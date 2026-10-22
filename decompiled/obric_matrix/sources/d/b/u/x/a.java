package d.b.u.x;

import android.util.Log;
import com.ss.android.agilelogger.ALog;
import d.b.u.w.d;

/* JADX INFO: loaded from: classes.dex */
final class a implements d {
    a() {
    }

    @Override // d.b.u.w.d
    public void a(String r1) {
        ALog.e("SyncSDKLog", r1);     // Catch: Throwable -> L4
        return;
    }

    @Override // d.b.u.w.d
    public void b(String r1) {
        Log.v("SyncSDKLog", r1);     // Catch: Throwable -> L5
        ALog.v("SyncSDKLog", r1);     // Catch: Throwable -> L5
        return;
    }

    @Override // d.b.u.w.d
    public void c(String r1) {
        ALog.i("SyncSDKLog", r1);     // Catch: Throwable -> L4
        return;
    }

    @Override // d.b.u.w.d
    public void d(String r1) {
        ALog.i("SyncSDKLog", r1);     // Catch: Throwable -> L4
        return;
    }
}
