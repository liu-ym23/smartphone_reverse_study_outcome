package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ Function1 $onPause;
    final /* synthetic */ Function1 $onResume;

    public AnimatorKt$addPauseListener$listener$1(Function1 r1, Function1 r2) {
        this.$onPause = r1;
        this.$onResume = r2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onPause.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onResume.invoke(r2);
    }
}
