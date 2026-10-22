package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public class r3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f22478f;

    public r3(IBinder r1) {
        this.f22478f = r1;
    }

    public String a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken((String) m.a(16777217, 0, 0, "2b3837", new byte[]{32, 111, 77, 2, 14, 53, 63, 13, 110, 97, 33, 46, 109, 95, 13, 9, 53, 106, 108, 124, 38, 114, 70, 77, 15, 37}));     // Catch: Throwable -> L5
        this.f22478f.transact(3, r0, r1, 0);     // Catch: Throwable -> L5
        r1.readException();     // Catch: Throwable -> L5
        String r13 = r1.readString();     // Catch: Throwable -> L5
    L6:
        r1.recycle();
        r0.recycle();
        return r13;
    L5:
        r1.recycle();
        r0.recycle();
        r13 = null;
        goto L6
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f22478f;
    }
}
