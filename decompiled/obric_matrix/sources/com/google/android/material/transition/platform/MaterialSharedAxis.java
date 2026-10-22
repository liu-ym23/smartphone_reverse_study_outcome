package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {

    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Axis {
    }

    static {
        DEFAULT_THEMED_DURATION_ATTR = R.attr.motionDurationLong1;
        DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingStandard;
    }

    public MaterialSharedAxis(int r3, boolean r4) {
        super(createPrimaryAnimatorProvider(r3, r4), createSecondaryAnimatorProvider());
        this.axis = r3;
        this.forward = r4;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int r2, boolean r3) {
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L10;
        return new ScaleProvider(r3);
    L10:
        throw new IllegalArgumentException("Invalid axis: " + r2);
    L12:
        if (r3 == false) goto L14;
        int r4 = 80;
    L16:
        return new SlideDistanceProvider(r4);
    L14:
        r4 = 48;
        goto L16
    L18:
        if (r3 == false) goto L20;
        int r5 = GravityCompat.END;
    L22:
        return new SlideDistanceProvider(r5);
    L20:
        r5 = GravityCompat.START;
        goto L22
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r1) {
        super.addAdditionalAnimatorProvider(r1);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
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
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
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
