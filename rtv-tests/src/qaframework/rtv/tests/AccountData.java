package qaframework.rtv.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class AccountData {
	public String username;
	public String password;

	public AccountData() {
	}

	public AccountData(String username, String password) {
		this.username = username;
		this.password = password;
	}

}