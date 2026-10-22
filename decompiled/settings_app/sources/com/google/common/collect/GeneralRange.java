package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @CheckForNull
    private final T lowerEndpoint;

    @CheckForNull
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @CheckForNull
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> r10) {
        Comparable r1 = null;
        if (r10.hasLowerBound() == false) goto L5;
        Comparable r5 = r10.lowerEndpoint();
    L7:
        if (r10.hasLowerBound() == false) goto L9;
        BoundType r0 = r10.lowerBoundType();
    L10:
        BoundType r6 = r0;
        if (r10.hasUpperBound() == false) goto L13;
        r1 = r10.upperEndpoint();
    L13:
        Comparable r8 = r1;
        if (r10.hasUpperBound() == false) goto L16;
        BoundType r2 = r10.upperBoundType();
    L18:
        return new GeneralRange(Ordering.natural(), r10.hasLowerBound(), r5, r6, r10.hasUpperBound(), r8, r2);
    L16:
        r2 = BoundType.OPEN;
        goto L18
    L9:
        r0 = BoundType.OPEN;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    static <T> GeneralRange<T> all(Comparator<? super T> r9) {
        return new GeneralRange(r9, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> r9, @ParametricNullness T r10, BoundType r11) {
        return new GeneralRange(r9, true, r10, r11, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> r9, @ParametricNullness T r10, BoundType r11) {
        return new GeneralRange(r9, false, null, BoundType.OPEN, true, r10, r11);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> r9, @ParametricNullness T r10, BoundType r11, @ParametricNullness T r12, BoundType r13) {
        return new GeneralRange(r9, true, r10, r11, true, r12, r13);
    }

    private GeneralRange(Comparator<? super T> r2, boolean r3, @CheckForNull T r4, BoundType r5, boolean r6, @CheckForNull T r7, BoundType r8) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r2);
        this.hasLowerBound = r3;
        this.hasUpperBound = r6;
        this.lowerEndpoint = r4;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(r5);
        this.upperEndpoint = r7;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(r8);
        if (r3 == false) goto L5;
        r2.compare((Object) NullnessCasts.uncheckedCastNullableTToT(r4), (Object) NullnessCasts.uncheckedCastNullableTToT(r4));
    L5:
        if (r6 == false) goto L7;
        r2.compare((Object) NullnessCasts.uncheckedCastNullableTToT(r7), (Object) NullnessCasts.uncheckedCastNullableTToT(r7));
    L7:
        if (r3 == false) goto L25;
        if (r6 == false) goto L26;
        int r1 = r2.compare((Object) NullnessCasts.uncheckedCastNullableTToT(r4), (Object) NullnessCasts.uncheckedCastNullableTToT(r7));
        boolean r9 = true;
        if (r1 > 0) goto L12;
        boolean r10 = true;
    L13:
        Preconditions.checkArgument(r10, "lowerEndpoint (%s) > upperEndpoint (%s)", r4, r7);
        if (r1 == 0) goto L16;
        return;
    L16:
        if (r5 == BoundType.OPEN) goto L18;
        boolean r11 = true;
    L20:
        if (r8 != BoundType.OPEN) goto L23;
        r9 = false;
    L23:
        Preconditions.checkArgument(r11 | r9);
        return;
    L18:
        r11 = false;
        goto L20
    L12:
        r10 = false;
        goto L13
    L26:
        return;
    }

    Comparator<? super T> comparator() {
        return this.comparator;
    }

    boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isEmpty() {
        if (hasUpperBound() == false) goto L7;
        if (tooLow(NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint())) == false) goto L7;
    L10:
        return true;
    L7:
        if (hasLowerBound() == true) goto L9;
    L11:
        return false;
    L9:
        if (tooHigh(NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint())) == false) goto L11;
        goto L10
    }

    boolean tooLow(@ParametricNullness T r5) {
        boolean r1 = false;
        if (hasLowerBound() == true) goto L5;
        return false;
    L5:
        int r6 = this.comparator.compare(r5, NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint()));
        if (r6 >= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r6 != 0) goto L11;
        boolean r7 = true;
    L13:
        if (getLowerBoundType() != BoundType.OPEN) goto L16;
        r1 = true;
    L16:
        return (r7 & r1) | r2;
    L11:
        r7 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    boolean tooHigh(@ParametricNullness T r5) {
        boolean r1 = false;
        if (hasUpperBound() == true) goto L5;
        return false;
    L5:
        int r6 = this.comparator.compare(r5, NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()));
        if (r6 <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r6 != 0) goto L11;
        boolean r7 = true;
    L13:
        if (getUpperBoundType() != BoundType.OPEN) goto L16;
        r1 = true;
    L16:
        return (r7 & r1) | r2;
    L11:
        r7 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    boolean contains(@ParametricNullness T r2) {
        if (tooLow(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (tooHigh(r2) == true) goto L7;
        return true;
    }

    GeneralRange<T> intersect(GeneralRange<T> r12) {
        Preconditions.checkNotNull(r12);
        Preconditions.checkArgument(this.comparator.equals(r12.comparator));
        boolean r0 = this.hasLowerBound;
        T r1 = getLowerEndpoint();
        BoundType r2 = getLowerBoundType();
        if (hasLowerBound() == true) goto L6;
        r0 = r12.hasLowerBound;
        r1 = r12.getLowerEndpoint();
        r2 = r12.getLowerBoundType();
    L13:
        boolean r5 = r0;
        boolean r3 = this.hasUpperBound;
        T r4 = getUpperEndpoint();
        BoundType r6 = getUpperBoundType();
        if (hasUpperBound() == true) goto L17;
        r3 = r12.hasUpperBound;
        r4 = r12.getUpperEndpoint();
        r6 = r12.getUpperBoundType();
    L24:
        boolean r8 = r3;
        T r9 = r4;
        if (r5 == false) goto L35;
        if (r8 == false) goto L35;
        int r13 = this.comparator.compare(r1, r9);
        if (r13 > 0) goto L34;
        if (r13 != 0) goto L35;
        if (r2 != BoundType.OPEN) goto L35;
        if (r6 != BoundType.OPEN) goto L35;
    L34:
        BoundType r14 = BoundType.OPEN;
        BoundType r7 = r14;
        BoundType r10 = BoundType.CLOSED;
        T r11 = r9;
    L37:
        return new GeneralRange(this.comparator, r5, r11, r7, r8, r9, r10);
    L35:
        r11 = r1;
        r7 = r2;
        r10 = r6;
        goto L37
    L17:
        if (r12.hasUpperBound() == false) goto L24;
        int r15 = this.comparator.compare(getUpperEndpoint(), r12.getUpperEndpoint());
        if (r15 > 0) goto L23;
        if (r15 != 0) goto L24;
        if (r12.getUpperBoundType() != BoundType.OPEN) goto L24;
    L23:
        r4 = r12.getUpperEndpoint();
        r6 = r12.getUpperBoundType();
        goto L24
    L6:
        if (r12.hasLowerBound() == false) goto L13;
        int r16 = this.comparator.compare(getLowerEndpoint(), r12.getLowerEndpoint());
        if (r16 < 0) goto L12;
        if (r16 != 0) goto L13;
        if (r12.getLowerBoundType() != BoundType.OPEN) goto L13;
    L12:
        r1 = r12.getLowerEndpoint();
        r2 = r12.getLowerBoundType();
        goto L13
    }

    public boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof GeneralRange) == false) goto L20;
        GeneralRange r5 = (GeneralRange) r4;
        if (this.comparator.equals(r5.comparator) == true) goto L7;
        return false;
    L7:
        if (this.hasLowerBound == r5.hasLowerBound) goto L9;
        return false;
    L9:
        if (this.hasUpperBound == r5.hasUpperBound) goto L11;
        return false;
    L11:
        if (getLowerBoundType().equals(r5.getLowerBoundType()) == true) goto L13;
        return false;
    L13:
        if (getUpperBoundType().equals(r5.getUpperBoundType()) == true) goto L15;
        return false;
    L15:
        if (Objects.equal(getLowerEndpoint(), r5.getLowerEndpoint()) == true) goto L17;
        return false;
    L17:
        if (Objects.equal(getUpperEndpoint(), r5.getUpperEndpoint()) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> r0 = this.reverse;
        if (r0 != null) goto L6;
        GeneralRange<T> r1 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        r1.reverse = this;
        this.reverse = r1;
        return r1;
    L6:
        return r0;
    }

    public String toString() {
        String r0 = String.valueOf(this.comparator);
        if (this.lowerBoundType != BoundType.CLOSED) goto L5;
        char r1 = '[';
    L7:
        if (this.hasLowerBound == false) goto L9;
        Object r2 = this.lowerEndpoint;
    L10:
        String r3 = String.valueOf(r2);
        if (this.hasUpperBound == false) goto L13;
        Object r4 = this.upperEndpoint;
    L14:
        String r5 = String.valueOf(r4);
        if (this.upperBoundType != BoundType.CLOSED) goto L17;
        char r6 = ']';
    L19:
        return new StringBuilder(((String.valueOf(r0).length() + 4) + String.valueOf(r3).length()) + String.valueOf(r5).length()).append(r0).append(":").append(r1).append(r3).append(',').append(r5).append(r6).toString();
    L17:
        r6 = ')';
        goto L19
    L13:
        r4 = "∞";
        goto L14
    L9:
        r2 = "-∞";
        goto L10
    L5:
        r1 = '(';
        goto L7
    }

    @CheckForNull
    T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    @CheckForNull
    T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
