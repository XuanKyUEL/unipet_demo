package mnxk.mcommerce.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table Book (id integer primary key autoincrement, title text, author text, price real)"; // Tạo bảng Book
        db.execSQL(sql);
        sql = "Insert into Book (title, author, price) values ('Android', 'Google', 20000)"; // Thêm dữ liệu mẫu
        db.execSQL(sql);
        sql = "Insert into Book (title, author, price) values ('iOS', 'Apple', 30000)"; // Thêm dữ liệu mẫu
        db.execSQL(sql);
        sql = "Insert into Book (title, author, price) values ('Window', 'Microsoft', 20000)"; // Thêm dữ liệu mẫu
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop table if exists Book"; // Xóa bảng Book nếu tồn tại
        db.execSQL(sql);
        onCreate(db);
    }
}
