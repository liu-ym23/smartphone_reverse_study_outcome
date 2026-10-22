package com.bytedance.apm.battery.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f1304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Integer> f1305d;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0040a {
    }

    public interface b<T> {
        T a(c r1);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Cursor f1306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, Integer> f1307b;

        private c(Cursor r1, HashMap<String, Integer> r2) {
            this.f1306a = r1;
            this.f1307b = r2;
        }

        /* synthetic */ c(Cursor r1, HashMap r2, C0040a r3) {
            this(r1, r2);
        }

        private int a(String r2) {
            Integer r0 = this.f1307b.get(r2);
            if (r0 != null) goto L9;
            r0 = Integer.valueOf(this.f1306a.getColumnIndex(r2));     // Catch: Throwable -> L6
        L7:
            this.f1307b.put(r2, r0);
        L6:
            r0 = -1;
        L9:
            return r0.intValue();
        }

        public int b(String r2) {
            return this.f1306a.getInt(a(r2));
        L4:
            return -1;
        }

        public long c(String r2) {
            return this.f1306a.getLong(a(r2));
        L4:
            return -1;
        }

        public String d(String r2) {
            return this.f1306a.getString(a(r2));
        L4:
            return "";
        }
    }

    protected a() {
        this.f1305d = new HashMap();
        Context r0 = d.h();
        this.f1302a = r0;
        this.f1303b = r0.getPackageName() + ".apm";
    }

    private static void h(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public abstract String[] b();

    public String c() {
        return "apm_monitor_t1.db";
    }

    public abstract String d();

    public Uri e() {
        if (this.f1304c != null) goto L6;
        this.f1304c = Uri.parse("content://" + this.f1303b + "/" + c() + "/" + d());
    L6:
        return this.f1304c;
    }

    public synchronized <I extends T> long f(ContentValues r5) {
        monitor-enter(this);
        if (r5 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r6 = d.h().getContentResolver().insert(e(), r5);     // Catch: Throwable -> L17 Exception -> L20
        if (r6 != null) goto L25;
        monitor-exit(this);
        return -1;
    L25:
        long r0 = Long.parseLong(r6.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r0;
    L14:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> g(String r9, String[] r10, String r11, b<T> r12) {
        Cursor r0 = null;
        Object[] r1 = 0;
        Cursor r13 = this.f1302a.getContentResolver().query(e(), b(), r9, r10, r11);     // Catch: Throwable -> L31
        if (r13 != null) goto L32;
    L25:
        List<T> r8 = Collections.emptyList();     // Catch: Throwable -> L28
        h(r13);
        return r8;
    L32:
    L28:
        r0 = r13;
        goto L29
    L6:
        if (r13.getCount() <= 0) goto L25;
        int r14 = Integer.MAX_VALUE;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        int r2 = r11.indexOf("LIMIT");     // Catch: Throwable -> L28
        if (r2 <= 0) goto L17;
        int r15 = r11.indexOf("OFF");     // Catch: Throwable -> L28
        int r3 = r2 + 5;     // Catch: Throwable -> L28
        if (r15 <= 0) goto L16;
        Integer r16 = Integer.valueOf(r11.substring(r3, r15).trim());     // Catch: Throwable -> L28
    L15:
        r14 = r16.intValue();     // Catch: Throwable -> L28
        goto L17
    L16:
        r16 = Integer.valueOf(r11.substring(r3).trim());     // Catch: Throwable -> L28
    L17:
        LinkedList r17 = new LinkedList();     // Catch: Throwable -> L28
        int r4 = 0;
    L19:
        if (r13.moveToNext() == false) goto L23;
        if (r4 >= r14) goto L23;
        r17.add(r12.a(new c(r13, this.f1305d, r1 == true ? 1 : 0)));     // Catch: Throwable -> L28
        r4 = r4 + 1;
    L23:
        h(r13);
        return r17;
    L29:
        h(r0);
        return Collections.emptyList();
    }

    public int i(ContentValues r3, String r4, String[] r5) {
        if (r3 != null) goto L8;
        return -1;
    L8:
        return d.h().getContentResolver().update(e(), r3, r4, r5);
    L7:
        return -1;
    }
}
