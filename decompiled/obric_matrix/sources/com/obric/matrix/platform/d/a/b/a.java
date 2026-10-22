package com.obric.matrix.platform.d.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.matrix.platform.d.a.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0258a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.matrix.platform.d.a.b.a$a$a, reason: collision with other inner class name */
        private static class C0259a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f9496g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9497f;

            C0259a(IBinder r1) {
                this.f9497f = r1;
            }

            @Override // com.obric.matrix.platform.d.a.b.a
            public void Y(b r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f9497f.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (AbstractBinderC0258a.c() == null) goto L14;
                AbstractBinderC0258a.c().Y(r5);     // Catch: Throwable -> L17
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9497f;
            }

            @Override // com.obric.matrix.platform.d.a.b.a
            public String getDeviceId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                if (this.f9497f.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0258a.c() == null) goto L10;
                String r5 = AbstractBinderC0258a.c().getDeviceId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.d.a.b.a
            public String getInstallId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                if (this.f9497f.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0258a.c() == null) goto L10;
                String r5 = AbstractBinderC0258a.c().getInstallId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.d.a.b.a
            public void onEvent(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f9497f.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0258a.c() == null) goto L10;
                AbstractBinderC0258a.c().onEvent(r5, r6);     // Catch: Throwable -> L13
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

        public AbstractBinderC0258a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
        }

        public static a a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0259a(r2);
        }

        public static a c() {
            return C0259a.f9496g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            String r3 = getDeviceId();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            String r8 = getInstallId();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            Y(b.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            a0(b.a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            onEvent(r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void Y(b r1);

    void a0(b r1);

    String getDeviceId();

    String getInstallId();

    void onEvent(String r1, String r2);
}
