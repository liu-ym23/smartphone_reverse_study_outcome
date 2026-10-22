package com.bytedanceos.recorder.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IRecorderCreatorService extends IInterface {

    public static abstract class Stub extends Binder implements IRecorderCreatorService {
        private static final String DESCRIPTOR = "com.bytedanceos.recorder.service.IRecorderCreatorService";
        static final int TRANSACTION_getRecordingCurrentState = 5;
        static final int TRANSACTION_getRecordingState = 9;
        static final int TRANSACTION_mark = 8;
        static final int TRANSACTION_pauseRecording = 2;
        static final int TRANSACTION_registerRecordingCallback = 6;
        static final int TRANSACTION_resumeRecording = 3;
        static final int TRANSACTION_setLastRecordTimeWhenUIDown = 12;
        static final int TRANSACTION_startRecording = 1;
        static final int TRANSACTION_stopRecording = 4;
        static final int TRANSACTION_stopRecordingTemporarily = 11;
        static final int TRANSACTION_stopRecordingWithNotification = 10;
        static final int TRANSACTION_unregisterRecordingCallback = 7;

        private static class Proxy implements IRecorderCreatorService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void startRecording(String srcDir, String srcName, int format, int sampleRate, int channel, int bitrate, ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(srcDir);     // Catch: Throwable -> L10
                r0.writeString(srcName);     // Catch: Throwable -> L10
                r0.writeInt(format);     // Catch: Throwable -> L10
                r0.writeInt(sampleRate);     // Catch: Throwable -> L10
                r0.writeInt(channel);     // Catch: Throwable -> L10
                r0.writeInt(bitrate);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void pauseRecording(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void resumeRecording(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void stopRecording(String newName, ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(newName);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void getRecordingCurrentState(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void registerRecordingCallback(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void unregisterRecordingCallback(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void mark(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public int getRecordingState() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void stopRecordingWithNotification(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(10, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void stopRecordingTemporarily(ICallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (callback == null) goto L6;
                IBinder r4 = callback.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L10
                this.mRemote.transact(11, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r4 = null;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.recorder.service.IRecorderCreatorService
            public void setLastRecordTimeWhenUIDown(long seconds) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(seconds);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRecorderCreatorService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IRecorderCreatorService) == false) goto L12;
            return (IRecorderCreatorService) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) goto L31;
            switch(code) {
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            data.enforceInterface(DESCRIPTOR);
            setLastRecordTimeWhenUIDown(data.readLong());
            return true;
        L9:
            data.enforceInterface(DESCRIPTOR);
            stopRecordingTemporarily(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L11:
            data.enforceInterface(DESCRIPTOR);
            stopRecordingWithNotification(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L13:
            data.enforceInterface(DESCRIPTOR);
            int r10 = getRecordingState();
            reply.writeNoException();
            reply.writeInt(r10);
            return true;
        L15:
            data.enforceInterface(DESCRIPTOR);
            mark(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L17:
            data.enforceInterface(DESCRIPTOR);
            unregisterRecordingCallback(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L19:
            data.enforceInterface(DESCRIPTOR);
            registerRecordingCallback(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L21:
            data.enforceInterface(DESCRIPTOR);
            getRecordingCurrentState(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L23:
            data.enforceInterface(DESCRIPTOR);
            stopRecording(data.readString(), ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L25:
            data.enforceInterface(DESCRIPTOR);
            resumeRecording(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L27:
            data.enforceInterface(DESCRIPTOR);
            pauseRecording(ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L29:
            data.enforceInterface(DESCRIPTOR);
            startRecording(data.readString(), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt(), ICallback.Stub.asInterface(data.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(code, data, reply, flags);
        L31:
            reply.writeString(DESCRIPTOR);
            return true;
        }
    }

    void getRecordingCurrentState(ICallback callback) throws RemoteException;

    int getRecordingState() throws RemoteException;

    void mark(ICallback callback) throws RemoteException;

    void pauseRecording(ICallback callback) throws RemoteException;

    void registerRecordingCallback(ICallback callback) throws RemoteException;

    void resumeRecording(ICallback callback) throws RemoteException;

    void setLastRecordTimeWhenUIDown(long seconds) throws RemoteException;

    void startRecording(String srcDir, String srcName, int format, int sampleRate, int channel, int bitrate, ICallback callback) throws RemoteException;

    void stopRecording(String newName, ICallback callback) throws RemoteException;

    void stopRecordingTemporarily(ICallback callback) throws RemoteException;

    void stopRecordingWithNotification(ICallback callback) throws RemoteException;

    void unregisterRecordingCallback(ICallback callback) throws RemoteException;
}
