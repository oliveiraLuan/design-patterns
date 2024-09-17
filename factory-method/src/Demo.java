import factory.Dialog;
import factory.HtmlDialog;
import factory.WindowsDialog;

public class Demo {
    private static Dialog dialog;
    private static final String WINDOWS = "Windows 10";

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }
    static void configure(){
        if(System.getProperty("os.name").equals(WINDOWS))
            dialog = new WindowsDialog();
        else
            dialog = new HtmlDialog();
    }
    static void runBusinessLogic(){
        dialog.renderWindow();
    }
}
