package designPatterns.strategyDesignPattern;

// 1. Strategy interface(menu)
interface  PaymentStrategy{
    void pay(int amount);
}

// 2. Concrete strategy 1: Credit Card
class CreditCardPayment implements  PaymentStrategy{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

// 3. Concrete Strategy 2: PayPal

class PayPalPayment implements  PaymentStrategy{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Context (Waitor) who uses the Strategy to make payment
class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    // execute the payment(serve the food)
    public void executePayment(int amount){
        paymentStrategy.pay(amount);
    }
}
// Main(ordering your meal and paying)
public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        //Choose credit card as your payment method
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(50);

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(30);

    }

}
