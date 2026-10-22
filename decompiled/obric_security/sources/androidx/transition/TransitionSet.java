package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private ArrayList<Transition> mTransitions;

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet r1) {
            this.mTransitionSet = r1;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r1) {
            if (this.mTransitionSet.mStarted == true) goto L6;
            this.mTransitionSet.start();
            this.mTransitionSet.mStarted = true;
            return;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r3) {
            this.mTransitionSet.mCurrentListeners--;
            if (this.mTransitionSet.mCurrentListeners != 0) goto L5;
            this.mTransitionSet.mStarted = false;
            this.mTransitionSet.end();
        L5:
            r3.removeListener(this);
        }
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addListener(Transition.TransitionListener r1) {
        return addListener(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(int r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(View r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(Class r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(String r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo61clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeListener(Transition.TransitionListener r1) {
        return removeListener(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(int r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(View r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(Class r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(String r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long r1) {
        return setDuration(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setInterpolator(TimeInterpolator r1) {
        return setInterpolator(r1);
    }

    @Override // androidx.transition.Transition
    /* bridge */ /* synthetic */ Transition setSceneRoot(ViewGroup r1) {
        return setSceneRoot(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r1) {
        return setStartDelay(r1);
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    public TransitionSet(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray r5 = r3.obtainStyledAttributes(r4, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(r5, (XmlResourceParser) r4, "transitionOrdering", 0, 0));
        r5.recycle();
    }

    public TransitionSet setOrdering(int r3) {
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        this.mPlayTogether = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r3);
    L8:
        this.mPlayTogether = true;
        goto L9
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    public TransitionSet addTransition(Transition r5) {
        addTransitionInternal(r5);
        if (this.mDuration < 0) goto L6;
        r5.setDuration(this.mDuration);
    L6:
        if ((this.mChangeFlags & 1) == 0) goto L9;
        r5.setInterpolator(getInterpolator());
    L9:
        if ((this.mChangeFlags & 2) == 0) goto L12;
        r5.setPropagation(getPropagation());
    L12:
        if ((this.mChangeFlags & 4) == 0) goto L15;
        r5.setPathMotion(getPathMotion());
    L15:
        if ((this.mChangeFlags & 8) == 0) goto L17;
        r5.setEpicenterCallback(getEpicenterCallback());
    L17:
        return this;
    }

    private void addTransitionInternal(Transition r2) {
        this.mTransitions.add(r2);
        r2.mParent = this;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public Transition getTransitionAt(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mTransitions.size()) goto L7;
        return null;
    L7:
        return this.mTransitions.get(r2);
    }

    @Override // androidx.transition.Transition
    public TransitionSet setDuration(long r5) {
        super.setDuration(r5);
        if (this.mDuration < 0) goto L9;
        ArrayList<Transition> r0 = this.mTransitions;
        if (r0 == null) goto L9;
        int r1 = r0.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        this.mTransitions.get(r2).setDuration(r5);
        r2 = r2 + 1;
    L9:
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet setStartDelay(long r1) {
        return (TransitionSet) super.setStartDelay(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet setInterpolator(TimeInterpolator r4) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> r0 = this.mTransitions;
        if (r0 == null) goto L8;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        this.mTransitions.get(r2).setInterpolator(r4);
        r2 = r2 + 1;
    L8:
        return (TransitionSet) super.setInterpolator(r4);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(View r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).addTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(int r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).addTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).addTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(Class<?> r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).addTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addListener(Transition.TransitionListener r1) {
        return (TransitionSet) super.addListener(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(int r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).removeTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(View r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).removeTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(Class<?> r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).removeTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r3);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).removeTarget(r3);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r3);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).excludeTarget(r3, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r3, r4);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).excludeTarget(r3, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r3, r4);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).excludeTarget(r3, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r3, r4);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r0).excludeTarget(r3, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r3, r4);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeListener(Transition.TransitionListener r1) {
        return (TransitionSet) super.removeListener(r1);
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r3) {
        super.setPathMotion(r3);
        this.mChangeFlags |= 4;
        if (this.mTransitions == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.mTransitions.size()) goto L10;
        this.mTransitions.get(r0).setPathMotion(r3);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    public TransitionSet removeTransition(Transition r2) {
        this.mTransitions.remove(r2);
        r2.mParent = null;
        return this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener r0 = new TransitionSetListener(this);
        Iterator<Transition> r1 = this.mTransitions.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().addListener(r0);
        goto L4
    L6:
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    protected void createAnimators(ViewGroup r13, TransitionValuesMaps r14, TransitionValuesMaps r15, ArrayList<TransitionValues> r16, ArrayList<TransitionValues> r17) {
        long r1 = getStartDelay();
        int r3 = this.mTransitions.size();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        Transition r6 = this.mTransitions.get(r4);
        if (r1 <= 0) goto L13;
        if (this.mPlayTogether == true) goto L9;
        if (r4 != 0) goto L13;
    L9:
        long r9 = r6.getStartDelay();
        if (r9 <= 0) goto L12;
        r6.setStartDelay(r9 + r1);
        goto L13
    L12:
        r6.setStartDelay(r1);
    L13:
        r6.createAnimators(r13, r14, r15, r16, r17);
        r4 = r4 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    protected void runAnimators() {
        if (this.mTransitions.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        setupStartEndListeners();
        if (this.mPlayTogether == true) goto L15;
        int r0 = 1;
    L10:
        if (r0 >= this.mTransitions.size()) goto L12;
        Transition r1 = this.mTransitions.get(r0 - 1);
        final Transition r2 = this.mTransitions.get(r0);
        r1.addListener(new AnonymousClass1(this, r2));
        r0 = r0 + 1;
        goto L10
    L12:
        Transition r4 = this.mTransitions.get(0);
        if (r4 == null) goto L19;
        r4.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator<Transition> r5 = this.mTransitions.iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        r5.next().runAnimators();
        goto L17
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r3) {
        if (isValidTarget(r3.view) == false) goto L10;
        Iterator<Transition> r2 = this.mTransitions.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Transition r0 = r2.next();
        if (r0.isValidTarget(r3.view) == false) goto L6;
        r0.captureStartValues(r3);
        r3.mTargetedTransitions.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r3) {
        if (isValidTarget(r3.view) == false) goto L10;
        Iterator<Transition> r2 = this.mTransitions.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Transition r0 = r2.next();
        if (r0.isValidTarget(r3.view) == false) goto L6;
        r0.captureEndValues(r3);
        r3.mTargetedTransitions.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues r4) {
        super.capturePropagationValues(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).capturePropagationValues(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void pause(View r4) {
        super.pause(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).pause(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void resume(View r4) {
        super.resume(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).resume(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    protected void cancel() {
        super.cancel();
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).cancel();
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    void forceToEnd(ViewGroup r4) {
        super.forceToEnd(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).forceToEnd(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    TransitionSet setSceneRoot(ViewGroup r4) {
        super.setSceneRoot(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).setSceneRoot(r4);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean r4) {
        super.setCanRemoveViews(r4);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).setCanRemoveViews(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation r4) {
        super.setPropagation(r4);
        this.mChangeFlags |= 2;
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).setPropagation(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback r4) {
        super.setEpicenterCallback(r4);
        this.mChangeFlags |= 8;
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTransitions.get(r1).setEpicenterCallback(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    String toString(String r6) {
        String r0 = super.toString(r6);
        int r1 = 0;
    L4:
        if (r1 >= this.mTransitions.size()) goto L6;
        r0 = r0 + IOUtils.LINE_SEPARATOR_UNIX + this.mTransitions.get(r1).toString(r6 + "  ");
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // androidx.transition.Transition
    public Transition clone() {
        TransitionSet r0 = (TransitionSet) super.clone();
        r0.mTransitions = new ArrayList();
        int r1 = this.mTransitions.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.addTransitionInternal(this.mTransitions.get(r2).clone());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
