package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.GroupMessageRequestPacket;

import java.util.Scanner;

/********************************
 *  @Class     : SendToGroupConsoleCommand
 *  @Function  : 发送消息给某个某个群组
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");
        String toGroupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));

    }
}
