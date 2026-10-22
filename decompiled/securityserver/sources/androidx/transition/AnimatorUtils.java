package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r1);

        void onAnimationResume(Animator r1);
    }

    private AnimatorUtils() {
    }

    public static void addPauseListener(@NonNull Animator r0, @NonNull AnimatorListenerAdapter r1) {
        r0.addPauseListener(r1);
    }

    public static void pause(@NonNull Animator r0) {
        r0.pause();
    }

    public static void resume(@NonNull Animator r0) {
        r0.resume();
    }
}
