package com.android.settingslib.mobile;

import android.content.res.Resources;
import android.content.res.TypedArray;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MobileIconCarrierIdOverrides.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/android/settingslib/mobile/MobileIconCarrierIdOverridesImpl;", "Lcom/android/settingslib/mobile/MobileIconCarrierIdOverrides;", "()V", "carrierIdEntryExists", "", DataServiceUtils.SubscriptionInfoData.COLUMN_CARRIER_ID, "", "getOverrideFor", "networkType", "", "resources", "Landroid/content/res/Resources;", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MobileIconCarrierIdOverridesImpl implements MobileIconCarrierIdOverrides {
    public static final Companion Companion = null;
    private static final Map<Integer, Integer> MAPPING = null;
    private static final String TAG = "MobileIconOverrides";

    /* JADX INFO: compiled from: MobileIconCarrierIdOverrides.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0003J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/settingslib/mobile/MobileIconCarrierIdOverridesImpl$Companion;", "", "()V", "MAPPING", "", "", "TAG", "", "overrideExists", "", DataServiceUtils.SubscriptionInfoData.COLUMN_CARRIER_ID, "mapping", "parseNetworkIconOverrideTypedArray", "ta", "Landroid/content/res/TypedArray;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$overrideExists(Companion r0, int r1, Map r2) {
            return r0.overrideExists(r1, r2);
        }

        @JvmStatic
        public final Map<String, Integer> parseNetworkIconOverrideTypedArray(TypedArray r8) {
            Intrinsics.checkNotNullParameter(r8, "ta");
            if ((r8.length() % 2) == 0) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(MobileIconCarrierIdOverridesImpl.TAG, "override must contain an even number of (key, value) entries. skipping");
            return MapsKt.emptyMap();
        L6:
            LinkedHashMap r7 = new LinkedHashMap();
            IntProgression r0 = RangesKt.step(RangesKt.until(0, r8.length()), 2);
            int r2 = r0.getFirst();
            int r4 = r0.getLast();
            int r1 = r0.getStep();
            if (r1 <= 0) goto L9;
            if (r2 > r4) goto L9;
        L11:
            String r5 = r8.getString(r2);
            int r6 = r8.getResourceId(r2 + 1, 0);
            if (r5 == null) goto L16;
            if (r6 == 0) goto L16;
            r7.put(r5, Integer.valueOf(r6));
        L17:
            if (r2 == r4) goto L19;
            r2 = r2 + r1;
        L19:
            return r7;
        L16:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(MobileIconCarrierIdOverridesImpl.TAG, "Invalid override found. Skipping");
        L9:
            if (r1 >= 0) goto L19;
            if (r4 > r2) goto L19;
            goto L19
        }

        @JvmStatic
        private final boolean overrideExists(int r1, Map<Integer, Integer> r2) {
            return r2.containsKey(Integer.valueOf(r1));
        }
    }

    @JvmStatic
    private static final boolean overrideExists(int r1, Map<Integer, Integer> r2) {
        return Companion.access$overrideExists(Companion, r1, r2);
    }

    @JvmStatic
    public static final Map<String, Integer> parseNetworkIconOverrideTypedArray(TypedArray r1) {
        return Companion.parseNetworkIconOverrideTypedArray(r1);
    }

    public MobileIconCarrierIdOverridesImpl() {
    }

    @Override // com.android.settingslib.mobile.MobileIconCarrierIdOverrides
    public int getOverrideFor(int r1, String r2, Resources r3) {
        Intrinsics.checkNotNullParameter(r2, "networkType");
        Intrinsics.checkNotNullParameter(r3, "resources");
        Integer r0 = MAPPING.get(Integer.valueOf(r1));
        if (r0 == null) goto L8;
        TypedArray r4 = r3.obtainTypedArray(r0.intValue());
        Intrinsics.checkNotNullExpressionValue(r4, "resources.obtainTypedArray(resId)");
        Map<String, Integer> r5 = Companion.parseNetworkIconOverrideTypedArray(r4);
        r4.recycle();
        Integer r6 = r5.get(r2);
        if (r6 != null) goto L7;
        return 0;
    L7:
        return r6.intValue();
    L8:
        return 0;
    }

    @Override // com.android.settingslib.mobile.MobileIconCarrierIdOverrides
    public boolean carrierIdEntryExists(int r2) {
        return Companion.access$overrideExists(Companion, r2, MAPPING);
    }

    static {
        Companion = new Companion(null);
        MAPPING = MapsKt.mapOf(TuplesKt.to(2032, Integer.valueOf(R.array.carrierId_2032_iconOverrides)));
    }
}
