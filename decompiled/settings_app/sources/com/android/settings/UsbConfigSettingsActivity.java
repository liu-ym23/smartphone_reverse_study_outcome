package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.deviceinfo.UsbBackend;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.utils.StyleUtil;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UsbConfigSettingsActivity extends BaseActivity {
    public static final int[] DEFAULT_MODES = null;
    protected static final String TAG = "UsbConfigSettingsActivity";
    private BaseAdapter mAdapter;
    private UsbBackend mBackend;
    private int mCurrentMode;
    private BroadcastReceiver mDisconnectedReceiver;
    private ListView mOptionsList;
    private List<UsbConfigItem> mUsbConfigList;
    private boolean mUsbConnected;
    private OCardListItem mUsbSource;
    private OSwitch mUsbSourceSwitch;

    private class OptionsAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        final /* synthetic */ UsbConfigSettingsActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public OptionsAdapter(UsbConfigSettingsActivity r1) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r1.mActivity);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return UsbConfigSettingsActivity.access$500(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, final View r8, final ViewGroup r9) {
            if (r8 != null) goto L5;
        L8:
            r8 = this.mInflater.inflate(R.layout.list_content_item_check_oui_2, r9, false);
            OCardListItem r1 = (OCardListItem) r8.findViewById(R.id.item_check);
            r8.setTag(r1);
        L9:
            UsbConfigItem r2 = (UsbConfigItem) UsbConfigSettingsActivity.access$500(this.this$0).get(r7);
            r1.setTitle(this.this$0.getString(r2.titleId));
            if (r7 != 0) goto L12;
            r1.setEnabled(!UsbConfigSettingsActivity.access$400(this.this$0).isChecked());
        L13:
            r1.setDefaultCustomEndView(2);
            if (r2.value != UsbConfigSettingsActivity.access$200(this.this$0)) goto L16;
            r1.showCustomEnd(true);
        L17:
            r1.setOnContentClickListener(new UsbConfigSettingsActivity$OptionsAdapter$$ExternalSyntheticLambda0(this, r9, r7, r8));
            if (r7 == 0) goto L20;
        L22:
            if (r7 != 0) goto L25;
            r1.setCardPosition(1);
        L28:
            return r8;
        L25:
            if (r7 != (getCount() - 1)) goto L27;
            r1.setCardPosition(3);
            goto L28
        L27:
            r1.setCardPosition(2);
            goto L28
        L20:
            if (getCount() != 1) goto L22;
            r1.setCardPosition(0);
            goto L28
        L16:
            r1.showCustomEnd(false);
            goto L17
        L12:
            r1.setEnabled(UsbConfigSettingsActivity.access$000(this.this$0));
            goto L13
        L5:
            if ((r8.getTag() instanceof OCardListItem) == false) goto L8;
            r1 = (OCardListItem) r8.getTag();
            goto L9
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-UsbConfigSettingsActivity$OptionsAdapter, reason: not valid java name */
        /* synthetic */ void m213xc887e143(ViewGroup r7, int r8, View r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L8;
            ListView r1 = (ListView) r7;
            AdapterView.OnItemClickListener r0 = r1.getOnItemClickListener();
            if (r0 == null) goto L9;
            OLog.d(UsbConfigSettingsActivity.TAG, "onItemClick: finalPosition=" + r8);
            r0.onItemClick(r1, r9, r8, getItemId(r8));
            return;
        L9:
            return;
        }
    }

    private class UsbConfigItem {
        final /* synthetic */ UsbConfigSettingsActivity this$0;
        int titleId;
        int value;

        public UsbConfigItem(UsbConfigSettingsActivity r1, int r2, int r3) {
            this.this$0 = r1;
            this.titleId = r2;
            this.value = r3;
        }
    }

    public void com_android_settings_UsbConfigSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_UsbConfigSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UsbConfigSettingsActivity() {
        this.mUsbConfigList = new ArrayList();
        this.mDisconnectedReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ boolean access$000(UsbConfigSettingsActivity r0) {
        return r0.mUsbConnected;
    }

    static /* synthetic */ boolean access$002(UsbConfigSettingsActivity r0, boolean r1) {
        r0.mUsbConnected = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$100(UsbConfigSettingsActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$200(UsbConfigSettingsActivity r0) {
        return r0.mCurrentMode;
    }

    static /* synthetic */ int access$202(UsbConfigSettingsActivity r0, int r1) {
        r0.mCurrentMode = r1;
        return r1;
    }

    static /* synthetic */ UsbBackend access$300(UsbConfigSettingsActivity r0) {
        return r0.mBackend;
    }

    static /* synthetic */ OSwitch access$400(UsbConfigSettingsActivity r0) {
        return r0.mUsbSourceSwitch;
    }

    static /* synthetic */ List access$500(UsbConfigSettingsActivity r0) {
        return r0.mUsbConfigList;
    }

    static {
        DEFAULT_MODES = new int[]{0, 2, 4, 6};
    }

    public void com_android_settings_UsbConfigSettingsActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        if (Utils.isMonkeyRunning() == false) goto L6;
        finish();
        return;
    L6:
        setContentView(R.layout.options_usb_layout);
        this.mOptionsList = (ListView) findViewById(R.id.options_list);
        OCardListItem r7 = (OCardListItem) StyleUtil.createWidgetWithStyle(this, R.style.OCardListItemSwitchSingle, new AnonymousClass2(this));
        this.mUsbSource = r7;
        r7.setTitle(getString(R.string.sm_usb_use_power_only));
        int r3 = 0;
        this.mOptionsList.addFooterView(LayoutInflater.from(this).inflate(R.layout.item_sub_settings_padding_layout2, this.mOptionsList, false));
        this.mOptionsList.addFooterView(this.mUsbSource);
        this.mUsbSource.setDefaultCustomEndView(1);
        this.mUsbSourceSwitch = this.mUsbSource.getEndSwitch();
        OptionsAdapter r8 = new OptionsAdapter(this);
        this.mAdapter = r8;
        this.mOptionsList.setAdapter(r8);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass3(this));
        this.mUsbSourceSwitch.setOnClickListener(new AnonymousClass4(this));
        UsbBackend r9 = new UsbBackend(this);
        this.mBackend = r9;
        this.mCurrentMode = r9.getCurrentMode();
        if (this.mBackend.getPowerRole() != 1) goto L9;
        this.mUsbSourceSwitch.setChecked(true);
    L10:
        boolean r10 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_usb_file_transfer");
    L11:
        int[] r0 = DEFAULT_MODES;
        if (r3 >= r0.length) goto L23;
        if (r10 == false) goto L20;
        int r1 = r0[r3];
        if (r1 == 2) goto L22;
        if (r1 != 4) goto L20;
    L22:
        r3 = r3 + 1;
    L20:
        if (this.mBackend.isModeDisplaySupported(r0[r3]) == false) goto L22;
        this.mUsbConfigList.add(new UsbConfigItem(this, getTitle(r0[r3]), r0[r3]));
        goto L22
    L23:
        setupBackBtnOnTitle();
        return;
    L9:
        this.mUsbSourceSwitch.setChecked(false);
        goto L10
    }

    public void com_android_settings_UsbConfigSettingsActivity__onResume$___twin___() {
        super.onResume();
        this.mCurrentMode = this.mBackend.getCurrentMode();
        this.mAdapter.notifyDataSetChanged();
    }

    public void com_android_settings_UsbConfigSettingsActivity__onStart$___twin___() {
        super.onStart();
        IntentFilter r0 = new IntentFilter("android.hardware.usb.action.USB_STATE");
        r0.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mDisconnectedReceiver, r0, 2);
    }

    public void com_android_settings_UsbConfigSettingsActivity__onStop$___twin___() {
        unregisterReceiver(this.mDisconnectedReceiver);
        super.onStop();
    }

    private static int getTitle(int r2) {
        OLog.d(TAG, "usb current mode = " + r2);
        if (r2 != 1) goto L5;
        return R.string.sm_usb_use_power_only;
    L5:
        if (r2 != 2) goto L7;
        return R.string.usb_use_file_transfers;
    L7:
        if (r2 != 4) goto L9;
        return R.string.usb_use_photo_transfers;
    L9:
        if (r2 != 6) goto L11;
        return R.string.sm_usb_use_MIDI;
    L11:
        if (r2 != 8) goto L13;
        return R.string.usb_tethering_title;
    L13:
        if (r2 == 10) goto L16;
        return R.string.sm_usb_use_charging_only;
    L16:
        return R.string.sm_usb_use_audio_source;
    }

    public static int getCurrentUsbConfigTitle(Context r1) {
        return getTitle(new UsbBackend(r1).getCurrentDataMode());
    }

    public static boolean getCurrentUsbIsSource(Context r1) {
        if (new UsbBackend(r1).getPowerRole() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_UsbConfigSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UsbConfigSettingsActivity r1) {
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(UsbConfigSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UsbConfigSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_UsbConfigSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UsbConfigSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UsbConfigSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UsbConfigSettingsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UsbConfigSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_UsbConfigSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UsbConfigSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_UsbConfigSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStart(UsbConfigSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UsbConfigSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_UsbConfigSettingsActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(UsbConfigSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UsbConfigSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_UsbConfigSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UsbConfigSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(UsbConfigSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UsbConfigSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_UsbConfigSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UsbConfigSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UsbConfigSettingsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_UsbConfigSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(UsbConfigSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UsbConfigSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_UsbConfigSettingsActivity__onStop$___twin___();
    }
}
