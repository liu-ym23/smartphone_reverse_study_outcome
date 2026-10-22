package tmsdkobf;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f125a;

    static {
        f125a = new Object();
    }

    public static void a(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS pf_key_value_profile_db_table_name (a INTEGER PRIMARY KEY,b INTEGER,c INTEGER,d INTEGER,e LONG,f TEXT,h INTEGER,i INTEGER,g BLOB)");
    }

    public static void b(SQLiteDatabase r1) {
        r1.execSQL("DROP TABLE IF EXISTS pf_key_value_profile_db_table_name");
    }

    public static void a(SQLiteDatabase r0, int r1, int r2) {
        b(r0);
        a(r0);
    }

    public static void b(SQLiteDatabase r0, int r1, int r2) {
        if (r1 >= 15) goto L6;
        a(r0);
        return;
    }
}
