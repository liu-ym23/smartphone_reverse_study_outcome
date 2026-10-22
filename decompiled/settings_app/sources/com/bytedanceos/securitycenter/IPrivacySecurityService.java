package com.bytedanceos.securitycenter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IPrivacySecurityService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedanceos.securitycenter.IPrivacySecurityService";

    public static class Default implements IPrivacySecurityService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public boolean checkPassword(String r1) throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void disableSecurity() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public long getCloudIdLockoutCountdown() throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public long getFaceIdLockoutCountdown() throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public long getFingerprintLockoutCountdown() throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public long getPinLockoutCountdown() throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public boolean isCloudIdUnlockOn() throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public boolean isFaceIdUnlockOn() throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public boolean isFingerprintUnlockOn() throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public boolean isSecurityOn() throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void lockoutCloudId() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void lockoutFaceId() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void lockoutFingerprint() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void lockoutPin() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void revokeLockout() throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void setCloudIdUnlock(boolean r1) throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void setFaceIdUnlock(boolean r1) throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void setFingerprintUnlock(boolean r1) throws RemoteException {
        }

        @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
        public void setPassword(String r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IPrivacySecurityService {
        static final int TRANSACTION_checkPassword = 2;
        static final int TRANSACTION_disableSecurity = 4;
        static final int TRANSACTION_getCloudIdLockoutCountdown = 18;
        static final int TRANSACTION_getFaceIdLockoutCountdown = 17;
        static final int TRANSACTION_getFingerprintLockoutCountdown = 16;
        static final int TRANSACTION_getPinLockoutCountdown = 19;
        static final int TRANSACTION_isCloudIdUnlockOn = 10;
        static final int TRANSACTION_isFaceIdUnlockOn = 9;
        static final int TRANSACTION_isFingerprintUnlockOn = 8;
        static final int TRANSACTION_isSecurityOn = 1;
        static final int TRANSACTION_lockoutCloudId = 13;
        static final int TRANSACTION_lockoutFaceId = 12;
        static final int TRANSACTION_lockoutFingerprint = 11;
        static final int TRANSACTION_lockoutPin = 14;
        static final int TRANSACTION_revokeLockout = 15;
        static final int TRANSACTION_setCloudIdUnlock = 7;
        static final int TRANSACTION_setFaceIdUnlock = 6;
        static final int TRANSACTION_setFingerprintUnlock = 5;
        static final int TRANSACTION_setPassword = 3;

        private static class Proxy implements IPrivacySecurityService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IPrivacySecurityService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public boolean isSecurityOn() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public boolean checkPassword(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void setPassword(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void disableSecurity() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void setFingerprintUnlock(boolean r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void setFaceIdUnlock(boolean r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void setCloudIdUnlock(boolean r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public boolean isFingerprintUnlockOn() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public boolean isFaceIdUnlockOn() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public boolean isCloudIdUnlockOn() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void lockoutFingerprint() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void lockoutFaceId() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void lockoutCloudId() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void lockoutPin() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public void revokeLockout() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public long getFingerprintLockoutCountdown() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public long getFaceIdLockoutCountdown() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(17, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public long getCloudIdLockoutCountdown() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(18, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.securitycenter.IPrivacySecurityService
            public long getPinLockoutCountdown() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPrivacySecurityService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(19, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
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
            attachInterface(this, IPrivacySecurityService.DESCRIPTOR);
        }

        public static IPrivacySecurityService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IPrivacySecurityService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IPrivacySecurityService) == false) goto L12;
            return (IPrivacySecurityService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IPrivacySecurityService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L42;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L40;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L30;
                case 7: goto L26;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L15;
                case 18: goto L14;
                case 19: goto L13;
                default: goto L12;
            };
        L13:
            long r3 = getPinLockoutCountdown();
            r6.writeNoException();
            r6.writeLong(r3);
        L41:
            return true;
        L14:
            long r8 = getCloudIdLockoutCountdown();
            r6.writeNoException();
            r6.writeLong(r8);
            goto L41
        L15:
            long r9 = getFaceIdLockoutCountdown();
            r6.writeNoException();
            r6.writeLong(r9);
            goto L41
        L16:
            long r10 = getFingerprintLockoutCountdown();
            r6.writeNoException();
            r6.writeLong(r10);
            goto L41
        L17:
            revokeLockout();
            r6.writeNoException();
            goto L41
        L18:
            lockoutPin();
            r6.writeNoException();
            goto L41
        L19:
            lockoutCloudId();
            r6.writeNoException();
            goto L41
        L20:
            lockoutFaceId();
            r6.writeNoException();
            goto L41
        L21:
            lockoutFingerprint();
            r6.writeNoException();
            goto L41
        L22:
            boolean r11 = isCloudIdUnlockOn();
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            goto L41
        L23:
            boolean r12 = isFaceIdUnlockOn();
            r6.writeNoException();
            r6.writeInt(r12 ? 1 : 0);
            goto L41
        L24:
            boolean r13 = isFingerprintUnlockOn();
            r6.writeNoException();
            r6.writeInt(r13 ? 1 : 0);
            goto L41
        L37:
            disableSecurity();
            r6.writeNoException();
            goto L41
        L38:
            setPassword(r5.readString());
            r6.writeNoException();
            goto L41
        L39:
            boolean r14 = checkPassword(r5.readString());
            r6.writeNoException();
            r6.writeInt(r14 ? 1 : 0);
            goto L41
        L40:
            boolean r15 = isSecurityOn();
            r6.writeNoException();
            r6.writeInt(r15 ? 1 : 0);
            goto L41
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            if (r5.readInt() == 0) goto L28;
            r0 = true;
        L28:
            setCloudIdUnlock(r0);
            r6.writeNoException();
            goto L41
        L30:
            if (r5.readInt() == 0) goto L32;
            r0 = true;
        L32:
            setFaceIdUnlock(r0);
            r6.writeNoException();
            goto L41
        L34:
            if (r5.readInt() == 0) goto L36;
            r0 = true;
        L36:
            setFingerprintUnlock(r0);
            r6.writeNoException();
            goto L41
        L42:
            r6.writeString(IPrivacySecurityService.DESCRIPTOR);
            return true;
        }
    }

    boolean checkPassword(String r1) throws RemoteException;

    void disableSecurity() throws RemoteException;

    long getCloudIdLockoutCountdown() throws RemoteException;

    long getFaceIdLockoutCountdown() throws RemoteException;

    long getFingerprintLockoutCountdown() throws RemoteException;

    long getPinLockoutCountdown() throws RemoteException;

    boolean isCloudIdUnlockOn() throws RemoteException;

    boolean isFaceIdUnlockOn() throws RemoteException;

    boolean isFingerprintUnlockOn() throws RemoteException;

    boolean isSecurityOn() throws RemoteException;

    void lockoutCloudId() throws RemoteException;

    void lockoutFaceId() throws RemoteException;

    void lockoutFingerprint() throws RemoteException;

    void lockoutPin() throws RemoteException;

    void revokeLockout() throws RemoteException;

    void setCloudIdUnlock(boolean r1) throws RemoteException;

    void setFaceIdUnlock(boolean r1) throws RemoteException;

    void setFingerprintUnlock(boolean r1) throws RemoteException;

    void setPassword(String r1) throws RemoteException;
}
