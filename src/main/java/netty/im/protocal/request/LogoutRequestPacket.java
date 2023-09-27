package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.LOGOUT_REQUEST;

/********************************
 *  @className  : LogoutRequestPacket
 *  @description: 登出请求协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
