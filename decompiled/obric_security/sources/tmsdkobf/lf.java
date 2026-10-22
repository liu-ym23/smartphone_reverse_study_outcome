package tmsdkobf;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f330a = "";
    public static volatile String b = "";
    public static volatile String c = "";
    public static volatile String d = "";

    class a implements n7 {
        a() {
        }

        @Override // tmsdkobf.o1
        public /* bridge */ /* synthetic */ r0.a a(byte[] r1, int r2, int r3) {
            return b(r1, r2, r3);
        }

        public n7.a b(byte[] r3, int r4, int r5) {
            return new n7.a(0, lf.m2391$$Nest$sma(r4, r5, r3, WorkRequest.MIN_BACKOFF_MILLIS));
        L5:
            return null;
        }
    }

    class b implements i7 {
        b() {
        }

        @Override // tmsdkobf.i7
        public String a() {
            return la.a(TMSDKContext.getApplicaionContext());
        }

        @Override // tmsdkobf.i7
        public String b() {
            return "";
        }

        @Override // tmsdkobf.i7
        public String c() {
            return "";
        }
    }

    class c implements m7 {
        c() {
        }

        @Override // tmsdkobf.l1
        public boolean a() {
            return true;
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h7 r1 = kf.a(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
            if (r1.c() != 0) goto L6;
            lf.b = r1.d();     // Catch: Throwable -> L11
            lf.d = r1.a();     // Catch: Throwable -> L11
            lf.c = r1.b();     // Catch: Throwable -> L11
        L8:
            if (TextUtils.isEmpty(lf.b) == true) goto L16;
            za.d().d();     // Catch: Throwable -> L11
            return;
        L16:
            return;
        L6:
            r8.c("TuringManager", "getAllIdTicket error : " + r1.c());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            r8.c("TuringManager", "getAllIdTicket ｜ error");
            r8.c("TuringManager", th);
        }
    }

    class e extends v6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f331a;
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ Object c;

        e(int r1, AtomicReference r2, Object r3) {
            this.f331a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // tmsdkobf.v6
        public void a(int r1, int r2, int r3, int r4, byte[] r5) {
            if (r2 != this.f331a) goto L7;
            if (r3 != 0) goto L7;
            if (r4 != 0) goto L7;
            this.b.set(r5);
        L7:
            Object r6 = this.c;
            monitor-enter(r6);
            this.c.notifyAll();     // Catch: Throwable -> L12
            monitor-exit(r6);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sma, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m2391$$Nest$sma(int r0, int r1, byte[] r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    static {
    }

    public static void a() {
        if (TextUtils.isEmpty(f330a) == false) goto L5;
        f330a = za.c().b();
    L5:
        r8.a("TuringManager", "getAllIdTicket : mGuid = " + f330a);
        if (m9.e().i().booleanValue() == false) goto L9;
        ve.f().a(10, new d(), "TuringId");
        return;
    }

    public static void a(boolean r4) {
        r8.c("TuringManager", "TuringSDK init");
        if (m9.e().i().booleanValue() == true) goto L20;
    L17:
        r8.a("TuringManager", "init end");
        return;
    L20:
        r8.c("TuringManager", "TuringSDK Version : " + mf.d());     // Catch: Throwable -> L19
        HashSet r0 = new HashSet();     // Catch: Throwable -> L19
        if (lb.b() == true) goto L7;
    L8:
        r0.add(41);     // Catch: Throwable -> L19
    L10:
        if (lb.a() == true) goto L12;
    L13:
        r0.add(143);     // Catch: Throwable -> L19
    L14:
        int r1 = mf.a(TMSDKContext.getApplicaionContext(), new c()).a(r0).a(new b()).a(false).a(new a()).a().e();     // Catch: Throwable -> L19
        r8.a("TuringManager", "TuringSDK init ret = " + r1);     // Catch: Throwable -> L19
        if (r1 != 0) goto L17;
        a();     // Catch: Throwable -> L19
        goto L17
    L12:
        if (b3.c() == true) goto L14;
    L7:
        if (b3.c() == false) goto L10;
        goto L8
    }

    public static void a(int r1, boolean r2) {
        if (11 != r1) goto L6;
        m9.e().c(Boolean.valueOf(r2));
        return;
    }

    private static byte[] a(int r9, int r10, byte[] r11, long r12) {
        AtomicReference r0 = new AtomicReference(new byte[0]);
        Object r1 = new Object();
        ve.e().a(r9, r11, 0, new e(r10, r0, r1), r12);
        monitor-enter(r1);     // Catch: InterruptedException -> L12
        r1.wait(r12);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L12
    L11:
        return (byte[]) r0.get();
    }
}
