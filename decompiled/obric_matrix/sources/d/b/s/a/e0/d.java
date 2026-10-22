package d.b.s.a.e0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.g;
import kotlin.u0.i;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Object> f14718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Map<String, Object>> f14719b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f14720c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14723c;

        public a(String r2, String r3, String r4) {
            o.g(r2, "sdkName");
            o.g(r3, "expectedVersion");
            o.g(r4, "actualVersion");
            this.f14721a = r2;
            this.f14722b = r3;
            this.f14723c = r4;
        }

        public final String a() {
            return this.f14723c;
        }

        public final String b() {
            return this.f14722b;
        }

        public final String c() {
            return this.f14721a;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (o.a(this.f14721a, r4.f14721a) == true) goto L8;
            return false;
        L8:
            if (o.a(this.f14722b, r4.f14722b) == true) goto L10;
            return false;
        L10:
            if (o.a(this.f14723c, r4.f14723c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.f14721a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14722b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f14723c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "MismatchInfo(sdkName=" + this.f14721a + ", expectedVersion=" + this.f14722b + ", actualVersion=" + this.f14723c + ")";
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f14724f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f14725g;

        b(int r1, l r2) {
            this.f14724f = r1;
            this.f14725g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map r0 = d.b(d.f14720c, this.f14724f);
            ArrayList r1 = new ArrayList();
            Iterator r2 = r0.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L14;
            Map.Entry r3 = (Map.Entry) r2.next();
            String r4 = (String) r3.getKey();
            String r5 = r3.getValue().toString();
            d r6 = d.f14720c;
            String r7 = d.c(r6, r4);
            if (r7 == null) goto L10;
            if (d.a(r6, r7, r5) >= 0) goto L4;
        L10:
            if (r7 != null) goto L13;
            r7 = "Unknown";
        L13:
            r1.add(new a(r4, r5, r7));
            goto L4
        L14:
            this.f14725g.invoke(r1);
        }
    }

    static {
        f14720c = new d();
        f14718a = m0.k(new u[]{a0.a("mssdk", 67699200), a0.a("bdturing", "3.7.5"), a0.a("ttnet", "4.2.223.13")});
        f14719b = new LinkedHashMap();
    }

    private d() {
    }

    public static final /* synthetic */ int a(d r0, String r1, String r2) {
        return r0.e(r1, r2);
    }

    public static final /* synthetic */ Map b(d r0, int r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ String c(d r0, String r1) {
        return r0.i(r1);
    }

    private final int e(String r2, String r3) {
        Integer r1 = k.i(r2);
        Integer r0 = k.i(r3);
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        return r1.intValue() - r0.intValue();
    L8:
        return d.b.s.a.s.e.a.b(r2, r3);
    }

    private final Map<String, Object> f(int r1) {
        Map<String, Object> r0 = f14719b.get(Integer.valueOf(r1));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return f14718a;
    }

    private final String g() {
        Object r1 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils").getDeclaredMethod("getVersionName", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L8
        d.b.s.a.a0.a.d("SafetyLibVersionChecker", "getVersionByBDTuring: " + r1);     // Catch: Exception -> L8
        if ((r1 instanceof String) == true) goto L6;
        r1 = null;
    L6:
        return (String) r1;
    L8:
        e = move-exception;
        d.b.s.a.a0.a.b("SafetyLibVersionChecker", "getVersionByBDTuring error: " + e.getMessage());
        return null;
    }

    private final String h() {
        Object r1 = Class.forName("com.bytedance.mobsec.metasec.ml.d").getDeclaredMethod("versionInfo", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L20
        if (r1 == null) goto L6;
        String r2 = r1.toString();     // Catch: Exception -> L20
    L7:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        d.b.s.a.a0.a.d("SafetyLibVersionChecker", "getVersionByMSSDK: " + r2);     // Catch: Exception -> L20
        g r3 = i.b(new i("versionCode\\s+(\\d+)"), r2, 0, 2, null);     // Catch: Exception -> L20
        if (r3 == null) goto L17;
        List<String> r4 = r3.b();     // Catch: Exception -> L20
        if (r4 == null) goto L17;
        String r5 = r4.get(1);     // Catch: Exception -> L20
        if (r5 == null) goto L17;
    L18:
        d.b.s.a.a0.a.d("SafetyLibVersionChecker", "getVersionByMSSDK trim: " + r5);     // Catch: Exception -> L20
        return r5;
    L17:
        r5 = String.valueOf(0);     // Catch: Exception -> L20
        goto L18
    L6:
        r2 = null;
    L20:
        e = move-exception;
        d.b.s.a.a0.a.b("SafetyLibVersionChecker", "getVersionByMSSDK error: " + e.getMessage());
        return null;
    }

    private final String i(String r3) {
        int r0 = r3.hashCode();
        if (r0 == 104203476) goto L18;
        if (r0 == 110693149) goto L14;
        if (r0 == 985309939) goto L10;
        return "0.0.0";
    L10:
        if (r3.equals("bdturing") == true) goto L12;
        return "0.0.0";
    L12:
        return g();
    L14:
        if (r3.equals("ttnet") == true) goto L16;
        return "0.0.0";
    L16:
        return j();
    L18:
        if (r3.equals("mssdk") == true) goto L20;
        return "0.0.0";
    L20:
        return h();
    }

    private final String j() {
        Object r1 = Class.forName("d.b.h.a.a.i.a").getDeclaredField("VERSION_NAME").get(null);     // Catch: Exception -> L8
        if ((r1 instanceof String) == true) goto L6;
        r1 = null;
    L6:
        String r2 = (String) r1;     // Catch: Exception -> L8
        d.b.s.a.a0.a.d("SafetyLibVersionChecker", "getVersionByTTNet: " + r2);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        d.b.s.a.a0.a.b("SafetyLibVersionChecker", "getVersionByTTNet error: " + e.getMessage());
        return null;
    }

    public final void d(int r1, l<? super List<a>, f0> r2) {
        o.g(r2, "onResult");
        com.bytedance.common.utility.m.c.c(new b(r1, r2));
    }
}
