package tmsdkobf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.common.TMSDKContext;
import tmsdk.common.tcc.ApkSAFScanner;
import tmsdk.common.tcc.DeepCleanEngine;
import tmsdk.common.tcc.QFile;
import tmsdk.fg.module.cleanV2.IScanTaskCallBack;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: loaded from: classes5.dex */
public class ad implements DeepCleanEngine.Callback {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String f94J = null;
    private volatile int A;
    private volatile long B;
    private volatile int C;
    private volatile long D;
    private boolean E;
    volatile ce F;
    long G;
    long H;
    StringBuffer I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile Map f95a;
    volatile Map b;
    private e6 c;
    private volatile RubbishHolder d;
    IScanTaskCallBack e;
    private final boolean f;
    private final boolean g;
    volatile he h;
    private ConcurrentHashMap i;
    volatile a j;
    private ConcurrentHashMap k;
    String l;
    private int m;
    private int n;
    List o;
    private final long p;
    private final int q;
    private volatile Map r;
    private ApkSAFScanner s;
    private final List t;
    private b u;
    private HandlerThread v;
    private final AtomicInteger w;
    private c x;
    private final AtomicBoolean y;
    private volatile int z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f96a;
        public String b;
        public boolean c;
        final /* synthetic */ ad d;

        public a(ad r1) {
            this.d = r1;
        }
    }

    private static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SoftReference f97a;

        b(Looper r1, ad r2) {
            super(r1);
            this.f97a = new SoftReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            SoftReference r0 = this.f97a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L67;
            ad r7 = (ad) this.f97a.get();
            if (r7 != null) goto L11;
            return;
        L11:
            if (r8 != null) goto L60;
            Bundle r1 = null;
        L17:
            if (r1 == null) goto L19;
            int r9 = r8.what;     // Catch: Throwable -> L14
            if (r9 != 1) goto L30;
            ad.m2370$$Nest$ma(r7, r1.getString("key"), r1.getString("full_path"), r1.getLong("file_size"));     // Catch: Throwable -> L14
        L44:
            if (ad.m2366$$Nest$fgetw(r7).decrementAndGet() == 0) goto L46;
            return;
        L46:
            if (ad.m2368$$Nest$fgety(r7).get() == false) goto L65;
            ad.m2368$$Nest$fgety(r7).set(false);
            c r10 = ad.m2367$$Nest$fgetx(r7);
            if (r10 == null) goto L66;
            r10.a();
            return;
        L66:
            return;
        L65:
            return;
        L30:
            if (r9 != 2) goto L32;
            ad.m2371$$Nest$ma(r7, r1.getString("key"), r1.getString("detail_dir"), r1.getString("abs_path"), r1.getLong("file_size"));     // Catch: Throwable -> L14
            goto L44
        L32:
            if (r9 != 3) goto L34;
            ad.m2372$$Nest$ma(r7, r1.getString("key"), r1.getStringArray("detail_dirs"), r1.getLong("file_size"));     // Catch: Throwable -> L14
            goto L44
        L34:
            if (r9 != 4) goto L36;
            ad.m2369$$Nest$ma(r7, r1.getString("full_path"), r1.getLong("file_size"));     // Catch: Throwable -> L14
            goto L44
        L36:
            if (r9 != 5) goto L44;
            ad.m2373$$Nest$mb(r7, r1.getString("file_name"), r1.getString("detail_dir"), r1.getLong("file_size"));     // Catch: Throwable -> L14
            goto L44
        L19:
            if (ad.m2366$$Nest$fgetw(r7).decrementAndGet() == 0) goto L21;
            return;
        L21:
            if (ad.m2368$$Nest$fgety(r7).get() == false) goto L62;
            ad.m2368$$Nest$fgety(r7).set(false);
            c r11 = ad.m2367$$Nest$fgetx(r7);
            if (r11 == null) goto L63;
            r11.a();
            return;
        L63:
            return;
        L62:
            return;
        L60:
            r1 = r8.getData();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (ad.m2366$$Nest$fgetw(r7).decrementAndGet() == 0) goto L54;
        L58:
            throw th;
        L54:
            if (ad.m2368$$Nest$fgety(r7).get() == false) goto L58;
            ad.m2368$$Nest$fgety(r7).set(false);
            c r12 = ad.m2367$$Nest$fgetx(r7);
            if (r12 == null) goto L58;
            r12.a();
            goto L58
        }
    }

    public interface c {
        void a();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetw, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m2366$$Nest$fgetw(ad r0) {
        return r0.w;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetx, reason: not valid java name */
    static /* bridge */ /* synthetic */ c m2367$$Nest$fgetx(ad r0) {
        return r0.x;
    }

    /* JADX INFO: renamed from: -$$Nest$fgety, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m2368$$Nest$fgety(ad r0) {
        return r0.y;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2369$$Nest$ma(ad r0, String r1, long r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2370$$Nest$ma(ad r0, String r1, String r2, long r3) {
        r0.a(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2371$$Nest$ma(ad r0, String r1, String r2, String r3, long r4) {
        r0.a(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2372$$Nest$ma(ad r0, String r1, String[] r2, long r3) {
        r0.a(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2373$$Nest$mb(ad r0, String r1, String r2, long r3) {
        r0.b(r1, r2, r3);
    }

    static {
        f94J = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public ad(int r4, List r5, boolean r6, boolean r7, boolean r8, boolean r9, IScanTaskCallBack r10) {
        this.m = 0;
        this.n = 0;
        this.w = new AtomicInteger(0);
        this.y = new AtomicBoolean(false);
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = new StringBuffer();
        this.f = r6;
        this.g = r7;
        this.q = r4;
        this.E = r9;
        this.p = System.currentTimeMillis();
        this.f95a = b();
        this.e = r10;
        this.b = new HashMap();
        this.d = new RubbishHolder();
        this.i = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        if (new z3().d() == true) goto L5;
        e6 r11 = new p8(this);
    L9:
        r11.b("/Android/sandbox/");
        this.r = new HashMap();
        a(ApkSAFScanner.ANDROID_DATA);
        a("/Android/obb");
        this.c = r11;
        if (r5 != null) goto L12;
    L15:
        List r12 = ac.c();
    L16:
        this.o = r12;
        this.t = new ArrayList();
        if (r8 == false) goto L21;
        HandlerThread r13 = new HandlerThread("scan_thread");
        this.v = r13;
        r13.start();
        Looper r14 = this.v.getLooper();
        if (r14 == null) goto L21;
        this.u = new b(r14, this);
        return;
    L21:
        o();
        return;
    L12:
        if (r5.isEmpty() == true) goto L15;
        r12 = new ArrayList(r5);
        goto L16
    L5:
        if (bc.a().d() == false) goto L7;
        r11 = new f2(this);
        goto L9
    L7:
        r11 = new p8(this);
        goto L9
    }

    private void a(String r5) {
        if (this.r.containsKey(r5.toLowerCase()) == true) goto L5;
        this.r.put(r5.toLowerCase(), 0);
        StringBuilder r0 = new StringBuilder("setWhiteEmptyPath, add: ");
    L6:
        q8.c("ScanData", r0.append(r5).toString());
        String r1 = f94J;
        if (r5.contains(r1) == true) goto L12;
        String r6 = (r1 + r5).toLowerCase();
        if (this.r.containsKey(r6) == true) goto L13;
        this.r.put(r6, 0);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = new StringBuilder("setWhiteEmptyPath, exist: ");
        goto L6
    }

    private int b(int r1) {
        if ((r1 & 16) == 0) goto L5;
        int r0 = 64;
    L7:
        if ((r1 & 32) != 0) goto L9;
        return r0;
    L9:
        return r0 | 4096;
    L5:
        r0 = 0;
        goto L7
    }

    private a b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        ConcurrentHashMap r0 = this.k;
        if (r0 != null) goto L8;
    L23:
        return null;
    L8:
        if (r0.isEmpty() == true) goto L23;
        Iterator r5 = this.k.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getKey();
        if (r6.startsWith("/storage/emulated") == false) goto L16;
        String r3 = r6.substring(17);
    L18:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3.toLowerCase().contains(r2.toLowerCase()) == false) goto L12;
        return (a) r1.getValue();
    L16:
        r3 = r6;
        goto L18
    }

    public static PackageInfo d() {
        Context r0 = TMSDKContext.getApplicaionContext();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        return r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);
    L6:
        return null;
    L11:
        return null;
    }

    public static String f() {
        return c("com.zhuoyi.appstore.transfer") + "_" + c("com.easy.transfer.abroad") + "_" + c("com.zhuoyi.browser") + "_" + c("com.zhuoyi.appstore.lite");
    }

    private void o() {
        b r0 = this.u;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
        this.u = null;
    L5:
        HandlerThread r1 = this.v;
        if (r1 == null) goto L8;
        r1.quitSafely();
        this.v = null;
    L8:
        this.x = null;
        this.w.set(0);
        this.y.set(false);
    }

    protected IScanTaskCallBack c() {
        return this.e;
    }

    protected e6 e() {
        return this.c;
    }

    protected String g() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String, tmsdkobf.ad$a, tmsdkobf.he] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public String getDetailRule(String r5) {
        ?? r1 = 0;
        if (this.c != null) goto L46;
        return null;
    L46:
        String r0 = r5.toLowerCase();     // Catch: Throwable -> L41
        if (h() == true) goto L24;
        int r2 = this.q;     // Catch: Throwable -> L41
        if (r2 == 1) goto L24;
        if (r2 == 2) goto L24;
        this.h = this.c.d(r0);     // Catch: Throwable -> L41
        if (this.h != null) goto L16;
        return null;
    L16:
        if (this.l == null) goto L18;
        a r6 = b(this.f, this.h);     // Catch: Throwable -> L41
    L19:
        this.j = r6;     // Catch: Throwable -> L41
        if (this.j != null) goto L22;
        return null;
    L22:
        e6 r7 = this.c;     // Catch: Throwable -> L41
        he r3 = this.h;     // Catch: Throwable -> L41
        Map r4 = this.f95a;     // Catch: Throwable -> L41
    L23:
        ad this = r7.a(r3, r4);     // Catch: Throwable -> L41
        r1 = this;
        return r1;
    L18:
        r6 = a(this.f, this.h);     // Catch: Throwable -> L41
    L24:
        r3 = this.c.d(r0);     // Catch: Throwable -> L41
        if (r3 != null) goto L28;
        return null;
    L28:
        if (this.i != null) goto L30;
        this.i = new ConcurrentHashMap();     // Catch: Throwable -> L41
    L30:
        this.i.put(r5, r3);     // Catch: Throwable -> L41
        if (this.l == null) goto L33;
        a r8 = b(this.f, r3);     // Catch: Throwable -> L41
    L34:
        if (r8 != null) goto L37;
        return null;
    L37:
        if (this.k != null) goto L39;
        this.k = new ConcurrentHashMap();     // Catch: Throwable -> L41
    L39:
        this.k.put(r5, r8);     // Catch: Throwable -> L41
        r7 = this.c;     // Catch: Throwable -> L41
        r4 = this.f95a;     // Catch: Throwable -> L41
        goto L23
    L33:
        r8 = a(this.f, r3);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        q8.b("ScanData", th);
        if (this.h() == true) goto L49;
        this.h = r1;
        this.j = r1;
        return r1;
    L49:
        return r1;
    }

    public boolean h() {
        if (this.u == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        return this.g;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        e6 r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.f();
    }

    public void l() {
        if (this.e == null) goto L7;
        q8.c("scan_apk", "ScanDataMedia | onScanCancel");
        IScanTaskCallBack r0 = this.e;
        if (r0 == null) goto L7;
        r0.onScanCanceled(this.d);
    L7:
        ApkSAFScanner r2 = this.s;
        if (r2 == null) goto L11;
        r2.cancel();
        return;
    }

    public void m() {
        if (this.e == null) goto L6;
        q8.c("scan_apk", "ScanDataMedia | onScanStarted");
        this.e.onScanStarted();
        return;
    }

    public void n() {
        o();
        this.e = null;
        this.c = null;
        this.f95a = null;
        this.b = null;
        this.d = null;
        this.h = null;
        this.j = null;
        ConcurrentHashMap r1 = this.i;
        if (r1 == null) goto L5;
        r1.clear();
        this.i = null;
    L5:
        ConcurrentHashMap r2 = this.k;
        if (r2 == null) goto L8;
        r2.clear();
        this.k = null;
    L8:
        this.F = null;
        this.l = null;
        this.o = null;
        if (this.r == null) goto L11;
        this.r.clear();
        this.r = null;
    L11:
        ApkSAFScanner r3 = this.s;
        if (r3 == null) goto L15;
        r3.release();
        this.s = null;
        return;
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onDirectoryChange(String r2, int r3) {
        if (r3 != 0) goto L4;
        this.m = this.n;
    L4:
        int r4 = r3 + this.m;
        this.n = r4;
        IScanTaskCallBack r1 = this.e;
        if (r1 == null) goto L8;
        r1.onDirectoryChange(r2, r4);
        return;
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundComRubbish(String r3, String r4, long r5) {
        if (this.u == null) goto L5;
        this.w.incrementAndGet();
        Bundle r0 = new Bundle();
        r0.putString("key", r3);
        r0.putString("full_path", r4);
        r0.putLong("file_size", r5);
        Message r6 = this.u.obtainMessage(1);
        r6.setData(r0);
        this.u.sendMessageDelayed(r6, 150);
        return;
    L5:
        a(r3, r4, r5);
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundEmptyDir(String r3, long r4) {
        if (this.u == null) goto L5;
        this.w.incrementAndGet();
        Bundle r0 = new Bundle();
        r0.putString("full_path", r3);
        r0.putLong("file_size", r4);
        Message r5 = this.u.obtainMessage(4);
        r5.setData(r0);
        this.u.sendMessageDelayed(r5, 150);
        return;
    L5:
        a(r3, r4);
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundKeySoftRubbish(String r3, String[] r4, long r5) {
        if (this.u == null) goto L5;
        this.w.incrementAndGet();
        Bundle r0 = new Bundle();
        r0.putString("key", r3);
        r0.putStringArray("detail_dirs", r4);
        r0.putLong("file_size", r5);
        Message r6 = this.u.obtainMessage(3);
        r6.setData(r0);
        this.u.sendMessageDelayed(r6, 150);
        return;
    L5:
        a(r3, r4, r5);
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundSoftRubbish(String r3, String r4, String r5, long r6) {
        if (this.u == null) goto L5;
        this.w.incrementAndGet();
        Bundle r0 = new Bundle();
        r0.putString("key", r3);
        r0.putString("detail_dir", r4);
        r0.putString("abs_path", r5);
        r0.putLong("file_size", r6);
        Message r7 = this.u.obtainMessage(2);
        r7.setData(r0);
        this.u.sendMessageDelayed(r7, 150);
        return;
    L5:
        a(r3, r4, r5, r6);
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onProcessChange(int r1) {
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onVisit(QFile r1) {
    }

    public void p() {
        this.y.set(true);
        if (this.w.get() != 0) goto L8;
        c r2 = this.x;
        if (r2 == null) goto L9;
        r2.a();
        return;
    L9:
        return;
    }

    private void a(String r13, String r14, long r15) {
    L45:
        th = move-exception;
        q8.b("ScanData", th);
        return;
    L4:
        if (TextUtils.isEmpty(r13) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r14) == false) goto L9;
        return;
    L9:
        if (this.c != null) goto L11;
        return;
    L11:
        if (this.f95a != null) goto L13;
        return;
    L13:
        if (this.b == null) goto L53;
        kd r10 = this.c.a(r13);     // Catch: Throwable -> L45
        if (r10 != null) goto L18;
        return;
    L18:
        h3 r1 = new h3();     // Catch: Throwable -> L45
        RubbishEntity r3 = null;
        if (r10 != this.c.g()) goto L32;
        if (a(r14, 2, null) == false) goto L23;
        r3 = r1.a(this, this.g, r14, r15, this.b, this.f95a, this.c.a());     // Catch: Throwable -> L45
    L23:
        if (r3 != null) goto L26;
        return;
    L26:
        if (r3.getPackageName() != null) goto L28;
    L34:
        if (r3 != null) goto L36;
        return;
    L36:
        if (this.e != null) goto L38;
        return;
    L38:
        if (this.d == null) goto L40;
        this.d.addRubbish(String.valueOf(r10.f306a), r3);     // Catch: Throwable -> L45
    L40:
        IScanTaskCallBack r0 = this.e;     // Catch: Throwable -> L45
        if (r0 == null) goto L56;
        r0.onRubbishFound(r3);     // Catch: Throwable -> L45
        return;
    L56:
        return;
    L28:
        if (this.b.get(r3.getPackageName()) == null) goto L30;
        ((List) this.b.get(r3.getPackageName())).add(Integer.valueOf(r3.getVersionCode()));     // Catch: Throwable -> L45
        goto L34
    L30:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L45
        r2.add(Integer.valueOf(r3.getVersionCode()));     // Catch: Throwable -> L45
        this.b.put(r3.getPackageName(), r2);     // Catch: Throwable -> L45
        goto L34
    L32:
        if (a(r14, 1, null) == false) goto L34;
        r3 = new RubbishEntity(1, r14, !r10.k, r15, null, null, r10.i);     // Catch: Throwable -> L45
        goto L34
    }

    private static int c(String r2) {
        Context r0 = TMSDKContext.getApplicaionContext();
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        r0.getPackageManager().getPackageInfo(r2, 1);     // Catch: Throwable -> L9
        return 1;
    L9:
        return 0;
    L15:
        return -1;
    }

    private boolean d(String r7) {
        List r0 = a();
        String[] r6 = this.c.e();
        if (r6 != null) goto L5;
        return false;
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        String r2 = (String) r1.next();
        if (r7.toLowerCase().contains(r2.toLowerCase()) == false) goto L7;
        String r3 = r7.toLowerCase().substring(r2.length());
        int r4 = r6.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L7;
        if (r6[r5].toLowerCase().startsWith(r3) == true) goto L14;
        r5 = r5 + 1;
        goto L11
    L14:
        return true;
    L17:
        return false;
    }

    protected Map b() {
        ArrayList r3 = a(73, 2);
        HashMap r0 = new HashMap();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        m r1 = (m) r4.next();
        r0.put(r1.k(), r1);
        goto L4
    L6:
        return r0;
    }

    public void e(String r3) {
        this.l = r3;
        Map r0 = this.c.c(r3);
        if ((this.c instanceof p8) == false) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L14:
        this.c = new p8(this);
        return;
    L7:
        if (r0.size() == 0) goto L14;
        p8 r1 = new p8(this);
        Map r4 = r1.c(r3);
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.size() <= r0.size()) goto L17;
        this.c = r1;
        return;
    }

    private void a(String r11, long r12) {
    L27:
        th = move-exception;
        q8.b("ScanData", th);
        return;
    L3:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (d(r11) == false) goto L8;
        return;
    L8:
        String r9 = tb.a("scan_item_empty_folders");     // Catch: Throwable -> L27
        if (this.r == null) goto L14;
        if (this.r.containsKey(r11.toLowerCase()) == false) goto L14;
        return;
    L14:
        if (a(r11, 1, "") == false) goto L16;
        RubbishEntity r0 = new RubbishEntity(1, r11, true, r12, null, null, r9);     // Catch: Throwable -> L27
    L17:
        if (r0 != null) goto L19;
        return;
    L19:
        if (this.e != null) goto L21;
        return;
    L21:
        if (this.d == null) goto L23;
        this.d.addRubbish(r0);     // Catch: Throwable -> L27
    L23:
        IScanTaskCallBack r10 = this.e;     // Catch: Throwable -> L27
        if (r10 == null) goto L34;
        r10.onRubbishFound(r0);     // Catch: Throwable -> L27
        return;
    L34:
        return;
    L16:
        r0 = null;
        goto L17
    }

    public static void e(int r8) {
        StringBuilder r0 = new StringBuilder();
        PackageInfo r1 = d();
        boolean r2 = m3.v();
        String r3 = f();
        StringBuilder r9 = r0.append(r8).append(",").append(ve.b()).append(",8.2.13,3272,").append(Build.VERSION.SDK_INT).append(",").append(la.d()).append(",").append(Build.PRODUCT).append(",").append(Build.MANUFACTURER).append(",").append(Build.BRAND).append(",").append(Build.FINGERPRINT).append(",");
        String r6 = "";
        if (TMSDKContext.getApplicaionContext() == null) goto L5;
        String r5 = TMSDKContext.getApplicaionContext().getPackageName();
    L6:
        StringBuilder r10 = r9.append(r5).append(",");
        if (r1 == null) goto L11;
        ApplicationInfo r7 = r1.applicationInfo;
        if (r7 == null) goto L11;
        String r11 = r7.loadLabel(TMSDKContext.getApplicaionContext().getPackageManager()).toString();
    L12:
        StringBuilder r12 = r10.append(r11).append(",");
        if (r1 == null) goto L15;
        r6 = r1.versionName;
    L15:
        StringBuilder r13 = r12.append(r6).append(",");
        if (r1 == null) goto L18;
        Object r4 = Integer.valueOf(r1.versionCode);
    L19:
        StringBuilder r14 = r13.append(r4).append(",");
        String r15 = "1";
        if (r2 == false) goto L22;
        String r16 = "1";
    L23:
        StringBuilder r17 = r14.append(r16).append(",").append(r3).append(",");
        if (r2 == true) goto L26;
    L28:
        r15 = "0";
    L29:
        r17.append(r15);
        f.a(1320201, r0.toString());
        return;
    L26:
        if (TextUtils.equals(r3, "0_0_0_0") == true) goto L28;
    L22:
        r16 = "0";
        goto L23
    L18:
        r4 = "-1";
    L11:
        r11 = "";
        goto L12
    L5:
        r5 = "";
        goto L6
    }

    public void c(int r3) {
        if (this.e == null) goto L8;
        q8.c("scan_apk", "ScanDataMedia | onScanError = " + r3);
        IScanTaskCallBack r0 = this.e;
        if (r0 == null) goto L9;
        r0.onScanError(r3, this.d);
        return;
    L9:
        return;
    }

    public void d(int r8) {
        if (this.e != null) goto L5;
        return;
    L5:
        if (this.d == null) goto L36;
        PackageInfo r9 = d();
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append(this.q).append(",").append(System.currentTimeMillis() - this.p).append(",").append(this.d.getSelectedRubbishFileSize()).append(",").append(this.d.getAllRubbishFileSize()).append(",").append(this.d.getSuggetRubbishFileSize()).append(",").append(this.d.getInstallRubbishFileSize()).append(",").append(this.d.getSystemRubbishFileSize()).append(",").append(this.d.getUnInstallRubbishFileSize()).append(",").append(this.d.getApkRubbishFileSize()).append(",");
        if (TextUtils.isEmpty(this.l) == true) goto L9;
        String r3 = this.l;
    L10:
        StringBuilder r2 = r1.append(r3).append(",").append(ve.b()).append(",").append(Build.VERSION.SDK_INT).append(",").append(la.d()).append(",").append(fd.i()).append(",8.2.13,3272,").append(this.d.getScanAllFileCount()).append(",").append(this.d.getScanInstallFileCount()).append(",").append(this.d.getScanSystemFileCount()).append(",").append(this.d.getScanUnInstallFileCount()).append(",").append(this.d.getScanApkFileCount()).append(",").append(fd.h()).append(",");
        String r4 = "";
        if (TMSDKContext.getApplicaionContext() == null) goto L13;
        String r5 = TMSDKContext.getApplicaionContext().getPackageName();
    L14:
        StringBuilder r6 = r2.append(r5).append(",");
        if (r9 == null) goto L19;
        ApplicationInfo r7 = r9.applicationInfo;
        if (r7 == null) goto L19;
        String r10 = r7.loadLabel(TMSDKContext.getApplicaionContext().getPackageManager()).toString();
    L20:
        StringBuilder r11 = r6.append(r10).append(",");
        if (r9 == null) goto L23;
        r4 = r9.versionName;
    L23:
        StringBuilder r12 = r11.append(r4).append(",");
        if (r9 == null) goto L26;
        Object r13 = Integer.valueOf(r9.versionCode);
    L27:
        StringBuilder r14 = r12.append(r13).append(",");
        if (m3.v() == false) goto L30;
        String r15 = "1";
    L31:
        r14.append(r15).append(",").append(Build.PRODUCT).append(",").append(Build.MANUFACTURER).append(",").append(Build.BRAND).append(",").append(Build.FINGERPRINT).append(",").append(f());
        f.a(1320078, r0.toString());
        IScanTaskCallBack r16 = this.e;
        if (r16 == null) goto L37;
        r16.onScanFinished(this.d);
        this.e = null;
        return;
    L37:
        return;
    L30:
        r15 = "0";
        goto L31
    L26:
        r13 = "-1";
    L19:
        r10 = "";
        goto L20
    L13:
        r5 = "";
        goto L14
    L9:
        r3 = "NULL";
        goto L10
    }

    private void a(String r19, String[] r20, long r21) {
    L71:
        th = move-exception;
        q8.b("ScanData", th);
        return;
    L4:
        if (TextUtils.isEmpty(r19) == true) goto L70;
        if (r20 != null) goto L7;
        return;
    L7:
        if (r20.length != 0) goto L10;
        return;
    L10:
        if (this.j == null) goto L12;
        a r2 = this.j;     // Catch: Throwable -> L71
    L15:
        boolean r3 = false;
        int r5 = Integer.parseInt(r19);     // Catch: Exception -> L18 Throwable -> L71
        boolean r6 = false;
    L20:
        long r13 = r21 / 1000;     // Catch: Throwable -> L71
        List r1 = Arrays.asList(r20);     // Catch: Throwable -> L71
        RubbishEntity r7 = null;
        if (r6 == false) goto L27;
        he r8 = (he) this.i.get(r19);     // Catch: Throwable -> L71
        if (r8 != null) goto L25;
        return;
    L25:
        ce r9 = r8.a(0);     // Catch: Throwable -> L71
    L38:
        ce r10 = r9;
    L39:
        if (r10 == null) goto L81;
        this.F = r10;     // Catch: Throwable -> L71
        if (r2 != null) goto L43;
    L50:
        int r11 = r10.c;     // Catch: Throwable -> L71
        if (r11 != 1) goto L54;
        boolean r12 = false;
    L56:
        if (r2 == null) goto L60;
        List r14 = a(r1, 0, r2.f96a);     // Catch: Throwable -> L71
        if (r14.isEmpty() == true) goto L60;
        r7 = new RubbishEntity(0, r14, !r12, r13, r2.b, r2.f96a, r10.d);     // Catch: Throwable -> L71
    L60:
        if (r7 == null) goto L82;
        r7.setExtendData(r10.k, r10.l, r10.o);     // Catch: Throwable -> L71
        if (this.e != null) goto L64;
        return;
    L64:
        if (this.d == null) goto L66;
        this.d.addRubbish(String.valueOf(r10.f130a), r7);     // Catch: Throwable -> L71
    L66:
        IScanTaskCallBack r0 = this.e;     // Catch: Throwable -> L71
        if (r0 == null) goto L84;
        r0.onRubbishFound(r7);     // Catch: Throwable -> L71
        return;
    L84:
        return;
    L82:
        return;
    L54:
        if (r11 != 2) goto L80;
        r12 = true;
        goto L56
    L80:
        return;
    L43:
        if (r2.c == false) goto L50;
        if (r10.c != 3) goto L47;
        r3 = true;
    L47:
        List r15 = a(r1, 4, r2.f96a);     // Catch: Throwable -> L71
        if (r15.isEmpty() == true) goto L60;
        r7 = new RubbishEntity(4, r15, !r3, r13, r2.b, r2.f96a, r10.d);     // Catch: Throwable -> L71
        goto L60
    L81:
        return;
    L27:
        if (this.F != null) goto L29;
    L31:
        r10 = null;
    L32:
        if (r10 == null) goto L34;
    L36:
        if (r10 != null) goto L39;
        r9 = a(r5);     // Catch: Throwable -> L71
        goto L38
    L34:
        if (this.h == null) goto L36;
        r10 = this.h.a(r5);     // Catch: Throwable -> L71
        goto L36
    L29:
        if (this.F.f130a != r5) goto L31;
        r10 = this.F;     // Catch: Throwable -> L71
    L18:
        r5 = -1;
        r6 = true;
        goto L20
    L12:
        r2 = a(r20);     // Catch: Throwable -> L71
        if (r2 != null) goto L15;
        return;
    }

    private void b(String r12, String r13, long r14) {
        if (TextUtils.isEmpty(r13) == false) goto L20;
        return;
    L20:
        String r3 = f94J + r13;     // Catch: Throwable -> L17
        m r15 = new m();     // Catch: Throwable -> L17
        r15.a(true);     // Catch: Throwable -> L17
        r15.a(r3);     // Catch: Throwable -> L17
        m r16 = n.a(true, r15.a());     // Catch: Throwable -> L17
        if (r16 == null) goto L8;
        r12 = r16.b();     // Catch: Throwable -> L17
    L8:
        String r7 = r12;
        if (r16 == null) goto L12;
        String r17 = r16.k();     // Catch: Throwable -> L17
    L13:
        RubbishEntity r10 = new RubbishEntity(2, r3, false, r14, r7, r17, tb.a("apk"));     // Catch: Throwable -> L17
        if (this.d == null) goto L22;
        this.d.addRubbish("apk", r10);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    L12:
        r17 = "";
    L17:
        th = move-exception;
        q8.b("ScanData", th);
    }

    private void a(String r20, String r21, String r22, long r23) {
        String r1 = r21;
    L73:
        th = move-exception;
        q8.b("ScanData", th);
        return;
    L4:
        if (TextUtils.isEmpty(r20) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r21) == false) goto L9;
        return;
    L9:
        if (this.j == null) goto L11;
        a r3 = this.j;     // Catch: Throwable -> L73
    L14:
        boolean r4 = false;
        int r6 = Integer.parseInt(r20);     // Catch: Exception -> L17 Throwable -> L73
        boolean r7 = false;
    L19:
        long r14 = r23 / 1000;     // Catch: Throwable -> L73
        if (r22 != null) goto L22;
    L21:
        String r12 = r1;
        RubbishEntity r2 = null;
        if (r7 == false) goto L30;
        he r5 = (he) this.i.get(r20);     // Catch: Throwable -> L73
        if (r5 != null) goto L28;
        return;
    L28:
        ce r8 = r5.a(0);     // Catch: Throwable -> L73
    L41:
        if (r8 == null) goto L82;
        this.F = r8;     // Catch: Throwable -> L73
        if (r3 != null) goto L45;
    L52:
        int r9 = r8.c;     // Catch: Throwable -> L73
        if (r9 != 1) goto L56;
        boolean r10 = false;
    L58:
        if (r3 != null) goto L60;
    L62:
        if (r2 == null) goto L83;
        r2.setExtendData(r8.k, r8.l, r8.o);     // Catch: Throwable -> L73
        if (this.e != null) goto L66;
        return;
    L66:
        if (this.d == null) goto L68;
        this.d.addRubbish(String.valueOf(r8.f130a), r2);     // Catch: Throwable -> L73
    L68:
        IScanTaskCallBack r0 = this.e;     // Catch: Throwable -> L73
        if (r0 == null) goto L85;
        r0.onRubbishFound(r2);     // Catch: Throwable -> L73
        return;
    L85:
        return;
    L83:
        return;
    L60:
        if (a(r12, 0, r3.f96a) == false) goto L62;
        r2 = new RubbishEntity(0, r12, !r10, r14, r3.b, r3.f96a, r8.d);     // Catch: Throwable -> L73
        goto L62
    L56:
        if (r9 != 2) goto L81;
        r10 = true;
        goto L58
    L81:
        return;
    L45:
        if (r3.c == false) goto L52;
        if (r8.c != 3) goto L50;
        r4 = true;
    L50:
        if (a(r12, 4, r3.f96a) == false) goto L62;
        r2 = new RubbishEntity(4, r12, !r4, r14, r3.b, r3.f96a, r8.d);     // Catch: Throwable -> L73
        goto L62
    L82:
        return;
    L30:
        if (this.F != null) goto L32;
    L34:
        r8 = null;
    L35:
        if (r8 == null) goto L37;
    L39:
        if (r8 != null) goto L41;
        r8 = a(r6);     // Catch: Throwable -> L73
        goto L41
    L37:
        if (this.h == null) goto L39;
        r8 = this.h.a(r6);     // Catch: Throwable -> L73
        goto L39
    L32:
        if (this.F.f130a != r6) goto L34;
        r8 = this.F;     // Catch: Throwable -> L73
        goto L35
    L22:
        r1 = r1 + r22;     // Catch: Throwable -> L73
    L17:
        r6 = -1;
        r7 = true;
        goto L19
    L11:
        r3 = b(r1);     // Catch: Throwable -> L73
        if (r3 != null) goto L14;
    }

    public boolean b(Set r3) {
        if (r3 == null) goto L7;
        Iterator r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L7;
        String r0 = (String) r4.next();
        this.c.b(r0);
    L7:
        this.c.e();
        return true;
    }

    private void a(PackageInfo r6, m r7, int r8, PackageManager r9) {
        if (r6 == null) goto L35;
        if (r7 == null) goto L37;
        ApplicationInfo r5 = r6.applicationInfo;
        if (r5 != null) goto L8;
        return;
    L8:
        int r0 = -1;
        boolean r1 = false;
        if ((r8 & 1) == 0) goto L20;
        r7.a(1, r5.packageName);
        if ((r6.applicationInfo.flags & 1) == 0) goto L13;
        boolean r10 = true;
    L14:
        r7.a(4, Boolean.valueOf(r10));
        ApplicationInfo r11 = r6.applicationInfo;
        if (r11 == null) goto L17;
        int r12 = r11.uid;
    L18:
        r7.a(2, Integer.valueOf(r12));
        goto L20
    L17:
        r12 = -1;
        goto L18
    L13:
        r10 = false;
    L20:
        if ((r8 & 2) == 0) goto L29;
        r7.a(1, r6.applicationInfo.packageName);
        if ((r6.applicationInfo.flags & 1) == 0) goto L24;
        r1 = true;
    L24:
        r7.a(4, Boolean.valueOf(r1));
        ApplicationInfo r13 = r6.applicationInfo;
        if (r13 == null) goto L27;
        r0 = r13.uid;
    L27:
        r7.a(2, Integer.valueOf(r0));
    L29:
        if ((r8 & 8) == 0) goto L32;
        r7.a(7, r6.versionName);
        r7.a(8, Integer.valueOf(r6.versionCode));
    L32:
        if ((r8 & 64) == 0) goto L36;
        r7.a(15, r6.applicationInfo.sourceDir);
        r7.a(16, Boolean.FALSE);
        return;
    L36:
        return;
    L37:
        return;
    }

    private a b(boolean r5, he r6) {
        a r7 = new a(this);
        m r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        Map r8 = r6.b;
        if (r8 == null) goto L29;
        boolean r2 = true;
        if (r8.size() < 1) goto L29;
        r7.f96a = this.l;
        m r1 = (m) this.f95a.get(this.l);
        if (r1 != null) goto L21;
        r7.b = (String) r8.get(this.l);
        Iterator r9 = r8.keySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L17;
        r0 = (m) this.f95a.get((String) r9.next());
        if (r0 == null) goto L14;
    L17:
        if (r0 == null) goto L20;
        r2 = false;
    L20:
        r7.c = r2;
    L28:
        return r7;
    L21:
        r7.f96a = r1.k();
        if (r1.b() == null) goto L30;
    L27:
        r7.b = r1.b();
        r7.c = false;
        goto L28
    L30:
        PackageManager r4 = TMSDKContext.getApplicaionContext().getPackageManager();     // Catch: Exception -> L25
        r1.b(r4.getApplicationLabel(r4.getApplicationInfo(r1.k(), 0)).toString());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        q8.b("ScanData", e);
    L29:
        return null;
    }

    public boolean a(String r4, int r5) {
        if (this.E == true) goto L14;
        return true;
    L14:
    L11:
        th = move-exception;
        q8.c("ScanData", th);
        return true;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L10;
        q8.c("scan_result", "path isEmpty = " + r4 + ", type = " + r5);     // Catch: Throwable -> L11
        return false;
    L10:
        return true;
    }

    private boolean a(String r2, int r3, String r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.equals(r2, LibrarianImpl.Constants.SEPARATOR) == true) goto L14;
        if (a(r2, r3) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        th = move-exception;
        q8.b("rubbish_filter", th);
        goto L14
    }

    private List a(List r4, int r5, String r6) {
        if (r4 != null) goto L4;
    L13:
        return r4;
    L4:
        if (r4.isEmpty() == true) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r4.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        String r1 = (String) r7.next();
        if (a(r1, r5, r6) == false) goto L8;
        r0.add(r1);
        goto L8
    L12:
        return r0;
    }

    private a a(String[] r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length != 0) goto L7;
        return null;
    L7:
        return b(r2[0]);
    }

    private ce a(int r3) {
        ConcurrentHashMap r0 = this.i;
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r2 = this.i.values().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ce r1 = ((he) r2.next()).a(r3);
        if (r1 == null) goto L9;
        return r1;
    }

    public List a() {
        List r0 = this.o;
        if (r0 != null) goto L5;
    L6:
        this.o = ac.c();
    L8:
        return this.o;
    L5:
        if (r0.size() >= 1) goto L8;
        goto L6
    }

    private a a(boolean r11, he r12) {
        a r13 = new a(this);
        String r0 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Map r14 = r12.b;
        if (r14 != null) goto L8;
    L40:
        return null;
    L8:
        if (r14.size() < 1) goto L40;
        Iterator r1 = r14.keySet().iterator();
        m r3 = null;
    L12:
        if (r1.hasNext() == false) goto L16;
        r3 = (m) this.f95a.get((String) r1.next());
        if (r3 == null) goto L12;
    L16:
        if (r3 != null) goto L32;
        Map r2 = bc.a().b();
        if (r2.size() <= 0) goto L29;
        Iterator r4 = r14.keySet().iterator();
        long r5 = 0;
    L21:
        if (r4.hasNext() == false) goto L28;
        String r6 = (String) r4.next();
        if (r2.get(r6) == null) goto L21;
        long r7 = ((Long) r2.get(r6)).longValue();
        if (r7 <= r5) goto L21;
        r0 = r6;
        r5 = r7;
        goto L21
    L28:
        r13.b = (String) r14.get(r0);
    L29:
        if (r0 != null) goto L31;
        r0 = (String) r14.keySet().toArray()[0];
        r13.b = (String) r14.get(r0);
    L31:
        r13.f96a = r0;
        r13.c = true;
    L39:
        return r13;
    L32:
        r13.f96a = r3.k();
        if (r3.b() == null) goto L41;
    L38:
        r13.b = r3.b();
        r13.c = false;
        goto L39
    L41:
        PackageManager r15 = TMSDKContext.getApplicaionContext().getPackageManager();     // Catch: Exception -> L36
        r3.b(r15.getApplicationLabel(r15.getApplicationInfo(r3.k(), 0)).toString());     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }

    public void a(c r1) {
        this.x = r1;
    }

    public void a(Set r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L19;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L20;
        String r0 = (String) r4.next();
        if (TextUtils.isEmpty(r0) == true) goto L8;
        a(r0);
        goto L8
    L20:
        return;
    }

    private ArrayList a(int r7, int r8) {
        PackageManager r0 = TMSDKContext.getApplicaionContext().getPackageManager();
        List<PackageInfo> r1 = r0.getInstalledPackages(b(r7));     // Catch: Exception -> L5
    L7:
        ArrayList r2 = new ArrayList();
        if (r1 == null) goto L22;
        Iterator<PackageInfo> r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L22;
        PackageInfo r4 = r3.next();
        if ((r4.applicationInfo.flags & 1) == 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        if (r8 == 1) goto L11;
    L18:
        if (r5 == false) goto L21;
        if (r8 == 0) goto L11;
    L21:
        m r6 = new m();
        a(r4, r6, r7, r0);
        r2.add(r6);
        goto L11
    L15:
        r5 = false;
    L22:
        return r2;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L7
    }
}
