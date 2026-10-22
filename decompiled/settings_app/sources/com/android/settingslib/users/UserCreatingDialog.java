package com.android.settingslib.users;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.icu.lang.UCharacter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class UserCreatingDialog extends AlertDialog {
    public UserCreatingDialog(Context r2) {
        this(r2, false);
    }

    public UserCreatingDialog(Context r2, boolean r3) {
        super(r2, R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        inflateContent(r3);
        getWindow().setType(2010);
        WindowManager.LayoutParams r4 = getWindow().getAttributes();
        r4.privateFlags = UCharacter.UnicodeBlock.TANGUT_ID;
        getWindow().setAttributes(r4);
    }

    private void inflateContent(boolean r4) {
        setCancelable(false);
        View r0 = LayoutInflater.from(getContext()).inflate(com.android.settingslib.R.layout.user_creation_progress_dialog, null);
        Context r1 = getContext();
        if (r4 == false) goto L5;
        int r5 = com.android.settingslib.R.string.creating_new_guest_dialog_message;
    L6:
        String r6 = r1.getString(r5);
        r0.setAccessibilityPaneTitle(r6);
        ((TextView) r0.findViewById(com.android.settingslib.R.id.message)).setText(r6);
        setView(r0);
        return;
    L5:
        r5 = com.android.settingslib.R.string.creating_new_user_dialog_message;
        goto L6
    }
}
