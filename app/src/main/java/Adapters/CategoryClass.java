package Adapters;

public class CategoryClass {

    private String CategoryID;

    private String CategoryName;

    public CategoryClass(String categoryID, String categoryName) {
        CategoryID = categoryID;
        CategoryName = categoryName;
    }

    public CategoryClass() {

    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
