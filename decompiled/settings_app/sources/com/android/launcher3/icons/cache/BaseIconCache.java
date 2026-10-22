package com.android.launcher3.icons.cache;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Process;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.android.launcher3.icons.BaseIconFactory;
import com.android.launcher3.icons.BitmapInfo;
import com.android.launcher3.icons.GraphicsUtils;
import com.android.launcher3.util.ComponentKey;
import com.android.launcher3.util.FlagOp;
import com.android.launcher3.util.SQLiteCacheHelper;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseIconCache {
    private static final boolean DEBUG = false;
    public static final String EMPTY_CLASS_NAME = ".";
    private static final String IDENTITY_FORMAT_STRING = "%1$s";
    private static final int INITIAL_ICON_CACHE_CAPACITY = 50;
    private static final String TAG = "BaseIconCache";
    private final Looper mBgLooper;
    private final Map<ComponentKey, CacheEntry> mCache;
    protected final Context mContext;
    private final String mDbFileName;
    private BitmapInfo mDefaultIcon;
    protected IconDB mIconDb;
    protected int mIconDpi;
    private volatile boolean mIconUpdateInProgress;
    protected LocaleList mLocaleList;
    protected final PackageManager mPackageManager;
    protected String mSystemState;
    private final SparseArray<FlagOp> mUserFlagOpMap;
    private final SparseArray<String> mUserFormatString;
    protected final Handler mWorkerHandler;

    public static class CacheEntry {
        public BitmapInfo bitmap;
        public CharSequence contentDescription;
        public CharSequence title;

        public CacheEntry() {
            this.bitmap = BitmapInfo.LOW_RES_INFO;
            this.title = "";
            this.contentDescription = "";
        }
    }

    public static final class IconDB extends SQLiteCacheHelper {
        public static final String[] COLUMNS_HIGH_RES = null;
        public static final String[] COLUMNS_LOW_RES = null;
        public static final String COLUMN_COMPONENT = "componentName";
        public static final String COLUMN_FLAGS = "flags";
        public static final String COLUMN_ICON = "icon";
        public static final String COLUMN_ICON_COLOR = "icon_color";
        public static final String COLUMN_KEYWORDS = "keywords";
        public static final String COLUMN_LABEL = "label";
        public static final String COLUMN_LAST_UPDATED = "lastUpdated";
        public static final String COLUMN_MONO_ICON = "mono_icon";
        public static final String COLUMN_ROWID = "rowid";
        public static final String COLUMN_SYSTEM_STATE = "system_state";
        public static final String COLUMN_USER = "profileId";
        public static final String COLUMN_VERSION = "version";
        private static final int INDEX_COLOR = 0;
        private static final int INDEX_FLAGS = 0;
        private static final int INDEX_ICON = 0;
        private static final int INDEX_MONO_ICON = 0;
        private static final int INDEX_TITLE = 0;
        private static final int RELEASE_VERSION = 34;
        public static final String TABLE_NAME = "icons";

        static /* synthetic */ int access$000() {
            return INDEX_COLOR;
        }

        static /* synthetic */ int access$100() {
            return INDEX_TITLE;
        }

        static /* synthetic */ int access$200() {
            return INDEX_ICON;
        }

        static /* synthetic */ int access$300() {
            return INDEX_MONO_ICON;
        }

        static /* synthetic */ int access$400() {
            return INDEX_FLAGS;
        }

        static {
            String[] r0 = {COLUMN_COMPONENT, "label", COLUMN_ICON_COLOR, COLUMN_FLAGS};
            COLUMNS_LOW_RES = r0;
            String[] r4 = (String[]) Arrays.copyOf(r0, r0.length + 2, String[].class);
            COLUMNS_HIGH_RES = r4;
            r4[r0.length] = "icon";
            r4[r0.length + 1] = COLUMN_MONO_ICON;
            INDEX_TITLE = Arrays.asList(r0).indexOf("label");
            INDEX_COLOR = Arrays.asList(r0).indexOf(COLUMN_ICON_COLOR);
            INDEX_FLAGS = Arrays.asList(r0).indexOf(COLUMN_FLAGS);
            int r1 = r0.length;
            INDEX_ICON = r1;
            INDEX_MONO_ICON = r1 + 1;
        }

        public IconDB(Context r2, String r3, int r4) {
            super(r2, r3, r4 + 2228224, TABLE_NAME);
        }

        @Override // com.android.launcher3.util.SQLiteCacheHelper
        protected void onCreateTable(SQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS icons (componentName TEXT NOT NULL, profileId INTEGER NOT NULL, lastUpdated INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, icon BLOB, mono_icon BLOB, icon_color INTEGER NOT NULL DEFAULT 0, flags INTEGER NOT NULL DEFAULT 0, label TEXT, system_state TEXT, keywords TEXT, PRIMARY KEY (componentName, profileId) );");
        }
    }

    public abstract BaseIconFactory getIconFactory();

    protected abstract long getSerialNumberForUser(UserHandle r1);

    protected abstract boolean isInstantApp(ApplicationInfo r1);

    public BaseIconCache(Context r2, String r3, Looper r4, int r5, int r6, boolean r7) {
        this.mLocaleList = LocaleList.getEmptyLocaleList();
        this.mSystemState = "";
        this.mUserFlagOpMap = new SparseArray();
        this.mUserFormatString = new SparseArray();
        this.mIconUpdateInProgress = false;
        this.mContext = r2;
        this.mDbFileName = r3;
        this.mPackageManager = r2.getPackageManager();
        this.mBgLooper = r4;
        this.mWorkerHandler = new Handler(r4);
        if (r7 == false) goto L5;
        this.mCache = new HashMap(50);
    L6:
        updateSystemState();
        this.mIconDpi = r5;
        this.mIconDb = new IconDB(r2, r3, r6);
        return;
    L5:
        this.mCache = new AnonymousClass1(this);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$updateIconParams$0$com-android-launcher3-icons-cache-BaseIconCache, reason: not valid java name */
    /* synthetic */ void m71xaa492de3(int r1, int r2) {
        updateIconParamsBg(r1, r2);
    }

    public void updateIconParams(final int r3, final int r4) {
        this.mWorkerHandler.post(new BaseIconCache$$ExternalSyntheticLambda0(this, r3, r4));
    }

    private synchronized void updateIconParamsBg(int r3, int r4) {
        monitor-enter(this);
        this.mIconDpi = r3;     // Catch: Throwable -> L6
        this.mDefaultIcon = null;     // Catch: Throwable -> L6
        this.mUserFlagOpMap.clear();     // Catch: Throwable -> L6
        this.mIconDb.clear();     // Catch: Throwable -> L6
        this.mIconDb.close();     // Catch: Throwable -> L6
        this.mIconDb = new IconDB(this.mContext, this.mDbFileName, r4);     // Catch: Throwable -> L6
        this.mCache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private Drawable getFullResIcon(Resources r2, int r3) {
        if (r2 == null) goto L7;
        if (r3 == 0) goto L7;
        return r2.getDrawableForDensity(r3, this.mIconDpi);
    L7:
        return BaseIconFactory.getFullResDefaultActivityIcon(this.mIconDpi);
    }

    public Drawable getFullResIcon(String r2, int r3) {
        return getFullResIcon(this.mPackageManager.getResourcesForApplication(r2), r3);
    L5:
        return BaseIconFactory.getFullResDefaultActivityIcon(this.mIconDpi);
    }

    public Drawable getFullResIcon(ActivityInfo r3) {
        return getFullResIcon(this.mPackageManager.getResourcesForApplication(r3.applicationInfo), r3.getIconResource());
    L5:
        return BaseIconFactory.getFullResDefaultActivityIcon(this.mIconDpi);
    }

    public void setIconUpdateInProgress(boolean r1) {
        this.mIconUpdateInProgress = r1;
    }

    public boolean isIconUpdateInProgress() {
        return this.mIconUpdateInProgress;
    }

    public synchronized void remove(ComponentName r3, UserHandle r4) {
        monitor-enter(this);
        this.mCache.remove(new ComponentKey(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void removeFromMemCacheLocked(String r5, UserHandle r6) {
        HashSet r0 = new HashSet();
        Iterator<ComponentKey> r1 = this.mCache.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ComponentKey r2 = r1.next();
        if (r2.componentName.getPackageName().equals(r5) == false) goto L4;
        if (r2.user.equals(r6) == false) goto L4;
        r0.add(r2);
        goto L4
    L10:
        Iterator r7 = r0.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ComponentKey r8 = (ComponentKey) r7.next();
        this.mCache.remove(r8);
        goto L12
    }

    public synchronized void removeIconsForPkg(String r6, UserHandle r7) {
        monitor-enter(this);
        removeFromMemCacheLocked(r6, r7);     // Catch: Throwable -> L6
        this.mIconDb.delete("componentName LIKE ? AND profileId = ?", new String[]{r6 + "/%", Long.toString(getSerialNumberForUser(r7))});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public IconCacheUpdateHandler getUpdateHandler() {
        updateSystemState();
        return new IconCacheUpdateHandler(this);
    }

    private void updateSystemState() {
        this.mLocaleList = this.mContext.getResources().getConfiguration().getLocales();
        this.mSystemState = this.mLocaleList.toLanguageTags() + "," + Build.VERSION.SDK_INT;
        this.mUserFormatString.clear();
    }

    protected String getIconSystemState(String r1) {
        return this.mSystemState;
    }

    public CharSequence getUserBadgedLabel(CharSequence r4, UserHandle r5) {
        int r0 = r5.hashCode();
        int r1 = this.mUserFormatString.indexOfKey(r0);
        if (r1 >= 0) goto L8;
        String r6 = this.mPackageManager.getUserBadgedLabel(IDENTITY_FORMAT_STRING, r5).toString();
        if (TextUtils.equals(IDENTITY_FORMAT_STRING, r6) == false) goto L7;
        r6 = null;
    L7:
        this.mUserFormatString.put(r0, r6);
    L9:
        if (r6 != null) goto L12;
        return r4;
    L12:
        return String.format(r6, new Object[]{r4});
    L8:
        r6 = this.mUserFormatString.valueAt(r1);
        goto L9
    }

    public synchronized <T> void addIconToDBAndMemCache(T r11, CachingLogic<T> r12, PackageInfo r13, long r14, boolean r16) {
        monitor-enter(this);
        UserHandle r3 = r12.getUser(r11);     // Catch: Throwable -> L29
        ComponentName r4 = r12.getComponent(r11);     // Catch: Throwable -> L29
        ComponentKey r5 = new ComponentKey(r4, r3);     // Catch: Throwable -> L29
        CacheEntry r6 = null;
        if (r16 == true) goto L12;
        CacheEntry r7 = this.mCache.get(r5);     // Catch: Throwable -> L29
        if (r7 == null) goto L12;
        if (r7.bitmap.isNullOrLowRes() == true) goto L12;
        r6 = r7;
    L12:
        if (r6 != null) goto L15;
        r6 = new CacheEntry();     // Catch: Throwable -> L29
        r6.bitmap = r12.loadIcon(this.mContext, r11);     // Catch: Throwable -> L29
    L15:
        if (r6.bitmap.isNullOrLowRes() == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        CharSequence r8 = r12.getLabel(r11);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r8) == false) goto L23;
        if (r8 != null) goto L22;
        Log.wtf(TAG, "No label returned from caching logic instance: " + r12);     // Catch: Throwable -> L29
    L22:
        r8 = r4.getPackageName();     // Catch: Throwable -> L29
    L23:
        r6.title = r8;     // Catch: Throwable -> L29
        r6.contentDescription = getUserBadgedLabel(r6.title, r3);     // Catch: Throwable -> L29
        if (r12.addToMemCache() == false) goto L26;
        this.mCache.put(r5, r6);     // Catch: Throwable -> L29
    L26:
        addIconToDB(newContentValues(r6.bitmap, r6.title.toString(), r4.getPackageName(), r12.getKeywords(r11, this.mLocaleList)), r4, r13, r14, r12.getLastUpdatedTime(r11, r13));     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }

    private void addIconToDB(ContentValues r2, ComponentName r3, PackageInfo r4, long r5, long r7) {
        r2.put(IconDB.COLUMN_COMPONENT, r3.flattenToString());
        r2.put(IconDB.COLUMN_USER, Long.valueOf(r5));
        r2.put(IconDB.COLUMN_LAST_UPDATED, Long.valueOf(r7));
        r2.put("version", Integer.valueOf(r4.versionCode));
        this.mIconDb.insertOrReplace(r2);
    }

    public synchronized BitmapInfo getDefaultIcon(UserHandle r3) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.mDefaultIcon != null) goto L17;
        BaseIconFactory r0 = getIconFactory();     // Catch: Throwable -> L20
        this.mDefaultIcon = r0.makeDefaultIcon();     // Catch: Throwable -> L10
        if (r0 == null) goto L17;
        r0.close();     // Catch: Throwable -> L20
        goto L17
    L10:
        th = move-exception;
        if (r0 != null) goto L25;
    L16:
        throw th;     // Catch: Throwable -> L20
    L25:
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20
    L17:
        BitmapInfo r4 = this.mDefaultIcon.withFlags(getUserFlagOpLocked(r3));     // Catch: Throwable -> L20
        monitor-exit(this);
        return r4;
    }

    protected FlagOp getUserFlagOpLocked(UserHandle r4) {
        int r0 = r4.hashCode();
        int r1 = this.mUserFlagOpMap.indexOfKey(r0);
        if (r1 >= 0) goto L5;
        BaseIconFactory r2 = getIconFactory();
        FlagOp r5 = r2.getBitmapFlagOp(new BaseIconFactory.IconOptions().setUser(r4));     // Catch: Throwable -> L11
        this.mUserFlagOpMap.put(r0, r5);     // Catch: Throwable -> L11
        if (r2 == null) goto L10;
        r2.close();
    L10:
        return r5;
    L11:
        th = move-exception;
        if (r2 != null) goto L20;
    L17:
        throw th;
    L20:
        r2.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L5:
        return this.mUserFlagOpMap.valueAt(r1);
    }

    public boolean isDefaultIcon(BitmapInfo r1, UserHandle r2) {
        if (getDefaultIcon(r2).icon != r1.icon) goto L5;
        return true;
    L5:
        return false;
    }

    protected <T> CacheEntry cacheLocked(ComponentName r9, UserHandle r10, Supplier<T> r11, CachingLogic<T> r12, boolean r13, boolean r14) {
        return cacheLocked(r9, r10, r11, r12, null, r13, r14);
    }

    protected <T> CacheEntry cacheLocked(ComponentName r13, UserHandle r14, Supplier<T> r15, CachingLogic<T> r16, Cursor r17, boolean r18, boolean r19) {
        assertWorkerThread();
        ComponentKey r2 = new ComponentKey(r13, r14);
        CacheEntry r3 = this.mCache.get(r2);
        if (r3 != null) goto L5;
    L7:
        CacheEntry r10 = new CacheEntry();
        if (r16.addToMemCache() == false) goto L10;
        this.mCache.put(r2, r10);
    L10:
        if (r17 != null) goto L12;
        boolean r0 = getEntryFromDBLocked(r2, r10, r19);
    L13:
        if (r0 == true) goto L15;
        T r11 = r15.get();
        loadFallbackIcon(r11, r10, r16, r18, true, r13, r14);
        boolean r1 = true;
    L17:
        if (TextUtils.isEmpty(r10.title) == false) goto L24;
        if (r11 != null) goto L21;
        if (r1 == true) goto L21;
        r11 = r15.get();
    L21:
        if (r11 == null) goto L24;
        loadFallbackTitle(r11, r10, r16, r14);
    L24:
        return r10;
    L15:
        r11 = null;
        r1 = false;
        goto L17
    L12:
        r0 = updateTitleAndIconLocked(r2, r10, r17, r19);
        goto L13
    L5:
        if (r3.bitmap.isLowRes() == false) goto L25;
        if (r19 == false) goto L7;
        return r3;
    L25:
        return r3;
    }

    protected <T> void loadFallbackIcon(T r1, CacheEntry r2, CachingLogic<T> r3, boolean r4, boolean r5, ComponentName r6, UserHandle r7) {
        if (r1 == null) goto L4;
        r2.bitmap = r3.loadIcon(this.mContext, r1);
        return;
    L4:
        if (r4 == false) goto L9;
        CacheEntry r8 = getEntryForPackageLocked(r6.getPackageName(), r7, false);
        r2.bitmap = r8.bitmap;
        r2.contentDescription = r8.contentDescription;
        if (r5 == false) goto L9;
        r2.title = r8.title;
    L9:
        if (r2.bitmap != null) goto L13;
        Log.wtf(TAG, "using default icon for " + r6.toShortString());
        r2.bitmap = getDefaultIcon(r7);
        return;
    }

    protected <T> void loadFallbackTitle(T r2, CacheEntry r3, CachingLogic<T> r4, UserHandle r5) {
        r3.title = r4.getLabel(r2);
        if (TextUtils.isEmpty(r3.title) == false) goto L5;
        r3.title = r4.getComponent(r2).getPackageName();
    L5:
        r3.contentDescription = getUserBadgedLabel(r4.getDescription(r2, r3.title), r5);
    }

    public synchronized void clearMemoryCache() {
        monitor-enter(this);
        assertWorkerThread();     // Catch: Throwable -> L6
        this.mCache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized void cachePackageInstallInfo(String r4, UserHandle r5, Bitmap r6, CharSequence r7) {
        monitor-enter(this);
        removeFromMemCacheLocked(r4, r5);     // Catch: Throwable -> L18
        ComponentKey r8 = getPackageKey(r4, r5);     // Catch: Throwable -> L18
        CacheEntry r0 = this.mCache.get(r8);     // Catch: Throwable -> L18
        if (r0 != null) goto L7;
        r0 = new CacheEntry();     // Catch: Throwable -> L18
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r0.title = r7;     // Catch: Throwable -> L18
    L9:
        if (r6 == null) goto L12;
        BaseIconFactory r1 = getIconFactory();     // Catch: Throwable -> L18
        r0.bitmap = r1.createShapedIconBitmap(r6, new BaseIconFactory.IconOptions().setUser(r5));     // Catch: Throwable -> L18
        r1.close();     // Catch: Throwable -> L18
    L12:
        if (TextUtils.isEmpty(r7) == false) goto L14;
    L16:
        monitor-exit(this);
        return;
    L14:
        if (r0.bitmap.icon == null) goto L16;
        this.mCache.put(r8, r0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private static ComponentKey getPackageKey(String r3, UserHandle r4) {
        return new ComponentKey(new ComponentName(r3, r3 + "."), r4);
    }

    protected CacheEntry getEntryForPackageLocked(String r17, UserHandle r18, boolean r19) {
        assertWorkerThread();
        ComponentKey r9 = getPackageKey(r17, r18);
        CacheEntry r3 = this.mCache.get(r9);
        if (r3 != null) goto L5;
    L7:
        CacheEntry r10 = new CacheEntry();
        boolean r11 = true;
        if (getEntryFromDBLocked(r9, r10, r19) == false) goto L32;
    L28:
        if (r11 == false) goto L31;
        this.mCache.put(r9, r10);
    L31:
        return r10;
    L32:
    L27:
        r11 = false;
        goto L28
    L11:
        if (Process.myUserHandle().equals(r18) == false) goto L13;
        long r4 = 0;
    L14:
        PackageInfo r5 = this.mPackageManager.getPackageInfo(r17, PackageManager.PackageInfoFlags.of(r4 | 4294967296L));     // Catch: PackageManager.NameNotFoundException -> L27
        ApplicationInfo r6 = r5.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L27
        if (r6 == null) goto L25;
        BaseIconFactory r7 = getIconFactory();     // Catch: PackageManager.NameNotFoundException -> L27
        Drawable r8 = r6.loadIcon(this.mPackageManager);     // Catch: PackageManager.NameNotFoundException -> L27
        if (this.mPackageManager.isDefaultApplicationIcon(r8) == false) goto L20;
        logdPersistently(TAG, String.format("Default icon returned for %s", new Object[]{r17}), null);     // Catch: PackageManager.NameNotFoundException -> L27
    L20:
        BitmapInfo r12 = r7.createBadgedIconBitmap(r8, new BaseIconFactory.IconOptions().setUser(r18).setInstantApp(isInstantApp(r6)));     // Catch: PackageManager.NameNotFoundException -> L27
        r7.close();     // Catch: PackageManager.NameNotFoundException -> L27
        r10.title = r6.loadLabel(this.mPackageManager);     // Catch: PackageManager.NameNotFoundException -> L27
        r10.contentDescription = getUserBadgedLabel(r10.title, r18);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r19 == false) goto L23;
        BitmapInfo r2 = BitmapInfo.of(BitmapInfo.LOW_RES_ICON, r12.color);     // Catch: PackageManager.NameNotFoundException -> L27
    L24:
        r10.bitmap = r2;     // Catch: PackageManager.NameNotFoundException -> L27
        addIconToDB(newContentValues(r12, r10.title.toString(), r17, null), r9.componentName, r5, getSerialNumberForUser(r18), r5.lastUpdateTime);     // Catch: PackageManager.NameNotFoundException -> L27
        goto L28
    L23:
        r2 = r12;
        goto L24
    L25:
        PackageManager.NameNotFoundException r1 = new PackageManager.NameNotFoundException("ApplicationInfo is null");     // Catch: PackageManager.NameNotFoundException -> L27
        logdPersistently(TAG, String.format("ApplicationInfo is null for %s", new Object[]{r17}), r1);     // Catch: PackageManager.NameNotFoundException -> L27
        throw r1;     // Catch: PackageManager.NameNotFoundException -> L27
    L13:
        r4 = 8192;
        goto L14
    L5:
        if (r3.bitmap.isLowRes() == false) goto L33;
        if (r19 == false) goto L7;
        return r3;
    L33:
        return r3;
    }

    protected boolean getEntryFromDBLocked(ComponentKey r9, CacheEntry r10, boolean r11) {
        Trace.beginSection("loadIconIndividually");
        Cursor r1 = null;
        IconDB r2 = this.mIconDb;     // Catch: Throwable -> L16 SQLiteException -> L18
        if (r11 == false) goto L6;
        String[] r3 = IconDB.COLUMNS_LOW_RES;     // Catch: Throwable -> L16 SQLiteException -> L18
    L7:
        r1 = r2.query(r3, "componentName = ? AND profileId = ?", new String[]{r9.componentName.flattenToString(), Long.toString(getSerialNumberForUser(r9.user))});     // Catch: Throwable -> L16 SQLiteException -> L18
        if (r1.moveToNext() == false) goto L14;
        boolean r8 = updateTitleAndIconLocked(r9, r10, r1, r11);     // Catch: Throwable -> L16 SQLiteException -> L18
        if (r1 == null) goto L12;
        r1.close();
    L12:
        Trace.endSection();
        return r8;
    L14:
        if (r1 != null) goto L21;
    L22:
        Trace.endSection();
        return false;
    L21:
        r1.close();
        goto L22
    L6:
        r3 = IconDB.COLUMNS_HIGH_RES;     // Catch: Throwable -> L16 SQLiteException -> L18
    L16:
        th = move-exception;
        if (r1 == null) goto L26;
        r1.close();
    L26:
        Trace.endSection();
        throw th;
    L18:
        e = move-exception;
        Log.d(TAG, "Error reading icon cache", e);     // Catch: Throwable -> L16
        if (r1 == null) goto L22;
        goto L21
    }

    private boolean updateTitleAndIconLocked(ComponentKey r6, CacheEntry r7, Cursor r8, boolean r9) {
        r7.bitmap = BitmapInfo.of(BitmapInfo.LOW_RES_ICON, GraphicsUtils.setColorAlphaBound(r8.getInt(IconDB.access$000()), 255));
        r7.title = r8.getString(IconDB.access$100());
        if (r7.title != null) goto L5;
        r7.title = "";
        r7.contentDescription = "";
    L7:
        if (r9 == true) goto L31;
        byte[] r10 = r8.getBlob(IconDB.access$200());
        if (r10 != null) goto L37;
        return false;
    L37:
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Exception -> L30
        r1.inPreferredConfig = Bitmap.Config.HARDWARE;     // Catch: Exception -> L30
        r7.bitmap = BitmapInfo.of((Bitmap) Objects.requireNonNull(BitmapFactory.decodeByteArray(r10, 0, r10.length, r1)), r7.bitmap.color);     // Catch: Exception -> L30
        byte[] r11 = r8.getBlob(IconDB.access$300());
        Bitmap r2 = r7.bitmap.icon;
        if (r11 == null) goto L31;
        if (r11.length != (r2.getHeight() * r2.getWidth())) goto L31;
        Bitmap r3 = Bitmap.createBitmap(r2.getWidth(), r2.getHeight(), Bitmap.Config.ALPHA_8);
        r3.copyPixelsFromBuffer(ByteBuffer.wrap(r11));
        Bitmap r12 = r3.copy(Bitmap.Config.HARDWARE, false);
        if (r12 == null) goto L19;
        r3.recycle();
        r3 = r12;
    L19:
        BaseIconFactory r13 = getIconFactory();
        r7.bitmap.setMonoIcon(r3, r13);     // Catch: Throwable -> L23
        if (r13 == null) goto L31;
        r13.close();
    L23:
        th = move-exception;
        if (r13 != null) goto L35;
    L29:
        throw th;
    L35:
        r13.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
    L30:
        return false;
    L31:
        BitmapInfo r14 = r7.bitmap;
        r14.flags = r8.getInt(IconDB.access$400());
        r7.bitmap = r7.bitmap.withFlags(getUserFlagOpLocked(r6.user));
        if (r7.bitmap == null) goto L41;
        return true;
    L41:
        return false;
    L5:
        r7.contentDescription = getUserBadgedLabel(r7.title, r6.user);
        goto L7
    }

    public synchronized Cursor queryCacheDb(String[] r2, String r3, String[] r4) {
        monitor-enter(this);
        Cursor r5 = this.mIconDb.query(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    private ContentValues newContentValues(BitmapInfo r7, String r8, String r9, String r10) {
        ContentValues r0 = new ContentValues();
        if (r7.canPersist() == false) goto L14;
        r0.put("icon", GraphicsUtils.flattenBitmap(r7.icon));
        Bitmap r1 = r7.getMono();
        if (r1 != null) goto L7;
    L13:
        byte[] r2 = (byte[]) null;
        r0.put(IconDB.COLUMN_MONO_ICON, null);
    L15:
        r0.put(IconDB.COLUMN_ICON_COLOR, Integer.valueOf(r7.color));
        r0.put(IconDB.COLUMN_FLAGS, Integer.valueOf(r7.flags));
        r0.put("label", r8);
        r0.put(IconDB.COLUMN_SYSTEM_STATE, getIconSystemState(r9));
        r0.put("keywords", r10);
        return r0;
    L7:
        if (r1.getHeight() != r7.icon.getHeight()) goto L13;
        if (r1.getWidth() != r7.icon.getWidth()) goto L13;
        if (r1.getConfig() != Bitmap.Config.ALPHA_8) goto L13;
        byte[] r3 = new byte[r1.getWidth() * r1.getHeight()];
        r1.copyPixelsToBuffer(ByteBuffer.wrap(r3));
        r0.put(IconDB.COLUMN_MONO_ICON, r3);
        goto L15
    L14:
        byte[] r4 = (byte[]) null;
        r0.put("icon", null);
        r0.put(IconDB.COLUMN_MONO_ICON, null);
        goto L15
    }

    private void assertWorkerThread() {
        if (Looper.myLooper() != this.mBgLooper) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cache accessed on wrong thread " + Looper.myLooper());
    }

    protected void logdPersistently(String r1, String r2, Exception r3) {
        Log.d(r1, r2, r3);
    }
}
