package time.tv.util;

/**
 * Created by mikhail.shchegolev on 07.04.2017.
 */

import com.getsentry.raven.Raven;
import com.getsentry.raven.RavenFactory;
import com.getsentry.raven.dsn.Dsn;
import com.getsentry.raven.event.Event;
import com.getsentry.raven.event.EventBuilder;
import com.getsentry.raven.event.interfaces.ExceptionInterface;

public class MyClass2 {
    private static Raven raven;

    public void MyClass2() {
        // Creation of the client with a specific DSN
        //String dsn = args[0];
        String dsn = "https://9c47336df8644e4fb12801571b733a1c:ac3f17e839cb4ef6aa286d00942758bd@sentry.io/64942";
        raven = RavenFactory.ravenInstance(dsn);

        // It is also possible to use the DSN detection system, which
        // will check the environment variable "SENTRY_DSN" and the Java
        // System Property "sentry.dsn".
        raven = RavenFactory.ravenInstance();

        // Advanced: specify the ravenFactory used
        raven = RavenFactory.ravenInstance(new Dsn(dsn), "com.getsentry.raven.DefaultRavenFactory");
    }

    void logSimpleMessage() {
        // This sends an event to Sentry
        EventBuilder eventBuilder = new EventBuilder()
                .withMessage("This is a test")
                .withLevel(Event.Level.INFO)
                .withLogger(MyClass.class.getName());
        raven.sendEvent(eventBuilder);
    }

    void logException() {
        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry
            EventBuilder eventBuilder = new EventBuilder()
                    .withMessage("Exception caught")
                    .withLevel(Event.Level.ERROR)
                    .withLogger(MyClass.class.getName())
                    .withSentryInterface(new ExceptionInterface(e));
            raven.sendEvent(eventBuilder);
        }
    }

    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this!");
    }
}
