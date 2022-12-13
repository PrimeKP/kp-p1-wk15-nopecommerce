package com.nopcommece.pages;

import com.nopcommece.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.Random;

public class ShoppingCartPage extends Utility {

    @FindBy(xpath = "//a[@href='/computers']")
    WebElement clickComputer;

    @FindBy(xpath="//a[@title='Show products in category Desktops']")
    WebElement clickDesktop;
   @FindBy(id="products-orderby")
   WebElement sort;

    @FindBy (xpath="(//button[contains(text(),'to cart')])[1]")
    WebElement clickCart;
    //By actualVerifyText = By.xpath("//h1[contains(text(),'Build your own computer')]");
    @FindBy(name="product_attribute_1")
    WebElement selctComputer;


    public void clickOnComputerAndDesktop() {
        Reporter.log("click on computer "+ clickComputer.getText());
        clickOnElement(clickComputer);
        Reporter.log("click on computer "+ clickDesktop.getText());
        clickOnElement(clickDesktop);
    }

    public void sortComputerDesktopsToAtoZ(String value) {
        Reporter.log("sort computerdesktops to AtoZ"+sort.getText());
        selectByValueFromDropDown(sort, value);
    }

    public void clickOnShoppingCart() throws InterruptedException {
        Reporter.log("click on shopping cart"+ clickCart.getText());
        Thread.sleep(5000);
        clickOnElement(clickCart);
    }


    public void selectPentiumComputer(String name) {
        Reporter.log("select Pentium Computer"+ selctComputer.getText());
        selectByVisibleTextFromDropDown(selctComputer, name);
    }

    //this method will select by what ever name provide from dropdown
    public void selectByDropDown(String message, By by, String name) {
        Reporter.log("selecting drop down");
        selectByVisibleTextFromDropDown(by, name);
    }


    //==================these methods allow to compare text by taking parameters==============
    public String exptectedTextMessage(String expected) {
        Reporter.log("Expected text message");
        System.out.println("Expected Text or Message is : " + expected);
        return expected;
    }

    public String actualTextToVerify(By by) {
        Reporter.log("Getting actual text verification");
        String actual = driver.findElement(by).getText();
        System.out.println("Actual Text or Message is : " + actual);
        return actual;
    }
    //==================these methods allow to compare text by taking parameters==============

    public void selectMemory8GB(String name) {
        Reporter.log("Selecting Memory 8GB");
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"), name);

    }

    public void selectingHDD400GB() {
        Reporter.log("Selecting HDD 400GB");
        clickOnElement(By.id("product_attribute_3_7"));
    }


    public void selectRadioButton(String message, By by) {
        Reporter.log("Selecting Radio Button");
        clickOnElement(by);
    }

    public void selectCheckBox(String message, By by) {
        Reporter.log("Selecting check box");
        clickOnElement(by);
    }

    public void selectPressButton(String message, By by) {
        Reporter.log("Selecting press button");
        clickOnElement(by);
    }

    public void mouseHoveronShoppingCartAndClickOnGoToCart() {
        Reporter.log("Mouse hovering on shopping cart and click on to to cart");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        goToCart.click();

    }

    public void changeTheQuantityTo2AndClickOnUpdateShoppingCart() {
        Reporter.log("Change the quantity to 2 and clicking on update shopping cart");
        clearContent(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.id("updatecart"));
    }

    public void fillingMandatoryFields(String message, String sendText, By by) {
        Reporter.log("Filling mandatory fileds");
        sendTextToElement(by, sendText);
    }

    public void randomEmailGeneratorAndSendText(By by, String firstName, String lastName) {
        Reporter.log("Random email generating and filling");
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        String email = firstName + "." + lastName + emailNum + "@email.com";
        sendTextToElement(by, email);
    }
    }

