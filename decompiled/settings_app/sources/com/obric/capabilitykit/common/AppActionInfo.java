package com.obric.capabilitykit.common;

import android.icu.text.PluralRules;
import com.android.settings.NotificationDisplayDetailsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/AppActionInfo;", "", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "appName", "action", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getAppName", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppActionInfo {
    private final String action;
    private final String appName;
    private final String packageName;

    public AppActionInfo(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.packageName = r2;
        this.appName = r3;
        this.action = r4;
    }

    public static /* synthetic */ AppActionInfo copy$default(AppActionInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.appName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.action;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.action;
    }

    public final AppActionInfo copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, "action");
        return new AppActionInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppActionInfo) == true) goto L8;
        return false;
    L8:
        AppActionInfo r6 = (AppActionInfo) r5;
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((this.packageName.hashCode() * 31) + this.appName.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "AppActionInfo(packageName=" + this.packageName + ", appName=" + this.appName + ", action=" + this.action + ')';
    }
}
