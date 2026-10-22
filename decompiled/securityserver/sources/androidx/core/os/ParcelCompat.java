package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static boolean readBoolean(@NonNull Parcel r0) {
        if (r0.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void writeBoolean(@NonNull Parcel r0, boolean r1) {
        r0.writeInt(r1 ? 1 : 0);
    }
}
