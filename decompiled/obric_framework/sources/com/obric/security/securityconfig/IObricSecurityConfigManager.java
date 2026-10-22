package com.obric.security.securityconfig;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IObricSecurityConfigManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.security.securityconfig.IObricSecurityConfigManager";

    public static class Default implements IObricSecurityConfigManager {
        public Default() {
        }

        @Override // com.obric.security.securityconfig.IObricSecurityConfigManager
        public int updateConfig(String key, String value) throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.securityconfig.IObricSecurityConfigManager
        public int updateConfigInt(String key, int value) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObricSecurityConfigManager {
        static final int TRANSACTION_updateConfig = 1;
        static final int TRANSACTION_updateConfigInt = 2;

        private static class Proxy implements IObricSecurityConfigManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IObricSecurityConfigManager.DESCRIPTOR;
            }

            @Override // com.obric.security.securityconfig.IObricSecurityConfigManager
            public int updateConfig(String key, String value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityConfigManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(key);     // Catch: Throwable -> L6
                _data.writeString(value);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.securityconfig.IObricSecurityConfigManager
            public int updateConfigInt(String key, int value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityConfigManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(key);     // Catch: Throwable -> L6
                _data.writeInt(value);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IObricSecurityConfigManager.DESCRIPTOR);
        }

        public static IObricSecurityConfigManager asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IObricSecurityConfigManager.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IObricSecurityConfigManager) == false) goto L12;
            return (IObricSecurityConfigManager) iin;
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
            data.enforceInterface(IObricSecurityConfigManager.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IObricSecurityConfigManager.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            int _result = updateConfigInt(_arg0, _arg1);
            reply.writeNoException();
            reply.writeInt(_result);
        L16:
            return true;
        L15:
            String _arg2 = data.readString();
            String _arg3 = data.readString();
            data.enforceNoDataAvail();
            int _result2 = updateConfig(_arg2, _arg3);
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L16
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    int updateConfig(String r1, String r2) throws RemoteException;

    int updateConfigInt(String r1, int r2) throws RemoteException;
}
