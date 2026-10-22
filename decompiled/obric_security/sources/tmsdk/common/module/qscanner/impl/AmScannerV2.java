package tmsdk.common.module.qscanner.impl;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;
import tmsdkobf.b3;
import tmsdkobf.cg;
import tmsdkobf.f;
import tmsdkobf.gb;
import tmsdkobf.h8;
import tmsdkobf.l;
import tmsdkobf.l8;
import tmsdkobf.m;
import tmsdkobf.nf;
import tmsdkobf.q8;
import tmsdkobf.ve;
import tmsdkobf.x8;
import tmsdkobf.yf;
import tmsdkobf.z4;

/* JADX INFO: loaded from: classes5.dex */
public class AmScannerV2 {
    private static volatile long c = 0;
    private static boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f44a;
    private long b;

    static {
        boolean r1 = l8.a(TMSDKContext.getApplicaionContext(), ve.j());     // Catch: Throwable -> L7
        d = r1;     // Catch: Throwable -> L7
        if (r1 == true) goto L12;
        q8.e("QScannerMgr-AmScannerV2", "load ams so failed");     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        q8.a("QScannerMgr-AmScannerV2", "load ams so exception: " + th, th);
    }

    protected AmScannerV2(Context r7, String r8) {
        this.f44a = 0;
        this.b = 0;
        this.f44a = newObject(r7, r8);
        q8.a("QScannerMgr-AmScannerV2", "[native]newObject:[" + this.f44a + "]");
        if (this.f44a == 0) goto L13;
        if (b3.c() == false) goto L11;
        this.b = newLanObject(r7, h8.a());
        q8.a("QScannerMgr-AmScannerV2", "[native]lanObject:[" + this.b + "]");
        if (this.b == 0) goto L10;
        return;
    L10:
        throw new OutOfMemoryError();
    L11:
        return;
    L13:
        throw new OutOfMemoryError();
    }

    public static boolean c() {
        return d;
    }

    private static native void deleteLanObject(long r0);

    private static native void deleteObject(long r0);

    private static native String getDesc(long r0, int r2, String r3, String r4, String r5);

    public static native int getOpcode(byte[] r0, AtomicReference<byte[]> r1);

    private static native int initScanner(long r0);

    private static native int nativeLoadAmfHeaderBytes(Context r0, String r1, AtomicReference<byte[]> r2);

    private static native int nativeUpdateMalwareInfoBytes(Context r0, String r1, byte[] r2, byte[] r3);

    private static native long newLanObject(Context r0, String r1);

    private static native long newObject(Context r0, String r1);

    private static native int parseApkInfo(long r0, byte[] r2, AtomicReference<byte[]> r3);

    private static native int scanApkBytes(long r0, byte[] r2, AtomicReference<byte[]> r3);

