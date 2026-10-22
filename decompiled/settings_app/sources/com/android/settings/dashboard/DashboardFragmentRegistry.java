package com.android.settings.dashboard;

import android.util.ArrayMap;
import com.android.settings.EmergencyDashboardFragment;
import com.android.settings.LegalSettings;
import com.android.settings.NetworkSettingsFragment;
import com.android.settings.notification.ConfigureNotificationSettings;
import com.android.settings.notification.SoundSettings;
import com.android.settingslib.drawer.CategoryKey;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DashboardFragmentRegistry {
    public static final Map<String, String> CATEGORY_KEY_TO_PARENT_MAP = null;
    public static final Map<String, String> PARENT_TO_CATEGORY_KEY_MAP = null;

    public DashboardFragmentRegistry() {
    }

    static {
        ArrayMap r0 = new ArrayMap();
        PARENT_TO_CATEGORY_KEY_MAP = r0;
        r0.put(NetworkSettingsFragment.class.getName(), CategoryKey.CATEGORY_DEVICE);
        r0.put(SoundSettings.class.getName(), CategoryKey.CATEGORY_SOUND);
        r0.put(ConfigureNotificationSettings.class.getName(), CategoryKey.CATEGORY_NOTIFICATIONS);
        r0.put(LegalSettings.class.getName(), CategoryKey.CATEGORY_ABOUT_LEGAL);
        r0.put(EmergencyDashboardFragment.class.getName(), CategoryKey.CATEGORY_EMERGENCY);
        CATEGORY_KEY_TO_PARENT_MAP = new ArrayMap(r0.size());
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        CATEGORY_KEY_TO_PARENT_MAP.put((String) r2.getValue(), (String) r2.getKey());
        goto L4
    }
}
