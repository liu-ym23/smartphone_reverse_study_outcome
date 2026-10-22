package com.bytedance.badger.f;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class h implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IBinder f2566f;

    h(IBinder r1) {
        this.f2566f = r1;
    }

    @Override // com.bytedance.badger.f.j
    public boolean E(int r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(i.c());     // Catch: Throwable -> L11
        r0.writeInt(r4);     // Catch: Throwable -> L11
        boolean r2 = false;
        if (this.f2566f.transact(3, r0, r1, 0) == true) goto L6;
        int r3 = i.f2568g;     // Catch: Throwable -> L11
    L6:
        r1.readException();     // Catch: Throwable -> L11
        if (r1.readInt() == 0) goto L9;
        r2 = true;
    L9:
        r1.recycle();
        r0.recycle();
        return r2;
    L11:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.bytedance.badger.f.j
    public int K(int r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(i.c());     // Catch: Throwable -> L9
        r0.writeInt(r4);     // Catch: Throwable -> L9
        if (this.f2566f.transact(1, r0, r1, 0) == true) goto L6;
        int r3 = i.f2568g;     // Catch: Throwable -> L9
    L6:
        r1.readException();     // Catch: Throwable -> L9
        int r5 = r1.readInt();     // Catch: Throwable -> L9
        r1.recycle();
        r0.recycle();
        return r5;
    L9:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.bytedance.badger.f.j
    public g R(int r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(i.c());     // Catch: Throwable -> L15
        r0.writeInt(r4);     // Catch: Throwable -> L15
        if (this.f2566f.transact(2, r0, r1, 0) == true) goto L6;
        int r3 = i.f2568g;     // Catch: Throwable -> L15
    L6:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() != 0) goto L10;
        g r5 = null;
    L13:
        r1.recycle();
        r0.recycle();
        return r5;
    L10:
        r5 = (g) ((f) g.f2562d).createFromParcel(r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2566f;
    }
}
