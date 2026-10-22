package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p5 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408a;
        public final boolean b;

        a(String r1, boolean r2) {
            this.f408a = r1;
            this.b = r2;
        }
    }

    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f409a;
        private final LinkedBlockingQueue b;

        private b() {
            this.f409a = false;
            this.b = new LinkedBlockingQueue(1);
        }

        /* synthetic */ b(bIA r1) {
            this();
        }

        public IBinder a() {
            if (this.f409a == true) goto L7;
            this.f409a = true;
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

    /* JADX INFO: renamed from: tmsdkobf.p5$b-IA, reason: invalid class name */
    /* JADX INFO: compiled from: D8$$SyntheticClass */
    public final /* synthetic */ class bIA {
    }

    private static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f410a;

        public c(IBinder r1) {
            this.f410a = r1;
        }

        public boolean a(boolean r4) {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L8
            r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L8
            boolean r2 = false;
            this.f410a.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
            r1.readException();     // Catch: Throwable -> L8
            if (r1.readInt() == 0) goto L6;
            r2 = true;
        L6:
            r1.recycle();
            r0.recycle();
            return r2;
        L8:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f410a;
        }

        public String c() {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L6
            this.f410a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
            r1.readException();     // Catch: Throwable -> L6
            String r4 = r1.readString();     // Catch: Throwable -> L6
            r1.recycle();
            r0.recycle();
            return r4;
        L6:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }
    }

    public static a a() {
        bIA r2 = null;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return null;
    L5:
        Context r0 = TMSDKContext.getApplicaionContext();
        r0.getPackageManager().getPackageInfo("com.android.vending", 0);     // Catch: Throwable -> L14
        b r1 = new b(r2);
        Intent r3 = new Intent("com.google.android.gms.ads.identifier.service.START");
        r3.setPackage("com.google.android.gms");
        if (r0.bindService(r3, r1, 1) == false) goto L13;
        c r4 = new c(r1.a());     // Catch: Throwable -> L12
        a r5 = new a(r4.c(), r4.a(true));     // Catch: Throwable -> L12
        r0.unbindService(r1);
        return r5;
    L12:
        r0.unbindService(r1);
    L13:
        return null;
    }

    public static String b() {
        if (lb.a() == true) goto L6;
        return "";
    L6:
        return new h9("tms").a(new String(zc.k), "");
    }

    public static void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (lb.a() == true) goto L9;
        return;
    L9:
        if (TextUtils.equals(b(), r3) == true) goto L16;
        new h9("tms").a(new String(zc.k), r3, true);
        ve.e().e();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }
}
