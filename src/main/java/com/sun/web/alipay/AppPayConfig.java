package com.sun.web.alipay;


import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

**/


public class AppPayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id =  "2016101000656155";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCVVenhYLgZg8L/3e7DeJmrRNxj0ucBhHdXoP/NDwgWjL1DmqYL0PvPXI2v5dL+5EFZ1TbHS4rktVaif8Xw64KUWJ2YDwf3UXlmbA1JQ3mRs/2cIqTGFQ9w6S238wWHmd9MrZGuZQWyV9WPhPpsLcM7RlyDkFkwM21uBHTxO261cmUVpm/k7Upac2PhGvqlKzHWwwAomFbdS8gNPpSIn5QD4xQ/iPSbrfmwwALO65S+CGUrNhDJPrGc9xXgdyrTmjBRLwGTgDyLJ4wtR7Qmhcf2+ISu7RuU17GY7r+kpu2dqMzpic9kqQrYxpMDnlWqH5B3pSjvIaKniXx5m1crajfRAgMBAAECggEABSbqo7jngRHXp2Yrt5iwjIUaqWL8T0QXrfFDAfsTx1thqDRsqBm0pknGJZxjNCIB0yyU8Dk9+Hf9HiwUUyR848tO3JEgMDsiWhM+PhnS1uEDzeAwGRle6AFTb3Y16aC4YHfYf9DCao23M3VeAl9tzdy2kl9nhE8x5krHEg9/2UikQCtc/Z7/LWdwejYKTt6yU70iqVWnV9BQz6WyOik3qs8FANkJqAW1oJFW12x+kblXF+hxahC/TXJKCoAI0XD0IDaPKyqtmSzViEx7QYWymRUS+FwaY+PSLnEVbXDMVWr9QqQ+/jO7nzD56dgCnrJbXRXrZacx7oIuxIZoxpP5xQKBgQDyct07I3NRUDbzTCEfRXWU9Y1cIyArrXp+fR+gnXQzOQxaIfoFIugF8YWuZCuO8HUpW988MM8xA3vv+KLTnTWn/oBSwo6xhtoDW8Oqne9jVePtlUQ0gKVPcOqV0pwsGebwVzWPgm4TlvBfjAU0d6ip8onNpeoFYVErXCwOM6tmUwKBgQCdrrfdWTLHEA3OCBECVUrR7r57xgc1GPwg6294LkLVwAE1F42FCMDIk8DoM5Jk4vwZlo2YMHo3jEewZxW/jSX38XVZIu9rGqwcG60TKD0opTGR18FGMCOn/GUZHf1rx4rCAXU9OpOG8oMVJLoGgmdEyR9gxOd/pKLUX/2S55UcywKBgQDMelXdr7ttg/KkZbu1rRZLCIItiC50x/38uji3dLRxExc42VkNhfAcOyPc/fzCtEiMFkEDecL0+pRHwvJI+Vksk3fU1OQWE77BgF5ZApTIucLfOLnqcel6Q6iFrbgrdbkRUOwKWh3Ohcm7O9OT+auVkcnpWJoz6WzU3gsF+0v+owKBgQCN/2tgkBUkIpbr9WOr4DdSulcbi4euD2PuGVb2uWJCr3fm4eD17p39guFzug2ZgLdaK7QzW2SUZWWhvBNfvrJ0iCMPNGC66PgZD+talyAMXEc5eTx6Apv5iVdZuSIgTz/r2fhEPV3hZr8Y6UwE1KY+0YfKU0fOMOrZqd/mzVoA5QKBgGudDm2tMi4tM8nDI5ymuPRkN7eKIkNVDQb/KlMbPcBuVIs8gcAV602VfJXp81Kb94gyCHBkmdSHUrLtkaDV173One/kDeiWDOLuBUttgsPdobwSQy6YoOHNWWmzauGfY0O7T52nH61R3Z/Bmp9ZEdE4WwtDdw7izux0vDUWP04R";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

//    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://201176f4g5.iok.la:8608/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
//
//    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://201176f4g5.iok.la:8608/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";


    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://201176f4g5.iok.la:35519/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://201176f4g5.iok.la:35519/return_url";

    // 签名方式
    public static String sign_type = "RSA";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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
