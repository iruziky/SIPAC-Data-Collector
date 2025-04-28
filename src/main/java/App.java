import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import components.RequestFilter;
import core.DriverFactory;
import pages.FiltersPage;
import pages.LoginPage;
import pages.Requisicao;
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
	        
	        DriverFactory.getUrl(Urls.SIPAC_HOME);
	        logIn(user, password);
	        
	        
	        
	        if (!DriverFactory.isEqualToCurrentUrl(Urls.REQUESTS_FILTERS_PAGE)) {
	        	DriverFactory.getUrl(Urls.REQUESTS_FILTERS_PAGE);
	        }
	        
	        String respostaHtml = Requisicao.buscarResultados();
            
            Pattern pattern = Pattern.compile("visualizaRequisicao\\.do\\?id=(\\d+)");
            Matcher matcher = pattern.matcher(respostaHtml);

            while (matcher.find()) {
                String id = matcher.group(1); // grupo 1 é o número capturado
                System.out.println("ID encontrado: " + id);
            }
	        
//	        FiltersPage filtersPage = new FiltersPage();
//	        RequestFilter yearFilter = new RequestFilter(By.xpath("//*[@id=\"buscaNumAno\"]"), true);
//	        filtersPage.selectFilters(yearFilter);
//	        filtersPage.searchResults();
	        
	        Thread.sleep(50000);
	        
	    } catch (Exception e) {
	        System.err.println("Erro durante a execução: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        DriverFactory.killDriver();
	    }
	}
	
	public static void logIn(String usuario, String senha) {
		CookieManager.carregarCookies();
		DriverFactory.getUrl(Urls.REQUESTS_FILTERS_PAGE);
        
        if (!DriverFactory.isEqualToCurrentUrl(Urls.REQUESTS_FILTERS_PAGE)) {
            LoginPage loginPage = new LoginPage();
            loginPage.fazerLogin(usuario, senha);
            CookieManager.salvarCookies();
        }
	}
}