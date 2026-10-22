package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class OptionsFragment extends BaseFragment {
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
    private String[] mOptionsTip;
    private int mOriginalIndex;
    private String mTargetKey;
    private String mTargetTable;
    private Object[] mValues;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ OptionsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(OptionsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(OptionsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (OptionsFragment.access$1000(this.this$0) == null) goto L6;
            return OptionsFragment.access$1000(this.this$0).length;
        L6:
            if (OptionsFragment.access$1100(this.this$0) != null) goto L11;
            return 0;
        L11:
            return OptionsFragment.access$1100(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            int[] r0 = OptionsFragment.access$1000(this.this$0);
            OptionsFragment r1 = this.this$0;
            if (r0 == null) goto L6;
            return Integer.valueOf(OptionsFragment.access$1000(r1)[r2]);
        L6:
            return OptionsFragment.access$1100(r1)[r2];
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, final View r8, final ViewGroup r9) {
            if (r8 != null) goto L5;
            r8 = LayoutInflater.from(this.this$0._mActivity).inflate(R.layout.olist_content_item_check_2, r9, false);
            OCardListItem r1 = (OCardListItem) NullSafe.nonNull(r8.findViewById(R.id.item_check));
            r8.setTag(r1);
        L6:
            r1.setDefaultCustomEndView(2);
            if (OptionsFragment.access$1000(this.this$0) == null) goto L9;
            String r3 = this.this$0.getResources().getString(OptionsFragment.access$1000(this.this$0)[r7]);
        L10:
            r1.setTitle(r3);
            r1.setOnContentClickListener(new OptionsFragment$OptionsAdapter$$ExternalSyntheticLambda0(this, r9, r7, r8));
            if (OptionsFragment.access$1200(this.this$0) != null) goto L13;
        L17:
            OTextView r10 = r1.getTitleView();
            if (Utils.caculateTextWidth(r10) < OptionsFragment.access$1300(this.this$0)) goto L20;
            Utils.setMaxTextSizeForTextView(r10, this.this$0.getResources().getDimensionPixelSize(R.dimen.common_max_size));
        L22:
            if (OptionsFragment.access$200(this.this$0) == null) goto L33;
            if (OptionsFragment.access$100(this.this$0)[r7] != null) goto L28;
            if (OptionsFragment.access$400(this.this$0) != null) goto L28;
        L29:
            boolean r11 = true;
        L31:
            r1.showCustomEnd(r11);
        L37:
            if (r7 == 0) goto L39;
        L41:
            if (r7 != 0) goto L44;
            r1.setCardPosition(1);
        L47:
            return r8;
        L44:
            if (r7 != (getCount() - 1)) goto L46;
            r1.setCardPosition(3);
            goto L47
        L46:
            r1.setCardPosition(2);
            goto L47
        L39:
            if (getCount() != 1) goto L41;
            r1.setCardPosition(0);
        L28:
            if (OptionsFragment.access$100(this.this$0)[r7].toString().equals(OptionsFragment.access$400(this.this$0)) == true) goto L29;
            r11 = false;
            goto L31
        L33:
            if (r7 != OptionsFragment.access$600(this.this$0)) goto L35;
            boolean r12 = true;
        L36:
            r1.showCustomEnd(r12);
            goto L37
        L35:
            r12 = false;
            goto L36
        L20:
            Utils.setMaxTextSizeForTextView(r10, 2.1474836E9f);
            goto L22
        L13:
            if (OptionsFragment.access$1200(this.this$0).length == 0) goto L17;
            if (OptionsFragment.access$1200(this.this$0).length <= r7) goto L17;
            r1.setSubTitle(OptionsFragment.access$1200(this.this$0)[r7]);
            r1.showSubTitle(true);
            goto L17
        L9:
            r3 = OptionsFragment.access$1100(this.this$0)[r7];
            goto L10
        L5:
            r1 = (OCardListItem) r8.getTag();
            goto L6
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-OptionsFragment$OptionsAdapter, reason: not valid java name */
        /* synthetic */ void m191x6fba194d(ViewGroup r7, int r8, View r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L8;
            ListView r1 = (ListView) r7;
            AdapterView.OnItemClickListener r0 = r1.getOnItemClickListener();
            if (r0 == null) goto L9;
            OLog.d(OptionsFragment.TAG, "onItemClick: finalPosition=" + r8);
            r0.onItemClick(r1, r9, r8, getItemId(r8));
            return;
        L9:
            return;
        }
    }

    public void com_android_settings_OptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OptionsFragment() {
    }

    static /* synthetic */ Object[] access$100(OptionsFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ int[] access$1000(OptionsFragment r0) {
        return r0.mOptionsRes;
    }

    static /* synthetic */ String[] access$1100(OptionsFragment r0) {
        return r0.mOptions;
    }

    static /* synthetic */ String[] access$1200(OptionsFragment r0) {
        return r0.mOptionsTip;
    }

    static /* synthetic */ float access$1300(OptionsFragment r0) {
        return r0.mOptionTitleMaxWidth;
    }

    static /* synthetic */ OptionsInfo access$200(OptionsFragment r0) {
        return r0.mOptionsInfo;
    }

    static /* synthetic */ boolean access$300(OptionsFragment r0) {
        return r0.mAutoFinishAfterSelect;
    }

    static /* synthetic */ Object access$400(OptionsFragment r0) {
        return r0.mCurrentValue;
    }

    static /* synthetic */ Object access$402(OptionsFragment r0, Object r1) {
        r0.mCurrentValue = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$500(OptionsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$600(OptionsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$602(OptionsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ String access$700(OptionsFragment r0) {
        return r0.mTargetTable;
    }

    static /* synthetic */ String access$800(OptionsFragment r0) {
        return r0.mTargetKey;
    }

    static /* synthetic */ void access$900(OptionsFragment r0, Object r1) {
        r0.saveSettingOption(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.options_layout, r3, false);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        Bundle r5 = getArguments();
        this.mAutoFinishAfterSelect = r5.getBoolean("extra_auto_finish", true);
        if (r5.containsKey("extra_option_info") == false) goto L6;
        processOptionArgs(r5);
    L13:
        OptionsAdapter r6 = new OptionsAdapter(this, null);
        this.mAdapter = r6;
        this.mOptionsList.setAdapter(r6);
        int r7 = getResources().getDrawable(R.drawable.icon_check_confirm_rounded).getIntrinsicWidth();
        DisplayMetrics r8 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(r8);
        this.mOptionTitleMaxWidth = (r8.widthPixels - (r8.density * 93.0f)) - r7;
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        return this.mRootView;
    L6:
        if (r5.containsKey("extra_options_res") == false) goto L8;
        this.mOptionsRes = r5.getIntArray("extra_options_res");
    L8:
        this.mOptions = r5.getStringArray("extra_options");
        this.mValues = r5.getStringArray("extra_values");
        if (r5.getString("extra_index") == null) goto L11;
        int r9 = Integer.parseInt(r5.getString("extra_index"));
        this.mCurrentIndex = r9;
        this.mOriginalIndex = r9;
    L12:
        this.mTargetTable = r5.getString("extra_target_table");
        this.mTargetKey = r5.getString("extra_target_key");
        goto L13
    L11:
        int r10 = r5.getInt("extra_index", 0);
        this.mCurrentIndex = r10;
        this.mOriginalIndex = r10;
        goto L12
    }

    private void processOptionArgs(Bundle r5) {
        this.mOptionsInfo = (OptionsInfo) r5.getParcelable("extra_option_info");
        this.mCurrentValue = r5.getString("extra_current_value");
        this.mOptions = this.mOptionsInfo.getOptionEntries();
        this.mOptionsTip = this.mOptionsInfo.getOptionTipEntries();
        this.mValues = this.mOptionsInfo.getOptionValues();
        Bundle r6 = this.mOptionsInfo.getExtrasArgs();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.containsKey("extra_option_tips_res") == false) goto L9;
        int r7 = r6.getInt("extra_option_tips_res");
        View r0 = LayoutInflater.from(this.mContext).inflate(R.layout.tips_layout, this.mOptionsList, false);
        this.mOptionsList.addFooterView(r0);
        ((TextView) r0.findViewById(R.id.tips)).setText(r7);
        r0.findViewById(R.id.item_shadow).setVisibility(8);
        return;
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
        int r2 = RESULT_OK;
    L12:
        r1.setResult(r2, r0);
        OLog.d(TAG, "mCurrentIndex:" + this.mCurrentIndex);
        goto L13
    L11:
        r2 = RESULT_CANCELED;
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
    public static void com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
