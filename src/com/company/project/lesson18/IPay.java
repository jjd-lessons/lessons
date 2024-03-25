package com.company.project.lesson18;

@FunctionalInterface
public interface IPay {
    boolean makePayment(double amount);

    default IPay additionalPay(IPay next){
        return amount -> {
            if (!makePayment(amount)) return next.makePayment(amount);
            return true;
        };
    }
}
// IPay pay01 = (amount) -> ...;
// IPay pay02 = (amount) -> ...;
// if (!pay01.makePayment(100)) pay02.makePayment(100);