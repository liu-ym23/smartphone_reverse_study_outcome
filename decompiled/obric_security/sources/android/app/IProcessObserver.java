package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessObserver extends IInterface {

    public static class Default implements IProcessObserver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.IProcessObserver
        public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) throws RemoteException {
        }

        @Override // android.app.IProcessObserver
        public void onForegroundServicesChanged(int pid, int uid, int serviceTypes) throws RemoteException {
        }

        @Override // android.app.IProcessObserver
        public void onProcessDied(int pid, int uid) throws RemoteException {
        }

        @Override // android.app.IProcessObserver
        public void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IProcessObserver {
        private static final String DESCRIPTOR = "android.app.IProcessObserver";
        static final int TRANSACTION_onForegroundActivitiesChanged = 2;
        static final int TRANSACTION_onForegroundServicesChanged = 3;
        static final int TRANSACTION_onProcessDied = 4;
        static final int TRANSACTION_onProcessStarted = 1;

        private static class Proxy implements IProcessObserver {
            public static IProcessObserver sDefaultImpl;
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

            @Override // android.app.IProcessObserver
            public void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(pid);     // Catch: Throwable -> L12
                r0.writeInt(processUid);     // Catch: Throwable -> L12
                r0.writeInt(packageUid);     // Catch: Throwable -> L12
                r0.writeString(packageName);     // Catch: Throwable -> L12
                r0.writeString(processName);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onProcessStarted(pid, processUid, packageUid, packageName, processName);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.app.IProcessObserver
            public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(pid);     // Catch: Throwable -> L16
                r0.writeInt(uid);     // Catch: Throwable -> L16
                if (foregroundActivities == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onForegroundActivitiesChanged(pid, uid, foregroundActivities);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.app.IProcessObserver
            public void onForegroundServicesChanged(int pid, int uid, int serviceTypes) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(pid);     // Catch: Throwable -> L12
                r0.writeInt(uid);     // Catch: Throwable -> L12
                r0.writeInt(serviceTypes);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onForegroundServicesChanged(pid, uid, serviceTypes);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.app.IProcessObserver
            public void onProcessDied(int pid, int uid) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(pid);     // Catch: Throwable -> L12
                r0.writeInt(uid);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onProcessDied(pid, uid);     // Catch: Throwable -> L12
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

        public static IProcessObserver asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IProcessObserver) == false) goto L12;
            return (IProcessObserver) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            onProcessStarted(data.readInt(), data.readInt(), data.readInt(), data.readString(), data.readString());
            return true;
        L5:
            if (code != 2) goto L7;
            data.enforceInterface(DESCRIPTOR);
            int r8 = data.readInt();
            int r10 = data.readInt();
            if (data.readInt() == 0) goto L23;
            boolean r9 = true;
        L24:
            onForegroundActivitiesChanged(r8, r10, r9);
            return true;
        L23:
            r9 = false;
            goto L24
        L7:
            if (code != 3) goto L9;
            data.enforceInterface(DESCRIPTOR);
            onForegroundServicesChanged(data.readInt(), data.readInt(), data.readInt());
            return true;
        L9:
            if (code != 4) goto L11;
            data.enforceInterface(DESCRIPTOR);
            onProcessDied(data.readInt(), data.readInt());
            return true;
        L11:
            if (code != 1598968902) goto L13;
            reply.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(IProcessObserver impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IProcessObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) throws RemoteException;

    void onForegroundServicesChanged(int pid, int uid, int serviceTypes) throws RemoteException;

    void onProcessDied(int pid, int uid) throws RemoteException;

    void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) throws RemoteException;
}
