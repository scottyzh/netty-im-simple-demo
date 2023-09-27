package netty.im.protocal.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/********************************
 *  @className  : Session
 *  @description: 会话实体类
 *  @Date      : 10:33 2023/9/27
 *  @Author    : zh
 ********************************/
@Data
@NoArgsConstructor
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    @Override
    public String toString() {
        return userId + ":" + userName;
    }

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

}
