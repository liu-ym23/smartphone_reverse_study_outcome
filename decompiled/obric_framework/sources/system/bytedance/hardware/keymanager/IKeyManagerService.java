package system.bytedance.hardware.keymanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import vendor.bytedance.hardware.keymanager.AttestationResult;
import vendor.bytedance.hardware.keymanager.KeyAgreementResult;
import vendor.bytedance.hardware.keymanager.KeyParameter;
import vendor.bytedance.hardware.keymanager.SignResult;
import vendor.bytedance.hardware.keymanager.TlsCertChainResult;
import vendor.bytedance.hardware.keymanager.UDIDResult;
import vendor.bytedance.hardware.keymanager.XcryptResult;

/* JADX INFO: loaded from: classes.dex */
public interface IKeyManagerService extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "1748fae82602df0611ad0971bd7ea9dd5de00024";
    public static final int VERSION = 1;

    public static class Default implements IKeyManagerService {
        public Default() {
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int importSyncKeyLegacy(CloudSyncKeyParamsLegacy keyParams) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int importSyncKey(CloudSyncKeyParams keyParams) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public XcryptResult cloudSyncXcrypt(int mode, String keyAlias, byte[] inData, String aad) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int deleteSyncKey(String keyAlias) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int generateKeyPair(String keyAlias, KeyParameter[] params) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public AttestationResult keyAttestation(String keyAlias, String challenge, KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public KeyAgreementResult keyAgreement(String keyAlias, byte[] publicKey, KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public AttestationResult getCertificateChain(String keyAlias) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public SignResult sign(String keyAlias, byte[] data) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int verify(String keyAlias, byte[] data, byte[] signature) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int deleteKey(String keyAlias) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int clearAppKeyData(String pkgName, int uid) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public TlsCertChainResult exportTlsCertChain(String certAlias) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public SignResult signTlsData(String keyAlias, byte[] data, KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int containsTlsKey(String keyAlias) throws RemoteException {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public UDIDResult getUDID() throws RemoteException {
            return null;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // system.bytedance.hardware.keymanager.IKeyManagerService
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IKeyManagerService {
        static final int TRANSACTION_clearAppKeyData = 12;
        static final int TRANSACTION_cloudSyncXcrypt = 3;
        static final int TRANSACTION_containsTlsKey = 15;
        static final int TRANSACTION_deleteKey = 11;
        static final int TRANSACTION_deleteSyncKey = 4;
        static final int TRANSACTION_exportTlsCertChain = 13;
        static final int TRANSACTION_generateKeyPair = 5;
        static final int TRANSACTION_getCertificateChain = 8;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getUDID = 16;
        static final int TRANSACTION_importSyncKey = 2;
        static final int TRANSACTION_importSyncKeyLegacy = 1;
        static final int TRANSACTION_keyAgreement = 7;
        static final int TRANSACTION_keyAttestation = 6;
        static final int TRANSACTION_sign = 9;
        static final int TRANSACTION_signTlsData = 14;
        static final int TRANSACTION_verify = 10;

        private static class Proxy implements IKeyManagerService {
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

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int importSyncKeyLegacy(CloudSyncKeyParamsLegacy keyParams) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(keyParams, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method importSyncKeyLegacy is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int importSyncKey(CloudSyncKeyParams keyParams) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(keyParams, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method importSyncKey is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public XcryptResult cloudSyncXcrypt(int mode, String keyAlias, byte[] inData, String aad) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeInt(mode);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(inData);     // Catch: Throwable -> L10
                _data.writeString(aad);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                XcryptResult _result = (XcryptResult) _reply.readTypedObject(XcryptResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method cloudSyncXcrypt is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int deleteSyncKey(String keyAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method deleteSyncKey is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int generateKeyPair(String keyAlias, KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method generateKeyPair is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public AttestationResult keyAttestation(String keyAlias, String challenge, KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeString(challenge);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                AttestationResult _result = (AttestationResult) _reply.readTypedObject(AttestationResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method keyAttestation is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public KeyAgreementResult keyAgreement(String keyAlias, byte[] publicKey, KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(publicKey);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                KeyAgreementResult _result = (KeyAgreementResult) _reply.readTypedObject(KeyAgreementResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method keyAgreement is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public AttestationResult getCertificateChain(String keyAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                AttestationResult _result = (AttestationResult) _reply.readTypedObject(AttestationResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method getCertificateChain is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public SignResult sign(String keyAlias, byte[] data) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(data);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                SignResult _result = (SignResult) _reply.readTypedObject(SignResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method sign is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int verify(String keyAlias, byte[] data, byte[] signature) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(data);     // Catch: Throwable -> L10
                _data.writeByteArray(signature);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_verify, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method verify is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int deleteKey(String keyAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_deleteKey, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method deleteKey is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int clearAppKeyData(String pkgName, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(pkgName);     // Catch: Throwable -> L10
                _data.writeInt(uid);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method clearAppKeyData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public TlsCertChainResult exportTlsCertChain(String certAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(certAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_exportTlsCertChain, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                TlsCertChainResult _result = (TlsCertChainResult) _reply.readTypedObject(TlsCertChainResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method exportTlsCertChain is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public SignResult signTlsData(String keyAlias, byte[] data, KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(data);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_signTlsData, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                SignResult _result = (SignResult) _reply.readTypedObject(SignResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method signTlsData is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public int containsTlsKey(String keyAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_containsTlsKey, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method containsTlsKey is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
            public UDIDResult getUDID() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                UDIDResult _result = (UDIDResult) _reply.readTypedObject(UDIDResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method getUDID is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
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

            @Override // system.bytedance.hardware.keymanager.IKeyManagerService
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

        public static IKeyManagerService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IKeyManagerService) == false) goto L12;
            return (IKeyManagerService) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L39;
                case 2: goto L37;
                case 3: goto L35;
                case 4: goto L33;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L21;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L11;
                case 16: goto L9;
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
            return "getUDID";
        L11:
            return "containsTlsKey";
        L13:
            return "signTlsData";
        L15:
            return "exportTlsCertChain";
        L17:
            return "clearAppKeyData";
        L19:
            return "deleteKey";
        L21:
            return "verify";
        L23:
            return "sign";
        L25:
            return "getCertificateChain";
        L27:
            return "keyAgreement";
        L29:
            return "keyAttestation";
        L31:
            return "generateKeyPair";
        L33:
            return "deleteSyncKey";
        L35:
            return "cloudSyncXcrypt";
        L37:
            return "importSyncKey";
        L39:
            return "importSyncKeyLegacy";
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
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                default: goto L19;
            };
        L20:
            UDIDResult _result = getUDID();
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
        L36:
            return true;
        L21:
            String _arg0 = data.readString();
            data.enforceNoDataAvail();
            int _result2 = containsTlsKey(_arg0);
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L36
        L22:
            String _arg1 = data.readString();
            byte[] _arg2 = data.createByteArray();
            KeyParameter[] _arg3 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            SignResult _result3 = signTlsData(_arg1, _arg2, _arg3);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L36
        L23:
            String _arg4 = data.readString();
            data.enforceNoDataAvail();
            TlsCertChainResult _result4 = exportTlsCertChain(_arg4);
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L36
        L24:
            String _arg5 = data.readString();
            int _arg6 = data.readInt();
            data.enforceNoDataAvail();
            int _result5 = clearAppKeyData(_arg5, _arg6);
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L36
        L25:
            String _arg7 = data.readString();
            data.enforceNoDataAvail();
            int _result6 = deleteKey(_arg7);
            reply.writeNoException();
            reply.writeInt(_result6);
            goto L36
        L26:
            String _arg8 = data.readString();
            byte[] _arg9 = data.createByteArray();
            byte[] _arg10 = data.createByteArray();
            data.enforceNoDataAvail();
            int _result7 = verify(_arg8, _arg9, _arg10);
            reply.writeNoException();
            reply.writeInt(_result7);
            goto L36
        L27:
            String _arg11 = data.readString();
            byte[] _arg12 = data.createByteArray();
            data.enforceNoDataAvail();
            SignResult _result8 = sign(_arg11, _arg12);
            reply.writeNoException();
            reply.writeTypedObject(_result8, 1);
            goto L36
        L28:
            String _arg13 = data.readString();
            data.enforceNoDataAvail();
            AttestationResult _result9 = getCertificateChain(_arg13);
            reply.writeNoException();
            reply.writeTypedObject(_result9, 1);
            goto L36
        L29:
            String _arg14 = data.readString();
            byte[] _arg15 = data.createByteArray();
            KeyParameter[] _arg16 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            KeyAgreementResult _result10 = keyAgreement(_arg14, _arg15, _arg16);
            reply.writeNoException();
            reply.writeTypedObject(_result10, 1);
            goto L36
        L30:
            String _arg17 = data.readString();
            String _arg18 = data.readString();
            KeyParameter[] _arg19 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            AttestationResult _result11 = keyAttestation(_arg17, _arg18, _arg19);
            reply.writeNoException();
            reply.writeTypedObject(_result11, 1);
            goto L36
        L31:
            String _arg20 = data.readString();
            KeyParameter[] _arg21 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            int _result12 = generateKeyPair(_arg20, _arg21);
            reply.writeNoException();
            reply.writeInt(_result12);
            goto L36
        L32:
            String _arg22 = data.readString();
            data.enforceNoDataAvail();
            int _result13 = deleteSyncKey(_arg22);
            reply.writeNoException();
            reply.writeInt(_result13);
            goto L36
        L33:
            int _arg23 = data.readInt();
            String _arg24 = data.readString();
            byte[] _arg25 = data.createByteArray();
            String _arg26 = data.readString();
            data.enforceNoDataAvail();
            XcryptResult _result14 = cloudSyncXcrypt(_arg23, _arg24, _arg25, _arg26);
            reply.writeNoException();
            reply.writeTypedObject(_result14, 1);
            goto L36
        L34:
            CloudSyncKeyParams _arg27 = (CloudSyncKeyParams) data.readTypedObject(CloudSyncKeyParams.CREATOR);
            data.enforceNoDataAvail();
            int _result15 = importSyncKey(_arg27);
            reply.writeNoException();
            reply.writeInt(_result15);
            goto L36
        L35:
            CloudSyncKeyParamsLegacy _arg28 = (CloudSyncKeyParamsLegacy) data.readTypedObject(CloudSyncKeyParamsLegacy.CREATOR);
            data.enforceNoDataAvail();
            int _result16 = importSyncKeyLegacy(_arg28);
            reply.writeNoException();
            reply.writeInt(_result16);
            goto L36
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    int clearAppKeyData(String r1, int r2) throws RemoteException;

    XcryptResult cloudSyncXcrypt(int r1, String r2, byte[] r3, String r4) throws RemoteException;

    int containsTlsKey(String r1) throws RemoteException;

    int deleteKey(String r1) throws RemoteException;

    int deleteSyncKey(String r1) throws RemoteException;

    TlsCertChainResult exportTlsCertChain(String r1) throws RemoteException;

    int generateKeyPair(String r1, KeyParameter[] r2) throws RemoteException;

    AttestationResult getCertificateChain(String r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    UDIDResult getUDID() throws RemoteException;

    int importSyncKey(CloudSyncKeyParams r1) throws RemoteException;

    int importSyncKeyLegacy(CloudSyncKeyParamsLegacy r1) throws RemoteException;

    KeyAgreementResult keyAgreement(String r1, byte[] r2, KeyParameter[] r3) throws RemoteException;

    AttestationResult keyAttestation(String r1, String r2, KeyParameter[] r3) throws RemoteException;

    SignResult sign(String r1, byte[] r2) throws RemoteException;

    SignResult signTlsData(String r1, byte[] r2, KeyParameter[] r3) throws RemoteException;

    int verify(String r1, byte[] r2, byte[] r3) throws RemoteException;

    static {
        DESCRIPTOR = "system$bytedance$hardware$keymanager$IKeyManagerService".replace('$', '.');
    }
}
