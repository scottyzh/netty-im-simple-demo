package netty.im.util;

/********************************
 *  @Class     : IDUtil 
 *  @Function  : ID工具类
 *  @Date      : 14:30 2023/9/27 
 *  @Author    : zh
 ********************************/
public class IDUtil {
    public static String randomId() {
        return java.util.UUID.randomUUID().toString().split("-")[0];
    }
}
