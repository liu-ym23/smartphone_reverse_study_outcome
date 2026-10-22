package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Timer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimersKt {

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: Timer.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super TimerTask, Unit> r1) {
            this.$action = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$action.invoke(this);
        }
    }

    private static final TimerTask schedule(Timer r1, long r2, Function1<? super TimerTask, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r4);
        r1.schedule(r0, r2);
        return r0;
    }

    private static final TimerTask schedule(Timer r1, Date r2, Function1<? super TimerTask, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "time");
        Intrinsics.checkNotNullParameter(r3, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r3);
        r1.schedule(r0, r2);
        return r0;
    }

    private static final TimerTask schedule(Timer r7, long r8, long r10, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r12);
        r7.schedule(r0, r8, r10);
        return r0;
    }

    private static final TimerTask schedule(Timer r1, Date r2, long r3, Function1<? super TimerTask, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "time");
        Intrinsics.checkNotNullParameter(r5, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r5);
        r1.schedule(r0, r2, r3);
        return r0;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r7, long r8, long r10, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r12);
        r7.scheduleAtFixedRate(r0, r8, r10);
        return r0;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r1, Date r2, long r3, Function1<? super TimerTask, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "time");
        Intrinsics.checkNotNullParameter(r5, "action");
        AnonymousClass1 r0 = new AnonymousClass1(r5);
        r1.scheduleAtFixedRate(r0, r2, r3);
        return r0;
    }

    public static final Timer timer(String r1, boolean r2) {
        if (r1 != null) goto L5;
        return new Timer(r2);
    L5:
        return new Timer(r1, r2);
    }

    static /* synthetic */ Timer timer$default(String r6, boolean r7, long r8, long r10, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r7 = false;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r8 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r12, "action");
        Timer r9 = timer(r6, r7);
        AnonymousClass1 r1 = new AnonymousClass1(r12);
        r9.schedule(r1, r8, r10);
        return r9;
    }

    private static final Timer timer(String r7, boolean r8, long r9, long r11, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r10 = timer(r7, r8);
        r10.schedule(new AnonymousClass1(r13), r9, r11);
        return r10;
    }

    static /* synthetic */ Timer timer$default(String r0, boolean r1, Date r2, long r3, Function1 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r0 = null;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r1 = false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "startAt");
        Intrinsics.checkNotNullParameter(r5, "action");
        Timer r4 = timer(r0, r1);
        r4.schedule(new AnonymousClass1(r5), r2, r3);
        return r4;
    }

    private static final Timer timer(String r1, boolean r2, Date r3, long r4, Function1<? super TimerTask, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "startAt");
        Intrinsics.checkNotNullParameter(r6, "action");
        Timer r5 = timer(r1, r2);
        r5.schedule(new AnonymousClass1(r6), r3, r4);
        return r5;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r6, boolean r7, long r8, long r10, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r7 = false;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r8 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r12, "action");
        Timer r9 = timer(r6, r7);
        AnonymousClass1 r1 = new AnonymousClass1(r12);
        r9.scheduleAtFixedRate(r1, r8, r10);
        return r9;
    }

    private static final Timer fixedRateTimer(String r7, boolean r8, long r9, long r11, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r10 = timer(r7, r8);
        r10.scheduleAtFixedRate(new AnonymousClass1(r13), r9, r11);
        return r10;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r0, boolean r1, Date r2, long r3, Function1 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r0 = null;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r1 = false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "startAt");
        Intrinsics.checkNotNullParameter(r5, "action");
        Timer r4 = timer(r0, r1);
        r4.scheduleAtFixedRate(new AnonymousClass1(r5), r2, r3);
        return r4;
    }

    private static final Timer fixedRateTimer(String r1, boolean r2, Date r3, long r4, Function1<? super TimerTask, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "startAt");
        Intrinsics.checkNotNullParameter(r6, "action");
        Timer r5 = timer(r1, r2);
        r5.scheduleAtFixedRate(new AnonymousClass1(r6), r3, r4);
        return r5;
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        return new AnonymousClass1(r1);
    }
}
