package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface ba extends IInterface {

    public static abstract class a extends Binder implements ba {

        /* JADX INFO: renamed from: tmsdkobf.ba$a$a, reason: collision with other inner class name */
        private static class C0097a implements ba {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f114a;

            C0097a(IBinder r1) {
                this.f114a = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f114a;
            }

            @Override // tmsdkobf.ba
            public String b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");     // Catch: Throwable -> L6
                this.f114a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

        public static ba a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (r0 == null) goto L12;
            if ((r0 instanceof ba) == false) goto L12;
            return (ba) r0;
        L12:
            return new C0097a(r2);
        }
    }

    String b();
}
