// default package

import java.sql.Timestamp;


/**
 * Page entity. @author MyEclipse Persistence Tools
 */

public class Page  implements java.io.Serializable {


    // Fields    

     private String id;
     private User user;
     private PageType pageType;
     private String contents;
     private Timestamp time;


    // Constructors

    /** default constructor */
    public Page() {
    }

    
    /** full constructor */
    public Page(User user, PageType pageType, String contents, Timestamp time) {
        this.user = user;
        this.pageType = pageType;
        this.contents = contents;
        this.time = time;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public PageType getPageType() {
        return this.pageType;
    }
    
    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public String getContents() {
        return this.contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
   








}