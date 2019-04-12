package com.office.mall.entiy;

import lombok.Getter;
import lombok.Setter; 
import com.office.mall.entiy.BaseModel;

/**
 * The UmsUser
 *
 * @author ecmybatis
 */
@Getter
@Setter
public class UmsUser extends BaseModel {

  private String username; //用户名
  private String password; //密码
  private String nickname; //昵称
  private String phone; //手机号码
  private Integer status; //帐号启用状态:0->禁用；1->启用
  private String createTime; //注册时间
  private String icon; //头像
  private Integer gender; //性别：0->未知；1->男；2->女
  private String city; //所在城市
  private Integer integration; //积分
  private Integer growth; //成长值
  private Integer luckeyCount; //剩余抽奖次数
  private Integer historyIntegration; //历史积分数量

}
