package com.obric.recorder.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IRecorderCreatorService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.recorder.service.IRecorderCreatorService";

    public static class Default implements IRecorderCreatorService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void getRecordingCurrentState(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public int getRecordingState() throws RemoteException {
            return 0;
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void mark(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void pauseRecording(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void registerRecordingCallback(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void resumeRecording(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void startRecording(String r1, String r2, int r3, int r4, int r5, int r6, ICallback r7) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void stopRecording(String r1, ICallback r2) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void stopRecordingTemporarily(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void stopRecordingWithNotification(ICallback r1) throws RemoteException {
        }

        @Override // com.obric.recorder.service.IRecorderCreatorService
        public void unregisterRecordingCallback(ICallback r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IRecorderCreatorService {
        static final int TRANSACTION_getRecordingCurrentState = 5;
        static final int TRANSACTION_getRecordingState = 9;
        static final int TRANSACTION_mark = 8;
        static final int TRANSACTION_pauseRecording = 2;
        static final int TRANSACTION_registerRecordingCallback = 6;
        static final int TRANSACTION_resumeRecording = 3;
        static final int TRANSACTION_startRecording = 1;
        static final int TRANSACTION_stopRecording = 4;
        static final int TRANSACTION_stopRecordingTemporarily = 11;
        static final int TRANSACTION_stopRecordingWithNotification = 10;
        static final int TRANSACTION_unregisterRecordingCallback = 7;

        private static class Proxy implements IRecorderCreatorService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IRecorderCreatorService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void startRecording(String r3, String r4, int r5, int r6, int r7, int r8, ICallback r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r9);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void pauseRecording(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void resumeRecording(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void stopRecording(String r3, ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void getRecordingCurrentState(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void registerRecordingCallback(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void unregisterRecordingCallback(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void mark(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public int getRecordingState() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void stopRecordingWithNotification(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.recorder.service.IRecorderCreatorService
            public void stopRecordingTemporarily(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IRecorderCreatorService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, null, 1);     // Catch: Throwable -> L6
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
            attachInterface(this, IRecorderCreatorService.DESCRIPTOR);
        }

        public static IRecorderCreatorService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IRecorderCreatorService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IRecorderCreatorService) == false) goto L12;
            return (IRecorderCreatorService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface(IRecorderCreatorService.DESCRIPTOR);
        L8:
            if (r11 == 1598968902) goto L24;
            switch(r11) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                default: goto L11;
            };
        L12:
            stopRecordingTemporarily(ICallback.Stub.asInterface(r12.readStrongBinder()));
        L23:
            return true;
        L13:
            stopRecordingWithNotification(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L14:
            int r10 = getRecordingState();
            r13.writeNoException();
            r13.writeInt(r10);
            goto L23
        L15:
            mark(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L16:
            unregisterRecordingCallback(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L17:
            registerRecordingCallback(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L18:
            getRecordingCurrentState(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L19:
            stopRecording(r12.readString(), ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L20:
            resumeRecording(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L21:
            pauseRecording(ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L22:
            startRecording(r12.readString(), r12.readString(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), ICallback.Stub.asInterface(r12.readStrongBinder()));
            goto L23
        L11:
            return super.onTransact(r11, r12, r13, r14);
        L24:
            r13.writeString(IRecorderCreatorService.DESCRIPTOR);
            return true;
        }
    }

    void getRecordingCurrentState(ICallback r1) throws RemoteException;

    int getRecordingState() throws RemoteException;

    void mark(ICallback r1) throws RemoteException;

    void pauseRecording(ICallback r1) throws RemoteException;

    void registerRecordingCallback(ICallback r1) throws RemoteException;

    void resumeRecording(ICallback r1) throws RemoteException;

    void startRecording(String r1, String r2, int r3, int r4, int r5, int r6, ICallback r7) throws RemoteException;

    void stopRecording(String r1, ICallback r2) throws RemoteException;

    void stopRecordingTemporarily(ICallback r1) throws RemoteException;

    void stopRecordingWithNotification(ICallback r1) throws RemoteException;

    void unregisterRecordingCallback(ICallback r1) throws RemoteException;
}
