package com.bytedanceos.recorder.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ICallback extends IInterface {

    public static abstract class Stub extends Binder implements ICallback {
        private static final String DESCRIPTOR = "com.bytedanceos.recorder.service.ICallback";
        static final int TRANSACTION_done = 1;

        private static class Proxy implements ICallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.recorder.service.ICallback
            public void done(Bundle result) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (result == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                result.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICallback) == false) goto L12;
            return (ICallback) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            if (data.readInt() == 0) goto L13;
            Bundle r4 = (Bundle) Bundle.CREATOR.createFromParcel(data);
        L14:
            done(r4);
            return true;
        L13:
            r4 = null;
            goto L14
        L5:
            if (code != 1598968902) goto L7;
            reply.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void done(Bundle result) throws RemoteException;
}
