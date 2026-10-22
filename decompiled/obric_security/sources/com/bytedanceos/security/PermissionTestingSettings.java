package com.bytedanceos.security;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.security.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionTestingSettings extends Activity {
    public static final int DIALOG_DISABLE_PERMISSION = 1;

    public PermissionTestingSettings() {
    }

    static /* synthetic */ void access$000(PermissionTestingSettings r0) {
        r0.updatePermissionState();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        OCTitleBar r0 = (OCTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L6;
        r0.setCenterText(R.string.app_name);
        return;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        updatePermissionState();
    }

    private void updatePermissionState() {
        SwitchEx r0 = (SwitchEx) findViewById(R.id.item_switcher);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(!OpsManagerHelper.getInstance().getEnabled());
        r0.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int id) {
        if (id == 1) goto L6;
        return null;
    L6:
        if (isFinishing() == false) goto L9;
        return null;
    L9:
        return new AlertDialog.Builder(this, 5).setIconAttribute(R.attr.alertDialogIcon).setTitle(R.string.disable_permission).setMessage(R.string.security_disable_warning_message).setCancelable(false).setPositiveButton(R.string.ok, new AnonymousClass4(this)).setNegativeButton(R.string.cancel, new AnonymousClass3(this)).setOnDismissListener(new AnonymousClass2(this)).create();
    }
}
