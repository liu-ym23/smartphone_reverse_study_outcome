package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.settings.R;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.servicemanager.IEmergencyHelp;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.android.settingslib.drawer.CategoryKey;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OtherAppSettingItems extends SettingItems {
    private static final String META_DATA_KEY_INTENT_ACTION = "com.android.settings.intent.action";
    private static final ArrayMap<String, List<Integer>> PATH_TO_CATEGORY_KEY_MAP = null;
    private final String ACCOUNT_PACKAGE_NAME;
    private final String ACTION;
    private final String CLOUD_SERVICE_PACKAGE_NAME;
    private final String TAG;

    public static class ItemsColumns {
        public static final String DEFAULT_VALUE = "defValue";
        public static final String DESCRIPTION = "description";
        public static final String INTENT_COMPONENT = "intent";
        public static final String INTENT_EXTRA = "extra";
        public static final String IS_SEARCHABLE = "isSearchable";
        public static final String IS_SWITCH = "isSwitch";
        public static final String ITEM_PATH_1 = "itemPath";
        public static final String NAME = "name";
        public static final String SPECIAL_KEY = "specialKey";
        public static final String SWITCH_KEY = "switchKey";
        public static final String SWITCH_TABLE = "switchTable";

        public ItemsColumns() {
        }
    }

    public static /* synthetic */ int $r8$lambda$uBsCIBAbAW1p84hPJ6ULJah0SPE(Integer r0) {
        return r0.intValue();
    }

    public OtherAppSettingItems(Context r1) {
        super(r1);
        this.TAG = "OtherAppSettingItems";
        this.ACTION = "android.content.action.OBRIC_SEARCH_INDEXABLES_PROVIDER";
        this.ACCOUNT_PACKAGE_NAME = "com.obric.account";
        this.CLOUD_SERVICE_PACKAGE_NAME = "com.obric.cloudservice";
    }

    static {
        ArrayMap<String, List<Integer>> r0 = new ArrayMap();
        PATH_TO_CATEGORY_KEY_MAP = r0;
        r0.put(CategoryKey.CATEGORY_DEVICE, List.of(Integer.valueOf(R.string.more_network_settings)));
        r0.put(CategoryKey.CATEGORY_HOMEPAGE, List.of());
        IEmergencyHelp r1 = (IEmergencyHelp) ServiceManager.getService(IEmergencyHelp.class);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isShowEmergency() == false) goto L9;
        r0.put(CategoryKey.CATEGORY_EMERGENCY, List.of(Integer.valueOf(R.string.emergency_settings_preference_title)));
        return;
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        performSearchIndexes(this.mContext);
        performDashboardIndex();
    }

    public void updateAccountItems(Handler r12, SQLiteDatabase r13) {
        if (OAccountHelper.isLogin() == false) goto L5;
        String r0 = "1";
    L6:
        this.mItemList.clear();
        performSearchIndexes(this.mContext, "com.obric.account");
        performSearchIndexes(this.mContext, "com.obric.cloudservice");
        Iterator<SettingItems.Items> r10 = this.mItemList.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        SettingItems.Items r1 = r10.next();
        String r5 = r0;
        executeUpdate(r12, this.mContext, r13, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r5, "name", r1.name);
        goto L8
    L10:
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public void updateDashboardItems(Handler r11, SQLiteDatabase r12) {
        this.mItemList.clear();
        performDashboardIndex();
        Iterator<SettingItems.Items> r9 = this.mItemList.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        SettingItems.Items r1 = r9.next();
        executeUpdate(r11, this.mContext, r12, "intent", r1.intent, "name", r1.name);
        goto L4
    }

    private void performSearchIndexes(Context r4) {
        Intent r0 = new Intent("android.content.action.OBRIC_SEARCH_INDEXABLES_PROVIDER");
        Iterator<ResolveInfo> r1 = r4.getPackageManager().queryIntentContentProviders(r0, 0).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ResolveInfo r2 = r1.next();
        if (isWellKnownProvider(r4, r2) == false) goto L4;
        String r3 = r2.providerInfo.authority;
        addIndexablesFromRemoteProvider(r4, r2.providerInfo.packageName, r3);
        goto L4
    }

    private void performSearchIndexes(Context r4, String r5) {
        Intent r0 = new Intent("android.content.action.OBRIC_SEARCH_INDEXABLES_PROVIDER");
        Iterator<ResolveInfo> r1 = r4.getPackageManager().queryIntentContentProviders(r0, 0).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        ResolveInfo r2 = r1.next();
        if (isWellKnownProvider(r4, r2) == false) goto L4;
        String r3 = r2.providerInfo.authority;
        String r6 = r2.providerInfo.packageName;
        if (r5 == null) goto L4;
        if (r5.equals(r6) == false) goto L4;
        addIndexablesFromRemoteProvider(r4, r5, r3);
        goto L4
    }

    private void addIndexablesFromRemoteProvider(Context r5, String r6, String r7) {
        OLog.d("OtherAppSettingItems", "addIndexablesFromRemoteProvider packageName: " + r6);     // Catch: PackageManager.NameNotFoundException -> L5
        getIndexablesForRawDataUri(r5.createPackageContext(r6, 0), r6, Uri.parse("content://" + r7 + "/raw_data"));     // Catch: PackageManager.NameNotFoundException -> L5
        return;
    L5:
        OLog.w("OtherAppSettingItems", "Could not create context for " + r6);
    }

    private void getIndexablesForRawDataUri(Context r28, String r29, Uri r30) {
        Cursor r1 = r28.getContentResolver().query(r30, null, null, null, null);
        if (r1 != null) goto L18;
        OLog.w("OtherAppSettingItems", "Cannot add index data for Uri: " + r30.toString());
        return;
    L18:
    L15:
        th = move-exception;
        r1.close();
        throw th;
    L7:
        if (r1.getCount() <= 0) goto L13;
        int r2 = r1.getColumnIndex("name");     // Catch: Throwable -> L15
        int r3 = r1.getColumnIndex("intent");     // Catch: Throwable -> L15
        int r4 = r1.getColumnIndex("extra");     // Catch: Throwable -> L15
        int r5 = r1.getColumnIndex(ItemsColumns.IS_SWITCH);     // Catch: Throwable -> L15
        int r6 = r1.getColumnIndex(ItemsColumns.SWITCH_TABLE);     // Catch: Throwable -> L15
        int r7 = r1.getColumnIndex(ItemsColumns.SWITCH_KEY);     // Catch: Throwable -> L15
        int r8 = r1.getColumnIndex(ItemsColumns.SPECIAL_KEY);     // Catch: Throwable -> L15
        int r9 = r1.getColumnIndex(ItemsColumns.DEFAULT_VALUE);     // Catch: Throwable -> L15
        int r10 = r1.getColumnIndex(ItemsColumns.IS_SEARCHABLE);     // Catch: Throwable -> L15
        int r11 = r1.getColumnIndex(ItemsColumns.ITEM_PATH_1);     // Catch: Throwable -> L15
        int r12 = r1.getColumnIndex("description");     // Catch: Throwable -> L15
    L10:
        if (r1.moveToNext() == false) goto L13;
        String r16 = r1.getString(r2);     // Catch: Throwable -> L15
        String r17 = r1.getString(r3);     // Catch: Throwable -> L15
        String r18 = r1.getString(r4);     // Catch: Throwable -> L15
        String r13 = r1.getString(r5);     // Catch: Throwable -> L15
        String r20 = r1.getString(r6);     // Catch: Throwable -> L15
        String r21 = r1.getString(r7);     // Catch: Throwable -> L15
        String r22 = r1.getString(r8);     // Catch: Throwable -> L15
        String r23 = r1.getString(r9);     // Catch: Throwable -> L15
        String r14 = r1.getString(r10);     // Catch: Throwable -> L15
        int r210 = r2;
        int r211 = r3;
        this.mItemList.add(new SettingItems.Items(this, r16, r17, r18, "true".equals(r13), r20, r21, r22, r23, "true".equals(r14), r1.getString(r11), r1.getString(r12)));     // Catch: Throwable -> L15
        r2 = r210;
        r3 = r211;
    L13:
        r1.close();
    }

    boolean isWellKnownProvider(Context r5, ResolveInfo r6) {
        String r0 = r6.providerInfo.authority;
        String r1 = r6.providerInfo.applicationInfo.packageName;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        String r2 = r6.providerInfo.readPermission;
        String r7 = r6.providerInfo.writePermission;
        if (TextUtils.isEmpty(r2) == true) goto L19;
        if (TextUtils.isEmpty(r7) == true) goto L19;
        if ("android.permission.READ_SEARCH_INDEXABLES".equals(r2) == false) goto L19;
        if ("android.permission.READ_SEARCH_INDEXABLES".equals(r7) == false) goto L19;
        return isPrivilegedPackage(r1, r5);
    }

    private boolean isPrivilegedPackage(String r1, Context r2) {
        if ((r2.getPackageManager().getPackageInfo(r1, 0).applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    private void performDashboardIndex() {
        List<DashboardCategory> r0 = FeatureFactory.getFeatureFactory().getDashboardFeatureProvider().getAllCategories();
        OLog.d("OtherAppSettingItems", "categories size: " + r0.size());
        if (r0.isEmpty() == false) goto L6;
        OLog.d("OtherAppSettingItems", "NO dashboard tiles for OtherAppSettingItems");
        return;
    L6:
        Iterator<DashboardCategory> r15 = r0.iterator();
    L8:
        if (r15.hasNext() == false) goto L63;
        DashboardCategory r1 = r15.next();
        List<Tile> r2 = r1.getTiles();
        if (r2 == null) goto L11;
        Iterator<Tile> r16 = r2.iterator();
    L15:
        if (r16.hasNext() == false) goto L8;
        Tile r12 = r16.next();
        if (r12.getTitle(this.mContext) != null) goto L19;
        String r3 = getDashboardTitle(r12);
    L20:
        String r11 = r3;
        Bundle r4 = r12.getMetaData();
        if (r4 == null) goto L23;
        String r5 = r4.getString(META_DATA_KEY_INTENT_ACTION);
    L24:
        Intent r6 = new Intent(r12.getIntent());
        r6.putExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, 0);
        if (r5 == null) goto L27;
        r6.setAction(r5);
    L27:
        String r10 = "intent=" + r6.toURI();
        if (r12.getType() != Tile.Type.SWITCH_WITH_ACTION) goto L30;
    L33:
        boolean r7 = true;
    L34:
        String r8 = r12.getKey(this.mContext);
        if (r12.isSearchable() == false) goto L41;
        if (r7 == true) goto L41;
        if (PATH_TO_CATEGORY_KEY_MAP.get(r12.getCategory()) == null) goto L41;
        if (r11 == null) goto L41;
        boolean r9 = true;
    L42:
        ArrayMap<String, List<Integer>> r13 = PATH_TO_CATEGORY_KEY_MAP;
        String r18 = "";
        if (r13.get(r12.getCategory()) == null) goto L49;
        List<Integer> r14 = r13.get(r12.getCategory());
        if (r14 == null) goto L49;
        if (r14.isEmpty() == true) goto L49;
        String r17 = buildPath(r14.stream().mapToInt(new OtherAppSettingItems$$ExternalSyntheticLambda0()).toArray());
    L51:
        if (r17.isEmpty() == false) goto L53;
        String r19 = r11;
    L59:
        if (r9 == false) goto L61;
        boolean r20 = r9;
        this.mItemList.add(new SettingItems.Items(this, r11, r10, null, r7, null, null, r8, null, r20, r19, null));
    L62:
        OLog.d("OtherAppSettingItems", "add " + r11 + HanziToPinyin.Token.SEPARATOR + r10 + HanziToPinyin.Token.SEPARATOR + r12.getCategory() + HanziToPinyin.Token.SEPARATOR + r12.getKey(this.mContext) + HanziToPinyin.Token.SEPARATOR + r20 + HanziToPinyin.Token.SEPARATOR + r10);
        goto L15
    L61:
        r20 = r9;
        goto L62
    L53:
        String[] r21 = new String[2];
        r21[0] = r17;
        if (r11 == null) goto L57;
        r18 = r11;
    L57:
        r21[1] = r18;
        r19 = buildPath(r21);
    L49:
        r17 = "";
    L41:
        r9 = false;
        goto L42
    L30:
        if (r12.getType() == Tile.Type.SWITCH) goto L33;
        r7 = false;
        goto L34
    L23:
        r5 = null;
        goto L24
    L19:
        r3 = r12.getTitle(this.mContext).toString();
        goto L20
    L11:
        OLog.d("OtherAppSettingItems", "tile list is empty, skipping category " + r1.key);
        return;
    }

    private String getDashboardTitle(Tile r1) {
        return FeatureFactory.getFeatureFactory().getDashboardFeatureProvider().getTitleFromUri(r1);
    }
}
