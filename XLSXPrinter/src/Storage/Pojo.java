package Storage;

import java.util.Date;
import java.util.List;

public class Pojo {

    private String path = System.getProperty("user.home") + "\\Desktop\\" + "/Test.xlsx";
    private Date dateKey;
    private String searchKey;
    private List<Entry> entryList;

    public final String getPath() {
        return this.path;
    }

    public final void setPath(final String path) {
        this.path = path;
    }

    public final String getSearchKey() {
        return this.searchKey;
    }

    public final void setSearchKey(final String searchKey) {
        this.searchKey = searchKey;
    }

    public final Date getDateKey() {
        return this.dateKey;
    }

    public final void setDateKey(final Date dateKey) {
        this.dateKey = dateKey;
    }

    public final List<Entry> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(final List<Entry> entryList) {
        this.entryList = entryList;
    }

}
