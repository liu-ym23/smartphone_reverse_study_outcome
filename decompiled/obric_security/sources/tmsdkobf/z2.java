package tmsdkobf;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class z2 extends ContentProvider {
    private static final Map e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f652a;
    private SQLiteOpenHelper b;
    private SQLiteDatabase c;
    private Set d;

    class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z2 f653a;

        a(z2 r1, Context r2, String r3, SQLiteDatabase.CursorFactory r4, int r5) {
            this.f653a = r1;
            super(r2, r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            q8.c("ConfigProvider", "onCreate");
            z2.m2479$$Nest$ma(this.f653a, r3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            q8.c("ConfigProvider", "onDowngrade");
            z2.m2480$$Nest$ma(this.f653a, r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            q8.c("ConfigProvider", "onUpgrade");
            z2.m2481$$Nest$mb(this.f653a, r3, r4, r5);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2479$$Nest$ma(z2 r0, SQLiteDatabase r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2480$$Nest$ma(z2 r0, SQLiteDatabase r1, int r2, int r3) {
        r0.a(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2481$$Nest$mb(z2 r0, SQLiteDatabase r1, int r2, int r3) {
        r0.b(r1, r2, r3);
    }

    static {
        e = new HashMap();
    }

    public z2() {
        this.f652a = new Object();
        this.b = null;
        this.c = null;
    }

    private void a(String r2) {
        if (this.d != null) goto L5;
        this.d = new HashSet();
    L5:
        this.d.add(r2);
    }

    private void b(SQLiteDatabase r1) {
        r1.execSQL("DROP TABLE IF EXISTS xml_pi_info_table");
        r1.execSQL("DROP TABLE IF EXISTS loc_pi_info_table");
        r1.execSQL("DROP TABLE IF EXISTS pi_compat_table");
    }

    private SQLiteDatabase c() {
        Context r2 = TMSDKContext.getApplicaionContext();
        if (r2 == null) goto L13;
        if (this.c != null) goto L11;
        if (this.b != null) goto L9;
        q8.c("ConfigProvider", "context: " + r2);
        this.b = new a(this, r2, "pi_config.db", null, 6);
    L9:
        this.c = this.b.getWritableDatabase();
    L11:
        return this.c;
    L13:
        throw new IllegalStateException("context is null,maybe process has crashed. please check former log!");
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList r6) {
        Object r1 = this.f652a;
        monitor-enter(r1);
        SQLiteDatabase r2 = c();     // Catch: Throwable -> L20
        r2.beginTransaction();     // Catch: Throwable -> L20
        ContentProviderResult[] r5 = super.applyBatch(r6);     // Catch: Throwable -> L10 Exception -> L12
        r2.setTransactionSuccessful();     // Catch: Exception -> L8 Throwable -> L10
    L15:
        r2.endTransaction();     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return r5;
    L8:
        e = e;
    L14:
        q8.a("ConfigProvider", "applyBatch, err: " + e.getMessage(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r2.endTransaction();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L12:
        e = e;
        r5 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r8, String r9, String[] r10) {
        Object r3 = this.f652a;
        monitor-enter(r3);
        String r4 = r8.getPath();     // Catch: Throwable -> L36
        int r6 = 0;
        if ("/delete".equals(r4) == false) goto L28;
        String r11 = r8.getQuery();     // Catch: Throwable -> L36
        if (r10 == null) goto L23;
        if (r10.length != 1) goto L23;
        if ("vo_init".equals(r10[0]) == false) goto L23;
        if ("xml_pi_info_table".equals(r11) == false) goto L16;
        SQLiteDatabase r7 = c();     // Catch: Throwable -> L36
        r7.execSQL("DROP TABLE IF EXISTS " + r11);     // Catch: Throwable -> L36
        String r12 = "CREATE TABLE IF NOT EXISTS xml_pi_info_table (xa INTEGER PRIMARY KEY,xb INTEGER,xc INTEGER,xd INTEGER,xe INTEGER,xf INTEGER,xg INTEGER,xh INTEGER,xi TEXT,xm TEXT,xj TEXT,xk TEXT,xl TEXT)";
    L21:
        r7.execSQL(r12);     // Catch: Throwable -> L36
    L34:
        monitor-exit(r3);     // Catch: Throwable -> L36
        return r6;
    L16:
        if ("loc_pi_info_table".equals(r11) == false) goto L19;
        r7 = c();     // Catch: Throwable -> L36
        r7.execSQL("DROP TABLE IF EXISTS " + r11);     // Catch: Throwable -> L36
        r12 = "CREATE TABLE IF NOT EXISTS loc_pi_info_table (xa INTEGER PRIMARY KEY,lh INTEGER,la INTEGER,lb INTEGER,lc INTEGER,ld TEXT,le TEXT,lf INTEGER,lg INTEGER)";
        goto L21
    L19:
        if ("pi_compat_table".equals(r11) == false) goto L33;
        r7 = c();     // Catch: Throwable -> L36
        r7.execSQL("DROP TABLE IF EXISTS " + r11);     // Catch: Throwable -> L36
        r12 = "CREATE TABLE IF NOT EXISTS pi_compat_table (xa INTEGER PRIMARY KEY,pa INTEGER,xb INTEGER)";
    L33:
        r6 = -1;
    L23:
        if ("vt_ps".equals(r11) == false) goto L26;
        int r13 = a(Integer.parseInt(r9));     // Catch: Throwable -> L36
    L25:
        r6 = r13;
        goto L34
    L26:
        r13 = c().delete(r11, r9, r10);     // Catch: Throwable -> L36
        goto L25
    L28:
        if ("/closecursor".equals(r4) == false) goto L31;
        b(r8.getQuery());     // Catch: Throwable -> L36
        goto L34
    L31:
        if ("/close".equals(r4) == false) goto L33;
        a();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        b();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Object r0 = this.f652a;
        monitor-enter(r0);
        String r1 = r10.getPath();     // Catch: Throwable -> L23
        int r2 = r1.indexOf("_");     // Catch: Throwable -> L23
        if (r2 == (-1)) goto L7;
        a(r1.substring(r2 + 1));     // Catch: Throwable -> L23
    L7:
        String r3 = r10.getQuery();     // Catch: Throwable -> L23
        if ("xml_pi_info_table".equals(r3) == false) goto L10;
    L20:
        Cursor r9 = c().query(r3, r11, r12, r13, null, null, r14);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r9;
    L10:
        if ("loc_pi_info_table".equals(r3) == true) goto L20;
        if ("pi_compat_table".equals(r3) == false) goto L17;
        Cursor r15 = c().query(r3, r11, r12, r13, null, null, r14);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r15;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return null;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r2, ContentValues r3, String r4, String[] r5) {
        Object r6 = this.f652a;
        monitor-enter(r6);
        String r7 = r2.getQuery();     // Catch: Throwable -> L23
        if ("both_pi_info_table".equals(r7) == false) goto L7;
    L15:
        b(r3, r4, r7);     // Catch: Throwable -> L23
        if ("both_pi_info_table".equals(r7) == false) goto L18;
    L19:
        e.clear();     // Catch: Throwable -> L23
        b();     // Catch: Throwable -> L23
    L20:
        int r1 = 0;
    L21:
        monitor-exit(r6);     // Catch: Throwable -> L23
        return r1;
    L18:
        if ("loc_pi_info_table".equals(r7) == false) goto L20;
    L7:
        if ("xml_pi_info_table".equals(r7) == true) goto L15;
        if ("loc_pi_info_table".equals(r7) == true) goto L15;
        if ("pi_compat_table".equals(r7) == false) goto L14;
        a(r3, r4, r7);     // Catch: Throwable -> L23
        goto L20
    L14:
        r1 = -1;
    L23:
        th = move-exception;
        throw th;
    }

    private void a() {
        Set r0 = this.d;
        if (r0 != null) goto L5;
    L6:
        SQLiteDatabase r1 = this.c;
        if (r1 == null) goto L11;
        r1.close();
        this.c = null;
        return;
    L11:
        return;
    L5:
        if (r0.size() <= 0) goto L6;
    }

    private void b() {
        if (e.isEmpty() == false) goto L19;
        SQLiteDatabase r3 = c();
        Cursor r11 = null;
        r11 = r3.query("loc_pi_info_table", new String[]{"xa", "lc"}, null, null, null, null, null);     // Catch: Throwable -> L10 Exception -> L12
        r11.moveToFirst();     // Catch: Throwable -> L10 Exception -> L12
    L7:
        if (r11.isAfterLast() == true) goto L15;
        e.put(Integer.valueOf(r11.getInt(r11.getColumnIndex("xa"))), Integer.valueOf(r11.getInt(r11.getColumnIndex("lc"))));     // Catch: Throwable -> L10 Exception -> L12
        r11.moveToNext();     // Catch: Throwable -> L10 Exception -> L12
    L15:
        r11.close();
        return;
    L12:
        e = move-exception;
        q8.b("ConfigProvider", "ensureStateMap err: " + e.getMessage());     // Catch: Throwable -> L10
        if (r11 != null) goto L15;
        return;
    L10:
        th = move-exception;
        if (r11 == null) goto L18;
        r11.close();
    L18:
        throw th;
    }

    private void a(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS xml_pi_info_table (xa INTEGER PRIMARY KEY,xb INTEGER,xc INTEGER,xd INTEGER,xe INTEGER,xf INTEGER,xg INTEGER,xh INTEGER,xi TEXT,xm TEXT,xj TEXT,xk TEXT,xl TEXT)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS loc_pi_info_table (xa INTEGER PRIMARY KEY,lh INTEGER,la INTEGER,lb INTEGER,lc INTEGER,ld TEXT,le TEXT,lf INTEGER,lg INTEGER)");
        r1.execSQL("CREATE TABLE IF NOT EXISTS pi_compat_table (xa INTEGER PRIMARY KEY,pa INTEGER,xb INTEGER)");
    }

    private ContentValues b(ContentValues r3) {
        ContentValues r2 = new ContentValues();
        if (r3.containsKey("xa") == false) goto L6;
        r2.put("xa", r3.getAsInteger("xa"));
    L6:
        if (r3.containsKey("xf") == false) goto L9;
        r2.put("xf", r3.getAsInteger("xf"));
    L9:
        if (r3.containsKey("xg") == false) goto L12;
        r2.put("xg", r3.getAsInteger("xg"));
    L12:
        if (r3.containsKey("xh") == false) goto L15;
        r2.put("xh", r3.getAsInteger("xh"));
    L15:
        if (r3.containsKey("xb") == false) goto L18;
        r2.put("xb", r3.getAsInteger("xb"));
    L18:
        if (r3.containsKey("xc") == false) goto L21;
        r2.put("xc", r3.getAsInteger("xc"));
    L21:
        if (r3.containsKey("xd") == false) goto L24;
        r2.put("xd", r3.getAsInteger("xd"));
    L24:
        if (r3.containsKey("xe") == false) goto L27;
        r2.put("xe", r3.getAsInteger("xe"));
    L27:
        if (r3.containsKey("xi") == false) goto L30;
        r2.put("xi", r3.getAsString("xi"));
    L30:
        if (r3.containsKey("xm") == false) goto L33;
        r2.put("xm", r3.getAsString("xm"));
    L33:
        if (r3.containsKey("xj") == false) goto L36;
        r2.put("xj", r3.getAsString("xj"));
    L36:
        if (r3.containsKey("xk") == false) goto L39;
        r2.put("xk", r3.getAsString("xk"));
    L39:
        if (r3.containsKey("xl") == false) goto L41;
        r2.put("xl", r3.getAsString("xl"));
    L41:
        return r2;
    }

    private void a(SQLiteDatabase r1, int r2, int r3) {
        b(r1);
        a(r1);
    }

    private void b(String r1) {
        Set r0 = this.d;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    private ContentValues a(ContentValues r3) {
        ContentValues r2 = new ContentValues();
        if (r3.containsKey("xa") == false) goto L6;
        r2.put("xa", r3.getAsInteger("xa"));
    L6:
        if (r3.containsKey("lh") == false) goto L9;
        r2.put("lh", r3.getAsInteger("lh"));
    L9:
        if (r3.containsKey("la") == false) goto L12;
        r2.put("la", r3.getAsInteger("la"));
    L12:
        if (r3.containsKey("lb") == false) goto L15;
        r2.put("lb", r3.getAsInteger("lb"));
    L15:
        if (r3.containsKey("lc") == false) goto L18;
        r2.put("lc", r3.getAsInteger("lc"));
    L18:
        if (r3.containsKey("le") == false) goto L21;
        r2.put("le", r3.getAsString("le"));
    L21:
        if (r3.containsKey("ld") == false) goto L24;
        r2.put("ld", r3.getAsString("ld"));
    L24:
        if (r3.containsKey("lf") == false) goto L27;
        r2.put("lf", r3.getAsString("lf"));
    L27:
        if (r3.containsKey("lg") == false) goto L29;
        r2.put("lg", r3.getAsString("lg"));
    L29:
        return r2;
    }

    private void b(ContentValues r3, String r4, String r5) {
        if (r3 == null) goto L16;
        if (r5 != null) goto L6;
        return;
    L6:
        if ("both_pi_info_table".equals(r5) == false) goto L8;
    L9:
        b(b(r3), r4);
    L11:
        if ("both_pi_info_table".equals(r5) == false) goto L13;
    L14:
        a(a(r3), r4);
        return;
    L13:
        if ("loc_pi_info_table".equals(r5) == true) goto L14;
        return;
    L8:
        if ("xml_pi_info_table".equals(r5) == false) goto L11;
    }

    private int a(int r2) {
        b();
        Map r1 = e;
        if (r1.containsKey(Integer.valueOf(r2)) == true) goto L5;
        return 0;
    L5:
        return ((Integer) r1.get(Integer.valueOf(r2))).intValue();
    }

    private void b(ContentValues r5, String r6) {
        SQLiteDatabase r4 = c();
        int r1 = r5.getAsInteger("xa").intValue();
        r5.remove("xa");
        if (r4.update("xml_pi_info_table", r5, r6, null) > 0) goto L6;
        r5.put("xa", Integer.valueOf(r1));
        r4.insert("xml_pi_info_table", null, r5);
        return;
    }

    private void a(ContentValues r5, String r6) {
        SQLiteDatabase r4 = c();
        int r1 = r5.getAsInteger("xa").intValue();
        r5.remove("xa");
        if (r4.update("loc_pi_info_table", r5, r6, null) > 0) goto L6;
        r5.put("xa", Integer.valueOf(r1));
        r4.insert("loc_pi_info_table", null, r5);
        return;
    }

    private void b(SQLiteDatabase r1, int r2, int r3) {
        if (r2 != 1) goto L5;
        r1.execSQL("CREATE TABLE IF NOT EXISTS pi_compat_table (xa INTEGER PRIMARY KEY,pa INTEGER,xb INTEGER)");
    L14:
        r1.execSQL("ALTER TABLE xml_pi_info_table ADD COLUMN xm TEXT");
    L15:
        r1.execSQL("update loc_pi_info_table set la=%d where loc_pi_info_table.la != 0 and (SELECT xj FROM xml_pi_info_table WHERE xml_pi_info_table.xa=loc_pi_info_table.xa) is %s null and (SELECT xk FROM xml_pi_info_table WHERE xml_pi_info_table.xa=loc_pi_info_table.xa) is %s null");
    L16:
        r1.execSQL("ALTER TABLE loc_pi_info_table ADD COLUMN lf INTEGER");
        r1.execSQL("ALTER TABLE loc_pi_info_table ADD COLUMN lg INTEGER");
    L17:
        r1.execSQL("ALTER TABLE loc_pi_info_table ADD COLUMN lh INTEGER");
        return;
    L5:
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L16;
        if (r2 == 5) goto L17;
    }

    private void a(ContentValues r4, String r5, String r6) {
        SQLiteDatabase r3 = c();
        int r0 = r4.getAsInteger("xa").intValue();
        r4.remove("xa");
        if (r3.update("pi_compat_table", r4, r5, null) > 0) goto L6;
        r4.put("xa", Integer.valueOf(r0));
        r3.insert("pi_compat_table", null, r4);
        return;
    }
}
