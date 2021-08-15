package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * system_user
 * @author 
 */
@Data
public class SystemUser implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 全名
     */
    private String fullName;

    /**
     * 电话号码
     */
    private String mobile;

    /**
     * 是否删除的标志
     */
    private Boolean disabled;

    private static final long serialVersionUID = 1L;
}