package com.bytedanceos.numberassistant.xysdk;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IXySdkCallBack extends IInterface {

    public static class Default implements IXySdkCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
        public void execute(XySdkParserItem item) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
        public void executeNumberLogo(Bitmap logo) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
        public void executeNumberLogoByte(byte[] logo) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
        public void executeNumberPublicInfo(String publicInfo) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IXySdkCallBack {
        private static final String DESCRIPTOR = "com.bytedanceos.numberassistant.xysdk.IXySdkCallBack";
        static final int TRANSACTION_execute = 1;
        static final int TRANSACTION_executeNumberLogo = 3;
        static final int TRANSACTION_executeNumberLogoByte = 4;
        static final int TRANSACTION_executeNumberPublicInfo = 2;

        private static class Proxy implements IXySdkCallBack {
            public static IXySdkCallBack sDefaultImpl;
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

            @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
            public void execute(XySdkParserItem item) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (item == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                item.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().execute(item);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
            public void executeNumberPublicInfo(String publicInfo) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(publicInfo);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().executeNumberPublicInfo(publicInfo);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
            public void executeNumberLogo(Bitmap logo) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (logo == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                logo.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().executeNumberLogo(logo);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.xysdk.IXySdkCallBack
            public void executeNumberLogoByte(byte[] logo) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeByteArray(logo);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().executeNumberLogoByte(logo);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
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

        public static IXySdkCallBack asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IXySdkCallBack) == false) goto L12;
            return (IXySdkCallBack) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            XySdkParserItem r0 = null;
            Bitmap r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L28;
            r0 = XySdkParserItem.CREATOR.createFromParcel(r6);
        L28:
            execute(r0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            executeNumberPublicInfo(r6.readString());
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L21;
            r1 = (Bitmap) Bitmap.CREATOR.createFromParcel(r6);
        L21:
            executeNumberLogo(r1);
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            executeNumberLogoByte(r6.createByteArray());
            return true;
        L11:
            if (r5 != 1598968902) goto L13;
            r7.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(IXySdkCallBack impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IXySdkCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void execute(XySdkParserItem item) throws RemoteException;

    void executeNumberLogo(Bitmap logo) throws RemoteException;

    void executeNumberLogoByte(byte[] logo) throws RemoteException;

    void executeNumberPublicInfo(String publicInfo) throws RemoteException;
}
