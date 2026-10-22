package com.zte.board.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IBoardEngineCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zte.board.engine.IBoardEngineCallback";

    public static class Default implements IBoardEngineCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.board.engine.IBoardEngineCallback
        public void onSomeStateReported(int r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IBoardEngineCallback {
        static final int TRANSACTION_onSomeStateReported = 1;

        private static class Proxy implements IBoardEngineCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IBoardEngineCallback.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.board.engine.IBoardEngineCallback
            public void onSomeStateReported(int r3) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngineCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBoardEngineCallback.DESCRIPTOR);
        }

        public static IBoardEngineCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IBoardEngineCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBoardEngineCallback) == false) goto L12;
            return (IBoardEngineCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IBoardEngineCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onSomeStateReported(r5.readInt());
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IBoardEngineCallback.DESCRIPTOR);
            return true;
        }
    }

    void onSomeStateReported(int r1) throws RemoteException;
}
