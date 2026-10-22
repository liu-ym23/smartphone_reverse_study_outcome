package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface i6 extends IInterface {

    public static abstract class a extends Binder implements i6 {

        /* JADX INFO: renamed from: tmsdkobf.i6$a$a, reason: collision with other inner class name */
        private static class C0101a implements i6 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f265a;

            C0101a(IBinder r1) {
                this.f265a = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f265a;
            }

            @Override // tmsdkobf.i6
            public String getOAID() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L6
                this.f265a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static i6 a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (r0 == null) goto L12;
            if ((r0 instanceof i6) == false) goto L12;
            return (i6) r0;
        L12:
            return new C0101a(r2);
        }
    }

    String getOAID();
}
