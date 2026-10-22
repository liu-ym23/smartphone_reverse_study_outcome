package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@NonNull Resources r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return r2.getConfiguration().densityDpi;
    L7:
        return r2.getDisplayMetrics().densityDpi;
    }
}
