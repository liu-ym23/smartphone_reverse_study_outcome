package vendor.bytedance.hardware.keymanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IKeyManagerVendor extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "36c05392569bf0e017a2691bd079329bef23ac75";
    public static final int VERSION = 1;

    public static class Default implements IKeyManagerVendor {
        public Default() {
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int importKeyLegacy(String keyAlias, byte[] wrappedKey, ImportParamsLegacy importParams) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int importKey(String keyAlias, byte[] wrappedKey, ImportParams importParams) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public XcryptResult xcrypt(int mode, byte[] inData, String keyAlias, byte[] aad) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int deleteSyncKey(String keyAlias) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public KeyPairResult generateKeyPair(KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public AttestationResult keyAttestation(KeyParameter[] params, byte[] challenge) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public SignResult sign(KeyParameter[] params, byte[] data) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public ProductionResult factoryOperate(byte[] inData) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public TlsCertChainResult exportTlsCertChain(String certAlias) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public SignResult signTlsData(String keyAlias, byte[] data, KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int containsTlsKey(String keyAlias) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int setSystemSecurityInfo(SystemSecurityInfo securityInfo) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public KeyAgreementResult keyAgreement(byte[] publicKey, KeyParameter[] params) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public UDIDResult udidInvokeCmd(UDIDRequest udidRequest) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IKeyManagerVendor {
        static final int TRANSACTION_containsTlsKey = 11;
        static final int TRANSACTION_deleteSyncKey = 4;
        static final int TRANSACTION_exportTlsCertChain = 9;
        static final int TRANSACTION_factoryOperate = 8;
        static final int TRANSACTION_generateKeyPair = 5;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_importKey = 2;
        static final int TRANSACTION_importKeyLegacy = 1;
        static final int TRANSACTION_keyAgreement = 13;
        static final int TRANSACTION_keyAttestation = 6;
        static final int TRANSACTION_setSystemSecurityInfo = 12;
        static final int TRANSACTION_sign = 7;
        static final int TRANSACTION_signTlsData = 10;
        static final int TRANSACTION_udidInvokeCmd = 14;
        static final int TRANSACTION_xcrypt = 3;

        private static class Proxy implements IKeyManagerVendor {
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public int importKeyLegacy(String keyAlias, byte[] wrappedKey, ImportParamsLegacy importParams) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(wrappedKey);     // Catch: Throwable -> L10
                _data.writeTypedObject(importParams, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method importKeyLegacy is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public int importKey(String keyAlias, byte[] wrappedKey, ImportParams importParams) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(wrappedKey);     // Catch: Throwable -> L10
                _data.writeTypedObject(importParams, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method importKey is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public XcryptResult xcrypt(int mode, byte[] inData, String keyAlias, byte[] aad) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeInt(mode);     // Catch: Throwable -> L10
                _data.writeByteArray(inData);     // Catch: Throwable -> L10
                _data.writeString(keyAlias);     // Catch: Throwable -> L10
                _data.writeByteArray(aad);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                XcryptResult _result = (XcryptResult) _reply.readTypedObject(XcryptResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method xcrypt is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public KeyPairResult generateKeyPair(KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                KeyPairResult _result = (KeyPairResult) _reply.readTypedObject(KeyPairResult.CREATOR);     // Catch: Throwable -> L10
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public AttestationResult keyAttestation(KeyParameter[] params, byte[] challenge) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                _data.writeByteArray(challenge);     // Catch: Throwable -> L10
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public SignResult sign(KeyParameter[] params, byte[] data) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                _data.writeByteArray(data);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public ProductionResult factoryOperate(byte[] inData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeByteArray(inData);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                ProductionResult _result = (ProductionResult) _reply.readTypedObject(ProductionResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method factoryOperate is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public TlsCertChainResult exportTlsCertChain(String certAlias) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(certAlias);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public int setSystemSecurityInfo(SystemSecurityInfo securityInfo) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(securityInfo, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                int _result = _reply.readInt();     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method setSystemSecurityInfo is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public KeyAgreementResult keyAgreement(byte[] publicKey, KeyParameter[] params) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeByteArray(publicKey);     // Catch: Throwable -> L10
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_keyAgreement, _data, _reply, 0);     // Catch: Throwable -> L10
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
            public UDIDResult udidInvokeCmd(UDIDRequest udidRequest) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeTypedObject(udidRequest, 0);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(Stub.TRANSACTION_udidInvokeCmd, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                UDIDResult _result = (UDIDResult) _reply.readTypedObject(UDIDResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method udidInvokeCmd is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
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

            @Override // vendor.bytedance.hardware.keymanager.IKeyManagerVendor
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

        public static IKeyManagerVendor asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IKeyManagerVendor) == false) goto L12;
            return (IKeyManagerVendor) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L35;
                case 2: goto L33;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L25;
                case 7: goto L23;
                case 8: goto L21;
                case 9: goto L19;
                case 10: goto L17;
                case 11: goto L15;
                case 12: goto L13;
                case 13: goto L11;
                case 14: goto L9;
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
            return "udidInvokeCmd";
        L11:
            return "keyAgreement";
        L13:
            return "setSystemSecurityInfo";
        L15:
            return "containsTlsKey";
        L17:
            return "signTlsData";
        L19:
            return "exportTlsCertChain";
        L21:
            return "factoryOperate";
        L23:
            return "sign";
        L25:
            return "keyAttestation";
        L27:
            return "generateKeyPair";
        L29:
            return "deleteSyncKey";
        L31:
            return "xcrypt";
        L33:
            return "importKey";
        L35:
            return "importKeyLegacy";
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
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                default: goto L19;
            };
        L20:
            UDIDRequest _arg0 = (UDIDRequest) data.readTypedObject(UDIDRequest.CREATOR);
            data.enforceNoDataAvail();
            UDIDResult _result = udidInvokeCmd(_arg0);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
        L34:
            return true;
        L21:
            byte[] _arg1 = data.createByteArray();
            KeyParameter[] _arg2 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            KeyAgreementResult _result2 = keyAgreement(_arg1, _arg2);
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L34
        L22:
            SystemSecurityInfo _arg3 = (SystemSecurityInfo) data.readTypedObject(SystemSecurityInfo.CREATOR);
            data.enforceNoDataAvail();
            int _result3 = setSystemSecurityInfo(_arg3);
            reply.writeNoException();
            reply.writeInt(_result3);
            goto L34
        L23:
            String _arg4 = data.readString();
            data.enforceNoDataAvail();
            int _result4 = containsTlsKey(_arg4);
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L34
        L24:
            String _arg5 = data.readString();
            byte[] _arg6 = data.createByteArray();
            KeyParameter[] _arg7 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            SignResult _result5 = signTlsData(_arg5, _arg6, _arg7);
            reply.writeNoException();
            reply.writeTypedObject(_result5, 1);
            goto L34
        L25:
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            TlsCertChainResult _result6 = exportTlsCertChain(_arg8);
            reply.writeNoException();
            reply.writeTypedObject(_result6, 1);
            goto L34
        L26:
            byte[] _arg9 = data.createByteArray();
            data.enforceNoDataAvail();
            ProductionResult _result7 = factoryOperate(_arg9);
            reply.writeNoException();
            reply.writeTypedObject(_result7, 1);
            goto L34
        L27:
            KeyParameter[] _arg10 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            byte[] _arg11 = data.createByteArray();
            data.enforceNoDataAvail();
            SignResult _result8 = sign(_arg10, _arg11);
            reply.writeNoException();
            reply.writeTypedObject(_result8, 1);
            goto L34
        L28:
            KeyParameter[] _arg12 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            byte[] _arg13 = data.createByteArray();
            data.enforceNoDataAvail();
            AttestationResult _result9 = keyAttestation(_arg12, _arg13);
            reply.writeNoException();
            reply.writeTypedObject(_result9, 1);
            goto L34
        L29:
            KeyParameter[] _arg14 = (KeyParameter[]) data.createTypedArray(KeyParameter.CREATOR);
            data.enforceNoDataAvail();
            KeyPairResult _result10 = generateKeyPair(_arg14);
            reply.writeNoException();
            reply.writeTypedObject(_result10, 1);
            goto L34
        L30:
            String _arg15 = data.readString();
            data.enforceNoDataAvail();
            int _result11 = deleteSyncKey(_arg15);
            reply.writeNoException();
            reply.writeInt(_result11);
            goto L34
        L31:
            int _arg16 = data.readInt();
            byte[] _arg17 = data.createByteArray();
            String _arg18 = data.readString();
            byte[] _arg19 = data.createByteArray();
            data.enforceNoDataAvail();
            XcryptResult _result12 = xcrypt(_arg16, _arg17, _arg18, _arg19);
            reply.writeNoException();
            reply.writeTypedObject(_result12, 1);
            goto L34
        L32:
            String _arg20 = data.readString();
            byte[] _arg21 = data.createByteArray();
            ImportParams _arg22 = (ImportParams) data.readTypedObject(ImportParams.CREATOR);
            data.enforceNoDataAvail();
            int _result13 = importKey(_arg20, _arg21, _arg22);
            reply.writeNoException();
            reply.writeInt(_result13);
            goto L34
        L33:
            String _arg23 = data.readString();
            byte[] _arg24 = data.createByteArray();
            ImportParamsLegacy _arg25 = (ImportParamsLegacy) data.readTypedObject(ImportParamsLegacy.CREATOR);
            data.enforceNoDataAvail();
            int _result14 = importKeyLegacy(_arg23, _arg24, _arg25);
            reply.writeNoException();
            reply.writeInt(_result14);
            goto L34
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    int containsTlsKey(String r1) throws RemoteException;

    int deleteSyncKey(String r1) throws RemoteException;

    TlsCertChainResult exportTlsCertChain(String r1) throws RemoteException;

    ProductionResult factoryOperate(byte[] r1) throws RemoteException;

    KeyPairResult generateKeyPair(KeyParameter[] r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    int importKey(String r1, byte[] r2, ImportParams r3) throws RemoteException;

    int importKeyLegacy(String r1, byte[] r2, ImportParamsLegacy r3) throws RemoteException;

    KeyAgreementResult keyAgreement(byte[] r1, KeyParameter[] r2) throws RemoteException;

    AttestationResult keyAttestation(KeyParameter[] r1, byte[] r2) throws RemoteException;

    int setSystemSecurityInfo(SystemSecurityInfo r1) throws RemoteException;

    SignResult sign(KeyParameter[] r1, byte[] r2) throws RemoteException;

    SignResult signTlsData(String r1, byte[] r2, KeyParameter[] r3) throws RemoteException;

    UDIDResult udidInvokeCmd(UDIDRequest r1) throws RemoteException;

    XcryptResult xcrypt(int r1, byte[] r2, String r3, byte[] r4) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$hardware$keymanager$IKeyManagerVendor".replace('$', '.');
    }
}
