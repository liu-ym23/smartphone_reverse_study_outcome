package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class Functions {
    static final Predicate<Object> ALWAYS_FALSE = null;
    static final Predicate<Object> ALWAYS_TRUE = null;
    public static final Action EMPTY_ACTION = null;
    static final Consumer<Object> EMPTY_CONSUMER = null;
    public static final LongConsumer EMPTY_LONG_CONSUMER = null;
    public static final Runnable EMPTY_RUNNABLE = null;
    public static final Consumer<Throwable> ERROR_CONSUMER = null;
    static final Function<Object, Object> IDENTITY = null;
    static final Comparator<Object> NATURAL_COMPARATOR = null;
    static final Callable<Object> NULL_SUPPLIER = null;
    public static final Consumer<Throwable> ON_ERROR_MISSING = null;
    public static final Consumer<Subscription> REQUEST_MAX = null;

    static final class ActionConsumer<T> implements Consumer<T> {
        final Action action;

        ActionConsumer(Action r1) {
            this.action = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T r1) throws Exception {
            this.action.run();
        }
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r3) throws Exception {
            if (r3.length != 2) goto L7;
            return this.f.apply(r3[0], r3[1]);
        L7:
            throw new IllegalArgumentException("Array of size 2 expected but got " + r3.length);
        }
    }

    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array3Func(Function3<T1, T2, T3, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r4) throws Exception {
            if (r4.length != 3) goto L7;
            return this.f.apply((T1) r4[0], (T2) r4[1], (T3) r4[2]);
        L7:
            throw new IllegalArgumentException("Array of size 3 expected but got " + r4.length);
        }
    }

    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        final Function4<T1, T2, T3, T4, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array4Func(Function4<T1, T2, T3, T4, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r5) throws Exception {
            if (r5.length != 4) goto L7;
            return this.f.apply((T1) r5[0], (T2) r5[1], (T3) r5[2], (T4) r5[3]);
        L7:
            throw new IllegalArgumentException("Array of size 4 expected but got " + r5.length);
        }
    }

    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        private final Function5<T1, T2, T3, T4, T5, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array5Func(Function5<T1, T2, T3, T4, T5, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r9) throws Exception {
            if (r9.length != 5) goto L7;
            return this.f.apply((T1) r9[0], (T2) r9[1], (T3) r9[2], (T4) r9[3], (T5) r9[4]);
        L7:
            throw new IllegalArgumentException("Array of size 5 expected but got " + r9.length);
        }
    }

    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        final Function6<T1, T2, T3, T4, T5, T6, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r10) throws Exception {
            if (r10.length != 6) goto L7;
            return this.f.apply((T1) r10[0], (T2) r10[1], (T3) r10[2], (T4) r10[3], (T5) r10[4], (T6) r10[5]);
        L7:
            throw new IllegalArgumentException("Array of size 6 expected but got " + r10.length);
        }
    }

    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r11) throws Exception {
            if (r11.length != 7) goto L7;
            return this.f.apply((T1) r11[0], (T2) r11[1], (T3) r11[2], (T4) r11[3], (T5) r11[4], (T6) r11[5], (T7) r11[6]);
        L7:
            throw new IllegalArgumentException("Array of size 7 expected but got " + r11.length);
        }
    }

    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r12) throws Exception {
            if (r12.length != 8) goto L7;
            return this.f.apply((T1) r12[0], (T2) r12[1], (T3) r12[2], (T4) r12[3], (T5) r12[4], (T6) r12[5], (T7) r12[6], (T8) r12[7]);
        L7:
            throw new IllegalArgumentException("Array of size 8 expected but got " + r12.length);
        }
    }

    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object[] r1) throws Exception {
            return apply2(r1);
        }

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> r1) {
            this.f = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public R apply2(Object[] r13) throws Exception {
            if (r13.length != 9) goto L7;
            return this.f.apply((T1) r13[0], (T2) r13[1], (T3) r13[2], (T4) r13[3], (T5) r13[4], (T6) r13[5], (T7) r13[6], (T8) r13[7], (T9) r13[8]);
        L7:
            throw new IllegalArgumentException("Array of size 9 expected but got " + r13.length);
        }
    }

    static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {
        final int capacity;

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        ArrayListCapacityCallable(int r1) {
            this.capacity = r1;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.capacity);
        }
    }

    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        final BooleanSupplier supplier;

        BooleanSupplierPredicateReverse(BooleanSupplier r1) {
            this.supplier = r1;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T r1) throws Exception {
            return !this.supplier.getAsBoolean();
        }
    }

    public static class BoundedConsumer implements Consumer<Subscription> {
        final int bufferSize;

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Subscription r1) throws Exception {
            accept2(r1);
        }

        BoundedConsumer(int r1) {
            this.bufferSize = r1;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Subscription r3) throws Exception {
            r3.request(this.bufferSize);
        }
    }

    static final class CastToClass<T, U> implements Function<T, U> {
        final Class<U> clazz;

        CastToClass(Class<U> r1) {
            this.clazz = r1;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T r1) throws Exception {
            return this.clazz.cast(r1);
        }
    }

    static final class ClassFilter<T, U> implements Predicate<T> {
        final Class<U> clazz;

        ClassFilter(Class<U> r1) {
            this.clazz = r1;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T r1) throws Exception {
            return this.clazz.isInstance(r1);
        }
    }

    static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        EmptyAction() {
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Object r1) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        EmptyConsumer() {
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        @Override // io.reactivex.functions.LongConsumer
        public void accept(long r1) {
        }

        EmptyLongConsumer() {
        }
    }

    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        EmptyRunnable() {
        }
    }

    static final class EqualsPredicate<T> implements Predicate<T> {
        final T value;

        EqualsPredicate(T r1) {
            this.value = r1;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T r1) throws Exception {
            return ObjectHelper.equals(r1, this.value);
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Throwable r1) throws Exception {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Throwable r1) {
            RxJavaPlugins.onError(r1);
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object r1) {
            return false;
        }

        FalsePredicate() {
        }
    }

    static final class FutureAction implements Action {
        final Future<?> future;

        FutureAction(Future<?> r1) {
            this.future = r1;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.future.get();
        }
    }

    static final enum HashSetCallable extends Enum<HashSetCallable> implements Callable<Set<Object>> {
        private static final /* synthetic */ HashSetCallable[] $VALUES = null;
        public static final HashSetCallable INSTANCE = null;

        private HashSetCallable(String r1, int r2) {
            super(r1, r2);
        }

        public static HashSetCallable valueOf(String r1) {
            return (HashSetCallable) Enum.valueOf(HashSetCallable.class, r1);
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) $VALUES.clone();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Set<Object> call() throws Exception {
            return call2();
        }

        static {
            HashSetCallable r0 = new HashSetCallable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new HashSetCallable[]{r0};
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Set<Object> call2() throws Exception {
            return new HashSet();
        }
    }

    static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.functions.Function
        public Object apply(Object r1) {
            return r1;
        }

        public String toString() {
            return "IdentityFunction";
        }

        Identity() {
        }
    }

    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        final U value;

        JustValue(U r1) {
            this.value = r1;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.value;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T r1) throws Exception {
            return this.value;
        }
    }

    static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> comparator;

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((List) r1);
        }

        ListSorter(Comparator<? super T> r1) {
            this.comparator = r1;
        }

        public List<T> apply(List<T> r1) {
            Collections.sort(r1, this.comparator);
            return r1;
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Subscription r1) throws Exception {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Subscription r3) throws Exception {
            r3.request(Long.MAX_VALUE);
        }
    }

    static final enum NaturalComparator extends Enum<NaturalComparator> implements Comparator<Object> {
        private static final /* synthetic */ NaturalComparator[] $VALUES = null;
        public static final NaturalComparator INSTANCE = null;

        private NaturalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static NaturalComparator valueOf(String r1) {
            return (NaturalComparator) Enum.valueOf(NaturalComparator.class, r1);
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) $VALUES.clone();
        }

        static {
            NaturalComparator r0 = new NaturalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NaturalComparator[]{r0};
        }

        @Override // java.util.Comparator
        public int compare(Object r1, Object r2) {
            return ((Comparable) r1).compareTo(r2);
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object r1, Object r2) {
            return ((Comparable) r1).compareTo(r2);
        }
    }

    static final class NotificationOnComplete<T> implements Action {
        final Consumer<? super Notification<T>> onNotification;

        NotificationOnComplete(Consumer<? super Notification<T>> r1) {
            this.onNotification = r1;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.onNotification.accept(Notification.createOnComplete());
        }
    }

    static final class NotificationOnError<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> onNotification;

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Throwable r1) throws Exception {
            accept2(r1);
        }

        NotificationOnError(Consumer<? super Notification<T>> r1) {
            this.onNotification = r1;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Throwable r1) throws Exception {
            this.onNotification.accept(Notification.createOnError(r1));
        }
    }

    static final class NotificationOnNext<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> onNotification;

        NotificationOnNext(Consumer<? super Notification<T>> r1) {
            this.onNotification = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T r1) throws Exception {
            this.onNotification.accept(Notification.createOnNext(r1));
        }
    }

    static final class NullCallable implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Throwable r1) throws Exception {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Throwable r1) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(r1));
        }
    }

    static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        final Scheduler scheduler;
        final TimeUnit unit;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply(r1);
        }

        TimestampFunction(TimeUnit r1, Scheduler r2) {
            this.unit = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.functions.Function
        public Timed<T> apply(T r4) throws Exception {
            return new Timed(r4, this.scheduler.now(this.unit), this.unit);
        }
    }

    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> keySelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object r1, Object r2) throws Exception {
            accept((Map) r1, r2);
        }

        ToMapKeySelector(Function<? super T, ? extends K> r1) {
            this.keySelector = r1;
        }

        public void accept(Map<K, T> r1, T r2) throws Exception {
            r1.put(this.keySelector.apply(r2), r2);
        }
    }

    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object r1, Object r2) throws Exception {
            accept((Map) r1, r2);
        }

        ToMapKeyValueSelector(Function<? super T, ? extends V> r1, Function<? super T, ? extends K> r2) {
            this.valueSelector = r1;
            this.keySelector = r2;
        }

        public void accept(Map<K, V> r2, T r3) throws Exception {
            r2.put(this.keySelector.apply(r3), this.valueSelector.apply(r3));
        }
    }

    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object r1, Object r2) throws Exception {
            accept((Map) r1, r2);
        }

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> r1, Function<? super T, ? extends V> r2, Function<? super T, ? extends K> r3) {
            this.collectionFactory = r1;
            this.valueSelector = r2;
            this.keySelector = r3;
        }

        public void accept(Map<K, Collection<V>> r3, T r4) throws Exception {
            K r0 = this.keySelector.apply(r4);
            Collection<? super V> r1 = (Collection) r3.get(r0);
            if (r1 != null) goto L5;
            r1 = this.collectionFactory.apply(r0);
            r3.put(r0, r1);
        L5:
            r1.add(this.valueSelector.apply(r4));
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object r1) {
            return true;
        }

        TruePredicate() {
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array2Func(r1);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array3Func(r1);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array4Func(r1);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array5Func(r1);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array6Func(r1);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array7Func(r1);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array8Func(r1);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> r1) {
        ObjectHelper.requireNonNull(r1, "f is null");
        return new Array9Func(r1);
    }

    static {
        IDENTITY = new Identity();
        EMPTY_RUNNABLE = new EmptyRunnable();
        EMPTY_ACTION = new EmptyAction();
        EMPTY_CONSUMER = new EmptyConsumer();
        ERROR_CONSUMER = new ErrorConsumer();
        ON_ERROR_MISSING = new OnErrorMissingConsumer();
        EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
        ALWAYS_TRUE = new TruePredicate();
        ALWAYS_FALSE = new FalsePredicate();
        NULL_SUPPLIER = new NullCallable();
        NATURAL_COMPARATOR = new NaturalObjectComparator();
        REQUEST_MAX = new MaxRequestSubscription();
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) ALWAYS_TRUE;
    }

    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) ALWAYS_FALSE;
    }

    public static <T> Callable<T> nullSupplier() {
        return (Callable<T>) NULL_SUPPLIER;
    }

    public static <T> Comparator<T> naturalOrder() {
        return (Comparator<T>) NATURAL_COMPARATOR;
    }

    public static Action futureAction(Future<?> r1) {
        return new FutureAction(r1);
    }

    public static <T> Callable<T> justCallable(T r1) {
        return new JustValue(r1);
    }

    public static <T, U> Function<T, U> justFunction(U r1) {
        return new JustValue(r1);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> r1) {
        return new CastToClass(r1);
    }

    public static <T> Callable<List<T>> createArrayList(int r1) {
        return new ArrayListCapacityCallable(r1);
    }

    public static <T> Predicate<T> equalsWith(T r1) {
        return new EqualsPredicate(r1);
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> r1) {
        return new NotificationOnNext(r1);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> r1) {
        return new NotificationOnError(r1);
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> r1) {
        return new NotificationOnComplete(r1);
    }

    public static <T> Consumer<T> actionConsumer(Action r1) {
        return new ActionConsumer(r1);
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> r1) {
        return new ClassFilter(r1);
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier r1) {
        return new BooleanSupplierPredicateReverse(r1);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit r1, Scheduler r2) {
        return new TimestampFunction(r1, r2);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> r1) {
        return new ToMapKeySelector(r1);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> r1, Function<? super T, ? extends V> r2) {
        return new ToMapKeyValueSelector(r2, r1);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> r1, Function<? super T, ? extends V> r2, Function<? super K, ? extends Collection<? super V>> r3) {
        return new ToMultimapKeyValueSelector(r3, r2, r1);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> r1) {
        return new ListSorter(r1);
    }

    public static <T> Consumer<T> boundedConsumer(int r1) {
        return new BoundedConsumer(r1);
    }
}
