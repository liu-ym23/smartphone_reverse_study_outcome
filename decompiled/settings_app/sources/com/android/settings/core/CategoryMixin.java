package com.android.settings.core;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.ArraySet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.dashboard.CategoryManager;
import com.android.settingslib.drawer.Tile;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class CategoryMixin implements LifecycleObserver {
    private static final String DATA_SCHEME_PKG = "package";
    private static final String TAG = "CategoryMixin";
    private static final ArraySet<ComponentName> sTileDenylist = null;
    private int mCategoriesUpdateTaskCount;
    private final List<CategoryListener> mCategoryListeners;
    private final Context mContext;
    private boolean mFirstOnResume;
    private final PackageReceiver mPackageReceiver;

    /* JADX INFO: renamed from: com.android.settings.core.CategoryMixin$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CategoriesUpdateTask extends AsyncTask<Boolean, Void, Set<String>> {
        private final CategoryManager mCategoryManager;
        private Map<ComponentName, Tile> mPreviousTileMap;
        final /* synthetic */ CategoryMixin this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Set<String> doInBackground(Boolean[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Set<String> r1) {
            onPostExecute2(r1);
        }

        CategoriesUpdateTask(CategoryMixin r1) {
            this.this$0 = r1;
            CategoryMixin.access$108(r1);
            this.mCategoryManager = CategoryManager.get(CategoryMixin.access$200(r1));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Set<String> doInBackground2(Boolean... r3) {
            this.mPreviousTileMap = this.mCategoryManager.getTileByComponentMap();
            this.mCategoryManager.reloadAllCategories(CategoryMixin.access$200(this.this$0));
            this.mCategoryManager.updateCategoryFromDenylist(CategoryMixin.access$300());
            return getChangedCategories(r3[0].booleanValue());
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Set<String> r2) {
            if (r2 != null) goto L4;
        L5:
            this.this$0.onCategoriesChanged(r2);
        L6:
            CategoryMixin.access$110(this.this$0);
            return;
        L4:
            if (r2.isEmpty() == true) goto L6;
            goto L5
        }

        private Set<String> getChangedCategories(boolean r4) {
            if (r4 == true) goto L5;
            return null;
        L5:
            final ArraySet r5 = new ArraySet();
            Map<ComponentName, Tile> r0 = this.mCategoryManager.getTileByComponentMap();
            r0.forEach(new CategoryMixin$CategoriesUpdateTask$$ExternalSyntheticLambda0(this, r5));
            ArraySet r1 = new ArraySet(this.mPreviousTileMap.keySet());
            r1.removeAll(r0.keySet());
            r1.forEach(new CategoryMixin$CategoriesUpdateTask$$ExternalSyntheticLambda1(this, r5));
            return r5;
        }

        /* JADX INFO: renamed from: lambda$getChangedCategories$0$com-android-settings-core-CategoryMixin$CategoriesUpdateTask, reason: not valid java name */
        /* synthetic */ void m384xedfd633a(Set r5, ComponentName r6, Tile r7) {
            Tile r0 = this.mPreviousTileMap.get(r6);
            if (r0 != null) goto L7;
            OLog.i(CategoryMixin.TAG, "Tile added: " + r6.flattenToShortString());
            r5.add(r7.getCategory());
            return;
        L7:
            if (TextUtils.equals(r7.getTitle(CategoryMixin.access$200(this.this$0)), r0.getTitle(CategoryMixin.access$200(this.this$0))) == true) goto L9;
        L10:
            OLog.i(CategoryMixin.TAG, "Tile changed: " + r6.flattenToShortString());
            r5.add(r7.getCategory());
            return;
        L9:
            if (TextUtils.equals(r7.getSummary(CategoryMixin.access$200(this.this$0)), r0.getSummary(CategoryMixin.access$200(this.this$0))) == false) goto L10;
        }

        /* JADX INFO: renamed from: lambda$getChangedCategories$1$com-android-settings-core-CategoryMixin$CategoriesUpdateTask, reason: not valid java name */
        /* synthetic */ void m385x823bd2d9(Set r3, ComponentName r4) {
            OLog.i(CategoryMixin.TAG, "Tile removed: " + r4.flattenToShortString());
            r3.add(this.mPreviousTileMap.get(r4).getCategory());
        }
    }

    public interface CategoryHandler {
        CategoryMixin getCategoryMixin();
    }

    public interface CategoryListener {
        void onCategoriesChanged(Set<String> r1);
    }

    private class PackageReceiver extends BroadcastReceiver {
        final /* synthetic */ CategoryMixin this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_core_CategoryMixin$PackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private PackageReceiver(CategoryMixin r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PackageReceiver(CategoryMixin r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_core_CategoryMixin$PackageReceiver__onReceive$___twin___(Context r1, Intent r2) {
            CategoryMixin.access$400(this.this$0, true);
        }

        @Insert("onReceive")
        public static void com_android_settings_core_CategoryMixin$PackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(PackageReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            PackageReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_core_CategoryMixin$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_core_CategoryMixin$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_core_CategoryMixin$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_core_CategoryMixin$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    static /* synthetic */ int access$108(CategoryMixin r2) {
        int r0 = r2.mCategoriesUpdateTaskCount;
        r2.mCategoriesUpdateTaskCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$110(CategoryMixin r2) {
        int r0 = r2.mCategoriesUpdateTaskCount;
        r2.mCategoriesUpdateTaskCount = r0 - 1;
        return r0;
    }

    static /* synthetic */ Context access$200(CategoryMixin r0) {
        return r0.mContext;
    }

    static /* synthetic */ ArraySet access$300() {
        return sTileDenylist;
    }

    static /* synthetic */ void access$400(CategoryMixin r0, boolean r1) {
        r0.updateCategories(r1);
    }

    static {
        sTileDenylist = new ArraySet();
    }

    public CategoryMixin(Context r3) {
        this.mPackageReceiver = new PackageReceiver(this, null);
        this.mCategoryListeners = new ArrayList();
        this.mFirstOnResume = true;
        this.mContext = r3;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        IntentFilter r0 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addAction("android.intent.action.PACKAGE_CHANGED");
        r0.addAction("android.intent.action.PACKAGE_REPLACED");
        r0.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mPackageReceiver, r0);
        if (this.mFirstOnResume == false) goto L6;
        OLog.d(TAG, "Skip categories update");
        this.mFirstOnResume = false;
        return;
    L6:
        updateCategories();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.mContext.unregisterReceiver(this.mPackageReceiver);
    }

    public void addCategoryListener(CategoryListener r1) {
        this.mCategoryListeners.add(r1);
    }

    public void removeCategoryListener(CategoryListener r1) {
        this.mCategoryListeners.remove(r1);
    }

    public void updateCategories() {
        updateCategories(false);
    }

    void addToDenylist(ComponentName r1) {
        sTileDenylist.add(r1);
    }

    void removeFromDenylist(ComponentName r1) {
        sTileDenylist.remove(r1);
    }

    static /* synthetic */ void lambda$onCategoriesChanged$0(Set r0, CategoryListener r1) {
        r1.onCategoriesChanged(r0);
    }

    void onCategoriesChanged(final Set<String> r2) {
        this.mCategoryListeners.forEach(new CategoryMixin$$ExternalSyntheticLambda0(r2));
    }

    private void updateCategories(boolean r3) {
        if (this.mCategoriesUpdateTaskCount >= 2) goto L6;
        new CategoriesUpdateTask(this).execute(new Boolean[]{Boolean.valueOf(r3)});
        return;
    }
}
