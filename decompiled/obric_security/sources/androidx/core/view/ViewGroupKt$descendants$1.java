package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {119, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ViewGroupKt$descendants$1(ViewGroup r1, Continuation<? super ViewGroupKt$descendants$1> r2) {
        this.$this_descendants = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ViewGroupKt$descendants$1 r0 = new ViewGroupKt$descendants$1(this.$this_descendants, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super View> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super View> r1, Continuation<? super Unit> r2) {
        return ((ViewGroupKt$descendants$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:22:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0092 -> B:24:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r4 = this.I$0;
        ViewGroup r5 = (ViewGroup) this.L$1;
        SequenceScope r6 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        SequenceScope r11 = r6;
        ViewGroup r8 = r5;
        int r7 = r2;
        ViewGroup r3 = r8;
    L24:
        int r9 = r7;
        int r12 = r4 + 1;
        int r13 = r9;
    L11:
        if (r12 >= r13) goto L26;
        View r14 = r3.getChildAt(r12);
        Intrinsics.checkNotNullExpressionValue(r14, "getChildAt(index)");
        this.L$0 = r11;
        this.L$1 = r3;
        this.L$2 = r14;
        this.I$0 = r12;
        this.I$1 = r13;
        this.label = 1;
        if (r11.yield(r14, this) != r0) goto L15;
        return r0;
    L15:
        ViewGroup r15 = r3;
        r2 = r13;
        r4 = r12;
        View r16 = r14;
    L17:
        if ((r16 instanceof ViewGroup) == false) goto L23;
        Sequence<View> r17 = ViewGroupKt.getDescendants((ViewGroup) r16);
        this.L$0 = r11;
        this.L$1 = r15;
        this.L$2 = null;
        this.I$0 = r4;
        this.I$1 = r2;
        this.label = 2;
        if (r11.yieldAll(r17, this) != r0) goto L21;
        return r0;
    L21:
        r5 = r15;
        r6 = r11;
        goto L22
    L23:
        r7 = r2;
        r3 = r15;
        goto L24
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$1;
        r4 = this.I$0;
        r16 = (View) this.L$2;
        r15 = (ViewGroup) this.L$1;
        SequenceScope r18 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        r11 = r18;
        goto L17
    L10:
        ResultKt.throwOnFailure(r10);
        r11 = (SequenceScope) this.L$0;
        r3 = this.$this_descendants;
        r13 = r3.getChildCount();
        r12 = 0;
        goto L11
    }
}
