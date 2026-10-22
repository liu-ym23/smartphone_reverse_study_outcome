package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÉ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TransitionKt {
    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r2, AnonymousClass1 r3, AnonymousClass2 r4, AnonymousClass3 r5, AnonymousClass4 r6, AnonymousClass5 r7, int r8, Object r9) {
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
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "onEnd");
        Intrinsics.checkNotNullParameter(r10, "onStart");
        Intrinsics.checkNotNullParameter(r0, "onCancel");
        Intrinsics.checkNotNullParameter(r6, "onResume");
        Intrinsics.checkNotNullParameter(r7, "onPause");
        TransitionKt$addListener$listener$1 r1 = new TransitionKt$addListener$listener$1(r3, r6, r7, r0, r10);
        r2.addListener(r1);
        return r1;
    }

    public static final Transition.TransitionListener addListener(Transition r7, Function1<? super Transition, Unit> r8, Function1<? super Transition, Unit> r9, Function1<? super Transition, Unit> r10, Function1<? super Transition, Unit> r11, Function1<? super Transition, Unit> r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "onEnd");
        Intrinsics.checkNotNullParameter(r9, "onStart");
        Intrinsics.checkNotNullParameter(r10, "onCancel");
        Intrinsics.checkNotNullParameter(r11, "onResume");
        Intrinsics.checkNotNullParameter(r12, "onPause");
        TransitionKt$addListener$listener$1 r0 = new TransitionKt$addListener$listener$1(r8, r11, r12, r10, r9);
        r7.addListener(r0);
        return r0;
    }

    public static final Transition.TransitionListener doOnEnd(Transition r1, final Function1<? super Transition, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Transition.TransitionListener doOnStart(Transition r1, final Function1<? super Transition, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Transition.TransitionListener doOnCancel(Transition r1, final Function1<? super Transition, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Transition.TransitionListener doOnResume(Transition r1, final Function1<? super Transition, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Transition.TransitionListener doOnPause(Transition r1, final Function1<? super Transition, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
