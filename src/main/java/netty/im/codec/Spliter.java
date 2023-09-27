package netty.im.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import netty.im.protocal.PacketCodec;

/********************************
 *  @Class     : Spliter 
 *  @Function  : 数据包拆包
 *  @Date      : 14:42 2023/9/27 
 *  @Author    : zh
 ********************************/
public class Spliter extends LengthFieldBasedFrameDecoder {

    // 数据包的偏移量
    private static final int LENGTH_FIELD_OFFSET = 7;

    // 数据长度字节大小-》通过这个获得数据包的完整大小
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter(){
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(io.netty.channel.ChannelHandlerContext ctx, io.netty.buffer.ByteBuf in) throws Exception {
        // 如果不是魔数，直接关闭连接 获取第一个Int字节
        if(in.getInt(in.readerIndex()) != PacketCodec.MAGIC_NUMBER){
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }



}
