package model;
public class Inert extends Waste{
    //atributtes
    private String advise;
    //methods
    public Inert(String identifier,String name,String origin,String color,int time,Product product,String advise){
        super(identifier,name,origin,color,time,product);
        this.advise = advise;
    }
    public String toString(){
        String string =super.toString()+"advise: "+advise;
        return string;
    }
    
}