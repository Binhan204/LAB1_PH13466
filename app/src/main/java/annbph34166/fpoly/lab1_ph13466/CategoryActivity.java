package annbph34166.fpoly.lab1_ph13466;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import annbph34166.fpoly.lab1_ph13466.Adapter.CatAdapter;
import annbph34166.fpoly.lab1_ph13466.DAO.CatDAO;
import annbph34166.fpoly.lab1_ph13466.DTO.CatDTO;
import annbph34166.fpoly.lab1_ph13466.R;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView rc_cat;
    CatAdapter adapter;
    CatDAO catDAO;
    ArrayList<CatDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        rc_cat = findViewById(R.id.rc_cat2);

        catDAO = new CatDAO(this);
        list = catDAO.getAllCat();

        adapter = new CatAdapter(this, list);
        rc_cat.setLayoutManager(new LinearLayoutManager(this));
        rc_cat.setAdapter(adapter);
    }
}
