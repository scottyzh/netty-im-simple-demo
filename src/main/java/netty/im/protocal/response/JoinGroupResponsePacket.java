package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;
import static netty.im.protocal.command.Command.JOIN_GROUP_RESPONSE;

/********************************
 *  @className  : JoinGroupResponsePacket
 *  @description: 加入群聊响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class JoinGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_RESPONSE;
    }
}
