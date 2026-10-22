package com.obric.safecheck;

import com.obric.securitycenter.api.settings.Introduction;
import com.obric.securitycenter.api.settings.Owner;
import com.obric.securitycenter.api.settings.Scope;
import com.obric.securitycenter.api.settings.SettingsKey;
import com.obric.securitycenter.api.settings.SettingsManager;
import com.obric.securitycenter.api.settings.Title;
import com.obric.securitycenter.api.settings.Value;
import com.obric.securitycenter.api.settings.scope.Security;
import com.obric.securitycenter.api.settings.scope.modules.AntiFraud;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AntiFraudWhiteListSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/AntiFraudOwnerSettings;", "", "()V", "DEFAULT", "", "getDEFAULT$annotations", "getDEFAULT", "()Ljava/lang/String;", "getValue", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
@Introduction("测试String")
@Owner("yejiongming.128")
@Title("测试String")
@Scope(business = Security.class, module = AntiFraud.class)
@SettingsKey("owner")
public final class AntiFraudOwnerSettings {

    @Value(isDefault = true)
    private static final String DEFAULT = null;
    public static final AntiFraudOwnerSettings INSTANCE = null;

    @JvmStatic
    public static /* synthetic */ void getDEFAULT$annotations() {
    }

    static {
        INSTANCE = new AntiFraudOwnerSettings();
        DEFAULT = "default";
    }

    private AntiFraudOwnerSettings() {
    }

    public static final String getDEFAULT() {
        return DEFAULT;
    }

    @JvmStatic
    public static final String getValue() {
        return (String) SettingsManager.getValueSafely(Reflection.getOrCreateKotlinClass(AntiFraudOwnerSettings.class));
    }
}
