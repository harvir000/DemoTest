package utilsPckg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;

import com.google.common.base.Function;


public class WebElementWait extends FluentWait<WebElement> {
	
	public final static long DEFAULT_SLEEP_TIMEOUT = 500;

    public WebElementWait(WebElement element, long timeOutInSeconds) {
          this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
    }

    public WebElementWait(WebElement element, long timeOutInSeconds, long sleepInMillis) {
          this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
    }

    protected WebElementWait(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds, long sleepTimeOut) {
          super(element, clock, sleeper);
          withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
          pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
          ignoring(NotFoundException.class);
    }
    
    public boolean isValid(WebElement e) {
        try {
            WebElementWait wait = new WebElementWait(e, 1);
            wait.until(new Function<WebElement, WebElement>() {
                        public WebElement apply(WebElement d) {
                            return d.findElement(By.xpath("./following-sibling::div[class='invalid-icon']"));
                        }
                    });
            return false;
        } catch (TimeoutException exception) {
            return true;
        }
    }
 
	
}
