package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.MessageRequestPacket;

import java.util.Scanner;

/********************************
 *  @Class     : SendToUserConsoleCommand
 *  @Function  : 发送消息给某个某个用户
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
