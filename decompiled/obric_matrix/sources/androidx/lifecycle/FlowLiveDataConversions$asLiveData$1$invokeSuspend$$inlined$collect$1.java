package androidx.lifecycle;

import h.a.e3.f;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.d;
import kotlin.w;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lh/a/e3/f;", "value", "Lkotlin/f0;", "emit", "(Ljava/lang/Object;Lkotlin/k0/d;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
public final class FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1<T> implements f<T> {
    final /* synthetic */ LiveDataScope $this_liveData$inlined;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @kotlin.k0.j.a.f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1", f = "FlowLiveData.kt", l = {136}, m = "emit")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {"T", "value", "LLkotlin/coroutines/Continuation;;", "L;", "continuation", "", "emit"}, k = 3, mv = {1, 1, 15})
    public final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 r1, kotlin.k0.d r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1(LiveDataScope r1) {
        this.$this_liveData$inlined = r1;
    }

    @Override // h.a.e3.f
    public Object emit(Object r5, kotlin.k0.d r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Object r4 = r0.L$3;
        kotlin.k0.d r8 = (kotlin.k0.d) r0.L$2;
        Object r9 = r0.L$1;
        FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 r10 = (FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1) r0.L$0;
        w.b(r7);
    L18:
        return f0.f18324a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        w.b(r7);
        LiveDataScope r11 = this.$this_liveData$inlined;
        r0.L$0 = this;
        r0.L$1 = r5;
        r0.L$2 = r0;
        r0.L$3 = r5;
        r0.label = 1;
        if (r11.emit(r5, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
