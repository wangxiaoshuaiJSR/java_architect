package org.architect.wxs.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public class Test {
    static Map<String,AbstractPaymentFactory> paymentFactoryMap = new HashMap<String, AbstractPaymentFactory>();
    public Test(){
        paymentFactoryMap.put("aliPay",new AliPaymentFactory());
        paymentFactoryMap.put("weiChatPay",new WeiChatPaymentFactory());
        paymentFactoryMap.put("unincomPay",new UninComPaymentFactory());
    }
    public static void main(String[] args) {
        Test test = new Test();
        paymentFactoryMap.get("aliPay").postProcessorPayment().payment();
    }
}
