package com.bytedanceos.rotateview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedanceos.security.widget.DefaultAnimatorListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ColorAnimateHelper extends DefaultAnimatorListener implements ValueAnimator.AnimatorUpdateListener {
    private final ValueAnimator mColorAnimator;
    private final List<WeakReference<ColorUpdateListener>> mListenerRefs;

    public interface ColorUpdateListener {
        void onColorUpdate(int color);

        void onColorUpdateEnd();
    }

    @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator arg0) {
    }

    @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator arg0) {
    }

    @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator arg0) {
    }

    public ColorAnimateHelper() {
        this.mListenerRefs = new ArrayList();
        ValueAnimator r0 = ValueAnimator.ofArgb(new int[]{0});
        this.mColorAnimator = r0;
        r0.setInterpolator(new AccelerateDecelerateInterpolator());
        r0.addUpdateListener(this);
        r0.addListener(this);
    }

    public ValueAnimator getColorAnimator() {
        return this.mColorAnimator;
    }

    public void addListener(ColorUpdateListener listener) {
        Iterator<WeakReference<ColorUpdateListener>> r0 = this.mListenerRefs.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().get() != listener) goto L4;
        return;
    L8:
        this.mListenerRefs.add(new WeakReference(listener));
    }

    public void removeListener(ColorUpdateListener listener) {
        Iterator<WeakReference<ColorUpdateListener>> r0 = this.mListenerRefs.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        WeakReference<ColorUpdateListener> r1 = r0.next();
        if (r1.get() != listener) goto L4;
        this.mListenerRefs.remove(r1);
        return;
    }

    public void removeAllListeners() {
        this.mListenerRefs.clear();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (animation.getAnimatedValue() != null) goto L5;
        return;
    L5:
        setColor(((Integer) animation.getAnimatedValue()).intValue());
    }

    public void setColor(int color) {
        Iterator<WeakReference<ColorUpdateListener>> r1 = this.mListenerRefs.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ColorUpdateListener r0 = r1.next().get();
        if (r0 == null) goto L4;
        r0.onColorUpdate(color);
        goto L4
    }

    public void destory() {
        this.mListenerRefs.clear();
        this.mColorAnimator.cancel();
    }

    @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator arg0) {
        Iterator<WeakReference<ColorUpdateListener>> r0 = this.mListenerRefs.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ColorUpdateListener r1 = r0.next().get();
        if (r1 == null) goto L4;
        r1.onColorUpdateEnd();
        goto L4
    }
}
