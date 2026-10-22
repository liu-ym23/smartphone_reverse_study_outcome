package com.android.settings.specialaccess.fromSpa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.android.settingslib.applications.ApplicationsState;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: UseFullScreenIntentActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J \u0010%\u001a\u00020\u00192\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0019H\u0002J$\u0010/\u001a\u00020\u00192\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/android/settings/specialaccess/fromSpa/UseFullScreenIntentActivity;", "Lcom/android/settings/specialaccess/SpecialAccessBaseActivity;", "Lcom/android/settings/applications/AppStateBaseBridge$Callback;", "Lcom/android/settingslib/applications/ApplicationsState$Callbacks;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mApplicationAdapter", "Lcom/android/settings/specialaccess/fromSpa/UseFullScreenIntentActivity$ApplicationAdapter;", "mApplicationsState", "Lcom/android/settingslib/applications/ApplicationsState;", "mBridgeBackend", "Lcom/android/settings/specialaccess/fromSpa/AppStateUseFullScreenIntentBridge;", "mPackageManager", "Landroid/content/pm/PackageManager;", "mSession", "Lcom/android/settingslib/applications/ApplicationsState$Session;", "getEmptyRes", "", "getPackageIdx", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "getSubtitleResId", "getTitleRes", "onAllSizesComputed", "", "onCreate", "icicle", "Landroid/os/Bundle;", "onDestroy", "onExtraInfoUpdated", "onLauncherInfoChanged", "onLoadEntriesCompleted", "onPackageIconChanged", "onPackageListChanged", "onPackageSizeChanged", "onPause", "onRebuildComplete", OcrAppInfoColumn.TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "Lkotlin/collections/ArrayList;", "onResume", "onRunningStateChanged", "running", "", "update", "updatePrefs", "ApplicationAdapter", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UseFullScreenIntentActivity extends SpecialAccessBaseActivity implements AppStateBaseBridge.Callback, ApplicationsState.Callbacks {
    private final String TAG;
    private ApplicationAdapter mApplicationAdapter;
    private ApplicationsState mApplicationsState;
    private AppStateUseFullScreenIntentBridge mBridgeBackend;
    private PackageManager mPackageManager;
    private ApplicationsState.Session mSession;

    /* JADX INFO: compiled from: UseFullScreenIntentActivity.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J$\u0010 \u001a\u00020\u000b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/settings/specialaccess/fromSpa/UseFullScreenIntentActivity$ApplicationAdapter;", "Lcom/android/settings/specialaccess/SpecialAccessHeaderAdapter;", "activity", "Landroid/app/Activity;", "mBridge", "Lcom/android/settings/specialaccess/fromSpa/AppStateUseFullScreenIntentBridge;", "mPkgMan", "Landroid/content/pm/PackageManager;", NotificationCompat.CATEGORY_CALL, "Lkotlin/Function1;", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "", "(Landroid/app/Activity;Lcom/android/settings/specialaccess/fromSpa/AppStateUseFullScreenIntentBridge;Landroid/content/pm/PackageManager;Lkotlin/jvm/functions/Function1;)V", OcrAppInfoColumn.TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "Lkotlin/collections/ArrayList;", "getApps", "()Ljava/util/ArrayList;", "setApps", "(Ljava/util/ArrayList;)V", "getItemContentCount", "", "onBindContentViewHolder", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateContentViewHolder", "Lcom/android/settings/specialaccess/SpecialAccessSwitchViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private final Activity activity;
        private ArrayList<ApplicationsState.AppEntry> apps;
        private final Function1<OSectionSupportiveText, Unit> call;
        private final AppStateUseFullScreenIntentBridge mBridge;
        private final PackageManager mPkgMan;

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return onCreateContentViewHolder(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ApplicationAdapter(Activity r2, AppStateUseFullScreenIntentBridge r3, PackageManager r4, Function1<? super OSectionSupportiveText, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "mBridge");
            Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
            super(r5);
            this.activity = r2;
            this.mBridge = r3;
            this.mPkgMan = r4;
            this.call = r5;
            this.apps = new ArrayList();
        }

        public final ArrayList<ApplicationsState.AppEntry> getApps() {
            return this.apps;
        }

        public final void setApps(ArrayList<ApplicationsState.AppEntry> r1) {
            this.apps = r1;
        }

        public final void setData(ArrayList<ApplicationsState.AppEntry> r1) {
            this.apps = r1;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public SpecialAccessSwitchViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r1));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "viewHolder");
            SpecialAccessSwitchViewHolder r7 = (SpecialAccessSwitchViewHolder) r5;
            ArrayList<ApplicationsState.AppEntry> r0 = this.apps;
            Intrinsics.checkNotNull(r0);
            ApplicationsState.AppEntry r1 = r0.get(r6);
            Intrinsics.checkNotNullExpressionValue(r1, "get(...)");
            ApplicationsState.AppEntry r2 = r1;
            ApplicationInfo r3 = r2.info;
            PackageManager r4 = this.mPkgMan;
            Intrinsics.checkNotNull(r4);
            Intrinsics.checkNotNullExpressionValue(r3.loadLabel(r4), "loadLabel(...)");
            if (r2.extraInfo == null) goto L5;
            Object r8 = r2.extraInfo;
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.android.settings.applications.AppStateAppOpsBridge.PermissionState");
            UserHandle r9 = ((AppStateAppOpsBridge.PermissionState) r8).userHandle;
            String r10 = r3.packageName;
            Intrinsics.checkNotNullExpressionValue(r10, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            r7.setIcon(ObricIconUtils.getDrawable(r10, r3.uid));
            r7.setTitle(r3.loadLabel(this.mPkgMan), null);
        L5:
            ArrayList<ApplicationsState.AppEntry> r11 = this.apps;
            if (r11 == null) goto L8;
            int r12 = r11.size();
        L9:
            r7.initCardItemInAdapter(r12, r6);
            r7.updateSwitch(this.mBridge.getSwitchOnCheckedListener(r2), this.mBridge.enableSwitch(r2), this.mBridge.checkSwitch(r2));
            return;
        L8:
            r12 = 0;
            goto L9
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            ArrayList<ApplicationsState.AppEntry> r0 = this.apps;
            if (r0 != null) goto L5;
            return 0;
        L5:
            Intrinsics.checkNotNull(r0);
            return r0.size();
        }
    }

    public void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.no_applications;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.footer_description_full_screen_intent;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.full_screen_intent_title;
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UseFullScreenIntentActivity() {
        this.TAG = "UseFullScreenIntentActivity";
    }

    public static final /* synthetic */ void access$initDescText(UseFullScreenIntentActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    public void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        Context r6 = getApplicationContext();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.Application");
        ApplicationsState r7 = ApplicationsState.getInstance((Application) r6);
        this.mApplicationsState = r7;
        Intrinsics.checkNotNull(r7);
        this.mSession = r7.newSession(this, getSettingsLifecycle());
        this.mBridgeBackend = new AppStateUseFullScreenIntentBridge(this, this.mApplicationsState, this);
        this.mPackageManager = getPackageManager();
        AppStateUseFullScreenIntentBridge r1 = this.mBridgeBackend;
        Intrinsics.checkNotNull(r1);
        this.mApplicationAdapter = new ApplicationAdapter(this, r1, this.mPackageManager, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r7) {
        Intrinsics.checkNotNullParameter(r7, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        ApplicationAdapter r0 = this.mApplicationAdapter;
        int r1 = -1;
        if (r0 == null) goto L21;
        int r2 = r0.getItemCount();
        if (this.mPackageName == null) goto L20;
        if (r2 <= 0) goto L20;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        ArrayList<ApplicationsState.AppEntry> r4 = r0.getApps();
        if (r4 == null) goto L14;
        ApplicationsState.AppEntry r5 = r4.get(r3);
        if (r5 == null) goto L14;
        ApplicationInfo r6 = r5.info;
    L15:
        if (r6 == null) goto L19;
        if (TextUtils.equals(r7, r6.packageName) == false) goto L19;
        r1 = r3;
    L19:
        r3 = r3 + 1;
    L14:
        r6 = null;
    L20:
        OLog.i(this.TAG, "jump to: " + r1 + ", package: " + r7);
    L21:
        return r1;
    }

    public void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onResume$___twin___() {
        super.onResume();
        AppStateUseFullScreenIntentBridge r1 = this.mBridgeBackend;
        Intrinsics.checkNotNull(r1);
        r1.resume(true);
    }

    public void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onPause$___twin___() {
        AppStateUseFullScreenIntentBridge r0 = this.mBridgeBackend;
        Intrinsics.checkNotNull(r0);
        r0.pause();
        super.onPause();
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AppStateUseFullScreenIntentBridge r0 = this.mBridgeBackend;
        Intrinsics.checkNotNull(r0);
        r0.release();
        super.onDestroy();
    }

    private final void updatePrefs(ArrayList<ApplicationsState.AppEntry> r2) {
        if (r2 != null) goto L4;
    L8:
        showEmptyView();
        return;
    L4:
        if (r2.isEmpty() == true) goto L8;
        showContent();
        ApplicationAdapter r0 = this.mApplicationAdapter;
        Intrinsics.checkNotNull(r0);
        r0.setData(r2);
        updatePositionAfterNotify();
    }

    private final void update() {
        ApplicationsState.Session r0 = this.mSession;
        Intrinsics.checkNotNull(r0);
        updatePrefs(r0.rebuild(AppStateUseFullScreenIntentBridge.Companion.getFILTER_APP_USE_FULL_SCREEN_INTENT(), ApplicationsState.ALPHA_COMPARATOR));
    }

    @Override // com.android.settings.applications.AppStateBaseBridge.Callback
    public void onExtraInfoUpdated() {
        update();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r2) {
        Intrinsics.checkNotNullParameter(r2, OcrAppInfoColumn.TABLE_NAME);
        updatePrefs(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UseFullScreenIntentActivity r1) {
        r1.com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UseFullScreenIntentActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UseFullScreenIntentActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UseFullScreenIntentActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UseFullScreenIntentActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UseFullScreenIntentActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UseFullScreenIntentActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UseFullScreenIntentActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_fromSpa_UseFullScreenIntentActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UseFullScreenIntentActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
