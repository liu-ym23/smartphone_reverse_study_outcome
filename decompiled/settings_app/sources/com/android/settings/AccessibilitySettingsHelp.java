package com.android.settings;

import com.android.settings.servicemanager.IAccessibilitySettingsHelp;
import kotlin.Metadata;

/* JADX INFO: compiled from: AccessibilitySettingsHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/AccessibilitySettingsHelp;", "Lcom/android/settings/servicemanager/IAccessibilitySettingsHelp;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccessibilitySettingsHelp implements IAccessibilitySettingsHelp {
    public static final AccessibilitySettingsHelp INSTANCE = null;

    static {
        INSTANCE = new AccessibilitySettingsHelp();
    }

    private AccessibilitySettingsHelp() {
    }

    @Override // com.android.settings.servicemanager.IAccessibilitySettingsHelp
    public boolean isShowUserExperienceEntry() {
        return IAccessibilitySettingsHelp.DefaultImpls.isShowUserExperienceEntry(this);
    }
}
