package model;
public class Product {
    //atributtes
    private String identifier;
    private String name;
    private String description;
    //methods
    public Product(String identifier,String name,String description){
        this.identifier = identifier;
        this.name = name;
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public String getIdentifier(){
        return identifier;
    }
}