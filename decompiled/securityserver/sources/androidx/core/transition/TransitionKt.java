package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.constant.AgentConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TransitionKt {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition r7, @NotNull Function1<? super Transition, Unit> r8, @NotNull Function1<? super Transition, Unit> r9, @NotNull Function1<? super Transition, Unit> r10, @NotNull Function1<? super Transition, Unit> r11, @NotNull Function1<? super Transition, Unit> r12) {
        Intrinsics.g(r7, "$this$addListener");
        Intrinsics.g(r8, "onEnd");
        Intrinsics.g(r9, AgentConstants.ON_START);
        Intrinsics.g(r10, "onCancel");
        Intrinsics.g(r11, "onResume");
        Intrinsics.g(r12, "onPause");
        TransitionKt$addListener$listener$1 r0 = new TransitionKt$addListener$listener$1(r8, r11, r12, r10, r9);
        r7.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r2, Function1 r3, Function1 r4, Function1 r5, Function1 r6, Function1 r7, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = AnonymousClass1.INSTANCE;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = AnonymousClass2.INSTANCE;
    L8:
        Function1 r10 = r4;
        if ((r8 & 4) == 0) goto L11;
        r5 = AnonymousClass3.INSTANCE;
    L11:
        Function1 r0 = r5;
        if ((r8 & 8) == 0) goto L15;
        r6 = AnonymousClass4.INSTANCE;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = AnonymousClass5.INSTANCE;
    L17:
        Intrinsics.g(r2, "$this$addListener");
        Intrinsics.g(r3, "onEnd");
        Intrinsics.g(r10, AgentConstants.ON_START);
        Intrinsics.g(r0, "onCancel");
        Intrinsics.g(r6, "onResume");
        Intrinsics.g(r7, "onPause");
        TransitionKt$addListener$listener$1 r1 = new TransitionKt$addListener$listener$1(r3, r6, r7, r0, r10);
        r2.addListener(r1);
        return r1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition r1, @NotNull final Function1<? super Transition, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnCancel");
        Intrinsics.g(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnCancel$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition r1, @NotNull final Function1<? super Transition, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnEnd");
        Intrinsics.g(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnEnd$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition r1, @NotNull final Function1<? super Transition, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnPause");
        Intrinsics.g(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnPause$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition r1, @NotNull final Function1<? super Transition, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnResume");
        Intrinsics.g(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnResume$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition r1, @NotNull final Function1<? super Transition, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnStart");
        Intrinsics.g(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnStart$$inlined$addListener$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
