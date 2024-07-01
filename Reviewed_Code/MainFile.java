package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Testcase101 {

    public static void main(String[] args) throws InterruptedException, AWTException {

        //align the whole file for readbility
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();// add try catch while initializing the driver , to tackle web driver failures due to incorrect path to the driver executable, missing dependencies, or compatibility issues with the browser version.
        driver.get("https://interview.supporthive.com/staff/");//urls can be added in property file and other explicit strings can be added in CONSTANT class
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// reduce implicit wait to 10secs or even lesser as it takes time for all elements to get loaded

        driver.manage().window().maximize();
        driver.findElement(By.id("id_username")).sendKeys("Agent");//urls can be added in property file and other explicit strings can be added in CONSTANT class
        //try using Page object model concept as maintianing the page elements will be easier
        // maintain all xpaths in variable classes created pagewise , for readability and reusability
        //xpaths can be taken from the 'class' of the element rather than 'id' because frameworks like React, Angular, and Vue often generate dynamic IDs
        // create common methods like click(),sendKeys() and pass webelement as parameter
        // arrange all the xpaths and give a valid name to each element and specify the actions need to be performed in each method by calling the element

        driver.findElement(By.id("id_password")).sendKeys("Agent@123");//urls can be added in property file and other explicit strings can be added in CONSTANT class
        driver.findElement(By.id("btn-submit")).click();//assertions can be added , so that the required elements will be asserted page wise
        //import assert class and add assertions

        WebElement tickets = driver.findElement(By.id("ember29"));
        Actions action = new Actions(driver);
        action.moveToElement(tickets).build().perform();

        WebElement statuses = driver.findElement(By.linkText("Statuses"));
        statuses.click();

        driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();//avoid using absolute xpaths because the xpath will break when the DOM structure changes
        driver.findElement(By.tagName("input")).sendKeys("Issue Created");

        WebElement statusColourSelect =
                driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
        statusColourSelect.click();

        WebElement statusColourEnter =
                driver.findElement(By.xpath("//input[@class='sp-input']"));
        statusColourEnter.clear();
        statusColourEnter.sendKeys("#47963f");

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);

        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();


        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();



        driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
        WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
        addCreate.click();

        Thread.sleep(3000);// use explicit or implicit waits rather than Thread.sleep because it makes tests slower

        WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
        action.moveToElement(moveTo).build().perform();
        moveTo.click();

        Thread.sleep(9000);// use explicit or implicit waits rather than Thread.sleep because it makes tests slower

        WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
        action.moveToElement(issue).build().perform();


        WebElement make = driver.findElement(By.linkText("Make Default"));
        make.click();
        driver.findElement(By.linkText("Priorities")).click();
        driver.findElement(By.xpath("//header/button[1]")).click();
        driver.findElement(By.tagName("input")).sendKeys("Assistance required");
        driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
        WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
        button.click();

        Thread.sleep(9000);// use explicit or implicit waits rather than Thread.sleep because it makes tests slower

        WebElement tickets2 = driver.findElement(By.id("ember29"));//instead of duplicating the already existing elements , separate page class can be created for reusability
        action.moveToElement(tickets2).build().perform();
        WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
        priorities2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//reduce the implicit wait time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();//avoid absolute xpaths
        driver.findElement(By.linkText("Delete")).click();
        WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
        delete.click();//will there be two delete buttons, since we are performing two deletes back to back

        Thread.sleep(9000);// use explicit or implicit waits rather than Thread.sleep because it makes tests slower
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();//avoid absolute xpaths
        driver.findElement(By.linkText("Logout")).click();

        public class PagesforAutomationAssignment {//a separate class can be created for this class for good readability and maintainability

            public static void main(String[] args) {
                ChromeDriver driver = new ChromeDriver();// add try catch while initializing the driver
                driver.get("https://www.happyfox.com");//urls can be added in property file and other explicit strings can be added in CONSTANT class

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("username", "password");

                HomePage homePage = new HomePage(driver);
                homePage.verifyHomePage();

                driver.quit();
            }

            static class BasePage {
                protected WebDriver driver;

                public BasePage(WebDriver driver) {
                    this.driver = driver;
                }
            }

            static class LoginPage extends BasePage {
                public LoginPage(WebDriver driver) {
                    super(driver);
                }

                public void login(String username, String password) {

                    driver.findElement(By.id("username")).sendKeys(username);// assign the path to private webelement variable and perform action using that variable
                    driver.findElement(By.id("password")).sendKeys(password);// assign the path to private webelement variable and perform action using that variable
                    driver.findElement(By.id("loginButton")).click();// assign the path to private webelement variable and perform action using that variable
                    // add assertions to check the reaction on selecting forgot password
                }

                public void forgotPassword() {
                    driver.findElement(By.linkText("Forgot password?")).click();// assign the path to private webelement variable and perform action using that variable
                    // add assertions to check the reaction on selecting forgot password
                }
            }

            static class HomePage extends BasePage {  //maintain all xpath in starting of the class

                public HomePage(WebDriver driver) {
                    super(driver);
                }

                public void verifyHomePage() {
                    if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {// add try catch method
                        throw new IllegalStateException("Not on the home page");
                    }
                }

                public void navigateToProfile() {
                    driver.findElement(By.id("profileLink")).click();
                }

                public class TablePage extends BasePage {

                    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

                    public TablePage(WebDriver driver) {
                        super(driver);
                    }

                    public void retrieveRowTexts() {
                        List<WebElement> rows = driver.findElements(rowLocator);
                        //add explicit wait until the table gets loaded
                        for (int i = 0; i < rows.size(); i++) {
                            WebElement row = rows.get(i);
                            String rowText = row.getText();
                            System.out.println("Row " + i + " Text: " + rowText);
                        }
                    }




                }

            }
 //} is missing


