package MavenUtilHomework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkNopCommerceAutomated extends UtilsPage {

    @BeforeMethod

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //Open the Browser
        openChromeVersion76();
        //Maximise the Browser window screen
        manageWindow();
        //Set Timeoutandimplicity wait for driver object
        manageTimeoutImplicity();
        //Open the website
        openNopCommerce();
    }



    @Test
    public void UserShouldBeAbleToRegisterSuccessfully(){

        //Click on Register Button
        clickElement(By.xpath("//a[@class='ico-register']"));
        //Enter First Name
        enterText(By.xpath("//input[@data-val-required='First name is required.']"), getProperty("FirstName"));
        //Enter Last Name
        enterText(By.id("LastName"),getProperty("LastName"));
        //click Dropdown date from Dob
        clickElement(By.xpath("//div[@class = \"date-picker-wrapper\"]"));
        //select DATE from Dropdown
        clickElement(By.xpath("//option[@value = \"16\"]"));
        //click Dropdown MONTH from Dob
        clickElement(By.xpath("//select[@name = \"DateOfBirthMonth\"]"));
        //Select Month In Dropdown
        selectByIndex(By.xpath("//select[@name = \"DateOfBirthMonth\"]"),11);
        //Click Year Dropdown
        clickElement(By.xpath("//select[@name = \"DateOfBirthYear\"]"));
        //Select Year in Dropdown
        selectByValue(By.xpath("//select[@name = \"DateOfBirthYear\"]"),"1985");
        enterText(By.name("Email"),generateEmail());
        //Enter Password
        //Enter Company Name
        enterText(By.id("Company"),"Venus International Limited");
        //Untick to Unsubscribe from Newsletter
        clickElement(By.id("Newsletter"));
        //Enter Email
        enterText(By.id("Password"),"123456");
        //Enter Confirm Password
        enterText(By.xpath("//input[@data-val-equalto-other='*.Password']"),getProperty("PassWord"));
        //Click on Register
        clickElement(By.xpath("//input[@class='button-1 register-next-step-button']"));
        //Expected Result
        String expectedResultsTest1 = ("Your registration completed");
        //Actual Result
        String actualResultsTest1 = extractText(By.xpath("//div[@class='result']"));
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResultsTest1,expectedResultsTest1);
    }




    @Test
    public void UserShouldBeAbleToReferAProductToFriend(){
        //Click on Register Button
        clickElement(By.xpath("//a[@class='ico-register']"));
        //Enter First Name
        enterText(By.xpath("//input[@data-val-required='First name is required.']"), getProperty("FirstName"));
        //Enter Last Name
        enterText(By.id("LastName"),getProperty("LastName"));
        //click Dropdown date from Dob
        clickElement(By.xpath("//div[@class = \"date-picker-wrapper\"]"));
        //select DATE from Dropdown
        clickElement(By.xpath("//option[@value = \"16\"]"));
        //click Dropdown MONTH from Dob
        clickElement(By.xpath("//select[@name = \"DateOfBirthMonth\"]"));
        //Select Month In Dropdown
        selectByIndex(By.xpath("//select[@name = \"DateOfBirthMonth\"]"),11);
        //Click Year Dropdown
        clickElement(By.xpath("//select[@name = \"DateOfBirthYear\"]"));
        //Select Year in Dropdown
        selectByValue(By.xpath("//select[@name = \"DateOfBirthYear\"]"),"1985");
        //Enter Email
        enterText(By.name("Email"),(getProperty("FirstName") + generateRandomNumberDouble() + getProperty("Email")));
        //Enter Company Name
        enterText(By.id("Company"),"Venus International Limited");
        //Untick to Unsubscribe from Newsletter
        clickElement(By.id("Newsletter"));
        //Enter Email
        enterText(By.id("Password"),"123456");
        //Enter Confirm Password
        enterText(By.xpath("//input[@data-val-equalto-other='*.Password']"),getProperty("PassWord"));
        //Click on Register
        clickElement(By.xpath("//input[@class='button-1 register-next-step-button']"));
        //Back to Homepage
        clickElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        //Click on Macbook Pro 13 inch
        clickElement(By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']"));
        //Click on Email a Friend
        clickElement(By.xpath("//input[@value='Email a friend']"));
        //Type Friend's Email
        enterText(By.name("FriendEmail"),getProperty("FriendName") + (getRandomNumberDate())+(generateRandomFloat()) + (getProperty("Email")));
        //Type Personal Message
        enterText(By.xpath("//textarea[@class='your-email']"),"Yo Bro.....Buy me this Laptop");
        //Wait for the button to Send Button Load
        waitForClickable(By.xpath("//input[@class='button-1 send-email-a-friend-button']"),3);
        //Click on Send Email
        clickElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']"));
        //Expected Result
        String expectedResults2 = ("Your message has been sent.");
        //Actual Result
        String actualResults2 = extractText(By.xpath("//div[@class='result']"));
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResults2,expectedResults2);
    }

    @ Test
    public void UserShouldBeNavigateToCameraAndPhotoPage(){
        //Click on Electronics
        clickElement(By.xpath("//h2/a[@title='Show products in category Electronics']"));
        //Click on Camera & Photo
        clickElement(By.xpath("//div/h2/a[@title='Show products in category Camera & photo']"));
        //Expected Result
        String expectedResultTest3 = ("Nikon D5500 DSLR");
        //Actual Result
        String actualResultTest3 = extractText(By.linkText("Nikon D5500 DSLR"));
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResultTest3,actualResultTest3);
    }


    @Test
    public void UserShouldBeAbleToSelectJewelleryBetween$700To$3000 (){
        //Click on Jewellery
        clickElement(By.linkText("Jewelry"));
        //Select $700 to $3000
        clickElement(By.xpath("//a[@href='//demo.nopcommerce.com/jewelry?price=700-3000']"));
        //Expected Result
        String expectedResultTest4 = extractText(By.className("product-title"));
        //Actual Result
        String actualResultTest4 = extractText(By.linkText("Vintage Style Engagement Ring"));
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResultTest4,actualResultTest4);
    }

    @Test
    public void UserShouldBeAbleToAddTwoBooksInShoppingBasket (){

        //Click on Books
        clickElement(By.linkText("Books"));
        //Select First Book
        clickElement(By.xpath("//img[@src=\"//demo.nopcommerce.com/images/thumbs/0000068_fahrenheit-451-by-ray-bradbury_415.jpeg\"]"));
        //Add First Book to Cart
        clickElement(By.id("add-to-cart-button-37"));
        //Select Second Book
        clickElement(By.xpath("//img[@src = \"//demo.nopcommerce.com/images/thumbs/0000069_first-prize-pies_415.jpeg\"]"));
        //Add Another Book to Cart
        clickElement(By.id("add-to-cart-button-38"));
        //Click on Shopping Cart
        clickElement(By.id("topcartlink"));
        //driver.findElement(By.linkText("Shopping cart")).click();
        //Expected Result A
        String expectedResult5a = ("Fahrenheit 451 by Ray Bradbury");
        //Actual Result A
        String actualResult5a = extractText(By.xpath("//a[@class = \"product-name\"]"));
        //Comparision with Expected and Actual Result
        Assert.assertEquals(expectedResult5a,actualResult5a);
        //Expected Result B
        String expectedResult5b = ("First Prize Pies");
        //Actual Result B
        String actualResult5b = extractText(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[4]/a"));
        //Comparision with Expected and Actual Result
        Assert.assertEquals(expectedResult5b,actualResult5b) ;


    }


    @AfterMethod
    public void browserClose() {
        driver.quit();

    }


}
