package tmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class bj extends BroadcastReceiver {
    public bj() {
    }

    public abstract void a(Context r1, Intent r2);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        a(r1, r2);     // Catch: Throwable -> L4
        return;
    }
}
