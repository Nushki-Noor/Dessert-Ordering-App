package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.R;

import Adapters.CategoryClass;
import Database.DBHelper;

public class CreateCategory extends AppCompatActivity {

    EditText EditTextCategoryID, EditTextCategoryName;

    Button buttonAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);

        EditTextCategoryID= findViewById(R.id.txtCatID);
        EditTextCategoryName= findViewById(R.id.txtCatName);
        buttonAddCategory= findViewById(R.id.btnAddCat);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        buttonAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditTextCategoryID.getText().toString().isEmpty() ||
                        EditTextCategoryName.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields Cannot be Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    CategoryClass category = new CategoryClass(
                            EditTextCategoryID.getText().toString(),
                            EditTextCategoryName.getText().toString());

                    if (dbHelper.CreateNewCategory(category)) {
                        Toast.makeText(getApplicationContext(),"Category Added",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Failed Adding a Category",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}