package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String[] PROPERTIES = null;
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    static {
        PROPERTIES = new String[]{PROPNAME_SCROLL_X, PROPNAME_SCROLL_Y};
    }

    public ChangeScroll() {
    }

    private void captureValues(TransitionValues r3) {
        r3.values.put(PROPNAME_SCROLL_X, Integer.valueOf(r3.view.getScrollX()));
        r3.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(r3.view.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r4, @Nullable TransitionValues r5, @Nullable TransitionValues r6) {
        ObjectAnimator r3 = null;
        if (r5 == null) goto L14;
        if (r6 == null) goto L15;
        View r7 = r6.view;
        int r0 = ((Integer) r5.values.get(PROPNAME_SCROLL_X)).intValue();
        int r1 = ((Integer) r6.values.get(PROPNAME_SCROLL_X)).intValue();
        int r8 = ((Integer) r5.values.get(PROPNAME_SCROLL_Y)).intValue();
        int r9 = ((Integer) r6.values.get(PROPNAME_SCROLL_Y)).intValue();
        if (r0 == r1) goto L9;
        r7.setScrollX(r0);
        ObjectAnimator r2 = ObjectAnimator.ofInt(r7, "scrollX", new int[]{r0, r1});
    L10:
        if (r8 == r9) goto L13;
        r7.setScrollY(r8);
        r3 = ObjectAnimator.ofInt(r7, "scrollY", new int[]{r8, r9});
    L13:
        return TransitionUtils.mergeAnimators(r2, r3);
    L9:
        r2 = null;
        goto L10
    L15:
        return null;
    L14:
        return null;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    public ChangeScroll(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
