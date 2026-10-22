package tmsdkobf;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.obric.oui.calendar.format.DayFormatter;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class de {
    private static Object b;
    private static de c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f153a;

    static {
        b = new Object();
    }

    private de() {
        this.f153a = null;
        this.f153a = ((me) qd.a(9)).a("QQSecureProvider");
    }

    public static void b(SQLiteDatabase r1) {
        r1.execSQL("DROP TABLE IF EXISTS pf_soft_list_profile_db_table_name");
    }

    public static de c() {
        if (c != null) goto L15;
        Object r0 = b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new de();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    private ArrayList d() {
        ArrayList r2 = new ArrayList();
        Cursor r3 = null;
        Cursor r4 = this.f153a.a("pf_soft_list_profile_db_table_name", null, null, null, null);     // Catch: Throwable -> L24 Exception -> L26
        if (r4 != null) goto L11;
        if (r4 != null) goto L42;
    L10:
        return r2;
    L42:
        r4.close();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        q8.b("SoftListProfileDB", "cursor.close() crash : " + e.toString());
        goto L10
    L11:
        r4.moveToFirst();     // Catch: Throwable -> L24 Exception -> L26
    L13:
        if (r4.isAfterLast() == true) goto L46;
        ge r10 = new ge();     // Catch: Throwable -> L24 Exception -> L26
        r10.d = r4.getLong(r4.getColumnIndex("e"));     // Catch: Throwable -> L24 Exception -> L26
        r10.c = r4.getString(r4.getColumnIndex(DayFormatter.DEFAULT_FORMAT));     // Catch: Throwable -> L24 Exception -> L26
        r10.g = r4.getString(r4.getColumnIndex("h"));     // Catch: Throwable -> L24 Exception -> L26
        boolean r5 = true;
        if (r4.getInt(r4.getColumnIndex("f")) == 1) goto L18;
        r5 = false;
    L18:
        r10.e = r5;     // Catch: Throwable -> L24 Exception -> L26
        r10.f218a = r4.getString(r4.getColumnIndex("b"));     // Catch: Throwable -> L24 Exception -> L26
        r10.b = r4.getString(r4.getColumnIndex("c"));     // Catch: Throwable -> L24 Exception -> L26
        r10.i = r4.getString(r4.getColumnIndex("j"));     // Catch: Throwable -> L24 Exception -> L26
        r10.h = r4.getLong(r4.getColumnIndex("i"));     // Catch: Throwable -> L24 Exception -> L26
        r10.f = r4.getString(r4.getColumnIndex("g"));     // Catch: Throwable -> L24 Exception -> L26
        r10.j = r4.getLong(r4.getColumnIndex("k"));     // Catch: Throwable -> L24 Exception -> L26
        r2.add(new wb(r10, r4.getInt(r4.getColumnIndex("a"))));     // Catch: Throwable -> L24 Exception -> L26
        r4.moveToNext();     // Catch: Throwable -> L24 Exception -> L26
    L46:
        r4.close();     // Catch: Exception -> L22
    L34:
        return r2;
    L22:
        e = e;
        StringBuilder r6 = new StringBuilder("cursor.close() crash : ");
    L33:
        q8.b("SoftListProfileDB", r6.append(e.toString()).toString());
    L24:
        th = move-exception;
        if (0 != 0) goto L44;
    L40:
        throw th;
    L44:
        r3.close();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        q8.b("SoftListProfileDB", "cursor.close() crash : " + e.toString());
    L26:
        e = move-exception;
        q8.b("SoftListProfileDB", e.toString());     // Catch: Throwable -> L24
        if (0 == 0) goto L34;
        r3.close();     // Catch: Exception -> L31
    L31:
        e = e;
        r6 = new StringBuilder("cursor.close() crash : ");
        goto L33
    }

    public boolean a(ArrayList r13) {
        if (r13 != null) goto L5;
    L42:
        return true;
    L5:
        if (r13.size() <= 0) goto L42;
        ArrayList r1 = new ArrayList();
        Iterator r14 = r13.iterator();
        boolean r3 = false;
    L9:
        if (r14.hasNext() == false) goto L33;
        q6.a r4 = (q6.a) r14.next();
        if (r4 == null) goto L9;
        JceStruct r5 = r4.f434a;
        if (r5 == null) goto L9;
        if ((r5 instanceof ge) == false) goto L9;
        ge r6 = (ge) r5;
        int r7 = r4.b;
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L30;
        if (r7 == 2) goto L26;
        if (r7 != 3) goto L9;
        ContentProviderOperation.Builder r8 = ContentProviderOperation.newUpdate(this.f153a.b("pf_soft_list_profile_db_table_name")).withValues(a(r6));
        String r9 = String.format("%s = '%s'", new Object[]{"b", r6.f218a});
    L27:
        ContentProviderOperation.Builder r10 = r8.withSelection(r9, null);
    L31:
        r1.add(r10.build());
        goto L9
    L26:
        r8 = ContentProviderOperation.newDelete(this.f153a.d("pf_soft_list_profile_db_table_name"));
        r9 = String.format("%s = '%s'", new Object[]{"b", r6.f218a});
    L30:
        r10 = ContentProviderOperation.newInsert(this.f153a.c("pf_soft_list_profile_db_table_name")).withValues(a(r6));
        goto L31
    L28:
        if (r3 == true) goto L30;
        a();
        r3 = true;
        goto L30
    L33:
        if (r1.size() <= 0) goto L42;
        ContentProviderResult[] r12 = this.f153a.a(r1);
        if (r12 != null) goto L37;
    L40:
        ta.a("SoftListProfileDB", "applyBatchOperation fail!!!");
        return false;
    L37:
        if (r12.length <= 0) goto L40;
        if (r12[0] != null) goto L42;
        goto L40
    }

    private void a() {
        this.f153a.a("pf_soft_list_profile_db_table_name", null, null);
    }

    public ArrayList b() {
        q8.c("SoftListProfileDB", "getAllSoftImage");
        ArrayList r0 = new ArrayList();
        ArrayList r2 = d();
        if (r2 != null) goto L5;
    L15:
        return r0;
    L5:
        if (r2.size() <= 0) goto L15;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        wb r1 = (wb) r3.next();
        if (r1 == null) goto L8;
        ge r4 = r1.f599a;
        if (r4 == null) goto L8;
        r0.add(r4);
        goto L8
    }

    public static void a(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS pf_soft_list_profile_db_table_name (a INTEGER PRIMARY KEY,b TEXT,c TEXT,d TEXT,e LONG,f INTEGER,h TEXT,i LONG,g TEXT,j TEXT,k LONG)");
    }

    public static void b(SQLiteDatabase r1, int r2, int r3) {
        q8.c("SoftListProfileDB", "upgradeDB");
        if (r2 >= 15) goto L5;
        a(r1);
    L5:
        if (r2 >= 15) goto L7;
        return;
    L7:
        if (r2 < 18) goto L12;
        return;
    L12:
        r1.execSQL("ALTER TABLE pf_soft_list_profile_db_table_name ADD COLUMN k LONG");     // Catch: Exception -> L11
        return;
    }

    public static void a(SQLiteDatabase r0, int r1, int r2) {
        q8.c("SoftListProfileDB", "downgradeDB");
        b(r0);
        a(r0);
    }

    private ContentValues a(ge r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ContentValues r2 = new ContentValues();
        r2.put("b", r3.f218a);
        r2.put("c", r3.b);
        r2.put(DayFormatter.DEFAULT_FORMAT, r3.c);
        r2.put("e", Long.valueOf(r3.d));
        r2.put("f", Integer.valueOf(r3.e ? 1 : 0));
        r2.put("h", r3.g);
        r2.put("i", Long.valueOf(r3.h));
        r2.put("j", r3.i);
        r2.put("g", r3.f);
        r2.put("k", Long.valueOf(r3.j));
        return r2;
    }
}
