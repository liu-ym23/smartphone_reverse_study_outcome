package com.android.settingslib.widget;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.android.settings.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LottieColorUtils {
    private static final Map<String, Integer> DARK_TO_LIGHT_THEME_COLOR_MAP = null;

    static {
        HashMap r0 = new HashMap();
        r0.put(".grey600", Integer.valueOf(R.color.settingslib_color_grey300));
        r0.put(".grey800", Integer.valueOf(R.color.settingslib_color_grey200));
        r0.put(".grey900", Integer.valueOf(R.color.settingslib_color_grey50));
        r0.put(".red400", Integer.valueOf(R.color.settingslib_color_red600));
        r0.put(".black", Integer.valueOf(android.R.color.white));
        r0.put(".blue400", Integer.valueOf(R.color.settingslib_color_blue600));
        r0.put(".green400", Integer.valueOf(R.color.settingslib_color_green600));
        DARK_TO_LIGHT_THEME_COLOR_MAP = Collections.unmodifiableMap(r0);
    }

    private LottieColorUtils() {
    }

    public static boolean isDarkMode(Context r1) {
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static void applyDynamicColors(Context r7, LottieAnimationView r8) {
        if (isDarkMode(r7) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = DARK_TO_LIGHT_THEME_COLOR_MAP.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        final int r2 = r7.getColor(DARK_TO_LIGHT_THEME_COLOR_MAP.get(r1).intValue());
        r8.addValueCallback(new KeyPath(new String[]{"**", r1, "**"}), LottieProperty.COLOR_FILTER, new LottieColorUtils$$ExternalSyntheticLambda0(r2));
        goto L7
    }

    static /* synthetic */ ColorFilter lambda$applyDynamicColors$0(int r1, LottieFrameInfo r2) {
        return new PorterDuffColorFilter(r1, PorterDuff.Mode.SRC_ATOP);
    }
}
