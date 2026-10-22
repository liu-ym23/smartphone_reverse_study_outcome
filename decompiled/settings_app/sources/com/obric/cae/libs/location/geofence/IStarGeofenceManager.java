package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IStarGeofenceManager extends IInterface {

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceByPoiId(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_findGeofenceByPoiId = 15;
        static final int TRANSACTION_getComponent = 3;
        static final int TRANSACTION_getVendorVersion = 1;
        static final int TRANSACTION_isStarGeofencesRecovered = 14;
        static final int TRANSACTION_listGeofences = 9;
        static final int TRANSACTION_registerComponent = 2;
        static final int TRANSACTION_registerGeofenceCallback = 12;
        static final int TRANSACTION_sendDebugEvent = 11;
        static final int TRANSACTION_unregisterComponent = 4;
        static final int TRANSACTION_unregisterGeofenceCallback = 13;
        static final int TRANSACTION_updateGeofence = 8;

        public static class Proxy implements IStarGeofenceManager {
            public static IStarGeofenceManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().addGeofence(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofence(StarGeofence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().deleteGeofence(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                byte r4 = r1.readByte();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                byte r7 = Stub.getDefaultImpl().deleteGeofenceById(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                StarGeofence r4 = StarGeofence.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                StarGeofence r6 = Stub.getDefaultImpl().findGeofenceById(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceByPoiId(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                StarGeofence r4 = StarGeofence.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                StarGeofence r6 = Stub.getDefaultImpl().findGeofenceByPoiId(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ComponentName r4 = (ComponentName) ComponentName.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ComponentName r6 = Stub.getDefaultImpl().getComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() throws RemoteException {
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
                String r5 = Stub.getDefaultImpl().getVendorVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isStarGeofencesRecovered();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<StarGeofence> r6 = Stub.getDefaultImpl().listGeofences(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().registerComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r5, IStarGeofenceCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerGeofenceCallback(r5, r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r5, int r6, StarGeofence r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L23
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L12:
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() == 0) goto L21;
                r7.readFromParcel(r1);     // Catch: Throwable -> L23
            L21:
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendDebugEvent(r5, r6, r7);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().unregisterComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r5, IStarGeofenceCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterGeofenceCallback(r5, r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                byte r4 = r1.readByte();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r5.readFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().updateGeofence(r5);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarGeofenceManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarGeofenceManager) == false) goto L12;
            return (IStarGeofenceManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static IStarGeofenceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarGeofenceManager r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L75;
            ComponentName r3 = null;
            StarGeofence r4 = null;
            StarGeofence r9 = null;
            StarGeofence r10 = null;
            StarGeofence r11 = null;
            ComponentName r12 = null;
            switch(r5) {
                case 1: goto L73;
                case 2: goto L68;
                case 3: goto L63;
                case 4: goto L58;
                case 5: goto L53;
                case 6: goto L48;
                case 7: goto L46;
                case 8: goto L38;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            StarGeofence r13 = findGeofenceByPoiId(r6.readString());
            r7.writeNoException();
            if (r13 == null) goto L11;
            r7.writeInt(1);
            r13.writeToParcel(r7, 1);
        L12:
            return true;
        L11:
            r7.writeInt(0);
            goto L12
        L13:
            r6.enforceInterface(DESCRIPTOR);
            boolean r14 = isStarGeofencesRecovered();
            r7.writeNoException();
            r7.writeInt(r14 ? 1 : 0);
            return true;
        L15:
            r6.enforceInterface(DESCRIPTOR);
            unregisterGeofenceCallback(r6.readString(), IStarGeofenceCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L17:
            r6.enforceInterface(DESCRIPTOR);
            registerGeofenceCallback(r6.readString(), IStarGeofenceCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L19:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L22;
            Location r15 = (Location) Location.CREATOR.createFromParcel(r6);
        L23:
            int r16 = r6.readInt();
            if (r6.readInt() == 0) goto L26;
            r4 = StarGeofence.CREATOR.createFromParcel(r6);
        L26:
            sendDebugEvent(r15, r16, r4);
            r7.writeNoException();
            if (r4 == null) goto L29;
            r7.writeInt(1);
            r4.writeToParcel(r7, 1);
        L30:
            return true;
        L29:
            r7.writeInt(0);
            goto L30
        L22:
            r15 = null;
            goto L23
        L31:
            r6.enforceInterface(DESCRIPTOR);
            StarGeofence r17 = findGeofenceById(r6.readString());
            r7.writeNoException();
            if (r17 == null) goto L34;
            r7.writeInt(1);
            r17.writeToParcel(r7, 1);
        L35:
            return true;
        L34:
            r7.writeInt(0);
            goto L35
        L36:
            r6.enforceInterface(DESCRIPTOR);
            List<StarGeofence> r18 = listGeofences(r6.readString());
            r7.writeNoException();
            r7.writeTypedList(r18);
            return true;
        L38:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L41;
            r9 = StarGeofence.CREATOR.createFromParcel(r6);
        L41:
            byte r19 = updateGeofence(r9);
            r7.writeNoException();
            r7.writeByte(r19);
            if (r9 == null) goto L44;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L45:
            return true;
        L44:
            r7.writeInt(0);
            goto L45
        L46:
            r6.enforceInterface(DESCRIPTOR);
            byte r20 = deleteGeofenceById(r6.readString(), r6.readString());
            r7.writeNoException();
            r7.writeByte(r20);
            return true;
        L48:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L51;
            r10 = StarGeofence.CREATOR.createFromParcel(r6);
        L51:
            byte r21 = deleteGeofence(r10);
            r7.writeNoException();
            r7.writeByte(r21);
            return true;
        L53:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L56;
            r11 = StarGeofence.CREATOR.createFromParcel(r6);
        L56:
            byte r22 = addGeofence(r11);
            r7.writeNoException();
            r7.writeByte(r22);
            return true;
        L58:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L61;
            r12 = (ComponentName) ComponentName.CREATOR.createFromParcel(r6);
        L61:
            byte r23 = unregisterComponent(r12);
            r7.writeNoException();
            r7.writeByte(r23);
            return true;
        L63:
            r6.enforceInterface(DESCRIPTOR);
            ComponentName r24 = getComponent(r6.readString());
            r7.writeNoException();
            if (r24 == null) goto L66;
            r7.writeInt(1);
            r24.writeToParcel(r7, 1);
        L67:
            return true;
        L66:
            r7.writeInt(0);
            goto L67
        L68:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L71;
            r3 = (ComponentName) ComponentName.CREATOR.createFromParcel(r6);
        L71:
            byte r25 = registerComponent(r3);
            r7.writeNoException();
            r7.writeByte(r25);
            return true;
        L73:
            r6.enforceInterface(DESCRIPTOR);
            String r26 = getVendorVersion();
            r7.writeNoException();
            r7.writeString(r26);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L75:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    byte addGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofenceById(String r1, String r2) throws RemoteException;

    StarGeofence findGeofenceById(String r1) throws RemoteException;

    StarGeofence findGeofenceByPoiId(String r1) throws RemoteException;

    ComponentName getComponent(String r1) throws RemoteException;

    String getVendorVersion() throws RemoteException;

    boolean isStarGeofencesRecovered() throws RemoteException;

    List<StarGeofence> listGeofences(String r1) throws RemoteException;

    byte registerComponent(ComponentName r1) throws RemoteException;

    void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException;

    byte unregisterComponent(ComponentName r1) throws RemoteException;

    void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    byte updateGeofence(StarGeofence r1) throws RemoteException;
}
