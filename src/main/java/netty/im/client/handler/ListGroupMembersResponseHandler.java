package netty.im.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.im.protocal.response.ListGroupMembersResponsePacket;

/********************************
 *  @className  : ListGroupMembersResponseHandler
 *  @description: 群成员列表响应处理器
 *  @Date      : 16:02 2023/9/27
 *  @Author    : zh
 ********************************/
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket responsePacket) {
        System.out.println("群[" + responsePacket.getGroupId() + "]中的人包括：" + responsePacket.getSessionList());
    }
}
