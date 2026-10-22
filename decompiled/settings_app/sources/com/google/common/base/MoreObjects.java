package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class MoreObjects {

    /* JADX INFO: renamed from: com.google.common.base.MoreObjects$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitEmptyValues;
        private boolean omitNullValues;

        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super(null);
            }

            /* synthetic */ UnconditionalValueHolder(AnonymousClass1 r1) {
                this();
            }
        }

        private static class ValueHolder {

            @CheckForNull
            String name;

            @CheckForNull
            ValueHolder next;

            @CheckForNull
            Object value;

            private ValueHolder() {
            }

            /* synthetic */ ValueHolder(AnonymousClass1 r1) {
                this();
            }
        }

        /* synthetic */ ToStringHelper(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ToStringHelper(String r3) {
            ValueHolder r0 = new ValueHolder(null);
            this.holderHead = r0;
            this.holderTail = r0;
            this.omitNullValues = false;
            this.omitEmptyValues = false;
            this.className = (String) Preconditions.checkNotNull(r3);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String r1, @CheckForNull Object r2) {
            return addHolder(r1, r2);
        }

        public ToStringHelper add(String r1, boolean r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, char r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, double r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, float r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, int r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, long r2) {
            return addUnconditionalHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper addValue(@CheckForNull Object r1) {
            return addHolder(r1);
        }

        public ToStringHelper addValue(boolean r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(char r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(double r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(float r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(int r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(long r1) {
            return addUnconditionalHolder(String.valueOf(r1));
        }

        private static boolean isEmpty(Object r3) {
            if ((r3 instanceof CharSequence) == false) goto L9;
            if (((CharSequence) r3).length() == 0) goto L7;
            return false;
        L7:
            return true;
        L9:
            if ((r3 instanceof Collection) == false) goto L13;
            return ((Collection) r3).isEmpty();
        L13:
            if ((r3 instanceof Map) == false) goto L17;
            return ((Map) r3).isEmpty();
        L17:
            if ((r3 instanceof java.util.Optional) == false) goto L21;
            return !((java.util.Optional) r3).isPresent();
        L21:
            if ((r3 instanceof OptionalInt) == false) goto L25;
            return !((OptionalInt) r3).isPresent();
        L25:
            if ((r3 instanceof OptionalLong) == false) goto L29;
            return !((OptionalLong) r3).isPresent();
        L29:
            if ((r3 instanceof OptionalDouble) == false) goto L33;
            return !((OptionalDouble) r3).isPresent();
        L33:
            if ((r3 instanceof Optional) == false) goto L37;
            return !((Optional) r3).isPresent();
        L37:
            if (r3.getClass().isArray() == true) goto L39;
            return false;
        L39:
            if (Array.getLength(r3) == 0) goto L41;
            return false;
        L41:
            return true;
        }

        public String toString() {
            boolean r0 = this.omitNullValues;
            boolean r1 = this.omitEmptyValues;
            StringBuilder r2 = new StringBuilder(32).append(this.className).append('{');
            ValueHolder r7 = this.holderHead.next;
            String r3 = "";
        L3:
            if (r7 == null) goto L23;
            Object r4 = r7.value;
            if ((r7 instanceof UnconditionalValueHolder) == true) goto L12;
            if (r4 != null) goto L9;
            if (r0 == false) goto L12;
        L21:
            r7 = r7.next;
            goto L3
        L9:
            if (r1 == false) goto L12;
            if (isEmpty(r4) == true) goto L21;
        L12:
            r2.append(r3);
            if (r7.name == null) goto L15;
            r2.append(r7.name).append('=');
        L15:
            if (r4 != null) goto L17;
        L19:
            r2.append(r4);
        L20:
            r3 = ", ";
            goto L21
        L17:
            if (r4.getClass().isArray() == false) goto L19;
            String r5 = Arrays.deepToString(new Object[]{r4});
            r2.append(r5, 1, r5.length() - 1);
            goto L20
        L23:
            return r2.append('}').toString();
        }

        private ValueHolder addHolder() {
            ValueHolder r0 = new ValueHolder(null);
            this.holderTail.next = r0;
            this.holderTail = r0;
            return r0;
        }

        private ToStringHelper addHolder(@CheckForNull Object r2) {
            addHolder().value = r2;
            return this;
        }

        private ToStringHelper addHolder(String r2, @CheckForNull Object r3) {
            ValueHolder r0 = addHolder();
            r0.value = r3;
            r0.name = (String) Preconditions.checkNotNull(r2);
            return this;
        }

        private UnconditionalValueHolder addUnconditionalHolder() {
            UnconditionalValueHolder r0 = new UnconditionalValueHolder(null);
            this.holderTail.next = r0;
            this.holderTail = r0;
            return r0;
        }

        private ToStringHelper addUnconditionalHolder(Object r2) {
            addUnconditionalHolder().value = r2;
            return this;
        }

        private ToStringHelper addUnconditionalHolder(String r2, Object r3) {
            UnconditionalValueHolder r0 = addUnconditionalHolder();
            r0.value = r3;
            r0.name = (String) Preconditions.checkNotNull(r2);
            return this;
        }
    }

    public static <T> T firstNonNull(@CheckForNull T r0, T r1) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        if (r1 == null) goto L7;
        return r1;
    L7:
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object r2) {
        return new ToStringHelper(r2.getClass().getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(Class<?> r2) {
        return new ToStringHelper(r2.getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(String r2) {
        return new ToStringHelper(r2, null);
    }

    private MoreObjects() {
    }
}
