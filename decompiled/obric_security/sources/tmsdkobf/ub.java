package tmsdkobf;

import android.content.Context;
import android.os.HandlerThread;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.ErrorCode;
import tmsdk.common.TMSDKContext;
import tmsdk.common.roach.nest.ISharkCallBackNest;
import tmsdk.common.tcc.TccCryptor;
import tmsdk.common.tcc.TccDiff;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h9 f552a = null;

    class a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISharkCallBackNest f553a;

        a(ISharkCallBackNest r1) {
            this.f553a = r1;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r7, int r8, int r9, int r10, JceStruct r11) {
            this.f553a.onFinish(r7, r8, r9, r10, r11);
        }
    }

    static {
        f552a = new h9("r_entities_sp");
    }

    public static int a(int r0, String r1, String r2, HashMap r3, String r4, Class r5, AtomicReference r6) {
        return ErrorCode.ERR_WUP;
    }

    public static void a(Runnable r1, String r2) {
        ve.f().a(r1, r2);     // Catch: Throwable -> L4
        return;
    }

    public static byte[] b(byte[] r0, byte[] r1) {
        return TccCryptor.encrypt(r0, r1);
    L4:
        return null;
    }

    public static void c(String r1) {
        f552a.b(r1);
    }

    public static int a(String r0, String r1, String r2, int r3) {
        return TccDiff.bsPatch(r0, r1, r2, r3);
    }

    public static String b() {
        za r0 = ve.e();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        return r0.b();
    L6:
        return "";
    L11:
        return "";
    }

    public static void c() {
        d.b(true);     // Catch: Throwable -> L5
        return;
    }

    public static byte[] a(byte[] r0, byte[] r1) {
        return TccCryptor.decrypt(r0, r1);
    L4:
        return null;
    }

    public static HandlerThread b(String r1) {
        return ve.f().b(r1);
    L4:
        return null;
    }

    public static int a(String r2, String r3, String r4) {
    L13:
        return ErrorCode.ERR_GET;
    L3:
        if (qe.b(r2) == false) goto L5;
        return -57;
    L5:
        if (qe.b(r3) == false) goto L7;
        return -57;
    L7:
        if (qe.b(r4) == true) goto L19;
        b6 r0 = new b6(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L13
        r0.b(r3);     // Catch: Throwable -> L13
        r0.a(r4);     // Catch: Throwable -> L13
        return r0.a(null, r2, false, null);
    L19:
        return -57;
    }

    public static Thread b(Runnable r1, String r2) {
        return ve.f().c(r1, r2);
    L4:
        return null;
    }

    public static String a(String r0) {
        return TccDiff.fileMd5(r0);
    }

    public static void b(String r2, int r3) {
        f552a.a(r2, r3, true);
    }

    public static Context a() {
        return TMSDKContext.getApplicaionContext();
    }

    public static void b(String r2, long r3) {
        f552a.a(r2, r3, true);
    }

    public static String a(byte[] r0) {
        return TccDiff.getByteMd5(r0);
    }

    public static void b(String r2, String r3) {
        f552a.a(r2, r3, true);
    }

    public static int a(String r1, int r2) {
        return f552a.a(r1, r2);
    }

    public static long a(String r1, long r2) {
        return f552a.a(r1, r2);
    }

    public static String a(String r1, String r2) {
        return f552a.a(r1, r2);
    }

    public static void a(int r0) {
        f.e(r0);     // Catch: Throwable -> L4
        return;
    }

    public static void a(int r0, int r1) {
        f.d(r0, r1);     // Catch: Throwable -> L4
        return;
    }

    public static void a(int r0, String r1) {
        f.a(r0, r1);     // Catch: Throwable -> L4
        return;
    }

    public static boolean a(int r9, JceStruct r10, JceStruct r11, int r12, ISharkCallBackNest r13, long r14) {
        if (r10 == null) goto L11;
        if (r13 == null) goto L11;
        if (ve.e().a(r9, r10, r11, r12, new a(r13), r14) != null) goto L9;
        return false;
    L9:
        return true;
    L11:
        return false;
    }
}
