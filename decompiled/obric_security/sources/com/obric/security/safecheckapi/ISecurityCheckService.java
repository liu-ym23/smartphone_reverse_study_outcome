package com.obric.security.safecheckapi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ISecurityCheckService extends IInterface {

    public static class Default implements ISecurityCheckService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckService
        public void checkApk(String r1, ISecurityCheckCallback r2) throws RemoteException {
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckService
        public void checkApkWithInfo(ApkInfo r1, ISecurityCheckCallback r2) throws RemoteException {
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckService
        public void checkPhoneWithExtra(List<String> r1, Bundle r2, ISecurityCheckCallback r3) throws RemoteException {
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckService
        public void checkUrl(List<String> r1, ISecurityCheckCallback r2) throws RemoteException {
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckService
        public void checkUrlWithExtra(List<String> r1, Bundle r2, ISecurityCheckCallback r3) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISecurityCheckService {
        private static final String DESCRIPTOR = "com.obric.security.safecheckapi.ISecurityCheckService";
        static final int TRANSACTION_checkApk = 1;
        static final int TRANSACTION_checkApkWithInfo = 2;
        static final int TRANSACTION_checkPhoneWithExtra = 5;
        static final int TRANSACTION_checkUrl = 3;
        static final int TRANSACTION_checkUrlWithExtra = 4;

        private static class Proxy implements ISecurityCheckService {
            public static ISecurityCheckService sDefaultImpl;
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

            @Override // com.obric.security.safecheckapi.ISecurityCheckService
            public void checkApk(String r4, ISecurityCheckCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r4);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().checkApk(r4, r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.security.safecheckapi.ISecurityCheckService
            public void checkApkWithInfo(ApkInfo r5, ISecurityCheckCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r6 == null) goto L10;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().checkApkWithInfo(r5, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.security.safecheckapi.ISecurityCheckService
            public void checkUrl(List<String> r5, ISecurityCheckCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeStringList(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().checkUrl(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.security.safecheckapi.ISecurityCheckService
            public void checkUrlWithExtra(List<String> r5, Bundle r6, ISecurityCheckCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeStringList(r5);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r7 == null) goto L10;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().checkUrlWithExtra(r5, r6, r7);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.security.safecheckapi.ISecurityCheckService
            public void checkPhoneWithExtra(List<String> r5, Bundle r6, ISecurityCheckCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeStringList(r5);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r7 == null) goto L10;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().checkPhoneWithExtra(r5, r6, r7);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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

        public static ISecurityCheckService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISecurityCheckService) == false) goto L12;
            return (ISecurityCheckService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1) goto L35;
            ApkInfo r3 = null;
            Bundle r4 = null;
            Bundle r9 = null;
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L33;
            r3 = ApkInfo.CREATOR.createFromParcel(r6);
        L33:
            checkApkWithInfo(r3, ISecurityCheckCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            checkUrl(r6.createStringArrayList(), ISecurityCheckCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            ArrayList<String> r10 = r6.createStringArrayList();
            if (r6.readInt() == 0) goto L26;
            r9 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L26:
            checkUrlWithExtra(r10, r9, ISecurityCheckCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L11:
            if (r5 != 5) goto L13;
            r6.enforceInterface(DESCRIPTOR);
            ArrayList<String> r11 = r6.createStringArrayList();
            if (r6.readInt() == 0) goto L21;
            r4 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L21:
            checkPhoneWithExtra(r11, r4, ISecurityCheckCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L13:
            if (r5 != 1598968902) goto L15;
            r7.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r5, r6, r7, r8);
        L35:
            r6.enforceInterface(DESCRIPTOR);
            checkApk(r6.readString(), ISecurityCheckCallback.Stub.asInterface(r6.readStrongBinder()));
            return true;
        }

        public static boolean setDefaultImpl(ISecurityCheckService r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISecurityCheckService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void checkApk(String r1, ISecurityCheckCallback r2) throws RemoteException;

    void checkApkWithInfo(ApkInfo r1, ISecurityCheckCallback r2) throws RemoteException;

    void checkPhoneWithExtra(List<String> r1, Bundle r2, ISecurityCheckCallback r3) throws RemoteException;

    void checkUrl(List<String> r1, ISecurityCheckCallback r2) throws RemoteException;

    void checkUrlWithExtra(List<String> r1, Bundle r2, ISecurityCheckCallback r3) throws RemoteException;
}
