package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class s3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f22489f;

    public s3(IBinder r1) {
        this.f22489f = r1;
    }

    public String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) m.a(16777217, 0, 0, "03c7f1", new byte[]{34, 62, 29, 13, 76, 41, 55, 27, 33, 41, 46, 33, 21, 77, 93, 35, 37, 27, 49, 98, 111, 48, 25, 71, 85, 104, 28, 2, 55, 105, 5, 52, 6, 74, 90, 35, 26, 22, 55, 105, 53, 56, 22, 74, 92, 52, 0, 23, 32, 113, 40, 50, 21}));     // Catch: Throwable -> L5
        this.f22489f.transact(1, r1, r2, 0);     // Catch: Throwable -> L5
        r2.readException();     // Catch: Throwable -> L5
        String r0 = r2.readString();     // Catch: Throwable -> L5
    L7:
        r1.recycle();
        r2.recycle();
        return r0;
    L5:
        th = move-exception;
        r1.recycle();
        r2.recycle();
        th.printStackTrace();
        r0 = null;
        goto L7
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f22489f;
    }
}
