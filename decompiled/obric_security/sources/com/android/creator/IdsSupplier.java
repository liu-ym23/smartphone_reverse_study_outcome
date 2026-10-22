package com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IdsSupplier extends IInterface {
    public static final String DESCRIPTOR = "com.android.creator.IdsSupplier";

    public static class Default implements IdsSupplier {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.creator.IdsSupplier
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.android.creator.IdsSupplier
        public String getUDID(String r1) throws RemoteException {
            return null;
        }

        @Override // com.android.creator.IdsSupplier
        public boolean isSupported() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IdsSupplier {
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_isSupported = 1;

        private static class Proxy implements IdsSupplier {
            private IBinder mRemote;

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IdsSupplier.DESCRIPTOR;
            }

            @Override // com.android.creator.IdsSupplier
            public String getOAID() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IdsSupplier.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.android.creator.IdsSupplier
            public String getUDID(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IdsSupplier.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r3 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.android.creator.IdsSupplier
            public boolean isSupported() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IdsSupplier.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IdsSupplier.DESCRIPTOR);
        }

        public static IdsSupplier asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IdsSupplier.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IdsSupplier) == false) goto L12;
            return (IdsSupplier) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IdsSupplier.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L11;
            boolean r3 = isSupported();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
        L20:
            return true;
        L11:
            if (r4 != 2) goto L13;
            String r8 = getUDID(r5.readString());
        L18:
            r6.writeNoException();
            r6.writeString(r8);
            goto L20
        L13:
            if (r4 != 3) goto L15;
            r8 = getOAID();
            goto L18
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(IdsSupplier.DESCRIPTOR);
            return true;
        }
    }

    String getOAID() throws RemoteException;

    String getUDID(String r1) throws RemoteException;

    boolean isSupported() throws RemoteException;
}
