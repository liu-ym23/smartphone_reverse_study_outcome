package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    public static class Default implements ICapabilityFeedbackReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onActionResultRecv(String r1, String r2, boolean r3) {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        static final int TRANSACTION_onActionResultRecv = 1;

        private static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r4, String r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r4);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onActionResultRecv(r4, r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityFeedbackReceiver asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityFeedbackReceiver) == false) goto L12;
            return (ICapabilityFeedbackReceiver) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r1) {
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
            String r8 = r5.readString();
            String r9 = r5.readString();
            if (r5.readInt() == 0) goto L13;
            boolean r10 = true;
        L14:
            onActionResultRecv(r8, r9, r10);
            return true;
        L13:
            r10 = false;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onActionResultRecv(String r1, String r2, boolean r3);
}
