package com.bytedance.facerecognition;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IFaceRecognition extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.facerecognition.IFaceRecognition";

    public static class Default implements IFaceRecognition {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void deleteFaceData() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void init() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public boolean isFaceDataExist() throws RemoteException {
            return false;
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void release() throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void setStateListener(IStateListener r1) throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void switchDetectFace(boolean r1) throws RemoteException {
        }

        @Override // com.bytedance.facerecognition.IFaceRecognition
        public void updateFaceIdListeningState(boolean r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFaceRecognition {
        static final int TRANSACTION_deleteFaceData = 4;
        static final int TRANSACTION_init = 5;
        static final int TRANSACTION_isFaceDataExist = 3;
        static final int TRANSACTION_release = 6;
        static final int TRANSACTION_setStateListener = 2;
        static final int TRANSACTION_switchDetectFace = 7;
        static final int TRANSACTION_updateFaceIdListeningState = 1;

        private static class Proxy implements IFaceRecognition {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IFaceRecognition.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void updateFaceIdListeningState(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void setStateListener(IStateListener r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public boolean isFaceDataExist() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void deleteFaceData() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void init() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void release() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.facerecognition.IFaceRecognition
            public void switchDetectFace(boolean r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IFaceRecognition.DESCRIPTOR);     // Catch: Throwable -> L10
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IFaceRecognition.DESCRIPTOR);
        }

        public static IFaceRecognition asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IFaceRecognition.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFaceRecognition) == false) goto L12;
            return (IFaceRecognition) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IFaceRecognition.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L27;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L14;
                default: goto L12;
            };
        L17:
            release();
            r6.writeNoException();
        L26:
            return true;
        L18:
            init();
            r6.writeNoException();
            goto L26
        L19:
            deleteFaceData();
            r6.writeNoException();
            goto L26
        L20:
            boolean r3 = isFaceDataExist();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L26
        L21:
            setStateListener(IStateListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L26
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            if (r5.readInt() == 0) goto L16;
            r0 = true;
        L16:
            switchDetectFace(r0);
            r6.writeNoException();
            goto L26
        L23:
            if (r5.readInt() == 0) goto L25;
            r0 = true;
        L25:
            updateFaceIdListeningState(r0);
            r6.writeNoException();
            goto L26
        L27:
            r6.writeString(IFaceRecognition.DESCRIPTOR);
            return true;
        }
    }

    void deleteFaceData() throws RemoteException;

    void init() throws RemoteException;

    boolean isFaceDataExist() throws RemoteException;

    void release() throws RemoteException;

    void setStateListener(IStateListener r1) throws RemoteException;

    void switchDetectFace(boolean r1) throws RemoteException;

    void updateFaceIdListeningState(boolean r1) throws RemoteException;
}
