package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: compiled from: Channels.common.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0087\b¢\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__Channels_commonKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1, reason: invalid class name */
    /* JADX INFO: compiled from: Channels.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {106}, m = "consumeEach", n = {"action", "$this$consume$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__Channels_commonKt.consumeEach(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3, reason: invalid class name */
    /* JADX INFO: compiled from: Channels.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {130}, m = "consumeEach", n = {"action", "channel$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass3<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__Channels_commonKt.consumeEach(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Channels.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {149}, m = "toList", n = {"$this$toList_u24lambda_u243", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
    static final class C03731<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C03731(Continuation<? super C03731> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toList(null, this);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> r2, Function1<? super ReceiveChannel<? extends E>, ? extends R> r3) {
        ReceiveChannel<E> r4 = r2.openSubscription();
        R r5 = r3.invoke(r4);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r4, null, 1, null);
        InlineMarker.finallyEnd(1);
        return r5;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r4, null, 1, null);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel r1, Continuation r2) {
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return r1.receiveOrNull(r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel r1) {
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return r1.getOnReceiveOrNull();
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> r2, Function1<? super ReceiveChannel<? extends E>, ? extends R> r3) {
        R r4 = r3.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r2, null);
        InlineMarker.finallyEnd(1);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r2, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005d). Please report as a decompilation issue!!! */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> r5, Function1<? super E, Unit> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r9 = (ChannelIterator) r0.L$2;
        ReceiveChannel<? extends E> r10 = (ReceiveChannel) r0.L$1;
        Function1<? super E, Unit> r3 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r8).booleanValue() == false) goto L28;
        r3.invoke((Object) r9.next());     // Catch: Throwable -> L14
        Function1<? super E, Unit> r11 = r3;
    L21:
        r0.L$0 = r11;     // Catch: Throwable -> L14
        r0.L$1 = r10;     // Catch: Throwable -> L14
        r0.L$2 = r9;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r4 = r9.hasNext(r0);     // Catch: Throwable -> L14
        if (r4 != r1) goto L24;
        return r1;
    L24:
        r3 = r11;
        r8 = r4;
        goto L26
    L28:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r10, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r10, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        r10 = r5;
        r9 = r5.iterator();     // Catch: Throwable -> L31
        r11 = r6;
    L31:
        th = move-exception;
        r10 = r5;
        th = th;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:25:0x0068). Please report as a decompilation issue!!! */
    public static final <E> Object toList(ReceiveChannel<? extends E> r7, Continuation<? super List<? extends E>> r8) {
        if ((r8 instanceof C03731) == false) goto L7;
        C03731 r0 = (C03731) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r10 = (ChannelIterator) r0.L$3;
        ReceiveChannel<? extends E> r3 = (ReceiveChannel) r0.L$2;
        List r4 = (List) r0.L$1;
        List r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L14
        ?? r6 = r4;
        List r11 = r5;
    L26:
        if (((Boolean) r9).booleanValue() == false) goto L28;
        r6.add(r10.next());     // Catch: Throwable -> L14
        ReceiveChannel<? extends E> r12 = r3;
        ?? r13 = r6;
        List r14 = r11;
    L39:
        r0.L$0 = r14;     // Catch: Throwable -> L31
        r0.L$1 = r13;     // Catch: Throwable -> L31
        r0.L$2 = r12;     // Catch: Throwable -> L31
        r0.L$3 = r10;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        Object r15 = r10.hasNext(r0);     // Catch: Throwable -> L31
        if (r15 != r1) goto L24;
        return r1;
    L24:
        r3 = r12;
        r9 = r15;
        r6 = r13;
        r11 = r14;
    L31:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        ChannelsKt.cancelConsumed(r12, th);
        throw th;
    L28:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r3, null);
        return CollectionsKt.build(r11);
    L14:
        th = th;
        r12 = r3;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r9);
        List r17 = CollectionsKt.createListBuilder();
        r14 = r17;
        r12 = r7;
        r10 = r7.iterator();     // Catch: Throwable -> L33
        r13 = r17;
    L33:
        th = move-exception;
        r12 = r7;
        th = th;
    L7:
        r0 = new C03731(r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0063 -> B:14:0x0039). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> r6, Function1<? super E, Unit> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        ChannelIterator r10 = (ChannelIterator) r0.L$2;
        ReceiveChannel<E> r11 = (ReceiveChannel) r0.L$1;
        Function1<? super E, Unit> r3 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
        AnonymousClass3 r5 = r0;
        ReceiveChannel<E> r4 = r11;
        r7 = r3;
    L14:
        Object r12 = r1;
        AnonymousClass3 r13 = r5;
    L32:
        Throwable th = th;
        r11 = r4;
    L38:
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r11, null, 1, null);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        if (((Boolean) r9).booleanValue() == false) goto L29;
        r7.invoke((Object) r10.next());     // Catch: Throwable -> L32
        ReceiveChannel<E> r14 = r4;
        r0 = r13;
        r1 = r12;
    L42:
        r0.L$0 = r7;     // Catch: Throwable -> L34
        r0.L$1 = r14;     // Catch: Throwable -> L34
        r0.L$2 = r10;     // Catch: Throwable -> L34
        r0.label = 1;     // Catch: Throwable -> L34
        Object r15 = r10.hasNext(r0);     // Catch: Throwable -> L34
        if (r15 != r1) goto L25;
        return r1;
    L25:
        r5 = r0;
        r4 = r14;
        r9 = r15;
    L34:
        th = th;
        r11 = r14;
        goto L38
    L29:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r4, null, 1, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L15:
        th = th;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r9);
        ReceiveChannel<E> r17 = r6.openSubscription();
        r14 = r17;
        r10 = r17.iterator();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r11 = r17;
        th = th;
    L7:
        r0 = new AnonymousClass3(r8);
        goto L8
    }

    public static final void cancelConsumed(ReceiveChannel<?> r2, Throwable r3) {
        CancellationException r0 = null;
        if (r3 != null) goto L5;
    L9:
        r2.cancel(r0);
        return;
    L5:
        if ((r3 instanceof CancellationException) == false) goto L7;
        r0 = (CancellationException) r3;
    L7:
        if (r0 != null) goto L9;
        r0 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", r3);
        goto L9
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> r3, Function1<? super E, Unit> r4, Continuation<? super Unit> r5) {
        ReceiveChannel<? extends E> r0 = r3;     // Catch: Throwable -> L10
        ChannelIterator<? extends E> r1 = r3.iterator();     // Catch: Throwable -> L10
    L4:
        InlineMarker.mark(3);     // Catch: Throwable -> L10
        InlineMarker.mark(0);     // Catch: Throwable -> L10
        Object r2 = r1.hasNext(null);     // Catch: Throwable -> L10
        InlineMarker.mark(1);     // Catch: Throwable -> L10
        if (((Boolean) r2).booleanValue() == false) goto L7;
        r4.invoke(r1.next());     // Catch: Throwable -> L10
        goto L4
    L7:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r3, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r3, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> r3, Function1<? super E, Unit> r4, Continuation<? super Unit> r5) {
        ReceiveChannel<E> r6 = r3.openSubscription();
        ReceiveChannel<E> r1 = r6;     // Catch: Throwable -> L10
        ChannelIterator<E> r2 = r6.iterator();     // Catch: Throwable -> L10
    L4:
        InlineMarker.mark(3);     // Catch: Throwable -> L10
        InlineMarker.mark(0);     // Catch: Throwable -> L10
        Object r7 = r2.hasNext(null);     // Catch: Throwable -> L10
        InlineMarker.mark(1);     // Catch: Throwable -> L10
        if (((Boolean) r7).booleanValue() == false) goto L7;
        r4.invoke(r2.next());     // Catch: Throwable -> L10
        goto L4
    L7:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r6, null, 1, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default(r6, null, 1, null);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
