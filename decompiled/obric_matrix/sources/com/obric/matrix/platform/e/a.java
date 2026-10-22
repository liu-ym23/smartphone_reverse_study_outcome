package com.obric.matrix.platform.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.matrix.platform.e.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0261a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.matrix.platform.e.a$a$a, reason: collision with other inner class name */
        private static class C0262a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f9500g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9501f;

            C0262a(IBinder r1) {
                this.f9501f = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9501f;
            }

            @Override // com.obric.matrix.platform.e.a
            public void s(String r5, b r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.server.IServerBroker");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f9501f.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (AbstractBinderC0261a.c() == null) goto L14;
                AbstractBinderC0261a.c().s(r5, r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.matrix.platform.e.a
            public void z(int r5, byte[] r6, b r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.server.IServerBroker");     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeByteArray(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f9501f.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (AbstractBinderC0261a.c() == null) goto L14;
                AbstractBinderC0261a.c().z(r5, r6, r7);     // Catch: Throwable -> L17
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

        public AbstractBinderC0261a() {
            attachInterface(this, "com.obric.matrix.platform.server.IServerBroker");
        }

        public static a a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.platform.server.IServerBroker");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0262a(r2);
        }

        public static a c() {
            return C0262a.f9500g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            byte[] r3 = D(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            r6.writeByteArray(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            z(r5.readInt(), r5.createByteArray(), b.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.obric.matrix.platform.server.IServerBroker");
            s(r5.readString(), b.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString("com.obric.matrix.platform.server.IServerBroker");
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    byte[] D(int r1, byte[] r2);

    void s(String r1, b r2);

    void z(int r1, byte[] r2, b r3);
}
