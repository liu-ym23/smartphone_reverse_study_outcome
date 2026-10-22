package com.bytedance.ttnet.s;

import android.content.SharedPreferences;
import android.text.TextUtils;
import d.b.h.a.a.h.s.j;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f6609a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<b> f6610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ReentrantReadWriteLock f6611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Lock f6612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Lock f6613e;

    /* JADX INFO: renamed from: com.bytedance.ttnet.s.a$a, reason: collision with other inner class name */
    public static class C0203a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6615b;

        public C0203a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Pattern f6616a;

        public b() {
        }

        public boolean a(URI r4) {
            if (r4 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r4.getHost()) == true) goto L14;
            if (this.f6616a == null) goto L14;
            String r1 = r4.getHost();
            if (TextUtils.isEmpty(r4.getPath()) == true) goto L16;
            r1 = r1 + r4.getPath();
        L16:
            return this.f6616a.matcher(r1).matches();
        }

        public boolean b(String r1) {
            this.f6616a = Pattern.compile(r1);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static {
        f6610b = new ArrayList();
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        f6611c = r0;
        f6612d = r0.readLock();
        f6613e = f6611c.writeLock();
    }

    private static boolean a(URI r2) {
        f6612d.lock();     // Catch: Throwable -> L12
        Iterator<b> r0 = f6610b.iterator();     // Catch: Throwable -> L12
    L4:
        if (r0.hasNext() == false) goto L10;
        goto L4
    L7:
        if (r0.next().a(r2) == false) goto L4;
        f6612d.unlock();
        return true;
    L10:
        f6612d.unlock();
        return false;
    L12:
        th = move-exception;
        f6612d.unlock();
        throw th;
    }

    private static String b() {
        return UUID.randomUUID().toString();
    }

    private static String c(URI r0) {
        if (a(r0) == true) goto L5;
        return null;
    L5:
        return b();
    }

    public static void d(SharedPreferences r3) {
        int r0 = r3.getInt("ttnet_response_verify_enabled", -1);
        String r4 = r3.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r4) == false) goto L10;
    L6:
        JSONArray r1 = null;
    L7:
        j(r0, r1);
        return;
    L10:
        r1 = new JSONArray(r4);     // Catch: Throwable -> L9
        goto L7
    }

    public static C0203a e(JSONObject r2) {
        int r0 = r2.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r3 = r2.optJSONArray("ttnet_response_verify");
        if (r3 == null) goto L5;
        String r1 = r3.toString();
    L6:
        j(r0, r3);
        C0203a r4 = new C0203a();
        r4.f6614a = r0;
        r4.f6615b = r1;
        return r4;
    L5:
        r1 = "";
        goto L6
    }

    public static void f(d.b.r.h0.c r1, d.b.r.h0.d r2, com.bytedance.ttnet.m.b r3) {
        if (f6609a == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        g(r1, r2, r3);
    }

    private static void g(d.b.r.h0.c r3, d.b.r.h0.d r4, com.bytedance.ttnet.m.b r5) {
        d.b.r.h0.b r1 = r3.u("X-TT-VERIFY-ID");
        String r2 = null;
        if (r1 == null) goto L5;
        String r6 = r1.b();
    L6:
        d.b.r.h0.b r0 = r4.c("X-TT-VERIFY-ID");
        if (r0 == null) goto L9;
        r2 = r0.b();
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (r2 != null) goto L15;
        int r7 = 1;
    L13:
        r5.e0 = r7;
    L19:
        c.a r8 = c.b();
        if (r8 == null) goto L23;
        r8.a(r3.G(), r5);
    L23:
        if (r5.e0 == 3) goto L26;
        return;
    L26:
        throw new d.b.h.a.a.h.l.a("Fail to verify cdn cache");
    L15:
        if (r6.equals(r2) == false) goto L17;
        r7 = 2;
        goto L13
    L17:
        r5.e0 = 3;
        r4.a().d().close();     // Catch: Throwable -> L28
        goto L19
    L5:
        r6 = null;
        goto L6
    }

    public static void h(String r1, List<d.b.r.h0.b> r2) {
        if (f6609a == true) goto L5;
        return;
    L5:
        i(r1, r2);
    }

    private static void i(String r2, List<d.b.r.h0.b> r3) {
        String r4 = c(j.b(r2));     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r3.add(new d.b.r.h0.b("X-TT-VERIFY-ID", r4));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static void j(int r4, JSONArray r5) {
        int r0 = 0;
        if (r4 <= 0) goto L16;
        ArrayList r6 = new ArrayList();
        if (r5 == null) goto L15;
        int r1 = r5.length();
    L7:
        if (r0 >= r1) goto L14;
        String r2 = r5.optString(r0);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        b r3 = new b();
        if (r3.b(r2) == false) goto L13;
        r6.add(r3);
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        l(r6);
    L15:
        k(true);
        return;
    L16:
        k(false);
    }

    public static void k(boolean r0) {
        f6609a = r0;
    }

    public static void l(List<b> r1) {
        f6613e.lock();     // Catch: Throwable -> L5
        f6610b = r1;     // Catch: Throwable -> L5
        f6613e.unlock();
        return;
    L5:
        th = move-exception;
        f6613e.unlock();
        throw th;
    }
}
