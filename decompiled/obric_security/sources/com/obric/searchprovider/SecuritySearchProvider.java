package com.obric.searchprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import com.obric.security.R;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.vault.feat.main.searchprovider.SecuritySearchData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecuritySearchProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016JM\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001bJ;\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001dR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/searchprovider/SecuritySearchProvider;", "Landroid/content/ContentProvider;", "()V", "searchData", "", "Lcom/obric/vault/feat/main/searchprovider/SecuritySearchData;", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "initSecuritySearchData", "", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", HealthModuleIds.UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecuritySearchProvider extends ContentProvider {
    private List<SecuritySearchData> searchData;

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }

    public SecuritySearchProvider() {
    }

    public final void initSecuritySearchData() {
        OSwitch.Companion r0 = OSwitch.Companion;
        String r7 = SecurityCenterApplication.getApplication().getString(R.string.reverse_wireless_charging);
        SecurityCenterApplication r4 = SecurityCenterApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r4, "SecurityCenterApplication.getApplication()");
        List r1 = CollectionsKt.listOf(new SecuritySearchData[]{new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.power_optimization), "com.obric.security/com.obric.security.battertpower.BatteryPowerActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.power_optimization), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.power_rank_label2), "com.obric.security/com.obric.security.battertpower.BatteryPowerActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.battery_power_rank_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.power_usage_battery_percentage), null, null, true, "system", "status_bar_show_battery_percent", null, String.valueOf(1), true, SecurityCenterApplication.getApplication().getString(R.string.power_usage_battery_percentage_path), null, 1094, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.power_usage_save_mode), "com.obric.security/com.obric.security.battertpower.BatteryPowerActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.power_usage_save_mode_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.low_battery_auto_enable), "com.obric.security/com.obric.security.battertpower.BatteryPowerActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.low_battery_auto_enable_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.fiveg_optimize), null, null, true, "global", Constants.SMT_5G_STATUS_KEY, null, String.valueOf(1), true, SecurityCenterApplication.getApplication().getString(R.string.fiveg_optimize_path), null, 1094, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.auto_sleep_mode), null, null, true, "global", Constants.POWER_SLEEP_MODE_ENABLE, null, "1", true, SecurityCenterApplication.getApplication().getString(R.string.auto_sleep_mode_path), null, 1094, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.battery_health_and_charging), "com.obric.security/com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.battery_health_and_charging_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.battery_capacity), "com.obric.security/com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.battery_capacity_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.smart_charging_mode_enabled), null, null, true, "system", Constants.SMART_CHARGING_MODE_ENABLED, null, "0", true, SecurityCenterApplication.getApplication().getString(R.string.smart_charging_mode_enabled_path), null, 1094, null), new SecuritySearchData(r7, "com.obric.security/com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity", null, false, null, null, null, null, r4.getResources().getBoolean(R.bool.config_support_reverse_wireless_charging), SecurityCenterApplication.getApplication().getString(R.string.reverse_wireless_charging_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.advanced_item_storage), "com.obric.security/com.bytedanceos.storage.StorageActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.advanced_item_storage_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.storage_free), "com.obric.security/com.bytedanceos.storage.StorageActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.storage_free_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.memory_junk_file_cleanup), "com.obric.security/com.bytedanceos.cleaner.CleanerActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.memory_junk_file_cleanup_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.memory_big_file_cleanup), "com.obric.security/com.obric.security.cleaner.bigfile.BigFileListActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.memory_big_file_cleanup_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.advanced_item_application), "com.android.settings/com.android.settings.applications.ManageApplicationsActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.advanced_item_application_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.scan_cache_trash_txt), "com.obric.security/com.bytedanceos.cleaner.cleardetail.TrashCacheActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.scan_cache_trash_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.scan_uninstall_trash_txt), "com.obric.security/com.bytedanceos.cleaner.cleardetail.TrashDeleteActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.scan_uninstall_trash_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.scan_package_trash_txt), "com.obric.security/com.bytedanceos.cleaner.cleardetail.UselessApkActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.scan_package_trash_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.clear_sdk_trash_system), "com.obric.security/com.bytedanceos.cleaner.cleardetail.SystemTrashActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.clear_sdk_trash_system_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.manager_application), "com.obric.security/com.bytedanceos.appmanager.ApplicationManagerActivitySettings", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.manager_application), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.system_app_manager), "com.obric.appstore/com.obric.appstore.sysapp.restore.SysAppManageActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.system_app_manager_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.doppelganger_title), "com.android.settings/com.android.settings.Settings$DoppelgangerSettingsActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.doppelganger_title_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.preferred_application), "com.android.settings/com.android.settings.Settings$PreferredActivityCategory", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.preferred_application_path), null, 1268, null)});
        if (ProductTypeUtils.INSTANCE.isNerida() == false) goto L5;
    L8:
        List r2 = CollectionsKt.listOf(new SecuritySearchData[]{new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.bypass_charging), "com.obric.security/com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity", null, false, null, null, null, null, ProductTypeUtils.INSTANCE.isNerida(), SecurityCenterApplication.getApplication().getString(R.string.bypass_charging_path), SecurityCenterApplication.getApplication().getString(R.string.bypass_charging_tip), OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.system_app_manager), "com.obric.appstore/com.obric.appstore.sysapp.restore.SysAppManageActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.system_app_manager_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.app_auto_update), "com.obric.appstore/com.obric.appstore.sysapp.restore.SysAppManageActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.system_app_manager_path), null, 1268, null), new SecuritySearchData(SecurityCenterApplication.getApplication().getString(R.string.system_app_install), "com.obric.appstore/com.obric.appstore.sysapp.restore.SysAppRestoreActivity", null, false, null, null, null, null, true, SecurityCenterApplication.getApplication().getString(R.string.system_app_install_path), null, 1268, null)});
    L9:
        this.searchData = CollectionsKt.plus(r1, r2);
        return;
    L5:
        if (ProductTypeUtils.INSTANCE.isPike() == true) goto L8;
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r13, String[] r14, String r15, String[] r16, String r17) {
        Intrinsics.checkNotNullParameter(r13, "uri");
        initSecuritySearchData();
        MatrixCursor r1 = new MatrixCursor(new String[]{"name", "intent", WsConstants.KEY_EXTRA, "isSwitch", "switchTable", "switchKey", "specialKey", "defValue", "isSearchable", "itemPath", "description"});
        List<SecuritySearchData> r0 = this.searchData;
        if (r0 == null) goto L5;
        if (r0 != null) goto L8;
        r0 = CollectionsKt.emptyList();
    L8:
        Iterator<SecuritySearchData> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L16;
        SecuritySearchData r3 = r2.next();
        if (r3.isSearchable() == false) goto L10;
        OLog.e("initSecuritySearchData", "query: " + r3.getName());
        r1.addRow(new Object[]{r3.getName(), r3.getIntent(), r3.getExtra(), Boolean.valueOf(r3.isSwitch()), r3.getSwitchTable(), r3.getSwitchKey(), r3.getSpecialKey(), r3.getDefValue(), Boolean.valueOf(r3.isSearchable()), r3.getItemPath(), r3.getDescription()});
        goto L10
    L16:
        return r1;
    L5:
        return r1;
    }
}
