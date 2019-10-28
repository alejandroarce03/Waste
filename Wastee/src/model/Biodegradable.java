package model;
public class Biodegradable extends Waste{
    //constants
    public static final int YEAR=365;
    //to do apto compostaje o no apto
    //atributes
    private String composting;
    private boolean usable;
    //methods
    public Biodegradable(String identifier,String name,String origin,String color,int time,Product product,String composting){
     super(identifier,name,origin,color,time,product);
     this.composting = composting;   
    }
    public String toString(){
        String string =super.toString()+"composting: "+composting;
        return string;
    }
    public boolean usableBiodegradable(){
        if(super.getTime()<YEAR && composting.equalsIgnoreCase("yes")){
            usable=true;
        }
        else usable=false;
        return usable;
    }
}