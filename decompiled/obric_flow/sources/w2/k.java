package w2;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.model.objects.PackageUseCountInfo;
import com.bytedance.ai.model.objects.PackageUseCountInfoWithIdentity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        IBinder r10 = r5.readStrongBinder();     // Catch: Exception -> L6
        ArrayList r11 = r5.createTypedArrayList(PackageUseCountInfo.CREATOR);     // Catch: Exception -> L6
        if (r11 != null) goto L8;
        r11 = new ArrayList();     // Catch: Exception -> L6
    L8:
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L6
        return new PackageUseCountInfoWithIdentity(r10, r11);
    L6:
        e = move-exception;
        String r12 = "createFromParcel exception: " + e;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L13;
        r13.e("AIManager", r12);
    L13:
        throw e;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new PackageUseCountInfoWithIdentity[r5];
    }
}
