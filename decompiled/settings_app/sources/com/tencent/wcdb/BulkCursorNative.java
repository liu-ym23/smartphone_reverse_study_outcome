package com.tencent.wcdb;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        IBulkCursor r0 = (IBulkCursor) r1.queryLocalInterface(IBulkCursor.descriptor);
        if (r0 == null) goto L9;
        return r0;
    L9:
        return new BulkCursorProxy(r1);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) throws RemoteException {
        switch(r3) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L26;
        };
    L5:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        close();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L7:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        Bundle r2 = respond(r4.readBundle(getClass().getClassLoader()));     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeBundle(r2);     // Catch: Exception -> L22
        return true;
    L9:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        Bundle r7 = getExtras();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeBundle(r7);     // Catch: Exception -> L22
        return true;
    L11:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        onMove(r4.readInt());     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L13:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        int r8 = requery(IContentObserver.Stub.asInterface(r4.readStrongBinder()));     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeInt(r8);     // Catch: Exception -> L22
        r5.writeBundle(getExtras());     // Catch: Exception -> L22
        return true;
    L15:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        deactivate();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L17:
        r4.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L22
        CursorWindow r9 = getWindow(r4.readInt());     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        if (r9 != null) goto L20;
        r5.writeInt(0);     // Catch: Exception -> L22
    L21:
        return true;
    L20:
        r5.writeInt(1);     // Catch: Exception -> L22
        r9.writeToParcel(r5, 1);     // Catch: Exception -> L22
        goto L21
    L26:
        return super.onTransact(r3, r4, r5, r6);
    L22:
        e = move-exception;
        DatabaseUtils.writeExceptionToParcel(r5, e);
        return true;
    }
}
