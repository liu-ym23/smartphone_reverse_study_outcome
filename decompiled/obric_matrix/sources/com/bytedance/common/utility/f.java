package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3263a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f3264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f3265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Printer f3267e;

    public interface a {
        void a(long r1);
    }

    static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f3268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f3269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<Printer> f3270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f3271d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f3272e;

        b() {
            this.f3268a = new ArrayList();
            this.f3269b = new ArrayList();
            this.f3270c = new ArrayList();
            this.f3271d = false;
            this.f3272e = false;
        }

        @Override // android.util.Printer
        public void println(String r9) {
            if (TextUtils.isEmpty(r9) == false) goto L6;
            return;
        L6:
            if (f.a() == null) goto L8;
            long r3 = System.currentTimeMillis();
        L10:
            if (r9.charAt(0) != '>') goto L21;
            if (this.f3272e == false) goto L21;
            Iterator<Printer> r5 = this.f3270c.iterator();
        L15:
            if (r5.hasNext() == false) goto L19;
            Printer r6 = r5.next();
            if (this.f3268a.contains(r6) == true) goto L15;
            this.f3268a.add(r6);
            goto L15
        L19:
            this.f3270c.clear();
            this.f3272e = false;
        L21:
            if (this.f3268a.size() <= f.b()) goto L23;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r7 = this.f3268a.iterator();
        L25:
            if (r7.hasNext() == false) goto L30;
            Printer r8 = r7.next();
            if (r8 == null) goto L25;
            r8.println(r9);
            goto L25
        L30:
            if (r9.charAt(0) != '<') goto L39;
            if (this.f3271d == false) goto L39;
            Iterator<Printer> r10 = this.f3269b.iterator();
        L35:
            if (r10.hasNext() == false) goto L37;
            Printer r11 = r10.next();
            this.f3268a.remove(r11);
            this.f3270c.remove(r11);
            goto L35
        L37:
            this.f3269b.clear();
            this.f3271d = false;
        L39:
            if (f.a() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            f.a().a(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }
    }

    static {
    }

    static /* synthetic */ a a() {
        return f3265c;
    }

    static /* synthetic */ int b() {
        return f3263a;
    }

    public static void c(Printer r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (f3264b.f3270c.contains(r1) == true) goto L8;
        f3264b.f3270c.add(r1);
        f3264b.f3272e = true;
        return;
    }

    private static Printer d() {
        Field r0 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r0.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static List<Printer> e() {
        b r0 = f3264b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.f3268a;
    }

    public static void f() {
        if (f3266d == false) goto L5;
        return;
    L5:
        f3266d = true;
        f3264b = new b();
        Printer r0 = d();
        f3267e = r0;
        if (r0 == null) goto L8;
        f3264b.f3268a.add(r0);
    L8:
        Looper.getMainLooper().setMessageLogging(f3264b);
    }

    public static void g(Printer r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (f3264b.f3269b.contains(r1) == true) goto L8;
        f3264b.f3269b.add(r1);
        f3264b.f3271d = true;
        return;
    }
}
