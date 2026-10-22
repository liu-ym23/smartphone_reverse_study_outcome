package com.google.common.base;

import android.icu.text.DateFormat;
import androidx.slice.core.SliceHints;
import com.android.settings.utils.HanziToPinyin;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Stopwatch {
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;

    /* JADX INFO: renamed from: com.google.common.base.Stopwatch$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit = null;

        static {
            int[] r0 = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = r0;
            r0[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    public static Stopwatch createUnstarted(Ticker r1) {
        return new Stopwatch(r1);
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    public static Stopwatch createStarted(Ticker r1) {
        return new Stopwatch(r1).start();
    }

    Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }

    Stopwatch(Ticker r2) {
        this.ticker = (Ticker) Preconditions.checkNotNull(r2, "ticker");
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    public Stopwatch stop() {
        long r0 = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += r0 - this.startTick;
        return this;
    }

    public Stopwatch reset() {
        this.elapsedNanos = 0;
        this.isRunning = false;
        return this;
    }

    private long elapsedNanos() {
        if (this.isRunning == false) goto L6;
        return (this.ticker.read() - this.startTick) + this.elapsedNanos;
    L6:
        return this.elapsedNanos;
    }

    public long elapsed(TimeUnit r3) {
        return r3.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    public Duration elapsed() {
        return Duration.ofNanos(elapsedNanos());
    }

    public String toString() {
        long r0 = elapsedNanos();
        TimeUnit r5 = chooseUnit(r0);
        String r1 = Platform.formatCompact4Digits(r0 / TimeUnit.NANOSECONDS.convert(1, r5));
        String r6 = abbreviate(r5);
        return new StringBuilder((String.valueOf(r1).length() + 1) + String.valueOf(r6).length()).append(r1).append(HanziToPinyin.Token.SEPARATOR).append(r6).toString();
    }

    private static TimeUnit chooseUnit(long r4) {
        if (TimeUnit.DAYS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L7;
        return TimeUnit.DAYS;
    L7:
        if (TimeUnit.HOURS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L11;
        return TimeUnit.HOURS;
    L11:
        if (TimeUnit.MINUTES.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L15;
        return TimeUnit.MINUTES;
    L15:
        if (TimeUnit.SECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L19;
        return TimeUnit.SECONDS;
    L19:
        if (TimeUnit.MILLISECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L23;
        return TimeUnit.MILLISECONDS;
    L23:
        if (TimeUnit.MICROSECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L27;
        return TimeUnit.MICROSECONDS;
    L27:
        return TimeUnit.NANOSECONDS;
    }

    private static String abbreviate(TimeUnit r1) {
        switch(AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[r1.ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "d";
    L8:
        return "h";
    L10:
        return SliceHints.SUBTYPE_MIN;
    L12:
        return DateFormat.SECOND;
    L14:
        return DateFormat.MINUTE_SECOND;
    L16:
        return "μs";
    L18:
        return "ns";
    L5:
        throw new AssertionError();
    }
}
