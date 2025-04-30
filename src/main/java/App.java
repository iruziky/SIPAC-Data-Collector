import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.LoginClient;
import client.RequisicaoClient;
import core.DriverManager;
import utils.CookieManager;
import utils.Urls;

public class App {
	public static void main(String[] args) {
	    try {
	        String user = System.getenv("USUARIO_UFRN");
	        String password = System.getenv("SENHA_UFRN");
	        
	        if (user == null || password == null) {
	            throw new RuntimeException("Variáveis de ambiente não encontradas.");
	        }
	        
	        DriverManager.getDriver().get(Urls.REQUESTS_FILTERS_PAGE);
	        
	        LoginClient loginClient = new LoginClient();
	        if (!CookieManager.validarCookies(Urls.REQUESTS_FILTERS_PAGE)) {
	        	loginClient.fazerLogin(user, password);
	        	Thread.sleep(5000);
	        	CookieManager.salvarCookies();
	        }
	        
	        String respostaHtml = RequisicaoClient.buscarResultados();
	        
            Pattern pattern = Pattern.compile("visualizaRequisicao\\.do\\?id=(\\d+)");
            Matcher matcher = pattern.matcher(respostaHtml);
            
            while (matcher.find()) {
                String id = matcher.group(1);
                System.out.println("ID encontrado: " + id);
            }
	        
	    } catch (Exception e) {
	        System.err.println("Erro durante a execução: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        DriverManager.killDriver();
	    }
	}
}
