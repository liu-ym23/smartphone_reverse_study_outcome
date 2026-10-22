package com.android.settings.fuelgauge.appBatteryUseOptimization.highpower;

import android.provider.Settings;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: compiled from: HighPowerAppManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/settings/fuelgauge/appBatteryUseOptimization/highpower/HighPowerAppManager;", "", "()V", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HighPowerAppManager {
    public static final String ALLOW_BG_POWER_HIGH = "allow_bg_power_high";
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: HighPowerAppManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settings/fuelgauge/appBatteryUseOptimization/highpower/HighPowerAppManager$Companion;", "", "()V", "ALLOW_BG_POWER_HIGH", "", "addHighPowerApp", "", "pkg", "isAllowBgHighPower", "", "removeHighPowerApp", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void addHighPowerApp(String r4) {
            Intrinsics.checkNotNullParameter(r4, "pkg");
            String r3 = Settings.Global.getString(SettingsApplication.getContext().getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH);
            if (r3 != null) goto L5;
            r3 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        L5:
            JSONArray r1 = new JSONArray(r3);
            r1.put(r4);
            String r5 = r1.toString();
            Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
            OLog.d("PowerHighAppsManager ", "add allow bg power high app:" + r4 + ", current new all allow bg power hihg apps is  :" + r5);
            Settings.Global.putString(SettingsApplication.getContext().getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH, r5);
        }

        public final void removeHighPowerApp(String r9) {
            Intrinsics.checkNotNullParameter(r9, "pkg");
            String r8 = Settings.Global.getString(SettingsApplication.getContext().getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH);
            if (r8 != null) goto L6;
            OLog.e("PowerHighAppsManager ", "remove allow bg power high app:" + r9 + ", current all allow bg power hihg apps is empty - error error error");
            return;
        L6:
            JSONArray r3 = new JSONArray(r8);
            JSONArray r10 = new JSONArray();
            int r4 = r3.length();
            int r5 = 0;
        L7:
            if (r5 >= r4) goto L12;
            String r6 = r3.getString(r5);
            if (Intrinsics.areEqual(r6, r9) == true) goto L11;
            r10.put(r6);
        L11:
            r5 = r5 + 1;
            goto L7
        L12:
            String r11 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
            OLog.d("PowerHighAppsManager ", "remove allow bg power high app:" + r9 + ", current new all allow bg power hihg apps is  :" + r11);
            Settings.Global.putString(SettingsApplication.getContext().getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH, r11);
        }

        public final boolean isAllowBgHighPower(String r5) {
            Intrinsics.checkNotNullParameter(r5, "pkg");
            String r4 = Settings.Global.getString(SettingsApplication.getContext().getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH);
            OLog.d("PowerHighAppsManager", "current app is:" + r5 + ", all allow bg power hihg apps is :" + r4);
            if (r4 != null) goto L5;
            return false;
        L5:
            JSONArray r1 = new JSONArray(r4);
            int r6 = r1.length();
            int r2 = 0;
        L6:
            if (r2 >= r6) goto L14;
            if (Intrinsics.areEqual(r1.getString(r2), r5) == true) goto L9;
            r2 = r2 + 1;
            goto L6
        L9:
            return true;
        L14:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HighPowerAppManager() {
    }
}
