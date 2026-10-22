package com.android.settings.sidedial;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class SideDialNavigationFragment extends BaseFragment {
    private NavigationAppAdapter mAdapter;
    private PackageManager mPackageManager;
    private RecyclerView mRecyclerView;
    private HashMap<String, String> mSwitchMap;

    private class NavigationAppAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<ResolveInfo> mResolveInfoList;
        final /* synthetic */ SideDialNavigationFragment this$0;

        public NavigationAppAdapter(SideDialNavigationFragment r1, List<ResolveInfo> r2) {
            this.this$0 = r1;
            this.mResolveInfoList = r2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            return new NavigationAppViewHolder(LayoutInflater.from(this.this$0.mContext).inflate(R.layout.list_content_item_check, r2, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            SettingItemCheck r7 = ((NavigationAppViewHolder) r5).getItemCheck();
            Utils.setItemBgStyle(r7, getItemCount(), r6);
            boolean r0 = false;
            if (r6 != 0) goto L13;
            boolean r8 = Utils.isPackageInstalled(this.this$0.mContext, getSideDialCarModeNavigationApp());
            if (r8 == true) goto L7;
            setSideDialCarModeNavigationApp("");
        L7:
            if (r8 == true) goto L9;
        L10:
            r0 = true;
        L11:
            r7.setChecked(r0);
            r7.setIcon(null);
            r7.setTitle(this.this$0.mContext.getString(R.string.car_mode_navigation_no));
            r7.setOnClickListener(new SideDialNavigationFragment$NavigationAppAdapter$$ExternalSyntheticLambda0(this));
            return;
        L9:
            if ("".equals(getSideDialCarModeNavigationApp()) == false) goto L11;
        L13:
            ResolveInfo r9 = this.mResolveInfoList.get(r6);
            if (r9.activityInfo != null) goto L16;
            return;
        L16:
            if (r9.activityInfo.applicationInfo == null) goto L25;
            final ApplicationInfo r10 = r9.activityInfo.applicationInfo;
            r7.setTitle(r10.loadLabel(this.this$0.requireActivity().getApplication().getPackageManager()));
            r7.setIcon(r10.loadIcon(this.this$0.requireActivity().getApplication().getPackageManager()));
            if (getSideDialCarModeNavigationApp().equals(r10.packageName) == false) goto L21;
            r7.setChecked(true);
        L22:
            r7.setOnClickListener(new SideDialNavigationFragment$NavigationAppAdapter$$ExternalSyntheticLambda1(this, r10));
            return;
        L21:
            r7.setChecked(false);
            goto L22
        }

        /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-sidedial-SideDialNavigationFragment$NavigationAppAdapter, reason: not valid java name */
        /* synthetic */ void m597xfc475a47(View r1) {
            SideDialHelper.setSideDialDetailPageModify(this.this$0.mContext);
            setSideDialCarModeNavigationApp("");
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: lambda$onBindViewHolder$1$com-android-settings-sidedial-SideDialNavigationFragment$NavigationAppAdapter, reason: not valid java name */
        /* synthetic */ void m598x3703c88(ApplicationInfo r1, View r2) {
            SideDialHelper.setSideDialDetailPageModify(this.this$0.mContext);
            setSideDialCarModeNavigationApp(r1.packageName);
            notifyDataSetChanged();
        }

        public void addAll(Collection<? extends ResolveInfo> r4) {
            List<ResolveInfo> r0 = this.mResolveInfoList;
            if (r0 == null) goto L6;
            r0.add(0, new ResolveInfo());
            this.mResolveInfoList.addAll(r4);
            return;
        }

        public void clear() {
            List<ResolveInfo> r0 = this.mResolveInfoList;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<ResolveInfo> r0 = this.mResolveInfoList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        private void setSideDialCarModeNavigationApp(String r3) {
            SideDialNavigationFragment.access$000(this.this$0).put(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION, r3);
            SettingsProviderUtils.setSideDialCarModeSwitch(this.this$0.mContext, Utils.toJson(SideDialNavigationFragment.access$000(this.this$0)));
        }

        private String getSideDialCarModeNavigationApp() {
            return (String) SideDialNavigationFragment.access$000(this.this$0).get(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION);
        }
    }

    private static class NavigationAppViewHolder extends RecyclerView.ViewHolder {
        private SettingItemCheck mItemCheck;

        public NavigationAppViewHolder(View r2) {
            super(r2);
            this.mItemCheck = (SettingItemCheck) r2.findViewById(R.id.item_check);
        }

        public SettingItemCheck getItemCheck() {
            return this.mItemCheck;
        }
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ HashMap access$000(SideDialNavigationFragment r0) {
        return r0.mSwitchMap;
    }

    public void com_android_settings_sidedial_SideDialNavigationFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mPackageManager = getActivity().getPackageManager();
        this.mAdapter = new NavigationAppAdapter(this, new ArrayList());
        this.mSwitchMap = (HashMap) Utils.fromJson(SettingsProviderUtils.getSideDialCarModeSwitch(this.mContext), SideDialHelper.TYPE_TOKEN);
    }

    public SideDialNavigationFragment() {
        super(R.layout.side_dial_navigation_setting_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        RecyclerView r4 = (RecyclerView) findViewByIdNullable(R.id.navigation_app_container);
        this.mRecyclerView = r4;
        r4.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    private List<ResolveInfo> getNavigationAppList() {
        Uri r0 = Uri.parse("geo:");
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setData(r0);
        return this.mPackageManager.queryIntentActivities(r1, 0);
    }

    private List<ResolveInfo> filterApp(List<ResolveInfo> r5) {
        ArrayList r0 = new ArrayList();
        Resources r4 = getResources();
        if (r4 != null) goto L5;
        return r0;
    L5:
        List r6 = Arrays.asList(r4.getStringArray(R.array.side_dial_navigation_whitelist_app));
        int r1 = 0;
    L7:
        if (r1 >= r5.size()) goto L17;
        ResolveInfo r2 = r5.get(r1);
        if (r2.activityInfo == null) goto L16;
        if (r2.activityInfo.applicationInfo == null) goto L16;
        if (r6.contains(r2.activityInfo.applicationInfo.packageName) == false) goto L16;
        r0.add(r2);
    L16:
        r1 = r1 + 1;
        goto L7
    L17:
        return r0;
    }

    public void com_android_settings_sidedial_SideDialNavigationFragment__onResume$___twin___() {
        super.onResume();
        NavigationAppAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.clear();
        this.mAdapter.addAll(filterApp(getNavigationAppList()));
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SideDialNavigationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialNavigationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SideDialNavigationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialNavigationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SideDialNavigationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialNavigationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
