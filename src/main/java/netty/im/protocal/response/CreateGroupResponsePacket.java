package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;

import java.util.List;

import static netty.im.protocal.command.Command.CREATE_GROUP_RESPONSE;

/********************************
 *  @className  : CreateGroupResponsePacket
 *  @description: 创建群聊响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_RESPONSE;
    }
}
