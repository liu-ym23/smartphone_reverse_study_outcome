package com.android.settings.core;

import android.text.TextUtils;
import com.android.settingslib.core.AbstractPreferenceController;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface PreferenceControllerMixin {
    public static final String TAG = "PrefControllerMixin";

    /* JADX WARN: Multi-variable type inference failed */
    default void updateNonIndexableKeys(List<String> r4) {
        if ((this instanceof AbstractPreferenceController) == false) goto L16;
        AbstractPreferenceController r0 = (AbstractPreferenceController) this;
        if (r0.isAvailable() == true) goto L17;
        String r1 = r0.getPreferenceKey();
        if (TextUtils.isEmpty(r1) == false) goto L11;
        OLog.w(TAG, "Skipping updateNonIndexableKeys due to empty key " + toString());
        return;
    L11:
        if (r4.contains(r1) == false) goto L14;
        OLog.w(TAG, "Skipping updateNonIndexableKeys, key already in list. " + toString());
        return;
    L14:
        r4.add(r1);
        return;
    L17:
        return;
    }
}
