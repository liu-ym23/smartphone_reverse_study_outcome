package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = null;

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
    }

    public ChangeClipBounds() {
    }

    private void captureValues(TransitionValues r4) {
        View r3 = r4.view;
        if (r3.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r0 = ViewCompat.getClipBounds(r3);
        r4.values.put(PROPNAME_CLIP, r0);
        if (r0 != null) goto L9;
        Rect r1 = new Rect(0, 0, r3.getWidth(), r3.getHeight());
        r4.values.put(PROPNAME_BOUNDS, r1);
        return;
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
    public Animator createAnimator(@NonNull ViewGroup r5, TransitionValues r6, TransitionValues r7) {
        ObjectAnimator r8 = null;
        if (r6 == null) goto L28;
        if (r7 == null) goto L28;
        if (r6.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        if (r7.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        Rect r0 = (Rect) r6.values.get(PROPNAME_CLIP);
        Rect r1 = (Rect) r7.values.get(PROPNAME_CLIP);
        if (r1 != null) goto L13;
        boolean r2 = true;
    L14:
        if (r0 != null) goto L18;
        if (r1 != null) goto L18;
        return null;
    L18:
        if (r0 != null) goto L20;
        r0 = (Rect) r6.values.get(PROPNAME_BOUNDS);
    L23:
        if (r0.equals(r1) == false) goto L25;
        return null;
    L25:
        ViewCompat.setClipBounds(r7.view, r0);
        RectEvaluator r9 = new RectEvaluator(new Rect());
        r8 = ObjectAnimator.ofObject(r7.view, ViewUtils.CLIP_BOUNDS, r9, new Rect[]{r0, r1});
        if (r2 == false) goto L28;
        final View r10 = r7.view;
        r8.addListener(new AnonymousClass1(this, r10));
        goto L28
    L20:
        if (r1 != null) goto L23;
        r1 = (Rect) r7.values.get(PROPNAME_BOUNDS);
        goto L23
    L13:
        r2 = false;
    L28:
        return r8;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
