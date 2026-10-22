package com.obric.cae.libs.wifi;

import android.net.wifi.ScanResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeSmartNetworkManager extends IInterface {

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() throws RemoteException {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public List<ScanResult> getSecondaryWifiList() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_getSecondaryWifiList = 12;
        static final int TRANSACTION_registerLinkThroughputListener = 1;
        static final int TRANSACTION_registerSecondaryWifiListener = 8;
        static final int TRANSACTION_releaseAll = 10;
        static final int TRANSACTION_releaseSecondaryWifi = 7;
        static final int TRANSACTION_requestSecondaryWifi = 6;
        static final int TRANSACTION_unregisterLinkThroughputListener = 2;
        static final int TRANSACTION_unregisterSecondaryWifiListener = 9;

        public static class Proxy implements ICaeSmartNetworkManager {
            public static ICaeSmartNetworkManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getCurrentSecondarySsid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getLinkThroughput();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() throws RemoteException {
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
                int r5 = Stub.getDefaultImpl().getLinkThroughputJitter();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                float r4 = r1.readFloat();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                float r5 = Stub.getDefaultImpl().getLinkThroughputJitterWeight();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public List<ScanResult> getSecondaryWifiList() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(ScanResult.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ScanResult> r5 = Stub.getDefaultImpl().getSecondaryWifiList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerLinkThroughputListener(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSecondaryWifiListener(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseAll();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().releaseSecondaryWifi(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r9, String r10, String r11, String r12, ISecondaryWifiCallback r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r9);     // Catch: Throwable -> L17
                r0.writeString(r10);     // Catch: Throwable -> L17
                r0.writeString(r11);     // Catch: Throwable -> L17
                r0.writeString(r12);     // Catch: Throwable -> L17
                if (r13 == null) goto L6;
                IBinder r2 = r13.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestSecondaryWifi(r9, r10, r11, r12, r13);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterLinkThroughputListener(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSecondaryWifiListener(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeSmartNetworkManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeSmartNetworkManager) == false) goto L12;
            return (ICaeSmartNetworkManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeSmartNetworkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeSmartNetworkManager r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L31;
            switch(r9) {
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
            r10.enforceInterface(DESCRIPTOR);
            List<ScanResult> r8 = getSecondaryWifiList();
            r11.writeNoException();
            r11.writeTypedList(r8);
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            String r13 = getCurrentSecondarySsid();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L11:
            r10.enforceInterface(DESCRIPTOR);
            releaseAll();
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            requestSecondaryWifi(r10.readString(), r10.readString(), r10.readString(), r10.readString(), ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L21:
            r10.enforceInterface(DESCRIPTOR);
            float r14 = getLinkThroughputJitterWeight();
            r11.writeNoException();
            r11.writeFloat(r14);
            return true;
        L23:
            r10.enforceInterface(DESCRIPTOR);
            int r15 = getLinkThroughputJitter();
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L25:
            r10.enforceInterface(DESCRIPTOR);
            int r16 = getLinkThroughput();
            r11.writeNoException();
            r11.writeInt(r16);
            return true;
        L27:
            r10.enforceInterface(DESCRIPTOR);
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L29:
            r10.enforceInterface(DESCRIPTOR);
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L6:
            return super.onTransact(r9, r10, r11, r12);
        L31:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCurrentSecondarySsid() throws RemoteException;

    int getLinkThroughput() throws RemoteException;

    int getLinkThroughputJitter() throws RemoteException;

    float getLinkThroughputJitterWeight() throws RemoteException;

    List<ScanResult> getSecondaryWifiList() throws RemoteException;

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;

    void releaseAll() throws RemoteException;

    void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException;

    void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException;

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;
}
