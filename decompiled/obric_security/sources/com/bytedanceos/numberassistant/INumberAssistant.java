package com.bytedanceos.numberassistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface INumberAssistant extends IInterface {

    public static class Default implements INumberAssistant {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistant
        public void queryNumberInfo(NumberQueryParams queryParams, INumberAssistantCallback iNumberInfoCallback) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistant
        public void uploadNumberMark(List<NumberMarkInfo> markInfoList, INumberAssistantCallback iNumberInfoCallback) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements INumberAssistant {
        private static final String DESCRIPTOR = "com.bytedanceos.numberassistant.INumberAssistant";
        static final int TRANSACTION_queryNumberInfo = 1;
        static final int TRANSACTION_uploadNumberMark = 2;

        private static class Proxy implements INumberAssistant {
            public static INumberAssistant sDefaultImpl;
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

            @Override // com.bytedanceos.numberassistant.INumberAssistant
            public void queryNumberInfo(NumberQueryParams queryParams, INumberAssistantCallback iNumberInfoCallback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (queryParams == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                queryParams.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (iNumberInfoCallback == null) goto L9;
                IBinder r4 = iNumberInfoCallback.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().queryNumberInfo(queryParams, iNumberInfoCallback);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.INumberAssistant
            public void uploadNumberMark(List<NumberMarkInfo> markInfoList, INumberAssistantCallback iNumberInfoCallback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeTypedList(markInfoList);     // Catch: Throwable -> L17
                if (iNumberInfoCallback == null) goto L6;
                IBinder r2 = iNumberInfoCallback.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadNumberMark(markInfoList, iNumberInfoCallback);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
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

        public static INumberAssistant asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof INumberAssistant) == false) goto L12;
            return (INumberAssistant) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            if (data.readInt() == 0) goto L17;
            NumberQueryParams r4 = NumberQueryParams.CREATOR.createFromParcel(data);
        L18:
            queryNumberInfo(r4, INumberAssistantCallback.Stub.asInterface(data.readStrongBinder()));
            reply.writeNoException();
            return true;
        L17:
            r4 = null;
            goto L18
        L5:
            if (code != 2) goto L7;
            data.enforceInterface(DESCRIPTOR);
            uploadNumberMark(data.createTypedArrayList(NumberMarkInfo.CREATOR), INumberAssistantCallback.Stub.asInterface(data.readStrongBinder()));
            reply.writeNoException();
            return true;
        L7:
            if (code != 1598968902) goto L9;
            reply.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(INumberAssistant impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static INumberAssistant getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void queryNumberInfo(NumberQueryParams queryParams, INumberAssistantCallback iNumberInfoCallback) throws RemoteException;

    void uploadNumberMark(List<NumberMarkInfo> markInfoList, INumberAssistantCallback iNumberInfoCallback) throws RemoteException;
}
