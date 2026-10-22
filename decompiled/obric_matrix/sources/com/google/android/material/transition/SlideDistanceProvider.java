package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
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

    private static Animator createTranslationAppearAnimator(View r3, View r4, int r5, @Px int r6) {
        float r0 = r4.getTranslationX();
        float r1 = r4.getTranslationY();
        if (r5 == 3) goto L35;
        if (r5 == 5) goto L33;
        if (r5 == 48) goto L31;
        if (r5 == 80) goto L29;
        if (r5 == 8388611) goto L23;
        if (r5 != 8388613) goto L21;
        if (isRtl(r3) == false) goto L17;
        float r7 = r0 - r6;
    L19:
        return createTranslationXAnimator(r4, r7, r0, r0);
    L17:
        r7 = r6 + r0;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r5);
    L23:
        if (isRtl(r3) == false) goto L25;
        float r8 = r6 + r0;
    L27:
        return createTranslationXAnimator(r4, r8, r0, r0);
    L25:
        r8 = r0 - r6;
        goto L27
    L29:
        return createTranslationYAnimator(r4, r6 + r1, r1, r1);
    L31:
        return createTranslationYAnimator(r4, r1 - r6, r1, r1);
    L33:
        return createTranslationXAnimator(r4, r0 - r6, r0, r0);
    L35:
        return createTranslationXAnimator(r4, r6 + r0, r0, r0);
    }

    private static Animator createTranslationDisappearAnimator(View r3, View r4, int r5, @Px int r6) {
        float r0 = r4.getTranslationX();
        float r1 = r4.getTranslationY();
        if (r5 == 3) goto L35;
        if (r5 == 5) goto L33;
        if (r5 == 48) goto L31;
        if (r5 == 80) goto L29;
        if (r5 == 8388611) goto L23;
        if (r5 != 8388613) goto L21;
        if (isRtl(r3) == false) goto L17;
        float r7 = r6 + r0;
    L19:
        return createTranslationXAnimator(r4, r0, r7, r0);
    L17:
        r7 = r0 - r6;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r5);
    L23:
        if (isRtl(r3) == false) goto L25;
        float r8 = r0 - r6;
    L27:
        return createTranslationXAnimator(r4, r0, r8, r0);
    L25:
        r8 = r6 + r0;
        goto L27
    L29:
        return createTranslationYAnimator(r4, r1, r1 - r6, r1);
    L31:
        return createTranslationYAnimator(r4, r1, r6 + r1, r1);
    L33:
        return createTranslationXAnimator(r4, r0, r6 + r0, r0);
    L35:
        return createTranslationXAnimator(r4, r0, r0 - r6, r0);
    }

    private static Animator createTranslationXAnimator(final View r5, float r6, float r7, final float r8) {
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r6, r7})});
        r9.addListener(new AnonymousClass1(r5, r8));
        return r9;
    }

    private static Animator createTranslationYAnimator(final View r5, float r6, float r7, final float r8) {
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r6, r7})});
        r9.addListener(new AnonymousClass2(r5, r8));
        return r9;
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

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r3, @NonNull View r4) {
        return createTranslationAppearAnimator(r3, r4, this.slideEdge, getSlideDistanceOrDefault(r4.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
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
