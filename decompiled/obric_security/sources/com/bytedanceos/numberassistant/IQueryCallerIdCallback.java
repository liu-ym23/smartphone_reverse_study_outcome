package com.bytedanceos.numberassistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IQueryCallerIdCallback extends IInterface {

    public static class Default implements IQueryCallerIdCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IQueryCallerIdCallback
        public void onQueryComplete(CallerIdDetail detail, boolean isOnline) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IQueryCallerIdCallback {
        private static final String DESCRIPTOR = "com.bytedanceos.numberassistant.IQueryCallerIdCallback";
        static final int TRANSACTION_onQueryComplete = 1;

        private static class Proxy implements IQueryCallerIdCallback {
            public static IQueryCallerIdCallback sDefaultImpl;
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

            @Override // com.bytedanceos.numberassistant.IQueryCallerIdCallback
            public void onQueryComplete(CallerIdDetail detail, boolean isOnline) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (detail == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                detail.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (isOnline == false) goto L9;
                int r4 = 1;
            L10:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onQueryComplete(detail, isOnline);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r4 = 0;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
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

        public static IQueryCallerIdCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IQueryCallerIdCallback) == false) goto L12;
            return (IQueryCallerIdCallback) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            if (data.readInt() == 0) goto L13;
            CallerIdDetail r4 = CallerIdDetail.CREATOR.createFromParcel(data);
        L15:
            if (data.readInt() == 0) goto L17;
            boolean r5 = true;
        L18:
            onQueryComplete(r4, r5);
            reply.writeNoException();
            return true;
        L17:
            r5 = false;
            goto L18
        L13:
            r4 = null;
            goto L15
        L5:
            if (code != 1598968902) goto L7;
            reply.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(IQueryCallerIdCallback impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IQueryCallerIdCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onQueryComplete(CallerIdDetail detail, boolean isOnline) throws RemoteException;
}
