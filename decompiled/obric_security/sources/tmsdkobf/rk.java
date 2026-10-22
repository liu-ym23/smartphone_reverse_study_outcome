package tmsdkobf;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class rk extends Binder implements IInterface {
    public rk() {
        attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) {
        if (r3 != 1) goto L7;
        r4.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L34
        r5.writeNoException();     // Catch: RemoteException -> L34
        return true;
    L7:
        if (r3 != 2) goto L29;
        r4.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L34
        int r7 = r4.readInt();     // Catch: RemoteException -> L34
        if (r4.readInt() == 0) goto L11;
        Bundle r8 = (Bundle) Bundle.CREATOR.createFromParcel(r4);     // Catch: RemoteException -> L34
    L12:
        ka r2 = (ka) this;     // Catch: RemoteException -> L34
        if (r2.b == true) goto L23;
        String r9 = "";
        if (r7 != 0) goto L19;
        if (r8 == null) goto L19;
        r9 = r8.getString("oa_id_flag");     // Catch: RemoteException -> L34
    L19:
        AtomicReference r10 = r2.f303a;     // Catch: RemoteException -> L34
        monitor-enter(r10);     // Catch: RemoteException -> L34
        r2.f303a.set(r9);     // Catch: Throwable -> L25
        r2.f303a.notifyAll();     // Catch: Throwable -> L25
        monitor-exit(r10);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L34
    L23:
        r5.writeNoException();     // Catch: RemoteException -> L34
        return true;
    L11:
        r8 = null;
        goto L12
    L29:
        if (r3 != 1598968902) goto L31;
        r5.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L34
        return true;
    L31:
        return super.onTransact(r3, r4, r5, r6);
    L34:
        return false;
    }
}
