package com.obric.matrix.platform.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.matrix.platform.e.b$a$a, reason: collision with other inner class name */
        private static class C0263a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f9502g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9503f;

            C0263a(IBinder r1) {
                this.f9503f = r1;
            }

            @Override // com.obric.matrix.platform.e.b
            public void A(int r5, byte[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.server.IServerCallback");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeByteArray(r6);     // Catch: Throwable -> L13
                if (this.f9503f.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.c() == null) goto L10;
                a.c().A(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9503f;
            }
        }

        public a() {
            attachInterface(this, "com.obric.matrix.platform.server.IServerCallback");
        }

        public static b a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.platform.server.IServerCallback");
            if (r0 == null) goto L12;
            if ((r0 instanceof b) == false) goto L12;
            return (b) r0;
        L12:
            return new C0263a(r2);
        }

        public static b c() {
            return C0263a.f9502g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.platform.server.IServerCallback");
            A(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.matrix.platform.server.IServerCallback");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void A(int r1, byte[] r2);
}
