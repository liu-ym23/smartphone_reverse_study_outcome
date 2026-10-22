package tmsdkobf;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f234a;

    static {
        f234a = new Object();
    }

    public static void a(SQLiteDatabase r1) {
        r1.execSQL("create table if not exists pabl_info(info1 text,info2 blob,info3 integer)");
        r1.execSQL("create index if not exists path_abl_index on pabl_info(info1)");
        r1.execSQL("create table if not exists pnabl_info(info1 text,info2 blob,info3 blob)");
        r1.execSQL("create index if not exists path_abl_index on pnabl_info(info1)");
        r1.execSQL("create table if not exists user_abl_info(info1 text,info2 blob,info3 blob)");
        r1.execSQL("create index if not exists user_abl_index on user_abl_info(info1)");
    }

    public static void b(SQLiteDatabase r1) {
        r1.execSQL("drop table if exists pabl_info");
        r1.execSQL("create table if not exists pabl_info(info1 text,info2 blob,info3 integer)");
        r1.execSQL("create index if not exists path_abl_index on pabl_info(info1)");
        r1.execSQL("drop table if exists pnabl_info");
        r1.execSQL("create table if not exists pnabl_info(info1 text,info2 blob,info3 blob)");
        r1.execSQL("create index if not exists path_abl_index on pnabl_info(info1)");
        r1.execSQL("drop table if exists user_abl_info");
        r1.execSQL("create table if not exists user_abl_info(info1 text,info2 blob,info3 blob)");
        r1.execSQL("create index if not exists user_abl_index on user_abl_info(info1)");
    }

    public static void a(SQLiteDatabase r0, int r1, int r2) {
        b(r0);
    }

    public static void b(SQLiteDatabase r0, int r1, int r2) {
        if (r1 >= 19) goto L6;
        a(r0);
        return;
    }
}
