package com.android.settings.inputmethod;

import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.input.InputManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.settings.Constants;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.autofill.AutofillPickerFragment;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodAndLanguageSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "InputMethodSettings";
    private final String AIRDROID_PACKAGENAME;
    private Comparator<InputMethodInfo> alphabetComparator;
    private OPopover mAutoFillPopover;
    private OCardListItem mAutoFillService;
    private AutofillOption mAutofillOption;
    private OSwitch mCbKeyBoardCheck;
    private OSwitch mCbSpellingCheck;
    private DevicePolicyManager mDpm;
    private Handler mHandler;
    private InputManager mIm;
    private HashMap<String, InputMethodInfoDetail> mImDetailsMap;
    private OTextView mImSubtitle;
    private final List<InputMethodAndSubtypeUtil.ImeSubtypeHolder> mImeSubtypeHolderList;
    private List<InputMethodInfo> mImis;
    private InputMethodManager mImm;
    private InputMethodSettingValuesWrapper mInputMethodSettingValues;
    private OCardListItem mItemDefaultInputmethod;
    private OCardListItem mItemLanguage;
    private OCardListItem mItemSpellingCheckSetting;
    private OCardListItem mItemUserDictionary;
    private LanguageOption mLanguageOption;
    private OPopover mLanguagePopover;
    private LinearLayout mListInputMethod;
    private Object mLock;
    private PackageManager mPackageManager;
    private volatile boolean mQuering;
    private OAlertDialog mSecurityWarningDialog;
    private SettingsObserver mSettingsObserver;
    private OCardListItem mSwitchKeyBoard;
    private OCardListItem mSwitchSpellingCheck;
    private int mTitleStringResId;
    private TextServicesManager mTsm;
    private UserManager mUm;
    private HashMap<String, InputMethodInfoDetail> mWorkImDetailsMap;
    private final List<InputMethodAndSubtypeUtil.ImeSubtypeHolder> mWorkImeSubtypeHolderList;
    private List<InputMethodInfo> mWorkImis;
    private InputMethodSettingValuesWrapper mWorkInputMethodSettingValues;
    private LinearLayout mWorkInputmethodApps;
    private View mWorkInputmethodTitle;

    private class InputMethodInfoDetail {
        boolean alwaysChecked;
        boolean check;
        String id;
        boolean isAllowedByOrganization;
        String subTitle;
        final /* synthetic */ InputMethodAndLanguageSettingsFragment this$0;
        CharSequence title;

        public InputMethodInfoDetail(InputMethodAndLanguageSettingsFragment r6, InputMethodInfo r7) {
            this.this$0 = r6;
            this.isAllowedByOrganization = true;
            this.id = r7.getId();
            this.title = r7.loadLabel(InputMethodAndLanguageSettingsFragment.access$1100(r6));
            this.subTitle = r6.getSummaryString(r7);
            this.alwaysChecked = InputMethodAndLanguageSettingsFragment.access$100(r6).isAlwaysCheckedIme(r7, r6.mContext);
            HashMap<String, HashSet<String>> r1 = InputMethodAndSubtypeUtil.getEnabledInputMethodsAndSubtypeList(r6.getContentResolver());
            UserHandle r2 = Utils.getManagedProfile(InputMethodAndLanguageSettingsFragment.access$600(r6));
            UserHandle r3 = UserHandle.getUserHandleForUid(r7.getServiceInfo().applicationInfo.uid);
            if (r2 != null) goto L5;
        L7:
            if (r1 != null) goto L9;
        L11:
            this.check = false;
        L12:
            applyOrganizationPolicy(r7);
            return;
        L9:
            if (r1.containsKey(r7.getId()) == false) goto L11;
            this.check = true;
            r1.clear();
            goto L12
        L5:
            if (r2.equals(r3) == false) goto L7;
            Context r4 = r6.mContext.createContextAsUser(r2, 0);
            this.alwaysChecked = InputMethodAndLanguageSettingsFragment.access$1200(r6).isAlwaysCheckedIme(r7, r4);
            r1 = InputMethodAndSubtypeUtil.getEnabledInputMethodsAndSubtypeList(r4.getContentResolver());
            goto L7
        }

        private void applyOrganizationPolicy(InputMethodInfo r4) {
            UserHandle r0 = UserHandle.getUserHandleForUid(r4.getServiceInfo().applicationInfo.uid);
            boolean r2 = false;
            List r1 = ((DevicePolicyManager) this.this$0.mContext.createContextAsUser(r0, 0).getSystemService(DevicePolicyManager.class)).getPermittedInputMethods();
            if (r1 != null) goto L5;
        L8:
            r2 = true;
        L9:
            this.isAllowedByOrganization = r2;
            return;
        L5:
            if (r1.contains(r4.getPackageName()) == true) goto L8;
            if (this.alwaysChecked == false) goto L9;
            goto L8
        }
    }

    private class SettingsObserver extends ContentObserver {
        private Context mContext;
        final /* synthetic */ InputMethodAndLanguageSettingsFragment this$0;

        public SettingsObserver(InputMethodAndLanguageSettingsFragment r1, Handler r2, Context r3) {
            this.this$0 = r1;
            super(r2);
            this.mContext = r3;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r3) {
            InputMethodAndLanguageSettingsFragment.access$000(this.this$0);
            InputMethodInfo r4 = InputMethodAndLanguageSettingsFragment.access$100(this.this$0).getCurrentInputMethodInfo();
            if (r4 == null) goto L6;
            OLog.d(InputMethodAndLanguageSettingsFragment.TAG, "received input method changed, new ime = " + r4.getId());
            OLog.d(InputMethodAndLanguageSettingsFragment.TAG, "Settings.Secure.Default_input_method values is " + Settings.Secure.getString(this.this$0.getContentResolver(), "default_input_method"));
            return;
        }

        public void resume() {
            OLog.d(InputMethodAndLanguageSettingsFragment.TAG, "register input method observer.");
            ContentResolver r0 = this.mContext.getContentResolver();
            r0.registerContentObserver(Settings.Secure.getUriFor("default_input_method"), false, this);
            r0.registerContentObserver(Settings.Secure.getUriFor("selected_input_method_subtype"), false, this);
            r0.registerContentObserver(Settings.Secure.getUriFor("enabled_input_methods"), false, this);
        }

        public void pause() {
            this.mContext.getContentResolver().unregisterContentObserver(this);
        }
    }

    public void com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public InputMethodAndLanguageSettingsFragment() {
        this.AIRDROID_PACKAGENAME = "com.sand.airdroid";
        this.mImDetailsMap = new HashMap();
        this.mImeSubtypeHolderList = new ArrayList();
        this.mWorkImeSubtypeHolderList = new ArrayList();
        this.mWorkImDetailsMap = new HashMap();
        this.alphabetComparator = new AnonymousClass1(this);
        this.mQuering = false;
        this.mLock = new String("lock");
    }

    static /* synthetic */ void access$000(InputMethodAndLanguageSettingsFragment r0) {
        r0.updateDefaultInputMethod();
    }

    static /* synthetic */ InputMethodSettingValuesWrapper access$100(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mInputMethodSettingValues;
    }

    static /* synthetic */ void access$1000(InputMethodAndLanguageSettingsFragment r0) {
        r0.updateWorkInputmethodList();
    }

    static /* synthetic */ PackageManager access$1100(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ InputMethodSettingValuesWrapper access$1200(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mWorkInputMethodSettingValues;
    }

    static /* synthetic */ Object access$200(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mLock;
    }

    static /* synthetic */ HashMap access$300(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mImDetailsMap;
    }

    static /* synthetic */ boolean access$400(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mQuering;
    }

    static /* synthetic */ boolean access$402(InputMethodAndLanguageSettingsFragment r0, boolean r1) {
        r0.mQuering = r1;
        return r1;
    }

    static /* synthetic */ InputMethodManager access$500(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mImm;
    }

    static /* synthetic */ UserManager access$600(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mUm;
    }

    static /* synthetic */ List access$700(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mWorkImis;
    }

    static /* synthetic */ List access$702(InputMethodAndLanguageSettingsFragment r0, List r1) {
        r0.mWorkImis = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$800(InputMethodAndLanguageSettingsFragment r0) {
        return r0.mWorkImDetailsMap;
    }

    static /* synthetic */ void access$900(InputMethodAndLanguageSettingsFragment r0) {
        r0.updateInputmethodList();
    }

    public void com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mDpm = (DevicePolicyManager) getApplicationContext().getSystemService("device_policy");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.inputmethod_language_settings_layout, r4, false);
        this.mTitleStringResId = R.string.language_settings;
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.item_id_language);
        this.mItemLanguage = r6;
        r6.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda10(this));
        this.mItemLanguage.setDefaultCustomEndView(3);
        this.mItemLanguage.showCustomEnd(true);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.item_id_switch_spelling_check);
        this.mSwitchSpellingCheck = r7;
        r7.setDefaultCustomEndView(1);
        this.mSwitchSpellingCheck.showCustomEnd(true);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_id_button_spelling_check);
        this.mItemSpellingCheckSetting = r8;
        r8.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda11(this));
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.item_id_user_dictionary);
        this.mItemUserDictionary = r9;
        r9.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda12(this));
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.item_id_default_inputmethod);
        this.mItemDefaultInputmethod = r10;
        r10.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda13(this));
        this.mItemDefaultInputmethod.setDefaultCustomEndView(3);
        this.mItemDefaultInputmethod.showCustomEnd(true);
        this.mAutoFillService = (OCardListItem) findViewByIdNullable(R.id.autofill_service);
        this.mAutoFillService.setVisibility(0);
        this.mAutoFillService.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda14(this));
        this.mAutoFillService.setDefaultCustomEndView(3);
        this.mAutoFillService.showCustomEnd(true);
        this.mListInputMethod = (LinearLayout) findViewByIdNullable(R.id.inputmethod_list);
        this.mWorkInputmethodTitle = this.mRootView.findViewById(R.id.inputmethod_list_work_title);
        this.mWorkInputmethodApps = (LinearLayout) this.mRootView.findViewById(R.id.inputmethod_list_work);
        this.mTsm = (TextServicesManager) getSystemService("textservices");
        this.mImm = (InputMethodManager) getSystemService("input_method");
        this.mIm = (InputManager) getSystemService("input");
        this.mPackageManager = getPackageManager();
        this.mDpm = (DevicePolicyManager) getSystemService("device_policy");
        this.mUm = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mSwitchKeyBoard = (OCardListItem) findViewByIdNullable(R.id.id_security_keyboard);
        if (SettingsFeature.isSupportSecurityKeyboard(this.mContext) == false) goto L5;
        this.mSwitchKeyBoard.setDefaultCustomEndView(1);
        this.mSwitchKeyBoard.showCustomEnd(true);
        this.mCbKeyBoardCheck = (OSwitch) this.mSwitchKeyBoard.getCustomEndView();
    L6:
        this.mHandler = new Handler();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler, this.mContext);
        this.mInputMethodSettingValues = InputMethodSettingValuesWrapper.getInstance(this.mContext);
        UserHandle r11 = Utils.getManagedProfile(this.mUm);
        if (r11 == null) goto L10;
        this.mWorkInputMethodSettingValues = InputMethodSettingValuesWrapper.getInstance(this.mContext.createContextAsUser(r11, 0));
    L10:
        if (Utils.isOnlySupportTnt() == false) goto L12;
        findViewByIdNullable(R.id.id_text_input_method).setVisibility(8);
        this.mItemDefaultInputmethod.setVisibility(8);
        this.mListInputMethod.setVisibility(8);
    L12:
        this.mLanguageOption = new LanguageOption(this._mActivity);
        this.mAutofillOption = new AutofillOption(this._mActivity);
        return this.mRootView;
    L5:
        this.mSwitchKeyBoard.setVisibility(8);
        findViewByIdNullable(R.id.id_security_keyboard_gap).setVisibility(8);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m482xc55fba5e(View r1) {
        onClick(this.mItemLanguage);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m483x8c6ba15f(View r1) {
        onClick(this.mItemSpellingCheckSetting);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m484x53778860(View r1) {
        onClick(this.mItemUserDictionary);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m485x1a836f61(View r1) {
        onClick(this.mItemDefaultInputmethod);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m486xe18f5662(View r1) {
        onClick(this.mAutoFillService);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        View r4 = this.mSwitchSpellingCheck.getCustomEndView();
        if ((r4 instanceof OSwitch) == false) goto L5;
        OSwitch r5 = (OSwitch) r4;
        this.mCbSpellingCheck = r5;
        r5.setOnCheckedChangeListener(this);
    L5:
        updateViews();
        if (SettingsFeature.isSupportSecurityKeyboard(this.mContext) == false) goto L13;
        this.mCbKeyBoardCheck.setOnCheckedChangeListener(this);
        OSwitch r6 = this.mCbKeyBoardCheck;
        boolean r1 = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), Constants.SAFE_KEYBOARD_SWITCH, 1) == 1) goto L11;
        r1 = false;
    L11:
        r6.setChecked(r1);
        return;
    }

    private boolean hasSpellCheckers() {
        PackageManager r0 = getPackageManager();
        SpellCheckerInfo[] r4 = this.mTsm.getEnabledSpellCheckers();
        if (r4 != null) goto L5;
        return false;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L13;
        if (TextUtils.isEmpty(r4[r2].loadLabel(r0)) == false) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    public void updateViews() {
        this.mSettingsObserver.resume();
        updateLanguageSubTitle();
        updateAutofillServiceSubTitleIfNeed();
        OAlertDialog r0 = this.mSecurityWarningDialog;
        if (r0 != null) goto L5;
    L6:
        updateInputmethodListAsync();
    L7:
        updateDefaultInputMethod();
        if (hasSpellCheckers() == false) goto L13;
        boolean r1 = this.mTsm.isSpellCheckerEnabled();
        this.mCbSpellingCheck.setChecked(r1);
        if (r1 == false) goto L12;
        this.mItemSpellingCheckSetting.setVisibility(0);
    L14:
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        updateAutofillServiceSubTitleIfNeed();
        return;
    L12:
        this.mItemSpellingCheckSetting.setVisibility(8);
        goto L14
    L13:
        this.mSwitchSpellingCheck.setVisibility(8);
        findViewByIdNullable(R.id.id_spelling_check_gap).setVisibility(8);
        this.mItemSpellingCheckSetting.setVisibility(8);
        goto L14
    L5:
        if (r0.isShowing() == true) goto L7;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateAutofillServiceSubTitleIfNeed() {
        this.mAutoFillService.setEndDetailText(AutofillPickerFragment.getCurrentAutofillServiceAppLabel(this.mContext));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSettingsObserver.pause();
    }

    private void updateLanguageSubTitle() {
        Resources r0 = getResources();
        Locale r1 = r0.getConfiguration().locale;
        int r2 = getResources().getIdentifier("special_locale_codes", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r3 = getResources().getIdentifier("special_locale_names", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r4 = r0.getStringArray(r2);
        String[] r5 = r0.getStringArray(r3);
        String r6 = r1.getLanguage();
        int r7 = 0;
        if ("zh".equalsIgnoreCase(r6) == true) goto L5;
        String[] r8 = Resources.getSystem().getAssets().getLocales();
        int r9 = 0;
        int r10 = 0;
    L12:
        if (r9 >= r8.length) goto L20;
        String r11 = r8[r9];
        if (r11.length() != 5) goto L18;
        if (r11.substring(0, 2).equals(r6) == false) goto L18;
        r10 = r10 + 1;
    L18:
        r9 = r9 + 1;
        goto L12
    L20:
        if (r10 <= 1) goto L22;
        this.mItemLanguage.setEndDetailText(r1.getDisplayName(r1));
        return;
    L22:
        this.mItemLanguage.setEndDetailText(r1.getDisplayLanguage(r1));
        return;
    L5:
        if (r7 >= r4.length) goto L32;
        if (r4[r7].equals(r1.toString()) == false) goto L9;
        this.mItemLanguage.setEndDetailText(r5[r7]);
    L9:
        r7 = r7 + 1;
        goto L5
    }

    private void updateDefaultInputMethod() {
        CharSequence r0 = this.mInputMethodSettingValues.getCurrentInputMethodName(this.mContext);
        if (TextUtils.isEmpty(r0) == true) goto L11;
        monitor-enter(this);
        this.mItemDefaultInputmethod.setEndDetailText(r0.toString());     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (this.mItemLanguage != r8) goto L10;
        ArrayList r9 = new ArrayList();
        final LanguageOption.LocaleInfo[] r0 = this.mLanguageOption.constructAdapter(this._mActivity);
        int r2 = 0;
    L6:
        if (r2 >= r0.length) goto L8;
        LanguageOption.LocaleInfo r3 = r0[r2];
        r9.add(new Item(r3.getLabel(), this.mLanguageOption.isCurrent(r3)));
        r2 = r2 + 1;
        goto L6
    L8:
        this.mLanguagePopover = OPopoverHelper.showPopoverList(this._mActivity, this.mItemLanguage, r9, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda2(this, r0), true);
        SettingsTracker.onItemClick(2001);
        return;
    L10:
        if (this.mItemSpellingCheckSetting != r8) goto L13;
        start(SpellCheckersSettingsFragment.class);
        return;
    L13:
        if (this.mItemUserDictionary != r8) goto L16;
        startActivity(new Intent(this._mActivity, UserDictionaryActivity.class).putExtra("back_text_id", this.mTitleStringResId));
        return;
    L16:
        if (this.mItemDefaultInputmethod != r8) goto L19;
        this.mImm.showInputMethodPicker();
        return;
    L19:
        if (r8 != this.mAutoFillService) goto L32;
        final List<AutofillOption.ServiceApp> r10 = this.mAutofillOption.fetchAutofillServices();
        ArrayList r1 = new ArrayList();
        Iterator<AutofillOption.ServiceApp> r4 = r10.iterator();
    L22:
        if (r4.hasNext() == false) goto L24;
        AutofillOption.ServiceApp r5 = r4.next();
        r1.add(new Item(r5.label, this.mAutofillOption.isCurrentService(r5)));
        goto L22
    L24:
        this.mAutoFillPopover = OPopoverHelper.showPopoverList(this._mActivity, this.mAutoFillService, r1, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda3(this, r10), true);
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$5$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m480x4e06f2f2(LanguageOption.LocaleInfo[] r1, View r2, int r3) {
        this.mLanguageOption.setLocale(r1[r3]);
        updateLanguageSubTitle();
        OPopover r0 = this.mLanguagePopover;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$6$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m481x1512d9f3(List r1, View r2, int r3) {
        AutofillOption.ServiceApp r4 = (AutofillOption.ServiceApp) r1.get(r3);
        OPopover r5 = this.mAutoFillPopover;
        if (r5 == null) goto L5;
        r5.dismiss();
    L5:
        showSelectAutofillServiceWarning(r4);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (this.mCbSpellingCheck != r2) goto L9;
        MultiSDKAdapter.setSpellCheckerEnabled(this.mContext, r3);
        if (r3 == false) goto L7;
        this.mItemSpellingCheckSetting.setVisibility(0);
        return;
    L7:
        this.mItemSpellingCheckSetting.setVisibility(8);
        return;
    L9:
        if (this.mCbKeyBoardCheck != r2) goto L14;
        Settings.Global.putInt(this.mContext.getContentResolver(), Constants.SAFE_KEYBOARD_SWITCH, r3 ? 1 : 0);
        return;
    }

    private void updateInputmethodList() {
        this.mListInputMethod.removeAllViews();
        this.mImeSubtypeHolderList.clear();
        List<InputMethodInfo> r0 = this.mImm.getInputMethodList();
        this.mImis = r0;
        int r1 = r0.size();
        ArrayList r2 = new ArrayList();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        InputMethodInfo r4 = this.mImis.get(r3);
        if ("com.sand.airdroid".equals(r4.getPackageName()) == true) goto L10;
        if (InputMethodUtils.isSystemIme(r4) == true) goto L10;
        r2.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        Collections.sort(r2, this.alphabetComparator);
        int r5 = 0;
    L12:
        if (r5 >= r1) goto L17;
        InputMethodInfo r6 = this.mImis.get(r5);
        if (InputMethodUtils.isSystemIme(r6) == false) goto L16;
        View r7 = prepareInputMethodInfoItemView(r6, false);
        r7.setTag(r6);
        this.mListInputMethod.addView(r7);
    L16:
        r5 = r5 + 1;
        goto L12
    L17:
        int r8 = 0;
    L19:
        if (r8 >= r2.size()) goto L21;
        InputMethodInfo r9 = (InputMethodInfo) r2.get(r8);
        View r10 = prepareInputMethodInfoItemView(r9, false);
        r10.setTag(r9);
        this.mListInputMethod.addView(r10);
        r8 = r8 + 1;
        goto L19
    L21:
        r2.clear();
        int r11 = this.mListInputMethod.getChildCount();
        int r12 = 0;
    L22:
        if (r12 >= r11) goto L24;
        this.mListInputMethod.getChildAt(r12);
        r12 = r12 + 1;
        goto L22
    L24:
        if (r11 <= 0) goto L46;
        View r13 = this.mListInputMethod.getChildAt(0);
        View r14 = this.mListInputMethod.getChildAt(r11 - 1);
        if (r14 != r13) goto L31;
        if ((r13 instanceof OCardListItem) == false) goto L31;
        ((OCardListItem) r13).setCardPosition(0);
        return;
    L31:
        if ((r13 instanceof OCardListItem) == false) goto L34;
        ((OCardListItem) r13).setCardPosition(1);
    L34:
        if ((r14 instanceof OCardListItem) == false) goto L48;
        ((OCardListItem) r14).setCardPosition(3);
        return;
    L48:
        return;
    }

    private void updateWorkInputmethodList() {
        UserHandle r0 = Utils.getManagedProfile(this.mUm);
        this.mWorkInputmethodApps.setVisibility(8);
        this.mWorkInputmethodTitle.setVisibility(8);
        if (r0 != null) goto L5;
        return;
    L5:
        this.mWorkInputmethodApps.setVisibility(0);
        this.mWorkInputmethodTitle.setVisibility(0);
        this.mWorkInputmethodApps.removeAllViews();
        this.mWorkImeSubtypeHolderList.clear();
        List<InputMethodInfo> r1 = this.mImm.getInputMethodListAsUser(r0.getIdentifier());
        this.mWorkImis = r1;
        int r2 = r1.size();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        InputMethodInfo r5 = this.mWorkImis.get(r4);
        if ("com.sand.airdroid".equals(r5.getPackageName()) == true) goto L13;
        if (InputMethodUtils.isSystemIme(r5) == true) goto L13;
        r3.add(r5);
    L13:
        r4 = r4 + 1;
        goto L6
    L14:
        Collections.sort(r3, this.alphabetComparator);
        int r6 = 0;
    L16:
        if (r6 >= r2) goto L21;
        InputMethodInfo r7 = this.mWorkImis.get(r6);
        if (InputMethodUtils.isSystemIme(r7) == false) goto L20;
        View r8 = prepareInputMethodInfoItemView(r7, true);
        r8.setTag(r7);
        this.mWorkInputmethodApps.addView(r8);
    L20:
        r6 = r6 + 1;
        goto L16
    L21:
        int r9 = 0;
    L23:
        if (r9 >= r3.size()) goto L25;
        InputMethodInfo r10 = (InputMethodInfo) r3.get(r9);
        View r11 = prepareInputMethodInfoItemView(r10, true);
        r11.setTag(r10);
        this.mWorkInputmethodApps.addView(r11);
        r9 = r9 + 1;
        goto L23
    L25:
        r3.clear();
        int r12 = this.mWorkInputmethodApps.getChildCount();
        int r13 = 0;
    L26:
        if (r13 >= r12) goto L28;
        this.mWorkInputmethodApps.getChildAt(r13);
        r13 = r13 + 1;
        goto L26
    L28:
        if (r12 <= 0) goto L50;
        View r14 = this.mWorkInputmethodApps.getChildAt(0);
        View r15 = this.mWorkInputmethodApps.getChildAt(r12 - 1);
        if (r15 != r14) goto L35;
        if ((r14 instanceof OCardListItem) == false) goto L35;
        ((OCardListItem) r14).setCardPosition(0);
        return;
    L35:
        if ((r14 instanceof OCardListItem) == false) goto L38;
        ((OCardListItem) r14).setCardPosition(1);
    L38:
        if ((r15 instanceof OCardListItem) == false) goto L52;
        ((OCardListItem) r15).setCardPosition(3);
        return;
    L52:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.inputmethod.InputMethodAndLanguageSettingsFragment$2] */
    private void updateInputmethodListAsync() {
        Void r3 = (Void) null;
        new AnonymousClass2(this).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[]{null});
    }

    private View prepareInputMethodInfoItemView(final InputMethodInfo r20, boolean r21) {
        if (r21 == false) goto L5;
        HashMap<String, InputMethodInfoDetail> r0 = this.mWorkImDetailsMap;
    L6:
        InputMethodInfoDetail r1 = r0.get(r20.getId());
        if (r1 != null) goto L9;
        r1 = new InputMethodInfoDetail(this, r20);
    L9:
        InputMethodInfoDetail r11 = r1;
        final InputMethodAndSubtypeUtil.ImeSubtypeHolder r2 = new InputMethodAndSubtypeUtil.ImeSubtypeHolder();
        r2.checked = r11.check;
        r2.imi = r20;
        if (r21 == false) goto L12;
        this.mWorkImeSubtypeHolderList.add(r2);
    L13:
        OCardListItem r12 = new OCardListItem(this.mContext);
        r12.setCardPosition(2);
        r12.setTitle(r11.title.toString());
        String r3 = r11.subTitle;
        if (TextUtils.isEmpty(r11.subTitle) == true) goto L16;
        r3 = r3.replace(" (", "（").replace(")", "）");
    L16:
        r12.showSubTitle(true);
        r12.setSubTitle(r3);
        r12.showTailIcon(false);
        r12.setCustomEndView(R.layout.layout_input_switch_card);
        View r4 = r12.getCustomEndView();
        r12.showCustomEnd(true);
        final OSwitch r15 = (OSwitch) r4.findViewById(R.id.custom_end_switch);
        String r8 = r20.getSettingsActivity();
        boolean r16 = TextUtils.isEmpty(r8);
        final UserHandle r7 = UserHandle.getUserHandleForUid(r20.getServiceInfo().applicationInfo.uid);
        final boolean r5 = InputMethodUtils.isSystemIme(r20);
        final RestrictedLockUtils.EnforcedAdmin r6 = MultiSDKAdapterNew.checkIfInputMethodDisallowed(this.mContext, r20.getPackageName(), r7.getIdentifier());
        final boolean r9 = r11.isAllowedByOrganization;
        if (r11.alwaysChecked == false) goto L19;
        r15.setEnabled(false);
        r15.setChecked(true);
        r12.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda4());
    L21:
        r15.setChecked(r11.check);
        if (r15.isEnabled() == false) goto L26;
        r15.setOnCheckedChangeListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda6(this, r2, r9, r6, r5, r7, r20, r15));
    L26:
        if (r11.isAllowedByOrganization == false) goto L31;
        if (r16 == false) goto L30;
        r12.showTailIcon(false);
        goto L31
    L30:
        r12.showTailIcon(true);
        final Intent r10 = new Intent("android.intent.action.MAIN");
        r10.setClassName(r20.getPackageName(), r8);
        r10.addFlags(268435456);
        r12.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda7(this, r10, r7, r20));
    L31:
        return r12;
    L19:
        if (r9 == true) goto L21;
        r12.setSubTitle(getString(R.string.disabled_by_administrator_summary));
        r12.showSubTitle(true);
        r12.setOnContentClickListener(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda5(this, r6));
        goto L21
    L12:
        this.mImeSubtypeHolderList.add(r2);
        goto L13
    L5:
        r0 = this.mImDetailsMap;
        goto L6
    }

    static /* synthetic */ void lambda$prepareInputMethodInfoItemView$7(View r1) {
        OLog.d("InputMethodAndLanguage", " click a disabled item , ignore..");
    }

    /* JADX INFO: renamed from: lambda$prepareInputMethodInfoItemView$8$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m488xf8e2ceb0(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r1);
    }

    /* JADX INFO: renamed from: lambda$prepareInputMethodInfoItemView$9$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m489xbfeeb5b1(InputMethodAndSubtypeUtil.ImeSubtypeHolder r1, boolean r2, RestrictedLockUtils.EnforcedAdmin r3, boolean r4, UserHandle r5, InputMethodInfo r6, OSwitch r7, CompoundButton r8, boolean r9) {
        r1.checked = r9;
        if (r2 == true) goto L6;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r3);
        r8.setOnCheckedChangeListener(null);
        r8.setChecked(false);
        r8.setOnCheckedChangeListener(this);
        return;
    L6:
        if (r9 == false) goto L10;
        if (r4 == false) goto L9;
        saveImeSettings(r5);
        return;
    L9:
        showSecurityWarnDialog(r6, r7);
        return;
    L10:
        saveImeSettings(r5);
    }

    /* JADX INFO: renamed from: lambda$prepareInputMethodInfoItemView$10$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m487x2fac3bb1(Intent r1, UserHandle r2, InputMethodInfo r3, View r4) {
        FragmentActivity r5 = getActivity();     // Catch: ActivityNotFoundException -> L7
        if (r5 == null) goto L5;
        r5.startActivityAsUser(r1, r2);     // Catch: ActivityNotFoundException -> L7
    L10:
        return;
    L5:
        r1.addFlags(268435456);     // Catch: ActivityNotFoundException -> L7
        this.mContext.startActivityAsUser(r1, r2);     // Catch: ActivityNotFoundException -> L7
    L7:
        e = move-exception;
        OLog.d("", "IME's Settings Activity Not Found", e);
        Context r0 = this.mContext;
        ToastUtils.show(r0, r0.getString(R.string.failed_to_open_app_settings_toast, new Object[]{r3.loadLabel(r0.getPackageManager())}));
    }

    public String getSummaryString(InputMethodInfo r7) {
        StringBuilder r0 = new StringBuilder();
        Iterator<InputMethodSubtype> r1 = this.mImm.getEnabledInputMethodSubtypeList(r7, true).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        InputMethodSubtype r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append(", ");
    L8:
        r0.append(r2.getDisplayName(this.mContext, r7.getPackageName(), r7.getServiceInfo().applicationInfo));
        goto L4
    L10:
        return r0.toString();
    }

    private void saveImeSettings(UserHandle r6) {
        boolean r1 = true;
        if (this.mUm.isManagedProfile(r6.getIdentifier()) == false) goto L9;
        Context r7 = this.mContext.createContextAsUser(r6, 0);
        List<InputMethodAndSubtypeUtil.ImeSubtypeHolder> r0 = this.mWorkImeSubtypeHolderList;
        ContentResolver r4 = r7.getContentResolver();
        if (getResources().getConfiguration().keyboard == 2) goto L8;
        r1 = false;
    L8:
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList(r7, r0, r4, r1);
        return;
    L9:
        Context r8 = this.mContext;
        List<InputMethodAndSubtypeUtil.ImeSubtypeHolder> r2 = this.mImeSubtypeHolderList;
        ContentResolver r5 = getContentResolver();
        if (getResources().getConfiguration().keyboard == 2) goto L13;
        r1 = false;
    L13:
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList(r8, r2, r5, r1);
    }

    private void showSecurityWarnDialog(InputMethodInfo r9, final OSwitch r10) {
        final UserHandle r0 = UserHandle.getUserHandleForUid(r9.getServiceInfo().applicationInfo.uid);
        String r1 = r9.loadLabel(this.mPackageManager).toString();
        int r2 = getResources().getDimensionPixelSize(R.dimen.ime_icon_size);
        OAlertDialog r11 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).autoDismiss(false).horizontalButton(true).title(getString(R.string.ime_attention_title, new Object[]{r1}), false).message(getString(R.string.ime_attention_content, new Object[]{r1})).icon(r9.loadIcon(this.mPackageManager)).imageSize(r2, r2).negativeButton(android.R.string.cancel, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda15(this, r10)).positiveButton(R.string.use_the_ime, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda16(this, r0, r10)).onCancel(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda1(this, r10)).createDialog();
        this.mSecurityWarningDialog = r11;
        r11.show();
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$11$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m490x2aa7b171(OSwitch r1, DialogInterface r2, int r3) {
        r1.setChecked(false);
        this.mSecurityWarningDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$12$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m491xf1b39872(UserHandle r1, OSwitch r2, DialogInterface r3, int r4) {
        saveImeSettings(r1);
        r2.setChecked(true);
        this.mSecurityWarningDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$13$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m492xb8bf7f73(OSwitch r1, DialogInterface r2) {
        r1.setChecked(false);
        this.mSecurityWarningDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackLanguageAndImSettings(this.mContext);
        super.onDestroy();
    }

    private Drawable convertToRoundCorner(Drawable r6) {
        Bitmap r0 = null;
    L8:
        e = move-exception;
        OLog.e(TAG, "convertToRoundCorner error: " + e.getMessage());
    L10:
        if (r0 != null) goto L12;
        return r6;
    L12:
        RoundedBitmapDrawable r5 = RoundedBitmapDrawableFactory.create(getResources(), r0);
        r5.setCornerRadius(r6.getIntrinsicWidth() / 2.0f);
        return r5;
    L4:
        if ((r6 instanceof BitmapDrawable) == false) goto L6;
        r0 = ((BitmapDrawable) r6).getBitmap();     // Catch: Exception -> L8
    L14:
        goto L10
    L6:
        r0 = Bitmap.createBitmap(Math.max(r6.getIntrinsicWidth(), 1), Math.max(r6.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L8
        Canvas r1 = new Canvas(r0);     // Catch: Exception -> L8
        r6.setBounds(0, 0, r1.getWidth(), r1.getHeight());     // Catch: Exception -> L8
        r6.draw(r1);     // Catch: Exception -> L8
        goto L14
    }

    private void showSelectAutofillServiceWarning(final AutofillOption.ServiceApp r5) {
        if (r5.componentName != null) goto L5;
    L7:
        this.mAutofillOption.setAutofillService(r5);
        updateAutofillServiceSubTitleIfNeed();
        return;
    L5:
        if (this.mAutofillOption.isCurrentService(r5) == true) goto L7;
        ((OAlertDialog) new OAlertDialogBuilder(this._mActivity).autoDismiss(false).horizontalButton(true).title(R.string.warning).message(getString(R.string.autofill_confirm_msg, new Object[]{r5.label})).negativeButton(R.string.cancel, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda0()).positiveButton(R.string.okay, new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda8(this, r5)).onCancel(new InputMethodAndLanguageSettingsFragment$$ExternalSyntheticLambda9()).createDialog()).show();
    }

    static /* synthetic */ void lambda$showSelectAutofillServiceWarning$14(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showSelectAutofillServiceWarning$15$com-android-settings-inputmethod-InputMethodAndLanguageSettingsFragment, reason: not valid java name */
    /* synthetic */ void m493x383786ce(AutofillOption.ServiceApp r1, DialogInterface r2, int r3) {
        this.mAutofillOption.setAutofillService(r1);
        r2.dismiss();
        updateAutofillServiceSubTitleIfNeed();
    }

    static /* synthetic */ void lambda$showSelectAutofillServiceWarning$16(DialogInterface r0) {
        r0.dismiss();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InputMethodAndLanguageSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InputMethodAndLanguageSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InputMethodAndLanguageSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndLanguageSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
