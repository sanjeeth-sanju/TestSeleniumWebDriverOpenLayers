package myTests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class editingOpenLayersTest {

	private static WebDriver driver = null;

    public static void main(String[] args)  throws InterruptedException {
    	
    	//Create a new profile and load my Firefox Test profile 
    	System.out.println("Creo un nuovo profilo e vi carico il profilo di default di Firefox ...");
    	Thread.sleep(3000L);
    	ProfilesIni profile = new ProfilesIni();    	
    	FirefoxProfile ffProfile = profile.getProfile("default");
    	    	
    	// Create a new instance of the Firefox driver using my Firefox Test profile  
    	System.out.println("Creo una nuova sessione del browser Firefox ...");
    	Thread.sleep(3000L);
    	driver = new FirefoxDriver(ffProfile);
    	    	    
        // Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // It is always advisable to Maximize the window before performing DragNDrop action
     	System.out.println("Massimizzo la finestra del browser ...");
     	Thread.sleep(3000L);
     	driver.manage().window().maximize();     	
     	
        // Launch the OpenLayers 2.x WMS identify sample 
        System.out.println("Mi collego all'esempio di editing di OpenLayers 2.x ...");
        Thread.sleep(3000L); 
        driver.get("http://dev.openlayers.org/releases/OpenLayers-2.13.1/examples/editingtoolbar.html");
        
        // Create a new Action instance 
        System.out.println("Creo un oggetto di tipo \"Action\" ...");
        Actions act = new Actions(driver);
        
        // Select polygon editing button  
        System.out.println("Seleziono il bottone dell'editing dei poligoni ...");
        Thread.sleep(3000L); 
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[4]")).click();
        
        // Find the viewport inside in witch there is the map   
        System.out.println("Individuo il viewport al cui interno c'� la mappa ...");
        Thread.sleep(3000L);
        WebElement el = driver.findElement(By.id("OpenLayers_Map_31_OpenLayers_ViewPort"));
        
        // Start the action sequence 
        System.out.println("Inizio la sequenza di azioni di editing da eseguire ...");
        Thread.sleep(3000L);
        act.click().perform();
        
        // Moves to 2nd location
        System.out.println("Moves to 1st location: 200, 150 ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 200, 150).click().build().perform();
                
        // Moves to 2nd location
        System.out.println("Moves to 2nd location: 200,50 ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 200, 50).click().build().perform();
        //act.moveByOffset(329, 139).perform();
        
        // Moves to 3nd location
        System.out.println("Moves to 3nd location: 300,50 ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 300, 50).click().build().perform();
        
        // Moves to 4nd location
        System.out.println("Moves to 4th location: 300, 150 ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 300, 150).click().build().perform();
                
        /* Double click creates the 3rd vertex of the polygon
            AND should finish the drawing */
        System.out.println("Doppio click a termine della sequenza di editing ...");
        Thread.sleep(3000L);
        act.click().doubleClick().build().perform();        
        
        // Print TEST = OK!!
        System.out.println("TEST = OK !!");
        //driver.quit();
        
            }
}