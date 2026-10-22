package org.codeaurora.wfcservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface IWFCServiceCB extends IInterface {
    public static final String DESCRIPTOR = "org.codeaurora.wfcservice.IWFCServiceCB";

    public static class Default implements IWFCServiceCB {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.codeaurora.wfcservice.IWFCServiceCB
        public void updateWFCMessage(String r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IWFCServiceCB {
        static final int TRANSACTION_updateWFCMessage = 1;

        private static class Proxy implements IWFCServiceCB {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWFCServiceCB.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // org.codeaurora.wfcservice.IWFCServiceCB
            public void updateWFCMessage(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWFCServiceCB.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWFCServiceCB.DESCRIPTOR);
        }

        public static IWFCServiceCB asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IWFCServiceCB.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IWFCServiceCB) == false) goto L12;
            return (IWFCServiceCB) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IWFCServiceCB.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            updateWFCMessage(r5.readString());
            r6.writeNoException();
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IWFCServiceCB.DESCRIPTOR);
            return true;
        }
    }

    void updateWFCMessage(String r1) throws RemoteException;
}
