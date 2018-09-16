package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import util.PropertiesReader;

import java.lang.reflect.InvocationTargetException;

public class MyPageFactory  {

    public static <T extends Page> T getPage(WebDriver driver, Class<T> pageClass) throws Exception {
        T page = instantiatePage(driver, pageClass);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PropertiesReader.getTimeOut()), page);
        page.driver = driver;
        if(!page.isOnThisPage()) {
            page.tryToOpen();
            if(!page.isOnThisPage()) {
                throw new Error("Can't open Page" + pageClass);
            }
        }
        return page;
    }

    private static <T> T instantiatePage(WebDriver driver, Class <T> pageClassToProxy) {
        try {
            try {
                java.lang.reflect.Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException e) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}