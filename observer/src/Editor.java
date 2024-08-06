import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor(){
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        events.notify("open", file);
    }
    public void saveFile() throws Exception{
        if(!isFileNull())
            events.notify("save", file);
        else
            throw new Exception("Por favor abra o arquivo primeiro.");
    }

    private boolean isFileNull(){
        return this.file == null;
    }
}
