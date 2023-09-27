package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.LOGIN_RESPONSE;

/********************************
 *  @Class     : LoginResponsePacket 
 *  @Function  : 登录响应协议包
 *  @Date      : 10:46 2023/9/26 
 *  @Author    : zh
 ********************************/
@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGIN_RESPONSE;
    }
}
