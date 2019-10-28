package model;
public abstract class Waste {
    //constants
    public static final String INDUSTRIAL = "industrial";
    public static final String DOMICILIARY = "domiciliary";
    public static final String MUNICIPAL = "municipal";
    public static final String CONSTRUCTION = "construction";
    public static final String HOSPITABLE = "hospitable";
    public static final double NINDUSTRIAL = 0.1;
    public static final double NDOMICILIARY = 0.05;
    public static final double NMUNICIPAL = 0.12;
    public static final double NCONSTRUCTION = 0.08;
    public static final double NHOSPITABLE = 0.15;
    //atributtes
    private String identifier;
    private String name;
    private String origin;
    private String color;
    private int time;
    private Product product;
    private double nocivility;
    //methods
    public Waste(String identifier,String name,String origin,String color,int time,Product product){
        this.identifier = identifier;
        this.name = name;
        this.origin = origin;
        this.color = color; 
        this.product = product;
        this.time = time;
    }

    public String getIdentifier() 
    {
        return this.identifier;
    }

    public String getName() 
    {
        return this.name;
    }

    public String getOrigin() 
    {
        return this.origin;
    }

    public String getColor() 
    {
        return this.color;
    }

    public int getTime() 
    {
        return this.time;
    }
    public String toString(){
        String string = name+" - "+origin+" - "+color+" - "+time+" - "+product+" -";
        return string;
    }
    public String getNameOfProduct(){
        String string ="";
        string=product.getName();
        return string;
    }
    public double calculateNocivility() {
        if(origin.equalsIgnoreCase("industrial")){
            nocivility=time*NINDUSTRIAL;
        }
        if(origin.equalsIgnoreCase("domiciliary")){
            nocivility=time*NDOMICILIARY;
        }
        if(origin.equalsIgnoreCase("municipal")){
            nocivility=time*NMUNICIPAL;
        }
        if(origin.equalsIgnoreCase("construction")){
            nocivility=time*NCONSTRUCTION;
        }
        if(origin.equalsIgnoreCase("hospitable")){
            nocivility=time*NHOSPITABLE;
        }
        return nocivility;
    }
}