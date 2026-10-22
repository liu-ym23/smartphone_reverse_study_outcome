package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.constant.AgentConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatorKt {
    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator r1, @NotNull Function1<? super Animator, Unit> r2, @NotNull Function1<? super Animator, Unit> r3, @NotNull Function1<? super Animator, Unit> r4, @NotNull Function1<? super Animator, Unit> r5) {
        Intrinsics.g(r1, "$this$addListener");
        Intrinsics.g(r2, "onEnd");
        Intrinsics.g(r3, AgentConstants.ON_START);
        Intrinsics.g(r4, "onCancel");
        Intrinsics.g(r5, "onRepeat");
        AnimatorKt$addListener$listener$1 r0 = new AnimatorKt$addListener$listener$1(r5, r2, r4, r3);
        r1.addListener(r0);
        return r0;
    }

    @NotNull
    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r0, Function1 r1, Function1 r2, Function1 r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = AnonymousClass2.INSTANCE;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = AnonymousClass3.INSTANCE;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = AnonymousClass4.INSTANCE;
    L14:
        Intrinsics.g(r0, "$this$addListener");
        Intrinsics.g(r1, "onEnd");
        Intrinsics.g(r2, AgentConstants.ON_START);
        Intrinsics.g(r3, "onCancel");
        Intrinsics.g(r4, "onRepeat");
        AnimatorKt$addListener$listener$1 r7 = new AnimatorKt$addListener$listener$1(r4, r1, r3, r2);
        r0.addListener(r7);
        return r7;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator r1, @NotNull Function1<? super Animator, Unit> r2, @NotNull Function1<? super Animator, Unit> r3) {
        Intrinsics.g(r1, "$this$addPauseListener");
        Intrinsics.g(r2, "onResume");
        Intrinsics.g(r3, "onPause");
        AnimatorKt$addPauseListener$listener$1 r0 = new AnimatorKt$addPauseListener$listener$1(r3, r2);
        r1.addPauseListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r0, Function1 r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = C00171.INSTANCE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = C00182.INSTANCE;
    L8:
        Intrinsics.g(r0, "$this$addPauseListener");
        Intrinsics.g(r1, "onResume");
        Intrinsics.g(r2, "onPause");
        AnimatorKt$addPauseListener$listener$1 r5 = new AnimatorKt$addPauseListener$listener$1(r2, r1);
        r0.addPauseListener(r5);
        return r5;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnCancel");
        Intrinsics.g(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnCancel$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnEnd");
        Intrinsics.g(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnEnd$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnPause");
        Intrinsics.g(r2, "action");
        Animator.AnimatorPauseListener r0 = new AnimatorKt$doOnPause$$inlined$addPauseListener$1(r2);
        r1.addPauseListener(r0);
        return r0;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnRepeat");
        Intrinsics.g(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnRepeat$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnResume");
        Intrinsics.g(r2, "action");
        Animator.AnimatorPauseListener r0 = new AnimatorKt$doOnResume$$inlined$addPauseListener$1(r2);
        r1.addPauseListener(r0);
        return r0;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator r1, @NotNull final Function1<? super Animator, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnStart");
        Intrinsics.g(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnStart$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
