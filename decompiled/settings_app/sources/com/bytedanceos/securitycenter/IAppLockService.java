package com.bytedanceos.securitycenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IAppLockService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedanceos.securitycenter.IAppLockService";

    public static class Default implements IAppLockService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.securitycenter.IAppLockService
        public List<String> getIgnoredAppList() throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.securitycenter.IAppLockService
        public List<String> getLockedAppList() throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.securitycenter.IAppLockService
        public boolean isAppLocked(String r1) throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IAppLockService
        public void lockApp(String r1) throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IAppLockService
        public void unlockApp(String r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAppLockService {
        static final int TRANSACTION_getIgnoredAppList = 5;
        static final int TRANSACTION_getLockedAppList = 4;
        static final int TRANSACTION_isAppLocked = 3;
        static final int TRANSACTION_lockApp = 1;
        static final int TRANSACTION_unlockApp = 2;

        private static class Proxy implements IAppLockService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAppLockService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.securitycenter.IAppLockService
            public void lockApp(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppLockService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IAppLockService
            public void unlockApp(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppLockService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IAppLockService
            public boolean isAppLocked(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppLockService.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.bytedanceos.securitycenter.IAppLockService
            public List<String> getLockedAppList() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppLockService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList<String> r4 = r1.createStringArrayList();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IAppLockService
            public List<String> getIgnoredAppList() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppLockService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList<String> r4 = r1.createStringArrayList();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
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
            attachInterface(this, IAppLockService.DESCRIPTOR);
        }

        public static IAppLockService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAppLockService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAppLockService) == false) goto L12;
            return (IAppLockService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAppLockService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L26;
            if (r4 != 1) goto L11;
            lockApp(r5.readString());
            r6.writeNoException();
        L25:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unlockApp(r5.readString());
            r6.writeNoException();
            goto L25
        L13:
            if (r4 != 3) goto L15;
            boolean r3 = isAppLocked(r5.readString());
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L25
        L15:
            if (r4 != 4) goto L17;
            List<String> r8 = getLockedAppList();
            r6.writeNoException();
            r6.writeStringList(r8);
            goto L25
        L17:
            if (r4 != 5) goto L19;
            List<String> r9 = getIgnoredAppList();
            r6.writeNoException();
            r6.writeStringList(r9);
            goto L25
        L19:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            r6.writeString(IAppLockService.DESCRIPTOR);
            return true;
        }
    }

    List<String> getIgnoredAppList() throws RemoteException;

    List<String> getLockedAppList() throws RemoteException;

    boolean isAppLocked(String r1) throws RemoteException;

    void lockApp(String r1) throws RemoteException;

    void unlockApp(String r1) throws RemoteException;
}
