package com.android.launcher3.icons.cache;

import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class IconCacheUpdateHandler {
    static final Object ICON_UPDATE_TOKEN = null;
    private static final boolean MODE_CLEAR_VALID_ITEMS = false;
    private static final boolean MODE_SET_INVALID_ITEMS = true;
    private static final String TAG = "IconCacheUpdateHandler";
    private boolean mFilterMode;
    private final BaseIconCache mIconCache;
    private final SparseBooleanArray mItemsToDelete;
    private final ArrayMap<UserHandle, Set<String>> mPackagesToIgnore;
    private final HashMap<String, PackageInfo> mPkgInfoMap;

    public interface OnUpdateCallback {
        void onPackageIconsUpdated(HashSet<String> r1, UserHandle r2);
    }

    private class SerializedIconUpdateTask<T> implements Runnable {
        private final ArrayDeque<T> mAppsToAdd;
        private final ArrayDeque<T> mAppsToUpdate;
        private final CachingLogic<T> mCachingLogic;
        private final OnUpdateCallback mOnUpdateCallback;
        private final HashSet<String> mUpdatedPackages;
        private final UserHandle mUserHandle;
        private final long mUserSerial;
        final /* synthetic */ IconCacheUpdateHandler this$0;

        SerializedIconUpdateTask(IconCacheUpdateHandler r1, long r2, UserHandle r4, ArrayDeque<T> r5, ArrayDeque<T> r6, CachingLogic<T> r7, OnUpdateCallback r8) {
            this.this$0 = r1;
            this.mUpdatedPackages = new HashSet();
            this.mUserHandle = r4;
            this.mUserSerial = r2;
            this.mAppsToAdd = r5;
            this.mAppsToUpdate = r6;
            this.mCachingLogic = r7;
            this.mOnUpdateCallback = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAppsToUpdate.isEmpty() == true) goto L11;
            T r2 = this.mAppsToUpdate.removeLast();
            String r0 = this.mCachingLogic.getComponent(r2).getPackageName();
            PackageInfo r4 = (PackageInfo) IconCacheUpdateHandler.access$000(this.this$0).get(r0);
            IconCacheUpdateHandler.access$100(this.this$0).addIconToDBAndMemCache(r2, this.mCachingLogic, r4, this.mUserSerial, true);
            this.mUpdatedPackages.add(r0);
            if (this.mAppsToUpdate.isEmpty() == true) goto L7;
        L9:
            scheduleNext();
            return;
        L7:
            if (this.mUpdatedPackages.isEmpty() == true) goto L9;
            this.mOnUpdateCallback.onPackageIconsUpdated(this.mUpdatedPackages, this.mUserHandle);
            goto L9
        L11:
            if (this.mAppsToAdd.isEmpty() == true) goto L23;
            T r3 = this.mAppsToAdd.removeLast();
            PackageInfo r5 = (PackageInfo) IconCacheUpdateHandler.access$000(this.this$0).get(this.mCachingLogic.getComponent(r3).getPackageName());
            if (r5 == null) goto L16;
            IconCacheUpdateHandler.access$100(this.this$0).addIconToDBAndMemCache(r3, this.mCachingLogic, r5, this.mUserSerial, false);
        L16:
            if (this.mAppsToAdd.isEmpty() == true) goto L19;
            scheduleNext();
            return;
        L19:
            if (IconCacheUpdateHandler.access$100(this.this$0).mWorkerHandler.hasMessages(0, IconCacheUpdateHandler.ICON_UPDATE_TOKEN) == true) goto L25;
            IconCacheUpdateHandler.access$100(this.this$0).setIconUpdateInProgress(false);
            return;
        L25:
            return;
        }

        public void scheduleNext() {
            IconCacheUpdateHandler.access$100(this.this$0).mWorkerHandler.postAtTime(this, IconCacheUpdateHandler.ICON_UPDATE_TOKEN, SystemClock.uptimeMillis() + 1);
        }
    }

    static /* synthetic */ HashMap access$000(IconCacheUpdateHandler r0) {
        return r0.mPkgInfoMap;
    }

    static /* synthetic */ BaseIconCache access$100(IconCacheUpdateHandler r0) {
        return r0.mIconCache;
    }

    static {
        ICON_UPDATE_TOKEN = new Object();
    }

    IconCacheUpdateHandler(BaseIconCache r2) {
        this.mPackagesToIgnore = new ArrayMap();
        this.mItemsToDelete = new SparseBooleanArray();
        this.mFilterMode = true;
        this.mIconCache = r2;
        this.mPkgInfoMap = new HashMap();
        r2.mWorkerHandler.removeCallbacksAndMessages(ICON_UPDATE_TOKEN);
        createPackageInfoMap();
    }

    public void addPackagesToIgnore(UserHandle r2, String r3) {
        Set<String> r0 = this.mPackagesToIgnore.get(r2);
        if (r0 != null) goto L5;
        r0 = new HashSet();
        this.mPackagesToIgnore.put(r2, r0);
    L5:
        r0.add(r3);
    }

    private void createPackageInfoMap() {
        Iterator<PackageInfo> r0 = this.mIconCache.mPackageManager.getInstalledPackages(8192).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageInfo r1 = r0.next();
        this.mPkgInfoMap.put(r1.packageName, r1);
        goto L4
    }

    public <T> void updateIcons(List<T> r8, CachingLogic<T> r9, OnUpdateCallback r10) {
        HashMap r0 = new HashMap();
        int r1 = r8.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        T r4 = r8.get(r3);
        UserHandle r5 = r9.getUser(r4);
        HashMap r6 = (HashMap) r0.get(r5);
        if (r6 != null) goto L7;
        r6 = new HashMap();
        r0.put(r5, r6);
    L7:
        r6.put(r9.getComponent(r4), r4);
        r3 = r3 + 1;
        goto L3
    L8:
        Iterator r11 = r0.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r11.next();
        updateIconsPerUser((UserHandle) r2.getKey(), (HashMap) r2.getValue(), r9, r10);
        goto L10
    L12:
        this.mFilterMode = false;
    }

    private <T> void updateIconsPerUser(UserHandle r24, HashMap<ComponentName, T> r25, CachingLogic<T> r26, OnUpdateCallback r27) {
        Set<String> r7 = this.mPackagesToIgnore.get(r24);
        if (r7 != null) goto L5;
        r7 = Collections.emptySet();
    L5:
        long r8 = this.mIconCache.getSerialNumberForUser(r24);
        ArrayDeque r10 = new ArrayDeque();
        Cursor r12 = this.mIconCache.mIconDb.query(new String[]{BaseIconCache.IconDB.COLUMN_ROWID, BaseIconCache.IconDB.COLUMN_COMPONENT, BaseIconCache.IconDB.COLUMN_LAST_UPDATED, "version", BaseIconCache.IconDB.COLUMN_SYSTEM_STATE}, "profileId = ? ", new String[]{Long.toString(r8)});     // Catch: SQLiteException -> L58
        int r4 = r12.getColumnIndex(BaseIconCache.IconDB.COLUMN_COMPONENT);     // Catch: Throwable -> L46
        int r3 = r12.getColumnIndex(BaseIconCache.IconDB.COLUMN_LAST_UPDATED);     // Catch: Throwable -> L46
        int r1 = r12.getColumnIndex("version");     // Catch: Throwable -> L46
        int r6 = r12.getColumnIndex(BaseIconCache.IconDB.COLUMN_ROWID);     // Catch: Throwable -> L46
        int r0 = r12.getColumnIndex(BaseIconCache.IconDB.COLUMN_SYSTEM_STATE);     // Catch: Throwable -> L46
    L8:
        if (r12.moveToNext() == false) goto L43;
        ComponentName r13 = ComponentName.unflattenFromString(r12.getString(r4));     // Catch: Throwable -> L46
        PackageInfo r14 = this.mPkgInfoMap.get(r13.getPackageName());     // Catch: Throwable -> L46
        int r15 = r12.getInt(r6);     // Catch: Throwable -> L46
        if (r14 == null) goto L13;
        if ((r14.applicationInfo.flags & 16777216) != 0) goto L8;
        long r17 = r12.getLong(r3);     // Catch: Throwable -> L46
        int r11 = r12.getInt(r1);     // Catch: Throwable -> L46
        int r19 = r1;
        int r20 = r3;
        T r5 = r25.remove(r13);     // Catch: Throwable -> L46
        if (r11 != r14.versionCode) goto L34;
        if (r17 != r26.getLastUpdatedTime(r5, r14)) goto L34;
        int r18 = r0;
        if (TextUtils.equals(r12.getString(r0), this.mIconCache.getIconSystemState(r14.packageName)) == false) goto L35;
        if (this.mFilterMode == true) goto L30;
        boolean r2 = false;
        this.mItemsToDelete.put(r15, false);     // Catch: Throwable -> L31
    L41:
        r0 = r18;
        r1 = r19;
        r3 = r20;
        goto L8
    L30:
        r0 = r18;
        r1 = r19;
        r3 = r20;
    L35:
        r2 = false;
        if (r5 == null) goto L38;
        r10.add(r5);     // Catch: Throwable -> L31
        goto L41
    L38:
        if (this.mFilterMode != true) goto L41;
        this.mIconCache.remove(r13, r24);     // Catch: Throwable -> L31
        this.mItemsToDelete.put(r15, true);     // Catch: Throwable -> L31
    L31:
        th = th;
    L48:
        Throwable r9 = th;
        if (r12 == null) goto L89;
        r12.close();     // Catch: Throwable -> L52
    L90:
        throw r9;     // Catch: SQLiteException -> L56
    L52:
        th = move-exception;
        r9.addSuppressed(th);     // Catch: SQLiteException -> L56
        throw r9;     // Catch: SQLiteException -> L56
    L89:
        throw r9;     // Catch: SQLiteException -> L56
    L34:
        r18 = r0;
        goto L35
    L13:
        if (r7.contains(r13.getPackageName()) == true) goto L8;
        if (this.mFilterMode != true) goto L8;
        this.mIconCache.remove(r13, r24);     // Catch: Throwable -> L46
        this.mItemsToDelete.put(r15, true);     // Catch: Throwable -> L46
        goto L8
    L43:
        if (r12 == null) goto L62;
        r12.close();     // Catch: SQLiteException -> L56
    L62:
        if (r25.isEmpty() == true) goto L64;
    L65:
        ArrayDeque r16 = new ArrayDeque();
        r16.addAll(r25.values());
        this.mIconCache.setIconUpdateInProgress(true);
        new SerializedIconUpdateTask(this, r8, r24, r16, r10, r26, r27).scheduleNext();
        return;
    L64:
        if (r10.isEmpty() == false) goto L65;
        return;
    L46:
        th = th;
    L58:
        e = e;
    L60:
        Log.d(TAG, "Error reading icon cache", e);
    L56:
        e = e;
        goto L60
    }

    public void finish() {
        StringBuilder r0 = new StringBuilder("rowid IN (");
        int r1 = this.mItemsToDelete.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L10;
        if (this.mItemsToDelete.valueAt(r2) == false) goto L9;
        if (r3 <= 0) goto L8;
        r0.append(", ");
    L8:
        r0.append(this.mItemsToDelete.keyAt(r2));
        r3 = r3 + 1;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        r0.append(')');
        if (r3 <= 0) goto L17;
        this.mIconCache.mIconDb.delete(r0.toString(), null);
        return;
    }
}
