package model;
public class Recyclable extends Waste{
    //constants
    public static final String plastic = "plastic";
    public static final String metal = "metal";
    public static final String glass = "glass";
    public static final String paperboard = "paperboard";
    public static final String paper = "paper";
    //atributtes
    private String type;
    private String recomendation;
    private boolean usable;
    //methods
    public Recyclable(String identifier,String name,String origin,String color,int time,Product product,String type,String recomendation){
        super(identifier,name,origin,color,time,product);
        this.type = type;
        this.recomendation = recomendation;
    }
    public String toString(){
        String string =super.toString()+"type: "+type+" recomendation: "+recomendation;
        return string;
    }
    public boolean usableRecyclable(){
        if(recomendation==null){
            usable = false;
        } 
        else
        usable=true;
        return usable;
    }
}