    protected synchronized void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f44a == 0) goto L8;
        q8.a("QScannerMgr-AmScannerV2", "[native]deleteObject, object:[" + this.f44a + "]");     // Catch: Throwable -> L14
        deleteObject(this.f44a);     // Catch: Throwable -> L14
        this.f44a = 0;     // Catch: Throwable -> L14
    L8:
        if (b3.c() == true) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (this.b == 0) goto L12;
        q8.a("QScannerMgr-AmScannerV2", "[native]deleteObject, lanObject:[" + this.b + "]");     // Catch: Throwable -> L14
        deleteLanObject(this.b);     // Catch: Throwable -> L14
        this.b = 0;     // Catch: Throwable -> L14
        goto L12
    }

    protected synchronized boolean b() {
        monitor-enter(this);
        int r2 = initScanner(this.f44a);     // Catch: Throwable -> L13
        c = 0;     // Catch: Throwable -> L13
        q8.a("QScannerMgr-AmScannerV2", "[native]initScanner:[" + r2 + "]");     // Catch: Throwable -> L13
        if (r2 == 0) goto L10;
        String r1 = z4.a(TMSDKContext.getApplicaionContext(), UpdateConfig.VIRUS_BASE_NAME, null);     // Catch: Throwable -> L13
        q8.e("QScannerMgr-AmScannerV2", "amf file error, delete:[" + r1 + "]");     // Catch: Throwable -> L13
        z4.a(r1);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L10:
        monitor-exit(this);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    protected void d() {
    }

    public synchronized String a(int r9) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (b3.c() == true) goto L10;
        monitor-exit(this);
        return "";
    L10:
        if (this.b != 0) goto L16;
        this.b = newLanObject(TMSDKContext.getApplicaionContext(), h8.a());     // Catch: Throwable -> L24
        q8.a("QScannerMgr-AmScannerV2", "new [native]lanObject:[" + this.b + "]");     // Catch: Throwable -> L24
        if (this.b != 0) goto L16;
        throw new OutOfMemoryError();     // Catch: Throwable -> L24
    L16:
        String r1 = "";
        r1 = getDesc(this.b, r9, h8.d().e(), h8.d().f(), h8.d().b());     // Catch: Throwable -> L19
    L21:
        q8.c("QScannerMgr-AmScannerV2", "getAmScannerDescByLanID desc_text_id = " + r9 + ", newDesc = " + r1);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r1;
    L19:
        th = move-exception;
        q8.b("QScannerMgr-AmScannerV2", th);     // Catch: Throwable -> L24
        goto L21
    }

    public synchronized gb b(l r17, m r18) {
        monitor-enter(this);
        gb r10 = null;
        if (r17 != null) goto L9;
        q8.e("QScannerMgr-AmScannerV2", "scanApk, apkKey == null!");     // Catch: Throwable -> L39
        monitor-exit(this);
        return null;
    L9:
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L39
        q8.a("QScannerMgr-AmScannerV2", "scanApk, [" + r17.f313a + "][" + r17.b + "][" + r17.c + "][" + r17.g + "]");     // Catch: Throwable -> L39
        nf r9 = new nf();     // Catch: Throwable -> L39
        r9.c("UTF-8");     // Catch: Throwable -> L39
        r9.d();     // Catch: Throwable -> L39
        r9.a("ak", r17);     // Catch: Throwable -> L39
        if (b3.c() == false) goto L18;
        if (r18 != null) goto L13;
    L17:
        String r6 = h8.d().e();     // Catch: Throwable -> L39
        String r13 = h8.d().b();     // Catch: Throwable -> L39
        String r14 = h8.d().f();     // Catch: Throwable -> L39
        q8.a("QScannerMgr-AmScannerV2", "scanApkBytes language = " + r6 + ", country = " + r13 + ", script = " + r14);     // Catch: Throwable -> L39
        r9.a("language", r6);     // Catch: Throwable -> L39
        r9.a("country", r13);     // Catch: Throwable -> L39
        r9.a("script", r14);     // Catch: Throwable -> L39
        goto L18
    L13:
        if (TextUtils.isEmpty(r18.b()) == true) goto L15;
        String r15 = x8.c(r18.b());     // Catch: Throwable -> L39
    L16:
        String r16 = x8.a(r18.h());     // Catch: Throwable -> L39
        q8.a("QScannerMgr-AmScannerV2", "scanApkBytes appName = " + r18.b() + ", appNameEncypt = " + r15 + ", iconEncypt = " + r16);     // Catch: Throwable -> L39
        r9.a("appName", r15);     // Catch: Throwable -> L39
        r9.a("appIcon", r16);     // Catch: Throwable -> L39
        goto L17
    L15:
        r15 = "";
    L18:
        AtomicReference r7 = new AtomicReference();     // Catch: Throwable -> L39
        q8.a("QScannerMgr-AmScannerV2", "[native]scanApkBytes, object:[" + this.f44a + "]");     // Catch: Throwable -> L39
        int r8 = scanApkBytes(this.f44a, r9.a(), r7);     // Catch: Throwable -> L39
        q8.e("QScannerMgr-AmScannerV2", "[native]scanApkBytes, err = " + r8);     // Catch: Throwable -> L39
        long r19 = System.currentTimeMillis() - r11;     // Catch: Throwable -> L39
        if (r8 == 0) goto L23;
        q8.e("QScannerMgr-AmScannerV2", "scanApk, native scanApkBytes() err: " + r8);     // Catch: Throwable -> L39
        f.a(1320111, "1;" + r19 + ";" + r8 + ";" + r17.c + ";" + r9.a("appName"));     // Catch: Throwable -> L39
        monitor-exit(this);
        return null;
    L23:
        byte[] r0 = (byte[]) r7.get();     // Catch: Throwable -> L39
        if (r0 != null) goto L28;
        q8.e("QScannerMgr-AmScannerV2", "scanApk, scanApkBytes() return null");     // Catch: Throwable -> L39
        monitor-exit(this);
        return null;
    L28:
        r9.b();     // Catch: Throwable -> L39
        r9.a(r0);     // Catch: Throwable -> L39
        gb r3 = (gb) r9.c("qsr", new gb());     // Catch: Throwable -> L34
        q8.c("QScannerMgr-AmScannerV2", "scanDesc = " + r3.d);     // Catch: Throwable -> L32
        b3.c();     // Catch: Throwable -> L32
    L37:
        monitor-exit(this);
        return r3;
    L32:
        th = th;
        r10 = r3;
    L35:
        q8.b("QScannerMgr-AmScannerV2", th);     // Catch: Throwable -> L39
        r3 = r10;
    L34:
        th = th;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized yf a(Context r7, String r8) {
        monitor-enter(AmScannerV2.class);
        if (r8 != null) goto L24;
    L19:
        monitor-exit(AmScannerV2.class);
        return null;
    L24:
        nf r3 = new nf();     // Catch: Throwable -> L16
        r3.c("UTF-8");     // Catch: Throwable -> L16
        r3.d();     // Catch: Throwable -> L16
        AtomicReference r4 = new AtomicReference();     // Catch: Throwable -> L16
        q8.a("QScannerMgr-AmScannerV2", "[native]nativeLoadAmfHeaderBytes, amfFile:[" + r8 + "]");     // Catch: Throwable -> L13
        if (nativeLoadAmfHeaderBytes(r7, r8, r4) != 0) goto L19;
        byte[] r9 = (byte[]) r4.get();     // Catch: Throwable -> L13
        if (r9 == null) goto L19;
        r3.a(r9);     // Catch: Throwable -> L13
        yf r10 = (yf) r3.c("vci", new yf());     // Catch: Throwable -> L13
        monitor-exit(AmScannerV2.class);
        return r10;
    L13:
        th = move-exception;
        q8.b("QScannerMgr-AmScannerV2", "loadAmfHeader, e:[" + th + "]");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void a(l r8, m r9) {
        monitor-enter(this);
        if (r8 == null) goto L22;
        if (r9 == null) goto L22;
        nf r2 = new nf();     // Catch: Throwable -> L18
        r2.c("UTF-8");     // Catch: Throwable -> L18
        r2.d();     // Catch: Throwable -> L18
        r2.a("ak", r8);     // Catch: Throwable -> L18
        AtomicReference r10 = new AtomicReference();     // Catch: Throwable -> L18
        q8.a("QScannerMgr-AmScannerV2", "[native]scanApkBytes, object:[" + this.f44a + "]");     // Catch: Throwable -> L18
        int r1 = parseApkInfo(this.f44a, r2.a(), r10);     // Catch: Throwable -> L18
        q8.e("QScannerMgr-AmScannerV2", "[native]scanApkBytes, err = " + r1);     // Catch: Throwable -> L18
        if (r1 == 0) goto L11;
        monitor-exit(this);
        return;
    L11:
        byte[] r11 = (byte[]) r10.get();     // Catch: Throwable -> L18
        if (r11 != null) goto L16;
        q8.e("QScannerMgr-AmScannerV2", "scanApk, scanApkBytes() return null");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L16:
        r2.b();     // Catch: Throwable -> L18
        r2.a(r11);     // Catch: Throwable -> L18
        gb r12 = (gb) r2.c("qsr", new gb());     // Catch: Throwable -> L18
        r9.h(r12.f216a.f313a);     // Catch: Throwable -> L18
        r9.j(r12.f216a.d);     // Catch: Throwable -> L18
        r9.c(r12.f216a.e);     // Catch: Throwable -> L18
    L20:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        q8.b("QScannerMgr-AmScannerV2", th);     // Catch: Throwable -> L25
    L22:
        q8.e("QScannerMgr-AmScannerV2", "scanApk, apkKey == null!");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public static synchronized int a(Context r4, String r5, cg r6, List r7) {
        monitor-enter(AmScannerV2.class);
        if (r6 == null) goto L10;
        if (r7 == null) goto L10;
        nf r2 = new nf();     // Catch: Throwable -> L14
        r2.c("UTF-8");     // Catch: Throwable -> L14
        r2.d();     // Catch: Throwable -> L14
        r2.a("vsi", r6);     // Catch: Throwable -> L14
        byte[] r8 = r2.a();     // Catch: Throwable -> L14
        r2.b();     // Catch: Throwable -> L14
        r2.a("vil", r7);     // Catch: Throwable -> L14
        byte[] r9 = r2.a();     // Catch: Throwable -> L14
        q8.a("QScannerMgr-AmScannerV2", "[native]nativeUpdateMalwareInfoBytes, amfFile:[" + r5 + "]");     // Catch: Throwable -> L14
        int r10 = nativeUpdateMalwareInfoBytes(r4, r5, r8, r9);     // Catch: Throwable -> L14
        monitor-exit(AmScannerV2.class);
        return r10;
    L10:
        q8.e("QScannerMgr-AmScannerV2", "updateBase, virusServerInfo == null || virusInfoList == null");     // Catch: Throwable -> L14
        monitor-exit(AmScannerV2.class);
        return -6;
    L14:
        th = move-exception;
        throw th;
    }
}
