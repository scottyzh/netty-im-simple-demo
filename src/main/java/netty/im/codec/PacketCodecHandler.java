package netty.im.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import netty.im.protocal.Packet;
import netty.im.protocal.PacketCodec;

import java.util.List;

/********************************
 *  @Class     : PacketCodecHandler 
 *  @Function  : 数据包编解码
 *  @Date      : 15:06 2023/9/27 
 *  @Author    : zh
 ********************************/
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) {
        ByteBuf byteBuf = channelHandlerContext.channel().alloc().ioBuffer();
        PacketCodec.INSTANCE.encode(byteBuf, packet);
        out.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out){
        out.add(PacketCodec.INSTANCE.decode(byteBuf));
    }
}
