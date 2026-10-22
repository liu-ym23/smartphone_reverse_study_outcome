package com.obric.security.guard;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IObricSecurityGuardService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.security.guard.IObricSecurityGuardService";

    public static class Default implements IObricSecurityGuardService {
        public Default() {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public Bundle getCurrentAppGrantPermissionInfo(String packageName) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public Bundle getAppGrantPermissionInfo(String packageName, String[] permission) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void updateMinPerPolicy(String packageName, String perPolicy) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public int getActivityRiskType(String packageName, String activityName, Bundle extra) throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void updatePolicyFile(String fileName, String policyFile) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public String getSecurityPolicy(String fileName) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void registerSettingsEventObserver(IObricSettingsEventObserver observer) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void unregisterSettingsEventObserver(IObricSettingsEventObserver observer) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void bdSettingsEventStart(int eventType, Bundle extra) throws RemoteException {
        }

        @Override // com.obric.security.guard.IObricSecurityGuardService
        public void bdSettingsEventEnd(int eventType, Bundle extra) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObricSecurityGuardService {
        static final int TRANSACTION_bdSettingsEventEnd = 10;
        static final int TRANSACTION_bdSettingsEventStart = 9;
        static final int TRANSACTION_getActivityRiskType = 4;
        static final int TRANSACTION_getAppGrantPermissionInfo = 2;
        static final int TRANSACTION_getCurrentAppGrantPermissionInfo = 1;
        static final int TRANSACTION_getSecurityPolicy = 6;
        static final int TRANSACTION_registerSettingsEventObserver = 7;
        static final int TRANSACTION_unregisterSettingsEventObserver = 8;
        static final int TRANSACTION_updateMinPerPolicy = 3;
        static final int TRANSACTION_updatePolicyFile = 5;

        private static class Proxy implements IObricSecurityGuardService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IObricSecurityGuardService.DESCRIPTOR;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public Bundle getCurrentAppGrantPermissionInfo(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public Bundle getAppGrantPermissionInfo(String packageName, String[] permission) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeStringArray(permission);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void updateMinPerPolicy(String packageName, String perPolicy) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(perPolicy);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public int getActivityRiskType(String packageName, String activityName, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(activityName);     // Catch: Throwable -> L6
                _data.writeTypedObject(extra, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void updatePolicyFile(String fileName, String policyFile) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(fileName);     // Catch: Throwable -> L6
                _data.writeString(policyFile);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public String getSecurityPolicy(String fileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(fileName);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void registerSettingsEventObserver(IObricSettingsEventObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(observer);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void unregisterSettingsEventObserver(IObricSettingsEventObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(observer);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void bdSettingsEventStart(int eventType, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(eventType);     // Catch: Throwable -> L6
                _data.writeTypedObject(extra, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.guard.IObricSecurityGuardService
            public void bdSettingsEventEnd(int eventType, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricSecurityGuardService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(eventType);     // Catch: Throwable -> L6
                _data.writeTypedObject(extra, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(Stub.TRANSACTION_bdSettingsEventEnd, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IObricSecurityGuardService.DESCRIPTOR);
        }

        public static IObricSecurityGuardService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IObricSecurityGuardService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IObricSecurityGuardService) == false) goto L12;
            return (IObricSecurityGuardService) iin;
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
            data.enforceInterface(IObricSecurityGuardService.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IObricSecurityGuardService.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                default: goto L13;
            };
        L14:
            int _arg0 = data.readInt();
            Bundle _arg1 = (Bundle) data.readTypedObject(Bundle.CREATOR);
            data.enforceNoDataAvail();
            bdSettingsEventEnd(_arg0, _arg1);
            reply.writeNoException();
        L24:
            return true;
        L15:
            int _arg2 = data.readInt();
            Bundle _arg3 = (Bundle) data.readTypedObject(Bundle.CREATOR);
            data.enforceNoDataAvail();
            bdSettingsEventStart(_arg2, _arg3);
            reply.writeNoException();
            goto L24
        L16:
            IObricSettingsEventObserver _arg4 = IObricSettingsEventObserver.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            unregisterSettingsEventObserver(_arg4);
            reply.writeNoException();
            goto L24
        L17:
            IObricSettingsEventObserver _arg5 = IObricSettingsEventObserver.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            registerSettingsEventObserver(_arg5);
            reply.writeNoException();
            goto L24
        L18:
            String _arg6 = data.readString();
            data.enforceNoDataAvail();
            String _result = getSecurityPolicy(_arg6);
            reply.writeNoException();
            reply.writeString(_result);
            goto L24
        L19:
            String _arg7 = data.readString();
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            updatePolicyFile(_arg7, _arg8);
            reply.writeNoException();
            goto L24
        L20:
            String _arg9 = data.readString();
            String _arg10 = data.readString();
            Bundle _arg11 = (Bundle) data.readTypedObject(Bundle.CREATOR);
            data.enforceNoDataAvail();
            int _result2 = getActivityRiskType(_arg9, _arg10, _arg11);
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L24
        L21:
            String _arg12 = data.readString();
            String _arg13 = data.readString();
            data.enforceNoDataAvail();
            updateMinPerPolicy(_arg12, _arg13);
            reply.writeNoException();
            goto L24
        L22:
            String _arg14 = data.readString();
            String[] _arg15 = data.createStringArray();
            data.enforceNoDataAvail();
            Bundle _result3 = getAppGrantPermissionInfo(_arg14, _arg15);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L24
        L23:
            String _arg16 = data.readString();
            data.enforceNoDataAvail();
            Bundle _result4 = getCurrentAppGrantPermissionInfo(_arg16);
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L24
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void bdSettingsEventEnd(int r1, Bundle r2) throws RemoteException;

    void bdSettingsEventStart(int r1, Bundle r2) throws RemoteException;

    int getActivityRiskType(String r1, String r2, Bundle r3) throws RemoteException;

    Bundle getAppGrantPermissionInfo(String r1, String[] r2) throws RemoteException;

    Bundle getCurrentAppGrantPermissionInfo(String r1) throws RemoteException;

    String getSecurityPolicy(String r1) throws RemoteException;

    void registerSettingsEventObserver(IObricSettingsEventObserver r1) throws RemoteException;

    void unregisterSettingsEventObserver(IObricSettingsEventObserver r1) throws RemoteException;

    void updateMinPerPolicy(String r1, String r2) throws RemoteException;

    void updatePolicyFile(String r1, String r2) throws RemoteException;
}
