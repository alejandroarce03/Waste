package model;
public class Reciclamos{
    //constants
    public static final int MAXWASTE=500;
    public static final int MAXPRODUCT=200;
    //atributtes
    private Waste[] residue;
    private Product[] products;
    //methods
    public Reciclamos(){
        residue = new Waste[MAXWASTE];
        products = new Product[MAXPRODUCT];
    }
    public void createWaste(String identifier,String name,String origin,String color,int time,Product product,String type,String composting,String advise,String typeOfRecyclable,String recomendation){
        Waste residuo=null;
        boolean cont = false;
        for(int i=0;i<residue.length && !cont ;i++){
            if(residue[i]!=null){
                    switch(type){
                        case("biodegradable"):  residuo = new Biodegradable(identifier,name,origin,color,time,product,composting);
                        residue[i]=residuo;
                        cont = true;
                        break;
                        case("inert"):  residuo = new Inert(identifier,name,origin,color,time,product,advise);
                        residue[i]=residuo;
                        cont = true;
                        break; 
                        case("recyclable"):  residuo = new Recyclable(identifier,name,origin,color,time,product,type,recomendation);
                        residue[i]=residuo;
                        cont = true;
                        break;
                        default: 
                    }
            }
         }
     }
     public boolean validProduct(String nameProduct){
         boolean valid=false;
         for(int i=0;i<products.length;i++){
             if(products[i]!=null){
                 if(nameProduct.equals(products[i].getName())){
                    valid= true;
                 }
             }
         }
         return valid;
     }
     public Product createProduct(String nameProduct,String identifierProduct,String description){
         Product product=null;
         for(int i=0;i<products.length;i++){
             if(products[i]==null){
                 product = new Product(identifierProduct,nameProduct,description);
                 products[i] = product;
             }
         }
         return product;
     }
     public Product searchProduct(String nameProduct){
         Product p=null;
         boolean valid=false;
         for(int i=0;i<products.length && !valid ;i++){
            if(products[i]!=null){
                if(nameProduct.equals(products[i].getName())){
                   valid= true;
                   products[i]=p;
                }
            }
        }
         return p;
     }
     public String showWaste(){
         String showWaste="";
         String showBiodegradable ="";
	showBiodegradable=" Biodegradable ";
         for(int i=0;i<residue.length;i++){
             if(residue[i]!=null){
                 if(residue[i] instanceof Biodegradable){
                     showBiodegradable+=((Biodegradable)residue[i]).toString();
                 }
             }
         }
	String showRecyclable=" Recyclable ";
         for(int i=0;i<residue.length;i++){
             if(residue[i]!=null){
                 if(residue[i] instanceof Recyclable){
                     showRecyclable+=((Recyclable)residue[i]).toString();
                 }
             }
         }
	String showInert=" Inert ";
	for(int i=0;i<residue.length;i++){
             if(residue[i]!=null){
                 if(residue[i] instanceof Inert){
                     showInert+=((Inert)residue[i]).toString();
                 }
             }
         }
	showWaste = showBiodegradable + showRecyclable + showInert;
	return showWaste;
     }
     public Waste searchWasteName(String searchResidue){
         Waste waste= null;
         for(int i=0;i<residue.length;i++){
            if(residue[i]!=null){
                if(residue[i].getName().equals(searchResidue)){
                    waste=residue[i];
                }
            }
         }
         return waste;
     }
     public Waste searchIdentifier(String identifier){
         Waste residues= null;
         for(int i=0;i<products.length;i++){
             if(products[i]!=null){
                 if(identifier.equalsIgnoreCase(products[i].getIdentifier())){
                     for(int j=0;j<residue.length;j++){
                         if(residue[j]!=null){
                            if(residue[j].getNameOfProduct().equalsIgnoreCase(products[i].getName()))
                                residue[j]=residues;
                         }
                     }
                 }
             }
         }
         return residues;
     }
     public String listProducts(){
         String list = "";
         for(int i = 0; i<products.length;i++){
             if(products[i]!=null){
                 list+=products[i].getName();
             }
         }
         return list;
     }
     public double nocivilityResidue(String nameResidue){
         double nocivityResidue=0;
         for(int i=0;i<residue.length;i++){
             if(residue[i]!=null){
                 if(residue[i].getName().equalsIgnoreCase(nameResidue)){
                     nocivityResidue= residue[i].calculateNocivility();
                 }
             }
         }
         return nocivityResidue;
     }
     public boolean usableResidue(String nameWaste){
         boolean usable=false;
         for(int i=0;i<residue.length;i++){
             if(residue[i]!=null){
                 if(residue[i].getName().equalsIgnoreCase(nameWaste)){
                    if(residue[i] instanceof Biodegradable){
                        usable=((Biodegradable)residue[i]).usableBiodegradable();
                    }
                    if(residue[i] instanceof Recyclable){
                        usable=((Recyclable)residue[i]).usableRecyclable();
                    }
                 }
             }
         }
         return usable;
     }
     public double listWasteNocivility(){
         double nocivityResidue=0;
         double[] list = new double[MAXWASTE];
         for(int i=0;i<residue.length;i++){
            if(residue[i]!=null){
                 nocivityResidue=residue[i].calculateNocivility();
                nocivityResidue=list[i];
            }
         }
         return nocivityResidue;
     }
}