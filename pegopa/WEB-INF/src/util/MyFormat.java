package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFormat {

	private Date posted_at;

	public Date getPosted_at() {
		return this.posted_at;
	}

	public String getFormatedDate() {

		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
		String formatedDate = simpledateformat.format(this.posted_at);

		return formatedDate;
	}

}
