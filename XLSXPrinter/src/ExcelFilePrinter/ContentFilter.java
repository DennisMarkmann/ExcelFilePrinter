package ExcelFilePrinter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exceptions.SearchKeyNotFoundExpception;
import Storage.Entry;
import Storage.Pojo;

public class ContentFilter {

    public final void filterContent(final Pojo pojo) {

        final String searchString = pojo.getSearchKey();
        final Date dateKey = pojo.getDateKey();
        String searchKeyString = "";
        String dateKeyString = "";
        final List<Entry> filteredEntryList = new ArrayList<Entry>();

        if ((searchString == null || searchString.equals("")) && (dateKey == null || dateKey.equals(""))) {
            new SearchKeyNotFoundExpception("SearchKey oder Datum muss gefüllt sein.").showDialog();
            System.exit(1);

        } else if (searchString != null && !searchString.equals("")) {
            searchKeyString = searchString;
        } else if (dateKey != null && !dateKey.equals("")) {
            dateKeyString = new DateHelper().getDateString(dateKey);
        }
        if (!searchKeyString.equals("") && searchKeyString != null) {
            for (final Entry entry : pojo.getEntryList()) {

                if (entry.getId().toLowerCase().trim().equals(searchKeyString.toLowerCase().trim())) {
                    filteredEntryList.add(entry);
                }
            }
        } else if (!dateKeyString.equals("") && dateKeyString != null) {
            for (final Entry entry : pojo.getEntryList()) {

                if (entry.getEingelagert().equals(dateKeyString)) {
                    filteredEntryList.add(entry);
                }
            }
        }
        if (filteredEntryList.size() == 0) {
            new SearchKeyNotFoundExpception("SearchKey nicht gefunden.").showDialog();
            System.exit(1);
        }
        pojo.setEntryList(filteredEntryList);
        new PrintJob(null).printText(pojo);
    }
    // @SuppressWarnings("deprecation")
    // public String getDateString(final Date dateKey) {
    // final StringBuilder searchKey = new StringBuilder();
    // searchKey.append(dateKey.getDate()).append(".");
    // if ((dateKey.getMonth() + "").length() == 1) {
    // searchKey.append("0");
    // }
    // searchKey.append(dateKey.getMonth() + 1).append(".");
    // searchKey.append("20").append((dateKey.getYear() + "").substring(1, 3));
    //
    // return searchKey.toString();
    // }
}
