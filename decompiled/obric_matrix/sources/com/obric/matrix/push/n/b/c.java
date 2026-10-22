package com.obric.matrix.push.n.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.obric.matrix.push.n.b.c$a$a, reason: collision with other inner class name */
        private static class C0277a implements c {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static c f9757g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9758f;

            C0277a(IBinder r1) {
                this.f9758f = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9758f;
            }

            @Override // com.obric.matrix.push.n.b.c
            public void d0(String r5, String r6, List r7, b r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeList(r7);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f9758f.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.c() == null) goto L14;
                a.c().d0(r5, r6, r7, r8);     // Catch: Throwable -> L17
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

        public a() {
            attachInterface(this, "com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
        }

        public static c a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            if (r0 == null) goto L12;
            if ((r0 instanceof c) == false) goto L12;
            return (c) r0;
        L12:
            return new C0277a(r2);
        }

        public static c c() {
            return C0277a.f9757g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            d0(r5.readString(), r5.readString(), r5.readArrayList(getClass().getClassLoader()), b.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void d0(String r1, String r2, List r3, b r4);
}
