package client;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequisicaoClient {
    private static final OkHttpClient client = new OkHttpClient();

    public static String buscarResultados() throws IOException {
    	RequestBody formBody = new FormBody.Builder()
    		    .add("tipoReq.id", "11")
    		    .add("subTipoReq.id", "1")
    		    .add("codigo_busca", "")
    		    .add("grupo.codigo", "5244")
    		    .add("idAlmoxarifado", "9")
    		    .add("numero", "")
    		    .add("ano", "2025")
    		    .add("model", "")
    		    .add("idReqMaterial", "")
    		    .add("livro.titulo", "")
    		    .add("status", "101")
    		    .add("grupoStatus", "0")
    		    .add("proponente.siape", "0")
    		    .add("cpfString", "")
    		    .add("grupoManutencao.id", "7")
    		    .add("modelForn", "")
    		    .add("fornecedor.id", "")
    		    .add("fornecedor.nome", "")
    		    .add("codigo_comboUnidadeCusto", "")
    		    .add("gestora_comboUnidadeCusto", "0")
    		    .add("unidadeCusto.id", "0")
    		    .add("buscaUnidadeReq", "true")
    		    .add("codigo_comboUnidadeReq", "11.31.05.14.01")
    		    .add("gestora_comboUnidadeReq", "0")
    		    .add("unidade.id", "1463")
    		    .add("buscaData", "true")
    		    .add("dataInicial", "01/01/2025")
    		    .add("dataFinal", "31/12/2025")
    		    .add("tipo", "11")
    		    .add("acao", "13")
    		    .add("busca", "true")
    		    .add("voltar", "11")
    		    .add("alterarOB", "")
    		    .build();

    		Request request = new Request.Builder()
    		    .url("https://sipac.ufrn.br/sipac/buscaListaReq.do")
    		    .post(formBody)
    		    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
    		    .header("Accept-Language", "en-US,en;q=0.9")
    		    .header("Cache-Control", "max-age=0")
    		    .header("Connection", "keep-alive")
    		    .header("Content-Type", "application/x-www-form-urlencoded")
    		    .header("Origin", "https://sipac.ufrn.br")
    		    .header("Referer", "https://sipac.ufrn.br/sipac/preparaBuscaListaReq.do?popula=true&popularCheckStatus=true&tipo=11")
    		    .header("Sec-Fetch-Dest", "document")
    		    .header("Sec-Fetch-Mode", "navigate")
    		    .header("Sec-Fetch-Site", "same-origin")
    		    .header("Sec-Fetch-User", "?1")
    		    .header("Upgrade-Insecure-Requests", "1")
    		    .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36")
    		    .header("sec-ch-ua", "\"Google Chrome\";v=\"135\", \"Not-A.Brand\";v=\"8\", \"Chromium\";v=\"135\"")
    		    .header("sec-ch-ua-mobile", "?0")
    		    .header("sec-ch-ua-platform", "\"Linux\"")
    		    .header("Cookie", "_ga_5C1BD7G8DL=GS1.1.1742342261.1.0.1742342270.0.0.0; JSESSIONID=0D6EDE3EB83B2424F83F74071EDD8B72.sipac04-producao; _ga=GA1.2.1057301046.1742342261; _gid=GA1.2.1537585952.1745889118; alertgenese-vera.cavalcanti=true; _ga_TSBKPET5FL=GS1.2.1745889118.1.1.1745889155.0.0.0")
    		    .build();
    		
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro inesperado: " + response);
            }
            return response.body().string();
        }
    }
}
