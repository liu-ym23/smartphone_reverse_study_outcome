package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface h6 extends IInterface {

    public static abstract class a extends Binder implements h6 {

        /* JADX INFO: renamed from: tmsdkobf.h6$a$a, reason: collision with other inner class name */
        private static class C0099a implements h6 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f238a;

            C0099a(IBinder r1) {
                this.f238a = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f238a;
            }

            @Override // tmsdkobf.h6
            public String getOAID() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L6
                this.f238a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

        public static h6 a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (r0 == null) goto L12;
            if ((r0 instanceof h6) == false) goto L12;
            return (h6) r0;
        L12:
            return new C0099a(r2);
        }
    }

    String getOAID();
}
