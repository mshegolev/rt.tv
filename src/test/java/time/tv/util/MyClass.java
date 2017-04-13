package time.tv.util;

/**
 * Created by mikhail.shchegolev on 07.04.2017.
 */
import com.getsentry.raven.Raven;
import com.getsentry.raven.RavenFactory;
import com.getsentry.raven.event.BreadcrumbBuilder;
import com.getsentry.raven.event.Breadcrumbs;

public class MyClass {
    private static Raven raven;

    public static void main(String... args) {
        // Creation of the client with a specific DSN
        //String dsn = args[0];
        String dsn = "https://9c47336df8644e4fb12801571b733a1c:ac3f17e839cb4ef6aa286d00942758bd@sentry.io/64942";
        raven = RavenFactory.ravenInstance(dsn);

        // Or, if you don't provide a DSN,
      //  raven = RavenFactory.ravenInstance();

        // It is also possible to use the DSN detection system, which
        // will check the environment variable "SENTRY_DSN" and the Java
        // System Property "sentry.dsn".
        //raven = RavenFactory.ravenInstance();

    }

    public static void logSimpleMessage() {
        // This sends a simple event to Sentry
        raven.sendMessage("This is a test GG");
    }

    void logWithBreadcrumbs() {
        // Record a breadcrumb that will be sent with the next event(s),
        // by default the last 100 breadcrumbs are kept.
        Breadcrumbs.record(
                new BreadcrumbBuilder().setMessage("User made an action").build()
        );

        // This sends a simple event to Sentry
        raven.sendMessage("This is a test");
    }

    void logException() {
        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry
            raven.sendException(e);
        }
    }

    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this!");
    }
}
