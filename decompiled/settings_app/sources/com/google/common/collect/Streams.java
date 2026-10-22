package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Streams {

    /* JADX INFO: renamed from: com.google.common.collect.Streams$1OptionalState, reason: invalid class name */
    class C1OptionalState {
        boolean set;

        @CheckForNull
        T value;

        C1OptionalState() {
            this.set = false;
            this.value = null;
        }

        void set(T r2) {
            this.set = true;
            this.value = r2;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        T get() {
            return Objects.requireNonNull(this.value);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: com.google.common.collect.Streams$1Splitr, reason: invalid class name */
    class C1Splitr<R, T> extends MapWithIndexSpliterator<Spliterator<T>, R, C1Splitr> implements Consumer<T> {

        @CheckForNull
        T holder;
        final /* synthetic */ FunctionWithIndex val$function;

        @Override // com.google.common.collect.Streams.MapWithIndexSpliterator
        /* bridge */ /* synthetic */ MapWithIndexSpliterator createSplit(Spliterator r1, long r2) {
            return createSplit(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.Streams$FunctionWithIndex), (r0 I:com.google.common.collect.Streams$1Splitr) (LINE:459) com.google.common.collect.Streams.1Splitr.val$function com.google.common.collect.Streams$FunctionWithIndex, block:B:2:0x0000 */
        C1Splitr(Spliterator r1, Spliterator<T> r2, long r3) {
            this.val$function = r4;
            super(r1, r2);
        }

        @Override // java.util.function.Consumer
        public void accept(@ParametricNullness T r1) {
            this.holder = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> r8) {
            if (this.fromSpliterator.tryAdvance(this) == true) goto L13;
            return false;
        L13:
            FunctionWithIndex r1 = this.val$function;     // Catch: Throwable -> L8
            Object r2 = NullnessCasts.uncheckedCastNullableTToT(this.holder);     // Catch: Throwable -> L8
            long r3 = this.index;     // Catch: Throwable -> L8
            this.index = 1 + r3;     // Catch: Throwable -> L8
            r8.accept((Object) r1.apply(r2, r3));     // Catch: Throwable -> L8
            this.holder = null;
            return true;
        L8:
            th = move-exception;
            this.holder = null;
            throw th;
        }

        @Override // com.google.common.collect.Streams.MapWithIndexSpliterator
        C1Splitr createSplit(Spliterator<T> r2, long r3) {
            return new C1Splitr(r2, r3, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.google.common.collect.Streams$2Splitr, reason: invalid class name */
    class C2Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfInt, R, C2Splitr> implements IntConsumer, Spliterator<R> {
        int holder;
        final /* synthetic */ IntFunctionWithIndex val$function;

        @Override // com.google.common.collect.Streams.MapWithIndexSpliterator
        /* bridge */ /* synthetic */ MapWithIndexSpliterator createSplit(Spliterator r1, long r2) {
            return createSplit((Spliterator.OfInt) r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.Streams$IntFunctionWithIndex), (r0 I:com.google.common.collect.Streams$2Splitr) (LINE:544) com.google.common.collect.Streams.2Splitr.val$function com.google.common.collect.Streams$IntFunctionWithIndex, block:B:2:0x0000 */
        C2Splitr(Spliterator.OfInt r1, Spliterator.OfInt r2, long r3) {
            this.val$function = r4;
            super(r1, r2);
        }

        @Override // java.util.function.IntConsumer
        public void accept(int r1) {
            this.holder = r1;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> r7) {
            if (((Spliterator.OfInt) this.fromSpliterator).tryAdvance(this) == false) goto L6;
            IntFunctionWithIndex r0 = this.val$function;
            int r1 = this.holder;
            long r2 = this.index;
            this.index = 1 + r2;
            r7.accept((Object) r0.apply(r1, r2));
            return true;
        L6:
            return false;
        }

        C2Splitr createSplit(Spliterator.OfInt r2, long r3) {
            return new C2Splitr(r2, r3, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.google.common.collect.Streams$3Splitr, reason: invalid class name */
    class C3Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfLong, R, C3Splitr> implements LongConsumer, Spliterator<R> {
        long holder;
        final /* synthetic */ LongFunctionWithIndex val$function;

        @Override // com.google.common.collect.Streams.MapWithIndexSpliterator
        /* bridge */ /* synthetic */ MapWithIndexSpliterator createSplit(Spliterator r1, long r2) {
            return createSplit((Spliterator.OfLong) r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.Streams$LongFunctionWithIndex), (r0 I:com.google.common.collect.Streams$3Splitr) (LINE:624) com.google.common.collect.Streams.3Splitr.val$function com.google.common.collect.Streams$LongFunctionWithIndex, block:B:2:0x0000 */
        C3Splitr(Spliterator.OfLong r1, Spliterator.OfLong r2, long r3) {
            this.val$function = r4;
            super(r1, r2);
        }

        @Override // java.util.function.LongConsumer
        public void accept(long r1) {
            this.holder = r1;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> r8) {
            if (((Spliterator.OfLong) this.fromSpliterator).tryAdvance(this) == false) goto L6;
            LongFunctionWithIndex r0 = this.val$function;
            long r1 = this.holder;
            long r3 = this.index;
            this.index = 1 + r3;
            r8.accept((Object) r0.apply(r1, r3));
            return true;
        L6:
            return false;
        }

        C3Splitr createSplit(Spliterator.OfLong r2, long r3) {
            return new C3Splitr(r2, r3, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.google.common.collect.Streams$4Splitr, reason: invalid class name */
    class C4Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfDouble, R, C4Splitr> implements DoubleConsumer, Spliterator<R> {
        double holder;
        final /* synthetic */ DoubleFunctionWithIndex val$function;

        @Override // com.google.common.collect.Streams.MapWithIndexSpliterator
        /* bridge */ /* synthetic */ MapWithIndexSpliterator createSplit(Spliterator r1, long r2) {
            return createSplit((Spliterator.OfDouble) r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.Streams$DoubleFunctionWithIndex), (r0 I:com.google.common.collect.Streams$4Splitr) (LINE:704) com.google.common.collect.Streams.4Splitr.val$function com.google.common.collect.Streams$DoubleFunctionWithIndex, block:B:2:0x0000 */
        C4Splitr(Spliterator.OfDouble r1, Spliterator.OfDouble r2, long r3) {
            this.val$function = r4;
            super(r1, r2);
        }

        @Override // java.util.function.DoubleConsumer
        public void accept(double r1) {
            this.holder = r1;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> r8) {
            if (((Spliterator.OfDouble) this.fromSpliterator).tryAdvance(this) == false) goto L6;
            DoubleFunctionWithIndex r0 = this.val$function;
            double r1 = this.holder;
            long r3 = this.index;
            this.index = 1 + r3;
            r8.accept((Object) r0.apply(r1, r3));
            return true;
        L6:
            return false;
        }

        C4Splitr createSplit(Spliterator.OfDouble r2, long r3) {
            return new C4Splitr(r2, r3, this.val$function);
        }
    }

    public interface DoubleFunctionWithIndex<R> {
        @ParametricNullness
        R apply(double r1, long r3);
    }

    public interface FunctionWithIndex<T, R> {
        @ParametricNullness
        R apply(@ParametricNullness T r1, long r2);
    }

    public interface IntFunctionWithIndex<R> {
        @ParametricNullness
        R apply(int r1, long r2);
    }

    public interface LongFunctionWithIndex<R> {
        @ParametricNullness
        R apply(long r1, long r3);
    }

    private static abstract class MapWithIndexSpliterator<F extends Spliterator<?>, R, S extends MapWithIndexSpliterator<F, R, S>> implements Spliterator<R> {
        final F fromSpliterator;
        long index;

        abstract S createSplit(F r1, long r2);

        @Override // java.util.Spliterator
        @CheckForNull
        public /* bridge */ /* synthetic */ Spliterator trySplit() {
            return trySplit();
        }

        MapWithIndexSpliterator(F r1, long r2) {
            this.fromSpliterator = r1;
            this.index = r2;
        }

        @Override // java.util.Spliterator
        @CheckForNull
        public S trySplit() {
            Spliterator r0 = this.fromSpliterator.trySplit();
            if (r0 != null) goto L6;
            return null;
        L6:
            S r1 = (S) createSplit(r0, this.index);
            this.index += r0.getExactSizeIfKnown();
            return r1;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fromSpliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.fromSpliterator.characteristics() & 16464;
        }
    }

    private static class TemporaryPair<A, B> {

        @ParametricNullness
        final A a;

        @ParametricNullness
        final B b;

        TemporaryPair(@ParametricNullness A r1, @ParametricNullness B r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3xarQn9-01mX0ryMDVLUOUVo4mo, reason: not valid java name */
    public static /* synthetic */ OptionalInt m911$r8$lambda$3xarQn901mX0ryMDVLUOUVo4mo(int r0) {
        return OptionalInt.of(r0);
    }

    public static /* synthetic */ OptionalDouble $r8$lambda$4mced6z7jB3cby1ZmxvwCq4gyhg(double r0) {
        return OptionalDouble.of(r0);
    }

    public static /* synthetic */ OptionalInt $r8$lambda$8ztn_HnA7Cd3jVD8V42p8P2lXeo() {
        return OptionalInt.empty();
    }

    public static /* synthetic */ OptionalLong $r8$lambda$BCNZXEX26QKXfYQO9PRp7ynYlY4(long r0) {
        return OptionalLong.of(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$CCBlbDhMal_Qn-vd1qnjtKuWRW4, reason: not valid java name */
    public static /* synthetic */ OptionalLong m912$r8$lambda$CCBlbDhMal_Qnvd1qnjtKuWRW4() {
        return OptionalLong.empty();
    }

    /* JADX INFO: renamed from: $r8$lambda$ysWjTWCgmTcuXM_G-7hjYksywHE, reason: not valid java name */
    public static /* synthetic */ OptionalDouble m913$r8$lambda$ysWjTWCgmTcuXM_G7hjYksywHE() {
        return OptionalDouble.empty();
    }

    static /* synthetic */ Spliterator lambda$concat$0(Spliterator r0) {
        return r0;
    }

    static /* synthetic */ Spliterator.OfInt lambda$concat$2(Spliterator.OfInt r0) {
        return r0;
    }

    static /* synthetic */ Spliterator.OfLong lambda$concat$4(Spliterator.OfLong r0) {
        return r0;
    }

    static /* synthetic */ Spliterator.OfDouble lambda$concat$6(Spliterator.OfDouble r0) {
        return r0;
    }

    public static <T> Stream<T> stream(Iterable<T> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).stream();
    L6:
        return StreamSupport.stream(r1.spliterator(), false);
    }

    @Deprecated
    public static <T> Stream<T> stream(Collection<T> r0) {
        return r0.stream();
    }

    public static <T> Stream<T> stream(Iterator<T> r1) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(r1, 0), false);
    }

    public static <T> Stream<T> stream(Optional<T> r1) {
        if (r1.isPresent() == false) goto L6;
        return Stream.of(r1.get());
    L6:
        return Stream.empty();
    }

    public static <T> Stream<T> stream(java.util.Optional<T> r1) {
        if (r1.isPresent() == false) goto L6;
        return Stream.of(r1.get());
    L6:
        return Stream.empty();
    }

    public static IntStream stream(OptionalInt r1) {
        if (r1.isPresent() == false) goto L6;
        return IntStream.of(r1.getAsInt());
    L6:
        return IntStream.empty();
    }

    public static LongStream stream(OptionalLong r2) {
        if (r2.isPresent() == false) goto L6;
        return LongStream.of(r2.getAsLong());
    L6:
        return LongStream.empty();
    }

    public static DoubleStream stream(OptionalDouble r2) {
        if (r2.isPresent() == false) goto L6;
        return DoubleStream.of(r2.getAsDouble());
    L6:
        return DoubleStream.empty();
    }

    private static void closeAll(BaseStream<?, ?>[] r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].close();
        r1 = r1 + 1;
        goto L3
    }

    @SafeVarargs
    public static <T> Stream<T> concat(final Stream<? extends T>... r9) {
        ImmutableList.Builder r0 = new ImmutableList.Builder(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        long r5 = 0;
        int r4 = 336;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L6;
        Stream<? extends T> r7 = r9[r2];
        r3 = r3 | r7.isParallel();
        Spliterator<? extends T> r8 = r7.spliterator();
        r0.add(r8);
        r4 = r4 & r8.characteristics();
        r5 = LongMath.saturatedAdd(r5, r8.estimateSize());
        r2 = r2 + 1;
        goto L3
    L6:
        return (Stream) StreamSupport.stream(CollectSpliterators.flatMap(r0.build().spliterator(), new Streams$$ExternalSyntheticLambda3(), r4, r5), r3).onClose(new Streams$$ExternalSyntheticLambda4(r9));
    }

    static /* synthetic */ void lambda$concat$1(Stream[] r0) {
        closeAll(r0);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Spliterator$OfInt] */
    public static IntStream concat(final IntStream... r9) {
        ImmutableList.Builder r0 = new ImmutableList.Builder(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        long r5 = 0;
        int r4 = 336;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L6;
        IntStream r7 = r9[r2];
        r3 = r3 | r7.isParallel();
        ?? r8 = r7.spliterator();
        r0.add(r8);
        r4 = r4 & r8.characteristics();
        r5 = LongMath.saturatedAdd(r5, r8.estimateSize());
        r2 = r2 + 1;
        goto L3
    L6:
        return (IntStream) StreamSupport.intStream(CollectSpliterators.flatMapToInt(r0.build().spliterator(), new Streams$$ExternalSyntheticLambda9(), r4, r5), r3).onClose(new Streams$$ExternalSyntheticLambda10(r9));
    }

    static /* synthetic */ void lambda$concat$3(IntStream[] r0) {
        closeAll(r0);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Spliterator$OfLong] */
    public static LongStream concat(final LongStream... r9) {
        ImmutableList.Builder r0 = new ImmutableList.Builder(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        long r5 = 0;
        int r4 = 336;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L6;
        LongStream r7 = r9[r2];
        r3 = r3 | r7.isParallel();
        ?? r8 = r7.spliterator();
        r0.add(r8);
        r4 = r4 & r8.characteristics();
        r5 = LongMath.saturatedAdd(r5, r8.estimateSize());
        r2 = r2 + 1;
        goto L3
    L6:
        return (LongStream) StreamSupport.longStream(CollectSpliterators.flatMapToLong(r0.build().spliterator(), new Streams$$ExternalSyntheticLambda17(), r4, r5), r3).onClose(new Streams$$ExternalSyntheticLambda18(r9));
    }

    static /* synthetic */ void lambda$concat$5(LongStream[] r0) {
        closeAll(r0);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Spliterator$OfDouble] */
    public static DoubleStream concat(final DoubleStream... r9) {
        ImmutableList.Builder r0 = new ImmutableList.Builder(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        long r5 = 0;
        int r4 = 336;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L6;
        DoubleStream r7 = r9[r2];
        r3 = r3 | r7.isParallel();
        ?? r8 = r7.spliterator();
        r0.add(r8);
        r4 = r4 & r8.characteristics();
        r5 = LongMath.saturatedAdd(r5, r8.estimateSize());
        r2 = r2 + 1;
        goto L3
    L6:
        return (DoubleStream) StreamSupport.doubleStream(CollectSpliterators.flatMapToDouble(r0.build().spliterator(), new Streams$$ExternalSyntheticLambda5(), r4, r5), r3).onClose(new Streams$$ExternalSyntheticLambda6(r9));
    }

    static /* synthetic */ void lambda$concat$7(DoubleStream[] r0) {
        closeAll(r0);
    }

    public static <A, B, R> Stream<R> zip(Stream<A> r11, Stream<B> r12, final BiFunction<? super A, ? super B, R> r13) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        Preconditions.checkNotNull(r13);
        if (r11.isParallel() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Spliterator<A> r1 = r11.spliterator();
        Spliterator<B> r2 = r12.spliterator();
        final int r7 = (r1.characteristics() & r2.characteristics()) & 80;
        final Iterator r8 = Spliterators.iterator(r1);
        final Iterator r9 = Spliterators.iterator(r2);
        final long r5 = Math.min(r1.estimateSize(), r2.estimateSize());
        Stream r14 = StreamSupport.stream(new AnonymousClass1(r5, r7, r8, r9, r13), r0);
        Objects.requireNonNull(r11);
        Stream r15 = (Stream) r14.onClose(new Streams$$ExternalSyntheticLambda0(r11));
        Objects.requireNonNull(r12);
        return (Stream) r15.onClose(new Streams$$ExternalSyntheticLambda0(r12));
    L5:
        if (r12.isParallel() == true) goto L8;
        r0 = false;
        goto L9
    }

    public static <A, B> void forEachPair(Stream<A> r2, Stream<B> r3, final BiConsumer<? super A, ? super B> r4) {
        Preconditions.checkNotNull(r4);
        if (r2.isParallel() == false) goto L5;
    L13:
        zip(r2, r3, new Streams$$ExternalSyntheticLambda14()).forEach(new Streams$$ExternalSyntheticLambda15(r4));
        return;
    L5:
        if (r3.isParallel() == true) goto L13;
        Iterator<A> r5 = r2.iterator();
        Iterator<B> r6 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L17;
        if (r6.hasNext() == false) goto L18;
        r4.accept(r5.next(), r6.next());
        goto L9
    L18:
        return;
    }

    static /* synthetic */ void lambda$forEachPair$8(BiConsumer r1, TemporaryPair r2) {
        r1.accept(r2.a, r2.b);
    }

    public static <T, R> Stream<R> mapWithIndex(Stream<T> r9, final FunctionWithIndex<? super T, ? extends R> r10) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        boolean r0 = r9.isParallel();
        Spliterator<T> r1 = r9.spliterator();
        if (r1.hasCharacteristics(16384) == true) goto L6;
        final Iterator r7 = Spliterators.iterator(r1);
        final long r4 = r1.estimateSize();
        final int r6 = r1.characteristics() & 80;
        Stream r11 = StreamSupport.stream(new AnonymousClass2(r4, r6, r7, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r11.onClose(new Streams$$ExternalSyntheticLambda0(r9));
    L6:
        Stream r12 = StreamSupport.stream(new C1Splitr(r1, 0, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r12.onClose(new Streams$$ExternalSyntheticLambda0(r9));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfInt] */
    public static <R> Stream<R> mapWithIndex(final IntStream r9, final IntFunctionWithIndex<R> r10) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        boolean r0 = r9.isParallel();
        ?? r1 = r9.spliterator();
        if (r1.hasCharacteristics(16384) == true) goto L6;
        final PrimitiveIterator.OfInt r7 = Spliterators.iterator(r1);
        final long r4 = r1.estimateSize();
        final int r6 = r1.characteristics() & 80;
        Stream r11 = StreamSupport.stream(new AnonymousClass3(r4, r6, r7, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r11.onClose(new Streams$$ExternalSyntheticLambda2(r9));
    L6:
        Stream r12 = StreamSupport.stream(new C2Splitr(r1, 0, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r12.onClose(new Streams$$ExternalSyntheticLambda2(r9));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfLong] */
    public static <R> Stream<R> mapWithIndex(final LongStream r9, final LongFunctionWithIndex<R> r10) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        boolean r0 = r9.isParallel();
        ?? r1 = r9.spliterator();
        if (r1.hasCharacteristics(16384) == true) goto L6;
        final PrimitiveIterator.OfLong r7 = Spliterators.iterator(r1);
        final long r4 = r1.estimateSize();
        final int r6 = r1.characteristics() & 80;
        Stream r11 = StreamSupport.stream(new AnonymousClass4(r4, r6, r7, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r11.onClose(new Streams$$ExternalSyntheticLambda12(r9));
    L6:
        Stream r12 = StreamSupport.stream(new C3Splitr(r1, 0, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r12.onClose(new Streams$$ExternalSyntheticLambda12(r9));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfDouble] */
    public static <R> Stream<R> mapWithIndex(final DoubleStream r9, final DoubleFunctionWithIndex<R> r10) {
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        boolean r0 = r9.isParallel();
        ?? r1 = r9.spliterator();
        if (r1.hasCharacteristics(16384) == true) goto L6;
        final PrimitiveIterator.OfDouble r7 = Spliterators.iterator(r1);
        final long r4 = r1.estimateSize();
        final int r6 = r1.characteristics() & 80;
        Stream r11 = StreamSupport.stream(new AnonymousClass5(r4, r6, r7, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r11.onClose(new Streams$$ExternalSyntheticLambda19(r9));
    L6:
        Stream r12 = StreamSupport.stream(new C4Splitr(r1, 0, r10), r0);
        Objects.requireNonNull(r9);
        return (Stream) r12.onClose(new Streams$$ExternalSyntheticLambda19(r9));
    }

    public static <T> java.util.Optional<T> findLast(Stream<T> r8) {
        final C1OptionalState r0 = new C1OptionalState();
        ArrayDeque r1 = new ArrayDeque();
        r1.addLast(r8.spliterator());
    L4:
        if (r1.isEmpty() == true) goto L31;
        Spliterator<T> r9 = (Spliterator) r1.removeLast();
        if (r9.getExactSizeIfKnown() == 0) goto L4;
        if (r9.hasCharacteristics(16384) == true) goto L10;
        Spliterator<T> r2 = r9.trySplit();
        if (r2 == null) goto L26;
        if (r2.getExactSizeIfKnown() == 0) goto L26;
        r1.addLast(r2);
        r1.addLast(r9);
    L26:
        Objects.requireNonNull(r0);
        r9.forEachRemaining(new Streams$$ExternalSyntheticLambda16(r0));
        if (r0.set == false) goto L4;
        return java.util.Optional.of(r0.get());
    L10:
        Spliterator<T> r3 = r9.trySplit();
        if (r3 == null) goto L18;
        if (r3.getExactSizeIfKnown() == 0) goto L18;
        if (r9.getExactSizeIfKnown() != 0) goto L10;
        r9 = r3;
    L18:
        Objects.requireNonNull(r0);
        r9.forEachRemaining(new Streams$$ExternalSyntheticLambda16(r0));
        return java.util.Optional.of(r0.get());
    L31:
        return java.util.Optional.empty();
    }

    public static OptionalInt findLast(IntStream r1) {
        return (OptionalInt) findLast(r1.boxed()).map(new Streams$$ExternalSyntheticLambda20()).orElseGet(new Streams$$ExternalSyntheticLambda1());
    }

    public static OptionalLong findLast(LongStream r1) {
        return (OptionalLong) findLast(r1.boxed()).map(new Streams$$ExternalSyntheticLambda7()).orElseGet(new Streams$$ExternalSyntheticLambda8());
    }

    public static OptionalDouble findLast(DoubleStream r1) {
        return (OptionalDouble) findLast(r1.boxed()).map(new Streams$$ExternalSyntheticLambda11()).orElseGet(new Streams$$ExternalSyntheticLambda13());
    }

    private Streams() {
    }
}
