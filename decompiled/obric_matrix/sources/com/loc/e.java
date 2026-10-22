package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f7261b;

        a(String r1, boolean r2) {
            this.f7260a = r1;
            this.f7261b = r2;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f7260a;
        }

        public final boolean b() {
            return this.f7261b;
        }
    }

    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f7262f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f7263g;

        private b() {
            this.f7262f = false;
            this.f7263g = new LinkedBlockingQueue(1);
        }

        /* synthetic */ b(byte r1) {
            this();
        }

        public final IBinder a() {
            if (this.f7262f == true) goto L7;
            this.f7262f = true;
            return this.f7263g.take();
        L7:
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r1, IBinder r2) {
            this.f7263g.put(r2);     // Catch: InterruptedException -> L4
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    private static final class c implements IInterface {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IBinder f7264f;

        public c(IBinder r1) {
            this.f7264f = r1;
        }

        public final String a() {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L6
            this.f7264f.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f7264f;
        }

        public final boolean c() {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");     // Catch: Throwable -> L9
            boolean r2 = true;
            r0.writeInt(1);     // Catch: Throwable -> L9
            this.f7264f.transact(2, r0, r1, 0);     // Catch: Throwable -> L9
            r1.readException();     // Catch: Throwable -> L9
            if (r1.readInt() != 0) goto L7;
            r2 = false;
        L7:
            r1.recycle();
            r0.recycle();
            return r2;
        L9:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }
    }

    public static String a(Context r2) {
        a r3 = b(r2);     // Catch: Throwable -> L11
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.b() == true) goto L10;
        return a.a(r3);
    L10:
        return null;
    }

    private static a b(Context r4) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L27;
        return null;
    L27:
        byte r2 = 0;
        r4.getPackageManager().getPackageInfo("com.android.vending", 0);     // Catch: Exception -> L23
        b r0 = new b(r2);
        Intent r1 = new Intent("com.google.android.gms.ads.identifier.service.START");
        r1.setPackage("com.google.android.gms");
        if (r4.bindService(r1, r0, 1) == false) goto L22;
        c r3 = new c(r0.a());     // Catch: Throwable -> L15 Exception -> L17
        boolean r5 = r3.c();     // Catch: Throwable -> L15 Exception -> L17
        String r6 = "";
        if (r5 == true) goto L12;
        r6 = r3.a();     // Catch: Throwable -> L15 Exception -> L17
    L12:
        a r7 = new a(r6, r5);     // Catch: Throwable -> L15 Exception -> L17
        r4.unbindService(r0);
        return r7;
    L17:
        e = move-exception;
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r4.unbindService(r0);
        throw th;
    L22:
        throw new IOException("Google Play connection failed");
    L23:
        e = move-exception;
        throw e;
    }
}
