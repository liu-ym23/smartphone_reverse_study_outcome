package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface q9 extends IInterface {

    public static abstract class a extends Binder {

        /* JADX INFO: renamed from: tmsdkobf.q9$a$a, reason: collision with other inner class name */
        private static class C0102a implements q9 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f437a;

            C0102a(IBinder r1) {
                this.f437a = r1;
            }

            @Override // tmsdkobf.q9
            public String a(String r4, String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f437a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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
                return this.f437a;
            }
        }

        public static q9 a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.heytap.openid.IOpenID");
            if (r0 == null) goto L12;
            if ((r0 instanceof q9) == false) goto L12;
            return (q9) r0;
        L12:
            return new C0102a(r2);
        }
    }

    String a(String r1, String r2, String r3);
}
