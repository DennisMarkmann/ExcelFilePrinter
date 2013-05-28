package Storage;

import java.util.Date;
import java.util.List;

public class Pojo {

    private String path = System.getProperty("user.home") + "\\Desktop\\" + "/Test.xlsx";
    private Date dateKey;
    private String searchKey;
    private List<String> contentList;
    private List<Entry> entryList;

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public List<String> getContentList() {
        return this.contentList;
    }

    public void setContentList(final List<String> contentList) {
        this.contentList = contentList;
    }

    public String getSearchKey() {
        return this.searchKey;
    }

    public void setSearchKey(final String searchKey) {
        this.searchKey = searchKey;
    }

    public Date getDateKey() {
        return this.dateKey;
    }

    public void setDateKey(final Date dateKey) {
        this.dateKey = dateKey;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

}
