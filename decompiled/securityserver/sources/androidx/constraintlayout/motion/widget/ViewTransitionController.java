package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransitionController {
    private String TAG;
    ArrayList<ViewTransition.Animate> animations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    ArrayList<ViewTransition.Animate> removeList;
    private ArrayList<ViewTransition> viewTransitions;

    public ViewTransitionController(MotionLayout r2) {
        this.viewTransitions = new ArrayList();
        this.TAG = "ViewTransitionController";
        this.removeList = new ArrayList();
        this.mMotionLayout = r2;
    }

    public static /* synthetic */ MotionLayout access$000(ViewTransitionController r0) {
        return r0.mMotionLayout;
    }

    private void listenForSharedVariable(final ViewTransition r10, final boolean r11) {
        final int r3 = r10.getSharedValueID();
        final int r5 = r10.getSharedValue();
        ConstraintLayout.getSharedValues().addListener(r10.getSharedValueID(), new AnonymousClass1(this, r10, r3, r11, r5));
    }

    private void viewTransition(ViewTransition r8, View... r9) {
        int r4 = this.mMotionLayout.getCurrentState();
        if (r8.mViewTransitionMode != 2) goto L5;
        r8.applyTransition(this, this.mMotionLayout, r4, null, r9);
        return;
    L5:
        if (r4 != (-1)) goto L8;
        Log.w(this.TAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
        return;
    L8:
        ConstraintSet r5 = this.mMotionLayout.getConstraintSet(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        r8.applyTransition(this, this.mMotionLayout, r4, r5, r9);
    }

    public void add(ViewTransition r3) {
        this.viewTransitions.add(r3);
        this.mRelatedViews = null;
        if (r3.getStateTransition() != 4) goto L6;
        listenForSharedVariable(r3, true);
        return;
    L6:
        if (r3.getStateTransition() != 5) goto L10;
        listenForSharedVariable(r3, false);
        return;
    }

    public void addAnimation(ViewTransition.Animate r2) {
        if (this.animations != null) goto L5;
        this.animations = new ArrayList();
    L5:
        this.animations.add(r2);
    }

    public void animate() {
        ArrayList<ViewTransition.Animate> r0 = this.animations;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<ViewTransition.Animate> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().mutate();
        goto L7
    L9:
        this.animations.removeAll(this.removeList);
        this.removeList.clear();
        if (this.animations.isEmpty() == false) goto L14;
        this.animations = null;
        return;
    }

    public boolean applyViewTransition(int r3, MotionController r4) {
        Iterator<ViewTransition> r2 = this.viewTransitions.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        ViewTransition r0 = r2.next();
        if (r0.getId() != r3) goto L4;
        r0.mKeyFrames.addAllFrames(r4);
        return true;
    L9:
        return false;
    }

    public void enableViewTransition(int r3, boolean r4) {
        Iterator<ViewTransition> r2 = this.viewTransitions.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        ViewTransition r0 = r2.next();
        if (r0.getId() != r3) goto L4;
        r0.setEnabled(r4);
        return;
    }

    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    public boolean isViewTransitionEnabled(int r3) {
        Iterator<ViewTransition> r2 = this.viewTransitions.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        ViewTransition r0 = r2.next();
        if (r0.getId() != r3) goto L4;
        return r0.isEnabled();
    L9:
        return false;
    }

    public void remove(int r5) {
        Iterator<ViewTransition> r0 = this.viewTransitions.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ViewTransition r1 = r0.next();
        if (r1.getId() != r5) goto L4;
    L9:
        if (r1 == null) goto L15;
        this.mRelatedViews = null;
        this.viewTransitions.remove(r1);
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public void removeAnimation(ViewTransition.Animate r1) {
        this.removeList.add(r1);
    }

    public void touchEvent(MotionEvent r15) {
        int r0 = this.mMotionLayout.getCurrentState();
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.mRelatedViews != null) goto L16;
        this.mRelatedViews = new HashSet();
        Iterator<ViewTransition> r1 = this.viewTransitions.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        ViewTransition r2 = r1.next();
        int r3 = this.mMotionLayout.getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L9;
        View r5 = this.mMotionLayout.getChildAt(r4);
        if (r2.matchesView(r5) == false) goto L15;
        r5.getId();
        this.mRelatedViews.add(r5);
    L15:
        r4 = r4 + 1;
    L16:
        float r7 = r15.getX();
        float r8 = r15.getY();
        Rect r9 = new Rect();
        int r16 = r15.getAction();
        ArrayList<ViewTransition.Animate> r6 = this.animations;
        if (r6 != null) goto L19;
    L24:
        if (r16 != 0) goto L26;
    L28:
        ConstraintSet r10 = this.mMotionLayout.getConstraintSet(r0);
        Iterator<ViewTransition> r11 = this.viewTransitions.iterator();
    L30:
        if (r11.hasNext() == false) goto L59;
        ViewTransition r12 = r11.next();
        if (r12.supports(r16) == false) goto L30;
        Iterator<View> r13 = this.mRelatedViews.iterator();
    L35:
        if (r13.hasNext() == false) goto L30;
        View r14 = r13.next();
        if (r12.matchesView(r14) == false) goto L35;
        r14.getHitRect(r9);
        if (r9.contains((int) r7, (int) r8) == false) goto L35;
        r12.applyTransition(this, this.mMotionLayout, r0, r10, new View[]{r14});
        goto L35
    L59:
        return;
    L26:
        if (r16 == 1) goto L28;
        return;
    L19:
        if (r6.isEmpty() == true) goto L24;
        Iterator<ViewTransition.Animate> r17 = this.animations.iterator();
    L22:
        if (r17.hasNext() == false) goto L24;
        r17.next().reactTo(r16, r7, r8);
        goto L22
    }

    public void viewTransition(int r9, View... r10) {
        ArrayList r0 = new ArrayList();
        Iterator<ViewTransition> r1 = this.viewTransitions.iterator();
        ViewTransition r2 = null;
    L4:
        if (r1.hasNext() == false) goto L17;
        ViewTransition r3 = r1.next();
        if (r3.getId() != r9) goto L4;
        int r4 = r10.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L14;
        View r6 = r10[r5];
        if (r3.checkTags(r6) == false) goto L12;
        r0.add(r6);
    L12:
        r5 = r5 + 1;
        goto L8
    L14:
        if (r0.isEmpty() == true) goto L16;
        viewTransition(r3, (View[]) r0.toArray(new View[0]));
        r0.clear();
    L16:
        r2 = r3;
        goto L4
    L17:
        if (r2 != null) goto L28;
        Log.e(this.TAG, " Could not find ViewTransition");
        return;
    }
}
