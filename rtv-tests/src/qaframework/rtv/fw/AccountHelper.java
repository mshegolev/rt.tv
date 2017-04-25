package qaframework.rtv.fw;

import org.openqa.selenium.By;
import qaframework.rtv.tests.AccountData;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountHelper extends HelperBase {

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {

        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }
    };

    public AccountHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillLoginForm(ApplicationManager applicationManager,
                              AccountData accountData) {
        type(By.id("id__4_3"), accountData.username);
        type(By.id("id__4_4"), accountData.password);
    }

    public String getDayMonth() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd MMMM", myDateFormatSymbols);
        return dateFormat.format(currentDate);


    }

}
