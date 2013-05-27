package ExcelFilePrinter;

import java.util.Date;
import java.util.List;

public class Pojo {

    private String path = System.getProperty("user.home") + "\\Desktop\\" + "/Test.xlsx";
    private Date dateKey;
    private String searchKey;

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
        return dateKey;
    }

    public void setDateKey(Date dateKey) {
        this.dateKey = dateKey;
    }

    private List<String> contentList;

}
