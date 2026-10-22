package com.obric.smsparser.risk;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsRiskSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/smsparser/risk/SmsRiskSettings;", "", "()V", "SMS_INTERCEPT_USE_CLOUD", "", "isSmsInterceptUseCloud", "", "context", "Landroid/content/Context;", "smsrisk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsRiskSettings {
    public static final SmsRiskSettings INSTANCE = null;
    private static final String SMS_INTERCEPT_USE_CLOUD = "pref_key_sms_yulore_intercept_use_cloud";

    static {
        INSTANCE = new SmsRiskSettings();
    }

    private SmsRiskSettings() {
    }

    public final boolean isSmsInterceptUseCloud(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ContentResolver r1 = r2.getContentResolver();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (Settings.System.getInt(r1, SMS_INTERCEPT_USE_CLOUD, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
