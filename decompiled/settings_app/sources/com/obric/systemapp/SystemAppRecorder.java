package com.obric.systemapp;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.android.settings.Constants;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemAppRecorder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/systemapp/SystemAppRecorder;", "", "()V", "appUninstallDescMap", "", "", "", "getUninstallDescription", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "context", "Landroid/content/Context;", "initDefaultSystemApps", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SystemAppRecorder {
    public static final SystemAppRecorder INSTANCE = null;
    private static final Map<String, Integer> appUninstallDescMap = null;

    private SystemAppRecorder() {
    }

    static {
        SystemAppRecorder r0 = new SystemAppRecorder();
        INSTANCE = r0;
        appUninstallDescMap = new ArrayMap();
        r0.initDefaultSystemApps();
    }

    private final void initDefaultSystemApps() {
        Map<String, Integer> r3 = appUninstallDescMap;
        Integer r0 = Integer.valueOf(R.string.uninstall_tip);
        r3.put("com.obric.securitymanager", r0);
        r3.put("com.obric.clock", r0);
        r3.put("com.obric.calculator", r0);
        r3.put("com.obric.compass", r0);
        r3.put("com.obric.weather", r0);
        r3.put("com.obric.feedbackserviceproject", r0);
        r3.put("com.obric.filemanager", Integer.valueOf(R.string.uninstall_tip_2));
        Integer r1 = Integer.valueOf(R.string.uninstall_tip_3);
        r3.put(Constants.PACKAGE_NOTES, r1);
        r3.put("com.obric.calendar", r1);
        r3.put("com.obric.recorder", r1);
        r3.put("com.larus.nova", Integer.valueOf(R.string.uninstall_tip_4));
        r3.put("com.obric.onetaplock", r0);
    }

    public final String getUninstallDescription(String r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r2, "context");
        Integer r0 = appUninstallDescMap.get(r1);
        if (r0 == null) goto L5;
        int r3 = r0.intValue();
    L6:
        String r4 = r2.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        return r4;
    L5:
        r3 = R.string.uninstall_tip;
        goto L6
    }
}
