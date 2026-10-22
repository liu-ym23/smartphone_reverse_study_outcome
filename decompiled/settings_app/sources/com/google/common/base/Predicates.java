package com.google.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Predicates {

    /* JADX INFO: renamed from: com.google.common.base.Predicates$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* synthetic */ AndPredicate(List r1, AnonymousClass1 r2) {
            this(r1);
        }

        private AndPredicate(List<? extends Predicate<? super T>> r1) {
            this.components = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L9;
            if (this.components.get(r1).apply(r4) == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof AndPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((AndPredicate) r2).components);
        }

        public String toString() {
            return Predicates.access$800("and", this.components);
        }
    }

    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<A, ? extends B> f;
        final Predicate<B> p;

        /* synthetic */ CompositionPredicate(Predicate r1, Function r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private CompositionPredicate(Predicate<B> r1, Function<A, ? extends B> r2) {
            this.p = (Predicate) Preconditions.checkNotNull(r1);
            this.f = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness A r2) {
            return this.p.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof CompositionPredicate) == false) goto L10;
            CompositionPredicate r5 = (CompositionPredicate) r4;
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.p.equals(r5.p) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.p.hashCode() ^ r0;
        }

        public String toString() {
            String r0 = String.valueOf(this.p);
            String r3 = String.valueOf(this.f);
            return new StringBuilder((String.valueOf(r0).length() + 2) + String.valueOf(r3).length()).append(r0).append("(").append(r3).append(")").toString();
        }
    }

    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String r1) {
            super(Platform.compilePattern(r1));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            String r2 = this.pattern.pattern();
            return new StringBuilder(String.valueOf(r2).length() + 28).append("Predicates.containsPattern(").append(r2).append(")").toString();
        }
    }

    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final CommonPattern pattern;

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(CharSequence r1) {
            return apply2(r1);
        }

        ContainsPatternPredicate(CommonPattern r1) {
            this.pattern = (CommonPattern) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(CharSequence r1) {
            return this.pattern.matcher(r1).find();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof ContainsPatternPredicate) == false) goto L10;
            ContainsPatternPredicate r5 = (ContainsPatternPredicate) r4;
            if (Objects.equal(this.pattern.pattern(), r5.pattern.pattern()) == true) goto L7;
            return false;
        L7:
            if (this.pattern.flags() != r5.pattern.flags()) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            String r3 = MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
            return new StringBuilder(String.valueOf(r3).length() + 21).append("Predicates.contains(").append(r3).append(")").toString();
        }
    }

    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        /* synthetic */ InPredicate(Collection r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InPredicate(Collection<?> r1) {
            this.target = (Collection) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T r1) {
            return this.target.contains(r1);
        L4:
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof InPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((InPredicate) r2).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(r2).length() + 15).append("Predicates.in(").append(r2).append(")").toString();
        }
    }

    private static class InstanceOfPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        /* synthetic */ InstanceOfPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InstanceOfPredicate(Class<?> r1) {
            this.clazz = (Class) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T r1) {
            return this.clazz.isInstance(r1);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r3) {
            if ((r3 instanceof InstanceOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((InstanceOfPredicate) r3).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public String toString() {
            String r2 = this.clazz.getName();
            return new StringBuilder(String.valueOf(r2).length() + 23).append("Predicates.instanceOf(").append(r2).append(")").toString();
        }
    }

    private static class IsEqualToPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        <T> Predicate<T> withNarrowedType() {
            return this;
        }

        /* synthetic */ IsEqualToPredicate(Object r1, AnonymousClass1 r2) {
            this(r1);
        }

        private IsEqualToPredicate(Object r1) {
            this.target = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@CheckForNull Object r1) {
            return this.target.equals(r1);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof IsEqualToPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((IsEqualToPredicate) r2).target);
        }

        public String toString() {
            String r2 = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(r2).length() + 20).append("Predicates.equalTo(").append(r2).append(")").toString();
        }
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> r1) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T r1) {
            return !this.predicate.apply(r1);
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof NotPredicate) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((NotPredicate) r2).predicate);
        }

        public String toString() {
            String r2 = String.valueOf(this.predicate);
            return new StringBuilder(String.valueOf(r2).length() + 16).append("Predicates.not(").append(r2).append(")").toString();
        }
    }

    static abstract enum ObjectPredicate extends Enum<ObjectPredicate> implements Predicate<Object> {
        private static final /* synthetic */ ObjectPredicate[] $VALUES = null;
        public static final ObjectPredicate ALWAYS_FALSE = null;
        public static final ObjectPredicate ALWAYS_TRUE = null;
        public static final ObjectPredicate IS_NULL = null;
        public static final ObjectPredicate NOT_NULL = null;

        <T> Predicate<T> withNarrowedType() {
            return this;
        }

        private static /* synthetic */ ObjectPredicate[] $values() {
            return new ObjectPredicate[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
        }

        private ObjectPredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ObjectPredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static ObjectPredicate valueOf(String r1) {
            return (ObjectPredicate) Enum.valueOf(ObjectPredicate.class, r1);
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) $VALUES.clone();
        }

        static {
            final String r1 = "ALWAYS_TRUE";
            final int r2 = 0;
            ALWAYS_TRUE = new AnonymousClass1(r1, r2);
            final String r3 = "ALWAYS_FALSE";
            final int r4 = 1;
            ALWAYS_FALSE = new AnonymousClass2(r3, r4);
            final String r5 = "IS_NULL";
            final int r6 = 2;
            IS_NULL = new AnonymousClass3(r5, r6);
            final String r7 = "NOT_NULL";
            final int r8 = 3;
            NOT_NULL = new AnonymousClass4(r7, r8);
            $VALUES = $values();
        }
    }

    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* synthetic */ OrPredicate(List r1, AnonymousClass1 r2) {
            this(r1);
        }

        private OrPredicate(List<? extends Predicate<? super T>> r1) {
            this.components = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L10;
            if (this.components.get(r1).apply(r4) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof OrPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((OrPredicate) r2).components);
        }

        public String toString() {
            return Predicates.access$800("or", this.components);
        }
    }

    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Class<?> r1) {
            return apply2(r1);
        }

        /* synthetic */ SubtypeOfPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SubtypeOfPredicate(Class<?> r1) {
            this.clazz = (Class) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(Class<?> r1) {
            return this.clazz.isAssignableFrom(r1);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object r3) {
            if ((r3 instanceof SubtypeOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((SubtypeOfPredicate) r3).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public String toString() {
            String r2 = this.clazz.getName();
            return new StringBuilder(String.valueOf(r2).length() + 22).append("Predicates.subtypeOf(").append(r2).append(")").toString();
        }
    }

    static /* synthetic */ String access$800(String r0, Iterable r1) {
        return toStringHelper(r0, r1);
    }

    private Predicates() {
    }

    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> r1) {
        return new NotPredicate(r1);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> r2) {
        return new AndPredicate(defensiveCopy(r2), null);
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... r2) {
        return new AndPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> and(Predicate<? super T> r1, Predicate<? super T> r2) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2)), null);
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> r2) {
        return new OrPredicate(defensiveCopy(r2), null);
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... r2) {
        return new OrPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> or(Predicate<? super T> r1, Predicate<? super T> r2) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2)), null);
    }

    public static <T> Predicate<T> equalTo(@ParametricNullness T r2) {
        if (r2 != null) goto L5;
        return isNull();
    L5:
        return new IsEqualToPredicate(r2, null).withNarrowedType();
    }

    public static <T> Predicate<T> instanceOf(Class<?> r2) {
        return new InstanceOfPredicate(r2, null);
    }

    public static Predicate<Class<?>> subtypeOf(Class<?> r2) {
        return new SubtypeOfPredicate(r2, null);
    }

    public static <T> Predicate<T> in(Collection<? extends T> r2) {
        return new InPredicate(r2, null);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> r2, Function<A, ? extends B> r3) {
        return new CompositionPredicate(r2, r3, null);
    }

    public static Predicate<CharSequence> containsPattern(String r1) {
        return new ContainsPatternFromStringPredicate(r1);
    }

    public static Predicate<CharSequence> contains(Pattern r2) {
        return new ContainsPatternPredicate(new JdkPattern(r2));
    }

    private static String toStringHelper(String r2, Iterable<?> r3) {
        StringBuilder r4 = new StringBuilder("Predicates.").append(r2).append('(');
        Iterator<?> r5 = r3.iterator();
        boolean r0 = true;
    L4:
        if (r5.hasNext() == false) goto L10;
        Object r1 = r5.next();
        if (r0 == true) goto L8;
        r4.append(',');
    L8:
        r4.append(r1);
        r0 = false;
        goto L4
    L10:
        return r4.append(')').toString();
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> r2, Predicate<? super T> r3) {
        return Arrays.asList(new Predicate[]{r2, r3});
    }

    private static <T> List<T> defensiveCopy(T... r0) {
        return defensiveCopy(Arrays.asList(r0));
    }

    static <T> List<T> defensiveCopy(Iterable<T> r2) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(Preconditions.checkNotNull(r3.next()));
        goto L4
    L6:
        return r0;
    }
}
