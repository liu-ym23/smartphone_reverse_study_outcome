package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f230a;
    private Handler b;
    private sh c;
    private ConcurrentHashMap d;

    static /* synthetic */ class a {
    }

    private class b extends bj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f231a;
        private Runnable b;
        final /* synthetic */ gi c;

        /* synthetic */ b(gi r1, String r2, Runnable r3, a r4) {
            this(r1, r2, r3);
        }

        @Override // tmsdkobf.bj
        public void a(Context r2, Intent r3) {
            String r4 = r3.getAction();
            if (r4 != null) goto L6;
            return;
        L6:
            if (this.f231a.equals(r4) == true) goto L8;
            return;
        L8:
            if (this.b == null) goto L13;
            gi.a(this.c).post(this.b);
            this.c.a(r4);
            return;
        }

        private b(gi r1, String r2, Runnable r3) {
            this.c = r1;
            this.f231a = r2;
            this.b = r3;
        }
    }

    public gi(sh r3) {
        this.d = new ConcurrentHashMap();
        this.f230a = rd.e();
        this.b = new Handler(uk.a());
        this.c = r3;
    }

    static /* synthetic */ Handler a(gi r0) {
        return r0.b;
    }

    public void a(String r8, long r9, Runnable r11) {
        b r6 = new b(this, r8, r11, null);     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.f230a.registerReceiver(r6, new IntentFilter(r8), rd.f(), null, 4);     // Catch: Throwable -> L8
    L6:
        this.c.a(this.f230a, r8, r9);     // Catch: Throwable -> L8
        this.d.put(r8, r6);     // Catch: Throwable -> L8
        return;
    L5:
        this.f230a.registerReceiver(r6, new IntentFilter(r8), rd.f(), null);     // Catch: Throwable -> L8
    }

    public void a(String r4) {
        b r0 = (b) this.d.remove(r4);
        if (r0 == null) goto L6;
        this.c.a(this.f230a, r4);
        this.f230a.unregisterReceiver(r0);
        return;
    }
}
