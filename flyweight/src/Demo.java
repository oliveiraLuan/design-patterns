import java.awt.*;

import static java.lang.Math.random;

public class Demo {
    static int TAMANHO_CANVAS = 500;
    static int ARVORE_PARA_DESENHAR = 1000000;
    static int TIPOS_DE_ARVORE = 2;

    public static void main(String[] args) {
        Floresta floresta = new Floresta();

        for(int i = 0; i < Math.floor(ARVORE_PARA_DESENHAR / TIPOS_DE_ARVORE); i++){
            floresta.plantarArvore(random(0, TAMANHO_CANVAS), random(0, TAMANHO_CANVAS), "Carvalho de verão", Color.GREEN, "Esboço textura carvalho de verão");
            floresta.plantarArvore(random(0, TAMANHO_CANVAS), random(0, TAMANHO_CANVAS), "Carvalho de outono", Color.ORANGE, "Esboço textura carvalho de outono");
        }
        floresta.setSize(TAMANHO_CANVAS, TAMANHO_CANVAS);
        floresta.setVisible(true);

        System.out.println(ARVORE_PARA_DESENHAR + "ÁRVORES DESENHADAS");
        System.out.println("---------------------");
        System.out.println("Uso da memória:");
        System.out.println("Tamanho da árvore (8 bytes) * " + ARVORE_PARA_DESENHAR);
        System.out.println("Tipos de árvore tamanho (˜30 bytes) * " + TIPOS_DE_ARVORE + "");
        System.out.println("---------------------");
        System.out.println("TOTAL: " + ((ARVORE_PARA_DESENHAR * 8 + TIPOS_DE_ARVORE * 30) / 1024 / 1024 + "MB AO INVÉS DE "
                + ((ARVORE_PARA_DESENHAR * 38) / 1024 / 1024 ) + " MB"));
    }

    private static int random(int min, int max){
        return min + (int) (Math.random() *  ((max - min) + 1));
    }
}
