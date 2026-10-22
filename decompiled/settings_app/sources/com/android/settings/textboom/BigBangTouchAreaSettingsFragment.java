package com.android.settings.textboom;

import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TouchAreaTestView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class BigBangTouchAreaSettingsFragment extends BaseFragment {
    private BaseAdapter mAdapter;
    private int mCurrentIndex;
    private String[] mOptions;
    private ListView mOptionsList;
    private TouchAreaTestView mTouchAreaTestView;
    private Integer[] mValues;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ BigBangTouchAreaSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(BigBangTouchAreaSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(BigBangTouchAreaSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BigBangTouchAreaSettingsFragment.access$600(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = View.inflate(this.this$0._mActivity, R.layout.list_content_item_check, null);
            SettingItemCheck r5 = (SettingItemCheck) r3.findViewById(R.id.item_check);
            r3.setTag(r5);
        L5:
            Utils.setItemBgStyle(r5, getCount(), r2);
            r5.setTitle(BigBangTouchAreaSettingsFragment.access$600(this.this$0)[r2]);
            if (r2 != BigBangTouchAreaSettingsFragment.access$300(this.this$0)) goto L8;
            boolean r1 = true;
        L9:
            r5.setChecked(r1);
            return r3;
        L8:
            r1 = false;
            goto L9
        L4:
            r5 = (SettingItemCheck) r3.getTag();
            goto L5
        }
    }

    public void com_android_settings_textboom_BigBangTouchAreaSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BigBangTouchAreaSettingsFragment() {
    }

    static /* synthetic */ ListView access$100(BigBangTouchAreaSettingsFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ Integer[] access$200(BigBangTouchAreaSettingsFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ int access$300(BigBangTouchAreaSettingsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$302(BigBangTouchAreaSettingsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ TouchAreaTestView access$400(BigBangTouchAreaSettingsFragment r0) {
        return r0.mTouchAreaTestView;
    }

    static /* synthetic */ BaseAdapter access$500(BigBangTouchAreaSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ String[] access$600(BigBangTouchAreaSettingsFragment r0) {
        return r0.mOptions;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.bigbang_touch_area_layout, r5, false);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mOptions = getResources().getStringArray(R.array.thumb_trigger_area_options);
        this.mValues = new Integer[]{0, 1, 2, 3, 4};
        this.mCurrentIndex = Settings.Global.getInt(getContentResolver(), "boom_text_trigger_area", 2);
        this.mOptionsList.addHeaderView(Utils.inflateListTransparentHeader(this._mActivity, this.mOptionsList, false));
        addFooterView();
        OptionsAdapter r7 = new OptionsAdapter(this, null);
        this.mAdapter = r7;
        this.mOptionsList.setAdapter(r7);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        Utils.setListViewIgnoreAccessibilityItemCount(this.mOptionsList, 1);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mTitleView.setCenterTitle(R.string.thumb_trigger_area);
        boolean r0 = true;
        if (Settings.Global.getInt(getContentResolver(), "text_boom", 1) == 1) goto L6;
        r0 = false;
    L6:
        if (r0 == true) goto L9;
        finish();
        return;
    }

    public void com_android_settings_textboom_BigBangTouchAreaSettingsFragment__onResume$___twin___() {
        super.onResume();
        boolean r2 = true;
        if (Settings.Global.getInt(getContentResolver(), "text_boom", 1) == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == true) goto L9;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mTouchAreaTestView.cancelAnims();
        super.onDestroyView();
    }

    private void addFooterView() {
        View r0 = LayoutInflater.from(this._mActivity).inflate(R.layout.touch_area_test_layout, null, false);
        this.mTouchAreaTestView = (TouchAreaTestView) r0.findViewById(R.id.touch_area_view);
        this.mOptionsList.addFooterView(r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BigBangTouchAreaSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_BigBangTouchAreaSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BigBangTouchAreaSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_BigBangTouchAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BigBangTouchAreaSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_BigBangTouchAreaSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
