package com.obric.safecheck.task;

import com.obric.safecheck.riskcontrol.api.model.RiskInstallSource;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PackageAddedTasks.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"mapInstallerPackageToInstallSource", "Lcom/obric/safecheck/riskcontrol/api/model/RiskInstallSource;", "installerPackageName", "", "safecheck_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class PackageAddedTasksKt {
    public static final RiskInstallSource mapInstallerPackageToInstallSource(String r2) {
        if (r2 == null) goto L6;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L6;
        Locale r0 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r0, "Locale.US");
        String r4 = r3.toLowerCase(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(locale)");
    L7:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (StringsKt.isBlank(r4) == false) goto L13;
        return RiskInstallSource.PM_INSTALL;
    L13:
        if (Intrinsics.areEqual(r4, "com.android.shell") == false) goto L16;
        return RiskInstallSource.ADB;
    L16:
        return RiskInstallSource.USER_CLICK;
    L6:
        r4 = null;
        goto L7
    }
}
