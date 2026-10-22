package com.android.settings.specialaccess.fromSpa;

import android.app.AppOpsManager;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.widget.CompoundButton;
import com.android.media.flags.Flags;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateBaseSwitchInterface;
import com.android.settingslib.applications.ApplicationsState;
import com.bytedance.sremlib.LibUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStateMediaRoutingControlBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013H\u0002J \u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0014\u0010'\u001a\u00020\u0013*\u00020&2\u0006\u0010(\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/settings/specialaccess/fromSpa/AppStateMediaRoutingControlBridge;", "Lcom/android/settings/applications/AppStateAppOpsBridge;", "Lcom/android/settings/applications/AppStateBaseSwitchInterface;", "mContext", "Landroid/content/Context;", "appState", "Lcom/android/settingslib/applications/ApplicationsState;", "callback", "Lcom/android/settings/applications/AppStateBaseBridge$Callback;", "(Landroid/content/Context;Lcom/android/settingslib/applications/ApplicationsState;Lcom/android/settings/applications/AppStateBaseBridge$Callback;)V", "mAppOpsManager", "Landroid/app/AppOpsManager;", "packageManager", "Landroid/content/pm/PackageManager;", "permissionManager", "Landroid/permission/PermissionManager;", "roleManager", "Landroid/app/role/RoleManager;", "checkSwitch", "", "entry", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "createPermissionState", "Lcom/android/settings/applications/AppStateAppOpsBridge$PermissionState;", "enableSwitch", "getSwitchOnCheckedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "isPermissionGranted", "isPermissionRequested", "loadAllExtraInfo", "", "setNewState", "newState", "updateExtraInfo", LibUtil.EXCEPTION_APPLICATION, "pkg", "", "uid", "", "hasFlag", "flag", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppStateMediaRoutingControlBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    public static final Companion Companion = null;
    private static final ApplicationsState.AppFilter FILTER_APP_MEDIA_ROUTING_CONTROL = null;
    private static final List<String> IGNORE_PACKAGE_LIST = null;
    private static final int OP_CODE = 0;
    private static final String[] PERMISSIONS = null;
    private static final String TAG = "AppStateMediaRoutingControlBridge";
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;
    private final PackageManager packageManager;
    private final PermissionManager permissionManager;
    private final RoleManager roleManager;

    /* JADX INFO: compiled from: AppStateMediaRoutingControlBridge.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/settings/specialaccess/fromSpa/AppStateMediaRoutingControlBridge$Companion;", "", "()V", "FILTER_APP_MEDIA_ROUTING_CONTROL", "Lcom/android/settingslib/applications/ApplicationsState$AppFilter;", "getFILTER_APP_MEDIA_ROUTING_CONTROL", "()Lcom/android/settingslib/applications/ApplicationsState$AppFilter;", "IGNORE_PACKAGE_LIST", "", "", "getIGNORE_PACKAGE_LIST$annotations", "getIGNORE_PACKAGE_LIST", "()Ljava/util/List;", "OP_CODE", "", "PERMISSIONS", "", "[Ljava/lang/String;", "TAG", "isSystemOrRootUid", "", "uid", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getIGNORE_PACKAGE_LIST$annotations() {
        }

        private Companion() {
        }

        public final List<String> getIGNORE_PACKAGE_LIST() {
            return AppStateMediaRoutingControlBridge.access$getIGNORE_PACKAGE_LIST$cp();
        }

        public final ApplicationsState.AppFilter getFILTER_APP_MEDIA_ROUTING_CONTROL() {
            return AppStateMediaRoutingControlBridge.access$getFILTER_APP_MEDIA_ROUTING_CONTROL$cp();
        }

        public final boolean isSystemOrRootUid(int r3) {
            return CollectionsKt.listOf(new Integer[]{1000, 0}).contains(Integer.valueOf(r3));
        }
    }

    public static /* synthetic */ void $r8$lambda$JO2pVnnYeIim4jsj3ZJ77Pt56aI(AppStateMediaRoutingControlBridge r0, ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        getSwitchOnCheckedListener$lambda$0(r0, r1, r2, r3);
    }

    private final boolean hasFlag(int r1, int r2) {
        if ((r1 & r2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ ApplicationsState.AppFilter access$getFILTER_APP_MEDIA_ROUTING_CONTROL$cp() {
        return FILTER_APP_MEDIA_ROUTING_CONTROL;
    }

    public static final /* synthetic */ List access$getIGNORE_PACKAGE_LIST$cp() {
        return IGNORE_PACKAGE_LIST;
    }

    public AppStateMediaRoutingControlBridge(Context r8, ApplicationsState r9, AppStateBaseBridge.Callback r10) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        super(r8, r9, r10, OP_CODE, PERMISSIONS);
        this.mContext = r8;
        Object r11 = r8.getSystemService("appops");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.AppOpsManager");
        this.mAppOpsManager = (AppOpsManager) r11;
        PackageManager r12 = r8.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r12, "getPackageManager(...)");
        this.packageManager = r12;
        Object r13 = r8.getSystemService(PermissionManager.class);
        Intrinsics.checkNotNull(r13);
        this.permissionManager = (PermissionManager) r13;
        Object r14 = r8.getSystemService(RoleManager.class);
        Intrinsics.checkNotNull(r14);
        this.roleManager = (RoleManager) r14;
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        super.loadAllExtraInfo();
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(ApplicationsState.AppEntry r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, LibUtil.EXCEPTION_APPLICATION);
        Intrinsics.checkNotNullParameter(r3, "pkg");
        r2.extraInfo = getPermissionInfo(r3, r4);
    }

    private final AppStateAppOpsBridge.PermissionState createPermissionState(ApplicationsState.AppEntry r2) {
        AppStateAppOpsBridge.PermissionState r1 = getPermissionInfo(r2.info.packageName, r2.info.uid);
        Intrinsics.checkNotNullExpressionValue(r1, "getPermissionInfo(...)");
        return r1;
    }

    private final void setNewState(ApplicationsState.AppEntry r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 0;
    L5:
        int r0 = r10.info.uid;
        AppOpsManager r1 = this.mAppOpsManager;
        int r2 = OP_CODE;
        r1.setUidMode(r2, r0, r12);
        String r5 = r10.info.packageName;
        String r4 = AppOpsManager.opToPermission(r2);
        if (r4 == null) goto L9;
        this.packageManager.updatePermissionFlags(r4, r5, 1, 1, UserHandle.getUserHandleForUid(r0));
        return;
    L9:
        return;
    L4:
        r12 = 2;
        goto L5
    }

    public final boolean isPermissionRequested(ApplicationsState.AppEntry r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        boolean r0 = Flags.enablePrivilegedRoutingForMediaRoutingControl();
        boolean r1 = !IGNORE_PACKAGE_LIST.contains(r5.info.packageName);
        boolean r4 = this.roleManager.getRoleHolders("android.app.role.COMPANION_DEVICE_WATCH").contains(r5.info.packageName);
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        if (r4 == false) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean isPermissionGranted(ApplicationsState.AppEntry r4) {
        PackageInfo r5 = PackageManager.getPackageInfoAsUserCached(r4.info.packageName, 4096, UserHandle.getUserId(r4.info.uid));
        Intrinsics.checkNotNullExpressionValue(r5, "getPackageInfoAsUserCached(...)");
        String[] r0 = r5.requestedPermissions;
        if (r0 == null) goto L13;
        int r1 = ArraysKt.indexOf(r0, PERMISSIONS[0]);
        if (r1 < 0) goto L14;
        int[] r6 = r5.requestedPermissionsFlags;
        if (r6 == null) goto L12;
        if (hasFlag(r6[r1], 2) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        throw new IllegalStateException("Required value was null.".toString());
    L14:
        return false;
    L13:
        return false;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationsState.AppEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        return new AppStateMediaRoutingControlBridge$$ExternalSyntheticLambda0(this, r2);
    }

    private static final void getSwitchOnCheckedListener$lambda$0(AppStateMediaRoutingControlBridge r0, ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$entry");
        if (r0.createPermissionState(r1) != null) goto L5;
        return;
    L5:
        if (r3 == r0.isPermissionGranted(r1)) goto L9;
        r0.setNewState(r1, r3);
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public boolean enableSwitch(ApplicationsState.AppEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        return isPermissionRequested(r2);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public boolean checkSwitch(ApplicationsState.AppEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        return isPermissionGranted(r2);
    }

    static {
        Companion = new Companion(null);
        OP_CODE = 139;
        PERMISSIONS = new String[]{"android.permission.MEDIA_ROUTING_CONTROL"};
        ArrayList r0 = new ArrayList();
        IGNORE_PACKAGE_LIST = r0;
        r0.add("com.android.systemui");
        FILTER_APP_MEDIA_ROUTING_CONTROL = new AppStateMediaRoutingControlBridge$Companion$FILTER_APP_MEDIA_ROUTING_CONTROL$1();
    }
}
