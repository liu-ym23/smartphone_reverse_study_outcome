package com.obric.security.guard;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IObricSettingsEventObserver extends IInterface {
    public static final String DESCRIPTOR = "com.obric.security.guard.IObricSettingsEventObserver";

    public static class Default implements IObricSettingsEventObserver {
        public Default() {
        }

        @Override // com.obric.security.guard.IObricSettingsEventObserver
        public void onEventStart(int eventType, String pkgName, Bundle extra) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSettingsEventObserver
        public void onEventEnd(int eventType, String pkgName, Bundle extra) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObricSettingsEventObserver {
        static final int TRANSACTION_onEventEnd = 2;
        static final int TRANSACTION_onEventStart = 1;

        private static class Proxy implements IObricSettingsEventObserver {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IObricSettingsEventObserver.DESCRIPTOR;
            }

            @Override // com.obric.security.guard.IObricSettingsEventObserver
            public void onEventStart(int eventType, String pkgName, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IObricSettingsEventObserver.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(eventType);     // Catch: Throwable -> L6
                _data.writeString(pkgName);     // Catch: Throwable -> L6
                _data.writeTypedObject(extra, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSettingsEventObserver
            public void onEventEnd(int eventType, String pkgName, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IObricSettingsEventObserver.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(eventType);     // Catch: Throwable -> L6
                _data.writeString(pkgName);     // Catch: Throwable -> L6
                _data.writeTypedObject(extra, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IObricSettingsEventObserver.DESCRIPTOR);
        }

        public static IObricSettingsEventObserver asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IObricSettingsEventObserver.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IObricSettingsEventObserver) == false) goto L12;
            return (IObricSettingsEventObserver) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IObricSettingsEventObserver.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IObricSettingsEventObserver.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L14:
            int _arg0 = data.readInt();
            String _arg1 = data.readString();
            Bundle _arg2 = (Bundle) data.readTypedObject(Bundle.CREATOR);
            data.enforceNoDataAvail();
            onEventEnd(_arg0, _arg1, _arg2);
        L16:
            return true;
        L15:
            int _arg3 = data.readInt();
            String _arg4 = data.readString();
            Bundle _arg5 = (Bundle) data.readTypedObject(Bundle.CREATOR);
            data.enforceNoDataAvail();
            onEventStart(_arg3, _arg4, _arg5);
            goto L16
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onEventEnd(int r1, String r2, Bundle r3) throws RemoteException;

    void onEventStart(int r1, String r2, Bundle r3) throws RemoteException;
}
