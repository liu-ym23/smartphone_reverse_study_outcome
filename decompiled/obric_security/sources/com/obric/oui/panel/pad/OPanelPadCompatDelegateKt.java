package com.obric.oui.panel.pad;

import android.content.Context;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPanelPadCompatDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"PAD_PANEL_MULTI_THRESHOLD_DP", "", "PAD_PANEL_MULTI_WIDTH_DP", "PAD_PANEL_SIMPLE_WIDTH_DP", "getPadPanelWidth", "context", "Landroid/content/Context;", "isMultiDialog", "", "wrapContent", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OPanelPadCompatDelegateKt {
    private static final int PAD_PANEL_MULTI_THRESHOLD_DP = 680;
    private static final int PAD_PANEL_MULTI_WIDTH_DP = 520;
    private static final int PAD_PANEL_SIMPLE_WIDTH_DP = 420;

    static {
    }

    public static /* synthetic */ int getPadPanelWidth$default(Context r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return getPadPanelWidth(r0, r1, r2);
    }

    public static final int getPadPanelWidth(Context r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r3 == false) goto L5;
        return -2;
    L5:
        if (r2 == false) goto L11;
        if (OUnitExtensionKt.getScreenWidth(r1) <= OUnitExtensionKt.cdp(r1, PAD_PANEL_MULTI_THRESHOLD_DP)) goto L14;
        return OUnitExtensionKt.cdp(r1, PAD_PANEL_MULTI_WIDTH_DP);
    L14:
        return OUnitExtensionKt.cdp(r1, PAD_PANEL_SIMPLE_WIDTH_DP);
    L11:
        return OUnitExtensionKt.cdp(r1, PAD_PANEL_SIMPLE_WIDTH_DP);
    }
}
