package qaframework.rtv.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import qaframework.rtv.fw.ApplicationManager;

public class TestBase {
	//protected Logger log = Logger.getLogger("TEST");
	protected ApplicationManager app;

	@BeforeClass
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }


    //	@BeforeClass
//	@Parameters({"configFile"})
//	public void setUp(@Optional String configFile) throws Exception {
//		if (configFile == null) {
//			configFile = System.getProperty("configFile");
//		}
//		if (configFile == null) {
//			configFile = System.getenv("configFile");
//		}
//		if (configFile == null) {
//			configFile = "configure.properties";
//		}
//		Properties props = new Properties();
//		props.load(new FileReader(configFile));
//		log.info("setUp start");
//		app = new ApplicationManager();
//		//app.setProperties(props);
//		log.info("setUp end");
//	}
}
