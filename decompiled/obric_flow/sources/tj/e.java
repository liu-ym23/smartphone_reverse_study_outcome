package tj;

import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e8.f {
    public final /* synthetic */ ArrayList d;

    public e(String r5, ArrayList r10) {
        this.d = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (sj.e.f21921a == null) goto L5;
    L15:
        sj.e r5 = sj.e.f21921a;
        ArrayList r10 = this.d;
        r5.getClass();
        if (r10 != null) goto L18;
        return;
    L18:
        if (r10.isEmpty() == true) goto L25;
        TTNetInit.getTTNetDepend();
        throw null;
    L25:
        return;
    L5:
        monitor-enter(sj.e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sj.e.f21921a != null) goto L11;
        sj.e.f21921a = new sj.e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(sj.e.class);     // Catch: Throwable -> L9
        goto L15
    }
}
