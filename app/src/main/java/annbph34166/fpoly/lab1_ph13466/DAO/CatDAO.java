package annbph34166.fpoly.lab1_ph13466.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import annbph34166.fpoly.lab1_ph13466.DTO.CatDTO;
import annbph34166.fpoly.lab1_ph13466.DbHelper.MyDbHelper;


public class CatDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;
    static String TAG="nnnnnnnnnnnnn";

    public CatDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db= dbHelper.getWritableDatabase();
    }

    public int addCat(CatDTO catDTO) {
        ContentValues values = new ContentValues();
        values.put("name", catDTO.getName());
        return (int) db.insert("tb_cat", null, values);
        //Nếu return về giá trị > 0 thì chính là ID tu động tăng của bảng tb_cat
    }

    // cần viết thêm: hàm lấy danh sách, lấy 1 bản ggi, sửa xóa
    public ArrayList<CatDTO> getAllCat(){
        ArrayList<CatDTO> list = new ArrayList<>();
        String sql = "select * from tb_cat";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null){
            //lấy đc dữ liệu
            cursor.moveToFirst();
            //duyệt vòng lặp để lấy từng dòng cho vào list
            do{
                //thứ tự các cột: select * from tb_cat câu lệnh sql sẽ lấy thứ tụ từ trái qua phaải

                int id = cursor.getInt(0);
                String name = cursor.getString(1);

                CatDTO catDTO = new CatDTO();
                catDTO.setId(id);
                catDTO.setName(name);
                list.add(catDTO);

            }while (cursor.moveToNext());
            if (cursor != null){
                cursor.close();
            }
            Log.d(TAG, "getAllCat: lấy đc dữ liệu");
        }
        else {
            //không lấy đc dữ liệu
            Log.d(TAG, "getAllCat: không lấy đc dữ liệu");
        }
        return list;
    }
    //lấy 1 bản ghi
    public CatDTO getOneCat(int id) {
        CatDTO catDTO = null;
        String sql = "select * from tb_cat where id = ?";
        String[] args = {String.valueOf(id)};
        Cursor cursor = db.rawQuery(sql, args);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            int id1 = cursor.getInt(0);
            catDTO = new CatDTO();
            catDTO.setId(cursor.getInt(0));
            catDTO.setName(cursor.getString(1));
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public boolean updateCat(CatDTO catDTO) {
        ContentValues values = new ContentValues();
        values.put("name", catDTO.getName());
        String[] params = {String.valueOf(catDTO.getId())};
        return db.update("tb_cat", values, "id = ?", params) > 0;

    }

    public boolean deleteCat(int id) {
        String[] params = {String.valueOf(id)};
        return db.delete("tb_cat", "id = ?", params) > 0;
    }


}

