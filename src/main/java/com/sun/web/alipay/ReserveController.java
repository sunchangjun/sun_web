package com.sun.web.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.*;


@Controller
public class ReserveController {

    /**
     * 支付网站扫码支付接口
     * @param out_trade_no
     * @param total_amount
     * @param subject
     * @return
     * ,method = RequestMethod.POST
     */
    @RequestMapping(value = "/pay")
    @ResponseBody
    public String alipayPay(String out_trade_no, Double total_amount, String subject) throws AlipayApiException{

        System.out.println("进入pay接口");
        System.out.println(total_amount+"金额");
        System.out.println(out_trade_no+"订单号");
        System.out.println(subject+"内容");

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //付款金额，必填
        //订单名称，必填

        AlipayVo vo=new AlipayVo();
        vo.setOut_trade_no(out_trade_no);
        vo.setSubject(subject);
        DecimalFormat df=new DecimalFormat("#.00");//定义浮点数格式
        String moneytoo=df.format(total_amount);//转换成string类型
        vo.setTotal_amount(Double.parseDouble(moneytoo));
        vo.setProduct_code("FAST_INSTANT_TRADE_PAY");//销售产品码

        String json =JSON.toJSONString(vo);

        AlipayClient alipayClient = new DefaultAlipayClient(AppPayConfig.gatewayUrl,AppPayConfig.app_id,AppPayConfig.merchant_private_key, "json",AppPayConfig.charset,AppPayConfig.alipay_public_key,AppPayConfig.sign_type);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AppPayConfig.return_url);
        alipayRequest.setNotifyUrl(AppPayConfig.notify_url);
        alipayRequest.setBizContent(json);

        //执行请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result; //这里生成一个表单，会自动提交
    }

    /**
     * 支付宝服务器异步通知
     * @param request
     * @param out_trade_no
     * @param trade_no
     * @param trade_status
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping(value = "/notify_url",method = RequestMethod.POST)
    @ResponseBody
    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException {
        System.out.println("进入 notify_url");
        System.out.println(out_trade_no+" out_trade_no");
        System.out.println(trade_no+" trade_no");
        System.out.println(trade_status+" trade_status");
        Map<String, String> params = getParamsMap(request);
        // 验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AppPayConfig.alipay_public_key, AppPayConfig.charset, AppPayConfig.sign_type);
        System.out.println("notify_url验证签名结果: "+signVerified);
        if (signVerified) {
            //处理你的业务逻辑，更新订单状态等
            System.out.println("notify_url:处理你的业务逻辑，更新订单状态等");

            return ("success");
        } else {
            System.out.println("notify_url fail");
            return ("fail");
        }
    }

    /**
     * 支付宝服务器同步通知
     * @param request
     * @param out_trade_no
     * @param trade_no 支付宝交易凭证号
     * @param total_amount 交易状态
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping(value = "/return_url",method = RequestMethod.GET)
    @ResponseBody
    public String alipayReturn(HttpServletRequest request, String out_trade_no, String trade_no, String total_amount) throws AlipayApiException {
        System.out.println("进入 return_url");
        System.out.println(out_trade_no+" out_trade_no");
        System.out.println(trade_no+" trade_no");
        System.out.println(total_amount+" total_amount");



        Map<String, String> params = getParamsMap(request);
        // 验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AppPayConfig.alipay_public_key, AppPayConfig.charset, AppPayConfig.sign_type);
        System.out.println("return_url验证签名结果: "+signVerified);
        if (signVerified) {
            //处理业务逻辑，更新订单状态等
            System.out.println("return_url:处理你的业务逻辑，更新订单状态等");

            return "success";
        } else {
            return ("fail");
        }
    }

    private Map<String, String> getParamsMap(HttpServletRequest request) {
        Map<String,String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return params;
    }



}
