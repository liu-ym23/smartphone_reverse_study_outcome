package com.obric.matrix.push.common.cross_process;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrossProcessCallbackInterface extends IInterface {

    public static class Default implements ICrossProcessCallbackInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface
        public void onCallBack(List r1) {
        }
    }

    public static abstract class Stub extends Binder implements ICrossProcessCallbackInterface {
        private static final String DESCRIPTOR = "com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface";
        static final int TRANSACTION_onCallBack = 1;

        public static class Proxy implements ICrossProcessCallbackInterface {
            public static ICrossProcessCallbackInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface
            public void onCallBack(List r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeList(r5);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onCallBack(r5);     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICrossProcessCallbackInterface asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICrossProcessCallbackInterface) == false) goto L12;
            return (ICrossProcessCallbackInterface) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICrossProcessCallbackInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICrossProcessCallbackInterface r1) {
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
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onCallBack(r5.readArrayList(getClass().getClassLoader()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onCallBack(List r1);
}
