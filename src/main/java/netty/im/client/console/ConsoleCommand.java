package netty.im.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/********************************
 *  @Class     : ConsoleCommand
 *  @Function  : 控制台命令接口
 *  @Date      : 15:06 2023/9/27
 *  @Author    : zh
 ********************************/
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
