package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface HarLevel2DataResp extends IInterface {

    public static class Default implements HarLevel2DataResp {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onCollectStats(boolean r1, ParcelFileDescriptor r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onDataReady(int r1, int r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements HarLevel2DataResp {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.HarLevel2DataResp";
        static final int TRANSACTION_onCollectStats = 1;
        static final int TRANSACTION_onDataReady = 2;

        public static class Proxy implements HarLevel2DataResp {
            public static HarLevel2DataResp sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onCollectStats(boolean r4, ParcelFileDescriptor r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCollectStats(r4, r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onDataReady(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onDataReady(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static HarLevel2DataResp asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof HarLevel2DataResp) == false) goto L12;
            return (HarLevel2DataResp) r0;
        L12:
            return new Proxy(r2);
        }

        public static HarLevel2DataResp getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(HarLevel2DataResp r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L17;
            boolean r8 = true;
        L19:
            if (r5.readInt() == 0) goto L21;
            ParcelFileDescriptor r9 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r5);
        L22:
            onCollectStats(r8, r9);
            return true;
        L21:
            r9 = null;
            goto L22
        L17:
            r8 = false;
            goto L19
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onDataReady(r5.readInt(), r5.readInt());
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onCollectStats(boolean r1, ParcelFileDescriptor r2) throws RemoteException;

    void onDataReady(int r1, int r2) throws RemoteException;
}
