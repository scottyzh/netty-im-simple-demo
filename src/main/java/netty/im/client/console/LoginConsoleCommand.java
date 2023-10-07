package netty.im.client.console;

import io.netty.channel.Channel;
import netty.im.protocal.request.LoginRequestPacket;

import java.util.Scanner;

/********************************
 * @Class : LoginConsoleCommand
 * @Function : 登录命令
 * @Date     : 15:06 2023/9/27
 * @Author : zh
 ********************************/
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        System.out.print("输入用户名登录: ");
        loginRequestPacket.setUserName(scanner.nextLine());
        loginRequestPacket.setPassword("pwd");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);

        // 这里很重要 需要等待登录返回结果 不然会重复要求输入用户名
        waitForLoginResponse();
    }


    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }

}
