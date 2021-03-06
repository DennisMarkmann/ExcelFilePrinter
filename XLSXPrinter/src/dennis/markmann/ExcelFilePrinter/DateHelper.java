package dennis.markmann.ExcelFilePrinter;

import java.util.Date;

class DateHelper {

    @SuppressWarnings("deprecation")
    final String getDateString(final Date dateKey) {
        final StringBuilder dateString = new StringBuilder();
        if ((dateKey.getDate() + "").length() == 1) {
            dateString.append("0");
        }
        dateString.append(dateKey.getDate()).append(".");
        if ((dateKey.getMonth() + "").length() == 1) {
            dateString.append("0");
        }
        dateString.append(dateKey.getMonth() + 1).append(".");
        dateString.append("20").append((dateKey.getYear() + "").substring(1, 3));

        return dateString.toString();
    }
}
