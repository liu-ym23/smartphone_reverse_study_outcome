package com.obric.security.audit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IObricAuditManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.security.audit.IObricAuditManager";

    public static class Default implements IObricAuditManager {
        public Default() {
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public int recordAuditWithResult(String json) throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public List<String> queryLogs(long startTimeMs, long endTimeMs, String targetIntent, String targetActivity) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public ParcelFileDescriptor exportAllLogs(long startTimeMs, long endTimeMs, boolean gzip) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public int setActiveSession(String sessionId, long ttlMs) throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public void clearActiveSession(String sessionId) throws RemoteException {
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public int getPendingUploadCount() throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public String getPendingUploadReport(int maxCount, int maxBytes) throws RemoteException {
            return null;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public int confirmUploadSuccess(String batchId) throws RemoteException {
            return 0;
        }

        @Override // com.obric.security.audit.IObricAuditManager
        public int confirmUploadFailure(String batchId, int errorCode, String errorMessage) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObricAuditManager {
        static final int TRANSACTION_clearActiveSession = 5;
        static final int TRANSACTION_confirmUploadFailure = 9;
        static final int TRANSACTION_confirmUploadSuccess = 8;
        static final int TRANSACTION_exportAllLogs = 3;
        static final int TRANSACTION_getPendingUploadCount = 6;
        static final int TRANSACTION_getPendingUploadReport = 7;
        static final int TRANSACTION_queryLogs = 2;
        static final int TRANSACTION_recordAuditWithResult = 1;
        static final int TRANSACTION_setActiveSession = 4;

        private static class Proxy implements IObricAuditManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IObricAuditManager.DESCRIPTOR;
            }

            @Override // com.obric.security.audit.IObricAuditManager
            public int recordAuditWithResult(String json) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(json);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public List<String> queryLogs(long startTimeMs, long endTimeMs, String targetIntent, String targetActivity) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeLong(startTimeMs);     // Catch: Throwable -> L6
                _data.writeLong(endTimeMs);     // Catch: Throwable -> L6
                _data.writeString(targetIntent);     // Catch: Throwable -> L6
                _data.writeString(targetActivity);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                List<String> _result = _reply.createStringArrayList();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.audit.IObricAuditManager
            public ParcelFileDescriptor exportAllLogs(long startTimeMs, long endTimeMs, boolean gzip) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeLong(startTimeMs);     // Catch: Throwable -> L6
                _data.writeLong(endTimeMs);     // Catch: Throwable -> L6
                _data.writeBoolean(gzip);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                ParcelFileDescriptor _result = (ParcelFileDescriptor) _reply.readTypedObject(ParcelFileDescriptor.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.obric.security.audit.IObricAuditManager
            public int setActiveSession(String sessionId, long ttlMs) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(sessionId);     // Catch: Throwable -> L6
                _data.writeLong(ttlMs);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public void clearActiveSession(String sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(sessionId);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public int getPendingUploadCount() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public String getPendingUploadReport(int maxCount, int maxBytes) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(maxCount);     // Catch: Throwable -> L6
                _data.writeInt(maxBytes);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public int confirmUploadSuccess(String batchId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(batchId);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.security.audit.IObricAuditManager
            public int confirmUploadFailure(String batchId, int errorCode, String errorMessage) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IObricAuditManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(batchId);     // Catch: Throwable -> L6
                _data.writeInt(errorCode);     // Catch: Throwable -> L6
                _data.writeString(errorMessage);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IObricAuditManager.DESCRIPTOR);
        }

        public static IObricAuditManager asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IObricAuditManager.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IObricAuditManager) == false) goto L12;
            return (IObricAuditManager) iin;
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
            data.enforceInterface(IObricAuditManager.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IObricAuditManager.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            int _arg1 = data.readInt();
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            int _result = confirmUploadFailure(_arg0, _arg1, _arg2);
            reply.writeNoException();
            reply.writeInt(_result);
        L23:
            return true;
        L15:
            String _arg3 = data.readString();
            data.enforceNoDataAvail();
            int _result2 = confirmUploadSuccess(_arg3);
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L23
        L16:
            int _arg4 = data.readInt();
            int _arg5 = data.readInt();
            data.enforceNoDataAvail();
            String _result3 = getPendingUploadReport(_arg4, _arg5);
            reply.writeNoException();
            reply.writeString(_result3);
            goto L23
        L17:
            int _result4 = getPendingUploadCount();
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L23
        L18:
            String _arg6 = data.readString();
            data.enforceNoDataAvail();
            clearActiveSession(_arg6);
            reply.writeNoException();
            goto L23
        L19:
            String _arg7 = data.readString();
            long _arg8 = data.readLong();
            data.enforceNoDataAvail();
            int _result5 = setActiveSession(_arg7, _arg8);
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L23
        L20:
            long _arg9 = data.readLong();
            long _arg10 = data.readLong();
            boolean _arg11 = data.readBoolean();
            data.enforceNoDataAvail();
            ParcelFileDescriptor _result6 = exportAllLogs(_arg9, _arg10, _arg11);
            reply.writeNoException();
            reply.writeTypedObject(_result6, 1);
            goto L23
        L21:
            long _arg12 = data.readLong();
            long _arg13 = data.readLong();
            String _arg14 = data.readString();
            String _arg15 = data.readString();
            data.enforceNoDataAvail();
            List<String> _result7 = queryLogs(_arg12, _arg13, _arg14, _arg15);
            reply.writeNoException();
            reply.writeStringList(_result7);
            goto L23
        L22:
            String _arg16 = data.readString();
            data.enforceNoDataAvail();
            int _result8 = recordAuditWithResult(_arg16);
            reply.writeNoException();
            reply.writeInt(_result8);
            goto L23
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void clearActiveSession(String r1) throws RemoteException;

    int confirmUploadFailure(String r1, int r2, String r3) throws RemoteException;

    int confirmUploadSuccess(String r1) throws RemoteException;

    ParcelFileDescriptor exportAllLogs(long r1, long r3, boolean r5) throws RemoteException;

    int getPendingUploadCount() throws RemoteException;

    String getPendingUploadReport(int r1, int r2) throws RemoteException;

    List<String> queryLogs(long r1, long r3, String r5, String r6) throws RemoteException;

    int recordAuditWithResult(String r1) throws RemoteException;

    int setActiveSession(String r1, long r2) throws RemoteException;
}
