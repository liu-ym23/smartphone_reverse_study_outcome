package com.zte.settings.backup;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IBackupController extends IInterface {
    public static final String DESCRIPTOR = "com.zte.settings.backup.IBackupController";

    public static class Default implements IBackupController {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.settings.backup.IBackupController
        public void cancelBackup(String r1) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupController
        public void cancelRestore(String r1) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupController
        public void deleteData(String r1) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupController
        public SettingsEntry getSettingsEntry() throws RemoteException {
            return null;
        }

        @Override // com.zte.settings.backup.IBackupController
        public void setPauseBackup(boolean r1, String r2) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupController
        public void setPauseRestore(boolean r1, String r2) throws RemoteException {
        }

        @Override // com.zte.settings.backup.IBackupController
        public boolean startBackup(int r1, String r2, IBackupStatusListener r3) throws RemoteException {
            return false;
        }

        @Override // com.zte.settings.backup.IBackupController
        public boolean startRestore(int r1, String r2, String r3, IBackupStatusListener r4) throws RemoteException {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IBackupController {
        static final int TRANSACTION_cancelBackup = 3;
        static final int TRANSACTION_cancelRestore = 6;
        static final int TRANSACTION_deleteData = 8;
        static final int TRANSACTION_getSettingsEntry = 1;
        static final int TRANSACTION_setPauseBackup = 4;
        static final int TRANSACTION_setPauseRestore = 7;
        static final int TRANSACTION_startBackup = 2;
        static final int TRANSACTION_startRestore = 5;

        private static class Proxy implements IBackupController {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IBackupController.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.settings.backup.IBackupController
            public SettingsEntry getSettingsEntry() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                SettingsEntry r4 = (SettingsEntry) _Parcel.access$100(r1, SettingsEntry.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.settings.backup.IBackupController
            public boolean startBackup(int r4, String r5, IBackupStatusListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                r0.writeString(r5);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L8
                boolean r7 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r7 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r7;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.settings.backup.IBackupController
            public void cancelBackup(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupController
            public void setPauseBackup(boolean r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.settings.backup.IBackupController
            public boolean startRestore(int r4, String r5, String r6, IBackupStatusListener r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                r0.writeString(r5);     // Catch: Throwable -> L8
                r0.writeString(r6);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L8
                boolean r8 = false;
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r8 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.settings.backup.IBackupController
            public void cancelRestore(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.zte.settings.backup.IBackupController
            public void setPauseRestore(boolean r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.settings.backup.IBackupController
            public void deleteData(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBackupController.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IBackupController.DESCRIPTOR);
        }

        public static IBackupController asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IBackupController.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBackupController) == false) goto L12;
            return (IBackupController) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IBackupController.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L28;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L15;
                case 8: goto L13;
                default: goto L12;
            };
        L13:
            deleteData(r5.readString());
            r6.writeNoException();
        L27:
            return true;
        L18:
            cancelRestore(r5.readString());
            r6.writeNoException();
            goto L27
        L19:
            boolean r3 = startRestore(r5.readInt(), r5.readString(), r5.readString(), IBackupStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L27
        L24:
            cancelBackup(r5.readString());
            r6.writeNoException();
            goto L27
        L25:
            boolean r8 = startBackup(r5.readInt(), r5.readString(), IBackupStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            goto L27
        L26:
            SettingsEntry r9 = getSettingsEntry();
            r6.writeNoException();
            _Parcel.access$000(r6, r9, 1);
            goto L27
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L15:
            if (r5.readInt() == 0) goto L17;
            r0 = true;
        L17:
            setPauseRestore(r0, r5.readString());
            r6.writeNoException();
            goto L27
        L21:
            if (r5.readInt() == 0) goto L23;
            r0 = true;
        L23:
            setPauseBackup(r0, r5.readString());
            r6.writeNoException();
            goto L27
        L28:
            r6.writeString(IBackupController.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        static /* synthetic */ void access$000(Parcel r0, Parcelable r1, int r2) {
            writeTypedObject(r0, r1, r2);
        }

        static /* synthetic */ Object access$100(Parcel r0, Parcelable.Creator r1) {
            return readTypedObject(r0, r1);
        }

        private static <T> T readTypedObject(Parcel r1, Parcelable.Creator<T> r2) {
            if (r1.readInt() != 0) goto L5;
            return null;
        L5:
            return r2.createFromParcel(r1);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r1, T r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    void cancelBackup(String r1) throws RemoteException;

    void cancelRestore(String r1) throws RemoteException;

    void deleteData(String r1) throws RemoteException;

    SettingsEntry getSettingsEntry() throws RemoteException;

    void setPauseBackup(boolean r1, String r2) throws RemoteException;

    void setPauseRestore(boolean r1, String r2) throws RemoteException;

    boolean startBackup(int r1, String r2, IBackupStatusListener r3) throws RemoteException;

    boolean startRestore(int r1, String r2, String r3, IBackupStatusListener r4) throws RemoteException;
}
