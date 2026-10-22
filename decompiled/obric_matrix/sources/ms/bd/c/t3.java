package ms.bd.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface t3 extends IInterface {

    public static abstract class a extends Binder implements t3 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f22493f = null;

        static {
            f22493f = (String) m.a(16777217, 0, 0, "9b54c4", new byte[]{43, 111, 75, 14, 84, 42, 50, 76, 106, 107, 58, 46, 69, 76, 83, 54, 62, 80, 97, 118, 62, 105, 69, 69, 18, 44, 59, 74, 96, 42, 1, 79, 103, 105, 120, 0, 59, 79, 104, 70, 41, 99, 77});
        }

        public a() {
            attachInterface(this, (String) m.a(16777217, 0, 0, "f540cf", new byte[]{116, 56, 74, 10, 84, 120, 109, 27, 107, 111, 101, 121, 68, 72, 83, 100, 97, 7, 96, 114, 97, 62, 68, 65, 18, 126, 100, 29, 97, 46, 94, 24, 102, 109, 120, 82, 100, 24, 105, 66, 118, 52, 76}));
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            String r0 = f22493f;
            if (r4 != 1) goto L5;
            r5.enforceInterface(r0);
            r5.readInt();
            r5.readLong();
            r5.readInt();
            r5.readFloat();
            r5.readDouble();
            r5.readString();
        L17:
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(r0);
            int r8 = r5.readInt();
            if (r5.readInt() == 0) goto L15;
            Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L16:
            ((i3.b) this).a(r8, r9);
            goto L17
        L15:
            r9 = null;
            goto L16
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(r0);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }
}
