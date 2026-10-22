package ms.bd.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface u3 extends IInterface {

    public static abstract class a extends Binder implements u3 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f22509f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f22510g = 0;

        /* JADX INFO: renamed from: ms.bd.c.u3$a$a, reason: collision with other inner class name */
        private static class C0602a implements u3 {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f22511f;

            C0602a(IBinder r1) {
                this.f22511f = r1;
            }

            @Override // ms.bd.c.u3
            public void W(t3 r19) {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken((String) m.a(16777217, 0, 0, "082609", new byte[]{34, 53, 76, 12, 7, 39, 59, 22, 109, 105, 51, 116, 66, 78, 0, 59, 55, 10, 102, 116, 55, 51, 66, 71, 65, 33, 50, 16, 103, 40, 8, 21, 96, 107, 43, 29, 54, 11, 117, 111, 34, 63}));     // Catch: Throwable -> L9
                r1.writeStrongBinder((t3.a) r19);     // Catch: Throwable -> L9
                if (this.f22511f.transact(2, r1, r2, 0) == true) goto L6;
                int r0 = a.f22510g;     // Catch: Throwable -> L9
            L6:
                r2.readException();     // Catch: Throwable -> L9
                r2.recycle();
                r1.recycle();
                return;
            L9:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22511f;
            }
        }

        static {
            f22509f = (String) m.a(16777217, 0, 0, "0587d8", new byte[]{34, 56, 70, 13, 83, 38, 59, 27, 103, 104, 51, 121, 72, 79, 84, 58, 55, 7, 108, 117, 55, 62, 72, 70, 21, 32, 50, 29, 109, 41, 8, 24, 106, 106, 127, 28, 54, 6, 127, 110, 34, 50});
        }

        public static u3 a(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(f22509f);
            if (r0 == null) goto L12;
            if ((r0 instanceof u3) == false) goto L12;
            return (u3) r0;
        L12:
            return new C0602a(r2);
        }
    }

    void W(t3 r1);
}
