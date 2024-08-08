import java.io.File;

public class LogOpenListener implements EventListener{
    private File log;

    public LogOpenListener(String fileName){
        this.log = new File(fileName);
    }
    @Override
    public void update(String eventType, File file) {
        System.out.println(STR."Salvar \{log} alguém fez a operação de \{eventType} com o seguinte arquivo: \{file.getName()}");
    }
}
