import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {
    static Map<String, TipoDeArvore> tiposDeArvores = new HashMap<>();

    public static TipoDeArvore buscarTipoDeArvore(String nome, Color cor, String outrosDadosDaArvore){
        TipoDeArvore resultado = tiposDeArvores.get(nome);

        if(resultado == null){
            resultado = new TipoDeArvore(nome, cor, outrosDadosDaArvore);
            tiposDeArvores.put(nome, resultado);
        }
        return resultado;
    }
}
