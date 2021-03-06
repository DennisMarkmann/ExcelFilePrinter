package dennis.markmann.ExcelFilePrinter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dennis.markmann.ExcelFilePrinter.Exceptions.SearchKeyNotFoundExpception;
import dennis.markmann.ExcelFilePrinter.Storage.Entry;
import dennis.markmann.ExcelFilePrinter.Storage.Pojo;


class ContentFilter {

    final void filterContent(final Pojo pojo) {

        final String searchString = pojo.getSearchKey();
        final Date dateKey = pojo.getDateKey();
        String searchKeyString = "";
        String dateKeyString = "";
        final List<Entry> filteredEntryList = new ArrayList<Entry>();

        if ((searchString == null || searchString.equals("")) && (dateKey == null || dateKey.equals(""))) {
            new SearchKeyNotFoundExpception("SearchKey oder Datum muss gefüllt sein.").showDialog();
            new ProgrammRestarter().reStart(pojo);
            return;
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
            new ProgrammRestarter().reStart(pojo);
            return;
        }
        pojo.setEntryList(filteredEntryList);
        new PrintJob(null).printText(pojo);
    }
}
