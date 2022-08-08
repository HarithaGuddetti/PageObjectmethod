package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CalculatorPage extends Basepage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private By devSiteSearch = By.className("devsite-search-form");
    private By googleSearch = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private By switchToCalculator = By.xpath("//div[@class='gs-title']//b[contains(text(),'Google Cloud Pricing Calculator')]");
    private By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");
    private By instancesField = By.name("quantity");
    private By operatingSystem = By.id("select_99");
    private By osModel = By.id("select_option_89");

    private By provisioning = By.id("select_103");
    private By provisioningModel = By.id("select_option_102");
    private By seriesOfMachine = By.xpath("//md-select[@name='series']/parent::md-input-container");
    private By seriesOfMachineModel = By.xpath("//md-option[@value='n1']");
    private By machineType = By.xpath("//label[text()='Machine type']/parent::md-input-container");
    private By computeEngine = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private By gpusCheckBox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private By gpuType = By.xpath("//md-select[@placeholder='GPU type']");
    private By gpuTypeModel =By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By numberOfGpus = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By numberOfGpusModel = By.cssSelector("md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]");
    private By localSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private By localSsdModel = By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='2']/div[@class='md-text ng-binding']");
    private By dataCenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private By dataCenterLocationInFrankfurt = By.cssSelector("md-select-menu[class='md-overflow']" + " md-option[value='europe-west3'][ng-repeat*='fullRegionList']");
    private By committedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By oneYearUsage = By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" + " md-option[value='1'][class='md-ink-ripple']");
    private By addToEstimateButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private By regionIsFrankfurt = By.xpath("//md-list-item[1]/div");
    private By InformationInInstanceTypeIncludeN1Standard8 = By.xpath("//md-list-item[5]/div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']");
    private By informationInVmClassIsRegular = By.xpath("//md-list-item[4]/div");

    private By localSsdSpace2x375Gib = By.xpath("//md-list-item[7]/div[1]");

    private By commitmentTermOneYear = By.xpath("//md-list-item[3]/div[1]");

    private By estimatedCost = By.xpath("//md-list-item[2]/div[1]");


    public void openCloudPage() {
        driver.get("https://cloud.google.com/");
    }

    public void goToGoogleCloudPlatformPricingCalculatorPage(String keyForCalculatorPageOpening) throws InterruptedException {
        driver.findElement(devSiteSearch).click();
        WebElement textForGoogleSearch = driver.findElement(googleSearch);
        textForGoogleSearch.click();
        textForGoogleSearch.sendKeys(keyForCalculatorPageOpening);
        textForGoogleSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(switchToCalculator).click();
    }

    public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances) throws InterruptedException {
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        Thread.sleep(3000);
        WebElement numberOfInstancesField = driver.findElement(instancesField);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
        Thread.sleep(3000);
    }

    public void selectOS() throws InterruptedException {
        driver.findElement(operatingSystem).click();
        Thread.sleep(3000);
        driver.findElement(osModel).click();
    }

    public void selectProvisionModel() throws InterruptedException {
        driver.findElement(provisioning).click();
        Thread.sleep(3000);
        driver.findElement(provisioningModel).click();
    }

    public void selectSeriesOfMachine() throws InterruptedException {
        driver.findElement(seriesOfMachine).click();
        Thread.sleep(3000);
        driver.findElement(seriesOfMachineModel).click();
        Thread.sleep(3000);
    }

    public void selectMachineType() throws InterruptedException {
        driver.findElement(machineType).click();
        Thread.sleep(3000);
        driver.findElement(computeEngine).click();
        Thread.sleep(3000);
    }

    public void clickAddGpusCheckBox() throws InterruptedException {
        driver.findElement(gpusCheckBox).click();
        Thread.sleep(3000);
    }

    public void selectGpuType() throws InterruptedException {
        driver.findElement(gpuType).click();
        Thread.sleep(3000);
        driver.findElement(gpuTypeModel).click();
        //Thread.sleep(2000);
    }
    public void selectNumberOfGpus() throws InterruptedException {
        driver.findElement(numberOfGpus).click();
        Thread.sleep(3000);
        driver.findElement(numberOfGpusModel).click();
        Thread.sleep(3000);
    }
    public void selectLocalSsd() throws InterruptedException {
        driver.findElement(localSsd).click();
        Thread.sleep(3000);
        driver.findElement(localSsdModel).click();
        Thread.sleep(3000);
    }

    public void selectDataCenterLocation() throws InterruptedException {
        driver.findElement(dataCenterLocation).click();
        Thread.sleep(3000);
        driver.findElement(dataCenterLocationInFrankfurt).click();
        Thread.sleep(3000);
    }

    public void selectCommittedUsage() throws InterruptedException {
        driver.findElement(committedUsage).click();
        Thread.sleep(3000);
        driver.findElement(oneYearUsage).click();
        Thread.sleep(3000);
    }

    public void pushAddToEstimate() throws InterruptedException {
        driver.findElement(addToEstimateButton).click();
        Thread.sleep(5000);
    }

    public void checkRegionIsFrankfurt() {
        String region = driver.findElement(regionIsFrankfurt).getText();
        System.out.println(region);
        Assert.assertEquals(region,"Region: Frankfurt");
    }
    public void checkInformationInInstanceTypeIncludeN1Standard8() {
        String instanceType = driver.findElement(InformationInInstanceTypeIncludeN1Standard8).getText();
        System.out.println("Instance Type"+ instanceType);
        Assert.assertEquals(instanceType,"Instance type: n1-standard-8\nCommitted Use Discount applied");
    }

    public void checkInformationInVmClassIsRegular() {
        String provisioningModelResult = driver.findElement(informationInVmClassIsRegular).getText();
        System.out.println(provisioningModelResult);
        Assert.assertEquals(provisioningModelResult,"Provisioning model: Regular");
    }

    public void checkLocalSsdSpace2x375Gib() {
        String localssd11 = driver.findElement(localSsdSpace2x375Gib).getText();
        System.out.println("Local SSD"+ localssd11);
        Assert.assertEquals(localssd11,"Local SSD: 2x375 GiB\nCommitted Use Discount applied");
    }

    public void checkCommitmentTermOneYear() {
        String commitmentTerm = driver.findElement(commitmentTermOneYear).getText();
        System.out.println("Commitment Term"+ commitmentTerm);
        Assert.assertEquals(commitmentTerm,"Commitment term: 1 Year");
    }

    public void checkMonthlyAmount() {
        String amount = driver.findElement(estimatedCost).getText();
        System.out.println("Estimated"+ amount);
        Assert.assertEquals(amount,"2,920 total hours per month");
    }
}