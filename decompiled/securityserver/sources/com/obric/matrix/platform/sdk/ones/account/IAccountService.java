package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountService extends IInterface {

    public static class Default implements IAccountService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void checkPassword(String r1, IAccountActionCallback r2) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void forceUpdateAccount() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void login(PendingIntent r1) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void loginWithPassword(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void logout(IAccountActionCallback r1) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void quickLogin(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void sendCode(String r1, int r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void setInitPassword(String r1, IAccountActionCallback r2) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updatePassword(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void uploadAvatar(String r1, IAccountActionCallback r2) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPassword(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) {
        }
    }

    public static abstract class Stub extends Binder implements IAccountService {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountService";
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

        public static class Proxy implements IAccountService {
            public static IAccountService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r5, IAccountActionCallback r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                if (r6 == null) goto L8;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().checkPassword(r5, r6);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().forceUpdateAccount();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().login(r5);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().loginWithPassword(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().logout(r5);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().quickLogin(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r5, String r6, String r7, IAccountActionCallback r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                if (r8 == null) goto L8;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().resetPassword(r5, r6, r7, r8);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r5, int r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().sendCode(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r5, IAccountActionCallback r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                if (r6 == null) goto L8;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().setInitPassword(r5, r6);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().ticketResetPassword(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().updatePassword(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L12;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L6
            L13:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L6
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L16;
            L20:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().updateUserInfo(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                r3 = null;
                goto L13
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r5, IAccountActionCallback r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                if (r6 == null) goto L8;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().uploadAvatar(r5, r6);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().verifyPassword(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r5, String r6, IAccountActionCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().verifyPasswordWithoutLogin(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r5, String r6, int r7, IAccountActionCallback r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                if (r8 == null) goto L8;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().verifySmsCode(r5, r6, r7, r8);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAccountService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountService) == false) goto L12;
            return (IAccountService) r0;
        L12:
            return new Proxy(r2);
        }

        public static IAccountService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAccountService r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L46;
            PendingIntent r0 = null;
            Bundle r1 = null;
            switch(r4) {
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L26;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L20;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L14;
                case 14: goto L12;
                case 15: goto L10;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            verifyPasswordWithoutLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            verifyPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            resetPassword(r5.readString(), r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            updatePassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L16:
            r5.enforceInterface(DESCRIPTOR);
            checkPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            setInitPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L20:
            r5.enforceInterface(DESCRIPTOR);
            ticketResetPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L22:
            r5.enforceInterface(DESCRIPTOR);
            verifySmsCode(r5.readString(), r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L24:
            r5.enforceInterface(DESCRIPTOR);
            loginWithPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L26:
            r5.enforceInterface(DESCRIPTOR);
            uploadAvatar(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L28:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L31;
            r1 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L31:
            updateUserInfo(r1, r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            quickLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            sendCode(r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            forceUpdateAccount();
            r6.writeNoException();
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            logout(IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L44;
            r0 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r5);
        L44:
            login(r0);
            r6.writeNoException();
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L46:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void checkPassword(String r1, IAccountActionCallback r2);

    void forceUpdateAccount();

    void login(PendingIntent r1);

    void loginWithPassword(String r1, String r2, IAccountActionCallback r3);

    void logout(IAccountActionCallback r1);

    void quickLogin(String r1, String r2, IAccountActionCallback r3);

    void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4);

    void sendCode(String r1, int r2, IAccountActionCallback r3);

    void setInitPassword(String r1, IAccountActionCallback r2);

    void ticketResetPassword(String r1, String r2, IAccountActionCallback r3);

    void updatePassword(String r1, String r2, IAccountActionCallback r3);

    void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3);

    void uploadAvatar(String r1, IAccountActionCallback r2);

    void verifyPassword(String r1, String r2, IAccountActionCallback r3);

    void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3);

    void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4);
}
