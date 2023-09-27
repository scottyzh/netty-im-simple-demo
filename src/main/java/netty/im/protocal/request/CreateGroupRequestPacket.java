package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;

import java.util.List;

import static netty.im.protocal.command.Command.CREATE_GROUP_REQUEST;

/********************************
 *  @Class     : CreateGroupRequestPacket
 *  @Function  : 创建群聊请求协议包
 *  @Date      : 10:33 2023/9/26
 *  @Author    : zh
 ********************************/
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
