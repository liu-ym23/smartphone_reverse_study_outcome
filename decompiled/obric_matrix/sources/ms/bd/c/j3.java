package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    v3 f22408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ServiceConnection f22409c;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j3 f22410f;

        a(j3 r1) {
            this.f22410f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            j3 r0 = this.f22410f;
            r0.f22408b = new v3(r2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public j3(Context r2) {
        this.f22409c = new a(this);
        this.f22407a = r2;
    }

    public void a(g3.a r10) {
        Intent r0 = new Intent();
        r0.setClassName((String) m.a(16777217, 0, 0, "2fb349", new byte[]{32, 107, 28, 9, 17, 59, 56, 9, 55, 102, 53, 109, 18, 66, 2, 42, 34, 66, 33, 117, 42, 103, 20}), (String) m.a(16777217, 0, 0, "5e7ff0", new byte[]{39, 104, 73, 92, 67, 50, 63, 10, 98, 51, 50, 110, 71, 23, 80, 35, 37, 65, 116, 32, 45, 100, 65, 92, 125, 34, 32, 77, 101, 51, 45, 99, 119, 23, 75, 49, 63, 71, 99}));
        if (this.f22407a.bindService(r0, this.f22409c, 1) == false) goto L14;
        v3 r1 = this.f22408b;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        String r2 = r1.a();     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        r10.a(r2);     // Catch: Throwable -> L11
    L9:
        this.f22407a.unbindService(this.f22409c);
        return;
    }
}
