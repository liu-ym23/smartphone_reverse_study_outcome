package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IMultiInstanceInvalidationService {
            private IBinder mRemote;

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int r3, String[] r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeStringArray(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(IMultiInstanceInvalidationCallback r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                IBinder r6 = r4.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                int r3 = r1.readInt();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(IMultiInstanceInvalidationCallback r4, int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                IBinder r6 = r4.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
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

        public static IMultiInstanceInvalidationService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMultiInstanceInvalidationService) == false) goto L12;
            return (IMultiInstanceInvalidationService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            int r3 = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r5.readStrongBinder()), r5.readString());
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r5.readStrongBinder()), r5.readInt());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            broadcastInvalidation(r5.readInt(), r5.createStringArray());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void broadcastInvalidation(int r1, String[] r2);

    int registerCallback(IMultiInstanceInvalidationCallback r1, String r2);

    void unregisterCallback(IMultiInstanceInvalidationCallback r1, int r2);
}
