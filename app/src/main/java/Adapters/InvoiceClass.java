package Adapters;

public class InvoiceClass {

    private String orderId;
    private String cupcakeId;
    private String userName;
    private int Quantity;
    private int total;

    public InvoiceClass() {
    }

    public InvoiceClass(String orderId, String cupcakeId, String userName, int quantity, int total) {
        this.orderId = orderId;
        this.cupcakeId = cupcakeId;
        this.userName = userName;
        Quantity = quantity;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCupcakeId() {
        return cupcakeId;
    }

    public void setCupcakeId(String cupcakeId) {
        this.cupcakeId = cupcakeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
