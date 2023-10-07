package netty.im.protocal;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/********************************
 *  @Class     : Packet 
 *  @Function  : 协议包
 *  @Date      : 10:29 2023/9/26 
 *  @Author    : zh
 ********************************/
@Data
public abstract class Packet {

    /*
    在Netty中，取消序列化（serialize = false）的作用通常是为了控制协议包中哪些字段需要被序列化（转换为字节流以便在网络上传输），哪些字段不需要被序列化。下面两个值实际都不需要北序列化
     */
    @JSONField(deserialize = false, serialize = false)
    // 协议版本
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();

}
