package com.obric.securitycenter.api.settings.scope.modules;

import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.settings.IScope;
import com.obric.securitycenter.api.settings.SettingsKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: AntiFraud.kt */
/* JADX INFO: loaded from: classes3.dex */
@SettingsKey("anti_fraud")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/api/settings/scope/modules/AntiFraud;", "Lcom/obric/securitycenter/api/settings/IScope;", "()V", "chinese", "", "getChinese", "()Ljava/lang/String;", "english", "getEnglish", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AntiFraud implements IScope {
    @Override // com.obric.securitycenter.api.settings.IScope
    public String getChinese() {
        return CheckResult.THREAT_FRAUD;
    }

    @Override // com.obric.securitycenter.api.settings.IScope
    public String getEnglish() {
        return "AntiFraud";
    }

    public AntiFraud() {
    }
}
