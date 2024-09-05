package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnecter extends SQLiteOpenHelper {

    public DBConnecter(Context context){super(context, "Cupcake Factory 3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usersTable(Username VARCHAR PRIMARY KEY NOT NULL, Password VARCHAR NOT NULL,user_type VARCHAR)");
        db.execSQL("CREATE TABLE categoryTable(categoryID VARCHAR PRIMARY KEY NOT NULL,categoryName VARCHAR NOT NULL)");
        db.execSQL("CREATE TABLE cupcakeTable(cupcakeID VARCHAR PRIMARY KEY NOT NULL,cupcakeName VARCHAR,categoryID VARCHAR,cupcakePrice INTEGER NOT NULL,cupcakeQuantity INTEGER,FOREIGN KEY(categoryID)REFERENCES categoryTable(categoryID))");
        db.execSQL("CREATE TABLE ordersTable(orderID VARCHAR PRIMARY KEY NOT NULL,cupcakeID VARCHAR NOT NULL,userName VARCHAR NOT NULL, Quantity INTEGER,Total INTEGER,FOREIGN KEY(cupcakeID) REFERENCES cupcakeTable(cupcakeID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
