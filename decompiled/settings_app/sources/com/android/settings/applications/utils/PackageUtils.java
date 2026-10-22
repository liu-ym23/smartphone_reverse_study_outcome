package com.android.settings.applications.utils;

import android.app.Activity;
import android.app.admin.DeviceAdminInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.lifecycle.LifecycleOwner;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.applications.AppStateAlarmsAndRemindersBridge;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateInstallAppsBridge;
import com.android.settings.applications.AppStateInteractAcrossProfilesBridge;
import com.android.settings.applications.AppStateLocaleBridge;
import com.android.settings.applications.AppStateLongBackgroundTasksBridge;
import com.android.settings.applications.AppStateManageExternalStorageBridge;
import com.android.settings.applications.AppStateMediaManagementAppsBridge;
import com.android.settings.applications.AppStateNotificationBridge;
import com.android.settings.applications.AppStateOverlayBridge;
import com.android.settings.applications.AppStateTurnScreenOnBridge;
import com.android.settings.applications.AppStateUsageBridge;
import com.android.settings.applications.AppStateWriteSettingsBridge;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.manageapplications.AppFilterRegistry;
import com.android.settings.applications.manageapplications.ManageApplications;
import com.android.settings.nfc.AppStateNfcTagAppsBridge;
import com.android.settings.specialaccess.notificationaccess.NotificationAccessSettingsActivity;
import com.android.settings.specialaccess.pictureinpicture.PictureInPictureSettingsActivity;
import com.android.settings.specialaccess.vrlistener.VrListenersSettingsActivity;
import com.android.settings.specialaccess.zenaccess.ZenAccessController;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.android.settings.wifi.AppStateChangeWifiStateBridge;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.applications.ServiceListing;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.olog.OLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: PackageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JC\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020 2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020 JC\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020 2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!JC\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020 2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J9\u0010*\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152)\u0010\u001a\u001a%\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020+\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\"2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0019H\u0002J$\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020\u0019\u0018\u0001000\"2\u0006\u0010\u001e\u001a\u00020 JC\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020 2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J~\u00103\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00105\u001a\u0002062)\b\u0002\u00107\u001a#\u0012\u0017\u0012\u001508R\u00020\u0017¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0013\u0018\u00010!2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J9\u0010:\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152)\u0010\u001a\u001a%\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020+\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J\u0016\u0010;\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020 J\u001e\u0010<\u001a\u00020\u001d2\f\u00109\u001a\b\u0018\u000108R\u00020\u00172\u0006\u00105\u001a\u000206H\u0002J\u001c\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@H\u0002Ja\u0010B\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u0001042\u0006\u0010D\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2+\u0010\u001a\u001a'\u0012\u001d\u0012\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!H\u0002J\"\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/android/settings/applications/utils/PackageUtils;", "", "()V", "DEFAULT_WHITE_SET", "", "", "GET_ACTIVITIES_FLAGS", "Landroid/content/pm/PackageManager$PackageInfoFlags;", "TAG", "handler", "Landroid/os/Handler;", "readyList", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "filterWhiteAppEntries", "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "entries", "getBridge", "Lcom/android/settings/applications/AppStateBaseBridge;", "context", "Landroid/content/Context;", "applicationsState", "Lcom/android/settingslib/applications/ApplicationsState;", ManageApplications.EXTRA_LIST_TYPE, "", "callback", "Lcom/android/settings/applications/AppStateBaseBridge$Callback;", "getDataSaverAppList", "", "activity", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/app/Activity;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", OcrAppInfoColumn.TABLE_NAME, "getDeviceList", "Landroid/app/admin/DeviceAdminInfo;", "getFullScreenAppList", "getMediaRoutingAppList", "getNotificationAppList", "Landroid/content/pm/ServiceInfo;", "getPackageAndActivityInfoList", "Landroid/content/pm/PackageInfo;", AccountInfoBundleKey.USER_ID, "getPicInPicAppList", "Lkotlin/Pair;", "Landroid/content/pm/ApplicationInfo;", "getSmsAppList", "getTypeAppList", "Lcom/android/settings/applications/utils/PackageService;", "filter", "Lcom/android/settingslib/applications/ApplicationsState$AppFilter;", "initBridge", "Lcom/android/settingslib/applications/ApplicationsState$Session;", "session", "getVRAppList", "getZenAppList", "handleRebuild", "packageNameEquals", "", "info1", "Landroid/content/pm/PackageItemInfo;", "info2", "rebuildComplete", "packageService", "filterType", "removeDuplicateIgnoringUser", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PackageUtils {
    private static final Set<String> DEFAULT_WHITE_SET = null;
    private static final PackageManager.PackageInfoFlags GET_ACTIVITIES_FLAGS = null;
    public static final PackageUtils INSTANCE = null;
    public static final String TAG = "PackageUtils";
    private static final Handler handler = null;
    private static final LinkedList<Runnable> readyList = null;

    /* JADX INFO: renamed from: $r8$lambda$T8RehAXEwFPWSvf8hr-BmUxGdWM, reason: not valid java name */
    public static /* synthetic */ void m316$r8$lambda$T8RehAXEwFPWSvf8hrBmUxGdWM(ApplicationsState.Session r0, ApplicationsState.AppFilter r1) {
        handleRebuild$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$TqL4DOoBw5PrVm5_Ijmews3x6ME(Function1 r0, List r1) {
        getNotificationAppList$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$XdKdNdKH9djkhEzNgQ1H_blFlq4(Function1 r0, List r1) {
        getVRAppList$lambda$1(r0, r1);
    }

    public final void getDataSaverAppList(LifecycleOwner r1, Activity r2, Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    public final void getFullScreenAppList(LifecycleOwner r1, Activity r2, Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    public final void getMediaRoutingAppList(LifecycleOwner r1, Activity r2, Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    public final void getSmsAppList(LifecycleOwner r1, Activity r2, Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    private PackageUtils() {
    }

    public static final /* synthetic */ void access$handleRebuild(PackageUtils r0, ApplicationsState.Session r1, ApplicationsState.AppFilter r2) {
        r0.handleRebuild(r1, r2);
    }

    public static final /* synthetic */ void access$rebuildComplete(PackageUtils r0, PackageService r1, int r2, int r3, ArrayList r4, Function1 r5) {
        r0.rebuildComplete(r1, r2, r3, r4, r5);
    }

    static {
        INSTANCE = new PackageUtils();
        DEFAULT_WHITE_SET = new PackageUtils$DEFAULT_WHITE_SET$1();
        handler = new Handler(Looper.getMainLooper());
        readyList = new LinkedList();
        PackageManager.PackageInfoFlags r0 = PackageManager.PackageInfoFlags.of(1);
        Intrinsics.checkNotNullExpressionValue(r0, "of(...)");
        GET_ACTIVITIES_FLAGS = r0;
    }

    public final List<DeviceAdminInfo> getDeviceList(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        ArrayList r1 = new ArrayList();
        HashSet r2 = new HashSet();
        PackageManager r3 = r10.getPackageManager();
        Object r4 = r10.getSystemService("device_policy");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        List<ComponentName> r5 = ((DevicePolicyManager) r4).getActiveAdmins();
        int r6 = 0;
        if (r5 == null) goto L7;
        int r7 = r5.size();
        int r8 = 0;
    L5:
        if (r8 >= r7) goto L7;
        r2.add(r5.get(r8));
        r8 = r8 + 1;
    L7:
        List<ResolveInfo> r9 = r3.queryBroadcastReceivers(new Intent("android.app.action.DEVICE_ADMIN_ENABLED"), 128);
        Intrinsics.checkNotNullExpressionValue(r9, "queryBroadcastReceivers(...)");
        int r11 = r9.size();
    L8:
        if (r6 >= r11) goto L22;
        ResolveInfo r12 = r9.get(r6);
        DeviceAdminInfo r13 = new DeviceAdminInfo(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        if (r13.isVisible() == false) goto L13;
    L14:
        r1.add(r13);     // Catch: IOException -> L16 XmlPullParserException -> L18
    L20:
        r6 = r6 + 1;
        goto L8
    L13:
        if (r2.contains(r13.getComponent()) == false) goto L20;
    L16:
        e = move-exception;
        OLog.w(TAG, "Skipping " + r12.activityInfo, e);
    L18:
        e = move-exception;
        OLog.w(TAG, "Skipping " + r12.activityInfo, e);
        goto L20
    L22:
        return r1;
    }

    public final List<ApplicationInfo> getZenAppList(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        PackageManager r3 = r4.getPackageManager();
        ArrayList r5 = new ArrayList();
        Set<String> r0 = ZenAccessController.getPackagesRequestingNotificationPolicyAccess();
        if (r0.isEmpty() == true) goto L11;
        List<ApplicationInfo> r6 = r3.getInstalledApplications(0);
        Intrinsics.checkNotNullExpressionValue(r6, "getInstalledApplications(...)");
        Iterator<ApplicationInfo> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        ApplicationInfo r1 = r7.next();
        if (r0.contains(r1.packageName) == false) goto L6;
        r5.add(r1);
    L11:
        return r5;
    }

    private final List<PackageInfo> getPackageAndActivityInfoList(Activity r1, int r2) {
        List<PackageInfo> r0 = r1.getPackageManager().getInstalledPackagesAsUser(GET_ACTIVITIES_FLAGS, r2);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L4
        return r0;
    L4:
        e = move-exception;
        OLog.e(TAG, "getPackageAndActivityInfoList Exception while getInstalledPackagesAsUser", e);
        return CollectionsKt.emptyList();
    }

    public final List<Pair<ApplicationInfo, Integer>> getPicInPicAppList(Activity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        r9.getPackageManager();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Object r2 = r9.getSystemService(PickApplicationActivity.EXTRA_USER);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.UserManager");
        Iterator r3 = ((UserManager) r2).getProfiles(UserHandle.myUserId()).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(((UserInfo) r3.next()).id));
        goto L4
    L6:
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        Integer r5 = (Integer) r4.next();
        Intrinsics.checkNotNull(r5);
        Iterator<PackageInfo> r6 = getPackageAndActivityInfoList(r9, r5.intValue()).iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        PackageInfo r7 = r6.next();
        PictureInPictureSettingsActivity.Companion r8 = PictureInPictureSettingsActivity.Companion;
        String r10 = r7.packageName;
        Intrinsics.checkNotNullExpressionValue(r10, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        if (r8.checkPackageHasPictureInPictureActivities(r10, r7.activities) == false) goto L11;
        r0.add(new Pair(r7.applicationInfo, r5));
        goto L11
    L16:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackageService getTypeAppList$default(PackageUtils r7, LifecycleOwner r8, Activity r9, int r10, ApplicationsState.AppFilter r11, Function1 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L6;
        r12 = null;
    L6:
        return r7.getTypeAppList(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, com.android.settingslib.applications.ApplicationsState$Session] */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, com.android.settings.applications.utils.PackageService] */
    public final PackageService getTypeAppList(LifecycleOwner r17, Activity r18, final int r19, ApplicationsState.AppFilter r20, Function1<? super ApplicationsState.Session, ? extends AppStateBaseBridge> r21, final Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r22) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r20, "filter");
        Intrinsics.checkNotNullParameter(r22, "callback");
        r18.getPackageManager();
        ApplicationsState r11 = ApplicationsState.getInstance(r18.getApplication());
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        ApplicationsState.CompoundFilter r2 = new ApplicationsState.CompoundFilter(r20, ApplicationsState.FILTER_PERSONAL);
        if (r19 != 5) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L12:
        final ApplicationsState.CompoundFilter r13 = new ApplicationsState.CompoundFilter(r2, ApplicationsState.FILTER_NOT_HIDE);
        final int r3 = AppFilterRegistry.getInstance().getDefaultFilterType(r19);
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r12.element = r11.newSession(new AnonymousClass1(r14, r3, r19, r22, r13, r12), r17.getLifecycle());
        if (r21 != null) goto L15;
        Intrinsics.checkNotNull(r11);
        AppStateBaseBridge r0 = getBridge(r18, r11, r19, new AnonymousClass2(r19, r13, r14, r12));
    L16:
        r14.element = new PackageService(r0, (ApplicationsState.Session) r12.element);
        return (PackageService) r14.element;
    L15:
        r0 = r21.invoke(r12.element);
        goto L16
    L8:
        if (ManageApplications.LIST_TYPES_WITH_INSTANT.contains(Integer.valueOf(r19)) == false) goto L10;
        ApplicationsState.CompoundFilter r4 = new ApplicationsState.CompoundFilter(r2, ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT);
    L11:
        r2 = r4;
        goto L12
    L10:
        r4 = new ApplicationsState.CompoundFilter(r2, ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER);
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private final void handleRebuild(final ApplicationsState.Session r2, final ApplicationsState.AppFilter r3) {
        LinkedList<Runnable> r1 = readyList;
        r1.add(new PackageUtils$$ExternalSyntheticLambda0(r2, r3));
        if (r1.size() <= 1) goto L8;
        Runnable r4 = r1.pop();
        if (r4 == null) goto L9;
        r4.run();
        return;
    L9:
        return;
    }

    private static final void handleRebuild$lambda$0(ApplicationsState.Session r1, ApplicationsState.AppFilter r2) {
        Intrinsics.checkNotNullParameter(r2, "$filter");
        if (r1 == null) goto L6;
        r1.rebuild(r2, ApplicationsState.ALPHA_COMPARATOR);
        return;
    }

    private final void rebuildComplete(PackageService r4, int r5, int r6, ArrayList<ApplicationsState.AppEntry> r7, Function1<? super List<? extends ApplicationsState.AppEntry>, Unit> r8) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L10;
        return;
    L10:
        if (r5 != 17) goto L12;
        r7 = filterWhiteAppEntries(r7);
    L12:
        if (r5 == 0) goto L15;
        if (r5 == 1) goto L15;
    L16:
        StringBuilder r3 = new StringBuilder().append(r6).append(": onRebuildComplete filteredEntries size = ");
        if (r7 == null) goto L19;
        Integer r9 = Integer.valueOf(r7.size());
    L20:
        OLog.e(TAG, r3.append(r9).toString());
        if (r8 == null) goto L23;
        r8.invoke(r7);
    L23:
        if (r4 == null) goto L26;
        r4.reset();
        return;
    L26:
        return;
    L19:
        r9 = null;
    L15:
        r7 = removeDuplicateIgnoringUser(r7);
        goto L16
    L5:
        if (r4.isUpdating() != true) goto L7;
        r0 = true;
        goto L7
    }

    private final ArrayList<ApplicationsState.AppEntry> filterWhiteAppEntries(ArrayList<ApplicationsState.AppEntry> r4) {
        if (r4 == null) goto L4;
        ArrayList<ApplicationsState.AppEntry> r3 = new ArrayList();
        Iterator<ApplicationsState.AppEntry> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        ApplicationsState.AppEntry r0 = r5.next();
        Set<String> r1 = DEFAULT_WHITE_SET;
        if (r0 == null) goto L13;
        ApplicationInfo r2 = r0.info;
        if (r2 == null) goto L13;
        String r6 = r2.packageName;
    L15:
        if (r1.contains(r6) == true) goto L7;
        r3.add(r0);
    L13:
        r6 = null;
        goto L15
    L17:
        return r3;
    L4:
        return new ArrayList();
    }

    private final ArrayList<ApplicationsState.AppEntry> removeDuplicateIgnoringUser(ArrayList<ApplicationsState.AppEntry> r8) {
        if (r8 == null) goto L4;
        int r0 = r8.size();
        ArrayList<ApplicationsState.AppEntry> r1 = new ArrayList(r0);
        int r3 = 0;
        ApplicationInfo r4 = null;
    L6:
        if (r3 >= r0) goto L15;
        ApplicationsState.AppEntry r5 = r8.get(r3);
        if (r5 == null) goto L10;
        ApplicationInfo r6 = r5.info;
    L11:
        ApplicationInfo r7 = r6;
        if (packageNameEquals(r4, r7) == true) goto L14;
        r1.add(r5);
    L14:
        r3 = r3 + 1;
        r4 = r7;
        goto L6
    L10:
        r6 = null;
        goto L11
    L15:
        r1.trimToSize();
        return r1;
    L4:
        return new ArrayList();
    }

    private final boolean packageNameEquals(PackageItemInfo r2, PackageItemInfo r3) {
        if (r2 == null) goto L13;
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r2.packageName != null) goto L9;
        return false;
    L9:
        if (r3.packageName != null) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(r2.packageName, r3.packageName);
    L13:
        return false;
    }

    private final AppStateBaseBridge getBridge(Context r8, ApplicationsState r9, int r10, AppStateBaseBridge.Callback r11) {
        switch(r10) {
            case 1: goto L18;
            case 2: goto L3;
            case 3: goto L3;
            case 4: goto L32;
            case 5: goto L3;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L3;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L3;
            case 16: goto L23;
            case 17: goto L3;
            case 18: goto L22;
            case 19: goto L21;
            case 20: goto L3;
            case 21: goto L20;
            default: goto L3;
        };
    L3:
        return null;
    L20:
        return new AppStateInteractAcrossProfilesBridge(r8, r9, r11);
    L21:
        return new AppStateTurnScreenOnBridge(r8, r9, r11);
    L22:
        return new AppStateNfcTagAppsBridge(r8, r9, r11);
    L23:
        return new AppStateLongBackgroundTasksBridge(r8, r9, r11);
    L24:
        return new AppStateLocaleBridge(r8, r9, r11, (UserManager) r8.getSystemService(UserManager.class));
    L25:
        return new AppStateMediaManagementAppsBridge(r8, r9, r11);
    L26:
        return new AppStateAlarmsAndRemindersBridge(r8, r9, r11);
    L27:
        return new AppStateManageExternalStorageBridge(r8, r9, r11);
    L28:
        return new AppStateChangeWifiStateBridge(r8, r9, r11);
    L29:
        return new AppStateInstallAppsBridge(r8, r9, r11);
    L30:
        return new AppStateWriteSettingsBridge(r8, r9, r11);
    L31:
        return new AppStateOverlayBridge(r8, r9, r11);
    L32:
        return new AppStateUsageBridge(r8, r9, r11);
    L18:
        return new AppStateNotificationBridge(r8, r9, r11, null, (UserManager) r8.getSystemService(UserManager.class), null);
    }

    public final void getVRAppList(Context r1, final Function1<? super List<? extends ServiceInfo>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "callback");
        new ServiceListing.Builder(r1).setPermission(VrListenersSettingsActivity.CONFIG.permission).setIntentAction(VrListenersSettingsActivity.CONFIG.intentAction).setNoun(VrListenersSettingsActivity.CONFIG.noun).setSetting(VrListenersSettingsActivity.CONFIG.setting).setTag(VrListenersSettingsActivity.CONFIG.tag).build().addCallback(new PackageUtils$$ExternalSyntheticLambda2(r2));
    }

    private static final void getVRAppList$lambda$1(Function1 r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        r1.invoke(r2);
    }

    public final void getNotificationAppList(Context r1, final Function1<? super List<? extends ServiceInfo>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "callback");
        new ServiceListing.Builder(r1).setPermission(NotificationAccessSettingsActivity.CONFIG.permission).setIntentAction(NotificationAccessSettingsActivity.CONFIG.intentAction).setNoun(NotificationAccessSettingsActivity.CONFIG.noun).setSetting(NotificationAccessSettingsActivity.CONFIG.setting).setTag(NotificationAccessSettingsActivity.CONFIG.tag).build().addCallback(new PackageUtils$$ExternalSyntheticLambda1(r2));
    }

    private static final void getNotificationAppList$lambda$2(Function1 r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        r1.invoke(r2);
    }
}
