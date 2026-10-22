package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeMultipathManager extends IInterface {

    public static class Default implements ICaeMultipathManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantOperateApps(int[] r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r1, int r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void startMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void stopMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathManager";
        static final int TRANSACTION_getLatestNetworkTruth = 7;
        static final int TRANSACTION_reportAssistantFailure = 8;
        static final int TRANSACTION_reportAssistantOperateApps = 9;
        static final int TRANSACTION_reportMPAConnectionQuality = 3;
        static final int TRANSACTION_reportPathCtlModeChanged = 6;
        static final int TRANSACTION_setICaeMultipathCallback = 4;
        static final int TRANSACTION_startMultipath = 1;
        static final int TRANSACTION_stopMultipath = 2;
        static final int TRANSACTION_unsetICaeMultipathCallback = 5;

        public static class Proxy implements ICaeMultipathManager {
            public static ICaeMultipathManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public String getLatestNetworkTruth() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getLatestNetworkTruth();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantFailure() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantFailure();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantOperateApps(int[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeIntArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantOperateApps(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportMPAConnectionQuality(String r10, int r11, int r12, int r13, int r14, int r15) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                r0.writeInt(r14);     // Catch: Throwable -> L13
                r0.writeInt(r15);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportMPAConnectionQuality(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportPathCtlModeChanged(String r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportPathCtlModeChanged(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void setICaeMultipathCallback(ICaeMultipathCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setICaeMultipathCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void startMultipath() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startMultipath();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void stopMultipath() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopMultipath();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void unsetICaeMultipathCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unsetICaeMultipathCallback();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMultipathManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeMultipathManager) == false) goto L12;
            return (ICaeMultipathManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeMultipathManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMultipathManager r1) {
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 == 1598968902) goto L25;
            switch(r10) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r11.enforceInterface(DESCRIPTOR);
            reportAssistantOperateApps(r11.createIntArray());
            return true;
        L9:
            r11.enforceInterface(DESCRIPTOR);
            reportAssistantFailure();
            return true;
        L11:
            r11.enforceInterface(DESCRIPTOR);
            String r9 = getLatestNetworkTruth();
            r12.writeNoException();
            r12.writeString(r9);
            return true;
        L13:
            r11.enforceInterface(DESCRIPTOR);
            reportPathCtlModeChanged(r11.readString(), r11.readInt());
            r12.writeNoException();
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            unsetICaeMultipathCallback();
            r12.writeNoException();
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            setICaeMultipathCallback(ICaeMultipathCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L19:
            r11.enforceInterface(DESCRIPTOR);
            reportMPAConnectionQuality(r11.readString(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L21:
            r11.enforceInterface(DESCRIPTOR);
            stopMultipath();
            r12.writeNoException();
            return true;
        L23:
            r11.enforceInterface(DESCRIPTOR);
            startMultipath();
            r12.writeNoException();
            return true;
        L6:
            return super.onTransact(r10, r11, r12, r13);
        L25:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getLatestNetworkTruth() throws RemoteException;

    void reportAssistantFailure() throws RemoteException;

    void reportAssistantOperateApps(int[] r1) throws RemoteException;

    void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException;

    void reportPathCtlModeChanged(String r1, int r2) throws RemoteException;

    void setICaeMultipathCallback(ICaeMultipathCallback r1) throws RemoteException;

    void startMultipath() throws RemoteException;

    void stopMultipath() throws RemoteException;

    void unsetICaeMultipathCallback() throws RemoteException;
}
