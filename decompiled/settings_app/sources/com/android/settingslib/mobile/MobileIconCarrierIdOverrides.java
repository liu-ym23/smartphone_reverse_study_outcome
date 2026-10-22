package com.android.settingslib.mobile;

import android.content.res.Resources;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: MobileIconCarrierIdOverrides.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/settingslib/mobile/MobileIconCarrierIdOverrides;", "", "carrierIdEntryExists", "", DataServiceUtils.SubscriptionInfoData.COLUMN_CARRIER_ID, "", "getOverrideFor", "networkType", "", "resources", "Landroid/content/res/Resources;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MobileIconCarrierIdOverrides {
    boolean carrierIdEntryExists(int r1);

    int getOverrideFor(int r1, String r2, Resources r3);
}
