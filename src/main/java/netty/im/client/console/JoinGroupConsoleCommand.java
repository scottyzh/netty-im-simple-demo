package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.JoinGroupRequestPacket;

import java.util.Scanner;

/********************************
 *  @Class     : JoinGroupConsoleCommand
 *  @Function  : 加入群聊命令
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
