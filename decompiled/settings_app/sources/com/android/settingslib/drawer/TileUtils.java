package com.android.settingslib.drawer;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TileUtils {
    private static final boolean DEBUG_TIMING = false;
    static final String EXTRA_CATEGORY_KEY = "com.android.settings.category";
    static final String EXTRA_PREFERENCE_ICON_PACKAGE = "com.android.settings.icon_package";
    public static final String EXTRA_SETTINGS_ACTION = "com.android.settings.action.EXTRA_SETTINGS";
    public static final String IA_SETTINGS_ACTION = "com.android.settings.action.IA_SETTINGS";
    private static final String LOG_TAG = "TileUtils";
    private static final String MANUFACTURER_DEFAULT_CATEGORY = "com.android.settings.category.device";
    private static final String MANUFACTURER_SETTINGS = "com.android.settings.MANUFACTURER_APPLICATION_SETTING";
    public static final String META_DATA_KEY_ORDER = "com.android.settings.order";
    public static final String META_DATA_KEY_PROFILE = "com.android.settings.profile";
    public static final String META_DATA_NEW_TASK = "com.android.settings.new_task";
    public static final String META_DATA_PREFERENCE_GROUP_KEY = "com.android.settings.group_key";
    public static final String META_DATA_PREFERENCE_ICON = "com.android.settings.icon";
    public static final String META_DATA_PREFERENCE_ICON_BACKGROUND_ARGB = "com.android.settings.bg.argb";
    public static final String META_DATA_PREFERENCE_ICON_BACKGROUND_HINT = "com.android.settings.bg.hint";
    public static final String META_DATA_PREFERENCE_ICON_TINTABLE = "com.android.settings.icon_tintable";
    public static final String META_DATA_PREFERENCE_ICON_URI = "com.android.settings.icon_uri";
    public static final String META_DATA_PREFERENCE_KEYHINT = "com.android.settings.keyhint";
    public static final String META_DATA_PREFERENCE_PENDING_INTENT = "com.android.settings.pending_intent";
    public static final String META_DATA_PREFERENCE_SEARCHABLE = "com.android.settings.searchable";
    public static final String META_DATA_PREFERENCE_SUMMARY = "com.android.settings.summary";
    public static final String META_DATA_PREFERENCE_SUMMARY_URI = "com.android.settings.summary_uri";
    public static final String META_DATA_PREFERENCE_SWITCH_URI = "com.android.settings.switch_uri";
    public static final String META_DATA_PREFERENCE_TITLE = "com.android.settings.title";
    public static final String META_DATA_PREFERENCE_TITLE_URI = "com.android.settings.title_uri";
    private static final String OPERATOR_DEFAULT_CATEGORY = "com.android.settings.category.wireless";
    private static final String OPERATOR_SETTINGS = "com.android.settings.OPERATOR_APPLICATION_SETTING";
    public static final String PROFILE_ALL = "all_profiles";
    public static final String PROFILE_PRIMARY = "primary_profile_only";
    private static final String SETTINGS_ACTION = "com.android.settings.action.SETTINGS";
    static final String SETTING_PKG = "com.android.settings";

    public TileUtils() {
    }

    public static List<DashboardCategory> getCategories(Context r11, Map<Pair<String, String>, Tile> r12) {
        System.currentTimeMillis();
        boolean r2 = false;
        if (Settings.Global.getInt(r11.getContentResolver(), "device_provisioned", 0) == 0) goto L5;
        r2 = true;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<UserHandle> r1 = ((UserManager) r11.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserProfiles().iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        UserHandle r10 = r1.next();
        if (r10.getIdentifier() != ActivityManager.getCurrentUser()) goto L11;
        loadTilesForAction(r11, r10, SETTINGS_ACTION, r12, null, r0, true);
        loadTilesForAction(r11, r10, OPERATOR_SETTINGS, r12, OPERATOR_DEFAULT_CATEGORY, r0, false);
        loadTilesForAction(r11, r10, MANUFACTURER_SETTINGS, r12, MANUFACTURER_DEFAULT_CATEGORY, r0, false);
    L11:
        if (r2 == false) goto L7;
        loadTilesForAction(r11, r10, EXTRA_SETTINGS_ACTION, r12, null, r0, false);
        loadTilesForAction(r11, r10, IA_SETTINGS_ACTION, r12, null, r0, false);
        goto L7
    L13:
        HashMap r13 = new HashMap();
        Iterator r14 = r0.iterator();
    L15:
        if (r14.hasNext() == false) goto L20;
        Tile r3 = (Tile) r14.next();
        String r4 = r3.getCategory();
        DashboardCategory r5 = (DashboardCategory) r13.get(r4);
        if (r5 != null) goto L19;
        r5 = new DashboardCategory(r4);
        r13.put(r4, r5);
    L19:
        r5.addTile(r3);
        goto L15
    L20:
        ArrayList r15 = new ArrayList(r13.values());
        Iterator r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        ((DashboardCategory) r16.next()).sortTiles();
        goto L22
    L24:
        return r15;
    }

    static void loadTilesForAction(Context r7, UserHandle r8, String r9, Map<Pair<String, String>, Tile> r10, String r11, List<Tile> r12, boolean r13) {
        Intent r6 = new Intent(r9);
        if (r13 == false) goto L5;
        r6.setPackage("com.android.settings");
    L5:
        loadActivityTiles(r7, r8, r10, r11, r12, r6);
        loadProviderTiles(r7, r8, r10, r11, r12, r6);
    }

    private static void loadActivityTiles(Context r9, UserHandle r10, Map<Pair<String, String>, Tile> r11, String r12, List<Tile> r13, Intent r14) {
        Iterator r15 = r9.getPackageManager().queryIntentActivitiesAsUser(r14, 128, r10.getIdentifier()).iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        ResolveInfo r0 = (ResolveInfo) r15.next();
        if (r0.system == false) goto L4;
        ActivityInfo r8 = r0.activityInfo;
        loadTile(r10, r11, r12, r13, r14, r8.metaData, r8);
        goto L4
    }

    private static void loadProviderTiles(Context r14, UserHandle r15, Map<Pair<String, String>, Tile> r16, String r17, List<Tile> r18, Intent r19) {
        Iterator r0 = r14.getPackageManager().queryIntentContentProvidersAsUser(r19, 0, r15.getIdentifier()).iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        ResolveInfo r1 = (ResolveInfo) r0.next();
        if (r1.system == false) goto L4;
        ProviderInfo r2 = r1.providerInfo;
        List<Bundle> r3 = getEntryDataFromProvider(r14.createContextAsUser(r15, 0), r2.authority);
        if (r3 == null) goto L4;
        if (r3.isEmpty() == true) goto L4;
        Iterator<Bundle> r13 = r3.iterator();
    L15:
        if (r13.hasNext() == false) goto L4;
        loadTile(r15, r16, r17, r18, r19, r13.next(), r2);
        goto L15
    }

    private static void loadTile(UserHandle r5, Map<Pair<String, String>, Tile> r6, String r7, List<Tile> r8, Intent r9, Bundle r10, ComponentInfo r11) {
        if (r5.getIdentifier() != ActivityManager.getCurrentUser()) goto L5;
    L8:
        String r0 = EXTRA_CATEGORY_KEY;
        if (r10 != null) goto L11;
    L12:
        if (r7 != null) goto L18;
        StringBuilder r12 = new StringBuilder("Found ").append(r11.name).append(" for intent ").append(r9).append(" missing metadata ");
        if (r10 != null) goto L16;
        r0 = "";
    L16:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, r12.append(r0).toString());
        return;
    L18:
        String r13 = r10.getString(EXTRA_CATEGORY_KEY);
        boolean r14 = r11 instanceof ProviderInfo;
        if (r14 == false) goto L21;
        Pair<String, String> r1 = new Pair(((ProviderInfo) r11).authority, r10.getString(META_DATA_PREFERENCE_KEYHINT));
    L22:
        Tile r2 = r6.get(r1);
        if (r2 != null) goto L28;
        if (r14 == false) goto L26;
        Tile r15 = new ProviderTile((ProviderInfo) r11, r13, r10);
    L27:
        r2 = r15;
        r6.put(r1, r2);
    L29:
        r2.setGroupKey(r10.getString(META_DATA_PREFERENCE_GROUP_KEY));
        if (r2.userHandle.contains(r5) == true) goto L33;
        r2.userHandle.add(r5);
    L33:
        if (r10.containsKey(META_DATA_PREFERENCE_PENDING_INTENT) == false) goto L36;
        r2.pendingIntentMap.put(r5, (PendingIntent) r10.getParcelable(META_DATA_PREFERENCE_PENDING_INTENT));
    L36:
        if (r8.contains(r2) == true) goto L39;
        r8.add(r2);
        return;
    L39:
        return;
    L26:
        r15 = new ActivityTile((ActivityInfo) r11, r13);
        goto L27
    L28:
        r2.setMetaData(r10);
        goto L29
    L21:
        r1 = new Pair(r11.packageName, r11.name);
        goto L22
    L11:
        if (r10.containsKey(EXTRA_CATEGORY_KEY) == true) goto L18;
    L5:
        if (Tile.isPrimaryProfileOnly(r11.metaData) == false) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Found " + r11.name + " for intent " + r9 + " is primary profile only, skip loading tile for uid " + r5.getIdentifier());
    }

    static Bundle getEntryDataFromProvider(Context r3, String r4, String r5) {
        ArrayMap r0 = new ArrayMap();
        Bundle r1 = getBundleFromUri(r3, buildUri(r4, EntriesProvider.METHOD_GET_ENTRY_DATA, r5), r0, null);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return getBundleFromUri(r3, buildUri(r4, EntriesProvider.METHOD_GET_SWITCH_DATA, r5), r0, null);
    }

    private static List<Bundle> getEntryDataFromProvider(Context r3, String r4) {
        ArrayMap r0 = new ArrayMap();
        Bundle r1 = getBundleFromUri(r3, buildUri(r4, EntriesProvider.METHOD_GET_ENTRY_DATA), r0, null);
        if (r1 != null) goto L5;
        Bundle r5 = getBundleFromUri(r3, buildUri(r4, EntriesProvider.METHOD_GET_SWITCH_DATA), r0, null);
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getParcelableArrayList(EntriesProvider.EXTRA_SWITCH_DATA);
    L5:
        return r1.getParcelableArrayList(EntriesProvider.EXTRA_ENTRY_DATA);
    }

    public static Uri getCompleteUri(Tile r2, String r3, String r4) {
        String r5 = r2.getMetaData().getString(r3);
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        Uri r0 = Uri.parse(r5);
        List<String> r1 = r0.getPathSegments();
        if (r1 != null) goto L9;
    L11:
        String r6 = r2.getMetaData().getString(META_DATA_PREFERENCE_KEYHINT);
        if (TextUtils.isEmpty(r6) == false) goto L16;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Please specify the meta-data com.android.settings.keyhint in AndroidManifest.xml for " + r5);
        return buildUri(r0.getAuthority(), r4);
    L16:
        return buildUri(r0.getAuthority(), r4, r6);
    L9:
        if (r1.isEmpty() == true) goto L11;
        return r0;
    }

    static Uri buildUri(String r2, String r3, String r4) {
        return new Uri.Builder().scheme("content").authority(r2).appendPath(r3).appendPath(r4).build();
    }

    private static Uri buildUri(String r2, String r3) {
        return new Uri.Builder().scheme("content").authority(r2).appendPath(r3).build();
    }

    public static Pair<String, Integer> getIconFromUri(Context r3, String r4, Uri r5, Map<String, IContentProvider> r6) {
        Bundle r7 = getBundleFromUri(r3, r5, r6, null);
        if (r7 != null) goto L5;
        return null;
    L5:
        String r8 = r7.getString(EXTRA_PREFERENCE_ICON_PACKAGE);
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return null;
    L8:
        int r9 = r7.getInt(META_DATA_PREFERENCE_ICON, 0);
        if (r9 != 0) goto L12;
        return null;
    L12:
        if (r8.equals(r4) == true) goto L18;
        if (r8.equals(r3.getPackageName()) == true) goto L18;
        return null;
    L18:
        return Pair.create(r8, Integer.valueOf(r9));
    }

    public static String getTextFromUri(Context r1, Uri r2, Map<String, IContentProvider> r3, String r4) {
        Bundle r5 = getBundleFromUri(r1, r2, r3, null);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getString(r4);
    }

    public static boolean getBooleanFromUri(Context r1, Uri r2, Map<String, IContentProvider> r3, String r4) {
        Bundle r5 = getBundleFromUri(r1, r2, r3, null);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.getBoolean(r4);
    }

    public static Bundle putBooleanToUriAndGetResult(Context r1, Uri r2, Map<String, IContentProvider> r3, String r4, boolean r5) {
        Bundle r0 = new Bundle();
        r0.putBoolean(r4, r5);
        return getBundleFromUri(r1, r2, r3, r0);
    }

    private static Bundle getBundleFromUri(Context r9, Uri r10, Map<String, IContentProvider> r11, Bundle r12) {
        Pair<String, String> r0 = getMethodAndKey(r10);
        if (r0 != null) goto L5;
        return null;
    L5:
        String r6 = (String) r0.first;
        String r1 = (String) r0.second;
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return null;
    L8:
        IContentProvider r3 = getProviderFromUri(r9, r10, r11);
        if (r3 != null) goto L12;
        return null;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        if (r12 != null) goto L15;
        r12 = new Bundle();
    L15:
        r12.putString(META_DATA_PREFERENCE_KEYHINT, r1);
    L16:
        Bundle r8 = r12;
        return r3.call(r9.getAttributionSource(), r10.getAuthority(), r6, r10.toString(), r8);
    L19:
        return null;
    }

    private static IContentProvider getProviderFromUri(Context r3, Uri r4, Map<String, IContentProvider> r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r1 = r4.getAuthority();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return null;
    L9:
        if (r5.containsKey(r1) == true) goto L12;
        r5.put(r1, r3.getContentResolver().acquireUnstableProvider(r4));
    L12:
        return r5.get(r1);
    }

    private static Pair<String, String> getMethodAndKey(Uri r4) {
        String r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        List<String> r5 = r4.getPathSegments();
        if (r5 != null) goto L8;
    L15:
        return null;
    L8:
        if (r5.isEmpty() == true) goto L15;
        String r1 = r5.get(0);
        if (r5.size() <= 1) goto L14;
        r0 = r5.get(1);
    L14:
        return Pair.create(r1, r0);
    }
}
