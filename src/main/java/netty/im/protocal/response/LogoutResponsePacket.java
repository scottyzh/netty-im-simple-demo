package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.LOGOUT_RESPONSE;

/********************************
 *  @className  : LogoutResponsePacket
 *  @description: 登出响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
