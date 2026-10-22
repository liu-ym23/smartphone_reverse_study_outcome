package tmsdk.common.module.qscanner.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.android.apksigner.ApkSignerTool;
import com.android.apksigner.CertInfoObject;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.security.safecheckapi.CheckResult;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.TMSDKContext;
import tmsdk.common.TMServiceFactory;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;
import tmsdk.common.module.qscanner.QScanListener;
import tmsdk.common.module.qscanner.QScanResultEntity;
import tmsdk.common.module.qscanner.QScanResultPluginEntity;
import tmsdk.common.module.qscanner.QScannerManagerV2;
import tmsdk.common.module.update.SdkSettingUpdate;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.tcc.ApkSAFScanner;
import tmsdk.common.tcc.QFile;
import tmsdk.common.tcc.QSdcardScanner;
import tmsdk.common.tcc.SdcardScannerFactory;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.ac;
import tmsdkobf.b0;
import tmsdkobf.b1;
import tmsdkobf.bg;
import tmsdkobf.c0;
import tmsdkobf.d2;
import tmsdkobf.dd;
import tmsdkobf.eb;
import tmsdkobf.ed;
import tmsdkobf.f;
import tmsdkobf.fb;
import tmsdkobf.g8;
import tmsdkobf.gb;
import tmsdkobf.h8;
import tmsdkobf.hb;
import tmsdkobf.j2;
import tmsdkobf.k1;
import tmsdkobf.k2;
import tmsdkobf.kc;
import tmsdkobf.l;
import tmsdkobf.m;
import tmsdkobf.mg;
import tmsdkobf.n;
import tmsdkobf.nf;
import tmsdkobf.of;
import tmsdkobf.pb;
import tmsdkobf.q8;
import tmsdkobf.qb;
import tmsdkobf.qe;
import tmsdkobf.r4;
import tmsdkobf.rb;
import tmsdkobf.s9;
import tmsdkobf.sb;
import tmsdkobf.sc;
import tmsdkobf.uf;
import tmsdkobf.ve;
import tmsdkobf.w6;
import tmsdkobf.x8;
import tmsdkobf.xb;
import tmsdkobf.yb;
import tmsdkobf.yf;
import tmsdkobf.z4;
import tmsdkobf.za;
import tmsdkobf.zb;
import tmsdkobf.zd;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends BaseManagerF {
    private static final String[] A = null;
    public static final byte[] B = null;
    private Context b;
    private AmScannerV2 c;
    private int d;
    private int e;
    private byte[] f;
    private boolean g;
    private boolean h;
    private Object i;
    private boolean j;
    private boolean k;
    private Object l;
    private String m;
    private Object n;
    private volatile int o;
    private volatile int p;
    private volatile long q;
    private volatile int r;
    private volatile int s;
    private volatile long t;
    private volatile long u;
    private volatile long v;
    private volatile long w;
    private volatile int x;
    private volatile int y;
    private volatile int z;

    class a implements c0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f49a;
        final /* synthetic */ QScanListener b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ List g;
        final /* synthetic */ ArrayList h;
        final /* synthetic */ Map i;
        final /* synthetic */ ArrayList j;
        final /* synthetic */ b k;

        a(b r1, int[] r2, QScanListener r3, ArrayList r4, int r5, boolean r6, ArrayList r7, List r8, ArrayList r9, Map r10, ArrayList r11) {
            this.k = r1;
            this.f49a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }

        @Override // tmsdkobf.c0.a
        public void onFound(int r12, QFile r13) {
            q8.c(QScannerManagerV2.LOG_TAG, "onFound,ruleId:[" + r12 + "]path:[" + r13.filePath + "]");
            b r14 = this.k;
            b.m2343$$Nest$fputr(r14, b.m2342$$Nest$fgetr(r14) + 1);
            b.m2349$$Nest$mb(this.k, this.f49a[0], this.b);
            if (b.m2348$$Nest$ma(this.k, this.f49a[0], this.b) == true) goto L5;
            m r15 = new m();
            r15.a(true);
            r15.a(r13.filePath);
            r15.b(r13.modifyTime);
            r15.c(r13.size);
            File r1 = new File(r13.filePath);     // Catch: Throwable -> L23
            r15.g(r1.getName());     // Catch: Throwable -> L23
            if (r15.m() != 0) goto L15;
            r15.c(r1.length());     // Catch: Throwable -> L23
        L15:
            if (r15.j() != 0) goto L17;
            r15.b(r1.lastModified());     // Catch: Throwable -> L23
        L17:
            b.m2347$$Nest$ma(this.k, r15, this.d, this.e, this.f, this.g, this.h, this.b, this.i, this.j);
            if (b.m2342$$Nest$fgetr(this.k) > 0) goto L20;
            return;
        L20:
            if ((b.m2342$$Nest$fgetr(this.k) % 220) != 0) goto L29;
            System.gc();
            q8.c(QScannerManagerV2.LOG_TAG, "scan gc in onFound, mCount = " + b.m2342$$Nest$fgetr(this.k));
            return;
        L29:
            return;
        L5:
            if (this.c.size() > 0) goto L7;
            return;
        L7:
            if (this.c.get(0) == null) goto L27;
            q8.c(QScannerManagerV2.LOG_TAG, "QSdcardScanner cancel");
            ((QSdcardScanner) this.c.get(0)).cancleScan();
            return;
        }
    }

    /* JADX INFO: renamed from: tmsdk.common.module.qscanner.impl.b$b, reason: collision with other inner class name */
    class C0090b implements QSdcardScanner.ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f50a;
        final /* synthetic */ QScanListener b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ Set d;
        final /* synthetic */ b e;

        C0090b(b r1, int[] r2, QScanListener r3, ArrayList r4, Set r5) {
            this.e = r1;
            this.f50a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // tmsdk.common.tcc.QSdcardScanner.ProgressListener
        public boolean onScanPathChange(String r9) {
            b.m2349$$Nest$mb(this.e, this.f50a[0], this.b);
            if (b.m2348$$Nest$ma(this.e, this.f50a[0], this.b) == true) goto L5;
            String r0 = x8.b(r9);
            if (this.d.contains(r0) == true) goto L24;
            this.d.add(r0);
            String[] r8 = b.m2350$$Nest$sfgetA();
            if (r8 == null) goto L22;
            int r1 = r8.length;
            int r3 = 0;
        L15:
            if (r3 >= r1) goto L27;
            if (r9.endsWith(LibrarianImpl.Constants.SEPARATOR + r8[r3]) == true) goto L18;
            r3 = r3 + 1;
            goto L15
        L18:
            StringBuilder r10 = new StringBuilder("mIgnoreDirs path:[");
        L19:
            q8.c(QScannerManagerV2.LOG_TAG, r10.append(r9).append("]").toString());
            return false;
        L27:
            return true;
        L22:
            return true;
        L24:
            r10 = new StringBuilder("has scanned path:[");
            goto L19
        L5:
            if (this.c.size() > 0) goto L7;
        L9:
            return false;
        L7:
            if (this.c.get(0) == null) goto L9;
            q8.c(QScannerManagerV2.LOG_TAG, "QSdcardScanner cancel");
            ((QSdcardScanner) this.c.get(0)).cancleScan();
            goto L9
        }
    }

    class c implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f51a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ QScanListener d;
        final /* synthetic */ List e;
        final /* synthetic */ k1 f;
        final /* synthetic */ long g;
        final /* synthetic */ za h;
        final /* synthetic */ boolean i;
        final /* synthetic */ Object j;
        final /* synthetic */ b k;

        c(b r1, long r2, long r4, int r6, QScanListener r7, List r8, k1 r9, long r10, za r12, boolean r13, Object r14) {
            this.k = r1;
            this.f51a = r2;
            this.b = r4;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r12;
            this.i = r13;
            this.j = r14;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r10, int r11, int r12, int r13, JceStruct r14) {
            q8.c(QScannerManagerV2.LOG_TAG, "[Shark]onFinish-Cmd_CSVirusCheck, elapsed time:[" + (System.currentTimeMillis() - this.f51a) + "]cmdId:[" + r11 + "]retCode:[" + r12 + "]dataRetCode: " + r13);
            q8.b(QScannerManagerV2.LOG_TAG, "[QScannerManagerV2] disconnect for CloudScan");
            f.a(1320109, this.c + ";" + (System.currentTimeMillis() - this.b) + ";" + r12 + ";" + r13);
            b.m2349$$Nest$mb(this.k, 2, this.d);
            if (b.m2348$$Nest$ma(this.k, 2, this.d) == true) goto L40;
            if (r12 != 0) goto L27;
            if (r13 != 0) goto L27;
            if (r14 == null) goto L25;
            sc r15 = (sc) r14;
            q8.c(QScannerManagerV2.LOG_TAG, "server handle time(micro seconds): " + r15.d);
            if (r15.f509a == null) goto L12;
            b.m2346$$Nest$ma(this.k, this.e, r15);
        L13:
            Map r16 = r15.e;
            if (r16 == null) goto L20;
            if (r16.size() == 0) goto L20;
            b.m2344$$Nest$ma(this.k, this.e, this.d, this.f.f298a, this.g, this.h, r15.e, this.i);
        L24:
            q8.c(QScannerManagerV2.LOG_TAG, "trpCheckParam:[" + r15.i + "]");
        L20:
            if (r15.e != null) goto L22;
            String r17 = "null";
        L23:
            q8.c(QScannerManagerV2.LOG_TAG, "not need FeatureCheck, scVirusCheck.mapFeatureParam: ".concat(r17));
            goto L24
        L22:
            r17 = "empty";
            goto L23
        L12:
            q8.c(QScannerManagerV2.LOG_TAG, "scVirusCheck.vecApkInfo is null, maybe because same as local result!");
            goto L13
        L25:
            q8.e(QScannerManagerV2.LOG_TAG, "Cmd_CSVirusCheck-onFinish, scVirusCheck is null!");
            q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanError, QScanConstants.SCAN_CLOUD-:[-205]");
            QScanListener r18 = this.d;
            int r19 = -205;
        L26:
            r18.onScanError(r19);
        L27:
            Iterator r110 = this.e.iterator();
        L29:
            if (r110.hasNext() == false) goto L33;
            hb r111 = (hb) r110.next();
            if (r111.L == false) goto L29;
            r111.l = 0;
            r111.m = null;
            r111.n = null;
            r111.o = null;
            r111.p = null;
            r111.q = null;
            r111.r = 0;
            goto L29
        L33:
            q8.e(QScannerManagerV2.LOG_TAG, "Cmd_CSVirusCheck-onFinish, fail-retCode:[" + r12 + "]dataRetCode:[" + r13 + "]");
            if (r12 == 0) goto L38;
            StringBuilder r112 = new StringBuilder("[callback]onScanError, QScanConstants.SCAN_CLOUD-retCode:[");
            q8.c(QScannerManagerV2.LOG_TAG, r112.append(r12).append("]").toString());
            if ((r12 % 20) != (-4)) goto L39;
            r18 = this.d;
            r19 = -206;
        L39:
            this.d.onScanError(-999);
            goto L40
        L38:
            r112 = new StringBuilder("[callback]onScanError, QScanConstants.SCAN_CLOUD-dataRetCode:[");
            q8.c(QScannerManagerV2.LOG_TAG, r112.append(r13).append("]").toString());
        L40:
            Object r113 = this.j;
            monitor-enter(r113);
            this.j.notify();     // Catch: Throwable -> L45
            monitor-exit(r113);     // Catch: Throwable -> L45
            return;
        L45:
            th = move-exception;
            throw th;
        }
    }

    class d implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f52a;
        final /* synthetic */ QScanListener b;
        final /* synthetic */ List c;
        final /* synthetic */ Object d;
        final /* synthetic */ b e;

        d(b r1, long r2, QScanListener r4, List r5, Object r6) {
            this.e = r1;
            this.f52a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r6, int r7, int r8, int r9, JceStruct r10) {
            q8.c(QScannerManagerV2.LOG_TAG, "[Shark]onFinish-Cmd_CSFeatureCheck, elapsed time:[" + (System.currentTimeMillis() - this.f52a) + "]cmdId:[" + r7 + "]retCode:[" + r8 + "]dataRetCode: " + r9);
            q8.b(QScannerManagerV2.LOG_TAG, "[QScannerManagerV2] disconnect for FeatureCheck");
            b.m2349$$Nest$mb(this.e, 2, this.b);
            if (b.m2348$$Nest$ma(this.e, 2, this.b) == true) goto L16;
            if (r8 != 0) goto L15;
            if (r9 != 0) goto L15;
            if (r10 == null) goto L13;
            kc r11 = (kc) r10;
            q8.c(QScannerManagerV2.LOG_TAG, "server handle time(micro seconds): " + r11.d);
            if (r11.f305a == null) goto L12;
            b.m2345$$Nest$ma(this.e, this.c, r11);
            goto L16
        L12:
            String r12 = QScannerManagerV2.LOG_TAG;
            String r13 = "scFeatureCheck.vecFeatureInfo is null!";
        L14:
            q8.e(r12, r13);
            goto L16
        L13:
            r12 = QScannerManagerV2.LOG_TAG;
            r13 = "scFeatureCheck is null!";
        L15:
            q8.e(QScannerManagerV2.LOG_TAG, "onFinish-Cmd_CSFeatureCheck fail" + r6 + " cmdId: " + r7 + " retCode: " + r8 + " dataRetCode: " + r9);
        L16:
            Object r14 = this.d;
            monitor-enter(r14);
            this.d.notify();     // Catch: Throwable -> L21
            monitor-exit(r14);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f53a;
        public String b;
        public String c;
        public String d;

        public e(String r1, String r2, String r3, String r4) {
            this.f53a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public String toString() {
            return "cert1 = " + this.f53a + ", cert2 = " + this.b + ", dexSha1 = " + this.c + ", appInfos = " + this.d;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$bKuPcN-lG4mS4-4pyw3mfTFJaXc, reason: not valid java name */
    public static /* synthetic */ void m2341$r8$lambda$bKuPcNlG4mS44pyw3mfTFJaXc(b r0, int[] r1, QScanListener r2, ArrayList r3, ApkSAFScanner r4, int r5, boolean r6, ArrayList r7, List r8, ArrayList r9, Map r10, ArrayList r11, String r12, String r13, long r14) {
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetr, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2342$$Nest$fgetr(b r0) {
        return r0.r;
    }

    /* JADX INFO: renamed from: -$$Nest$fputr, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2343$$Nest$fputr(b r0, int r1) {
        r0.r = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2344$$Nest$ma(b r0, List r1, QScanListener r2, qb r3, long r4, za r6, Map r7, boolean r8) {
        r0.a(r1, r2, r3, r4, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2345$$Nest$ma(b r0, List r1, kc r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2346$$Nest$ma(b r0, List r1, sc r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2347$$Nest$ma(b r0, m r1, int r2, boolean r3, ArrayList r4, List r5, ArrayList r6, QScanListener r7, Map r8, ArrayList r9) {
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2348$$Nest$ma(b r0, int r1, QScanListener r2) {
        return r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2349$$Nest$mb(b r0, int r1, QScanListener r2) {
        r0.b(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetA, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m2350$$Nest$sfgetA() {
        return A;
    }

    static {
        A = new String[]{SlardarSettingsConsts.SETTING_IMAGE, "icon", "photo", "music", "dcim", "weibo"};
        B = new byte[]{77, 68, 53};
    }

    public b() {
        this.d = 0;
        this.e = 0;
        this.f = new byte[0];
        this.h = false;
        this.i = new Object();
        this.j = false;
        this.k = false;
        this.l = new Object();
        this.m = "";
        this.n = new Object();
        this.o = 0;
        this.p = -1;
        this.w = 1;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    private static l a(m r10, int r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r1 = qe.a(r10.k());
        String r2 = qe.a(r10.b());
        if (TextUtils.isEmpty(r12) == false) goto L9;
        r12 = r10.e();
    L9:
        return new l(r1, r2, qe.a(r12), qe.a(r10.p()), r10.q(), (int) r10.m(), qe.a(r10.a()), r11);
    }

    private boolean b(m r8, tmsdk.common.module.qscanner.impl.a.C0089a r9) {
        if (r8 == null) goto L28;
        if (r9 != null) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r8.k(), r9.i()) == true) goto L9;
        return false;
    L9:
        if (r8.i() == r9.f()) goto L15;
        if (r8.i() == 0) goto L13;
        return false;
    L13:
        if (r9.f() > 0) goto L15;
        return false;
    L15:
        if (r8.o() == r9.l()) goto L21;
        if (r8.o() == 0) goto L19;
        return false;
    L19:
        if (r9.l() > 0) goto L21;
        return false;
    L21:
        if (TextUtils.equals(r8.p(), r9.n()) == true) goto L23;
        return false;
    L23:
        if (r8.q() == r9.m()) goto L25;
        return false;
    L25:
        if (TextUtils.equals(r8.a(), r9.k()) == false) goto L36;
        return true;
    L36:
        return false;
    L28:
        return false;
    }

    private int c() {
        yf r3 = of.c(this.b, z4.a(this.b, UpdateConfig.VIRUS_BASE_NAME, null));
        if (r3 == null) goto L5;
        int r4 = r3.a();
    L6:
        q8.c(QScannerManagerV2.LOG_TAG, "getVirusBaseIntVersion:[" + r4 + "]");
        return r4;
    L5:
        r4 = 0;
        goto L6
    }

    private boolean c(int r1) {
        if (r1 != 3) goto L5;
        return true;
    L5:
        if (r1 != 4) goto L7;
        return true;
    L7:
        if (r1 == 12) goto L14;
        return false;
    L14:
        return true;
    }

    private boolean d(int r1) {
        if ((r1 & 2) == 0) goto L5;
        return true;
    L5:
        if ((r1 & 4) != 0) goto L11;
        return false;
    L11:
        return true;
    }

    private ArrayList e() {
        long r1 = System.currentTimeMillis();
        ArrayList r3 = new ArrayList();
        List<ApplicationInfo> r4 = this.b.getPackageManager().getInstalledApplications(0);     // Catch: Exception -> L25
        if (r4 != null) goto L6;
    L27:
        q8.c(QScannerManagerV2.LOG_TAG, "loadInstalledAppList,size:[" + r3.size() + "]time(millis) elpased:[" + (System.currentTimeMillis() - r1) + "]");
        return r3;
    L6:
        if (r4.size() <= 0) goto L27;
        String r11 = this.b.getPackageName();     // Catch: Exception -> L25
        Iterator<ApplicationInfo> r5 = r4.iterator();     // Catch: Exception -> L25
    L8:
        if (r5.hasNext() == false) goto L27;
        ApplicationInfo r6 = r5.next();     // Catch: Exception -> L25
        if (r6 == null) goto L8;
        String r7 = r6.packageName;     // Catch: Exception -> L25
        if (r7 == null) goto L8;
        if (r7.equals(r11) == true) goto L8;
        m r8 = new m();     // Catch: Exception -> L25
        r8.h(r6.packageName);     // Catch: Exception -> L25
        PackageInfo r9 = ((Context) Objects.requireNonNull(TMSDKContext.getApplicaionContext())).getPackageManager().getPackageInfo(r6.packageName, 0);     // Catch: Throwable -> L20
    L21:
        if (r9 == null) goto L23;
        r8.d(r9.lastUpdateTime);     // Catch: Exception -> L25
        r8.a(r9.firstInstallTime);     // Catch: Exception -> L25
        r8.j(r9.versionName);     // Catch: Exception -> L25
        r8.c(r9.versionCode);     // Catch: Exception -> L25
        r8.a(r6.sourceDir);     // Catch: Exception -> L25
    L23:
        r3.add(r8);     // Catch: Exception -> L25
    L20:
        r9 = null;
    L25:
        e = move-exception;
        q8.c(QScannerManagerV2.LOG_TAG, "loadInstalledAppList, exception: ", e);
        goto L27
    }

    private void f() {
        q8.c(QScannerManagerV2.LOG_TAG, "[beg] resetScanStatus this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        Object r0 = this.l;
        monitor-enter(r0);
        this.j = false;     // Catch: Throwable -> L16
        this.k = false;     // Catch: Throwable -> L16
        this.e = 0;     // Catch: Throwable -> L16
        this.d = 0;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        Object r2 = this.i;
        monitor-enter(r2);
        this.h = false;     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        q8.c(QScannerManagerV2.LOG_TAG, "[end] resetScanStatus this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public void cancelScan() {
        q8.c(QScannerManagerV2.LOG_TAG, "cancelScan");
        Object r0 = this.l;
        monitor-enter(r0);
        this.j = true;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Object r1 = this.i;
        monitor-enter(r1);
        this.i.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public void continueScan() {
        q8.c(QScannerManagerV2.LOG_TAG, "continueScan");
        Object r0 = this.i;
        monitor-enter(r0);
        this.i.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int freeScanner() {
        q8.c(QScannerManagerV2.LOG_TAG, "[beg]freeScanner this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        long r0 = System.currentTimeMillis();
        byte[] r2 = this.f;
        monitor-enter(r2);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L10;
        q8.e(QScannerManagerV2.LOG_TAG, "is scanning");     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        return -201;
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L38
        Object r3 = this.l;
        monitor-enter(r3);
        this.j = true;     // Catch: Throwable -> L35
        monitor-exit(r3);     // Catch: Throwable -> L35
        Object r4 = this.n;
        monitor-enter(r4);
        AmScannerV2 r5 = this.c;     // Catch: Throwable -> L32
        if (r5 != null) goto L42;
    L29:
        monitor-exit(r4);     // Catch: Throwable -> L32
        q8.c(QScannerManagerV2.LOG_TAG, "[end]freeScanner, time(millis) elapsed:[" + (System.currentTimeMillis() - r0) + "]this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        System.gc();
        q8.c(QScannerManagerV2.LOG_TAG, "free gc");
        return 0;
    L42:
        r5.a();     // Catch: Throwable -> L23
    L25:
        this.c = null;     // Catch: Throwable -> L32
        goto L29
    L23:
        th = move-exception;
        q8.b(QScannerManagerV2.LOG_TAG, th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.c = null;     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 2;
    }

    public String getVirusBaseVersion() {
        if (this.p == (-1)) goto L5;
        int r4 = this.p;
    L6:
        Date r5 = new Date(((long) r4) * 1000);
        StringBuilder r0 = new StringBuilder().append(new SimpleDateFormat("yyyyMMdd").format(r5));
        if (r5.getHours() <= 12) goto L9;
        String r6 = "B";
    L10:
        String r7 = r0.append(r6).toString();
        q8.c(QScannerManagerV2.LOG_TAG, "getVirusBaseVersion:[" + r7 + "]");
        return r7;
    L9:
        r6 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        goto L10
    L5:
        r4 = c();
        goto L6
    }

    public int initScanner() {
        q8.c(QScannerManagerV2.LOG_TAG, "[beg]initScanner, this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS init failed, missing check Licence SafeState !");
        return -101;
    L6:
        long r1 = System.currentTimeMillis();
        tmsdk.common.module.qscanner.impl.a.f45a.a();
        Object r3 = this.n;
        monitor-enter(r3);
    L49:
        th = move-exception;
        throw th;
    L9:
        if (AmScannerV2.c() == true) goto L15;
        q8.e(QScannerManagerV2.LOG_TAG, "AmScannerV2 no supported, initScanner");     // Catch: Throwable -> L49
        monitor-exit(r3);     // Catch: Throwable -> L49
        return -103;
    L15:
        if (this.c != null) goto L46;
        AmScannerV2 r5 = new AmScannerV2(this.b, z4.a(this.b, UpdateConfig.VIRUS_BASE_NAME, null));     // Catch: Throwable -> L49
        this.c = r5;     // Catch: Throwable -> L49
        if (r5.b() == true) goto L23;
        this.c = null;     // Catch: Throwable -> L49
        q8.e(QScannerManagerV2.LOG_TAG, "initScanner failed!!");     // Catch: Throwable -> L49
        monitor-exit(r3);     // Catch: Throwable -> L49
        return -104;
    L23:
        if (this.o == this.p) goto L45;
        m r4 = n.a();     // Catch: Throwable -> L49
        if (r4 == null) goto L45;
        PackageInfo r6 = b();     // Catch: Throwable -> L49
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L49
        StringBuilder r0 = r7.append(s9.b()).append(";").append(r4.k()).append(";").append(r4.e()).append(";").append(r4.m()).append(";").append(getVirusBaseVersion()).append(";").append(ve.b()).append(";8.2.13;").append(r4.e()).append(";");     // Catch: Throwable -> L49
        if (TMSDKContext.getApplicaionContext() == null) goto L29;
        String r8 = TMSDKContext.getApplicaionContext().getPackageName();     // Catch: Throwable -> L49
    L30:
        StringBuilder r2 = r0.append(r8).append(";");     // Catch: Throwable -> L49
        if (r6 == null) goto L35;
        ApplicationInfo r9 = r6.applicationInfo;     // Catch: Throwable -> L49
        if (r9 == null) goto L35;
        String r10 = r9.loadLabel(TMSDKContext.getApplicaionContext().getPackageManager()).toString();     // Catch: Throwable -> L49
    L36:
        StringBuilder r11 = r2.append(r10).append(";");     // Catch: Throwable -> L49
        if (r6 == null) goto L39;
        String r12 = r6.versionName;     // Catch: Throwable -> L49
    L40:
        StringBuilder r13 = r11.append(r12).append(";");     // Catch: Throwable -> L49
        if (r6 == null) goto L43;
        Object r14 = Integer.valueOf(r6.versionCode);     // Catch: Throwable -> L49
    L44:
        r13.append(r14);     // Catch: Throwable -> L49
        f.a(1310038, r7.toString());     // Catch: Throwable -> L49
        goto L45
    L43:
        r14 = "-1";
        goto L44
    L39:
        r12 = "";
    L35:
        r10 = "";
        goto L36
    L29:
        r8 = "";
    L45:
        this.o = this.p;     // Catch: Throwable -> L49
        this.w = ((long) (SdkSettingUpdate.INSTANCE.getScannerCacheInterval() * 86400)) * 1000;     // Catch: Throwable -> L49
    L46:
        monitor-exit(r3);     // Catch: Throwable -> L49
        q8.c(QScannerManagerV2.LOG_TAG, "[end]initScanner, time(millis) elapsed:[" + (System.currentTimeMillis() - r1) + "this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");
        return 0;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r3) {
        q8.c(QScannerManagerV2.LOG_TAG, "onCreate, this:[" + this + "]");
        this.b = r3;
    }

    public void pauseScan() {
        q8.c(QScannerManagerV2.LOG_TAG, "pauseScan");
        Object r0 = this.i;
        monitor-enter(r0);
        this.h = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setCacheInterval(long r1) {
    }

    public void setHashType(int r1) {
    }

    public void setHashWay(int r1) {
    }

    private boolean a(m r6, tmsdk.common.module.qscanner.impl.a.C0089a r7) {
        if (r6 == null) goto L26;
        if (r7 == null) goto L33;
        String r0 = r6.k();
        if (TextUtils.isEmpty(r0) == false) goto L13;
        if (r6.j() != r7.g()) goto L13;
        if (r6.m() != r7.a()) goto L13;
    L24:
        return true;
    L13:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return false;
    L15:
        if (r6.j() == r7.g()) goto L17;
        return false;
    L17:
        if (TextUtils.equals(r6.k(), r7.i()) == true) goto L19;
        return false;
    L19:
        if (r6.m() == r7.a()) goto L21;
        return false;
    L21:
        if (TextUtils.equals(r6.p(), r7.n()) == true) goto L23;
        return false;
    L23:
        if (r6.q() == r7.m()) goto L24;
        return false;
    L33:
        return false;
    L26:
        return false;
    }

    private int b(boolean r2) {
        if (r2 == false) goto L12;
        if (this.y <= 0) goto L20;
        if (this.y > 3) goto L20;
        return this.y;
    L20:
        return SdkSettingUpdate.INSTANCE.getVirusHashAPK();
    L12:
        if (this.x <= 0) goto L18;
        if (this.x > 3) goto L18;
        return this.x;
    L18:
        return SdkSettingUpdate.INSTANCE.getVirusHashAPP();
    }

    private List d() {
        ArrayList r0 = new ArrayList();
        Context r6 = this.b;
        String r1 = UpdateConfig.CERTMD5_WHITELIST;
        z4.a(r6, r1, null);
        k2 r7 = (k2) mg.a(TMSDKContext.getApplicaionContext(), r1, UpdateConfig.intToString(40706), new k2(), "UTF-8");
        if (r7 == null) goto L16;
        ArrayList r2 = r7.f299a;
        if (r2 == null) goto L16;
        if (r2.size() <= 0) goto L16;
        Iterator r8 = r7.f299a.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        String r3 = ((j2) r8.next()).f281a;
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r0.add(r3);
        goto L11
    L15:
        return r0;
    L16:
        return null;
    }

    private boolean a(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 > 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= this.w) goto L7;
        return true;
    }

    private static PackageInfo b() {
        Context r0 = TMSDKContext.getApplicaionContext();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        return r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);
    L6:
        return null;
    L11:
        return null;
    }

    private boolean c(m r2, tmsdk.common.module.qscanner.impl.a.C0089a r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r2.r() == false) goto L10;
        return a(r2, r3);
    L10:
        return b(r2, r3);
    L11:
        return false;
    }

    private void d(m r9, tmsdk.common.module.qscanner.impl.a.C0089a r10) {
        if (r9 == null) goto L11;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r9.r() == false) goto L8;
        q8.c(QScannerManagerV2.LOG_TAG, "【check】 cache data has changed, path = " + r9.a());
        q8.c(QScannerManagerV2.LOG_TAG, "cache data | modifiedTime = " + r10.g() + ", apkSize = " + r10.a() + ", version = " + r10.n() + ", versionCode = " + r10.m());
        StringBuilder r8 = new StringBuilder("now data | modifiedTime = ").append(r9.j()).append(", apkSize = ").append(r9.m()).append(", version = ").append(r9.p()).append(", versionCode = ").append(r9.q());
    L9:
        q8.c(QScannerManagerV2.LOG_TAG, r8.toString());
        return;
    L8:
        q8.c(QScannerManagerV2.LOG_TAG, "【check】 cache data has changed, pkg = " + r9.k());
        q8.c(QScannerManagerV2.LOG_TAG, "cache data | installTime = " + r10.f() + ", updateTime = " + r10.l() + ", version = " + r10.n() + ", versionCode = " + r10.m() + ", apkPath = " + r10.k());
        r8 = new StringBuilder("now data | modifiedTime = ").append(r9.i()).append(", updateTime = ").append(r9.o()).append(", version = ").append(r9.p()).append(", versionCode = ").append(r9.q()).append(", apkPath = ").append(r9.a());
        goto L9
    }

    private e a(m r6, boolean r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r7 == true) goto L24;
    L22:
        return null;
    L24:
        if (this.w <= 0) goto L22;
        if (r6.r() == false) goto L16;
        String r1 = r6.a();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return null;
    L15:
        Map r2 = tmsdk.common.module.qscanner.impl.a.f45a.a("info1 = ?", Collections.singletonList(r1), true);     // Catch: Throwable -> L23
    L20:
        return a(r6, r7, r2);
    L16:
        String r3 = r6.k();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r3) == false) goto L19;
        return null;
    L19:
        r2 = tmsdk.common.module.qscanner.impl.a.f45a.a("info1 = ?", Collections.singletonList(r3), false);     // Catch: Throwable -> L23
        goto L20
    }

    private List c(List r4) {
        if (r4 == null) goto L4;
        ArrayList r0 = new ArrayList(r4.size());
        q8.c(QScannerManagerV2.LOG_TAG, "—— safeLevel com.google.android.apps.messaging | entityList.size() = " + r4.size());
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(a((hb) r5.next()));
        goto L7
    L9:
        return r0;
    L4:
        return new ArrayList();
    }

    public String b(int r1) {
        return this.c.a(r1);
    }

    private e a(m r6, boolean r7, Map r8) {
        if (r6 == null) goto L22;
        if (r8 == null) goto L22;
        if (r7 == false) goto L22;
        if (this.w <= 0) goto L22;
        if (r6.r() == false) goto L17;
        String r1 = r6.a();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L16;
        return null;
    L16:
        return a(r6, r7, (tmsdk.common.module.qscanner.impl.a.C0089a) r8.get(r1));
    L17:
        String r2 = r6.k();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r2) == false) goto L21;
        return null;
    L21:
        return a(r6, r7, (tmsdk.common.module.qscanner.impl.a.C0089a) r8.get(r2));
    L22:
        return null;
    }

    private void b(int r7, QScanListener r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "[callback]onScanContinue, scanType:["
            java.lang.String r1 = "[callback]onScanPaused, scanType:["
            java.lang.String r2 = "isPaused(): "
            java.lang.Object r3 = r6.i
            monitor-enter(r3)
            boolean r4 = r6.h     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            if (r4 == 0) goto L69
            if (r8 == 0) goto L2a
            java.lang.String r4 = "QScannerMgr"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.StringBuilder r1 = r5.append(r7)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.String r5 = "]"
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            tmsdkobf.q8.c(r4, r1)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            r8.onScanPaused(r7)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
        L2a:
            java.lang.Object r1 = r6.i     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            r1.wait()     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            if (r8 == 0) goto L4c
            java.lang.String r1 = "QScannerMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.StringBuilder r0 = r4.append(r7)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.String r4 = "]"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            tmsdkobf.q8.c(r1, r0)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            r8.onScanContinue(r7)     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
        L4c:
            r7 = 0
            r6.h = r7     // Catch: java.lang.Throwable -> L50 java.lang.InterruptedException -> L52
            goto L69
        L50:
            r6 = move-exception
            goto L6b
        L52:
            r6 = move-exception
            java.lang.String r7 = "QScannerMgr"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r6.getMessage()     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L50
            tmsdkobf.q8.a(r7, r8, r6)     // Catch: java.lang.Throwable -> L50
        L69:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L50
            return
        L6b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L50
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdk.common.module.qscanner.impl.b.b(int, tmsdk.common.module.qscanner.QScanListener):void");
    }

    private e a(m r10, boolean r11, tmsdk.common.module.qscanner.impl.a.C0089a r12) {
        if (r10 == null) goto L36;
        if (r11 == false) goto L36;
        if (this.w <= 0) goto L36;
        if (r12 == null) goto L10;
        String r13 = r12.c();     // Catch: Throwable -> L37
    L13:
        if (a(r10, r13) == true) goto L22;
        if (r10.r() == false) goto L18;
        StringBuilder r9 = new StringBuilder("【check】apk cache certs is empty, path = ");     // Catch: Throwable -> L37
        String r14 = r10.a();     // Catch: Throwable -> L37
    L19:
        q8.c(QScannerManagerV2.LOG_TAG, r9.append(r14).toString());     // Catch: Throwable -> L37
        return null;
    L18:
        r9 = new StringBuilder("【check】app cache certs is empty, pkg = ");     // Catch: Throwable -> L37
        r14 = r10.k();     // Catch: Throwable -> L37
        goto L19
    L22:
        if (c(r10, r12) == true) goto L26;
        d(r10, r12);     // Catch: Throwable -> L37
        return null;
    L26:
        if (a(r12.e()) == true) goto L35;
        if (r10.r() == false) goto L31;
        StringBuilder r15 = new StringBuilder("【check】 cache data has expired, path = ");     // Catch: Throwable -> L37
        String r16 = r10.a();     // Catch: Throwable -> L37
    L32:
        q8.c(QScannerManagerV2.LOG_TAG, r15.append(r16).toString());     // Catch: Throwable -> L37
        return null;
    L31:
        r15 = new StringBuilder("【check】 cache data has expired, pkg = ");     // Catch: Throwable -> L37
        r16 = r10.k();     // Catch: Throwable -> L37
        goto L32
    L35:
        return new e(r13, r12.b(), r12.d(), r12.j());
    L10:
        r13 = null;
    L36:
        return null;
    }

    private m b(m r2) {
        if (r2.r() == false) goto L7;
        return n.a(true, r2.a(), r2);
    L7:
        return TMServiceFactory.getSystemInfoService().getAppInfo(r2, 8269);
    }

    private boolean a(m r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L31;
        d2 r5 = tmsdk.common.module.qscanner.impl.a.f45a.a(r4);
        if (r5 != null) goto L10;
        return false;
    L10:
        int r2 = b(r3.r());
        if (r2 != SdkSettingUpdate.VirusCloudType.ONLY_MD_5.getValue()) goto L15;
        String r6 = r5.f142a;
    L27:
        return !TextUtils.isEmpty(r6);
    L15:
        if (r2 != SdkSettingUpdate.VirusCloudType.ONLY_SHA256.getValue()) goto L19;
        r6 = r5.b;
        goto L27
    L19:
        if (r2 == SdkSettingUpdate.VirusCloudType.BOTH_HASH.getValue()) goto L21;
        return false;
    L21:
        if (TextUtils.isEmpty(r5.f142a) == false) goto L23;
        return false;
    L23:
        if (TextUtils.isEmpty(r5.b) == false) goto L25;
        return false;
    L25:
        return true;
    L31:
        return false;
    }

    private void b(List r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.size() <= 0) goto L35;
        q8.c(QScannerManagerV2.LOG_TAG, "size:[" + r8.size() + "]");
        Iterator r7 = r8.iterator();
        int r9 = 0;
        int r2 = 0;
    L7:
        if (r7.hasNext() == false) goto L22;
        hb r3 = (hb) r7.next();
        if (r3 == null) goto L7;
        if (r3.w == false) goto L15;
        q8.c(QScannerManagerV2.LOG_TAG, "isInPayList:[" + r3.f244a + "][" + r3.b + "]");
    L15:
        if (r3.x == false) goto L17;
        q8.c(QScannerManagerV2.LOG_TAG, "isInStealAccountList:[" + r3.f244a + "][" + r3.b + "]");
    L17:
        int r4 = r3.r;
        if (r4 == 4) goto L19;
        if (r4 == 0) goto L7;
        r9 = r9 + 1;
        goto L7
    L19:
        r2 = r2 + 1;
        goto L7
    L22:
        q8.c(QScannerManagerV2.LOG_TAG, "riskCount:[" + r9 + "]unknowCount:[" + r2 + "]");
        return;
    }

    private void a(int r11, List r12, Map r13, List r14, boolean r15) {
        q8.c(QScannerManagerV2.LOG_TAG, "collectFeatureCheckInfo");
        long r1 = System.currentTimeMillis();
        int r16 = r12.size();
        Iterator r17 = r13.entrySet().iterator();
    L4:
        if (r17.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) r17.next();
        int r5 = ((Integer) r3.getKey()).intValue();
        r4 r4 = (r4) r3.getValue();
        if (r4 == null) goto L19;
        Map r6 = r4.f467a;
        if (r6 == null) goto L19;
        if (r6.size() == 0) goto L19;
        if (r5 >= r16) goto L13;
        hb r7 = (hb) r12.get(r5);
        rb r8 = new rb();
        r8.f477a = r7.e;
        r8.b = r4.f467a;
        r8.c = r4.b;
        r8.d = r4.c;
        q8.c(QScannerManagerV2.LOG_TAG, "path: " + r8.f477a + " mapParam: " + r8.b + " fileSimhashMinCnt: " + r4.b + " fileSimhashMaxCnt: " + r4.c);
        AtomicReference r9 = new AtomicReference();
        int r10 = a(r8, r9);
        q8.c(QScannerManagerV2.LOG_TAG, "nativeGetOpCode:[" + r10 + "]");
        if (r10 != 0) goto L4;
        yb r18 = (yb) r9.get();
        if (r18 == null) goto L4;
        sb r19 = new sb();
        pb r20 = fb.a(r7, r15, r5);
        r19.f508a = r20.f416a;
        r19.b = r20.b;
        r19.c = r20.c;
        r19.d = r20.d;
        r19.e = r20.e;
        r19.f = r18.b;
        r19.g = r18.c;
        r19.h = r18.d;
        r14.add(r19);
        goto L4
    L13:
        StringBuilder r21 = new StringBuilder("invalid: seq >= nativeCount: ").append(r5).append(" ").append(r16);
    L20:
        q8.e(QScannerManagerV2.LOG_TAG, r21.toString());
    L19:
        r21 = new StringBuilder("invalid: featureParam is null or empty: ").append(r4);
        goto L20
    L21:
        q8.c(QScannerManagerV2.LOG_TAG, "[end]collectFeatureCheckInfo, time(millis) elapsed:[" + (System.currentTimeMillis() - r1) + "]");
    }

    private boolean b(m r8, String r9) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L7;
        return false;
    L7:
        if (r9.contains(";") == false) goto L57;
        String[] r10 = r9.split(";");     // Catch: Throwable -> L41
        int r2 = r10.length;     // Catch: Throwable -> L41
        if (r2 != 7) goto L13;
        boolean r3 = true;
    L44:
        if (r3 == true) goto L19;
        q8.e(QScannerManagerV2.LOG_TAG, "setCacheAppInfo appInfo fields incomplete, expected = 7, actual = " + r2 + ", path = " + r8.a());     // Catch: Throwable -> L40
        return false;
    L19:
        if (TextUtils.isEmpty(r10[6]) == false) goto L22;
        q8.e(QScannerManagerV2.LOG_TAG, "setCacheAppInfo packageName field is empty, path = " + r8.a());     // Catch: Throwable -> L40
        return false;
    L22:
        int r7 = 0;
    L23:
        if (r7 >= r2) goto L39;
        String r0 = r10[r7];     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r0) == false) goto L28;
        r3 = false;
    L37:
        r7 = r7 + 1;
        goto L23
    L28:
        switch(r7) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L37;
        };
    L30:
        r8.h(r0);     // Catch: Throwable -> L40
        goto L37
    L31:
        r8.a(Boolean.valueOf(TextUtils.equals(r0, "1")));     // Catch: Throwable -> L40
        goto L37
    L32:
        r8.b(a(r0, 0));     // Catch: Throwable -> L40
        goto L37
    L33:
        r8.c(a(r0, 0));     // Catch: Throwable -> L40
        goto L37
    L34:
        r8.b(a(r0, -1));     // Catch: Throwable -> L40
        goto L37
    L35:
        r8.b(TextUtils.equals(r0, "1"));     // Catch: Throwable -> L40
        goto L37
    L36:
        r8.b(r0);     // Catch: Throwable -> L40
    L39:
        return r3;
    L13:
        r3 = false;
    L58:
        return false;
    L57:
        return false;
    }

    private void a(List r11, sc r12) {
        q8.c(QScannerManagerV2.LOG_TAG, "correctNativeResults");
        if (r11 == null) goto L47;
        if (r12 == null) goto L47;
        ArrayList r0 = r12.f509a;
        Map r2 = r12.b;
        Map r13 = r12.c;
        if (r0 != null) goto L9;
    L41:
        if (r0 != null) goto L43;
        String r10 = "null";
    L44:
        String r14 = "rspApkInfoList: ".concat(r10);
    L45:
        q8.e(QScannerManagerV2.LOG_TAG, r14);
        return;
    L43:
        r10 = "empty";
        goto L44
    L9:
        if (r0.size() == 0) goto L41;
        q8.e(QScannerManagerV2.LOG_TAG, "rspApkInfoList.size(): " + r0.size());
        b(r11);
        int r3 = r11.size();
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L39;
        xb r4 = (xb) r1.next();
        if (r4 == null) goto L13;
        int r5 = r4.f618a;
        if (r5 >= r3) goto L19;
        hb r6 = (hb) r11.get(r5);
        r6.r = r4.b;
        r6.l = r4.c;
        r6.E = r4.d;
        r6.C = fb.a(r4.e, r13);
        int r7 = r4.f;
        if ((r7 & 1) == 0) goto L23;
        r6.w = true;
    L25:
        if ((r7 & 2) == 0) goto L27;
        r6.x = true;
    L28:
        r6.H = r4.g;
        r6.A = r4.h;
        r6.D = r4.i;
        int r8 = r4.c;
        if (r8 <= 0) goto L36;
        if (r2 == null) goto L35;
        bg r9 = (bg) r2.get(Integer.valueOf(r8));
        if (r9 == null) goto L34;
        String r15 = r9.f119a;
        r6.n = r15;
        r6.m = r15;
        r6.o = r9.b;
        r6.p = r9.c;
        r6.M = r9.f;
    L38:
        r6.k = r4.l;
        r6.q = r4.m;
        r6.F = r4.n;
        r6.G = r4.o;
        r6.j = r4.p;
        goto L13
    L34:
        StringBuilder r16 = new StringBuilder("Cloud rsp —— cannot find VirusInfo for virusId: ");
    L37:
        q8.e(QScannerManagerV2.LOG_TAG, r16.append(r4.c).toString());
        goto L38
    L35:
        r16 = new StringBuilder("Cloud rsp —— mapVirusInfo is null for virusId: ");
        goto L37
    L36:
        String r17 = r4.j;
        r6.n = r17;
        r6.m = r17;
        r6.o = r4.k;
        r16 = new StringBuilder("Cloud rsp —— No Virus: ");
        goto L37
    L27:
        r6.x = false;
        goto L28
    L23:
        r6.w = false;
        goto L25
    L19:
        q8.e(QScannerManagerV2.LOG_TAG, "invalid: rspApkInfo.nRefSeqNo >= nativeCount: " + r4.f618a + " " + r3);
        goto L13
    L39:
        b(r11);
        return;
    L47:
        r14 = "nativeResults == null || resp == null";
        goto L45
    }

    private void a(List r9, kc r10) {
        q8.c(QScannerManagerV2.LOG_TAG, "correctNativeResultsByFeatureCheck");
        if (r9 == null) goto L38;
        if (r10 == null) goto L38;
        b(r9);
        ArrayList r0 = r10.f305a;
        Map r2 = r10.b;
        Map r11 = r10.c;
        if (r0 != null) goto L9;
    L32:
        if (r0 != null) goto L34;
        String r8 = "null";
    L35:
        String r12 = "rspFeatureInfoList: ".concat(r8);
    L36:
        q8.e(QScannerManagerV2.LOG_TAG, r12);
        return;
    L34:
        r8 = "empty";
        goto L35
    L9:
        if (r0.size() == 0) goto L32;
        q8.c(QScannerManagerV2.LOG_TAG, "rspFeatureInfoList size:[" + r0.size() + "]");
        int r3 = r9.size();
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L30;
        zb r4 = (zb) r1.next();
        if (r4 == null) goto L13;
        int r5 = r4.f661a;
        if (r5 >= r3) goto L19;
        hb r6 = (hb) r9.get(r5);
        r6.r = r4.b;
        r6.l = r4.c;
        r6.E = r4.d;
        r6.C = fb.a(r4.e, r11);
        r6.A = r4.f;
        int r7 = r4.c;
        if (r7 <= 0) goto L29;
        if (r2 == null) goto L27;
        bg r13 = (bg) r2.get(Integer.valueOf(r7));
        if (r13 == null) goto L26;
        String r14 = r13.f119a;
        r6.n = r14;
        r6.m = r14;
        r6.o = r13.b;
        r6.p = r13.c;
        goto L29
    L26:
        StringBuilder r15 = new StringBuilder("cannot find VirusInfo for virusId: ");
    L28:
        q8.e(QScannerManagerV2.LOG_TAG, r15.append(r4.c).toString());
        goto L29
    L27:
        r15 = new StringBuilder("mapVirusInfo is null for virusId: ");
    L29:
        r6.k = r4.g;
        r6.q = r4.h;
        r6.j = r4.i;
        goto L13
    L19:
        q8.e(QScannerManagerV2.LOG_TAG, "invalid: rspFeatureInfo.nRefSeqNo >= nativeCount: " + r4.f661a + " " + r3);
        goto L13
    L30:
        b(r9);
        return;
    L38:
        r12 = "nativeResults == null || resp == null";
        goto L36
    }

    private void a(List r23, QScanListener r24, int r25, long r26, byte[] r28, boolean r29) {
        long r2 = r26;
        if (r23 != null) goto L5;
    L43:
        q8.e(QScannerManagerV2.LOG_TAG, "doCloudScanSync, nativeResults is null or size==0");
        return;
    L5:
        if (r23.size() <= 0) goto L43;
        f.f(29953);
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSync, requestType:[" + r25 + "]timeoutMillis:[" + r2 + "]size:[" + r23.size() + "]");
        if (r2 > 0) goto L11;
        r2 = 120000;
    L11:
        long r16 = r2 / 2;
        b(2, r24);
        if (a(2, r24) == false) goto L14;
        return;
    L14:
        k1 r15 = new k1();
        qb r3 = new qb();
        r15.f298a = r3;
        r3.f440a = 10;
        r3.b = 1;
        if (((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG() == false) goto L17;
        r15.f298a.b = 2;
    L17:
        qb r4 = r15.f298a;
        if (r4.n != null) goto L20;
        r4.n = new g8();
    L20:
        r15.f298a.n.b = h8.d().e();
        r15.f298a.n.f215a = h8.d().b();
        r15.f298a.n.c = h8.d().f();
        String r5 = TimeZone.getDefault().getID();
        qb r7 = r15.f298a;
        r7.q = r5;
        r7.o = new uf(fb.b(TMSDKContext.getApplicaionContext()));
        r15.f298a.p = new tmsdkobf.a(fb.a(TMSDKContext.getApplicaionContext()));
        qb r6 = r15.f298a;
        r6.c = r25;
        r6.d = 3;
        if (this.p == (-1)) goto L23;
        qb r1 = r15.f298a;
        int r8 = this.p;
    L24:
        r1.e = r8;
        qb r9 = r15.f298a;
        r9.f = r28;
        r9.g = 2;
        r9.h = (int) (System.currentTimeMillis() / 1000);
        qb r10 = r15.f298a;
        r10.i = 0;
        r10.k = 0;
        r15.b = new ArrayList();
        int r11 = 0;
    L26:
        if (r11 >= r23.size()) goto L31;
        pb r12 = fb.a((hb) r23.get(r11), r29, r11);
        if (((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG() == false) goto L30;
        q8.c(QScannerManagerV2.LOG_TAG, "ELanguage.ELANG_ENG modify flag");
        r12.t = 1;
        r12.k = 0;
        r12.l = 0;
    L30:
        r15.b.add(r12);
        r11 = r11 + 1;
        goto L26
    L31:
        tmsdkobf.d.a();
        Object r18 = new Object();
        za r19 = ve.e();
        long r13 = System.currentTimeMillis();
        q8.c(QScannerManagerV2.LOG_TAG, "[Shark]Cmd_CSVirusCheck, sendShark, guid:[" + r19.b() + "]");
        q8.a(QScannerManagerV2.LOG_TAG, "[QScannerManagerV2] connect for CloudScan");
        int r14 = r15.b.size();
        r19.a(2016, r15, new sc(), 0, new c(this, r13, System.currentTimeMillis(), r14, r24, r23, r15, r16, r19, r29, r18), r16);
        monitor-enter(r18);
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSync(), block thread " + Thread.currentThread() + ", waiting for shark callback -->|");     // Catch: Throwable -> L35 Exception -> L37
        r18.wait();     // Catch: Throwable -> L35 Exception -> L37
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSync(), continue thread: " + Thread.currentThread() + " |-->");     // Catch: Throwable -> L35 Exception -> L37
    L39:
        monitor-exit(r18);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L37:
        e = move-exception;
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSync(), SCAN_LOCK.wait(): " + e, e);     // Catch: Throwable -> L35
        goto L39
    L23:
        r1 = r15.f298a;
        r8 = c();
        goto L24
    }

    private void a(List r18, QScanListener r19, long r20, byte[] r22, boolean r23) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (r18.isEmpty() == true) goto L29;
        int r0 = r18.size();
        int r3 = 15;
        if (r0 > 500) goto L13;
        if (r0 != 1) goto L11;
        r3 = 14;
    L11:
        a(r18, r19, r3, r20, r22, r23);
        return;
    L13:
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSyncBatched totalSize = " + r0 + ", batchSize = 500");
        int r4 = 0;
        int r7 = 0;
    L14:
        if (r4 >= r0) goto L30;
        if (a(2, r19) == true) goto L17;
        int r8 = r4 + 500;
        ArrayList r10 = new ArrayList(r18.subList(r4, Math.min(r8, r0)));
        if (r10.size() != 1) goto L22;
        int r12 = 14;
    L23:
        a(r10, r19, r12, r20, r22, r23);
        r7 = r7 + 1;
        r4 = r8;
        goto L14
    L22:
        r12 = 15;
        goto L23
    L17:
        q8.c(QScannerManagerV2.LOG_TAG, "doCloudScanSyncBatched canceled at batch " + r7);
        return;
    L30:
        return;
    }

    private void a(List r20, QScanListener r21, qb r22, long r23, za r25, Map r26, boolean r27) {
        if (r26 != null) goto L5;
        return;
    L5:
        q8.c(QScannerManagerV2.LOG_TAG, "doFeatureCheckSync, apk count: " + r26.size());
        ArrayList r10 = new ArrayList();
        a(r22.c, r20, r26, r10, r27);
        q8.c(QScannerManagerV2.LOG_TAG, "needFeatureCheckList size:[" + r10.size() + "]");
        if (r10.size() > 0) goto L8;
        return;
    L8:
        Object r4 = new Object();
        b1 r5 = new b1();
        r5.f106a = r22;
        r5.b = r10;
        long r13 = System.currentTimeMillis();
        q8.c(QScannerManagerV2.LOG_TAG, "[Shark]Cmd_CSFeatureCheck, sendShark, guid:[" + r25.b() + "]");
        q8.a(QScannerManagerV2.LOG_TAG, "[QScannerManagerV2] connect for FeatureCheck");
        r25.a(2019, r5, new kc(), 1, new d(this, r13, r21, r20, r4), r23);
        monitor-enter(r4);
        q8.c(QScannerManagerV2.LOG_TAG, "doFeatureCheckSync(), block thread " + Thread.currentThread() + ", waiting for shark callback -->|");     // Catch: Throwable -> L12
        r4.wait();     // Catch: Throwable -> L12
        q8.c(QScannerManagerV2.LOG_TAG, "doFeatureCheckSync(), continue thread: " + Thread.currentThread() + " |-->");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        q8.c(QScannerManagerV2.LOG_TAG, "doFeatureCheckSync(), SCAN_LOCK.wait(): " + th, th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private ArrayList a(int r37, List r38, int r39, boolean r40, QScanListener r41, boolean r42, long r43) {
        boolean r12 = r42;
        this.s = 0;
        this.t = 0;
        if ((r37 & 2) == 0) goto L5;
        List r17 = d();
        boolean r18 = true;
    L7:
        if ((r37 & 4) == 0) goto L9;
        boolean r19 = true;
    L10:
        if (r18 == true) goto L13;
        if (r19 == false) goto L13;
        int r5 = 4;
    L14:
        ArrayList r4 = new ArrayList();
        int r3 = r38.size();
        int r2 = (r3 / 4) + 1;
        ArrayList r1 = new ArrayList();
        if (r40 == true) goto L17;
    L19:
        Map r7 = null;
    L20:
        int r0 = 0;
        int r6 = 0;
        int r20 = 0;
    L22:
        if (r0 >= r2) goto L109;
        int r21 = r0 + 1;
        int r8 = r21 * 4;
        if (r8 < r3) goto L27;
        r8 = r3;
    L27:
        if (r6 >= r8) goto L70;
        ArrayList r22 = r4;
        m r9 = (m) r38.get(r6);
        if (r9 != null) goto L31;
        r2 = r2;
        r3 = r3;
    L69:
        r6 = r6 + 1;
        r3 = r3;
        r4 = r22;
        r2 = r2;
        goto L27
    L31:
        if (r7 == null) goto L49;
        if (r12 == false) goto L34;
        String r23 = r9.a();
    L35:
        String r25 = r23;
        if (TextUtils.isEmpty(r25) == true) goto L38;
        tmsdk.common.module.qscanner.impl.a.C0089a r14 = (tmsdk.common.module.qscanner.impl.a.C0089a) r7.get(r25);
    L39:
        e r15 = a(r9, r40, r14);
        if (r15 == null) goto L49;
        String r16 = r15.d;
        if (TextUtils.isEmpty(r16) == false) goto L44;
    L47:
        boolean r110 = false;
    L48:
        r9.a(r15);
    L51:
        if ((!r110) == false) goto L66;
        m r111 = b(r9);
        if (r111 != null) goto L55;
    L57:
        q8.c(QScannerManagerV2.LOG_TAG, "simpleInfo is null");
    L58:
        if (r12 == false) goto L68;
        if (r9.r() == false) goto L68;
        if (TextUtils.isEmpty(r9.k()) == false) goto L68;
        if (this.c == null) goto L68;
        this.c.a(a(r9, 2, ""), r9);
    L68:
        r1.add(r9);
        goto L69
    L55:
        if (r9.r() == true) goto L57;
        r9.a(r12);
        r9.b(r111.b());
        r9.b(r111.n());
        r9.a(r111.h());
        r9.a(r111.i());
        r9.d(r111.o());
        r9.c(r111.m());
        r9.b(r111.j());
        r9.b(r111.t());
        r9.c(r111.q());
        r9.j(r111.p());
        r9.h(r111.k());
        r9.a(r111.a());
        r9.a(Boolean.valueOf(r111.s()));
        goto L58
    L66:
        r2 = r2;
        r3 = r3;
        goto L68
    L44:
        if (b(r9, r16) == false) goto L47;
        if (r12 == true) goto L47;
        r110 = true;
        goto L48
    L38:
        r14 = null;
        goto L39
    L34:
        r23 = r9.k();
    L49:
        r110 = false;
        goto L51
    L70:
        int r24 = r2;
        int r112 = r3;
        ArrayList r26 = r4;
        char r113 = 2;
        if (r40 == false) goto L75;
        long r27 = 0;
        if (this.w <= 0) goto L76;
        ArrayList r10 = new ArrayList();
    L77:
        long r28 = System.currentTimeMillis();
        Iterator r29 = r1.iterator();
        int r11 = 0;
    L79:
        if (r29.hasNext() == false) goto L96;
        m r13 = (m) r29.next();
        b(r5, r41);
        if (a(r5, r41) == true) goto L82;
        if (r18 == false) goto L85;
        m r114 = r13;
        ArrayList r33 = r10;
        char r30 = 2;
        hb r31 = a(r13, r17, r42, false, null, r40, r7, r33);
        Map r32 = r7;
        ArrayList r34 = r33;
    L86:
        if (r31 == null) goto L94;
        int r35 = r11 + 1;
        r26.add(r31);
        if (r18 == false) goto L95;
        int r36 = r20 + 1;
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanProgress,scanType:[2]progress:[" + ((r36 * 100) / r112) + "][" + r31.f244a + "][" + r31.b + "]");
        String r44 = r31.f244a;
        if (TextUtils.isEmpty(r31.b) == true) goto L92;
        String r45 = r31.b;
    L93:
        r41.onScanProgress(2, r36, r112, r44, r45);
        goto L95
    L92:
        r45 = r114.b();
    L95:
        r20 = r20 + 1;
        this.d++;
        r41 = r41;
        r10 = r34;
        r6 = r6;
        r113 = r30;
        r1 = r1;
        r5 = r5;
        r26 = r26;
        Map r310 = r32;
        r11 = r35;
        r7 = r310;
        goto L79
    L94:
        r35 = r11;
        goto L95
    L85:
        r30 = r113;
        r114 = r13;
        r32 = r7;
        r34 = r10;
        r31 = a(r114, r40, r32, r34);
        goto L86
    L82:
        q8.c(QScannerManagerV2.LOG_TAG, "isCanceled");
    L96:
        ArrayList r311 = r1;
        int r312 = r5;
        int r115 = r11;
        ArrayList r116 = r26;
        int r210 = r6;
        Map r46 = r7;
        ArrayList r47 = r10;
        if (r47 == null) goto L102;
        if (r47.isEmpty() == true) goto L102;
        tmsdk.common.module.qscanner.impl.a.f45a.b(r47);
    L102:
        if (r311.isEmpty() == true) goto L104;
        f.a(1320110, r311.size() + ";" + (System.currentTimeMillis() - r28) + ";" + r115);
    L104:
        r311.clear();
        if (this.d <= 220) goto L108;
        System.gc();
        this.d = 0;
        q8.c(QScannerManagerV2.LOG_TAG, "scan gc1");
    L108:
        r7 = r46;
        r4 = r116;
        r3 = r112;
        r0 = r21;
        r6 = r210;
        r2 = r24;
        r1 = r311;
        r5 = r312;
        r12 = r42;
    L76:
        r10 = null;
        goto L77
    L75:
        r27 = 0;
        goto L76
    L109:
        ArrayList r117 = r4;
        int r313 = r5;
        if (r18 == false) goto L116;
        if (r19 == false) goto L116;
        if (a(r313, r41) == true) goto L116;
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanStarted, scanType:[4]");
        r41.onScanStarted(4);
    L116:
        if (r19 == true) goto L118;
    L120:
        return r117;
    L118:
        if (r117.size() <= 0) goto L120;
        a(r117, r41, r43, null, r42);
        goto L120
    L17:
        if (this.w <= 0) goto L19;
        r7 = tmsdk.common.module.qscanner.impl.a.f45a.a(null, null, r12);
    L13:
        r5 = 2;
        goto L14
    L9:
        r19 = false;
        goto L10
    L5:
        r17 = null;
        r18 = false;
        goto L7
    }

    private void a(ArrayList r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == true) goto L14;
        r1.size();
        tmsdk.common.module.qscanner.impl.a.f45a.b(r1);     // Catch: Throwable -> L10
    L8:
        r1.clear();
        return;
    }

    private void a(m r14, int r15, boolean r16, ArrayList r17, List r18, ArrayList r19, QScanListener r20, Map r21, ArrayList r22) {
        if (r14 != null) goto L5;
        return;
    L5:
        if (r21 == null) goto L7;
        e r0 = a(r14, r16, r21);
    L8:
        boolean r1 = false;
        if (r0 != null) goto L11;
    L16:
        e r11 = a(r14);
        boolean r12 = true;
    L17:
        r14.a(r11);
        if ((r15 & 2) == 0) goto L20;
        a(r14, r18, r17, r20, r11, r16);
    L29:
        if (r12 == false) goto L42;
        if (r16 == true) goto L32;
        return;
    L32:
        if (this.w <= 0) goto L44;
        if (r11 == null) goto L45;
        if (r22 == null) goto L40;
        tmsdk.common.module.qscanner.impl.a.C0089a r2 = tmsdk.common.module.qscanner.impl.a.f45a.a(r14, r11);
        if (r2 == null) goto L46;
        r22.add(r2);
        if (r22.size() < 50) goto L47;
        a(r22);
        return;
    L47:
        return;
    L46:
        return;
    L40:
        a(r14, r11);
        return;
    L45:
        return;
    L44:
        return;
    L42:
        return;
    L20:
        if (r1 == true) goto L28;
        b(r14);
        if (r14.r() == false) goto L28;
        if (TextUtils.isEmpty(r14.k()) == false) goto L28;
        if (this.c == null) goto L28;
        this.c.a(a(r14, 2, ""), r14);
    L28:
        r19.add(r14);
        goto L29
    L11:
        if (TextUtils.isEmpty(r0.f53a) == true) goto L16;
        String r3 = r0.d;
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r11 = r0;
        r12 = false;
        r1 = b(r14, r3);
        goto L17
    L15:
        r11 = r0;
        r12 = false;
        goto L17
    L7:
        r0 = a(r14, r16);
        goto L8
    }

    private hb a(m r9, boolean r10, Map r11, ArrayList r12) {
        hb r2 = null;
        if (r9 != null) goto L45;
        q8.e(QScannerManagerV2.LOG_TAG, "genCloudScanEntity, appEntity == null");
        return null;
    L45:
    L40:
        th = th;
    L41:
        q8.a(QScannerManagerV2.LOG_TAG, "genCloudScanEntity, exception: " + th, th);
        hb r0 = r2;
    L42:
        q8.c(QScannerManagerV2.LOG_TAG, "genCloudScanEntity[" + r0.f244a + "][" + r0.b + "][" + r0.e + "][" + r0.g + "][" + r0.h + "]");
        return r0;
    L7:
        if (r9.r() == false) goto L10;
        int r3 = 2;
    L14:
        if (TextUtils.isEmpty(r9.a()) == false) goto L17;
        q8.b(QScannerManagerV2.LOG_TAG, "genCloudScanEntity, appEntity.getApkPath() == null, unable to scan: " + r9.k() + " " + r9.a());     // Catch: Throwable -> L40
        return null;
    L17:
        r0 = new hb();     // Catch: Throwable -> L40
        r0.K = true;     // Catch: Throwable -> L38
        r0.I = r9.j();     // Catch: Throwable -> L38
        r0.f243J = r9.s();     // Catch: Throwable -> L38
        l r4 = a(r9, r3, null);     // Catch: Throwable -> L38
        r0.f244a = r4.f313a;     // Catch: Throwable -> L38
        r0.b = r4.b;     // Catch: Throwable -> L38
        r0.c = r4.d;     // Catch: Throwable -> L38
        r0.d = r4.e;     // Catch: Throwable -> L38
        r0.e = r4.g;     // Catch: Throwable -> L38
        r0.f = r4.h;     // Catch: Throwable -> L38
        r0.i = r4.f;     // Catch: Throwable -> L38
        r0.j = 1;     // Catch: Throwable -> L38
        r0.k = 0;     // Catch: Throwable -> L38
        r0.l = 0;     // Catch: Throwable -> L38
        r0.n = null;     // Catch: Throwable -> L38
        r0.q = null;     // Catch: Throwable -> L38
        r0.r = 0;     // Catch: Throwable -> L38
        r0.A = 0;     // Catch: Throwable -> L38
        r0.C = null;     // Catch: Throwable -> L38
        r0.m = null;     // Catch: Throwable -> L38
        r0.E = 0;     // Catch: Throwable -> L38
        r0.o = this.m;     // Catch: Throwable -> L38
        r0.N = r9.i();     // Catch: Throwable -> L38
        r0.O = r9.o();     // Catch: Throwable -> L38
        r0.P = r9.g();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r9.d()) == false) goto L36;
        e r13 = a(r9, r10, r11);     // Catch: Throwable -> L38
        if (r13 != null) goto L23;
    L25:
        e r14 = a(r9);     // Catch: Throwable -> L38
        if (r14 != null) goto L28;
    L30:
        if (r10 == false) goto L42;
        if (this.w <= 0) goto L42;
        if (r12 == null) goto L42;
        if (r14 == null) goto L42;
        r12.add(tmsdk.common.module.qscanner.impl.a.f45a.a(r9, r14));     // Catch: Throwable -> L38
        goto L42
    L28:
        if (TextUtils.isEmpty(r14.f53a) == true) goto L30;
        String r5 = r14.f53a;     // Catch: Throwable -> L38
        r0.R = r5;     // Catch: Throwable -> L38
        r0.S = r14.b;     // Catch: Throwable -> L38
        tmsdk.common.module.qscanner.impl.a r6 = tmsdk.common.module.qscanner.impl.a.f45a;     // Catch: Throwable -> L38
        r0.g = r6.b(r5);     // Catch: Throwable -> L38
        r0.h = r6.b(r14);     // Catch: Throwable -> L38
        goto L30
    L23:
        if (TextUtils.isEmpty(r13.f53a) == true) goto L25;
        String r8 = r13.f53a;     // Catch: Throwable -> L38
        r0.R = r8;     // Catch: Throwable -> L38
        r0.S = r13.b;     // Catch: Throwable -> L38
        r0.B = r13.c;     // Catch: Throwable -> L38
        tmsdk.common.module.qscanner.impl.a r15 = tmsdk.common.module.qscanner.impl.a.f45a;     // Catch: Throwable -> L38
        r0.g = r15.b(r8);     // Catch: Throwable -> L38
        r0.h = r15.b(r13);     // Catch: Throwable -> L38
        goto L42
    L36:
        r0.R = r9.d();     // Catch: Throwable -> L38
        r0.S = r9.c();     // Catch: Throwable -> L38
        tmsdk.common.module.qscanner.impl.a r16 = tmsdk.common.module.qscanner.impl.a.f45a;     // Catch: Throwable -> L38
        r0.g = r16.b(r9.d());     // Catch: Throwable -> L38
        r0.h = r16.b(r9.d(), r9.c());     // Catch: Throwable -> L38
        r0.B = r9.f();     // Catch: Throwable -> L38
    L38:
        th = th;
        r2 = r0;
        goto L41
    L10:
        if (r9.t() == false) goto L12;
        r3 = 1;
        goto L14
    L12:
        r3 = 0;
        goto L14
    }

    private int a(boolean r2) {
        if (r2 == false) goto L6;
        return SdkSettingUpdate.VirusGetHashWayApp.WAY_JAR.getValue();
    L6:
        if (this.z <= 0) goto L12;
        if (this.z > 2) goto L12;
        return this.z;
    L12:
        return SdkSettingUpdate.INSTANCE.getVirusGetHashWayApp();
    }

    private e a(m r5) {
        if (r5 != null) goto L24;
        return null;
    L24:
        int r1 = b(r5.r());     // Catch: Throwable -> L23
        int r4 = a(r5.r());     // Catch: Throwable -> L23
        if (r4 != SdkSettingUpdate.VirusGetHashWayApp.WAY_JAR.getValue()) goto L9;
        List<CertInfoObject> r6 = ApkSignerTool.getCerts(r5.a(), r1);     // Catch: Throwable -> L23
    L12:
        if (r6 == null) goto L14;
        int r7 = r6.size();     // Catch: Throwable -> L23
    L15:
        if (r7 > 0) goto L17;
        return null;
    L17:
        if (r7 <= 1) goto L19;
        String r8 = tmsdk.common.module.qscanner.impl.a.f45a.a(r6);     // Catch: Throwable -> L23
    L20:
        return new e(tmsdk.common.module.qscanner.impl.a.f45a.a(r6.get(0)), r8, null, null);
    L19:
        r8 = null;
        goto L20
    L14:
        r7 = -1;
        goto L15
    L9:
        if (r4 != SdkSettingUpdate.VirusGetHashWayApp.WAY_SYS.getValue()) goto L11;
        r6 = zd.a(r5, r1);     // Catch: Throwable -> L23
        goto L12
    L11:
        r6 = null;
    L27:
        return null;
    }

    private boolean a(int r6, QScanListener r7) {
        Object r1 = this.l;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.j == true) goto L7;
        monitor-exit(r1);     // Catch: Throwable -> L16
        return false;
    L7:
        if (r7 != null) goto L9;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return true;
    L9:
        if (this.k == true) goto L11;
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanCanceled, scanType:[" + r6 + "]");     // Catch: Throwable -> L16
        r7.onScanCanceled(r6);     // Catch: Throwable -> L16
        this.k = true;     // Catch: Throwable -> L16
        goto L11
    }

    private /* synthetic */ void a(int[] r15, QScanListener r16, ArrayList r17, ApkSAFScanner r18, int r19, boolean r20, ArrayList r21, List r22, ArrayList r23, Map r24, ArrayList r25, String r26, String r27, long r28) {
        if (TextUtils.isEmpty(r27) == false) goto L5;
        return;
    L5:
        b(r15[0], r16);
        if (a(r15[0], r16) == true) goto L8;
        String r0 = Environment.getExternalStorageDirectory().getAbsolutePath() + r27;
        m r2 = new m();
        r2.a(true);
        r2.a(r0);
        r2.c(r28);
        File r1 = new File(r0);     // Catch: Throwable -> L18
        r2.b(r1.lastModified());     // Catch: Throwable -> L18
        r2.c(r1.length());     // Catch: Throwable -> L18
        r2.g(r1.getName());     // Catch: Throwable -> L18
    L20:
        a(r2, r19, r20, r21, r22, r23, r16, r24, r25);
        this.r++;
        if (this.r > 0) goto L23;
        return;
    L23:
        if ((this.r % 220) != 0) goto L30;
        System.gc();
        q8.c(QScannerManagerV2.LOG_TAG, "scan gc in SAF onFound, mCount = " + this.r);
        return;
    L30:
        return;
    L18:
        th = move-exception;
        q8.b(QScannerManagerV2.LOG_TAG, th);
        goto L20
    L8:
        if (r17.size() > 0) goto L10;
    L12:
        if (r18 == null) goto L28;
        r18.cancel();
        return;
    L28:
        return;
    L10:
        if (r17.get(0) == null) goto L12;
        q8.c(QScannerManagerV2.LOG_TAG, "QSdcardScanner cancel");
        ((QSdcardScanner) r17.get(0)).cancleScan();
        goto L12
    }

    private ArrayList a(List r8) {
        PackageManager r7 = null;
        if (r8 != null) goto L5;
    L18:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L18;
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L17;
        String r1 = (String) r9.next();
        m r2 = new m();
        r2.h(r1);
        if (r7 != null) goto L13;
        r7 = ((Context) Objects.requireNonNull(TMSDKContext.getApplicaionContext())).getPackageManager();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        q8.e(QScannerManagerV2.LOG_TAG, th);
    L13:
        PackageInfo r4 = r7.getPackageInfo(r1, 0);     // Catch: Throwable -> L15
        r2.a(r4.firstInstallTime);     // Catch: Throwable -> L15
        r2.d(r4.lastUpdateTime);     // Catch: Throwable -> L15
        r2.j(r4.versionName);     // Catch: Throwable -> L15
        r2.c(r4.versionCode);     // Catch: Throwable -> L15
        r2.a(r7.getApplicationInfo(r1, 0).sourceDir);     // Catch: Throwable -> L15
        r0.add(r2);     // Catch: Throwable -> L15
        goto L9
    L17:
        return r0;
    }

    private int a(rb r5, AtomicReference r6) {
        if (AmScannerV2.c() == true) goto L19;
        return -103;
    L19:
        nf r2 = new nf();     // Catch: Throwable -> L16
        r2.c("UTF-8");     // Catch: Throwable -> L16
        r2.d();     // Catch: Throwable -> L16
        r2.a("reqfc", r5);     // Catch: Throwable -> L16
        AtomicReference r7 = new AtomicReference();     // Catch: Throwable -> L16
        int r1 = AmScannerV2.getOpcode(r2.a(), r7);     // Catch: Throwable -> L16
        if (r1 == 0) goto L11;
        q8.e(QScannerManagerV2.LOG_TAG, "AmScannerV2.getOpcode ret: " + r1);     // Catch: Throwable -> L16
        return r1;
    L11:
        byte[] r8 = (byte[]) r7.get();     // Catch: Throwable -> L16
        r2.b();     // Catch: Throwable -> L16
        r2.a(r8);     // Catch: Throwable -> L16
        yb r9 = (yb) r2.c("rspfc", new yb());     // Catch: Throwable -> L16
        if (r9 == null) goto L14;
        r6.set(r9);     // Catch: Throwable -> L16
        return 0;
    L14:
        q8.e(QScannerManagerV2.LOG_TAG, "AmScannerV2.getOpcode rspfc == null");     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        q8.a(QScannerManagerV2.LOG_TAG, "AmScannerV2.getOpcode exception: " + th, th);
        return -999;
    }

    private hb a(m r17, List r18, boolean r19, boolean r20, e r21, boolean r22, Map r23, ArrayList r24) {
        if (r17 != null) goto L7;
        q8.e(QScannerManagerV2.LOG_TAG, "nativeScan, appEntity == null");
        return null;
    L7:
        if (r19 == false) goto L15;
        if (r20 == false) goto L15;
        if (b(r17) == null) goto L12;
        r17.a(r19);
        String r1 = "nativeScan, loadAppSimpleInfo appEntity copyBy simpleInfo";
    L13:
        q8.e(QScannerManagerV2.LOG_TAG, r1);
        goto L15
    L12:
        r1 = "nativeScan, loadAppSimpleInfo == null::" + r17.k() + " " + r17.a();
    L15:
        if (r17.r() == false) goto L18;
        int r6 = 2;
    L22:
        if (TextUtils.isEmpty(r17.a()) == false) goto L25;
        q8.b(QScannerManagerV2.LOG_TAG, "nativeScan, appEntity.getApkPath() == null, unable to scan: " + r17.k() + " " + r17.a());
        return null;
    L25:
        hb r13 = new hb();
        r13.f244a = r17.k();
        r13.b = r17.b();
        r13.e = r17.a();
        r13.i = (int) r17.m();
        r13.c = r17.p();
        r13.d = r17.q();
        r13.f = r6;
        r13.K = false;
        r13.I = r17.j();
        r13.f243J = r17.s();
        r13.N = r17.i();
        r13.O = r17.o();
        r13.P = r17.g();
        if (r21 == null) goto L34;
        if (TextUtils.isEmpty(r17.e()) == false) goto L30;
    L31:
        r17.a(r21);
    L32:
        r13.Q = r17.l();
        r13.g = r17.e();
        r13.h = tmsdk.common.module.qscanner.impl.a.f45a.b(r21);
        r13.R = r21.f53a;
        r13.S = r21.b;
        goto L34
    L30:
        if (TextUtils.isEmpty(r17.l()) == false) goto L32;
    L34:
        if (r21 != null) goto L90;
    L39:
        e r2 = a(r17, r22, r23);     // Catch: Throwable -> L84
        if (r2 != null) goto L42;
    L70:
        e r15 = a(r17);     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r17.e()) == false) goto L73;
    L74:
        r17.a(r15);     // Catch: Throwable -> L84
    L75:
        r13.Q = r17.l();     // Catch: Throwable -> L84
        r13.g = r17.e();     // Catch: Throwable -> L84
        tmsdk.common.module.qscanner.impl.a r5 = tmsdk.common.module.qscanner.impl.a.f45a;     // Catch: Throwable -> L84
        r13.h = r5.b(r15);     // Catch: Throwable -> L84
        r13.R = r15.f53a;     // Catch: Throwable -> L84
        r13.S = r15.b;     // Catch: Throwable -> L84
        a(r17, r15, r18, r13, r6);     // Catch: Throwable -> L84
        r17.f(r13.B);     // Catch: Throwable -> L84
        if (r22 == true) goto L78;
    L86:
        q8.c(QScannerManagerV2.LOG_TAG, "nativeScan[" + r13.f244a + "][" + r13.b + "][" + r13.g + "][" + r13.h + "][" + r13.e + "]");
        int r0 = this.e + 1;
        this.e = r0;
        if (r0 <= 800) goto L89;
        System.gc();
        this.e = 0;
        q8.c(QScannerManagerV2.LOG_TAG, "scan gc2");
    L89:
        return r13;
    L78:
        if (this.w <= 0) goto L86;
        if (r24 == null) goto L86;
        if (TextUtils.isEmpty(r15.f53a) == true) goto L86;
        r24.add(r5.a(r17, r15));     // Catch: Throwable -> L84
        goto L86
    L73:
        if (TextUtils.isEmpty(r17.l()) == false) goto L75;
    L42:
        if (TextUtils.isEmpty(r2.f53a) == true) goto L70;
        tmsdk.common.module.qscanner.impl.a r3 = tmsdk.common.module.qscanner.impl.a.f45a;     // Catch: Throwable -> L84
        List r4 = r3.a(r2);     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r17.e()) == false) goto L46;
    L47:
        r17.a(r2);     // Catch: Throwable -> L84
    L48:
        r13.Q = r17.l();     // Catch: Throwable -> L84
        r13.g = r17.e();     // Catch: Throwable -> L84
        r13.h = r3.b(r2);     // Catch: Throwable -> L84
        r13.R = r2.f53a;     // Catch: Throwable -> L84
        r13.S = r2.b;     // Catch: Throwable -> L84
        Iterator r7 = r4.iterator();     // Catch: Throwable -> L84
    L50:
        if (r7.hasNext() == false) goto L86;
        gb r8 = this.c.b(a(r17, r6, (String) r7.next()), r17);     // Catch: Throwable -> L84
        if (r8 == null) goto L50;
        q8.c(QScannerManagerV2.LOG_TAG, "scanApk, desc_text_id = " + r8.p);     // Catch: Throwable -> L84
        fb.a(r8, r13);     // Catch: Throwable -> L84
        q8.a("handleCert", "nativeScan called");     // Catch: Throwable -> L84
        TextUtils.isEmpty(r2.b);     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r13.o) == false) goto L57;
        r13.o = this.m;     // Catch: Throwable -> L84
    L57:
        if (r13.g == null) goto L66;
        if (r18 == null) goto L66;
        Iterator r9 = r18.iterator();     // Catch: Throwable -> L84
    L61:
        if (r9.hasNext() == false) goto L66;
        if (r13.g.compareToIgnoreCase((String) r9.next()) != 0) goto L61;
        r13.L = true;     // Catch: Throwable -> L84
    L66:
        if (r13.L == true) goto L86;
        if (r8.j == 0) goto L50;
    L46:
        if (TextUtils.isEmpty(r17.l()) == false) goto L48;
    L90:
    L84:
        th = move-exception;
        q8.b(QScannerManagerV2.LOG_TAG, "nativeScan error:[" + th + "]");
        goto L86
    L36:
        if (TextUtils.isEmpty(r21.f53a) == true) goto L39;
        a(r17, r21, r18, r13, r6);     // Catch: Throwable -> L84
        goto L86
    L18:
        if (r17.t() == false) goto L20;
        r6 = 1;
        goto L22
    L20:
        r6 = 0;
        goto L22
    }

    public static int a(String r0, int r1) {
        return Integer.parseInt(r0);
    L4:
        return r1;
    }

    public static long a(String r0, long r1) {
        return Long.parseLong(r0);
    L4:
        return r1;
    }

    public static String a(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L33;
        return null;
    L33:
        File r0 = new File(r7);     // Catch: Throwable -> L20
        long r2 = r0.length();     // Catch: Throwable -> L20
        if (r2 <= 0) goto L41;
        int r8 = (int) (r2 - 500);     // Catch: Throwable -> L20
        if (r8 >= 0) goto L11;
        r8 = 0;
    L11:
        byte[] r3 = new byte[500];     // Catch: Throwable -> L20
        RandomAccessFile r4 = new RandomAccessFile(r0, "r");     // Catch: Throwable -> L20
        r4.seek(r8);     // Catch: Throwable -> L31
        int r9 = r4.read(r3);     // Catch: Throwable -> L31
        if (r9 <= 0) goto L17;
        String r1 = new String(r3, 0, r9);     // Catch: Throwable -> L31
    L39:
        r4.close();     // Catch: Throwable -> L30
    L25:
        if (TextUtils.isEmpty(r1) == true) goto L42;
        int r10 = r1.indexOf("channelId=");
        if (r10 >= 0) goto L29;
        return null;
    L29:
        return r1.substring(r10 + 10).replaceAll("\r|\n", "");
    L42:
        return null;
    L17:
        r1 = null;
    L21:
        if (r4 != null) goto L37;
    L23:
        r1 = null;
        goto L25
    L37:
        r4.close();     // Catch: Throwable -> L32
        goto L23
    L41:
        return null;
    L20:
        r4 = null;
        goto L21
    }

    private void a(m r1, e r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2.f53a) == true) goto L9;
        tmsdk.common.module.qscanner.impl.a r0 = tmsdk.common.module.qscanner.impl.a.f45a;
        r0.c(r0.a(r1, r2));
        return;
    }

    private void a(m r12, List r13, ArrayList r14, QScanListener r15, e r16, boolean r17) {
        long r0 = System.currentTimeMillis();
        hb r2 = a(r12, r13, true, true, r16, r17, null, null);
        if (r2 != null) goto L5;
        return;
    L5:
        r14.add(r2);
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanProgress,scanType:[2][" + r2.f244a + "][" + r2.b + "][" + r2.e + "]");
        String r6 = r2.f244a;
        if (TextUtils.isEmpty(r2.b) == true) goto L8;
        String r7 = r2.b;
    L9:
        r15.onScanProgress(2, -1, -1, r6, r7);
        f.a(1320110, "1;" + (System.currentTimeMillis() - r0) + ";1;" + r2.g);
        return;
    L8:
        r7 = r12.b();
        goto L9
    }

    private void a(m r6, e r7, List r8, hb r9, int r10) {
        if (r6 == null) goto L29;
        if (r9 == null) goto L40;
        if (r7 == null) goto L41;
        Iterator r0 = tmsdk.common.module.qscanner.impl.a.f45a.a(r7).iterator();
    L8:
        if (r0.hasNext() == false) goto L42;
        l r1 = a(r6, r10, (String) r0.next());
        gb r2 = this.c.b(r1, r6);
        if (r2 == null) goto L8;
        fb.a(r2, r9);
        TextUtils.isEmpty(r7.b);
        if (TextUtils.isEmpty(r9.o) == false) goto L15;
        r9.o = this.m;
    L15:
        if (r9.g == null) goto L24;
        if (r8 == null) goto L24;
        Iterator r3 = r8.iterator();
    L19:
        if (r3.hasNext() == false) goto L24;
        String r4 = (String) r3.next();
        if (r9.g.compareToIgnoreCase(r4) != 0) goto L19;
        r9.L = true;
    L24:
        if (r9.L == true) goto L43;
        if (r2.j != 0) goto L44;
        r9.B = r2.l;
        goto L8
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    public int a(int r19, List r20, QScanListener r21, int r22, boolean r23, long r24) {
        Object r11 = this.n;
        monitor-enter(r11);
        this.q = System.currentTimeMillis();     // Catch: Throwable -> L122
        this.u = 0;     // Catch: Throwable -> L122
        this.v = 0;     // Catch: Throwable -> L122
        this.r = 0;     // Catch: Throwable -> L122
        AmScannerV2 r15 = this.c;     // Catch: Throwable -> L122
        if (r15 == null) goto L7;
        r15.d();     // Catch: Throwable -> L122
    L7:
        StringBuilder r7 = new StringBuilder("[beg]scanInstalledPackagesImpl, scanType:[").append(r19).append("]packageNames size:[");     // Catch: Throwable -> L122
        if (r20 != null) goto L10;
        int r14 = -1;
    L11:
        q8.c(QScannerManagerV2.LOG_TAG, r7.append(r14).append("]scanListener:[").append(r21).append("]requestType:[").append(r22).append("]timeoutMillis:[").append(r24).append("]").toString());     // Catch: Throwable -> L122
        q8.c(QScannerManagerV2.LOG_TAG, "scanInstalledPackagesImpl this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");     // Catch: Throwable -> L122
        if (r21 != null) goto L14;
    L120:
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -102;
    L14:
        if (d(r19) == false) goto L120;
        if (c(r22) == false) goto L120;
        boolean r16 = true;
        if (r22 != 3) goto L26;
        if (r20 != null) goto L22;
    L23:
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -102;
    L22:
        if (r20.size() != 1) goto L23;
    L26:
        if (r24 <= 0) goto L32;
        if (r24 >= 2000) goto L32;
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -102;
    L32:
        if (b0.a() == false) goto L38;
        q8.e(QScannerManagerV2.LOG_TAG, "isExpired");     // Catch: Throwable -> L122
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -101;
    L38:
        if (this.c != null) goto L43;
        q8.e(QScannerManagerV2.LOG_TAG, "not invoke initScanner");     // Catch: Throwable -> L122
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -204;
    L43:
        if (r20 != null) goto L45;
    L47:
        int r3 = 17;
    L48:
        int r6 = r3;
        this.p = c();     // Catch: Throwable -> L122
        if (this.p == this.o) goto L51;
        freeScanner();     // Catch: Throwable -> L122
        initScanner();     // Catch: Throwable -> L122
    L51:
        f();     // Catch: Throwable -> L122
        byte[] r4 = this.f;     // Catch: Throwable -> L122
        monitor-enter(r4);     // Catch: Throwable -> L122
        this.g = true;     // Catch: Throwable -> L117
        monitor-exit(r4);     // Catch: Throwable -> L117
    L56:
        if ((r19 & 2) == 0) goto L58;
        q8.c(QScannerManagerV2.LOG_TAG, "QScanConfig.SCAN_LOCAL");     // Catch: Throwable -> L122
        boolean r12 = true;
    L60:
        if ((r19 & 4) == 0) goto L62;
        q8.c(QScannerManagerV2.LOG_TAG, "QScanConfig.SCAN_CLOUD");     // Catch: Throwable -> L122
    L64:
        if (r12 == true) goto L67;
        if (r16 == false) goto L67;
        int r5 = 4;
    L68:
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanStarted, scanType:[" + r5 + "]");     // Catch: Throwable -> L122
        r21.onScanStarted(r5);     // Catch: Throwable -> L122
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L122
        if (r20 != null) goto L71;
    L74:
        ArrayList r1 = e();     // Catch: Throwable -> L122
    L75:
        ArrayList r8 = r1;
        if (r8 != null) goto L78;
    L105:
        f();     // Catch: Throwable -> L122
        byte[] r2 = this.f;     // Catch: Throwable -> L122
        monitor-enter(r2);     // Catch: Throwable -> L122
        this.g = false;     // Catch: Throwable -> L114
        monitor-exit(r2);     // Catch: Throwable -> L114
        q8.e(QScannerManagerV2.LOG_TAG, "cannot featch installed packages");     // Catch: Throwable -> L122
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanFinished, scanType:[" + r5 + "]size:[0]");     // Catch: Throwable -> L122
        r21.onScanFinished(r5, new ArrayList());     // Catch: Throwable -> L122
        monitor-exit(r11);     // Catch: Throwable -> L122
        return -202;
    L114:
        th = move-exception;
        throw th;     // Catch: Throwable -> L122
    L78:
        if (r8.size() <= 0) goto L105;
        ArrayList r9 = a(r19, r8, r6, r23, r21, false, r24);     // Catch: Throwable -> L122
        f();     // Catch: Throwable -> L122
        byte[] r10 = this.f;     // Catch: Throwable -> L122
        monitor-enter(r10);     // Catch: Throwable -> L122
        this.g = false;     // Catch: Throwable -> L102
        monitor-exit(r10);     // Catch: Throwable -> L102
        if (r12 == false) goto L94;
        if (r16 == true) goto L94;
        Iterator r13 = r9.iterator();     // Catch: Throwable -> L122
    L89:
        if (r13.hasNext() == false) goto L93;
        hb r18 = (hb) r13.next();     // Catch: Throwable -> L122
        if (r18.L == false) goto L89;
        r18.l = 0;     // Catch: Throwable -> L122
        r18.m = null;     // Catch: Throwable -> L122
        r18.n = null;     // Catch: Throwable -> L122
        r18.o = null;     // Catch: Throwable -> L122
        r18.p = null;     // Catch: Throwable -> L122
        r18.q = null;     // Catch: Throwable -> L122
        r18.r = 0;     // Catch: Throwable -> L122
        goto L89
    L93:
        int r110 = 2;
    L95:
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanFinished, scanType:[" + r110 + "]size:[" + r9.size() + "]");     // Catch: Throwable -> L122
        r21.onScanFinished(r110, c(r9));     // Catch: Throwable -> L122
        if (q8.a() == false) goto L98;
        b(r9);     // Catch: Throwable -> L122
    L98:
        q8.c(QScannerManagerV2.LOG_TAG, "scanInstalledPackagesImpl this:[" + this + "]tid:[" + Thread.currentThread().getId() + "]");     // Catch: Throwable -> L122
        q8.c(QScannerManagerV2.LOG_TAG, "[end]scanInstalledPackagesImpl, time(millis) elapsed:[" + (System.currentTimeMillis() - r17) + "]");     // Catch: Throwable -> L122
        monitor-exit(r11);     // Catch: Throwable -> L122
        return 0;
    L94:
        r110 = 4;
        goto L95
    L102:
        th = move-exception;
        throw th;     // Catch: Throwable -> L122
    L71:
        if (r20.size() <= 0) goto L74;
        r1 = a(r20);     // Catch: Throwable -> L122
    L67:
        r5 = 2;
        goto L68
    L62:
        r16 = false;
        goto L64
    L58:
        r12 = false;
    L117:
        th = move-exception;
        throw th;     // Catch: Throwable -> L122
    L45:
        if (r20.size() != 1) goto L47;
        r3 = 16;
        goto L48
    L10:
        r14 = r20.size();     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        throw th;
    }

    public int a(final int r36, List r37, final QScanListener r38, final boolean r39, long r40) {
        b r0 = this;
        Object r10 = r0.n;
        monitor-enter(r10);
        r0.q = System.currentTimeMillis();     // Catch: Throwable -> L141
        r0.u = 0;     // Catch: Throwable -> L141
        r0.v = 0;     // Catch: Throwable -> L141
        r0.r = 0;     // Catch: Throwable -> L141
        AmScannerV2 r6 = r0.c;     // Catch: Throwable -> L141
        if (r6 == null) goto L7;
        r6.d();     // Catch: Throwable -> L141
    L7:
        StringBuilder r3 = new StringBuilder("[beg]scanUninstalledApksImpl, scanType:[").append(r36).append("]apkPaths size:[");     // Catch: Throwable -> L141
        if (r37 != null) goto L10;
        int r7 = -1;
    L11:
        q8.c(QScannerManagerV2.LOG_TAG, r3.append(r7).append("]scanListener:[").append(r38).append("]timeoutMillis:[").append(r40).append("]").toString());     // Catch: Throwable -> L141
        q8.c(QScannerManagerV2.LOG_TAG, "scanUninstalledApksImpl this:[" + r0 + "]tid:[" + Thread.currentThread().getId() + "]");     // Catch: Throwable -> L141
        if (r38 == null) goto L139;
        if (d(r36) == false) goto L139;
        if (r40 <= 0) goto L23;
        if (r40 >= 2000) goto L23;
        monitor-exit(r10);     // Catch: Throwable -> L141
        return -102;
    L23:
        if (b0.a() == false) goto L29;
        q8.e(QScannerManagerV2.LOG_TAG, "isExpired");     // Catch: Throwable -> L141
        monitor-exit(r10);     // Catch: Throwable -> L141
        return -101;
    L29:
        if (r0.c != null) goto L34;
        q8.e(QScannerManagerV2.LOG_TAG, "not invoke initScanner");     // Catch: Throwable -> L141
        monitor-exit(r10);     // Catch: Throwable -> L141
        return -204;
    L34:
        r0.p = c();     // Catch: Throwable -> L141
        if (r0.p == r0.o) goto L37;
        freeScanner();     // Catch: Throwable -> L141
        initScanner();     // Catch: Throwable -> L141
    L37:
        f();     // Catch: Throwable -> L141
        byte[] r2 = r0.f;     // Catch: Throwable -> L141
        monitor-enter(r2);     // Catch: Throwable -> L141
        boolean r9 = true;
        r0.g = true;     // Catch: Throwable -> L132
        monitor-exit(r2);     // Catch: Throwable -> L132
    L43:
        if ((r36 & 2) == 0) goto L45;
        q8.c(QScannerManagerV2.LOG_TAG, "QScanConfig.SCAN_LOCAL");     // Catch: Throwable -> L141
        boolean r16 = true;
    L47:
        if ((r36 & 4) == 0) goto L49;
        q8.c(QScannerManagerV2.LOG_TAG, "QScanConfig.SCAN_CLOUD");     // Catch: Throwable -> L141
        boolean r17 = true;
    L50:
        int[] r8 = {2};     // Catch: Throwable -> L141
        if (r16 == true) goto L54;
        if (r17 == false) goto L54;
        r8[0] = 4;     // Catch: Throwable -> L141
    L54:
        long r19 = System.currentTimeMillis();     // Catch: Throwable -> L141
        final ArrayList r4 = new ArrayList();     // Catch: Throwable -> L141
        if (r37 != null) goto L57;
    L72:
        final int[] r23 = r8;
        if (r16 == false) goto L75;
        List r24 = d();     // Catch: Throwable -> L141
    L76:
        ed r11 = new ed();     // Catch: Throwable -> L141
        r11.f179a.add(new dd(0, null, new String[]{"apk", CheckResult.TYPE_APK, "APk", "ApK", "aPK", "Apk", "aPk", "apK"}));     // Catch: Throwable -> L141
        r11.b = new String[]{"/storage/emulated/legacy", "/storage_int", "/HWUserData"};     // Catch: Throwable -> L141
        final ArrayList r25 = new ArrayList();     // Catch: Throwable -> L141
        final ArrayList r12 = new ArrayList();     // Catch: Throwable -> L141
        final ArrayList r5 = new ArrayList();     // Catch: Throwable -> L141
        if (r39 == true) goto L79;
    L81:
        boolean r13 = true;
        Map r26 = null;
    L83:
        Object r28 = r10;
        QSdcardScanner r14 = SdcardScannerFactory.getQSdcardScanner(2, new a(this, r23, r38, r12, r36, r39, r4, r24, r25, r26, r5), r11);     // Catch: Throwable -> L145
        if (r14 != null) goto L90;
        q8.e(QScannerManagerV2.LOG_TAG, "SdcardScannerFactory.getQSdcardScanner failed!");     // Catch: Throwable -> L145
        monitor-exit(r28);     // Catch: Throwable -> L145
        return -203;
    L90:
        r12.add(r14);     // Catch: Throwable -> L145
        HashSet r15 = new HashSet();     // Catch: Throwable -> L145
        r14.registerProgressListener(9999, new C0090b(this, r23, r38, r12, r15));     // Catch: Throwable -> L145
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanStarted, scanType:[" + r23[0] + "]");     // Catch: Throwable -> L145
        r38.onScanStarted(r23[0]);     // Catch: Throwable -> L145
        Iterator r1 = ac.e().iterator();     // Catch: Throwable -> L145
    L92:
        if (r1.hasNext() == false) goto L94;
        String r18 = (String) r1.next();     // Catch: Throwable -> L145
        q8.c(QScannerManagerV2.LOG_TAG, "startScan path:[" + r18 + "]");     // Catch: Throwable -> L145
        r14.startScan(r18);     // Catch: Throwable -> L145
        goto L92
    L94:
        r14.release();     // Catch: Throwable -> L145
        r15.clear();     // Catch: Throwable -> L145
        final ApkSAFScanner r110 = new ApkSAFScanner();     // Catch: Throwable -> L145
        final List r111 = r24;
        final Map r112 = r26;
        r110.scanApk(ApkSAFScanner.ANDROID_DATA, new b$$ExternalSyntheticLambda0(this, r23, r38, r12, r110, r36, r39, r4, r111, r25, r112, r5), 1);     // Catch: Throwable -> L145
        b r20 = this;
        r20.a(r5);     // Catch: Throwable -> L145
        if (r17 == true) goto L97;
        QScanListener r113 = r38;
        ArrayList r21 = r4;
        int r114 = 4;
        b r22 = r20;
    L109:
        f();     // Catch: Throwable -> L145
        byte[] r27 = r22.f;     // Catch: Throwable -> L145
        monitor-enter(r27);     // Catch: Throwable -> L145
        r22.g = false;     // Catch: Throwable -> L129
        monitor-exit(r27);     // Catch: Throwable -> L129
        r23[0] = r114;     // Catch: Throwable -> L145
        if (r16 == false) goto L123;
        if (r17 == true) goto L123;
        r23[0] = 2;     // Catch: Throwable -> L145
        Iterator r29 = r21.iterator();     // Catch: Throwable -> L145
    L119:
        if (r29.hasNext() == false) goto L123;
        hb r30 = (hb) r29.next();     // Catch: Throwable -> L145
        if (r30.L == false) goto L119;
        r30.l = 0;     // Catch: Throwable -> L145
        r30.m = null;     // Catch: Throwable -> L145
        r30.n = null;     // Catch: Throwable -> L145
        r30.o = null;     // Catch: Throwable -> L145
        r30.p = null;     // Catch: Throwable -> L145
        r30.q = null;     // Catch: Throwable -> L145
        r30.r = 0;     // Catch: Throwable -> L145
    L123:
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanFinished, scanType:[" + r23[0] + "]size:[" + r21.size() + "]");     // Catch: Throwable -> L145
        r113.onScanFinished(r23[0], r22.c(r21));     // Catch: Throwable -> L145
        if (q8.a() == false) goto L126;
        r22.b(r21);     // Catch: Throwable -> L145
    L126:
        q8.c(QScannerManagerV2.LOG_TAG, "scanUninstalledApksImpl this:[" + r22 + "]tid:[" + Thread.currentThread().getId() + "]");     // Catch: Throwable -> L145
        q8.c(QScannerManagerV2.LOG_TAG, "[end]scanUninstalledApksImpl, time(millis) elapsed:[" + (System.currentTimeMillis() - r19) + "]");     // Catch: Throwable -> L145
        monitor-exit(r28);     // Catch: Throwable -> L145
        return 0;
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L145
    L97:
        if (r4.size() <= 0) goto L99;
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanStarted, scanType:[4]");     // Catch: Throwable -> L145
        r113 = r38;
        r114 = 4;
        r113.onScanStarted(4);     // Catch: Throwable -> L145
        a(r4, r38, r40, null, true);     // Catch: Throwable -> L145
    L107:
        r21 = r4;
        r22 = r20;
        goto L109
    L99:
        r113 = r38;
        r114 = 4;
        if (r25.size() <= 0) goto L107;
        if (r25.size() != 1) goto L104;
        int r31 = 14;
    L105:
        ArrayList r32 = a(4, r25, r31, false, r38, true, r40);     // Catch: Throwable -> L145
        r21 = r4;
        b r33 = r20;
    L106:
        r21.addAll(r32);     // Catch: Throwable -> L145
        r22 = r33;
        goto L109
    L104:
        r31 = 15;
        goto L105
    L79:
        if (r0.w <= 0) goto L81;
        r13 = true;
        r26 = tmsdk.common.module.qscanner.impl.a.f45a.a(null, null, true);     // Catch: Throwable -> L141
        goto L83
    L75:
        r24 = null;
        goto L76
    L57:
        if (r37.size() <= 0) goto L72;
        q8.c(QScannerManagerV2.LOG_TAG, "[callback]onScanStarted, scanType:[" + r8[0] + "]");     // Catch: Throwable -> L141
        r38.onScanStarted(r8[0]);     // Catch: Throwable -> L141
        if (r37.size() != 1) goto L62;
        int r34 = 14;
    L63:
        ArrayList r35 = new ArrayList(r37.size());     // Catch: Throwable -> L141
        Iterator r41 = r37.iterator();     // Catch: Throwable -> L141
    L65:
        if (r41.hasNext() == false) goto L71;
        String r115 = (String) r41.next();     // Catch: Throwable -> L141
        m r42 = new m();     // Catch: Throwable -> L141
        r42.a(r9);     // Catch: Throwable -> L141
        r42.a(r115);     // Catch: Throwable -> L141
        File r43 = new File(r115);     // Catch: Throwable -> L147
        if (r43.exists() == false) goto L70;
        r42.g(r43.getName());     // Catch: Throwable -> L147
        r42.b(r43.lastModified());     // Catch: Throwable -> L147
        r42.c(r43.length());     // Catch: Throwable -> L147
    L70:
        r35.add(r42);     // Catch: Throwable -> L141
        r9 = true;
        goto L65
    L71:
        r23 = r8;
        r32 = a(r36, r35, r34, r39, r38, true, r40);     // Catch: Throwable -> L141
        r21 = r4;
        r28 = r10;
        r113 = r38;
        r114 = 4;
        r33 = r0;
        goto L106
    L62:
        r34 = 15;
        goto L63
    L49:
        r17 = false;
        goto L50
    L45:
        r16 = false;
    L132:
        th = th;
    L156:
        throw th;     // Catch: Throwable -> L145
    L136:
        th = th;
    L139:
        monitor-exit(r10);     // Catch: Throwable -> L145
        return -102;
    L10:
        r7 = r37.size();     // Catch: Throwable -> L141
    L141:
        th = th;
        r28 = r10;
    L143:
        monitor-exit(r28);     // Catch: Throwable -> L145
        throw th;
    L145:
        th = th;
        goto L143
    }

    private QScanResultEntity a(hb r6) {
        QScanResultEntity r5 = new QScanResultEntity();
        r5.packageName = r6.f244a;
        r5.softName = r6.b;
        r5.version = r6.c;
        r5.versionCode = r6.d;
        r5.path = r6.e;
        r5.plugins = new ArrayList();
        int r0 = r6.l;
        r5.malwareid = r0;
        r5.virusName = r6.m;
        r5.virusDiscription = r6.o;
        r5.virusUrl = r6.p;
        r5.certMd5 = r6.g;
        r5.size = r6.i;
        r5.desc_text_id = r6.M;
        r5.certMd5Ex = r6.h;
        int r1 = r6.r;
        if (r1 != 0) goto L6;
        int r2 = 257;
    L28:
        ArrayList r3 = r6.C;
        if (r3 == null) goto L34;
        Iterator r4 = r3.iterator();
    L32:
        if (r4.hasNext() == false) goto L34;
        eb r7 = (eb) r4.next();
        QScanResultPluginEntity r8 = new QScanResultPluginEntity();
        r8.type = r7.b;
        r8.banUrls = r7.d;
        r8.banIps = r7.e;
        r8.name = r7.f;
        r5.plugins.add(r8);
    L34:
        r5.scanResult = r2;
        r5.officialPackName = r6.F;
        r5.officialCertMd5 = r6.G;
        return r5;
    L6:
        if (r1 != 4) goto L9;
        r2 = 263;
        goto L28
    L9:
        if ((r6.E & 512) != 0) goto L27;
        if (r1 == 0) goto L15;
        if (r6.w == true) goto L27;
    L15:
        if (r1 != 1) goto L18;
        if (r0 == 0) goto L18;
        r2 = 260;
    L18:
        if (r1 != 0) goto L20;
        r2 = 0;
        goto L28
    L20:
        if (r6.x == false) goto L23;
        r2 = 261;
        goto L28
    L23:
        if (r6.D != 2) goto L25;
        r2 = 258;
        goto L28
    L25:
        r2 = 262;
    L27:
        r2 = 259;
        goto L28
    }
}
