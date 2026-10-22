package com.android.settings;

import android.app.CustomRefreshRateAppInfo;
import android.app.DynamicRefreshRateManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenRefreshRateAppsSettingsFragment extends BaseFragment {
    private static final int HIGH_SCREEN_REFRESH_RATE = 0;
    private static final int NOT_USE_HIGH_SCREEN_REFRESH_RATE = 1;
    private static final int USE_APP_SETTING_SCREEN_REFRESH_RATE = 2;
    private ApplicationsSettingsAdapter mAdapter;
    private ArrayList<AppInfo> mItems;
    private RecyclerView mListview;
    private BroadcastReceiver mPackageReceiver;

    class AppInfo {
        Drawable mAppIcon;
        String mAppName;
        String mAppPackageName;
        int mAppsScreenRefreshRateMode;
        final /* synthetic */ ScreenRefreshRateAppsSettingsFragment this$0;

        AppInfo(ScreenRefreshRateAppsSettingsFragment r2, int r3, String r4) {
            this.this$0 = r2;
            this.mAppsScreenRefreshRateMode = r3;
            this.mAppPackageName = r4;
            PackageManager r5 = r2.getPackageManager();     // Catch: Exception -> L5
            ApplicationInfo r6 = r5.getApplicationInfo(r4, 1);     // Catch: Exception -> L5
            this.mAppName = r5.getApplicationLabel(r6).toString();     // Catch: Exception -> L5
            this.mAppIcon = r5.getApplicationIcon(r6);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            OLog.e(ScreenRefreshRateAppsSettingsFragment.access$500(r2), "getApplicationInfo failed", e);
        }
    }

    public class ApplicationsSettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        final /* synthetic */ ScreenRefreshRateAppsSettingsFragment this$0;

        class ApplicationsSettingsViewHolder extends RecyclerView.ViewHolder {
            private final View item;
            final /* synthetic */ ApplicationsSettingsAdapter this$1;

            static /* synthetic */ void access$400(ApplicationsSettingsViewHolder r0, boolean r1, int r2) {
                r0.updateMode(r1, r2);
            }

            public ApplicationsSettingsViewHolder(ApplicationsSettingsAdapter r1, View r2) {
                this.this$1 = r1;
                super(r2);
                this.item = r2.findViewById(R.id.item);
            }

            private void updateMode(boolean r2, int r3) {
                if (r3 >= 0) goto L4;
                return;
            L4:
                if (r3 >= ScreenRefreshRateAppsSettingsFragment.access$300(this.this$1.this$0).size()) goto L9;
                AppInfo r1 = (AppInfo) ScreenRefreshRateAppsSettingsFragment.access$300(this.this$1.this$0).get(r3);
                DynamicRefreshRateManager.updateCustomRefreshRateApp(r1.mAppPackageName, r2);
                r1.mAppsScreenRefreshRateMode = !r2 ? 1 : 0;
                return;
            }

            public void bindData(Context r5, AppInfo r6, final int r7) {
                if (this.item == null) goto L23;
                if (r6 == null) goto L24;
                int r8 = r6.mAppsScreenRefreshRateMode;
                if (r8 == 0) goto L10;
                if (r8 == 1) goto L10;
                OCardListItem r9 = (OCardListItem) this.item;
                r9.setTitle(r6.mAppName);
                r9.setAppIcon(r6.mAppIcon);
                r9.showIcon(true);
                OCardListItemUtils.setCustomEndTipTextView(r9, this.this$1.this$0.getString(R.string.follow_app_setting));
            L15:
                if (r7 != 0) goto L18;
                r9.setCardPosition(1);
            L21:
                r9.getContentContainer().setClickable(false);
                return;
            L18:
                if (r7 != (this.this$1.getItemCount() - 1)) goto L20;
                r9.setCardPosition(3);
                goto L21
            L20:
                r9.setCardPosition(2);
            L10:
                OCardListItem r2 = (OCardListItem) this.item;
                r2.setTitle(r6.mAppName);
                r2.setAppIcon(r6.mAppIcon);
                r2.showIcon(true);
                ((OSwitch) r2.getCustomEndView()).setOnCheckedChangeListener(null);
                OSwitch r10 = (OSwitch) r2.getCustomEndView();
                if (r8 != 0) goto L13;
                boolean r11 = true;
            L14:
                r10.setChecked(r11);
                ((OSwitch) r2.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass1(this, r7));
                r9 = r2;
                goto L15
            L13:
                r11 = false;
                goto L14
            L24:
                return;
            }
        }

        public ApplicationsSettingsAdapter(ScreenRefreshRateAppsSettingsFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new ApplicationsSettingsViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(R.layout.list_screen_refresh_rate_item, r3, false));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            AppInfo r0 = (AppInfo) ScreenRefreshRateAppsSettingsFragment.access$300(this.this$0).get(r4);
            if ((r3 instanceof ApplicationsSettingsViewHolder) == false) goto L6;
            ((ApplicationsSettingsViewHolder) r3).bindData(this.this$0.mContext, r0, r4);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r1) {
            return ((AppInfo) ScreenRefreshRateAppsSettingsFragment.access$300(this.this$0).get(r1)).mAppsScreenRefreshRateMode;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ScreenRefreshRateAppsSettingsFragment.access$300(this.this$0).size();
        }
    }

    public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
        private ApplicationsSettingsAdapter mAdapter;
        final /* synthetic */ ScreenRefreshRateAppsSettingsFragment this$0;

        public RecyclerViewItemDecoration(ScreenRefreshRateAppsSettingsFragment r1, ApplicationsSettingsAdapter r2) {
            this.this$0 = r1;
            this.mAdapter = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
            int r5 = r3.getChildAdapterPosition(r2);
            if (r5 != 0) goto L5;
            r1.set(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, 0);
            return;
        L5:
            ApplicationsSettingsAdapter r0 = this.mAdapter;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r5 != (r0.getItemCount() - 1)) goto L13;
            r1.set(0, 0, 0, UIUtils.INSTANCE.dp2px(32));
            return;
        }
    }

    public void com_android_settings_ScreenRefreshRateAppsSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ String access$000(ScreenRefreshRateAppsSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$100(ScreenRefreshRateAppsSettingsFragment r0) {
        r0.updateApplicationsInfo();
    }

    static /* synthetic */ ApplicationsSettingsAdapter access$200(ScreenRefreshRateAppsSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ ArrayList access$300(ScreenRefreshRateAppsSettingsFragment r0) {
        return r0.mItems;
    }

    static /* synthetic */ String access$500(ScreenRefreshRateAppsSettingsFragment r0) {
        return r0.TAG;
    }

    public ScreenRefreshRateAppsSettingsFragment() {
        super(R.layout.screen_refresh_rate_applications_settings);
        this.mItems = new ArrayList();
        this.mPackageReceiver = new AnonymousClass1(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r2, Bundle r3) {
        super.initViews(r2, r3);
        RecyclerView r4 = (RecyclerView) findViewByIdNullable(R.id.list_view);
        this.mListview = r4;
        r4.setLayoutManager(new LinearLayoutManager(this.mContext));
        ApplicationsSettingsAdapter r5 = new ApplicationsSettingsAdapter(this);
        this.mAdapter = r5;
        this.mListview.setAdapter(r5);
        this.mListview.addItemDecoration(new RecyclerViewItemDecoration(this, this.mAdapter));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateApplicationsInfo();
        this.mAdapter.notifyDataSetChanged();
    }

    public void com_android_settings_ScreenRefreshRateAppsSettingsFragment__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r0);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mPackageReceiver);
    }

    private void updateApplicationsInfo() {
        CustomRefreshRateAppInfo r0 = DynamicRefreshRateManager.getCustomRefreshRateAppInfo();
        if (r0 != null) goto L6;
        OLog.d(this.TAG, "getCustomRefreshRateAppInfo is null");
        return;
    L6:
        this.mItems.clear();
        sortAndAdd(r0.mDisableHighAppList, 1);
        sortAndAdd(r0.mEnableHighAppList, 0);
        sortAndAdd(r0.mNotAllowSetAppList, 2);
    }

    private void sortAndAdd(List<String> r4, int r5) {
        ArrayList<AppInfo> r0 = new ArrayList();
        Iterator<String> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(new AppInfo(this, r5, r6.next()));
        goto L4
    L6:
        sort(r0);
        ArrayList<AppInfo> r3 = this.mItems;
        r3.addAll(r3.size(), r0);
    }

    private void sort(ArrayList<AppInfo> r3) {
        final Collator r0 = Collator.getInstance(Locale.getDefault());
        Collections.sort(r3, new AnonymousClass2(this, r0));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenRefreshRateAppsSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenRefreshRateAppsSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenRefreshRateAppsSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenRefreshRateAppsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenRefreshRateAppsSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenRefreshRateAppsSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
