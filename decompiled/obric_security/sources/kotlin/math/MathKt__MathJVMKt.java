package kotlin.math;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: MathJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", MaterialConfigFormatNames.X, "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", MaterialConfigFormatNames.Y, "atanh", "cbrt", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", TraceStatsConsts.STATS_BASE_MODULE, "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends MathKt__MathHKt {
    public MathKt__MathJVMKt() {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(double r0) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float r0) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int r0) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long r0) {
    }

    public static final int getSign(int r0) {
        if (r0 >= 0) goto L4;
        return -1;
    L4:
        if (r0 <= 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static final int getSign(long r2) {
        if (r2 >= 0) goto L5;
        return -1;
    L5:
        if (r2 <= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static /* synthetic */ void getSign$annotations(double r0) {
    }

    public static /* synthetic */ void getSign$annotations(float r0) {
    }

    public static /* synthetic */ void getSign$annotations(int r0) {
    }

    public static /* synthetic */ void getSign$annotations(long r0) {
    }

    public static /* synthetic */ void getUlp$annotations(double r0) {
    }

    public static /* synthetic */ void getUlp$annotations(float r0) {
    }

    private static final double sin(double r0) {
        return Math.sin(r0);
    }

    private static final double cos(double r0) {
        return Math.cos(r0);
    }

    private static final double tan(double r0) {
        return Math.tan(r0);
    }

    private static final double asin(double r0) {
        return Math.asin(r0);
    }

    private static final double acos(double r0) {
        return Math.acos(r0);
    }

    private static final double atan(double r0) {
        return Math.atan(r0);
    }

    private static final double atan2(double r0, double r2) {
        return Math.atan2(r0, r2);
    }

    private static final double sinh(double r0) {
        return Math.sinh(r0);
    }

    private static final double cosh(double r0) {
        return Math.cosh(r0);
    }

    private static final double tanh(double r0) {
        return Math.tanh(r0);
    }

    public static final double asinh(double r4) {
        if (r4 < Constants.taylor_n_bound) goto L12;
        if (r4 <= Constants.upper_taylor_n_bound) goto L20;
        if (r4 > Constants.upper_taylor_2_bound) goto L18;
        double r5 = r4 * ((double) 2);
        return Math.log(r5 + (((double) 1) / r5));
    L18:
        return Math.log(r4) + Constants.LN2;
    L20:
        return Math.log(r4 + Math.sqrt((r4 * r4) + ((double) 1)));
    L12:
        if (r4 > (-Constants.taylor_n_bound)) goto L15;
        return -MathKt.asinh(-r4);
    L15:
        if (Math.abs(r4) >= Constants.taylor_2_bound) goto L17;
        return r4;
    L17:
        return r4 - (((r4 * r4) * r4) / ((double) 6));
    }

    public static final double acosh(double r6) {
        if (r6 >= 1.0d) goto L6;
        return Double.NaN;
    L6:
        if (r6 > Constants.upper_taylor_2_bound) goto L17;
        double r0 = 1;
        double r2 = r6 - r0;
        if (r2 >= Constants.taylor_n_bound) goto L18;
        double r7 = Math.sqrt(r2);
        if (r7 < Constants.taylor_2_bound) goto L15;
        r7 = r7 - (((r7 * r7) * r7) / ((double) 12));
    L15:
        return r7 * Math.sqrt(2.0d);
    L18:
        return Math.log(r6 + Math.sqrt((r6 * r6) - r0));
    L17:
        return Math.log(r6) + Constants.LN2;
    }

    public static final double atanh(double r4) {
        if (Math.abs(r4) < Constants.taylor_n_bound) goto L5;
        double r0 = 1;
        return Math.log((r0 + r4) / (r0 - r4)) / ((double) 2);
    L5:
        if (Math.abs(r4) > Constants.taylor_2_bound) goto L7;
        return r4;
    L7:
        return r4 + (((r4 * r4) * r4) / ((double) 3));
    }

    private static final double hypot(double r0, double r2) {
        return Math.hypot(r0, r2);
    }

    private static final double sqrt(double r0) {
        return Math.sqrt(r0);
    }

    private static final double exp(double r0) {
        return Math.exp(r0);
    }

    private static final double expm1(double r0) {
        return Math.expm1(r0);
    }

    public static final double log(double r2, double r4) {
        if (r4 > 0.0d) goto L5;
        return Double.NaN;
    L5:
        if (r4 != 1.0d) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return Double.NaN;
    L11:
        return Math.log(r2) / Math.log(r4);
    L7:
        r0 = false;
        goto L8
    }

    private static final double ln(double r0) {
        return Math.log(r0);
    }

    private static final double log10(double r0) {
        return Math.log10(r0);
    }

    public static final double log2(double r2) {
        return Math.log(r2) / Constants.LN2;
    }

    private static final double ln1p(double r0) {
        return Math.log1p(r0);
    }

    private static final double ceil(double r0) {
        return Math.ceil(r0);
    }

    private static final double floor(double r0) {
        return Math.floor(r0);
    }

    public static final double truncate(double r2) {
        if (Double.isNaN(r2) == false) goto L5;
        return r2;
    L5:
        if (Double.isInfinite(r2) == false) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0d) goto L11;
        return Math.floor(r2);
    L11:
        return Math.ceil(r2);
    }

    private static final double round(double r0) {
        return Math.rint(r0);
    }

    private static final double abs(double r0) {
        return Math.abs(r0);
    }

    private static final double sign(double r0) {
        return Math.signum(r0);
    }

    private static final double min(double r0, double r2) {
        return Math.min(r0, r2);
    }

    private static final double max(double r0, double r2) {
        return Math.max(r0, r2);
    }

    private static final double cbrt(double r0) {
        return Math.cbrt(r0);
    }

    private static final double pow(double r0, double r2) {
        return Math.pow(r0, r2);
    }

    private static final double pow(double r2, int r4) {
        return Math.pow(r2, r4);
    }

    private static final double IEEErem(double r0, double r2) {
        return Math.IEEEremainder(r0, r2);
    }

    private static final double getAbsoluteValue(double r0) {
        return Math.abs(r0);
    }

    private static final double getSign(double r0) {
        return Math.signum(r0);
    }

    private static final double withSign(double r0, double r2) {
        return Math.copySign(r0, r2);
    }

    private static final double withSign(double r2, int r4) {
        return Math.copySign(r2, r4);
    }

    private static final double getUlp(double r0) {
        return Math.ulp(r0);
    }

    private static final double nextUp(double r0) {
        return Math.nextUp(r0);
    }

    private static final double nextDown(double r2) {
        return Math.nextAfter(r2, Double.NEGATIVE_INFINITY);
    }

    private static final double nextTowards(double r0, double r2) {
        return Math.nextAfter(r0, r2);
    }

    public static final int roundToInt(double r2) {
        if (Double.isNaN(r2) == true) goto L13;
        if (r2 <= 2.147483647E9d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r2 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r2);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(double r1) {
        if (Double.isNaN(r1) == true) goto L7;
        return Math.round(r1);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final float sin(float r2) {
        return (float) Math.sin(r2);
    }

    private static final float cos(float r2) {
        return (float) Math.cos(r2);
    }

    private static final float tan(float r2) {
        return (float) Math.tan(r2);
    }

    private static final float asin(float r2) {
        return (float) Math.asin(r2);
    }

    private static final float acos(float r2) {
        return (float) Math.acos(r2);
    }

    private static final float atan(float r2) {
        return (float) Math.atan(r2);
    }

    private static final float atan2(float r2, float r3) {
        return (float) Math.atan2(r2, r3);
    }

    private static final float sinh(float r2) {
        return (float) Math.sinh(r2);
    }

    private static final float cosh(float r2) {
        return (float) Math.cosh(r2);
    }

    private static final float tanh(float r2) {
        return (float) Math.tanh(r2);
    }

    private static final float asinh(float r2) {
        return (float) MathKt.asinh(r2);
    }

    private static final float acosh(float r2) {
        return (float) MathKt.acosh(r2);
    }

    private static final float atanh(float r2) {
        return (float) MathKt.atanh(r2);
    }

    private static final float hypot(float r2, float r3) {
        return (float) Math.hypot(r2, r3);
    }

    private static final float sqrt(float r2) {
        return (float) Math.sqrt(r2);
    }

    private static final float exp(float r2) {
        return (float) Math.exp(r2);
    }

    private static final float expm1(float r2) {
        return (float) Math.expm1(r2);
    }

    public static final float log(float r2, float r3) {
        if (r3 > 0.0f) goto L5;
        return Float.NaN;
    L5:
        if (r3 != 1.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return Float.NaN;
    L11:
        return (float) (Math.log(r2) / Math.log(r3));
    L7:
        r0 = false;
        goto L8
    }

    private static final float ln(float r2) {
        return (float) Math.log(r2);
    }

    private static final float log10(float r2) {
        return (float) Math.log10(r2);
    }

    public static final float log2(float r4) {
        return (float) (Math.log(r4) / Constants.LN2);
    }

    private static final float ln1p(float r2) {
        return (float) Math.log1p(r2);
    }

    private static final float ceil(float r2) {
        return (float) Math.ceil(r2);
    }

    private static final float floor(float r2) {
        return (float) Math.floor(r2);
    }

    public static final float truncate(float r2) {
        if (Float.isNaN(r2) == false) goto L5;
        return r2;
    L5:
        if (Float.isInfinite(r2) == false) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0f) goto L10;
        double r0 = Math.floor(r2);
    L12:
        return (float) r0;
    L10:
        r0 = Math.ceil(r2);
        goto L12
    }

    private static final float round(float r2) {
        return (float) Math.rint(r2);
    }

    private static final float abs(float r0) {
        return Math.abs(r0);
    }

    private static final float sign(float r0) {
        return Math.signum(r0);
    }

    private static final float min(float r0, float r1) {
        return Math.min(r0, r1);
    }

    private static final float max(float r0, float r1) {
        return Math.max(r0, r1);
    }

    private static final float cbrt(float r2) {
        return (float) Math.cbrt(r2);
    }

    private static final float pow(float r2, float r3) {
        return (float) Math.pow(r2, r3);
    }

    private static final float pow(float r2, int r3) {
        return (float) Math.pow(r2, r3);
    }

    private static final float IEEErem(float r2, float r3) {
        return (float) Math.IEEEremainder(r2, r3);
    }

    private static final float getAbsoluteValue(float r0) {
        return Math.abs(r0);
    }

    private static final float getSign(float r0) {
        return Math.signum(r0);
    }

    private static final float withSign(float r0, float r1) {
        return Math.copySign(r0, r1);
    }

    private static final float withSign(float r0, int r1) {
        return Math.copySign(r0, r1);
    }

    private static final float getUlp(float r0) {
        return Math.ulp(r0);
    }

    private static final float nextUp(float r0) {
        return Math.nextUp(r0);
    }

    private static final float nextDown(float r2) {
        return Math.nextAfter(r2, Double.NEGATIVE_INFINITY);
    }

    private static final float nextTowards(float r2, float r3) {
        return Math.nextAfter(r2, r3);
    }

    public static final int roundToInt(float r1) {
        if (Float.isNaN(r1) == true) goto L7;
        return Math.round(r1);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(float r2) {
        return MathKt.roundToLong(r2);
    }

    private static final int abs(int r0) {
        return Math.abs(r0);
    }

    private static final int min(int r0, int r1) {
        return Math.min(r0, r1);
    }

    private static final int max(int r0, int r1) {
        return Math.max(r0, r1);
    }

    private static final int getAbsoluteValue(int r0) {
        return Math.abs(r0);
    }

    private static final long abs(long r0) {
        return Math.abs(r0);
    }

    private static final long min(long r0, long r2) {
        return Math.min(r0, r2);
    }

    private static final long max(long r0, long r2) {
        return Math.max(r0, r2);
    }

    private static final long getAbsoluteValue(long r0) {
        return Math.abs(r0);
    }
}
