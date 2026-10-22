package com.android.settings.revone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class StylusKeySettingsFragment extends BaseFragment {
    public static final String EXTRA_CLICK_TYPE = "extra_click_type";
    private BaseAdapter mAdapter;
    private StylusClickType mClickType;
    private int mCurrentIndex;
    private int mKeyType;
    private ListView mListView;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ StylusKeySettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(StylusKeySettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(StylusKeySettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r2 = StylusKeySettingsFragment.access$400(this.this$0);
            if (r2 != 144) goto L5;
        L12:
            return 6;
        L5:
            if (r2 == 145) goto L12;
            if (r2 == 147) goto L10;
            return 0;
        L10:
            return 8;
        }

        @Override // android.widget.Adapter
        public String getItem(int r1) {
            return StylusKeyOperation.OPERATION_KEY[r1];
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            boolean r8 = false;
            if (r6 != null) goto L5;
            r6 = LayoutInflater.from(this.this$0.getActivity()).inflate(R.layout.revone_list_item_left_check, null, false);
            SettingItemCheckSimpleText r0 = (SettingItemCheckSimpleText) r6.findViewById(R.id.item_check_text);
            r6.setTag(r0);
        L6:
            Utils.setItemBgStyle(r0, getCount(), r5);
            if (Constants.STYLUS_KEY_LAUNCH_SPECIFIED_APP.equals(getItem(r5)) == false) goto L9;
            r0.showIconArrow(true);
            r0.setIconArrowListener(new AnonymousClass1(this));
        L9:
            r0.setTitleText(this.this$0.getString(StylusKeyOperation.OPERATION_NAME[r5]));
            if (r5 != StylusKeySettingsFragment.access$100(this.this$0)) goto L12;
            r8 = true;
        L12:
            r0.setChecked(r8);
            return r6;
        L5:
            r0 = (SettingItemCheckSimpleText) r6.getTag();
            goto L6
        }
    }

    public void com_android_settings_revone_StylusKeySettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_StylusKeySettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ int access$100(StylusKeySettingsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$102(StylusKeySettingsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$200(StylusKeySettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ StylusClickType access$300(StylusKeySettingsFragment r0) {
        return r0.mClickType;
    }

    static /* synthetic */ int access$400(StylusKeySettingsFragment r0) {
        return r0.mKeyType;
    }

    public StylusKeySettingsFragment() {
        super(R.layout.revone_fragment_stylus_key_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mListView = (ListView) findViewByIdNullable(R.id.options_list);
        this.mKeyType = getArguments().getInt(EXTRA_CLICK_TYPE);
        this.mClickType = new StylusClickType(this.mKeyType);
        OFloatingTitleBar r3 = this.mTitleView;
        if (r3 == null) goto L5;
        r3.setCenterTitle(this.mClickType.getTitleId());
    L5:
        this.mAdapter = new OptionsAdapter(this, null);
        this.mCurrentIndex = StylusKeyOperation.getCurrentIndex(this.mClickType.getStylusAppId(this.mContext));
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(new AnonymousClass1(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StylusKeySettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusKeySettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StylusKeySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusKeySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StylusKeySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusKeySettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
