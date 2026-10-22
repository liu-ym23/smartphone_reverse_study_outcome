package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompnentFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final String KEY_BYTEDANCE_DEVELOPMENT_COMPONENT = "bytedance_development_activity";
    private static final Comparator<MyApplicationInfo> sDisplayNameComparator = null;
    private AppListAdapter mAdapter;
    private View mEmptyView;
    private ListView mListView;

    public class AppListAdapter extends ArrayAdapter<MyApplicationInfo> {
        private final int mAppIconSize;
        private final LayoutInflater mInflater;
        private final List<MyApplicationInfo> mPackageInfoList;
        final /* synthetic */ AppCompnentFragment this$0;

        public AppListAdapter(AppCompnentFragment r7, Context r8) {
            this.this$0 = r7;
            super(r8, 0);
            this.mPackageInfoList = new ArrayList();
            this.mAppIconSize = r7.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
            this.mInflater = (LayoutInflater) r8.getSystemService("layout_inflater");
            List<ApplicationInfo> r9 = r8.getPackageManager().getInstalledApplications(128);
            int r1 = 0;
        L4:
            if (r1 >= r9.size()) goto L20;
            ApplicationInfo r2 = r9.get(r1);
            if (r2.metaData == null) goto L8;
            String r3 = r2.metaData.getString(AppCompnentFragment.KEY_BYTEDANCE_DEVELOPMENT_COMPONENT);
        L10:
            if (TextUtils.isEmpty(r3) == true) goto L19;
            if (r3.startsWith(".") == false) goto L15;
            r3 = r2.packageName + r3;
        L15:
            ComponentName r4 = new ComponentName(r2.packageName, r3);
            Intent r5 = new Intent();
            r5.setComponent(r4);
            ActivityInfo r6 = r5.resolveActivityInfo(r7.getPackageManager(), 0);
            if (r6 != null) goto L18;
            OLog.w(AppCompnentFragment.access$000(r7), "not exists ComponentName: " + r4);
            goto L19
        L18:
            MyApplicationInfo r10 = new MyApplicationInfo(r7);
            r10.info = r2;
            r10.label = r6.loadLabel(r7.getPackageManager()).toString();
            r10.launchIntent = r5;
            this.mPackageInfoList.add(r10);
        L19:
            r1 = r1 + 1;
            goto L4
        L8:
            r3 = null;
            goto L10
        L20:
            Collections.sort(this.mPackageInfoList, AppCompnentFragment.access$100());
            addAll(this.mPackageInfoList);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = this.mInflater.inflate(R.layout.list_content_item_text, r6, false);
            SettingItemText r7 = (SettingItemText) r5.findViewById(R.id.item_text);
            r5.setTag(r7);
        L5:
            MyApplicationInfo r0 = getItem(r4);
            r7.setTitle(r0.label);
            r7.setIcon(r0.info.loadIcon(this.this$0.getPackageManager()));
            int r1 = this.mAppIconSize;
            Utils.setItemIconSize(r7, r1, r1);
            r7.setSummary(r0.info.packageName);
            Utils.setItemBgStyle(r7, getCount(), r4);
            return r5;
        L4:
            r7 = (SettingItemText) r5.getTag();
            goto L5
        }
    }

    class MyApplicationInfo {
        ApplicationInfo info;
        CharSequence label;
        Intent launchIntent;
        final /* synthetic */ AppCompnentFragment this$0;

        MyApplicationInfo(AppCompnentFragment r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_settings_AppCompnentFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AppCompnentFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.dev_app_label;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppCompnentFragment() {
    }

    static /* synthetic */ String access$000(AppCompnentFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ Comparator access$100() {
        return sDisplayNameComparator;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.app_dev_list_layout, r3, false);
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        this.mEmptyView = findViewByIdNullable(R.id.view_empty);
        AppListAdapter r5 = new AppListAdapter(this, this.mContext);
        this.mAdapter = r5;
        if (r5.isEmpty() == false) goto L5;
        this.mEmptyView.setVisibility(0);
        this.mListView.setEmptyView(this.mEmptyView);
    L6:
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        addTransparentHeaderFooter(this.mListView);
        return this.mRootView;
    L5:
        this.mEmptyView.setVisibility(8);
        goto L6
    }

    public void addTransparentHeaderFooter(ListView r3) {
        if (r3.getHeaderViewsCount() == 0) goto L5;
        return;
    L5:
        if (r3.getFooterViewsCount() != 0) goto L9;
        r3.addHeaderView(Utils.inflateListTransparentHeader(this.mContext, r3, false));
        r3.addFooterView(Utils.inflateListTransparentHeader(this.mContext, r3, false));
        return;
    }

    static {
        sDisplayNameComparator = new AnonymousClass1();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        if (r6 != (-1)) goto L6;
        return;
    L6:
        if ((r3.getItemAtPosition(r5) instanceof MyApplicationInfo) == false) goto L9;
        MyApplicationInfo r7 = (MyApplicationInfo) r3.getItemAtPosition(r5);
        Utils.startActivity(this._mActivity, r7.launchIntent);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppCompnentFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppCompnentFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppCompnentFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppCompnentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppCompnentFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppCompnentFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
