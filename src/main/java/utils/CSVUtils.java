package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUtils {
    
    public static void salvarDadosCSV(String nomeArquivo, List<String[]> dados, String[] cabecalho) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            if (cabecalho != null) {
                writer.write(String.join(",", cabecalho) + "\n");
            }

            for (String[] linha : dados) {
                writer.write(String.join(",", linha) + "\n");
            }
            
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo CSV: " + e.getMessage());
        }
    }
}