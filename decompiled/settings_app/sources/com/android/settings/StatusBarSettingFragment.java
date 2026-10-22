package com.android.settings;

import android.content.ContentResolver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class StatusBarSettingFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final int MODE_EXPAND = 0;
    public static final int MODE_OPEN_APP = 1;
    public static final String STATUS_BAR_NOTIFICATION_ICON = "status_bar_notification_icon";
    public static final String STATUS_BAR_SHOW_NETWORK_SPEED = "status_bar_show_network_speed";
    public static final String SWITCH_DEFAULT_CLOSE = "0";
    public static final String SWITCH_DEFAULT_OPEN = "1";
    private OCardListItem mLiveCardClickAction;
    private OCardListItem mNotificationIconItemSwitch;
    private OPopover mPopMenu;
    private OCardListItem mShowNetworkSpeedSwitch;

    public void com_android_settings_StatusBarSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_StatusBarSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.status_bar_title;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public StatusBarSettingFragment() {
        this.mPopMenu = null;
    }

    static /* synthetic */ void access$000(StatusBarSettingFragment r0, int r1) {
        r0.updateLiveCardClickMode(r1);
    }

    static /* synthetic */ OCardListItem access$100(StatusBarSettingFragment r0) {
        return r0.mLiveCardClickAction;
    }

    static /* synthetic */ OPopover access$200(StatusBarSettingFragment r0) {
        return r0.mPopMenu;
    }

    static /* synthetic */ OPopover access$202(StatusBarSettingFragment r0, OPopover r1) {
        r0.mPopMenu = r1;
        return r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.status_bar_settings_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.live_card_click_action);
        this.mLiveCardClickAction = r5;
        r5.setOnContentClickListener(this);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.notification_icon);
        this.mNotificationIconItemSwitch = r6;
        r6.getContentContainer().setClickable(false);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.network_speed);
        this.mShowNetworkSpeedSwitch = r7;
        r7.getContentContainer().setClickable(false);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        ((OSwitch) this.mNotificationIconItemSwitch.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mShowNetworkSpeedSwitch.getCustomEndView()).setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != ((OSwitch) this.mNotificationIconItemSwitch.getCustomEndView())) goto L6;
        handleToggleNotificationIconClick(r3);
        return;
    L6:
        if (r2 != ((OSwitch) this.mShowNetworkSpeedSwitch.getCustomEndView())) goto L10;
        handleToggleNetworkSpeedClick(r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mLiveCardClickAction.getContentContainer()) goto L6;
        showLiveCardClickPopMenu();
        return;
    }

    private void showLiveCardClickPopMenu() {
        final String[] r1 = {getString(R.string.live_card_expand_action), getString(R.string.live_card_open_app_action)};
        ArrayList r2 = new ArrayList();
        final int r5 = getLiveCardClickMode();
        int r6 = 0;
    L3:
        if (r6 >= 2) goto L9;
        String r8 = r1[r6];
        if (r5 != r6) goto L7;
        boolean r9 = true;
    L8:
        r2.add(new Item(r8, r9));
        r6 = r6 + 1;
        goto L3
    L7:
        r9 = false;
        goto L8
    L9:
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L13;
        OLog.e(this.TAG, "showLiveCardClickPopMenu, activity is null, return");
        return;
    L13:
        this.mPopMenu = OPopoverHelper.showPopoverList(r0, this.mLiveCardClickAction, r2, new AnonymousClass1(this, r5, r1), true);
    }

    private int getLiveCardClickMode() {
        return android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), LiveCardClickSettingsFragment.LiveCardClickAction, 0);
    }

    private void updateLiveCardClickMode(int r2) {
        android.provider.Settings.Secure.putInt(getContentResolver(), LiveCardClickSettingsFragment.LiveCardClickAction, r2);
    }

    private void updateViews() {
        ContentResolver r0 = getContentResolver();
        OCardListItemUtils.setCustomEndTipTextView(this.mLiveCardClickAction, ResourceUtils.getString(getLiveCardClickActionRes()));
        OSwitch r1 = (OSwitch) this.mNotificationIconItemSwitch.getCustomEndView();
        boolean r3 = false;
        if (android.provider.Settings.Secure.getInt(r0, STATUS_BAR_NOTIFICATION_ICON, Integer.valueOf("1").intValue()) != 1) goto L5;
        boolean r2 = true;
    L6:
        r1.setChecked(r2);
        OSwitch r5 = (OSwitch) this.mShowNetworkSpeedSwitch.getCustomEndView();
        if (android.provider.Settings.Secure.getInt(r0, STATUS_BAR_SHOW_NETWORK_SPEED, Integer.valueOf("0").intValue()) != 1) goto L9;
        r3 = true;
    L9:
        r5.setChecked(r3);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void handleToggleNotificationIconClick(boolean r2) {
        android.provider.Settings.Secure.putInt(getContentResolver(), STATUS_BAR_NOTIFICATION_ICON, r2 ? 1 : 0);
    }

    private void handleToggleNetworkSpeedClick(boolean r2) {
        android.provider.Settings.Secure.putInt(getContentResolver(), STATUS_BAR_SHOW_NETWORK_SPEED, r2 ? 1 : 0);
    }

    private int getLiveCardClickActionRes() {
        if (LiveCardClickSettingsFragment.getLiveCardClickMode(this.mContext) != 0) goto L6;
        return R.string.live_card_expand_action;
    L6:
        return R.string.live_card_open_app_action;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StatusBarSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_StatusBarSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StatusBarSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_StatusBarSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StatusBarSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_StatusBarSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
