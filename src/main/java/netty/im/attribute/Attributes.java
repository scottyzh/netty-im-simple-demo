package netty.im.attribute;

import io.netty.util.AttributeKey;
import netty.im.protocal.session.Session;

/********************************
 *  @Class     : Attributes
 *  @Function  : 属性
 *  @Date      : 10:33 2023/9/26
 *  @Author    : zh
 ********************************/
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
