// default package

import java.util.HashSet;
import java.util.Set;


/**
 * ResourceType entity. @author MyEclipse Persistence Tools
 */

public class ResourceType  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private Set resources = new HashSet(0);


    // Constructors

    /** default constructor */
    public ResourceType() {
    }

	/** minimal constructor */
    public ResourceType(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public ResourceType(String name, Set resources) {
        this.name = name;
        this.resources = resources;
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

    public Set getResources() {
        return this.resources;
    }
    
    public void setResources(Set resources) {
        this.resources = resources;
    }
   








}