package com.zte.zgesture.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface ISettingProvider extends IInterface {
    public static final String DESCRIPTOR = "com.zte.zgesture.provider.ISettingProvider";

    public static class Default implements ISettingProvider {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.zgesture.provider.ISettingProvider
        public boolean getBoolen(String r1) throws RemoteException {
            return false;
        }

        @Override // com.zte.zgesture.provider.ISettingProvider
        public void setBoolen(String r1, boolean r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISettingProvider {
        static final int TRANSACTION_getBoolen = 2;
        static final int TRANSACTION_setBoolen = 1;

        private static class Proxy implements ISettingProvider {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return ISettingProvider.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.zgesture.provider.ISettingProvider
            public void setBoolen(String r4, boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISettingProvider.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
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

            @Override // com.zte.zgesture.provider.ISettingProvider
            public boolean getBoolen(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISettingProvider.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
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
            attachInterface(this, ISettingProvider.DESCRIPTOR);
        }

        public static ISettingProvider asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ISettingProvider.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISettingProvider) == false) goto L12;
            return (ISettingProvider) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ISettingProvider.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L11;
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L18;
            boolean r9 = true;
        L19:
            setBoolen(r8, r9);
            r6.writeNoException();
        L20:
            return true;
        L18:
            r9 = false;
            goto L19
        L11:
            if (r4 != 2) goto L13;
            boolean r3 = getBoolen(r5.readString());
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L20
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(ISettingProvider.DESCRIPTOR);
            return true;
        }
    }

    boolean getBoolen(String r1) throws RemoteException;

    void setBoolen(String r1, boolean r2) throws RemoteException;
}
