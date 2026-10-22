package com.obric.safecheck.riskcontrol.domain.permission;

import android.app.AppOpsManager;
import android.app.INotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.NetworkPolicyManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IPowerAdvisor;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.search.data.SearchConfigType;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: RiskPermissionPolicyEnforcer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u00100\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007J\u0018\u00102\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0004H\u0002J \u00104\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH\u0002J \u00106\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u00107\u001a\u00020\tH\u0002J\u0018\u00108\u001a\u0002032\u0006\u0010'\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u00109\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0004H\u0002J \u0010:\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\tH\u0002J.\u0010;\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J \u0010<\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u00107\u001a\u00020\tH\u0002J(\u0010=\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0007J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010&\u001a\u00020#H\u0002J$\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\tH\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020D2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\u0004H\u0002J\u0017\u0010G\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u0002032\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u0002032\u0006\u0010'\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\tH\u0002J!\u0010P\u001a\u0004\u0018\u00010\t2\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u00105\u001a\u00020\tH\u0002¢\u0006\u0002\u0010RJ(\u0010S\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0007J\u001a\u0010T\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0010\u0010V\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u001a\u0010W\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u0004H\u0002J\b\u0010X\u001a\u000203H\u0007J\u0012\u0010Y\u001a\u0004\u0018\u00010\u00042\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001d\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010]\u001a\u00020*H\u0001¢\u0006\u0002\b^J\b\u0010_\u001a\u00020\tH\u0002J\u0017\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010bJ)\u0010c\u001a\u0004\u0018\u00010\t2\u0006\u0010d\u001a\u00020\u00042\u000e\b\u0002\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0004\bf\u0010gJ.\u0010h\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010i\u001a\u00020A2\u0006\u0010(\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J(\u0010j\u001a\u00020*2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0018\u0010k\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u00105\u001a\u00020\tH\u0002J0\u0010l\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010d\u001a\u00020\u00042\u0006\u00105\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\tH\u0002J\"\u0010m\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u00105\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002J\"\u0010n\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u00105\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002J\"\u0010o\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u00105\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002J\"\u0010p\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u00105\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002J/\u0010q\u001a\u00020*2\u0006\u00105\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\t2\b\b\u0002\u00107\u001a\u00020\tH\u0001¢\u0006\u0002\brJ2\u0010s\u001a\u0002032\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020\u00042\u0006\u00105\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\tH\u0002J!\u0010w\u001a\u00020*2\u0006\u0010x\u001a\u00020\t2\b\u0010\\\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\by\u0010zJ.\u0010{\u001a\u0002032\u0006\u0010&\u001a\u00020#2\u0006\u0010i\u001a\u00020A2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010O\u001a\u00020\tH\u0002J*\u0010|\u001a\u0002032\b\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u0010'\u001a\u00020\u00042\u0006\u00105\u001a\u00020\t2\u0006\u0010x\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R~\u0010!\u001a\\\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\t¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006}"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/permission/RiskPermissionPolicyEnforcer;", "", "()V", "ANDROID_APP_APP_OPS_MANAGER", "", "ANDROID_APP_SMT_OPS_MANAGER", "APP_OPS_MANAGER_CLASS_NAMES", "", "BACKGROUND_NETWORK_POLICY_REJECT_ALL", "", "BACKGROUND_NETWORK_POLICY_REJECT_SCREEN_OFF", "CONTACTS_PERMISSIONS", "", "CONTEXT_SMT", "DEVICE_IDLE_CONTROLLER_HELPER", "ENABLED_NOTIFICATION_LISTENERS", "INSTALL_PACKAGE_PERMISSIONS", "NETWORK_CONTROL_PREF", "NETWORK_POLICY_CHANGE_APP_KEY", "NETWORK_POLICY_NONE", "NETWORK_REJECT_HELPER", "NOTIFICATION_PERMISSIONS", "PERM_PROVIDER_AUTHORITY", "PERM_PROVIDER_EXTRA_RUNTIME", "PERM_PROVIDER_EXTRA_USER_ID", "PERM_PROVIDER_METHOD_SET", "PERM_PROVIDER_RESULT_STATUS", "PERM_PROVIDER_STATE_REVOKE", "PERM_PROVIDER_STATUS_SUCCESS", "PHONE_AND_CALL_LOG_PERMISSIONS", "SMS_PERMISSIONS", RiskPermissionPolicyEnforcer.SMT_OPS_SERVICE, "TAG", "permRevoker", "Lkotlin/Function4;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "runtimePayload", "", "getPermRevoker$annotations", "getPermRevoker", "()Lkotlin/jvm/functions/Function4;", "setPermRevoker", "(Lkotlin/jvm/functions/Function4;)V", "buildPermProviderRevokePayload", "permissions", "disableAccessibilityServices", "", "disableBackgroundNetwork", "uid", "disableNetwork", "controlFlags", "disableNotificationEnabledState", "disableNotificationListeners", "disableNotifications", "disablePermissionAppOps", "enableNetwork", "enforceControls", "getNetworkPolicyManager", "Landroid/net/NetworkPolicyManager;", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfoForCurrentUser", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageNameFromFlattenedComponent", "flattened", "isAppInDeviceIdleWhitelist", "(Ljava/lang/String;)Ljava/lang/Boolean;", "logE", "message", "throwable", "", "logW", "notifyPowerAdvisorBackgroundNetworkSelected", SearchConfigType.KEY_MODE, "readBackgroundNetworkRawPolicy", "networkPolicyManager", "(Landroid/net/NetworkPolicyManager;I)Ljava/lang/Integer;", "releaseControls", "removeAccessibilityServicesForPackage", "enabledServices", "removeAppFromDeviceIdleWhitelist", "removeFlattenedComponentsForPackage", "resetPermRevoker", "resolveAppOpsServiceName", "managerClassName", "resolveBackgroundNetworkModeForUi", "rawPolicy", "isDeviceIdleWhitelisted", "resolveBackgroundNetworkModeForUi$safecheck_neridaCnRelease", "resolveNetworkRejectPolicyAllBackground", "resolveOpsManagerHelperIntMethod", "methodName", "(Ljava/lang/String;)Ljava/lang/Integer;", "resolveStaticIntField", "fieldName", "classNames", "resolveStaticIntField$safecheck_neridaCnRelease", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/Integer;", "revokeRuntimePermissionsIfNeeded", "packageInfo", "revokeViaPermProvider", "saveBackgroundNetworkChangeUid", "setAppOpModeByField", "setBackgroundNetworkPolicy", "setBackgroundNetworkPolicyDirect", "setBackgroundNetworkPolicyRaw", "setBackgroundNetworkPolicyWithHelper", "setNetworkModeWithOpsManagerHelper", "setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease", "setPermissionAppOpMode", "appOpsManager", "Landroid/app/AppOpsManager;", "permission", "shouldForceRawBackgroundNetworkReject", "targetMode", "shouldForceRawBackgroundNetworkReject$safecheck_neridaCnRelease", "(ILjava/lang/Integer;)Z", "updatePermissionAppOps", "verifyBackgroundNetworkPolicy", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskPermissionPolicyEnforcer {
    private static final String ANDROID_APP_APP_OPS_MANAGER = "android.app.AppOpsManager";
    private static final String ANDROID_APP_SMT_OPS_MANAGER = "android.app.SmtOpsManager";
    private static final List<String> APP_OPS_MANAGER_CLASS_NAMES = null;
    private static final int BACKGROUND_NETWORK_POLICY_REJECT_ALL = 16;
    private static final int BACKGROUND_NETWORK_POLICY_REJECT_SCREEN_OFF = 8;
    private static final Set<String> CONTACTS_PERMISSIONS = null;
    private static final String CONTEXT_SMT = "com.bytedanceos.api.ContextSmt";
    private static final String DEVICE_IDLE_CONTROLLER_HELPER = "com.bytedanceos.securitycenter.networkControl.DeviceIdleControllerHelper";
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final Set<String> INSTALL_PACKAGE_PERMISSIONS = null;
    public static final RiskPermissionPolicyEnforcer INSTANCE = null;
    private static final String NETWORK_CONTROL_PREF = "network_control";
    private static final String NETWORK_POLICY_CHANGE_APP_KEY = "networkPolicy_change_app";
    private static final int NETWORK_POLICY_NONE = 0;
    private static final String NETWORK_REJECT_HELPER = "com.bytedanceos.securitycenter.networkControl.NetworkRejectHelper";
    private static final Set<String> NOTIFICATION_PERMISSIONS = null;
    private static final String PERM_PROVIDER_AUTHORITY = "com.android.permissioncontroller.PermProvider";
    private static final String PERM_PROVIDER_EXTRA_RUNTIME = "runtime";
    private static final String PERM_PROVIDER_EXTRA_USER_ID = "user_id";
    private static final String PERM_PROVIDER_METHOD_SET = "set";
    private static final String PERM_PROVIDER_RESULT_STATUS = "status";
    private static final String PERM_PROVIDER_STATE_REVOKE = "1";
    private static final int PERM_PROVIDER_STATUS_SUCCESS = 0;
    private static final Set<String> PHONE_AND_CALL_LOG_PERMISSIONS = null;
    private static final Set<String> SMS_PERMISSIONS = null;
    private static final String SMT_OPS_SERVICE = "SMT_OPS_SERVICE";
    private static final String TAG = "RiskPermissionEnforcer";
    private static Function4<? super Context, ? super String, ? super Integer, ? super String, Boolean> permRevoker;

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.domain.permission.RiskPermissionPolicyEnforcer$resetPermRevoker$1, reason: invalid class name */
    /* JADX INFO: compiled from: RiskPermissionPolicyEnforcer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u00110\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0015\u0010\r\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u000f"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "p2", "", ApkVirusCheckProvider.KEY_PKG, "p3", "", AccountInfoBundleKey.USER_ID, "p4", "runtimePayload", "invoke"}, k = 3, mv = {1, 4, 3})
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<Context, String, Integer, String, Boolean> {
        AnonymousClass1(RiskPermissionPolicyEnforcer r8) {
            super(4, r8, RiskPermissionPolicyEnforcer.class, "revokeViaPermProvider", "revokeViaPermProvider(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(Context r1, String r2, Integer r3, String r4) {
            return Boolean.valueOf(invoke(r1, r2, r3.intValue(), r4));
        }

        public final boolean invoke(Context r2, String r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            Intrinsics.checkNotNullParameter(r3, "p2");
            Intrinsics.checkNotNullParameter(r5, "p4");
            return RiskPermissionPolicyEnforcer.access$revokeViaPermProvider((RiskPermissionPolicyEnforcer) this.receiver, r2, r3, r4, r5);
        }
    }

    @JvmStatic
    public static /* synthetic */ void getPermRevoker$annotations() {
    }

    @JvmStatic
    public static final int resolveBackgroundNetworkModeForUi$safecheck_neridaCnRelease(int r0, boolean r1) {
        if (r0 != 0) goto L6;
        if (r1 == true) goto L7;
        return 8;
    L7:
        return r0;
    L6:
        return r0;
    }

    static {
        RiskPermissionPolicyEnforcer r0 = new RiskPermissionPolicyEnforcer();
        INSTANCE = r0;
        APP_OPS_MANAGER_CLASS_NAMES = CollectionsKt.listOf(new String[]{ANDROID_APP_SMT_OPS_MANAGER, ANDROID_APP_APP_OPS_MANAGER});
        CONTACTS_PERMISSIONS = SetsKt.setOf(new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"});
        SMS_PERMISSIONS = SetsKt.setOf(new String[]{"android.permission.READ_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.READ_CELL_BROADCASTS", "android.permission.BD_SEND_MMS"});
        PHONE_AND_CALL_LOG_PERMISSIONS = SetsKt.setOf(new String[]{"android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.ANSWER_PHONE_CALLS", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.ACCEPT_HANDOVER"});
        INSTALL_PACKAGE_PERMISSIONS = SetsKt.setOf("android.permission.REQUEST_INSTALL_PACKAGES");
        NOTIFICATION_PERMISSIONS = SetsKt.setOf("android.permission.POST_NOTIFICATIONS");
        permRevoker = new RiskPermissionPolicyEnforcer$permRevoker$1(r0);
    }

    private RiskPermissionPolicyEnforcer() {
    }

    public static final /* synthetic */ boolean access$revokeViaPermProvider(RiskPermissionPolicyEnforcer r0, Context r1, String r2, int r3, String r4) {
        return r0.revokeViaPermProvider(r1, r2, r3, r4);
    }

    public static final Function4<Context, String, Integer, String, Boolean> getPermRevoker() {
        return permRevoker;
    }

    public static final void setPermRevoker(Function4<? super Context, ? super String, ? super Integer, ? super String, Boolean> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        permRevoker = r1;
    }

    @JvmStatic
    public static final void resetPermRevoker() {
        permRevoker = new AnonymousClass1(INSTANCE);
    }

    @JvmStatic
    public static final void enforceControls(Context r4, String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, ApkVirusCheckProvider.KEY_PKG);
        if (StringsKt.isBlank(r5) == true) goto L25;
        if (r7 == 0) goto L27;
        Context r8 = r4.getApplicationContext();
        if (RiskControlFlags.hasFlag(r7, 3) == false) goto L10;
        RiskPermissionPolicyEnforcer r0 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r0.disableNetwork(r8, r5, r7);
    L10:
        if (RiskControlFlags.hasFlag(r7, 4) == false) goto L13;
        RiskPermissionPolicyEnforcer r1 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r1.disablePermissionAppOps(r8, r5, r6, CONTACTS_PERMISSIONS);
    L13:
        if (RiskControlFlags.hasFlag(r7, 8) == false) goto L16;
        RiskPermissionPolicyEnforcer r2 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r2.disablePermissionAppOps(r8, r5, r6, SetsKt.plus(SMS_PERMISSIONS, PHONE_AND_CALL_LOG_PERMISSIONS));
    L16:
        if (RiskControlFlags.hasFlag(r7, 16) == false) goto L19;
        RiskPermissionPolicyEnforcer r3 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r3.disablePermissionAppOps(r8, r5, r6, INSTALL_PACKAGE_PERMISSIONS);
    L19:
        if (RiskControlFlags.hasFlag(r7, 32) == false) goto L22;
        RiskPermissionPolicyEnforcer r9 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r9.disableAccessibilityServices(r8, r5);
    L22:
        if (RiskControlFlags.hasFlag(r7, 64) == false) goto L26;
        RiskPermissionPolicyEnforcer r10 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r10.disableNotifications(r8, r5, r6);
        return;
    L26:
        return;
    L27:
        return;
    }

    @JvmStatic
    public static final void releaseControls(Context r1, String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        if (StringsKt.isBlank(r2) == true) goto L10;
        if (r4 == 0) goto L12;
        Context r5 = r1.getApplicationContext();
        if (RiskControlFlags.hasFlag(r4, 3) == false) goto L11;
        RiskPermissionPolicyEnforcer r6 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r5, "appContext");
        r6.enableNetwork(r5, r2, r4);
        return;
    L11:
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final String removeAccessibilityServicesForPackage(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, ApkVirusCheckProvider.KEY_PKG);
        String r1 = r10;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L21:
        if (r10 != null) goto L29;
        return "";
    L29:
        return r10;
    L11:
        if (StringsKt.isBlank(r11) == true) goto L21;
        List r12 = StringsKt.split$default(r1, new char[]{':'}, false, 0, 6, null);
        ArrayList r0 = new ArrayList();
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        Object r3 = r13.next();
        if ((!Intrinsics.areEqual(INSTANCE.getPackageNameFromFlattenedComponent((String) r3), r11)) == false) goto L15;
        r0.add(r3);
        goto L15
    L20:
        return CollectionsKt.joinToString$default(r0, ":", null, null, 0, null, null, 62, null);
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final String getPackageNameFromFlattenedComponent(String r7) {
        int r6 = StringsKt.indexOf$default(r7, IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, null);
        if (r6 > 0) goto L6;
        return null;
    L6:
        String r8 = r7.substring(0, r6);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        return r8;
    }

    private final void disablePermissionAppOps(Context r2, String r3, int r4, Set<String> r5) {
        PackageInfo r6 = getPackageInfo(r2, r3, r4);
        if (r6 != null) goto L5;
        return;
    L5:
        updatePermissionAppOps(r2, r6, r5, 1);
        revokeRuntimePermissionsIfNeeded(r2, r6, r4, r5);
    }

    private final void updatePermissionAppOps(Context r8, PackageInfo r9, Set<String> r10, int r11) {
        String[] r7 = r9.requestedPermissions;
        if (r7 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r7, "packageInfo.requestedPermissions ?: return");
        Object r12 = r8.getSystemService("appops");
        if ((r12 instanceof AppOpsManager) == true) goto L8;
        r12 = null;
    L8:
        AppOpsManager r13 = (AppOpsManager) r12;
        ApplicationInfo r0 = r9.applicationInfo;
        if (r0 == null) goto L20;
        int r6 = r0.uid;
        String r14 = r9.packageName;
        Intrinsics.checkNotNullExpressionValue(r14, "packageInfo.packageName");
        ArrayList r1 = new ArrayList();
        int r2 = r7.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L16;
        String r4 = r7[r3];
        if (r10.contains(r4) == false) goto L15;
        r1.add(r4);
    L15:
        r3 = r3 + 1;
        goto L11
    L16:
        Iterator r15 = r1.iterator();
    L18:
        if (r15.hasNext() == false) goto L25;
        String r5 = (String) r15.next();
        RiskPermissionPolicyEnforcer r16 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r5, "permission");
        r16.setPermissionAppOpMode(r13, r5, r6, r14, r11);
        goto L18
    L25:
        return;
    }

    private final void revokeRuntimePermissionsIfNeeded(Context r17, PackageInfo r18, int r19, Set<String> r20) {
        String[] r1 = r18.requestedPermissions;
        if (r1 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r1, "packageInfo.requestedPermissions ?: return");
        int[] r2 = r18.requestedPermissionsFlags;
        PackageManager r3 = r17.getPackageManager();
        String r4 = r18.packageName;
        Intrinsics.checkNotNullExpressionValue(r4, "packageInfo.packageName");
        ArrayList r5 = new ArrayList();
        int r6 = r1.length;
        boolean r7 = false;
        int r0 = 0;
        int r8 = 0;
    L6:
        boolean r9 = true;
        if (r8 >= r6) goto L36;
        String r10 = r1[r8];
        int r11 = r0 + 1;
        if (r20.contains(r10) == true) goto L11;
    L10:
        r9 = false;
    L33:
        if (r9 == false) goto L35;
        r5.add(r10);
    L35:
        r8 = r8 + 1;
        r0 = r11;
        goto L6
    L11:
        if (r2 == null) goto L18;
        Integer r12 = ArraysKt.getOrNull(r2, r0);
        if (r12 == null) goto L18;
        if ((r12.intValue() & 2) != 0) goto L18;
        boolean r13 = false;
    L58:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L25
        if (r3.checkPermission(r10, r4) != 0) goto L22;
        boolean r15 = true;
    L23:
        Object r16 = Result.m774constructorimpl(Boolean.valueOf(r15));     // Catch: Throwable -> L25
    L28:
        if (Result.m780isFailureimpl(r16) == false) goto L30;
        r16 = false;
    L30:
        boolean r21 = ((Boolean) r16).booleanValue();
        if (r13 == true) goto L33;
        if (r21 == false) goto L10;
    L22:
        r15 = false;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.m774constructorimpl(ResultKt.createFailure(th));
    L18:
        r13 = true;
        goto L58
    L36:
        ArrayList r22 = r5;
        if (r22.isEmpty() == false) goto L39;
        return;
    L39:
        String r23 = buildPermProviderRevokePayload(r22);
        if (r23.length() <= 0) goto L42;
        r7 = true;
    L42:
        if (r7 == false) goto L63;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L45
        RiskPermissionPolicyEnforcer r25 = this;     // Catch: Throwable -> L45
        Object r26 = Result.m774constructorimpl(Boolean.valueOf(permRevoker.invoke(r17, r4, Integer.valueOf(r19), r23).booleanValue()));     // Catch: Throwable -> L45
    L47:
        Throwable r27 = Result.m777exceptionOrNullimpl(r26);
        if (r27 == null) goto L51;
        INSTANCE.logE("permRevoker failed, pkg=" + r4 + ", payload=" + r23, r27);
    L51:
        if (Result.m781isSuccessimpl(r26) == true) goto L53;
        return;
    L53:
        if (((Boolean) r26).booleanValue() == true) goto L65;
        INSTANCE.logW("permRevoker not handled, skip local revoke, pkg=" + r4);
        return;
    L65:
        return;
    L45:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L47
    }

    @JvmStatic
    public static final String buildPermProviderRevokePayload(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r1 = r11.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return CollectionsKt.joinToString$default(r0, ";", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null);
    }

    private final boolean revokeViaPermProvider(Context r7, String r8, int r9, String r10) {
        if (StringsKt.isBlank(r8) == false) goto L5;
        return false;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L22;
        Uri r2 = Uri.parse("content://com.android.permissioncontroller.PermProvider");     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r2, "parse(this)");     // Catch: Exception -> L16
        Bundle r4 = new Bundle();     // Catch: Exception -> L16
        r4.putString(PERM_PROVIDER_EXTRA_RUNTIME, r10);     // Catch: Exception -> L16
        r4.putInt(PERM_PROVIDER_EXTRA_USER_ID, r9);     // Catch: Exception -> L16
        Context r11 = r7.getApplicationContext();     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r11, "context.applicationContext");     // Catch: Exception -> L16
        Bundle r12 = r11.getContentResolver().call(r2, PERM_PROVIDER_METHOD_SET, r8, r4);     // Catch: Exception -> L16
        if (r12 != null) goto L11;
        logW("revokeViaPermProvider null result, pkg=" + r8);     // Catch: Exception -> L16
        return false;
    L11:
        int r13 = r12.getInt("status", -1);     // Catch: Exception -> L16
        if (r13 == 0) goto L15;
        logW("revokeViaPermProvider status=" + r13 + ", pkg=" + r8);     // Catch: Exception -> L16
        return false;
    L15:
        return true;
    L16:
        e = move-exception;
        logE("revokeViaPermProvider failed, pkg=" + r8 + ", payload=" + r10, e);
        return false;
    L22:
        return false;
    }

    private final void disableNetwork(Context r10, String r11, int r12) {
        PackageInfo r2 = getPackageInfo$default(this, r10, r11, 0, 4, null);     // Catch: Exception -> L27
        if (r2 != null) goto L7;
        RiskPermissionPolicyEnforcer r13 = this;     // Catch: Exception -> L27
        logW("disableNetwork skipped, package not found, pkg=" + r11);     // Catch: Exception -> L27
        return;
    L7:
        ApplicationInfo r1 = r2.applicationInfo;     // Catch: Exception -> L27
        if (r1 == null) goto L25;
        int r0 = r1.uid;     // Catch: Exception -> L27
        Integer r3 = resolveOpsManagerHelperIntMethod("get_MODE_IGNORED");     // Catch: Exception -> L27
        if (r3 != null) goto L13;
        r3 = resolveStaticIntField$safecheck_neridaCnRelease$default("MODE_IGNORED", null, 2, null);     // Catch: Exception -> L27
    L13:
        if (r3 == null) goto L15;
        int r4 = r3.intValue();     // Catch: Exception -> L27
    L17:
        if (setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease(r0, r11, r4, r12) == false) goto L19;
    L24:
        disableBackgroundNetwork(r10, r11, r0);     // Catch: Exception -> L27
        return;
    L19:
        if (RiskControlFlags.hasFlag(r12, 2) == false) goto L22;
        setAppOpModeByField(r10, "OP_NET_MOBILE", r0, r11, r4);     // Catch: Exception -> L27
    L22:
        if (RiskControlFlags.hasFlag(r12, 1) == false) goto L24;
        setAppOpModeByField(r10, "OP_NET_WIFI", r0, r11, r4);     // Catch: Exception -> L27
        goto L24
    L15:
        r4 = 1;
        goto L17
    L25:
        RiskPermissionPolicyEnforcer r14 = this;     // Catch: Exception -> L27
        logW("disableNetwork skipped, applicationInfo missing, pkg=" + r11);     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        logE("disableNetwork failed, pkg=" + r11 + ", controlFlags=" + r12, e);
    }

    private final void enableNetwork(Context r9, String r10, int r11) {
        PackageInfo r2 = getPackageInfo$default(this, r9, r10, 0, 4, null);     // Catch: Exception -> L25
        if (r2 != null) goto L7;
        RiskPermissionPolicyEnforcer r12 = this;     // Catch: Exception -> L25
        logW("enableNetwork skipped, package not found, pkg=" + r10);     // Catch: Exception -> L25
        return;
    L7:
        ApplicationInfo r1 = r2.applicationInfo;     // Catch: Exception -> L25
        if (r1 == null) goto L23;
        int r0 = r1.uid;     // Catch: Exception -> L25
        Integer r3 = resolveOpsManagerHelperIntMethod("get_MODE_ALLOWED");     // Catch: Exception -> L25
        if (r3 != null) goto L12;
        r3 = resolveStaticIntField$safecheck_neridaCnRelease$default("MODE_ALLOWED", null, 2, null);     // Catch: Exception -> L25
    L12:
        if (r3 == null) goto L14;
        int r4 = r3.intValue();     // Catch: Exception -> L25
    L16:
        if (setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease(r0, r10, r4, r11) == false) goto L18;
        return;
    L18:
        if (RiskControlFlags.hasFlag(r11, 2) == false) goto L21;
        setAppOpModeByField(r9, "OP_NET_MOBILE", r0, r10, r4);     // Catch: Exception -> L25
    L21:
        if (RiskControlFlags.hasFlag(r11, 1) == false) goto L30;
        setAppOpModeByField(r9, "OP_NET_WIFI", r0, r10, r4);     // Catch: Exception -> L25
        return;
    L30:
        return;
    L14:
        r4 = 0;
        goto L16
    L23:
        RiskPermissionPolicyEnforcer r13 = this;     // Catch: Exception -> L25
        logW("enableNetwork skipped, applicationInfo missing, pkg=" + r10);     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        logE("enableNetwork failed, pkg=" + r10 + ", controlFlags=" + r11, e);
    }

    private final void disableBackgroundNetwork(Context r5, String r6, int r7) {
        int r0 = resolveNetworkRejectPolicyAllBackground();
        NetworkPolicyManager r1 = getNetworkPolicyManager(r5);
        if (setBackgroundNetworkPolicy(r1, r7, r0) == true) goto L6;
        logW("disableBackgroundNetwork policy update failed or unavailable, pkg=" + r6 + ", uid=" + r7 + ", mode=" + r0);
    L6:
        if (removeAppFromDeviceIdleWhitelist(r6) == true) goto L8;
        logW("disableBackgroundNetwork remove device idle whitelist failed or unavailable, pkg=" + r6);
    L8:
        verifyBackgroundNetworkPolicy(r1, r6, r7, r0);
        saveBackgroundNetworkChangeUid(r5, r7);
        notifyPowerAdvisorBackgroundNetworkSelected(r6, r0);
    }

    private final void disableAccessibilityServices(Context r4, String r5) {
        ContentResolver r6 = r4.getContentResolver();     // Catch: Exception -> L12
        String r1 = Settings.Secure.getString(r6, "enabled_accessibility_services");     // Catch: Exception -> L12
        String r2 = removeAccessibilityServicesForPackage(r1, r5);     // Catch: Exception -> L12
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        if ((!Intrinsics.areEqual(r2, r1)) == false) goto L17;
        Settings.Secure.putString(r6, "enabled_accessibility_services", r2);     // Catch: Exception -> L12
        if (StringsKt.isBlank(r2) == false) goto L18;
        Settings.Secure.putInt(r6, "accessibility_enabled", 0);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        logE("disableAccessibilityServices failed, pkg=" + r5, e);
    }

    private final void disableNotifications(Context r9, String r10, int r11) {
        PackageInfo r0 = getPackageInfo(r9, r10, r11);
        if (r0 != null) goto L5;
        return;
    L5:
        ApplicationInfo r1 = r0.applicationInfo;
        if (r1 == null) goto L15;
        int r2 = r1.uid;
        Object r3 = r9.getSystemService("appops");
        if ((r3 instanceof AppOpsManager) == true) goto L10;
        r3 = null;
    L10:
        AppOpsManager r4 = (AppOpsManager) r3;
        if (Build.VERSION.SDK_INT < 33) goto L13;
        setPermissionAppOpMode(r4, "android.permission.POST_NOTIFICATIONS", r2, r10, 1);
        revokeRuntimePermissionsIfNeeded(r9, r0, r11, NOTIFICATION_PERMISSIONS);
    L13:
        disableNotificationEnabledState(r10, r2);
        disableNotificationListeners(r9, r10);
        return;
    }

    private final void disableNotificationEnabledState(String r5, int r6) {
        INotificationManager r2 = INotificationManager.Stub.asInterface(ServiceManager.getService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION));     // Catch: Exception -> L9
        if (r2 != null) goto L7;
        logW("disableNotificationEnabledState service unavailable, pkg=" + r5 + ", uid=" + r6);     // Catch: Exception -> L9
        return;
    L7:
        r2.setNotificationsEnabledForPackage(r5, r6, false);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        logE("disableNotificationEnabledState failed, pkg=" + r5 + ", uid=" + r6, e);
    }

    private final void disableNotificationListeners(Context r4, String r5) {
        ContentResolver r6 = r4.getContentResolver();     // Catch: Exception -> L10
        String r1 = Settings.Secure.getString(r6, ENABLED_NOTIFICATION_LISTENERS);     // Catch: Exception -> L10
        String r2 = removeFlattenedComponentsForPackage(r1, r5);     // Catch: Exception -> L10
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        if ((!Intrinsics.areEqual(r2, r1)) == false) goto L15;
        Settings.Secure.putString(r6, ENABLED_NOTIFICATION_LISTENERS, r2);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        logE("disableNotificationListeners failed, pkg=" + r5, e);
    }

    private final String removeFlattenedComponentsForPackage(String r10, String r11) {
        String r0 = r10;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L21:
        if (r10 != null) goto L29;
        return "";
    L29:
        return r10;
    L11:
        if (StringsKt.isBlank(r11) == true) goto L21;
        List r9 = StringsKt.split$default(r0, new char[]{':'}, false, 0, 6, null);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r9.iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        Object r2 = r13.next();
        if ((!Intrinsics.areEqual(INSTANCE.getPackageNameFromFlattenedComponent((String) r2), r11)) == false) goto L15;
        r12.add(r2);
        goto L15
    L20:
        return CollectionsKt.joinToString$default(r12, ":", null, null, 0, null, null, 62, null);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    static /* synthetic */ PackageInfo getPackageInfo$default(RiskPermissionPolicyEnforcer r0, Context r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = UserHandle.myUserId();
    L6:
        return r0.getPackageInfo(r1, r2, r3);
    }

    private final PackageInfo getPackageInfo(Context r5, String r6, int r7) {
        PackageManager r8 = r5.getPackageManager();
    L12:
        return r8.getPackageInfoAsUser(r6, 4096, r7);
    L7:
        Intrinsics.checkNotNullExpressionValue(r8, "packageManager");
        return getPackageInfoForCurrentUser(r8, r6);
    L5:
        e = move-exception;
        logE("getPackageInfoAsUser failed, fallback current user, pkg=" + r6 + ", userId=" + r7, e);
        Intrinsics.checkNotNullExpressionValue(r8, "packageManager");
        return getPackageInfoForCurrentUser(r8, r6);
    }

    private final PackageInfo getPackageInfoForCurrentUser(PackageManager r4, String r5) {
        goto L12
    L11:
        return r4.getPackageInfo(r5, 4096);
    L5:
        e = move-exception;
        logE("getPackageInfo fallback failed, pkg=" + r5, e);
        return null;
    L12:
        return null;
    }

    private final void setPermissionAppOpMode(AppOpsManager r3, String r4, int r5, String r6, int r7) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(r6) == true) goto L20;
        String r0 = AppOpsManager.permissionToOp(r4);     // Catch: Exception -> L13
        if (r0 != null) goto L11;
        return;
    L11:
        Intrinsics.checkNotNullExpressionValue(r0, "AppOpsManager.permissionToOp(permission) ?: return");     // Catch: Exception -> L13
        r3.setMode(r0, r5, r6, r7);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        logE("setPermissionAppOpMode failed, permission=" + r4 + ", pkg=" + r6 + ", mode=" + r7, e);
        return;
    }

    public static /* synthetic */ Integer resolveStaticIntField$safecheck_neridaCnRelease$default(String r0, List r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = APP_OPS_MANAGER_CLASS_NAMES;
    L6:
        return resolveStaticIntField$safecheck_neridaCnRelease(r0, r1);
    }

    @JvmStatic
    public static final Integer resolveStaticIntField$safecheck_neridaCnRelease(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "fieldName");
        Intrinsics.checkNotNullParameter(r3, "classNames");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return null;
    L5:
        Iterator<T> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        return Integer.valueOf(Class.forName((String) r4.next()).getDeclaredField(r2).getInt(null));
    L11:
        return null;
    }

    public static /* synthetic */ boolean setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease$default(int r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = 3;
    L6:
        return setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final boolean setNetworkModeWithOpsManagerHelper$safecheck_neridaCnRelease(int r12, String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, ApkVirusCheckProvider.KEY_PKG);
        if (StringsKt.isBlank(r13) == false) goto L32;
        return false;
    L32:
        Class<?> r0 = Class.forName("com.bytedanceos.security.reflect.OpsManagerHelper");     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        Object r4 = null;
        Object r2 = r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if (r2 != null) goto L8;
        return false;
    L8:
        Object r3 = r0.getMethod("get_OP_NET_MOBILE", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if ((r3 instanceof Integer) == true) goto L11;
        r3 = null;
    L11:
        Integer r5 = (Integer) r3;     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if (r5 == null) goto L26;
        int r6 = r5.intValue();     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        Object r7 = r0.getMethod("get_OP_NET_WIFI", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if ((r7 instanceof Integer) == false) goto L17;
        r4 = r7;
    L17:
        Integer r8 = (Integer) r4;     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if (r8 == null) goto L26;
        int r9 = r8.intValue();     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        Method r1 = r0.getMethod("setMode", new Class[]{Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
        if (RiskControlFlags.hasFlag(r15, 2) == false) goto L23;
        r1.invoke(r2, new Object[]{Integer.valueOf(r6), Integer.valueOf(r12), r13, Integer.valueOf(r14)});     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
    L23:
        if (RiskControlFlags.hasFlag(r15, 1) == false) goto L34;
        r1.invoke(r2, new Object[]{Integer.valueOf(r9), Integer.valueOf(r12), r13, Integer.valueOf(r14)});     // Catch: Exception -> L27 NoSuchMethodException -> L29 ClassNotFoundException -> L30
    L34:
        return true;
    L26:
        return false;
    L30:
        INSTANCE.logW("OpsManagerHelper class not found, pkg=" + r13);
        return false;
    L29:
        INSTANCE.logW("OpsManagerHelper method not found, pkg=" + r13);
        return false;
    L27:
        e = move-exception;
        INSTANCE.logE("setNetworkModeWithOpsManagerHelper failed, pkg=" + r13 + ", uid=" + r12, e);
        return false;
    }

    private final void logW(String r1) {
        Log.w(TAG, r1);     // Catch: Throwable -> L4
        return;
    }

    private final void logE(String r1, Throwable r2) {
        Log.e(TAG, r1, r2);     // Catch: Throwable -> L4
        return;
    }

    private final int resolveNetworkRejectPolicyAllBackground() {
        return Class.forName(NETWORK_REJECT_HELPER).getDeclaredField("POLICY_REJECT_ALL_BACKGROUND").getInt(null);
    L8:
        return 16;
    }

    private final boolean setBackgroundNetworkPolicy(NetworkPolicyManager r2, int r3, int r4) {
        if (setBackgroundNetworkPolicyWithHelper(r2, r3, r4) == false) goto L7;
        return true;
    L7:
        return setBackgroundNetworkPolicyDirect(r2, r3, r4);
    }

    private final NetworkPolicyManager getNetworkPolicyManager(Context r2) {
        return NetworkPolicyManager.from(r2.getApplicationContext());
    L4:
        e = move-exception;
        logE("getNetworkPolicyManager failed", e);
        return null;
    }

    private final boolean setBackgroundNetworkPolicyWithHelper(NetworkPolicyManager r12, int r13, int r14) {
        if (r12 != null) goto L30;
        return false;
    L30:
        Class<?> r1 = Class.forName(NETWORK_REJECT_HELPER);     // Catch: Exception -> L26 ClassNotFoundException -> L29
        Intrinsics.checkNotNullExpressionValue(r1, "helperClass");     // Catch: Exception -> L26 ClassNotFoundException -> L29
        Method[] r2 = r1.getMethods();     // Catch: Exception -> L26 ClassNotFoundException -> L29
        Intrinsics.checkNotNullExpressionValue(r2, "helperClass.methods");     // Catch: Exception -> L26 ClassNotFoundException -> L29
        int r3 = r2.length;     // Catch: Exception -> L26 ClassNotFoundException -> L29
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L21;
        Method r8 = r2[r4];     // Catch: Exception -> L26 ClassNotFoundException -> L29
        Intrinsics.checkNotNullExpressionValue(r8, "method");     // Catch: Exception -> L26 ClassNotFoundException -> L29
        if (Intrinsics.areEqual(r8.getName(), "setRealPolicy") == true) goto L11;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == true) goto L22;
        r4 = r4 + 1;     // Catch: Exception -> L26 ClassNotFoundException -> L29
    L22:
        if (r8 != null) goto L24;
        return false;
    L24:
        r8.invoke(null, new Object[]{r12, Integer.valueOf(r13), Integer.valueOf(r14)});     // Catch: Exception -> L26 ClassNotFoundException -> L29
        goto L35
    L34:
        return true;
    L11:
        if (r8.getParameterTypes().length != 3) goto L17;
        if (Intrinsics.areEqual(r8.getParameterTypes()[1], Integer.TYPE) == false) goto L17;
        if (Intrinsics.areEqual(r8.getParameterTypes()[2], Integer.TYPE) == false) goto L17;
        r9 = true;
        goto L18
    L21:
        r8 = null;
    L26:
        e = move-exception;
        logE("setBackgroundNetworkPolicyWithHelper failed, uid=" + r13 + ", mode=" + r14, e);
        return false;
    L35:
        return false;
    }

    private final boolean setBackgroundNetworkPolicyDirect(NetworkPolicyManager r4, int r5, int r6) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r6 != 8) goto L8;
        int r1 = 0;
    L14:
        r4.setUidPolicy(r5, r1);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        logE("setBackgroundNetworkPolicyDirect failed, uid=" + r5 + ", mode=" + r6, e);
        return false;
    L8:
        r1 = r6;
        goto L14
    }

    private final boolean setBackgroundNetworkPolicyRaw(NetworkPolicyManager r4, int r5, int r6) {
        if (r4 != null) goto L10;
        return false;
    L10:
        r4.setUidPolicy(r5, r6);     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        logE("setBackgroundNetworkPolicyRaw failed, uid=" + r5 + ", mode=" + r6, e);
        return false;
    }

    private final void verifyBackgroundNetworkPolicy(NetworkPolicyManager r6, String r7, int r8, int r9) {
        Integer r0 = readBackgroundNetworkRawPolicy(r6, r8);
        Boolean r1 = isAppInDeviceIdleWhitelist(r7);
        if (shouldForceRawBackgroundNetworkReject$safecheck_neridaCnRelease(r9, r0) == false) goto L8;
        logW("verifyBackgroundNetworkPolicy raw policy does not contain target reject, force raw reject, pkg=" + r7 + ", uid=" + r8 + ", targetMode=" + r9 + ", rawPolicy=" + r0 + ", isDeviceIdleWhitelisted=" + r1);
        if (setBackgroundNetworkPolicyRaw(r6, r8, r9) == false) goto L9;
        logW("verifyBackgroundNetworkPolicy force raw reject done, pkg=" + r7 + ", uid=" + r8 + ", forcedRawPolicy=" + readBackgroundNetworkRawPolicy(r6, r8) + ", forcedWhitelisted=" + isAppInDeviceIdleWhitelist(r7));
        return;
    L9:
        return;
    }

    private final Integer readBackgroundNetworkRawPolicy(NetworkPolicyManager r1, int r2) {
        if (r1 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r1.getUidPolicy(r2));
    L10:
        return null;
    }

    private final Boolean isAppInDeviceIdleWhitelist(String r7) {
        if (StringsKt.isBlank(r7) == false) goto L12;
        return null;
    L12:
        Object r6 = Class.forName(DEVICE_IDLE_CONTROLLER_HELPER).getMethod("isWhileListApp", new Class[]{String.class}).invoke(null, new Object[]{r7});     // Catch: Throwable -> L11
        if ((r6 instanceof Boolean) == true) goto L8;
        r6 = null;
    L8:
        return (Boolean) r6;
    L14:
        return null;
    }

    @JvmStatic
    public static final boolean shouldForceRawBackgroundNetworkReject$safecheck_neridaCnRelease(int r1, Integer r2) {
        if (r1 == 0) goto L10;
        if (r2 != null) goto L7;
        return false;
    L7:
        if ((r1 & r2.intValue()) != 0) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    private final boolean removeAppFromDeviceIdleWhitelist(String r7) {
        if (StringsKt.isBlank(r7) == false) goto L11;
        return false;
    L11:
        Class.forName(DEVICE_IDLE_CONTROLLER_HELPER).getMethod("removeApp", new Class[]{String.class}).invoke(null, new Object[]{r7});     // Catch: Exception -> L7 Throwable -> L10
        goto L14
    L13:
        return true;
    L7:
        e = move-exception;
        logE("removeAppFromDeviceIdleWhitelist failed, pkg=" + r7, e);
        return false;
    L14:
        return false;
    }

    private final void saveBackgroundNetworkChangeUid(Context r4, int r5) {
        SharedPreferences r6 = r4.getApplicationContext().getSharedPreferences("network_control", 0);     // Catch: Exception -> L8
        Set<String> r2 = r6.getStringSet("networkPolicy_change_app", SetsKt.emptySet());     // Catch: Exception -> L8
        if (r2 != null) goto L6;
        r2 = SetsKt.emptySet();     // Catch: Exception -> L8
    L6:
        HashSet r1 = new HashSet(r2);     // Catch: Exception -> L8
        r1.add(String.valueOf(r5));     // Catch: Exception -> L8
        r6.edit().putStringSet("networkPolicy_change_app", r1).apply();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        logE("saveBackgroundNetworkChangeUid failed, uid=" + r5, e);
    }

    private final void notifyPowerAdvisorBackgroundNetworkSelected(String r4, int r5) {
        if (StringsKt.isBlank(r4) == false) goto L16;
        return;
    L16:
        IBinder r0 = ServiceManager.getService("poweradvisor");     // Catch: Exception -> L13
        if (r0 != null) goto L8;
        return;
    L8:
        IPowerAdvisor r1 = IPowerAdvisor.Stub.asInterface(r0);     // Catch: Exception -> L13
        if (r1 != null) goto L11;
        return;
    L11:
        r1.userSelectedWhitelistApp(r4, r5);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        logE("notifyPowerAdvisorBackgroundNetworkSelected failed, pkg=" + r4 + ", mode=" + r5, e);
    }

    private final Integer resolveOpsManagerHelperIntMethod(String r4) {
        if (StringsKt.isBlank(r4) == false) goto L12;
        return null;
    L12:
        Object r3 = Class.forName("com.bytedanceos.security.reflect.OpsManagerHelper").getMethod(r4, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if ((r3 instanceof Integer) == true) goto L8;
        r3 = null;
    L8:
        return (Integer) r3;
    L14:
        return null;
    }

    private final void setAppOpModeByField(Context r21, String r22, int r23, String r24, int r25) {
        Context r5 = r21.getApplicationContext();
        Iterator<T> r6 = APP_OPS_MANAGER_CLASS_NAMES.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        String r9 = (String) r6.next();
        Integer r0 = resolveStaticIntField$safecheck_neridaCnRelease(r22, CollectionsKt.listOf(r9));
        if (r0 == null) goto L4;
        int r1 = r0.intValue();
        String r10 = INSTANCE.resolveAppOpsServiceName(r9);
        if (r10 == null) goto L4;
        Object r11 = r5.getSystemService(r10);
        if (r11 == null) goto L4;
        Class.forName(r9).getMethod("setMode", new Class[]{Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(r1), Integer.valueOf(r23), r24, Integer.valueOf(r25)});     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        INSTANCE.logE("set app op failed on " + r9 + ", field=" + r22 + ", pkg=" + r24 + ", uid=" + r23 + ", mode=" + r25, e);
        goto L4
    L17:
        logW("app op " + r22 + " not available or set failed, pkg=" + r24 + ", uid=" + r23 + ", mode=" + r25);
    }

    private final String resolveAppOpsServiceName(String r2) {
        if (Intrinsics.areEqual(r2, ANDROID_APP_SMT_OPS_MANAGER) == true) goto L13;
        return "appops";
    L13:
        Object r3 = Class.forName(CONTEXT_SMT).getDeclaredField(SMT_OPS_SERVICE).get(null);     // Catch: Throwable -> L12
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        return (String) r3;
    L16:
        return null;
    }
}
