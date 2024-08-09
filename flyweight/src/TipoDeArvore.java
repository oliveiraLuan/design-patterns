import java.awt.*;

public class TipoDeArvore {
    private String nome;
    private Color cor;
    private String dadosDaArvore;


    public TipoDeArvore(String nome, Color cor, String dadosDaArvore){
        this.nome = nome;
        this.cor = cor;
        this.dadosDaArvore = dadosDaArvore;
    }

    public void desenhar(Graphics graficos, int x, int y){
        graficos.setColor(Color.BLACK);
        graficos.fillRect(x - 1, y, 3, 5);
        graficos.setColor(cor);
        graficos.fillOval(x - 5, y - 10, 10, 10);
    }
}
