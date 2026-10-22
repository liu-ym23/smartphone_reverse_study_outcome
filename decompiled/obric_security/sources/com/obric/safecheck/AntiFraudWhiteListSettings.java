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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AntiFraudWhiteListSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/AntiFraudWhiteListSettings;", "", "()V", "DEFAULT", "", "Lcom/obric/safecheck/WhitePackageItem;", "getDEFAULT$annotations", "getDEFAULT", "()Ljava/util/List;", "getValue", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
@Introduction("白名单应用列表，白名单中的应用会在安装时被豁免反诈检查")
@Owner("yejiongming.128")
@Title("反诈白名单应用列表")
@Scope(business = Security.class, module = AntiFraud.class)
@SettingsKey("white_packages")
public final class AntiFraudWhiteListSettings {

    @Value(isDefault = true)
    private static final List<WhitePackageItem> DEFAULT = null;
    public static final AntiFraudWhiteListSettings INSTANCE = null;

    @JvmStatic
    public static /* synthetic */ void getDEFAULT$annotations() {
    }

    static {
        INSTANCE = new AntiFraudWhiteListSettings();
        DEFAULT = CollectionsKt.emptyList();
    }

    private AntiFraudWhiteListSettings() {
    }

    public static final List<WhitePackageItem> getDEFAULT() {
        return DEFAULT;
    }

    @JvmStatic
    public static final List<WhitePackageItem> getValue() {
        return (List) SettingsManager.getValueSafely(Reflection.getOrCreateKotlinClass(AntiFraudWhiteListSettings.class));
    }
}
