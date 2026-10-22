package com.android.settings.dashboard;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import com.android.settings.homepage.HighlightableMenu;
import com.android.settings.safetycenter.SafetyCenterManagerWrapper;
import com.android.settingslib.applications.InterestingConfigChanges;
import com.android.settingslib.drawer.CategoryKey;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.ProviderTile;
import com.android.settingslib.drawer.Tile;
import com.android.settingslib.drawer.TileUtils;
import com.google.android.setupcompat.util.WizardManagerHelper;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CategoryManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "CategoryManager";
    private static CategoryManager sInstance;
    private List<DashboardCategory> mCategories;
    private final Map<String, DashboardCategory> mCategoryByKeyMap;
    private final InterestingConfigChanges mInterestingConfigChanges;
    private final Map<Pair<String, String>, Tile> mTileByComponentCache;

    private void logTiles(Context r1) {
    }

    public static CategoryManager get(Context r1) {
        if (sInstance != null) goto L6;
        sInstance = new CategoryManager(r1);
    L6:
        return sInstance;
    }

    CategoryManager(Context r2) {
        this.mTileByComponentCache = new ArrayMap();
        this.mCategoryByKeyMap = new ArrayMap();
        InterestingConfigChanges r0 = new InterestingConfigChanges();
        this.mInterestingConfigChanges = r0;
        r0.applyNewConfig(r2.getResources());
    }

    public synchronized DashboardCategory getTilesByCategory(Context r1, String r2) {
        monitor-enter(this);
        tryInitCategories(r1);     // Catch: Throwable -> L6
        DashboardCategory r3 = this.mCategoryByKeyMap.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<DashboardCategory> getCategories(Context r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (WizardManagerHelper.isUserSetupComplete(r2) == true) goto L8;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L8:
        tryInitCategories(r2);     // Catch: Throwable -> L11
        List<DashboardCategory> r4 = this.mCategories;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    }

    public synchronized void reloadAllCategories(Context r3) {
        monitor-enter(this);
        boolean r0 = this.mInterestingConfigChanges.applyNewConfig(r3.getResources());     // Catch: Throwable -> L6
        this.mCategories = null;     // Catch: Throwable -> L6
        tryInitCategories(r3, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void updateCategoryFromDenylist(Set<ComponentName> r6) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mCategories != null) goto L8;
        OLog.w(TAG, "Category is null, skipping denylist update");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= this.mCategories.size()) goto L20;
        DashboardCategory r2 = this.mCategories.get(r1);     // Catch: Throwable -> L22
        int r3 = 0;
    L13:
        if (r3 >= r2.getTilesCount()) goto L19;
        if (r6.contains(r2.getTile(r3).getIntent().getComponent()) == false) goto L18;
        int r4 = r3 - 1;     // Catch: Throwable -> L22
        r2.removeTile(r3);     // Catch: Throwable -> L22
        r3 = r4;
    L18:
        r3 = r3 + 1;
        goto L13
    L19:
        r1 = r1 + 1;
        goto L10
    L20:
        monitor-exit(this);
    }

    public synchronized Map<ComponentName, Tile> getTileByComponentMap() {
        monitor-enter(this);
        final ArrayMap r0 = new ArrayMap();     // Catch: Throwable -> L11
        List<DashboardCategory> r1 = this.mCategories;     // Catch: Throwable -> L11
        if (r1 != null) goto L8;
        OLog.w(TAG, "Category is null, no tiles");     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        r1.forEach(new CategoryManager$$ExternalSyntheticLambda0(r0));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$getTileByComponentMap$0(Map r3, DashboardCategory r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.getTilesCount()) goto L6;
        Tile r1 = r4.getTile(r0);
        r3.put(r1.getIntent().getComponent(), r1);
        r0 = r0 + 1;
        goto L4
    }

    private static /* synthetic */ void lambda$logTiles$1(Context r4, ComponentName r5, Tile r6) {
        OLog.d(TAG, "Tile: " + r6.getCategory().replace("com.android.settings.", "") + ": " + r6.getTitle(r4) + ", " + r5.flattenToShortString());
    }

    private synchronized void tryInitCategories(Context r2) {
        monitor-enter(this);
        tryInitCategories(r2, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void tryInitCategories(Context r5, boolean r6) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (WizardManagerHelper.isUserSetupComplete(r5) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mCategories != null) goto L30;
        boolean r0 = this.mCategoryByKeyMap.isEmpty();     // Catch: Throwable -> L32
        if (r6 == false) goto L12;
        this.mTileByComponentCache.clear();     // Catch: Throwable -> L32
    L12:
        this.mCategoryByKeyMap.clear();     // Catch: Throwable -> L32
        List<DashboardCategory> r7 = TileUtils.getCategories(r5, this.mTileByComponentCache);     // Catch: Throwable -> L32
        this.mCategories = r7;     // Catch: Throwable -> L32
        Iterator<DashboardCategory> r8 = r7.iterator();     // Catch: Throwable -> L32
    L14:
        if (r8.hasNext() == false) goto L16;
        DashboardCategory r1 = r8.next();     // Catch: Throwable -> L32
        this.mCategoryByKeyMap.put(r1.key, r1);     // Catch: Throwable -> L32
        goto L14
    L16:
        backwardCompatCleanupForCategory(this.mTileByComponentCache, this.mCategoryByKeyMap);     // Catch: Throwable -> L32
        mergeSecurityPrivacyKeys(r5, this.mTileByComponentCache, this.mCategoryByKeyMap);     // Catch: Throwable -> L32
        sortCategories(r5, this.mCategoryByKeyMap);     // Catch: Throwable -> L32
        filterDuplicateTiles(this.mCategoryByKeyMap);     // Catch: Throwable -> L32
        if (r0 == false) goto L30;
        logTiles(r5);     // Catch: Throwable -> L32
        DashboardCategory r9 = this.mCategoryByKeyMap.get(CategoryKey.CATEGORY_HOMEPAGE);     // Catch: Throwable -> L32
        if (r9 != null) goto L22;
        monitor-exit(this);
        return;
    L22:
        Iterator<Tile> r10 = r9.getTiles().iterator();     // Catch: Throwable -> L32
    L23:
        if (r10.hasNext() == false) goto L30;
        Tile r2 = r10.next();     // Catch: Throwable -> L32
        String r3 = r2.getKey(r5);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r3) == true) goto L27;
        HighlightableMenu.addMenuKey(r3);     // Catch: Throwable -> L32
        goto L23
    L27:
        OLog.w(TAG, "Key hint missing for homepage tile: " + r2.getTitle(r5));     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);
    }

    synchronized void backwardCompatCleanupForCategory(Map<Pair<String, String>, Tile> r7, Map<String, DashboardCategory> r8) {
        monitor-enter(this);
        HashMap r0 = new HashMap();     // Catch: Throwable -> L32
        Iterator<Map.Entry<Pair<String, String>, Tile>> r9 = r7.entrySet().iterator();     // Catch: Throwable -> L32
    L5:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<Pair<String, String>, Tile> r1 = r9.next();     // Catch: Throwable -> L32
        String r2 = (String) r1.getKey().first;     // Catch: Throwable -> L32
        List r3 = (List) r0.get(r2);     // Catch: Throwable -> L32
        if (r3 != null) goto L9;
        r3 = new ArrayList();     // Catch: Throwable -> L32
        r0.put(r2, r3);     // Catch: Throwable -> L32
    L9:
        r3.add(r1.getValue());     // Catch: Throwable -> L32
        goto L5
    L10:
        Iterator r10 = r0.entrySet().iterator();     // Catch: Throwable -> L32
    L11:
        if (r10.hasNext() == false) goto L30;
        List r4 = (List) ((Map.Entry) r10.next()).getValue();     // Catch: Throwable -> L32
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L32
        boolean r6 = false;
        boolean r11 = false;
    L15:
        if (r5.hasNext() == false) goto L20;
        if (CategoryKey.KEY_COMPAT_MAP.containsKey(((Tile) r5.next()).getCategory()) == false) goto L19;
        r11 = true;
        goto L15
    L19:
        r6 = true;
    L20:
        if (r11 == false) goto L11;
        if (r6 == true) goto L11;
        Iterator r12 = r4.iterator();     // Catch: Throwable -> L32
    L24:
        if (r12.hasNext() == false) goto L11;
        Tile r13 = (Tile) r12.next();     // Catch: Throwable -> L32
        String r14 = CategoryKey.KEY_COMPAT_MAP.get(r13.getCategory());     // Catch: Throwable -> L32
        r13.setCategory(r14);     // Catch: Throwable -> L32
        DashboardCategory r15 = r8.get(r14);     // Catch: Throwable -> L32
        if (r15 != null) goto L28;
        r15 = new DashboardCategory(r14);     // Catch: Throwable -> L32
        r8.put(r14, r15);     // Catch: Throwable -> L32
    L28:
        r15.addTile(r13);     // Catch: Throwable -> L32
        goto L24
    L30:
        monitor-exit(this);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    synchronized void mergeSecurityPrivacyKeys(Context r3, Map<Pair<String, String>, Tile> r4, Map<String, DashboardCategory> r5) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (SafetyCenterManagerWrapper.get().isEnabled(r3) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<Pair<String, String>, Tile>> r6 = r4.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r6.hasNext() == false) goto L19;
        Tile r7 = r6.next().getValue();     // Catch: Throwable -> L21
        if (Objects.equals(r7.getCategory(), CategoryKey.CATEGORY_SECURITY_ADVANCED_SETTINGS) == true) goto L14;
        if (Objects.equals(r7.getCategory(), CategoryKey.CATEGORY_PRIVACY) == false) goto L8;
    L14:
        r7.setCategory(CategoryKey.CATEGORY_MORE_SECURITY_PRIVACY_SETTINGS);     // Catch: Throwable -> L21
        DashboardCategory r0 = r5.get(CategoryKey.CATEGORY_MORE_SECURITY_PRIVACY_SETTINGS);     // Catch: Throwable -> L21
        if (r0 != null) goto L17;
        r0 = new DashboardCategory(CategoryKey.CATEGORY_MORE_SECURITY_PRIVACY_SETTINGS);     // Catch: Throwable -> L21
        r5.put(CategoryKey.CATEGORY_MORE_SECURITY_PRIVACY_SETTINGS, r0);     // Catch: Throwable -> L21
    L17:
        r0.addTile(r7);     // Catch: Throwable -> L21
        goto L8
    L19:
        monitor-exit(this);
    }

    synchronized void sortCategories(Context r3, Map<String, DashboardCategory> r4) {
        monitor-enter(this);
        Iterator<Map.Entry<String, DashboardCategory>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        r5.next().getValue().sortTiles(r3.getPackageName());     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    synchronized void filterDuplicateTiles(Map<String, DashboardCategory> r7) {
        monitor-enter(this);
        Iterator<Map.Entry<String, DashboardCategory>> r8 = r7.entrySet().iterator();     // Catch: Throwable -> L21
    L4:
        if (r8.hasNext() == false) goto L19;
        DashboardCategory r0 = r8.next().getValue();     // Catch: Throwable -> L21
        int r1 = r0.getTilesCount();     // Catch: Throwable -> L21
        ArraySet r2 = new ArraySet();     // Catch: Throwable -> L21
        ArraySet r3 = new ArraySet();     // Catch: Throwable -> L21
        int r4 = r1 - 1;     // Catch: Throwable -> L21
    L7:
        if (r4 < 0) goto L4;
        Tile r5 = r0.getTile(r4);     // Catch: Throwable -> L21
        if ((r5 instanceof ProviderTile) == false) goto L14;
        String r6 = r5.getDescription();     // Catch: Throwable -> L21
        if (r2.contains(r6) == false) goto L13;
        r0.removeTile(r4);     // Catch: Throwable -> L21
    L18:
        r4 = r4 - 1;
        goto L7
    L13:
        r2.add(r6);     // Catch: Throwable -> L21
        goto L18
    L14:
        ComponentName r9 = r5.getIntent().getComponent();     // Catch: Throwable -> L21
        if (r3.contains(r9) == false) goto L17;
        r0.removeTile(r4);     // Catch: Throwable -> L21
        goto L18
    L17:
        r3.add(r9);     // Catch: Throwable -> L21
        goto L18
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
