package com.android.settings.eldership;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.Constants;
import com.android.settings.ExecutorManager;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.RingtoneSettingsActivity;
import com.android.settings.SettingsFeature;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItem;
import obric.widget.SettingItemSwitch;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class EldershipModeSettingsFragment extends BaseFragment implements View.OnClickListener, OnSwitcherCheckedChangedListener, CompoundButton.OnCheckedChangeListener {
    private static final int DIALOG_TYPE_IDEA_PILLS = 3;
    private static final int DIALOG_TYPE_ONE_STEP = 2;
    private static final int DIALOG_TYPE_TEXT_BOOM = 1;
    private static final int HAND_IN_HAND_STATE_CONNECTED = 2;
    private static final int HAND_IN_HAND_STATE_INVALID = -1;
    private static final int HAND_IN_HAND_STATE_LOGGED_IN = 1;
    private static final int HAND_IN_HAND_STATE_LOGGED_OUT = 0;
    private static final Uri HAND_IN_HAND_URI = null;
    private IEldershipSettingsController mController;
    private AlertDialog mDialog;
    private final ListContentItem.OnDisabledClickListener mHandInHandDisabledClickListener;
    private OListItemSettings mItemFontSize;
    private OListItemSettings mItemHandInHand;
    private OListItemSettings mItemLauncherGrids;
    private OListItemSettings mItemRingtone;
    private OListItemSettings mItemScreenZoom;
    private OListItemSettings mItemSwitchMuteDoubleCheck;
    private OSwitch mItemSwitchMuteDoubleCheckSwitch;
    private SettingItemSwitch mItemSwitchOneStep;
    private SettingItemSwitch mItemSwitchTextBoom;
    private SettingItemSwitch mItemSwitchthinkboost;
    private LinearLayout mSubSettingsContainer;

    private static class HandInHandStateAction {
        public static final int ACTION_CONNECTED_TOAST = 2;
        public static final int ACTION_START_CLIENT = 3;
        public static final int ACTION_UPDATE_SUB_TITLE = 1;
        int mAction;
        String mData;

        public HandInHandStateAction(int r1, String r2) {
            this.mAction = r1;
            this.mData = r2;
        }
    }

    private boolean showScreenZoomSetting() {
        return false;
    }

    public void com_android_settings_eldership_EldershipModeSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$000(EldershipModeSettingsFragment r0) {
        return r0.isHandInHandInstalled();
    }

    static /* synthetic */ void access$100(EldershipModeSettingsFragment r0) {
        r0.showInstallHandInHandDialog();
    }

    static /* synthetic */ int access$200(EldershipModeSettingsFragment r0) {
        return r0.getHandInHandState();
    }

    static /* synthetic */ OListItemSettings access$300(EldershipModeSettingsFragment r0) {
        return r0.mItemHandInHand;
    }

    static /* synthetic */ IEldershipSettingsController access$400(EldershipModeSettingsFragment r0) {
        return r0.mController;
    }

    static /* synthetic */ SettingItemSwitch access$500(EldershipModeSettingsFragment r0) {
        return r0.mItemSwitchTextBoom;
    }

    static /* synthetic */ SettingItemSwitch access$600(EldershipModeSettingsFragment r0) {
        return r0.mItemSwitchOneStep;
    }

    static /* synthetic */ SettingItemSwitch access$700(EldershipModeSettingsFragment r0) {
        return r0.mItemSwitchthinkboost;
    }

    static /* synthetic */ String access$800(EldershipModeSettingsFragment r0) {
        return r0.getHandInHandSubTitle();
    }

    static {
        HAND_IN_HAND_URI = Uri.parse("content://com.bytedanceos.handinhand.contentprovider");
    }

    public void com_android_settings_eldership_EldershipModeSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mController = new BasicEldershipSettingsController(this);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mController.getSettingsBehavior().onSaveInstanceState(r1);
    }

    public EldershipModeSettingsFragment() {
        super(R.layout.fragment_eldership_mode_settings);
        this.mHandInHandDisabledClickListener = new AnonymousClass1(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        View r6 = this.mController.onCreateSwitcherView(getActivity(), this.mController.getSettingsBehavior().isEldershipModeEnable(), this);
        int r7 = 0;
        if (r6 != null) goto L5;
    L7:
        OLog.e(this.TAG, "provided switcher view is null or has a parent. hide the tips text.");
        findViewByIdNullable(R.id.eldership_mode_tips).setVisibility(8);
    L8:
        this.mSubSettingsContainer = (LinearLayout) findViewByIdNullable(R.id.eldership_all_settings);
        this.mItemLauncherGrids = (OListItemSettings) findViewByIdNullable(R.id.item_launcher_grids);
        this.mItemFontSize = (OListItemSettings) findViewByIdNullable(R.id.item_font_size);
        this.mItemScreenZoom = (OListItemSettings) findViewByIdNullable(R.id.item_screen_zoom);
        this.mItemRingtone = (OListItemSettings) findViewByIdNullable(R.id.item_ringtone);
        this.mItemSwitchMuteDoubleCheck = (OListItemSettings) findViewByIdNullable(R.id.item_switch_mute_double_check);
        OSwitch r8 = new OSwitch(this.mContext);
        this.mItemSwitchMuteDoubleCheckSwitch = r8;
        r8.setClickable(true);
        this.mItemSwitchMuteDoubleCheck.setTrailingView(this.mItemSwitchMuteDoubleCheckSwitch);
        this.mItemSwitchTextBoom = (SettingItemSwitch) findViewByIdNullable(R.id.item_switch_text_boom);
        this.mItemSwitchOneStep = (SettingItemSwitch) findViewByIdNullable(R.id.item_switch_one_step);
        this.mItemSwitchthinkboost = (SettingItemSwitch) findViewByIdNullable(R.id.item_switch_idea_pills);
        this.mItemHandInHand = (OListItemSettings) findViewByIdNullable(R.id.item_hand_in_hand);
        OFloatingTitleBar r9 = this.mTitleView;
        if (r9 == null) goto L15;
        boolean r10 = this.mController.onSetupTitleAndOkButton(r9, (Button) findViewByIdNullable(R.id.btn_ok));
        View r1 = findViewByIdNullable(R.id.bottom_line);
        if (r10 == false) goto L13;
        int r11 = 0;
    L14:
        r1.setVisibility(r11);
        goto L15
    L13:
        r11 = 8;
    L15:
        boolean r12 = this.mController.showRingtoneSetting();
        OListItemSettings r2 = this.mItemRingtone;
        if (r12 == true) goto L19;
        r7 = 8;
    L19:
        r2.setVisibility(r7);
        View r13 = findViewByIdNullable(R.id.shortcut_contacts_tips);
        this.mItemHandInHand.setVisibility(8);
        r13.setVisibility(8);
        this.mItemLauncherGrids.setOnClickListener(this);
        this.mItemFontSize.setOnClickListener(this);
        this.mItemScreenZoom.setOnClickListener(this);
        this.mItemRingtone.setOnClickListener(this);
        this.mItemHandInHand.setOnClickListener(this);
        return;
    L5:
        if (r6.getParent() != null) goto L7;
        ((LinearLayout) findViewByIdNullable(R.id.ll_container)).addView(r6, 0);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateView();
        this.mItemSwitchMuteDoubleCheckSwitch.setOnCheckedChangeListener(this);
        this.mItemSwitchTextBoom.setOnCheckedChangeListener(this);
        this.mItemSwitchOneStep.setOnCheckedChangeListener(this);
        this.mItemSwitchthinkboost.setOnCheckedChangeListener(this);
    }

    private void updateView() {
        boolean r0 = this.mController.getSettingsBehavior().isEldershipModeEnable();
        this.mController.updateSwitcherView(r0);
        updateSubSettingsView(r0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mItemLauncherGrids) goto L6;
        this.mController.getSettingsBehavior().startLauncherSetting();
        return;
    L6:
        if (r2 != this.mItemFontSize) goto L9;
        this.mController.getSettingsBehavior().startFontSizeSetting();
        return;
    L9:
        if (r2 != this.mItemScreenZoom) goto L12;
        this.mController.getSettingsBehavior().startScreenZoomSetting();
        return;
    L12:
        if (r2 != this.mItemRingtone) goto L15;
        startPersonalRingtoneSetting();
        return;
    L15:
        if (r2 != this.mItemHandInHand) goto L22;
        onHandInHandClick();
        return;
    }

    private void onHandInHandClick() {
        Object r0 = this.mItemHandInHand.getTag();
        if (r0 != null) goto L5;
    L7:
        this.mItemHandInHand.setTag(true);
        ExecutorManager.execute(new AnonymousClass2(this));
        return;
    L5:
        if (((Boolean) r0).booleanValue() == false) goto L7;
    }

    private void startPersonalRingtoneSetting() {
        if (Utils.hasMultiSimInDevice() == false) goto L5;
        start(MultiSimRingtoneSettingFragment.class);
        return;
    L5:
        Intent r0 = new Intent();
        if (MultiSimAdapter.hasIccCard(1) == true) goto L8;
    L10:
        String r1 = SoundSettingsFragment.TYPE_RINGTONE;
    L11:
        r0.putExtras(SoundSettingsFragment.prepareRingtonePickerIntent(getString(R.string.sound_settings_text_phone_ring), r1));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    L8:
        if (MultiSimAdapter.hasIccCard(0) == true) goto L10;
        r1 = SoundSettingsFragment.TYPE_RINGTONE_SUB2;
        goto L11
    }

    private void startHandInHandBindingSetting() {
        Intent r0 = new Intent();
        r0.setClassName(Constants.PKG_HAND_IN_HAND, "com.bytedanceos.handinhand.business.OtherLaunchRequestReceiver");
        r0.setAction("com.bytedanceos.action.LAUNCH_HANDINHAND");
        r0.putExtra("bytedanceos.intent.extra.FORWARD_ANIM_RESOURCE_ID", new int[]{R.anim.slide_in_from_right, R.anim.slide_out_to_left});
        r0.putExtra("launch_from", 5);
        r0.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{R.anim.slide_in_from_left, R.anim.slide_out_to_right});
        this.mContext.sendBroadcast(r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        IEldershipSettingsBehavior r0 = this.mController.getSettingsBehavior();
        if (r3 != null) goto L5;
        Bundle r4 = null;
    L6:
        r0.handleSubSettingsResult(r1, r2, r4);
        return;
    L5:
        r4 = r3.getExtras();
        goto L6
    }

    @Override // com.android.settings.eldership.OnSwitcherCheckedChangedListener
    public void onEldershipModeCheckedChanged(boolean r2) {
        this.mController.getSettingsBehavior().setEldershipModeEnable(r2);
        updateSubSettingsView(r2);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemSwitchMuteDoubleCheckSwitch) goto L6;
        this.mController.getSettingsBehavior().setMuteDoubleCheckEnable(r3);
        return;
    L6:
        if (r2 != this.mItemSwitchTextBoom.getSwitch()) goto L13;
        if (r3 == true) goto L9;
    L11:
        this.mController.getSettingsBehavior().setTextBoomEnable(r3);
        return;
    L9:
        if (EldershipUtils.isLowConfigDevice() == false) goto L11;
        showMemoryWarningDialog(1);
        return;
    L13:
        if (r2 != this.mItemSwitchOneStep.getSwitch()) goto L20;
        if (r3 == true) goto L16;
    L18:
        this.mController.getSettingsBehavior().setOneStepEnable(r3);
        return;
    L16:
        if (EldershipUtils.isLowConfigDevice() == false) goto L18;
        showMemoryWarningDialog(2);
        return;
    L20:
        if (r2 != this.mItemSwitchthinkboost.getSwitch()) goto L32;
        if (r3 == true) goto L23;
    L25:
        this.mController.getSettingsBehavior().setthinkboostEnable(r3);
        return;
    L23:
        if (EldershipUtils.isLowConfigDevice() == false) goto L25;
        showMemoryWarningDialog(3);
        return;
    }

    private void showMemoryWarningDialog(final int r5) {
        AlertDialog r0 = this.mDialog;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        return;
    L8:
        if (r5 != 1) goto L10;
        CharSequence r1 = this.mItemSwitchTextBoom.getTitle();
    L17:
        FragmentActivity r2 = getActivity();
        if (r2 != null) goto L21;
        OLog.e(this.TAG, "showMemoryWarningDialog, activity is null, return");
        return;
    L21:
        this.mDialog = new AlertDialog.Builder(r2).setTitle(R.string.dlg_title_notice).setMessage(getString(R.string.smart_key_enable_tips, new Object[]{r1})).setNegativeButton(android.R.string.cancel, new AnonymousClass4(this, r5)).setPositiveButton(R.string.enter_save_power_ok, new AnonymousClass3(this, r5)).setCancelable(false).show();
        return;
    L10:
        if (r5 != 2) goto L12;
        r1 = this.mItemSwitchOneStep.getTitle();
        goto L17
    L12:
        if (r5 == 3) goto L14;
        return;
    L14:
        r1 = this.mItemSwitchthinkboost.getTitle();
        goto L17
    }

    private void showInstallHandInHandDialog() {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(this.TAG, "showInstallHandInHandDialog, activity is null, return");
        return;
    L11:
        this.mDialog = new AlertDialog.Builder(r1).setTitle(R.string.dlg_title_notice).setMessage(getString(R.string.install_package_message, new Object[]{getString(R.string.hand_in_hand_dialog_title)})).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.install_text, new AnonymousClass5(this, r1)).show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void updateSubSettingsView(boolean r6) {
        boolean r0 = this.mController.areSubSettingsVisible(r6);
        LinearLayout r1 = this.mSubSettingsContainer;
        boolean r3 = false;
        if (r0 == false) goto L5;
        int r4 = 0;
    L6:
        r1.setVisibility(r4);
        if (r0 == true) goto L9;
        return;
    L9:
        IEldershipSettingsBehavior r2 = this.mController.getSettingsBehavior();
        if (showScreenZoomSetting() == false) goto L12;
        this.mItemScreenZoom.setVisibility(0);
        this.mItemScreenZoom.setTrailingTextString(r2.getScreenZoom().toString());
    L13:
        this.mItemFontSize.setTrailingTextString(r2.getFontSize().toString());
        this.mItemSwitchMuteDoubleCheckSwitch.setChecked(r2.isMuteDoubleCheckEnable());
        this.mItemSwitchTextBoom.setChecked(r2.isTextBoomEnable());
        this.mItemSwitchOneStep.setChecked(r2.isOneStepEnable());
        this.mItemSwitchthinkboost.setChecked(r2.isthinkboostEnable());
        boolean r7 = this.mController.areSubSettingsEnabled(r6);
        int r5 = this.mSubSettingsContainer.getChildCount();
        int r8 = 0;
    L14:
        if (r8 >= r5) goto L20;
        View r9 = this.mSubSettingsContainer.getChildAt(r8);
        if (r9 == null) goto L18;
        r9.setEnabled(r7);
    L18:
        r8 = r8 + 1;
        goto L14
    L20:
        if (this.mController.showFamilyLoveSettings() == true) goto L22;
        return;
    L22:
        if (SettingsFeature.isFeatureDomestic(this.mContext) == false) goto L34;
        OListItemSettings r10 = this.mItemHandInHand;
        if (r7 == true) goto L26;
    L28:
        r10.setEnabled(r3);
        updateHandInHandSubTitle();
        return;
    L26:
        if (isHandInHandInstalled() == false) goto L28;
        r3 = true;
        goto L28
    L34:
        return;
    L12:
        this.mItemScreenZoom.setVisibility(8);
        goto L13
    L5:
        r4 = 8;
        goto L6
    }

    private void updateHandInHandSubTitle() {
        ExecutorManager.execute(new AnonymousClass6(this));
    }

    private String getHandInHandSubTitle() {
        if (isHandInHandInstalled() == false) goto L5;
        int r1 = getHandInHandState();     // Catch: Exception -> L17
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L14;
        return "";
    L14:
        return getString(R.string.logged_in);
    L16:
        return getString(R.string.click_to_login);
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return getString(R.string.click_to_login);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(HandInHandStateAction r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.mAction;
        if (r0 != 1) goto L7;
        this.mItemHandInHand.setTrailingTextString(r3.mData);
        return;
    L7:
        if (r0 != 2) goto L9;
        ToastUtils.show(getActivity(), R.string.hand_in_hand_connected);
        return;
    L9:
        if (r0 != 3) goto L17;
        startHandInHandBindingSetting();
        return;
    }

    private int getHandInHandState() {
        int r1 = -1;
        Bundle r2 = this.mContext.getContentResolver().call(HAND_IN_HAND_URI, "getState", null, null);     // Catch: Exception -> L8
        if (r2 != null) goto L6;
        return -1;
    L6:
        r1 = r2.getInt("state");     // Catch: Exception -> L8
        OLog.d(this.TAG, "got hand-in-hand state : " + r1);     // Catch: Exception -> L8
        return r1;
    L8:
        OLog.d(this.TAG, "getHandInHandState cr query error");
        return r1;
    }

    private boolean isHandInHandInstalled() {
        return Utils.isPackageInstalled(this.mContext, Constants.PKG_HAND_IN_HAND);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EldershipModeSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_EldershipModeSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EldershipModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_EldershipModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EldershipModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_EldershipModeSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
