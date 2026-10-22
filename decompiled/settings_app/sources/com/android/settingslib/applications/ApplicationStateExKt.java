package com.android.settingslib.applications;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.utils.NullSafe;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationStateEx.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0005¨\u0006\t"}, d2 = {"isDoppleganger", "", "Landroid/content/pm/ApplicationInfo;", "(Landroid/content/pm/ApplicationInfo;)Z", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "(Lcom/android/settingslib/applications/ApplicationsState$AppEntry;)Z", "ensureIconLockedEx", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ApplicationStateExKt {
    public static final boolean isDoppleganger(ApplicationsState.AppEntry r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (UserHandle.getUserId(r1.info.uid) != 10) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean ensureIconLockedEx(ApplicationsState.AppEntry r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.getPackageManager();
        if (r4.icon != null) goto L17;
        if (r4.apkFile == null) goto L15;
        File r0 = r4.apkFile;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        ApplicationInfo r6 = r4.info;
        Intrinsics.checkNotNullExpressionValue(r6, "info");
        r4.icon = ObricIconUtils.getDrawable(r6);
        return true;
    L9:
        if (r0.exists() != true) goto L11;
        r1 = true;
    L15:
        r4.mounted = false;
        r4.icon = r5.getResources().getDrawable(17305298);
    L29:
        return false;
    L17:
        if (r4.mounted == true) goto L29;
        if (r4.apkFile == null) goto L29;
        File r7 = r4.apkFile;
        if (r7 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L29;
        r4.mounted = true;
        ApplicationInfo r9 = r4.info;
        Intrinsics.checkNotNullExpressionValue(r9, "info");
        r4.icon = (Drawable) NullSafe.nonNull(ObricIconUtils.getDrawable(r9));
        return true;
    L23:
        if (r7.exists() != true) goto L25;
        r8 = true;
        goto L26
    }

    public static final boolean isDoppleganger(ApplicationInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (UserHandle.getUserId(r1.uid) != 10) goto L5;
        return true;
    L5:
        return false;
    }
}
