package io.reactivex.observers;

import a.a;
import com.bytedance.apm.constant.PerfConsts;
import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected final CountDownLatch done;
    protected final List<Throwable> errors;
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values;

    /* JADX INFO: renamed from: io.reactivex.observers.BaseTestConsumer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum TestWaitStrategy extends Enum<TestWaitStrategy> implements Runnable {
        private static final /* synthetic */ TestWaitStrategy[] $VALUES = null;
        public static final TestWaitStrategy SLEEP_1000MS = null;
        public static final TestWaitStrategy SLEEP_100MS = null;
        public static final TestWaitStrategy SLEEP_10MS = null;
        public static final TestWaitStrategy SLEEP_1MS = null;
        public static final TestWaitStrategy SPIN = null;
        public static final TestWaitStrategy YIELD = null;

        static {
            final String r1 = "SPIN";
            final int r2 = 0;
            TestWaitStrategy r0 = new AnonymousClass1(r1, r2);
            SPIN = r0;
            final String r3 = "YIELD";
            final int r4 = 1;
            TestWaitStrategy r5 = new AnonymousClass2(r3, r4);
            YIELD = r5;
            final String r6 = "SLEEP_1MS";
            final int r7 = 2;
            TestWaitStrategy r8 = new AnonymousClass3(r6, r7);
            SLEEP_1MS = r8;
            final String r9 = "SLEEP_10MS";
            final int r10 = 3;
            TestWaitStrategy r11 = new AnonymousClass4(r9, r10);
            SLEEP_10MS = r11;
            final String r12 = "SLEEP_100MS";
            final int r13 = 4;
            TestWaitStrategy r14 = new AnonymousClass5(r12, r13);
            SLEEP_100MS = r14;
            final String r15 = "SLEEP_1000MS";
            final int r16 = 5;
            TestWaitStrategy r17 = new AnonymousClass6(r15, r16);
            SLEEP_1000MS = r17;
            $VALUES = new TestWaitStrategy[]{r0, r5, r8, r11, r14, r17};
        }

        private TestWaitStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static void sleep(int r2) {
            Thread.sleep(r2);     // Catch: InterruptedException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public static TestWaitStrategy valueOf(String r1) {
            return (TestWaitStrategy) Enum.valueOf(TestWaitStrategy.class, r1);
        }

        public static TestWaitStrategy[] values() {
            return (TestWaitStrategy[]) $VALUES.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();

        public /* synthetic */ TestWaitStrategy(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }
    }

    public BaseTestConsumer() {
        this.values = new VolatileSizeArrayList();
        this.errors = new VolatileSizeArrayList();
        this.done = new CountDownLatch(1);
    }

    public static String valueAndClass(Object r2) {
        if (r2 != null) goto L4;
        return "null";
    L4:
        return r2 + " (class: " + r2.getClass().getSimpleName() + ")";
    }

    public final U assertComplete() {
        long r0 = this.completions;
        if (r0 == 0) goto L10;
        if (r0 > 1) goto L8;
        return this;
    L8:
        throw fail("Multiple completions: " + r0);
    L10:
        throw fail("Not completed");
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Throwable r1) {
        return (U) assertError(Functions.equalsWith(r1));
    }

    public final U assertErrorMessage(String r4) {
        int r0 = this.errors.size();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L12;
        String r1 = this.errors.get(0).getMessage();
        if (ObjectHelper.equals(r4, r1) == false) goto L10;
        return this;
    L10:
        throw fail("Error message differs; exptected: " + r4 + " but was: " + r1);
    L12:
        throw fail("Multiple errors");
    L14:
        throw fail("No errors");
    }

    public final U assertFailure(Class<? extends Throwable> r1, T... r2) {
        return (U) assertSubscribed().assertValues(r2).assertError(r1).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> r1, String r2, T... r3) {
        return (U) assertSubscribed().assertValues(r3).assertError(r1).assertErrorMessage(r2).assertNotComplete();
    }

    public final U assertNever(T r4) {
        int r0 = this.values.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (ObjectHelper.equals(this.values.get(r1), r4) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        StringBuilder r2 = a.p(r1, "Value at position ", " is equal to ");
        r2.append(valueAndClass(r4));
        r2.append("; Expected them to be different");
        throw fail(r2.toString());
    L9:
        return this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() != 0) goto L6;
        return this;
    L6:
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertNoTimeout() {
        if (this.timeout == true) goto L6;
        return this;
    L6:
        throw fail("Timeout?!");
    }

    public final U assertNoValues() {
        return (U) assertValueCount(0);
    }

    public final U assertNotComplete() {
        long r0 = this.completions;
        if (r0 == 1) goto L9;
        if (r0 > 1) goto L7;
        return this;
    L7:
        throw fail("Multiple completions: " + r0);
    L9:
        throw fail("Completed!");
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() == 0) goto L6;
        return this;
    L6:
        throw fail("Subscriber terminated!");
    }

    public final U assertResult(T... r1) {
        return (U) assertSubscribed().assertValues(r1).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() != 0) goto L20;
        long r0 = this.completions;
        if (r0 > 1) goto L18;
        int r4 = this.errors.size();
        if (r4 > 1) goto L16;
        if (r0 == 0) goto L14;
        if (r4 == 0) goto L14;
        throw fail("Terminated with multiple completions and errors: " + r0);
    L14:
        return this;
    L16:
        throw fail("Terminated with multiple errors: " + r4);
    L18:
        throw fail("Terminated with multiple completions: " + r0);
    L20:
        throw fail("Subscriber still running!");
    }

    public final U assertTimeout() {
        if (this.timeout == false) goto L6;
        return this;
    L6:
        throw fail("No timeout?!");
    }

    public final U assertValue(T r5) {
        if (this.values.size() != 1) goto L10;
        T r0 = this.values.get(0);
        if (ObjectHelper.equals(r5, r0) == false) goto L8;
        return this;
    L8:
        throw fail("expected: " + valueAndClass(r5) + " but was: " + valueAndClass(r0));
    L10:
        throw fail("expected: " + valueAndClass(r5) + " but was: " + this.values);
    }

    public final U assertValueAt(int r3, T r4) {
        int r0 = this.values.size();
        if (r0 == 0) goto L13;
        if (r3 >= r0) goto L11;
        T r5 = this.values.get(r3);
        if (ObjectHelper.equals(r4, r5) == false) goto L9;
        return this;
    L9:
        throw fail("expected: " + valueAndClass(r4) + " but was: " + valueAndClass(r5));
    L11:
        throw fail("Invalid index: " + r3);
    L13:
        throw fail("No values");
    }

    public final U assertValueCount(int r4) {
        int r0 = this.values.size();
        if (r0 != r4) goto L6;
        return this;
    L6:
        throw fail("Value counts differ; expected: " + r4 + " but was: " + r0);
    }

    public final U assertValueSequence(Iterable<? extends T> r6) {
        Iterator<T> r0 = this.values.iterator();
        Iterator<? extends T> r7 = r6.iterator();
        int r1 = 0;
    L3:
        boolean r2 = r7.hasNext();
        boolean r3 = r0.hasNext();
        if (r3 == false) goto L13;
        if (r2 == false) goto L13;
        T r4 = r7.next();
        T r5 = r0.next();
        if (ObjectHelper.equals(r4, r5) == false) goto L10;
        r1 = r1 + 1;
        goto L3
    L10:
        StringBuilder r8 = a.p(r1, "Values at position ", " differ; expected: ");
        r8.append(valueAndClass(r4));
        r8.append(" but was: ");
        r8.append(valueAndClass(r5));
        throw fail(r8.toString());
    L13:
        if (r3 == true) goto L19;
        if (r2 == true) goto L17;
        return this;
    L17:
        throw fail("Fewer values received than expected (" + r1 + ")");
    L19:
        throw fail("More values received than expected (" + r1 + ")");
    }

    public final U assertValueSequenceOnly(Iterable<? extends T> r1) {
        return (U) assertSubscribed().assertValueSequence(r1).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> r4) {
        if (r4.isEmpty() == false) goto L6;
        assertNoValues();
        return this;
    L6:
        Iterator<T> r0 = this.values.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        T r1 = r0.next();
        if (r4.contains(r1) == true) goto L8;
        throw fail("Value not in the expected collection: " + valueAndClass(r1));
    L14:
        return this;
    }

    public final U assertValueSetOnly(Collection<? extends T> r1) {
        return (U) assertSubscribed().assertValueSet(r1).assertNoErrors().assertNotComplete();
    }

    public final U assertValues(T... r7) {
        int r0 = this.values.size();
        if (r0 != r7.length) goto L13;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L11;
        T r3 = this.values.get(r1);
        T r4 = r7[r1];
        if (ObjectHelper.equals(r4, r3) == false) goto L9;
        r1 = r1 + 1;
        goto L5
    L9:
        StringBuilder r8 = a.p(r1, "Values at position ", " differ; expected: ");
        r8.append(valueAndClass(r4));
        r8.append(" but was: ");
        r8.append(valueAndClass(r3));
        throw fail(r8.toString());
    L11:
        return this;
    L13:
        throw fail("Value count differs; expected: " + r7.length + " " + Arrays.toString(r7) + " but was: " + r0 + " " + this.values);
    }

    public final U assertValuesOnly(T... r1) {
        return (U) assertSubscribed().assertValues(r1).assertNoErrors().assertNotComplete();
    }

    public final U await() {
        if (this.done.getCount() != 0) goto L5;
        return this;
    L5:
        this.done.await();
        return this;
    }

    public final U awaitCount(int r4) {
        return (U) awaitCount(r4, TestWaitStrategy.SLEEP_10MS, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
    }

    public final U awaitDone(long r2, TimeUnit r4) {
    L6:
        e = move-exception;
        dispose();
        throw ExceptionHelper.wrapOrThrow(e);
    L3:
        if (this.done.await(r2, r4) == true) goto L8;
        this.timeout = true;     // Catch: InterruptedException -> L6
        dispose();     // Catch: InterruptedException -> L6
    L8:
        return this;
    }

    public final boolean awaitTerminalEvent() {
        await();     // Catch: InterruptedException -> L5
        return true;
    L5:
        Thread.currentThread().interrupt();
        return false;
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    public final AssertionError fail(String r4) {
        StringBuilder r0 = new StringBuilder(r4.length() + 64);
        r0.append(r4);
        r0.append(" (latch = ");
        r0.append(this.done.getCount());
        r0.append(", values = ");
        r0.append(this.values.size());
        r0.append(", errors = ");
        r0.append(this.errors.size());
        r0.append(", completions = ");
        r0.append(this.completions);
        if (this.timeout == false) goto L6;
        r0.append(", timeout!");
    L6:
        if (isDisposed() == false) goto L8;
        r0.append(", disposed!");
    L8:
        CharSequence r5 = this.tag;
        if (r5 == null) goto L11;
        r0.append(", tag = ");
        r0.append(r5);
    L11:
        r0.append(')');
        AssertionError r6 = new AssertionError(r0.toString());
        if (this.errors.isEmpty() == false) goto L14;
    L17:
        return r6;
    L14:
        if (this.errors.size() != 1) goto L16;
        r6.initCause(this.errors.get(0));
        goto L17
    L16:
        r6.initCause(new CompositeException(this.errors));
        goto L17
    }

    public final List<List<Object>> getEvents() {
        ArrayList r0 = new ArrayList();
        r0.add(values());
        r0.add(errors());
        ArrayList r1 = new ArrayList();
        long r2 = 0;
    L4:
        if (r2 >= this.completions) goto L6;
        r1.add(Notification.createOnComplete());
        r2 = r2 + 1;
        goto L4
    L6:
        r0.add(r1);
        return r0;
    }

    public final boolean isTerminated() {
        if (this.done.getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U withTag(CharSequence r1) {
        this.tag = r1;
        return this;
    }

    public final U assertError(Class<? extends Throwable> r1) {
        return (U) assertError(Functions.isInstanceOf(r1));
    }

    public final U awaitCount(int r3, Runnable r4) {
        return (U) awaitCount(r3, r4, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
    }

    public final U assertError(Predicate<Throwable> r4) {
        int r0 = this.errors.size();
        if (r0 == 0) goto L21;
        Iterator<Throwable> r1 = this.errors.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        if (r4.test(r1.next()) == false) goto L6;
        if (r0 != 1) goto L14;
        return this;
    L14:
        throw fail("Error present but other errors as well");
    L15:
        e = move-exception;
        throw ExceptionHelper.wrapOrThrow(e);
    L19:
        throw fail("Error not present");
    L21:
        throw fail("No errors");
    }

    public final boolean await(long r5, TimeUnit r7) {
        if (this.done.getCount() != 0) goto L5;
    L8:
        boolean r6 = true;
    L9:
        this.timeout = !r6;
        return r6;
    L5:
        if (this.done.await(r5, r7) == true) goto L8;
        r6 = false;
        goto L9
    }

    public final U awaitCount(int r7, Runnable r8, long r9) {
        long r0 = System.currentTimeMillis();
    L4:
        if (r9 <= 0) goto L9;
        if ((System.currentTimeMillis() - r0) < r9) goto L9;
        this.timeout = true;
    L13:
        return this;
    L9:
        if (this.done.getCount() == 0) goto L13;
        if (this.values.size() >= r7) goto L13;
        r8.run();
        goto L4
    }

    public final boolean awaitTerminalEvent(long r1, TimeUnit r3) {
        return await(r1, r3);
    L4:
        Thread.currentThread().interrupt();
        return false;
    }

    public final U assertFailure(Predicate<Throwable> r1, T... r2) {
        return (U) assertSubscribed().assertValues(r2).assertError(r1).assertNotComplete();
    }

    public final U assertValue(Predicate<T> r2) {
        assertValueAt(0, r2);
        if (this.values.size() > 1) goto L6;
        return this;
    L6:
        throw fail("Value present but other values as well");
    }

    public final U assertValueAt(int r2, Predicate<T> r3) {
        if (this.values.size() == 0) goto L17;
        if (r2 >= this.values.size()) goto L15;
        if (r3.test(this.values.get(r2)) == false) goto L10;
        return this;
    L10:
        throw fail("Value not present");
    L11:
        e = move-exception;
        throw ExceptionHelper.wrapOrThrow(e);
    L15:
        throw fail("Invalid index: " + r2);
    L17:
        throw fail("No values");
    }

    public final U assertNever(Predicate<? super T> r4) {
        int r0 = this.values.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
    L10:
        e = move-exception;
        throw ExceptionHelper.wrapOrThrow(e);
    L6:
        if (r4.test(this.values.get(r1)) == true) goto L9;
        r1 = r1 + 1;     // Catch: Exception -> L10
        goto L3
    L9:
        throw fail("Value at position " + r1 + " matches predicate " + r4.toString() + ", which was not expected.");     // Catch: Exception -> L10
    L13:
        return this;
    }
}
