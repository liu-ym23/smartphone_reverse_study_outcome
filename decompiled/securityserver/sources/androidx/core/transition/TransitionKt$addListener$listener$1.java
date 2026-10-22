package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onCancel;
    final /* synthetic */ Function1 $onEnd;
    final /* synthetic */ Function1 $onPause;
    final /* synthetic */ Function1 $onResume;
    final /* synthetic */ Function1 $onStart;

    public TransitionKt$addListener$listener$1(Function1 r1, Function1 r2, Function1 r3, Function1 r4, Function1 r5) {
        this.$onEnd = r1;
        this.$onResume = r2;
        this.$onPause = r3;
        this.$onCancel = r4;
        this.$onStart = r5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@NotNull Transition r2) {
        Intrinsics.g(r2, "transition");
        this.$onCancel.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@NotNull Transition r2) {
        Intrinsics.g(r2, "transition");
        this.$onEnd.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@NotNull Transition r2) {
        Intrinsics.g(r2, "transition");
        this.$onPause.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@NotNull Transition r2) {
        Intrinsics.g(r2, "transition");
        this.$onResume.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@NotNull Transition r2) {
        Intrinsics.g(r2, "transition");
        this.$onStart.invoke(r2);
    }
}
