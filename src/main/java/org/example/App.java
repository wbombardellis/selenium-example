package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.gecko.driver","/home/wbombardellis/Selenium/geckodriver-v0.30.0-linux64/geckodriver");

        var driver = new FirefoxDriver();
        try {
            /// First scenario - Invalid login
            driver.get("https://account.blip.ai/login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dblip-portal%26redirect_uri%3Dhttps%253A%252F%252Fportal.blip.ai%252Fauthorize%26response_type%3Did_token%2520token%26scope%3Doffline_access%2520openid%2520profile%2520email%2520api-msging-hub.full_access%26state%3Dac7affc61f2f41b583a38097040b3159%26nonce%3Df3982e609ca24569808c458150071868");

            By emailLocator = By.cssSelector("input#email");
            By pwLocator = By.cssSelector("input#password");
            By loginBtnLocator = By.cssSelector("button#blip-login");

            var emailInput = driver.findElement(emailLocator);
            var pwInput = driver.findElement(pwLocator);

            emailInput.sendKeys("wbombardellis@gmail.com");
            pwInput.sendKeys("123456");

            var loginButton = driver.findElement(loginBtnLocator);
            var isEnabledLogin = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> loginButton.isEnabled());

            loginButton.click();

            By errorMessageLocator = By.xpath("//*[contains(text(),‘Invalid Login’)]");
            var invalidLoginMsg = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> d.findElement(errorMessageLocator));

            System.out.println("done");

            /// Second scenario - Invalid login
            driver.get("https://account.blip.ai/login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dblip-portal%26redirect_uri%3Dhttps%253A%252F%252Fportal.blip.ai%252Fauthorize%26response_type%3Did_token%2520token%26scope%3Doffline_access%2520openid%2520profile%2520email%2520api-msging-hub.full_access%26state%3Dac7affc61f2f41b583a38097040b3159%26nonce%3Df3982e609ca24569808c458150071868");



            System.out.println("done");
        } finally{
            driver.quit();
        }
    }
}
