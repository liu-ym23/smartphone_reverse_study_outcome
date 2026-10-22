package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends y>, y> f8008d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c0 f8009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f8010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y f8011c;

    static {
        f8008d = new HashMap();
    }

    public z(Context r3, y r4) {
        this.f8009a = new c0(r3.getApplicationContext(), r4.a(), r4);     // Catch: Throwable -> L5
    L7:
        this.f8011c = r4;
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    private static ContentValues a(Object r5, a0 r6) {
        ContentValues r0 = new ContentValues();
        Field[] r7 = l(r5.getClass(), r6.b());
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Field r3 = r7[r2];
        r3.setAccessible(true);
        j(r5, r3, r0);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private SQLiteDatabase b() {
    L6:
        th = move-exception;
        s.e(th, "dbs", "grd");
    L9:
        return this.f8010b;
    L3:
        if (this.f8010b != null) goto L9;
        this.f8010b = this.f8009a.getReadableDatabase();     // Catch: Throwable -> L6
        goto L9
    }

    public static synchronized y c(Class<? extends y> r3) {
        monitor-enter(z.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f8008d.get(r3) != null) goto L7;
        f8008d.put(r3, r3.newInstance());     // Catch: Throwable -> L10
    L7:
        y r4 = f8008d.get(r3);     // Catch: Throwable -> L10
        monitor-exit(z.class);
        return r4;
    }

    private static <T> T d(Cursor r6, Class<T> r7, a0 r8) {
        Field[] r9 = l(r7, r8.b());
        int r0 = 0;
        Constructor<T> r10 = r7.getDeclaredConstructor(new Class[0]);
        r10.setAccessible(true);
        T r11 = r10.newInstance(new Object[0]);
        int r2 = r9.length;
    L3:
        if (r0 >= r2) goto L18;
        Field r3 = r9[r0];
        r3.setAccessible(true);
        Annotation r4 = r3.getAnnotation(b0.class);
        if (r4 == null) goto L17;
        b0 r5 = (b0) r4;
        int r12 = r5.b();
        int r13 = r6.getColumnIndex(r5.a());
        switch(r12) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L17;
        };
    L9:
        r3.set(r11, r6.getBlob(r13));
        goto L17
    L10:
        Object r14 = r6.getString(r13);
    L16:
        r3.set(r11, r14);
        goto L17
    L11:
        r14 = Long.valueOf(r6.getLong(r13));
        goto L16
    L12:
        r14 = Double.valueOf(r6.getDouble(r13));
        goto L16
    L13:
        r14 = Float.valueOf(r6.getFloat(r13));
        goto L16
    L14:
        r14 = Integer.valueOf(r6.getInt(r13));
        goto L16
    L15:
        r14 = Short.valueOf(r6.getShort(r13));
    L17:
        r0 = r0 + 1;
        goto L3
    L18:
        return r11;
    }

    private static <T> String e(a0 r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    private static <T> void g(SQLiteDatabase r3, T r4) {
        a0 r0 = n(r4.getClass());
        String r1 = e(r0);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (r4 == null) goto L10;
        if (r3 == null) goto L11;
        r3.insert(r1, null, a(r4, r0));
        return;
    L11:
        return;
    }

    private <T> void h(T r1) {
        p(r1);
    }

    private static void j(Object r2, Field r3, ContentValues r4) {
        Annotation r0 = r3.getAnnotation(b0.class);
        if (r0 != null) goto L5;
        return;
    L5:
        b0 r1 = (b0) r0;
        switch(r1.b()) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L26;
        };
    L8:
        byte[] r5 = (byte[]) r3.get(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), r5);     // Catch: IllegalAccessException -> L21
        return;
    L9:
        String r6 = (String) r3.get(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), r6);     // Catch: IllegalAccessException -> L21
        return;
    L11:
        long r7 = r3.getLong(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), Long.valueOf(r7));     // Catch: IllegalAccessException -> L21
        return;
    L13:
        double r8 = r3.getDouble(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), Double.valueOf(r8));     // Catch: IllegalAccessException -> L21
        return;
    L15:
        float r9 = r3.getFloat(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), Float.valueOf(r9));     // Catch: IllegalAccessException -> L21
        return;
    L17:
        int r10 = r3.getInt(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), Integer.valueOf(r10));     // Catch: IllegalAccessException -> L21
        return;
    L19:
        short r11 = r3.getShort(r2);     // Catch: IllegalAccessException -> L21
        r4.put(r1.a(), Short.valueOf(r11));     // Catch: IllegalAccessException -> L21
        return;
    L26:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private <T> void k(String r5, Object r6) {
        y r0 = this.f8011c;
        monitor-enter(r0);
        if (r6 != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L7:
        a0 r1 = n(r6.getClass());     // Catch: Throwable -> L34
        String r2 = e(r1);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r2) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L11:
        ContentValues r7 = a(r6, r1);     // Catch: Throwable -> L34
        SQLiteDatabase r3 = m();     // Catch: Throwable -> L34
        this.f8010b = r3;     // Catch: Throwable -> L34
        if (r3 != null) goto L38;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L38:
        r3.update(r2, r7, r5, null);     // Catch: Throwable -> L22
        SQLiteDatabase r8 = this.f8010b;     // Catch: Throwable -> L34
        if (r8 == null) goto L27;
        r8.close();     // Catch: Throwable -> L34
    L20:
        this.f8010b = null;     // Catch: Throwable -> L34
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L22:
        th = move-exception;
        s.e(th, "dbs", "udd");     // Catch: Throwable -> L29
        SQLiteDatabase r9 = this.f8010b;     // Catch: Throwable -> L34
        if (r9 == null) goto L27;
        r9.close();     // Catch: Throwable -> L34
        goto L20
    L29:
        th = move-exception;
        SQLiteDatabase r10 = this.f8010b;     // Catch: Throwable -> L34
        if (r10 == null) goto L33;
        r10.close();     // Catch: Throwable -> L34
        this.f8010b = null;     // Catch: Throwable -> L34
    L33:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    private static Field[] l(Class<?> r0, boolean r1) {
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r1 == false) goto L9;
        return r0.getSuperclass().getDeclaredFields();
    L9:
        return r0.getDeclaredFields();
    }

    private SQLiteDatabase m() {
        SQLiteDatabase r0 = this.f8010b;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
    L6:
        SQLiteDatabase r1 = this.f8010b;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L11
    L9:
        this.f8010b = this.f8009a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.f8010b;
    L5:
        if (r0.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        s.e(th, "dbs", "gwd");
        goto L14
    }

    private static <T> a0 n(Class<T> r1) {
        Annotation r2 = r1.getAnnotation(a0.class);
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return (a0) r2;
    L5:
        r0 = false;
        goto L6
    }

    private <T> List<T> o(String r13, Class<T> r14) {
        y r0 = this.f8011c;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L80
        a0 r2 = n(r14);     // Catch: Throwable -> L80
        String r4 = e(r2);     // Catch: Throwable -> L80
        if (this.f8010b != null) goto L8;
        this.f8010b = b();     // Catch: Throwable -> L80
    L8:
        if (this.f8010b != null) goto L10;
    L78:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L78;
        if (r13 == null) goto L78;
        Cursor r15 = this.f8010b.query(r4, null, r13, null, null, null, null);     // Catch: Throwable -> L49
        if (r15 != null) goto L31;
        this.f8010b.close();     // Catch: Throwable -> L47
        this.f8010b = null;     // Catch: Throwable -> L47
        if (r15 == null) goto L99;
        r15.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
    L99:
        SQLiteDatabase r16 = this.f8010b;     // Catch: Throwable -> L26
        if (r16 == null) goto L28;
        r16.close();     // Catch: Throwable -> L26
        this.f8010b = null;     // Catch: Throwable -> L26
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L26:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
    L31:
        if (r15.moveToNext() == false) goto L34;
        r1.add(d(r15, r14, r2));     // Catch: Throwable -> L47
        goto L31
    L34:
        if (r15 == null) goto L97;
        r15.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
    L97:
        SQLiteDatabase r17 = this.f8010b;     // Catch: Throwable -> L43
        if (r17 == null) goto L63;
        r17.close();     // Catch: Throwable -> L43
        this.f8010b = null;     // Catch: Throwable -> L43
    L63:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L43:
        th = th;
        String r18 = "dbs";
        String r19 = "sld";
    L45:
        s.e(th, r18, r19);     // Catch: Throwable -> L80
    L47:
        th = th;
    L101:
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L65
        if (r15 == null) goto L89;
        r15.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
    L89:
        SQLiteDatabase r110 = this.f8010b;     // Catch: Throwable -> L61
        if (r110 == null) goto L63;
        r110.close();     // Catch: Throwable -> L61
        this.f8010b = null;     // Catch: Throwable -> L61
    L61:
        th = th;
        r18 = "dbs";
        r19 = "sld";
        goto L45
    L65:
        th = move-exception;
        if (r15 == null) goto L91;
        r15.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
    L91:
        SQLiteDatabase r111 = this.f8010b;     // Catch: Throwable -> L75
        if (r111 == null) goto L106;
        r111.close();     // Catch: Throwable -> L75
        this.f8010b = null;     // Catch: Throwable -> L75
    L107:
        throw th;     // Catch: Throwable -> L80
    L106:
        throw th;     // Catch: Throwable -> L80
    L75:
        th = move-exception;
        s.e(th, "dbs", "sld");     // Catch: Throwable -> L80
        throw th;     // Catch: Throwable -> L80
    L49:
        th = th;
        r15 = null;
    L80:
        th = move-exception;
        throw th;
    }

    private <T> void p(T r5) {
        y r0 = this.f8011c;
        monitor-enter(r0);
        SQLiteDatabase r1 = m();     // Catch: Throwable -> L27
        this.f8010b = r1;     // Catch: Throwable -> L27
        if (r1 != null) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L31:
        g(r1, r5);     // Catch: Throwable -> L15
        SQLiteDatabase r6 = this.f8010b;     // Catch: Throwable -> L27
        if (r6 == null) goto L20;
        r6.close();     // Catch: Throwable -> L27
    L13:
        this.f8010b = null;     // Catch: Throwable -> L27
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L15:
        th = move-exception;
        s.e(th, "dbs", "itd");     // Catch: Throwable -> L22
        SQLiteDatabase r7 = this.f8010b;     // Catch: Throwable -> L27
        if (r7 == null) goto L20;
        r7.close();     // Catch: Throwable -> L27
        goto L13
    L22:
        th = move-exception;
        SQLiteDatabase r2 = this.f8010b;     // Catch: Throwable -> L27
        if (r2 == null) goto L26;
        r2.close();     // Catch: Throwable -> L27
        this.f8010b = null;     // Catch: Throwable -> L27
    L26:
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private <T> void q(String r1, Object r2) {
        k(r1, r2);
    }

    public final <T> List<T> f(String r1, Class<T> r2) {
        return o(r1, r2);
    }

    public final void i(Object r3, String r4) {
        y r0 = this.f8011c;
        monitor-enter(r0);
        List r1 = f(r4, r3.getClass());     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L10:
        h(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (r1.size() == 0) goto L10;
        q(r4, r3);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
