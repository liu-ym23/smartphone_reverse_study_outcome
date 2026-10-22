package com.obric.cae.libs.l4NetStatus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IQoeStatusReportManager extends IInterface {

    public static class Default implements IQoeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean registerQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean unregisterQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IQoeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager";
        static final int TRANSACTION_registerQoeStatusListener = 1;
        static final int TRANSACTION_unregisterQoeStatusListener = 2;

        public static class Proxy implements IQoeStatusReportManager {
            public static IQoeStatusReportManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean registerQoeStatusListener(String r5, IQoeStatusListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r4 = Stub.getDefaultImpl().registerQoeStatusListener(r5, r6);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean unregisterQoeStatusListener(String r5, IQoeStatusListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r4 = Stub.getDefaultImpl().unregisterQoeStatusListener(r5, r6);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQoeStatusReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IQoeStatusReportManager) == false) goto L12;
            return (IQoeStatusReportManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static IQoeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IQoeStatusReportManager r1) {
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
            boolean r3 = registerQoeStatusListener(r5.readString(), IQoeStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = unregisterQoeStatusListener(r5.readString(), IQoeStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    boolean registerQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException;

    boolean unregisterQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException;
}
