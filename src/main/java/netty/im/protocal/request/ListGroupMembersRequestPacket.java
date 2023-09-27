package netty.im.protocal.request;

import lombok.Data;
import netty.im.protocal.Packet;
import static netty.im.protocal.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/********************************
 *  @className  : ListGroupMembersRequestPacket
 *  @description: 获取群成员列表请求协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
