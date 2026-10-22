package androidx.core.transition;

import android.annotation.SuppressLint;
import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÉ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class TransitionKt {

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass1 extends q implements l<Transition, f0> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Transition r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2 extends q implements l<Transition, f0> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Transition r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3 extends q implements l<Transition, f0> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Transition r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass4 extends q implements l<Transition, f0> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Transition r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass5 extends q implements l<Transition, f0> {
        public static final AnonymousClass5 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Transition r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition r1) {
            o.f(r1, "it");
        }
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition r7, l<? super Transition, f0> r8, l<? super Transition, f0> r9, l<? super Transition, f0> r10, l<? super Transition, f0> r11, l<? super Transition, f0> r12) {
        o.f(r7, "<this>");
        o.f(r8, "onEnd");
        o.f(r9, "onStart");
        o.f(r10, "onCancel");
        o.f(r11, "onResume");
        o.f(r12, "onPause");
        TransitionKt$addListener$listener$1 r0 = new TransitionKt$addListener$listener$1(r8, r11, r12, r10, r9);
        r7.addListener(r0);
        return r0;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r2, l r3, l r4, l r5, l r6, l r7, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = AnonymousClass1.INSTANCE;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = AnonymousClass2.INSTANCE;
    L8:
        l r10 = r4;
        if ((r8 & 4) == 0) goto L11;
        r5 = AnonymousClass3.INSTANCE;
    L11:
        l r0 = r5;
        if ((r8 & 8) == 0) goto L15;
        r6 = AnonymousClass4.INSTANCE;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = AnonymousClass5.INSTANCE;
    L17:
        o.f(r2, "<this>");
        o.f(r3, "onEnd");
        o.f(r10, "onStart");
        o.f(r0, "onCancel");
        o.f(r6, "onResume");
        o.f(r7, "onPause");
        TransitionKt$addListener$listener$1 r1 = new TransitionKt$addListener$listener$1(r3, r6, r7, r0, r10);
        r2.addListener(r1);
        return r1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition r1, final l<? super Transition, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition r1, final l<? super Transition, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition r1, final l<? super Transition, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition r1, final l<? super Transition, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition r1, final l<? super Transition, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Transition.TransitionListener r0 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
