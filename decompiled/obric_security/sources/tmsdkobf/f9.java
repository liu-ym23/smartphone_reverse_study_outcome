package tmsdkobf;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public class f9 extends oa {
    private static final oa.c n = null;

    class a implements oa.c {
        a() {
        }

        @Override // tmsdkobf.oa.c
        public void a(SQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_thread (_id INTEGER PRIMARY KEY,mid LONG,name TEXT,ut LONG,ct LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_ui (_id INTEGER PRIMARY KEY,name TEXT,ut LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_dev (_id INTEGER PRIMARY KEY,id LONG,vl TEXT)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_mod (_id INTEGER PRIMARY KEY,mid INTEGER,ut LONG,sz INTEGER)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS gd_info (_id INTEGER PRIMARY KEY,type INTEGER,data TEXT)");
        }

        @Override // tmsdkobf.oa.c
        public void b(SQLiteDatabase r1, int r2, int r3) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_thread (_id INTEGER PRIMARY KEY,mid LONG,name TEXT,ut LONG,ct LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_ui (_id INTEGER PRIMARY KEY,name TEXT,ut LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_dev (_id INTEGER PRIMARY KEY,id LONG,vl TEXT)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_mod (_id INTEGER PRIMARY KEY,mid INTEGER,ut LONG,sz INTEGER)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS gd_info (_id INTEGER PRIMARY KEY,type INTEGER,data TEXT)");
        }

        @Override // tmsdkobf.oa.c
        public void a(SQLiteDatabase r1, int r2, int r3) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_thread (_id INTEGER PRIMARY KEY,mid LONG,name TEXT,ut LONG,ct LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_ui (_id INTEGER PRIMARY KEY,name TEXT,ut LONG)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_dev (_id INTEGER PRIMARY KEY,id LONG,vl TEXT)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS rqd_mod (_id INTEGER PRIMARY KEY,mid INTEGER,ut LONG,sz INTEGER)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS gd_info (_id INTEGER PRIMARY KEY,type INTEGER,data TEXT)");
        }
    }

    static {
        n = new a();
    }

    public f9() {
        super("meriExt.db", 4, n);
    }
}
