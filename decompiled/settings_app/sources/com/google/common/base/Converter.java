package com.google.common.base;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @CheckForNull
    @LazyInit
    private transient Converter<B, A> reverse;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> r1, Converter<B, C> r2) {
            this.first = r1;
            this.second = r2;
        }

        @Override // com.google.common.base.Converter
        protected C doForward(A r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(C r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        C correctedDoForward(@CheckForNull A r2) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(r2));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A correctedDoBackward(@CheckForNull C r2) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(r2));
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof ConverterComposition) == false) goto L10;
            ConverterComposition r5 = (ConverterComposition) r4;
            if (this.first.equals(r5.first) == true) goto L7;
            return false;
        L7:
            if (this.second.equals(r5.second) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String r0 = String.valueOf(this.first);
            String r3 = String.valueOf(this.second);
            return new StringBuilder((String.valueOf(r0).length() + 10) + String.valueOf(r3).length()).append(r0).append(".andThen(").append(r3).append(")").toString();
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        /* synthetic */ FunctionBasedConverter(Function r1, Function r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> r1, Function<? super B, ? extends A> r2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(r1);
            this.backwardFunction = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A r1) {
            return this.forwardFunction.apply(r1);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B r1) {
            return this.backwardFunction.apply(r1);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof FunctionBasedConverter) == false) goto L10;
            FunctionBasedConverter r5 = (FunctionBasedConverter) r4;
            if (this.forwardFunction.equals(r5.forwardFunction) == true) goto L7;
            return false;
        L7:
            if (this.backwardFunction.equals(r5.backwardFunction) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            String r0 = String.valueOf(this.forwardFunction);
            String r3 = String.valueOf(this.backwardFunction);
            return new StringBuilder((String.valueOf(r0).length() + 18) + String.valueOf(r3).length()).append("Converter.from(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = null;
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Converter
        protected T doBackward(T r1) {
            return r1;
        }

        @Override // com.google.common.base.Converter
        protected T doForward(T r1) {
            return r1;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        private IdentityConverter() {
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Converter reverse() {
            return reverse();
        }

        static {
            INSTANCE = new IdentityConverter();
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> doAndThen(Converter<T, S> r1) {
            return (Converter) Preconditions.checkNotNull(r1, "otherConverter");
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> r1) {
            this.original = r1;
        }

        @Override // com.google.common.base.Converter
        protected A doForward(B r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected B doBackward(A r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A correctedDoForward(@CheckForNull B r1) {
            return this.original.correctedDoBackward(r1);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        B correctedDoBackward(@CheckForNull A r1) {
            return this.original.correctedDoForward(r1);
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof ReverseConverter) == true) goto L5;
            return false;
        L5:
            return this.original.equals(((ReverseConverter) r2).original);
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.original);
            return new StringBuilder(String.valueOf(r2).length() + 10).append(r2).append(".reverse()").toString();
        }
    }

    protected abstract A doBackward(B r1);

    protected abstract B doForward(A r1);

    protected Converter() {
        this(true);
    }

    Converter(boolean r1) {
        this.handleNullAutomatically = r1;
    }

    @CheckForNull
    public final B convert(@CheckForNull A r1) {
        return correctedDoForward(r1);
    }

    @CheckForNull
    B correctedDoForward(@CheckForNull A r2) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (B) Preconditions.checkNotNull(doForward(r2));
    L9:
        return unsafeDoForward(r2);
    }

    @CheckForNull
    A correctedDoBackward(@CheckForNull B r2) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (A) Preconditions.checkNotNull(doBackward(r2));
    L9:
        return unsafeDoBackward(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private B unsafeDoForward(@CheckForNull A r1) {
        return (B) doForward(NullnessCasts.uncheckedCastNullableTToT(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private A unsafeDoBackward(@CheckForNull B r1) {
        return (A) doBackward(NullnessCasts.uncheckedCastNullableTToT(r1));
    }

    public Iterable<B> convertAll(final Iterable<? extends A> r2) {
        Preconditions.checkNotNull(r2, "fromIterable");
        return new AnonymousClass1(this, r2);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> r0 = this.reverse;
        if (r0 != null) goto L6;
        ReverseConverter r1 = new ReverseConverter(this);
        this.reverse = r1;
        return r1;
    L6:
        return r0;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> r1) {
        return doAndThen(r1);
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> r2) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(r2));
    }

    @Override // com.google.common.base.Function, java.util.function.Function
    @CheckForNull
    @Deprecated
    public final B apply(@CheckForNull A r1) {
        return convert(r1);
    }

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> r2, Function<? super B, ? extends A> r3) {
        return new FunctionBasedConverter(r2, r3, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }
}
