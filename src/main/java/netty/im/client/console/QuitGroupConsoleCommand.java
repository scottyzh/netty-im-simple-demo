package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.QuitGroupRequestPacket;
import java.util.Scanner;

/********************************
 *  @Class     : QuitGroupConsoleCommand
 *  @Function  : 退出群聊命令
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class QuitGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();
        System.out.print("输入 groupId，退出群聊：");
        String groupId = scanner.next();

        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
