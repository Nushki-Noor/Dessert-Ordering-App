package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Adapters.CategoryClass;
import Adapters.CupcakeClass;
import Adapters.InvoiceClass;
import Adapters.UserClass;

public class DBHelper {

    private Context context;

    private static SQLiteDatabase dbDatabase, readableDatabase;

    public DBHelper(Context context) {
        this.context = context;
    }

    public DBHelper OpenDB() {
        DBConnecter dbCon = new DBConnecter(context);
        dbDatabase = dbCon.getWritableDatabase();
        readableDatabase = dbCon.getReadableDatabase();
        return this;
    }

    public boolean CreateNewUser(UserClass userClass) {
        try {
            dbDatabase.execSQL("insert into usersTable values('" + userClass.getUsername() + "','" + userClass.getPassword() + "','" + userClass.getUserType() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<UserClass> ValidLogin(String Username, String Password) {
        ArrayList<UserClass> userList = new ArrayList<UserClass>();
        try {
            Cursor cursor = dbDatabase.rawQuery("Select * from usersTable where Username='" + Username + "' and Password ='" + Password + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    UserClass user = new UserClass();
                    user.setUsername(cursor.getString(0));
                    user.setPassword(cursor.getString(1));
                    user.setUserType(cursor.getString(2));
                    userList.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public boolean CreateNewCategory(CategoryClass categoryClass) {
        try {
            dbDatabase.execSQL("insert into categoryTable values('" + categoryClass.getCategoryID() + "','" + categoryClass.getCategoryName() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Vector<String> getCategoryName() {
        Vector<String> vecCategory = new Vector<String>();
        try {
            Cursor cursor = dbDatabase.rawQuery("Select categoryName from categoryTable ", null);
            if (cursor.moveToFirst()) {
                do {
                    vecCategory.add(cursor.getString(0));
                }
                while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vecCategory;
    }

    public String getCategoryID(String CategoryName) {
        String CategoryId = null;
        try {
            Cursor cursor = dbDatabase.rawQuery("Select CategoryID from categoryTable where categoryName='" + CategoryName + "'", null);
            if (cursor.moveToFirst()) {
                CategoryId = cursor.getString(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CategoryId;
    }

    public boolean CreateNewCupcake(CupcakeClass cupcakeClass) {
        try {
            dbDatabase.execSQL("INSERT INTO cupcakeTable VALUES ('" + cupcakeClass.getCupcakeID() + "','" + cupcakeClass.getCupcakeName() + "','" + cupcakeClass.getCategoryID() + "'," + cupcakeClass.getCupcakePrice() + "," + cupcakeClass.getCupcakeQuantity() + ")");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public void deleteCategory(String id) {
        dbDatabase.delete("categoryTable", "categoryID = ?", new String[]{id});
        dbDatabase.close();
    }

    public void deleteCupcake(String id) {
        dbDatabase.delete("cupcakeTable", "cupcakeID = ?", new String[]{id});
        dbDatabase.close();
    }

    public ArrayList<String> getAllCategory() {

        ArrayList<String> arrayList = new ArrayList<String>();

        Cursor cursor = dbDatabase.rawQuery("Select categoryName from categoryTable ", null);

        if (cursor.moveToFirst()) {
            do {
                arrayList.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public List<CupcakeClass> getSelectCake(String categoryId) {

        ArrayList<CupcakeClass> arrayList = new ArrayList<CupcakeClass>();

        Cursor cursor = dbDatabase.rawQuery("Select * from cupcakeTable where categoryID='"+ categoryId+"' ", null);

        if (cursor.moveToFirst()) {
            do {
                CupcakeClass cupcakeClass = new CupcakeClass();
                cupcakeClass.setCupcakeID(cursor.getString(0));
                cupcakeClass.setCupcakeName(cursor.getString(1));

                arrayList.add(cupcakeClass);

            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public void buyCupcake(String cupcakeId,int qty) {

        try
        {
            dbDatabase.execSQL("UPDATE cupcakeTable SET Quantity=quantity-"+ qty+ " WHERE cupcakeID='"+cupcakeId+"'");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public  boolean addOrder(InvoiceClass invoiceClass) {
        try {

            dbDatabase.execSQL("insert into ordersTable values('" + invoiceClass.getOrderId() +  "','" + invoiceClass.getCupcakeId()  + "','" + invoiceClass.getUserName()  + "','" + invoiceClass.getQuantity() + "','" + invoiceClass.getTotal() + "')");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<CupcakeClass> getBuyCakeDetails(String cakeId) {

        ArrayList<CupcakeClass> arrayList = new ArrayList<CupcakeClass>();

        Cursor cursor = dbDatabase.rawQuery("Select *  from cupcakeTable where cupcakeID='"+ cakeId+"' ", null);

        if (cursor.moveToFirst()) {
            do {
                CupcakeClass cupcakeClass = new CupcakeClass();
                cupcakeClass.setCupcakeID(cursor.getString(0));
                cupcakeClass.setCupcakeName(cursor.getString(1));
                cupcakeClass.setCupcakePrice(Integer.parseInt(cursor.getString(3)));
                cupcakeClass.setCupcakeQuantity(Integer.parseInt(cursor.getString(4)));

                arrayList.add(cupcakeClass);

            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    public List<InvoiceClass>  getAllOrders() {


        ArrayList<InvoiceClass> orderList = new ArrayList<InvoiceClass>();

        Cursor cursor = readableDatabase.rawQuery("select * from ordersTable", null);

        if (cursor.moveToFirst()) {
            do {
                InvoiceClass invoiceClass = new InvoiceClass();
                invoiceClass.setOrderId(cursor.getString(0));
                invoiceClass.setCupcakeId(cursor.getString(1));
                invoiceClass.setUserName(cursor.getString(2));
                invoiceClass.setQuantity(cursor.getInt(3));
                invoiceClass.setTotal(cursor.getInt(4));

                orderList.add(invoiceClass);
            } while (cursor.moveToNext());
        }return orderList;
    }

   public List<InvoiceClass> getAllCustOrder(String username) {


       ArrayList<InvoiceClass> orderList = new ArrayList<InvoiceClass>();

       try {
           Cursor cursor = readableDatabase.rawQuery("select * from ordersTable where username='" + username + "' ", null);

           if (cursor.moveToFirst()) {
               do {
                   InvoiceClass invoiceClass = new InvoiceClass();
                   invoiceClass.setOrderId(cursor.getString(0));
                   invoiceClass.setCupcakeId(cursor.getString(1));
                   invoiceClass.setUserName(cursor.getString(2));
                   invoiceClass.setQuantity(cursor.getInt(3));
                   invoiceClass.setTotal(cursor.getInt(4));

                   orderList.add(invoiceClass);
               } while (cursor.moveToNext());
           }
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
       return orderList;
   }
}
