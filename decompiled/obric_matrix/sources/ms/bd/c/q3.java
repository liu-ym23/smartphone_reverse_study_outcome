package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class q3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f22467f;

    public q3(IBinder r1) {
        this.f22467f = r1;
    }

    public String a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken((String) m.a(16777217, 0, 0, "36a472", new byte[]{33, 59, 31, 14, 9, 54, 37, 4, 126, 105, 49, 53, 92, 115, 29, 53, 32, 27, 53, 105, 39, 58, 6, 65, 26, 60, 20, 62, 20, 42, 11, 16, 27, 68, 41, 44, 52, 27, 25, 106, 54, 49, 0, 70, 9, 38, 53}));     // Catch: Throwable -> L5
        this.f22467f.transact(3, r0, r1, 0);     // Catch: Throwable -> L5
        r1.readException();     // Catch: Throwable -> L5
        String r2 = r1.readString();     // Catch: Throwable -> L5
    L6:
        r0.recycle();
        r1.recycle();
        return r2;
    L5:
        r0.recycle();
        r1.recycle();
        r2 = null;
        goto L6
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f22467f;
    }
}
