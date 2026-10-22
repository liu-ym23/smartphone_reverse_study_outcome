package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f470a = "";
    private static long b = -1;
    private static long c = -1;
    private static int d = -1;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f471a;
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ AtomicReference c;
        final /* synthetic */ Object d;

        a(long r1, AtomicReference r3, AtomicReference r4, Object r5) {
            this.f471a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r5, IBinder r6) {
            r9.m2436$$Nest$sfputb(System.currentTimeMillis() - this.f471a);
            this.b.set(r6);
            this.c.set(this);
            Object r7 = this.d;
            monitor-enter(r7);
            this.d.notifyAll();     // Catch: Throwable -> L10
        L13:
            monitor-exit(r7);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f472a;
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ Context c;
        final /* synthetic */ AtomicReference d;
        final /* synthetic */ Object e;

        b(AtomicReference r1, AtomicReference r2, Context r3, AtomicReference r4, Object r5) {
            this.f472a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            q9 r0 = q9.a.a((IBinder) this.f472a.get());     // Catch: Throwable -> L4
        L5:
            if (r0 == null) goto L25;
            String r1 = this.c.getPackageName();     // Catch: Throwable -> L8
            r9.m2435$$Nest$sfputa(r0.a(r1, v5.a(this.c, r1, "SHA1"), "OUID"));     // Catch: Throwable -> L8
        L8:
            this.b.set(Integer.valueOf(NetError.ERR_CACHE_WRITE_FAILURE));
        L25:
            this.c.unbindService((ServiceConnection) this.d.get());     // Catch: Throwable -> L11
        L12:
            Object r2 = this.e;
            monitor-enter(r2);
            this.e.notifyAll();     // Catch: Throwable -> L20
        L21:
            monitor-exit(r2);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        L11:
            this.b.set(Integer.valueOf(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED));
        L4:
            this.b.set(Integer.valueOf(NetError.ERR_CACHE_READ_FAILURE));
            r0 = null;
            goto L5
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfputa, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2435$$Nest$sfputa(String r0) {
        f470a = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2436$$Nest$sfputb(long r0) {
        b = r0;
    }

    static {
    }

    private static int a(Context r9, AtomicReference r10, AtomicReference r11) {
        long r1 = System.currentTimeMillis();
        Object r6 = new Object();
        Intent r7 = new Intent();
        r7.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r7.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (r9.bindService(r7, new a(r1, r10, r11, r6), 1) == true) goto L7;
        return -400;
    L7:
        if (r10.get() != null) goto L17;
        monitor-enter(r6);
        r6.wait(1000);     // Catch: Throwable -> L22
    L23:
        monitor-exit(r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r10.get() != null) goto L20;
        return NetError.ERR_CACHE_CREATE_FAILURE;
    L20:
        return 0;
    }

    private static int b(Context r11, AtomicReference r12, AtomicReference r13) {
        Object r6 = new Object();
        AtomicReference r7 = new AtomicReference(0);
        long r8 = System.currentTimeMillis();
        new b(r12, r7, r11, r13, r6).start();
        monitor-enter(r6);
        r6.wait(1000);     // Catch: Throwable -> L12
    L15:
        monitor-exit(r6);     // Catch: Throwable -> L9
        c = System.currentTimeMillis() - r8;
        return ((Integer) r7.get()).intValue();
    L9:
        th = move-exception;
        throw th;
    }

    private static boolean c(Context r0) {
        return true;
    }

    private static String a(Context r3) {
        d = 0;     // Catch: Throwable -> L8
        AtomicReference r0 = new AtomicReference();     // Catch: Throwable -> L8
        AtomicReference r1 = new AtomicReference();     // Catch: Throwable -> L8
        int r2 = a(r3, r0, r1);     // Catch: Throwable -> L8
        d = r2;     // Catch: Throwable -> L8
        if (r2 != 0) goto L6;
        d = b(r3, r0, r1);     // Catch: Throwable -> L8
    L6:
        return f470a;
    L8:
        th = move-exception;
        q8.a("OPPOImpl", th.getMessage());
        d = NetError.ERR_CACHE_RACE;
        return f470a;
    }

    public static String b(Context r1) {
        if (c(r1) == true) goto L7;
        d = NetError.ERR_CACHE_CHECKSUM_READ_FAILURE;
        return f470a;
    L7:
        if (TextUtils.isEmpty(f470a) == false) goto L11;
        return a(r1);
    L11:
        return f470a;
    }
}
