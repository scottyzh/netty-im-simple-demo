package netty.im.protocal.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import netty.im.protocal.Packet;
import static netty.im.protocal.command.Command.MESSAGE_REQUEST;

/********************************
 *  @className  : MessageRequestPacket
 *  @description: 消息请求协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
