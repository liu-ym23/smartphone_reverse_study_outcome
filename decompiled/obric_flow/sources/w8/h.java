package w8;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.crash.Npth;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.util.NativeTools;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f22818b;

    public h(int r5, long r10) {
        this.f22817a = r5;
        this.f22818b = r10;
        super("fd_track_looper");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context r5 = n.f4057a;
        String r10 = com.bytedance.crash.util.g.f4181a;
        File r11 = new File(new File(com.bytedance.crash.util.g.h(r5), com.bytedance.crash.util.g.f4181a), "core.config");
    L4:
        if (a.a.f33x == false) goto L23;
        int r12 = NativeTools.k().v(r11.getAbsolutePath());
        if (r12 <= 0) goto L7;
        if (r12 <= this.f22817a) goto L17;
        Log.d("LooperMonitor", "looper start fd_tracker!");
        a.a.f33x = false;
        if (p.f4089m == null) goto L17;
        Npth.startFdTracker();
    L17:
        SystemClock.sleep(this.f22818b);     // Catch: Throwable -> L16
        goto L4
    L7:
        a.a.f33x = false;
        return;
    }
}
