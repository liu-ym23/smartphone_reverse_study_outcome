package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
    private static final float DEFAULT_START_SCALE = 0.92f;

    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;

    static {
        DEFAULT_THEMED_DURATION_ATTR = R.attr.motionDurationLong1;
        DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingStandard;
    }

    public MaterialFadeThrough() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static FadeThroughProvider createPrimaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider r0 = new ScaleProvider();
        r0.setScaleOnDisappear(false);
        r0.setIncomingStartScale(DEFAULT_START_SCALE);
        return r0;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r1) {
        super.addAdditionalAnimatorProvider(r1);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @AttrRes
    int getDurationThemeAttrResId(boolean r1) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @AttrRes
    int getEasingThemeAttrResId(boolean r1) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return super.onAppear(r1, r2, r3, r4);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return super.onDisappear(r1, r2, r3, r4);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r1) {
        return super.removeAdditionalAnimatorProvider(r1);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider r1) {
        super.setSecondaryAnimatorProvider(r1);
    }
}
