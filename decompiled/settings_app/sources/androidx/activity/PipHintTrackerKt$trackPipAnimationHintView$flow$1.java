package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public static /* synthetic */ void $r8$lambda$3HoOD4FOOs4BK4W3sogOQmeeOUI(ProducerScope r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        invokeSuspend$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$tX1ZAZ_6mxGyPSL59qbNSbD0n4g(ProducerScope r0, View r1) {
        invokeSuspend$lambda$1(r0, r1);
    }

    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r1, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r2) {
        this.$view = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Rect> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Rect> r1, Continuation<? super Unit> r2) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final ProducerScope r9 = (ProducerScope) this.L$0;
        final View.OnLayoutChangeListener r2 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0(r9);
        final View r3 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r4 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1(r9, r3);
        final View r5 = this.$view;
        final ?? r6 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r9, r5, r4, r2);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        r9.mo3012trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r4);
        this.$view.addOnLayoutChangeListener(r2);
    L11:
        this.$view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) r6);
        final View r7 = this.$view;
        this.label = 1;
        if (ProduceKt.awaitClose(r9, new AnonymousClass1(r7, r4, r2, r6), this) != r0) goto L15;
        return r0;
    }

    private static final void invokeSuspend$lambda$0(ProducerScope r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r4 != r8) goto L6;
        if (r3 != r7) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        r0.mo3012trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }

    private static final void invokeSuspend$lambda$1(ProducerScope r0, View r1) {
        r0.mo3012trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }
}
