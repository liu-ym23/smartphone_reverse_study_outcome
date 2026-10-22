package tmsdkobf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.obric.oui.calendar.format.DayFormatter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class qa {
    private static Object c;
    private static qa d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f438a;
    byte b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f439a;
        public int b;
        public int c;
        public int d;
        private f1 e;

        public a(byte[] r2, int r3, int r4, int r5) {
            this.e = null;
            this.c = r4;
            this.f439a = r2;
            this.b = r3;
            this.d = r5;
        }

        public f1 a() {
            if (this.e != null) goto L15;
            if (this.b != 0) goto L15;
            byte[] r0 = this.f439a;
            if (r0 == null) goto L15;
            if (r0.length <= 0) goto L15;
            this.e = ta.a(r0);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            q8.b("ProfileQueue", th);
        L15:
            return this.e;
        }
    }

    static {
        c = new Object();
    }

    private qa() {
        this.f438a = null;
        this.b = 0;
        this.f438a = ((me) qd.a(9)).a("QQSecureProvider");
    }

    private String c(int r3) {
        return String.format("%s = %s", new Object[]{"c", Integer.valueOf(r3)});
    }

    public boolean a(int r3) {
        if (this.f438a.a("profile_fifo_upload_queue", c(r3), null) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public byte[] b(int r4) {
        String r5 = "d = " + r4;
        a r1 = a(r5, null);
        if (r1 != null) goto L5;
        return null;
    L5:
        int r3 = this.f438a.a("profile_fifo_upload_queue", r5, null);
        if (r3 <= 1) goto L8;
        ta.a("ProfileUpload", "delete error! 多于一行被delete了！！");
    L11:
        return r1.f439a;
    L8:
        if (r3 != 0) goto L11;
        return null;
    }

    public static void a(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS profile_fifo_upload_queue (a INTEGER PRIMARY KEY,c INTEGER,d INTEGER,e INTEGER,b BLOB)");
    }

    public static void b(SQLiteDatabase r1) {
        r1.execSQL("DROP TABLE IF EXISTS profile_fifo_upload_queue");
    }

    public static void a(SQLiteDatabase r0, int r1, int r2) {
        b(r0);
        a(r0);
    }

    public static qa b() {
        if (d != null) goto L15;
        Object r0 = c;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new qa();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    private ArrayList b(String r11, String r12) {
        ArrayList r2 = new ArrayList();
        Cursor r3 = null;
        Cursor r4 = this.f438a.a("profile_fifo_upload_queue", null, r11, null, r12);     // Catch: Throwable -> L20 Exception -> L22
        if (r4 != null) goto L11;
        if (r4 != null) goto L37;
    L10:
        return r2;
    L37:
        r4.close();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        q8.b("ProfileQueue", "cursor.close() crash : " + e.toString());
        goto L10
    L11:
        r4.moveToFirst();     // Catch: Throwable -> L20 Exception -> L22
    L13:
        if (r4.isAfterLast() == true) goto L45;
        r2.add(new a(r4.getBlob(r4.getColumnIndex("b")), r4.getInt(r4.getColumnIndex("e")), r4.getInt(r4.getColumnIndex(DayFormatter.DEFAULT_FORMAT)), r4.getInt(r4.getColumnIndex("c"))));     // Catch: Throwable -> L20 Exception -> L22
        r4.moveToNext();     // Catch: Throwable -> L20 Exception -> L22
    L45:
        r4.close();     // Catch: Exception -> L18
    L30:
        return r2;
    L18:
        e = e;
        StringBuilder r13 = new StringBuilder("cursor.close() crash : ");
    L29:
        q8.b("ProfileQueue", r13.append(e.toString()).toString());
    L22:
        e = move-exception;
        q8.b("ProfileQueue", e.toString());     // Catch: Throwable -> L20
        if (0 == 0) goto L30;
        r3.close();     // Catch: Exception -> L27
    L27:
        e = e;
        r13 = new StringBuilder("cursor.close() crash : ");
    L20:
        th = move-exception;
        if (0 != 0) goto L43;
    L36:
        throw th;
    L43:
        r3.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        q8.b("ProfileQueue", "cursor.close() crash : " + e.toString());
        goto L36
    }

    public List a() {
        return b(null, DayFormatter.DEFAULT_FORMAT);
    }

    private a a(String r1, String r2) {
        ArrayList r0 = b(r1, r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() > 0) goto L8;
        return null;
    L8:
        return (a) r0.get(0);
    }

    public static void b(SQLiteDatabase r0, int r1, int r2) {
        if (r1 >= 15) goto L6;
        a(r0);
        return;
    }

    public int a(byte[] r2, int r3) {
        return a(r2, 0, r3);
    }

    private int a(byte[] r3, int r4, int r5) {
        ContentValues r0 = new ContentValues();
        if (r3 != null) goto L5;
    L7:
        r0.put("e", Integer.valueOf(r4));
        if (r5 > 0) goto L10;
    L12:
        int r6 = sa.b().a();
        r0.put(DayFormatter.DEFAULT_FORMAT, Integer.valueOf(r6));
        if (this.f438a.a("profile_fifo_upload_queue", r0) < 0) goto L16;
        sa.b().c();
        return r6;
    L16:
        return -1;
    L10:
        if (r5 >= 5) goto L12;
        r0.put("c", Integer.valueOf(r5));
        goto L12
    L5:
        if (r3.length <= 0) goto L7;
        r0.put("b", r3);
        goto L7
    }
}
