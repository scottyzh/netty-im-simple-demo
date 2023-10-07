package netty.im.protocal.request;


import netty.im.protocal.Packet;

import static netty.im.protocal.command.Command.HEARTBEAT_REQUEST;


public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
