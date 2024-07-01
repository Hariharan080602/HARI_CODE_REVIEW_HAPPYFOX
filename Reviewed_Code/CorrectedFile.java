Sample way:

public class Testcase101 {

  public static void main(String[] args) throws InterruptedException, AWTException {

    private static final String DRIVER_PATH ="C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe";
    private static final String URL_PATH = "https://interview.supporthive.com/staff/";
    private static final String USERNAME = "Agent";
    private static final String PASSWORD = "Agent@123";
    private static final String INPUT_VALUE = "Issue Created";
    private static final String STATUS_COLOUR_VALUE = "#47963f";
    private static final String TEXT_AREA_VALUE = "Status when a new ticket is created in HappyFox";
    System.setProperty("webdriver.gecko.driver", DRIVER_PATH);

    try {
      WebDriver driver = new FirefoxDriver();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      quitDriver();
    }

    driver.get(URL_PATH);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    WebElement userName = driver.findElement(By.id("id_username"));
    WebElement password = driver.findElement(By.id("id_password"));
    WebElement submitButton = driver.findElement(By.id("btn-submit"));
    WebElement tickets = driver.findElement(By.id("ember29"));
    WebElement statuses = driver.findElement(By.linkText("Statuses"));
    WebElement header =   driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button"));// change to relative xpath
    WebElement input = driver.findElement(By.tagName("input"));
    WebElement statusColourSelect =driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
    WebElement statusColourEnter = driver.findElement(By.xpath("//input[@class='sp-input']"));
    WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
    WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
    WebElement textarea = driver.findElement(By.tagName("textarea"));
    WebElement addCreate = driver.findElement(By.xpath(
        "//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));

    Actions action = new Actions(driver);

    public void click (WebElement element)
    {
      element.click();
    }

    public void sendKeys (WebElement element, String value)
    {
      element.sendKeys(value);
    }

    login();
    clickOnTickets();
    clickOnStatus();
    clickOnHeader();
    inputValues();
    selectColourStatus();

    private static void login (WebDriver driver)
    {
      sendKeys(userName, USERNAME);
      sendKeys(password, PASSWORD);
      click(submitButton);
    }

			private static clickOnTickets() {
      action.moveToElement(tickets).build().perform();

    }

			private static clickOnStatus() {
      click(statuses);
    }

			private static clickOnHeader() {
      click(header);
    }

			private static inputValues() {
      sendKeys(input, INPUT_VALUE);
    }

			private static selectColourStatus() {
      click(statusColourSelect);

      statusColourEnter.clear();
      sendKeys(statusColourEnter, STATUS_COLOUR_VALUE) Robot r = new Robot();
      r.keyPress(KeyEvent.VK_ESCAPE);
    }


  }}
