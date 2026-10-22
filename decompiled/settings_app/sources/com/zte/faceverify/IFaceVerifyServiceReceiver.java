package com.zte.faceverify;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IFaceVerifyServiceReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.zte.faceverify.IFaceVerifyServiceReceiver";

    public static class Default implements IFaceVerifyServiceReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationError(int r1, String r2) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationFailed() throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationHelp(int r1, String r2) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationSucceeded(int r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFaceVerifyServiceReceiver {
        static final int TRANSACTION_onAuthenticationError = 3;
        static final int TRANSACTION_onAuthenticationFailed = 2;
        static final int TRANSACTION_onAuthenticationHelp = 4;
        static final int TRANSACTION_onAuthenticationSucceeded = 1;

        private static class Proxy implements IFaceVerifyServiceReceiver {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IFaceVerifyServiceReceiver.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
            public void onAuthenticationSucceeded(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyServiceReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
            public void onAuthenticationFailed() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyServiceReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
            public void onAuthenticationError(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyServiceReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
            public void onAuthenticationHelp(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyServiceReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IFaceVerifyServiceReceiver.DESCRIPTOR);
        }

        public static IFaceVerifyServiceReceiver asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IFaceVerifyServiceReceiver.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFaceVerifyServiceReceiver) == false) goto L12;
            return (IFaceVerifyServiceReceiver) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IFaceVerifyServiceReceiver.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L23;
            if (r4 != 1) goto L11;
            onAuthenticationSucceeded(r5.readInt());
            r6.writeNoException();
        L22:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onAuthenticationFailed();
            r6.writeNoException();
            goto L22
        L13:
            if (r4 != 3) goto L15;
            onAuthenticationError(r5.readInt(), r5.readString());
            r6.writeNoException();
            goto L22
        L15:
            if (r4 != 4) goto L17;
            onAuthenticationHelp(r5.readInt(), r5.readString());
            r6.writeNoException();
            goto L22
        L17:
            return super.onTransact(r4, r5, r6, r7);
        L23:
            r6.writeString(IFaceVerifyServiceReceiver.DESCRIPTOR);
            return true;
        }
    }

    void onAuthenticationError(int r1, String r2) throws RemoteException;

    void onAuthenticationFailed() throws RemoteException;

    void onAuthenticationHelp(int r1, String r2) throws RemoteException;

    void onAuthenticationSucceeded(int r1) throws RemoteException;
}
