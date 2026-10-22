package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ok {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f401a;
        public final boolean b;

        public a(String r1, boolean r2) {
            this.f401a = r1;
            this.b = r2;
        }
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f402a;
        public final LinkedBlockingQueue b;

        public b() {
            this.f402a = false;
            this.b = new LinkedBlockingQueue(1);
        }

        public IBinder a() {
            if (this.f402a == true) goto L7;
            this.f402a = true;
            return (IBinder) this.b.take();
        L7:
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            this.b.put(r2);     // Catch: InterruptedException -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public static a a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return null;
    L6:
        monitor-enter(mh.class);
        Context r1 = mh.f353a;     // Catch: Throwable -> L32
        monitor-exit(mh.class);
        boolean r4 = false;
        r1.getPackageManager().getPackageInfo("com.android.vending", 0);     // Catch: Exception -> L35
        b r0 = new b();
        Intent r3 = new Intent("com.google.android.gms.ads.identifier.service.START");
        r3.setPackage("com.google.android.gms");
        if (r1.bindService(r3, r0, 1) == false) goto L31;
        IBinder r5 = r0.a();     // Catch: Throwable -> L27 Exception -> L30
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L27 Exception -> L30
        Parcel r8 = Parcel.obtain();     // Catch: Throwable -> L27 Exception -> L30
        r7.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L24
        r5.transact(1, r7, r8, 0);     // Catch: Throwable -> L24
        r8.readException();     // Catch: Throwable -> L24
        String r9 = r8.readString();     // Catch: Throwable -> L24
        r8.recycle();     // Catch: Throwable -> L27 Exception -> L30
        r7.recycle();     // Catch: Throwable -> L27 Exception -> L30
        Parcel r10 = Parcel.obtain();     // Catch: Throwable -> L27 Exception -> L30
        Parcel r11 = Parcel.obtain();     // Catch: Throwable -> L27 Exception -> L30
        r10.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L21
        r10.writeInt(1);     // Catch: Throwable -> L21
        r5.transact(2, r10, r11, 0);     // Catch: Throwable -> L21
        r11.readException();     // Catch: Throwable -> L21
        if (r11.readInt() == 0) goto L18;
        r4 = true;
    L18:
        r11.recycle();     // Catch: Throwable -> L27 Exception -> L30
        r10.recycle();     // Catch: Throwable -> L27 Exception -> L30
        a r6 = new a(r9, r4);     // Catch: Throwable -> L27 Exception -> L30
        r1.unbindService(r0);
        return r6;
    L21:
        th = move-exception;
        r11.recycle();     // Catch: Throwable -> L27 Exception -> L30
        r10.recycle();     // Catch: Throwable -> L27 Exception -> L30
        throw th;     // Catch: Throwable -> L27 Exception -> L30
    L24:
        th = move-exception;
        r8.recycle();     // Catch: Throwable -> L27 Exception -> L30
        r7.recycle();     // Catch: Throwable -> L27 Exception -> L30
        throw th;     // Catch: Throwable -> L27 Exception -> L30
    L30:
        r1.unbindService(r0);
    L27:
        th = move-exception;
        r1.unbindService(r0);
        throw th;
    L31:
        return null;
    L32:
        th = move-exception;
        throw th;
    }
}
