package w2;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.model.objects.PackageUseCountInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new PackageUseCountInfo(r5);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new PackageUseCountInfo[r5];
    }
}
