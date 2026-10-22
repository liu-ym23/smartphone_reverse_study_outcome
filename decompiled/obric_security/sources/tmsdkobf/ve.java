package tmsdkobf;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import tmsdk.common.ExtraInfoFetcher;
import tmsdk.common.IDualPhoneInfoFetcher;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.SdkSettingUpdate;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f581a = false;
    private static List b;
    private static we c;
    private static volatile boolean d;
    private static boolean e;
    public static IDualPhoneInfoFetcher f;
    public static ExtraInfoFetcher g;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lf.a(ve.a());
            if (ve.a() == false) goto L10;
            if (mb.d() == true) goto L10;
            if (mb.c() == true) goto L10;
            new h9("tms").a("reportlc", false, true);
            d.a();
        L10:
            if (ve.m2471$$Nest$smi() == false) goto L16;
            SdkSettingUpdate.INSTANCE.updateSdkSetting();
        L16:
            Thread.sleep(30000);     // Catch: InterruptedException -> L15
            return;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(p5.b()) == false) goto L12;
            p5.a r1 = p5.a();
            if (r1 == null) goto L7;
            String r2 = r1.f408a;
        L9:
            if (TextUtils.isEmpty(r2) == true) goto L13;
            p5.a(r2);
            za.d().d();
            return;
        L13:
            return;
        L7:
            r2 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smi, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2471$$Nest$smi() {
        return i();
    }

    static {
        f581a = true;
        b = new LinkedList();
        d = false;
        e = true;
        f = null;
        g = null;
    }

    public static boolean a() {
        if (e == false) goto L5;
    L8:
        return true;
    L5:
        if (m9.e().a().booleanValue() == true) goto L8;
        return false;
    }

    private static boolean a(long r0, long r2) {
        long r3 = r2 - r0;
        if (r3 < 39600000) goto L5;
    L8:
        return true;
    L5:
        if (r3 < 0) goto L8;
        return false;
    }

    public static String b() {
        return ye.d().c();
    }

    private static long c() {
        int r1 = 1;
        if (1 == l()) goto L10;
        r1 = 2;
        if (2 == l()) goto L10;
        r1 = 3;
    L10:
        return m1.a(r1, 4294967296L);
    }

    public static int d() {
        String r0 = ye.d().c();
        if (r0 != null) goto L5;
    L8:
        q8.d("TMSDKContextI", "chanel:" + r0);
        return 13;
    L5:
        if (r0.equals("892333") == false) goto L8;
        return 84;
    }

    public static za e() {
        return za.c();
    }

    public static we f() {
        if (c != null) goto L15;
        monitor-enter(ve.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new we(c(), "com.tmsdk.common");     // Catch: Throwable -> L11
    L9:
        monitor-exit(ve.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public static void g() {
        s9.a();
        d.d();
        f().a(new a(), "icheck");
        if (b3.c() == true) goto L5;
        return;
    L5:
        if (lb.a() == false) goto L9;
        f().a(new b(), "gad");
        return;
    }

    public static boolean h() {
        k();
        return d;
    }

    private static boolean i() {
        long r0 = m9.e().j();
        long r2 = System.currentTimeMillis();
        if (r0 != 0) goto L5;
    L9:
        m9.e().c(r2);
        return true;
    L5:
        if (a(r0, r2) == true) goto L9;
        return false;
    }

    public static String j() {
        if (b3.c() == false) goto L5;
        return "ams-1.3.5-mfr";
    L5:
        return "ams-1.3.10-mfr";
    }

    public static void k() {
        if (d == false) goto L5;
        return;
    L5:
        d = l8.a(TMSDKContext.getApplicaionContext(), TMSDKContext.LIB_TMS_COMMON_EXT);
        if (d == true) goto L14;
    L12:
        q8.d("demo", "mIsSdkLibraryLoaded =" + d + "libraryName:Tmsdk-2.0.16-mfr");
        return;
    L14:
        TMSDKContext.registerNatives(0, TccCryptor.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        d = false;
        goto L12
    }

    public static int l() {
        return 0;
    }

    public static void a(boolean r0) {
        e = r0;
    }

    public static void a(IDualPhoneInfoFetcher r4) {
        q8.d("TMSDKContextI", "setDualPhoneInfoFetcher:[" + r4 + "]");
        q8.d("TrafficCorrection", "setDualPhoneInfoFetcher:[" + r4 + "]");
        f = r4;
    }

    public static void a(ExtraInfoFetcher r4) {
        q8.c("TMSDKContextI", "setExtraInfoFetcher");
        if (r4 == null) goto L8;
        q8.c("TMSDKContextI", "imeiHash:" + r4.getImeiHash());
        if (TextUtils.isEmpty(r4.getImeiHash()) == true) goto L9;
        g = r4;
        return;
    L9:
        return;
    }
}
