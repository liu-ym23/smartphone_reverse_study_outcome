package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0004a extends Binder implements a {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        /* JADX INFO: renamed from: android.support.v4.app.a$a$a, reason: collision with other inner class name */
        private static class C0005a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f101f;

            C0005a(IBinder r1) {
                this.f101f = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f101f;
            }

            @Override // android.support.v4.app.a
            public void cancel(String r3, int r4, String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.f101f.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.app.a
            public void cancelAll(String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f101f.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.app.a
            public void notify(String r3, int r4, String r5, Notification r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                b.b(r0, r6, 0);     // Catch: Throwable -> L6
                this.f101f.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public AbstractBinderC0004a() {
            attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        }

        public static a asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0005a(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface("android.support.v4.app.INotificationSideChannel");
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            notify(r5.readString(), r5.readInt(), r5.readString(), (Notification) b.a(r5, Notification.CREATOR));
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            cancel(r5.readString(), r5.readInt(), r5.readString());
            goto L19
        L13:
            if (r4 != 3) goto L15;
            cancelAll(r5.readString());
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString("android.support.v4.app.INotificationSideChannel");
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

    void cancel(String r1, int r2, String r3);

    void cancelAll(String r1);

    void notify(String r1, int r2, String r3, Notification r4);
}
