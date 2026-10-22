package com.bytedance.wirelesscast;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IWirelessCastService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.wirelesscast.IWirelessCastService";

    public static class Default implements IWirelessCastService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.wirelesscast.IWirelessCastService
        public void connectService(SmtLinkInfo r1) throws RemoteException {
        }

        @Override // com.bytedance.wirelesscast.IWirelessCastService
        public void disConnectService(SmtLinkInfo r1) throws RemoteException {
        }

        @Override // com.bytedance.wirelesscast.IWirelessCastService
        public boolean hasConnected() throws RemoteException {
            return false;
        }

        @Override // com.bytedance.wirelesscast.IWirelessCastService
        public void registerCallback(ICallback r1) throws RemoteException {
        }

        @Override // com.bytedance.wirelesscast.IWirelessCastService
        public void unregisterCallback(ICallback r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IWirelessCastService {
        static final int TRANSACTION_connectService = 3;
        static final int TRANSACTION_disConnectService = 4;
        static final int TRANSACTION_hasConnected = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IWirelessCastService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWirelessCastService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.wirelesscast.IWirelessCastService
            public void registerCallback(ICallback r3) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IWirelessCastService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r3);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.wirelesscast.IWirelessCastService
            public void unregisterCallback(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IWirelessCastService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.wirelesscast.IWirelessCastService
            public void connectService(SmtLinkInfo r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IWirelessCastService.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.access$100(r0, r4, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.wirelesscast.IWirelessCastService
            public void disConnectService(SmtLinkInfo r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IWirelessCastService.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.access$100(r0, r4, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.wirelesscast.IWirelessCastService
            public boolean hasConnected() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IWirelessCastService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
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
            attachInterface(this, IWirelessCastService.DESCRIPTOR);
        }

        public static IWirelessCastService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IWirelessCastService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IWirelessCastService) == false) goto L12;
            return (IWirelessCastService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IWirelessCastService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L26;
            if (r4 != 1) goto L11;
            registerCallback(ICallback.Stub.asInterface(r5.readStrongBinder()));
        L25:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterCallback(ICallback.Stub.asInterface(r5.readStrongBinder()));
            goto L25
        L13:
            if (r4 != 3) goto L15;
            connectService((SmtLinkInfo) _Parcel.access$000(r5, SmtLinkInfo.CREATOR));
            goto L25
        L15:
            if (r4 != 4) goto L17;
            disConnectService((SmtLinkInfo) _Parcel.access$000(r5, SmtLinkInfo.CREATOR));
            goto L25
        L17:
            if (r4 != 5) goto L19;
            boolean r3 = hasConnected();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L25
        L19:
            return super.onTransact(r4, r5, r6, r7);
        L26:
            r6.writeString(IWirelessCastService.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        static /* synthetic */ Object access$000(Parcel r0, Parcelable.Creator r1) {
            return readTypedObject(r0, r1);
        }

        static /* synthetic */ void access$100(Parcel r0, Parcelable r1, int r2) {
            writeTypedObject(r0, r1, r2);
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

    void connectService(SmtLinkInfo r1) throws RemoteException;

    void disConnectService(SmtLinkInfo r1) throws RemoteException;

    boolean hasConnected() throws RemoteException;

    void registerCallback(ICallback r1) throws RemoteException;

    void unregisterCallback(ICallback r1) throws RemoteException;
}
