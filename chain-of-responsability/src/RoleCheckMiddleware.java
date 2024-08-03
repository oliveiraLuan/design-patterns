/*
*   Classe concreta - Verifica a role de um usuário
* */
public class RoleCheckMiddleware extends Middleware{

    private final String ADMIN_EMAIL = "admin@gmail.com";

    @Override
    public boolean check(String email, String password) {
        if(email.equals(ADMIN_EMAIL)){
            System.out.println("Olá Admin");
            return true;
        }
        System.out.printf("Olá %s%n",email);
        return checkNext(email, password);
    }
}
