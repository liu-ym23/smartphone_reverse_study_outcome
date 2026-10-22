package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long r0, int r2) {
        return durationOf(r0, r2);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r0) {
        return durationOfMillis(r0);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r0) {
        return durationOfMillisNormalized(r0);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r0) {
        return durationOfNanos(r0);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r0) {
        return durationOfNanosNormalized(r0);
    }

    public static final /* synthetic */ long access$millisToNanos(long r0) {
        return millisToNanos(r0);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r0) {
        return nanosToMillis(r0);
    }

    public static final /* synthetic */ long access$parseDuration(String r0, boolean r1) {
        return parseDuration(r0, r1);
    }

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(long r0) {
    }

    private static final long millisToNanos(long r2) {
        return r2 * ((long) 1000000);
    }

    public static final long toDuration(int r2, DurationUnit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        if (r3.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r2, r3, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r2, r3);
    }

    public static final long toDuration(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        long r0 = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, r9);
        if (new LongRange(-r0, r0).contains(r7) == false) goto L7;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r7, r9, DurationUnit.NANOSECONDS));
    L7:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    public static final long toDuration(double r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        double r0 = DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.NANOSECONDS);
        if ((!Double.isNaN(r0)) == false) goto L10;
        long r1 = MathKt.roundToLong(r0);
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r1) == false) goto L8;
        return durationOfNanos(r1);
    L8:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS)));
    L10:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long getNanoseconds(int r2) {
        return toDuration(r2, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(double r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final long getMicroseconds(int r2) {
        return toDuration(r2, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(double r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(int r2) {
        return toDuration(r2, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(double r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final long getSeconds(int r2) {
        return toDuration(r2, DurationUnit.SECONDS);
    }

    public static final long getSeconds(long r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final long getSeconds(double r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final long getMinutes(int r2) {
        return toDuration(r2, DurationUnit.MINUTES);
    }

    public static final long getMinutes(long r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final long getMinutes(double r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final long getHours(int r2) {
        return toDuration(r2, DurationUnit.HOURS);
    }

    public static final long getHours(long r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final long getHours(double r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final long getDays(int r2) {
        return toDuration(r2, DurationUnit.DAYS);
    }

    public static final long getDays(long r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    public static final long getDays(double r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m2226timesmvk6XK0(int r0, long r1) {
        return Duration.m2138timesUwyO8pc(r1, r0);
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m2225timeskIfJnKk(double r0, long r2) {
        return Duration.m2137timesUwyO8pc(r2, r0);
    }

    private static final long parseDuration(String r26, boolean r27) {
        int r7 = r26.length();
        if (r7 == 0) goto L157;
        long r8 = Duration.Companion.m2202getZEROUwyO8pc();
        char r0 = r26.charAt(0);
        boolean r11 = true;
        if (r0 != '+') goto L7;
    L6:
        int r12 = 1;
    L10:
        if (r12 <= 0) goto L12;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L16;
    L18:
        boolean r15 = false;
    L20:
        if (r7 <= r12) goto L155;
        char r1 = r26.charAt(r12);
        char r10 = DeepCleanSAFEngine.DetailPath.KEY;
        if (r1 != 'P') goto L78;
        int r14 = r12 + 1;
        if (r14 == r7) goto L77;
        boolean r2 = false;
        DurationUnit r3 = null;
    L26:
        if (r14 >= r7) goto L75;
        if (r26.charAt(r14) == 'T') goto L29;
        int r4 = r14;
    L37:
        if (r4 >= r26.length()) goto L48;
        char r16 = r26.charAt(r4);
        boolean r18 = r15;
        if (new CharRange(r10, '9').contains(r16) == true) goto L44;
        int r17 = r7;
        if (StringsKt.contains$default("+-.", r16, false, 2, null) == true) goto L45;
        boolean r9 = false;
    L46:
        if (r9 == false) goto L49;
        r4 = r4 + 1;
        r7 = r17;
        r15 = r18;
        r10 = DeepCleanSAFEngine.DetailPath.KEY;
    L49:
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type java.lang.String");
        String r5 = r26.substring(r14, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        String r19 = r5;
        if (r19.length() != 0) goto L52;
        boolean r20 = true;
    L53:
        if (r20 == true) goto L74;
        int r110 = r14 + r5.length();
        String r21 = r26;
        if (r110 < 0) goto L72;
        if (r110 > StringsKt.getLastIndex(r21)) goto L72;
        char r22 = r21.charAt(r110);
        r14 = r110 + 1;
        DurationUnit r23 = DurationUnitKt.durationUnitByIsoChar(r22, r2);
        if (r3 != null) goto L61;
    L65:
        int r6 = StringsKt.indexOf$default(r19, '.', 0, false, 6, null);
        if (r23 != DurationUnit.SECONDS) goto L69;
        if (r6 <= 0) goto L69;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r111 = r5.substring(0, r6);
        Intrinsics.checkNotNullExpressionValue(r111, "this as java.lang.String…ing(startIndex, endIndex)");
        long r24 = Duration.m2136plusLRDsOJo(r8, toDuration(parseOverLongIsoComponent(r111), r23));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r25 = r5.substring(r6);
        Intrinsics.checkNotNullExpressionValue(r25, "this as java.lang.String).substring(startIndex)");
        r8 = Duration.m2136plusLRDsOJo(r24, toDuration(Double.parseDouble(r25), r23));
    L70:
        r3 = r23;
        r7 = r17;
        r15 = r18;
        r10 = DeepCleanSAFEngine.DetailPath.KEY;
        r11 = true;
    L69:
        r8 = Duration.m2136plusLRDsOJo(r8, toDuration(parseOverLongIsoComponent(r5), r23));
        goto L70
    L61:
        if (r3.compareTo(r23) > 0) goto L65;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L72:
        throw new IllegalArgumentException("Missing unit for value " + r5);
    L74:
        throw new IllegalArgumentException();
    L52:
        r20 = false;
    L45:
        r9 = true;
        goto L46
    L44:
        r17 = r7;
        goto L45
    L48:
        r17 = r7;
        r18 = r15;
        goto L49
    L29:
        if (r2 == true) goto L34;
        r14 = r14 + 1;
        if (r14 == r7) goto L34;
        r2 = r11;
    L34:
        throw new IllegalArgumentException();
    L75:
        boolean r112 = r15;
    L149:
        if (r112 == true) goto L151;
        return r8;
    L151:
        return Duration.m2152unaryMinusUwyO8pc(r8);
    L77:
        throw new IllegalArgumentException();
    L78:
        r112 = r15;
        if (r27 == true) goto L153;
        String r28 = "this as java.lang.String).substring(startIndex)";
        if (StringsKt.regionMatches(r26, r12, "Infinity", 0, Math.max(r7 - r12, 8), true) == false) goto L83;
        r8 = Duration.Companion.m2200getINFINITEUwyO8pc();
        goto L149
    L83:
        boolean r29 = !r13;
        if (r13 == true) goto L86;
    L94:
        int r30 = r7;
    L95:
        boolean r31 = false;
        DurationUnit r32 = null;
    L96:
        if (r12 >= r30) goto L149;
        if (r31 == false) goto L107;
        if (r29 == false) goto L107;
    L100:
        if (r12 >= r26.length()) goto L107;
        if (r26.charAt(r12) != ' ') goto L104;
        boolean r33 = true;
    L105:
        if (r33 == false) goto L107;
        r12 = r12 + 1;
        goto L100
    L104:
        r33 = false;
    L107:
        int r34 = r12;
    L109:
        if (r34 >= r26.length()) goto L120;
        char r35 = r26.charAt(r34);
        if (new CharRange(DeepCleanSAFEngine.DetailPath.KEY, '9').contains(r35) == false) goto L113;
    L116:
        boolean r36 = true;
    L117:
        if (r36 == false) goto L120;
        r34 = r34 + 1;
        goto L109
    L113:
        if (r35 == '.') goto L116;
        r36 = false;
    L120:
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type java.lang.String");
        String r37 = r26.substring(r12, r34);
        Intrinsics.checkNotNullExpressionValue(r37, "this as java.lang.String…ing(startIndex, endIndex)");
        String r113 = r37;
        if (r113.length() != 0) goto L123;
        boolean r38 = true;
    L124:
        if (r38 == true) goto L148;
        int r114 = r12 + r37.length();
        int r39 = r114;
    L127:
        if (r39 >= r26.length()) goto L131;
        if (new CharRange('a', 'z').contains(r26.charAt(r39)) == false) goto L131;
        r39 = r39 + 1;
    L131:
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type java.lang.String");
        String r40 = r26.substring(r114, r39);
        Intrinsics.checkNotNullExpressionValue(r40, "this as java.lang.String…ing(startIndex, endIndex)");
        r12 = r114 + r40.length();
        DurationUnit r41 = DurationUnitKt.durationUnitByShortName(r40);
        if (r32 != null) goto L134;
    L138:
        int r42 = StringsKt.indexOf$default(r113, '.', 0, false, 6, null);
        if (r42 <= 0) goto L145;
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type java.lang.String");
        String r115 = r37.substring(0, r42);
        Intrinsics.checkNotNullExpressionValue(r115, "this as java.lang.String…ing(startIndex, endIndex)");
        long r43 = Duration.m2136plusLRDsOJo(r8, toDuration(Long.parseLong(r115), r41));
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type java.lang.String");
        String r44 = r37.substring(r42);
        String r45 = r28;
        Intrinsics.checkNotNullExpressionValue(r44, r45);
        r8 = Duration.m2136plusLRDsOJo(r43, toDuration(Double.parseDouble(r44), r41));
        if (r12 < r30) goto L144;
        r28 = r45;
    L146:
        r32 = r41;
        r31 = true;
        goto L96
    L144:
        throw new IllegalArgumentException("Fractional component must be last");
    L145:
        r8 = Duration.m2136plusLRDsOJo(r8, toDuration(Long.parseLong(r37), r41));
        goto L146
    L134:
        if (r32.compareTo(r41) > 0) goto L138;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L148:
        throw new IllegalArgumentException();
    L123:
        r38 = false;
        goto L124
    L86:
        if (r26.charAt(r12) != '(') goto L94;
        if (StringsKt.last(r26) != ')') goto L94;
        r12 = r12 + 1;
        int r46 = r7 - 1;
        if (r12 == r46) goto L93;
        r30 = r46;
        r29 = true;
        goto L95
    L93:
        throw new IllegalArgumentException("No components");
    L153:
        throw new IllegalArgumentException();
    L155:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default(r26, '-', false, 2, null) == false) goto L18;
        r15 = true;
        goto L20
    L12:
        r13 = false;
        goto L14
    L7:
        if (r0 == '-') goto L6;
        r12 = 0;
        goto L10
    L157:
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String r9) {
        int r0 = r9.length();
        if (r0 > 0) goto L5;
    L7:
        int r5 = 0;
    L9:
        if ((r0 - r5) <= 16) goto L28;
        Iterable r1 = new IntRange(r5, StringsKt.getLastIndex(r9));
        if ((r1 instanceof Collection) == true) goto L13;
    L15:
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L14;
        if (new CharRange(DeepCleanSAFEngine.DetailPath.KEY, '9').contains(r9.charAt(((IntIterator) r2).nextInt())) == true) goto L17;
        boolean r3 = false;
    L21:
        if (r3 == false) goto L28;
        if (r9.charAt(0) != '-') goto L25;
        return Long.MIN_VALUE;
    L25:
        return Long.MAX_VALUE;
    L14:
        r3 = true;
        goto L21
    L13:
        if (((Collection) r1).isEmpty() == false) goto L15;
    L28:
        if (StringsKt.startsWith$default(r9, "+", false, 2, null) == false) goto L31;
        r9 = StringsKt.drop(r9, 1);
    L31:
        return Long.parseLong(r9);
    L5:
        if (StringsKt.contains$default("+-", r9.charAt(0), false, 2, null) == false) goto L7;
        r5 = 1;
        goto L9
    }

    private static final int skipWhile(String r1, int r2, Function1<? super Character, Boolean> r3) {
    L3:
        if (r2 >= r1.length()) goto L7;
        if (r3.invoke(Character.valueOf(r1.charAt(r2))).booleanValue() == false) goto L7;
        r2 = r2 + 1;
    L7:
        return r2;
    }

    private static final long nanosToMillis(long r2) {
        return r2 / ((long) 1000000);
    }

    private static final long durationOfNanos(long r1) {
        return Duration.m2100constructorimpl(r1 << 1);
    }

    private static final long durationOfMillis(long r2) {
        return Duration.m2100constructorimpl((r2 << 1) + 1);
    }

    private static final long durationOf(long r2, int r4) {
        return Duration.m2100constructorimpl((r2 << 1) + ((long) r4));
    }

    private static final long durationOfNanosNormalized(long r5) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r5) == false) goto L6;
        return durationOfNanos(r5);
    L6:
        return durationOfMillis(nanosToMillis(r5));
    }

    private static final long durationOfMillisNormalized(long r6) {
        if (new LongRange(-4611686018426L, MAX_NANOS_IN_MILLIS).contains(r6) == false) goto L6;
        return durationOfNanos(millisToNanos(r6));
    L6:
        return durationOfMillis(RangesKt.coerceIn(r6, -4611686018427387903L, MAX_MILLIS));
    }

    private static final String substringWhile(String r2, int r3, Function1<? super Character, Boolean> r4) {
        int r0 = r3;
    L4:
        if (r0 >= r2.length()) goto L8;
        if (r4.invoke(Character.valueOf(r2.charAt(r0))).booleanValue() == false) goto L8;
        r0 = r0 + 1;
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r5 = r2.substring(r3, r0);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        return r5;
    }
}
