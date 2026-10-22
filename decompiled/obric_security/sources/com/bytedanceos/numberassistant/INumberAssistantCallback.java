package com.bytedanceos.numberassistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface INumberAssistantCallback extends IInterface {

    public static class Default implements INumberAssistantCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
        public void executeBaseInfo(List<NumberBaseInfo> baseInfoList) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
        public void executeLogoInfo(List<NumberLogoInfo> logoInfoList) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
        public void executeMarkInfo(List<NumberMarkInfo> markInfoList) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
        public void executeUploadMarkInfo(boolean success) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements INumberAssistantCallback {
        private static final String DESCRIPTOR = "com.bytedanceos.numberassistant.INumberAssistantCallback";
        static final int TRANSACTION_executeBaseInfo = 1;
        static final int TRANSACTION_executeLogoInfo = 3;
        static final int TRANSACTION_executeMarkInfo = 2;
        static final int TRANSACTION_executeUploadMarkInfo = 4;

        private static class Proxy implements INumberAssistantCallback {
            public static INumberAssistantCallback sDefaultImpl;
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

            @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
            public void executeBaseInfo(List<NumberBaseInfo> baseInfoList) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(baseInfoList);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().executeBaseInfo(baseInfoList);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
            public void executeMarkInfo(List<NumberMarkInfo> markInfoList) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(markInfoList);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().executeMarkInfo(markInfoList);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
            public void executeLogoInfo(List<NumberLogoInfo> logoInfoList) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(logoInfoList);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().executeLogoInfo(logoInfoList);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
            public void executeUploadMarkInfo(boolean success) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (success == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().executeUploadMarkInfo(success);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
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

        public static INumberAssistantCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof INumberAssistantCallback) == false) goto L12;
            return (INumberAssistantCallback) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            executeBaseInfo(data.createTypedArrayList(NumberBaseInfo.CREATOR));
            return true;
        L5:
            if (code != 2) goto L7;
            data.enforceInterface(DESCRIPTOR);
            executeMarkInfo(data.createTypedArrayList(NumberMarkInfo.CREATOR));
            return true;
        L7:
            if (code != 3) goto L9;
            data.enforceInterface(DESCRIPTOR);
            executeLogoInfo(data.createTypedArrayList(NumberLogoInfo.CREATOR));
            return true;
        L9:
            if (code != 4) goto L11;
            data.enforceInterface(DESCRIPTOR);
            if (data.readInt() == 0) goto L19;
            boolean r4 = true;
        L20:
            executeUploadMarkInfo(r4);
            return true;
        L19:
            r4 = false;
            goto L20
        L11:
            if (code != 1598968902) goto L13;
            reply.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(INumberAssistantCallback impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static INumberAssistantCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void executeBaseInfo(List<NumberBaseInfo> baseInfoList) throws RemoteException;

    void executeLogoInfo(List<NumberLogoInfo> logoInfoList) throws RemoteException;

    void executeMarkInfo(List<NumberMarkInfo> markInfoList) throws RemoteException;

    void executeUploadMarkInfo(boolean success) throws RemoteException;
}
