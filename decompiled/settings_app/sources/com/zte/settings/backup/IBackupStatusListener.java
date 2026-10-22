package com.zte.settings.backup;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IBackupStatusListener extends IInterface {
    public static final String DESCRIPTOR = "com.zte.settings.backup.IBackupStatusListener";

    public static class Default implements IBackupStatusListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.settings.backup.IBackupStatusListener
        public void onBackupCompleted(int r1, String r2) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupStatusListener
        public void onBackupFailed(int r1, String r2) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupStatusListener
        public void onProgressChanged(int r1, int r2, int r3, String r4) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupStatusListener
        public void onRestoreCompleted(int r1) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupStatusListener
        public void onRestoreFailed(int r1, String r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IBackupStatusListener {
        static final int TRANSACTION_onBackupCompleted = 2;
        static final int TRANSACTION_onBackupFailed = 3;
        static final int TRANSACTION_onProgressChanged = 1;
        static final int TRANSACTION_onRestoreCompleted = 4;
        static final int TRANSACTION_onRestoreFailed = 5;

        private static class Proxy implements IBackupStatusListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IBackupStatusListener.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.settings.backup.IBackupStatusListener
            public void onProgressChanged(int r4, int r5, int r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupStatusListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupStatusListener
            public void onBackupCompleted(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupStatusListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupStatusListener
            public void onBackupFailed(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupStatusListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupStatusListener
            public void onRestoreCompleted(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupStatusListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupStatusListener
            public void onRestoreFailed(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupStatusListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBackupStatusListener.DESCRIPTOR);
        }

        public static IBackupStatusListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IBackupStatusListener.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBackupStatusListener) == false) goto L12;
            return (IBackupStatusListener) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IBackupStatusListener.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L26;
            if (r4 != 1) goto L11;
            onProgressChanged(r5.readInt(), r5.readInt(), r5.readInt(), r5.readString());
            r6.writeNoException();
        L25:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onBackupCompleted(r5.readInt(), r5.readString());
            r6.writeNoException();
            goto L25
        L13:
            if (r4 != 3) goto L15;
            onBackupFailed(r5.readInt(), r5.readString());
            r6.writeNoException();
            goto L25
        L15:
            if (r4 != 4) goto L17;
            onRestoreCompleted(r5.readInt());
            r6.writeNoException();
            goto L25
        L17:
            if (r4 != 5) goto L19;
            onRestoreFailed(r5.readInt(), r5.readString());
            r6.writeNoException();
            goto L25
        L19:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            r6.writeString(IBackupStatusListener.DESCRIPTOR);
            return true;
        }
    }

    void onBackupCompleted(int r1, String r2) throws RemoteException;

    void onBackupFailed(int r1, String r2) throws RemoteException;

    void onProgressChanged(int r1, int r2, int r3, String r4) throws RemoteException;

    void onRestoreCompleted(int r1) throws RemoteException;

    void onRestoreFailed(int r1, String r2) throws RemoteException;
}
