package com.obric.oui.time;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeFormat.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0010R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/time/TimePattern;", "", "locale", "Ljava/util/Locale;", "fullPattern", "Lkotlin/Pair;", "", "fullPatternY", "fullPatternYM", "fullPatternYMD", "fullPatternMD", "fullPatternYMDHM", "fullPatternYMDEHM", "briefPatternHM", "briefPatternMD", "briefPatternYMDHM", "(Ljava/util/Locale;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;)V", "getBriefPatternHM", "()Lkotlin/Pair;", "getBriefPatternMD", "getBriefPatternYMDHM", "getFullPattern", "getFullPatternMD", "getFullPatternY", "getFullPatternYM", "getFullPatternYMD", "getFullPatternYMDEHM", "getFullPatternYMDHM", "getLocale", "()Ljava/util/Locale;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimePattern {
    public static final Companion Companion = null;
    private final Pair<String, String> briefPatternHM;
    private final Pair<String, String> briefPatternMD;
    private final Pair<String, String> briefPatternYMDHM;
    private final Pair<String, String> fullPattern;
    private final Pair<String, String> fullPatternMD;
    private final Pair<String, String> fullPatternY;
    private final Pair<String, String> fullPatternYM;
    private final Pair<String, String> fullPatternYMD;
    private final Pair<String, String> fullPatternYMDEHM;
    private final Pair<String, String> fullPatternYMDHM;
    private final Locale locale;

    /* JADX INFO: compiled from: TimeFormat.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/time/TimePattern$Companion;", "", "()V", "ofClockFormat", "", "Lkotlin/Pair;", "clockFormat", "Lcom/obric/oui/time/ClockFormat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: TimeFormat.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[ClockFormat.values().length];
                r0[ClockFormat.H24.ordinal()] = 1;
                r0[ClockFormat.H12.ordinal()] = 2;
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String ofClockFormat(Pair<String, String> r1, ClockFormat r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, "clockFormat");
            int r0 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
            if (r0 == 1) goto L10;
            if (r0 != 2) goto L8;
            return r1.getSecond();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return r1.getFirst();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TimePattern(Locale r2, Pair<String, String> r3, Pair<String, String> r4, Pair<String, String> r5, Pair<String, String> r6, Pair<String, String> r7, Pair<String, String> r8, Pair<String, String> r9, Pair<String, String> r10, Pair<String, String> r11, Pair<String, String> r12) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        Intrinsics.checkNotNullParameter(r3, "fullPattern");
        Intrinsics.checkNotNullParameter(r4, "fullPatternY");
        Intrinsics.checkNotNullParameter(r5, "fullPatternYM");
        Intrinsics.checkNotNullParameter(r6, "fullPatternYMD");
        Intrinsics.checkNotNullParameter(r7, "fullPatternMD");
        Intrinsics.checkNotNullParameter(r8, "fullPatternYMDHM");
        Intrinsics.checkNotNullParameter(r9, "fullPatternYMDEHM");
        Intrinsics.checkNotNullParameter(r10, "briefPatternHM");
        Intrinsics.checkNotNullParameter(r11, "briefPatternMD");
        Intrinsics.checkNotNullParameter(r12, "briefPatternYMDHM");
        this.locale = r2;
        this.fullPattern = r3;
        this.fullPatternY = r4;
        this.fullPatternYM = r5;
        this.fullPatternYMD = r6;
        this.fullPatternMD = r7;
        this.fullPatternYMDHM = r8;
        this.fullPatternYMDEHM = r9;
        this.briefPatternHM = r10;
        this.briefPatternMD = r11;
        this.briefPatternYMDHM = r12;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final Pair<String, String> getFullPattern() {
        return this.fullPattern;
    }

    public final Pair<String, String> getFullPatternY() {
        return this.fullPatternY;
    }

    public final Pair<String, String> getFullPatternYM() {
        return this.fullPatternYM;
    }

    public final Pair<String, String> getFullPatternYMD() {
        return this.fullPatternYMD;
    }

    public final Pair<String, String> getFullPatternMD() {
        return this.fullPatternMD;
    }

    public final Pair<String, String> getFullPatternYMDHM() {
        return this.fullPatternYMDHM;
    }

    public final Pair<String, String> getFullPatternYMDEHM() {
        return this.fullPatternYMDEHM;
    }

    public final Pair<String, String> getBriefPatternHM() {
        return this.briefPatternHM;
    }

    public final Pair<String, String> getBriefPatternMD() {
        return this.briefPatternMD;
    }

    public final Pair<String, String> getBriefPatternYMDHM() {
        return this.briefPatternYMDHM;
    }
}
