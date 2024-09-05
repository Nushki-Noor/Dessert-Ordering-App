package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.R;

import Database.DBHelper;

public class DeleteCategory extends AppCompatActivity {

    EditText EditTextCatDelete;

    Button buttonCatDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_category);

        EditTextCatDelete= findViewById(R.id.txtCatDelete);
        buttonCatDelete= findViewById(R.id.btnCatDelete);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        buttonCatDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CategoryID= EditTextCatDelete.getText().toString();

                if (CategoryID.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter the Category ID", Toast.LENGTH_LONG).show();
                }
                else {
                    dbHelper.deleteCategory(CategoryID);
                    Toast.makeText(getApplicationContext(),CategoryID+" ID is Deleted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), ManageCategory.class);
                    startActivity(intent);
                }
            }
        });

    }
}