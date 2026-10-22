package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    static {
    }

    public AnimatorDurationScaleProvider() {
    }

    @VisibleForTesting
    public static void setDefaultSystemAnimatorDurationScale(float r0) {
        defaultSystemAnimatorDurationScale = r0;
    }

    public float getSystemAnimatorDurationScale(@NonNull ContentResolver r4) {
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 17) goto L7;
        return Settings.Global.getFloat(r4, "animator_duration_scale", 1.0f);
    L7:
        if (r3 != 16) goto L11;
        return Settings.System.getFloat(r4, "animator_duration_scale", 1.0f);
    L11:
        return defaultSystemAnimatorDurationScale;
    }
}
