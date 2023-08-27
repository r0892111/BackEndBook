package karelbackend.demo.Book.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
@Entity
@Table(name = "books")

public class Book {
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
   
    public long id;
    @NotBlank(message="Needs to be filled in")
    private String title;
    private boolean inColor;
    
    @Positive(message="age may not be negative")
    private int numberInStock;
    
    @Positive(message="age may not be negative")
    private double price;
    public Book(){}
    public Book(String title,int numberInStock,double price, boolean inColor){
        this.title = title;
        this.numberInStock = numberInStock;
        this.price = price;
        this.inColor = inColor;
    }

    public String getTitle(){
        return title;
    }
    public boolean isInColor(){
        return inColor;
    }
    public int getNumberInStock(){
        return numberInStock;
    }
    public double getPrice(){
        return price;
    }
    public double getPriceInDollar(){
        return price*1.06;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setNumberInStock(int numberInStock){
        this.numberInStock = numberInStock;
    }
    public void setInColor(boolean bool){
        this.inColor=bool;
    }
    public String toString(){
        String value = "";
        if(this.inColor){
            value = " is in color.";
        }else{
            value = " is not in color.";
        }
        return this.title+" costs €"+this.price+". There are "+this.numberInStock+" items present. The book"+value;
    }
}
