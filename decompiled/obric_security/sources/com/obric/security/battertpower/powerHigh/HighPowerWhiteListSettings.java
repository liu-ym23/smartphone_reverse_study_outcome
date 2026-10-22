package com.obric.security.battertpower.powerHigh;

import com.obric.securitycenter.api.settings.Introduction;
import com.obric.securitycenter.api.settings.Owner;
import com.obric.securitycenter.api.settings.Scope;
import com.obric.securitycenter.api.settings.SettingsKey;
import com.obric.securitycenter.api.settings.SettingsManager;
import com.obric.securitycenter.api.settings.Title;
import com.obric.securitycenter.api.settings.Value;
import com.obric.securitycenter.api.settings.scope.Security;
import com.obric.securitycenter.api.settings.scope.modules.BatteryPower;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HighPowerWhiteListSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0002\u0010\bR$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/HighPowerWhiteListSettings;", "", "()V", "DEFAULT", "", "", "getDEFAULT$annotations", "getDEFAULT", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getValue", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
@Introduction("白名单中的应用会在初始化时，被自动设置为允许高耗电")
@Owner("yejiongming.128")
@Title("高耗电控制白名单")
@Scope(business = Security.class, module = BatteryPower.class)
@SettingsKey("high_power_app_white_list")
public final class HighPowerWhiteListSettings {

    @Value(isDefault = true)
    private static final String[] DEFAULT = null;
    public static final HighPowerWhiteListSettings INSTANCE = null;

    @JvmStatic
    public static /* synthetic */ void getDEFAULT$annotations() {
    }

    static {
        INSTANCE = new HighPowerWhiteListSettings();
        DEFAULT = HighPowerAppManager.Companion.getWHITE_LIST();
    }

    private HighPowerWhiteListSettings() {
    }

    public static final String[] getDEFAULT() {
        return DEFAULT;
    }

    @JvmStatic
    public static final String[] getValue() {
        String[] r0 = (String[]) SettingsManager.getValueSafely(Reflection.getOrCreateKotlinClass(HighPowerWhiteListSettings.class));
        if (r0 == null) goto L5;
        return r0;
    L5:
        return DEFAULT;
    }
}
