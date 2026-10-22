package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001aV\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a/\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a/\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AnimatorKt {

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass1 extends q implements l<Animator, f0> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2 extends q implements l<Animator, f0> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3 extends q implements l<Animator, f0> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass4 extends q implements l<Animator, f0> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C06061 extends q implements l<Animator, f0> {
        public static final C06061 INSTANCE = null;

        static {
            INSTANCE = new C06061();
        }

        C06061() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C06072 extends q implements l<Animator, f0> {
        public static final C06072 INSTANCE = null;

        static {
            INSTANCE = new C06072();
        }

        C06072() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Animator r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator r1) {
            o.f(r1, "it");
        }
    }

    public static final Animator.AnimatorListener addListener(Animator r1, l<? super Animator, f0> r2, l<? super Animator, f0> r3, l<? super Animator, f0> r4, l<? super Animator, f0> r5) {
        o.f(r1, "<this>");
        o.f(r2, "onEnd");
        o.f(r3, "onStart");
        o.f(r4, "onCancel");
        o.f(r5, "onRepeat");
        AnimatorKt$addListener$listener$1 r0 = new AnimatorKt$addListener$listener$1(r5, r2, r4, r3);
        r1.addListener(r0);
        return r0;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r0, l r1, l r2, l r3, l r4, int r5, Object r6) {
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
        o.f(r0, "<this>");
        o.f(r1, "onEnd");
        o.f(r2, "onStart");
        o.f(r3, "onCancel");
        o.f(r4, "onRepeat");
        AnimatorKt$addListener$listener$1 r7 = new AnimatorKt$addListener$listener$1(r4, r1, r3, r2);
        r0.addListener(r7);
        return r7;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator r1, final l<? super Animator, f0> r2, final l<? super Animator, f0> r3) {
        o.f(r1, "<this>");
        o.f(r2, "onResume");
        o.f(r3, "onPause");
        Animator.AnimatorPauseListener r0 = new AnimatorKt$addPauseListener$listener$1(r3, r2);
        Api19Impl.addPauseListener(r1, r0);
        return r0;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r0, l r1, l r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = C06061.INSTANCE;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = C06072.INSTANCE;
    L9:
        return addPauseListener(r0, r1, r2);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator r1, final l<? super Animator, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r1, final l<? super Animator, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator r2, l<? super Animator, f0> r3) {
        o.f(r2, "<this>");
        o.f(r3, "action");
        return addPauseListener$default(r2, null, r3, 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r1, final l<? super Animator, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator r2, l<? super Animator, f0> r3) {
        o.f(r2, "<this>");
        o.f(r3, "action");
        return addPauseListener$default(r2, r3, null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator r1, final l<? super Animator, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
