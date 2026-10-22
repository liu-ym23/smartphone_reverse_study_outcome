package s8;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f21841b;

    public /* synthetic */ c(d r5, int r10) {
        this.f21840a = r10;
        this.f21841b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21840a) {
            case 0: goto L35;
            default: goto L4;
        };
    L4:
        Object r5 = this.f21841b.f;
        monitor-enter(r5);
        d r10 = this.f21841b;     // Catch: Throwable -> L23
        if (r10.d == null) goto L52;
        Context r11 = r10.f21842a;     // Catch: Throwable -> L23
        Class r12 = (Class) r10.f21847j.f23313c;     // Catch: Throwable -> L23
        if (r11 == null) goto L52;
        if (r12 == null) goto L52;
        Iterator<ActivityManager.RunningServiceInfo> r13 = ((ActivityManager) r11.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();     // Catch: Throwable -> L23 Exception -> L25
    L14:
        if (r13.hasNext() == false) goto L52;
        ActivityManager.RunningServiceInfo r14 = r13.next();     // Catch: Throwable -> L23 Exception -> L25
        if (r14 == null) goto L14;
        if (r14.service == null) goto L14;
        if (TextUtils.equals(r12.getName(), r14.service.getClassName()) == false) goto L14;
        d r15 = this.f21841b;     // Catch: Throwable -> L23
        r15.f21842a.unbindService(r15.d);     // Catch: Throwable -> L23
        goto L52
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
    L52:
    L29:
        d r16 = this.f21841b;     // Catch: Throwable -> L32
        r16.d = null;     // Catch: Throwable -> L32
        r16.f21843b = null;     // Catch: Throwable -> L32
        Logger.d("WsChannelSdk", "mDisconnectRunnable timeout");     // Catch: Throwable -> L32
        monitor-exit(r5);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L32
        goto L29
    L35:
        Object r17 = this.f21841b.f;
        monitor-enter(r17);
        Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");     // Catch: Throwable -> L40
        d r18 = this.f21841b;     // Catch: Throwable -> L40
        if (r18.e == false) goto L42;
        r18.e = false;     // Catch: Throwable -> L40
    L42:
        monitor-exit(r17);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    }
}
