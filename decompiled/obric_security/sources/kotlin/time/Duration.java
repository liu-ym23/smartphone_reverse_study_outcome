package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¤\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¤\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001b\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010jJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0099\u0001\u0010\u0005JK\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\b0\u009c\u0001j\u0003`\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010¡\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006¥\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    /* JADX INFO: compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u001b\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b>J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R%\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R%\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R%\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R%\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R%\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R%\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R%\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R%\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R%\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R%\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R%\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R%\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R%\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2158getDaysUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2159getDaysUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2160getDaysUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2164getHoursUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2165getHoursUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2166getHoursUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2170getMicrosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2171getMicrosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2172getMicrosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2176getMillisecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2177getMillisecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2178getMillisecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2182getMinutesUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2183getMinutesUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2184getMinutesUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2188getNanosecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2189getNanosecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2190getNanosecondsUwyO8pc$annotations(long r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2194getSecondsUwyO8pc$annotations(double r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2195getSecondsUwyO8pc$annotations(int r0) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2196getSecondsUwyO8pc$annotations(long r0) {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m2202getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m2200getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2201getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        public final double convert(double r1, DurationUnit r3, DurationUnit r4) {
            Intrinsics.checkNotNullParameter(r3, "sourceUnit");
            Intrinsics.checkNotNullParameter(r4, "targetUnit");
            return DurationUnitKt.convertDurationUnit(r1, r3, r4);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2186getNanosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2187getNanosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2185getNanosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2168getMicrosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2169getMicrosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m2167getMicrosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2174getMillisecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2175getMillisecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2173getMillisecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2192getSecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2193getSecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2191getSecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2180getMinutesUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2181getMinutesUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2179getMinutesUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2162getHoursUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2163getHoursUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m2161getHoursUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2156getDaysUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2157getDaysUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m2155getDaysUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m2216nanosecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m2217nanosecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m2215nanosecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m2207microsecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m2208microsecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m2206microsecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m2210millisecondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m2211millisecondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m2209millisecondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m2223secondsUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m2224secondsUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m2222secondsUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m2213minutesUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m2214minutesUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m2212minutesUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m2204hoursUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m2205hoursUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m2203hoursUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m2198daysUwyO8pc(int r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m2199daysUwyO8pc(long r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m2197daysUwyO8pc(double r1) {
            return DurationKt.toDuration(r1, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m2218parseUwyO8pc(String r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            return DurationKt.access$parseDuration(r4, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid duration string format: '" + r4 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m2219parseIsoStringUwyO8pc(String r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            return DurationKt.access$parseDuration(r4, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid ISO duration string format: '" + r4 + "'.", e);
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m2221parseOrNullFghU774(String r1) {
            Intrinsics.checkNotNullParameter(r1, "value");
            return Duration.m2098boximpl(DurationKt.access$parseDuration(r1, false));
        L5:
            Duration r2 = (Duration) null;
            return null;
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m2220parseIsoStringOrNullFghU774(String r1) {
            Intrinsics.checkNotNullParameter(r1, "value");
            return Duration.m2098boximpl(DurationKt.access$parseDuration(r1, true));
        L5:
            Duration r2 = (Duration) null;
            return null;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m2098boximpl(long r1) {
        return new Duration(r1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2104equalsimpl(long r4, Object r6) {
        if ((r6 instanceof Duration) == true) goto L6;
        return false;
    L6:
        if (r4 == ((Duration) r6).m2154unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2105equalsimpl0(long r0, long r2) {
        if (r0 != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m2126getUnitDiscriminatorimpl(long r0) {
        return ((int) r0) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m2127getValueimpl(long r1) {
        return r1 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2128hashCodeimpl(long r0) {
        return Long.hashCode(r0);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m2130isInMillisimpl(long r0) {
        if ((((int) r0) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m2131isInNanosimpl(long r0) {
        if ((((int) r0) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m2133isNegativeimpl(long r2) {
        if (r2 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m2134isPositiveimpl(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r3) {
        return m2104equalsimpl(this.rawValue, r3);
    }

    public int hashCode() {
        return m2128hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2154unboximpl() {
        return this.rawValue;
    }

    public static final /* synthetic */ long access$getINFINITE$cp() {
        return INFINITE;
    }

    public static final /* synthetic */ long access$getNEG_INFINITE$cp() {
        return NEG_INFINITE;
    }

    public static final /* synthetic */ long access$getZERO$cp() {
        return ZERO;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r3) {
        return m2153compareToLRDsOJo(r3.m2154unboximpl());
    }

    private /* synthetic */ Duration(long r1) {
        this.rawValue = r1;
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m2125getStorageUnitimpl(long r0) {
        if (m2131isInNanosimpl(r0) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2100constructorimpl(long r5) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == true) goto L5;
    L20:
        return r5;
    L5:
        if (m2131isInNanosimpl(r5) == false) goto L12;
        if (new LongRange(-4611686018426999999L, DurationKt.MAX_NANOS).contains(m2127getValueimpl(r5)) == true) goto L20;
        throw new AssertionError(m2127getValueimpl(r5) + " ns is out of nanoseconds range");
    L12:
        if (new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS).contains(m2127getValueimpl(r5)) == false) goto L19;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(m2127getValueimpl(r5)) == false) goto L20;
        throw new AssertionError(m2127getValueimpl(r5) + " ms is denormalized");
    L19:
        throw new AssertionError(m2127getValueimpl(r5) + " ms is out of milliseconds range");
    }

    static {
        Companion = new Companion(null);
        ZERO = m2100constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m2152unaryMinusUwyO8pc(long r2) {
        return DurationKt.access$durationOf(-m2127getValueimpl(r2), ((int) r2) & 1);
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m2136plusLRDsOJo(long r7, long r9) {
        if (m2132isInfiniteimpl(r7) == false) goto L13;
        if (m2129isFiniteimpl(r9) == false) goto L7;
    L11:
        return r7;
    L7:
        if ((r9 ^ r7) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m2132isInfiniteimpl(r9) == false) goto L16;
        return r9;
    L16:
        if ((((int) r7) & 1) != (((int) r9) & 1)) goto L22;
        long r0 = m2127getValueimpl(r7) + m2127getValueimpl(r9);
        if (m2131isInNanosimpl(r7) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r0);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r0);
    L22:
        if (m2130isInMillisimpl(r7) == false) goto L25;
        return m2096addValuesMixedRangesUwyO8pc(r7, m2127getValueimpl(r7), m2127getValueimpl(r9));
    L25:
        return m2096addValuesMixedRangesUwyO8pc(r7, m2127getValueimpl(r9), m2127getValueimpl(r7));
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m2096addValuesMixedRangesUwyO8pc(long r6, long r8, long r10) {
        long r7 = DurationKt.access$nanosToMillis(r10);
        long r0 = r8 + r7;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(r0) == false) goto L6;
        long r11 = r10 - DurationKt.access$millisToNanos(r7);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + r11);
    L6:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r0, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m2135minusLRDsOJo(long r0, long r2) {
        return m2136plusLRDsOJo(r0, m2152unaryMinusUwyO8pc(r2));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m2138timesUwyO8pc(long r16, int r18) {
        if (m2132isInfiniteimpl(r16) == false) goto L11;
        if (r18 == 0) goto L10;
        if (r18 <= 0) goto L8;
        return r16;
    L8:
        return m2152unaryMinusUwyO8pc(r16);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r18 == 0) goto L13;
        long r1 = m2127getValueimpl(r16);
        long r3 = r18;
        long r5 = r1 * r3;
        if (m2131isInNanosimpl(r16) == false) goto L32;
        if (new LongRange(-2147483647L, 2147483647L).contains(r1) == false) goto L20;
        return DurationKt.access$durationOfNanos(r5);
    L20:
        if ((r5 / r3) == r1) goto L41;
        long r6 = DurationKt.access$nanosToMillis(r1);
        long r14 = r6 * r3;
        long r12 = DurationKt.access$nanosToMillis((r1 - DurationKt.access$millisToNanos(r6)) * r3) + r14;
        if ((r14 / r3) != r6) goto L28;
        if ((r12 ^ r14) < 0) goto L28;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r12, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L28:
        if ((MathKt.getSign(r1) * MathKt.getSign(r18)) <= 0) goto L44;
        return INFINITE;
    L44:
        return NEG_INFINITE;
    L41:
        return DurationKt.access$durationOfNanosNormalized(r5);
    L32:
        if ((r5 / r3) != r1) goto L35;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r5, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    L35:
        if ((MathKt.getSign(r1) * MathKt.getSign(r18)) <= 0) goto L38;
        return INFINITE;
    L38:
        return NEG_INFINITE;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m2137timesUwyO8pc(long r3, double r5) {
        int r0 = MathKt.roundToInt(r5);
        if (r0 != r5) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        DurationUnit r2 = m2125getStorageUnitimpl(r3);
        return DurationKt.toDuration(m2143toDoubleimpl(r3, r2) * r5, r2);
    L8:
        return m2138timesUwyO8pc(r3, r0);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m2103divUwyO8pc(long r8, int r10) {
        if (r10 != 0) goto L13;
        if (m2134isPositiveimpl(r8) == false) goto L7;
        return INFINITE;
    L7:
        if (m2133isNegativeimpl(r8) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m2131isInNanosimpl(r8) == false) goto L17;
        return DurationKt.access$durationOfNanos(m2127getValueimpl(r8) / ((long) r10));
    L17:
        if (m2132isInfiniteimpl(r8) == true) goto L19;
        long r2 = r10;
        long r0 = m2127getValueimpl(r8) / r2;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(r0) == false) goto L25;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r0) + (DurationKt.access$millisToNanos(m2127getValueimpl(r8) - (r0 * r2)) / r2));
    L25:
        return DurationKt.access$durationOfMillis(r0);
    L19:
        return m2138timesUwyO8pc(r8, MathKt.getSign(r10));
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m2102divUwyO8pc(long r3, double r5) {
        int r0 = MathKt.roundToInt(r5);
        if (r0 != r5) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r0 == 0) goto L10;
        return m2103divUwyO8pc(r3, r0);
    L10:
        DurationUnit r2 = m2125getStorageUnitimpl(r3);
        return DurationKt.toDuration(m2143toDoubleimpl(r3, r2) / r5, r2);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m2101divLRDsOJo(long r2, long r4) {
        DurationUnit r0 = (DurationUnit) ComparisonsKt.maxOf(m2125getStorageUnitimpl(r2), m2125getStorageUnitimpl(r4));
        return m2143toDoubleimpl(r2, r0) / m2143toDoubleimpl(r4, r0);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m2132isInfiniteimpl(long r2) {
        if (r2 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r2 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m2129isFiniteimpl(long r0) {
        return !m2132isInfiniteimpl(r0);
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m2106getAbsoluteValueUwyO8pc(long r1) {
        if (m2133isNegativeimpl(r1) == true) goto L5;
        return r1;
    L5:
        return m2152unaryMinusUwyO8pc(r1);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m2153compareToLRDsOJo(long r3) {
        return m2099compareToLRDsOJo(this.rawValue, r3);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m2099compareToLRDsOJo(long r4, long r6) {
        long r0 = r4 ^ r6;
        if (r0 < 0) goto L12;
        if ((((int) r0) & 1) == 0) goto L12;
        int r1 = (((int) r4) & 1) - (((int) r6) & 1);
        if (m2133isNegativeimpl(r4) == true) goto L10;
        return r1;
    L10:
        return -r1;
    L12:
        return Intrinsics.compare(r4, r6);
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2142toComponentsimpl(long r8, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return r10.invoke(Long.valueOf(m2115getInWholeDaysimpl(r8)), Integer.valueOf(m2107getHoursComponentimpl(r8)), Integer.valueOf(m2122getMinutesComponentimpl(r8)), Integer.valueOf(m2124getSecondsComponentimpl(r8)), Integer.valueOf(m2123getNanosecondsComponentimpl(r8)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2141toComponentsimpl(long r3, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        return r5.invoke(Long.valueOf(m2116getInWholeHoursimpl(r3)), Integer.valueOf(m2122getMinutesComponentimpl(r3)), Integer.valueOf(m2124getSecondsComponentimpl(r3)), Integer.valueOf(m2123getNanosecondsComponentimpl(r3)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2140toComponentsimpl(long r2, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        return r4.invoke(Long.valueOf(m2119getInWholeMinutesimpl(r2)), Integer.valueOf(m2124getSecondsComponentimpl(r2)), Integer.valueOf(m2123getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m2139toComponentsimpl(long r2, Function2<? super Long, ? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        return r4.invoke(Long.valueOf(m2121getInWholeSecondsimpl(r2)), Integer.valueOf(m2123getNanosecondsComponentimpl(r2)));
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m2107getHoursComponentimpl(long r2) {
        if (m2132isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2116getInWholeHoursimpl(r2) % ((long) 24));
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m2122getMinutesComponentimpl(long r2) {
        if (m2132isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2119getInWholeMinutesimpl(r2) % ((long) 60));
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m2124getSecondsComponentimpl(long r2) {
        if (m2132isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m2121getInWholeSecondsimpl(r2) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m2123getNanosecondsComponentimpl(long r2) {
        if (m2132isInfiniteimpl(r2) == false) goto L6;
        return 0;
    L6:
        if (m2130isInMillisimpl(r2) == false) goto L8;
        long r3 = DurationKt.access$millisToNanos(m2127getValueimpl(r2) % ((long) 1000));
    L10:
        return (int) r3;
    L8:
        r3 = m2127getValueimpl(r2) % ((long) 1000000000);
        goto L10
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m2143toDoubleimpl(long r2, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        if (r2 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r2 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt.convertDurationUnit(m2127getValueimpl(r2), m2125getStorageUnitimpl(r2), r4);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m2146toLongimpl(long r2, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        if (r2 != INFINITE) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r2 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt.convertDurationUnit(m2127getValueimpl(r2), m2125getStorageUnitimpl(r2), r4);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m2144toIntimpl(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        return (int) RangesKt.coerceIn(m2146toLongimpl(r7, r9), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final double m2108getInDaysimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final double m2109getInHoursimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final double m2112getInMinutesimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final double m2114getInSecondsimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final double m2111getInMillisecondsimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final double m2110getInMicrosecondsimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final double m2113getInNanosecondsimpl(long r1) {
        return m2143toDoubleimpl(r1, DurationUnit.NANOSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m2115getInWholeDaysimpl(long r1) {
        return m2146toLongimpl(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m2116getInWholeHoursimpl(long r1) {
        return m2146toLongimpl(r1, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m2119getInWholeMinutesimpl(long r1) {
        return m2146toLongimpl(r1, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m2121getInWholeSecondsimpl(long r1) {
        return m2146toLongimpl(r1, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m2118getInWholeMillisecondsimpl(long r1) {
        if (m2130isInMillisimpl(r1) == false) goto L8;
        if (m2129isFiniteimpl(r1) == false) goto L8;
        return m2127getValueimpl(r1);
    L8:
        return m2146toLongimpl(r1, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m2117getInWholeMicrosecondsimpl(long r1) {
        return m2146toLongimpl(r1, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m2120getInWholeNanosecondsimpl(long r2) {
        long r0 = m2127getValueimpl(r2);
        if (m2131isInNanosimpl(r2) == false) goto L6;
        return r0;
    L6:
        if (r0 <= 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r0 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r0);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final long m2148toLongNanosecondsimpl(long r0) {
        return m2120getInWholeNanosecondsimpl(r0);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final long m2147toLongMillisecondsimpl(long r0) {
        return m2118getInWholeMillisecondsimpl(r0);
    }

    public String toString() {
        return m2149toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2149toStringimpl(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r14 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r2 = m2133isNegativeimpl(r14);
        StringBuilder r11 = new StringBuilder();
        if (r2 == false) goto L14;
        r11.append('-');
    L14:
        long r3 = m2106getAbsoluteValueUwyO8pc(r14);
        long r5 = m2115getInWholeDaysimpl(r3);
        int r7 = m2107getHoursComponentimpl(r3);
        int r8 = m2122getMinutesComponentimpl(r3);
        int r9 = m2124getSecondsComponentimpl(r3);
        int r10 = m2123getNanosecondsComponentimpl(r3);
        int r1 = 0;
        if (r5 == 0) goto L17;
        boolean r0 = true;
    L18:
        if (r7 == 0) goto L20;
        boolean r4 = true;
    L21:
        if (r8 == 0) goto L23;
        boolean r6 = true;
    L24:
        if (r9 != 0) goto L28;
        if (r10 != 0) goto L28;
        boolean r13 = false;
    L29:
        if (r0 == false) goto L32;
        r11.append(r5).append('d');
        r1 = 1;
    L32:
        if (r4 == true) goto L36;
        if (r0 == false) goto L40;
        if (r6 == true) goto L36;
        if (r13 == true) goto L36;
    L40:
        if (r6 == true) goto L44;
        if (r13 == false) goto L48;
        if (r4 == true) goto L44;
        if (r0 == true) goto L44;
    L48:
        if (r13 == false) goto L66;
        int r15 = r1 + 1;
        if (r1 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r9 != 0) goto L64;
        if (r0 == true) goto L64;
        if (r4 == true) goto L64;
        if (r6 == true) goto L64;
        if (r10 < 1000000) goto L61;
        m2097appendFractionalimpl(r14, r11, r10 / 1000000, r10 % 1000000, 6, "ms", false);
    L65:
        r1 = r15;
        goto L66
    L61:
        if (r10 < 1000) goto L63;
        m2097appendFractionalimpl(r14, r11, r10 / 1000, r10 % 1000, 3, "us", false);
        goto L65
    L63:
        r11.append(r10).append("ns");
    L64:
        m2097appendFractionalimpl(r14, r11, r9, r10, 9, "s", false);
    L66:
        if (r2 == false) goto L69;
        if (r1 <= 1) goto L69;
        r11.insert(1, '(').append(')');
    L69:
        String r16 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    L44:
        int r12 = r1 + 1;
        if (r1 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r8).append('m');
        r1 = r12;
    L36:
        int r17 = r1 + 1;
        if (r1 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r7).append('h');
        r1 = r17;
    L28:
        r13 = true;
        goto L29
    L23:
        r6 = false;
        goto L24
    L20:
        r4 = false;
        goto L21
    L17:
        r0 = false;
        goto L18
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m2097appendFractionalimpl(long r3, StringBuilder r5, int r6, int r7, int r8, String r9, boolean r10) {
        r5.append(r6);
        if (r7 == 0) goto L20;
        r5.append('.');
        String r4 = StringsKt.padStart(String.valueOf(r7), r8, DeepCleanSAFEngine.DetailPath.KEY);
        int r11 = -1;
        int r12 = r4.length() - 1;
        if (r12 < 0) goto L15;
    L6:
        int r1 = r12 - 1;
        if (r4.charAt(r12) == '0') goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L11;
        if (r1 < 0) goto L15;
        r12 = r1;
        goto L6
    L11:
        r11 = r12;
        goto L15
    L9:
        r2 = false;
    L15:
        int r13 = r11 + 1;
        if (r10 == true) goto L19;
        if (r13 >= 3) goto L19;
        Intrinsics.checkNotNullExpressionValue(r5.append(r4, 0, r13), "this.append(value, startIndex, endIndex)");
    L19:
        Intrinsics.checkNotNullExpressionValue(r5.append(r4, 0, ((r13 + 2) / 3) * 3), "this.append(value, startIndex, endIndex)");
    L20:
        r5.append(r9);
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m2151toStringimpl$default(long r0, DurationUnit r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return m2150toStringimpl(r0, r2, r3);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m2150toStringimpl(long r2, DurationUnit r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        if (r5 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        double r3 = m2143toDoubleimpl(r2, r4);
        if (Double.isInfinite(r3) == false) goto L12;
        return String.valueOf(r3);
    L12:
        return DurationJvmKt.formatToExactDecimals(r3, RangesKt.coerceAtMost(r5, 12)) + DurationUnitKt.shortName(r4);
    L14:
        throw new IllegalArgumentException(("decimals must be not negative, but was " + r5).toString());
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m2145toIsoStringimpl(long r11) {
        StringBuilder r8 = new StringBuilder();
        if (m2133isNegativeimpl(r11) == false) goto L5;
        r8.append('-');
    L5:
        r8.append("PT");
        long r0 = m2106getAbsoluteValueUwyO8pc(r11);
        long r2 = m2116getInWholeHoursimpl(r0);
        int r4 = m2122getMinutesComponentimpl(r0);
        int r5 = m2124getSecondsComponentimpl(r0);
        int r6 = m2123getNanosecondsComponentimpl(r0);
        if (m2132isInfiniteimpl(r11) == false) goto L8;
        r2 = 9999999999999L;
    L8:
        boolean r1 = true;
        if (r2 == 0) goto L11;
        boolean r3 = true;
    L12:
        if (r5 != 0) goto L16;
        if (r6 != 0) goto L16;
        boolean r9 = false;
    L17:
        if (r4 != 0) goto L22;
        if (r9 == false) goto L21;
        if (r3 == true) goto L22;
    L21:
        r1 = false;
    L22:
        if (r3 == false) goto L24;
        r8.append(r2).append('H');
    L24:
        if (r1 == false) goto L26;
        r8.append(r4).append('M');
    L26:
        if (r9 == true) goto L29;
        if (r3 == true) goto L30;
        if (r1 == false) goto L29;
    L30:
        String r12 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    L29:
        m2097appendFractionalimpl(r11, r8, r5, r6, 9, ExifInterface.LATITUDE_SOUTH, true);
    L16:
        r9 = true;
        goto L17
    L11:
        r3 = false;
        goto L12
    }
}
