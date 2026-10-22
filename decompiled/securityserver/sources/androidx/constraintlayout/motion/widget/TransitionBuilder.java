package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
    }

    public static MotionScene.Transition buildTransition(MotionScene r1, int r2, int r3, ConstraintSet r4, int r5, ConstraintSet r6) {
        MotionScene.Transition r0 = new MotionScene.Transition(r2, r1, r3, r5);
        updateConstraintSetInMotionScene(r1, r0, r4, r6);
        return r0;
    }

    private static void updateConstraintSetInMotionScene(MotionScene r1, MotionScene.Transition r2, ConstraintSet r3, ConstraintSet r4) {
        int r0 = r2.getStartConstraintSetId();
        int r5 = r2.getEndConstraintSetId();
        r1.setConstraintSet(r0, r3);
        r1.setConstraintSet(r5, r4);
    }

    public static void validate(MotionLayout r1) {
        MotionScene r0 = r1.mScene;
        if (r0 == null) goto L16;
        if (r0.validateLayout(r1) == false) goto L14;
        if (r0.mCurrentTransition == null) goto L12;
        if (r0.getDefinedTransitions().isEmpty() == true) goto L12;
        return;
    L12:
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
    L14:
        throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    L16:
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}
