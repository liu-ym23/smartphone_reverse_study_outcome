package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = null;

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context r1, AttributeSet r2) {
        super(r1, r2);
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
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r8, TransitionValues r9, TransitionValues r10) {
        ObjectAnimator r11 = null;
        if (r9 == null) goto L28;
        if (r10 == null) goto L28;
        if (r9.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        if (r10.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        Rect r0 = (Rect) r9.values.get(PROPNAME_CLIP);
        Rect r1 = (Rect) r10.values.get(PROPNAME_CLIP);
        if (r1 != null) goto L13;
        boolean r4 = true;
    L14:
        if (r0 != null) goto L18;
        if (r1 != null) goto L18;
        return null;
    L18:
        if (r0 != null) goto L20;
        r0 = (Rect) r9.values.get(PROPNAME_BOUNDS);
    L23:
        if (r0.equals(r1) == false) goto L25;
        return null;
    L25:
        ViewCompat.setClipBounds(r10.view, r0);
        r11 = ObjectAnimator.ofObject(r10.view, ViewUtils.CLIP_BOUNDS, new RectEvaluator(new Rect()), new Rect[]{r0, r1});
        if (r4 == false) goto L28;
        final View r12 = r10.view;
        r11.addListener(new AnonymousClass1(this, r12));
        goto L28
    L20:
        if (r1 != null) goto L23;
        r1 = (Rect) r10.values.get(PROPNAME_BOUNDS);
        goto L23
    L13:
        r4 = false;
    L28:
        return r11;
    }
}
