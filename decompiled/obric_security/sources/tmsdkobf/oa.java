package tmsdkobf;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class oa extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f392a;
    public final Object b;
    private final String c;
    protected Set d;
    private int e;
    private final int f;
    private final int g;
    private SQLiteOpenHelper h;
    private tc i;
    private String j;
    private int k;
    private c l;
    private String m;

    class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ oa f393a;

        a(oa r1, Context r2, String r3, SQLiteDatabase.CursorFactory r4, int r5) {
            this.f393a = r1;
            super(r2, r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            r8.c("DBService", "SQLiteDatabase|onCreate|name=" + oa.m2426$$Nest$fgetj(this.f393a) + "|version=" + oa.m2427$$Nest$fgetk(this.f393a));
            oa.m2428$$Nest$fgetl(this.f393a).a(r3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            r8.e("DBService", "SQLiteDatabase|onDowngrade|name=" + oa.m2426$$Nest$fgetj(this.f393a) + "|oldversion=" + r4 + "|newVersion=" + r5);
            oa.m2428$$Nest$fgetl(this.f393a).a(r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            r8.e("DBService", "SQLiteDatabase|onUpgrade|name=" + oa.m2426$$Nest$fgetj(this.f393a) + "|oldversion=" + r4 + "|newVersion=" + r5);
            oa.m2428$$Nest$fgetl(this.f393a).b(r3, r4, r5);
        }
    }

    class b extends tc {
        final /* synthetic */ oa j;

        b(oa r7, Context r8, String r9, SQLiteDatabase.CursorFactory r10, int r11, String r12) {
            this.j = r7;
            super(r8, r9, r10, r11, r12);
        }

        @Override // tmsdkobf.tc
        public void a(SQLiteDatabase r3) {
            r8.c("DBService", "SDCardSQLiteDatabase|onCreate|name=" + oa.m2426$$Nest$fgetj(this.j) + "|version=" + oa.m2427$$Nest$fgetk(this.j));
            oa.m2428$$Nest$fgetl(this.j).a(r3);
        }

        @Override // tmsdkobf.tc
        public void a(SQLiteDatabase r3, int r4, int r5) {
            r8.e("DBService", "SDCardSQLiteDatabase|onUpgrade|name=" + oa.m2426$$Nest$fgetj(this.j) + "|oldversion=" + r4 + "|newVersion=" + r5);
            oa.m2428$$Nest$fgetl(this.j).b(r3, r4, r5);
        }
    }

    public interface c {
        void a(SQLiteDatabase r1);

        void a(SQLiteDatabase r1, int r2, int r3);

        void b(SQLiteDatabase r1, int r2, int r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetj, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2426$$Nest$fgetj(oa r0) {
        return r0.j;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetk, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2427$$Nest$fgetk(oa r0) {
        return r0.k;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetl, reason: not valid java name */
    static /* bridge */ /* synthetic */ c m2428$$Nest$fgetl(oa r0) {
        return r0.l;
    }

    public oa(String r3, int r4, c r5) {
        this.f392a = new ReentrantReadWriteLock();
        this.b = new Object();
        this.c = "PiDBProvider";
        this.d = Collections.synchronizedSet(new HashSet());
        this.f = 1;
        this.g = 2;
        this.e = 1;
        this.j = r3;
        this.k = r4;
        this.l = r5;
    }

    protected void a(String r1) {
        this.d.add(r1);
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList r3) {
        this.f392a.writeLock().lock();
        SQLiteDatabase r0 = b();     // Catch: Throwable -> L23
        ContentProviderResult[] r1 = null;
        if (r0 == null) goto L17;
        r0.beginTransaction();     // Catch: Throwable -> L23
        r1 = super.applyBatch(r3);     // Catch: Throwable -> L10 Exception -> L12
        r0.setTransactionSuccessful();     // Catch: Throwable -> L10 Exception -> L12
    L8:
        if (r0.inTransaction() == false) goto L26;
    L16:
        r0.endTransaction();     // Catch: Throwable -> L23
    L26:
    L10:
        th = move-exception;
        if (r0.inTransaction() == false) goto L22;
        r0.endTransaction();     // Catch: Throwable -> L23
    L22:
        throw th;     // Catch: Throwable -> L23
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r0.inTransaction() == false) goto L26;
    L17:
        this.f392a.writeLock().unlock();
        return r1;
    L23:
        th = move-exception;
        this.f392a.writeLock().unlock();
        throw th;
    }

    protected Cursor b(SQLiteDatabase r1, String r2) {
        if (r1 == null) goto L11;
        return r1.rawQuery(r2, null);
    L6:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "rawQuery fail!");
        return null;
    L11:
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r5, String r6, String[] r7) {
        this.f392a.writeLock().lock();
        String r2 = r5.getPath();     // Catch: Throwable -> L21
        if ("/delete".equals(r2) == false) goto L9;
        int r8 = a(b(), r5.getQuery(), r6, r7);     // Catch: Throwable -> L21
        this.f392a.writeLock().unlock();
        return r8;
    L9:
        if ("/execSQL".equals(r2) == false) goto L14;
        a(b(), r5.getQuery());     // Catch: Throwable -> L21
    L11:
        this.f392a.writeLock().unlock();
        return 0;
    L14:
        if ("/closecursor".equals(r2) == false) goto L17;
        b(r5.getQuery());     // Catch: Throwable -> L21
        goto L11
    L17:
        if ("/close".equals(r2) == false) goto L19;
        a();     // Catch: Throwable -> L21
        goto L11
    L19:
        r8.b("PiDBProvider", "error delete: " + r5.toString());     // Catch: Throwable -> L21
        throw new IllegalArgumentException("the uri " + r5.toString() + "is error");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.f392a.writeLock().unlock();
        throw th;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r7, ContentValues r8) {
        this.f392a.writeLock().lock();
    L15:
        th = move-exception;
        this.f392a.writeLock().unlock();
        throw th;
    L5:
        if ("/insert".equals(r7.getPath()) == false) goto L11;
        String r9 = "content://" + r7.getAuthority() + "?" + a(b(), r7.getQuery(), r8);     // Catch: Throwable -> L15
    L7:
        Uri r10 = Uri.parse(r9);     // Catch: Throwable -> L15
        this.f392a.writeLock().unlock();
        return r10;
    L11:
        if ("/replace".equals(r7.getPath()) == false) goto L13;
        r9 = "content://" + r7.getAuthority() + "?" + b(b(), r7.getQuery(), r8);     // Catch: Throwable -> L15
        goto L7
    L13:
        r8.b("PiDBProvider", "error insert: " + r7.toString());     // Catch: Throwable -> L15
        throw new IllegalArgumentException("the uri " + r7.toString() + "is error");     // Catch: Throwable -> L15
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        this.f392a.readLock().lock();
        String r2 = r9.getPath();     // Catch: Throwable -> L16
        int r3 = r2.indexOf("_");     // Catch: Throwable -> L16
        if (r3 == (-1)) goto L7;
        a(r2.substring(r3 + 1));     // Catch: Throwable -> L16
        r2 = r2.substring(0, r3);     // Catch: Throwable -> L16
    L7:
        if ("/query".equals(r2) == false) goto L12;
        Cursor r0 = a(b(), r9.getQuery(), r10, r11, r12, r13);     // Catch: Throwable -> L16
    L9:
        this.f392a.readLock().unlock();
        return r0;
    L12:
        if ("/rawquery".equals(r2) == false) goto L14;
        r0 = b(b(), r9.getQuery());     // Catch: Throwable -> L16
        goto L9
    L14:
        r8.b("PiDBProvider", "error query: " + r9.toString());     // Catch: Throwable -> L16
        throw new IllegalArgumentException("the uri " + r9.toString() + "is error");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f392a.readLock().unlock();
        throw th;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        this.f392a.writeLock().lock();
    L10:
        th = move-exception;
        this.f392a.writeLock().unlock();
        throw th;
    L4:
        if ("/update".equals(r10.getPath()) == false) goto L8;
        int r14 = a(b(), r10.getQuery(), r11, r12, r13);     // Catch: Throwable -> L10
        this.f392a.writeLock().unlock();
        return r14;
    L8:
        r8.b("PiDBProvider", "error update: " + r10.toString());     // Catch: Throwable -> L10
        throw new IllegalArgumentException("the uri " + r10.toString() + "is error");     // Catch: Throwable -> L10
    }

    protected void a() {
        Set r0 = this.d;
        if (r0 != null) goto L5;
    L6:
        SQLiteOpenHelper r1 = this.h;
        if (r1 != null) goto L9;
    L11:
        tc r2 = this.i;
        if (r2 != null) goto L14;
        return;
    L14:
        if (this.e != 2) goto L20;
        r2.a();
        return;
    L20:
        return;
    L9:
        if (this.e != 1) goto L11;
        r1.close();
        return;
    L5:
        if (r0.size() <= 0) goto L6;
    }

    protected long b(SQLiteDatabase r3, String r4, ContentValues r5) {
        if (r3 != null) goto L10;
        return -1;
    L10:
        return r3.replace(r4, null, r5);
    L7:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "replace fail!");
        return -1;
    }

    protected int a(SQLiteDatabase r1, String r2, String r3, String[] r4) {
        if (r1 == null) goto L11;
        return r1.delete(r2, r3, r4);
    L6:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "delete fail!");
        return -1;
    L11:
        return -1;
    }

    protected SQLiteDatabase b() {
        Context r2 = TMSDKContext.getApplicaionContext();
        if (r2 != null) goto L7;
        r8.c("PiDBProvider", "ProviderUtil.getForeContext()： " + r2);
        return null;
    L7:
        if (this.e != 1) goto L22;
        if (this.h != null) goto L20;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.h != null) goto L14;
        this.h = new a(this, r2, this.j, null, this.k);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    L20:
        return this.h.getWritableDatabase();
    L22:
        if (this.i != null) goto L33;
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L25:
        if (this.i != null) goto L27;
        this.i = new b(this, r2, this.j, null, this.k, this.m);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
    L33:
        return this.i.b();
    }

    protected void a(SQLiteDatabase r1, String r2) {
        if (r1 == null) goto L10;
        r1.execSQL(r2);     // Catch: SQLiteException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "execSQL fail!");
        return;
    }

    protected void b(String r1) {
        this.d.remove(r1);
    }

    protected long a(SQLiteDatabase r3, String r4, ContentValues r5) {
        if (r3 != null) goto L10;
        return -1;
    L10:
        return r3.insert(r4, null, r5);
    L7:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "insert fail!");
        return -1;
    }

    protected Cursor a(SQLiteDatabase r9, String r10, String[] r11, String r12, String[] r13, String r14) {
        if (r9 != null) goto L10;
        return null;
    L10:
        return r9.query(r10, r11, r12, r13, null, null, r14);
    L7:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "query fail!");
        return null;
    }

    protected int a(SQLiteDatabase r1, String r2, ContentValues r3, String r4, String[] r5) {
        if (r1 == null) goto L11;
        return r1.update(r2, r3, r4, r5);
    L6:
        e = move-exception;
        e.printStackTrace();
        r8.b("PiDBProvider", "update fail!");
        return -1;
    L11:
        return -1;
    }
}
