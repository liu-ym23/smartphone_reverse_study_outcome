package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface g6 extends IInterface {

    public static abstract class a extends Binder implements g6 {

        /* JADX INFO: renamed from: tmsdkobf.g6$a$a, reason: collision with other inner class name */
        private static class C0098a implements g6 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f213a;

            C0098a(IBinder r1) {
                this.f213a = r1;
            }

            @Override // tmsdkobf.g6
            public String a(String r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.f213a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r3 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f213a;
            }
        }

        public static g6 a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (r0 == null) goto L12;
            if ((r0 instanceof g6) == false) goto L12;
            return (g6) r0;
        L12:
            return new C0098a(r2);
        }
    }

    String a(String r1);
}
