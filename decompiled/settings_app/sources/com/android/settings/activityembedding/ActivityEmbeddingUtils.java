package com.android.settings.activityembedding;

import android.app.Activity;
import android.content.Context;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.util.FeatureFlagUtils;
import android.util.TypedValue;
import com.android.setupwizardlib.util.WizardManagerHelper;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityEmbeddingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/settings/activityembedding/ActivityEmbeddingUtils;", "", "()V", "MIN_REGULAR_HOMEPAGE_LAYOUT_WIDTH_DP", "", "SHOULD_ENABLE_LARGE_SCREEN_OPTIMIZATION", "", "TAG", "", "isEmbeddingActivityEnabled", "context", "Landroid/content/Context;", "isRegularHomepageLayout", "activity", "Landroid/app/Activity;", "isSettingsSplitEnabled", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityEmbeddingUtils {
    public static final ActivityEmbeddingUtils INSTANCE = null;
    private static final float MIN_REGULAR_HOMEPAGE_LAYOUT_WIDTH_DP = 380.0f;
    private static final boolean SHOULD_ENABLE_LARGE_SCREEN_OPTIMIZATION = false;
    private static final String TAG = "ActivityEmbeddingUtils";

    private ActivityEmbeddingUtils() {
    }

    static {
        INSTANCE = new ActivityEmbeddingUtils();
        boolean r1 = false;
        if (SystemProperties.getBoolean("persist.settings.large_screen_opt.enabled", false) == false) goto L6;
        r1 = true;
    L6:
        SHOULD_ENABLE_LARGE_SCREEN_OPTIMIZATION = r1;
    }

    public final boolean isSettingsSplitEnabled(Context r1) {
        return SHOULD_ENABLE_LARGE_SCREEN_OPTIMIZATION;
    }

    @JvmStatic
    public static final boolean isEmbeddingActivityEnabled(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (INSTANCE.isSettingsSplitEnabled(r3) == true) goto L7;
        OLog.d(TAG, "isSettingsSplitSupported = false");
        return false;
    L7:
        if (FeatureFlagUtils.isEnabled(r3, "settings_support_large_screen") == true) goto L11;
        OLog.d(TAG, "isFlagEnabled = false");
        return false;
    L11:
        if (WizardManagerHelper.isUserSetupComplete(r3) == true) goto L14;
        OLog.d(TAG, "isUserSetupComplete = false");
        return false;
    L14:
        OLog.d(TAG, "isEmbeddingActivityEnabled = true");
        return true;
    }

    public final boolean isRegularHomepageLayout(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        DisplayMetrics r2 = r3.getResources().getDisplayMetrics();
        if (r2.widthPixels >= ((int) TypedValue.applyDimension(1, MIN_REGULAR_HOMEPAGE_LAYOUT_WIDTH_DP, r2))) goto L7;
        return false;
    L7:
        return true;
    }
}
