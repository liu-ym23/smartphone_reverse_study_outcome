package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout r1);

    void onPostDraw(Canvas r1);

    void onPreDraw(Canvas r1);

    void onPreSetup(MotionLayout r1, HashMap<View, MotionController> r2);
}
