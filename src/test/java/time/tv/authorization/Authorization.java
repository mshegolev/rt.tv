package time.tv.authorization;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by myname on 04.02.17.
 */
public class Authorization {
    private final String pathToConfig = "/Users/myname/IdeaProjects/FunctionalTests/src/test/resources/roles.json";


    //   @BeforeMethod
//    public void initPageObjects() {
//        homepage = PageFactory.initElements(driver, Home.class);
//    }


    @Test
    public void testHomePageHasAHeader() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(
                new FileReader(pathToConfig));
        System.out.println(br.toString());

    }
}
