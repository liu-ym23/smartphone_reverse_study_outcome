package com.ss.android.token;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f12253a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12254b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<String> f12255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<v> f12256d;

    static {
        f12255c = Collections.synchronizedSet(new HashSet());
        f12256d = new ArrayList();
    }

    public static void a(e r0) {
        p.u(r0);
    }

    @SuppressLint({"[ByDesign9.6]GetXTTToken"})
    public static h b(String r1, String r2) {
        return c(r1, r2, null);
    }

    public static h c(String r2, String r3, List<m> r4) {
        if (f12253a == false) goto L20;
        h r5 = p.K().w(r2, r3, r4);
        if (f12256d == null) goto L19;
        if (r5 != null) goto L9;
        r5 = new h();
    L9:
        if (r5.f12210a != null) goto L11;
        r5.f12210a = new HashMap();
    L11:
        Map<String, String> r6 = r5.f12210a;
        Iterator<v> r0 = f12256d.iterator();
    L13:
        if (r0.hasNext() == false) goto L19;
        v r1 = r0.next();
        if (r1 == null) goto L13;
        Map<String, String> r7 = r1.a(r2);
        if (r7 == null) goto L13;
        r6.putAll(r7);
    L19:
        return r5;
    L20:
        return null;
    }

    public static Map<String, String> d(String r1) {
        h r2 = b(r1, null);
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.f12210a;
    }

    public static String e() {
        if (n() == true) goto L5;
        return null;
    L5:
        return p.K().L();
    }

    public static g f() {
        if (f12253a == true) goto L5;
        return null;
    L5:
        return p.K().M();
    }

    public static void g(d r1) {
        p.K().R(r1);
    }

    public static String h(boolean r1, boolean r2, String r3) {
        return p.K().T(r1, r2, r3);
    }

    @SuppressLint({"[ByDesign9.6]GetXTTToken"})
    public static t i() {
        if (n() == true) goto L5;
        return null;
    L5:
        return p.K().U();
    }

    public static String j() {
        t r0 = i();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.f12309a;
    }

    public static void k() {
        if (f12253a == false) goto L6;
        p.K().a0("settings_update");
        return;
    }

    public static void l(Context r0, l r1) {
        com.bytedance.android.sdk.bdticketguard.n1.k.h();
        p.e0(r0, r1);
        u();
    }

    public static boolean m(String r1, String r2) {
        if (n() == true) goto L5;
        return false;
    L5:
        return p.K().f0(r1, r2);
    }

    public static boolean n() {
        return f12253a;
    }

    public static void o(String r10, List<m> r11, long r12, long r14, long r16) {
        if (f12253a == false) goto L6;
        p.K().p0(r10, r11, r12, r14, r16);
        return;
    }

    public static void p(String r1, List<m> r2, boolean r3) {
        if (f12253a == false) goto L6;
        p.K().u0(r1, r2, r3);
        return;
    }

    public static void q(Context r0, l r1, @NonNull com.ss.android.d r2) {
        com.bytedance.android.sdk.bdticketguard.n1.k.d();
        p.y0(r0, r1, r2);
        u();
    }

    public static void r(String r1) {
        if (f12253a == true) goto L6;
        return;
    L6:
        if (com.bytedance.sdk.account.settings.f.a.y() == true) goto L8;
        return;
    L8:
        if (com.bytedance.sdk.account.settings.f.a.D(r1) == false) goto L12;
        p.K().C0();
        return;
    }

    public static void s(String r1, int r2) {
        if (f12253a == true) goto L6;
        return;
    L6:
        if (r2 == 200) goto L8;
        return;
    L8:
        if (com.bytedance.sdk.account.settings.f.a.y() == true) goto L10;
        return;
    L10:
        if (com.bytedance.sdk.account.settings.f.a.D(r1) == false) goto L15;
        p.K().C();
        return;
    }

    public static void t(String r1, h r2, @Nullable List<m> r3, List<m> r4, long r5) {
        if (f12253a == true) goto L5;
        return;
    L5:
        p.K().t0(r1, r4, r5);
        p.K().A0(r1, r2, r3, r4);
        List<v> r6 = f12256d;
        if (r6 == null) goto L13;
        Iterator<v> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L19;
        v r8 = r7.next();
        if (r8 == null) goto L9;
        r8.b(r1, r4);
        goto L9
    L19:
        return;
    }

    private static synchronized void u() {
        monitor-enter(n.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f12253a == true) goto L10;
        p.K().F0(f12254b);     // Catch: Throwable -> L12
        if (f12255c.isEmpty() == true) goto L9;
        p.K().t(f12255c);     // Catch: Throwable -> L12
        f12255c.clear();     // Catch: Throwable -> L12
        f12255c = null;     // Catch: Throwable -> L12
    L9:
        f12253a = true;     // Catch: Throwable -> L12
        o.o();     // Catch: Throwable -> L12
        d.b.s.a.a0.a.d("TTTokenManager", "TTTokenManager initialize finish");     // Catch: Throwable -> L12
    L10:
        monitor-exit(n.class);
    }

    public static void v() {
        if (f12253a == false) goto L6;
        p.K().J0();
        return;
    }

    public static void w() {
        if (f12253a == false) goto L6;
        p.K().K0();
        return;
    }

    public static void x() {
        if (f12253a == false) goto L6;
        p.K().L0();
        return;
    }

    public static void y() {
        if (f12253a == false) goto L5;
        d.b.s.a.a0.a.a("TTTokenManager", "updateToken called");
        p.K().P0(false, false);
        return;
    L5:
        d.b.s.a.a0.a.a("TTTokenManager", "updateToken called before inited");
    }
}
