package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IStarLocationService extends IInterface {
    public static final int CITY_LISTEN_LEVEL1 = 1;
    public static final int CITY_LISTEN_LEVEL2 = 2;
    public static final int CITY_LISTEN_LEVEL3 = 3;
    public static final int CITY_LISTEN_LEVEL4 = 4;
    public static final int DIRECTION_TYPE_DRIVING = 2;
    public static final int DIRECTION_TYPE_RIDING = 4;
    public static final int DIRECTION_TYPE_TRANSIT = 1;
    public static final int DIRECTION_TYPE_WALKING = 3;

    public static class Default implements IStarLocationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getCommSenseAARVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Address getCurCityInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLastKnownLocationFromZpp(int r1, String r2) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
        static final int TRANSACTION_getCommSenseAARVersion = 14;
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLastKnownLocationFromZpp = 13;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarVersion = 1;
        static final int TRANSACTION_registerCityCallback = 7;
        static final int TRANSACTION_runIndoorCheck = 6;
        static final int TRANSACTION_searchDirectionFromBmap = 9;
        static final int TRANSACTION_searchDirectionFromBmapByAddress = 10;
        static final int TRANSACTION_searchPoiTextFromBd = 5;
        static final int TRANSACTION_unregisterCityCallback = 8;

        public static class Proxy implements IStarLocationService {
            public static IStarLocationService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getCommSenseAARVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getCommSenseAARVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Address r4 = (Address) Address.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Address r5 = Stub.getDefaultImpl().getCurCityInfo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLastKnownLocationFromZpp(int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r4 = (Location) Location.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r7 = Stub.getDefaultImpl().getLastKnownLocationFromZpp(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r4 = (Location) Location.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r5 = Stub.getDefaultImpl().getLocationFromBdGeo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r4 = (Location) Location.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r5 = Stub.getDefaultImpl().getLocationFromZpp();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarAoiBoardManager r4 = IStarAoiBoardManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarAoiBoardManager r5 = Stub.getDefaultImpl().getStarAoiBoardManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarGeofenceManager r4 = IStarGeofenceManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarGeofenceManager r5 = Stub.getDefaultImpl().getStarGeofenceManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getStarVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r5, IStarLocationCityCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
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
                Stub.getDefaultImpl().registerCityCallback(r5, r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runIndoorCheck(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r17, double r19, double r21, double r23, byte r25, byte r26, Map r27, int r28) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeDouble(r17);     // Catch: Throwable -> L17
                r1.writeDouble(r19);     // Catch: Throwable -> L17
                r1.writeDouble(r21);     // Catch: Throwable -> L17
                r1.writeDouble(r23);     // Catch: Throwable -> L17
                r1.writeByte(r25);     // Catch: Throwable -> L17
                r1.writeByte(r26);     // Catch: Throwable -> L17
                r1.writeMap(r27);     // Catch: Throwable -> L17
                r1.writeInt(r28);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L17
                if (r2.readInt() == 0) goto L14;
                Bundle r0 = (Bundle) Bundle.CREATOR.createFromParcel(r2);     // Catch: Throwable -> L17
            L15:
                r2.recycle();
                r1.recycle();
                return r0;
            L14:
                r0 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r3 = Stub.getDefaultImpl().searchDirectionFromBmap(r17, r19, r21, r23, r25, r26, r27, r28);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r3;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r15, double r17, String r19, byte r20, byte r21, Map r22, int r23) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeDouble(r15);     // Catch: Throwable -> L17
                r1.writeDouble(r17);     // Catch: Throwable -> L17
                r1.writeString(r19);     // Catch: Throwable -> L17
                r1.writeByte(r20);     // Catch: Throwable -> L17
                r1.writeByte(r21);     // Catch: Throwable -> L17
                r1.writeMap(r22);     // Catch: Throwable -> L17
                r1.writeInt(r23);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L17
                if (r2.readInt() == 0) goto L14;
                Bundle r0 = (Bundle) Bundle.CREATOR.createFromParcel(r2);     // Catch: Throwable -> L17
            L15:
                r2.recycle();
                r1.recycle();
                return r0;
            L14:
                r0 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r3 = Stub.getDefaultImpl().searchDirectionFromBmapByAddress(r15, r17, r19, r20, r21, r22, r23);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r3;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r9, int r10, int r11, String r12, String r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeString(r12);     // Catch: Throwable -> L13
                r0.writeString(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r8 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().searchPoiTextFromBd(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r14;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterCityCallback();     // Catch: Throwable -> L13
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarLocationService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarLocationService) == false) goto L12;
            return (IStarLocationService) r0;
        L12:
            return new Proxy(r2);
        }

        public static IStarLocationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarLocationService r1) {
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
        public boolean onTransact(int r19, Parcel r20, Parcel r21, int r22) throws RemoteException {
            if (r19 == 1598968902) goto L60;
            IBinder r3 = null;
            switch(r19) {
                case 1: goto L58;
                case 2: goto L53;
                case 3: goto L48;
                case 4: goto L43;
                case 5: goto L41;
                case 6: goto L39;
                case 7: goto L37;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L10;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r20.enforceInterface(DESCRIPTOR);
            String r0 = getCommSenseAARVersion();
            r21.writeNoException();
            r21.writeString(r0);
            return true;
        L10:
            r20.enforceInterface(DESCRIPTOR);
            Location r1 = getLastKnownLocationFromZpp(r20.readInt(), r20.readString());
            r21.writeNoException();
            if (r1 == null) goto L13;
            r21.writeInt(1);
            r1.writeToParcel(r21, 1);
        L14:
            return true;
        L13:
            r21.writeInt(0);
            goto L14
        L15:
            r20.enforceInterface(DESCRIPTOR);
            Address r2 = getCurCityInfo();
            r21.writeNoException();
            if (r2 == null) goto L18;
            r21.writeInt(1);
            r2.writeToParcel(r21, 1);
        L19:
            return true;
        L18:
            r21.writeInt(0);
            goto L19
        L20:
            r20.enforceInterface(DESCRIPTOR);
            IStarAoiBoardManager r4 = getStarAoiBoardManager();
            r21.writeNoException();
            if (r4 == null) goto L23;
            r3 = r4.asBinder();
        L23:
            r21.writeStrongBinder(r3);
            return true;
        L25:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r5 = searchDirectionFromBmapByAddress(r20.readDouble(), r20.readDouble(), r20.readString(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r5 == null) goto L28;
            r21.writeInt(1);
            r5.writeToParcel(r21, 1);
        L29:
            return true;
        L28:
            r21.writeInt(0);
            goto L29
        L30:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r6 = searchDirectionFromBmap(r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r6 == null) goto L33;
            r21.writeInt(1);
            r6.writeToParcel(r21, 1);
        L34:
            return true;
        L33:
            r21.writeInt(0);
            goto L34
        L35:
            r20.enforceInterface(DESCRIPTOR);
            unregisterCityCallback();
            r21.writeNoException();
            return true;
        L37:
            r20.enforceInterface(DESCRIPTOR);
            registerCityCallback(r20.readInt(), IStarLocationCityCallback.Stub.asInterface(r20.readStrongBinder()));
            r21.writeNoException();
            return true;
        L39:
            r20.enforceInterface(DESCRIPTOR);
            runIndoorCheck(r20.readLong());
            r21.writeNoException();
            return true;
        L41:
            r20.enforceInterface(DESCRIPTOR);
            String r7 = searchPoiTextFromBd(r20.readString(), r20.readInt(), r20.readInt(), r20.readString(), r20.readString());
            r21.writeNoException();
            r21.writeString(r7);
            return true;
        L43:
            r20.enforceInterface(DESCRIPTOR);
            Location r8 = getLocationFromBdGeo();
            r21.writeNoException();
            if (r8 == null) goto L46;
            r21.writeInt(1);
            r8.writeToParcel(r21, 1);
        L47:
            return true;
        L46:
            r21.writeInt(0);
            goto L47
        L48:
            r20.enforceInterface(DESCRIPTOR);
            Location r9 = getLocationFromZpp();
            r21.writeNoException();
            if (r9 == null) goto L51;
            r21.writeInt(1);
            r9.writeToParcel(r21, 1);
        L52:
            return true;
        L51:
            r21.writeInt(0);
            goto L52
        L53:
            r20.enforceInterface(DESCRIPTOR);
            IStarGeofenceManager r10 = getStarGeofenceManager();
            r21.writeNoException();
            if (r10 == null) goto L56;
            r3 = r10.asBinder();
        L56:
            r21.writeStrongBinder(r3);
            return true;
        L58:
            r20.enforceInterface(DESCRIPTOR);
            String r11 = getStarVersion();
            r21.writeNoException();
            r21.writeString(r11);
            return true;
        L7:
            return super.onTransact(r19, r20, r21, r22);
        L60:
            r21.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCommSenseAARVersion() throws RemoteException;

    Address getCurCityInfo() throws RemoteException;

    Location getLastKnownLocationFromZpp(int r1, String r2) throws RemoteException;

    Location getLocationFromBdGeo() throws RemoteException;

    Location getLocationFromZpp() throws RemoteException;

    IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException;

    IStarGeofenceManager getStarGeofenceManager() throws RemoteException;

    String getStarVersion() throws RemoteException;

    void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException;

    void runIndoorCheck(long r1) throws RemoteException;

    Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException;

    Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException;

    String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException;

    void unregisterCityCallback() throws RemoteException;
}
