package com.qti.snapdragon.sdk.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IColorService extends IInterface {

    public static class Default implements IColorService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int createNewMode(int r1, String r2, long r3, int r5) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int createNewModeAllFeatures(int r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int deleteMode(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int disableMemoryColorConfiguration(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public long[] getActiveMode(int r1) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getAdaptiveBacklightScale(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getBacklightQualityLevel(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getColorBalance(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getDefaultMode(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int[] getMemoryColorParameters(int r1, int r2) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public ModeInfo[] getModes(int r1, int r2) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getNumModes(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int[] getPAParameters(int r1) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int[] getRangeMemoryColorParameter(int r1, int r2) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int[] getRangePAParameter(int r1) throws RemoteException {
            return null;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getRangeSunlightVisibilityStrength(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int getSunlightVisibilityStrength(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int isActiveFeatureOn(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public boolean isFeatureSupported(int r1, int r2) throws RemoteException {
            return false;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int modifyMode(int r1, int r2, String r3, long r4, int r6) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int modifyModeAllFeatures(int r1, int r2, String r3) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public void release() throws RemoteException {
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setActiveFeatureControl(int r1, int r2, int r3) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setActiveMode(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setBacklightQualityLevel(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setColorBalance(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setDefaultMode(int r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setMemoryColorParameters(int r1, int r2, int r3, int r4, int r5) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setPAParameters(int r1, int r2, int r3, int r4, int r5, int r6, int r7) throws RemoteException {
            return 0;
        }

        @Override // com.qti.snapdragon.sdk.display.IColorService
        public int setSunlightVisibilityStrength(int r1, int r2) throws RemoteException {
            return 0;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IColorService {
        private static final String DESCRIPTOR = "com.qti.snapdragon.sdk.display.IColorService";
        static final int TRANSACTION_createNewMode = 9;
        static final int TRANSACTION_createNewModeAllFeatures = 13;
        static final int TRANSACTION_deleteMode = 7;
        static final int TRANSACTION_disableMemoryColorConfiguration = 26;
        static final int TRANSACTION_getActiveMode = 5;
        static final int TRANSACTION_getAdaptiveBacklightScale = 20;
        static final int TRANSACTION_getBacklightQualityLevel = 18;
        static final int TRANSACTION_getColorBalance = 3;
        static final int TRANSACTION_getDefaultMode = 11;
        static final int TRANSACTION_getMemoryColorParameters = 25;
        static final int TRANSACTION_getModes = 8;
        static final int TRANSACTION_getNumModes = 4;
        static final int TRANSACTION_getPAParameters = 29;
        static final int TRANSACTION_getRangeMemoryColorParameter = 23;
        static final int TRANSACTION_getRangePAParameter = 27;
        static final int TRANSACTION_getRangeSunlightVisibilityStrength = 15;
        static final int TRANSACTION_getSunlightVisibilityStrength = 17;
        static final int TRANSACTION_isActiveFeatureOn = 21;
        static final int TRANSACTION_isFeatureSupported = 1;
        static final int TRANSACTION_modifyMode = 10;
        static final int TRANSACTION_modifyModeAllFeatures = 14;
        static final int TRANSACTION_release = 30;
        static final int TRANSACTION_setActiveFeatureControl = 22;
        static final int TRANSACTION_setActiveMode = 6;
        static final int TRANSACTION_setBacklightQualityLevel = 19;
        static final int TRANSACTION_setColorBalance = 2;
        static final int TRANSACTION_setDefaultMode = 12;
        static final int TRANSACTION_setMemoryColorParameters = 24;
        static final int TRANSACTION_setPAParameters = 28;
        static final int TRANSACTION_setSunlightVisibilityStrength = 16;

        private static class Proxy implements IColorService {
            public static IColorService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public boolean isFeatureSupported(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r2 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r2 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isFeatureSupported(r5, r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setColorBalance(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().setColorBalance(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getColorBalance(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getColorBalance(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getNumModes(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().getNumModes(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public long[] getActiveMode(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long[] r4 = r1.createLongArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long[] r6 = Stub.getDefaultImpl().getActiveMode(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setActiveMode(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().setActiveMode(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int deleteMode(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().deleteMode(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public ModeInfo[] getModes(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ModeInfo[] r4 = (ModeInfo[]) r1.createTypedArray(ModeInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ModeInfo[] r7 = Stub.getDefaultImpl().getModes(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int createNewMode(int r9, String r10, long r11, int r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                r0.writeLong(r11);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r12 = Stub.getDefaultImpl().createNewMode(r9, r10, r11, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r12;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int modifyMode(int r10, int r11, String r12, long r13, int r15) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeString(r12);     // Catch: Throwable -> L13
                r0.writeLong(r13);     // Catch: Throwable -> L13
                r0.writeInt(r15);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r9 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r14 = Stub.getDefaultImpl().modifyMode(r10, r11, r12, r13, r15);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r14;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getDefaultMode(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getDefaultMode(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setDefaultMode(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().setDefaultMode(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int createNewModeAllFeatures(int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().createNewModeAllFeatures(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int modifyModeAllFeatures(int r5, int r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().modifyModeAllFeatures(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getRangeSunlightVisibilityStrength(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().getRangeSunlightVisibilityStrength(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setSunlightVisibilityStrength(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().setSunlightVisibilityStrength(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getSunlightVisibilityStrength(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getSunlightVisibilityStrength(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getBacklightQualityLevel(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getBacklightQualityLevel(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setBacklightQualityLevel(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().setBacklightQualityLevel(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int getAdaptiveBacklightScale(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getAdaptiveBacklightScale(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int isActiveFeatureOn(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().isActiveFeatureOn(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setActiveFeatureControl(int r5, int r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().setActiveFeatureControl(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int[] getRangeMemoryColorParameter(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r7 = Stub.getDefaultImpl().getRangeMemoryColorParameter(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setMemoryColorParameters(int r9, int r10, int r11, int r12, int r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(24, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r14 = Stub.getDefaultImpl().setMemoryColorParameters(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r14;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int[] getMemoryColorParameters(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(25, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r7 = Stub.getDefaultImpl().getMemoryColorParameters(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int disableMemoryColorConfiguration(int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(26, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().disableMemoryColorConfiguration(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int[] getRangePAParameter(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(27, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r6 = Stub.getDefaultImpl().getRangePAParameter(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int setPAParameters(int r13, int r14, int r15, int r16, int r17, int r18, int r19) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r1.writeInt(r13);     // Catch: Throwable -> L13
                r1.writeInt(r14);     // Catch: Throwable -> L13
                r1.writeInt(r15);     // Catch: Throwable -> L13
                r1.writeInt(r16);     // Catch: Throwable -> L13
                r1.writeInt(r17);     // Catch: Throwable -> L13
                r1.writeInt(r18);     // Catch: Throwable -> L13
                r1.writeInt(r19);     // Catch: Throwable -> L13
                if (this.mRemote.transact(28, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L13
                int r0 = r2.readInt();     // Catch: Throwable -> L13
                r2.recycle();
                r1.recycle();
                return r0;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().setPAParameters(r13, r14, r15, r16, r17, r18, r19);     // Catch: Throwable -> L13
                r2.recycle();
                r1.recycle();
                return r3;
            L13:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public int[] getPAParameters(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(29, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r6 = Stub.getDefaultImpl().getPAParameters(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.qti.snapdragon.sdk.display.IColorService
            public void release() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().release();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
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

        public static IColorService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IColorService) == false) goto L12;
            return (IColorService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 == 1598968902) goto L67;
            switch(r11) {
                case 1: goto L65;
                case 2: goto L63;
                case 3: goto L61;
                case 4: goto L59;
                case 5: goto L57;
                case 6: goto L55;
                case 7: goto L53;
                case 8: goto L51;
                case 9: goto L49;
                case 10: goto L47;
                case 11: goto L45;
                case 12: goto L43;
                case 13: goto L41;
                case 14: goto L39;
                case 15: goto L37;
                case 16: goto L35;
                case 17: goto L33;
                case 18: goto L31;
                case 19: goto L29;
                case 20: goto L27;
                case 21: goto L25;
                case 22: goto L23;
                case 23: goto L21;
                case 24: goto L19;
                case 25: goto L17;
                case 26: goto L15;
                case 27: goto L13;
                case 28: goto L11;
                case 29: goto L9;
                case 30: goto L7;
                default: goto L6;
            };
        L7:
            r12.enforceInterface(DESCRIPTOR);
            release();
            r13.writeNoException();
            return true;
        L9:
            r12.enforceInterface(DESCRIPTOR);
            int[] r10 = getPAParameters(r12.readInt());
            r13.writeNoException();
            r13.writeIntArray(r10);
            return true;
        L11:
            r12.enforceInterface(DESCRIPTOR);
            int r15 = setPAParameters(r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r15);
            return true;
        L13:
            r12.enforceInterface(DESCRIPTOR);
            int[] r16 = getRangePAParameter(r12.readInt());
            r13.writeNoException();
            r13.writeIntArray(r16);
            return true;
        L15:
            r12.enforceInterface(DESCRIPTOR);
            int r17 = disableMemoryColorConfiguration(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r17);
            return true;
        L17:
            r12.enforceInterface(DESCRIPTOR);
            int[] r18 = getMemoryColorParameters(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeIntArray(r18);
            return true;
        L19:
            r12.enforceInterface(DESCRIPTOR);
            int r19 = setMemoryColorParameters(r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r19);
            return true;
        L21:
            r12.enforceInterface(DESCRIPTOR);
            int[] r110 = getRangeMemoryColorParameter(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeIntArray(r110);
            return true;
        L23:
            r12.enforceInterface(DESCRIPTOR);
            int r111 = setActiveFeatureControl(r12.readInt(), r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r111);
            return true;
        L25:
            r12.enforceInterface(DESCRIPTOR);
            int r112 = isActiveFeatureOn(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r112);
            return true;
        L27:
            r12.enforceInterface(DESCRIPTOR);
            int r113 = getAdaptiveBacklightScale(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r113);
            return true;
        L29:
            r12.enforceInterface(DESCRIPTOR);
            int r114 = setBacklightQualityLevel(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r114);
            return true;
        L31:
            r12.enforceInterface(DESCRIPTOR);
            int r115 = getBacklightQualityLevel(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r115);
            return true;
        L33:
            r12.enforceInterface(DESCRIPTOR);
            int r116 = getSunlightVisibilityStrength(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r116);
            return true;
        L35:
            r12.enforceInterface(DESCRIPTOR);
            int r117 = setSunlightVisibilityStrength(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r117);
            return true;
        L37:
            r12.enforceInterface(DESCRIPTOR);
            int r118 = getRangeSunlightVisibilityStrength(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r118);
            return true;
        L39:
            r12.enforceInterface(DESCRIPTOR);
            int r119 = modifyModeAllFeatures(r12.readInt(), r12.readInt(), r12.readString());
            r13.writeNoException();
            r13.writeInt(r119);
            return true;
        L41:
            r12.enforceInterface(DESCRIPTOR);
            int r120 = createNewModeAllFeatures(r12.readInt(), r12.readString());
            r13.writeNoException();
            r13.writeInt(r120);
            return true;
        L43:
            r12.enforceInterface(DESCRIPTOR);
            int r121 = setDefaultMode(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r121);
            return true;
        L45:
            r12.enforceInterface(DESCRIPTOR);
            int r122 = getDefaultMode(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r122);
            return true;
        L47:
            r12.enforceInterface(DESCRIPTOR);
            int r123 = modifyMode(r12.readInt(), r12.readInt(), r12.readString(), r12.readLong(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r123);
            return true;
        L49:
            r12.enforceInterface(DESCRIPTOR);
            int r124 = createNewMode(r12.readInt(), r12.readString(), r12.readLong(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r124);
            return true;
        L51:
            r12.enforceInterface(DESCRIPTOR);
            ModeInfo[] r125 = getModes(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeTypedArray(r125, 1);
            return true;
        L53:
            r12.enforceInterface(DESCRIPTOR);
            int r126 = deleteMode(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r126);
            return true;
        L55:
            r12.enforceInterface(DESCRIPTOR);
            int r127 = setActiveMode(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r127);
            return true;
        L57:
            r12.enforceInterface(DESCRIPTOR);
            long[] r128 = getActiveMode(r12.readInt());
            r13.writeNoException();
            r13.writeLongArray(r128);
            return true;
        L59:
            r12.enforceInterface(DESCRIPTOR);
            int r129 = getNumModes(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r129);
            return true;
        L61:
            r12.enforceInterface(DESCRIPTOR);
            int r130 = getColorBalance(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r130);
            return true;
        L63:
            r12.enforceInterface(DESCRIPTOR);
            int r131 = setColorBalance(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r131);
            return true;
        L65:
            r12.enforceInterface(DESCRIPTOR);
            boolean r132 = isFeatureSupported(r12.readInt(), r12.readInt());
            r13.writeNoException();
            r13.writeInt(r132 ? 1 : 0);
            return true;
        L6:
            return super.onTransact(r11, r12, r13, r14);
        L67:
            r13.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IColorService r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IColorService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int createNewMode(int r1, String r2, long r3, int r5) throws RemoteException;

    int createNewModeAllFeatures(int r1, String r2) throws RemoteException;

    int deleteMode(int r1, int r2) throws RemoteException;

    int disableMemoryColorConfiguration(int r1, int r2) throws RemoteException;

    long[] getActiveMode(int r1) throws RemoteException;

    int getAdaptiveBacklightScale(int r1) throws RemoteException;

    int getBacklightQualityLevel(int r1) throws RemoteException;

    int getColorBalance(int r1) throws RemoteException;

    int getDefaultMode(int r1) throws RemoteException;

    int[] getMemoryColorParameters(int r1, int r2) throws RemoteException;

    ModeInfo[] getModes(int r1, int r2) throws RemoteException;

    int getNumModes(int r1, int r2) throws RemoteException;

    int[] getPAParameters(int r1) throws RemoteException;

    int[] getRangeMemoryColorParameter(int r1, int r2) throws RemoteException;

    int[] getRangePAParameter(int r1) throws RemoteException;

    int getRangeSunlightVisibilityStrength(int r1, int r2) throws RemoteException;

    int getSunlightVisibilityStrength(int r1) throws RemoteException;

    int isActiveFeatureOn(int r1, int r2) throws RemoteException;

    boolean isFeatureSupported(int r1, int r2) throws RemoteException;

    int modifyMode(int r1, int r2, String r3, long r4, int r6) throws RemoteException;

    int modifyModeAllFeatures(int r1, int r2, String r3) throws RemoteException;

    void release() throws RemoteException;

    int setActiveFeatureControl(int r1, int r2, int r3) throws RemoteException;

    int setActiveMode(int r1, int r2) throws RemoteException;

    int setBacklightQualityLevel(int r1, int r2) throws RemoteException;

    int setColorBalance(int r1, int r2) throws RemoteException;

    int setDefaultMode(int r1, int r2) throws RemoteException;

    int setMemoryColorParameters(int r1, int r2, int r3, int r4, int r5) throws RemoteException;

    int setPAParameters(int r1, int r2, int r3, int r4, int r5, int r6, int r7) throws RemoteException;

    int setSunlightVisibilityStrength(int r1, int r2) throws RemoteException;
}
