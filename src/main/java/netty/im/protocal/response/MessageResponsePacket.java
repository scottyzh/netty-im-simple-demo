package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;
import static netty.im.protocal.command.Command.MESSAGE_RESPONSE;

/********************************
 *  @className  : MessageResponsePacket
 *  @description: 消息响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
