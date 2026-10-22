package com.android.settings.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import com.android.settings.MultiSimAdapter;
import com.android.settings.MultiSimSimStatus;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.about.status.AndroidVersionItemView;
import com.android.settings.about.status.BatteryItemView;
import com.android.settings.about.status.BatteryStatusItemView;
import com.android.settings.about.status.BluetoothAddressStatusItemView;
import com.android.settings.about.status.DataStateStatusItemView;
import com.android.settings.about.status.IpAddressStatusItemView;
import com.android.settings.about.status.MacAddressStatusItemView;
import com.android.settings.about.status.ModVersionStatusItemView;
import com.android.settings.about.status.NetworkTypeStatusItemView;
import com.android.settings.about.status.NumberStatusItemView;
import com.android.settings.about.status.OperatorNameStatusItemView;
import com.android.settings.about.status.RoamingStateStatusItemView;
import com.android.settings.about.status.ServiceStateStatusItemView;
import com.android.settings.about.status.SignalStrengthStatusItemView;
import com.android.settings.about.status.SimStatusHelper;
import com.android.settings.about.status.UpTimeStatusItemView;
import com.android.settings.base.BaseActivity;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.deviceinfo.MSimInfoHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: DeviceStatusActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/settings/about/DeviceStatusActivity;", "Lcom/android/settings/base/BaseActivity;", "()V", "mList", "", "Lcom/android/settings/about/DeviceStatusItemView;", "displaySimStatus", "", "simIndex", "", "initList", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStatusActivity extends BaseActivity {
    private final List<DeviceStatusItemView> mList;

    /* JADX INFO: renamed from: $r8$lambda$-_tzPHwpz5BtKr0WiBG_mO8ep98, reason: not valid java name */
    public static /* synthetic */ void m219$r8$lambda$_tzPHwpz5BtKr0WiBG_mO8ep98(DeviceStatusActivity r0, View r1) {
        initView$lambda$21(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$PF-oo6ssRYunj43niCgx_Xp1NAM, reason: not valid java name */
    public static /* synthetic */ void m220$r8$lambda$PFoo6ssRYunj43niCgx_Xp1NAM(DeviceStatusActivity r0, View r1) {
        initList$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xhRKQLIQLdUiYbCA_cEGAHQUSlI(DeviceStatusActivity r0, View r1) {
        initList$lambda$8$lambda$7(r0, r1);
    }

    public void com_android_settings_about_DeviceStatusActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_about_DeviceStatusActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_about_DeviceStatusActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_about_DeviceStatusActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DeviceStatusActivity() {
        this.mList = new ArrayList();
    }

    public void com_android_settings_about_DeviceStatusActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.device_status_new_layout);
        initList();
        initView();
    }

    private final void initList() {
        List<DeviceStatusItemView> r1 = this.mList;
        DeviceStatusActivity r15 = this;
        AttributeSet r4 = null;
        int r5 = 0;
        int r6 = 6;
        DefaultConstructorMarker r7 = null;
        ModVersionStatusItemView r8 = new ModVersionStatusItemView(r15, r4, r5, r6, r7);
        r8.initData(ResourceUtils.getString(R.string.mod_version), DeviceUtils.INSTANCE.getOSVersion());
        r8.setCardPosition(1);
        r1.add(r8);
        List<DeviceStatusItemView> r2 = this.mList;
        AndroidVersionItemView r9 = new AndroidVersionItemView(r15, r4, r5, r6, r7);
        r9.initData(ResourceUtils.getString(R.string.firmware_version), Build.VERSION.RELEASE + '|' + ResourceUtils.getString(R.string.secure_patch) + TokenParser.SP + Build.VERSION.SECURITY_PATCH);
        r2.add(r9);
        List<DeviceStatusItemView> r3 = this.mList;
        DeviceStatusItemView r10 = new DeviceStatusItemView(r15, null, 0, null, 192, 14, null);
        String r11 = ResourceUtils.getString(R.string.baseband_version);
        String r12 = DeviceUtils.INSTANCE.getBasebandSummary();
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r10.initData(r11, r12);
        r3.add(r10);
        List<DeviceStatusItemView> r13 = this.mList;
        AttributeSet r14 = null;
        int r16 = 0;
        Lifecycle r17 = null;
        int r18 = 14;
        DefaultConstructorMarker r19 = null;
        DeviceStatusItemView r20 = new DeviceStatusItemView(r15, r14, r16, r17, 213, r18, r19);
        r20.initData(ResourceUtils.getString(R.string.kernel_version), DeviceUtils.INSTANCE.getFormattedKernelVersion());
        r13.add(r20);
        List<DeviceStatusItemView> r21 = this.mList;
        DeviceStatusItemView r22 = new DeviceStatusItemView(r15, r14, r16, r17, 198, r18, r19);
        r22.initData(ResourceUtils.getString(R.string.build_date), DeviceUtils.INSTANCE.getBuildDate());
        r21.add(r22);
        int r110 = 6;
        DefaultConstructorMarker r111 = null;
        this.mList.add(new BatteryStatusItemView(r15, r14, r16, getLifecycle(), r110, r111));
        this.mList.add(new BatteryItemView(r15, r14, r16, getLifecycle(), r110, r111));
        String r23 = null;
        Bundle r24 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_NUM, null, null);
        String r25 = MSimInfoHelper.getSimName(r15, 0);
        String r26 = MSimInfoHelper.getSimName(r15, 1);
        if (r24 == null) goto L8;
        String r27 = r24.getString("0");
    L9:
        if (r24 == null) goto L12;
        r23 = r24.getString("1");
    L12:
        if (Utils.hasMultiSimInDevice() == false) goto L30;
        String r28 = r27;
        if (r28 != null) goto L16;
    L19:
        boolean r112 = true;
    L20:
        if (r112 == true) goto L30;
        String r29 = r23;
        if (r29 != null) goto L24;
    L27:
        boolean r113 = true;
    L28:
        if (r113 == true) goto L30;
        List<DeviceStatusItemView> r30 = this.mList;
        AttributeSet r114 = null;
        int r115 = 0;
        Lifecycle r116 = null;
        int r117 = 193;
        DeviceStatusItemView r118 = new DeviceStatusItemView(r15, r114, r115, r116, r117, 14, null);
        Intrinsics.checkNotNull(r25);
        r118.initData(r25, r27);
        r118.showRightArrow(true);
        r118.setOnClickListener(new DeviceStatusActivity$$ExternalSyntheticLambda0(this));
        r30.add(r118);
        List<DeviceStatusItemView> r31 = this.mList;
        DeviceStatusItemView r32 = new DeviceStatusItemView(r15, r114, r115, r116, r117, 14, null);
        Intrinsics.checkNotNull(r26);
        r32.initData(r26, r23);
        r32.showRightArrow(true);
        r32.setOnClickListener(new DeviceStatusActivity$$ExternalSyntheticLambda1(this));
        r31.add(r32);
    L31:
        TelephonyManager r33 = TelephonyManager.getDefault();
        List<DeviceStatusItemView> r34 = this.mList;
        DeviceStatusItemView r35 = new DeviceStatusItemView(r15, null, 0, getLifecycle(), 0, 22, null);
        r35.initData(ResourceUtils.getString(R.string.status_imei), r33.getImei(0) + '\n' + r33.getImei(1));
        r34.add(r35);
        Object r36 = getSystemService(MultiSimAdapter.PHONE_KEY);
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String r37 = ((TelephonyManager) r36).getDeviceSoftwareVersion();
        String r38 = r37;
        if (r38 != null) goto L34;
    L37:
        boolean r119 = true;
    L38:
        if (r119 == true) goto L40;
        List<DeviceStatusItemView> r39 = this.mList;
        DeviceStatusItemView r40 = new DeviceStatusItemView(r15, null, 0, getLifecycle(), 0, 22, null);
        String r41 = ResourceUtils.getString(R.string.status_imei_sv);
        Intrinsics.checkNotNull(r37);
        r40.initData(r41, r37);
        r39.add(r40);
    L40:
        AttributeSet r120 = null;
        int r121 = 0;
        int r122 = 6;
        DefaultConstructorMarker r123 = null;
        this.mList.add(new IpAddressStatusItemView(r15, r120, r121, getLifecycle(), r122, r123));
        this.mList.add(new MacAddressStatusItemView(r15, r120, r121, getLifecycle(), r122, r123));
        this.mList.add(new BluetoothAddressStatusItemView(r15, r120, r121, getLifecycle(), r122, r123));
        String r42 = Build.getSerial();
        String r43 = r42;
        if (r43 != null) goto L43;
    L46:
        boolean r124 = true;
    L47:
        if (r124 == true) goto L49;
        List<DeviceStatusItemView> r44 = this.mList;
        DeviceStatusItemView r45 = new DeviceStatusItemView(r15, null, 0, getLifecycle(), 0, 22, null);
        r45.initData(ResourceUtils.getString(R.string.status_serial_number), r42);
        r44.add(r45);
    L49:
        List<DeviceStatusItemView> r46 = this.mList;
        UpTimeStatusItemView r47 = new UpTimeStatusItemView(r15, null, 0, getLifecycle(), 6, null);
        r47.setCardPosition(3);
        r46.add(r47);
        return;
    L43:
        if (r43.length() == 0) goto L46;
        r124 = false;
        goto L47
    L34:
        if (r38.length() == 0) goto L37;
        r119 = false;
        goto L38
    L24:
        if (r29.length() == 0) goto L27;
        r113 = false;
        goto L28
    L16:
        if (r28.length() == 0) goto L19;
        r112 = false;
    L30:
        SimStatusHelper r48 = new SimStatusHelper();
        int r49 = DeviceUtils.INSTANCE.getSimIndexWhenHasNoMultiSim();
        Lifecycle r50 = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(r50, "<get-lifecycle>(...)");
        r48.init(r49, r50);
        List<DeviceStatusItemView> r51 = this.mList;
        AttributeSet r125 = null;
        int r126 = 0;
        int r127 = 6;
        DefaultConstructorMarker r128 = null;
        OperatorNameStatusItemView r52 = new OperatorNameStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        DeviceStatusActivity r53 = this;
        r52.initData(r53, r48);
        r51.add(r52);
        List<DeviceStatusItemView> r54 = this.mList;
        SignalStrengthStatusItemView r55 = new SignalStrengthStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        r55.initData(r53, r48);
        r54.add(r55);
        List<DeviceStatusItemView> r56 = this.mList;
        NetworkTypeStatusItemView r57 = new NetworkTypeStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        r57.initData(r53, r48);
        r56.add(r57);
        List<DeviceStatusItemView> r58 = this.mList;
        ServiceStateStatusItemView r59 = new ServiceStateStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        r59.initData(r53, r48);
        r58.add(r59);
        List<DeviceStatusItemView> r60 = this.mList;
        RoamingStateStatusItemView r61 = new RoamingStateStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        r61.initData(r53, r48);
        r60.add(r61);
        List<DeviceStatusItemView> r62 = this.mList;
        DataStateStatusItemView r63 = new DataStateStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        r63.initData(r53, r48);
        r62.add(r63);
        List<DeviceStatusItemView> r64 = this.mList;
        NumberStatusItemView r65 = new NumberStatusItemView(r15, r125, r126, getLifecycle(), r127, r128);
        NumberStatusItemView.initData$default(r65, r53, r48, null, false, 12, null);
        r64.add(r65);
        goto L31
    L8:
        r27 = null;
        goto L9
    }

    private static final void initList$lambda$6$lambda$5(DeviceStatusActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.displaySimStatus(0);
    }

    private static final void initList$lambda$8$lambda$7(DeviceStatusActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.displaySimStatus(1);
    }

    private final void initView() {
        OFloatingTitleBar r1 = (OFloatingTitleBar) findViewById(R.id.view_title);
        if (r1 == null) goto L7;
        View r0 = OFloatingTitleBar.addStartAction$default(r1, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null);
        if (r0 == null) goto L7;
        r0.setOnClickListener(new DeviceStatusActivity$$ExternalSyntheticLambda2(this));
    L7:
        LinearLayout r2 = (LinearLayout) findViewById(R.id.constraint_root_view);
        if (r2 == null) goto L16;
        Iterator<T> r7 = this.mList.iterator();
        int r3 = 0;
    L11:
        if (r7.hasNext() == false) goto L20;
        Object r4 = r7.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        r2.addView((DeviceStatusItemView) r4);
        r3 = r5;
        goto L11
    L20:
        return;
    }

    private static final void initView$lambda$21(DeviceStatusActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onBackPressed();
    }

    private final void displaySimStatus(int r4) {
        DeviceStatusActivity r1 = this;
        Intent r0 = new Intent(r1, MultiSimSimStatus.class);
        r0.putExtra("title", MSimInfoHelper.getSimName(r1, r4));
        r0.putExtra("back_text_id", R.string.about_item_title_device_status);
        r0.putExtra("subscription", r4);
        Utils.startActivity(this.mActivity, r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        Iterator<T> r1 = this.mList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((DeviceStatusItemView) r1.next()).onActivityResult(r2, r3, r4);
        goto L4
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_about_DeviceStatusActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DeviceStatusActivity r1) {
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onCreate(DeviceStatusActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceStatusActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_about_DeviceStatusActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DeviceStatusActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DeviceStatusActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DeviceStatusActivity r5 = r4;
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
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DeviceStatusActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_about_DeviceStatusActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DeviceStatusActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_about_DeviceStatusActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onResume(DeviceStatusActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceStatusActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_about_DeviceStatusActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DeviceStatusActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onPause(DeviceStatusActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceStatusActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_about_DeviceStatusActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DeviceStatusActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DeviceStatusActivity r5 = r3;
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
    public static void com_android_settings_about_DeviceStatusActivity_com_obric_hook_lancet_PrivacyHook_onStop(DeviceStatusActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceStatusActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_about_DeviceStatusActivity__onStop$___twin___();
    }
}
