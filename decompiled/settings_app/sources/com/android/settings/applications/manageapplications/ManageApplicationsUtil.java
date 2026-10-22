package com.android.settings.applications.manageapplications;

import android.content.Context;
import android.util.FeatureFlagUtils;
import com.android.settings.MainSettings;
import com.android.settings.Settings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ManageApplicationsUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007R\"\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0016\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/settings/applications/manageapplications/ManageApplicationsUtil;", "", "()V", "LIST_TYPE_CLASS_MAP", "", "Lkotlin/reflect/KClass;", "Lcom/android/settings/MainSettings;", "", "LIST_TYPE_MAP", "", "kotlin.jvm.PlatformType", "getSpaDestination", "context", "Landroid/content/Context;", ManageApplications.EXTRA_LIST_TYPE, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ManageApplicationsUtil {
    public static final ManageApplicationsUtil INSTANCE = null;
    private static final Map<KClass<? extends MainSettings>, Integer> LIST_TYPE_CLASS_MAP = null;
    public static final Map<String, Integer> LIST_TYPE_MAP = null;

    private ManageApplicationsUtil() {
    }

    static {
        INSTANCE = new ManageApplicationsUtil();
        Map<KClass<? extends MainSettings>, Integer> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.UsageAccessSettingsActivity.class), 4), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.OverlaySettingsActivity.class), 6), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.AppDrawOverlaySettingsActivity.class), 6), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.WriteSettingsActivity.class), 7), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.ManageExternalSourcesActivity.class), 8), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.ChangeWifiStateActivity.class), 10), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.ManageExternalStorageActivity.class), 11), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.MediaManagementAppsActivity.class), 13), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.AlarmsAndRemindersActivity.class), 12), TuplesKt.to(Reflection.getOrCreateKotlinClass(Settings.TurnScreenOnSettingsActivity.class), 19)});
        LIST_TYPE_CLASS_MAP = r0;
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
        Iterator<T> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.put(JvmClassMappingKt.getJavaClass((KClass) r3.getKey()).getName(), r3.getValue());
        goto L4
    L6:
        LIST_TYPE_MAP = r1;
    }

    @JvmStatic
    public static final String getSpaDestination(Context r0, int r1) {
        Intrinsics.checkNotNullParameter(r0, "context");
        FeatureFlagUtils.isEnabled(r0, "settings_enable_spa");
        return null;
    }
}
