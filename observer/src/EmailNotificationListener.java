import java.io.File;

import static java.lang.StringTemplate.STR;


public class EmailNotificationListener implements EventListener{
    private String email;

    public EmailNotificationListener(String email){
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println(STR."Email para \{email}: Alguém fez a operação de \{ eventType } com o seguinte arquivo: \{ file.getName() }");
    }
}
