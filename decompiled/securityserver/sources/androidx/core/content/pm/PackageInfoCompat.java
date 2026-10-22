package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    public static long getLongVersionCode(@NonNull PackageInfo r2) {
        return r2.getLongVersionCode();
    }
}
