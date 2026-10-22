package com.obric.security.battertpower.powerHigh;

import android.content.Context;
import android.provider.Settings;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.utils.DeviceType;
import com.obric.olog.OLog;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: HighPowerAppManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/HighPowerAppManager;", "", "()V", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HighPowerAppManager {
    public static final String ALLOW_BG_POWER_HIGH = "allow_bg_power_high";
    public static final String ALLOW_BG_POWER_HIGH_MANUAL = "allow_bg_power_high_manual";
    public static final String ALLOW_BG_POWER_HIGH_WHITELIST = "allow_bg_power_high_whitelist";
    public static final String ALLOW_BG_POWER_HIGH_WHITELIST_VERSION = "allow_bg_power_high_whitelist_version";
    public static final Companion Companion = null;
    public static final int NEW_VERSION = 8;
    private static final String[] WHITE_LIST = null;

    /* JADX INFO: compiled from: HighPowerAppManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J \u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018J\u001e\u0010\u001c\u001a\u00020\u001a2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J\u001e\u0010\u001e\u001a\u00020\u001a2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J\u001e\u0010 \u001a\u00020\u001a2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011J(\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/HighPowerAppManager$Companion;", "", "()V", "ALLOW_BG_POWER_HIGH", "", "ALLOW_BG_POWER_HIGH_MANUAL", "ALLOW_BG_POWER_HIGH_WHITELIST", "ALLOW_BG_POWER_HIGH_WHITELIST_VERSION", "NEW_VERSION", "", "WHITE_LIST", "", "getWHITE_LIST", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getAllowBgPowerList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastWhitelist", "getManualPackageSet", "getStringSetFromGlobal", "key", "getWhiteList", "hasLastWhitelist", "", "init", "", "isNeedInit", "updateAllowBgPowerList", "packageSet", "updateLastWhitelist", "whitelist", "updateManualPackageSet", "manualSet", "updateStringSetToGlobal", "set", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String[] getWHITE_LIST() {
            return HighPowerAppManager.access$getWHITE_LIST$cp();
        }

        public final HashSet<String> getAllowBgPowerList() {
            HashSet<String> r2 = getStringSetFromGlobal("allow_bg_power_high");
            OLog.d("PowerHighAppsManager", "BootCompletedReceiver:getAllowBgPowerList:" + r2);
            return r2;
        }

        public final void updateAllowBgPowerList(HashSet<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "packageSet");
            OLog.d("PowerHighAppsManager", "BootCompletedReceiver:updateAllowBgPowerList:" + updateStringSetToGlobal("allow_bg_power_high", r2));
        }

        public final boolean isNeedInit() {
            Context r3 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r3, "SecurityCenterApplication.getContext()");
            int r4 = Settings.Global.getInt(r3.getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH_WHITELIST_VERSION, 0);
            OLog.d("PowerHighAppsManager", "isNeedInit:" + r4);
            if (r4 == 8) goto L6;
            return true;
        L6:
            return false;
        }

        public final boolean hasLastWhitelist() {
            Context r1 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r1, "SecurityCenterApplication.getContext()");
            String r2 = Settings.Global.getString(r1.getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH_WHITELIST);
            if (r2 != null) goto L5;
        L8:
            boolean r3 = true;
        L10:
            return !r3;
        L5:
            if (StringsKt.isBlank(r2) == true) goto L8;
            r3 = false;
            goto L10
        }

        public final HashSet<String> getLastWhitelist() {
            return getStringSetFromGlobal(HighPowerAppManager.ALLOW_BG_POWER_HIGH_WHITELIST);
        }

        public final HashSet<String> getWhiteList() {
            if (DeviceType.isPacific() == false) goto L6;
            return ArraysKt.toHashSet(getWHITE_LIST());
        L6:
            return ArraysKt.toHashSet(HighPowerWhiteListSettings.getValue());
        }

        public final void updateLastWhitelist(HashSet<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "whitelist");
            updateStringSetToGlobal(HighPowerAppManager.ALLOW_BG_POWER_HIGH_WHITELIST, r2);
        }

        public final HashSet<String> getManualPackageSet() {
            return getStringSetFromGlobal(HighPowerAppManager.ALLOW_BG_POWER_HIGH_MANUAL);
        }

        public final void updateManualPackageSet(HashSet<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "manualSet");
            updateStringSetToGlobal(HighPowerAppManager.ALLOW_BG_POWER_HIGH_MANUAL, r2);
        }

        public final void init() {
            Context r0 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r0, "SecurityCenterApplication.getContext()");
            Settings.Global.putInt(r0.getContentResolver(), HighPowerAppManager.ALLOW_BG_POWER_HIGH_WHITELIST_VERSION, 8);
            updateLastWhitelist(getWhiteList());
        }

        private final HashSet<String> getStringSetFromGlobal(String r4) {
            Context r3 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r3, "SecurityCenterApplication.getContext()");
            String r5 = Settings.Global.getString(r3.getContentResolver(), r4);
            String r6 = r5;
            int r0 = 0;
            if (r6 != null) goto L5;
        L8:
            boolean r7 = true;
        L9:
            if (r7 == true) goto L11;
            JSONArray r8 = new JSONArray(r5);     // Catch: Exception -> L16
            HashSet<String> r9 = new HashSet();     // Catch: Exception -> L16
            int r1 = r8.length();     // Catch: Exception -> L16
        L13:
            if (r0 >= r1) goto L21;
            r9.add(r8.getString(r0));     // Catch: Exception -> L16
            r0 = r0 + 1;
            goto L13
        L21:
            return r9;
        L17:
            return new HashSet();
        L11:
            return new HashSet();
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r7 = false;
            goto L9
        }

        private final String updateStringSetToGlobal(String r2, HashSet<String> r3) {
            JSONArray r1 = new JSONArray();
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r1.put((String) r4.next());
            goto L4
        L6:
            String r5 = r1.toString();
            Intrinsics.checkNotNullExpressionValue(r5, "jsonArray.toString()");
            Context r6 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r6, "SecurityCenterApplication.getContext()");
            Settings.Global.putString(r6.getContentResolver(), r2, r5);
            return r5;
        }
    }

    public HighPowerAppManager() {
    }

    public static final /* synthetic */ String[] access$getWHITE_LIST$cp() {
        return WHITE_LIST;
    }

    static {
        Companion = new Companion(null);
        if (DeviceType.isPacific() == false) goto L5;
        String[] r0 = {"com.tencent.mm", "com.tencent.mobileqq"};
    L6:
        WHITE_LIST = r0;
        return;
    L5:
        r0 = new String[0];
        goto L6
    }
}
