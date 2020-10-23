package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        registerForContextMenu(listView);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();
        customAdapter = new CustomAdapter(context,countriesData);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,countriesData.get(position).getTieuDe(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateCountriesData() {
        //country 1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Android");
        countriesModel.setImage(R.drawable.android);
        countriesModel.setTieuDePhu("4,000,000 VNĐ");
        countriesData.add(countriesModel);


        //country 2
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("C/C++");
        countriesModel.setImage(R.drawable.c);
        countriesModel.setTieuDePhu("5,999,000 VNĐ");
        countriesData.add(countriesModel);

        //country 3
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Java");
        countriesModel.setImage(R.drawable.java);
        countriesModel.setTieuDePhu("7,999,000 VNĐ");
        countriesData.add(countriesModel);

        //country 4
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Python");
        countriesModel.setImage(R.drawable.python);
        countriesModel.setTieuDePhu("4,999,000 VNĐ");
        countriesData.add(countriesModel);


        //country 5
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("PHP");
        countriesModel.setImage(R.drawable.php);
        countriesModel.setTieuDePhu("6,999,000 VNĐ");
        countriesData.add(countriesModel);

        //country 6
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("IOS");
        countriesModel.setImage(R.drawable.ios);
        countriesModel.setTieuDePhu("5,999,000 VNĐ");
        countriesData.add(countriesModel);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        menu.setHeaderTitle("Menu context");
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
            countriesData.remove(info.position);
            customAdapter.notifyDataSetChanged();
            return  true;
            case R.id.add:
            countriesData.add(info.position,countriesModel);
             customAdapter.notifyDataSetChanged();
            return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}