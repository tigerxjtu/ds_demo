package cn.dataguru.dianshang.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093671";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvCCV/R1I30JOiM8oLUvQKLbzRdyXq1DdBINPun27VoLVKThilZ7N5DTBo92kX7eXRZhDfjXMxNebwPHbWwICOljyxncGVQyNTJRAKHwV647uBFKM2yIrjpFGIHvvRnzvgqWCzafrDboLdjcTYtJaLf+HC/nlpNHEUFYU0nsFezSZI0e03SeYI9xLg2/idIUVDEvLHoJRT7GQrdDsgsm3vEdHk5V959iamw8j2nS9PoyRH3gYaFevTRlTaIXRcU677lVa7vYDC9FZbFu7eMEBGh4x5MH8S2wub6V3yH60hFIY/4pd80m0WAEgUvd4PMZp3AgMBAAECggEAeqSJ1yJiRylV+Hj6opB97LWIh0vAWcTAK4h0GqyOwKus4m1zzv7cZ1WPApnMgwIpMtZS6Gev/onDcDDDyQlGggY4gDCXH8mpF4i9BQoyrHd+el2GxYxbk6M++VcBEAVx613gyO5fiRyWvq7woOfkLlsRKx/gHL1CE3eOrZ0WPgDkNVgK7gYK32S116SYTjauCyFi1KTbqUjzfFv7bm2gONyLWWbhysDQZlMgR4VxQ7QGCvcouvCpN4CIMFADZMseV+2xvyWtrVYoETkiWQKBgQDY4NsriWYODrOUKRylK+7yPzv9hxT06a/CDOFzZHdKqgK8TzvcUh+dOeunr+bhwMHmoJy17iqZWynThGJoFWhAeML48US/BctwEZZu6UyMgqq8NOUpVVs2OParIAo+3bSKNTOegM/kglmY59kivOUwKBgQCZ2wrBZZEEIiQ5lg6v7eh4AYjCe58W8pOAvw6jHCkwHbB+YT8+MUOZTjK460FSIELcltFvtSlTL/WZvE0ExtCoY1wlWRXjQj81hlyJ2sGabn7glHA1fSVdUS5QxUFnJ54uVTaOwcD3XSS2ytv4Csgi7wqLLxZXOLz+HUNW8UzWzQKBgGB1QYVPitBdwYj38AGWVKPxc+ECn1Va//MkSyj15XDy2pB0xu/3ipJr6LtAn6eQQAMU9HfjwzWlQ3WpQuK+XkMVk9vfU8hD3IygWFL69TNhbWnwDRbd332c9yQxH5OU6VHxKuA+4qRHMNSsg5a9UiDhYaK2cnq07amrbjBzPoB5AoGAKJSz44rskxCGSYIg4Zp4xJ5y+gktTxowebbrH26gFobeNJdl3PuVfuw3SLsUgZrsx84n87Tu73go6aHXFrlx89gxR9CVi1m/3lhQNDQ0+IzIfmfoqNMXdeOhucAtng2/FS14tHK6eQRiWKxtFKGTZFN0jn2fAOaAQu5pApem0skCgYA66IAli6rPBY8tDCzw+iBEB2oZ9VFuD1b5FQ2Id2SqGLtjROHJLKNHn+p1fwzpKFqtDLTrH4+FCTno6lXSC4jsAWVK3PYGZIA1d7KpqCweG63pjm+923aX+duBWye1osafYUFHMCSsoHT+8QS/7DOLN7GMMZPuClTwRhv11B2A+Q==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBr4fDlIWw3I7s7jpXp7eGi8Lh2fD+FqIF9rLEnViumBFbZNCj25eDd1Kpcpr5xZGVz2X/11TkQAzVOWTcds2p2M7zfSWKLq7S36HatcnJ5knJWF9XjoXxuoRFcSLHlLfwyePyzkN9uEZNPmSNJ5WE0bEPdxNnTl0e5IHrASbi3Q0nPdJPuHrq/iw3djHGy4vGpjUk6pXbmZ+LM/90QndkjmDMjfEYbDribTq9UOWl59SFRsg9TQZfX5yDeRzJduuf3LWVQdyC56Guvk/3AUWzXTweV0IWV/ba491t2VOqlMUqYaqE+q6goDzOCFIPQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://youfanteacher.natapp1.cc/pay/notifyzhifubao";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://youfanteacher.natapp1.cc/pay/returnzhifubao";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}