package com.zte.faceverify;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IFaceVerifyService extends IInterface {
    public static final String DESCRIPTOR = "com.zte.faceverify.IFaceVerifyService";

    public static class Default implements IFaceVerifyService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public void authenticate(IBinder r1, long r2, int r4, IFaceVerifyServiceReceiver r5, int r6, String r7) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public void cancelAuthentication(IBinder r1, String r2) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public int getFaceCount() throws RemoteException {
            return 0;
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public boolean isSpecSwitchOpen(String r1) throws RemoteException {
            return false;
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public void setSpecSwitchState(String r1, boolean r2, String r3) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public void setWindowPosition(int r1, int r2) throws RemoteException {
        }

        @Override // com.zte.faceverify.IFaceVerifyService
        public void updateMultiAuthenticator() throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFaceVerifyService {
        static final int TRANSACTION_authenticate = 1;
        static final int TRANSACTION_cancelAuthentication = 2;
        static final int TRANSACTION_getFaceCount = 3;
        static final int TRANSACTION_isSpecSwitchOpen = 4;
        static final int TRANSACTION_setSpecSwitchState = 5;
        static final int TRANSACTION_setWindowPosition = 7;
        static final int TRANSACTION_updateMultiAuthenticator = 6;

        private static class Proxy implements IFaceVerifyService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IFaceVerifyService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.faceverify.IFaceVerifyService
            public void authenticate(IBinder r4, long r5, int r7, IFaceVerifyServiceReceiver r8, int r9, String r10) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L6
                r0.writeLong(r5);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                r0.writeInt(r9);     // Catch: Throwable -> L6
                r0.writeString(r10);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyService
            public void cancelAuthentication(IBinder r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyService
            public int getFaceCount() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyService
            public boolean isSpecSwitchOpen(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.zte.faceverify.IFaceVerifyService
            public void setSpecSwitchState(String r4, boolean r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r7 = 1;
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L10
                r0.writeString(r6);     // Catch: Throwable -> L10
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r7 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.faceverify.IFaceVerifyService
            public void updateMultiAuthenticator() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.zte.faceverify.IFaceVerifyService
            public void setWindowPosition(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceVerifyService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IFaceVerifyService.DESCRIPTOR);
        }

        public static IFaceVerifyService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IFaceVerifyService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFaceVerifyService) == false) goto L12;
            return (IFaceVerifyService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface(IFaceVerifyService.DESCRIPTOR);
        L8:
            if (r11 == 1598968902) goto L24;
            switch(r11) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            setWindowPosition(r12.readInt(), r12.readInt());
            r13.writeNoException();
        L23:
            return true;
        L13:
            updateMultiAuthenticator();
            r13.writeNoException();
            goto L23
        L14:
            String r15 = r12.readString();
            if (r12.readInt() == 0) goto L17;
            boolean r16 = true;
        L18:
            setSpecSwitchState(r15, r16, r12.readString());
            r13.writeNoException();
            goto L23
        L17:
            r16 = false;
            goto L18
        L19:
            boolean r10 = isSpecSwitchOpen(r12.readString());
            r13.writeNoException();
            r13.writeInt(r10 ? 1 : 0);
            goto L23
        L20:
            int r17 = getFaceCount();
            r13.writeNoException();
            r13.writeInt(r17);
            goto L23
        L21:
            cancelAuthentication(r12.readStrongBinder(), r12.readString());
            r13.writeNoException();
            goto L23
        L22:
            authenticate(r12.readStrongBinder(), r12.readLong(), r12.readInt(), IFaceVerifyServiceReceiver.Stub.asInterface(r12.readStrongBinder()), r12.readInt(), r12.readString());
            r13.writeNoException();
            goto L23
        L11:
            return super.onTransact(r11, r12, r13, r14);
        L24:
            r13.writeString(IFaceVerifyService.DESCRIPTOR);
            return true;
        }
    }

    void authenticate(IBinder r1, long r2, int r4, IFaceVerifyServiceReceiver r5, int r6, String r7) throws RemoteException;

    void cancelAuthentication(IBinder r1, String r2) throws RemoteException;

    int getFaceCount() throws RemoteException;

    boolean isSpecSwitchOpen(String r1) throws RemoteException;

    void setSpecSwitchState(String r1, boolean r2, String r3) throws RemoteException;

    void setWindowPosition(int r1, int r2) throws RemoteException;

    void updateMultiAuthenticator() throws RemoteException;
}
