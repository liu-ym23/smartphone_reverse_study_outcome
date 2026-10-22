package com.android.settings.wifi.scanner;

import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WifiResultParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/android/settings/wifi/scanner/WifiResultParser;", "Lcom/android/settings/wifi/scanner/ResultParser;", "()V", "parse", "Lcom/android/settings/wifi/scanner/WifiParsedResult;", "resultStr", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiResultParser extends ResultParser {
    public static final Companion Companion = null;
    private static final String TAG = "WifiResultParser";

    /* JADX INFO: compiled from: WifiResultParser.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/settings/wifi/scanner/WifiResultParser$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WifiResultParser() {
    }

    @Override // com.android.settings.wifi.scanner.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(String r1) {
        return parse(r1);
    }

    @Override // com.android.settings.wifi.scanner.ResultParser
    public WifiParsedResult parse(String r18) {
        Intrinsics.checkNotNullParameter(r18, "resultStr");
        String r0 = ResultParser.getMassagedText(r18);
        Intrinsics.checkNotNull(r0);
        if (StringsKt.startsWith$default(r0, "WIFI:", false, 2, null) == true) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r0);
        String r1 = r0.substring(5);
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        String r7 = ResultParser.matchSinglePrefixedField("S:", r1, ';', false);
        if (r7 != null) goto L8;
    L25:
        return null;
    L8:
        if (r7.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L25;
        String r8 = ResultParser.matchSinglePrefixedField("P:", r1, ';', false);
        String r3 = ResultParser.matchSinglePrefixedField("T:", r1, ';', false);
        if (r3 != null) goto L16;
        r3 = "nopass";
    L16:
        String r6 = r3;
        String r4 = ResultParser.matchSinglePrefixedField("H:", r1, ';', false);
        if (r4 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        OLog.d(TAG, "SSID hidden : " + r9);
        return new WifiParsedResult(r6, r7, r8, r9, ResultParser.matchSinglePrefixedField("I:", r1, ';', false), ResultParser.matchSinglePrefixedField("A:", r1, ';', false), ResultParser.matchSinglePrefixedField("E:", r1, ';', false), ResultParser.matchSinglePrefixedField("H:", r1, ';', false), false, 256, null);
    L19:
        if (Boolean.parseBoolean(r4) == true) goto L22;
        r9 = false;
        goto L23
    L10:
        r2 = false;
        goto L11
    }
}
