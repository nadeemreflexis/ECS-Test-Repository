package ecs_digital_framework.ecs_digital_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ESC_TableTest 
{
	
	@Test
	public void TableTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		
		driver.findElement(By.xpath("//*[@id='home']/div/div/button/div/div/span")).click();
		Thread.sleep(5000);
		
		List<WebElement> row1Elements= driver.findElements(By.xpath("//*[@id='challenge']/div/div/div[1]/div/div[2]/table/tbody/tr[1]/td"));
		List<WebElement> row2Elements= driver.findElements(By.xpath("//*[@id='challenge']/div/div/div[1]/div/div[2]/table/tbody/tr[2]/td"));
		List<WebElement> row3Elements= driver.findElements(By.xpath("//*[@id='challenge']/div/div/div[1]/div/div[2]/table/tbody/tr[3]/td"));
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for(WebElement elements: row1Elements)
		{
			String arr = elements.getText();
			int x = Integer.valueOf(arr);
			al.add(x);
		}
		Object[] objArray = al.toArray();
		int length = objArray.length;
		Integer[] arr = new Integer[length];
		for(int i=0;i<length;i++)
		{
			arr[i]= (Integer)objArray[i];
			
		}
		for(WebElement elements1: row2Elements)
		{
			String arr1 = elements1.getText();
			int x = Integer.valueOf(arr1);
			al1.add(x);
		}
		Object[] objArray1 = al1.toArray();
		int length1 = objArray1.length;
		Integer[] arr1 = new Integer[length1];
		for(int i=0;i<length1;i++)
		{
			arr1[i]= (Integer)objArray1[i];
			
		}
		for(WebElement elements2: row3Elements)
		{
			String arr2 = elements2.getText();
			int x = Integer.valueOf(arr2);
			al2.add(x);
		}
		Object[] objArray2 = al2.toArray();
		int length2 = objArray2.length;
		Integer[] arr2 = new Integer[length2];
		for(int i=0;i<length2;i++)
		{
			arr2[i]= (Integer)objArray2[i];
			
		}
		System.out.println("Elements in first row::"+Arrays.toString(arr));
		System.out.println("Elements in second row::"+Arrays.toString(arr1));
		System.out.println("Elements in third row::"+Arrays.toString(arr2));
		checkIfEqualOption1(arr);
		checkIfEqualOption1(arr1);
		checkIfEqualOption1(arr2);
		}
		
	
	public static void checkIfEqualOption1(Integer[] arr){

        int sumTotal=0;
        for (int i=0; i < arr.length; i++){ // O(arr.length)
            sumTotal += arr[i];
        }

        int sumRight = 0;
        int sumLeft=0;
        for (int i=1; i < arr.length-1; i++){ // O(arr.length)
            sumLeft += arr[i-1];
            sumRight = sumTotal - arr[i] - sumLeft;
            if (sumRight == sumLeft){
                System.out.println("\nFoundIndex = "+i);
                break;
            }
        }
	

}
}
