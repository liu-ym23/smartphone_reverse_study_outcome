package com.bytedance.applog.r;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2354b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2355a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<JSONObject> f2357b;

        a() {
            this.f2356a = 0;
            this.f2357b = new ArrayList();
        }
    }

    static {
        f2354b = System.getProperty("line.separator", "\n");
    }

    d(Context r2, String r3) {
        this.f2355a = r2.getFilesDir() + "/" + r3 + "monitor_file";
    }

    private void a(Closeable r1) {
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private a d(String r7) {
        a r0 = new a();
        if (new File(r7).exists() == true) goto L5;
        return r0;
    L5:
        Closeable r1 = null;
        FileInputStream r2 = new FileInputStream(r7);     // Catch: Throwable -> L26 Exception -> L30
        InputStreamReader r8 = new InputStreamReader(r2, "UTF-8");     // Catch: Throwable -> L23 Exception -> L25
    L40:
        BufferedReader r3 = new BufferedReader(r8);     // Catch: Throwable -> L21 Exception -> L33
        int r4 = 0;
    L36:
        String r5 = r3.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L16;
        if (r4 != 0) goto L14;
        r0.f2356a = Long.parseLong(r5);     // Catch: Throwable -> L18 Exception -> L20
    L15:
        r4 = r4 + 1;
        goto L36
    L14:
        r0.f2357b.add(new JSONObject(r5));     // Catch: Throwable -> L18 Exception -> L20
        goto L15
    L16:
        a(r3);
        a(r8);
        a(r2);
        return r0;
    L20:
        r1 = r3;
    L18:
        th = th;
        r1 = r3;
    L28:
        a(r1);
        a(r8);
        a(r2);
        throw th;
    L21:
        th = th;
    L31:
        a(r1);
        a(r8);
        a(r2);
        return r0;
    L25:
        r8 = null;
    L23:
        th = th;
        r8 = null;
        goto L28
    L30:
        r8 = null;
        r2 = null;
    L26:
        th = th;
        r8 = null;
        r2 = null;
        goto L28
    }

    private void f(String r4, long r5, List<JSONObject> r7) {
        Closeable r0 = null;
        FileOutputStream r1 = new FileOutputStream(r4);     // Catch: Throwable -> L21
        OutputStreamWriter r6 = new OutputStreamWriter(r1, "UTF-8");     // Catch: Throwable -> L20
        BufferedWriter r2 = new BufferedWriter(r6);     // Catch: Throwable -> L25
        r2.write(r5 + f2354b);     // Catch: Throwable -> L19
        if (r7 != null) goto L9;
    L17:
        a(r2);
        a(r6);
        a(r1);
        return;
    L9:
        if (r7.size() == 0) goto L17;
        int r8 = 0;
    L13:
        if (r8 >= r7.size()) goto L16;
        r2.write(r7.get(r8).toString() + f2354b);     // Catch: Throwable -> L19
        r8 = r8 + 1;
        goto L13
    L16:
        a(r2);
    L23:
        a(r6);
        a(r1);
        return;
    L19:
        r0 = r2;
    L22:
        a(r0);
    L20:
        r6 = null;
    L21:
        r6 = null;
        r1 = null;
        goto L22
    }

    void b() {
        File r0 = new File(this.f2355a);
        if (r0.exists() == false) goto L6;
        r0.delete();
        return;
    }

    a c() {
        return d(this.f2355a);
    }

    void e(long r2, List<JSONObject> r4) {
        f(this.f2355a, r2, r4);
    }
}
