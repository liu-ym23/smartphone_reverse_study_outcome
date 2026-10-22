package com.android.settings.notification.zen;

import android.app.AutomaticZenRule;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.SystemZenRules;
import android.service.notification.ZenModeConfig;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.oui.button.OIconButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.widget.VerticalSpaceItemDecoration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeAutomationFragment extends BaseFragment {
    public static final String DELETE = "DELETE_RULE";
    private static final Comparator<ZenRuleInfo> RULE_TYPE_COMPARATOR = null;
    private static final String TAG = "ZenModeAutomationFragment";
    private static NotificationManager mNm;
    private OSelectionDialog mAddRuleDialog;
    private ZenModeBackend mBackend;
    private Context mContext;
    private boolean[] mDeleteDialogChecked;
    private String[] mDeleteDialogRuleIds;
    private CharSequence[] mDeleteDialogRuleNames;
    private OEditText mOEditor;
    private PackageManager mPm;
    private Map.Entry<String, AutomaticZenRule>[] mRules;
    private ZenServiceListing mServiceListing;
    private final ZenServiceListing.Callback mServiceListingCallback;
    private List<ZenRuleInfo> mZenRuleInfoList;
    private ZenModeRuleAdapter ruleAdapter;
    private ListView ruleList;

    class ZenModeRuleAdapter extends BaseAdapter {
        final /* synthetic */ ZenModeAutomationFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        ZenModeRuleAdapter(ZenModeAutomationFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ZenModeAutomationFragment.access$1600(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return ZenModeAutomationFragment.access$1600(this.this$0)[r1];
        }

        @Override // android.widget.Adapter
        public View getView(final int r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L5;
            r7 = View.inflate(this.this$0.getActivity(), R.layout.card_list_item_oui, null);
            final OCardListItem r1 = (OCardListItem) r7.findViewById(R.id.item_text);
            r1.setDefaultCustomEndView(1);
            r1.showCustomEnd(true);
            r7.setTag(r1);
        L7:
            if (r6 != 0) goto L9;
            r7.setPadding(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, 0);
        L9:
            r1.setTitle(((AutomaticZenRule) ZenModeAutomationFragment.access$1600(this.this$0)[r6].getValue()).getName());
            r1.setSwipeView(R.layout.layout_card_list_item_delete_swip);
            r1.setEnableSwipe(true);
            if (r1.getSwipeView() == null) goto L12;
            ((OIconButton) r1.getSwipeView().findViewById(R.id.btn_delete)).setOnClickListener(new AnonymousClass1(this, r6, r1));
        L12:
            OCardListItemUtils.setOnCheckedChangeListener(r1, null);
            OCardListItemUtils.setChecked(r1, ((AutomaticZenRule) ZenModeAutomationFragment.access$1600(this.this$0)[r6].getValue()).isEnabled());
            OCardListItemUtils.setOnCheckedChangeListener(r1, new AnonymousClass2(this, r6));
            r1.setOnContentClickListener(new AnonymousClass3(this, r6));
            if (ZenModeAutomationFragment.access$1600(this.this$0).length != 1) goto L15;
            r1.setCardPosition(0);
        L21:
            return r7;
        L15:
            if (r6 != 0) goto L18;
            r1.setCardPosition(1);
            goto L21
        L18:
            if (r6 != (ZenModeAutomationFragment.access$1600(this.this$0).length - 1)) goto L20;
            r1.setCardPosition(3);
            goto L21
        L20:
            r1.setCardPosition(2);
            goto L21
        L5:
            r1 = (OCardListItem) r7.getTag();
            goto L7
        }
    }

    public void com_android_settings_notification_zen_ZenModeAutomationFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ZenModeAutomationFragment() {
        this.mZenRuleInfoList = new ArrayList();
        this.mServiceListingCallback = new AnonymousClass9(this);
    }

    static /* synthetic */ ZenServiceListing access$000(ZenModeAutomationFragment r0) {
        return r0.mServiceListing;
    }

    static /* synthetic */ List access$100(ZenModeAutomationFragment r0) {
        return r0.mZenRuleInfoList;
    }

    static /* synthetic */ void access$1000(ZenModeAutomationFragment r0) {
        r0.getRules();
    }

    static /* synthetic */ ZenModeRuleAdapter access$1100(ZenModeAutomationFragment r0) {
        return r0.ruleAdapter;
    }

    static /* synthetic */ Comparator access$1200() {
        return RULE_TYPE_COMPARATOR;
    }

    static /* synthetic */ PackageManager access$1300(ZenModeAutomationFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ NotificationManager access$1400() {
        return mNm;
    }

    static /* synthetic */ void access$1500(ZenModeAutomationFragment r0, Set r1) {
        r0.bindExternalRules(r1);
    }

    static /* synthetic */ Map.Entry[] access$1600(ZenModeAutomationFragment r0) {
        return r0.mRules;
    }

    static /* synthetic */ ZenRuleInfo access$200(ZenModeAutomationFragment r0) {
        return r0.defaultNewEvent();
    }

    static /* synthetic */ ZenRuleInfo access$300(ZenModeAutomationFragment r0) {
        return r0.defaultNewSchedule();
    }

    static /* synthetic */ ZenServiceListing.Callback access$400(ZenModeAutomationFragment r0) {
        return r0.mServiceListingCallback;
    }

    static /* synthetic */ OSelectionDialog access$500(ZenModeAutomationFragment r0) {
        return r0.mAddRuleDialog;
    }

    static /* synthetic */ OSelectionDialog access$502(ZenModeAutomationFragment r0, OSelectionDialog r1) {
        r0.mAddRuleDialog = r1;
        return r1;
    }

    static /* synthetic */ OSelectionDialog access$600(ZenModeAutomationFragment r0) {
        return r0.zenModeAddRuleDialog();
    }

    static /* synthetic */ View access$700(ZenModeAutomationFragment r0) {
        return r0.genContentView();
    }

    static /* synthetic */ OEditText access$800(ZenModeAutomationFragment r0) {
        return r0.mOEditor;
    }

    static /* synthetic */ OEditText access$802(ZenModeAutomationFragment r0, OEditText r1) {
        r0.mOEditor = r1;
        return r1;
    }

    static /* synthetic */ ZenModeBackend access$900(ZenModeAutomationFragment r0) {
        return r0.mBackend;
    }

    public void com_android_settings_notification_zen_ZenModeAutomationFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mBackend = ZenModeBackend.getInstance(getContext());
        getRules();
        this.mPm = getContext().getPackageManager();
        ZenServiceListing r4 = new ZenServiceListing(getContext(), null);
        this.mServiceListing = r4;
        r4.reloadApprovedServices();
        Context r5 = getContext();
        this.mContext = r5;
        mNm = (NotificationManager) r5.getSystemService("notification");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.zen_mode_layout, r3, false);
        this.ruleList = (ListView) this.mRootView.findViewById(R.id.zen_mode_rule);
        ZenModeRuleAdapter r5 = new ZenModeRuleAdapter(this);
        this.ruleAdapter = r5;
        this.ruleList.setAdapter(r5);
        ((OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title)).addEndAction(R.drawable.oui_icon_oic_plus, -1, new AnonymousClass1(this));
        return this.mRootView;
    }

    private OSelectionDialog zenModeAddRuleDialog() {
        OSelectionDialog.Modifier r6 = new OSelectionDialog.Modifier(getString(R.string.zen_mode_choose_rule_type), "", new AnonymousClass2(this), null, new OBaseDialog.ButtonConfig(getString(R.string.cancel), new AnonymousClass3(this), null));
        OSelectionDialog r0 = new OSelectionDialog(this.mContext, r6);
        r0.setOnDismissListener(new AnonymousClass4(this));
        return r0;
    }

    private int getTitleResource(Uri r1, boolean r2) {
        boolean r0 = ZenModeConfig.isValidEventConditionId(r1);
        boolean r3 = ZenModeConfig.isValidScheduleConditionId(r1);
        if (r2 == false) goto L8;
        if (r0 == false) goto L6;
        return R.string.zen_mode_add_event_rule;
    L6:
        if (r3 == false) goto L8;
        return R.string.zen_mode_add_time_rule;
    L8:
        return R.string.zen_mode_rule_name;
    }

    private void showRenameDialog(final ZenRuleInfo r10) {
        OSimpleFormDialog.Modifier r7 = new OSimpleFormDialog.Modifier(getString(getTitleResource(r10.defaultConditionId, true)), "", new OSimpleFormDialog.InputViewConfig(true, false, new AnonymousClass5(this)), new OSimpleFormDialog.InputViewConfig(false, false, null), new OBaseDialog.ButtonConfig(getString(R.string.menu_ok_confirm), new AnonymousClass6(this, r10), null), new OBaseDialog.ButtonConfig(getString(R.string.menu_cancel_confirm), new AnonymousClass7(this), null));
        new OSimpleFormDialog(this.mContext, r7).show();
    }

    static {
        RULE_TYPE_COMPARATOR = new AnonymousClass8();
    }

    public static ZenRuleInfo getRuleInfo(PackageManager r7, ComponentInfo r8) {
        ComponentName r0 = null;
        if (r8 != null) goto L5;
    L25:
        return null;
    L5:
        if (r8.metaData == null) goto L25;
        boolean r1 = r8 instanceof ServiceInfo;
        if (r1 == false) goto L10;
        String r2 = r8.metaData.getString("android.service.zen.automatic.ruleType");
    L11:
        ComponentName r3 = getSettingsActivity(r7, null, r8);
        if (r2 == null) goto L25;
        if (r2.trim().isEmpty() == true) goto L25;
        if (r3 == null) goto L25;
        ZenRuleInfo r4 = new ZenRuleInfo();
        if (r1 == false) goto L19;
        r0 = new ComponentName(r8.packageName, r8.name);
    L19:
        r4.serviceComponent = r0;
        r4.settingsAction = "android.settings.ZEN_MODE_EXTERNAL_RULE_SETTINGS";
        r4.title = r2;
        r4.packageName = r8.packageName;
        r4.configurationActivity = r3;
        r4.packageLabel = r8.applicationInfo.loadLabel(r7);
        if (r1 == false) goto L22;
        int r9 = r8.metaData.getInt("android.service.zen.automatic.ruleInstanceLimit", -1);
    L23:
        r4.ruleInstanceLimit = r9;
        return r4;
    L22:
        r9 = r8.metaData.getInt("android.service.zen.automatic.ruleInstanceLimit", -1);
        goto L23
    L10:
        r2 = r8.metaData.getString("android.service.zen.automatic.ruleType");
        goto L11
    }

    private void bindExternalRules(Set<ZenRuleInfo> r1) {
        this.mZenRuleInfoList.addAll(r1);
    }

    private View genContentView() {
        RecyclerView r0 = new RecyclerView(getContext());
        r0.setOverScrollMode(2);
        r0.setLayoutManager(new LinearLayoutManager(getContext()));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.addItemDecoration(new VerticalSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.dimen_4dp)));
        SelectionDialogAdapter r1 = new SelectionDialogAdapter(getContext());
        r0.setAdapter(r1);
        r1.setItems(this.mZenRuleInfoList);
        r1.setOnItemClickListener(new ZenModeAutomationFragment$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$genContentView$0$com-android-settings-notification-zen-ZenModeAutomationFragment, reason: not valid java name */
    /* synthetic */ Unit m529x4031a414(ZenRuleInfo r1, Integer r2) {
        ZenRuleInfo r3 = this.mZenRuleInfoList.get(r2.intValue());
        if (r3.isSystem == false) goto L5;
        showRenameDialog(r3);
    L6:
        this.mAddRuleDialog.dismiss();
        return null;
    L5:
        startActivity(new Intent().setComponent(r3.configurationActivity));
        goto L6
    }

    private ZenRuleInfo defaultNewSchedule() {
        ZenModeConfig.ScheduleInfo r0 = new ZenModeConfig.ScheduleInfo();
        r0.days = ZenModeConfig.ALL_DAYS;
        r0.startHour = 22;
        r0.endHour = 7;
        ZenRuleInfo r1 = new ZenRuleInfo();
        r1.settingsAction = "android.settings.ZEN_MODE_EVENT_RULE_SETTINGS";
        r1.title = this.mContext.getString(R.string.zen_schedule_rule_type_name);
        r1.packageName = ZenModeConfig.getEventConditionProvider().getPackageName();
        r1.defaultConditionId = ZenModeConfig.toScheduleConditionId(r0);
        r1.type = 1;
        r1.defaultTriggerDescription = SystemZenRules.getTriggerDescriptionForScheduleTime(this.mContext, r0);
        r1.serviceComponent = ZenModeConfig.getScheduleConditionProvider();
        r1.isSystem = true;
        return r1;
    }

    private ZenRuleInfo defaultNewEvent() {
        ZenModeConfig.EventInfo r0 = new ZenModeConfig.EventInfo();
        r0.calName = null;
        r0.calendarId = null;
        r0.reply = 0;
        ZenRuleInfo r1 = new ZenRuleInfo();
        r1.settingsAction = "android.settings.ZEN_MODE_EVENT_RULE_SETTINGS";
        r1.title = this.mContext.getString(R.string.zen_event_rule_type_name);
        r1.packageName = ZenModeConfig.getScheduleConditionProvider().getPackageName();
        r1.defaultConditionId = ZenModeConfig.toEventConditionId(r0);
        r1.type = 2;
        r1.defaultTriggerDescription = SystemZenRules.getTriggerDescriptionForScheduleEvent(this.mContext, r0);
        r1.serviceComponent = ZenModeConfig.getEventConditionProvider();
        r1.isSystem = true;
        return r1;
    }

    protected Intent getRuleIntent(String r2, ComponentName r3, String r4) {
        Intent r1 = new Intent().addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM).putExtra("android.service.notification.extra.RULE_ID", r4).putExtra("android.app.extra.AUTOMATIC_RULE_ID", r4);
        if (r3 == null) goto L5;
        r1.setComponent(r3);
    L6:
        return r1;
    L5:
        r1.setAction(r2);
        r1.setPackage("com.android.settings");
        goto L6
    }

    protected static ComponentName getSettingsActivity(PackageManager r6, AutomaticZenRule r7, ComponentInfo r8) {
        if (r7 == null) goto L5;
        String r2 = r7.getPackageName();
    L7:
        if (r7 != null) goto L9;
    L11:
        if (r8 != null) goto L14;
    L12:
        ComponentName r9 = null;
    L21:
        if (r9 == null) goto L32;
        if (r2 == null) goto L32;
    L30:
        OLog.e(TAG, "Failed to find config activity");
        return null;
    L26:
        if (r6.getPackageUid(r2, 0) != r6.getPackageUid(r9.getPackageName(), 0)) goto L28;
        return r9;
    L28:
        OLog.w(TAG, "Config activity not in owner package for " + r7.getName());     // Catch: PackageManager.NameNotFoundException -> L30
        return null;
    L32:
        return r9;
    L14:
        if ((r8 instanceof ActivityInfo) == false) goto L17;
        r9 = new ComponentName(r8.packageName, r8.name);
        goto L21
    L17:
        if (r8.metaData == null) goto L12;
        String r10 = r8.metaData.getString("android.service.zen.automatic.configurationActivity");
        if (r10 == null) goto L12;
        r9 = ComponentName.unflattenFromString(r10);
        goto L21
    L9:
        if (r7.getConfigurationActivity() == null) goto L11;
        r9 = r7.getConfigurationActivity();
        goto L21
    L5:
        r2 = r8.packageName;
        goto L7
    }

    private void getRules() {
        ZenModeBackend r0 = this.mBackend;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mRules = r0.getAutomaticZenRules();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ZenModeAutomationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_zen_ZenModeAutomationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ZenModeAutomationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_zen_ZenModeAutomationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ZenModeAutomationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_zen_ZenModeAutomationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
