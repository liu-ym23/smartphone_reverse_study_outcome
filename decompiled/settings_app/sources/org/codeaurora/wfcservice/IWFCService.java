package org.codeaurora.wfcservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes6.dex */
public interface IWFCService extends IInterface {
    public static final String DESCRIPTOR = "org.codeaurora.wfcservice.IWFCService";

    public static class Default implements IWFCService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.codeaurora.wfcservice.IWFCService
        public void registerCallback(IWFCServiceCB r1) throws RemoteException {
        }

        @Override // org.codeaurora.wfcservice.IWFCService
        public void unregisterCallback(IWFCServiceCB r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IWFCService {
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IWFCService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWFCService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // org.codeaurora.wfcservice.IWFCService
            public void registerCallback(IWFCServiceCB r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWFCService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
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

            @Override // org.codeaurora.wfcservice.IWFCService
            public void unregisterCallback(IWFCServiceCB r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWFCService.DESCRIPTOR);     // Catch: Throwable -> L6
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWFCService.DESCRIPTOR);
        }

        public static IWFCService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IWFCService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IWFCService) == false) goto L12;
            return (IWFCService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IWFCService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            registerCallback(IWFCServiceCB.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterCallback(IWFCServiceCB.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(IWFCService.DESCRIPTOR);
            return true;
        }
    }

    void registerCallback(IWFCServiceCB r1) throws RemoteException;

    void unregisterCallback(IWFCServiceCB r1) throws RemoteException;
}
