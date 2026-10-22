package com.android.settingslib.mobile;

import android.content.Context;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.os.SystemProperties;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyDisplayInfo;
import com.android.settingslib.R;
import com.android.settingslib.SignalIcon;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MobileMappings {

    public static class Config {
        public boolean alwaysShowCdmaRssi;
        public boolean alwaysShowDataRatIcon;
        public boolean alwaysShowNetworkTypeIcon;
        public boolean crossSimdisplaySingnalLevel;
        public boolean enableDdsRatIconEnhancement;
        public boolean enableRatIconEnhancement;
        public boolean hideLtePlus;
        public boolean hideNoInternetState;
        public boolean hspaDataDistinguishable;
        public boolean show4gFor3g;
        public boolean show4gForLte;
        public boolean show4glteForLte;
        public boolean show6RxIcon;
        public boolean showAtLeast3G;
        public boolean showRsrpSignalLevelforLTE;
        public boolean showVolteIcon;
        public boolean showVowifiIcon;

        public Config() {
            this.showAtLeast3G = false;
            this.show4gFor3g = false;
            this.alwaysShowCdmaRssi = false;
            this.show4gForLte = false;
            this.show4glteForLte = false;
            this.hideLtePlus = false;
            this.alwaysShowDataRatIcon = false;
            this.showRsrpSignalLevelforLTE = false;
            this.hideNoInternetState = false;
            this.showVolteIcon = false;
            this.alwaysShowNetworkTypeIcon = false;
            this.enableRatIconEnhancement = false;
            this.showVowifiIcon = false;
            this.enableDdsRatIconEnhancement = false;
            this.crossSimdisplaySingnalLevel = false;
            this.show6RxIcon = true;
        }

        public static Config readConfig(Context r3) {
            Config r0 = new Config();
            Resources r1 = r3.getResources();
            r0.showAtLeast3G = r1.getBoolean(R.bool.config_showMin3G);
            r0.alwaysShowCdmaRssi = r1.getBoolean(android.R.bool.config_allow_pin_storage_for_unattended_reboot);
            r0.hspaDataDistinguishable = r1.getBoolean(R.bool.config_hspa_data_distinguishable);
            CarrierConfigManager r2 = (CarrierConfigManager) r3.getSystemService("carrier_config");
            SubscriptionManager.from(r3);
            int r4 = SubscriptionManager.getDefaultDataSubscriptionId();
            if (r2 != null) goto L5;
            PersistableBundle r5 = null;
        L6:
            if (r5 == null) goto L8;
            r0.alwaysShowDataRatIcon = r5.getBoolean("always_show_data_rat_icon_bool");
            r0.show4gForLte = r5.getBoolean("show_4g_for_lte_data_icon_bool");
            r0.show4glteForLte = r5.getBoolean("show_4glte_for_lte_data_icon_bool");
            r0.show4gFor3g = r5.getBoolean("show_4g_for_3g_data_icon_bool");
            r0.hideLtePlus = r5.getBoolean("hide_lte_plus_data_icon_bool");
            r0.crossSimdisplaySingnalLevel = r5.getBoolean("carrier_cross_sim_display_signal_strength");
        L8:
            r0.alwaysShowNetworkTypeIcon = r1.getBoolean(R.bool.config_alwaysShowTypeIcon);
            r0.showRsrpSignalLevelforLTE = r1.getBoolean(R.bool.config_showRsrpSignalLevelforLTE);
            r0.hideNoInternetState = r1.getBoolean(R.bool.config_hideNoInternetState);
            r0.showVolteIcon = r1.getBoolean(R.bool.config_display_volte);
            r0.showVowifiIcon = r1.getBoolean(R.bool.config_display_vowifi);
            if (r0.alwaysShowNetworkTypeIcon == false) goto L11;
            r0.hideLtePlus = false;
        L11:
            r0.show6RxIcon = r1.getBoolean(R.bool.config_display_6Rx);
            r0.enableRatIconEnhancement = SystemProperties.getBoolean("persist.sysui.rat_icon_enhancement", false);
            r0.enableDdsRatIconEnhancement = SystemProperties.getBoolean("persist.sysui.dds_rat_icon_enhancement", false);
            r0.showVowifiIcon |= SystemProperties.getBoolean("persist.sysui.enable_vowifi_icon", false);
            return r0;
        L5:
            r5 = r2.getConfigForSubId(r4);
            goto L6
        }

        public boolean areEqual(Config r3) {
            if (this.showAtLeast3G == r3.showAtLeast3G) goto L5;
        L19:
            return false;
        L5:
            if (this.show4gFor3g != r3.show4gFor3g) goto L19;
            if (this.alwaysShowCdmaRssi != r3.alwaysShowCdmaRssi) goto L19;
            if (this.show4gForLte != r3.show4gForLte) goto L19;
            if (this.show4glteForLte != r3.show4glteForLte) goto L19;
            if (this.hideLtePlus != r3.hideLtePlus) goto L19;
            if (this.hspaDataDistinguishable != r3.hspaDataDistinguishable) goto L19;
            if (this.alwaysShowDataRatIcon != r3.alwaysShowDataRatIcon) goto L19;
            return true;
        }
    }

    public MobileMappings() {
    }

    public static String getIconKey(TelephonyDisplayInfo r1) {
        if (r1.getOverrideNetworkType() != 0) goto L7;
        return toIconKey(r1.getNetworkType());
    L7:
        return toDisplayIconKey(r1.getOverrideNetworkType());
    }

    public static String toIconKey(int r0) {
        return Integer.toString(r0);
    }

    public static String toDisplayIconKey(int r2) {
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 == 5) goto L13;
        return "unsupported";
    L13:
        return toIconKey(20) + "_Plus";
    L15:
        return toIconKey(20);
    L17:
        return toIconKey(13) + "_CA_Plus";
    L19:
        return toIconKey(13) + "_CA";
    }

    public static SignalIcon.MobileIconGroup getDefaultIcons(Config r0) {
        if (r0.showAtLeast3G == true) goto L7;
        return TelephonyIcons.G;
    L7:
        return TelephonyIcons.THREE_G;
    }

    public static Map<String, SignalIcon.MobileIconGroup> mapIconSets(Config r9) {
        HashMap r0 = new HashMap();
        r0.put(toIconKey(5), TelephonyIcons.THREE_G);
        r0.put(toIconKey(6), TelephonyIcons.THREE_G);
        r0.put(toIconKey(12), TelephonyIcons.THREE_G);
        r0.put(toIconKey(14), TelephonyIcons.THREE_G);
        if (r9.show4gFor3g == false) goto L5;
        r0.put(toIconKey(3), TelephonyIcons.FOUR_G);
    L6:
        r0.put(toIconKey(17), TelephonyIcons.THREE_G);
        if (r9.showAtLeast3G == true) goto L9;
        r0.put(toIconKey(0), TelephonyIcons.UNKNOWN);
        r0.put(toIconKey(2), TelephonyIcons.E);
        r0.put(toIconKey(1), TelephonyIcons.G);
        r0.put(toIconKey(4), TelephonyIcons.ONE_X);
        r0.put(toIconKey(7), TelephonyIcons.ONE_X);
    L10:
        SignalIcon.MobileIconGroup r2 = TelephonyIcons.THREE_G;
        SignalIcon.MobileIconGroup r4 = TelephonyIcons.THREE_G;
        if (r9.show4gFor3g == false) goto L14;
        r2 = TelephonyIcons.FOUR_G;
        r4 = TelephonyIcons.FOUR_G;
    L16:
        r0.put(toIconKey(8), r2);
        r0.put(toIconKey(9), r2);
        r0.put(toIconKey(10), r2);
        r0.put(toIconKey(15), r4);
        if (r9.show4gForLte == false) goto L23;
        r0.put(toIconKey(13), TelephonyIcons.FOUR_G);
        if (r9.hideLtePlus == false) goto L21;
        r0.put(toDisplayIconKey(1), TelephonyIcons.FOUR_G);
    L32:
        r0.put(toIconKey(18), TelephonyIcons.WFC);
        r0.put(toDisplayIconKey(2), TelephonyIcons.LTE_CA_5G_E);
        r0.put(toDisplayIconKey(3), TelephonyIcons.NR_5G);
        r0.put(toDisplayIconKey(5), TelephonyIcons.NR_5G_PLUS);
        r0.put(toIconKey(20), TelephonyIcons.NR_5G);
        return r0;
    L21:
        r0.put(toDisplayIconKey(1), TelephonyIcons.FOUR_G_PLUS);
        goto L32
    L23:
        if (r9.show4glteForLte == false) goto L28;
        r0.put(toIconKey(13), TelephonyIcons.FOUR_G_LTE);
        if (r9.hideLtePlus == false) goto L27;
        r0.put(toDisplayIconKey(1), TelephonyIcons.FOUR_G_LTE);
        goto L32
    L27:
        r0.put(toDisplayIconKey(1), TelephonyIcons.FOUR_G_LTE_PLUS);
        goto L32
    L28:
        r0.put(toIconKey(13), TelephonyIcons.LTE);
        if (r9.hideLtePlus == false) goto L31;
        r0.put(toDisplayIconKey(1), TelephonyIcons.LTE);
        goto L32
    L31:
        r0.put(toDisplayIconKey(1), TelephonyIcons.LTE_PLUS);
        goto L32
    L14:
        if (r9.hspaDataDistinguishable == false) goto L16;
        r2 = TelephonyIcons.H;
        r4 = TelephonyIcons.H_PLUS;
        goto L16
    L9:
        r0.put(toIconKey(0), TelephonyIcons.THREE_G);
        r0.put(toIconKey(2), TelephonyIcons.THREE_G);
        r0.put(toIconKey(1), TelephonyIcons.THREE_G);
        r0.put(toIconKey(4), TelephonyIcons.THREE_G);
        r0.put(toIconKey(7), TelephonyIcons.THREE_G);
        goto L10
    L5:
        r0.put(toIconKey(3), TelephonyIcons.THREE_G);
        goto L6
    }
}
