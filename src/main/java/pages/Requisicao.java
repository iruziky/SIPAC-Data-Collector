package pages;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requisicao {
    private static final OkHttpClient client = new OkHttpClient();

    public static String buscarResultados() throws IOException {
        FormBody formBody = new FormBody.Builder()
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
        	    .header("Accept-Language", "pt-PT,pt;q=0.9,en-US;q=0.8,en;q=0.7")
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
        	    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36")
        	    .header("sec-ch-ua", "\"Google Chrome\";v=\"135\", \"Not-A.Brand\";v=\"8\", \"Chromium\";v=\"135\"")
        	    .header("sec-ch-ua-mobile", "?0")
        	    .header("sec-ch-ua-platform", "\"Windows\"")
        	    .header("Cookie", "JSESSIONID=557AF96C7CDA4F25AECF0282C4C525F3.sipac01-producao; alertgenese-vera.cavalcanti=true; _ga=GA1.2.453584100.1745871105; _gid=GA1.2.1556323758.1745871105; _gat=1; _ga_TSBKPET5FL=GS1.2.1745871105.1.1.1745871127.0.0.0")
        	    .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro inesperado: " + response);
            }
            return response.body().string();
        }
    }
}
