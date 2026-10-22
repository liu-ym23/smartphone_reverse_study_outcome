package com.android.settings;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ISettingsSearchService extends IInterface {

    public static class Default implements ISettingsSearchService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.settings.ISettingsSearchService
        public boolean isSettingsEnabled(String r1) throws RemoteException {
            return false;
        }

        @Override // com.android.settings.ISettingsSearchService
        public void setOnUpdateViewListener(String r1, IUpdateViewListener r2) throws RemoteException {
        }

        @Override // com.android.settings.ISettingsSearchService
        public void setSettingsEnabled(String r1, boolean r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISettingsSearchService {
        private static final String DESCRIPTOR = "com.android.settings.ISettingsSearchService";
        static final int TRANSACTION_isSettingsEnabled = 2;
        static final int TRANSACTION_setOnUpdateViewListener = 3;
        static final int TRANSACTION_setSettingsEnabled = 1;

        private static class Proxy implements ISettingsSearchService {
            public static ISettingsSearchService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.settings.ISettingsSearchService
            public void setSettingsEnabled(String r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setSettingsEnabled(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.android.settings.ISettingsSearchService
            public boolean isSettingsEnabled(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isSettingsEnabled(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.android.settings.ISettingsSearchService
            public void setOnUpdateViewListener(String r5, IUpdateViewListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setOnUpdateViewListener(r5, r6);     // Catch: Throwable -> L17
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

        public static ISettingsSearchService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISettingsSearchService) == false) goto L12;
            return (ISettingsSearchService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L21;
            boolean r9 = true;
        L22:
            setSettingsEnabled(r8, r9);
            r6.writeNoException();
            return true;
        L21:
            r9 = false;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = isSettingsEnabled(r5.readString());
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            setOnUpdateViewListener(r5.readString(), IUpdateViewListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(ISettingsSearchService r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISettingsSearchService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean isSettingsEnabled(String r1) throws RemoteException;

    void setOnUpdateViewListener(String r1, IUpdateViewListener r2) throws RemoteException;

    void setSettingsEnabled(String r1, boolean r2) throws RemoteException;
}
