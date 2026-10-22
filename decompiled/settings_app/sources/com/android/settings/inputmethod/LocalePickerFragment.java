package com.android.settings.inputmethod;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.app.LocalePicker;
import com.android.internal.app.LocaleStore;
import com.android.settings.AboutFragment;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.widget.GestureDetector;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocalePickerFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private boolean isSetupWizard;
    private LocalePickerAdapter mAdapter;
    private final Configuration mCurConfig;
    private LocaleInfo[] mData;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private ListView mList;
    Runnable mLocaleRunnable;
    private TextView mSelectLangTipTextView;
    private AlertDialog mWarningDialog;

    public class LocaleInfo implements Comparable<LocaleInfo> {
        String label;
        Locale locale;
        Collator sCollator;
        final /* synthetic */ LocalePickerFragment this$0;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(LocaleInfo r1) {
            return compareTo2(r1);
        }

        public LocaleInfo(LocalePickerFragment r1, String r2, Locale r3) {
            this.this$0 = r1;
            this.sCollator = Collator.getInstance();
            this.label = r2;
            this.locale = r3;
        }

        public String getLabel() {
            return this.label;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public String toString() {
            return this.label;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(LocaleInfo r2) {
            return this.sCollator.compare(this.label, r2.label);
        }
    }

    private class LocalePickerAdapter extends BaseAdapter {
        private String mCurrent;
        final /* synthetic */ LocalePickerFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private LocalePickerAdapter(LocalePickerFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LocalePickerAdapter(LocalePickerFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (LocalePickerFragment.access$500(this.this$0) != null) goto L7;
            return 0;
        L7:
            return LocalePickerFragment.access$500(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return LocalePickerFragment.access$500(this.this$0)[r1];
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = View.inflate(this.this$0._mActivity, R.layout.olist_content_item_check, null);
            OListItemCheck r7 = (OListItemCheck) r5.findViewById(R.id.item_check);
            ViewHolder r1 = new ViewHolder(null);
            r1.mItemCheck = r7;
            r5.setTag(r1);
        L5:
            OListItemCheck r8 = r1.mItemCheck;
            r8.setTrailingImageView(this.this$0.mContext.getDrawable(R.drawable.icon_check_confirm_rounded));
            LocaleInfo r9 = LocalePickerFragment.access$500(this.this$0)[r4];
            String r0 = r9.toString();
            if (r0.equals(this.this$0.getString(R.string.language_chinese)) == false) goto L9;
            r8.setTitle(this.this$0.getString(R.string.lauguage_chinese_simple));
        L13:
            if (Locale.KOREA.equals(r9.getLocale()) == false) goto L15;
            r8.getMTvTitle().setContentDescription(this.this$0.getString(R.string.language_korean));
        L16:
            String r2 = Locale.getDefault().getDisplayName();
            this.mCurrent = r2;
            if (r2.equals(r9.getLocale().getDisplayName()) == false) goto L19;
            r8.setChecked(true);
        L20:
            return r5;
        L19:
            r8.setChecked(false);
            goto L20
        L15:
            r8.getMTvTitle().setContentDescription(r8.getMTvTitle().getText());
            goto L16
        L9:
            if (r0.equals(this.this$0.getString(R.string.lauguage_russian)) == false) goto L11;
            r8.setTitle(r0 + " (beta)");
            goto L13
        L11:
            r8.setTitle(r0);
            goto L13
        L4:
            r1 = (ViewHolder) r5.getTag();
            goto L5
        }
    }

    private static class ViewHolder {
        OListItemCheck mItemCheck;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(AnonymousClass1 r1) {
            this();
        }
    }

    public void com_android_settings_inputmethod_LocalePickerFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocalePickerFragment() {
        this.mGestureDetector = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass4(this);
        this.mLocaleRunnable = new AnonymousClass5(this);
        this.mCurConfig = new Configuration();
    }

    static /* synthetic */ boolean access$000(LocalePickerFragment r0) {
        return r0.isSetupWizard;
    }

    static /* synthetic */ String access$100(LocalePickerFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$300(LocalePickerFragment r0) {
        r0.launchSetupWizardLicenseActivity();
    }

    static /* synthetic */ void access$400(LocalePickerFragment r0) {
        r0.showWarningDialog();
    }

    static /* synthetic */ LocaleInfo[] access$500(LocalePickerFragment r0) {
        return r0.mData;
    }

    static /* synthetic */ LocaleInfo[] access$502(LocalePickerFragment r0, LocaleInfo[] r1) {
        r0.mData = r1;
        return r1;
    }

    static /* synthetic */ LocalePickerAdapter access$700(LocalePickerFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ AlertDialog access$802(LocalePickerFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    public void com_android_settings_inputmethod_LocalePickerFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        boolean r4 = Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false);
        this.isSetupWizard = r4;
        if (r4 == false) goto L6;
        this._mActivity.setTheme(R.style.DisableSwipeToDismiss);
        return;
    }

    private void resetWizardSettingsIfNeed() {
        if (this.isSetupWizard == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), Constants.DEVICE_ACTIVATION_COMPLETED, 0) != 1) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        Locale r0 = Locale.forLanguageTag(SystemProperties.get("ro.product.locale"));
        if (Locale.getDefault().equals(r0) == true) goto L14;
        OLog.d(this.TAG, "not activated device with not product locale, reset it to :" + r0);
        setLocale(r0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.locale_picker_layout, r3, false);
        this.mList = (ListView) findViewByIdNullable(R.id.list);
        LocalePickerAdapter r5 = new LocalePickerAdapter(this, null);
        this.mAdapter = r5;
        this.mList.setAdapter(r5);
        this.mList.setOnItemClickListener(this);
        setupLocaleListHeader();
        this.mHandler.post(this.mLocaleRunnable);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (this.isSetupWizard == false) goto L6;
        this.mTitleView.setCenterTitle(R.string.setupwizard_locale_picker_title);
        View r5 = findViewByIdNullable(R.id.next_step_btn);
        findViewByIdNullable(R.id.next_step_btn_group).setVisibility(0);
        r5.setOnClickListener(new AnonymousClass2(this));
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) this.mList.getLayoutParams();
        r6.removeRule(2);
        this.mList.setLayoutParams(r6);
        ((BaseActivity) this._mActivity).registerWizardFinishReceiver();
        this.mTitleView.addEndAction(R.drawable.selector_titlebar_device_info, -1, null).setOnClickListener(new AnonymousClass3(this));
        return;
    }

    private View inflateDeviceInfoView() {
        LinearLayout r5 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.device_info_layout, null);
        ((TextView) r5.findViewById(R.id.id_model_summary)).setText(Build.MODEL + AboutFragment.getMsvSuffix());
        ((TextView) r5.findViewById(R.id.id_storage_summary)).setText(Utils.getStorageVersion());
        TextView r0 = (TextView) r5.findViewById(R.id.id_imei_summary);
        boolean r1 = Utils.isMultiSimSupport();
        TelephonyManager r2 = TelephonyManager.getDefault();
        String r3 = r2.getImei(0);
        String r4 = r2.getImei(1);
        if (r1 == false) goto L5;
        r3 = r3 + "\n" + r4;
    L5:
        r0.setText(r3);
        return r5;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        if (getView() != null) goto L5;
        return;
    L5:
        this.mAdapter.notifyDataSetChanged();
        if (this.isSetupWizard == false) goto L9;
        this.mTitleView = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        this.mTitleView.setCenterTitle(R.string.setupwizard_locale_picker_title);
        ((Button) findViewByIdNullable(R.id.next_step_btn)).setText(R.string.button_next_step);
        this.mSelectLangTipTextView.setText(R.string.setupwizard_locale_picker_list_title);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (this.isSetupWizard == false) goto L5;
        return true;
    L5:
        return super.onBackPressedSupport();
    }

    private void launchSetupWizardLicenseActivity() {
        Intent r0 = new Intent();
        r0.setClassName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.LicenseActivity");
        Utils.startActivity(this._mActivity, r0, 0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void setupLocaleListHeader() {
        if (this.isSetupWizard == false) goto L5;
        View r0 = LayoutInflater.from(this._mActivity).inflate(R.layout.setup_wizard_locale_picker_list_title, null);
        this.mSelectLangTipTextView = (TextView) r0.findViewById(R.id.setup_wizard_locale_list_title);
        this.mList.addHeaderView(r0);
        return;
    L5:
        View r1 = Utils.inflateListTransparentHeader(this._mActivity);
        r1.setMinimumHeight(ResourceUtils.getResources().getDimensionPixelSize(R.dimen.top_gap));
        this.mList.addHeaderView(r1);
    }

    public LocaleInfo[] constructAdapter(Context r13) {
        Resources r14 = r13.getResources();
        String[] r0 = Resources.getSystem().getAssets().getLocales();
        String[] r1 = r14.getStringArray(17236294);
        String[] r15 = r14.getStringArray(17236295);
        Arrays.sort(r0);
        int r2 = r0.length;
        LocaleInfo[] r3 = new LocaleInfo[r2];
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r2) goto L24;
        String r7 = r0[r5];
        if (r7.equals("en-US") == true) goto L10;
        if (r7.equals("zh-CN") == true) goto L10;
    L23:
        r5 = r5 + 1;
    L10:
        if (r7.length() != 5) goto L23;
        String r8 = r7.substring(0, 2);
        Locale r10 = new Locale(r8, r7.substring(3, 5));
        if (r6 != 0) goto L15;
        int r9 = r6 + 1;
        r3[r6] = new LocaleInfo(this, toTitleCase(r10.getDisplayLanguage(r10)), r10);
    L14:
        r6 = r9;
        goto L23
    L15:
        int r11 = r6 - 1;
        if (r3[r11].locale.getLanguage().equals(r8) == false) goto L19;
        LocaleInfo r12 = r3[r11];
        r12.label = toTitleCase(getDisplayName(r12.locale, r1, r15));
        r9 = r6 + 1;
        r3[r6] = new LocaleInfo(this, toTitleCase(getDisplayName(r10, r1, r15)), r10);
        goto L14
    L19:
        if (r7.equals("zz_ZZ") == false) goto L21;
        String r16 = "Pseudo...";
    L22:
        r3[r6] = new LocaleInfo(this, r16, r10);
        r6 = r6 + 1;
        goto L23
    L21:
        r16 = toTitleCase(r10.getDisplayLanguage(r10));
        goto L22
    L24:
        LocaleInfo[] r17 = new LocaleInfo[r6];
    L25:
        if (r4 >= r6) goto L27;
        r17[r4] = r3[r4];
        r4 = r4 + 1;
        goto L25
    L27:
        return r17;
    }

    private String toTitleCase(String r2) {
        if (r2.length() != 0) goto L6;
        return r2;
    L6:
        return Character.toUpperCase(r2.charAt(0)) + r2.substring(1);
    }

    private String getDisplayName(Locale r3, String[] r4, String[] r5) {
        String r2 = r3.toString();
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L11;
        if (r4[r0].equals(r2) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r5[r0];
    L11:
        return r3.getDisplayName(r3);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        if (r6 != (-1)) goto L5;
        return;
    L5:
        Locale r7 = ((LocaleInfo) r3.getAdapter().getItem(r5)).locale;
        if (this.isSetupWizard == false) goto L8;
    L10:
        setLocale(r7);
        return;
    L8:
        if (this.mIsExtDisplaying == true) goto L10;
        finish();
        goto L10
    }

    private void setLocale(Locale r1) {
        updateFontScale(r1);
        updateLocale(r1);
        OLog.d(this.TAG, "setLocale-----------------finish");
    }

    private List<LocaleStore.LocaleInfo> getUserLocaleList() {
        ArrayList r3 = new ArrayList();
        LocaleList r0 = LocalePicker.getLocales();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        r3.add(LocaleStore.getLocaleInfo(r0.get(r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r3;
    }

    public void updateLocale(Locale r4) {
        List<LocaleStore.LocaleInfo> r0 = getUserLocaleList();
        OLog.d(this.TAG, "new local:" + r4 + ", the old list:" + r0);
        LocaleStore.LocaleInfo r3 = LocaleStore.getLocaleInfo(r4);
        int r1 = 0;
        if (r0.contains(r3) == false) goto L5;
        r0.add(0, r0.remove(r0.indexOf(r3)));
    L6:
        int r5 = r0.size();
        Locale[] r6 = new Locale[r5];
    L7:
        if (r1 >= r5) goto L9;
        r6[r1] = r0.get(r1).getLocale();
        r1 = r1 + 1;
        goto L7
    L9:
        LocaleList r7 = new LocaleList(r6);
        LocaleList.setDefault(r7);
        LocalePicker.updateLocales(r7);
        return;
    L5:
        r0.add(0, r3);
        goto L6
    }

    private void updateFontScale(Locale r7) {
        Configuration r0 = this._mActivity.getResources().getConfiguration();
        r0.setLocale(r7);
        String[] r1 = this._mActivity.createConfigurationContext(r0).getResources().getStringArray(R.array.font_scale_values);
        OLog.d(this.TAG, "locale " + r7 + " , font scale array: " + r1);
        float r8 = getCurrentFontScale();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L9;
        if (Float.valueOf(r1[r4]).floatValue() == r8) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        r3 = true;
    L9:
        if (r3 == true) goto L14;
        float r5 = Float.valueOf(r1[r1.length - 1]).floatValue();
        OLog.d(this.TAG, "current font " + r8 + " not found, set as " + r5);
        setFontSize(r5);
        return;
    }

    private float getCurrentFontScale() {
        this.mCurConfig.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L5
    L4:
        return this.mCurConfig.fontScale;
    }

    private void setFontSize(float r2) {
        Settings.System.putFloat(this.mContext.getContentResolver(), "font_scale", r2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackLanguageAndImSettings(this.mContext);
        super.onDestroy();
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean dispatchTouchEvent(MotionEvent r2) {
        if (this.mGestureDetector.dispatchTouchEvent(r2) == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    private void showWarningDialog() {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        AlertDialog.Builder r1 = new AlertDialog.Builder(this._mActivity);
        r1.setTitle(R.string.setup_device_into_title).setNegativeButton(R.string.dlg_close, null).setPositiveButton(R.string.dlg_set_wallpaper_button, null).setView(inflateDeviceInfoView()).setCancelable(false).setOnDismissListener(new AnonymousClass6(this));
        AlertDialog r2 = r1.create();
        this.mWarningDialog = r2;
        r2.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocalePickerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_LocalePickerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocalePickerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_LocalePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocalePickerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_LocalePickerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
