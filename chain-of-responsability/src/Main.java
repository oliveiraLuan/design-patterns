import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Server server;

    private static void init(){
        server = new Server();
        server.register("admin@gmail.com", "@dm1n");
        server.register("luan@gmail.com", "123456");

        //Todas as verificações estao unidas. O client pode construir diversas chains usando os mesmos componentes
        Middleware middleware = Middleware.link(
            new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) {
        init();

        var sucess = false;

        do{
            System.out.println("Insira o e-mail");
            String email = scanner.next();
            System.out.println("Insira a senha");
            String password = scanner.next();
            sucess = server.login(email, password);
        } while (!sucess);
    }
}