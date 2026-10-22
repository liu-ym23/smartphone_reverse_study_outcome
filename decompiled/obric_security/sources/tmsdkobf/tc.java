package tmsdkobf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public abstract class tc {
    private static Class g;
    private static Method h;
    private static Method i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f529a;
    private final SQLiteDatabase.CursorFactory b;
    private final int c;
    private final String d;
    private SQLiteDatabase e;
    private boolean f;

    static {
    }

    public tc(Context r2, String r3, SQLiteDatabase.CursorFactory r4, int r5, String r6) {
        this.e = null;
        this.f = false;
        if (r5 < 1) goto L17;
        monitor-enter(tc.class);
        this.f529a = r3;     // Catch: Throwable -> L13
        this.b = r4;     // Catch: Throwable -> L13
        this.c = r5;     // Catch: Throwable -> L13
        this.d = r6;     // Catch: Throwable -> L13
        Class<?> r1 = Class.forName("android.database.sqlite.SQLiteDatabase");     // Catch: Exception -> L9 Throwable -> L13
        g = r1;     // Catch: Exception -> L9 Throwable -> L13
        h = r1.getDeclaredMethod("lock", new Class[0]);     // Catch: Exception -> L9 Throwable -> L13
        i = g.getDeclaredMethod("unlock", new Class[0]);     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(tc.class);     // Catch: Throwable -> L13
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("Version must be >= 1, was " + r5);
    }

    public void a() {
        monitor-enter(tc.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f == true) goto L14;
        SQLiteDatabase r1 = this.e;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
    L11:
        monitor-exit(tc.class);     // Catch: Throwable -> L15
        return;
    L9:
        if (r1.isOpen() == false) goto L11;
        this.e.close();     // Catch: Throwable -> L15
        this.e = null;     // Catch: Throwable -> L15
        goto L11
    L14:
        throw new IllegalStateException("Closed during initialization");     // Catch: Throwable -> L15
    }

    public abstract void a(SQLiteDatabase r1);

    public abstract void a(SQLiteDatabase r1, int r2, int r3);

    public SQLiteDatabase b() {
        monitor-enter(tc.class);
        SQLiteDatabase r1 = this.e;     // Catch: Throwable -> L72
        if (r1 == null) goto L14;
        if (r1.isOpen() == false) goto L14;
        if (this.e.isReadOnly() == true) goto L14;
        SQLiteDatabase r7 = this.e;     // Catch: Throwable -> L72
        monitor-exit(tc.class);     // Catch: Throwable -> L72
        return r7;
    L14:
        if (this.f == true) goto L71;
        SQLiteDatabase r2 = this.e;     // Catch: Throwable -> L72
        if (r2 != null) goto L85;
    L22:
        SQLiteDatabase r3 = null;
        this.f = true;     // Catch: Throwable -> L55 SQLiteException -> L62
        String r4 = this.f529a;     // Catch: Throwable -> L55 SQLiteException -> L62
        if (r4 != null) goto L26;
        SQLiteDatabase r5 = SQLiteDatabase.create(null);     // Catch: Throwable -> L55 SQLiteException -> L62
    L27:
        if (r5 != null) goto L94;
        this.f = false;     // Catch: Throwable -> L72
        SQLiteDatabase r8 = this.e;     // Catch: Throwable -> L72
        if (r8 != null) goto L87;
    L31:
        if (r5 == null) goto L33;
        r5.close();     // Catch: Throwable -> L72
    L33:
        monitor-exit(tc.class);     // Catch: Throwable -> L72
        return null;
    L87:
        i.invoke(r8, new Object[0]);     // Catch: Exception -> L75 Throwable -> L72
        goto L31
    L94:
        int r6 = r5.getVersion();     // Catch: Throwable -> L53 SQLiteException -> L78
        if (r6 == this.c) goto L46;
        r5.beginTransaction();     // Catch: Throwable -> L53 SQLiteException -> L78
        if (r6 != 0) goto L40;
        a(r5);     // Catch: Throwable -> L43
    L41:
        r5.setVersion(this.c);     // Catch: Throwable -> L43
        r5.setTransactionSuccessful();     // Catch: Throwable -> L43
        r5.endTransaction();     // Catch: Throwable -> L53 SQLiteException -> L78
        goto L46
    L40:
        a(r5, r6, this.c);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r5.endTransaction();     // Catch: Throwable -> L53 SQLiteException -> L78
        throw th;     // Catch: Throwable -> L53 SQLiteException -> L78
    L46:
        b(r5);     // Catch: Throwable -> L53 SQLiteException -> L78
        this.f = false;     // Catch: Throwable -> L72
        SQLiteDatabase r9 = this.e;     // Catch: Throwable -> L72
        if (r9 != null) goto L82;
    L50:
        this.e = r5;     // Catch: Throwable -> L72
        monitor-exit(tc.class);     // Catch: Throwable -> L72
        return r5;
    L82:
        r9.close();     // Catch: Exception -> L76 Throwable -> L72
        i.invoke(this.e, new Object[0]);     // Catch: Exception -> L76 Throwable -> L72
    L53:
        th = move-exception;
        r3 = r5;
        th = th;
    L56:
        this.f = false;     // Catch: Throwable -> L72
        SQLiteDatabase r10 = this.e;     // Catch: Throwable -> L72
        if (r10 != null) goto L91;
    L59:
        if (r3 == null) goto L95;
        r3.close();     // Catch: Throwable -> L72
        throw th;     // Catch: Throwable -> L72
    L95:
        throw th;     // Catch: Throwable -> L72
    L91:
        i.invoke(r10, new Object[0]);     // Catch: Exception -> L77 Throwable -> L72
    L63:
        this.f = false;     // Catch: Throwable -> L72
        SQLiteDatabase r11 = this.e;     // Catch: Throwable -> L72
        if (r11 != null) goto L89;
    L66:
        if (r5 == null) goto L68;
        r5.close();     // Catch: Throwable -> L72
    L68:
        monitor-exit(tc.class);     // Catch: Throwable -> L72
        return null;
    L89:
        i.invoke(r11, new Object[0]);     // Catch: Exception -> L79 Throwable -> L72
        goto L66
    L26:
        r5 = SQLiteDatabase.openOrCreateDatabase(a(r4).getPath(), this.b);     // Catch: Throwable -> L55 SQLiteException -> L62
    L62:
        r5 = null;
    L55:
        th = th;
        goto L56
    L85:
        h.invoke(r2, new Object[0]);     // Catch: Exception -> L20 Throwable -> L72
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L72
        goto L22
    L71:
        throw new IllegalStateException("getWritableDatabase called recursively");     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    }

    public void b(SQLiteDatabase r1) {
    }

    public File a(String r3) {
        File r0 = new File(this.d);
        if (r0.exists() == true) goto L6;
        r0.mkdirs();
    L6:
        return new File(this.d + r3);
    }
}
