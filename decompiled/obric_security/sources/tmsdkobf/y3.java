package tmsdkobf;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f631a;

    static {
        f631a = new Object();
    }

    public static void a(SQLiteDatabase r1) {
        r1.execSQL("create table if not exists dcp_info(info1 text,info2 blob,info4 blob,info3 blob)");
        r1.execSQL("create table if not exists dcr_info(info1 text,info2 blob)");
        r1.execSQL("create index if not exists dcp_index on dcp_info(info1)");
        r1.execSQL("create index if not exists dcr_index on dcr_info(info1)");
        r1.execSQL("create table if not exists up(info1 text primary key,info2 integer)");
    }

    public static void b(SQLiteDatabase r1) {
        r1.execSQL("drop table if exists dcd_info");
        r1.execSQL("create table if not exists dcd_info(info1 text,info2 blob)");
        r1.execSQL("drop table if exists dcp_info");
        r1.execSQL("create table if not exists dcp_info(info1 text,info2 blob,info4 blob,info3 blob)");
        r1.execSQL("create index if not exists dcd_index on dcd_info(info1)");
        r1.execSQL("create index if not exists dcp_index on dcp_info(info1)");
        ee.d().e();
    }

    public static void a(SQLiteDatabase r0, int r1, int r2) {
        b(r0);
        a(r0);
    }

    public static void b(SQLiteDatabase r0, int r1, int r2) {
        if (r1 < 18) goto L9;
    L6:
        a(r0);
        return;
    L9:
        r0.execSQL("ALTER TABLE dcp_info ADD COLUMN info4 blob");     // Catch: Exception -> L8
    L5:
        ee.d().e();
        goto L6
    }
}
