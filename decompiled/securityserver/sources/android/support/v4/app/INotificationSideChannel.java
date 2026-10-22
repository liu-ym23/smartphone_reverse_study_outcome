package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    public static class Default implements INotificationSideChannel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String r1, int r2, String r3) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String r1) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String r1, int r2, String r3, Notification r4) {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {
        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public static class Proxy implements INotificationSideChannel {
            public static INotificationSideChannel sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(String r5, int r6, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                r0.writeInt(r6);     // Catch: Throwable -> L10
                r0.writeString(r7);     // Catch: Throwable -> L10
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L12:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().cancel(r5, r6, r7);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L12:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().cancelAll(r5);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(String r4, int r5, String r6, Notification r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L12;
            L16:
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().notify(r4, r5, r6, r7);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof INotificationSideChannel) == false) goto L12;
            return (INotificationSideChannel) r0;
        L12:
            return new Proxy(r2);
        }

        public static INotificationSideChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INotificationSideChannel r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            int r9 = r5.readInt();
            String r10 = r5.readString();
            if (r5.readInt() == 0) goto L21;
            Notification r11 = (Notification) Notification.CREATOR.createFromParcel(r5);
        L22:
            notify(r8, r9, r10, r11);
            return true;
        L21:
            r11 = null;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            cancel(r5.readString(), r5.readInt(), r5.readString());
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            cancelAll(r5.readString());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void cancel(String r1, int r2, String r3);

    void cancelAll(String r1);

    void notify(String r1, int r2, String r3, Notification r4);
}
