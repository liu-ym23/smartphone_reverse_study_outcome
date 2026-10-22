package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class MoreCollectors {
    private static final Object NULL_PLACEHOLDER = null;
    private static final Collector<Object, ?, Object> ONLY_ELEMENT = null;
    private static final Collector<Object, ?, Optional<Object>> TO_OPTIONAL = null;

    private static final class ToOptionalState {
        static final int MAX_EXTRAS = 4;
        Object element;
        List<Object> extras;

        ToOptionalState() {
            this.element = null;
            this.extras = Collections.emptyList();
        }

        IllegalArgumentException multiples(boolean r4) {
            StringBuilder r0 = new StringBuilder("expected one element but was: <").append(this.element);
            Iterator<Object> r3 = this.extras.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Object r1 = r3.next();
            r0.append(", ").append(r1);
            goto L4
        L6:
            if (r4 == false) goto L8;
            r0.append(", ...");
        L8:
            r0.append('>');
            throw new IllegalArgumentException(r0.toString());
        }

        void add(Object r3) {
            Preconditions.checkNotNull(r3);
            if (this.element != null) goto L6;
            this.element = r3;
            return;
        L6:
            if (this.extras.isEmpty() == false) goto L9;
            ArrayList r0 = new ArrayList(4);
            this.extras = r0;
            r0.add(r3);
            return;
        L9:
            if (this.extras.size() >= 4) goto L13;
            this.extras.add(r3);
            return;
        L13:
            throw multiples(true);
        }

        ToOptionalState combine(ToOptionalState r3) {
            if (this.element != null) goto L6;
            return r3;
        L6:
            if (r3.element != null) goto L9;
            return this;
        L9:
            if (this.extras.isEmpty() == false) goto L11;
            this.extras = new ArrayList();
        L11:
            this.extras.add(r3.element);
            this.extras.addAll(r3.extras);
            if (this.extras.size() > 4) goto L14;
            return this;
        L14:
            List<Object> r4 = this.extras;
            r4.subList(4, r4.size()).clear();
            throw multiples(true);
        }

        Optional<Object> getOptional() {
            if (this.extras.isEmpty() == false) goto L7;
            return Optional.ofNullable(this.element);
        L7:
            throw multiples(false);
        }

        Object getElement() {
            if (this.element == null) goto L11;
            if (this.extras.isEmpty() == false) goto L9;
            return this.element;
        L9:
            throw multiples(false);
        L11:
            throw new NoSuchElementException();
        }
    }

    static {
        TO_OPTIONAL = Collector.of(new MoreCollectors$$ExternalSyntheticLambda0(), new MoreCollectors$$ExternalSyntheticLambda1(), new MoreCollectors$$ExternalSyntheticLambda2(), new MoreCollectors$$ExternalSyntheticLambda3(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
        NULL_PLACEHOLDER = new Object();
        ONLY_ELEMENT = Collector.of(new MoreCollectors$$ExternalSyntheticLambda0(), new MoreCollectors$$ExternalSyntheticLambda4(), new MoreCollectors$$ExternalSyntheticLambda2(), new MoreCollectors$$ExternalSyntheticLambda5(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    public static <T> Collector<T, ?, Optional<T>> toOptional() {
        return (Collector<T, ?, Optional<T>>) TO_OPTIONAL;
    }

    static /* synthetic */ void lambda$static$0(ToOptionalState r0, Object r1) {
        if (r1 != null) goto L4;
        r1 = NULL_PLACEHOLDER;
    L4:
        r0.add(r1);
    }

    static /* synthetic */ Object lambda$static$1(ToOptionalState r1) {
        Object r2 = r1.getElement();
        if (r2 != NULL_PLACEHOLDER) goto L6;
        return null;
    L6:
        return r2;
    }

    public static <T> Collector<T, ?, T> onlyElement() {
        return (Collector<T, ?, T>) ONLY_ELEMENT;
    }

    private MoreCollectors() {
    }
}
