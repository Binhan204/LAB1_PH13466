package annbph34166.fpoly.lab1_ph13466;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import annbph34166.fpoly.lab1_ph13466.Adapter.CatAdapter;
import annbph34166.fpoly.lab1_ph13466.DAO.CatDAO;
import annbph34166.fpoly.lab1_ph13466.DTO.CatDTO;

public class MainActivity extends AppCompatActivity {
    CatDAO catDAO;
    static String TAG = "zzzzzzzzzzzzzz";

    RecyclerView rc_cat;
    ArrayList<CatDTO> list;
    CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnOpen = findViewById(R.id.btnOpenCategory);


        catDAO = new CatDAO(this);

        rc_cat = findViewById(R.id.rc_cat);
        catDAO = new CatDAO(this);
        CatDTO catDTO = new CatDTO();

        list = catDAO.getAllCat();
        adapter = new CatAdapter(this, list);
        rc_cat.setAdapter(adapter);

        btnOpen.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        });

    }

}