package com.android.settingslib.drawer;

import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class SwitchesProvider extends EntriesProvider {
    public void com_android_settingslib_drawer_SwitchesProvider__onCreate$___twin___() {
        super.onCreate();
    }

    protected abstract List<SwitchController> createSwitchControllers();

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settingslib_drawer_SwitchesProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public SwitchesProvider() {
    }

    @Override // com.android.settingslib.drawer.EntriesProvider
    protected List<? extends EntryController> createEntryControllers() {
        return createSwitchControllers();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settingslib_drawer_SwitchesProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SwitchesProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settingslib_drawer_SwitchesProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
