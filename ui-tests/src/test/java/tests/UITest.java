package tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        String caminhoChromeDriver = "C:/Users/adamx/OneDrive/Área de Trabalho/Projeto QA entrevista/qa-project/ui-tests/recursos/drivers/chromedriver.exe"; 
		
        // Configuração do WebDriver (neste exemplo, usando o ChromeDriver)
		System.setProperty("webdriver.chrome.driver", caminhoChromeDriver);
        
        // Inicia o ChromeDriver
        driver = new ChromeDriver();

        if(driver != null){
			System.out.println("Driver instanciado!");
        }

        // Maximiza a janela do navegador
		driver.manage().window().maximize();
    }

    @Test
    public void testPageTitle() {
        // Navega até uma página de exemplo
        driver.get("https://www.example.com");

        // Verifica se o título da página é o esperado
        String title = driver.getTitle();
        assertEquals("Example Domain", title, "O título da página não é o esperado");
    }
    
    @AfterEach
    public void tearDown() {
        // Fecha o navegador após o teste
        if (driver != null) {
            driver.quit();
        }
    }
}
