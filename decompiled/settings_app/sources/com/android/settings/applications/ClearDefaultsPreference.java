package com.android.settings.applications;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.usb.IUsbManager;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settingslib.applications.AppUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ClearDefaultsPreference extends Preference {
    protected static final String TAG = "ClearDefaultsPreference";
    private Button mActivitiesButton;
    protected com.android.settingslib.applications.ApplicationsState.AppEntry mAppEntry;
    private AppWidgetManager mAppWidgetManager;
    private String mPackageName;
    private PackageManager mPm;
    private IUsbManager mUsbManager;

    static {
    }

    static /* synthetic */ IUsbManager access$000(ClearDefaultsPreference r0) {
        return r0.mUsbManager;
    }

    static /* synthetic */ String access$100(ClearDefaultsPreference r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ PackageManager access$200(ClearDefaultsPreference r0) {
        return r0.mPm;
    }

    static /* synthetic */ boolean access$300(ClearDefaultsPreference r0, String r1) {
        return r0.isDefaultBrowser(r1);
    }

    static /* synthetic */ AppWidgetManager access$400(ClearDefaultsPreference r0) {
        return r0.mAppWidgetManager;
    }

    static /* synthetic */ void access$500(ClearDefaultsPreference r0, TextView r1) {
        r0.resetLaunchDefaultsUi(r1);
    }

    public ClearDefaultsPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        setLayoutResource(R.layout.app_preferred_settings);
        this.mAppWidgetManager = AppWidgetManager.getInstance(r1);
        this.mPm = r1.getPackageManager();
        this.mUsbManager = IUsbManager.Stub.asInterface(ServiceManager.getService("usb"));
    }

    public ClearDefaultsPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ClearDefaultsPreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ClearDefaultsPreference(Context r2) {
        this(r2, null);
    }

    public void setPackageName(String r1) {
        this.mPackageName = r1;
    }

    public void setAppEntry(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        this.mAppEntry = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(final PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        Button r0 = (Button) r3.findViewById(R.id.clear_activities_button);
        this.mActivitiesButton = r0;
        r0.setOnClickListener(new AnonymousClass1(this, r3));
        updateUI(r3);
    }

    public boolean updateUI(PreferenceViewHolder r12) {
        boolean r0 = this.mAppWidgetManager.hasBindAppWidgetPermission(this.mAppEntry.info.packageName);
        TextView r13 = (TextView) r12.findViewById(R.id.auto_launch);
        if (AppUtils.hasPreferredActivities(this.mPm, this.mPackageName) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        if (r0 == true) goto L14;
        resetLaunchDefaultsUi(r13);
    L37:
        return true;
    L14:
        if (r0 == false) goto L17;
        if (r1 == false) goto L17;
        boolean r4 = true;
    L18:
        if (r0 == false) goto L20;
        r13.setText(R.string.auto_launch_label_generic);
    L21:
        Context r5 = getContext();
        int r6 = r5.getResources().getDimensionPixelSize(R.dimen.installed_app_details_bullet_offset);
        if (r1 == false) goto L27;
        CharSequence r2 = r5.getText(R.string.auto_launch_enable_text);
        SpannableString r9 = new SpannableString(r2);
        if (r4 == false) goto L26;
        r9.setSpan(new BulletSpan(r6), 0, r2.length(), 0);
    L26:
        CharSequence r3 = TextUtils.concat(new CharSequence[]{r9, "\n"});
    L28:
        if (r0 == false) goto L36;
        CharSequence r7 = r5.getText(R.string.always_allow_bind_appwidgets_text);
        SpannableString r8 = new SpannableString(r7);
        if (r4 == false) goto L32;
        r8.setSpan(new BulletSpan(r6), 0, r7.length(), 0);
    L32:
        if (r3 != null) goto L34;
        CharSequence r10 = TextUtils.concat(new CharSequence[]{r8, "\n"});
    L35:
        r3 = r10;
        goto L36
    L34:
        r10 = TextUtils.concat(new CharSequence[]{r3, "\n", r8, "\n"});
    L36:
        r13.setText(r3);
        this.mActivitiesButton.setEnabled(true);
        goto L37
    L27:
        r3 = null;
        goto L28
    L20:
        r13.setText(R.string.auto_launch_label);
    L17:
        r4 = false;
        goto L18
    L5:
        if (isDefaultBrowser(this.mPackageName) == true) goto L10;
        if (AppUtils.hasUsbDefaults(this.mUsbManager, this.mPackageName) == true) goto L10;
        r1 = false;
        goto L11
    }

    private boolean isDefaultBrowser(String r2) {
        return r2.equals(this.mPm.getDefaultBrowserPackageNameAsUser(UserHandle.myUserId()));
    }

    private void resetLaunchDefaultsUi(TextView r2) {
        r2.setText(R.string.auto_launch_disable_text);
        this.mActivitiesButton.setEnabled(false);
    }
}
