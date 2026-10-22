package com.obric.matrix.push.common.cross_process;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrossProcessInterface extends IInterface {

    public static class Default implements ICrossProcessInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.push.common.cross_process.ICrossProcessInterface
        public void invoke(String r1, String r2, List r3, ICrossProcessCallbackInterface r4) {
        }
    }

    public static abstract class Stub extends Binder implements ICrossProcessInterface {
        private static final String DESCRIPTOR = "com.obric.matrix.push.common.cross_process.ICrossProcessInterface";
        static final int TRANSACTION_invoke = 1;

        public static class Proxy implements ICrossProcessInterface {
            public static ICrossProcessInterface sDefaultImpl;
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

            @Override // com.obric.matrix.push.common.cross_process.ICrossProcessInterface
            public void invoke(String r5, String r6, List r7, ICrossProcessCallbackInterface r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeList(r7);     // Catch: Throwable -> L6
                if (r8 == null) goto L8;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().invoke(r5, r6, r7, r8);     // Catch: Throwable -> L6
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

        public static ICrossProcessInterface asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICrossProcessInterface) == false) goto L12;
            return (ICrossProcessInterface) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICrossProcessInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICrossProcessInterface r1) {
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
            invoke(r5.readString(), r5.readString(), r5.readArrayList(getClass().getClassLoader()), ICrossProcessCallbackInterface.Stub.asInterface(r5.readStrongBinder()));
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

    void invoke(String r1, String r2, List r3, ICrossProcessCallbackInterface r4);
}
