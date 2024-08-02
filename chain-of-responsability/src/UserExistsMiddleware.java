
/*
    Classe concreta - Verifica se o usuário com as credenciais fornecidas existe e se a senha é valida
* */
public class UserExistsMiddleware extends Middleware{
    private Server server;

    public UserExistsMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if(!server.hasEmail(email)){
            System.out.println("O servidor não possui esse e-mail.");
            return false;
        }
        if(!server.isValidPassword(email, password)){
            System.out.println("Credenciais inválidas");
            return false;
        }
        return checkNext(email, password);
    }
}
