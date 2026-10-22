package android.os;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IPowerAdvisor extends IInterface {

    public static class Default implements IPowerAdvisor {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.os.IPowerAdvisor
        public void disableWifi(String pkgName) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public boolean enableWifi(String pkgName, int timeout) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void enterEnduranceMode(Map params) throws RemoteException {
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
        public boolean inPowerCheckBlacklist(String packageName, int uid) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public boolean isSleepModeSupport() throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void notePowerSceneState(String pkgName, String mainScene, String subScene, int sceneState, String payload) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void noteSystemState(String pkgName, String event, String params) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void notifyLockFreqState(boolean enable) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public boolean setVideoRefreshRate(String packageName, int refreshRate) throws RemoteException {
            return false;
        }

        @Override // android.os.IPowerAdvisor
        public void updateDefaultWhitelist(String[] whitelists) throws RemoteException {
        }

        @Override // android.os.IPowerAdvisor
        public void userSelectedWhitelistApp(String packageName, int type) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IPowerAdvisor {
        private static final String DESCRIPTOR = "android.os.IPowerAdvisor";
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
            public static IPowerAdvisor sDefaultImpl;
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

            @Override // android.os.IPowerAdvisor
            public void updateDefaultWhitelist(String[] whitelists) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringArray(whitelists);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateDefaultWhitelist(whitelists);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public String[] getDefaultWhitelist() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String[] r4 = r1.createStringArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String[] r5 = Stub.getDefaultImpl().getDefaultWhitelist();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void userSelectedWhitelistApp(String packageName, int type) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(packageName);     // Catch: Throwable -> L13
                r0.writeInt(type);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().userSelectedWhitelistApp(packageName, type);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public int getLongTimeNoResumeDay() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getLongTimeNoResumeDay();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean inPowerCheckBlacklist(String packageName, int uid) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(packageName);     // Catch: Throwable -> L15
                r0.writeInt(uid);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().inPowerCheckBlacklist(packageName, uid);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean isSleepModeSupport() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isSleepModeSupport();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean inNetWindowAllow() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().inNetWindowAllow();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void notifyLockFreqState(boolean enable) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (enable == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyLockFreqState(enable);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void enterEnduranceMode(Map params) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeMap(params);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().enterEnduranceMode(params);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void notePowerSceneState(String pkgName, String mainScene, String subScene, int sceneState, String payload) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(pkgName);     // Catch: Throwable -> L12
                r0.writeString(mainScene);     // Catch: Throwable -> L12
                r0.writeString(subScene);     // Catch: Throwable -> L12
                r0.writeInt(sceneState);     // Catch: Throwable -> L12
                r0.writeString(payload);     // Catch: Throwable -> L12
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notePowerSceneState(pkgName, mainScene, subScene, sceneState, payload);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean enableWifi(String pkgName, int timeout) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(pkgName);     // Catch: Throwable -> L15
                r0.writeInt(timeout);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().enableWifi(pkgName, timeout);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void disableWifi(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disableWifi(pkgName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public void noteSystemState(String pkgName, String event, String params) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(pkgName);     // Catch: Throwable -> L12
                r0.writeString(event);     // Catch: Throwable -> L12
                r0.writeString(params);     // Catch: Throwable -> L12
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().noteSystemState(pkgName, event, params);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IPowerAdvisor
            public boolean setVideoRefreshRate(String packageName, int refreshRate) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(packageName);     // Catch: Throwable -> L15
                r0.writeInt(refreshRate);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setVideoRefreshRate(packageName, refreshRate);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IPowerAdvisor asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IPowerAdvisor) == false) goto L12;
            return (IPowerAdvisor) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L39;
            switch(r9) {
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L33;
                case 4: goto L31;
                case 5: goto L29;
                case 6: goto L27;
                case 7: goto L25;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L9;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface(DESCRIPTOR);
            boolean r8 = setVideoRefreshRate(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r8 ? 1 : 0);
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            noteSystemState(r10.readString(), r10.readString(), r10.readString());
            return true;
        L11:
            r10.enforceInterface(DESCRIPTOR);
            disableWifi(r10.readString());
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            boolean r13 = enableWifi(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            notePowerSceneState(r10.readString(), r10.readString(), r10.readString(), r10.readInt(), r10.readString());
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            enterEnduranceMode(r10.readHashMap(getClass().getClassLoader()));
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L22;
            boolean r14 = true;
        L23:
            notifyLockFreqState(r14);
            r11.writeNoException();
            return true;
        L22:
            r14 = false;
            goto L23
        L25:
            r10.enforceInterface(DESCRIPTOR);
            boolean r15 = inNetWindowAllow();
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L27:
            r10.enforceInterface(DESCRIPTOR);
            boolean r16 = isSleepModeSupport();
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L29:
            r10.enforceInterface(DESCRIPTOR);
            boolean r17 = inPowerCheckBlacklist(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r17 ? 1 : 0);
            return true;
        L31:
            r10.enforceInterface(DESCRIPTOR);
            int r18 = getLongTimeNoResumeDay();
            r11.writeNoException();
            r11.writeInt(r18);
            return true;
        L33:
            r10.enforceInterface(DESCRIPTOR);
            userSelectedWhitelistApp(r10.readString(), r10.readInt());
            r11.writeNoException();
            return true;
        L35:
            r10.enforceInterface(DESCRIPTOR);
            String[] r19 = getDefaultWhitelist();
            r11.writeNoException();
            r11.writeStringArray(r19);
            return true;
        L37:
            r10.enforceInterface(DESCRIPTOR);
            updateDefaultWhitelist(r10.createStringArray());
            r11.writeNoException();
            return true;
        L6:
            return super.onTransact(r9, r10, r11, r12);
        L39:
            r11.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IPowerAdvisor impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IPowerAdvisor getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void disableWifi(String pkgName) throws RemoteException;

    boolean enableWifi(String pkgName, int timeout) throws RemoteException;

    void enterEnduranceMode(Map params) throws RemoteException;

    String[] getDefaultWhitelist() throws RemoteException;

    int getLongTimeNoResumeDay() throws RemoteException;

    boolean inNetWindowAllow() throws RemoteException;

    boolean inPowerCheckBlacklist(String packageName, int uid) throws RemoteException;

    boolean isSleepModeSupport() throws RemoteException;

    void notePowerSceneState(String pkgName, String mainScene, String subScene, int sceneState, String payload) throws RemoteException;

    void noteSystemState(String pkgName, String event, String params) throws RemoteException;

    void notifyLockFreqState(boolean enable) throws RemoteException;

    boolean setVideoRefreshRate(String packageName, int refreshRate) throws RemoteException;

    void updateDefaultWhitelist(String[] whitelists) throws RemoteException;

    void userSelectedWhitelistApp(String packageName, int type) throws RemoteException;
}
