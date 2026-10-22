package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
class z5 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f655a;
    private final Context b;
    private final a c;
    public CountDownLatch d;

    public class a extends k6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z5 f656a;

        public a(z5 r1) {
            this.f656a = r1;
        }

        @Override // tmsdkobf.k6
        public void a(int r2, Bundle r3) {
            if (r2 != 0) goto L5;
            if (r3 == null) goto L5;
            z5 r4 = this.f656a;
            r4.f655a = r3.getString("oa_id_flag");
        L5:
            this.f656a.d.countDown();
        }
    }

    public z5(Context r3) {
        this.f655a = null;
        this.c = new a(this);
        this.d = new CountDownLatch(2);
        this.b = r3.getApplicationContext();
    }

    public final void a() {
        this.b.unbindService(this);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        Parcel r6 = Parcel.obtain();
        Parcel r0 = Parcel.obtain();
        r6.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L5 Exception -> L7
        r6.writeStrongBinder(this.c);     // Catch: Throwable -> L5 Exception -> L7
        r5.transact(2, r6, r0, 0);     // Catch: Throwable -> L5 Exception -> L7
        r0.readException();     // Catch: Throwable -> L5 Exception -> L7
    L8:
        r6.recycle();
        r0.recycle();
        return;
    L7:
        this.d.countDown();     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r6.recycle();
        r0.recycle();
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.d.countDown();
    }
}
