package com.bytedanceos.tencent;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICallback extends IInterface {
    public static final String DESCRIPTOR = "com.bytedanceos.tencent.ICallback";

    public static class Default implements ICallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.tencent.ICallback
        public void onCorrectionResult(int r1, int r2) throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ICallback
        public void onError(int r1, int r2) throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ICallback
        public void onNeedSmsCorrection(int r1, String r2, String r3) throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ICallback
        public void onNotifyTimeOut(int r1) throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ICallback
        public void onTrafficInfoNotify(int r1, int[] r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICallback {
        static final int TRANSACTION_onCorrectionResult = 3;
        static final int TRANSACTION_onError = 4;
        static final int TRANSACTION_onNeedSmsCorrection = 1;
        static final int TRANSACTION_onNotifyTimeOut = 5;
        static final int TRANSACTION_onTrafficInfoNotify = 2;

        private static class Proxy implements ICallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return ICallback.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.tencent.ICallback
            public void onNeedSmsCorrection(int r4, String r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.tencent.ICallback
            public void onTrafficInfoNotify(int r4, int[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeIntArray(r5);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.tencent.ICallback
            public void onCorrectionResult(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.tencent.ICallback
            public void onError(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.tencent.ICallback
            public void onNotifyTimeOut(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
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
            attachInterface(this, ICallback.DESCRIPTOR);
        }

        public static ICallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICallback) == false) goto L12;
            return (ICallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L26;
            if (r4 != 1) goto L11;
            onNeedSmsCorrection(r5.readInt(), r5.readString(), r5.readString());
            r6.writeNoException();
        L25:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onTrafficInfoNotify(r5.readInt(), r5.createIntArray());
            r6.writeNoException();
            goto L25
        L13:
            if (r4 != 3) goto L15;
            onCorrectionResult(r5.readInt(), r5.readInt());
            r6.writeNoException();
            goto L25
        L15:
            if (r4 != 4) goto L17;
            onError(r5.readInt(), r5.readInt());
            r6.writeNoException();
            goto L25
        L17:
            if (r4 != 5) goto L19;
            onNotifyTimeOut(r5.readInt());
            r6.writeNoException();
            goto L25
        L19:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            r6.writeString(ICallback.DESCRIPTOR);
            return true;
        }
    }

    void onCorrectionResult(int r1, int r2) throws RemoteException;

    void onError(int r1, int r2) throws RemoteException;

    void onNeedSmsCorrection(int r1, String r2, String r3) throws RemoteException;

    void onNotifyTimeOut(int r1) throws RemoteException;

    void onTrafficInfoNotify(int r1, int[] r2) throws RemoteException;
}
