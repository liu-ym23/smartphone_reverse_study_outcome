package com.android.settings.specialaccess.notificationaccess;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.VersionedPackage;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.UserHandle;
import android.service.notification.NotificationListenerFilter;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.app.NotificationCompat;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BridgedAppsSettingsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010'\u001a\u00020\u001c2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010)j\n\u0012\u0004\u0012\u00020*\u0018\u0001`+H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0016J\u0006\u0010/\u001a\u00020\u001cJ\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\fJ\u000e\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0013J\u0010\u00108\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/android/settings/specialaccess/notificationaccess/BridgedAppsSettingsActivity;", "Lcom/android/settings/specialaccess/SpecialAccessBaseActivity;", "Lcom/android/settings/applications/AppStateBaseBridge$Callback;", "Lcom/android/settingslib/applications/ApplicationsState$Callbacks;", "()V", "TAG", "", "mApplicationAdapter", "Lcom/android/settings/specialaccess/notificationaccess/BridgedAppsSettingsActivity$ApplicationAdapter;", "mApplicationsState", "Lcom/android/settingslib/applications/ApplicationsState;", "mCn", "Landroid/content/ComponentName;", "mComponentName", "mFilter", "Lcom/android/settingslib/applications/ApplicationsState$AppFilter;", "mNlf", "Landroid/service/notification/NotificationListenerFilter;", "mNm", "Lcom/android/settings/notification/NotificationBackend;", "mSession", "Lcom/android/settingslib/applications/ApplicationsState$Session;", "mUserId", "", "getEmptyRes", "getSubtitleResId", "getTitleRes", "onAllSizesComputed", "", "onCreate", "icicle", "Landroid/os/Bundle;", "onExtraInfoUpdated", "onLauncherInfoChanged", "onLoadEntriesCompleted", "onPackageIconChanged", "onPackageListChanged", "onPackageSizeChanged", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "onRebuildComplete", OcrAppInfoColumn.TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "Lkotlin/collections/ArrayList;", "onRunningStateChanged", "running", "", "rebuild", "setAppState", "appState", "setCn", "cn", "setFilter", "filter", "setNm", "nm", "setSession", "lifecycle", "Lcom/android/settingslib/core/lifecycle/Lifecycle;", "setUserId", AccountInfoBundleKey.USER_ID, "ApplicationAdapter", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BridgedAppsSettingsActivity extends SpecialAccessBaseActivity implements AppStateBaseBridge.Callback, ApplicationsState.Callbacks {
    private final String TAG;
    private ApplicationAdapter mApplicationAdapter;
    private ApplicationsState mApplicationsState;
    private ComponentName mCn;
    private ComponentName mComponentName;
    private ApplicationsState.AppFilter mFilter;
    private NotificationListenerFilter mNlf;
    private NotificationBackend mNm;
    private ApplicationsState.Session mSession;
    private int mUserId;

    /* JADX INFO: compiled from: BridgedAppsSettingsActivity.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tH\u0016J(\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00182\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/settings/specialaccess/notificationaccess/BridgedAppsSettingsActivity$ApplicationAdapter;", "Lcom/android/settings/specialaccess/SpecialAccessHeaderAdapter;", "activity", "Landroid/app/Activity;", "mNm", "Lcom/android/settings/notification/NotificationBackend;", "mCn", "Landroid/content/ComponentName;", "mUserId", "", NotificationCompat.CATEGORY_CALL, "Lkotlin/Function1;", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "", "(Landroid/app/Activity;Lcom/android/settings/notification/NotificationBackend;Landroid/content/ComponentName;ILkotlin/jvm/functions/Function1;)V", OcrAppInfoColumn.TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "Lkotlin/collections/ArrayList;", "getApps", "()Ljava/util/ArrayList;", "setApps", "(Ljava/util/ArrayList;)V", "mNlf", "Landroid/service/notification/NotificationListenerFilter;", "mPkgMan", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "getItemContentCount", "getSwitchOnCheckedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "uid", "onBindContentViewHolder", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateContentViewHolder", "Lcom/android/settings/specialaccess/SpecialAccessSwitchViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "nlf", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private final Activity activity;
        private ArrayList<ApplicationsState.AppEntry> apps;
        private final Function1<OSectionSupportiveText, Unit> call;
        private final ComponentName mCn;
        private NotificationListenerFilter mNlf;
        private final NotificationBackend mNm;
        private final PackageManager mPkgMan;
        private final int mUserId;

        public static /* synthetic */ void $r8$lambda$llYA5mnhnbwgaBSH298WqqZ9VK4(ApplicationAdapter r0, String r1, int r2, CompoundButton r3, boolean r4) {
            getSwitchOnCheckedListener$lambda$0(r0, r1, r2, r3, r4);
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return onCreateContentViewHolder(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ApplicationAdapter(Activity r2, NotificationBackend r3, ComponentName r4, int r5, Function1<? super OSectionSupportiveText, Unit> r6) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "mNm");
            Intrinsics.checkNotNullParameter(r4, "mCn");
            Intrinsics.checkNotNullParameter(r6, NotificationCompat.CATEGORY_CALL);
            super(r6);
            this.activity = r2;
            this.mNm = r3;
            this.mCn = r4;
            this.mUserId = r5;
            this.call = r6;
            this.mPkgMan = r2.getPackageManager();
            this.apps = new ArrayList();
        }

        public final ArrayList<ApplicationsState.AppEntry> getApps() {
            return this.apps;
        }

        public final void setApps(ArrayList<ApplicationsState.AppEntry> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.apps = r2;
        }

        public final void setData(NotificationListenerFilter r2, ArrayList<ApplicationsState.AppEntry> r3) {
            Intrinsics.checkNotNullParameter(r2, "nlf");
            Intrinsics.checkNotNullParameter(r3, OcrAppInfoColumn.TABLE_NAME);
            this.mNlf = r2;
            this.apps = r3;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public SpecialAccessSwitchViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r1));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "viewHolder");
            SpecialAccessSwitchViewHolder r8 = (SpecialAccessSwitchViewHolder) r6;
            ApplicationsState.AppEntry r0 = this.apps.get(r7);
            Intrinsics.checkNotNullExpressionValue(r0, "get(...)");
            ApplicationsState.AppEntry r1 = r0;
            ApplicationInfo r2 = r1.info;
            String r3 = r2.packageName;
            Intrinsics.checkNotNullExpressionValue(r3, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            r8.setIcon(ObricIconUtils.getDrawable(r3, r2.uid));
            CharSequence r4 = r2.loadLabel(this.mPkgMan);
            NotificationListenerFilter r5 = null;
            r8.setTitle(r4, null);
            r8.initCardItemInAdapter(this.apps.size(), r7);
            String r9 = r1.info.packageName;
            Intrinsics.checkNotNullExpressionValue(r9, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            CompoundButton.OnCheckedChangeListener r10 = getSwitchOnCheckedListener(r9, r1.info.uid);
            NotificationListenerFilter r11 = this.mNlf;
            if (r11 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mNlf");
        L6:
            r8.updateSwitch(r10, true, r5.isPackageAllowed(new VersionedPackage(r1.info.packageName, r1.info.uid)));
            return;
        L5:
            r5 = r11;
            goto L6
        }

        private final CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final String r2, final int r3) {
            return new BridgedAppsSettingsActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r2, r3);
        }

        private static final void getSwitchOnCheckedListener$lambda$0(ApplicationAdapter r2, String r3, int r4, CompoundButton r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$packageName");
            NotificationListenerFilter r7 = null;
            if (r6 == false) goto L8;
            NotificationListenerFilter r8 = r2.mNlf;
            if (r8 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mNlf");
            r8 = null;
        L7:
            r8.removePackage(new VersionedPackage(r3, r4));
        L12:
            NotificationBackend r9 = r2.mNm;
            ComponentName r10 = r2.mCn;
            int r11 = r2.mUserId;
            NotificationListenerFilter r12 = r2.mNlf;
            if (r12 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mNlf");
        L16:
            r9.setListenerFilter(r10, r11, r7);
            return;
        L15:
            r7 = r12;
            goto L16
        L8:
            NotificationListenerFilter r13 = r2.mNlf;
            if (r13 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mNlf");
            r13 = null;
        L11:
            r13.addPackage(new VersionedPackage(r3, r4));
            goto L12
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            return this.apps.size();
        }
    }

    public void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.no_applications;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.notif_listener_excluded_app_summary;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.notif_listener_excluded_app_screen_title;
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BridgedAppsSettingsActivity() {
        this.TAG = Reflection.getOrCreateKotlinClass(BridgedAppsSettingsActivity.class).getSimpleName();
        ApplicationsState.AppFilter r0 = ApplicationsState.FILTER_NOT_HIDE;
        Intrinsics.checkNotNullExpressionValue(r0, "FILTER_NOT_HIDE");
        this.mFilter = r0;
    }

    public static final /* synthetic */ void access$initDescText(BridgedAppsSettingsActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    public void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        String r9 = getIntent().getStringExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME");
        if (r9 == null) goto L6;
        this.mComponentName = ComponentName.unflattenFromString(r9);
    L6:
        if (getIntent() != null) goto L8;
    L10:
        this.mUserId = UserHandle.myUserId();
    L11:
        ApplicationsState r10 = ApplicationsState.getInstance(getApplication());
        Intrinsics.checkNotNullExpressionValue(r10, "getInstance(...)");
        BridgedAppsSettingsActivity r11 = setAppState(r10);
        ComponentName r0 = this.mComponentName;
        Intrinsics.checkNotNull(r0);
        r11.setCn(r0).setUserId(this.mUserId).setSession(getSettingsLifecycle()).setFilter(this.mFilter).setNm(new NotificationBackend()).rebuild();
        BridgedAppsSettingsActivity r1 = this;
        NotificationBackend r2 = this.mNm;
        ApplicationAdapter r6 = null;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mNm");
        NotificationBackend r3 = null;
    L15:
        ComponentName r4 = this.mCn;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mCn");
        ComponentName r5 = null;
    L19:
        this.mApplicationAdapter = new ApplicationAdapter(r1, r3, r5, this.mUserId, new AnonymousClass1(this));
        RecyclerView r12 = this.mRecyclerView;
        ApplicationAdapter r7 = this.mApplicationAdapter;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mApplicationAdapter");
    L23:
        r12.setAdapter(r6);
        return;
    L22:
        r6 = r7;
        goto L23
    L18:
        r5 = r4;
        goto L19
    L14:
        r3 = r2;
        goto L15
    L8:
        if (getIntent().hasExtra("android.intent.extra.user_handle") == false) goto L10;
        Parcelable r13 = getIntent().getParcelableExtra("android.intent.extra.user_handle");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.UserHandle");
        this.mUserId = ((UserHandle) r13).getIdentifier();
        goto L11
    }

    public final BridgedAppsSettingsActivity setAppState(ApplicationsState r2) {
        Intrinsics.checkNotNullParameter(r2, "appState");
        this.mApplicationsState = r2;
        return this;
    }

    public final BridgedAppsSettingsActivity setCn(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "cn");
        this.mCn = r2;
        return this;
    }

    public final BridgedAppsSettingsActivity setUserId(int r1) {
        this.mUserId = r1;
        return this;
    }

    public final BridgedAppsSettingsActivity setNm(NotificationBackend r2) {
        Intrinsics.checkNotNullParameter(r2, "nm");
        this.mNm = r2;
        return this;
    }

    public final BridgedAppsSettingsActivity setFilter(ApplicationsState.AppFilter r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        this.mFilter = r2;
        return this;
    }

    public final BridgedAppsSettingsActivity setSession(Lifecycle r3) {
        ApplicationsState r0 = this.mApplicationsState;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mApplicationsState");
        r0 = null;
    L5:
        ApplicationsState.Session r4 = r0.newSession(this, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "newSession(...)");
        this.mSession = r4;
        return this;
    }

    @Override // com.android.settings.applications.AppStateBaseBridge.Callback
    public void onExtraInfoUpdated() {
        rebuild();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
        rebuild();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r5) {
        ArrayList<ApplicationsState.AppEntry> r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        showEmptyView();
        return;
    L12:
        showContent();
        NotificationBackend r2 = this.mNm;
        NotificationListenerFilter r3 = null;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mNm");
        r2 = null;
    L15:
        ComponentName r4 = this.mCn;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mCn");
        r4 = null;
    L18:
        NotificationListenerFilter r6 = r2.getListenerFilter(r4, this.mUserId);
        Intrinsics.checkNotNullExpressionValue(r6, "getListenerFilter(...)");
        this.mNlf = r6;
        ApplicationAdapter r7 = this.mApplicationAdapter;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mApplicationAdapter");
        r7 = null;
    L21:
        NotificationListenerFilter r8 = this.mNlf;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mNlf");
    L25:
        r7.setData(r3, r5);
        updatePositionAfterNotify();
        return;
    L24:
        r3 = r8;
        goto L25
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
        rebuild();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
        rebuild();
    }

    public final void rebuild() {
        ApplicationsState.Session r0 = this.mSession;
        Unit r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSession");
        r0 = null;
    L5:
        ArrayList<ApplicationsState.AppEntry> r2 = r0.rebuild(this.mFilter, ApplicationsState.ALPHA_COMPARATOR);
        if (r2 == null) goto L8;
        onRebuildComplete(r2);
        r1 = Unit.INSTANCE;
    L8:
        if (r1 != null) goto L11;
        onRebuildComplete(new ArrayList());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BridgedAppsSettingsActivity r1) {
        r1.com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(BridgedAppsSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BridgedAppsSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BridgedAppsSettingsActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BridgedAppsSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(BridgedAppsSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BridgedAppsSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BridgedAppsSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_notificationaccess_BridgedAppsSettingsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BridgedAppsSettingsActivity r5 = r3;
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
