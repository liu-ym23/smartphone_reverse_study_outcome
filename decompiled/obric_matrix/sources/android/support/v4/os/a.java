package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0013a extends Binder implements a {

        /* JADX INFO: renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        private static class C0014a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f222f;

            C0014a(IBinder r1) {
                this.f222f = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f222f;
            }

            @Override // android.support.v4.os.a
            public void h0(int r3, Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.os.IResultReceiver");     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                b.b(r0, r4, 0);     // Catch: Throwable -> L6
                this.f222f.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public AbstractBinderC0013a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0014a(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("android.support.v4.os.IResultReceiver");
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            h0(r5.readInt(), (Bundle) b.a(r5, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
    }

    public static class b {
        static /* synthetic */ Object a(Parcel r0, Parcelable.Creator r1) {
            return c(r0, r1);
        }

        static /* synthetic */ void b(Parcel r0, Parcelable r1, int r2) {
            d(r0, r1, r2);
        }

        private static <T> T c(Parcel r1, Parcelable.Creator<T> r2) {
            if (r1.readInt() != 0) goto L5;
            return null;
        L5:
            return r2.createFromParcel(r1);
        }

        private static <T extends Parcelable> void d(Parcel r1, T r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    void h0(int r1, Bundle r2);
}
