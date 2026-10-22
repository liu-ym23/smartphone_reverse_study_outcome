package com.android.settings;

import android.app.admin.DeviceAdminInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.applications.api.OnSettingsItemClickListener;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceManagerFragment extends BaseFragment {
    static final int DIALOG_WARNING = 1;
    static final String TAG = "DeviceAdminSettings";
    final HashSet<ComponentName> mActiveAdmins;
    final ArrayList<DeviceAdminInfo> mAvailableAdmins;
    DevicePolicyManager mDPM;
    private ListView mListView;
    private boolean mNoHistory;
    private PackageManager mPackageManager;

    class PolicyListAdapter extends BaseAdapter {
        final LayoutInflater mInflater;
        private OnSettingsItemClickListener mOnSettingsItemClickListener;
        final /* synthetic */ DeviceManagerFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return true;
        }

        PolicyListAdapter(DeviceManagerFragment r2, OnSettingsItemClickListener r3) {
            this.this$0 = r2;
            this.mInflater = (LayoutInflater) r2.mContext.getSystemService("layout_inflater");
            this.mOnSettingsItemClickListener = r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mAvailableAdmins.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.this$0.mAvailableAdmins.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L5;
            r6 = this.mInflater.inflate(R.layout.settings_oui_card_list_item, r7, false);
            final OCardListItem r8 = (OCardListItem) r6.findViewById(R.id.card_list_item);
            r6.setTag(r8);
        L7:
            if (this.this$0.isAdded() == true) goto L9;
            return r6;
        L9:
            OCardListItemUtils.initCardItemInAdapter(r8, getCount(), r5);
            DeviceAdminInfo r1 = this.this$0.mAvailableAdmins.get(r5);
            OCardListItemUtils.setTitle(r8, r1.loadLabel(DeviceManagerFragment.access$100(this.this$0)));
            OCardListItemUtils.setIcon(r8, r1.loadIcon(DeviceManagerFragment.access$100(this.this$0)));
            if (this.this$0.mActiveAdmins.contains(r1.getComponent()) == false) goto L12;
            r8.setDefaultCustomEndView(2);
            r8.showCustomEnd(true);
        L19:
            OCardListItemUtils.setTrailingText(r8, r1.loadDescription(DeviceManagerFragment.access$100(this.this$0)));     // Catch: Resources.NotFoundException -> L15
        L17:
            r8.setOnContentClickListener(new DeviceManagerFragment$PolicyListAdapter$$ExternalSyntheticLambda0(this, r8, r5));
            return r6;
        L15:
            e = move-exception;
            OLog.e(DeviceManagerFragment.TAG, "getView: item" + r1 + ", e:" + e);
            goto L17
        L12:
            r8.showCustomEnd(false);
            goto L19
        L5:
            r8 = (OCardListItem) r6.getTag();
            goto L7
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-DeviceManagerFragment$PolicyListAdapter, reason: not valid java name */
        /* synthetic */ void m125x8cafcd5c(OCardListItem r1, int r2, View r3) {
            OnSettingsItemClickListener r4 = this.mOnSettingsItemClickListener;
            if (r4 == null) goto L6;
            r4.onItemClick(this, r1, r2);
            return;
        }
    }

    public void com_android_settings_DeviceManagerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DeviceManagerFragment() {
        this.mActiveAdmins = new HashSet();
        this.mAvailableAdmins = new ArrayList();
    }

    static /* synthetic */ boolean access$000(DeviceManagerFragment r0) {
        return r0.mNoHistory;
    }

    static /* synthetic */ PackageManager access$100(DeviceManagerFragment r0) {
        return r0.mPackageManager;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mNoHistory = getArguments().getBoolean(Settings.DeviceManagerActivity.EXTRA_NO_HISTORY, false);
        this.mRootView = r3.inflate(R.layout.device_manager_layout, r4, false);
        this.mTitleResId = Integer.valueOf(R.string.security_item_device_manager);
        this.mDPM = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        this.mPackageManager = getPackageManager();
        ListView r6 = (ListView) findViewByIdNullable(R.id.listView);
        this.mListView = r6;
        r6.setEmptyView(findViewByIdNullable(R.id.emptyView));
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        View r0 = this.mRootView;
        if (r0 == null) goto L5;
        UIUtils.fitMaskTitle(this, r0, this.mListView);
    L5:
        super.onViewCreated(r3, r4);
        updateList();
    }

    public void com_android_settings_DeviceManagerFragment__onResume$___twin___() {
        super.onResume();
        updateList();
    }

    private void addHeaderFooter() {
        if (this.mListView.getFooterViewsCount() != 0) goto L6;
        View r0 = Utils.inflateListTransparentHeader(getActivity(), this.mListView, false);
        View r1 = Utils.inflateListTransparentHeader(getActivity(), this.mListView, false);
        this.mListView.addFooterView(r1);
        this.mListView.addHeaderView(r0);
        return;
    }

    void updateList() {
        this.mActiveAdmins.clear();
        List<ComponentName> r2 = this.mDPM.getActiveAdmins();
        int r3 = 0;
        if (r2 == null) goto L8;
        int r4 = 0;
    L6:
        if (r4 >= r2.size()) goto L8;
        this.mActiveAdmins.add(r2.get(r4));
        r4 = r4 + 1;
    L8:
        this.mAvailableAdmins.clear();
        List<ResolveInfo> r5 = this.mPackageManager.queryBroadcastReceivers(new Intent("android.app.action.DEVICE_ADMIN_ENABLED"), 128);
        if (r5 != null) goto L11;
        int r6 = 0;
    L12:
        if (r3 >= r6) goto L25;
        ResolveInfo r7 = r5.get(r3);
        DeviceAdminInfo r8 = new DeviceAdminInfo(getActivity(), r7);     // Catch: IOException -> L20 XmlPullParserException -> L22
        if (r8.isVisible() == false) goto L17;
    L18:
        this.mAvailableAdmins.add(r8);     // Catch: IOException -> L20 XmlPullParserException -> L22
    L24:
        r3 = r3 + 1;
        goto L12
    L17:
        if (this.mActiveAdmins.contains(r8.getComponent()) == false) goto L24;
    L20:
        e = move-exception;
        OLog.w(TAG, "Skipping " + r7.activityInfo, e);
    L22:
        e = move-exception;
        OLog.w(TAG, "Skipping " + r7.activityInfo, e);
        goto L24
    L25:
        this.mListView.setAdapter(new PolicyListAdapter(this, new AnonymousClass1(this)));
        return;
    L11:
        r6 = r5.size();
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeviceManagerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceManagerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeviceManagerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeviceManagerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceManagerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
