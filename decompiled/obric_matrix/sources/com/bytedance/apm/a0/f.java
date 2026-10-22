package com.bytedance.apm.a0;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.o;
import com.bytedance.apm.util.y;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.a0.a {
    private static long C = 17179869184L;
    private static String D;
    private static String E;
    private y<c> A;
    private y<e> B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1141l;
    private com.bytedance.apm.w.f m;
    private String n;
    private String o;
    private long p;
    private long q;
    private long r;
    private long s;
    private boolean t;
    private List<b> u;
    private List<String> v;
    private List<String> w;
    private List<String> x;
    private List<String> y;
    private y<c> z;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1142f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f1143g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f1144h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f1145i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f1146j;

        a(f r1, long r2, List r4, List r5, List r6) {
            this.f1146j = r1;
            this.f1142f = r2;
            this.f1143g = r4;
            this.f1144h = r5;
            this.f1145i = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.p(this.f1146j).a(f.o(this.f1146j), this.f1142f, this.f1143g, this.f1144h, this.f1145i);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<b> f1152f;

        private b() {
            this.f1151e = "normal";
            this.f1152f = new ArrayList();
        }

        /* synthetic */ b(a r1) {
            this();
        }

        private String a() {
            String r2 = this.f1147a;
            if (r2.contains(f.A()) == false) goto L7;
            String r0 = f.A();
            String r1 = "internal";
        L9:
            return r2.replace(r0, r1);
        L7:
            if (r2.contains(f.q()) == false) goto L10;
            r0 = f.q();
            r1 = "external";
            goto L9
        L10:
            return r2;
        }

        public JSONObject b() {
            JSONObject r0 = new JSONObject();
            r0.put("path", a());     // Catch: JSONException -> L11
            r0.put("size", this.f1148b);     // Catch: JSONException -> L11
            r0.put("size_rate", this.f1149c);     // Catch: JSONException -> L11
            r0.put("is_folder", this.f1150d);     // Catch: JSONException -> L11
            r0.put("report_type", this.f1151e);     // Catch: JSONException -> L11
            if (this.f1152f.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<b> r4 = this.f1152f.iterator();     // Catch: JSONException -> L11
        L7:
            if (r4.hasNext() == false) goto L9;
            r1.put(r4.next().b());     // Catch: JSONException -> L11
            goto L7
        L9:
            r0.put("next_disk", r1);     // Catch: JSONException -> L11
        L13:
            return r0;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    private static class c implements Comparable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f1153f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f1154g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1155h;

        public c() {
        }

        public c(String r1, long r2, int r4) {
            this.f1153f = r1;
            this.f1154g = r2;
            this.f1155h = r4;
        }

        static /* synthetic */ String a(c r0) {
            return r0.f1153f;
        }

        private String b() {
            String r2 = this.f1153f;
            if (r2.contains(f.A()) == false) goto L7;
            String r0 = f.A();
            String r1 = "internal";
        L9:
            return r2.replace(r0, r1);
        L7:
            if (r2.contains(f.q()) == false) goto L10;
            r0 = f.q();
            r1 = "external";
            goto L9
        L10:
            return r2;
        }

        public JSONObject c() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", b());     // Catch: Exception -> L6
            r0.put("size", this.f1154g);     // Catch: Exception -> L6
            int r4 = this.f1155h;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put("num", r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.f1154g;
            long r3 = ((c) r4).f1154g;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }
    }

    private class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f1157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f1162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f1164i;

        private d(f r1) {
            this.f1164i = r1;
        }

        /* synthetic */ d(f r1, a r2) {
            this(r1);
        }

        static /* synthetic */ String a(d r0) {
            return r0.f1156a;
        }

        static /* synthetic */ String b(d r0, String r1) {
            r0.f1156a = r1;
            return r1;
        }

        static /* synthetic */ int c(d r0, int r1) {
            r0.f1159d = r1;
            return r1;
        }

        static /* synthetic */ int d(d r2) {
            int r0 = r2.f1159d;
            r2.f1159d = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean e(d r0) {
            return r0.f1161f;
        }

        static /* synthetic */ boolean f(d r0, boolean r1) {
            r0.f1161f = r1;
            return r1;
        }

        static /* synthetic */ long g(d r0, long r1) {
            r0.f1162g = r1;
            return r1;
        }

        private void i() {
            if (TextUtils.equals(this.f1156a, f.A()) == false) goto L6;
            f.u(this.f1164i, this.f1158c);
            return;
        L6:
            if (TextUtils.equals(this.f1156a, f.q()) == false) goto L9;
            f.v(this.f1164i, this.f1158c);
            return;
        L9:
            if (TextUtils.equals(this.f1156a, f.w(this.f1164i)) == false) goto L12;
            f.x(this.f1164i, this.f1158c);
            return;
        L12:
            if (TextUtils.equals(this.f1156a, f.y(this.f1164i)) == false) goto L18;
            f.z(this.f1164i, this.f1158c);
            return;
        }

        private boolean j() {
            if (this.f1160e != this.f1159d) goto L5;
            return true;
        L5:
            return false;
        }

        public void h(long r8) {
            this.f1158c += r8;
            this.f1160e++;
            if (this.f1157b != null) goto L5;
            return;
        L5:
            if (j() == true) goto L7;
            return;
        L7:
            if (this.f1163h == false) goto L10;
            this.f1157b.f1163h = true;
        L10:
            if (this.f1158c >= f.r(this.f1164i)) goto L12;
        L14:
            this.f1157b.h(this.f1158c);
            if (this.f1161f == false) goto L17;
            f.t(this.f1164i, this.f1156a, this.f1158c, this.f1159d, this.f1162g);
        L17:
            i();
            return;
        L12:
            if (this.f1163h == true) goto L14;
            f.s(this.f1164i, this.f1156a, this.f1158c, this.f1160e, this.f1159d);
            this.f1157b.f1163h = true;
            goto L14
        }
    }

    private static class e extends c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f1165i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f1166j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f1167k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f1168l;

        public e(String r1, long r2, int r4, long r5) {
            this.f1165i = r1;
            this.f1166j = r2;
            this.f1167k = r4;
            this.f1168l = r5;
        }

        private String b() {
            String r2 = this.f1165i;
            if (r2.contains(f.A()) == false) goto L7;
            String r0 = f.A();
            String r1 = "internal";
        L9:
            return r2.replace(r0, r1);
        L7:
            if (r2.contains(f.q()) == false) goto L10;
            r0 = f.q();
            r1 = "external";
            goto L9
        L10:
            return r2;
        }

        @Override // com.bytedance.apm.a0.f.c
        public JSONObject c() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", b());     // Catch: Exception -> L7
            r0.put("size", this.f1166j);     // Catch: Exception -> L7
            int r1 = this.f1167k;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put("num", r1);     // Catch: Exception -> L7
        L5:
            r0.put("outdate_interval", this.f1168l);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }

        @Override // com.bytedance.apm.a0.f.c, java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.f1168l;
            long r3 = ((e) r4).f1168l;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }
    }

    static {
    }

    public f() {
        this.f1138i = 524288000;
        this.f1139j = 524288000;
        this.f1140k = 20;
        this.f1141l = 2592000000L;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.f1122e = "disk";
    }

    static /* synthetic */ String A() {
        return D;
    }

    private void B(String r6, long r7) {
        if (com.bytedance.apm.d.C() == false) goto L6;
        com.bytedance.apm.x.e.b("MonitorStorage", new String[]{"appendExceptionFileQueue: path: " + r6 + ", size: " + r7});
    L6:
        if (r7 <= C) goto L9;
        return;
    L9:
        if (this.z != null) goto L11;
        this.z = new y(this.f1140k);
    L11:
        this.z.a(new c(r6, r7, 1));
    }

    private void C(String r3, long r4, int r6, int r7) {
        if (com.bytedance.apm.d.C() == false) goto L6;
        Log.d("MonitorStorage", "appendExceptionFolderQueue: path: " + r3 + ":  size: " + r4 + " , accumulateNum: " + r6 + " , num: " + r7);
    L6:
        if (r4 <= C) goto L9;
        return;
    L9:
        if (this.A != null) goto L11;
        this.A = new y(this.f1140k);
    L11:
        this.A.a(new c(r3, r4, r7));
    }

    private void D(String r9, long r10, int r12, long r13) {
        if (com.bytedance.apm.d.C() == false) goto L6;
        com.bytedance.apm.x.e.b("MonitorStorage", new String[]{"appendutdatedFileQueue: path: " + r9 + ", size: " + r10});
    L6:
        if (r10 >= WsConstants.DEFAULT_IO_LIMIT) goto L8;
        return;
    L8:
        if (r10 <= C) goto L11;
        return;
    L11:
        if (this.B != null) goto L13;
        this.B = new y(this.f1140k);
    L13:
        this.B.a(new e(r9, r10, r12, r13));
    }

    private long E(long r3) {
        return r3 / 1073741824;
    }

    private void F(File r10, int r11, boolean r12, List<b> r13) {
        if (r11 > 2) goto L49;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (this.x.contains(r10.getAbsolutePath()) == true) goto L53;
        int r3 = 0;
        a r4 = null;
        if (r10.isDirectory() == false) goto L38;
        if (r12 == false) goto L37;
        File[] r14 = r10.listFiles();
        if (r14 != null) goto L16;
        return;
    L16:
        if (r14.length == 0) goto L48;
        int r1 = r14.length;
    L19:
        if (r3 >= r1) goto L54;
        File r2 = r14[r3];
        if (r2 == null) goto L35;
        if (r2.exists() == false) goto L35;
        if (this.x.contains(r2.getAbsolutePath()) == true) goto L35;
        b r5 = new b(r4);
        r5.f1150d = r2.isDirectory();
        r5.f1147a = r2.getAbsolutePath();
        if (r2.isDirectory() == false) goto L33;
        ArrayList r6 = new ArrayList();
        r5.f1152f = r6;
        if (r11 != 2) goto L32;
        r5.f1148b = I(r2);
    L32:
        F(r2, r11 + 1, r12, r6);
    L34:
        r13.add(r5);
        goto L35
    L33:
        r5.f1148b = r2.length();
    L35:
        r3 = r3 + 1;
        goto L19
    L54:
        return;
    L48:
        return;
    L37:
        b r15 = new b(r4);
        r15.f1150d = true;
        r15.f1151e = "custom";
        r15.f1147a = r10.getAbsolutePath();
        r15.f1148b = I(r10);
        r13.add(r15);
        return;
    L38:
        b r9 = new b(r4);
        r9.f1150d = false;
        r9.f1147a = r10.getAbsolutePath();
        r9.f1148b = r10.length();
        if (r12 == true) goto L41;
        r9.f1151e = "custom";
    L41:
        r13.add(r9);
        return;
    L53:
        return;
    }

    private static List<String> H(y<? extends c> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r3 = r2.d().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(c.a((c) r3.next()));
        goto L7
    L9:
        return r0;
    }

    private long I(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L16
        if (r8 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r8.length == 0) goto L15;
        int r2 = r8.length;     // Catch: Exception -> L16
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        File r4 = r8[r3];     // Catch: Exception -> L16
        if (r4.isDirectory() == false) goto L13;
        long r5 = I(r4);     // Catch: Exception -> L16
    L14:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = r4.length();     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    private float J(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private void K() {
        G();     // Catch: Throwable -> L4
        P(this.p + this.q, this.r + this.s, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L4
        com.bytedance.apm.internal.b.a().f("check_disk_last_time", System.currentTimeMillis());     // Catch: Throwable -> L4
        return;
    }

    private void L() {
        P(com.bytedance.apm.util.b.m(com.bytedance.apm.d.h()), com.bytedance.apm.util.b.l(com.bytedance.apm.d.h()), com.bytedance.apm.util.b.d(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L4
        return;
    }

    private void M() {
        if (D == null) goto L5;
        return;
    L5:
        Context r0 = com.bytedance.apm.d.h();
        r0.getPackageName();     // Catch: Exception -> L35
        D = r0.getFilesDir().getParent();     // Catch: Exception -> L35
        this.n = r0.getCacheDir().getAbsolutePath();     // Catch: Exception -> L35
        E = r0.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L35
        File r1 = r0.getExternalCacheDir();     // Catch: Exception -> L35
        if (r1 == null) goto L9;
        this.o = r1.getAbsolutePath();     // Catch: Exception -> L35
    L9:
        List<String> r2 = this.w;     // Catch: Exception -> L35
        if (r2 == null) goto L22;
        Iterator<String> r3 = r2.iterator();     // Catch: Exception -> L35
    L14:
        if (r3.hasNext() == false) goto L22;
        String r4 = r3.next();     // Catch: Exception -> L35
        if (r4.contains("internal") == true) goto L17;
        if (r4.contains("external") == false) goto L14;
        List<String> r5 = this.x;     // Catch: Exception -> L35
        String r6 = r4.replace("external", E);     // Catch: Exception -> L35
    L18:
        r5.add(r6);     // Catch: Exception -> L35
        goto L14
    L17:
        r5 = this.x;     // Catch: Exception -> L35
        r6 = r4.replace("internal", D);     // Catch: Exception -> L35
    L22:
        List<String> r7 = this.v;     // Catch: Exception -> L35
        if (r7 == null) goto L51;
        Iterator<String> r8 = r7.iterator();     // Catch: Exception -> L35
    L25:
        if (r8.hasNext() == false) goto L52;
        String r9 = r8.next();     // Catch: Exception -> L35
        if (r9.contains("internal") == true) goto L29;
        if (r9.contains("external") == false) goto L25;
        List<String> r10 = this.y;     // Catch: Exception -> L35
        String r11 = r9.replace("external", E);     // Catch: Exception -> L35
    L30:
        r10.add(r11);     // Catch: Exception -> L35
        goto L25
    L29:
        r10 = this.y;     // Catch: Exception -> L35
        r11 = r9.replace("internal", D);     // Catch: Exception -> L35
        goto L30
    L52:
        return;
    L51:
        return;
    L35:
        this.t = true;
    }

    private boolean N(b r3) {
        Iterator<String> r2 = this.x.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r0 = r2.next();
        if (r3.f1147a.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private long O(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.f1141l) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private void P(long r8, long r10, long r12, long r14) {
        if (com.bytedance.apm.d.C() == false) goto L5;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2127c, new String[]{"disk: data: " + r8 + " , cache: " + r10 + " , total: " + r12 + " , free: " + r14});     // Catch: Exception -> L86
    L5:
        long r0 = C;     // Catch: Exception -> L86
        if (r8 <= r0) goto L8;
        long r2 = r0;
    L10:
        if (r10 > r0) goto L13;
        r0 = r10;
    L13:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L86
        if (r8 <= 0) goto L17;
        r4.put("data", r2);     // Catch: Exception -> L86
    L17:
        if (r10 <= 0) goto L20;
        r4.put(LocationMonitorConst.CACHE, r0);     // Catch: Exception -> L86
    L20:
        if (r12 <= 0) goto L23;
        r4.put("total", E(r12));     // Catch: Exception -> L86
    L23:
        if (r14 <= 0) goto L25;
        r4.put("rom_free", E(r14));     // Catch: Exception -> L86
    L25:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L86
        if (this.f1137h == true) goto L28;
    L84:
        k(new com.bytedance.apm.t.d.e("disk", "storageUsed", false, r4, null, r15));     // Catch: Exception -> L86
        return;
    L28:
        if (r2 <= this.f1138i) goto L84;
        if (this.z == null) goto L39;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L86
        Iterator r11 = this.z.d().iterator();     // Catch: Exception -> L86
    L33:
        if (r11.hasNext() == false) goto L37;
        JSONObject r13 = ((c) r11.next()).c();     // Catch: Exception -> L86
        if (r13 == null) goto L33;
        r9.put(r13);     // Catch: Exception -> L86
        goto L33
    L37:
        r15.put("top_usage", r9);     // Catch: Exception -> L86
    L39:
        if (this.A == null) goto L48;
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L86
        Iterator r17 = this.A.d().iterator();     // Catch: Exception -> L86
    L42:
        if (r17.hasNext() == false) goto L46;
        JSONObject r18 = ((c) r17.next()).c();     // Catch: Exception -> L86
        if (r18 == null) goto L42;
        r16.put(r18);     // Catch: Exception -> L86
        goto L42
    L46:
        r15.put("exception_folders", r16);     // Catch: Exception -> L86
    L48:
        if (this.B == null) goto L56;
        JSONArray r19 = new JSONArray();     // Catch: Exception -> L86
        Iterator r20 = this.B.d().iterator();     // Catch: Exception -> L86
    L51:
        if (r20.hasNext() == false) goto L55;
        JSONObject r110 = ((e) r20.next()).c();     // Catch: Exception -> L86
        if (r110 == null) goto L51;
        r19.put(r110);     // Catch: Exception -> L86
        goto L51
    L55:
        r15.put("outdated_files", r19);     // Catch: Exception -> L86
    L56:
        List<b> r21 = this.u;     // Catch: Exception -> L86
        if (r21 == null) goto L81;
        if (r21.isEmpty() == true) goto L81;
        BigDecimal r22 = new BigDecimal(r2);     // Catch: Exception -> L86
        JSONArray r23 = new JSONArray();     // Catch: Exception -> L86
        Iterator<b> r111 = this.u.iterator();     // Catch: Exception -> L86
    L62:
        if (r111.hasNext() == false) goto L79;
        b r112 = r111.next();     // Catch: Exception -> L86
        if (N(r112) == false) goto L66;
        r112.f1149c = 0.0f;     // Catch: Exception -> L86
    L67:
        List<b> r113 = r112.f1152f;     // Catch: Exception -> L86
        if (r113 == null) goto L78;
        if (r113.size() <= 0) goto L78;
        Iterator<b> r114 = r113.iterator();     // Catch: Exception -> L86
    L73:
        if (r114.hasNext() == false) goto L78;
        b r115 = r114.next();     // Catch: Exception -> L86
        if (N(r115) == true) goto L76;
        r115.f1149c = J(r115.f1148b, r22);     // Catch: Exception -> L86
        goto L73
    L76:
        r115.f1149c = 0.0f;     // Catch: Exception -> L86
    L78:
        r23.put(r112.b());     // Catch: Exception -> L86
        goto L62
    L66:
        r112.f1149c = J(r112.f1148b, r22);     // Catch: Exception -> L86
        goto L67
    L79:
        r15.put("disk_info", r23);     // Catch: Exception -> L86
    L81:
        if (this.m == null) goto L83;
        com.bytedance.apm.f0.b.f().p(new a(this, r2, H(this.z), H(this.A), H(this.B)));     // Catch: Exception -> L86
    L83:
        this.z = null;     // Catch: Exception -> L86
        this.A = null;     // Catch: Exception -> L86
        this.B = null;     // Catch: Exception -> L86
        this.u = null;     // Catch: Exception -> L86
        goto L84
    L8:
        r2 = r8;
    }

    static /* synthetic */ long o(f r2) {
        return r2.f1138i;
    }

    static /* synthetic */ com.bytedance.apm.w.f p(f r0) {
        return r0.m;
    }

    static /* synthetic */ String q() {
        return E;
    }

    static /* synthetic */ long r(f r2) {
        return r2.f1139j;
    }

    static /* synthetic */ void s(f r0, String r1, long r2, int r4, int r5) {
        r0.C(r1, r2, r4, r5);
    }

    static /* synthetic */ void t(f r0, String r1, long r2, int r4, long r5) {
        r0.D(r1, r2, r4, r5);
    }

    static /* synthetic */ long u(f r0, long r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ long v(f r0, long r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ String w(f r0) {
        return r0.n;
    }

    static /* synthetic */ long x(f r0, long r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ String y(f r0) {
        return r0.o;
    }

    static /* synthetic */ long z(f r0, long r1) {
        r0.s = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    public void G() {
        int r8 = 2;
        int r10 = 0;
        ?? r11 = 1;
        String[] r9 = {D, E};
        this.u = new ArrayList();
        int r12 = 0;
    L3:
        if (r12 >= r8) goto L54;
        String r0 = r9[r12];
        F(new File(r0), r11, r11, this.u);
        File r1 = new File(r0);
        a r13 = null;
        d r2 = new d(this, r13);
        d.b(r2, r0);
        r2.f1157b = new d(this, r13);
        File[] r3 = r1.listFiles();
        if (r3 == null) goto L53;
        if (r3.length == 0) goto L53;
        d.c(r2, r3.length);
        LinkedList r14 = new LinkedList();
        r14.offer(r2);
    L11:
        if (r14.isEmpty() == true) goto L53;
        int r15 = r14.size();
        int r5 = r10;
    L13:
        if (r5 >= r15) goto L11;
        d r4 = (d) r14.poll();
        if (r4 != null) goto L17;
        int r17 = r5;
        String[] r16 = r9;
    L52:
        r5 = r17 + 1;
        r9 = r16;
        r10 = 0;
        goto L13
    L17:
        String r6 = d.a(r4);
        File r7 = new File(r6);
        if (r7.exists() == true) goto L20;
    L51:
        r17 = r5;
        r16 = r9;
        d.d(r4.f1157b);
        goto L52
    L20:
        if (this.x.contains(r6) == true) goto L51;
        r16 = r9;
        if (r7.isFile() == false) goto L35;
        long r18 = r7.length();
        if (r18 <= 0) goto L27;
        B(r6, r18);
    L27:
        d r19 = r4.f1157b;
        if (r19 == null) goto L34;
        r19.h(r18);
        if (d.e(r4.f1157b) == true) goto L34;
        long r110 = O(r7.lastModified());
        if (r110 <= 0) goto L34;
        r17 = r5;
        D(r6, r18, 0, r110);
    L34:
        r17 = r5;
        goto L52
    L35:
        r17 = r5;
        File[] r20 = r7.listFiles();
        if (r20 != null) goto L38;
    L50:
        r4.f1157b.h(0);
        goto L52
    L38:
        if (r20.length == 0) goto L50;
        d.c(r4, r20.length);
        int r21 = r20.length;
        int r22 = 0;
    L41:
        if (r22 >= r21) goto L52;
        File r23 = r20[r22];
        d r24 = new d(this, r13);
        r24.f1157b = r4;
        d.b(r24, r23.getAbsolutePath());
        if (r23.isDirectory() == false) goto L49;
        if (d.e(r4) == true) goto L49;
        long r111 = O(r23.lastModified());
        if (r111 <= 0) goto L49;
        d.f(r24, true);
        d.g(r24, r111);
    L49:
        r14.offer(r24);
        r22 = r22 + 1;
    L53:
        r12 = r12 + 1;
        r9 = r9;
        r8 = 2;
        r10 = 0;
        r11 = 1;
        goto L3
    L54:
        List<String> r25 = this.y;
        if (r25 != null) goto L57;
    L62:
        Iterator<b> r26 = this.u.iterator();
    L64:
        if (r26.hasNext() == false) goto L75;
        b r27 = r26.next();
        if ("normal".equals(r27.f1151e) == false) goto L64;
        List<b> r28 = r27.f1152f;
        if (r28 == null) goto L64;
        if (r28.isEmpty() == true) goto L64;
        Iterator<b> r29 = r28.iterator();
    L73:
        if (r29.hasNext() == false) goto L64;
        r27.f1148b += r29.next().f1148b;
        goto L73
    L75:
        return;
    L57:
        if (r25.size() <= 0) goto L62;
        Iterator<String> r30 = this.y.iterator();
    L60:
        if (r30.hasNext() == false) goto L62;
        F(new File(r30.next()), 1, false, this.u);
        goto L60
    }

    public void Q(com.bytedance.apm.w.f r1) {
        this.m = r1;
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r10) {
        boolean r0 = r10.optBoolean("dump_switch", true);
        this.f1137h = r0;
        if (r0 == false) goto L22;
        long r2 = com.bytedance.apm.internal.b.a().c("check_disk_last_time");
        long r4 = System.currentTimeMillis() - r2;
        if (r4 >= 86400000) goto L10;
        if (r4 <= 0) goto L10;
        this.f1136g = true;
    L10:
        if (r10.optInt("dump_threshold") <= 0) goto L13;
        this.f1138i = (((long) r10.optInt("dump_threshold")) * 1024) * 1024;
    L13:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L16;
        this.f1139j = (((long) r10.optInt("abnormal_folder_size")) * 1024) * 1024;
    L16:
        if (r10.optInt("dump_top_count") <= 0) goto L19;
        this.f1140k = r10.optInt("dump_top_count");
    L19:
        if (r10.optInt("outdated_days") <= 0) goto L21;
        this.f1141l = ((long) r10.optInt("outdated_days")) * 86400000;
    L21:
        this.v = o.e(r10, "disk_customed_paths");
        this.w = o.d(r10, "ignored_relative_paths");
    L22:
        this.f1136g = true;
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return true;
    }

    @Override // com.bytedance.apm.a0.a
    public void i() {
        boolean r0 = e();
        if (this.f1136g == true) goto L16;
        if (r0 == false) goto L17;
        M();
        if (this.t == false) goto L11;
        this.f1136g = true;
        return;
    L11:
        if (this.f1137h == false) goto L13;
        K();
    L14:
        this.f1136g = true;
        m();
        b();
        return;
    L13:
        L();
        goto L14
    L17:
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return 120000;
    }
}
