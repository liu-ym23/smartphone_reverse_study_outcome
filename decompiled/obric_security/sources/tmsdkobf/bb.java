package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ttnet.org.chromium.net.NetError;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class bb implements zi {

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f115a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ Object c;

        public a(bb r1, AtomicReference r2, AtomicReference r3, Object r4) {
            this.f115a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f115a.set(r2);
            this.b.set(this);
            Object r3 = this.c;
            monitor-enter(r3);
            this.c.notifyAll();     // Catch: Throwable -> L10
        L13:
            monitor-exit(r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f116a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ AtomicReference e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ bb g;

        public b(bb r1, AtomicReference r2, AtomicReference r3, AtomicReference r4, Context r5, AtomicReference r6, Object r7) {
            this.g = r1;
            this.f116a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String r0 = "";
            r0 = this.g.a((IBinder) this.f116a.get());     // Catch: Throwable -> L5
        L6:
            this.c.set(r0);
            this.d.unbindService((ServiceConnection) this.e.get());     // Catch: Throwable -> L9
        L10:
            Object r1 = this.f;
            monitor-enter(r1);
            this.f.notifyAll();     // Catch: Throwable -> L18
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L9:
            this.b.set(-103);
        L5:
            this.b.set(-102);
            goto L6
        }
    }

    public bb() {
    }

    public abstract String a(IBinder r1);

    @Override // tmsdkobf.zi
    public u9 a(Context r5) {
        AtomicReference r0 = new AtomicReference();
        r0.set("");
        AtomicReference r1 = new AtomicReference();     // Catch: Throwable -> L7
        AtomicReference r2 = new AtomicReference();     // Catch: Throwable -> L7
        int r3 = a(r5, r1, r2);     // Catch: Throwable -> L7
        if (r3 != 0) goto L9;
        r3 = a(r5, r1, r2, r0);     // Catch: Throwable -> L10
    L9:
        return new u9((String) r0.get(), r3);
    L7:
        r3 = -1;
        goto L9
    }

    public final int a(Context r6, AtomicReference r7, AtomicReference r8) {
        Object r0 = new Object();
        Intent r1 = new Intent(xk.a(xk.k));
        r1.setComponent(new ComponentName(xk.a(xk.g), xk.a(xk.h)));
        if (r6.bindService(r1, new a(this, r7, r8, r0), 1) == true) goto L7;
        return -100;
    L7:
        if (r7.get() != null) goto L17;
        monitor-enter(r0);
        r0.wait(1000);     // Catch: Throwable -> L22
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r7.get() != null) goto L20;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L20:
        return 0;
    }

    public final int a(Context r12, AtomicReference r13, AtomicReference r14, AtomicReference r15) {
        Object r8 = new Object();
        AtomicReference r9 = new AtomicReference(0);
        new b(this, r13, r9, r15, r12, r14, r8).start();
        monitor-enter(r8);
        r8.wait(1000);     // Catch: Throwable -> L12
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L9
        return ((Integer) r9.get()).intValue();
    L9:
        th = move-exception;
        throw th;
    }
}
