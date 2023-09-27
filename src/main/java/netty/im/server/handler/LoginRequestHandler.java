package netty.im.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.im.protocal.request.LoginRequestPacket;

/********************************
 *  @Class     : LoginRequestHandler 
 *  @Function  : 登录请求处理
 *  @Date      : 10:25 2023/9/26 
 *  @Author    : zh
 ********************************/
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestPacket) throws Exception {

    }
}
