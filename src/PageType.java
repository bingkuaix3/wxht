// default package

import java.util.HashSet;
import java.util.Set;


/**
 * PageType entity. @author MyEclipse Persistence Tools
 */

public class PageType  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private Set pages = new HashSet(0);


    // Constructors

    /** default constructor */
    public PageType() {
    }

	/** minimal constructor */
    public PageType(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public PageType(String name, Set pages) {
        this.name = name;
        this.pages = pages;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getPages() {
        return this.pages;
    }
    
    public void setPages(Set pages) {
        this.pages = pages;
    }
   








}