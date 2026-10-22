package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f22432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ServiceConnection f22433c;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ n3 f22434f;

        a(n3 r1) {
            this.f22434f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f22434f.f22432b.put(r2);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public n3(Context r3) {
        this.f22432b = new LinkedBlockingQueue(1);
        this.f22433c = new a(this);
        this.f22431a = r3;
    }

    public void a(g3.a r21) {
        if (c3.d(this.f22431a, (String) m.a(16777217, 0, 0, "9f5f1a", new byte[]{43, 107, 75, 92, 29, 119, 55, 84, 113, 56, 47, 42, 71, 28, 10, 100, 53, 78, 96, 120, 44, 97, 80, 27, 13, 115, 51, 67, 119, 51, 58, 114, 79, 17, 11})) == true) goto L5;
        return;
    L5:
        boolean r4 = false;
        this.f22431a.getPackageManager().getPackageInfo((String) m.a(16777217, 0, 0, "c34019", new byte[]{113, 62, 74, 10, 29, 47, 109, 1, 112, 110, 117, 127, 70, 74, 10, 60, 111, 27, 97, 46, 118, 52, 81, 77, 13, 43, 105, 22, 118, 101, 96, 39, 78, 71, 11}), 0);     // Catch: Exception -> L24
    L9:
        Intent r5 = new Intent();
        r5.setClassName((String) m.a(16777217, 0, 0, "1c4e34", new byte[]{35, 110, 74, 95, 31, 34, 63, 81, 112, 59, 39, 47, 70, 31, 8, 49, 61, 75, 97, 123, 36, 100, 81, 24, 15, 38, 59, 70, 118, 48, 50, 119, 78, 18, 9}), (String) m.a(16777217, 0, 0, "53fe3f", new byte[]{39, 62, 24, 95, 31, 112, 59, 1, 34, 59, 35, 127, 20, 31, 8, 99, 57, 27, 51, 123, 32, 52, 3, 24, 15, 116, 63, 22, 36, 48, 54, 39, 28, 18, 9, 63, 18, 23, 33, 60, 39, 52, 60, 21, 63, 116, 36, 4, 62, 54, 33}));
        r4 = this.f22431a.bindService(r5, this.f22433c, 1);     // Catch: Throwable -> L17 Exception -> L21
        if (r4 == false) goto L15;
        String r2 = new x3(this.f22432b.take()).a();     // Catch: Throwable -> L17 Exception -> L21
        if (r21 == null) goto L15;
        r21.a(r2);     // Catch: Throwable -> L17 Exception -> L21
    L15:
        if (r4 == false) goto L29;
    L22:
        this.f22431a.unbindService(this.f22433c);
        return;
    L29:
        return;
    L21:
        if (r4 == true) goto L22;
        return;
    L17:
        th = move-exception;
        if (r4 == false) goto L20;
        this.f22431a.unbindService(this.f22433c);
    L20:
        throw th;
    }
}
