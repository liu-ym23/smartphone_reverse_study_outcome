package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r1);

        void onAnimationResume(Animator r1);
    }

    private AnimatorUtils() {
    }

    static void addPauseListener(@NonNull Animator r2, @NonNull AnimatorListenerAdapter r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r2.addPauseListener(r3);
        return;
    }

    static void pause(@NonNull Animator r5) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r5.pause();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r5.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = r0.get(r1);
        if ((r3 instanceof AnimatorPauseListenerCompat) == false) goto L12;
        ((AnimatorPauseListenerCompat) r3).onAnimationPause(r5);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    static void resume(@NonNull Animator r5) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r5.resume();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r5.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = r0.get(r1);
        if ((r3 instanceof AnimatorPauseListenerCompat) == false) goto L12;
        ((AnimatorPauseListenerCompat) r3).onAnimationResume(r5);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }
}
