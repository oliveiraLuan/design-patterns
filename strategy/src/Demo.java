import strategies.PayByCreditCard;
import strategies.PayByPayPal;
import strategies.PayStrategy;
import strategies.StragegyEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    private static String PAY = "P";
    private static String YES = "Y";

    static{
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 3500);
        priceOnProducts.put(3, 1500);
        priceOnProducts.put(4, 7200);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()){
            int cost;

            String continueChoice = "";

            do{
                System.out.println("Por favor escolha um dos produtos: \n 1- Mother board \n 2- CPU\n 3- HDD\n 4- Memory");
                int choice = Integer.parseInt(READER.readLine());
                cost = priceOnProducts.get(choice);
                System.out.println("Digite a quantidade do produto:");
                int quantity = Integer.parseInt(READER.readLine());
                int total = cost * quantity;
                order.setTotalCost(order.getTotalCost() + total);
                System.out.println("Você deseja continuar selecionando produtos? Y/N");
                continueChoice = READER.readLine();
            } while (continueChoice.equals(YES)); {
                if(strategy == null){
                    System.out.println("Por favor, selecione um método de pagamento: \n 1- Pay Pal\n 2- Credit card");
                    String paymentMethod = READER.readLine();

                    strategy = paymentMethod.equals(StragegyEnum.PAYPAL.getOption()) ? new PayByPayPal() : new PayByCreditCard();

                    order.processOrder(strategy);

                    System.out.println(STR."Pagar \{order.getTotalCost()} R$ ou continuar comprando? P/C: ");
                    String proceed = READER.readLine();

                    if(proceed.equals(PAY))
                        System.out.println(strategy.pay(order.getTotalCost()) ? "Pagamento realizado com sucesso" : "Falha, por favor cheque seus dados.");

                    order.setClosed();
                }
            }

        }
    }
}
