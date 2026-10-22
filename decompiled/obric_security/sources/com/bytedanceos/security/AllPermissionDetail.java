package com.bytedanceos.security;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.telephony.ISms;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.security.permission.AppSecurityPermissions;
import com.bytedanceos.utils.PermissionUtil;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AllPermissionDetail extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "AllPermissionDetail";
    private LayoutInflater mInflater;
    private String mLabel;
    private List<String> mMenuDialogContent;
    private PackageInfo mPackageInfo;
    private String mPackageName;
    private PackageManager mPm;
    private boolean mShowAppInfo;
    private ISms mSmsManager;
    private int mUid;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public AllPermissionDetail() {
        this.mMenuDialogContent = new ArrayList();
        this.mShowAppInfo = true;
    }

    static /* synthetic */ ISms access$000(AllPermissionDetail r0) {
        return r0.mSmsManager;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_permission_detail);
        this.mSmsManager = ISms.Stub.asInterface(ServiceManager.getService("isms"));
        PackagePermissions r4 = (PackagePermissions) getIntent().getParcelableExtra("detail");
        this.mPackageInfo = (PackageInfo) getIntent().getParcelableExtra(Utils.INTENT_KEY_INFO);
        this.mPm = getPackageManager();
        this.mShowAppInfo = getIntent().getBooleanExtra(Utils.INTENT_KEY_SHOW_ICON, true);
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        if (r4 == null) goto L5;
        this.mUid = r4.getUid();
        this.mPackageName = r4.getPackageName();
        this.mLabel = r4.getLabel();
    L11:
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L14;
        finish();
        return;
    L14:
        setupViews();
        return;
    L5:
        PackageInfo r5 = this.mPackageInfo;
        if (r5 == null) goto L11;
        this.mUid = r5.applicationInfo.uid;
        this.mPackageName = this.mPackageInfo.packageName;
        if (this.mPm == null) goto L11;
        this.mLabel = this.mPackageInfo.applicationInfo.loadLabel(this.mPm).toString();
        goto L11
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L6;
        refreshUI(this.mPackageName);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void setupViews() {
        initTitleBar(false);
    }

    private int getPremiumSmsPermission(String packageName) {
        Uri r1 = Uri.parse("content://com.android.settings.apiprovider");     // Catch: Exception -> L7
        Bundle r4 = getContentResolver().call(r1, "getPremiumSmsPermission", packageName, null);     // Catch: Exception -> L7
        if (r4 == null) goto L12;
        return Integer.parseInt(r4.getString("extra_result"));
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private boolean setAppLabelAndIcon(PackageInfo packageInfo) {
        if (this.mShowAppInfo == false) goto L25;
        if (packageInfo == null) goto L25;
        View r0 = findViewById(R.id.app_snippet);
        if (r0 == null) goto L24;
        r0.setVisibility(0);
        ImageView r3 = (ImageView) r0.findViewById(R.id.app_icon);
        AppEntry r4 = new AppEntry(this, packageInfo.applicationInfo);
        if (r3 == null) goto L11;
        r3.setImageDrawable(r4.getIcon());
    L11:
        ImageView r5 = (ImageView) r0.findViewById(R.id.iv_doppleganger_icon);
        r5.setImageResource(R.color.transparent);
        if (r4.isDoppleganger == false) goto L14;
        r5.setImageResource(R.drawable.oic_doppleganger_badge);
    L14:
        TextView r6 = (TextView) r0.findViewById(R.id.app_name);
        if (r6 == null) goto L17;
        r6.setText(r4.getLabel());
    L17:
        TextView r1 = (TextView) r0.findViewById(R.id.app_size);
        if (r1 == null) goto L24;
        if (packageInfo != null) goto L21;
    L23:
        r1.setVisibility(4);
        goto L24
    L21:
        if (packageInfo.versionName == null) goto L23;
        r1.setText(getString(R.string.version_text, new Object[]{String.valueOf(packageInfo.versionName)}));
    L24:
        return true;
    L25:
        return false;
    }

    private void refreshUI(final String packageName) {
        setAppLabelAndIcon((PackageInfo) getIntent().getParcelableExtra(Utils.INTENT_KEY_INFO));
        LinearLayout r1 = (LinearLayout) findViewById(R.id.permissions_section);
        if (r1 != null) goto L5;
        return;
    L5:
        AppSecurityPermissions r2 = new AppSecurityPermissions(this, packageName);
        int r3 = getPremiumSmsPermission(packageName);
        if (r2.getPermissionCount() > 0) goto L10;
        if (r3 != 0) goto L10;
        r1.setVisibility(8);
    L11:
        TextView r4 = (TextView) r1.findViewById(R.id.security_settings_billing_desc);
        LinearLayout r7 = (LinearLayout) r1.findViewById(R.id.security_settings_billing_list);
        if (r3 == 0) goto L18;
        if (r4 == null) goto L15;
        r4.setVisibility(0);
    L15:
        if (r7 == null) goto L17;
        r7.setVisibility(0);
    L17:
        this.mMenuDialogContent = Arrays.asList(getResources().getStringArray(R.array.security_settings_premium_sms_values));
        ArrayList r5 = new ArrayList();
        View.OnClickListener r6 = new AnonymousClass1(this, packageName);
        View.OnClickListener r8 = new AnonymousClass2(this, packageName);
        View.OnClickListener r9 = new AnonymousClass3(this, packageName);
        r5.add(r6);
        r5.add(r8);
        r5.add(r9);
    L23:
        if (r2.getPermissionCount() <= 0) goto L60;
        LinearLayout r12 = (LinearLayout) r1.findViewById(R.id.security_settings_list);
        if (r12 == null) goto L29;
        r12.removeAllViews();
        r12.addView(r2.getPermissionsView());
        if (PermissionUtil.hasPermission(this.mPm, this.mPackageInfo.packageName, "android.permission.ACCESS_NOTIFICATION_POLICY") == false) goto L29;
        AppSecurityPermissions.PermissionItemView r10 = (AppSecurityPermissions.PermissionItemView) this.mInflater.inflate(R.layout.packageinstaller_app_permission_item, null);
        TextView r11 = (TextView) r10.findViewById(R.id.perm_name);
        TextView r13 = (TextView) r10.findViewById(R.id.perm_desc);
        r11.setText(R.string.manage_zen_access_title);
        r13.setText(R.string.zen_access_warning_dialog_summary);
        r12.addView(r10);
    L29:
        String[] r14 = this.mPm.getPackagesForUid(this.mUid);
        if (r14 == null) goto L60;
        if (r14.length <= 1) goto L60;
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L35:
        if (r16 >= r14.length) goto L43;
        String r17 = r14[r16];
        if (this.mPackageName.equals(r17) == true) goto L42;
        ApplicationInfo r18 = this.mPm.getApplicationInfo(r17, 0);     // Catch: PackageManager.NameNotFoundException -> L62
        if (r18 == null) goto L42;
        r15.add(r18.loadLabel(this.mPm));     // Catch: PackageManager.NameNotFoundException -> L62
    L42:
        r16 = r16 + 1;
        goto L35
    L43:
        int r19 = r15.size();
        if (r19 <= 0) goto L60;
        Resources r20 = getResources();
        if (r19 != 1) goto L48;
        String r110 = ((CharSequence) r15.get(0)).toString();
    L57:
        TextView r21 = (TextView) findViewById(R.id.security_settings_desc);
        if (r21 == null) goto L60;
        r21.setText(r20.getString(R.string.security_settings_desc_multi, new Object[]{this.mLabel, r110}));
        goto L60
    L48:
        if (r19 != 2) goto L50;
        r110 = r20.getString(R.string.join_two_items, new Object[]{r15.get(0), r15.get(1)});
        goto L57
    L50:
        String r22 = ((CharSequence) r15.get(r19 - 2)).toString();
        int r23 = r19 - 3;
    L51:
        if (r23 < 0) goto L56;
        if (r23 != 0) goto L54;
        int r24 = R.string.join_many_items_first;
    L55:
        r22 = r20.getString(r24, new Object[]{r15.get(r23), r22});
        r23 = r23 - 1;
        goto L51
    L54:
        r24 = R.string.join_many_items_middle;
        goto L55
    L56:
        r110 = r20.getString(R.string.join_many_items_last, new Object[]{r22, r15.get(r19 - 1)});
    L60:
        updateViewWidth(R.id.permissions_section);
        return;
    L18:
        if (r4 == null) goto L20;
        r4.setVisibility(8);
    L20:
        if (r7 == null) goto L23;
        r7.setVisibility(8);
    L10:
        r1.setVisibility(0);
        goto L11
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.permissions_section);
    }
}
