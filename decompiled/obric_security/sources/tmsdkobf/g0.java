package tmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g0 extends BroadcastReceiver {
    public g0() {
    }

    public abstract void a(Context r1, Intent r2);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r1, Intent r2) {
        a(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
