package android.os;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IPowerAdvisor extends IInterface {
    public static final String DESCRIPTOR = "android.os.IPowerAdvisor";

    public static class Default implements IPowerAdvisor {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.os.IPowerAdvisor
        public void disableWifi(String r1) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public boolean enableWifi(String r1, int r2) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void enterEnduranceMode(Map r1) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public String[] getDefaultWhitelist() throws RemoteException {
            return null;
        }

        @Override // android.os.IPowerAdvisor
        public int getLongTimeNoResumeDay() throws RemoteException {
            return 0;
        }

        @Override // android.os.IPowerAdvisor
        public boolean inNetWindowAllow() throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public boolean inPowerCheckBlacklist(String r1, int r2) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public boolean isSleepModeSupport() throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void notePowerSceneState(String r1, String r2, String r3, int r4, String r5) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void noteSystemState(String r1, String r2, String r3) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void notifyLockFreqState(boolean r1) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public boolean setVideoRefreshRate(String r1, int r2) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void updateDefaultWhitelist(String[] r1) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void userSelectedWhitelistApp(String r1, int r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IPowerAdvisor {
        static final int TRANSACTION_disableWifi = 12;
        static final int TRANSACTION_enableWifi = 11;
        static final int TRANSACTION_enterEnduranceMode = 9;
        static final int TRANSACTION_getDefaultWhitelist = 2;
        static final int TRANSACTION_getLongTimeNoResumeDay = 4;
        static final int TRANSACTION_inNetWindowAllow = 7;
        static final int TRANSACTION_inPowerCheckBlacklist = 5;
        static final int TRANSACTION_isSleepModeSupport = 6;
        static final int TRANSACTION_notePowerSceneState = 10;
        static final int TRANSACTION_noteSystemState = 13;
        static final int TRANSACTION_notifyLockFreqState = 8;
        static final int TRANSACTION_setVideoRefreshRate = 14;
        static final int TRANSACTION_updateDefaultWhitelist = 1;
        static final int TRANSACTION_userSelectedWhitelistApp = 3;

        private static class Proxy implements IPowerAdvisor {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IPowerAdvisor.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.os.IPowerAdvisor
            public void updateDefaultWhitelist(String[] r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringArray(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IPowerAdvisor
            public String[] getDefaultWhitelist() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String[] r4 = r1.createStringArray();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void userSelectedWhitelistApp(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IPowerAdvisor
            public int getLongTimeNoResumeDay() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IPowerAdvisor
            public boolean inPowerCheckBlacklist(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // android.os.IPowerAdvisor
            public boolean isSleepModeSupport() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // android.os.IPowerAdvisor
            public boolean inNetWindowAllow() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // android.os.IPowerAdvisor
            public void notifyLockFreqState(boolean r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void enterEnduranceMode(Map r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeMap(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IPowerAdvisor
            public void notePowerSceneState(String r3, String r4, String r5, int r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean enableWifi(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // android.os.IPowerAdvisor
            public void disableWifi(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IPowerAdvisor
            public void noteSystemState(String r3, String r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean setVideoRefreshRate(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IPowerAdvisor.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L8
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPowerAdvisor.DESCRIPTOR);
        }

        public static IPowerAdvisor asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IPowerAdvisor.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IPowerAdvisor) == false) goto L12;
            return (IPowerAdvisor) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 < 1) goto L8;
            if (r9 > 16777215) goto L8;
            r10.enforceInterface(IPowerAdvisor.DESCRIPTOR);
        L8:
            if (r9 == 1598968902) goto L31;
            switch(r9) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                default: goto L11;
            };
        L12:
            boolean r8 = setVideoRefreshRate(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r8 ? 1 : 0);
        L30:
            return true;
        L13:
            noteSystemState(r10.readString(), r10.readString(), r10.readString());
            goto L30
        L14:
            disableWifi(r10.readString());
            r11.writeNoException();
            goto L30
        L15:
            boolean r13 = enableWifi(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            goto L30
        L16:
            notePowerSceneState(r10.readString(), r10.readString(), r10.readString(), r10.readInt(), r10.readString());
            goto L30
        L17:
            enterEnduranceMode(r10.readHashMap(getClass().getClassLoader()));
            r11.writeNoException();
            goto L30
        L23:
            boolean r14 = inNetWindowAllow();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            goto L30
        L24:
            boolean r15 = isSleepModeSupport();
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            goto L30
        L25:
            boolean r16 = inPowerCheckBlacklist(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            goto L30
        L26:
            int r17 = getLongTimeNoResumeDay();
            r11.writeNoException();
            r11.writeInt(r17);
            goto L30
        L27:
            userSelectedWhitelistApp(r10.readString(), r10.readInt());
            r11.writeNoException();
            goto L30
        L28:
            String[] r18 = getDefaultWhitelist();
            r11.writeNoException();
            r11.writeStringArray(r18);
            goto L30
        L29:
            updateDefaultWhitelist(r10.createStringArray());
            r11.writeNoException();
            goto L30
        L11:
            return super.onTransact(r9, r10, r11, r12);
        L19:
            if (r10.readInt() == 0) goto L21;
            boolean r19 = true;
        L22:
            notifyLockFreqState(r19);
            r11.writeNoException();
            goto L30
        L21:
            r19 = false;
            goto L22
        L31:
            r11.writeString(IPowerAdvisor.DESCRIPTOR);
            return true;
        }
    }

    void disableWifi(String r1) throws RemoteException;

    boolean enableWifi(String r1, int r2) throws RemoteException;

    void enterEnduranceMode(Map r1) throws RemoteException;

    String[] getDefaultWhitelist() throws RemoteException;

    int getLongTimeNoResumeDay() throws RemoteException;

    boolean inNetWindowAllow() throws RemoteException;

    boolean inPowerCheckBlacklist(String r1, int r2) throws RemoteException;

    boolean isSleepModeSupport() throws RemoteException;

    void notePowerSceneState(String r1, String r2, String r3, int r4, String r5) throws RemoteException;

    void noteSystemState(String r1, String r2, String r3) throws RemoteException;

    void notifyLockFreqState(boolean r1) throws RemoteException;

    boolean setVideoRefreshRate(String r1, int r2) throws RemoteException;

    void updateDefaultWhitelist(String[] r1) throws RemoteException;

    void userSelectedWhitelistApp(String r1, int r2) throws RemoteException;
}
