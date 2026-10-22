package com.obric.matrix.platform.d.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.matrix.platform.d.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0256a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.matrix.platform.d.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0257a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f9494g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f9495f;

            C0257a(IBinder r1) {
                this.f9495f = r1;
            }

            @Override // com.obric.matrix.platform.d.a.a.a
            public void B(boolean r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");     // Catch: Throwable -> L20
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L20
                if (r6 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L12:
                if (this.f9495f.transact(1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (AbstractBinderC0256a.c() == null) goto L18;
                AbstractBinderC0256a.c().B(r5, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r3 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9495f;
            }
        }

        public static a a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0257a(r2);
        }

        public static a c() {
            return C0257a.f9494g;
        }
    }

    void B(boolean r1, Bundle r2);
}
