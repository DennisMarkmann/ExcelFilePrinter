package XLSXPrinter;

import java.util.ArrayList;
import java.util.List;

public class ContentFilter {

    public void filterContent(final Pojo pojo) {

        final String searchString = pojo.getSearchKey();
        if (searchString.equals("") || searchString == null) {
            new SearchKeyNotFoundExpception("SearchKey muss gefüllt sein.").showDialog();
            return;
        }
        final List<String> filteredContentList = new ArrayList<String>();

        for (final String entry : pojo.getContentList()) {
            if (entry.contains(searchString)) {
                filteredContentList.add(entry);
            }
        }
        if (filteredContentList.size() == 0) {
            new SearchKeyNotFoundExpception("SearchKey nicht gefunden.").showDialog();
            return;
        }
        pojo.setContentList(filteredContentList);
        new PrintJob(null).printText(pojo);
    }
}
