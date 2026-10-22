package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f22361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ServiceConnection f22362c;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h3 f22363f;

        a(h3 r1) {
            this.f22363f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f22363f.f22361b.put(r2);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public h3(Context r3) {
        this.f22361b = new LinkedBlockingQueue(1024);
        this.f22362c = new a(this);
        this.f22360a = r3;
    }

    public void a(g3.a r10) {
        if (c3.d(this.f22360a, (String) m.a(16777217, 0, 0, "e6c576", new byte[]{119, 59, 29, 15, 0, 52, 103, 0, 55, 108, 58, 60, 7, 72, 12})) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent((String) m.a(16777217, 0, 0, "9471f6", new byte[]{43, 57, 73, 11, 76, 46, 62, 28, 117, 47, 39, 38, 65, 75, 93, 36, 44, 28, 101, 100, 102, 25, 116, 96, 119, 8, 30, 38, 89, 82, 13, 4, 114, 108, 122, 4}));
        r0.setPackage((String) m.a(16777217, 0, 0, "f759bb", new byte[]{116, 58, 75, 3, 85, 96, 100, 1, 97, 96, 57, 61, 81, 68, 89}));
        if (this.f22360a.bindService(r0, this.f22362c, 1) == false) goto L19;
        String r1 = new s3(this.f22361b.take()).a();     // Catch: Throwable -> L11 Exception -> L16
        if (r10 == null) goto L14;
        r10.a(r1);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        this.f22360a.unbindService(this.f22362c);
        throw th;
    L14:
        this.f22360a.unbindService(this.f22362c);
        return;
    }
}
