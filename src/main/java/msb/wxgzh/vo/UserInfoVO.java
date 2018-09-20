//package msb.wxgzh.vo;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//public class UserInfoVO {
//    private Long id;
//
//    private String userName;
//
//    private BigDecimal balance;
//
//    private String userSignature;
//
//    private Date updateTime;
//
//    private String userTelephone;
//
//    private String userNickname;
//
//    private String userPhoto;
//
//    private String userPhotoUrl;
//
//    private Long userAppid;
//
//    private Long userId;
//
//    private String code;
//
//    //网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
//    private String access_token;
//    //access_token接口调用凭证超时时间，单位（秒）
//    private String expires_in;
//    //用户刷新access_token
//    private String refresh_token;
//    //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
//    private String openid;
//    //用户授权的作用域，使用逗号（,）分隔
//    private String scope;
//
//    public String getAccess_token() {
//        return access_token;
//    }
//
//    public void setAccess_token(String access_token) {
//        this.access_token = access_token;
//    }
//
//    public String getExpires_in() {
//        return expires_in;
//    }
//
//    public void setExpires_in(String expires_in) {
//        this.expires_in = expires_in;
//    }
//
//    public String getRefresh_token() {
//        return refresh_token;
//    }
//
//    public void setRefresh_token(String refresh_token) {
//        this.refresh_token = refresh_token;
//    }
//
//    public String getOpenid() {
//        return openid;
//    }
//
//    public void setOpenid(String openid) {
//        this.openid = openid;
//    }
//
//    public String getScope() {
//        return scope;
//    }
//
//    public void setScope(String scope) {
//        this.scope = scope;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName == null ? null : userName.trim();
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public String getUserSignature() {
//        return userSignature;
//    }
//
//    public void setUserSignature(String userSignature) {
//        this.userSignature = userSignature == null ? null : userSignature.trim();
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public String getUserTelephone() {
//        return userTelephone;
//    }
//
//    public void setUserTelephone(String userTelephone) {
//        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
//    }
//
//    public String getUserNickname() {
//        return userNickname;
//    }
//
//    public void setUserNickname(String userNickname) {
//        this.userNickname = userNickname == null ? null : userNickname.trim();
//    }
//
//    public String getUserPhoto() {
//        return userPhoto;
//    }
//
//    public void setUserPhoto(String userPhoto) {
//        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
//    }
//
//    public String getUserPhotoUrl() {
//        return userPhotoUrl;
//    }
//
//    public void setUserPhotoUrl(String userPhotoUrl) {
//        this.userPhotoUrl = userPhotoUrl == null ? null : userPhotoUrl.trim();
//    }
//
//    public Long getUserAppid() {
//        return userAppid;
//    }
//
//    public void setUserAppid(Long userAppid) {
//        this.userAppid = userAppid;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//}