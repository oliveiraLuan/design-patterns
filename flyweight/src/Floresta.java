import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Floresta extends JFrame {
    private List<Arvore> arvores = new ArrayList<>();

    public void plantarArvore(int x, int y, String nome, Color cor, String outrosDadosDaArvore){
        TipoDeArvore tipoDeArvore = ArvoreFactory.buscarTipoDeArvore(nome, cor, outrosDadosDaArvore);
        Arvore arvore = new Arvore(x, y, tipoDeArvore);
        arvores.add(arvore);
    }

    public void pintar(Graphics graficos){
        for(Arvore arvore : arvores)
            arvore.desenhar(graficos);
    }
}
