package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(TransitionValues r1);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup r1, Transition r2, TransitionValues r3, TransitionValues r4);

    public TransitionPropagation() {
    }
}
