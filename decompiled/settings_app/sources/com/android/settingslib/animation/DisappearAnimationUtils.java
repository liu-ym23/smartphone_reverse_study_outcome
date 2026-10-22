package com.android.settingslib.animation;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class DisappearAnimationUtils extends AppearAnimationUtils {
    private static final AppearAnimationUtils.RowTranslationScaler ROW_TRANSLATION_SCALER = null;

    public DisappearAnimationUtils(Context r8) {
        this(r8, 220, 1.0f, 1.0f, AnimationUtils.loadInterpolator(r8, 17563663));
    }

    public DisappearAnimationUtils(Context r9, long r10, float r12, float r13, Interpolator r14) {
        this(r9, r10, r12, r13, r14, ROW_TRANSLATION_SCALER);
    }

    public DisappearAnimationUtils(Context r1, long r2, float r4, float r5, Interpolator r6, AppearAnimationUtils.RowTranslationScaler r7) {
        super(r1, r2, r4, r5, r6);
        this.mRowTranslationScaler = r7;
        this.mAppearing = false;
    }

    @Override // com.android.settingslib.animation.AppearAnimationUtils
    protected long calculateDelay(int r7, int r8) {
        return (long) ((((double) (r7 * 60)) + ((((double) r8) * (Math.pow(r7, 0.4d) + 0.4d)) * 10.0d)) * ((double) this.mDelayScale));
    }

    static {
        ROW_TRANSLATION_SCALER = new AnonymousClass1();
    }
}
