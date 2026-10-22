package tmsdkobf;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface k6 extends IInterface {

    public static abstract class a extends Binder implements k6 {
        public a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L7;
            r5.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L20
            r6.writeNoException();     // Catch: RemoteException -> L20
            return true;
        L7:
            if (r4 != 2) goto L15;
            r5.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L20
            int r8 = r5.readInt();     // Catch: RemoteException -> L20
            if (r5.readInt() == 0) goto L11;
            Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r5);     // Catch: RemoteException -> L20
        L12:
            a(r8, r9);     // Catch: RemoteException -> L20
            r6.writeNoException();     // Catch: RemoteException -> L20
            return true;
        L11:
            r9 = null;
            goto L12
        L15:
            if (r4 != 1598968902) goto L17;
            r6.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");     // Catch: RemoteException -> L20
            return true;
        L17:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            return false;
        }
    }

    void a(int r1, Bundle r2);
}
