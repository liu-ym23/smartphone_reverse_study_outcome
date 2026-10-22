package com.android.settings.about.status;

import android.content.Context;
import android.telephony.SubscriptionManager;
import android.text.Html;
import android.text.Spanned;
import com.android.settingslib.SignalIcon;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MobileIconGroupExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"HTML_TAG", "", "getSummaryForSub", "Lcom/android/settingslib/SignalIcon$MobileIconGroup;", "context", "Landroid/content/Context;", DataServiceUtils.MobileNetworkInfoData.COLUMN_ID, "", "maybeToHtml", "", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MobileIconGroupExtKt {
    private static final String HTML_TAG = "</";

    public static final String getSummaryForSub(SignalIcon.MobileIconGroup r1, Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r1.dataContentDescription != 0) goto L5;
        return "";
    L5:
        String r4 = SubscriptionManager.getResourcesForSubId(r2, r3).getString(r1.dataContentDescription);
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    public static final CharSequence maybeToHtml(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r0 = r5;
        if (StringsKt.contains$default(r0, HTML_TAG, false, 2, null) == false) goto L6;
        Spanned r6 = Html.fromHtml(r5, 0);
        Intrinsics.checkNotNullExpressionValue(r6, "fromHtml(...)");
        return r6;
    L6:
        return r0;
    }
}
