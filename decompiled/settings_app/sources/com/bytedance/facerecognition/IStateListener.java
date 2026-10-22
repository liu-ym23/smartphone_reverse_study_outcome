package com.bytedance.facerecognition;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.facerecognition.IStateListener";

    public static class Default implements IStateListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationAcquired(int r1) throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationError(int r1, CharSequence r2) throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationFailed() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationHelp(int r1, CharSequence r2) throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationInit() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onAuthenticationSucceeded() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IStateListener
        public void onFingerprintLockoutReset() throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IStateListener {
        static final int TRANSACTION_onAuthenticationAcquired = 7;
        static final int TRANSACTION_onAuthenticationError = 2;
        static final int TRANSACTION_onAuthenticationFailed = 5;
        static final int TRANSACTION_onAuthenticationHelp = 3;
        static final int TRANSACTION_onAuthenticationInit = 1;
        static final int TRANSACTION_onAuthenticationSucceeded = 4;
        static final int TRANSACTION_onFingerprintLockoutReset = 6;

        private static class Proxy implements IStateListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IStateListener.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationInit() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationError(int r4, CharSequence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeInt(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                TextUtils.writeToParcel(r5, r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationHelp(int r4, CharSequence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeInt(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                TextUtils.writeToParcel(r5, r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationSucceeded() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationFailed() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IStateListener
            public void onFingerprintLockoutReset() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IStateListener
            public void onAuthenticationAcquired(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
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
            attachInterface(this, IStateListener.DESCRIPTOR);
        }

        public static IStateListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStateListener.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStateListener) == false) goto L12;
            return (IStateListener) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IStateListener.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            switch(r4) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            onAuthenticationAcquired(r5.readInt());
            r6.writeNoException();
        L19:
            return true;
        L13:
            onFingerprintLockoutReset();
            r6.writeNoException();
            goto L19
        L14:
            onAuthenticationFailed();
            r6.writeNoException();
            goto L19
        L15:
            onAuthenticationSucceeded();
            r6.writeNoException();
            goto L19
        L16:
            onAuthenticationHelp(r5.readInt(), (CharSequence) _Parcel.access$000(r5, TextUtils.CHAR_SEQUENCE_CREATOR));
            r6.writeNoException();
            goto L19
        L17:
            onAuthenticationError(r5.readInt(), (CharSequence) _Parcel.access$000(r5, TextUtils.CHAR_SEQUENCE_CREATOR));
            r6.writeNoException();
            goto L19
        L18:
            onAuthenticationInit();
            r6.writeNoException();
            goto L19
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(IStateListener.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        static /* synthetic */ Object access$000(Parcel r0, Parcelable.Creator r1) {
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

    void onAuthenticationAcquired(int r1) throws RemoteException;

    void onAuthenticationError(int r1, CharSequence r2) throws RemoteException;

    void onAuthenticationFailed() throws RemoteException;

    void onAuthenticationHelp(int r1, CharSequence r2) throws RemoteException;

    void onAuthenticationInit() throws RemoteException;

    void onAuthenticationSucceeded() throws RemoteException;

    void onFingerprintLockoutReset() throws RemoteException;
}
