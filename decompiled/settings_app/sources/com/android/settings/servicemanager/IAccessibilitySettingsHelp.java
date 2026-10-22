package com.android.settings.servicemanager;

import kotlin.Metadata;

/* JADX INFO: compiled from: IAccessibilitySettingsHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/android/settings/servicemanager/IAccessibilitySettingsHelp;", "", "isShowUserExperienceEntry", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IAccessibilitySettingsHelp {

    /* JADX INFO: compiled from: IAccessibilitySettingsHelp.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isShowUserExperienceEntry(IAccessibilitySettingsHelp r0) {
            return true;
        }
    }

    boolean isShowUserExperienceEntry();
}
