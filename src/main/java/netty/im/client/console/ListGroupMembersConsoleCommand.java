package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.ListGroupMembersRequestPacket;

import java.util.Scanner;

/********************************
 *  @Class     : ListGroupMembersConsoleCommand
 *  @Function  : 获取群成员列表命令
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();

        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
