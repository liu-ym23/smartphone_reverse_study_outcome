package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: android.support.v4.media.session.b$a$a, reason: collision with other inner class name */
        private static class C0011a implements b {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f213f;

            C0011a(IBinder r1) {
                this.f213f = r1;
            }

            @Override // android.support.v4.media.session.b
            public boolean G(KeyEvent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                this.f213f.transact(2, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                if (r1.readInt() != 0) goto L11;
                r2 = false;
            L11:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f213f;
            }

            @Override // android.support.v4.media.session.b
            public void i(android.support.v4.media.session.a r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                IBinder r5 = r4.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r5);     // Catch: Throwable -> L10
                this.f213f.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static b a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (r0 == null) goto L12;
            if ((r0 instanceof b) == false) goto L12;
            return (b) r0;
        L12:
            return new C0011a(r2);
        }
    }

    boolean G(KeyEvent r1);

    void i(android.support.v4.media.session.a r1);
}
