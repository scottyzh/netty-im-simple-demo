package netty.im.protocal.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.GROUP_MESSAGE_REQUEST;

/********************************
 *  @Class     : GroupMessageRequestPacket
 *  @Function  : 群聊消息请求协议包
 *  @Date      : 10:33 2023/9/26
 *  @Author    : zh
 ********************************/
@Data
@NoArgsConstructor // 需要无参构造 不然序列化会失败
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
