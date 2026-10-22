package com.android.settings;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class AllowBindAppWidgetActivity extends AlertActivity implements DialogInterface.OnClickListener {
    private CheckBox mAlwaysUse;
    private int mAppWidgetId;
    private AppWidgetManager mAppWidgetManager;
    private String mCallingPackage;
    private boolean mClicked;
    private ComponentName mComponentName;
    private UserHandle mProfile;

    public AllowBindAppWidgetActivity() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r5, int r6) {
        if (r6 != (-1)) goto L18;
        setResult(0);
        int r7 = this.mAppWidgetId;
        if (r7 == (-1)) goto L18;
        ComponentName r0 = this.mComponentName;
        if (r0 == null) goto L18;
        if (this.mCallingPackage == null) goto L18;
    L14:
        OLog.v("BIND_APPWIDGET", "Error binding widget with id " + this.mAppWidgetId + " and component " + this.mComponentName);
    L15:
        boolean r8 = this.mAlwaysUse.isChecked();
        if (r8 == this.mAppWidgetManager.hasBindAppWidgetPermission(this.mCallingPackage)) goto L18;
        this.mAppWidgetManager.setBindAppWidgetPermission(this.mCallingPackage, r8);
        goto L18
    L11:
        if (this.mAppWidgetManager.bindAppWidgetIdIfAllowed(r7, this.mProfile, r0, null) == false) goto L15;
        Intent r9 = new Intent();     // Catch: Exception -> L14
        r9.putExtra("appWidgetId", this.mAppWidgetId);     // Catch: Exception -> L14
        setResult(-1, r9);     // Catch: Exception -> L14
    L18:
        finish();
    }

    protected void onPause() {
        if (isDestroyed() == true) goto L5;
    L7:
        super.onPause();
        return;
    L5:
        if (this.mClicked == true) goto L7;
        setResult(0);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        Intent r8 = getIntent();
        if (r8 != null) goto L15;
        CharSequence r9 = "";
    L13:
        AlertController.AlertParams r2 = this.mAlertParams;
        r2.mTitle = getString(R.string.allow_bind_app_widget_activity_allow_bind_title);
        r2.mMessage = getString(R.string.allow_bind_app_widget_activity_allow_bind, new Object[]{r9});
        r2.mPositiveButtonText = getString(R.string.create);
        r2.mNegativeButtonText = getString(android.R.string.cancel);
        r2.mPositiveButtonListener = this;
        r2.mNegativeButtonListener = this;
        r2.mView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(android.R.layout.app_error_dialog, null);
        CheckBox r0 = (CheckBox) r2.mView.findViewById(android.R.id.alwaysUse);
        this.mAlwaysUse = r0;
        r0.setText(getString(R.string.allow_bind_app_widget_activity_always_allow_bind, new Object[]{r9}));
        CheckBox r10 = this.mAlwaysUse;
        r10.setPadding(r10.getPaddingLeft(), this.mAlwaysUse.getPaddingTop(), this.mAlwaysUse.getPaddingRight(), (int) (this.mAlwaysUse.getPaddingBottom() + getResources().getDimension(R.dimen.bind_app_widget_dialog_checkbox_bottom_padding)));
        AppWidgetManager r11 = AppWidgetManager.getInstance(this);
        this.mAppWidgetManager = r11;
        this.mAlwaysUse.setChecked(r11.hasBindAppWidgetPermission(this.mCallingPackage, this.mProfile.getIdentifier()));
        setupAlert();
        return;
    L15:
        this.mAppWidgetId = r8.getIntExtra("appWidgetId", -1);     // Catch: Exception -> L10
        UserHandle r3 = (UserHandle) r8.getParcelableExtra("appWidgetProviderProfile");     // Catch: Exception -> L10
        this.mProfile = r3;     // Catch: Exception -> L10
        if (r3 != null) goto L8;
        this.mProfile = Process.myUserHandle();     // Catch: Exception -> L10
    L8:
        this.mComponentName = (ComponentName) r8.getParcelableExtra("appWidgetProvider");     // Catch: Exception -> L10
        this.mCallingPackage = getCallingPackage();     // Catch: Exception -> L10
        PackageManager r12 = getPackageManager();     // Catch: Exception -> L10
        r9 = r12.getApplicationLabel(r12.getApplicationInfo(this.mCallingPackage, 0));     // Catch: Exception -> L10
    L10:
        this.mAppWidgetId = -1;
        this.mComponentName = null;
        this.mCallingPackage = null;
        OLog.v("BIND_APPWIDGET", "Error getting parameters");
        setResult(0);
        finish();
    }
}
