package com.bytedanceos.security;

import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.olog.OLog;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class UnKonownAppSourceActivity extends Activity {
    private static final String TAG = "UnKonownAppSourceActivity";
    private AppInfo mAppInfo;
    private UnkonownAppSourcePermissionDialog mDialog;
    private boolean mGrantPermission;
    private OpsManagerHelper mOpsManagerHelper;
    private String mPackageName;

    class AppInfo {
        Drawable icon;
        String label;
        final /* synthetic */ UnKonownAppSourceActivity this$0;
        int uid;

        AppInfo(final UnKonownAppSourceActivity this$0) {
            this.this$0 = this$0;
        }
    }

    public class UnkonownAppSourcePermissionDialog extends AlertDialog {
        private DialogInterface.OnClickListener mAllowListener;
        private Context mContext;
        private DialogInterface.OnClickListener mDenyListener;
        private String mPackageName;
        final /* synthetic */ UnKonownAppSourceActivity this$0;

        static /* synthetic */ Context access$200(UnkonownAppSourcePermissionDialog r0) {
            return r0.mContext;
        }

        static /* synthetic */ String access$300(UnkonownAppSourcePermissionDialog r0) {
            return r0.mPackageName;
        }

        public UnkonownAppSourcePermissionDialog(final UnKonownAppSourceActivity this$0, Context context, String packageName) {
            this.this$0 = this$0;
            super(context, 5);
            this.mDenyListener = new AnonymousClass1(this);
            this.mAllowListener = new AnonymousClass2(this);
            this.mContext = context;
            this.mPackageName = packageName;
            setCancelable(false);
            setupViews(context, context.getResources());
        }

        private void setupViews(Context context, Resources res) {
            LinearLayout r5 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bytedance_permission_dialog, null);
            TextView r0 = (TextView) r5.findViewById(R.id.name);
            ImageView r1 = (ImageView) r5.findViewById(R.id.icon);
            UnKonownAppSourceActivity.access$002(this.this$0, getAppInfo(this.mPackageName, res));
            if (r0 == null) goto L5;
            r0.setText(UnKonownAppSourceActivity.access$000(this.this$0).label);
        L5:
            if (r1 == null) goto L7;
            r1.setImageDrawable(UnKonownAppSourceActivity.access$000(this.this$0).icon);
        L7:
            setTitle(res.getString(R.string.unknown_app_dialog_alert_title));
            setButtonsForNormal(res);
            setView(r5);
        }

        private AppInfo getAppInfo(String packageName, Resources res) {
            AppInfo r0 = new AppInfo(this.this$0);
            PackageManager r1 = this.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L19
            if (r1 != null) goto L6;
            return r0;
        L6:
            ApplicationInfo r3 = r1.getApplicationInfoAsUser(packageName, 0, UnKonownAppSourceActivity.access$100(this.this$0));     // Catch: PackageManager.NameNotFoundException -> L19
            if (r3 != null) goto L9;
            return r0;
        L9:
            r0.label = (String) r1.getApplicationLabel(r3);     // Catch: PackageManager.NameNotFoundException -> L19
            r0.icon = r1.getApplicationIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L19
            r0.uid = r3.uid;     // Catch: PackageManager.NameNotFoundException -> L19
        L11:
            if (r0.label != null) goto L13;
        L14:
            r0.label = res.getString(R.string.unknown_app) + packageName;
        L16:
            if (r0.icon != null) goto L18;
            r0.icon = Resources.getSystem().getDrawable(R.drawable.sym_app_on_sd_unavailable_icon);
        L18:
            return r0;
        L13:
            if (r0.label.length() != 0) goto L16;
            goto L14
        }

        private void setButtonsForNormal(Resources res) {
            setButton(-1, res.getString(R.string.permission_allow_button), this.mAllowListener);
            setButton(-2, res.getString(R.string.permission_status_deny), this.mDenyListener);
        }
    }

    public UnKonownAppSourceActivity() {
    }

    static /* synthetic */ AppInfo access$000(UnKonownAppSourceActivity r0) {
        return r0.mAppInfo;
    }

    static /* synthetic */ AppInfo access$002(UnKonownAppSourceActivity r0, AppInfo r1) {
        r0.mAppInfo = r1;
        return r1;
    }

    static /* synthetic */ int access$100(UnKonownAppSourceActivity r0) {
        return r0.getOriginatingUid();
    }

    static /* synthetic */ OpsManagerHelper access$400(UnKonownAppSourceActivity r0) {
        return r0.mOpsManagerHelper;
    }

    static /* synthetic */ boolean access$502(UnKonownAppSourceActivity r0, boolean r1) {
        r0.mGrantPermission = r1;
        return r1;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent r3 = getIntent();     // Catch: Exception -> L15
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();     // Catch: Exception -> L15
        if ("android.settings.MANAGE_UNKNOWN_APP_SOURCES".equals(r3.getAction()) == true) goto L7;
        finish();     // Catch: Exception -> L15
        return;
    L7:
        Uri r4 = r3.getData();     // Catch: Exception -> L15
        if (r4 == null) goto L18;
        String r5 = r4.getSchemeSpecificPart();     // Catch: Exception -> L15
        this.mPackageName = r5;     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        OLog.d(TAG, "empty package name ");     // Catch: Exception -> L15
        finish();     // Catch: Exception -> L15
        return;
    L13:
        this.mDialog = new UnkonownAppSourcePermissionDialog(this, this, this.mPackageName);     // Catch: Exception -> L15
        return;
    L18:
        return;
    L15:
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        UnkonownAppSourcePermissionDialog r0 = this.mDialog;
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

    private int getOriginatingUid() {
        int r2 = ActivityManagerNative.getDefault().getLaunchedFromUid(getActivityToken());     // Catch: RemoteException -> L8
        if (r2 <= (-1)) goto L11;
        return UserHandle.getUserId(r2);
    L11:
        return 0;
    L12:
        return 0;
    }
}
