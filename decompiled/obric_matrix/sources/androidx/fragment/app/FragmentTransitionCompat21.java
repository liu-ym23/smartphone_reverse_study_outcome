package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FragmentTransitionCompat21 extends FragmentTransitionImpl {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void addListener(@NonNull Transition r0, @NonNull Transition.TransitionListener r1) {
            r0.addListener(r1);
        }

        static void removeListener(@NonNull Transition r0, @NonNull Transition.TransitionListener r1) {
            r0.removeListener(r1);
        }
    }

    FragmentTransitionCompat21() {
    }

    private static boolean hasSimpleTarget(Transition r1) {
        if (FragmentTransitionImpl.isNullOrEmpty(r1.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (FragmentTransitionImpl.isNullOrEmpty(r1.getTargetNames()) == false) goto L10;
        if (FragmentTransitionImpl.isNullOrEmpty(r1.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object r1, View r2) {
        if (r1 == null) goto L5;
        ((Transition) r1).addTarget(r2);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object r4, ArrayList<View> r5) {
        Transition r6 = (Transition) r4;
        if (r6 != null) goto L5;
        return;
    L5:
        int r1 = 0;
        if ((r6 instanceof TransitionSet) == false) goto L11;
        TransitionSet r7 = (TransitionSet) r6;
        int r0 = r7.getTransitionCount();
    L8:
        if (r1 >= r0) goto L21;
        addTargets(r7.getTransitionAt(r1), r5);
        r1 = r1 + 1;
        goto L8
    L21:
        return;
    L11:
        if (hasSimpleTarget(r6) == false) goto L13;
        return;
    L13:
        if (FragmentTransitionImpl.isNullOrEmpty(r6.getTargets()) == false) goto L20;
        int r3 = r5.size();
    L15:
        if (r1 >= r3) goto L22;
        r6.addTarget(r5.get(r1));
        r1 = r1 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup r1, Object r2) {
        TransitionManager.beginDelayedTransition(r1, (Transition) r2);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object r1) {
        return r1 instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return ((Transition) r1).clone();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object r1, Object r2, Object r3) {
        Transition r4 = (Transition) r1;
        Transition r5 = (Transition) r2;
        Transition r6 = (Transition) r3;
        if (r4 == null) goto L6;
        if (r5 == null) goto L6;
        r4 = new TransitionSet().addTransition(r4).addTransition(r5).setOrdering(1);
    L11:
        if (r6 == null) goto L17;
        TransitionSet r0 = new TransitionSet();
        if (r4 == null) goto L15;
        r0.addTransition(r4);
    L15:
        r0.addTransition(r6);
        return r0;
    L17:
        return r4;
    L6:
        if (r4 != null) goto L11;
        if (r5 == null) goto L10;
        r4 = r5;
        goto L11
    L10:
        r4 = null;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object r1, Object r2, Object r3) {
        TransitionSet r0 = new TransitionSet();
        if (r1 == null) goto L5;
        r0.addTransition((Transition) r1);
    L5:
        if (r2 == null) goto L7;
        r0.addTransition((Transition) r2);
    L7:
        if (r3 == null) goto L9;
        r0.addTransition((Transition) r3);
    L9:
        return r0;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object r1, View r2) {
        if (r1 == null) goto L5;
        ((Transition) r1).removeTarget(r2);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object r4, ArrayList<View> r5, ArrayList<View> r6) {
        Transition r7 = (Transition) r4;
        int r1 = 0;
        if ((r7 instanceof TransitionSet) == false) goto L8;
        TransitionSet r8 = (TransitionSet) r7;
        int r0 = r8.getTransitionCount();
    L5:
        if (r1 >= r0) goto L31;
        replaceTargets(r8.getTransitionAt(r1), r5, r6);
        r1 = r1 + 1;
        goto L5
    L31:
        return;
    L8:
        if (hasSimpleTarget(r7) == true) goto L23;
        List<View> r3 = r7.getTargets();
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.size() == r5.size()) goto L14;
        return;
    L14:
        if (r3.containsAll(r5) == false) goto L30;
        if (r6 != null) goto L17;
        int r9 = 0;
    L18:
        if (r1 >= r9) goto L20;
        r7.addTarget(r6.get(r1));
        r1 = r1 + 1;
        goto L18
    L20:
        int r10 = r5.size() - 1;
    L21:
        if (r10 < 0) goto L32;
        r7.removeTarget(r5.get(r10));
        r10 = r10 - 1;
        goto L21
    L32:
        return;
    L17:
        r9 = r6.size();
        goto L18
    L30:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object r2, final View r3, final ArrayList<View> r4) {
        ((Transition) r2).addListener(new AnonymousClass2(this, r3, r4));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object r11, final Object r12, final ArrayList<View> r13, final Object r14, final ArrayList<View> r15, final Object r16, final ArrayList<View> r17) {
        ((Transition) r11).addListener(new AnonymousClass3(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r2, final Rect r3) {
        if (r2 == null) goto L5;
        ((Transition) r2).setEpicenterCallback(new AnonymousClass5(this, r3));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r2, View r3) {
        if (r3 == null) goto L5;
        final Rect r0 = new Rect();
        getBoundsOnScreen(r3, r0);
        ((Transition) r2).setEpicenterCallback(new AnonymousClass1(this, r0));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(@NonNull Fragment r1, @NonNull Object r2, @NonNull CancellationSignal r3, @NonNull final Runnable r4) {
        ((Transition) r2).addListener(new AnonymousClass4(this, r4));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object r5, View r6, ArrayList<View> r7) {
        TransitionSet r8 = (TransitionSet) r5;
        List<View> r0 = r8.getTargets();
        r0.clear();
        int r1 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        FragmentTransitionImpl.bfsAddViewChildren(r0, r7.get(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        r0.add(r6);
        r7.add(r6);
        addTargets(r8, r7);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object r2, ArrayList<View> r3, ArrayList<View> r4) {
        TransitionSet r5 = (TransitionSet) r2;
        if (r5 == null) goto L6;
        r5.getTargets().clear();
        r5.getTargets().addAll(r4);
        replaceTargets(r5, r3, r4);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        TransitionSet r0 = new TransitionSet();
        r0.addTransition((Transition) r1);
        return r0;
    }
}
