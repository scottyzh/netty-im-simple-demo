package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.JOIN_GROUP_REQUEST;

/********************************
 *  @Class     : JoinGroupRequestPacket
 *  @Function  : 加入群聊请求协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
