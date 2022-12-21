package com.selenium.concept;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Frames {
//creating webDriver method with driver refName; int i =9; if int i; --> takes default "0";
	public static WebDriver driver;     //here null;
//Taking webDriver as common for single and multiple frames; No need of browser launch steps to do again and again;	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\V.VIDHYA\\eclipse-workspace\\Selenium Java Project\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
	//we can call this methods inside the method,without creating object, as they are Static;	
	//if you want to run multiple frame only,make single frame as command line;	
		multiple();
		//single();
	}
	public static void single() {	
		WebElement single = driver.findElement(By.xpath("//a[text()='Single Iframe ']"));
        single.click();
        
        driver.switchTo().frame("singleframe");
        
        WebElement text1 = driver.findElement(By.xpath("//input[@type='text']"));
        text1.sendKeys("Single Frame");	
	}
	public static void multiple() {
		WebElement multiple = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		multiple.click();
		
		WebElement multiple_outer = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(multiple_outer);
		
		WebElement multiple_inner = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(multiple_inner);
		
		WebElement text2 = driver.findElement(By.xpath("(//input[@type='text'])"));
		text2.sendKeys("Multiple frames");	
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().parentFrame();
		
		WebElement other_box = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[2]"));
		other_box.click();
	}
}
