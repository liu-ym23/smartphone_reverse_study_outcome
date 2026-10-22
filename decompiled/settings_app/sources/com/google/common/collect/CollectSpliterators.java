package com.google.common.collect;

import adcpeJava.adcpe.Ciphertext;
import android.icu.lang.UCharacter;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CollectSpliterators {

    /* JADX INFO: Add missing generic type declarations: [OutElementT] */
    /* JADX INFO: renamed from: com.google.common.collect.CollectSpliterators$1, reason: invalid class name */
    class AnonymousClass1<OutElementT> implements Spliterator<OutElementT> {
        final /* synthetic */ Spliterator val$fromSpliterator;
        final /* synthetic */ Function val$function;

        AnonymousClass1(Spliterator r1, Function r2) {
            this.val$fromSpliterator = r1;
            this.val$function = r2;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super OutElementT> r3) {
            Spliterator r0 = this.val$fromSpliterator;
            final Function r2 = this.val$function;
            return r0.tryAdvance(new CollectSpliterators$1$$ExternalSyntheticLambda1(r3, r2));
        }

        static /* synthetic */ void lambda$tryAdvance$0(Consumer r0, Function r1, Object r2) {
            r0.accept(r1.apply(r2));
        }

        static /* synthetic */ void lambda$forEachRemaining$1(Consumer r0, Function r1, Object r2) {
            r0.accept(r1.apply(r2));
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super OutElementT> r3) {
            Spliterator r0 = this.val$fromSpliterator;
            final Function r2 = this.val$function;
            r0.forEachRemaining(new CollectSpliterators$1$$ExternalSyntheticLambda0(r3, r2));
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public Spliterator<OutElementT> trySplit() {
            Spliterator r0 = this.val$fromSpliterator.trySplit();
            if (r0 != null) goto L7;
            return null;
        L7:
            return CollectSpliterators.map(r0, this.val$function);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.val$fromSpliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.val$fromSpliterator.characteristics() & (-262);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.CollectSpliterators$1Splitr, reason: invalid class name */
    class C1Splitr<T> implements Spliterator<T>, Consumer<T> {

        @CheckForNull
        T holder;
        final /* synthetic */ Spliterator val$fromSpliterator;
        final /* synthetic */ Predicate val$predicate;

        C1Splitr(Spliterator r1, Predicate r2) {
            this.val$fromSpliterator = r1;
            this.val$predicate = r2;
            this.holder = null;
        }

        @Override // java.util.function.Consumer
        public void accept(@ParametricNullness T r1) {
            this.holder = r1;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> r4) {
        L3:
            if (this.val$fromSpliterator.tryAdvance(this) == false) goto L14;
            Ciphertext r1 = (Object) NullnessCasts.uncheckedCastNullableTToT(this.holder);
            if (this.val$predicate.test(r1) == true) goto L7;
            this.holder = null;
            goto L3
        L7:
            r4.accept(r1);     // Catch: Throwable -> L11
            this.holder = null;
            return true;
        L11:
            th = move-exception;
            this.holder = null;
            throw th;
        L14:
            return false;
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public Spliterator<T> trySplit() {
            Spliterator<T> r0 = this.val$fromSpliterator.trySplit();
            if (r0 != null) goto L6;
            return null;
        L6:
            return CollectSpliterators.filter(r0, this.val$predicate);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.val$fromSpliterator.estimateSize() / 2;
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public Comparator<? super T> getComparator() {
            return this.val$fromSpliterator.getComparator();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.val$fromSpliterator.characteristics() & UCharacter.UnicodeBlock.NUSHU_ID;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.CollectSpliterators$1WithCharacteristics, reason: invalid class name */
    class C1WithCharacteristics<T> implements Spliterator<T> {
        private final Spliterator.OfInt delegate;
        final /* synthetic */ Comparator val$comparator;
        final /* synthetic */ int val$extraCharacteristics;
        final /* synthetic */ IntFunction val$function;

        C1WithCharacteristics(Spliterator.OfInt r1, IntFunction r2, int r3, Comparator r4) {
            this.val$function = r2;
            this.val$extraCharacteristics = r3;
            this.val$comparator = r4;
            this.delegate = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void lambda$tryAdvance$0(Consumer r0, IntFunction r1, int r2) {
            r0.accept(r1.apply(r2));
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> r3) {
            Spliterator.OfInt r0 = this.delegate;
            final IntFunction r2 = this.val$function;
            return r0.tryAdvance(new CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda1(r3, r2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void lambda$forEachRemaining$1(Consumer r0, IntFunction r1, int r2) {
            r0.accept(r1.apply(r2));
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> r3) {
            Spliterator.OfInt r0 = this.delegate;
            final IntFunction r2 = this.val$function;
            r0.forEachRemaining(new CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda0(r3, r2));
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public Spliterator<T> trySplit() {
            Spliterator.OfInt r0 = this.delegate.trySplit();
            if (r0 != null) goto L6;
            return null;
        L6:
            return new C1WithCharacteristics(r0, this.val$function, this.val$extraCharacteristics, this.val$comparator);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.delegate.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.val$extraCharacteristics | 16464;
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4) == false) goto L7;
            return this.val$comparator;
        L7:
            throw new IllegalStateException();
        }
    }

    static abstract class FlatMapSpliterator<InElementT, OutElementT, OutSpliteratorT extends Spliterator<OutElementT>> implements Spliterator<OutElementT> {
        int characteristics;
        long estimatedSize;
        final Factory<InElementT, OutSpliteratorT> factory;
        final Spliterator<InElementT> from;
        final Function<? super InElementT, OutSpliteratorT> function;

        @CheckForNull
        OutSpliteratorT prefix;

        @FunctionalInterface
        interface Factory<InElementT, OutSpliteratorT extends Spliterator<?>> {
            OutSpliteratorT newFlatMapSpliterator(@CheckForNull OutSpliteratorT r1, Spliterator<InElementT> r2, Function<? super InElementT, OutSpliteratorT> r3, int r4, long r5);
        }

        FlatMapSpliterator(@CheckForNull OutSpliteratorT r1, Spliterator<InElementT> r2, Function<? super InElementT, OutSpliteratorT> r3, Factory<InElementT, OutSpliteratorT> r4, int r5, long r6) {
            this.prefix = r1;
            this.from = r2;
            this.function = r3;
            this.factory = r4;
            this.characteristics = r5;
            this.estimatedSize = r6;
        }

        @Override // java.util.Spliterator
        public final boolean tryAdvance(Consumer<? super OutElementT> r5) {
        L2:
            OutSpliteratorT r0 = this.prefix;
            if (r0 != null) goto L5;
        L11:
            this.prefix = null;
            if (this.from.tryAdvance(new CollectSpliterators$FlatMapSpliterator$$ExternalSyntheticLambda1(this)) == true) goto L2;
            return false;
        L5:
            if (r0.tryAdvance(r5) == false) goto L11;
            long r1 = this.estimatedSize;
            if (r1 == Long.MAX_VALUE) goto L18;
            this.estimatedSize = r1 - 1;
            return true;
        L18:
            return true;
        }

        /* JADX INFO: renamed from: lambda$tryAdvance$0$com-google-common-collect-CollectSpliterators$FlatMapSpliterator, reason: not valid java name */
        /* synthetic */ void m895xf1ca5dcf(Object r2) {
            this.prefix = this.function.apply(r2);
        }

        @Override // java.util.Spliterator
        public final void forEachRemaining(final Consumer<? super OutElementT> r3) {
            OutSpliteratorT r0 = this.prefix;
            if (r0 == null) goto L5;
            r0.forEachRemaining(r3);
            this.prefix = null;
        L5:
            this.from.forEachRemaining(new CollectSpliterators$FlatMapSpliterator$$ExternalSyntheticLambda0(this, r3));
            this.estimatedSize = 0;
        }

        /* JADX INFO: renamed from: lambda$forEachRemaining$1$com-google-common-collect-CollectSpliterators$FlatMapSpliterator, reason: not valid java name */
        /* synthetic */ void m894x4d83d929(Consumer r1, Object r2) {
            OutSpliteratorT r0 = this.function.apply(r2);
            if (r0 == null) goto L6;
            r0.forEachRemaining(r1);
            return;
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public final OutSpliteratorT trySplit() {
            Spliterator<InElementT> r3 = this.from.trySplit();
            if (r3 == null) goto L9;
            int r5 = this.characteristics & (-65);
            long r1 = estimateSize();
            if (r1 >= Long.MAX_VALUE) goto L7;
            r1 = r1 / 2;
            this.estimatedSize -= r1;
            this.characteristics = r5;
        L7:
            OutSpliteratorT r2 = (OutSpliteratorT) this.factory.newFlatMapSpliterator(this.prefix, r3, this.function, r5, r1);
            this.prefix = null;
            return r2;
        L9:
            OutSpliteratorT r4 = this.prefix;
            if (r4 == null) goto L13;
            this.prefix = null;
            return r4;
        L13:
            return null;
        }

        @Override // java.util.Spliterator
        public final long estimateSize() {
            OutSpliteratorT r0 = this.prefix;
            if (r0 == null) goto L6;
            this.estimatedSize = Math.max(this.estimatedSize, r0.estimateSize());
        L6:
            return Math.max(this.estimatedSize, 0);
        }

        @Override // java.util.Spliterator
        public final int characteristics() {
            return this.characteristics;
        }
    }

    static final class FlatMapSpliteratorOfDouble<InElementT> extends FlatMapSpliteratorOfPrimitive<InElementT, Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble {
        @Override // java.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer r1) {
            super.forEachRemaining(r1);
        }

        @Override // java.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer r1) {
            return super.tryAdvance(r1);
        }

        @Override // com.google.common.collect.CollectSpliterators.FlatMapSpliteratorOfPrimitive, com.google.common.collect.CollectSpliterators.FlatMapSpliterator, java.util.Spliterator
        @CheckForNull
        public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
            return (Spliterator.OfDouble) super.trySplit();
        }

        FlatMapSpliteratorOfDouble(@CheckForNull Spliterator.OfDouble r9, Spliterator<InElementT> r10, Function<? super InElementT, Spliterator.OfDouble> r11, int r12, long r13) {
            super(r9, r10, r11, new CollectSpliterators$FlatMapSpliteratorOfDouble$$ExternalSyntheticLambda0(), r12, r13);
        }
    }

    static final class FlatMapSpliteratorOfInt<InElementT> extends FlatMapSpliteratorOfPrimitive<InElementT, Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt {
        @Override // java.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer r1) {
            super.forEachRemaining(r1);
        }

        @Override // java.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer r1) {
            return super.tryAdvance(r1);
        }

        @Override // com.google.common.collect.CollectSpliterators.FlatMapSpliteratorOfPrimitive, com.google.common.collect.CollectSpliterators.FlatMapSpliterator, java.util.Spliterator
        @CheckForNull
        public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
            return (Spliterator.OfInt) super.trySplit();
        }

        FlatMapSpliteratorOfInt(@CheckForNull Spliterator.OfInt r9, Spliterator<InElementT> r10, Function<? super InElementT, Spliterator.OfInt> r11, int r12, long r13) {
            super(r9, r10, r11, new CollectSpliterators$FlatMapSpliteratorOfInt$$ExternalSyntheticLambda0(), r12, r13);
        }
    }

    static final class FlatMapSpliteratorOfLong<InElementT> extends FlatMapSpliteratorOfPrimitive<InElementT, Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong {
        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer r1) {
            super.forEachRemaining(r1);
        }

        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer r1) {
            return super.tryAdvance(r1);
        }

        @Override // com.google.common.collect.CollectSpliterators.FlatMapSpliteratorOfPrimitive, com.google.common.collect.CollectSpliterators.FlatMapSpliterator, java.util.Spliterator
        @CheckForNull
        public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
            return (Spliterator.OfLong) super.trySplit();
        }

        FlatMapSpliteratorOfLong(@CheckForNull Spliterator.OfLong r9, Spliterator<InElementT> r10, Function<? super InElementT, Spliterator.OfLong> r11, int r12, long r13) {
            super(r9, r10, r11, new CollectSpliterators$FlatMapSpliteratorOfLong$$ExternalSyntheticLambda0(), r12, r13);
        }
    }

    static final class FlatMapSpliteratorOfObject<InElementT, OutElementT> extends FlatMapSpliterator<InElementT, OutElementT, Spliterator<OutElementT>> {
        FlatMapSpliteratorOfObject(@CheckForNull Spliterator<OutElementT> r9, Spliterator<InElementT> r10, Function<? super InElementT, Spliterator<OutElementT>> r11, int r12, long r13) {
            super(r9, r10, r11, new CollectSpliterators$FlatMapSpliteratorOfObject$$ExternalSyntheticLambda0(), r12, r13);
        }
    }

    static abstract class FlatMapSpliteratorOfPrimitive<InElementT, OutElementT, OutConsumerT, OutSpliteratorT extends Spliterator.OfPrimitive<OutElementT, OutConsumerT, OutSpliteratorT>> extends FlatMapSpliterator<InElementT, OutElementT, OutSpliteratorT> implements Spliterator.OfPrimitive<OutElementT, OutConsumerT, OutSpliteratorT> {
        @Override // com.google.common.collect.CollectSpliterators.FlatMapSpliterator, java.util.Spliterator
        @CheckForNull
        public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
            return (Spliterator.OfPrimitive) super.trySplit();
        }

        FlatMapSpliteratorOfPrimitive(@CheckForNull OutSpliteratorT r1, Spliterator<InElementT> r2, Function<? super InElementT, OutSpliteratorT> r3, FlatMapSpliterator.Factory<InElementT, OutSpliteratorT> r4, int r5, long r6) {
            super(r1, r2, r3, r4, r5, r6);
        }

        @Override // java.util.Spliterator.OfPrimitive
        public final boolean tryAdvance(OutConsumerT r5) {
        L3:
            if (this.prefix != 0) goto L5;
        L11:
            this.prefix = null;
            if (this.from.tryAdvance(new CollectSpliterators$FlatMapSpliteratorOfPrimitive$$ExternalSyntheticLambda1(this)) == true) goto L3;
            return false;
        L5:
            if (((Spliterator.OfPrimitive) this.prefix).tryAdvance(r5) == false) goto L11;
            if (this.estimatedSize == Long.MAX_VALUE) goto L18;
            this.estimatedSize--;
            return true;
        L18:
            return true;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: lambda$tryAdvance$0$com-google-common-collect-CollectSpliterators$FlatMapSpliteratorOfPrimitive, reason: not valid java name */
        /* synthetic */ void m897xff99a381(Object r2) {
            this.prefix = (OutSpliteratorT) this.function.apply((Object) r2);
        }

        @Override // java.util.Spliterator.OfPrimitive
        public final void forEachRemaining(final OutConsumerT r3) {
            if (this.prefix == 0) goto L5;
            ((Spliterator.OfPrimitive) this.prefix).forEachRemaining(r3);
            this.prefix = null;
        L5:
            this.from.forEachRemaining(new CollectSpliterators$FlatMapSpliteratorOfPrimitive$$ExternalSyntheticLambda0(this, r3));
            this.estimatedSize = 0;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: lambda$forEachRemaining$1$com-google-common-collect-CollectSpliterators$FlatMapSpliteratorOfPrimitive, reason: not valid java name */
        /* synthetic */ void m896x55296be7(Object r1, Object r2) {
            Spliterator.OfPrimitive r0 = (Spliterator.OfPrimitive) this.function.apply((Object) r2);
            if (r0 == null) goto L6;
            r0.forEachRemaining(r1);
            return;
        }
    }

    private CollectSpliterators() {
    }

    static <T> Spliterator<T> indexed(int r1, int r2, IntFunction<T> r3) {
        return indexed(r1, r2, r3, null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Spliterator$OfInt] */
    static <T> Spliterator<T> indexed(int r2, int r3, IntFunction<T> r4, @CheckForNull Comparator<? super T> r5) {
        if (r5 == null) goto L10;
        if ((r3 & 4) == 0) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkArgument(r1);
        goto L10
    L7:
        r1 = false;
    L10:
        return new C1WithCharacteristics(IntStream.range(0, r2).spliterator(), r4, r3, r5);
    }

    static <InElementT, OutElementT> Spliterator<OutElementT> map(Spliterator<InElementT> r1, Function<? super InElementT, ? extends OutElementT> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(r1, r2);
    }

    static <T> Spliterator<T> filter(Spliterator<T> r1, Predicate<? super T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new C1Splitr(r1, r2);
    }

    static <InElementT, OutElementT> Spliterator<OutElementT> flatMap(Spliterator<InElementT> r9, Function<? super InElementT, Spliterator<OutElementT>> r10, int r11, long r12) {
        boolean r1 = true;
        if ((r11 & 16384) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "flatMap does not support SUBSIZED characteristic");
        if ((r11 & 4) == 0) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "flatMap does not support SORTED characteristic");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        return new FlatMapSpliteratorOfObject(null, r9, r10, r11, r12);
    L5:
        r0 = false;
        goto L6
    }

    static <InElementT> Spliterator.OfInt flatMapToInt(Spliterator<InElementT> r9, Function<? super InElementT, Spliterator.OfInt> r10, int r11, long r12) {
        boolean r1 = true;
        if ((r11 & 16384) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "flatMap does not support SUBSIZED characteristic");
        if ((r11 & 4) == 0) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "flatMap does not support SORTED characteristic");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        return new FlatMapSpliteratorOfInt(null, r9, r10, r11, r12);
    L5:
        r0 = false;
        goto L6
    }

    static <InElementT> Spliterator.OfLong flatMapToLong(Spliterator<InElementT> r9, Function<? super InElementT, Spliterator.OfLong> r10, int r11, long r12) {
        boolean r1 = true;
        if ((r11 & 16384) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "flatMap does not support SUBSIZED characteristic");
        if ((r11 & 4) == 0) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "flatMap does not support SORTED characteristic");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        return new FlatMapSpliteratorOfLong(null, r9, r10, r11, r12);
    L5:
        r0 = false;
        goto L6
    }

    static <InElementT> Spliterator.OfDouble flatMapToDouble(Spliterator<InElementT> r9, Function<? super InElementT, Spliterator.OfDouble> r10, int r11, long r12) {
        boolean r1 = true;
        if ((r11 & 16384) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "flatMap does not support SUBSIZED characteristic");
        if ((r11 & 4) == 0) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "flatMap does not support SORTED characteristic");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        return new FlatMapSpliteratorOfDouble(null, r9, r10, r11, r12);
    L5:
        r0 = false;
        goto L6
    }
}
