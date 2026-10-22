package com.bytedanceos.security;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.olog.OLog;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class WriteSettingsActivity extends Activity {
    private static final String ACTION = "android.settings.action.MANAGE_WRITE_SETTINGS";
    private static final String TAG = "WriteSettingsActivity";
    private Drawable mAppIcon;
    private int mAppUid;
    private WriteSettingsPermissionDialog mDialog;
    private boolean mGrantPermission;
    private String mLabel;
    private OpsManagerHelper mOpsManagerHelper;
    private String mPackageName;

    public class WriteSettingsPermissionDialog extends AlertDialog {
        private DialogInterface.OnClickListener mAllowListener;
        private DialogInterface.OnClickListener mDenyListener;
        final /* synthetic */ WriteSettingsActivity this$0;

        public WriteSettingsPermissionDialog(final WriteSettingsActivity this$0, Context context) {
            this.this$0 = this$0;
            super(context, 5);
            this.mDenyListener = new AnonymousClass1(this);
            this.mAllowListener = new AnonymousClass2(this);
            setCancelable(false);
            setupViews(context, context.getResources());
        }

        private void setupViews(Context context, Resources res) {
            LinearLayout r6 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bytedance_permission_dialog, null);
            TextView r0 = (TextView) r6.findViewById(R.id.name);
            TextView r1 = (TextView) r6.findViewById(R.id.detail);
            ImageView r2 = (ImageView) r6.findViewById(R.id.icon);
            WriteSettingsActivity r3 = this.this$0;
            WriteSettingsActivity.access$100(r3, WriteSettingsActivity.access$000(r3));
            if (r0 == null) goto L5;
            r0.setText(WriteSettingsActivity.access$200(this.this$0));
        L5:
            if (r2 == null) goto L7;
            r2.setImageDrawable(WriteSettingsActivity.access$300(this.this$0));
        L7:
            if (r1 == null) goto L9;
            r1.setText(R.string.permission_dialog_write_setting_detail);
        L9:
            setTitle(res.getString(R.string.unknown_app_dialog_alert_title));
            setButtonsForNormal(res);
            setView(r6);
        }

        private void setButtonsForNormal(Resources res) {
            setButton(-1, res.getString(R.string.permission_allow_button), this.mAllowListener);
            setButton(-2, res.getString(R.string.permission_status_deny), this.mDenyListener);
        }
    }

    public WriteSettingsActivity() {
    }

    static /* synthetic */ String access$000(WriteSettingsActivity r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ void access$100(WriteSettingsActivity r0, String r1) {
        r0.initAppInfo(r1);
    }

    static /* synthetic */ String access$200(WriteSettingsActivity r0) {
        return r0.mLabel;
    }

    static /* synthetic */ Drawable access$300(WriteSettingsActivity r0) {
        return r0.mAppIcon;
    }

    static /* synthetic */ int access$400(WriteSettingsActivity r0) {
        return r0.mAppUid;
    }

    static /* synthetic */ OpsManagerHelper access$500(WriteSettingsActivity r0) {
        return r0.mOpsManagerHelper;
    }

    static /* synthetic */ boolean access$602(WriteSettingsActivity r0, boolean r1) {
        r0.mGrantPermission = r1;
        return r1;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent r3 = getIntent();     // Catch: Exception -> L22
        if (TextUtils.equals(ACTION, r3.getAction()) == true) goto L7;
        finish();     // Catch: Exception -> L22
        return;
    L7:
        Uri r4 = r3.getData();     // Catch: Exception -> L22
        if (r4 != null) goto L11;
        finish();     // Catch: Exception -> L22
        return;
    L11:
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();     // Catch: Exception -> L22
        String r5 = r4.getSchemeSpecificPart();     // Catch: Exception -> L22
        this.mPackageName = r5;     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r5) == false) goto L17;
        OLog.d(TAG, "empty package name ");     // Catch: Exception -> L22
        finish();     // Catch: Exception -> L22
        return;
    L17:
        if (hasPermission() == true) goto L20;
        OLog.d(TAG, this.mPackageName + "  has't permission  ");     // Catch: Exception -> L22
        finish();     // Catch: Exception -> L22
        return;
    L20:
        this.mDialog = new WriteSettingsPermissionDialog(this, this);     // Catch: Exception -> L22
        return;
    L22:
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        WriteSettingsPermissionDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L9;
        this.mDialog.show();
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mGrantPermission == false) goto L5;
        setResult(-1);
    L5:
        super.finish();
    }

    private boolean hasPermission() {
        PackageManager r0 = getPackageManager();
        if (r0 != null) goto L19;
        return false;
    L19:
        PackageInfo r5 = r0.getPackageInfo(this.mPackageName, 4096);     // Catch: Exception -> L18
        if (r5 == null) goto L17;
        if (r5.requestedPermissions == null) goto L17;
        String[] r6 = r5.requestedPermissions;     // Catch: Exception -> L18
        int r1 = r6.length;     // Catch: Exception -> L18
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L17;
        if (TextUtils.equals("android.permission.WRITE_SETTINGS", r6[r2]) == true) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return true;
    L17:
        return false;
    }

    private void initAppInfo(String packageName) {
        PackageManager r0 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L8
        if (r0 == null) goto L10;
        ApplicationInfo r1 = r0.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r1 == null) goto L10;
        this.mLabel = (String) r0.getApplicationLabel(r1);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mAppIcon = r0.getApplicationIcon(r1);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mAppUid = r1.uid;     // Catch: PackageManager.NameNotFoundException -> L8
    L10:
        if (TextUtils.isEmpty(this.mLabel) == false) goto L13;
        this.mLabel = getResources().getString(R.string.unknown_app) + packageName;
    L13:
        if (this.mAppIcon != null) goto L18;
        this.mAppIcon = getResources().getDrawable(R.drawable.sym_app_on_sd_unavailable_icon);
        return;
    L18:
        return;
    L8:
        OLog.d(TAG, " not find package =" + packageName);
        goto L10
    }
}
