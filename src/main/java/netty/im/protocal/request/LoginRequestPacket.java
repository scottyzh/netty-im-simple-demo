package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.LOGIN_REQUEST;

/********************************
 *  @Class     : LoginRequestPacket 
 *  @Function  : 登录请求协议包
 *  @Date      : 10:33 2023/9/26 
 *  @Author    : zh
 ********************************/
@Data
public class LoginRequestPacket extends Packet {

    private String userName;

    private String password;

    /********************************
     *  @function  : 获取指令
     *  @parameter : []
     *  @return    : java.lang.Byte
     *  @date      : 2023/9/26 10:34
     ********************************/
    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
