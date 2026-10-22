package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes2.dex */
public class w3 implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IBinder f22539f;

    public w3(IBinder r1) {
        this.f22539f = r1;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f22539f;
    }
}
