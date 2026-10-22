package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public class x3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f22547f;

    public x3(IBinder r1) {
        this.f22547f = r1;
    }

    public String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) m.a(16777217, 0, 0, "a54b43", new byte[]{115, 56, 74, 88, 24, 37, 111, 7, 112, 60, 119, 121, 70, 24, 15, 54, 109, 29, 97, 124, 116, 50, 81, 31, 8, 33, 107, 16, 118, 55, 98, 33, 78, 21, 14, 106, 75, 48, 96, 36, 121, 52, 66, 63, 15, 23, 103, 6, 115, 59, 115, 50}));     // Catch: Throwable -> L5
        this.f22547f.transact(1, r1, r2, 0);     // Catch: Throwable -> L5
        r2.readException();     // Catch: Throwable -> L5
        String r0 = r2.readString();     // Catch: Throwable -> L5
    L7:
        r2.recycle();
        r1.recycle();
        return r0;
    L5:
        th = move-exception;
        r2.recycle();
        r1.recycle();
        th.printStackTrace();
        r0 = null;
        goto L7
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f22547f;
    }
}
