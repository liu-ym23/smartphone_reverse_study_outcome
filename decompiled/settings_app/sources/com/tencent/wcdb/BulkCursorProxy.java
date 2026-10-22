package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: BulkCursorNative.java */
/* JADX INFO: loaded from: classes5.dex */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder r1) {
        this.mRemote = r1;
        this.mExtras = null;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public CursorWindow getWindow(int r4) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L10
        r0.writeInt(r4);     // Catch: Throwable -> L10
        this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L10
        if (r1.readInt() != 1) goto L7;
        CursorWindow r3 = CursorWindow.newFromParcel(r1);     // Catch: Throwable -> L10
    L8:
        r0.recycle();
        r1.recycle();
        return r3;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void onMove(int r4) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L6
        r0.writeInt(r4);     // Catch: Throwable -> L6
        this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void deactivate() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L6
        this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public void close() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L6
        this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public int requery(IContentObserver r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L10
        r0.writeStrongInterface(r5);     // Catch: Throwable -> L10
        boolean r6 = this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L10
        if (r6 == true) goto L6;
        int r4 = -1;
    L8:
        r0.recycle();
        r1.recycle();
        return r4;
    L6:
        int r7 = r1.readInt();     // Catch: Throwable -> L10
        this.mExtras = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L10
        r4 = r7;
    L10:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public Bundle getExtras() throws RemoteException {
        if (this.mExtras != null) goto L11;
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L7
        this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L7
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L7
        this.mExtras = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L7
        r0.recycle();
        r1.recycle();
    L7:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    L11:
        return this.mExtras;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public Bundle respond(Bundle r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(IBulkCursor.descriptor);     // Catch: Throwable -> L6
        r0.writeBundle(r5);     // Catch: Throwable -> L6
        this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
        DatabaseUtils.readExceptionFromParcel(r1);     // Catch: Throwable -> L6
        Bundle r4 = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return r4;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }
}
