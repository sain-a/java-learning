package week2_day03_abstract;

abstract class Payment {
    public abstract void pay(double amount);
}
class WechatPay extends Payment{
    @Override
    public void pay(double amount){
        System.out.println("微信支付"+amount);
    }
}
class AliPay extends Payment{
    @Override
    public void pay(double amount){
        System.out.println("支付宝支付"+amount);
    }
}
public class PaymentSystem {
    public static void main(String[] args){
        Payment p1 = new WechatPay();
        Payment p2 = new AliPay();
        p1.pay(100);
        p2.pay(200);
    }
}
