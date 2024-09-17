package buttons;

public class HtmlButton implements Button{

    @Override
    public void render() {
        System.out.println("<button>Teste do botão</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("[OnClick] Clicando no botão");
    }
}
