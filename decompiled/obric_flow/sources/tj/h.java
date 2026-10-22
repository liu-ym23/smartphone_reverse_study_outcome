package tj;

import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends e8.f {
    @Override // java.lang.Runnable
    public final void run() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
