package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f22332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ServiceConnection f22333c;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d3 f22334f;

        a(d3 r1) {
            this.f22334f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f22334f.f22332b.put(r2);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public d3(Context r3) {
        this.f22332b = new LinkedBlockingQueue(1);
        this.f22333c = new a(this);
        this.f22331a = r3;
    }

    public void a(g3.a r11) {
        if (c3.d(this.f22331a, (String) m.a(16777217, 0, 0, "236d4e", new byte[]{32, 62, 72, 94, 10, 97, 36, 1, 41, 57, 48, 48, 11, 35, 30, 98, 33, 30, 98, 57, 38, 63, 81, 17, 25, 107, 21, 59, 67})) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction((String) m.a(16777217, 0, 0, "a608aa", new byte[]{115, 59, 78, 2, 95, 101, 119, 4, 47, 101, 99, 53, 13, 77, 93, 98, 107, 24, 111, 38, 81, 23, 96, 105, 109, 69, 93, 51, 72, 76}));
        r0.setComponent(new ComponentName((String) m.a(16777217, 0, 0, "7fa9b5", new byte[]{37, 107, 31, 3, 92, 49, 33, 84, 126, 100, 53, 101, 92, 126, 72, 50, 36, 75, 53, 100, 35, 106, 6, 76, 79, 59, 16, 110, 20}), (String) m.a(16777217, 0, 0, "22d97b", new byte[]{32, 63, 26, 3, 9, 102, 36, 0, 123, 100, 48, 49, 89, 126, 29, 101, 33, 31, 48, 100, 38, 62, 3, 76, 26, 108, 21, 58, 17, 39, 16, 37, 7, 93, 4, 112, 60, 22, 59, 125, 34, 34, 14, 105, 33, 81, 2, 22, 39, 127, 42, 51, 18})));
        if (this.f22331a.bindService(r0, this.f22333c, 1) == false) goto L19;
        String r1 = new q3(this.f22332b.take()).a();     // Catch: Throwable -> L11 Exception -> L16
        if (r11 == null) goto L14;
        r11.a(r1);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        this.f22331a.unbindService(this.f22333c);
        throw th;
    L14:
        this.f22331a.unbindService(this.f22333c);
        return;
    }
}
