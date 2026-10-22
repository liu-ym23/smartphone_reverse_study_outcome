package com.obric.smsparser.risk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ISmsRiskService extends IInterface {

    public static class Default implements ISmsRiskService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.smsparser.risk.ISmsRiskService
        public void queryRisk(SmsRiskQueryParam r1, ISmsRiskCallback r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISmsRiskService {
        private static final String DESCRIPTOR = "com.obric.smsparser.risk.ISmsRiskService";
        static final int TRANSACTION_queryRisk = 1;

        private static class Proxy implements ISmsRiskService {
            public static ISmsRiskService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.smsparser.risk.ISmsRiskService
            public void queryRisk(SmsRiskQueryParam r5, ISmsRiskCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r6 == null) goto L10;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().queryRisk(r5, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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
            attachInterface(this, DESCRIPTOR);
        }

        public static ISmsRiskService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISmsRiskService) == false) goto L12;
            return (ISmsRiskService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            SmsRiskQueryParam r8 = SmsRiskQueryParam.CREATOR.createFromParcel(r5);
        L14:
            queryRisk(r8, ISmsRiskCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(ISmsRiskService r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISmsRiskService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void queryRisk(SmsRiskQueryParam r1, ISmsRiskCallback r2) throws RemoteException;
}
