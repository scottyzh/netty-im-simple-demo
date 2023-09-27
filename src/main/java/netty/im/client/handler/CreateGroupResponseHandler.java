package netty.im.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.im.protocal.response.CreateGroupResponsePacket;

/********************************
 *  @className  : CreateGroupResponseHandler
 *  @description: 创建群聊响应处理器
 *  @Date      : 16:02 2023/9/27
 *  @Author    : zh
 ********************************/
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket createGroupResponsePacket) {
        System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
    }

}
