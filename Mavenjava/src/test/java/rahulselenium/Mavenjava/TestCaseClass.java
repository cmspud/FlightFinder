package rahulselenium.Mavenjava;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
 
import rahulselenium.Mavenjava.BrowserFactory;
import rahulselenium.Mavenjava.CaptureScreenShot;
import rahulselenium.Mavenjava.BookFlightPage;
import rahulselenium.Mavenjava.FlightConfirmationPage;
import rahulselenium.Mavenjava.FlightFinderPage;
import rahulselenium.Mavenjava.LoginPage;
import rahulselenium.Mavenjava.SelectFlightPage;
 
public class TestCaseClass extends HelperClass {
 
public TestCaseClass(){
}
 
@Test
public void returnTicket() {
try {
System.out.println("in returnTicket");
driver.get("<a href='http://newtours.demoaut.com/'>http://newtours.demoaut.com/</a>");
LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
loginPage.loginWordPress("mercury", "mercury");
FlightFinderPage flightFinderpage = PageFactory.initElements(driver, FlightFinderPage.class);
flightFinderpage.continueWordPress("1","Zurich","July","12","Frankfurt","September","15","Business Class","Unified Airlines");
SelectFlightPage selectFlightPage = PageFactory.initElements(driver, SelectFlightPage.class);
selectFlightPage.departAirlineWordPress("Pangaea Airlines 362");
selectFlightPage.returnAirlineWordPress("Unified Airlines 363");
selectFlightPage.continu();
BookFlightPage bookFlightPage = PageFactory.initElements(driver, BookFlightPage.class);
bookFlightPage.purchasePress("Anirudh", "AS", "Vegetarian", "MasterCard", "12345678", "12", "2008", "Anirudh", "A", "S");
FlightConfirmationPage flightConfirmationPage = PageFactory.initElements(driver, FlightConfirmationPage.class);
String bookingDetailsFile = System.getProperty("user.dir")+"\"+"ScreenShotsFlightConfirmationDetails - "+CaptureScreenShot.getDateTimeStamp()+".png";
try {CaptureScreenShot.getScreenShot(BrowserFactory.getDriver(), bookingDetailsFile);
} catch (Exception e) {e.printStackTrace();}
 
flightConfirmationPage.logoutPress();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
 
}
}