package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobileapp.R;

import java.util.List;

public class CakeSingleRow extends ArrayAdapter<CupcakeClass> {

    private  Context context;
    private  int resource;
    private List<CupcakeClass> cupcakeClassList;
    public CakeSingleRow(@NonNull Context context, int resource, List<CupcakeClass> cupcakeClassList) {
        super(context, resource, cupcakeClassList);
        this.context = context;
        this.resource = resource;
        this.cupcakeClassList = cupcakeClassList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView txtCup = row.findViewById(R.id.txtCup);
        TextView txtCup2 = row.findViewById(R.id.txtCup2);

        CupcakeClass cupcakeClass = cupcakeClassList.get(position);

        txtCup.setText(cupcakeClass.getCupcakeID());
        txtCup2.setText(cupcakeClass.getCupcakeName());

        return row;
    }
}
