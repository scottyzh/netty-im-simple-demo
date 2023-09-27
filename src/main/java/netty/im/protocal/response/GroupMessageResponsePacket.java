package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;
import netty.im.protocal.session.Session;

import static netty.im.protocal.command.Command.GROUP_MESSAGE_RESPONSE;

/********************************
 *  @className  : GroupMessageResponsePacket
 *  @description: 群聊消息响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
