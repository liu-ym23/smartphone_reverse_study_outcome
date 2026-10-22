package com.zte.board.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IBoardEngine extends IInterface {
    public static final String DESCRIPTOR = "com.zte.board.engine.IBoardEngine";

    public static class Default implements IBoardEngine {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean checkSecureToolsAuthentication(int r1) throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean deletePersistFile(String r1) throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean performSecureAuthentication(int r1, String r2, String r3, String r4) throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public byte[] readPersistFile(String r1) throws RemoteException {
            return null;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean registerCallback(IBoardEngineCallback r1, int[] r2) throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean resetAuthenticationData() throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public void setBrightness(int r1) throws RemoteException {
        }

        @Override // com.zte.board.engine.IBoardEngine
        public void setLCDParams(int r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException {
        }

        @Override // com.zte.board.engine.IBoardEngine
        public int setupSensorCalibration(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean unregisterCallback(IBoardEngineCallback r1) throws RemoteException {
            return false;
        }

        @Override // com.zte.board.engine.IBoardEngine
        public boolean writePersistFile(String r1, byte[] r2) throws RemoteException {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IBoardEngine {
        static final int TRANSACTION_checkSecureToolsAuthentication = 7;
        static final int TRANSACTION_deletePersistFile = 5;
        static final int TRANSACTION_performSecureAuthentication = 6;
        static final int TRANSACTION_readPersistFile = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_resetAuthenticationData = 8;
        static final int TRANSACTION_setBrightness = 10;
        static final int TRANSACTION_setLCDParams = 11;
        static final int TRANSACTION_setupSensorCalibration = 9;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_writePersistFile = 4;

        private static class Proxy implements IBoardEngine {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IBoardEngine.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean registerCallback(IBoardEngineCallback r4, int[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L8
                r0.writeIntArray(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r6;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean unregisterCallback(IBoardEngineCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public byte[] readPersistFile(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte[] r3 = r1.createByteArray();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean writePersistFile(String r4, byte[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeByteArray(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r6;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean deletePersistFile(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean performSecureAuthentication(int r4, String r5, String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                r0.writeString(r5);     // Catch: Throwable -> L8
                r0.writeString(r6);     // Catch: Throwable -> L8
                r0.writeString(r7);     // Catch: Throwable -> L8
                boolean r8 = false;
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r8 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean checkSecureToolsAuthentication(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public boolean resetAuthenticationData() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public int setupSensorCalibration(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public void setBrightness(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.zte.board.engine.IBoardEngine
            public void setLCDParams(int r4, int r5, int r6, int r7, int r8, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBoardEngine.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                r0.writeInt(r9);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBoardEngine.DESCRIPTOR);
        }

        public static IBoardEngine asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IBoardEngine.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBoardEngine) == false) goto L12;
            return (IBoardEngine) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface(IBoardEngine.DESCRIPTOR);
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
            setLCDParams(r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt());
            r13.writeNoException();
        L23:
            return true;
        L13:
            setBrightness(r12.readInt());
            r13.writeNoException();
            goto L23
        L14:
            int r10 = setupSensorCalibration(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r10);
            goto L23
        L15:
            boolean r15 = resetAuthenticationData();
            r13.writeNoException();
            r13.writeInt(r15 ? 1 : 0);
            goto L23
        L16:
            boolean r16 = checkSecureToolsAuthentication(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r16 ? 1 : 0);
            goto L23
        L17:
            boolean r17 = performSecureAuthentication(r12.readInt(), r12.readString(), r12.readString(), r12.readString());
            r13.writeNoException();
            r13.writeInt(r17 ? 1 : 0);
            goto L23
        L18:
            boolean r18 = deletePersistFile(r12.readString());
            r13.writeNoException();
            r13.writeInt(r18 ? 1 : 0);
            goto L23
        L19:
            boolean r19 = writePersistFile(r12.readString(), r12.createByteArray());
            r13.writeNoException();
            r13.writeInt(r19 ? 1 : 0);
            goto L23
        L20:
            byte[] r110 = readPersistFile(r12.readString());
            r13.writeNoException();
            r13.writeByteArray(r110);
            goto L23
        L21:
            boolean r111 = unregisterCallback(IBoardEngineCallback.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            r13.writeInt(r111 ? 1 : 0);
            goto L23
        L22:
            boolean r112 = registerCallback(IBoardEngineCallback.Stub.asInterface(r12.readStrongBinder()), r12.createIntArray());
            r13.writeNoException();
            r13.writeInt(r112 ? 1 : 0);
            goto L23
        L11:
            return super.onTransact(r11, r12, r13, r14);
        L24:
            r13.writeString(IBoardEngine.DESCRIPTOR);
            return true;
        }
    }

    boolean checkSecureToolsAuthentication(int r1) throws RemoteException;

    boolean deletePersistFile(String r1) throws RemoteException;

    boolean performSecureAuthentication(int r1, String r2, String r3, String r4) throws RemoteException;

    byte[] readPersistFile(String r1) throws RemoteException;

    boolean registerCallback(IBoardEngineCallback r1, int[] r2) throws RemoteException;

    boolean resetAuthenticationData() throws RemoteException;

    void setBrightness(int r1) throws RemoteException;

    void setLCDParams(int r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException;

    int setupSensorCalibration(int r1) throws RemoteException;

    boolean unregisterCallback(IBoardEngineCallback r1) throws RemoteException;

    boolean writePersistFile(String r1, byte[] r2) throws RemoteException;
}
