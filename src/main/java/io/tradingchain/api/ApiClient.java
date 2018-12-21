package io.tradingchain.api;

import io.tradingchain.api.key.*;
import io.tradingchain.api.login.LoginReq;
import io.tradingchain.api.login.LoginResp;
import io.tradingchain.api.password.*;
import io.tradingchain.api.queryOrder.QueryOrderReq;
import io.tradingchain.api.queryOrder.QueryOrderResp;
import io.tradingchain.api.register.BeforeRegisterReq;
import io.tradingchain.api.register.BeforeRegisterResp;
import io.tradingchain.api.register.RegisterReq;
import io.tradingchain.api.register.RegisterResp;
import io.tradingchain.api.user.IsUserExistsReq;
import io.tradingchain.api.user.IsUserExistsResp;
import io.tradingchain.util.AnnotationUtil;
import io.tradingchain.util.HttpUtil;

import java.lang.reflect.Field;

public class ApiClient {

  // 全局参数
  public static String BASE_URL;
  public static String API_KEY;
  public static String PLATFORM;
  public static String SECRET;

  private static final ApiClient apiClient = new ApiClient();

  public static final ApiClient build(String baseUrl, String apiKey, String platform, String secret) {
    BASE_URL = baseUrl;
    API_KEY = apiKey;
    PLATFORM = platform;
    SECRET = secret;
    return apiClient;
  }

  public static final ApiClient getInstance() throws Exception {
    if (null == BASE_URL || "".equals(BASE_URL)) throw new Exception(String.format("全局参数%s未设置", "baseUrl"));
    if (null == API_KEY || "".equals(API_KEY)) throw new Exception(String.format("全局参数%s未设置", "apiKey"));
    if (null == PLATFORM || "".equals(PLATFORM)) throw new Exception(String.format("全局参数%s未设置", "platform"));
    if (null == SECRET || "".equals(SECRET)) throw new Exception(String.format("全局参数%s未设置", "secret"));
    return apiClient;
  }

  private ApiClient() {
  }

  private static final void setField(String fieldName, Object value, Object o) {
    try {
      Class clazz = o.getClass();
      Field field = clazz.getDeclaredField(fieldName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);
      if (null == field.get(o)) field.set(o, value);
      if (!accessible) field.setAccessible(false);
    } catch (NoSuchFieldException e) {

    } catch (IllegalAccessException e) {

    }
  }

  // 设置请求对象的公共参数
  private static final Object setCommonParams(Object o) {
    setField("apiKey", API_KEY, o);
    setField("platform", PLATFORM, o);
    return o;
  }

  /**
   * 注册前获取备份私钥
   *
   * @param req
   * @return
   * @throws Exception
   */
  public BeforeRegisterResp beforeRegister(BeforeRegisterReq req) throws Exception {
    final String path = "/api/getKeyBeforeRegister";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(BeforeRegisterResp.class);
  }

  /**
   * 注册接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public RegisterResp register(RegisterReq req) throws Exception {
    final String path = "/api/registUser2";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(RegisterResp.class);
  }

  /**
   * 登录接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public LoginResp login(LoginReq req) throws Exception {
    final String path = "/api/login2";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(LoginResp.class);
  }

  /**
   * 订单状态查询接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public QueryOrderResp queryOrder(QueryOrderReq req) throws Exception {
    final String path = "/api/query/order";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(QueryOrderResp.class);
  }

  /**
   * 用户是否存在接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public IsUserExistsResp isUserExists(IsUserExistsReq req) throws Exception {
    final String path = "/api/userIsExist";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(IsUserExistsResp.class);
  }

  /**
   * 修改登录密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ModifyPasswordResp modifyLoginPassword(ModifyPasswordReq req) throws Exception {
    final String path = "/api/resetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("P")), SECRET));
    return response.castTo(ModifyPasswordResp.class);
  }

  /**
   * 修改交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ModifyPasswordResp modifyTradePassword(ModifyPasswordReq req) throws Exception {
    final String path = "/api/resetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("T")), SECRET));
    return response.castTo(ModifyPasswordResp.class);
  }

  /**
   * 重置登录密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetPasswordResp resetLoginPassword(ResetPasswordReq req) throws Exception {
    final String path = "/api/forgetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("P")), SECRET));
    return response.castTo(ResetPasswordResp.class);
  }

  /**
   * 重置交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetPasswordResp resetTradePassword(ResetPasswordReq req) throws Exception {
    final String path = "/api/forgetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("T")), SECRET));
    return response.castTo(ResetPasswordResp.class);
  }

  /**
   * 校验交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public CheckTradePasswordResp checkTradePassword(CheckTradePasswordReq req) throws Exception {
    final String path = "/api/isTradePassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(CheckTradePasswordResp.class);
  }

  /**
   * 重置备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetKeyResp resetKey(ResetKeyReq req) throws Exception {
    final String path = "/api/resetKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(ResetKeyResp.class);
  }

  /**
   * 获取老用户备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public GetLoginKeysResp getLoginKeys(GetLoginKeysReq req) throws Exception {
    final String path = "/api/loginKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(GetLoginKeysResp.class);
  }

  /**
   * 绑定备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public BindLoginKeysResp bindLoginKeys(BindLoginKeysReq req) throws Exception {
    final String path = "/api/bindLoginKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(BindLoginKeysResp.class);
  }
}