import java.awt.*;

public class Arvore {
    private int x;
    private int y;
    private TipoDeArvore tipoDeArvore;

    public Arvore(int x, int y, TipoDeArvore tipoDeArvore){
        this.x = x;
        this.y = y;
        this.tipoDeArvore = tipoDeArvore;
    }

    public void desenhar(Graphics graficos){
        tipoDeArvore.desenhar(graficos, x, y);
    }
}
