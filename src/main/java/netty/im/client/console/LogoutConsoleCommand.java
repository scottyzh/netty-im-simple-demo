package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.LogoutRequestPacket;

import java.util.Scanner;

/********************************
 *  @Class     : LogoutConsoleCommand
 *  @Function  : 登出命令
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
