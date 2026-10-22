package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.simplified.ORoundedListItemImage;
import com.obric.oui.simplified.ORoundedListItemSwitch;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DrawOverlayDetailsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int[] APP_OPS_OP_CODES = null;
    public static final String ARG_PACKAGE_NAME = "package";
    private static final String[] PM_PERMISSION = null;
    private AppOpsManager mAppOpsManager;
    private ORoundedListItemImage mItemAppName;
    private PackageInfo mPackageInfo;
    private PackageManager mPackageManager;
    private String mPackageName;
    private ORoundedListItemSwitch mSwitchPermitDrawOverlay;

    public void com_android_settings_applications_DrawOverlayDetailsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DrawOverlayDetailsFragment() {
    }

    static {
        PM_PERMISSION = new String[]{"android.permission.SYSTEM_ALERT_WINDOW"};
        APP_OPS_OP_CODES = new int[]{24};
    }

    public static DrawOverlayDetailsFragment newInstance(Bundle r1) {
        DrawOverlayDetailsFragment r0 = new DrawOverlayDetailsFragment();
        r0.setArguments(r1);
        return r0;
    }

    public void com_android_settings_applications_DrawOverlayDetailsFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        this.mPackageManager = getPackageManager();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_draw_overlay_details, r3, false);
        this.mTitleResId = Integer.valueOf(R.string.permit_draw_overlay);
        ORoundedListItemImage r5 = (ORoundedListItemImage) findViewByIdNullable(R.id.item_text_app_name);
        this.mItemAppName = r5;
        r5.setTrailingImage(getResources().getDrawable(R.drawable.ic_arrow_forward_list_item));
        this.mItemAppName.setOnClickListener(this);
        ORoundedListItemSwitch r6 = (ORoundedListItemSwitch) findViewByIdNullable(R.id.item_switch_permit_draw_overlay);
        this.mSwitchPermitDrawOverlay = r6;
        r6.setTitleString(getString(R.string.permit_draw_overlay));
        this.mSwitchPermitDrawOverlay.setIconVisibility(8);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mSwitchPermitDrawOverlay.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateViews() {
        retrieveAppEntry();
        if (refreshUi() == true) goto L6;
        finish();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mItemAppName) goto L6;
        startAppDetails();
        return;
    }

    private void startAppDetails() {
        if (this.mPackageInfo != null) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        r0.putString("package", this.mPackageName);
        r0.putInt(InstalledAppDetails.ARG_APP_UID, getCallingUid());
        if (this.mTitleResId == null) goto L8;
        r0.putInt("back_text_id", this.mTitleResId.intValue());
    L8:
        InstalledAppDetails r1 = new InstalledAppDetails();
        r1.setArguments(r0);
        start(r1);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mSwitchPermitDrawOverlay.getSwitch()) goto L6;
        setCanDrawOverlay(r3);
        return;
    }

    private void retrieveAppEntry() {
        String r0 = retrievePackageName();
        this.mPackageName = r0;
        if (r0 != null) goto L11;
        OLog.e(this.TAG, "should provide a package name to retrieve app entry.");
        return;
    L11:
        this.mPackageInfo = this.mPackageManager.getPackageInfo(r0, 12864);     // Catch: PackageManager.NameNotFoundException -> L8
        return;
    L8:
        e = move-exception;
        this.mPackageInfo = null;
        OLog.e(this.TAG, "package not found with packageName:" + this.mPackageName, e);
    }

    private String retrievePackageName() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("package");
    L6:
        if (r1 != null) goto L14;
        if (r0 == null) goto L9;
    L11:
        Intent r2 = (Intent) r0.getParcelable("intent");
    L12:
        if (r2 == null) goto L14;
        r1 = r2.getData().getSchemeSpecificPart();
        goto L14
    L9:
        if (getActivity() == null) goto L11;
        r2 = getActivity().getIntent();
    L14:
        if (r1 == null) goto L16;
        return r1;
    L16:
        if (getActivity() != null) goto L18;
        return r1;
    L18:
        if (getActivity().getIntent().getData() != null) goto L20;
        return r1;
    L20:
        return getActivity().getIntent().getData().getSchemeSpecificPart();
    L5:
        r1 = null;
        goto L6
    }

    private AppStateOverlayBridge.OverlayState getOverlayInfo(String r2, int r3) {
        return new AppStateOverlayBridge.OverlayState(getPermissionInfo(r2, r3));
    }

    private AppStateAppOpsBridge.PermissionState getPermissionInfo(String r8, int r9) {
        AppStateAppOpsBridge.PermissionState r0 = new AppStateAppOpsBridge.PermissionState(r8, new UserHandle(UserHandle.getUserId(r9)));
        r0.packageInfo = getPackageManager().getPackageInfoAsUser(r8, 12288, r0.userHandle.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L25
        if (r0.packageInfo != null) goto L6;
        return r0;
    L6:
        String[] r1 = r0.packageInfo.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L25
        int[] r2 = r0.packageInfo.requestedPermissionsFlags;     // Catch: PackageManager.NameNotFoundException -> L25
        if (r1 == null) goto L17;
        int r4 = 0;
    L10:
        if (r4 >= r1.length) goto L17;
        if (doesAnyPermissionMatch(r1[r4], PM_PERMISSION) == false) goto L16;
        r0.permissionDeclared = true;     // Catch: PackageManager.NameNotFoundException -> L25
        if ((r2[r4] & 2) == 0) goto L16;
        r0.staticPermissionGranted = true;     // Catch: PackageManager.NameNotFoundException -> L25
    L16:
        r4 = r4 + 1;     // Catch: PackageManager.NameNotFoundException -> L25
    L17:
        List r10 = this.mAppOpsManager.getOpsForPackage(r9, r8, APP_OPS_OP_CODES);     // Catch: PackageManager.NameNotFoundException -> L25
        if (r10 != null) goto L20;
    L27:
        return r0;
    L20:
        if (r10.size() <= 0) goto L27;
        if (((AppOpsManager.PackageOps) r10.get(0)).getOps().size() <= 0) goto L27;
        r0.appOpMode = ((AppOpsManager.OpEntry) ((AppOpsManager.PackageOps) r10.get(0)).getOps().get(0)).getMode();     // Catch: PackageManager.NameNotFoundException -> L25
    L25:
        e = move-exception;
        OLog.w(this.TAG, "PackageManager is dead. Can't get package info " + r8, e);
        goto L27
    }

    private boolean doesAnyPermissionMatch(String r4, String[] r5) {
        int r3 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        if (r4.equals(r5[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean refreshUi() {
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L5;
        return false;
    L5:
        if (this.mPackageInfo == null) goto L11;
        this.mItemAppName.setContentImage(getAppIconDrawable());
        this.mItemAppName.setTitleString(getAppLabel());
        AppStateOverlayBridge.OverlayState r0 = getOverlayInfo(this.mPackageName, getCallingUid());
        this.mSwitchPermitDrawOverlay.setChecked(r0.isPermissible());
        this.mSwitchPermitDrawOverlay.setEnabled(r0.permissionDeclared);
        return true;
    L11:
        return false;
    }

    private Drawable getAppIconDrawable() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Drawable r1 = r0.applicationInfo.loadIcon(this.mPackageManager);
        if ((r1 instanceof BitmapDrawable) == true) goto L10;
        return r1;
    L10:
        if (UserHandle.getUserId(getCallingUid()) != 10) goto L14;
        r1 = Utils.getDoppelgangerDrawableIcon(this.mContext.getResources(), (BitmapDrawable) r1);
        if ((r1 instanceof BitmapDrawable) == true) goto L14;
        return r1;
    L14:
        Bitmap r2 = ((BitmapDrawable) r1).getBitmap();
        return new BitmapDrawable(this.mContext.getResources(), Utils.resizeAppIcon(r2));
    }

    private CharSequence getAppLabel() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.applicationInfo.loadLabel(this.mPackageManager);
    }

    private void setCanDrawOverlay(boolean r4) {
        if (this.mPackageInfo != null) goto L5;
        return;
    L5:
        AppOpsManager r0 = this.mAppOpsManager;
        int r1 = getCallingUid();
        String r3 = this.mPackageName;
        if (r4 == false) goto L8;
        int r5 = 0;
    L9:
        r0.setMode(24, r1, r3, r5);
        return;
    L8:
        r5 = 2;
        goto L9
    }

    private boolean canDrawOverlay(String r4) {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.mAppOpsManager.noteOpNoThrow(24, r0.applicationInfo.uid, r4) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private int getCallingUid() {
        IBinder r0 = getActivity().getActivityToken();     // Catch: RemoteException -> L4
        return ActivityManager.getService().getLaunchedFromUid(r0);
    L4:
        e = move-exception;
        OLog.w(this.TAG, "Error reporting SAW intent restriction", e);
        return this.mPackageInfo.applicationInfo.uid;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DrawOverlayDetailsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_DrawOverlayDetailsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DrawOverlayDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_DrawOverlayDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DrawOverlayDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_DrawOverlayDetailsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
