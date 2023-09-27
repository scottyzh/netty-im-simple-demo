package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;
import static netty.im.protocal.command.Command.QUIT_GROUP_RESPONSE;

/********************************
 *  @className  : QuitGroupResponsePacket
 *  @description: 退出群聊响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_RESPONSE;
    }
}
