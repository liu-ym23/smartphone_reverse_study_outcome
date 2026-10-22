package com.android.settings.utils;

import android.content.Context;
import bytedanceos.api.SettingsSmt;
import com.android.settings.search.Index;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsUtil {
    public SettingsUtil() {
    }

    public static String getAdditionalNotificationWidgets(Context r3, String r4) {
        List r5 = SettingsSmt.NOTIFICATION_WIDGET.getAllWidgets();
        List r6 = Arrays.asList(r4.split("\\|"));
        StringBuilder r0 = new StringBuilder();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        String r1 = (String) r7.next();
        if (r6.contains(r1) == true) goto L4;
        r0.append(r1).append(Index.ENTRIES_SEPARATOR);
        goto L4
    L8:
        int r8 = r0.length();
        if (r8 > 0) goto L18;
        return "";
    L18:
        return r0.substring(0, r8 - 1);
    }
}
