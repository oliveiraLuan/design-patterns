import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware){
        this.middleware = middleware;
    }
    /*
        Servidor recebe as credenciais e envia a requisição de autorização para chain
    * */
    public Boolean login(String email, String password){
        if(middleware.check(email, password)){
            System.out.println("Autorização bem sucedida");
            return true;
        }
        return false;
    }

    public void register(String email, String password){
        users.put(email, password);
    }

    public Boolean hasEmail(String email){
        return users.containsKey(email);
    }

    public Boolean isValidPassword(String email, String password){
        return users.get(email).equals(password);
    }
}
