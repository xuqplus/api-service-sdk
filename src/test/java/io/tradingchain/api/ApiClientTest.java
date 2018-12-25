package io.tradingchain.api;

import com.alibaba.fastjson.JSON;
import io.tradingchain.api.account.*;
import io.tradingchain.api.asset.*;
import io.tradingchain.api.key.*;
import io.tradingchain.api.kline.KLineReq;
import io.tradingchain.api.kline.KLineResp;
import io.tradingchain.api.login.LoginReq;
import io.tradingchain.api.login.LoginResp;
import io.tradingchain.api.offer.CommitOfferReq;
import io.tradingchain.api.offer.CommitOfferResp;
import io.tradingchain.api.order.QueryOrderReq;
import io.tradingchain.api.order.QueryOrderResp;
import io.tradingchain.api.password.*;
import io.tradingchain.api.register.BeforeRegisterReq;
import io.tradingchain.api.register.BeforeRegisterResp;
import io.tradingchain.api.register.RegisterReq;
import io.tradingchain.api.register.RegisterResp;
import io.tradingchain.api.trade.*;
import io.tradingchain.api.user.IsUserExistsReq;
import io.tradingchain.api.user.IsUserExistsResp;
import org.junit.Before;
import org.junit.Test;

public class ApiClientTest {

  // 测试服务器的参数
  public static final String BASE_URL = "http://api.1mfpay.com";
  public static final String API_KEY = "tradingchain";
  public static final String PLATFORM = "tradingchain_test";
  public static final String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";

  @Before
  public void before() {
    ApiClient.build(BASE_URL, API_KEY, PLATFORM, SECRET);
  }

  @Test
  public void beforeRegister() throws Exception {
    BeforeRegisterResp resp = ApiClient.getInstance()
            .beforeRegister(new BeforeRegisterReq());
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void register() throws Exception {
    RegisterResp resp = ApiClient.getInstance()
            .register(new RegisterReq("test", "test", "test", "xx", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void login() throws Exception {
    LoginResp resp = ApiClient.getInstance()
            .login(new LoginReq("test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void queryOrder() throws Exception {
    QueryOrderResp resp = ApiClient.getInstance()
            .queryOrder(QueryOrderReq.getInstanceByOutTradeNo("xxx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void isUserExists() throws Exception {
    IsUserExistsResp resp = ApiClient.getInstance()
            .isUserExists(new IsUserExistsReq("test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void modifyLoginPassword() throws Exception {
    ModifyPasswordResp resp = ApiClient.getInstance()
            .modifyLoginPassword(new ModifyPasswordReq("test", "test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void modifyTradePassword() throws Exception {
    ModifyPasswordResp resp = ApiClient.getInstance()
            .modifyTradePassword(new ModifyPasswordReq("test", "test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void resetLoginPassword() throws Exception {
    ResetPasswordResp resp = ApiClient.getInstance()
            .resetLoginPassword(new ResetPasswordReq("test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void resetTradePassword() throws Exception {
    ResetPasswordResp resp = ApiClient.getInstance()
            .resetTradePassword(new ResetPasswordReq("test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void checkTradePassword() throws Exception {
    CheckTradePasswordResp resp = ApiClient.getInstance()
            .checkTradePassword(new CheckTradePasswordReq("test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void resetKey() throws Exception {
    ResetKeyResp resp = ApiClient.getInstance()
            .resetKey(new ResetKeyReq("test", "test", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getLoginKeys() throws Exception {
    GetLoginKeysResp resp = ApiClient.getInstance()
            .getLoginKeys(new GetLoginKeysReq("test", "test"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void bindLoginKeys() throws Exception {
    BindLoginKeysResp resp = ApiClient.getInstance()
            .bindLoginKeys(new BindLoginKeysReq("test", "test", "xx", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void assetTrust() throws Exception {
    AssetTrustResp resp = ApiClient.getInstance()
            .assetTrust(new AssetTrustReq("test", "test", "xx", "xx", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void assetsTrust() throws Exception {
    AssetsTrustResp resp = ApiClient.getInstance().assetsTrust(
            new AssetsTrustReq("test", "xx")
                    .addAsset(new AssetPair("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"))
                    .addAsset(new AssetPair("BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"))
    );
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getIntervalList() throws Exception {
    GetIntervalListResp resp = ApiClient.getInstance()
            .getIntervalList(new GetIntervalListReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getHistoryTrades() throws Exception {
    GetHistoryTradesResp resp = ApiClient.getInstance()
            .getHistoryTrades(new GetHistoryTradesReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));

    System.err.println(resp.data.get(0).createdAt);
    System.err.println(resp.data.get(0).setOffer_id(""));
  }

  @Test
  public void tradeDepth() throws Exception {
    TradeDepthResp resp = ApiClient.getInstance()
            .tradeDepth(new TradeDepthReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void latestTrades() throws Exception {
    LatestTradesResp resp = ApiClient.getInstance()
            .latestTrades(new LatestTradesReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void kLine() throws Exception {
    KLineResp resp = ApiClient.getInstance()
            .kLine(new KLineReq("XRP", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", KLineReq.RangeTime.OneHour, 1535338800000L, 1535338800000L));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void accountDetails() throws Exception {
    AccountDetailsResp resp = ApiClient.getInstance()
            .accountDetails(new AccountDetailsReq("test", "test", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));

    System.err.println(JSON.toJSONString(ApiClient.getInstance().accountDetails(new AccountDetailsReq("test", "test"))));
  }

  @Test
  public void isKeyBelongTo() throws Exception {
    IsKeyBelongToResp resp = ApiClient.getInstance()
            .isKeyBelongTo(new IsKeyBelongToReq("test", "test", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void accountValuations() throws Exception {
    AccountValuationsResp resp = ApiClient.getInstance()
            .accountValuations(new AccountValuationsReq("test", "test", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));

    System.err.println(JSON.toJSONString(ApiClient.getInstance().accountValuations(
            new AccountValuationsReq("test", "test", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG")
                    .addAsset(new AssetPair("XRP", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"))
                    .addAsset(new AssetPair("BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"))
    )));
  }

  @Test
  public void assetAmount() throws Exception {
    AssetAmountResp resp = ApiClient.getInstance()
            .assetAmount(new AssetAmountReq("test", "test", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void userTradesHistory() throws Exception {
    UserTradesHistoryResp resp = ApiClient.getInstance()
            .userTradesHistory(new UserTradesHistoryReq("15921863921", "12345678", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void userTransferHistory() throws Exception {
    UserTransferHistoryResp resp = ApiClient.getInstance()
            .userTransferHistory(new UserTransferHistoryReq("15921863921", "12345678", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void userOffers() throws Exception {
    UserOffersResp resp = ApiClient.getInstance()
            .userOffers(new UserOffersReq("15921863921", "12345678"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void commitOffer() throws Exception {
    CommitOfferResp resp = ApiClient.getInstance()
            .commitOffer(CommitOfferReq.getInstanceByBackupKey("test", "test", "0.001", "0.001", "xx", "xx", "xx", "xx", "buy", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }
}