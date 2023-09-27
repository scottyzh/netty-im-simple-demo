package netty.im.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.im.protocal.response.GroupMessageResponsePacket;
import netty.im.protocal.session.Session;


/********************************
 *  @className  : GroupMessageResponseHandler
 *  @description: 群聊消息响应处理器
 *  @Date      : 16:02 2023/9/27
 *  @Author    : zh
 ********************************/
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket responsePacket) {
        String fromGroupId = responsePacket.getFromGroupId();
        Session fromUser = responsePacket.getFromUser();
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + responsePacket.getMessage());
    }
}
