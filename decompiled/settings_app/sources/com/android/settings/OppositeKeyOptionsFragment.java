package com.android.settings;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.DeviceType;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.PreviewOptionView;
import obric.widget.PreviewOptionsCheckView;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class OppositeKeyOptionsFragment extends BaseFragment implements View.OnClickListener, PreviewOptionsCheckView.OptionCheckListener, VerticalOptionsCheckView.OptionSelectListener {
    private static final int DIALOG_ID_ENABLE_WALLET = 3;
    private static final int DIALOG_SHORTCUT_AS_HOME = 2;
    private static final int DIALOG_SHORTCUT_AS_SIDEKEY = 1;
    private static final int INDEX_LIGHTEN_DARKEN_SCREEN = 2;
    private BaseAdapter mAdapter;
    private TextView mBootPhoneTips;
    private int mCurrentIndex;
    public String[] mDisplayTitles;
    private PreviewOptionsCheckView mDoubleClickHomeChooserView;
    private TextView mEnablethinkboostTips;
    private boolean mHomeTriggerthinkboost;
    private boolean mLeftKeyAsBrightness;
    private ListView mOptionsList;
    private Resources mResources;
    private PreviewOptionsCheckView mShortcutKeyChooserView;
    private TextView mSidekeyTitle;
    private SettingItemSwitch mSongSwitch;
    private TextView mSwitchSongTipsView;
    public ArrayList<Integer> mValues;
    private PreviewOptionsCheckView mVolumeKeyChooserView;
    private int mVolumeKeyValue;
    private VerticalOptionsCheckView mVolumeSettingsView;
    private int mWalletCardCount;
    private AlertDialog mWarningDialog;

    class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ OppositeKeyOptionsFragment this$0;

        class ViewHolder {
            final /* synthetic */ OptionsAdapter this$1;
            TextView title;

            ViewHolder(OptionsAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        OptionsAdapter(OppositeKeyOptionsFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mDisplayTitles.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
        L7:
            SettingItemCheck r8 = new SettingItemCheck(this.this$0.mContext);
            ViewHolder r9 = new ViewHolder(this);
            r9.title = r8.getTitleView();
            r8.setTag(r9);
            View r10 = r8;
        L8:
            r9.title.setText(this.this$0.mDisplayTitles[r5]);
            SettingItemCheck r11 = (SettingItemCheck) r10;
            if (OppositeKeyOptionsFragment.access$100(this.this$0) != r5) goto L11;
            r11.setChecked(true);
        L13:
            if (SettingsFeature.hasNoPowerKey() == true) goto L15;
        L22:
            if (r5 != 0) goto L25;
            r11.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_top);
        L28:
            return r10;
        L25:
            if (r5 != (this.this$0.mDisplayTitles.length - 1)) goto L27;
            r11.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_bottom);
            goto L28
        L27:
            r11.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
            goto L28
        L15:
            if (OppositeKeyOptionsFragment.access$1200(this.this$0) == false) goto L19;
            if (r5 != 2) goto L18;
            r11.setTitle(R.string.brightness_key_as_power_function);
            r11.setEnabled(true);
            goto L22
        L18:
            r11.setEnabled(false);
            goto L22
        L19:
            if (r5 != 2) goto L21;
            r11.setTitle(R.string.darken_screen);
        L21:
            r11.setEnabled(true);
            goto L22
        L11:
            r11.setChecked(false);
            goto L13
        L4:
            if ((r6.getTag() instanceof ViewHolder) == false) goto L7;
            r9 = (ViewHolder) r6.getTag();
            r10 = r6;
            goto L8
        }
    }

    private class TipsClickableSpan extends ClickableSpan {
        final /* synthetic */ OppositeKeyOptionsFragment this$0;

        private TipsClickableSpan(OppositeKeyOptionsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TipsClickableSpan(OppositeKeyOptionsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r1) {
            super.updateDrawState(r1);
            r1.setUnderlineText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r1) {
            OppositeKeyOptionsFragment.access$500(this.this$0);
        }
    }

    public void com_android_settings_OppositeKeyOptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OppositeKeyOptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.side_key;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OppositeKeyOptionsFragment() {
        this.mVolumeKeyValue = 1;
        this.mWalletCardCount = -1;
    }

    static /* synthetic */ ListView access$000(OppositeKeyOptionsFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ int access$100(OppositeKeyOptionsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$1002(OppositeKeyOptionsFragment r0, int r1) {
        r0.mWalletCardCount = r1;
        return r1;
    }

    static /* synthetic */ int access$102(OppositeKeyOptionsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ String access$1100(OppositeKeyOptionsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ boolean access$1200(OppositeKeyOptionsFragment r0) {
        return r0.mHomeTriggerthinkboost;
    }

    static /* synthetic */ SettingItemSwitch access$200(OppositeKeyOptionsFragment r0) {
        return r0.mSongSwitch;
    }

    static /* synthetic */ BaseAdapter access$300(OppositeKeyOptionsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$400(OppositeKeyOptionsFragment r0) {
        r0.save();
    }

    static /* synthetic */ void access$500(OppositeKeyOptionsFragment r0) {
        r0.launchthinkboost();
    }

    static /* synthetic */ AlertDialog access$702(OppositeKeyOptionsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$800(OppositeKeyOptionsFragment r0, boolean r1) {
        r0.applyBrightnessFunction(r1);
    }

    static /* synthetic */ void access$900(OppositeKeyOptionsFragment r0) {
        r0.updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.options_layout, r3, false);
        this.mVolumeKeyValue = android.provider.Settings.Global.getInt(getContentResolver(), "volume_key", 1);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        addHeaderView();
        Resources r5 = getResources();
        this.mResources = r5;
        this.mDisplayTitles = r5.getStringArray(R.array.opposite_key_titles);
        loadCurrentValueIndex();
        OptionsAdapter r6 = new OptionsAdapter(this);
        this.mAdapter = r6;
        this.mOptionsList.setAdapter(r6);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        addFootView();
        scrollToBottomIfNeeded();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        loadCurrentValueIndex();
        updateViews();
        this.mAdapter.notifyDataSetChanged();
        startQueryBankcardCount();
    }

    private void addHeaderView() {
        View r0 = requireActivity().getLayoutInflater().inflate(R.layout.sidekey_settings_header_layout, null);
        PreviewOptionsCheckView r1 = (PreviewOptionsCheckView) r0.findViewById(R.id.volume_key_chooser);
        this.mVolumeKeyChooserView = r1;
        r1.setHeadTitle(R.string.setup_volume_key_title);
        this.mVolumeKeyChooserView.bindPreviewOptionView(0, R.drawable.volume_key_left, null);
        this.mVolumeKeyChooserView.bindPreviewOptionView(1, R.drawable.volume_key_right, null);
        this.mVolumeKeyChooserView.setOptionCheckListener(this);
        VerticalOptionsCheckView r2 = (VerticalOptionsCheckView) r0.findViewById(R.id.volume_chooser_settings);
        this.mVolumeSettingsView = r2;
        r2.bindOptionPreview(R.string.setup_volume_key_title, R.drawable.brightness_key_left, R.drawable.brightness_key_right);
        this.mVolumeSettingsView.setOptionSelectListener(this);
        this.mSidekeyTitle = (TextView) r0.findViewById(R.id.header_text);
        this.mOptionsList.addHeaderView(r0);
    }

    private void addFootView() {
        View r0 = LayoutInflater.from(this.mContext).inflate(R.layout.sidekey_settings_footer_layout, null);
        SettingItemSwitch r1 = (SettingItemSwitch) r0.findViewById(R.id.switching_songs_with_brightness_keys);
        this.mSongSwitch = r1;
        if (android.provider.Settings.System.getInt(getContentResolver(), "switch_with_brightness_keys", 1) != 1) goto L5;
        boolean r2 = true;
    L6:
        r1.setChecked(r2);
        this.mSongSwitch.setOnCheckedChangeListener(new AnonymousClass2(this));
        this.mBootPhoneTips = (TextView) r0.findViewById(R.id.boot_phone_tips);
        this.mSwitchSongTipsView = (TextView) r0.findViewById(R.id.switching_songs_tips);
        PreviewOptionsCheckView r3 = (PreviewOptionsCheckView) r0.findViewById(R.id.id_shortcut_key_chooser);
        this.mShortcutKeyChooserView = r3;
        r3.setHeadTitle(R.string.idea_pills_shortcut_key_title);
        this.mShortcutKeyChooserView.setAutoCheck(false);
        this.mShortcutKeyChooserView.setOptionCheckListener(this);
        initPreviewOptionViewDimens(this.mShortcutKeyChooserView.getOptionView(0), R.dimen.sidekey_shortcut_preview_check_icon_margin_right);
        initPreviewOptionViewDimens(this.mShortcutKeyChooserView.getOptionView(1), R.dimen.home_shortcut_preview_check_icon_margin_right);
        PreviewOptionsCheckView r4 = (PreviewOptionsCheckView) r0.findViewById(R.id.double_click_home_chooser);
        this.mDoubleClickHomeChooserView = r4;
        r4.setHeadTitle(R.string.double_click_home_when_lockscreen);
        this.mDoubleClickHomeChooserView.setAutoCheck(false);
        this.mDoubleClickHomeChooserView.bindPreviewOptionView(0, R.drawable.setting_call_music, R.string.home_trigger_music);
        this.mDoubleClickHomeChooserView.bindPreviewOptionView(1, R.drawable.setting_call_wallet, R.string.home_trigger_wallet);
        initDoubleClickHomePreviewDimens(this.mDoubleClickHomeChooserView.getOptionView(0));
        initDoubleClickHomePreviewDimens(this.mDoubleClickHomeChooserView.getOptionView(1));
        this.mDoubleClickHomeChooserView.setOptionCheckListener(this);
        if (SettingsFeature.isWalletFeatureEnabled(this.mContext) == false) goto L9;
        this.mDoubleClickHomeChooserView.setVisibility(0);
    L10:
        this.mEnablethinkboostTips = (TextView) r0.findViewById(R.id.enable_idea_pills_tips);
        if (SettingsFeature.hasNoPowerKey() == false) goto L13;
        this.mShortcutKeyChooserView.setVisibility(0);
        this.mEnablethinkboostTips.setVisibility(0);
    L14:
        this.mOptionsList.addFooterView(r0);
        return;
    L13:
        this.mShortcutKeyChooserView.setVisibility(8);
        this.mEnablethinkboostTips.setVisibility(8);
        goto L14
    L9:
        this.mDoubleClickHomeChooserView.setVisibility(8);
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void initDoubleClickHomePreviewDimens(PreviewOptionView r4) {
        r4.setCheckImgMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_check_icon_margin_top), getResources().getDimensionPixelOffset(R.dimen.preview_widget_icon_margin_right), 0, 0);
        r4.setPreviewImgMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_widget_icon_margin_top), 0, 0, 0);
        r4.setPreviewTitleMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_widget_title_margin_top), 0, 0, 0);
    }

    private void initPreviewOptionViewDimens(PreviewOptionView r3, int r4) {
        r3.setCheckImgMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_check_icon_margin_top), getResources().getDimensionPixelOffset(r4), 0, 0);
        r3.setPreviewImgMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_widget_icon_margin_top), 0, 0, 0);
        r3.setPreviewTitleMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_widget_title_margin_top), 0, 0, 0);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        loadCurrentValueIndex();
        updateViews();
        this.mAdapter.notifyDataSetChanged();
        startQueryBankcardCount();
    }

    private void scrollToBottomIfNeeded() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        OLog.e(this.TAG, "scrollToBottomIfNeeded, activity is null, return");
        return;
    L7:
        if (r0.getIntent().getBooleanExtra("scroll", false) == false) goto L10;
        this.mOptionsList.post(new AnonymousClass3(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateViews() {
        if (this.mVolumeKeyValue != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mLeftKeyAsBrightness = r0;
        this.mHomeTriggerthinkboost = "idea_pills".equals(android.provider.Settings.Global.getString(getContentResolver(), "long_click_home"));
        if (this.mLeftKeyAsBrightness == false) goto L9;
        String r1 = getString(R.string.volume_key_left);
    L10:
        int r6 = 8;
        if (this.mHomeTriggerthinkboost == false) goto L13;
        this.mVolumeKeyChooserView.setVisibility(8);
        this.mVolumeSettingsView.setVisibility(0);
    L15:
        if (SettingsFeature.hasNoPowerKey() == false) goto L21;
        this.mBootPhoneTips.setText(R.string.boot_phone_via_home_tips);
        TextView r5 = this.mBootPhoneTips;
        if (this.mHomeTriggerthinkboost == false) goto L19;
        r6 = 0;
    L19:
        r5.setVisibility(r6);
    L27:
        if (this.mLeftKeyAsBrightness == false) goto L29;
        this.mVolumeKeyChooserView.setCheck(1);
        this.mVolumeSettingsView.setCheck(2);
        this.mSidekeyTitle.setText(R.string.setup_volume_key_left);
        this.mSwitchSongTipsView.setText(R.string.switching_songs_tips_left);
        this.mShortcutKeyChooserView.bindPreviewOptionView(0, R.drawable.idea_pills_shortcut_left_key, getString(R.string.hold_key_of, new Object[]{getString(R.string.volume_key_left)}));
    L30:
        SwitchEx r3 = this.mSongSwitch.getSwitch();
        if (this.mCurrentIndex != 2) goto L33;
        boolean r4 = false;
    L34:
        r3.setEnabled(r4);
        this.mSongSwitch.setTitle(getString(R.string.switch_song_via_sidekey_of, new Object[]{r1}));
        this.mShortcutKeyChooserView.bindPreviewOptionView(1, R.drawable.idea_pills_shortcut_home_key, R.string.long_press_home_key);
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_assist_beta_enable", 0) != 1) goto L37;
        Object[] r7 = true;
    L38:
        if (r7 == false) goto L40;
        this.mShortcutKeyChooserView.setCheck(this.mHomeTriggerthinkboost ? 1 : 0);
    L42:
        if (isVoiceAssistEnabled() == false) goto L48;
        this.mShortcutKeyChooserView.setEnabled(true);
        if (this.mHomeTriggerthinkboost == false) goto L46;
        String r2 = getString(R.string.home_launch_idea_pills_tips, new Object[]{r1});
    L47:
        this.mEnablethinkboostTips.setText(r2);
    L49:
        updateHomeKeyDoubleClickSettingsUI();
        this.mAdapter.notifyDataSetChanged();
        return;
    L46:
        r2 = getString(R.string.sidekey_launch_idea_pills_tips, new Object[]{r1, r1});
        goto L47
    L48:
        String r8 = getString(R.string.enable_idea_pills_tips);
        SpannableStringBuilder r9 = new SpannableStringBuilder(r8).append(HanziToPinyin.Token.SEPARATOR).append(getString(R.string.goto_enable));
        r9.setSpan(new TipsClickableSpan(this, null), r8.length(), r9.length(), 33);
        this.mEnablethinkboostTips.setText(r9);
        this.mEnablethinkboostTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.mShortcutKeyChooserView.setEnabled(false);
        goto L49
    L40:
        this.mShortcutKeyChooserView.setCheck(-1);
        goto L42
    L37:
        r7 = false;
        goto L38
    L33:
        r4 = true;
        goto L34
    L29:
        this.mVolumeKeyChooserView.setCheck(0);
        this.mVolumeSettingsView.setCheck(0);
        this.mSidekeyTitle.setText(R.string.setup_volume_key_right);
        this.mSwitchSongTipsView.setText(R.string.switching_songs_tips_right);
        this.mShortcutKeyChooserView.bindPreviewOptionView(0, R.drawable.idea_pills_shortcut_right_key, getString(R.string.hold_key_of, new Object[]{getString(R.string.volume_key_right)}));
        goto L30
    L21:
        if (DeviceType.is(DeviceType.U1) == false) goto L27;
        this.mBootPhoneTips.setText(getString(R.string.long_press_sidekey_enabled_tips, new Object[]{r1}));
        TextView r10 = this.mBootPhoneTips;
        if (isVoiceAssistEnabled() == false) goto L25;
        r6 = 0;
    L25:
        r10.setVisibility(r6);
        goto L27
    L13:
        this.mVolumeSettingsView.setVisibility(8);
        this.mVolumeKeyChooserView.setVisibility(0);
        goto L15
    L9:
        r1 = getString(R.string.volume_key_right);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private void updateHomeKeyDoubleClickSettingsUI() {
        int r2 = 0;
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), "lockscreen_home_trigger_type", 0);
        PreviewOptionsCheckView r3 = this.mDoubleClickHomeChooserView;
        if (r0 != 1) goto L5;
        r2 = 1;
    L5:
        r3.setCheck(r2);
    }

    private void save() {
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), "brightness_key_function", 1);
        android.provider.Settings.Global.putInt(getContentResolver(), "last_brightness_key_function", r0);
        android.provider.Settings.Global.putInt(getContentResolver(), "brightness_key_function", this.mCurrentIndex);
    }

    private void loadCurrentValueIndex() {
        this.mCurrentIndex = android.provider.Settings.Global.getInt(getContentResolver(), "brightness_key_function", 1);
    }

    private boolean isVoiceAssistEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void showWarningDialog(int r10) {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(this.TAG, "showWarningDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        int r3 = 0;
        r2.setTitle(R.string.dlg_title_notice).setNegativeButton(android.R.string.cancel, null).setCancelable(false).setOnDismissListener(new AnonymousClass4(this));
        if (this.mLeftKeyAsBrightness == false) goto L14;
        int r4 = R.string.volume_key_left;
    L15:
        String r5 = getString(r4);
        View r6 = LayoutInflater.from(this.mContext).inflate(R.layout.idea_pills_shortcut_dialog_layout, null);
        TextView r7 = (TextView) r6.findViewById(R.id.id_message);
        ImageView r8 = (ImageView) r6.findViewById(R.id.id_intro_image);
        if (r10 == 1) goto L23;
        if (r10 != 2) goto L19;
        r7.setText(getString(R.string.idea_pills_shortcut_as_home_msg, new Object[]{r5}));
        r8.setImageResource(R.drawable.tip_thinkboost_home);
        r2.setView(r6).setPositiveButton(R.string.lockpattern_confirm_button_text, new AnonymousClass6(this));
    L28:
        if (r3 <= 0) goto L30;
        r2.setMessage(r3);
    L30:
        AlertDialog r11 = r2.create();
        this.mWarningDialog = r11;
        r11.show();
        return;
    L19:
        if (r10 == 3) goto L21;
        return;
    L21:
        r2.setPositiveButton(R.string.add_card, new AnonymousClass7(this));
        r3 = R.string.wallet_add_card_message;
        goto L28
    L23:
        r7.setText(getString(R.string.idea_pills_shortcut_as_sidekey_msg, new Object[]{r5, r5}));
        if (this.mLeftKeyAsBrightness == false) goto L26;
        int r12 = R.drawable.tip_thinkboost_left;
    L27:
        r8.setImageResource(r12);
        r2.setView(r6).setPositiveButton(R.string.lockpattern_confirm_button_text, new AnonymousClass5(this));
        goto L28
    L26:
        r12 = R.drawable.tip_thinkboost_right;
        goto L27
    L14:
        r4 = R.string.volume_key_right;
        goto L15
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void launchthinkboost() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.sara", "com.bytedanceos.sara.bubble.SettingActivity"));
        Utils.startActivity(this._mActivity, r0, 0);
    }

    private void applyBrightnessFunction(boolean r4) {
        if (r4 == false) goto L5;
        this.mCurrentIndex = 2;
        int r5 = android.provider.Settings.Global.getInt(getContentResolver(), "brightness_key_function", 1);
        android.provider.Settings.Global.putInt(getContentResolver(), "last_brightness_key_function", r5);
        android.provider.Settings.Global.putInt(getContentResolver(), "brightness_key_function", this.mCurrentIndex);
        return;
    L5:
        int r6 = android.provider.Settings.Global.getInt(getContentResolver(), "last_brightness_key_function", 1);
        android.provider.Settings.Global.putInt(getContentResolver(), "brightness_key_function", r6);
        this.mCurrentIndex = r6;
    }

    @Override // obric.widget.PreviewOptionsCheckView.OptionCheckListener
    public void onOptionChecked(PreviewOptionsCheckView r4, int r5) {
        if (r4 != this.mVolumeKeyChooserView) goto L11;
        if (r5 == 0) goto L8;
        if (r5 != 1) goto L9;
        this.mVolumeKeyValue = 1;
    L9:
        android.provider.Settings.Global.putInt(getContentResolver(), "volume_key", this.mVolumeKeyValue);
        updateViews();
        return;
    L8:
        this.mVolumeKeyValue = 0;
        goto L9
    L11:
        if (r4 != this.mShortcutKeyChooserView) goto L18;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L38;
        showWarningDialog(2);
        return;
    L38:
        return;
    L16:
        showWarningDialog(1);
        return;
    L18:
        if (r4 == this.mDoubleClickHomeChooserView) goto L20;
        return;
    L20:
        if (r5 == 0) goto L29;
        if (r5 != 1) goto L39;
        int r6 = this.mWalletCardCount;
        if (r6 == (-1)) goto L28;
        if (r6 == 0) goto L27;
        android.provider.Settings.Global.putInt(getContentResolver(), "lockscreen_home_trigger_type", 1);
        updateHomeKeyDoubleClickSettingsUI();
        return;
    L27:
        showWarningDialog(3);
        return;
    L28:
        updateHomeKeyDoubleClickSettingsUI();
        return;
    L39:
        return;
    L29:
        android.provider.Settings.Global.putInt(getContentResolver(), "lockscreen_home_trigger_type", 0);
        updateHomeKeyDoubleClickSettingsUI();
    }

    @Override // com.android.settings.widget.VerticalOptionsCheckView.OptionSelectListener
    public void onOptionSelected(int r3) {
        if (r3 != 0) goto L4;
        this.mVolumeKeyValue = 0;
    L8:
        android.provider.Settings.Global.putInt(getContentResolver(), "volume_key", this.mVolumeKeyValue);
        updateViews();
        return;
    L4:
        if (r3 == 2) goto L6;
        return;
    L6:
        this.mVolumeKeyValue = 1;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.OppositeKeyOptionsFragment$8] */
    private void startQueryBankcardCount() {
        new AnonymousClass8(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OppositeKeyOptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OppositeKeyOptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OppositeKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OppositeKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OppositeKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OppositeKeyOptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
