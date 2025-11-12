package annbph34166.fpoly.lab1_ph13466;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import annbph34166.fpoly.lab1_ph13466.DAO.CatDAO;
import annbph34166.fpoly.lab1_ph13466.DTO.CatDTO;

public class MainActivity extends AppCompatActivity {
    CatDAO catDAO;
    static String TAG = "zzzzzzzzzzzzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        catDAO = new CatDAO(this);

        CatDTO catDTO = new CatDTO();
        catDTO.setName("Máy tinh");


        int kq = catDAO.addCat(catDTO);
        Log.d(TAG, "onCreate: "+kq);


        if(kq >0 ){
            Log.d(TAG, "onCreate: Thành công");
        }else{
            Log.d(TAG, "onCreate: Thất bại");
        }

    }
}