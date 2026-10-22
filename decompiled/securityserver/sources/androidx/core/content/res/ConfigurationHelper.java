package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@NonNull Resources r0) {
        return r0.getConfiguration().densityDpi;
    }
}
