package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = null;

    interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> r1);
    }

    static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = null;
        static final String CLASS_VALUE_VALIDATOR_NAME = null;

        static final enum ClassValueValidator extends Enum<ClassValueValidator> implements GetCheckedTypeValidator {
            private static final /* synthetic */ ClassValueValidator[] $VALUES = null;
            public static final ClassValueValidator INSTANCE = null;
            private static final ClassValue<Boolean> isValidClass = null;

            private static /* synthetic */ ClassValueValidator[] $values() {
                return new ClassValueValidator[]{INSTANCE};
            }

            public static ClassValueValidator valueOf(String r1) {
                return (ClassValueValidator) Enum.valueOf(ClassValueValidator.class, r1);
            }

            public static ClassValueValidator[] values() {
                return (ClassValueValidator[]) $VALUES.clone();
            }

            private ClassValueValidator(String r1, int r2) {
                super(r1, r2);
            }

            static {
                INSTANCE = new ClassValueValidator("INSTANCE", 0);
                $VALUES = $values();
                isValidClass = new AnonymousClass1();
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> r1) {
                isValidClass.get(r1);
            }
        }

        static final enum WeakSetValidator extends Enum<WeakSetValidator> implements GetCheckedTypeValidator {
            private static final /* synthetic */ WeakSetValidator[] $VALUES = null;
            public static final WeakSetValidator INSTANCE = null;
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            private static /* synthetic */ WeakSetValidator[] $values() {
                return new WeakSetValidator[]{INSTANCE};
            }

            private WeakSetValidator(String r1, int r2) {
                super(r1, r2);
            }

            public static WeakSetValidator valueOf(String r1) {
                return (WeakSetValidator) Enum.valueOf(WeakSetValidator.class, r1);
            }

            public static WeakSetValidator[] values() {
                return (WeakSetValidator[]) $VALUES.clone();
            }

            static {
                INSTANCE = new WeakSetValidator("INSTANCE", 0);
                $VALUES = $values();
                validClasses = new CopyOnWriteArraySet();
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> r3) {
                Iterator<WeakReference<Class<? extends Exception>>> r2 = validClasses.iterator();
            L4:
                if (r2.hasNext() == false) goto L8;
                if (r3.equals(r2.next().get()) == false) goto L4;
                return;
            L8:
                FuturesGetChecked.checkExceptionClassValidity(r3);
                Set<WeakReference<Class<? extends Exception>>> r4 = validClasses;
                if (r4.size() <= 1000) goto L11;
                r4.clear();
            L11:
                r4.add(new WeakReference(r3));
            }
        }

        GetCheckedTypeValidatorHolder() {
        }

        static {
            CLASS_VALUE_VALIDATOR_NAME = String.valueOf(GetCheckedTypeValidatorHolder.class.getName()).concat("$ClassValueValidator");
            BEST_VALIDATOR = getBestValidator();
        }

        static GetCheckedTypeValidator getBestValidator() {
            return (GetCheckedTypeValidator) ((Enum[]) Class.forName(CLASS_VALUE_VALIDATOR_NAME).asSubclass(Enum.class).getEnumConstants())[0];
        L5:
            return FuturesGetChecked.weakSetValidator();
        }
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(Future<V> r1, Class<X> r2) throws Exception {
        return (V) getChecked(bestGetCheckedTypeValidator(), r1, r2);
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(GetCheckedTypeValidator r0, Future<V> r1, Class<X> r2) throws Exception {
        r0.validateClass(r2);
        return r1.get();
    L8:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r2, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r2);
        throw new AssertionError();
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(Future<V> r1, Class<X> r2, long r3, TimeUnit r5) throws Exception {
        bestGetCheckedTypeValidator().validateClass(r2);
        return r1.get(r3, r5);
    L11:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r2, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r2);
        throw new AssertionError();
    L8:
        e = move-exception;
        throw newWithCause(r2, e);
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    static GetCheckedTypeValidator classValueValidator() {
        return GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable r1, Class<X> r2) throws Exception {
        if ((r1 instanceof Error) == true) goto L11;
        if ((r1 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r1);
    L9:
        throw newWithCause(r2, r1);
    L11:
        throw new ExecutionError((Error) r1);
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> r1) {
        newWithCause(r1, new Exception());     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    private static <X extends Exception> X newWithCause(Class<X> r3, Throwable r4) {
        Iterator r0 = preferringStrings(Arrays.asList(r3.getConstructors())).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        X r1 = (X) newFromConstructor((Constructor) r0.next(), r4);
        if (r1 == null) goto L4;
        if (r1.getCause() != null) goto L10;
        r1.initCause(r4);
    L10:
        return r1;
    L11:
        String r5 = String.valueOf(r3);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r5).length() + 82).append("No appropriate constructor for exception of type ").append(r5).append(" in response to chained exception").toString(), r4);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> r1) {
        return (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(r1);
    }

    static {
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new AnonymousClass1()).reverse();
    }

    @CheckForNull
    private static <X> X newFromConstructor(Constructor<X> r6, Throwable r7) {
        Class<?>[] r0 = r6.getParameterTypes();
        Object[] r1 = new Object[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L16;
        Class<?> r3 = r0[r2];
        if (r3.equals(String.class) == false) goto L9;
        r1[r2] = r7.toString();
    L11:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r3.equals(Throwable.class) == false) goto L12;
        r1[r2] = r7;
        goto L11
    L12:
        return null;
    L16:
        return r6.newInstance(r1);
    L15:
        return null;
    }

    static boolean isCheckedException(Class<? extends Exception> r1) {
        return !RuntimeException.class.isAssignableFrom(r1);
    }

    static void checkExceptionClassValidity(Class<? extends Exception> r2) {
        Preconditions.checkArgument(isCheckedException(r2), "Futures.getChecked exception type (%s) must not be a RuntimeException", r2);
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(r2), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", r2);
    }

    private FuturesGetChecked() {
    }
}
