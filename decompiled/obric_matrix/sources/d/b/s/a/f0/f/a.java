package d.b.s.a.f0.f;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public a(@Nullable Context r4) {
        super(r4, "account_db", null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS login_info (time integer primary key , type integer , info text , uid integer , avatar_url text , screen_name text , platform_avatar_url text, platform_screen_name text,sec_uid text,ext text);");     // Catch: SQLException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        if (r2 >= 2) goto L6;
        r1.execSQL("alter TABLE login_info add COLUMN sec_uid text ");
        r1.execSQL("alter TABLE login_info add COLUMN ext text ");
        d.b.s.a.a0.a.a("DBHelper", "update db ");
        return;
    }
}
