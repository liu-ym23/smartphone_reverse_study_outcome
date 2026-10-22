package com.bytedance.apm.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f2041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f2042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2044l;
    private long m;
    private long n;
    private double o;
    private long p;
    private long q;
    private double r;
    private long s;
    private long t;
    private double u;
    private boolean v;
    private boolean w;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Throwable f2045f;

        a(c r1, Throwable r2) {
            this.f2045f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.k.e().b(this.f2045f, "apm_error");
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f2046a = null;

        static {
            f2046a = new c(null);
        }
    }

    private c() {
        i();
        this.f2033a = com.bytedance.apm.d.D();
        p();
    }

    /* synthetic */ c(a r1) {
        this();
    }

    private void i() {
        if (w.a() == false) goto L6;
        Throwable r0 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        com.bytedance.apm.f0.b.f().i(new a(this, r0));
        return;
    }

    private double j(long r3, long r5) {
        if (r5 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r3 / r5) * 100.0d) / 100.0d;
    }

    public static c k() {
        return b.f2046a;
    }

    private String l() {
        File r2 = new File("/system/lib/libc.so");
        if (r2.exists() == true) goto L11;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L11:
        if (r.c(r2, "je_malloc") == true) goto L13;
        return "dlmalloc";
    L13:
        return "jemalloc";
    L10:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private long m(long r3) {
        return r3 / 1073741824;
    }

    private void n() {
        String r0 = com.bytedance.apm.d.h().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        StringBuilder r1 = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 21) goto L10;
    L18:
        r1 = new StringBuilder(Build.CPU_ABI);
    L19:
        String r2 = r1.toString();
        if (r2 != null) goto L22;
    L24:
        o();
        return;
    L22:
        if (r2.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L24;
        this.f2035c = true;
        goto L24
    L10:
        if (Build.SUPPORTED_ABIS.length <= 0) goto L18;
        int r3 = 0;
    L12:
        String[] r4 = Build.SUPPORTED_ABIS;
        if (r3 >= r4.length) goto L19;
        r1.append(r4[r3]);
        if (r3 == (r4.length - 1)) goto L17;
        r1.append(", ");
    L17:
        r3 = r3 + 1;
        goto L12
    L5:
        if (r0.endsWith("arm64") == false) goto L7;
        this.f2034b = true;
        goto L7
    }

    private void o() {
        com.bytedance.apm.internal.b r0 = com.bytedance.apm.internal.b.a();
        String r2 = r0.d("sp_cpu_model");
        int r4 = r0.b("sp_cpu_core_num");
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.f2036d = r2;
        this.f2037e = r4;
        return;
    L6:
        s();
        if (TextUtils.isEmpty(this.f2036d) == false) goto L9;
        this.f2036d = EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        r0.g("sp_cpu_model", this.f2036d);
        r0.e("sp_cpu_core_num", this.f2037e);
    }

    private void p() {
        if (this.f2033a == true) goto L8;
        return;
    L8:
        n();     // Catch: Throwable -> L7
        q();     // Catch: Throwable -> L7
        r();     // Catch: Throwable -> L7
        return;
    }

    private void q() {
        ActivityManager r0 = (ActivityManager) com.bytedance.apm.d.h().getSystemService("activity");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 16) goto L5;
        int r3 = -1;
    L6:
        this.f2038f = r3;
        if (r2 >= 21) goto L11;
        String r4 = "dlmalloc";
    L9:
        this.f2043k = r4;
        return;
    L11:
        if (r2 < 24) goto L13;
        r4 = "jemalloc";
        goto L9
    L13:
        r4 = com.bytedance.apm.internal.b.a().d("sp_malloc_impl");
        if (r4 != null) goto L9;
        r4 = l();
        com.bytedance.apm.internal.b.a().g("sp_malloc_impl", r4);
        goto L9
    L5:
        r3 = (int) (r1.totalMem / 536870912);
        goto L6
    }

    @SuppressLint({"NewApi"})
    private void r() {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r0 = true;
    L6:
        this.f2044l = r0;
        StatFs r1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.f2044l == false) goto L9;
        this.n = r1.getAvailableBytes();
        long r2 = r1.getBlockSizeLong();
        long r3 = r1.getBlockCountLong();
    L10:
        this.m = r2 * r3;
        this.o = j(this.n, this.m);
        StatFs r4 = new StatFs(com.bytedance.apm.d.h().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L28
        if (this.f2044l == false) goto L14;
        this.q = r4.getAvailableBytes();     // Catch: Throwable -> L28
        this.p = r4.getBlockSizeLong() * r4.getBlockCountLong();     // Catch: Throwable -> L28
    L15:
        this.r = j(this.q, this.p);     // Catch: Throwable -> L28
        goto L16
    L14:
        this.q = ((long) r4.getBlockSize()) * ((long) r4.getAvailableBlocks());     // Catch: Throwable -> L28
        this.p = ((long) r4.getBlockSize()) * ((long) r4.getBlockCount());     // Catch: Throwable -> L28
    L16:
        String r5 = null;
        r5 = Environment.getExternalStorageState();     // Catch: Exception -> L29
    L18:
        boolean r6 = TextUtils.equals(r5, "mounted");
        this.v = r6;
        if (r6 == false) goto L25;
        StatFs r7 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L30
        if (this.f2044l == false) goto L23;
        this.t = r7.getAvailableBytes();     // Catch: Throwable -> L30
        this.s = r7.getBlockSizeLong() * r7.getBlockCountLong();     // Catch: Throwable -> L30
    L24:
        this.u = j(this.t, this.s);     // Catch: Throwable -> L30
        goto L26
    L23:
        this.t = ((long) r7.getBlockSize()) * ((long) r7.getAvailableBlocks());     // Catch: Throwable -> L30
        this.s = ((long) r7.getBlockSize()) * ((long) r7.getBlockCount());     // Catch: Throwable -> L30
        goto L24
    L25:
        this.s = 0;     // Catch: Throwable -> L30
    L26:
        this.w = Environment.isExternalStorageRemovable();
        return;
    L9:
        this.n = ((long) r1.getBlockSize()) * ((long) r1.getAvailableBlocks());
        r2 = r1.getBlockSize();
        r3 = r1.getBlockCount();
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private void s() {
        BufferedReader r0 = null;
        String r1 = null;
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Throwable -> L21 Exception -> L25
        int r4 = 0;
    L46:
        String r5 = r3.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L40;
        String[] r6 = r5.split(":");     // Catch: Throwable -> L18 Exception -> L20
        if (r6.length != 2) goto L46;
        if (r6[0].startsWith("Hardware") == true) goto L12;
        if (r6[0].startsWith("processor") == false) goto L46;
        r4 = r4 + 1;
        goto L46
    L12:
        r1 = r6[1].trim();     // Catch: Throwable -> L18 Exception -> L20
        goto L46
    L40:
        r3.close();     // Catch: Exception -> L35
    L29:
        this.f2036d = r1;
        this.f2037e = r4;
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return;
    L32:
        if (s.u() == false) goto L59;
        this.f2036d = Build.HARDWARE;
        return;
    L59:
        return;
    L20:
        String r7 = r1;
        r2 = r3;
    L26:
        if (r2 != null) goto L42;
    L28:
        r1 = r7;
        goto L29
    L42:
        r2.close();     // Catch: Exception -> L37
    L18:
        th = th;
        r0 = r3;
    L22:
        if (r0 != null) goto L38;
    L24:
        throw th;
    L38:
        r0.close();     // Catch: Exception -> L36
        goto L24
    L25:
        r4 = 0;
        r7 = null;
    L21:
        th = th;
        goto L22
    }

    private void t() {
        this.f2039g = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.f2041i = r4 / 1048576;
        long r2 = r1 - r6;
        this.f2042j = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.f2040h = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void a(JSONObject r2) {
        b(r2, false);
    }

    public void b(JSONObject r1, boolean r2) {
        if (this.f2033a == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        k().d(r1);     // Catch: JSONException -> L8
        k().c(r1);     // Catch: JSONException -> L8
        k().h(r1);     // Catch: JSONException -> L8
        return;
    }

    public void c(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f2033a == false) goto L9;
        r3.put("apm_physical_mem", this.f2038f);
        r3.put("apm_malloc_impl", this.f2043k);
        return;
    }

    public void d(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f2033a == false) goto L12;
        r3.put("apm_is_app_64", this.f2034b);
        r3.put("apm_is_device_64", this.f2035c);
        r3.put("apm_cpu_model", this.f2036d);
        int r2 = this.f2037e;
        if (r2 <= 0) goto L11;
        r3.put("apm_cpu_core_num", r2);
        return;
    L11:
        return;
    }

    public void e(JSONObject r2) {
        f(r2, false);
    }

    public void f(JSONObject r1, boolean r2) {
        if (this.f2033a == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        k().g(r1);     // Catch: JSONException -> L8
        return;
    }

    public void g(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.f2033a == false) goto L9;
        t();
        r4.put("apm_native_heap_size", this.f2039g);
        r4.put("apm_java_heap_leak", this.f2040h);
        r4.put("apm_java_heap_used", this.f2042j);
        r4.put("apm_java_heap_max", this.f2041i);
        return;
    }

    public void h(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (this.f2033a == true) goto L7;
        return;
    L7:
        if (this.m == 0) goto L10;
        r7.put("apm_sys_avail_size", this.n / 1048576);
        r7.put("apm_sys_avail_ratio", this.o);
    L10:
        if (this.p == 0) goto L13;
        r7.put("apm_data_avail_size", m(this.q));
        r7.put("apm_data_avail_ratio", this.r);
    L13:
        if (this.s == 0) goto L16;
        r7.put("apm_sd_avail_size", m(this.t));
        r7.put("apm_sd_avail_ratio", this.u);
    L16:
        if (this.v == false) goto L20;
        r7.put("apm_external_removable", this.w);
        return;
    }
}
