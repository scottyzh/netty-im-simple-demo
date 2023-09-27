package netty.im.serialize.impl;

import com.alibaba.fastjson.JSON;
import netty.im.serialize.Serializer;
import netty.im.serialize.SerializerAlgorithm;

/********************************
 *  @Class     : JSONSerializer
 *  @Function  : JSON序列化器
 *  @Date      : 10:29 2023/9/26
 *  @Author    : zh
 ********************************/
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
