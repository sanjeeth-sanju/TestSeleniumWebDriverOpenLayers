package myTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class aeraTest {

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
    	    	    
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // It is always advisable to Maximize the window before performing DragNDrop action
     	System.out.println("Massimizzo la finestra del browser ...");
     	Thread.sleep(3000L);
     	driver.manage().window().maximize();     	
     	
        //Launch the "Sistema Piemonte" Home Page
        System.out.println("Mi collego a AERA Piemonte ...");
        Thread.sleep(3000L); 
        driver.get("http://www.regione.piemonte.it/aeraw/");         
         
        // Close the modal browser window to select layers 
        System.out.println("Chiudo la finestra modale di selezione layers ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/div/div/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click();        
 
        // Change the basemap setting OpenLayers as basemap 
        System.out.println("Modifico la mappa di sfondo impostando OpenLayers (RadioButton) ...");
        Thread.sleep(3000L);
        WebElement baseRadioButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div/ul/div/li[3]/ul/li[3]/div/input"));        
        baseRadioButton.click(); 
        
        // Active the "Comuni" layer on the map (CheckBox) 
        System.out.println("Attivo su mappa il layer dei Comuni (CheckBox)...");
        Thread.sleep(3000L);
        WebElement comuniCheckBox = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div/ul/div/li[1]/ul/li[3]/div/input"));
        comuniCheckBox.click(); 
        
        // Zoom on TORINO (Input)
        System.out.println("Selezione e Zoom su Torino (Input) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[21]/div/input")).sendKeys("TORINO");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[21]/div/input")).sendKeys(Keys.RETURN);
       
        // Click on arrow down button to select the scale (Button) 
        System.out.println("Click sulla freccia in gi� per la selezione della scala (Button) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/img")).click();        
               
        // Select "1 : 272989" (Div)"
        System.out.println("Seleziono \"1 : 272989\" (Div) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[17]/div/div[9]")).click();
               
        // Find the viewport inside in witch there is the map   
        System.out.println("Individuo il viewport al cui interno c'� la mappa ...");
        Thread.sleep(3000L);
        WebElement el = driver.findElement(By.id("OpenLayers.Map_21_OpenLayers_ViewPort"));
        
        // Create a new Action instance 
        System.out.println("Creo un oggetto di tipo \"Action\" ...");
        Actions act = new Actions(driver);
                
        // Select the zoom in button 
        System.out.println("Seleziono il bottone per fare zoom in  ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[9]/table/tbody/tr[2]/td[2]/em/button")).click();        
        
        // Interactive zoom in    
        System.out.println("Primo zoom in interattivo  ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 714, 197).click().keyDown(Keys.SHIFT).clickAndHold().moveToElement(el, 760, 243).click().release().keyUp(Keys.SHIFT).build().perform();

        // Interactive zoom in    
        System.out.println("Secondo zoom in interattivo  ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 714, 197).click().keyDown(Keys.SHIFT).clickAndHold().moveToElement(el, 760, 243).click().release().keyUp(Keys.SHIFT).build().perform();

        // Select the pan button 
        System.out.println("Seleziono il bottone per fare pan ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[7]/table/tbody/tr[2]/td[2]/em/button")).click();        
       
        // Interactive pan    
        System.out.println("Pan sulla mappa  ...");
        Thread.sleep(3000L);
        act.moveToElement(el, 700, 200).clickAndHold().moveToElement(el, 1000, 500).release().build().perform();       
               
        // Zoom 1 (Button)
        System.out.println("Faccio zoom in sulla mappa (Button) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[3]/div[10]/div[1]")).click();        

        // Zoom 2 (Button)
        System.out.println("Faccio altro zoom in sulla mappa (Button) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[3]/div[10]/div[1]")).click();        

        // Pan dx 1 (Button)
        System.out.println("Faccio pan a dx in sulla mappa (Button) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[3]/div[6]/div[3]")).click();        

        // Pan dx 2 (Button)
        System.out.println("Faccio altro pan a dx in sulla mappa (Button) ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[3]/div[6]/div[3]")).click();        

        // Select the zoom max button 
        System.out.println("Seleziono il bottone per fare zoom max ...");
        Thread.sleep(3000L);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr/td[6]/table/tbody/tr[2]/td[2]/em/button")).click();        

        // Print TEST = OK!!
        System.out.println("TEST = OK !!");
        //driver.quit();
        
            }
}  