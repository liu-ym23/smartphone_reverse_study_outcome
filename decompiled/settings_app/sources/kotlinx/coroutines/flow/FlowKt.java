package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class FlowKt {
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    public static final <T> Flow<T> asFlow(Iterable<? extends T> r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> Flow<T> asFlow(Iterator<? extends T> r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> Flow<T> asFlow(Function0<? extends T> r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> Flow<T> asFlow(Function1<? super Continuation<? super T>, ? extends Object> r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final Flow<Integer> asFlow(IntRange r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final Flow<Long> asFlow(LongRange r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> Flow<T> asFlow(Sequence<? extends T> r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(BroadcastChannel<T> r0) {
        return FlowKt__ChannelsKt.asFlow(r0);
    }

    public static final Flow<Integer> asFlow(int[] r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final Flow<Long> asFlow(long[] r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> Flow<T> asFlow(T[] r0) {
        return FlowKt__BuildersKt.asFlow(r0);
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> r0) {
        return FlowKt__ShareKt.asSharedFlow(r0);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> r0) {
        return FlowKt__ShareKt.asStateFlow(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Flow buffer(Flow r0, int r1) {
        return FlowKt__ContextKt.buffer(r0, r1);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> r0, int r1, BufferOverflow r2) {
        return FlowKt__ContextKt.buffer(r0, r1, r2);
    }

    public static /* synthetic */ Flow buffer$default(Flow r0, int r1, int r2, Object r3) {
        return FlowKt__ContextKt.buffer$default(r0, r1, r2, r3);
    }

    public static /* synthetic */ Flow buffer$default(Flow r0, int r1, BufferOverflow r2, int r3, Object r4) {
        return FlowKt__ContextKt.buffer$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    public static final <T> Flow<T> cache(Flow<? extends T> r0) {
        return FlowKt__MigrationKt.cache(r0);
    }

    public static final <T> Flow<T> callbackFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r0) {
        return FlowKt__BuildersKt.callbackFlow(r0);
    }

    public static final <T> Flow<T> cancellable(Flow<? extends T> r0) {
        return FlowKt__ContextKt.cancellable(r0);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m3041catch(Flow<? extends T> r0, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__ErrorsKt.m3052catch(r0, r1);
    }

    public static final <T> Object catchImpl(Flow<? extends T> r0, FlowCollector<? super T> r1, Continuation<? super Throwable> r2) {
        return FlowKt__ErrorsKt.catchImpl(r0, r1, r2);
    }

    public static final <T> Flow<T> channelFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r0) {
        return FlowKt__BuildersKt.channelFlow(r0);
    }

    public static final Object collect(Flow<?> r0, Continuation<? super Unit> r1) {
        return FlowKt__CollectKt.collect(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super Unit> r2) {
        return FlowKt__CollectKt.collect(r0, r1, r2);
    }

    public static final <T> Object collectIndexed(Flow<? extends T> r0, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super Unit> r2) {
        return FlowKt__CollectKt.collectIndexed(r0, r1, r2);
    }

    public static final <T> Object collectLatest(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super Unit> r2) {
        return FlowKt__CollectKt.collectLatest(r0, r1, r2);
    }

    public static final <T> Object collectWhile(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super Unit> r2) {
        return FlowKt__LimitKt.collectWhile(r0, r1, r2);
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> r0, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> r1) {
        return FlowKt__ZipKt.combine(r0, r1);
    }

    public static final <T1, T2, R> Flow<R> combine(Flow<? extends T1> r0, Flow<? extends T2> r1, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__ZipKt.combine(r0, r1, r2);
    }

    public static final <T1, T2, T3, R> Flow<R> combine(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> r3) {
        return FlowKt__ZipKt.combine(r0, r1, r2, r3);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combine(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> r4) {
        return FlowKt__ZipKt.combine(r0, r1, r2, r3, r4);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Flow<? extends T5> r4, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> r5) {
        return FlowKt__ZipKt.combine(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Flow<? extends T>[] r0, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> r1) {
        return FlowKt__ZipKt.combine(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> Flow<R> combineLatest(Flow<? extends T1> r0, Flow<? extends T2> r1, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__MigrationKt.combineLatest(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> r3) {
        return FlowKt__MigrationKt.combineLatest(r0, r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> r4) {
        return FlowKt__MigrationKt.combineLatest(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Flow<? extends T5> r4, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> r5) {
        return FlowKt__MigrationKt.combineLatest(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> r0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__ZipKt.combineTransform(r0, r1);
    }

    public static final <T1, T2, R> Flow<R> combineTransform(Flow<? extends T1> r0, Flow<? extends T2> r1, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return FlowKt__ZipKt.combineTransform(r0, r1, r2);
    }

    public static final <T1, T2, T3, R> Flow<R> combineTransform(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return FlowKt__ZipKt.combineTransform(r0, r1, r2, r3);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> r4) {
        return FlowKt__ZipKt.combineTransform(r0, r1, r2, r3, r4);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(Flow<? extends T1> r0, Flow<? extends T2> r1, Flow<? extends T3> r2, Flow<? extends T4> r3, Flow<? extends T5> r4, Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> r5) {
        return FlowKt__ZipKt.combineTransform(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Flow<? extends T>[] r0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__ZipKt.combineTransform(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> compose(Flow<? extends T> r0, Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> r1) {
        return FlowKt__MigrationKt.compose(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> concatMap(Flow<? extends T> r0, Function1<? super T, ? extends Flow<? extends R>> r1) {
        return FlowKt__MigrationKt.concatMap(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow<? extends T> r0, T r1) {
        return FlowKt__MigrationKt.concatWith(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow<? extends T> r0, Flow<? extends T> r1) {
        return FlowKt__MigrationKt.concatWith(r0, r1);
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> r0) {
        return FlowKt__ContextKt.conflate(r0);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> r0) {
        return FlowKt__ChannelsKt.consumeAsFlow(r0);
    }

    public static final <T> Object count(Flow<? extends T> r0, Continuation<? super Integer> r1) {
        return FlowKt__CountKt.count(r0, r1);
    }

    public static final <T> Object count(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super Integer> r2) {
        return FlowKt__CountKt.count(r0, r1, r2);
    }

    public static final <T> Flow<T> debounce(Flow<? extends T> r0, long r1) {
        return FlowKt__DelayKt.debounce(r0, r1);
    }

    public static final <T> Flow<T> debounce(Flow<? extends T> r0, Function1<? super T, Long> r1) {
        return FlowKt__DelayKt.debounce(r0, r1);
    }

    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m3042debounceHG0u8IE(Flow<? extends T> r0, long r1) {
        return FlowKt__DelayKt.m3045debounceHG0u8IE(r0, r1);
    }

    public static final <T> Flow<T> debounceDuration(Flow<? extends T> r0, Function1<? super T, Duration> r1) {
        return FlowKt__DelayKt.debounceDuration(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayEach(Flow<? extends T> r0, long r1) {
        return FlowKt__MigrationKt.delayEach(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayFlow(Flow<? extends T> r0, long r1) {
        return FlowKt__MigrationKt.delayFlow(r0, r1);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> r0) {
        return FlowKt__DistinctKt.distinctUntilChanged(r0);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> r0, Function2<? super T, ? super T, Boolean> r1) {
        return FlowKt__DistinctKt.distinctUntilChanged(r0, r1);
    }

    public static final <T, K> Flow<T> distinctUntilChangedBy(Flow<? extends T> r0, Function1<? super T, ? extends K> r1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(r0, r1);
    }

    public static final <T> Flow<T> drop(Flow<? extends T> r0, int r1) {
        return FlowKt__LimitKt.drop(r0, r1);
    }

    public static final <T> Flow<T> dropWhile(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__LimitKt.dropWhile(r0, r1);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> r0, ReceiveChannel<? extends T> r1, Continuation<? super Unit> r2) {
        return FlowKt__ChannelsKt.emitAll(r0, r1, r2);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> r0, Flow<? extends T> r1, Continuation<? super Unit> r2) {
        return FlowKt__CollectKt.emitAll(r0, r1, r2);
    }

    public static final <T> Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(FlowCollector<?> r0) {
        FlowKt__EmittersKt.ensureActive(r0);
    }

    public static final <T> Flow<T> filter(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__TransformKt.filter(r0, r1);
    }

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> r0) {
        return FlowKt__TransformKt.filterIsInstance(r0);
    }

    public static final <R> Flow<R> filterIsInstance(Flow<?> r0, KClass<R> r1) {
        return FlowKt__TransformKt.filterIsInstance(r0, r1);
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__TransformKt.filterNot(r0, r1);
    }

    public static final <T> Flow<T> filterNotNull(Flow<? extends T> r0) {
        return FlowKt__TransformKt.filterNotNull(r0);
    }

    public static final <T> Object first(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.first(r0, r1);
    }

    public static final <T> Object first(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super T> r2) {
        return FlowKt__ReduceKt.first(r0, r1, r2);
    }

    public static final <T> Object firstOrNull(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.firstOrNull(r0, r1);
    }

    public static final <T> Object firstOrNull(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super T> r2) {
        return FlowKt__ReduceKt.firstOrNull(r0, r1, r2);
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope r0, long r1, long r3) {
        return FlowKt__DelayKt.fixedPeriodTicker(r0, r1, r3);
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope r0, long r1, long r3, int r5, Object r6) {
        return FlowKt__DelayKt.fixedPeriodTicker$default(r0, r1, r3, r5, r6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> flatMap(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> r1) {
        return FlowKt__MigrationKt.flatMap(r0, r1);
    }

    public static final <T, R> Flow<R> flatMapConcat(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> r1) {
        return FlowKt__MergeKt.flatMapConcat(r0, r1);
    }

    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> r1) {
        return FlowKt__MergeKt.flatMapLatest(r0, r1);
    }

    public static final <T, R> Flow<R> flatMapMerge(Flow<? extends T> r0, int r1, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> r2) {
        return FlowKt__MergeKt.flatMapMerge(r0, r1, r2);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow r0, int r1, Function2 r2, int r3, Object r4) {
        return FlowKt__MergeKt.flatMapMerge$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> r0) {
        return FlowKt__MigrationKt.flatten(r0);
    }

    public static final <T> Flow<T> flattenConcat(Flow<? extends Flow<? extends T>> r0) {
        return FlowKt__MergeKt.flattenConcat(r0);
    }

    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> r0, int r1) {
        return FlowKt__MergeKt.flattenMerge(r0, r1);
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow r0, int r1, int r2, Object r3) {
        return FlowKt__MergeKt.flattenMerge$default(r0, r1, r2, r3);
    }

    public static final <T> Flow<T> flow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r0) {
        return FlowKt__BuildersKt.flow(r0);
    }

    public static final <T1, T2, R> Flow<R> flowCombine(Flow<? extends T1> r0, Flow<? extends T2> r1, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__ZipKt.flowCombine(r0, r1, r2);
    }

    public static final <T1, T2, R> Flow<R> flowCombineTransform(Flow<? extends T1> r0, Flow<? extends T2> r1, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return FlowKt__ZipKt.flowCombineTransform(r0, r1, r2);
    }

    public static final <T> Flow<T> flowOf(T r0) {
        return FlowKt__BuildersKt.flowOf(r0);
    }

    public static final <T> Flow<T> flowOf(T... r0) {
        return FlowKt__BuildersKt.flowOf(r0);
    }

    public static final <T> Flow<T> flowOn(Flow<? extends T> r0, CoroutineContext r1) {
        return FlowKt__ContextKt.flowOn(r0, r1);
    }

    public static final <T, R> Object fold(Flow<? extends T> r0, R r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2, Continuation<? super R> r3) {
        return FlowKt__ReduceKt.fold(r0, r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void forEach(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        FlowKt__MigrationKt.forEach(r0, r1);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
        FlowKt__MergeKt.getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations();
    }

    public static final <T> Object last(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.last(r0, r1);
    }

    public static final <T> Object lastOrNull(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.lastOrNull(r0, r1);
    }

    public static final <T> Job launchIn(Flow<? extends T> r0, CoroutineScope r1) {
        return FlowKt__CollectKt.launchIn(r0, r1);
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r1) {
        return FlowKt__TransformKt.map(r0, r1);
    }

    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r1) {
        return FlowKt__MergeKt.mapLatest(r0, r1);
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r1) {
        return FlowKt__TransformKt.mapNotNull(r0, r1);
    }

    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> r0) {
        return FlowKt__MergeKt.merge(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> r0) {
        return FlowKt__MigrationKt.merge(r0);
    }

    public static final <T> Flow<T> merge(Flow<? extends T>... r0) {
        return FlowKt__MergeKt.merge(r0);
    }

    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> observeOn(Flow<? extends T> r0, CoroutineContext r1) {
        return FlowKt__MigrationKt.observeOn(r0, r1);
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> r0, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__EmittersKt.onCompletion(r0, r1);
    }

    public static final <T> Flow<T> onEach(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__TransformKt.onEach(r0, r1);
    }

    public static final <T> Flow<T> onEmpty(Flow<? extends T> r0, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__EmittersKt.onEmpty(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResume(Flow<? extends T> r0, Flow<? extends T> r1) {
        return FlowKt__MigrationKt.onErrorResume(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> r0, Flow<? extends T> r1) {
        return FlowKt__MigrationKt.onErrorResumeNext(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> r0, T r1) {
        return FlowKt__MigrationKt.onErrorReturn(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> r0, T r1, Function1<? super Throwable, Boolean> r2) {
        return FlowKt__MigrationKt.onErrorReturn(r0, r1, r2);
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow r0, Object r1, Function1 r2, int r3, Object r4) {
        return FlowKt__MigrationKt.onErrorReturn$default(r0, r1, r2, r3, r4);
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> r0, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__EmittersKt.onStart(r0, r1);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> r0, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__ShareKt.onSubscription(r0, r1);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> r0, CoroutineScope r1) {
        return FlowKt__ChannelsKt.produceIn(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> publish(Flow<? extends T> r0) {
        return FlowKt__MigrationKt.publish(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> publish(Flow<? extends T> r0, int r1) {
        return FlowKt__MigrationKt.publish(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> publishOn(Flow<? extends T> r0, CoroutineContext r1) {
        return FlowKt__MigrationKt.publishOn(r0, r1);
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> r0) {
        return FlowKt__ChannelsKt.receiveAsFlow(r0);
    }

    public static final <S, T extends S> Object reduce(Flow<? extends T> r0, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r1, Continuation<? super S> r2) {
        return FlowKt__ReduceKt.reduce(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    public static final <T> Flow<T> replay(Flow<? extends T> r0) {
        return FlowKt__MigrationKt.replay(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    public static final <T> Flow<T> replay(Flow<? extends T> r0, int r1) {
        return FlowKt__MigrationKt.replay(r0, r1);
    }

    public static final <T> Flow<T> retry(Flow<? extends T> r0, long r1, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        return FlowKt__ErrorsKt.retry(r0, r1, r3);
    }

    public static /* synthetic */ Flow retry$default(Flow r0, long r1, Function2 r3, int r4, Object r5) {
        return FlowKt__ErrorsKt.retry$default(r0, r1, r3, r4, r5);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> r0, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__ErrorsKt.retryWhen(r0, r1);
    }

    public static final <T, R> Flow<R> runningFold(Flow<? extends T> r0, R r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__TransformKt.runningFold(r0, r1, r2);
    }

    public static final <T> Flow<T> runningReduce(Flow<? extends T> r0, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r1) {
        return FlowKt__TransformKt.runningReduce(r0, r1);
    }

    public static final <T> Flow<T> sample(Flow<? extends T> r0, long r1) {
        return FlowKt__DelayKt.sample(r0, r1);
    }

    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m3043sampleHG0u8IE(Flow<? extends T> r0, long r1) {
        return FlowKt__DelayKt.m3046sampleHG0u8IE(r0, r1);
    }

    public static final <T, R> Flow<R> scan(Flow<? extends T> r0, R r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__TransformKt.scan(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> scanFold(Flow<? extends T> r0, R r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__MigrationKt.scanFold(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <T> Flow<T> scanReduce(Flow<? extends T> r0, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r1) {
        return FlowKt__MigrationKt.scanReduce(r0, r1);
    }

    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> r0, CoroutineScope r1, SharingStarted r2, int r3) {
        return FlowKt__ShareKt.shareIn(r0, r1, r2, r3);
    }

    public static /* synthetic */ SharedFlow shareIn$default(Flow r0, CoroutineScope r1, SharingStarted r2, int r3, int r4, Object r5) {
        return FlowKt__ShareKt.shareIn$default(r0, r1, r2, r3, r4, r5);
    }

    public static final <T> Object single(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.single(r0, r1);
    }

    public static final <T> Object singleOrNull(Flow<? extends T> r0, Continuation<? super T> r1) {
        return FlowKt__ReduceKt.singleOrNull(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> skip(Flow<? extends T> r0, int r1) {
        return FlowKt__MigrationKt.skip(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow<? extends T> r0, T r1) {
        return FlowKt__MigrationKt.startWith(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow<? extends T> r0, Flow<? extends T> r1) {
        return FlowKt__MigrationKt.startWith(r0, r1);
    }

    public static final <T> Object stateIn(Flow<? extends T> r0, CoroutineScope r1, Continuation<? super StateFlow<? extends T>> r2) {
        return FlowKt__ShareKt.stateIn(r0, r1, r2);
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> r0, CoroutineScope r1, SharingStarted r2, T r3) {
        return FlowKt__ShareKt.stateIn(r0, r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(Flow<? extends T> r0) {
        FlowKt__MigrationKt.subscribe(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        FlowKt__MigrationKt.subscribe(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r2) {
        FlowKt__MigrationKt.subscribe(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    public static final <T> Flow<T> subscribeOn(Flow<? extends T> r0, CoroutineContext r1) {
        return FlowKt__MigrationKt.subscribeOn(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> switchMap(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> r1) {
        return FlowKt__MigrationKt.switchMap(r0, r1);
    }

    public static final <T> Flow<T> take(Flow<? extends T> r0, int r1) {
        return FlowKt__LimitKt.take(r0, r1);
    }

    public static final <T> Flow<T> takeWhile(Flow<? extends T> r0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__LimitKt.takeWhile(r0, r1);
    }

    /* JADX INFO: renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m3044timeoutHG0u8IE(Flow<? extends T> r0, long r1) {
        return FlowKt__DelayKt.m3047timeoutHG0u8IE(r0, r1);
    }

    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> r0, C r1, Continuation<? super C> r2) {
        return FlowKt__CollectionKt.toCollection(r0, r1, r2);
    }

    public static final <T> Object toList(Flow<? extends T> r0, List<T> r1, Continuation<? super List<? extends T>> r2) {
        return FlowKt__CollectionKt.toList(r0, r1, r2);
    }

    public static /* synthetic */ Object toList$default(Flow r0, List r1, Continuation r2, int r3, Object r4) {
        return FlowKt__CollectionKt.toList$default(r0, r1, r2, r3, r4);
    }

    public static final <T> Object toSet(Flow<? extends T> r0, Set<T> r1, Continuation<? super Set<? extends T>> r2) {
        return FlowKt__CollectionKt.toSet(r0, r1, r2);
    }

    public static /* synthetic */ Object toSet$default(Flow r0, Set r1, Continuation r2, int r3, Object r4) {
        return FlowKt__CollectionKt.toSet$default(r0, r1, r2, r3, r4);
    }

    public static final <T, R> Flow<R> transform(Flow<? extends T> r0, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__EmittersKt.transform(r0, r1);
    }

    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> r0, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__MergeKt.transformLatest(r0, r1);
    }

    public static final <T, R> Flow<R> transformWhile(Flow<? extends T> r0, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        return FlowKt__LimitKt.transformWhile(r0, r1);
    }

    public static final <T, R> Flow<R> unsafeTransform(Flow<? extends T> r0, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        return FlowKt__EmittersKt.unsafeTransform(r0, r1);
    }

    public static final <T> Flow<IndexedValue<T>> withIndex(Flow<? extends T> r0) {
        return FlowKt__TransformKt.withIndex(r0);
    }

    public static final <T1, T2, R> Flow<R> zip(Flow<? extends T1> r0, Flow<? extends T2> r1, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r2) {
        return FlowKt__ZipKt.zip(r0, r1, r2);
    }
}
