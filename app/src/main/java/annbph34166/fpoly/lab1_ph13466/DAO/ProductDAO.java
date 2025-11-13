package annbph34166.fpoly.lab1_ph13466.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import annbph34166.fpoly.lab1_ph13466.DTO.ProductDTO;
import annbph34166.fpoly.lab1_ph13466.DbHelper.MyDbHelper;

public class ProductDAO {

    private SQLiteDatabase db;
    public  ProductDAO(Context context){
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public  long insertProduct(ProductDTO ojb){
        ContentValues values = new ContentValues();
        values.put("name", ojb.getName());
        values.put("price", ojb.getPrice());
        values.put("categoryId", ojb.getId_cat());
        return db.insert("tb_product", null, values);
    }

    public long updateProduct(ProductDTO obj) {
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        values.put("price", obj.getPrice());
        values.put("categoryId", obj.getId_cat());

        return db.update("tb_product", values, "id = ?", new String[]{String.valueOf(obj.getId())});
    }

    public long deleteProduct(int id) {
        return db.delete("tb_product", "id = ?", new String[]{String.valueOf(id)});
    }

    public ArrayList<ProductDTO> getAllProduct() {
        ArrayList<ProductDTO> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM tb_product", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                ProductDTO obj = new ProductDTO();
                obj.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                obj.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                obj.setPrice(cursor.getInt(cursor.getColumnIndexOrThrow("price")));
                obj.setId_cat(cursor.getInt(cursor.getColumnIndexOrThrow("categoryId")));

                list.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }
}

