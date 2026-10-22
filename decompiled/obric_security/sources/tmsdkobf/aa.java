package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class aa {
    private static String e = "OpenDeviceId library";
    private static boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f90a;
    private i6 b;
    private ServiceConnection c;
    private b d;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aa f91a;

        a(aa r1) {
            this.f91a = r1;
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName r2, IBinder r3) {
            monitor-enter(this);
            aa.a(this.f91a, i6.a.a(r3));     // Catch: Throwable -> L9
            if (aa.a(this.f91a) == null) goto L6;
            aa.a(this.f91a).a("Deviceid Service Connected", this.f91a);     // Catch: Throwable -> L9
        L6:
            aa.a(this.f91a, "Service onServiceConnected");     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            aa.a(this.f91a, null);
            aa.a(this.f91a, "Service onServiceDisconnected");
        }
    }

    public interface b {
        void a(Object r1, aa r2);
    }

    static {
    }

    public aa() {
        this.f90a = null;
        this.d = null;
    }

    static /* synthetic */ i6 a(aa r0, i6 r1) {
        r0.b = r1;
        return r1;
    }

    private void b(String r1) {
        if (f == false) goto L6;
        Log.i(e, r1);
        return;
    }

    static /* synthetic */ b a(aa r0) {
        return r0.d;
    }

    static /* synthetic */ void a(aa r0, String r1) {
        r0.b(r1);
    }

    public int a(Context r3, b r4) {
        if (r3 == null) goto L10;
        this.f90a = r3;
        this.d = r4;
        this.c = new a(this);
        Intent r5 = new Intent();
        r5.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f90a.bindService(r5, this.c, 1) == false) goto L7;
        b("bindService Successful!");
        return 1;
    L7:
        b("bindService Failed!");
        return -1;
    L10:
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        if (this.f90a != null) goto L14;
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    L14:
        i6 r0 = this.b;     // Catch: RemoteException -> L8
        if (r0 == null) goto L16;
        return r0.getOAID();
    L16:
        return null;
    L8:
        e = move-exception;
        a("getOAID error, RemoteException!");
        e.printStackTrace();
        return null;
    }

    private void a(String r1) {
        if (f == false) goto L6;
        Log.e(e, r1);
        return;
    }
}
