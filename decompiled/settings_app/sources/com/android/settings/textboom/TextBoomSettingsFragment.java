package com.android.settings.textboom;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.TextView;
import bytedanceos.util.DeviceType;
import com.android.internal.content.PackageMonitor;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.BigbangGifAnimView;
import com.android.settings.widget.SettingItemImage;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class TextBoomSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int DIALOG_ID_HOT_WORD_CARD = 5;
    private static final int DIALOG_ID_INSTALL_BIGBANG = 4;
    private static final int DIALOG_ID_INSTALL_SCANNER_APP = 2;
    private static final int DIALOG_ID_MEMORY_WARNING = 3;
    private static final int DIALOG_ID_PLAY_VIDEO = 1;
    private static final int DIALOG_ID_V2_BETA = 6;
    public static final String EXTRA_BACK_BTN_RES_NAME = "back_text_res_name";
    public static final String EXTRA_INFO_TYPE = "extra_info_type";
    public static final int INFO_TYPE_PRIVACY_POLICY = 2;
    public static final int INFO_TYPE_USER_LICENSE = 1;
    private static final int REQUEST_CODE_PLAY_VIDEO = 10;
    private BigbangGifAnimView mBigbangGifAnimView;
    private View mGifContainerView;
    private boolean mIsBigBangEnabled;
    private boolean mIsViewStubInflated;
    private SettingItemText mOCRApplistItem;
    private SettingItemText mOCRDetailSetting;
    private SettingItemSwitch mOCRGameSwitch;
    private SettingItemSwitch mOCRSwitch;
    private PackageMonitor mPackageReceiver;
    private View mPreloadGifView;
    private View mSubSettingsContainer;
    private SettingItemSwitch mTextBoomSwitch;
    private SettingItemText mTextBoomTriggerAreaOption;
    private SettingItemImage mVideoIntroImage;
    private AlertDialog mWarningDialog;

    private class LegalStatementClickableSpan extends ClickableSpan {
        final /* synthetic */ TextBoomSettingsFragment this$0;

        private LegalStatementClickableSpan(TextBoomSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LegalStatementClickableSpan(TextBoomSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.this$0.getResources().getColor(R.color.legal_privacy_light_color));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r1) {
            TextBoomSettingsFragment.access$1500(this.this$0, 1);
        }
    }

    private class PrivacyPolicyClickableSpans extends ClickableSpan {
        final /* synthetic */ TextBoomSettingsFragment this$0;

        private PrivacyPolicyClickableSpans(TextBoomSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PrivacyPolicyClickableSpans(TextBoomSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.this$0.getResources().getColor(R.color.legal_privacy_light_color));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r1) {
            TextBoomSettingsFragment.access$1500(this.this$0, 2);
        }
    }

    public void com_android_settings_textboom_TextBoomSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TextBoomSettingsFragment() {
        this.mPackageReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(TextBoomSettingsFragment r0) {
        r0.updateViews();
    }

    static /* synthetic */ AlertDialog access$100(TextBoomSettingsFragment r0) {
        return r0.mWarningDialog;
    }

    static /* synthetic */ void access$1000(TextBoomSettingsFragment r0) {
        r0.showVideoDialogIfNeeded();
    }

    static /* synthetic */ AlertDialog access$102(TextBoomSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ SettingItemSwitch access$1100(TextBoomSettingsFragment r0) {
        return r0.mOCRSwitch;
    }

    static /* synthetic */ SettingItemText access$1200(TextBoomSettingsFragment r0) {
        return r0.mOCRDetailSetting;
    }

    static /* synthetic */ SettingItemText access$1300(TextBoomSettingsFragment r0) {
        return r0.mOCRApplistItem;
    }

    static /* synthetic */ SettingItemSwitch access$1400(TextBoomSettingsFragment r0) {
        return r0.mOCRGameSwitch;
    }

    static /* synthetic */ void access$1500(TextBoomSettingsFragment r0, int r1) {
        r0.startPrivacyActivity(r1);
    }

    static /* synthetic */ void access$200(TextBoomSettingsFragment r0, int r1) {
        r0.showWarningDialog(r1);
    }

    static /* synthetic */ SettingItemSwitch access$300(TextBoomSettingsFragment r0) {
        return r0.mTextBoomSwitch;
    }

    static /* synthetic */ void access$600(TextBoomSettingsFragment r0, boolean r1) {
        r0.enableBigBang(r1);
    }

    static /* synthetic */ void access$700(TextBoomSettingsFragment r0) {
        r0.playTutorialVideo();
    }

    static /* synthetic */ void access$800(TextBoomSettingsFragment r0, String r1) {
        r0.launchAppStoreForPackage(r1);
    }

    static /* synthetic */ void access$900(TextBoomSettingsFragment r0) {
        r0.saveMemoryWarnedIfNeed();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.bigbang_settings_layout, r3, false);
        this.mTitleResId = Integer.valueOf(R.string.text_boom_settings);
        initViews();
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateBigbangGifView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void initViews() {
        this.mSubSettingsContainer = NullSafe.nonNull(findViewByIdNullable(R.id.sub_settings_container));
        this.mGifContainerView = NullSafe.nonNull(findViewByIdNullable(R.id.gif_container));
        this.mPreloadGifView = NullSafe.nonNull(findViewByIdNullable(R.id.preload_gif_img));
        SettingItemImage r0 = (SettingItemImage) NullSafe.nonNull(findViewByIdNullable(R.id.video_intro));
        this.mVideoIntroImage = r0;
        r0.setOnClickListener(this);
        SettingItemSwitch r1 = (SettingItemSwitch) findViewByIdNullable(R.id.text_boom_switch);
        this.mTextBoomSwitch = r1;
        r1.setOnCheckedChangeListener(this);
        this.mTextBoomSwitch.setSwitcherCallback(new AnonymousClass2(this));
        SettingItemSwitch r2 = (SettingItemSwitch) findViewByIdNullable(R.id.ocr_switch);
        this.mOCRSwitch = r2;
        r2.setOnCheckedChangeListener(this);
        this.mOCRSwitch.setSwitcherCallback(new AnonymousClass3(this));
        SettingItemSwitch r3 = (SettingItemSwitch) NullSafe.nonNull((SettingItemSwitch) findViewByIdNullable(R.id.ocr_game_switch));
        this.mOCRGameSwitch = r3;
        r3.setOnCheckedChangeListener(this);
        SettingItemText r4 = (SettingItemText) NullSafe.nonNull((SettingItemText) findViewByIdNullable(R.id.id_ocr_detail));
        this.mOCRDetailSetting = r4;
        r4.setOnClickListener(this);
        SettingItemText r5 = (SettingItemText) NullSafe.nonNull((SettingItemText) findViewByIdNullable(R.id.ocr_app_sublist));
        this.mOCRApplistItem = r5;
        r5.setOnClickListener(this);
        SettingItemText r6 = (SettingItemText) NullSafe.nonNull((SettingItemText) findViewByIdNullable(R.id.textboom_trigger_area_options));
        this.mTextBoomTriggerAreaOption = r6;
        r6.setOnClickListener(this);
        TextView r7 = (TextView) NullSafe.nonNull((TextView) findViewByIdNullable(R.id.id_audio_tips1));
        r7.setText(getPrivacyAndLegalSpan(R.string.ocr_audio_privacy_tips));
        r7.setHighlightColor(getResources().getColor(android.R.color.transparent));
        r7.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private SpannableString getPrivacyAndLegalSpan(int r8) {
        String r9 = getString(r8);
        String r0 = getString(R.string.legal_tips);
        String r1 = getString(R.string.privacy_tips);
        SpannableString r2 = new SpannableString(r9);
        int r3 = r9.toLowerCase().indexOf(r0.toLowerCase());
        int r10 = r9.toLowerCase().indexOf(r1.toLowerCase());
        if (r3 == (-1)) goto L6;
        if (r10 == (-1)) goto L6;
        int r4 = r0.length() + r3;
        int r5 = r1.length() + r10;
        AnonymousClass1 r6 = null;
        r2.setSpan(new LegalStatementClickableSpan(this, r6), r3, r4, 33);
        r2.setSpan(new PrivacyPolicyClickableSpans(this, r6), r10, r5, 33);
    L6:
        return r2;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_textboom_TextBoomSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mPackageReceiver.register(this.mContext, Looper.getMainLooper(), true);
    }

    private void updateViews() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        boolean r0 = Utils.isPackageInstalled(this.mContext, Constants.PKG_BIG_BANG);
        if (r0 == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        this.mIsBigBangEnabled = r3;
        if (Settings.Global.getInt(getContentResolver(), "big_bang_disable_ocr_in_game", 1) != 1) goto L14;
        boolean r4 = true;
    L16:
        if (Settings.Global.getInt(getContentResolver(), "big_bang_ocr", 0) != 1) goto L18;
        boolean r5 = true;
    L19:
        this.mTextBoomSwitch.setChecked(this.mIsBigBangEnabled);
        this.mTextBoomSwitch.setEnabled(r0);
        this.mOCRSwitch.setChecked(r5);
        SettingItemSwitch r1 = this.mOCRSwitch;
        if (this.mIsBigBangEnabled == true) goto L22;
    L24:
        boolean r6 = false;
    L25:
        r1.setEnabled(r6);
        this.mTextBoomTriggerAreaOption.setSubTitle(getTextBoomTriggerAreaSubtitle());
        this.mTextBoomTriggerAreaOption.setEnabled(this.mIsBigBangEnabled);
        SettingItemText r2 = this.mOCRDetailSetting;
        if (this.mOCRSwitch.isChecked() == true) goto L28;
    L30:
        boolean r7 = false;
    L31:
        r2.setEnabled(r7);
        this.mOCRGameSwitch.setChecked(r4);
        SettingItemSwitch r8 = this.mOCRGameSwitch;
        if (this.mOCRSwitch.isChecked() == true) goto L34;
    L36:
        boolean r9 = false;
    L37:
        r8.setEnabled(r9);
        SettingItemText r10 = this.mOCRApplistItem;
        if (this.mOCRSwitch.isChecked() == true) goto L40;
    L42:
        boolean r11 = false;
    L43:
        r10.setEnabled(r11);
        if (this.mIsBigBangEnabled == false) goto L46;
        this.mTextBoomSwitch.setBackgroundStyle(2);
        this.mSubSettingsContainer.setVisibility(0);
        this.mGifContainerView.setVisibility(0);
    L47:
        updateBigbangGifView();
        return;
    L46:
        this.mTextBoomSwitch.setBackgroundStyle(1);
        this.mSubSettingsContainer.setVisibility(8);
        this.mGifContainerView.setVisibility(8);
        goto L47
    L40:
        if (this.mOCRSwitch.isEnabled() == false) goto L42;
        r11 = true;
        goto L43
    L34:
        if (this.mOCRSwitch.isEnabled() == false) goto L36;
        r9 = true;
        goto L37
    L28:
        if (this.mOCRSwitch.isEnabled() == false) goto L30;
        r7 = true;
        goto L31
    L22:
        if (Utils.isPackageInstalled(this.mContext, Constants.PKG_CAMSCANNER) == false) goto L24;
        r6 = true;
        goto L25
    L18:
        r5 = false;
        goto L19
    L14:
        r4 = false;
        goto L16
    L8:
        if (Settings.Global.getInt(getContentResolver(), "text_boom", 1) != 1) goto L10;
        r3 = true;
        goto L11
    }

    private void updateBigbangGifView() {
        if (this.mIsViewStubInflated == true) goto L6;
        ViewStub r0 = (ViewStub) findViewByIdNullable(R.id.gif_view_stub);
        r0.setOnInflateListener(new TextBoomSettingsFragment$$ExternalSyntheticLambda0(this));
        r0.inflate();
        this.mBigbangGifAnimView = (BigbangGifAnimView) findViewByIdNullable(R.id.gif_view);
    L6:
        if (this.mIsBigBangEnabled == true) goto L8;
        this.mBigbangGifAnimView.setVisibility(8);
        this.mBigbangGifAnimView.cancelAnim();
        return;
    L8:
        if (this.mBigbangGifAnimView.getVisibility() == 0) goto L12;
        this.mBigbangGifAnimView.setVisibility(0);
        this.mPreloadGifView.setVisibility(8);
        this.mBigbangGifAnimView.startAnim();
        return;
    }

    /* JADX INFO: renamed from: lambda$updateBigbangGifView$0$com-android-settings-textboom-TextBoomSettingsFragment, reason: not valid java name */
    /* synthetic */ void m622xc7f2a9c1(ViewStub r1, View r2) {
        this.mIsViewStubInflated = true;
    }

    private void showWarningDialog(int r7) {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        AlertDialog.Builder r1 = new AlertDialog.Builder(this._mActivity);
        int r4 = 0;
        r1.setTitle(R.string.dlg_title_notice).setNegativeButton(android.R.string.cancel, null).setCancelable(false).setOnDismissListener(new AnonymousClass4(this));
        if (r7 != 1) goto L10;
        r1.setNegativeButton(R.string.see_video_later, new AnonymousClass5(this));
        r1.setPositiveButton(R.string.play_video_now, new AnonymousClass6(this));
        r4 = R.string.dlg_msg_play_usage_video;
    L23:
        if (r4 <= 0) goto L25;
        r1.setMessage(r4);
    L25:
        AlertDialog r8 = r1.create();
        this.mWarningDialog = r8;
        r8.show();
        return;
    L10:
        if (r7 != 2) goto L12;
        r1.setPositiveButton(R.string.install_text, new AnonymousClass7(this));
        r4 = R.string.install_camscanner_message;
        goto L23
    L12:
        if (r7 != 3) goto L14;
        r1.setNegativeButton(android.R.string.cancel, new AnonymousClass9(this));
        r1.setPositiveButton(R.string.enter_save_power_ok, new AnonymousClass10(this));
        r4 = R.string.bigbang_high_memory_warning;
        goto L23
    L14:
        if (r7 != 4) goto L16;
        r1.setPositiveButton(R.string.install_text, new AnonymousClass8(this));
        r4 = R.string.install_bigbang_message;
        goto L23
    L16:
        if (r7 == 6) goto L18;
        return;
    L18:
        View r9 = this.mLayoutInflater.inflate(R.layout.grant_dialog, null, false);
        TextView r2 = (TextView) r9.findViewById(R.id.grant_message);
        r2.setText(getPrivacyAndLegalSpan(R.string.ocr_enable_beta_content));
        r2.setHighlightColor(getResources().getColor(android.R.color.transparent));
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        r1.setView(r9);
        r1.setNegativeButton(android.R.string.cancel, new AnonymousClass11(this));
        r1.setPositiveButton(R.string.ok, new AnonymousClass12(this));
        goto L23
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void launchAppStoreForPackage(String r3) {
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r3));     // Catch: ActivityNotFoundException -> L5
        r0.setPackage(Utils.APP_STORE_PACKAGE);     // Catch: ActivityNotFoundException -> L5
        r0.addFlags(268435456);     // Catch: ActivityNotFoundException -> L5
        startActivity(r0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPackageReceiver.unregister();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackBigBang(this.mContext);
        BigbangGifAnimView r0 = this.mBigbangGifAnimView;
        if (r0 == null) goto L5;
        r0.cancelAnim();
    L5:
        super.onDestroy();
    }

    private boolean isLowConfigDevice() {
        if (DeviceType.is(DeviceType.T1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.T2) == true) goto L10;
        if (DeviceType.is(DeviceType.U1) == true) goto L10;
        return false;
    }

    private boolean needMemoryWarning() {
        if (isLowConfigDevice() == false) goto L6;
        return true;
    L6:
        if (DeviceType.is(DeviceType.OSCAR) == true) goto L8;
        return false;
    L8:
        return !PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_TEXT_BOOM_MEMORY_WARNED, false);
    }

    private void saveMemoryWarnedIfNeed() {
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L6;
        PreferenceMgr.getInstance(this.mContext).putBoolean(PreferenceMgr.KEY_TEXT_BOOM_MEMORY_WARNED, true);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mTextBoomSwitch.getSwitch()) goto L12;
        SettingsTracker.onSwitcherClick(EntityType.FILE, r3);
        if (r3 == false) goto L10;
        SettingsTracker.onEvent("A316980");
        if (needMemoryWarning() == false) goto L9;
        showWarningDialog(3);
        return;
    L9:
        showVideoDialogIfNeeded();
        return;
    L10:
        enableBigBang(r3);
        return;
    L12:
        if (r2 != this.mOCRSwitch.getSwitch()) goto L18;
        if (r3 == false) goto L16;
        SettingsTracker.onEvent("A316981");
        Settings.Global.putInt(getContentResolver(), "big_bang_ocr", 1);
        this.mOCRDetailSetting.setEnabled(true);
        this.mOCRApplistItem.setEnabled(true);
        this.mOCRGameSwitch.setEnabled(true);
        this.mOCRSwitch.setChecked(true);
        return;
    L16:
        Settings.Global.putInt(getContentResolver(), "big_bang_ocr", 0);
        this.mOCRDetailSetting.setEnabled(false);
        this.mOCRApplistItem.setEnabled(false);
        this.mOCRGameSwitch.setEnabled(false);
        return;
    L18:
        if (r2 != this.mOCRGameSwitch.getSwitch()) goto L28;
        Settings.Global.putInt(getContentResolver(), "big_bang_disable_ocr_in_game", r3 ? 1 : 0);
        if (r3 == false) goto L29;
        SettingsTracker.onEvent("A316982");
        return;
    L29:
        return;
    }

    private void showVideoDialogIfNeeded() {
        if (PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_BIGBANG_VIDEO_PLAYED, false) == false) goto L5;
        enableBigBang(true);
        return;
    L5:
        showWarningDialog(1);
    }

    private void enableBigBang(boolean r3) {
        Settings.Global.putInt(getContentResolver(), "text_boom", r3 ? 1 : 0);
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        switch(r3.getId()) {
            case 2131429068: goto L8;
            case 2131430191: goto L7;
            case 2131431308: goto L6;
            case 2131431637: goto L5;
            default: goto L13;
        };
    L5:
        playTutorialVideo();
        return;
    L6:
        start(BigBangTouchAreaSettingsFragment.class);
        SettingsTracker.onItemClick(802);
        return;
    L7:
        Intent r4 = new Intent(this._mActivity, com.android.settings.Settings.OcrApplicationsActivity.class);
        Utils.startActivity(this._mActivity, r4);
        return;
    L8:
        start(OCRDetalSettingsFragment.class);
        return;
    }

    private void playTutorialVideo() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(Constants.PACKAGE_NAME_HANDBOOK, Constants.CLASS_NAME_HANDBOOK));
        r0.putExtra(Constants.VIDEO_NAME_KEY, "bigbang_video");
        startActivityForResult(r0, 10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        OLog.d(this.TAG, "resultCode " + r4);
        if (r3 == 10) goto L5;
        return;
    L5:
        if (r4 != RESULT_OK) goto L9;
        PreferenceMgr.getInstance(this.mContext).putBoolean(PreferenceMgr.KEY_BIGBANG_VIDEO_PLAYED, true);
        return;
    }

    private String getTextBoomTriggerAreaSubtitle() {
        String[] r0 = getResources().getStringArray(R.array.thumb_trigger_area_options);
        int r2 = getTextBoomTriggerAreaSettings();
        if (r2 < r0.length) goto L5;
        return null;
    L5:
        return r0[r2];
    }

    private int getTextBoomTriggerAreaSettings() {
        return Settings.Global.getInt(getContentResolver(), "boom_text_trigger_area", 2);
    }

    private void startPrivacyActivity(int r5) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_res_name", "about_item_title_law_info");
        r0.setComponent(new ComponentName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.LicenseActivity"));
        r0.putExtra("extra_info_type", r5);
        Utils.startActivity(this._mActivity, r0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TextBoomSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_TextBoomSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TextBoomSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_TextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TextBoomSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_TextBoomSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
