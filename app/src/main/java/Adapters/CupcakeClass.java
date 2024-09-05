package Adapters;

public class CupcakeClass {

    private String CupcakeID;

    private String CupcakeName;

    private int CupcakePrice;

    private int CupcakeQuantity;

    private String CategoryID;

    public CupcakeClass() {
    }

    public CupcakeClass(String cupcakeID, String cupcakeName, int cupcakePrice, int cupcakeQuantity, String categoryID) {
        CupcakeID = cupcakeID;
        CupcakeName = cupcakeName;
        CupcakePrice = cupcakePrice;
        CupcakeQuantity = cupcakeQuantity;
        CategoryID = categoryID;
    }

    public String getCupcakeID() {
        return CupcakeID;
    }

    public void setCupcakeID(String cupcakeID) {
        CupcakeID = cupcakeID;
    }

    public String getCupcakeName() {
        return CupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        CupcakeName = cupcakeName;
    }

    public int getCupcakePrice() {
        return CupcakePrice;
    }

    public void setCupcakePrice(int cupcakePrice) {
        CupcakePrice = cupcakePrice;
    }

    public int getCupcakeQuantity() {
        return CupcakeQuantity;
    }

    public void setCupcakeQuantity(int cupcakeQuantity) {
        CupcakeQuantity = cupcakeQuantity;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }
}
