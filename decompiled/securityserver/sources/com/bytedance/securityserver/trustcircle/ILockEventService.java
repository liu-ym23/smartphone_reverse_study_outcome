package com.bytedance.securityserver.trustcircle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface ILockEventService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.securityserver.trustcircle.ILockEventService";
    public static final int EVENT_CHANGE_PASSWORD = 3;
    public static final int EVENT_DISABLE_PASSWORD = 4;
    public static final int EVENT_SET_PASSWORD = 1;
    public static final int EVENT_VERIFY_PASSWORD = 2;

    public static class Default implements ILockEventService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.securityserver.trustcircle.ILockEventService
        public void onLockEvent(int r1, int r2, byte[] r3, Bundle r4) {
        }
    }

    public static abstract class Stub extends Binder implements ILockEventService {
        static final int TRANSACTION_onLockEvent = 1;

        public static class Proxy implements ILockEventService {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILockEventService.DESCRIPTOR;
            }

            @Override // com.bytedance.securityserver.trustcircle.ILockEventService
            public void onLockEvent(int r3, int r4, byte[] r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ILockEventService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                _Parcel.b(r0, r6);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ILockEventService.DESCRIPTOR);
        }

        public static ILockEventService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ILockEventService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ILockEventService) == false) goto L12;
            return (ILockEventService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ILockEventService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onLockEvent(r5.readInt(), r5.readInt(), r5.createByteArray(), (Bundle) _Parcel.a(r5, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(ILockEventService.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static /* bridge */ /* synthetic */ Object a(Parcel r0, Parcelable.Creator r1) {
            return readTypedObject(r0, r1);
        }

        public static /* bridge */ /* synthetic */ void b(Parcel r1, Parcelable r2) {
            writeTypedObject(r1, r2, 0);
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

    void onLockEvent(int r1, int r2, byte[] r3, Bundle r4);
}
