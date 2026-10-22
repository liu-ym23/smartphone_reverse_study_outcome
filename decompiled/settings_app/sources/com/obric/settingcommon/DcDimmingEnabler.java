package com.obric.settingcommon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class DcDimmingEnabler extends DefaultSettingsEnabler {
    public DcDimmingEnabler(Context r1, OSwitch r2, SwitchItemValue r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    public DcDimmingEnabler(Context r1, OSwitch r2, SwitchItemValue r3) {
        super(r1, r2, r3);
    }

    @Override // com.obric.settingcommon.DefaultSettingsEnabler, com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if ((r2.getContext() instanceof Activity) == false) goto L5;
        showDCDimmingTips((Activity) r2.getContext(), r3, r2);
        return;
    L5:
        setEnabled(r3);
    }

    private void showDCDimmingTips(Activity r2, final boolean r3, final CompoundButton r4) {
        if (r3 != isEnabled()) goto L5;
        return;
    L5:
        showDCDimmingTips(r2, r3, new DcDimmingEnabler$$ExternalSyntheticLambda3(this, r3, r4)).show();
    }

    /* JADX INFO: renamed from: lambda$showDCDimmingTips$0$com-obric-settingcommon-DcDimmingEnabler, reason: not valid java name */
    /* synthetic */ void m1473xbd44c39f(boolean r2, CompoundButton r3, DialogInterface r4, int r5) {
        if (r5 != (-1)) goto L5;
        setEnabled(r2);
        r4.dismiss();
        return;
    L5:
        r3.setChecked(!r2);
        r4.dismiss();
    }

    public static OAlertDialog showDCDimmingTips(Activity r4, boolean r5, final DialogInterface.OnClickListener r6) {
        if (r5 == false) goto L4;
        int r0 = R.string.switch_on_text;
    L5:
        String r1 = r4.getString(r0);
        if (r5 == false) goto L8;
        int r2 = R.string.dc_dimming_dialog_open;
    L9:
        String r3 = r4.getString(r2);
        if (r5 == false) goto L12;
        int r7 = R.string.dc_dimming_dialog_open_message;
    L14:
        return (OAlertDialog) new OAlertDialogBuilder(r4).title(r3, false).message(r4.getString(r7)).horizontalButton(!r5).positiveButton(r1, new DcDimmingEnabler$$ExternalSyntheticLambda0(r6)).negativeButton(R.string.activate_dlg_negative, new DcDimmingEnabler$$ExternalSyntheticLambda1(r6)).onCancel(new DcDimmingEnabler$$ExternalSyntheticLambda2(r6)).createDialog();
    L12:
        r7 = R.string.dc_dimming_dialog_close_message;
        goto L14
    L8:
        r2 = R.string.dc_dimming_dialog_close;
        goto L9
    L4:
        r0 = R.string.dlg_close;
        goto L5
    }

    static /* synthetic */ void lambda$showDCDimmingTips$1(DialogInterface.OnClickListener r0, DialogInterface r1, int r2) {
        r0.onClick(r1, -1);
    }

    static /* synthetic */ void lambda$showDCDimmingTips$2(DialogInterface.OnClickListener r0, DialogInterface r1, int r2) {
        r0.onClick(r1, -2);
    }

    static /* synthetic */ void lambda$showDCDimmingTips$3(DialogInterface.OnClickListener r1, DialogInterface r2) {
        r1.onClick(r2, -2);
    }
}
