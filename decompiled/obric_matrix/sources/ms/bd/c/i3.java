package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f22385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f22386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f22387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ServiceConnection f22388d;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i3 f22389f;

        a(i3 r1) {
            this.f22389f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f22389f.f22387c.put(r2);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public class b extends t3.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile String f22390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private g3.a f22391h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i3 f22392i;

        public b(i3 r1, g3.a r2) {
            this.f22392i = r1;
            this.f22390g = "";
            this.f22391h = null;
            this.f22391h = r2;
        }

        public void a(int r2, Bundle r3) {
            this.f22392i.getClass();
            if (r2 != 0) goto L9;
            if (r3 == null) goto L10;
            this.f22390g = r3.getString(this.f22392i.f22385a);
            g3.a r4 = this.f22391h;
            if (r4 == null) goto L11;
            r4.a(this.f22390g);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public i3(Context r8) {
        this.f22385a = (String) m.a(16777217, 0, 0, "ee5730", new byte[]{123, 102, 121, 74, 8, 24, 96, 72, 101, 96});
        this.f22387c = new LinkedBlockingQueue(1);
        this.f22388d = new a(this);
        this.f22386b = r8;
    }

    public void a(g3.a r10) {
        if (c3.d(this.f22386b, (String) m.a(16777217, 0, 0, "3e5f82", new byte[]{33, 104, 75, 92, 15, 44, 56, 75, 106, 57, 48, 41, 79, 22})) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction((String) m.a(16777217, 0, 0, "1cadb8", new byte[]{35, 110, 31, 94, 85, 38, 58, 77, 62, 59, 50, 47, 27, 20, 19, 7, 60, 109, 49, 29, 36, 82, 23, 2, 75, 38, 49, 71}));
        r0.setPackage((String) m.a(16777217, 0, 0, "2f8876", new byte[]{32, 107, 70, 2, 0, 40, 57, 72, 103, 103, 49, 42, 66, 72}));
        if (this.f22386b.bindService(r0, this.f22388d, 1) == false) goto L17;
        u3.a.a(this.f22387c.take()).W(new b(this, r10));     // Catch: Throwable -> L9 Exception -> L14
    L9:
        th = move-exception;
        this.f22386b.unbindService(this.f22388d);
        throw th;
    L12:
        this.f22386b.unbindService(this.f22388d);
        return;
    }
}
