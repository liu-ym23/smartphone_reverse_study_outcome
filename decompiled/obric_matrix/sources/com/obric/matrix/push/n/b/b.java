package com.obric.matrix.push.n.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.matrix.push.n.b.b$a$a, reason: collision with other inner class name */
        private static class C0276a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f9755g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9756f;

            C0276a(IBinder r1) {
                this.f9756f = r1;
            }

            @Override // com.obric.matrix.push.n.b.b
            public void F(List r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");     // Catch: Throwable -> L13
                r0.writeList(r5);     // Catch: Throwable -> L13
                if (this.f9756f.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.c() == null) goto L10;
                a.c().F(r5);     // Catch: Throwable -> L13
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
                return this.f9756f;
            }
        }

        public a() {
            attachInterface(this, "com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
        }

        public static b a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            if (r0 == null) goto L12;
            if ((r0 instanceof b) == false) goto L12;
            return (b) r0;
        L12:
            return new C0276a(r2);
        }

        public static b c() {
            return C0276a.f9755g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            F(r5.readArrayList(getClass().getClassLoader()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void F(List r1);
}
