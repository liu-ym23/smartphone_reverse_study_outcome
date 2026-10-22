package com.android.settings;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WallpaperTypeSettings extends SettingsPreferenceFragment implements Indexable {
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;

    public void com_android_settings_WallpaperTypeSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_uri_wallpaper;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WallpaperTypeSettings() {
    }

    public void com_android_settings_WallpaperTypeSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        addPreferencesFromResource(R.xml.wallpaper_settings);
        populateWallpaperTypes();
    }

    private void populateWallpaperTypes() {
        Intent r0 = new Intent("android.intent.action.SET_WALLPAPER");
        PackageManager r1 = getPackageManager();
        List<ResolveInfo> r2 = r1.queryIntentActivities(r0, 65536);
        PreferenceScreen r3 = getPreferenceScreen();
        r3.setOrderingAsAdded(false);
        Iterator<ResolveInfo> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ResolveInfo r5 = r4.next();
        Preference r6 = new Preference(getPrefContext());
        r6.setLayoutResource(R.layout.preference_wallpaper_type);
        Intent r7 = new Intent(r0);
        r7.setComponent(new ComponentName(r5.activityInfo.packageName, r5.activityInfo.name));
        r6.setIntent(r7);
        CharSequence r8 = r5.loadLabel(r1);
        if (r8 != null) goto L8;
        r8 = r5.activityInfo.packageName;
    L8:
        r6.setTitle(r8);
        r6.setIcon(r5.loadIcon(r1));
        r3.addPreference(r6);
        goto L4
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass1();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WallpaperTypeSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WallpaperTypeSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WallpaperTypeSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WallpaperTypeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WallpaperTypeSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WallpaperTypeSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
