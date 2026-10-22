package vendor.bytedance.hardware.agentmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IAgentManagerVendor extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "1ef5deaf4cc5c0415a96f1bbbedd5805bb28d9cd";
    public static final int VERSION = 1;

    public static class Default implements IAgentManagerVendor {
        public Default() {
        }

        @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
        public RegisterResult registerAgent(String agentUuid, byte[] agentData) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
        public RegisterList listRegisteredAgents() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
        public AgentInfoResult getAgentInfo(String agentUuid) throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAgentManagerVendor {
        static final int TRANSACTION_getAgentInfo = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_listRegisteredAgents = 2;
        static final int TRANSACTION_registerAgent = 1;

        private static class Proxy implements IAgentManagerVendor {
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

            @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
            public RegisterResult registerAgent(String agentUuid, byte[] agentData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(agentUuid);     // Catch: Throwable -> L10
                _data.writeByteArray(agentData);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                RegisterResult _result = (RegisterResult) _reply.readTypedObject(RegisterResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method registerAgent is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
            public RegisterList listRegisteredAgents() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                RegisterList _result = (RegisterList) _reply.readTypedObject(RegisterList.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method listRegisteredAgents is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
            public AgentInfoResult getAgentInfo(String agentUuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L10
                _data.writeString(agentUuid);     // Catch: Throwable -> L10
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L10
                if (_status == false) goto L9;
                _reply.readException();     // Catch: Throwable -> L10
                AgentInfoResult _result = (AgentInfoResult) _reply.readTypedObject(AgentInfoResult.CREATOR);     // Catch: Throwable -> L10
                _reply.recycle();
                _data.recycle();
                return _result;
            L9:
                throw new RemoteException("Method getAgentInfo is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
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

            @Override // vendor.bytedance.hardware.agentmanager.IAgentManagerVendor
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

        public static IAgentManagerVendor asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IAgentManagerVendor) == false) goto L12;
            return (IAgentManagerVendor) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L13;
                case 2: goto L11;
                case 3: goto L9;
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
            return "getAgentInfo";
        L11:
            return "listRegisteredAgents";
        L13:
            return "registerAgent";
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
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                default: goto L19;
            };
        L20:
            String _arg0 = data.readString();
            data.enforceNoDataAvail();
            AgentInfoResult _result = getAgentInfo(_arg0);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
        L23:
            return true;
        L21:
            RegisterList _result2 = listRegisteredAgents();
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L23
        L22:
            String _arg1 = data.readString();
            byte[] _arg2 = data.createByteArray();
            data.enforceNoDataAvail();
            RegisterResult _result3 = registerAgent(_arg1, _arg2);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L23
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    AgentInfoResult getAgentInfo(String r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    RegisterList listRegisteredAgents() throws RemoteException;

    RegisterResult registerAgent(String r1, byte[] r2) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$hardware$agentmanager$IAgentManagerVendor".replace('$', '.');
    }
}
