package netty.im.protocal.response;


import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.HEARTBEAT_RESPONSE;


/********************************
 *  @Class     : HeartBeatResponsePacket
 *  @Function  : 心跳响应协议包
 *  @Date      : 16:12 2023/10/07
 *  @Author    : zh
 ********************************/
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
