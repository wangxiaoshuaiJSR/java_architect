package org.architect.wxs.pay;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public abstract class AbstractPaymentFactory {
    public void beforePostProcessorPayment(){
        System.out.println("支付前操作，包括安全检查等");
    }

    public abstract Payment postProcessorPayment();

}
