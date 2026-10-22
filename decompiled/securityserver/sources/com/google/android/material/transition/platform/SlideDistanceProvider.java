package com.google.android.material.transition.platform;

import a.a;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int r2) {
        this.slideDistance = -1;
        this.slideEdge = r2;
    }

    private static Animator createTranslationAppearAnimator(View r2, View r3, int r4, @Px int r5) {
        if (r4 == 3) goto L35;
        if (r4 == 5) goto L33;
        if (r4 == 48) goto L31;
        if (r4 == 80) goto L29;
        if (r4 == 8388611) goto L23;
        if (r4 != 8388613) goto L21;
        if (isRtl(r2) == false) goto L17;
        float r6 = -r5;
    L19:
        return createTranslationXAnimator(r3, r6, 0.0f);
    L17:
        r6 = r5;
        goto L19
    L21:
        throw new IllegalArgumentException(a.e(r4, "Invalid slide direction: "));
    L23:
        if (isRtl(r2) == false) goto L25;
        float r7 = r5;
    L27:
        return createTranslationXAnimator(r3, r7, 0.0f);
    L25:
        r7 = -r5;
        goto L27
    L29:
        return createTranslationYAnimator(r3, r5, 0.0f);
    L31:
        return createTranslationYAnimator(r3, -r5, 0.0f);
    L33:
        return createTranslationXAnimator(r3, -r5, 0.0f);
    L35:
        return createTranslationXAnimator(r3, r5, 0.0f);
    }

    private static Animator createTranslationDisappearAnimator(View r2, View r3, int r4, @Px int r5) {
        if (r4 == 3) goto L35;
        if (r4 == 5) goto L33;
        if (r4 == 48) goto L31;
        if (r4 == 80) goto L29;
        if (r4 == 8388611) goto L23;
        if (r4 != 8388613) goto L21;
        if (isRtl(r2) == false) goto L17;
        float r6 = r5;
    L19:
        return createTranslationXAnimator(r3, 0.0f, r6);
    L17:
        r6 = -r5;
        goto L19
    L21:
        throw new IllegalArgumentException(a.e(r4, "Invalid slide direction: "));
    L23:
        if (isRtl(r2) == false) goto L25;
        float r7 = -r5;
    L27:
        return createTranslationXAnimator(r3, 0.0f, r7);
    L25:
        r7 = r5;
        goto L27
    L29:
        return createTranslationYAnimator(r3, 0.0f, -r5);
    L31:
        return createTranslationYAnimator(r3, 0.0f, r5);
    L33:
        return createTranslationXAnimator(r3, 0.0f, r5);
    L35:
        return createTranslationXAnimator(r3, 0.0f, -r5);
    }

    private static Animator createTranslationXAnimator(View r3, float r4, float r5) {
        return ObjectAnimator.ofPropertyValuesHolder(r3, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r4, r5})});
    }

    private static Animator createTranslationYAnimator(View r3, float r4, float r5) {
        return ObjectAnimator.ofPropertyValuesHolder(r3, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r4, r5})});
    }

    private int getSlideDistanceOrDefault(Context r2) {
        int r1 = this.slideDistance;
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        return r2.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r3, @NonNull View r4) {
        return createTranslationAppearAnimator(r3, r4, this.slideEdge, getSlideDistanceOrDefault(r4.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r3, @NonNull View r4) {
        return createTranslationDisappearAnimator(r3, r4, this.slideEdge, getSlideDistanceOrDefault(r4.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int r1) {
        if (r1 < 0) goto L6;
        this.slideDistance = r1;
        return;
    L6:
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int r1) {
        this.slideEdge = r1;
    }
}
