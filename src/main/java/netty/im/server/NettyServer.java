package netty.im.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import static jdk.nashorn.internal.objects.NativeFunction.bind;

/********************************
 *  @Class     : NettyServer 
 *  @Function  : 服务端启动
 *  @Date      : 9:46 2023/9/26 
 *  @Author    : zh
 ********************************/
public class NettyServer {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        // boss是接受新连接线程 主要负责创建新连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // worker是负责读取数据的线程 主要用于读取数据以及业务逻辑处理
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 1.指定线程模型
        serverBootstrap
                .group(bossGroup, workerGroup)
                // 指定IO模型
                .channel(NioServerSocketChannel.class)
                /*
                 SO_BACKLOG对应的是tcp/ip协议listen函数中的backlog参数，
                 函数listen(int socketfd,int backlog)用来初始化服务端可连接队列，
                 服务端处理客户端连接请求是顺序处理的，所以同一时间只能处理一个客户端连接，
                 多个客户端来的时候，服务端将不能处理的客户端连接请求放在队列中等待处理，backlog参数指定了队列的大小
                 */
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // TCP_NODELAY就是用于启用或关于Nagle算法。如果要求高实时性,有数据发送时就马上发送,就将该选项设置为true关闭Nagle算法;如果要减少发送次数减少网络交互,就设置为false等累积一定大小后再发送
                .childOption(ChannelOption.TCP_NODELAY, true);
        // 4.绑定端口
        bind(serverBootstrap, PORT);
    }

    /********************************
     *  @function  : 端口绑定
     *  @parameter : [serverBootstrap, port]
     *  @return    : void
     *  @date      : 2023/9/26 10:23
     ********************************/
    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}
