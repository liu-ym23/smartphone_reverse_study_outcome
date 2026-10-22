package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountService";

    public static class Default implements IAccountService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void checkPassword(String r1, IAccountActionCallback r2) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void forceUpdateAccount() throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void login(PendingIntent r1) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void loginWithPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void logout(IAccountActionCallback r1) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void quickLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void sendCode(String r1, int r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void setInitPassword(String r1, IAccountActionCallback r2) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updatePassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void uploadAvatar(String r1, IAccountActionCallback r2) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAccountService {
        static final int TRANSACTION_checkPassword = 12;
        static final int TRANSACTION_forceUpdateAccount = 3;
        static final int TRANSACTION_login = 1;
        static final int TRANSACTION_loginWithPassword = 8;
        static final int TRANSACTION_logout = 2;
        static final int TRANSACTION_quickLogin = 5;
        static final int TRANSACTION_resetPassword = 14;
        static final int TRANSACTION_sendCode = 4;
        static final int TRANSACTION_setInitPassword = 11;
        static final int TRANSACTION_ticketResetPassword = 10;
        static final int TRANSACTION_updatePassword = 13;
        static final int TRANSACTION_updateUserInfo = 6;
        static final int TRANSACTION_uploadAvatar = 7;
        static final int TRANSACTION_verifyPassword = 15;
        static final int TRANSACTION_verifyPasswordWithoutLogin = 16;
        static final int TRANSACTION_verifySmsCode = 9;

        private static class Proxy implements IAccountService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAccountService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.access$100(r0, r4, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r4, int r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.access$100(r0, r4, 0);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r4, String r5, int r6, IAccountActionCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r4, String r5, String r6, IAccountActionCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IAccountService.DESCRIPTOR);
        }

        public static IAccountService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAccountService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountService) == false) goto L12;
            return (IAccountService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAccountService.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IAccountService.DESCRIPTOR);
            return true;
        L11:
            switch(r4) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L14;
                default: goto L13;
            };
        L14:
            verifyPasswordWithoutLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L30:
            return true;
        L15:
            verifyPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L16:
            resetPassword(r5.readString(), r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L17:
            updatePassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L18:
            checkPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L19:
            setInitPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L20:
            ticketResetPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L21:
            verifySmsCode(r5.readString(), r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L22:
            loginWithPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L23:
            uploadAvatar(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L24:
            updateUserInfo((Bundle) _Parcel.access$000(r5, Bundle.CREATOR), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L25:
            quickLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L26:
            sendCode(r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L27:
            forceUpdateAccount();
            r6.writeNoException();
            goto L30
        L28:
            logout(IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L29:
            login((PendingIntent) _Parcel.access$000(r5, PendingIntent.CREATOR));
            r6.writeNoException();
            goto L30
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        static /* synthetic */ Object access$000(Parcel r0, Parcelable.Creator r1) {
            return readTypedObject(r0, r1);
        }

        static /* synthetic */ void access$100(Parcel r0, Parcelable r1, int r2) {
            writeTypedObject(r0, r1, r2);
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

    void checkPassword(String r1, IAccountActionCallback r2) throws RemoteException;

    void forceUpdateAccount() throws RemoteException;

    void login(PendingIntent r1) throws RemoteException;

    void loginWithPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void logout(IAccountActionCallback r1) throws RemoteException;

    void quickLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) throws RemoteException;

    void sendCode(String r1, int r2, IAccountActionCallback r3) throws RemoteException;

    void setInitPassword(String r1, IAccountActionCallback r2) throws RemoteException;

    void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void updatePassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void uploadAvatar(String r1, IAccountActionCallback r2) throws RemoteException;

    void verifyPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) throws RemoteException;
}
