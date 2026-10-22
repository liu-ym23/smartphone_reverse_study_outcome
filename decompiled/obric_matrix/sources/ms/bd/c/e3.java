package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f22336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f22337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f22338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ServiceConnection f22339d;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e3 f22340f;

        a(e3 r1) {
            this.f22340f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f22340f.f22338c.put(r2);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public e3(Context r8) {
        this.f22337b = (String) m.a(16777217, 0, 0, "52230b", new byte[]{39, 63, 76, 9, 2, 113, 63, 23, 45, 110, 55, 49});
        this.f22338c = new LinkedBlockingQueue(1);
        this.f22339d = new a(this);
        this.f22336a = r8;
    }

    public void a(g3.a r20) {
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == true) goto L8;
        return;
    L8:
        String r3 = this.f22336a.getPackageName();
        Intent r4 = new Intent();
        r4.setClassName(this.f22337b, (String) m.a(16777217, 0, 0, "3835f9", new byte[]{33, 53, 77, 15, 84, 42, 57, 29, 44, 104, 49, 59, 14, 82, 92, 60, 38, 16, 97, 96, 108, 23, 83, 64, 114, 34, 3, 28, 112, 115, 43, 57, 69}));
        r4.setAction((String) m.a(16777217, 0, 0, "53e99b", new byte[]{39, 62, 27, 3, 4, 96, 56, 92, 57, 122, 37, 127, 23, 78, 18, 124, 57, 28, 122, 122, 48, 48, 4, 89, 72, 102, 51, 0, 34, 96, 39, 52}));
        r4.putExtra((String) m.a(16777217, 0, 0, "22416a", new byte[]{32, 63, 74, 11, 11, 99, 63, 93, 104, 114, 34, 126, 87, 68, 27, 119, 60, 93, 117, 106, 36, 62, 70, 72, 12}), r3);
        int r5 = 1;
        r4.putExtra((String) m.a(16777217, 0, 0, "323caa", new byte[]{33, 63, 77, 89, 92, 99, 62, 93, 111, 32, 35, 126, 80, 22, 76, 119, 61, 93, 112, 38, 44, 57, 78, 4, 91, 98}), true);     // Catch: Exception -> L25
        this.f22336a.startService(r4);     // Catch: Exception -> L25
    L14:
        Intent r6 = new Intent();
        r6.setClassName((String) m.a(16777217, 0, 0, "5ae320", new byte[]{39, 108, 27, 9, 0, 35, 63, 68, 122, 110, 55, 98}), (String) m.a(16777217, 0, 0, "d8091c", new byte[]{118, 53, 78, 3, 3, 112, 110, 29, 47, 100, 102, 59, 13, 94, 11, 102, 113, 16, 98, 108, 59, 23, 80, 76, 39, 112, 84, 28, 115, 127, 124, 57, 70}));
        r6.setAction((String) m.a(16777217, 0, 0, "a8e606", new byte[]{115, 53, 27, 12, 13, 52, 108, 87, 57, 117, 113, 116, 23, 65, 27, 40, 109, 23, 122, 100, 121, 52, 18, 86, 0, 111, 113, 28, 38, 112, 121, 57, 19}));
        r6.putExtra((String) m.a(16777217, 0, 0, "5ad01e", new byte[]{39, 108, 26, 10, 12, 103, 56, 14, 56, 115, 37, 45, 7, 69, 28, 115, 59, 14, 37, 107, 35, 109, 22, 73, 11}), r3);
        if (this.f22336a.bindService(r6, this.f22339d, r5) == false) goto L33;
        String r7 = new r3(this.f22338c.take()).a();     // Catch: Throwable -> L20 Exception -> L26
        if (r20 == null) goto L23;
        r20.a(r7);     // Catch: Throwable -> L20 Exception -> L26
    L20:
        th = move-exception;
        this.f22336a.unbindService(this.f22339d);
        throw th;
    L23:
        this.f22336a.unbindService(this.f22339d);
        return;
    L33:
        return;
    L13:
        r5 = 1;
        goto L14
    L5:
        r2 = c3.d(this.f22336a, this.f22337b);
        goto L6
    }
}
