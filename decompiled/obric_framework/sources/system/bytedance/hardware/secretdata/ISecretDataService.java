package system.bytedance.hardware.secretdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISecretDataService extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "194384adc8be2f1533748e96125f937be5469759";
    public static final int VERSION = 1;

    public static class Default implements ISecretDataService {
        public Default() {
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public SecretDataAddResult addSecretData(SecretDataParcel secretData, String appSign, String pkgName) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public int deleteSecretData(SecretDataDeleteParams deleteParams, String appSign, String pkgName) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public int updateSecretData(SecretDataParcel newData, String appSign, String pkgName) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public SecretDataQueryResult querySecretData(SecretDataQueryParams queryParams, int startIndex, String appSign, String pkgName) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public int clearAppData(String packageName, int uid) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // system.bytedance.hardware.secretdata.ISecretDataService
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISecretDataService {
        static final int TRANSACTION_addSecretData = 1;
        static final int TRANSACTION_clearAppData = 5;
        static final int TRANSACTION_deleteSecretData = 2;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_querySecretData = 4;
        static final int TRANSACTION_updateSecretData = 3;

        private static class Proxy implements ISecretDataService {
            private String mCachedHash;
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mCachedVersion = -1;
                this.mCachedHash = "-1";
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public SecretDataAddResult addSecretData(SecretDataParcel secretData, String appSign, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(secretData, 0);     // Catch: Throwable -> L10
                _data.writeString(appSign);     // Catch: Throwable -> L10
                _data.writeString(pkgName);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                SecretDataAddResult _result = (SecretDataAddResult) _reply.readTypedObject(SecretDataAddResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method addSecretData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public int deleteSecretData(SecretDataDeleteParams deleteParams, String appSign, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(deleteParams, 0);     // Catch: Throwable -> L10
                _data.writeString(appSign);     // Catch: Throwable -> L10
                _data.writeString(pkgName);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method deleteSecretData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public int updateSecretData(SecretDataParcel newData, String appSign, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(newData, 0);     // Catch: Throwable -> L10
                _data.writeString(appSign);     // Catch: Throwable -> L10
                _data.writeString(pkgName);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method updateSecretData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public SecretDataQueryResult querySecretData(SecretDataQueryParams queryParams, int startIndex, String appSign, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(queryParams, 0);     // Catch: Throwable -> L10
                _data.writeInt(startIndex);     // Catch: Throwable -> L10
                _data.writeString(appSign);     // Catch: Throwable -> L10
                _data.writeString(pkgName);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                SecretDataQueryResult _result = (SecretDataQueryResult) _reply.readTypedObject(SecretDataQueryResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method querySecretData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public int clearAppData(String packageName, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(packageName);     // Catch: Throwable -> L10
                _data.writeInt(uid);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method clearAppData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceVersion, data, reply, 0);     // Catch: Throwable -> L7
                reply.readException();     // Catch: Throwable -> L7
                this.mCachedVersion = reply.readInt();     // Catch: Throwable -> L7
                reply.recycle();
                data.recycle();
            L7:
                th = move-exception;
                reply.recycle();
                data.recycle();
                throw th;
            L11:
                return this.mCachedVersion;
            }

            @Override // system.bytedance.hardware.secretdata.ISecretDataService
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L14:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L11;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L14
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L14
                data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L8
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);     // Catch: Throwable -> L8
                reply.readException();     // Catch: Throwable -> L8
                this.mCachedHash = reply.readString();     // Catch: Throwable -> L8
                reply.recycle();     // Catch: Throwable -> L14
                data.recycle();     // Catch: Throwable -> L14
                goto L11
            L8:
                th = move-exception;
                reply.recycle();     // Catch: Throwable -> L14
                data.recycle();     // Catch: Throwable -> L14
                throw th;     // Catch: Throwable -> L14
            L11:
                String r0 = this.mCachedHash;     // Catch: Throwable -> L14
                monitor-exit(this);
                return r0;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, DESCRIPTOR);
        }

        public static ISecretDataService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ISecretDataService) == false) goto L12;
            return (ISecretDataService) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "clearAppData";
        L11:
            return "querySecretData";
        L13:
            return "updateSecretData";
        L15:
            return "deleteSecretData";
        L17:
            return "addSecretData";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            if (code < 1) goto L7;
            if (code > TRANSACTION_getInterfaceVersion) goto L7;
            data.enforceInterface(descriptor);
        L7:
            if (code != 1598968902) goto L10;
            reply.writeString(descriptor);
            return true;
        L10:
            if (code != TRANSACTION_getInterfaceVersion) goto L14;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (code != TRANSACTION_getInterfaceHash) goto L17;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L17:
            switch(code) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                default: goto L19;
            };
        L20:
            String _arg0 = data.readString();
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            int _result = clearAppData(_arg0, _arg1);
            reply.writeNoException();
            reply.writeInt(_result);
        L25:
            return true;
        L21:
            SecretDataQueryParams _arg2 = (SecretDataQueryParams) data.readTypedObject(SecretDataQueryParams.CREATOR);
            int _arg3 = data.readInt();
            String _arg4 = data.readString();
            String _arg5 = data.readString();
            data.enforceNoDataAvail();
            SecretDataQueryResult _result2 = querySecretData(_arg2, _arg3, _arg4, _arg5);
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L25
        L22:
            SecretDataParcel _arg6 = (SecretDataParcel) data.readTypedObject(SecretDataParcel.CREATOR);
            String _arg7 = data.readString();
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            int _result3 = updateSecretData(_arg6, _arg7, _arg8);
            reply.writeNoException();
            reply.writeInt(_result3);
            goto L25
        L23:
            SecretDataDeleteParams _arg9 = (SecretDataDeleteParams) data.readTypedObject(SecretDataDeleteParams.CREATOR);
            String _arg10 = data.readString();
            String _arg11 = data.readString();
            data.enforceNoDataAvail();
            int _result4 = deleteSecretData(_arg9, _arg10, _arg11);
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L25
        L24:
            SecretDataParcel _arg12 = (SecretDataParcel) data.readTypedObject(SecretDataParcel.CREATOR);
            String _arg13 = data.readString();
            String _arg14 = data.readString();
            data.enforceNoDataAvail();
            SecretDataAddResult _result5 = addSecretData(_arg12, _arg13, _arg14);
            reply.writeNoException();
            reply.writeTypedObject(_result5, 1);
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    SecretDataAddResult addSecretData(SecretDataParcel r1, String r2, String r3) throws RemoteException;

    int clearAppData(String r1, int r2) throws RemoteException;

    int deleteSecretData(SecretDataDeleteParams r1, String r2, String r3) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    SecretDataQueryResult querySecretData(SecretDataQueryParams r1, int r2, String r3, String r4) throws RemoteException;

    int updateSecretData(SecretDataParcel r1, String r2, String r3) throws RemoteException;

    static {
        DESCRIPTOR = "system$bytedance$hardware$secretdata$ISecretDataService".replace('$', '.');
    }
}
