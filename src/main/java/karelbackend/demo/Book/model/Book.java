package karelbackend.demo.Book.model;

public class Book {

    private String title;
    private boolean inColor;
    private int numberInStock;
    private double price;

    public Book(String title,int numberInStock,double price, boolean inColor){
        this.title = title;
        this.numberInStock = numberInStock;
        this.price = price;
        this.inColor = inColor;
    }

    public String getTitle(){
        return title;
    }
    public boolean getinColor(){
        return inColor;
    }
    public int getnumberInStock(){
        return numberInStock;
    }
    public double getPrice(){
        return price;
    }
    public double getPriceInDollar(){
        return price*1.06;
    }
}
