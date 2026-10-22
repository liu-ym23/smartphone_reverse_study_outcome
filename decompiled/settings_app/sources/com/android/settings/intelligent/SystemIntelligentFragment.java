package com.android.settings.intelligent;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.voice.VoiceInteractionServiceInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.internal.app.AssistUtils;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ColorButtonStyleController;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.applications.DefaultAppInfo;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SystemIntelligentFragment extends BaseFragment {
    private static final String ACTION_LAUNCH_SETTING = "com.obric.assistant.LAUNCH_SETTING";
    private static final int AI_LAB_STATUS_BLACKLIST = 4;
    private static final int AI_LAB_STATUS_INIT = 0;
    private static final String ASSISTANT_ACCOUNT_INFO_OBSERVER_URI = "content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_account_info";
    private static final String ASSISTANT_ACCOUNT_INFO_PROVIDER = "content://com.obric.assistant.provider.AssistantHybridAbilityProvider";
    private static final String ASSIST_PACKAGE_NAME = "com.obric.assistant";
    private static final String KEY_IS_ENTERPRISE = "is_enterprise";
    private static final String METHOD_QUERY_ACCOUNT_INFO = "query_account_info";
    private static final String MULTIMEDIA_METADATA_ACTION = "com.obric.mediametadataservice.SETTINGS";
    private static final String MULTIMEDIA_METADATA_PACKAGE_NAME = "com.obric.mediametadataservice";
    private static final String STATIC_TAG = "SystemIntelligentFragment";
    private static final String URI_PERMISSION_STATUS = "content://com.obric.memorydata.memory.ailabprovider/memory_permission_status";
    private static final String URI_STATUS = "content://com.obric.memorydata.memory.ailabprovider/ai_lab_status";
    private static volatile boolean sHasEnterpriseAccountCache;
    private static volatile boolean sIsEnterpriseAccount;
    private OCardListItem[] items;
    private OCardListItem mAILab;
    private AssistUtils mAssistUtils;
    private ContentObserver mAssistantAccountObserver;
    private OCardListItem mAssistantActivation;
    private OCardListItem mAssistantCallForwarding;
    private OCardListItem mAssistantEnable;
    private OCardListItem mAssistantHighPriorityNotification;
    private OCardListItem mAssistantMemory;
    private OCardListItem mAssistantRecordingSummary;
    private final CompoundButton.OnCheckedChangeListener mDoubaoCheckedListener;
    private OCardListItem mDoubaoDevices;
    private OAlertDialog mDoubaoDisableDialog;
    private DoubaoAssistantEnabler mDoubaoEnabler;
    private OListItemSettings mDoubaoProposal;
    private OCardListItem mDoubaoSettings;
    private OCardListItem mDoubaoSwitch;
    private OPopover mPopover;
    private View titleBarRightBtn;

    public interface EnterpriseAccountCallback {
        void onResult(boolean r1);
    }

    public void com_android_settings_intelligent_SystemIntelligentFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(SystemIntelligentFragment r0, boolean r1) {
        r0.setDoubaoAssistantEnabled(r1);
    }

    static /* synthetic */ DoubaoAssistantEnabler access$100(SystemIntelligentFragment r0) {
        return r0.mDoubaoEnabler;
    }

    static /* synthetic */ String access$1000(SystemIntelligentFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$1100(SystemIntelligentFragment r0, boolean r1) {
        r0.getAILabState(r1);
    }

    static /* synthetic */ Intent access$200(SystemIntelligentFragment r0) {
        return r0.getAssistSettingIntent();
    }

    static /* synthetic */ String access$300(SystemIntelligentFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$400(SystemIntelligentFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ Integer access$500(SystemIntelligentFragment r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ Integer access$600(SystemIntelligentFragment r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ Intent access$700(SystemIntelligentFragment r0) {
        return r0.getSmartNotificationSettingActivity();
    }

    static /* synthetic */ void access$800(SystemIntelligentFragment r0) {
        r0.refreshWhenAssistantAccountChanged();
    }

    static /* synthetic */ void access$900(SystemIntelligentFragment r0, boolean r1) {
        r0.changeAlwaysOnTileService(r1);
    }

    public SystemIntelligentFragment() {
        super(R.layout.system_intelligent_layout);
        this.items = null;
        this.mDoubaoCheckedListener = new AnonymousClass1(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r8, Bundle r9) {
        super.initViews(r8, r9);
        View r3 = findViewByIdNullable(R.id.assistant_sub_container);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.assistant_switch);
        this.mDoubaoSwitch = r10;
        r10.setDefaultCustomEndView(1);
        OSwitch r11 = (OSwitch) this.mDoubaoSwitch.getCustomEndView();
        this.mDoubaoEnabler = new DoubaoAssistantEnabler(getActivity(), r11, r3, this.mDoubaoSwitch, this.mDoubaoCheckedListener);
        r11.setClickable(true);
        this.mDoubaoSwitch.setOnClickListener(new AnonymousClass2(this));
        this.mAssistantEnable = (OCardListItem) findViewByIdNullable(R.id.assistant_enable);
        this.mAssistantEnable.setCustomStartView((OTextView) LayoutInflater.from(getActivity()).inflate(R.layout.system_intelligent_btn_enable, this.mAssistantEnable.getCardContainer(), false));
        this.mAssistantEnable.showCustomStart(true);
        this.mAssistantEnable.setOnContentClickListener(new SystemIntelligentFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r12 = this.mAssistantEnable;
        if (this.mDoubaoEnabler.isEnabled() == false) goto L5;
        int r0 = 8;
    L6:
        r12.setVisibility(r0);
        this.mDoubaoEnabler.setEnableChangeCallback(new SystemIntelligentFragment$$ExternalSyntheticLambda2(this));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.doubao_settings);
        this.mDoubaoSettings = r13;
        r13.setOnContentClickListener(new AnonymousClass3(this));
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.assistant_activation);
        this.mAssistantActivation = r14;
        r14.setOnContentClickListener(new AnonymousClass4(this));
        OCardListItem r15 = (OCardListItem) findViewByIdNullable(R.id.doubao_devices);
        this.mDoubaoDevices = r15;
        r15.setOnContentClickListener(new AnonymousClass5(this));
        OCardListItem r16 = (OCardListItem) findViewByIdNullable(R.id.assistant_memory);
        this.mAssistantMemory = r16;
        r16.setOnContentClickListener(new AnonymousClass6(this));
        OCardListItem r17 = (OCardListItem) findViewByIdNullable(R.id.assistant_call_forwarding);
        this.mAssistantCallForwarding = r17;
        r17.setOnContentClickListener(new AnonymousClass7(this));
        this.mAssistantCallForwarding.clearCustomTitleView();
        this.mAssistantCallForwarding.setCustomTitleView(R.layout.view_o_card_list_item_custom_title_tag, 0, true);
        OTextView r18 = this.mAssistantCallForwarding.getCustomTitleText(0);
        if (r18 == null) goto L9;
        r18.setText(R.string.assistant_call_forwarding);
    L9:
        this.mAssistantCallForwarding.showTitle(false);
        OCardListItem r19 = (OCardListItem) findViewByIdNullable(R.id.assistant_high_priority_notification);
        this.mAssistantHighPriorityNotification = r19;
        r19.setOnContentClickListener(new AnonymousClass8(this));
        OCardListItem r20 = (OCardListItem) findViewByIdNullable(R.id.assistant_recording_summary);
        this.mAssistantRecordingSummary = r20;
        r20.setOnContentClickListener(new AnonymousClass9(this));
        OCardListItem r21 = (OCardListItem) findViewByIdNullable(R.id.ai_lab);
        this.mAILab = r21;
        r21.setOnContentClickListener(new AnonymousClass10(this));
        this.items = new OCardListItem[]{this.mAssistantMemory, this.mAssistantCallForwarding, this.mAssistantHighPriorityNotification, this.mAssistantRecordingSummary, this.mAILab};
        updateItemBackground();
        this.mAssistUtils = new AssistUtils(getContext());
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(findViewByIdNullable(R.id.page_scrollview));
        return;
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$initViews$0$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m507xffc9ea19(View r1) {
        setDoubaoAssistantEnabled(true);
    }

    /* JADX INFO: renamed from: lambda$initViews$1$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ Unit m508x5cdb578(Boolean r3) {
        OCardListItem r0 = this.mAssistantEnable;
        if (r3.booleanValue() == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        View r2 = this.titleBarRightBtn;
        if (r2 == null) goto L10;
        r2.setEnabled(r3.booleanValue());
    L10:
        return Unit.INSTANCE;
    L5:
        r1 = 0;
        goto L6
    }

    private void updateItemBackground() {
        OCardListItem[] r6 = this.items;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length == 0) goto L26;
        int r0 = r6.length;
        OCardListItem r1 = null;
        int r3 = 0;
        OCardListItem r2 = null;
    L8:
        if (r3 >= r0) goto L17;
        OCardListItem r4 = r6[r3];
        if (r4.getVisibility() != 0) goto L15;
        if (r1 != null) goto L14;
        r1 = r4;
    L14:
        r4.setCardPosition(2);
        r2 = r4;
    L15:
        r3 = r3 + 1;
        goto L8
    L17:
        if (r1 != r2) goto L19;
        r1.setCardPosition(1);
        return;
    L19:
        r1.setCardPosition(1);
        r2.setCardPosition(3);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        r1.setPadding(0, 0, 0, 0);
        ViewGroup r3 = (ViewGroup) r1.findViewById(R.id.page_root);
        if (r3 == null) goto L6;
        r3.setClipChildren(false);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    protected void initTitleView(View r4) {
        super.initTitleView(r4);
        OFloatingTitleBar r5 = this.mTitleView;
        if (r5 == null) goto L8;
        View r6 = r5.addEndAction(R.drawable.oui_icon_leading, -1, new SystemIntelligentFragment$$ExternalSyntheticLambda0(this));
        this.titleBarRightBtn = r6;
        DoubaoAssistantEnabler r3 = this.mDoubaoEnabler;
        if (r3 == null) goto L9;
        r6.setEnabled(r3.isEnabled());
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: lambda$initTitleView$2$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m506x5b3a2608(View r1) {
        showAssistantMenu(r1);
    }

    private void showAssistantMenu(final View r4) {
        final boolean r0 = shouldShowNonEnterpriseAccountItems(this.mContext);
        showAssistantMenuInternal(r4, r0);
        refreshEnterpriseAccountStatus(this.mContext, new SystemIntelligentFragment$$ExternalSyntheticLambda5(this, r0, r4));
    }

    /* JADX INFO: renamed from: lambda$showAssistantMenu$3$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m510xcabc4c54(boolean r1, View r2, boolean r3) {
        boolean r4 = !r3;
        if (r4 != r1) goto L5;
        return;
    L5:
        if (this.titleBarRightBtn == null) goto L14;
        OPopover r5 = this.mPopover;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.isShowing() == false) goto L16;
        this.mPopover.dismiss();
        showAssistantMenuInternal(r2, r4);
        return;
    L16:
        return;
    }

    private void showAssistantMenuInternal(View r4, boolean r5) {
        if (getActivity() == null) goto L11;
        if (r4 == null) goto L12;
        OPopoverEntranceMenuView.Builder r0 = new OPopoverEntranceMenuView.Builder(getActivity());
        if (r5 == false) goto L9;
        OPopoverHelper.addPopoverItem(r0, getActivity().getString(R.string.doubao_assistant_improvement_plan), new SystemIntelligentFragment$$ExternalSyntheticLambda13(this));
    L9:
        r0.addHighlightPopoverItem(0, getActivity().getString(R.string.doubao_assistant_disable), new SystemIntelligentFragment$$ExternalSyntheticLambda14(this));
        OPopoverEntranceMenuView r6 = r0.build();
        this.mPopover = new OPopover.Builder(getActivity()).setView(r6).build();
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(this.mPopover, r4, 83);
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: lambda$showAssistantMenuInternal$4$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ Unit m511x17381cf6(View r1, Integer r2) {
        routeToDoubaoAssistantImprovementPlan();
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$showAssistantMenuInternal$5$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ Unit m512x1d3be855(View r1, Integer r2) {
        setDoubaoAssistantEnabled(false);
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    public static boolean shouldShowNonEnterpriseAccountItems(Context r0) {
        if (r0 != null) goto L4;
    L8:
        return false;
    L4:
        if (sHasEnterpriseAccountCache == false) goto L8;
        if (sIsEnterpriseAccount == true) goto L8;
        return true;
    }

    public static void refreshEnterpriseAccountStatus(final Context r1, final EnterpriseAccountCallback r2) {
        if (r1 != null) goto L6;
        notifyEnterpriseAccountResult(r2, false);
        return;
    L6:
        if (r1.getApplicationContext() == null) goto L8;
        r1 = r1.getApplicationContext();
    L8:
        ThreadUtils.postOnBackgroundThread(new SystemIntelligentFragment$$ExternalSyntheticLambda15(r1, r2));
    }

    static /* synthetic */ void lambda$refreshEnterpriseAccountStatus$6(Context r1, EnterpriseAccountCallback r2) {
        boolean r3 = queryEnterpriseAccount(r1);
        sIsEnterpriseAccount = r3;
        sHasEnterpriseAccountCache = true;
        notifyEnterpriseAccountResult(r2, r3);
    }

    static /* synthetic */ void lambda$notifyEnterpriseAccountResult$7(EnterpriseAccountCallback r0, boolean r1) {
        r0.onResult(r1);
    }

    private static void notifyEnterpriseAccountResult(final EnterpriseAccountCallback r1, final boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        ThreadUtils.postOnMainThread(new SystemIntelligentFragment$$ExternalSyntheticLambda4(r1, r2));
    }

    private static boolean queryEnterpriseAccount(Context r4) {
        if (r4 != null) goto L14;
        return false;
    L14:
        Bundle r5 = r4.getContentResolver().call(Uri.parse(ASSISTANT_ACCOUNT_INFO_PROVIDER), METHOD_QUERY_ACCOUNT_INFO, null, null);     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        if (r5.getBoolean(KEY_IS_ENTERPRISE, false) == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        OLog.w(STATIC_TAG, "isEnterpriseAccount failed", e);
        return false;
    }

    private void registerAccountChange() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mAssistantAccountObserver != null) goto L16;
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mAssistantAccountObserver = new AnonymousClass11(this, r1);
        this.mContext.getContentResolver().registerContentObserver(Uri.parse(ASSISTANT_ACCOUNT_INFO_OBSERVER_URI), false, this.mAssistantAccountObserver);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        OLog.w(this.TAG, "registerAccountChange failed", e);
        this.mAssistantAccountObserver = null;
        return;
    }

    private void unregisterAccountChange() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mAssistantAccountObserver != null) goto L19;
        return;
    L19:
        this.mContext.getContentResolver().unregisterContentObserver(this.mAssistantAccountObserver);     // Catch: Throwable -> L10 Exception -> L12
    L9:
        this.mAssistantAccountObserver = null;
        return;
    L12:
        e = move-exception;
        OLog.w(this.TAG, "unregisterAccountChange failed", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mAssistantAccountObserver = null;
        throw th;
    }

    private void refreshWhenAssistantAccountChanged() {
        refreshEnterpriseAccountStatus(this.mContext, new SystemIntelligentFragment$$ExternalSyntheticLambda6(this));
    }

    /* JADX INFO: renamed from: lambda$refreshWhenAssistantAccountChanged$8$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m509xf0b25765(boolean r4) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        DoubaoAssistantEnabler r0 = this.mDoubaoEnabler;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        updateAssistantMemoryVisibility(r1, !r4);
        if (this.titleBarRightBtn == null) goto L19;
        OPopover r2 = this.mPopover;
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.isShowing() == false) goto L21;
        this.mPopover.dismiss();
        showAssistantMenuInternal(this.titleBarRightBtn, !r4);
        return;
    L21:
        return;
    L19:
        return;
    L8:
        if (r0.isEnabled() == false) goto L10;
        r1 = true;
        goto L11
    }

    private void routeToDoubaoAssistantImprovementPlan() {
        Intent r0 = getAssistSettingIntent();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.putExtra("sub_page", "privacy_model_training");
        Utils.startActivity(getActivity(), r0);
    }

    private DefaultAppInfo getDefaultAppInfo() {
        ComponentName r0 = this.mAssistUtils.getAssistComponentForUser(UserHandle.myUserId());
        if (r0 != null) goto L6;
        return null;
    L6:
        PackageManager r1 = getContext().getPackageManager();
        return new DefaultAppInfo(this.mContext, r1, UserHandle.myUserId(), r0);
    }

    private Intent getAssistSettingIntent() {
        ComponentName r0 = new ComponentName("com.larus.nova", "com.obric.sva.sdk.service.ObricInteractionService2");
        OLog.d(this.TAG, "cn:" + r0);
        Intent r1 = new Intent("android.service.voice.VoiceInteractionService").setPackage(r0.getPackageName());
        PackageManager r2 = getContext().getPackageManager();
        List<ResolveInfo> r3 = r2.queryIntentServices(r1, 128);
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if (r3.isEmpty() == true) goto L12;
        String r4 = getAssistSettingsActivity(r0, r3.get(0), r2);
        OLog.d(this.TAG, "activity:" + r4);
        if (r4 != null) goto L11;
        return null;
    L11:
        return new Intent("android.intent.action.MAIN").setComponent(new ComponentName(r0.getPackageName(), r4));
    }

    private String getAssistSettingsActivity(ComponentName r1, ResolveInfo r2, PackageManager r3) {
        VoiceInteractionServiceInfo r0 = new VoiceInteractionServiceInfo(r3, r2.serviceInfo);
        if (r0.getSupportsAssist() == true) goto L7;
        return null;
    L7:
        return r0.getSettingsActivity();
    }

    private void changeAlwaysOnTileService(boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L5;
        int r2 = 0;
    L6:
        OCardListItem r3 = this.mAssistantMemory;
        if (r6 == true) goto L9;
    L11:
        r0 = 8;
    L12:
        r3.setVisibility(r0);
        if (r6 == true) goto L15;
        disableAlwaysOnTileService();
        this.mAILab.setVisibility(r2);
    L16:
        updateItemBackground();
        return;
    L15:
        OLog.i(this.TAG, "changeAlwaysOnTileService true");
        getAILabState(true);
        goto L16
    L9:
        if (shouldShowNonEnterpriseAccountItems(this.mContext) == false) goto L11;
    L5:
        r2 = 8;
        goto L6
    }

    private void updateAssistantMemoryVisibility(boolean r2, boolean r3) {
        OCardListItem r0 = this.mAssistantMemory;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        r0.setVisibility(r4);
        updateItemBackground();
        return;
    L8:
        r4 = 8;
        goto L9
    }

    private void disableAlwaysOnTileService() {
        OLog.i(this.TAG, "disableAlwaysOnTileService");
        ComponentName r2 = new ComponentName("com.obric.recorder", "com.bytedanceos.recorder.alwayson.tile.AlwaysOnTileService");     // Catch: Exception -> L5
        getContext().getPackageManager().setComponentEnabledSetting(r2, 2, 1);     // Catch: Exception -> L5
    L14:
        ComponentName r3 = new ComponentName("com.obric.lifelog", "com.obric.lifelog.ui.startup.LifelogStartupActivity");     // Catch: Exception -> L9
        getContext().getPackageManager().setComponentEnabledSetting(r3, 2, 1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        OLog.e(this.TAG, "enableLifelogComponent error", e);
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "enableAlwaysOnTileService error", e);
        goto L14
    }

    public void com_android_settings_intelligent_SystemIntelligentFragment__onResume$___twin___() {
        super.onResume();
        OLog.i(this.TAG, "onResume");
        DoubaoAssistantEnabler r0 = this.mDoubaoEnabler;
        if (r0 == null) goto L9;
        r0.updateView();
        OCardListItem r1 = this.mAssistantEnable;
        if (this.mDoubaoEnabler.isEnabled() == false) goto L7;
        int r2 = 8;
    L8:
        r1.setVisibility(r2);
        this.titleBarRightBtn.setEnabled(this.mDoubaoEnabler.isEnabled());
        changeAlwaysOnTileService(this.mDoubaoEnabler.isEnabled());
        goto L9
    L7:
        r2 = 0;
    L9:
        getAILabState(false);
        registerScreenMemoryObserver();
        registerAccountChange();
        refreshWhenAssistantAccountChanged();
    }

    private void setDoubaoAssistantEnabled(boolean r2) {
        DoubaoAssistantEnabler r0 = this.mDoubaoEnabler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.updateSwitchView(r2);
        if (r2 == false) goto L8;
        this.mDoubaoEnabler.setEnabled(true);
        changeAlwaysOnTileService(true);
        return;
    L8:
        showDisableAssistantDialog();
    }

    private void showDisableAssistantDialog() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getContext() != null) goto L8;
        return;
    L8:
        if (this.mDoubaoDisableDialog != null) goto L11;
        this.mDoubaoDisableDialog = new OAlertDialogBuilder(getContext()).title(R.string.doubao_assistant_disable_dlg_title).message(R.string.doubao_assistant_disable_dlg_text).overrideButtonStyleController(new SystemIntelligentFragment$$ExternalSyntheticLambda16()).horizontalButton().negativeButton(R.string.doubao_assistant_disable_dlg_close, new AnonymousClass13(this)).positiveButton(R.string.doubao_assistant_disable_dlg_open, new AnonymousClass12(this)).build();
    L11:
        if (this.mDoubaoDisableDialog.isShowing() == true) goto L15;
        this.mDoubaoDisableDialog.show();
        return;
    }

    static /* synthetic */ ButtonStyleController lambda$showDisableAssistantDialog$9(Context r1, Integer r2) {
        return new ColorButtonStyleController(r1, r2.intValue()).positiveColor(R.color.oui_text_1, -1).negativeColor(R.color.oui_functional_red_6, -1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OAlertDialog r0 = this.mDoubaoDisableDialog;
        if (r0 != null) goto L5;
    L7:
        unregisterAccountChange();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDoubaoDisableDialog.dismiss();
        this.mDoubaoDisableDialog = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OAlertDialog r0 = this.mDoubaoDisableDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mDoubaoDisableDialog.dismiss();
        this.mDoubaoDisableDialog = null;
        return;
    }

    private void registerScreenMemoryObserver() {
        final Handler r3 = null;
        getContext().getContentResolver().registerContentObserver(Uri.parse(URI_STATUS), false, new AnonymousClass14(this, r3));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        OLog.i(this.TAG, "registerScreenMemoryObserver error=" + th);
    }

    private void updateAILabUi(final int r2, final int r3) {
        ThreadUtils.postOnMainThread(new SystemIntelligentFragment$$ExternalSyntheticLambda3(this, r3, r2));
    }

    /* JADX INFO: renamed from: lambda$updateAILabUi$10$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m513xc6120d76(int r6, int r7) {
        int r0 = 0;
        boolean r1 = true;
        if (r6 == 1) goto L5;
    L12:
        r1 = false;
    L13:
        OLog.i(this.TAG, "updateAILabUi status=" + r7 + ",permission=" + r6 + "visible=" + r1);
        OCardListItem r8 = this.mAILab;
        if (r8 == null) goto L19;
        if (r1 == true) goto L18;
        r0 = 8;
    L18:
        r8.setVisibility(r0);
    L19:
        updateItemBackground();
        return;
    L5:
        if (r7 == 4) goto L12;
        if (r7 == 0) goto L12;
        DoubaoAssistantEnabler r2 = this.mDoubaoEnabler;
        if (r2 == null) goto L12;
        if (r2.isEnabled() == false) goto L12;
        goto L12
    }

    private Integer readStatus(ContentProviderClient r8, Uri r9) throws RemoteException {
        Integer r7 = null;
        Cursor r10 = r8.query(r9, null, null, null, null);     // Catch: Throwable -> L17
        if (r10 != null) goto L21;
    L15:
        closeQuietly(r10);
        return null;
    L21:
    L13:
        Throwable th = th;
    L19:
        closeQuietly(r10);
        throw th;
    L6:
        if (r10.moveToFirst() == false) goto L15;
        int r11 = r10.getColumnIndex("status");     // Catch: Throwable -> L13
        if (r11 < 0) goto L11;
        r7 = Integer.valueOf(r10.getInt(r11));     // Catch: Throwable -> L13
    L11:
        closeQuietly(r10);
        return r7;
    L17:
        th = move-exception;
        r10 = null;
        th = th;
        goto L19
    }

    private static void closeQuietly(AutoCloseable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }

    private void releaseQuietly(ContentProviderClient r1) {
        if (r1 != null) goto L7;
        return;
    L7:
        r1.close();     // Catch: Throwable -> L6
        return;
    }

    private void getAILabState(final boolean r3) {
        final Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        ThreadUtils.postOnBackgroundThread(new SystemIntelligentFragment$$ExternalSyntheticLambda7(this, r0, r3));
    }

    /* JADX INFO: renamed from: lambda$getAILabState$16$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m505xeb721082(Context r12, boolean r13) {
        Uri r5 = Uri.parse(URI_STATUS);
        Uri r6 = Uri.parse(URI_PERMISSION_STATUS);
        ContentProviderClient r10 = null;
        r10 = r12.getContentResolver().acquireUnstableContentProviderClient(r5);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        if (r10 != null) goto L11;
        OLog.i(this.TAG, "getAILabState provider client null, delayToTry=" + r13);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        if (r13 == false) goto L8;
        ThreadUtils.postOnBackgroundThreadDelayed(new SystemIntelligentFragment$$ExternalSyntheticLambda8(this), 1000);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
    L9:
        releaseQuietly(r10);
        return;
    L8:
        updateAILabUi(0, 0);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        goto L9
    L11:
        Integer r14 = readStatus(r10, r5);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        Integer r4 = readStatus(r10, r6);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        if (r14 == null) goto L17;
        if (r4 == null) goto L17;
        updateAILabUi(r14.intValue(), r4.intValue());     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
    L16:
        releaseQuietly(r10);
        return;
    L17:
        OLog.i(this.TAG, "getAILabState cursor invalid, delayToTry=" + r13);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
        if (r13 == false) goto L20;
        ThreadUtils.postOnBackgroundThreadDelayed(new SystemIntelligentFragment$$ExternalSyntheticLambda9(this), 1000);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
    L21:
        releaseQuietly(r10);
        return;
    L20:
        updateAILabUi(0, 0);     // Catch: Throwable -> L23 RemoteException -> L28 DeadObjectException -> L33
    L40:
        th = move-exception;
        releaseQuietly(null);
        throw th;
    L23:
        th = move-exception;
        if (r13 == false) goto L26;
        ThreadUtils.postOnBackgroundThreadDelayed(new SystemIntelligentFragment$$ExternalSyntheticLambda12(this), 1000);     // Catch: Throwable -> L40
    L27:
        OLog.e(this.TAG, "初始化权限逻辑失败:" + th.getMessage());     // Catch: Throwable -> L40
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
        goto L16
    L26:
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
    L33:
        e = move-exception;
        if (r13 == false) goto L36;
        ThreadUtils.postOnBackgroundThreadDelayed(new SystemIntelligentFragment$$ExternalSyntheticLambda10(this), 1000);     // Catch: Throwable -> L40
    L37:
        OLog.e(this.TAG, "getAILabState DeadObjectException: " + e.getMessage());     // Catch: Throwable -> L40
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
        goto L16
    L36:
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
    L28:
        e = move-exception;
        if (r13 == false) goto L31;
        ThreadUtils.postOnBackgroundThreadDelayed(new SystemIntelligentFragment$$ExternalSyntheticLambda11(this), 1000);     // Catch: Throwable -> L40
    L32:
        OLog.e(this.TAG, "getAILabState RemoteException: " + e.getMessage());     // Catch: Throwable -> L40
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
        goto L16
    L31:
        updateAILabUi(0, 0);     // Catch: Throwable -> L40
        goto L32
    }

    /* JADX INFO: renamed from: lambda$getAILabState$11$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m500xcd5f17a7() {
        getAILabState(false);
    }

    /* JADX INFO: renamed from: lambda$getAILabState$12$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m501xd362e306() {
        getAILabState(false);
    }

    /* JADX INFO: renamed from: lambda$getAILabState$13$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m502xd966ae65() {
        getAILabState(false);
    }

    /* JADX INFO: renamed from: lambda$getAILabState$14$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m503xdf6a79c4() {
        getAILabState(false);
    }

    /* JADX INFO: renamed from: lambda$getAILabState$15$com-android-settings-intelligent-SystemIntelligentFragment, reason: not valid java name */
    /* synthetic */ void m504xe56e4523() {
        getAILabState(false);
    }

    private Intent getSmartNotificationSettingActivity() {
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName(Constants.PKG_ORIGINAL_SMARTNOTIFICATION, Constants.PKG_ORIGINAL_SMARTNOTIFICATION_CLASS_NAME));
        r3.setPackage(Constants.PKG_ORIGINAL_SMARTNOTIFICATION);
        return r3;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SystemIntelligentFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_SystemIntelligentFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SystemIntelligentFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_SystemIntelligentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SystemIntelligentFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_SystemIntelligentFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
