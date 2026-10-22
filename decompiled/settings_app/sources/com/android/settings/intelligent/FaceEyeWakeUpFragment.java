package com.android.settings.intelligent;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.OptionsInfo;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class FaceEyeWakeUpFragment extends BaseFragment {
    public static final String EXTRA_AUTO_FINISH = "extra_auto_finish";
    public static final String EXTRA_CURRENT_INDEX = "extra_index";
    public static final String EXTRA_CURRENT_VALUE = "extra_current_value";
    public static final String EXTRA_OPTIONS = "extra_options";
    public static final String EXTRA_OPTIONS_RES = "extra_options_res";
    public static final String EXTRA_OPTION_INFO = "extra_option_info";
    public static final String EXTRA_OPTION_TIPS_RES = "extra_option_tips_res";
    public static final String EXTRA_TARGET_KEY = "extra_target_key";
    public static final String EXTRA_TARGET_TABLE = "extra_target_table";
    public static final String EXTRA_VALUES = "extra_values";
    private static final String TAG = "OptionsFragment";
    private BaseAdapter mAdapter;
    private boolean mAutoFinishAfterSelect;
    private int mCurrentIndex;
    private Object mCurrentValue;
    private float mOptionTitleMaxWidth;
    private String[] mOptions;
    private OptionsInfo mOptionsInfo;
    private ListView mOptionsList;
    private int[] mOptionsRes;
    private int mOriginalIndex;
    private String mTargetKey;
    private String mTargetTable;
    private Object[] mValues;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ FaceEyeWakeUpFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(FaceEyeWakeUpFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(FaceEyeWakeUpFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int[] r0 = FaceEyeWakeUpFragment.access$300(this.this$0);
            FaceEyeWakeUpFragment r1 = this.this$0;
            if (r0 == null) goto L6;
            return FaceEyeWakeUpFragment.access$300(r1).length;
        L6:
            return FaceEyeWakeUpFragment.access$400(r1).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            int[] r0 = FaceEyeWakeUpFragment.access$300(this.this$0);
            FaceEyeWakeUpFragment r1 = this.this$0;
            if (r0 == null) goto L6;
            return Integer.valueOf(FaceEyeWakeUpFragment.access$300(r1)[r2]);
        L6:
            return FaceEyeWakeUpFragment.access$400(r1)[r2];
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            boolean r0 = false;
            if (r6 != null) goto L5;
            r6 = LayoutInflater.from(this.this$0.getActivity()).inflate(R.layout.list_content_item_check, r7, false);
            SettingItemCheck r8 = (SettingItemCheck) NullSafe.nonNull(r6.findViewById(R.id.item_check));
            r6.setTag(r8);
        L6:
            Utils.setItemBgStyle(r8, getCount(), r5);
            if (FaceEyeWakeUpFragment.access$300(this.this$0) == null) goto L9;
            String r1 = this.this$0.getResources().getString(FaceEyeWakeUpFragment.access$300(this.this$0)[r5]);
        L10:
            r8.setTitle(r1);
            if (Utils.caculateTextWidth(r8.getTitleView()) < FaceEyeWakeUpFragment.access$500(this.this$0)) goto L13;
            Utils.setMaxTextSizeForTextView(r8.getTitleView(), this.this$0.getResources().getDimensionPixelSize(R.dimen.common_max_size));
        L15:
            if (FaceEyeWakeUpFragment.access$600(this.this$0) == null) goto L25;
            if (FaceEyeWakeUpFragment.access$100(this.this$0)[r5] != null) goto L21;
            if (FaceEyeWakeUpFragment.access$700(this.this$0) != null) goto L21;
        L22:
            r0 = true;
        L23:
            r8.setChecked(r0);
        L28:
            return r6;
        L21:
            if (FaceEyeWakeUpFragment.access$100(this.this$0)[r5].toString().equals(FaceEyeWakeUpFragment.access$700(this.this$0)) == false) goto L23;
        L25:
            if (r5 != FaceEyeWakeUpFragment.access$800(this.this$0)) goto L27;
            r0 = true;
        L27:
            r8.setChecked(r0);
            goto L28
        L13:
            Utils.setMaxTextSizeForTextView(r8.getTitleView(), 2.1474836E9f);
            goto L15
        L9:
            r1 = FaceEyeWakeUpFragment.access$400(this.this$0)[r5];
            goto L10
        L5:
            r8 = (SettingItemCheck) r6.getTag();
            goto L6
        }
    }

    public void com_android_settings_intelligent_FaceEyeWakeUpFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_intelligent_FaceEyeWakeUpFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ Object[] access$100(FaceEyeWakeUpFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ void access$200(FaceEyeWakeUpFragment r0, Object r1) {
        r0.saveSettingOption(r1);
    }

    static /* synthetic */ int[] access$300(FaceEyeWakeUpFragment r0) {
        return r0.mOptionsRes;
    }

    static /* synthetic */ String[] access$400(FaceEyeWakeUpFragment r0) {
        return r0.mOptions;
    }

    static /* synthetic */ float access$500(FaceEyeWakeUpFragment r0) {
        return r0.mOptionTitleMaxWidth;
    }

    static /* synthetic */ OptionsInfo access$600(FaceEyeWakeUpFragment r0) {
        return r0.mOptionsInfo;
    }

    static /* synthetic */ Object access$700(FaceEyeWakeUpFragment r0) {
        return r0.mCurrentValue;
    }

    static /* synthetic */ int access$800(FaceEyeWakeUpFragment r0) {
        return r0.mCurrentIndex;
    }

    public FaceEyeWakeUpFragment() {
        super(R.layout.face_eye_wakeup_layout);
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r3, Bundle r4) {
        super.initViews(r3, r4);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mOptionsList.addHeaderView(Utils.inflateListTransparentHeader(getActivity(), this.mOptionsList, false));
        OptionsAdapter r5 = new OptionsAdapter(this, null);
        this.mAdapter = r5;
        this.mOptionsList.setAdapter(r5);
        int r6 = getResources().getDrawable(R.drawable.icon_check_confirm_rounded).getIntrinsicWidth();
        DisplayMetrics r7 = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(r7);
        this.mOptionTitleMaxWidth = (r7.widthPixels - (r7.density * 93.0f)) - r6;
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        if (this.mOptionsInfo == null) goto L5;
    L13:
        super.finish();
        return;
    L5:
        if (this.mTargetTable != null) goto L13;
        if ((getActivity() instanceof Settings.OptionsActivity) == false) goto L13;
        Intent r0 = new Intent();
        r0.putExtra("extra_index", this.mCurrentIndex);
        FragmentActivity r1 = getActivity();
        if (this.mOriginalIndex == this.mCurrentIndex) goto L11;
        int r2 = -1;
    L12:
        r1.setResult(r2, r0);
        OLog.d(TAG, "finish, mCurrentIndex:" + this.mCurrentIndex);
        goto L13
    L11:
        r2 = 0;
        goto L12
    }

    private void saveSettingOption(Object r3) {
        if (SettingsSwitchKeyUtil.SettingTable.System.equals(this.mTargetTable) == false) goto L6;
        android.provider.Settings.System.putString(getContentResolver(), this.mTargetKey, r3.toString());
        return;
    L6:
        if (SettingsSwitchKeyUtil.SettingTable.Global.equals(this.mTargetTable) == false) goto L9;
        android.provider.Settings.Global.putString(getContentResolver(), this.mTargetKey, r3.toString());
        return;
    L9:
        if ("secure".equals(this.mTargetTable) == false) goto L14;
        android.provider.Settings.Secure.putString(getContentResolver(), this.mTargetKey, r3.toString());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceEyeWakeUpFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_FaceEyeWakeUpFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceEyeWakeUpFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_FaceEyeWakeUpFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceEyeWakeUpFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_FaceEyeWakeUpFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
