package tmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface r extends IInterface {

    public static abstract class a extends Binder implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f461a = null;

        /* JADX INFO: renamed from: tmsdkobf.r$a$a, reason: collision with other inner class name */
        public static class C0104a implements r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f462a;

            public C0104a(IBinder r1) {
                this.f462a = r1;
            }

            @Override // tmsdkobf.r
            public int a(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f461a);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f462a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
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
                return this.f462a;
            }

            @Override // tmsdkobf.r
            public int b(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f461a);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f462a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // tmsdkobf.r
            public boolean c(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f461a);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.f462a.transact(3, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // tmsdkobf.r
            public r1 d(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f461a);     // Catch: Throwable -> L10
                r0.writeInt(r4);     // Catch: Throwable -> L10
                this.f462a.transact(2, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                r1 r3 = new r1(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r3;
            L7:
                r3 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // tmsdkobf.r
            public int a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f461a);     // Catch: Throwable -> L6
                this.f462a.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
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

        static {
            f461a = xk.a(xk.K0);
        }
    }

    int a();

    int a(int r1);

    int b(int r1);

    boolean c(int r1);

    r1 d(int r1);
}
