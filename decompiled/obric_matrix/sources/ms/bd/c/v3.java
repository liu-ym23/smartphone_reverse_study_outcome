package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public class v3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f22526f;

    public v3(IBinder r1) {
        this.f22526f = r1;
    }

    public String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) m.a(16777217, 0, 0, "de2e5f", new byte[]{118, 104, 76, 95, 16, 100, 110, 10, 103, 48, 99, 110, 66, 20, 3, 117, 116, 65, 113, 35, 124, 100, 68, 95, 35, 85, 98, 82, 106, 54, 112, 110, 69, 56, 4, 101, 98, 86, 101, 52, 118, 98}));     // Catch: Throwable -> L6 Exception -> L8
        this.f22526f.transact(1, r1, r2, 0);     // Catch: Throwable -> L6 Exception -> L8
        r2.readException();     // Catch: Throwable -> L6 Exception -> L8
        String r0 = r2.readString();     // Catch: Throwable -> L6 Exception -> L8
        r2.recycle();
        r1.recycle();
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        r2.recycle();
        r1.recycle();
        return null;
    L6:
        th = move-exception;
        r2.recycle();
        r1.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
