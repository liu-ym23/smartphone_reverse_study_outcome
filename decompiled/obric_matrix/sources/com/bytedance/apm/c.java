package com.bytedance.apm;

import android.content.Context;
import android.os.Build;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1313a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f1314b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1315c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1316d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static MappedByteBuffer f1317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static AtomicLong f1318f;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.config.d f1319f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1320g;

        a(com.bytedance.apm.config.d r1, JSONObject r2) {
            this.f1319f = r1;
            this.f1320g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.d.a.g(this.f1319f.e(), this.f1319f.f(), null, this.f1319f.b(), this.f1319f.d(), this.f1320g);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.config.d f1321f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1322g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1323h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f1324i;

        b(com.bytedance.apm.config.d r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.f1321f = r1;
            this.f1322g = r2;
            this.f1323h = r3;
            this.f1324i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r9 = new com.bytedance.apm.t.d.c(this.f1321f.e(), this.f1321f.f(), null, this.f1322g, this.f1323h, this.f1324i, this.f1321f.g()).c();
            if (r9 == null) goto L6;
            c.v("monitorEvent", r9.toString());
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.c$c, reason: collision with other inner class name */
    static class RunnableC0041c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1325f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1326g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1327h;

        RunnableC0041c(String r1, int r2, JSONObject r3) {
            this.f1325f = r1;
            this.f1326g = r2;
            this.f1327h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r8 = new com.bytedance.apm.t.d.c(this.f1325f, this.f1326g, null, null, null, this.f1327h).c();
            if (r8 == null) goto L6;
            c.v("monitorStatusRate", r8.toString());
            return;
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1328f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1329g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1330h;

        d(String r1, JSONObject r2, JSONObject r3) {
            this.f1328f = r1;
            this.f1329g = r2;
            this.f1330h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r8 = new com.bytedance.apm.t.d.c(this.f1328f, 0, this.f1329g, null, null, this.f1330h).c();
            if (r8 == null) goto L6;
            c.v("monitorDuration", r8.toString());
            return;
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1332g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1333h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f1334i;

        e(String r1, int r2, JSONObject r3, JSONObject r4) {
            this.f1331f = r1;
            this.f1332g = r2;
            this.f1333h = r3;
            this.f1334i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r8 = new com.bytedance.apm.t.d.c(this.f1331f, this.f1332g, this.f1333h, null, null, this.f1334i).c();
            if (r8 == null) goto L6;
            c.v("monitorStatusAndDuration", r8.toString());
            return;
        }
    }

    static class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1336g;

        f(String r1, JSONObject r2) {
            this.f1335f = r1;
            this.f1336g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d(this.f1335f, this.f1336g));
        }
    }

    static class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1338g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1339h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1340i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1341j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1342k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1343l;

        g(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
            this.f1337f = r1;
            this.f1338g = r3;
            this.f1339h = r5;
            this.f1340i = r6;
            this.f1341j = r7;
            this.f1342k = r8;
            this.f1343l = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.t.c.d.t().e(new com.bytedance.apm.t.d.a("api_all", this.f1337f, this.f1338g, this.f1339h, this.f1340i, this.f1341j, this.f1342k, c.a(this.f1343l, false)));
        }
    }

    static class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1345g;

        h(String r1, JSONObject r2) {
            this.f1344f = r1;
            this.f1345g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r2 = new com.bytedance.apm.t.d.d(this.f1344f, this.f1345g).c();
            if (r2 == null) goto L6;
            c.v("monitorExceptionLog", r2.toString());
            return;
        }
    }

    static class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1346f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1347g;

        i(String r1, JSONObject r2) {
            this.f1346f = r1;
            this.f1347g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.d.a.d(this.f1346f, this.f1347g);
        }
    }

    static class j implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1349g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f1350h;

        j(String r1, JSONObject r2, boolean r3) {
            this.f1348f = r1;
            this.f1349g = r2;
            this.f1350h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r3 = new com.bytedance.apm.t.d.b(this.f1348f, this.f1349g, this.f1350h).c();
            if (r3 == null) goto L6;
            c.v("monitorCommonLog", r3.toString());
            return;
        }
    }

    static class k implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1351f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1352g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1353h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1354i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1355j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1356k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1357l;

        k(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
            this.f1351f = r1;
            this.f1352g = r3;
            this.f1353h = r5;
            this.f1354i = r6;
            this.f1355j = r7;
            this.f1356k = r8;
            this.f1357l = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new com.bytedance.apm.t.d.a("api_all", this.f1351f, this.f1352g, this.f1353h, this.f1354i, this.f1355j, this.f1356k, this.f1357l).c();
            if (r12 == null) goto L6;
            c.v("monitorSLA", r12.toString());
            return;
        }
    }

    static class l implements Comparator<File> {
        l() {
        }

        public int a(File r3, File r4) {
            if (Build.VERSION.SDK_INT >= 19) goto L12;
            long r2 = r3.lastModified();
            long r0 = r4.lastModified();
            if (r2 >= r0) goto L7;
            return -1;
        L7:
            if (r2 != r0) goto L9;
            return 0;
        L9:
            return 1;
        L12:
            return Long.compare(r3.lastModified(), r4.lastModified());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r1, File r2) {
            return a(r1, r2);
        }
    }

    static class m implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1360h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1361i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1362j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1363k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1364l;

        m(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
            this.f1358f = r1;
            this.f1359g = r3;
            this.f1360h = r5;
            this.f1361i = r6;
            this.f1362j = r7;
            this.f1363k = r8;
            this.f1364l = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.t.c.d.t().e(new com.bytedance.apm.t.d.a("api_error", this.f1358f, this.f1359g, this.f1360h, this.f1361i, this.f1362j, this.f1363k, c.a(this.f1364l, false)));
        }
    }

    static class n implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1365f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1366g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1367h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1368i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1369j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1370k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1371l;

        n(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
            this.f1365f = r1;
            this.f1366g = r3;
            this.f1367h = r5;
            this.f1368i = r6;
            this.f1369j = r7;
            this.f1370k = r8;
            this.f1371l = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new com.bytedance.apm.t.d.a("api_error", this.f1365f, this.f1366g, this.f1367h, this.f1368i, this.f1369j, this.f1370k, this.f1371l).c();
            if (r12 == null) goto L6;
            c.v("monitorApiError", r12.toString());
            return;
        }
    }

    static class o implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1374h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f1375i;

        o(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.f1372f = r1;
            this.f1373g = r2;
            this.f1374h = r3;
            this.f1375i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r8 = new com.bytedance.apm.t.d.c(this.f1372f, 0, null, this.f1373g, this.f1374h, this.f1375i).c();
            if (r8 == null) goto L6;
            c.v("monitorEvent", r8.toString());
            return;
        }
    }

    public interface p {
        void a(float r1, float r2, String r3);
    }

    static {
        f1318f = new AtomicLong(0);
    }

    public c() {
    }

    static /* synthetic */ JSONObject a(JSONObject r0, boolean r1) {
        return r(r0, r1);
    }

    public static void b(String r8, long r9, long r11, String r13, com.bytedance.apm.p.e r14) {
        c(r8, r9, r11, r13, r14, null);
    }

    public static void c(String r9, long r10, long r12, String r14, com.bytedance.apm.p.e r15, com.bytedance.apm.p.d r16) {
        ApmDelegate.k().f(r9, r10, r12, r14, r15, r16);
    }

    private static void d(JSONObject r6) {
        if (r6 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put("_debug_uuid", com.bytedance.apm.d.A() + "_" + f1318f.getAndAdd(1));     // Catch: Exception -> L6
        r6.put("_debug_self", r0);     // Catch: Exception -> L6
        return;
    }

    private static JSONObject e(JSONObject r3) {
        if (r3 != null) goto L5;
        r3 = new JSONObject();
    L5:
        if (r3.isNull("timestamp") == true) goto L11;
    L10:
        return r3;
    L11:
        r3.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static boolean f(String r1) {
        return ApmDelegate.k().l(r1);
    }

    public static void g(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = s(r21);
        com.bytedance.apm.f0.b.f().i(new m(r13, r15, r17, r18, r19, r20, r10));
        if (com.bytedance.apm.d.E() == false) goto L6;
        com.bytedance.apm.f0.c.a().b(new n(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void h(String r1, JSONObject r2) {
        i(r1, r2, false);
    }

    public static void i(String r2, JSONObject r3, boolean r4) {
        if (d.b.b.d.a.n(r2, Boolean.FALSE) == false) goto L6;
        q(r2, r3);
        return;
    L6:
        JSONObject r5 = t(r3);
        d(r5);
        com.bytedance.apm.f0.b.f().i(new i(r2, r5));
        if (com.bytedance.apm.d.E() == false) goto L10;
        JSONObject r6 = r(r5, true);
        com.bytedance.apm.f0.c.a().b(new j(r2, r6, r4));
        return;
    }

    @Deprecated
    public static void j(String r2, JSONObject r3, JSONObject r4) {
        if (d.b.b.d.a.n(r2, Boolean.TRUE) == false) goto L6;
        q(r2, r3);
        return;
    L6:
        JSONObject r5 = t(r4);
        d(r5);
        if (f1316d == false) goto L9;
        JSONObject r0 = com.bytedance.apm.util.h.g(r3);
    L10:
        d.b.b.d.a.e(r2, r0, r5);
        if (com.bytedance.apm.d.E() == false) goto L14;
        JSONObject r6 = r(r3, true);
        JSONObject r7 = r(r5, true);
        com.bytedance.apm.f0.c.a().b(new d(r2, r6, r7));
        return;
    L14:
        return;
    L9:
        r0 = r3;
        goto L10
    }

    public static void k(com.bytedance.apm.config.d r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (d.b.b.d.a.n(r5.e(), Boolean.TRUE) == false) goto L8;
        q(r5.e(), null);
        return;
    L8:
        JSONObject r0 = e(r5.c());
        d(r0);
        com.bytedance.apm.f0.b.f().i(new a(r5, r0));
        if (com.bytedance.apm.d.E() == false) goto L12;
        JSONObject r1 = r(r5.b(), true);
        JSONObject r3 = r(r5.d(), true);
        JSONObject r2 = r(r0, true);
        com.bytedance.apm.f0.c.a().b(new b(r5, r1, r3, r2));
        return;
    }

    public static void l(String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (d.b.b.d.a.n(r3, Boolean.TRUE) == false) goto L6;
        q(r3, r4);
        return;
    L6:
        JSONObject r7 = t(r6);
        d(r7);
        d.b.b.d.a.h(r3, r(r4, true), r(r5, true), r7);
        if (com.bytedance.apm.d.E() == false) goto L10;
        JSONObject r8 = r(r4, true);
        JSONObject r9 = r(r5, true);
        JSONObject r10 = r(r7, true);
        com.bytedance.apm.f0.c.a().b(new o(r3, r8, r9, r10));
        return;
    }

    public static void m(String r2, JSONObject r3) {
        JSONObject r4 = t(r3);
        com.bytedance.apm.f0.b.f().i(new f(r2, r4));
        if (com.bytedance.apm.d.E() == false) goto L6;
        com.bytedance.apm.f0.c.a().b(new h(r2, r4));
        return;
    }

    public static void n(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = s(r21);
        com.bytedance.apm.f0.b.f().i(new g(r13, r15, r17, r18, r19, r20, r10));
        if (com.bytedance.apm.d.E() == false) goto L6;
        com.bytedance.apm.f0.c.a().b(new k(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    @Deprecated
    public static void o(String r4, int r5, JSONObject r6, JSONObject r7) {
        if (d.b.b.d.a.n(r4, Boolean.TRUE) == false) goto L6;
        q(r4, r6);
        return;
    L6:
        JSONObject r0 = s(r7);
        d(r0);
        d.b.b.d.a.j(r4, r5, r(r6, true), r(r0, false));
        if (com.bytedance.apm.d.E() == false) goto L10;
        JSONObject r8 = r(r6, true);
        JSONObject r9 = r(r7, true);
        com.bytedance.apm.f0.c.a().b(new e(r4, r5, r8, r9));
        return;
    }

    public static void p(String r2, int r3, JSONObject r4) {
        if (d.b.b.d.a.n(r2, Boolean.TRUE) == false) goto L6;
        q(r2, r4);
        return;
    L6:
        JSONObject r5 = t(r4);
        d(r5);
        d.b.b.d.a.l(r2, r3, r5);
        if (com.bytedance.apm.d.E() == false) goto L10;
        JSONObject r6 = r(r5, true);
        com.bytedance.apm.f0.c.a().b(new RunnableC0041c(r2, r3, r6));
        return;
    }

    private static void q(String r1, JSONObject r2) {
        if (com.bytedance.apm.d.C() == false) goto L8;
        if (r2 != null) goto L6;
        r2 = new JSONObject();
    L6:
        com.bytedance.apm.doctor.a.b(r1, r2, false);
        return;
    }

    private static JSONObject r(JSONObject r1, boolean r2) {
        if (f1313a == false) goto L8;
        if (r2 == true) goto L7;
        return r1;
    L7:
        return com.bytedance.apm.util.h.i(r1);
    L8:
        return com.bytedance.apm.util.h.b(r1);
    }

    private static JSONObject s(JSONObject r1) {
        if (f1313a == false) goto L6;
        return com.bytedance.apm.util.h.i(r1);
    L6:
        return t(r1);
    }

    private static JSONObject t(JSONObject r3) {
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r3;
    L6:
        if (r3.isNull("timestamp") == false) goto L8;
        r3.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void u(Context r0, long r1, long r3, boolean r5) {
    }

    public static void v(String r18, String r19) {
        monitor-enter(c.class);     // Catch: Throwable -> L40
        String r0 = com.bytedance.apm.d.i();     // Catch: Throwable -> L36
        long r2 = Thread.currentThread().getId();     // Catch: Throwable -> L36
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r6 = x.a();     // Catch: Throwable -> L36
        StringBuffer r7 = new StringBuffer();     // Catch: Throwable -> L36
        r7.append(r18);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r2);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r4);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r6);     // Catch: Throwable -> L36
        r7.append("\n");     // Catch: Throwable -> L36
        r7.append(r19);     // Catch: Throwable -> L36
        r7.append("\n");     // Catch: Throwable -> L36
        byte[] r3 = r7.toString().getBytes("UTF-8");     // Catch: Throwable -> L36
        String r5 = com.bytedance.apm.d.h().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (f1317e != null) goto L18;
        File r8 = new File(r5 + "/logs");     // Catch: Throwable -> L36
        f1314b = new File(r5 + "/logs/proc: " + r0);     // Catch: Throwable -> L36
        File r9 = new File(r5 + "/logs/proc: " + r0 + "/" + r6);     // Catch: Throwable -> L36
        if (r8.exists() == true) goto L10;
        r8.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (f1314b.exists() == true) goto L12;
        f1314b.mkdirs();     // Catch: Throwable -> L36
    L12:
        r9.createNewFile();     // Catch: Throwable -> L36
        FileChannel r12 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r13 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.G() == false) goto L15;
        long r16 = 2097152;
    L16:
        f1317e = r12.map(r13, 0, r16);     // Catch: Throwable -> L36
        goto L18
    L15:
        r16 = 262144;
    L18:
        if (f1317e.remaining() >= r3.length) goto L24;
        f1317e.force();     // Catch: Throwable -> L36
        FileChannel r11 = new RandomAccessFile(new File(r5 + "/logs/proc: " + r0 + "/" + r6), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r14 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.G() == false) goto L22;
        long r15 = 2097152;
    L23:
        f1317e = r11.map(r14, 0, r15);     // Catch: Throwable -> L36
        goto L24
    L22:
        r15 = 262144;
    L24:
        f1317e.put(r3);     // Catch: Throwable -> L36
        if (f1315c == (-1)) goto L29;
        if ((System.currentTimeMillis() - f1315c) > 3600000) goto L29;
    L34:
        monitor-exit(c.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (com.bytedance.apm.util.e.f(f1314b) <= 1073741824) goto L31;
    L32:
        w();     // Catch: Throwable -> L36
    L33:
        f1315c = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (com.bytedance.apm.util.e.e(com.bytedance.apm.d.h()).getFreeSpace() >= 1073741824) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    private static void w() {
        if (com.bytedance.apm.d.G() == true) goto L6;
        return;
    L6:
        if (f1314b.exists() == true) goto L8;
        return;
    L8:
        File[] r0 = f1314b.listFiles();
        Arrays.sort(r0, new l());
        int r2 = 60;
        if (r0.length > 60) goto L12;
        r2 = r0.length;
    L12:
        int r1 = 0;
    L13:
        if (r1 >= r2) goto L15;
        r0[r1].delete();
        r1 = r1 + 1;
        goto L13
    }
}
