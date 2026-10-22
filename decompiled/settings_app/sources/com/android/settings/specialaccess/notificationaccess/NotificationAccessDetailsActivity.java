package com.android.settings.specialaccess.notificationaccess;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Slog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.password.PasswordUtils;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: NotificationAccessDetailsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0016J\u0010\u0010I\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0016H\u0004J\b\u0010J\u001a\u00020GH\u0016J\b\u0010K\u001a\u0004\u0018\u00010\u0004J\b\u0010L\u001a\u00020\u0010H\u0002J\u0010\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u0010H\u0002J\b\u0010O\u001a\u00020\u0010H\u0004J\b\u0010P\u001a\u00020GH\u0004J\u0012\u0010Q\u001a\u00020G2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\b\u0010T\u001a\u00020GH\u0014J\b\u0010U\u001a\u00020GH\u0014J\b\u0010V\u001a\u00020\u0010H\u0004J\b\u0010W\u001a\u00020GH\u0004J\b\u0010X\u001a\u00020GH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006Y"}, d2 = {"Lcom/android/settings/specialaccess/notificationaccess/NotificationAccessDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "bridgedApps", "Lcom/obric/oui/lisitem/OCardListItem;", "bridgedAppsController", "Lcom/android/settings/specialaccess/notificationaccess/BridgedAppsLinkPreferenceController;", "mAppsControlDisallowedAdmin", "Lcom/android/settingslib/RestrictedLockUtils$EnforcedAdmin;", "getMAppsControlDisallowedAdmin", "()Lcom/android/settingslib/RestrictedLockUtils$EnforcedAdmin;", "setMAppsControlDisallowedAdmin", "(Lcom/android/settingslib/RestrictedLockUtils$EnforcedAdmin;)V", "mAppsControlDisallowedBySystem", "", "getMAppsControlDisallowedBySystem", "()Z", "setMAppsControlDisallowedBySystem", "(Z)V", "mComponentName", "Landroid/content/ComponentName;", "mIsNls", "mNm", "Lcom/android/settings/notification/NotificationBackend;", "mPackageInfo", "Landroid/content/pm/PackageInfo;", "getMPackageInfo", "()Landroid/content/pm/PackageInfo;", "setMPackageInfo", "(Landroid/content/pm/PackageInfo;)V", "mPackageName", "getMPackageName", "()Ljava/lang/String;", "setMPackageName", "(Ljava/lang/String;)V", "mPm", "Landroid/content/pm/PackageManager;", "mPreUpgradePreferenceController", "Lcom/android/settings/specialaccess/notificationaccess/PreUpgradePreferenceController;", "mServiceInfo", "Landroid/content/pm/ServiceInfo;", "getMServiceInfo", "()Landroid/content/pm/ServiceInfo;", "setMServiceInfo", "(Landroid/content/pm/ServiceInfo;)V", "mServiceName", "", "mUserId", "", "getMUserId", "()I", "setMUserId", "(I)V", "moreSettings", "moreSettingsController", "Lcom/android/settings/specialaccess/notificationaccess/MoreSettingsPreferenceController;", "notificationAccessController", "Lcom/android/settings/specialaccess/notificationaccess/ApprovalPreferenceController;", "notificationAccessSwitch", "subContainer", "Landroid/view/ViewGroup;", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "typeFilterControllers", "", "Lcom/android/settings/specialaccess/notificationaccess/TypeFilterPreferenceController;", "getTypeFilterControllers", "()Ljava/util/List;", "disable", "", "cn", "enable", "finish", "getInitialCallingPackage", "hasInteractAcrossUsersPermission", "initTipsVisible", "visible", "isLightStatusBar", "loadNotificationListenerService", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "refreshUi", "retrieveAppEntry", "updateSubContainers", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotificationAccessDetailsActivity extends AppCompatActivity {
    private final String TAG;
    private OCardListItem bridgedApps;
    private final BridgedAppsLinkPreferenceController bridgedAppsController;
    private RestrictedLockUtils.EnforcedAdmin mAppsControlDisallowedAdmin;
    private boolean mAppsControlDisallowedBySystem;
    private ComponentName mComponentName;
    private boolean mIsNls;
    private final NotificationBackend mNm;
    private PackageInfo mPackageInfo;
    private String mPackageName;
    private PackageManager mPm;
    private PreUpgradePreferenceController mPreUpgradePreferenceController;
    private ServiceInfo mServiceInfo;
    private CharSequence mServiceName;
    private int mUserId;
    private OCardListItem moreSettings;
    private final MoreSettingsPreferenceController moreSettingsController;
    private final ApprovalPreferenceController notificationAccessController;
    private OCardListItem notificationAccessSwitch;
    private ViewGroup subContainer;
    private OFloatingTitleBar titleBar;
    private final List<TypeFilterPreferenceController> typeFilterControllers;

    /* JADX INFO: renamed from: $r8$lambda$HsnDinBtT_1gq3BXIC-3NNCfvlI, reason: not valid java name */
    public static /* synthetic */ void m613$r8$lambda$HsnDinBtT_1gq3BXIC3NNCfvlI(TypeFilterPreferenceController r0, CompoundButton r1, boolean r2) {
        updateSubContainers$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$LdQlbioEmSHqdRqea36MVH9FpgE(NotificationAccessDetailsActivity r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Tj2DW0NZFbdWyZdAqydwhwL577A(NotificationAccessDetailsActivity r0, View r1) {
        onCreate$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lgS9p4s_oVL5ny9byK8QgodNAKQ(NotificationAccessDetailsActivity r0, View r1) {
        updateSubContainers$lambda$9$lambda$8(r0, r1);
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public NotificationAccessDetailsActivity() {
        this.TAG = Reflection.getOrCreateKotlinClass(NotificationAccessDetailsActivity.class).getSimpleName();
        this.mNm = new NotificationBackend();
        this.notificationAccessController = new ApprovalPreferenceController();
        this.typeFilterControllers = CollectionsKt.listOf(new TypeFilterPreferenceController[]{new OngoingTypeFilterPreferenceController(), new ConversationTypeFilterPreferenceController(), new AlertingTypeFilterPreferenceController(), new SilentTypeFilterPreferenceController()});
        this.bridgedAppsController = new BridgedAppsLinkPreferenceController();
        this.moreSettingsController = new MoreSettingsPreferenceController();
    }

    protected final ServiceInfo getMServiceInfo() {
        return this.mServiceInfo;
    }

    protected final void setMServiceInfo(ServiceInfo r1) {
        this.mServiceInfo = r1;
    }

    protected final PackageInfo getMPackageInfo() {
        return this.mPackageInfo;
    }

    protected final void setMPackageInfo(PackageInfo r1) {
        this.mPackageInfo = r1;
    }

    protected final int getMUserId() {
        return this.mUserId;
    }

    protected final void setMUserId(int r1) {
        this.mUserId = r1;
    }

    protected final String getMPackageName() {
        return this.mPackageName;
    }

    protected final void setMPackageName(String r1) {
        this.mPackageName = r1;
    }

    protected final RestrictedLockUtils.EnforcedAdmin getMAppsControlDisallowedAdmin() {
        return this.mAppsControlDisallowedAdmin;
    }

    protected final void setMAppsControlDisallowedAdmin(RestrictedLockUtils.EnforcedAdmin r1) {
        this.mAppsControlDisallowedAdmin = r1;
    }

    protected final boolean getMAppsControlDisallowedBySystem() {
        return this.mAppsControlDisallowedBySystem;
    }

    protected final void setMAppsControlDisallowedBySystem(boolean r1) {
        this.mAppsControlDisallowedBySystem = r1;
    }

    public final List<TypeFilterPreferenceController> getTypeFilterControllers() {
        return this.typeFilterControllers;
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_notification_access_details);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.some_activities_bg_color));
        int r0 = 0;
        getWindow().setNavigationBarColor(0);
        SpecialAccessBaseActivity.setLightStatusBarIcon(getWindow(), isLightStatusBar());
        Intent r9 = getIntent();
        if (this.mComponentName != null) goto L13;
        if (r9 == null) goto L13;
        String r1 = r9.getStringExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME");
        if (r1 == null) goto L13;
        ComponentName r2 = ComponentName.unflattenFromString(r1);
        this.mComponentName = r2;
        if (r2 == null) goto L13;
        OLog.i(this.TAG, "onCreate mComponentName: " + this.mComponentName);
        Bundle r3 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r9, "android.provider.extra.NOTIFICATION_LISTENER_ARGS");
        if (r3 != null) goto L12;
        r3 = new Bundle();
    L12:
        ComponentName r4 = this.mComponentName;
        Intrinsics.checkNotNull(r4);
        r3.putString("package", r4.getPackageName());
        r9.putExtra("android.provider.extra.NOTIFICATION_LISTENER_ARGS", r3);
    L13:
        PackageManager r10 = getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r10, "getPackageManager(...)");
        this.mPm = r10;
        retrieveAppEntry();
        loadNotificationListenerService();
        if (this.mPackageInfo != null) goto L17;
        OLog.e(this.TAG, "onCreate mPackageInfo is null");
        finish();
        return;
    L17:
        OFloatingTitleBar r5 = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.titleBar = r5;
        if (r5 == null) goto L22;
        View r11 = OFloatingTitleBar.addStartAction$default(r5, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null);
        if (r11 == null) goto L22;
        r11.setOnClickListener(new NotificationAccessDetailsActivity$$ExternalSyntheticLambda2(this));
    L22:
        OFloatingTitleBar r12 = this.titleBar;
        Intrinsics.checkNotNull(r12);
        PackageInfo r6 = this.mPackageInfo;
        Intrinsics.checkNotNull(r6);
        ApplicationInfo r7 = r6.applicationInfo;
        Intrinsics.checkNotNull(r7);
        PackageManager r13 = this.mPm;
        PackageManager r14 = null;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");
        r13 = null;
    L25:
        r12.setCenterTitle(r7.loadLabel(r13).toString());
        this.notificationAccessSwitch = (OCardListItem) findViewById(R.id.notification_access_switch);
        ApprovalPreferenceController r15 = this.notificationAccessController.setPkgInfo(this.mPackageInfo).setCn(this.mComponentName).setNm((NotificationManager) getSystemService(NotificationManager.class));
        PackageManager r16 = this.mPm;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");
        r16 = null;
    L28:
        r15.setPm(r16).setSettingIdentifier("android:access_notifications").setParent(this);
        this.subContainer = (ViewGroup) findViewById(R.id.sub_switch_container);
        NotificationBackend r17 = new NotificationBackend();
        PackageManager r18 = this.mPm;     // Catch: PackageManager.NameNotFoundException -> L34
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");     // Catch: PackageManager.NameNotFoundException -> L34
        r18 = null;
    L32:
        ComponentName r19 = this.mComponentName;     // Catch: PackageManager.NameNotFoundException -> L34
        Intrinsics.checkNotNull(r19);     // Catch: PackageManager.NameNotFoundException -> L34
        int r20 = r18.getTargetSdkVersion(r19.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L34
    L35:
        Iterator<TypeFilterPreferenceController> r21 = this.typeFilterControllers.iterator();
    L37:
        if (r21.hasNext() == false) goto L39;
        r21.next().setNm(r17).setCn(this.mComponentName).setServiceInfo(this.mServiceInfo).setUserId(this.mUserId).setTargetSdk(r20);
        goto L37
    L39:
        this.bridgedApps = (OCardListItem) findViewById(R.id.bridged_apps);
        this.bridgedAppsController.setNm(r17).setCn(this.mComponentName).setUserId(this.mUserId).setTargetSdk(r20);
        OCardListItem r22 = this.bridgedApps;
        if (r22 == null) goto L42;
        r22.setOnContentClickListener(new NotificationAccessDetailsActivity$$ExternalSyntheticLambda3(this));
    L42:
        this.moreSettings = (OCardListItem) findViewById(R.id.more_settings);
        MoreSettingsPreferenceController r23 = this.moreSettingsController;
        ComponentName r24 = this.mComponentName;
        Intrinsics.checkNotNull(r24);
        MoreSettingsPreferenceController r25 = r23.setPackage(r24.getPackageName());
        PackageManager r26 = this.mPm;
        if (r26 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");
    L46:
        r25.setPackageManager(r14);
        updateSubContainers();
        OTextView r27 = (OTextView) findViewById(R.id.notif_listener_not_migrated);
        if (r27 == null) goto L57;
        PreUpgradePreferenceController r28 = new PreUpgradePreferenceController();
        this.mPreUpgradePreferenceController = r28;
        r28.setNm(r17).setCn(this.mComponentName).setUserId(this.mUserId).setTargetSdk(r20);
        if (r28.getAvailabilityStatus() == true) goto L52;
        r0 = 8;
    L52:
        r27.setVisibility(r0);
        r27.setText(R.string.notif_listener_not_migrated);
        return;
    L57:
        return;
    L45:
        r14 = r26;
    L34:
        r20 = 31;
        goto L35
    }

    private static final void onCreate$lambda$1(NotificationAccessDetailsActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onBackPressed();
    }

    private static final void onCreate$lambda$3(NotificationAccessDetailsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent(r2, BridgedAppsSettingsActivity.class);
        r4.putExtra("android.intent.extra.user_handle", UserHandle.of(r2.mUserId));
        r4.putExtra("package", r2.mPackageName);
        ComponentName r0 = r2.mComponentName;
        Intrinsics.checkNotNull(r0);
        r4.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", r0.flattenToString());
        Utils.startActivity(r2, r4);
    }

    private final void initTipsVisible(boolean r3) {
        OTextView r0 = (OTextView) findViewById(R.id.notif_listener_not_migrated);
        PreUpgradePreferenceController r2 = this.mPreUpgradePreferenceController;
        int r1 = 8;
        if (r2 == null) goto L11;
        if (r0 == null) goto L16;
        Intrinsics.checkNotNull(r2);
        if (r2.getAvailabilityStatus() == false) goto L10;
        if (r3 == false) goto L10;
        r1 = 0;
    L10:
        r0.setVisibility(r1);
        return;
    L16:
        return;
    L11:
        if (r0 == null) goto L17;
        r0.setVisibility(8);
        return;
    }

    protected final boolean isLightStatusBar() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateSubContainers() {
        int r4 = 3;
        Iterator r0 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.type_filter_ongoing), Integer.valueOf(R.id.type_filter_conversation), Integer.valueOf(R.id.type_filter_alerting), Integer.valueOf(R.id.type_filter_silent)}).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        int r5 = r1 + 1;
        int r6 = ((Number) r0.next()).intValue();
        final TypeFilterPreferenceController r2 = this.typeFilterControllers.get(r1);
        OCardListItem r7 = (OCardListItem) findViewById(r6);
        if (r7 == null) goto L8;
        r2.updateState(r7);
        OCardListItemUtils.setOnCheckedChangeListener(r7, new NotificationAccessDetailsActivity$$ExternalSyntheticLambda0(r2));
    L8:
        r1 = r5;
        goto L4
    L9:
        OCardListItem r3 = this.bridgedApps;
        if (r3 == null) goto L12;
        this.bridgedAppsController.updateState(r3);
    L12:
        OCardListItem r8 = this.moreSettings;
        if (r8 != null) goto L15;
        return;
    L15:
        if (this.moreSettingsController.getAvailabilityStatus() == false) goto L17;
        int r9 = 0;
    L18:
        r8.setVisibility(r9);
        OCardListItem r10 = this.bridgedApps;
        if (r10 != null) goto L21;
    L24:
        r8.setOnClickListener(new NotificationAccessDetailsActivity$$ExternalSyntheticLambda1(this));
        return;
    L21:
        if (this.moreSettingsController.getAvailabilityStatus() == false) goto L23;
        r4 = 2;
    L23:
        OCardListItem.setCardPosition$default(r10, r4, false, 2, null);
        goto L24
    L17:
        r9 = 8;
        goto L18
    }

    private static final void updateSubContainers$lambda$6$lambda$5(TypeFilterPreferenceController r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$typeFilterController");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.onCheckedChanged(r2, r3);
    }

    private static final void updateSubContainers$lambda$9$lambda$8(NotificationAccessDetailsActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Utils.startActivity(r0, r0.moreSettingsController.mIntent);
    }

    protected final boolean refreshUi() {
        if (this.mComponentName != null) goto L7;
        Slog.d(this.TAG, "No component name provided");
        return false;
    L7:
        if (this.mIsNls == true) goto L11;
        Slog.d(this.TAG, "Provided component name is not an NLS");
        return false;
    L11:
        if (UserManager.get(this).isManagedProfile() == false) goto L14;
        Slog.d(this.TAG, "NLSes aren't allowed in work profiles");
        return false;
    L14:
        return true;
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onResume$___twin___() {
        super.onResume();
        NotificationAccessDetailsActivity r0 = this;
        this.mAppsControlDisallowedAdmin = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r0, "no_control_apps", this.mUserId);
        this.mAppsControlDisallowedBySystem = RestrictedLockUtilsInternal.hasBaseUserRestriction(r0, "no_control_apps", this.mUserId);
        if (refreshUi() == true) goto L5;
        finish();
    L5:
        ComponentName r1 = this.mComponentName;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.mNm.isNotificationListenerAccessGranted(r1) == false) goto L10;
        enable(r1);
        return;
    L10:
        disable(r1);
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onPause$___twin___() {
        super.onPause();
    }

    protected final void retrieveAppEntry() {
        Bundle r0 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(getIntent(), "android.provider.extra.NOTIFICATION_LISTENER_ARGS");
        PackageManager r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("package");
    L6:
        this.mPackageName = r2;
        if (r2 != null) goto L13;
        OLog.i(this.TAG, "retrieveAppEntry intent=" + getIntent() + ", intent.data=" + getIntent().getData());
        if (getIntent() == null) goto L13;
        if (getIntent().getData() == null) goto L13;
        Uri r3 = getIntent().getData();
        Intrinsics.checkNotNull(r3);
        this.mPackageName = r3.getSchemeSpecificPart();
    L13:
        String r4 = this.mPackageName;
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        OLog.e(this.TAG, "retrieveAppEntry mPackageName=" + this.mPackageName + ", callingPkg=" + getCallingPackage() + ", callingAc=" + getCallingActivity());
    L23:
        if (getIntent() != null) goto L25;
    L30:
        this.mUserId = UserHandle.myUserId();
    L42:
        PackageManager r6 = this.mPm;     // Catch: Throwable -> L37 PackageManager.NameNotFoundException -> L39
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");     // Catch: Throwable -> L37 PackageManager.NameNotFoundException -> L39
    L35:
        String r7 = this.mPackageName;     // Catch: Throwable -> L37 PackageManager.NameNotFoundException -> L39
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L37 PackageManager.NameNotFoundException -> L39
        this.mPackageInfo = r1.getPackageInfoAsUser(r7, 134222336, this.mUserId);     // Catch: Throwable -> L37 PackageManager.NameNotFoundException -> L39
    L45:
        return;
    L34:
        r1 = r6;
    L39:
        e = move-exception;
        OLog.e(this.TAG, "retrieveAppEntry err: " + e);
        finish();
        return;
    L37:
        th = move-exception;
        OLog.e(this.TAG, "retrieveAppEntry err2: " + th);
        finish();
        return;
    L25:
        if (getIntent().hasExtra("android.intent.extra.user_handle") == false) goto L30;
        if (hasInteractAcrossUsersPermission() == false) goto L29;
        Parcelable r8 = getIntent().getParcelableExtra("android.intent.extra.user_handle");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.os.UserHandle");
        this.mUserId = ((UserHandle) r8).getIdentifier();
        goto L42
    L29:
        finish();
        goto L42
    L16:
        if (r4.length() == 0) goto L19;
        r5 = false;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    public final String getInitialCallingPackage() {
        return PasswordUtils.getCallingAppPackageName(getActivityToken());
    }

    private final boolean hasInteractAcrossUsersPermission() {
        String r0 = getInitialCallingPackage();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        OLog.w(this.TAG, "Not able to get calling package name for permission check");
        return false;
    L6:
        PackageManager r1 = getPackageManager();
        Intrinsics.checkNotNull(r0);
        if (r1.checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", r0) == 0) goto L10;
        OLog.w(this.TAG, "Package " + r0 + " does not have required permission android.permission.INTERACT_ACROSS_USERS_FULL");
        return false;
    L10:
        return true;
    }

    public final void disable(ComponentName r3) {
        Intrinsics.checkNotNullParameter(r3, "cn");
        this.notificationAccessController.disable(r3);
        this.notificationAccessController.updateState(this.notificationAccessSwitch);
        ViewGroup r4 = this.subContainer;
        if (r4 == null) goto L5;
        ViewExtensionsKt.setEnable(r4, false);
    L5:
        ViewGroup r5 = this.subContainer;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
    L8:
        initTipsVisible(false);
        updateSubContainers();
    }

    protected final void enable(ComponentName r3) {
        Intrinsics.checkNotNullParameter(r3, "cn");
        this.notificationAccessController.enable(r3);
        this.notificationAccessController.updateState(this.notificationAccessSwitch);
        ViewGroup r4 = this.subContainer;
        if (r4 == null) goto L5;
        ViewExtensionsKt.setEnable(r4, true);
    L5:
        ViewGroup r5 = this.subContainer;
        if (r5 == null) goto L8;
        r5.setVisibility(0);
    L8:
        initTipsVisible(true);
        updateSubContainers();
    }

    protected final void loadNotificationListenerService() {
        this.mIsNls = false;
        if (this.mComponentName != null) goto L5;
        return;
    L5:
        Intent r0 = new Intent("android.service.notification.NotificationListenerService").setComponent(this.mComponentName);
        Intrinsics.checkNotNullExpressionValue(r0, "setComponent(...)");
        PackageManager r1 = this.mPm;
        PackageManager r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");
        r1 = null;
    L8:
        List r3 = r1.queryIntentServicesAsUser(r0, 132, this.mUserId);
        Intrinsics.checkNotNullExpressionValue(r3, "queryIntentServicesAsUser(...)");
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L27;
        ServiceInfo r5 = ((ResolveInfo) r4.next()).serviceInfo;
        if (Intrinsics.areEqual("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE", r5.permission) == false) goto L10;
        if (Intrinsics.areEqual(this.mComponentName, r5.getComponentName()) == false) goto L10;
        this.mIsNls = true;
        PackageManager r6 = this.mPm;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPm");
    L19:
        this.mServiceName = r5.loadLabel(r2);
        this.mServiceInfo = r5;
        return;
    L18:
        r2 = r6;
        goto L19
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NotificationAccessDetailsActivity r1) {
        r1.com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(NotificationAccessDetailsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(NotificationAccessDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessDetailsActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(NotificationAccessDetailsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(NotificationAccessDetailsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(NotificationAccessDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(NotificationAccessDetailsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_notificationaccess_NotificationAccessDetailsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessDetailsActivity r5 = r3;
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
}
