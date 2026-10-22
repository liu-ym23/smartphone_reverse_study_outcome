package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SearchVoiceFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String DEFAULT_SELECT_LANGUAGE = "domain=iat,language=zh_cn,accent=mandarin";
    private SettingItemSwitch mApplicationSuggestions;
    private SettingItemSwitch mContactVoiceButton;
    private View mContactVoiceSettings;
    private SettingItemText mFuzzyToneSettingItem;
    private OListItemSettings mGlobalSearchItem;
    private TextView mGlobalSuggestionsTips;
    private SettingItemText mImageSearch;
    private SettingItemText mItemSearch;
    private SettingItemSwitch mItemVoiceSearch;
    private View mMenuSettingsContainer;
    private SettingItemSwitch mPopularInformation;
    private SettingItemText mRecognizeLangItem;
    private OListItemSettings mSearchMenu;
    private TextView mSettingTitle;
    private SettingItemSwitch mTriggerViaSlideUpLauncher;
    private View mVoiceSearchHeader;

    public void com_android_settings_SearchVoiceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_SearchVoiceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SearchVoiceFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        this.mRootView = r6.inflate(R.layout.voice_search_settings_layout, r7, false);
        SettingItemText r9 = (SettingItemText) NullSafe.nonNull((SettingItemText) findViewByIdNullable(R.id.allowed_search));
        this.mItemSearch = r9;
        r9.setOnClickListener(this);
        this.mVoiceSearchHeader = NullSafe.nonNull(findViewByIdNullable(R.id.id_header_voice_search));
        this.mMenuSettingsContainer = NullSafe.nonNull(findViewByIdNullable(R.id.menu_settings_container));
        this.mTriggerViaSlideUpLauncher = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.id_slide_up_launcher));
        this.mItemVoiceSearch = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.menu));
        this.mContactVoiceButton = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.contact_voice_button));
        this.mContactVoiceSettings = NullSafe.nonNull(findViewByIdNullable(R.id.contact_voice_settings));
        if (Utils.isCtaTestModeOn() == false) goto L5;
        this.mContactVoiceSettings.setVisibility(8);
    L5:
        this.mApplicationSuggestions = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.switch_application_suggestions));
        this.mPopularInformation = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.switch_popular_information));
        this.mGlobalSuggestionsTips = (TextView) NullSafe.nonNull((TextView) findViewByIdNullable(R.id.global_suggestions_tips));
        if (this.mIsExtDisplaying == false) goto L8;
        this.mApplicationSuggestions.setVisibility(8);
        this.mPopularInformation.setVisibility(8);
        this.mGlobalSuggestionsTips.setVisibility(8);
    L8:
        this.mFuzzyToneSettingItem = (SettingItemText) NullSafe.nonNull((SettingItemText) findViewByIdNullable(R.id.pinyin_fuzzy_tone_search_item));
        View r10 = NullSafe.nonNull(findViewByIdNullable(R.id.fuzzy_tone_tips_view));
        View r11 = NullSafe.nonNull(findViewByIdNullable(R.id.id_searchable_item_gap));
        OListItemSettings r1 = (OListItemSettings) findViewByIdNullable(R.id.search_menu);
        this.mSearchMenu = r1;
        if (r1 == null) goto L11;
        r1.setOnClickListener(this);
    L11:
        this.mSettingTitle = (TextView) NullSafe.nonNull((TextView) findViewByIdNullable(R.id.search_setting_title));
        PackageInfo r2 = getPackageManager().getPackageInfo("com.obric.quicksearch", 0);     // Catch: PackageManager.NameNotFoundException -> L18
        if (r2 == null) goto L21;
        if (r2.versionCode >= 38) goto L21;
        this.mSearchMenu.setVisibility(8);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mSettingTitle.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mItemSearch.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mFuzzyToneSettingItem.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        r10.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mApplicationSuggestions.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mPopularInformation.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mGlobalSuggestionsTips.setVisibility(0);     // Catch: PackageManager.NameNotFoundException -> L18
        r11.setVisibility(8);     // Catch: PackageManager.NameNotFoundException -> L18
    L21:
        if (Utils.isChineseLocale() == false) goto L23;
        this.mFuzzyToneSettingItem.setOnClickListener(this);
        this.mItemSearch.setBackgroundStyle(2);
    L25:
        if (SettingsFeature.hasMenuAndBackKeys() == true) goto L27;
        this.mMenuSettingsContainer.setVisibility(8);
    L27:
        SettingItemText r12 = (SettingItemText) findViewByIdNullable(R.id.id_recognize_lang);
        this.mRecognizeLangItem = r12;
        r12.setTitle(Utils.getPackageString(this.mContext, "com.bytedanceos.sara", "recognition_language"));
        this.mRecognizeLangItem.setOnClickListener(this);
        TextView r13 = (TextView) findViewByIdNullable(R.id.recognition_language_tip);
        String r14 = Utils.getPackageString(this.mContext, "com.bytedanceos.sara", "recognition_language_tip");
        SpannableStringBuilder r0 = new SpannableStringBuilder(r14);
        Matcher r15 = Pattern.compile("/iflytek/").matcher(r14);
    L29:
        if (r15.find() == false) goto L31;
        r0.setSpan(new ImageSpanAlignCenter(this.mContext, R.drawable.bubble_ifly), r15.start(), r15.end(), 33);
        goto L29
    L31:
        r13.setText(r0);
        ImageView r16 = (ImageView) findViewByIdNullable(R.id.iv_slide_up_launcher_intro);
        if (Utils.getCurrentLauncherMode(this.mContext) != 20) goto L34;
        r16.setImageResource(R.drawable.slide_up_launcher_intro_20);
    L35:
        OListItemSettings r17 = (OListItemSettings) findViewByIdNullable(R.id.id_global_search);
        this.mGlobalSearchItem = r17;
        r17.setOnClickListener(this);
        this.mGlobalSearchItem.setVisibility(8);
        SettingItemText r18 = (SettingItemText) findViewByIdNullable(R.id.id_image_search);
        this.mImageSearch = r18;
        r18.setOnClickListener(this);
        this.mImageSearch.setTitle(Utils.getPackageString(this.mContext, "com.android.browser", Constants.STRING_IMAGE_SEARCH));
        return this.mRootView;
    L34:
        r16.setImageResource(R.drawable.slide_up_launcher_intro);
        goto L35
    L23:
        this.mFuzzyToneSettingItem.setVisibility(8);
        r10.setVisibility(8);
        r11.setVisibility(0);
        this.mItemSearch.setBackgroundStyle(1);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mTriggerViaSlideUpLauncher.setOnCheckedChangeListener(this);
        this.mItemVoiceSearch.setOnCheckedChangeListener(this);
        this.mContactVoiceButton.setOnCheckedChangeListener(this);
        this.mApplicationSuggestions.setOnCheckedChangeListener(this);
        this.mPopularInformation.setOnCheckedChangeListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        Intent r0 = new Intent();
        r0.putExtra("back_text", getString(R.string.search_voice_title));
        if (this.mItemSearch != r6) goto L10;
        r0.setClassName("com.obric.quicksearch", "com.android.quicksearchbox.preferences.SearchBytedanceSettingsActivity");     // Catch: Exception -> L6
        r0.setAction("android.intent.action.MAIN");     // Catch: Exception -> L6
        r0.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);     // Catch: Exception -> L6
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L6
    L8:
        SettingsTracker.onItemClick(2501);
    L27:
        updateCheckState();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.mFuzzyToneSettingItem != r6) goto L16;
        r0.setClassName("com.obric.quicksearch", "com.android.quicksearchbox.preferences.FuzzyToneSettingsActivity");     // Catch: Exception -> L13
        r0.setAction("android.intent.action.MAIN");     // Catch: Exception -> L13
        r0.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);     // Catch: Exception -> L13
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L27
    L16:
        if (this.mRecognizeLangItem != r6) goto L19;
        r0.setClassName("com.bytedanceos.sara", "com.bytedanceos.sara.bubble.IflyLanguageChooserActivity");
        Utils.startActivity(this._mActivity, r0);
        goto L27
    L19:
        if (this.mSearchMenu != r6) goto L22;
        r0.setClassName("com.obric.quicksearch", "com.android.quicksearchbox.preferences.SearchSettingsActivity");
        Utils.startActivity(this._mActivity, r0);
        goto L27
    L22:
        if (this.mGlobalSearchItem != r6) goto L25;
        start(GlobalSearchCategoryFragment.class);
        goto L27
    L25:
        if (this.mImageSearch != r6) goto L27;
        r0.setClassName("com.android.browser", Constants.ACTIVITY_IMAGESEARCH);
        Utils.startActivity(this._mActivity, r0);
        goto L27
    }

    public void updateViews() {
        boolean r3 = false;
        if (SettingsFeature.SLIDE_UP_SETTING == false) goto L13;
        View r0 = findViewByIdNullable(R.id.id_slide_up_settings);
        if (this.mIsExtDisplaying == false) goto L7;
    L10:
        int r5 = 8;
    L11:
        r0.setVisibility(r5);
        findViewByIdNullable(R.id.id_voice_top_shadow).setVisibility(0);
        goto L13
    L7:
        if (Utils.isThirdPartHome(this.mContext) == true) goto L10;
        r5 = 0;
    L13:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "trigger_search_via_slide_up", 1) != 1) goto L15;
        r3 = true;
    L15:
        this.mTriggerViaSlideUpLauncher.setChecked(r3);
        this.mItemVoiceSearch.setChecked(getVoiceByMenuEnabled());
        updateCheckState();
        this.mRecognizeLangItem.setSubTitle(getLangSubtitle(this.mContext));
        if (Utils.hasTelephonyFeature(this.mContext) == true) goto L19;
        this.mContactVoiceSettings.setVisibility(8);
    L19:
        if (Utils.isOnlySupportTnt() == false) goto L21;
        findViewByIdNullable(R.id.search_setting_title).setVisibility(8);
        this.mItemSearch.setVisibility(8);
        this.mFuzzyToneSettingItem.setVisibility(8);
        findViewByIdNullable(R.id.fuzzy_tone_tips_view).setVisibility(8);
        findViewByIdNullable(R.id.id_slide_up_settings).setVisibility(8);
        findViewByIdNullable(R.id.id_voice_top_shadow).setVisibility(8);
    L21:
        this.mApplicationSuggestions.setChecked(getApplicationSuggestionsEnabled());
        this.mPopularInformation.setChecked(getPopularInformationEnabled());
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateCheckState() {
        if (Utils.isCtaTestModeOn() == true) goto L6;
        this.mContactVoiceButton.setChecked(getBtnInContactsEnabled());
        Utils.isChineseLocale();
        this.mContactVoiceSettings.setVisibility(8);
        return;
    }

    public void setVoiceByMenuEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "voice_assit_by_menu", r2 ? 1 : 0);
    }

    private boolean getVoiceByMenuEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_assit_by_menu", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void setBtnInContactsEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_voice_search_btn_enabled", r2 ? 1 : 0);
    }

    private boolean getBtnInContactsEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_voice_search_btn_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mContactVoiceButton.getSwitch()) goto L6;
        setBtnInContactsEnabled(r3);
        return;
    L6:
        if (r2 != this.mItemVoiceSearch.getSwitch()) goto L9;
        setVoiceByMenuEnabled(r3);
        return;
    L9:
        if (r2 != this.mTriggerViaSlideUpLauncher.getSwitch()) goto L12;
        android.provider.Settings.Global.putInt(getContentResolver(), "trigger_search_via_slide_up", r3 ? 1 : 0);
        return;
    L12:
        if (r2 != this.mApplicationSuggestions.getSwitch()) goto L15;
        setApplicationSuggestionsEnabled(r3);
        return;
    L15:
        if (r2 != this.mPopularInformation.getSwitch()) goto L22;
        setPopularInformationEnabled(r3);
        return;
    }

    public static String getLangSubtitle(Context r6) {
        String r0 = getSelectedLanguage(r6);
        String[] r1 = Utils.getOutsideAppArray(r6, "com.bytedanceos.sara", "ilfy_language_entry");
        String[] r7 = Utils.getOutsideAppArray(r6, "com.bytedanceos.sara", "ilfy_language_value");
        if (r1 == null) goto L20;
        if (r7 == null) goto L22;
        int r4 = 0;
    L8:
        if (r4 >= r7.length) goto L15;
        if (r0.equals(r7[r4]) == true) goto L12;
        r4 = r4 + 1;
        goto L8
    L12:
        return r1[r4];
    L15:
        if (r1.length > 0) goto L17;
        return "";
    L17:
        return r1[0];
    L22:
        return "";
    L20:
        return "";
    }

    public static String getSelectedLanguage(Context r1) {
        String r2 = android.provider.Settings.Global.getString(r1.getContentResolver(), "voice_language");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return DEFAULT_SELECT_LANGUAGE;
    L6:
        return r2;
    }

    private boolean getApplicationSuggestionsEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "search_application_suggestions", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean getPopularInformationEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "search_popular_information", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setApplicationSuggestionsEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "search_application_suggestions", r2 ? 1 : 0);
    }

    public void setPopularInformationEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "search_popular_information", r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SearchVoiceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SearchVoiceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SearchVoiceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SearchVoiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SearchVoiceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SearchVoiceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
