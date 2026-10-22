package com.android.settingslib.users;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.android.settingslib.R;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class GrantAdminDialogController {
    public GrantAdminDialogController() {
    }

    public Dialog createDialog(Activity r3, final Consumer<Boolean> r4, final Runnable r5) {
        View r2 = LayoutInflater.from(r3).inflate(R.layout.grant_admin_dialog_content, null);
        final RadioButton r0 = (RadioButton) ((RadioGroup) r2.findViewById(R.id.choose_admin)).findViewById(R.id.grant_admin_yes);
        r0.setChecked(true);
        return new AlertDialog.Builder(r3).setView(r2).setTitle(R.string.user_grant_admin_title).setMessage(R.string.user_grant_admin_message).setPositiveButton(android.R.string.ok, new GrantAdminDialogController$$ExternalSyntheticLambda0(r4, r0)).setNegativeButton(android.R.string.cancel, new GrantAdminDialogController$$ExternalSyntheticLambda1(r5)).setOnCancelListener(new GrantAdminDialogController$$ExternalSyntheticLambda2(r5)).create();
    }

    static /* synthetic */ void lambda$createDialog$0(Consumer r0, RadioButton r1, DialogInterface r2, int r3) {
        if (r0 == null) goto L5;
        r0.accept(Boolean.valueOf(r1.isChecked()));
        return;
    }

    static /* synthetic */ void lambda$createDialog$1(Runnable r0, DialogInterface r1, int r2) {
        if (r0 == null) goto L5;
        r0.run();
        return;
    }

    static /* synthetic */ void lambda$createDialog$2(Runnable r0, DialogInterface r1) {
        if (r0 == null) goto L5;
        r0.run();
        return;
    }
}
