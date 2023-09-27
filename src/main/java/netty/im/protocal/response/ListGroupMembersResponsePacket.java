package netty.im.protocal.response;

import lombok.Data;
import netty.im.protocal.Packet;
import netty.im.protocal.session.Session;

import java.util.List;

import static netty.im.protocal.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/********************************
 *  @className  : ListGroupMembersResponsePacket
 *  @description: 群聊成员列表响应协议包
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
