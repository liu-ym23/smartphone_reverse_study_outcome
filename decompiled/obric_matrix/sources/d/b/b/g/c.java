package d.b.b.g;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.util.y;
import com.bytedance.apm.w.f;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static c p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f12892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f12893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f12894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f12895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d.b.b.g.d.a f12897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f12899l;
    private long m;
    private long n;
    private f o;

    static /* synthetic */ class a {
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f12902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<b> f12905f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f12906g;

        private b(c r1) {
            this.f12906g = r1;
            this.f12904e = "normal";
            this.f12905f = new ArrayList();
        }

        /* synthetic */ b(c r1, a r2) {
            this(r1);
        }

        private String a() {
            String r0 = this.f12900a;
            String r1 = c.d(this.f12906g, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.e(this.f12906g)) == false) goto L10;
            String r2 = c.e(this.f12906g);
            String r3 = "internal";
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(c.f(this.f12906g)) == false) goto L13;
            r2 = c.f(this.f12906g);
            r3 = "external";
            goto L12
        L13:
            return r0;
        }

        public JSONObject b() {
            JSONObject r0 = new JSONObject();
            r0.put("path", a());     // Catch: JSONException -> L11
            r0.put("size", this.f12901b);     // Catch: JSONException -> L11
            r0.put("size_rate", this.f12902c);     // Catch: JSONException -> L11
            r0.put("is_folder", this.f12903d);     // Catch: JSONException -> L11
            r0.put("report_type", this.f12904e);     // Catch: JSONException -> L11
            if (this.f12905f.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<b> r4 = this.f12905f.iterator();     // Catch: JSONException -> L11
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

    /* JADX INFO: renamed from: d.b.b.g.c$c, reason: collision with other inner class name */
    private class C0339c implements Comparable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f12907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f12908g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f12909h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12910i;

        public C0339c(c r1) {
            this.f12910i = r1;
        }

        public C0339c(c r1, String r2, long r3, int r5) {
            this.f12910i = r1;
            this.f12907f = r2;
            this.f12908g = r3;
            this.f12909h = r5;
        }

        static /* synthetic */ String a(C0339c r0) {
            return r0.f12907f;
        }

        private String b() {
            String r0 = this.f12907f;
            String r1 = c.d(this.f12910i, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.e(this.f12910i)) == false) goto L10;
            String r2 = c.e(this.f12910i);
            String r3 = "internal";
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(c.f(this.f12910i)) == false) goto L13;
            r2 = c.f(this.f12910i);
            r3 = "external";
            goto L12
        L13:
            return r0;
        }

        public JSONObject c() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", b());     // Catch: Exception -> L6
            r0.put("size", this.f12908g);     // Catch: Exception -> L6
            int r4 = this.f12909h;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put("num", r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.f12908g;
            long r3 = ((C0339c) r4).f12908g;
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
        private String f12911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f12912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f12913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f12915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f12916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f12917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12919i;

        private d(c r1) {
            this.f12919i = r1;
        }

        /* synthetic */ d(c r1, a r2) {
            this(r1);
        }

        static /* synthetic */ String a(d r0) {
            return r0.f12911a;
        }

        static /* synthetic */ String b(d r0, String r1) {
            r0.f12911a = r1;
            return r1;
        }

        static /* synthetic */ int c(d r0, int r1) {
            r0.f12914d = r1;
            return r1;
        }

        static /* synthetic */ int d(d r2) {
            int r0 = r2.f12914d;
            r2.f12914d = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean e(d r0) {
            return r0.f12916f;
        }

        static /* synthetic */ boolean f(d r0, boolean r1) {
            r0.f12916f = r1;
            return r1;
        }

        static /* synthetic */ long g(d r0, long r1) {
            r0.f12917g = r1;
            return r1;
        }

        public void h(long r9, y<C0339c> r11, y<C0339c> r12) {
            this.f12913c += r9;
            this.f12915e++;
            if (this.f12912b != null) goto L5;
            return;
        L5:
            if (i() == true) goto L7;
            return;
        L7:
            if (this.f12918h == false) goto L10;
            this.f12912b.f12918h = true;
        L10:
            if (this.f12913c >= c.b(this.f12919i).e()) goto L12;
        L17:
            this.f12912b.h(this.f12913c, r11, r12);
            if (this.f12916f == true) goto L20;
            return;
        L20:
            if (this.f12919i.G(this.f12913c) == false) goto L26;
            c r1 = this.f12919i;
            String r2 = this.f12911a;
            long r3 = this.f12913c;
            int r5 = this.f12914d;
            r11.a(new e(r1, r2, r3, r5, r5));
            return;
        L26:
            return;
        L12:
            if (this.f12918h == true) goto L17;
            if (c.c(this.f12919i, this.f12913c) == true) goto L16;
            r12.a(new C0339c(this.f12919i, this.f12911a, this.f12913c, this.f12914d));
        L16:
            this.f12912b.f12918h = true;
            goto L17
        }

        public boolean i() {
            if (this.f12915e != this.f12914d) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private class e extends C0339c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f12920j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f12921k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f12922l;
        private long m;
        final /* synthetic */ c n;

        public e(c r1, String r2, long r3, int r5, long r6) {
            this.n = r1;
            super(r1);
            this.f12920j = r2;
            this.f12921k = r3;
            this.f12922l = r5;
            this.m = r6;
        }

        private String b() {
            String r0 = this.f12920j;
            String r1 = c.d(this.n, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(c.e(this.n)) == false) goto L10;
            String r2 = c.e(this.n);
            String r3 = "internal";
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(c.f(this.n)) == false) goto L13;
            r2 = c.f(this.n);
            r3 = "external";
            goto L12
        L13:
            return r0;
        }

        @Override // d.b.b.g.c.C0339c
        public JSONObject c() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", b());     // Catch: Exception -> L7
            r0.put("size", this.f12921k);     // Catch: Exception -> L7
            int r1 = this.f12922l;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put("num", r1);     // Catch: Exception -> L7
        L5:
            r0.put("outdate_interval", this.m);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }

        @Override // d.b.b.g.c.C0339c, java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.m;
            long r3 = ((e) r4).m;
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
        p = new c();
    }

    private c() {
        this.f12892e = false;
        this.f12898k = 0;
        this.f12899l = 0;
        this.m = 0;
        this.n = 0;
    }

    private Pair<Long, Long> A() {
        int r13 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L33
        long r2 = 0;
        if (r13 < 26) goto L16;
        StorageStatsManager r14 = (StorageStatsManager) d.b.b.o.a.b().getSystemService("storagestats");     // Catch: Throwable -> L33
        StorageManager r0 = (StorageManager) d.b.b.o.a.b().getSystemService("storage");     // Catch: Throwable -> L33
        Iterator<StorageVolume> r1 = r0.getStorageVolumes().iterator();     // Catch: Throwable -> L33
        long r8 = 0;
    L7:
        if (r1.hasNext() == false) goto L14;
        String r10 = r1.next().getUuid();     // Catch: Throwable -> L33
        if (r10 != null) goto L11;
        UUID r11 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L33
    L12:
        r2 = r2 + r14.getTotalBytes(r11);     // Catch: Throwable -> L33
        r8 = r8 + r0.getAllocatableBytes(r11);     // Catch: Throwable -> L33
        goto L7
    L11:
        r11 = UUID.fromString(r10);     // Catch: Throwable -> L33
        goto L12
    L14:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r8 / 1000) / 1000) * 1024) * 1024));
    L16:
        if (r13 < 24) goto L27;
        List<StorageVolume> r15 = ((StorageManager) d.b.b.o.a.b().getSystemService("storage")).getStorageVolumes();     // Catch: Throwable -> L33
        if (d.b.b.o.f.b(r15) == false) goto L21;
        return null;
    L21:
        Iterator<StorageVolume> r16 = r15.iterator();     // Catch: Throwable -> L33
        long r3 = 0;
    L23:
        if (r16.hasNext() == false) goto L26;
        StorageVolume r12 = r16.next();     // Catch: Throwable -> L33
        File r17 = (File) H(r12.getClass(), "getPathFile", new Class[0]).invoke(r12, new Object[0]);     // Catch: Throwable -> L33
        r2 = r2 + r17.getTotalSpace();     // Catch: Throwable -> L33
        r3 = r3 + r17.getFreeSpace();     // Catch: Throwable -> L33
        goto L23
    L26:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r3 / 1000) / 1000) * 1024) * 1024));
    L27:
        StorageManager r18 = (StorageManager) d.b.b.o.a.b().getSystemService("storage");     // Catch: Throwable -> L33
        Iterator r19 = ((List) H(r18.getClass(), "getVolumes", new Class[0]).invoke(r18, new Object[0])).iterator();     // Catch: Throwable -> L33
        long r4 = 0;
    L29:
        if (r19.hasNext() == false) goto L32;
        Object r5 = r19.next();     // Catch: Throwable -> L33
        File r6 = (File) H(r5.getClass(), "getPathFile", new Class[0]).invoke(r5, new Object[0]);     // Catch: Throwable -> L33
        r4 = r4 + r6.getFreeSpace();     // Catch: Throwable -> L33
        r2 = r2 + r6.getFreeSpace();     // Catch: Throwable -> L33
        goto L29
    L32:
        return new Pair(Long.valueOf(r2), Long.valueOf(r4));
    L34:
        return new Pair(Long.valueOf(d.b.b.o.c.d(Environment.getDataDirectory().getPath()) + d.b.b.o.c.d(Environment.getRootDirectory().getPath())), Long.valueOf(d.b.b.o.c.c(Environment.getDataDirectory().getPath())));
    }

    private float B(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private void C() {
        if (this.f12896i == false) goto L5;
        return;
    L5:
        this.f12896i = true;
        Application r1 = d.b.b.o.a.b();
        r1.getPackageName();     // Catch: Exception -> L10
        this.f12888a = r1.getFilesDir().getParent();     // Catch: Exception -> L10
        this.f12889b = r1.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.f12890c = v(r1);     // Catch: Exception -> L10
        File r2 = r1.getExternalCacheDir();     // Catch: Exception -> L10
        if (r2 == null) goto L14;
        this.f12891d = r2.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.f12892e = true;
    }

    private boolean D(File r2) {
        if (d.b.b.o.f.b(this.f12893f) == false) goto L5;
        return false;
    L5:
        return this.f12893f.contains(r2.getAbsolutePath());
    }

    private boolean E(b r3) {
        Iterator<String> r2 = this.f12893f.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r0 = r2.next();
        if (r3.f12900a.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean F(long r3) {
        if (r3 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r3 > 17179869184L) goto L8;
        return false;
    }

    private static Method H(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private List<String> J(List<String> r5) {
        ArrayList r0 = new ArrayList();
        if (d.b.b.o.f.b(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<String> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L15;
        String r1 = r6.next();
        String r2 = "internal";
        if (r1.contains("internal") == true) goto L10;
        r2 = "external";
        if (r1.contains("external") == false) goto L7;
        String r3 = this.f12890c;
    L11:
        r0.add(r1.replace(r2, r3));
        goto L7
    L10:
        r3 = this.f12888a;
        goto L11
    L15:
        return r0;
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context a(Application r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ d.b.b.g.d.a b(c r0) {
        return r0.f12897j;
    }

    static /* synthetic */ boolean c(c r0, long r1) {
        return r0.F(r1);
    }

    static /* synthetic */ String d(c r0, String r1) {
        return r0.u(r1);
    }

    static /* synthetic */ String e(c r0) {
        return r0.f12888a;
    }

    static /* synthetic */ String f(c r0) {
        return r0.f12890c;
    }

    private d.b.b.g.b g() {
        ArrayList r0 = new ArrayList();
        m(new File(this.f12888a), r0);
        m(new File(this.f12890c), r0);
        ArrayList r1 = new ArrayList();
        Iterator<b> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        b r3 = r2.next();
        boolean r4 = true;
        Iterator<b> r5 = r3.f12905f.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (r5.next().f12903d == false) goto L7;
        r4 = false;
    L11:
        if (r4 == false) goto L4;
        r1.remove(r3);
        goto L4
    L13:
        r0.removeAll(r1);
        if (d.b.b.o.a.c() == false) goto L19;
        Iterator<b> r6 = r0.iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        d.b.b.o.m.b.a("APM-Disk", "diskInfoNodes:" + r6.next().b());
    L19:
        y<C0339c> r7 = new y(this.f12897j.j());
        y<C0339c> r8 = new y(this.f12897j.h());
        y<C0339c> r10 = new y(this.f12897j.i());
        List<String> r11 = new ArrayList();
        r11.add(this.f12888a);
        r11.add(this.f12889b);
        l(k(this.f12888a, r7, r8, r10, r11));
        r11.clear();
        r11.add(this.f12891d);
        r11.add(this.f12890c);
        l(k(this.f12890c, r7, r8, r10, r11));
        if (d.b.b.o.a.c() == false) goto L34;
        Iterator r9 = r7.d().iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        d.b.b.o.m.b.a("APM-Disk", "fileListTopK:" + ((C0339c) r9.next()).c());
        goto L23
    L25:
        Iterator r12 = r8.d().iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        d.b.b.o.m.b.a("APM-Disk", "dirListTopK:" + ((C0339c) r12.next()).c());
        goto L27
    L29:
        Iterator r13 = r10.d().iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        d.b.b.o.m.b.a("APM-Disk", "outdatedListTopK:" + ((C0339c) r13.next()).c());
        goto L31
    L33:
        d.b.b.o.m.b.a("APM-Disk", "insideDataSize:" + this.f12898k + " outsideDataSize:" + this.f12899l + " insideCacheSize:" + this.m + " outsideCacheSize:" + this.n);
    L34:
        i(r0);
        return r(r7, r8, r10, r0);
    }

    private void h(File r6, List<b> r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.exists() == true) goto L6;
        return;
    L6:
        if (D(r6) == true) goto L16;
        a r2 = null;
        if (r6.isFile() == false) goto L13;
        long r3 = r6.length();
        b r0 = new b(this, r2);
        r0.f12903d = false;
        r0.f12900a = r6.getAbsolutePath();
        r0.f12901b = r3;
        r0.f12904e = "custom";
    L11:
        r7.add(r0);
        return;
    L13:
        r0 = new b(this, r2);
        r0.f12903d = true;
        r0.f12904e = "custom";
        r0.f12900a = r6.getAbsolutePath();
        r0.f12901b = w(r6);
        goto L11
    }

    private void i(List<b> r4) {
        if (d.b.b.o.f.b(this.f12894g) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.f12894g.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        h(new File(r0.next()), r4);
        goto L7
    }

    private long j(File r9, List<b> r10) {
        long r0 = 0;
        if (r9 != null) goto L5;
    L33:
        return r0;
    L5:
        if (r9.exists() == false) goto L33;
        if (D(r9) == true) goto L33;
        int r3 = 0;
        a r4 = null;
        if (r9.isFile() == false) goto L16;
        long r1 = r9.length();
        if (r1 >= this.f12897j.d()) goto L14;
        return r1;
    L14:
        b r2 = new b(this, r4);
        r2.f12903d = false;
        r2.f12900a = r9.getAbsolutePath();
        r2.f12901b = r1;
        r10.add(r2);
        return r1;
    L16:
        File[] r5 = r9.listFiles();
        if (r5 == null) goto L33;
        if (r5.length == 0) goto L33;
        b r6 = new b(this, r4);
        r6.f12903d = r9.isDirectory();
        r6.f12900a = r9.getAbsolutePath();
        ArrayList r11 = new ArrayList();
        r6.f12905f = r11;
        r10.add(r6);
        int r12 = r5.length;
    L22:
        if (r3 >= r12) goto L32;
        File r7 = r5[r3];
        if (r7 == null) goto L31;
        if (r7.exists() == false) goto L31;
        if (D(r7) == true) goto L31;
        r0 = r0 + j(r7, r11);
    L31:
        r3 = r3 + 1;
        goto L22
    L32:
        r6.f12901b = r0;
        goto L33
    }

    private List<d> k(String r23, y<C0339c> r24, y<C0339c> r25, y<C0339c> r26, List<String> r27) {
        List<String> r11 = r27;
        ArrayList r12 = new ArrayList();
        File r1 = new File(r23);
        a r13 = null;
        d r2 = new d(this, r13);
        d.b(r2, r23);
        r2.f12912b = new d(this, r13);
        File[] r0 = r1.listFiles();
        if (r0 == null) goto L69;
        if (r0.length == 0) goto L69;
        if (r11.contains(r1.getAbsolutePath()) == false) goto L10;
        r12.add(r2);
        r11.remove(r1.getAbsolutePath());
    L10:
        d.c(r2, r0.length);
        LinkedList r14 = new LinkedList();
        r14.offer(r2);
    L12:
        if (r14.isEmpty() == true) goto L67;
        int r15 = r14.size();
        int r6 = 0;
    L14:
        if (r6 >= r15) goto L12;
        d r7 = (d) r14.poll();
        if (r7 != null) goto L18;
        r27 = r11;
        ArrayList r3 = r12;
        LinkedList r16 = r14;
        int r17 = r15;
        r6 = r6;
    L65:
        r6 = r6 + 1;
        r12 = r3;
        r14 = r16;
        r15 = r17;
        r11 = r27;
        goto L14
    L18:
        String r5 = d.a(r7);
        File r4 = new File(r5);
        if (r4.exists() == true) goto L21;
    L64:
        r27 = r11;
        r3 = r12;
        r16 = r14;
        r17 = r15;
        r6 = r6;
        d.d(r7.f12912b);
        goto L65
    L21:
        if (D(r4) == true) goto L64;
        if (r4.isFile() == false) goto L42;
        r16 = r14;
        long r18 = r4.length();
        if (F(r18) == true) goto L29;
        r24.a(new C0339c(this, r5, r18, 1));
    L29:
        d r8 = r7.f12912b;
        if (r8 != null) goto L32;
        r6 = r6;
    L41:
        r17 = r15;
        r3 = r12;
        goto L65
    L32:
        r8.h(r18, r26, r25);
        if (d.e(r7.f12912b) == true) goto L41;
        long r20 = z(r4.lastModified());
        if (r20 <= 0) goto L41;
        if (G(r18) == false) goto L41;
        r26.a(new e(this, r5, r15, 0, r20));
        goto L41
    L42:
        ArrayList r19 = r12;
        LinkedList r28 = r14;
        r6 = r6;
        r27 = r27;
        if (r27.contains(r4.getAbsolutePath()) == false) goto L45;
        r3 = r19;
        r3.add(r7);
        r27.remove(r4.getAbsolutePath());
    L46:
        File[] r9 = r4.listFiles();
        if (r9 != null) goto L49;
    L63:
        r16 = r28;
        r17 = r15;
        r7.f12912b.h(0, r26, r25);
        goto L65
    L49:
        if (r9.length == 0) goto L63;
        d.c(r7, r9.length);
        int r10 = r9.length;
        int r21 = 0;
    L52:
        if (r21 >= r10) goto L62;
        File r110 = r9[r21];
        d r111 = new d(this, null);
        r111.f12912b = r7;
        d.b(r111, r110.getAbsolutePath());
        if (r110.isDirectory() == true) goto L56;
    L60:
        int r112 = r15;
    L61:
        LinkedList r113 = r28;
        r113.offer(r111);
        r21 = r21 + 1;
        r28 = r113;
        r15 = r112;
        goto L52
    L56:
        if (d.e(r7) == true) goto L60;
        r112 = r15;
        long r114 = z(r110.lastModified());
        if (r114 <= 0) goto L61;
        d.f(r111, true);
        d.g(r111, r114);
        goto L61
    L62:
        r16 = r28;
        r17 = r15;
        goto L65
    L45:
        r3 = r19;
        goto L46
    L67:
        return r12;
    L69:
        return null;
    }

    private void l(List<d> r4) {
        if (d.b.b.o.f.b(r4) == false) goto L5;
        return;
    L5:
        Iterator<d> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L20;
        d r0 = r5.next();
        if (TextUtils.equals(d.a(r0), this.f12888a) == true) goto L10;
        if (TextUtils.equals(d.a(r0), this.f12890c) == true) goto L13;
        if (TextUtils.equals(d.a(r0), this.f12889b) == true) goto L16;
        if (TextUtils.equals(d.a(r0), this.f12891d) == false) goto L7;
        this.n = r0.f12913c;
        goto L7
    L16:
        this.m = r0.f12913c;
        goto L7
    L13:
        this.f12899l = r0.f12913c;
        goto L7
    L10:
        this.f12898k = r0.f12913c;
        goto L7
    }

    private void m(File r4, List<b> r5) {
        File[] r6 = r4.listFiles();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length == 0) goto L12;
        int r0 = r6.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        j(r6[r1], r5);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private static List<String> o(y<? extends C0339c> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r3 = r2.d().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(C0339c.a((C0339c) r3.next()));
        goto L7
    L9:
        return r0;
    }

    private JSONArray p(List<b> r7, long r8) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (r7.isEmpty() == true) goto L36;
        BigDecimal r0 = new BigDecimal(r8);
        JSONArray r9 = new JSONArray();
        Iterator<b> r10 = r7.iterator();
    L7:
        if (r10.hasNext() == false) goto L24;
        b r11 = r10.next();
        if (E(r11) == false) goto L11;
        r11.f12902c = 0.0f;
    L12:
        List<b> r1 = r11.f12905f;
        if (r1 == null) goto L23;
        if (r1.size() <= 0) goto L23;
        Iterator<b> r2 = r1.iterator();
    L18:
        if (r2.hasNext() == false) goto L23;
        b r3 = r2.next();
        if (E(r3) == true) goto L21;
        r3.f12902c = B(r3.f12901b, r0);
        goto L18
    L21:
        r3.f12902c = 0.0f;
    L23:
        r9.put(r11.b());
        goto L7
    L11:
        r11.f12902c = B(r11.f12901b, r0);
        goto L12
    L24:
        return r9;
    L36:
        return null;
    }

    private d.b.b.g.b r(y<C0339c> r29, y<C0339c> r30, y<C0339c> r31, List<b> r32) {
        long r8 = this.f12898k + this.f12899l;     // Catch: Throwable -> L15
        long r3 = this.m + this.n;     // Catch: Throwable -> L15
        long r12 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L15
        long r14 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L15
        long r10 = Math.min(r8, 17179869184L);     // Catch: Throwable -> L15
        long r4 = Math.min(r3, 17179869184L);     // Catch: Throwable -> L15
        if (r10 >= 0) goto L7;
        return null;
    L7:
        if (this.o == null) goto L9;
        this.o.a(this.f12897j.c(), r10, o(r29), o(r30), o(r31));     // Catch: Throwable -> L15
    L9:
        Pair<Long, Long> r5 = A();     // Catch: Throwable -> L15
        long r6 = t();     // Catch: Throwable -> L15
        if (d.b.b.o.a.c() == false) goto L13;
        d.b.b.o.m.b.a("APM-Disk", "appUsage:" + r6);     // Catch: Throwable -> L15
    L13:
        return new d.b.b.g.b(r8, r4, r12, r14, r6, ((Long) r5.first).longValue(), ((Long) r5.second).longValue(), B(r6, new BigDecimal(r12)), q(r29), q(r30), q(r31), p(r32, r10));
    L15:
        th = move-exception;
        Log.e("APM-Disk", WsConstants.KEY_CONNECTION_ERROR, th);
        return null;
    }

    private String s(String r3) {
        if (d.b.b.o.f.b(this.f12895h) == true) goto L11;
        if (r3 == null) goto L16;
        Iterator<String> r2 = this.f12895h.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        String r0 = r2.next();
        if (r3.startsWith(r0) == false) goto L7;
        return r0;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    private long t() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        Application r0 = d.b.b.o.a.b();     // Catch: Throwable -> L17
        String r3 = r0.getPackageName();     // Catch: Throwable -> L17
        StorageStats r1 = ((StorageStatsManager) r0.getSystemService("storagestats")).queryStatsForUid(((StorageManager) r0.getSystemService("storage")).getUuidForPath(new File(r0.getDataDir().getParent(), r3)), r0.getPackageManager().getApplicationInfo(r3, 128).uid);     // Catch: Throwable -> L17
        if (d.b.b.o.a.c() == false) goto L7;
        Log.e("APM-Disk", "storageStats.getAppBytes():" + r1.getAppBytes());     // Catch: Throwable -> L17
    L7:
        return r1.getAppBytes();
    L20:
        long r4 = w(new File(d.b.b.o.a.b().getPackageManager().getApplicationInfo(d.b.b.o.a.b().getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L15
        if (d.b.b.o.a.c() == false) goto L12;
        Log.e("APM-Disk", "storageStats.getAppBytes():" + (((y() + r4) + this.f12898k) + this.f12899l));     // Catch: Exception -> L15
    L12:
        return ((r4 + y()) + this.f12898k) + this.f12899l;
    L15:
        return 0;
    }

    private String u(String r3) {
        String r2 = s(r3);
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return r2 + r3.substring(r2.length()).replaceAll("[^/]", "*");
    L7:
        return null;
    }

    private String v(Context r1) {
        return r1.getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L8:
        return null;
    }

    private long w(File r7) {
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
        long r5 = w(r4);     // Catch: Exception -> L16
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

    public static c x() {
        return p;
    }

    private long y() {
        long r1 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L7;
        File[] r0 = a(d.b.b.o.a.b()).getExternalMediaDirs();
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r1 = r1 + w(r0[r4]);
        r4 = r4 + 1;
    L7:
        return r1;
    }

    private long z(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.f12897j.g()) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    boolean G(long r3) {
        if (r3 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 17179869184L) goto L7;
        return true;
    }

    public void I(f r1) {
        this.o = r1;
    }

    d.b.b.g.b n(d.b.b.g.d.a r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.f12892e == false) goto L8;
        return null;
    L8:
        this.f12897j = r3;
        C();
        this.f12893f = J(r3.f());
        this.f12894g = J(r3.b());
        this.f12895h = J(r3.a());
        return g();
    }

    JSONArray q(y<C0339c> r2) {
        JSONArray r1 = new JSONArray();
        Iterator r3 = r2.d().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        JSONObject r0 = ((C0339c) r3.next()).c();
        if (r0 == null) goto L4;
        r1.put(r0);
        goto L4
    L8:
        return r1;
    }
}
