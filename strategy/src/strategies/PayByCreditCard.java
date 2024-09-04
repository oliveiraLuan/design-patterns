package strategies;

import model.CreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy{
    private static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public boolean pay(int paymentAmount) {
        if(isCardPresent()){
            System.out.println(STR."Pagando o valor \{paymentAmount} com cartão de crédito");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try{
            System.out.println("Insira o número do cartão de crédito:");
            String cardNumber = READER.readLine();
            System.out.println("Insira a data de vencimento mm/yy: ");
            String date = READER.readLine();
            System.out.println("Insira o CVV: ");
            String cvv = READER.readLine();
            card = new CreditCard(cardNumber, date, cvv);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private Boolean isCardPresent(){
        return card != null;
    }
}
