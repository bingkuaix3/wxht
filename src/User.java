// default package

import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private String id;
     private String username;
     private String password;
     private String headimg;
     private String company;
     private String applyid;
     private String applysecret;
     private String token;
     private String wxname;
     private Set resources = new HashSet(0);
     private Set pages = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String username, String password, String headimg, String company, String applyid, String applysecret, String token, String wxname, Set resources, Set pages) {
        this.username = username;
        this.password = password;
        this.headimg = headimg;
        this.company = company;
        this.applyid = applyid;
        this.applysecret = applysecret;
        this.token = token;
        this.wxname = wxname;
        this.resources = resources;
        this.pages = pages;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadimg() {
        return this.headimg;
    }
    
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }

    public String getApplyid() {
        return this.applyid;
    }
    
    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getApplysecret() {
        return this.applysecret;
    }
    
    public void setApplysecret(String applysecret) {
        this.applysecret = applysecret;
    }

    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public String getWxname() {
        return this.wxname;
    }
    
    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public Set getResources() {
        return this.resources;
    }
    
    public void setResources(Set resources) {
        this.resources = resources;
    }

    public Set getPages() {
        return this.pages;
    }
    
    public void setPages(Set pages) {
        this.pages = pages;
    }
   








}