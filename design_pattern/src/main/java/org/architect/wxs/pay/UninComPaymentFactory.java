package org.architect.wxs.pay;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public class UninComPaymentFactory extends AbstractPaymentFactory {
    public Payment postProcessorPayment() {
        super.beforePostProcessorPayment();
        return new UninComPayment();
    }
}
