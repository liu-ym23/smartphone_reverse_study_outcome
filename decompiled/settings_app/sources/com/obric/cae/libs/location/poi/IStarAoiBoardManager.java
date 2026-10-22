package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IStarAoiBoardManager extends IInterface {

    public static class Default implements IStarAoiBoardManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public AoiBoard findAoiBoardByPoiId(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public boolean isAoiBoardsRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAllAoiBoards() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAoiBoardsByType(int r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void registerAoiBoardCallback(IStarAoiBoardCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void unregisterAoiBoardCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardManager";
        static final int TRANSACTION_findAoiBoardByPoiId = 5;
        static final int TRANSACTION_isAoiBoardsRecovered = 6;
        static final int TRANSACTION_listAllAoiBoards = 3;
        static final int TRANSACTION_listAoiBoardsByType = 4;
        static final int TRANSACTION_registerAoiBoardCallback = 1;
        static final int TRANSACTION_unregisterAoiBoardCallback = 2;

        public static class Proxy implements IStarAoiBoardManager {
            public static IStarAoiBoardManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public AoiBoard findAoiBoardByPoiId(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                AoiBoard r4 = AoiBoard.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                AoiBoard r6 = Stub.getDefaultImpl().findAoiBoardByPoiId(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public boolean isAoiBoardsRecovered() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isAoiBoardsRecovered();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAllAoiBoards() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AoiBoard> r5 = Stub.getDefaultImpl().listAllAoiBoards();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAoiBoardsByType(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AoiBoard> r6 = Stub.getDefaultImpl().listAoiBoardsByType(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void registerAoiBoardCallback(IStarAoiBoardCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                IBinder r2 = r4.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAoiBoardCallback(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void unregisterAoiBoardCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterAoiBoardCallback();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarAoiBoardManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarAoiBoardManager) == false) goto L12;
            return (IStarAoiBoardManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static IStarAoiBoardManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarAoiBoardManager r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L22;
            switch(r4) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = isAoiBoardsRecovered();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            AoiBoard r8 = findAoiBoardByPoiId(r5.readString());
            r6.writeNoException();
            if (r8 == null) goto L12;
            r6.writeInt(1);
            r8.writeToParcel(r6, 1);
        L13:
            return true;
        L12:
            r6.writeInt(0);
            goto L13
        L14:
            r5.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r9 = listAoiBoardsByType(r5.readInt());
            r6.writeNoException();
            r6.writeTypedList(r9);
            return true;
        L16:
            r5.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r10 = listAllAoiBoards();
            r6.writeNoException();
            r6.writeTypedList(r10);
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            unregisterAoiBoardCallback();
            return true;
        L20:
            r5.enforceInterface(DESCRIPTOR);
            registerAoiBoardCallback(IStarAoiBoardCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L22:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    AoiBoard findAoiBoardByPoiId(String r1) throws RemoteException;

    boolean isAoiBoardsRecovered() throws RemoteException;

    List<AoiBoard> listAllAoiBoards() throws RemoteException;

    List<AoiBoard> listAoiBoardsByType(int r1) throws RemoteException;

    void registerAoiBoardCallback(IStarAoiBoardCallback r1) throws RemoteException;

    void unregisterAoiBoardCallback() throws RemoteException;
}
