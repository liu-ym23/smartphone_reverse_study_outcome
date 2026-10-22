package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onCancel;
    final /* synthetic */ Function1 $onEnd;
    final /* synthetic */ Function1 $onRepeat;
    final /* synthetic */ Function1 $onStart;

    public AnimatorKt$addListener$listener$1(Function1 r1, Function1 r2, Function1 r3, Function1 r4) {
        this.$onRepeat = r1;
        this.$onEnd = r2;
        this.$onCancel = r3;
        this.$onStart = r4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onCancel.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onEnd.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onRepeat.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator r2) {
        Intrinsics.g(r2, "animator");
        this.$onStart.invoke(r2);
    }
}
