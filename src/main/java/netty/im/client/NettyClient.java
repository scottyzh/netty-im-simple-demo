package netty.im.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.im.client.console.ConsoleCommandManager;
import netty.im.client.console.LoginConsoleCommand;
import netty.im.client.handler.LoginResponseHandler;
import netty.im.client.handler.LogoutResponseHandler;
import netty.im.client.handler.MessageResponseHandler;
import netty.im.codec.PacketCodecHandler;
import netty.im.codec.Spliter;
import netty.im.util.SessionUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/********************************
 *  @Class     : NettyClient 
 *  @Function  : Netty客户端
 *  @Date      : 16:12 2023/9/27 
 *  @Author    : zh
 ********************************/
public class NettyClient {

    private static final int MAX_RETRY = 5;

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 8000;

    public static void main(String[] args) {
        // 创建工作线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        // 创建启动类
        Bootstrap bootstrap = new Bootstrap();
        // 配置启动类
        bootstrap
                // 配置工作线程组
                .group(workerGroup)
                // 配置客户端通道实现类
                .channel(NioSocketChannel.class)
                // 配置客户端连接超时时间
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                // 配置是否开启TCP底层心跳机制
                .option(ChannelOption.SO_KEEPALIVE, true)
                // 配置是否开启Nagle算法
                .option(ChannelOption.TCP_NODELAY, true)
                // 配置客户端处理器
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        // 添加拆包器
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);

                        // 添加登录响应处理器
                        ch.pipeline().addLast(new LoginResponseHandler());
                        // 添加消息响应处理器
                        ch.pipeline().addLast(new MessageResponseHandler());
                        // 添加登出响应处理器
                        ch.pipeline().addLast(new LogoutResponseHandler());


                    }
                });
        // 连接服务器
        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        // 连接服务器
        bootstrap.connect(host, port).addListener(future -> {
            // 连接成功
            if (future.isSuccess()) {
                System.out.println("连接成功!");
                // 获取通道
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                // 连接失败
                System.err.println("重试次数已用完，放弃连接!");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                // 重连
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit
                        .SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            while (!Thread.interrupted()) {
                // 判断是否已经登录
                if (!SessionUtil.hasLogin(channel)) {
                    // 未登录
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    // 已登录
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }
}
