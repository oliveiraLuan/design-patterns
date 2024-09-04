package strategies;

import model.CreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StringTemplate.STR;

public class PayByPayPal implements PayStrategy {
    private static Map<String, String> db = new HashMap<>();
    private Boolean signedIn;
    private final BufferedReader  READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;
    private String email;
    private String password;

    static {
        db.put("dexter@gmail.com", "4#20AfG+");
        db.put("vincemasuka@gmail.com", "valencia");
    }


    @Override
    public boolean pay(int paymentAmount) {
        if(signedIn){
            System.out.println(STR."Pagando: \{paymentAmount} usando Paypal");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try{
            while (!signedIn){
                System.out.println("Insira o e-mail:");
                email = READER.readLine();
                System.out.println("Insira a senha:");
                password = READER.readLine();
                System.out.println(verifyCredentials() ? "Verificação bem sucedida" : "E-mail ou senha inválidos");
            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    private boolean verifyCredentials(){
        setSignedIn(email.equals(db.get(password)));
        return signedIn;
    }

    public void setSignedIn(Boolean signedIn) {
        this.signedIn = signedIn;
    }
}
