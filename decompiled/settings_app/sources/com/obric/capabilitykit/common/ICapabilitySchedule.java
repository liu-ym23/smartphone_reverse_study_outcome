package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICapabilitySchedule extends IInterface {

    public static class Default implements ICapabilitySchedule {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void dispatchServerActions(String r1, boolean r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void queryAppIntents(String r1, IQueryAppIntentsCallback r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilitySchedule {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilitySchedule";
        public static final int TRANSACTION_dispatchServerActions = 1;
        public static final int TRANSACTION_queryAppIntents = 3;
        public static final int TRANSACTION_registerActionsResultReceiver = 2;

        public static class Proxy implements ICapabilitySchedule {
            public static ICapabilitySchedule sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void dispatchServerActions(String r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dispatchServerActions(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void queryAppIntents(String r5, IQueryAppIntentsCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().queryAppIntents(r5, r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerActionsResultReceiver(r5);     // Catch: Throwable -> L16
                goto L12
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilitySchedule asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilitySchedule) == false) goto L12;
            return (ICapabilitySchedule) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilitySchedule getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilitySchedule r1) {
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L21;
            boolean r9 = true;
        L22:
            dispatchServerActions(r8, r9);
        L15:
            r6.writeNoException();
            return true;
        L21:
            r9 = false;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            registerActionsResultReceiver(ICapabilityFeedbackReceiver.Stub.asInterface(r5.readStrongBinder()));
            goto L15
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            queryAppIntents(r5.readString(), IQueryAppIntentsCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L15
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void dispatchServerActions(String r1, boolean r2) throws RemoteException;

    void queryAppIntents(String r1, IQueryAppIntentsCallback r2) throws RemoteException;

    void registerActionsResultReceiver(ICapabilityFeedbackReceiver r1) throws RemoteException;
}
