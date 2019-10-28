package ui;
import java.util.Scanner;
import model.*;
public class Main{
    //atributtes
    private Scanner in;
    private Scanner num;
    private Reciclamos reciclamos;
    //methods
    public Main(){
        in = new Scanner(System.in);
        num = new Scanner(System.in);
        reciclamos = new Reciclamos();
    }
    public static void main(String args[]){
        Main obj = new Main();
        obj.run();
    }
    public void addResidue(){
        boolean cont = false;
        String composting="";
        String advise="";
        String recomendation="";
        String typeOfRecyclable="";
        Product productWaste=null;
             System.out.print("Enter the product of the residue come from: ");
            String nameProduct = in.nextLine();
            productWaste=reciclamos.searchProduct(nameProduct);
            if(productWaste==null){
                System.out.println("The product does not exist");
                productWaste=registerProduct(nameProduct);
            }
                System.out.print("What type of residue is(biodegradable,inert,recyclable): ");
                String type = in.nextLine();
                switch(type){
                    case ("biodegradable"): System.out.print("is the residue composting? ");
                    composting = in.nextLine();
                    break;
                    case ("inert"): System.out.print("Advise to trate this residue: ");
                    advise = in.nextLine();
                    break;
                    case ("recyclable"): System.out.print("Enter type of recyclable: ");
                    typeOfRecyclable = in.nextLine();
                    System.out.print("Enter the recomendation: ");
                    recomendation = in.nextLine();
                    break;
                    default:
                }
                System.out.print("Enter name of residue: ");
                String name = in.nextLine();
                System.out.print("Enter identifier of residue: ");
                String identifier = in.nextLine();
                System.out.println("Enter origin(industrial,domiciliary,municipal,construction,hospitable)of residue: ");
                String origin = in.nextLine();
                System.out.print("Enter color of residue: ");
                String color = in.nextLine();
                System.out.print("Enter time of residue in days: ");
                int time = num.nextInt();
                reciclamos.createWaste(identifier, name, origin, color, time,productWaste,type,composting,advise,typeOfRecyclable,recomendation);
                System.out.println("The residue was created!!");
        }    
        public void run(){
            boolean cont = false;
            for(int i=0;!cont;i++){
            System.out.println("----Menu----");
            System.out.println("1.Create residue");
            System.out.println("2.Create product");
            System.out.println("3.List of products");
            System.out.println("4.Search residue by identifier of product");
            System.out.println("5.Search residue by name");
            System.out.println("6.Calculate nocivility");
            System.out.println("7.Usable");
            System.out.println("8.Exist");
            System.out.println("9.Waste");
            int option = num.nextInt();
            switch(option){
                case 1: addResidue();
                break;
                case 2:  if(registerProduct()!=null)
                System.out.println("The product is created");
                else 
                System.out.println("The product is not created");
                break;
                case 3: if(reciclamos.listProducts()!=null)
                System.out.println(reciclamos.listProducts());
                else 
                System.out.println("The produts are not exist");
                break;
                case 4: System.out.println(searchIdentifier());
                break;
                case 5: System.out.println(searchResidue());
                break;
                case 6: System.out.println(nocivility());
                break;
                case 7: System.out.println(usable());
                break;
                case 8: cont=true; 
                break;
                case 9: System.out.println(reciclamos.showWaste());
                default:
            }
        }
        }
        public Product registerProduct(){
            System.out.print("Enter name of product: ");
            String nameProduct = in.nextLine();
            //validar si el producto ya existe
           if(reciclamos.validProduct(nameProduct)){
               System.out.println("This product exist");
           }
           else
            System.out.print("Enter identifier: ");
            String identifier = in.nextLine();
            System.out.println("Enter description: ");
            String description = in.nextLine();
            return reciclamos.createProduct(nameProduct, identifier, description);
        }
        public Product registerProduct(String nameProduct){
            //validar si el producto ya existe
            if(reciclamos.validProduct(nameProduct)){
                System.out.println("This product exist");
            }
            else
            System.out.print("Enter identifier: ");
            String identifier = in.nextLine();
            System.out.println("Enter description: ");
            String description = in.nextLine();
            return reciclamos.createProduct(nameProduct, identifier, description);
        }
        public String searchResidue(){
            String information = "";
            System.out.print("Enter the name of residue: ");
            String searchResidue = in.nextLine();
            Waste w=reciclamos.searchWasteName(searchResidue);
            if(w!=null){
                information=w.toString();
            }
            else 
            information="This residue does not exist";
            return information;
        }
        public Waste searchIdentifier(){
            Waste w = null;
            System.out.print("Enter the identifier of product: ");
            String identifier= in.nextLine();
            if(reciclamos.searchIdentifier(identifier)!=null){
                w=reciclamos.searchIdentifier(identifier);
            }else
            System.out.println("this residue does not exist");
            return w; 
        }
        public String listProducts(){
            return reciclamos.listProducts();
        }
        public double nocivility(){
            System.out.print("Enter de name of residue that you want calculate nocivility: ");
            String nameResdiue= in.nextLine();
           return reciclamos.nocivilityResidue(nameResdiue); 
         }
         public boolean usable(){
             System.out.println("Enter de residue biodegradable or recyclable that you want know usable");
             String nameWaste = in.nextLine();
             boolean usable = reciclamos.usableResidue(nameWaste);
             return usable;
         }
    }
