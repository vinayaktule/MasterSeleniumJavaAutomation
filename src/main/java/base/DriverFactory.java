package base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static DriverFactory instance = null;

    private DriverFactory(){}

    public static DriverFactory getInstance(){
        if(instance==null){
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return webDriver.get();
    }

    public void setDriver(WebDriver driver){
        webDriver.set(driver);
        System.out.println("Driver is initiated");
    }

    public static WebDriver getCurrentDriver(){
        return getInstance().getDriver();
    }

    /*
    private static final ThreadLocal<String> str = new ThreadLocal<String>();
    public static String getString(){
        return str.get();
    }

    public static void setString(String string){
        str.set(string);
    }

    public static void main(String[] args) {
        DriverFactory.setString("Setting string value");
        System.out.println(DriverFactory.getString());
        DriverFactory.setString("Setting string value Again");
        System.out.println(DriverFactory.getString());
        //This approach break singleton class in framework
    } */


}
