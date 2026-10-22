package tmsdkobf;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import tmsdk.common.DataEntity;

/* JADX INFO: loaded from: classes5.dex */
public interface r6 extends IInterface {

    public static abstract class a extends Binder implements r6 {
        public a() {
            attachInterface(this, "com.tencent.tmsecure.common.ISDKClient");
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof a) == true) goto L5;
            return false;
        L5:
            return super.equals((a) r2);
        }

        @Override // android.os.Binder, android.os.IBinder
        public String getInterfaceDescriptor() {
            return "com.tencent.tmsecure.common.ISDKClient";
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) {
            if (r2 != 20100405) goto L7;
            r3.enforceInterface("com.tencent.tmsecure.common.ISDKClient");
            DataEntity r1 = a((DataEntity) r3.readParcelable(DataEntity.class.getClassLoader()));
            r4.writeNoException();
            r4.writeParcelable(r1, 0);
            return true;
        L7:
            return super.onTransact(r2, r3, r4, r5);
        }
    }

    DataEntity a(DataEntity r1);
}
