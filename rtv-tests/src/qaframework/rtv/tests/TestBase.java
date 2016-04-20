package qaframework.rtv.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import qaframework.rtv.fw.ApplicationManager;

public class TestBase {
	protected ApplicationManager app;

	@BeforeClass
	public void setUp() throws Exception {
		app = new ApplicationManager();

	}

	@AfterClass
	public void tearDown() throws Exception {
		app.stop();

	}

}
