package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.QUIT_GROUP_REQUEST;

/********************************
 *  @className  : QuitGroupRequestPacket
 *  @description: 退出群聊请求协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
