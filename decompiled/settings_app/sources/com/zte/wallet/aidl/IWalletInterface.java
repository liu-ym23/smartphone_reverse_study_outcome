package com.zte.wallet.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IWalletInterface extends IInterface {
    public static final int ACCESS_NOT_ALLOWED = -10;
    public static final int ACCOUNT_ABNORMAL = -5;
    public static final String DESCRIPTOR = "com.zte.wallet.aidl.IWalletInterface";
    public static final int ERROR = -99;
    public static final int JSON_ERROR = -1;
    public static final int JSON_NULL = -2;
    public static final int NETWORK_ERROR = -4;
    public static final int NO_PERMISSION = -6;
    public static final int PARAMETER_ERROR = -8;
    public static final String RESULT_CODE = "result_code";
    public static final String RESULT_DATA = "result_data";
    public static final int RESULT_SUCCESS = 1000;
    public static final int SERVER_ERROR = 5000;
    public static final int SESSION_ILLEGAL = 4003;
    public static final int SOCKET_TIMEOUT = -3;
    public static final int USER_HAS_NOT_AGREED_POLICY = -10;

    public static class Default implements IWalletInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public int getCardCount() throws RemoteException {
            return 0;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public int getServiceVersion() throws RemoteException {
            return 0;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public Bundle queryCardNames() throws RemoteException {
            return null;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public Bundle queryInstalled() throws RemoteException {
            return null;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public Bundle queryShiftedZte() throws RemoteException {
            return null;
        }

        @Override // com.zte.wallet.aidl.IWalletInterface
        public Bundle tryClearAllCards() throws RemoteException {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IWalletInterface {
        static final int TRANSACTION_getCardCount = 2;
        static final int TRANSACTION_getServiceVersion = 1;
        static final int TRANSACTION_queryCardNames = 5;
        static final int TRANSACTION_queryInstalled = 3;
        static final int TRANSACTION_queryShiftedZte = 4;
        static final int TRANSACTION_tryClearAllCards = 6;

        private static class Proxy implements IWalletInterface {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWalletInterface.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public int getServiceVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public int getCardCount() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public Bundle queryInstalled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Bundle r4 = (Bundle) _Parcel.access$100(r1, Bundle.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public Bundle queryShiftedZte() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Bundle r4 = (Bundle) _Parcel.access$100(r1, Bundle.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public Bundle queryCardNames() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Bundle r4 = (Bundle) _Parcel.access$100(r1, Bundle.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.wallet.aidl.IWalletInterface
            public Bundle tryClearAllCards() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWalletInterface.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Bundle r4 = (Bundle) _Parcel.access$100(r1, Bundle.CREATOR);     // Catch: Throwable -> L6
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
            attachInterface(this, IWalletInterface.DESCRIPTOR);
        }

        public static IWalletInterface asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IWalletInterface.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IWalletInterface) == false) goto L12;
            return (IWalletInterface) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IWalletInterface.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            Bundle r3 = tryClearAllCards();
            r6.writeNoException();
            _Parcel.access$000(r6, r3, 1);
        L18:
            return true;
        L13:
            Bundle r8 = queryCardNames();
            r6.writeNoException();
            _Parcel.access$000(r6, r8, 1);
            goto L18
        L14:
            Bundle r9 = queryShiftedZte();
            r6.writeNoException();
            _Parcel.access$000(r6, r9, 1);
            goto L18
        L15:
            Bundle r10 = queryInstalled();
            r6.writeNoException();
            _Parcel.access$000(r6, r10, 1);
            goto L18
        L16:
            int r11 = getCardCount();
            r6.writeNoException();
            r6.writeInt(r11);
            goto L18
        L17:
            int r12 = getServiceVersion();
            r6.writeNoException();
            r6.writeInt(r12);
            goto L18
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString(IWalletInterface.DESCRIPTOR);
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

    int getCardCount() throws RemoteException;

    int getServiceVersion() throws RemoteException;

    Bundle queryCardNames() throws RemoteException;

    Bundle queryInstalled() throws RemoteException;

    Bundle queryShiftedZte() throws RemoteException;

    Bundle tryClearAllCards() throws RemoteException;
}
