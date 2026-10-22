package com.android.settings.inputmethod;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.R;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryAddWordActivity extends AlertActivity implements DialogInterface.OnClickListener, TextWatcher {
    static final int CODE_ALREADY_PRESENT = 2;
    static final int CODE_CANCEL = 1;
    static final int CODE_WORD_ADDED = 0;
    public static final String MODE_EDIT_ACTION = "com.android.settings.USER_DICTIONARY_EDIT";
    public static final String MODE_INSERT_ACTION = "com.android.settings.USER_DICTIONARY_INSERT";
    private UserDictionaryAddWordContents mContents;
    private AlertController.AlertParams p;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public UserDictionaryAddWordActivity() {
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Intent r0 = getIntent();
        String r1 = r0.getAction();
        if (MODE_EDIT_ACTION.equals(r1) == false) goto L6;
        int r2 = 0;
    L8:
        Bundle r3 = r0.getExtras();
        if (r3 != null) goto L12;
        finish();
        return;
    L12:
        r3.putInt("mode", r2);
        if (r4 == null) goto L15;
        r3.putAll(r4);
    L15:
        setupDialog();
        this.mContents = new UserDictionaryAddWordContents(this.p.mView, r3);
        return;
    L6:
        if (MODE_INSERT_ACTION.equals(r1) == false) goto L17;
        r2 = 1;
        goto L8
    L17:
        finish();
    }

    private void setupDialog() {
        AlertController.AlertParams r0 = this.mAlertParams;
        this.p = r0;
        r0.mTitle = getString(R.string.user_dict_settings_add_dialog_title);
        AlertController.AlertParams r1 = this.p;
        r1.mView = initContentView();
        AlertController.AlertParams r2 = this.p;
        r2.mPositiveButtonText = getString(R.string.ok);
        this.p.mPositiveButtonListener = this;
        AlertController.AlertParams r3 = this.p;
        r3.mNegativeButtonText = getString(R.string.cancel);
        this.p.mNegativeButtonListener = this;
        setupAlert();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View initContentView() {
        View r0 = LayoutInflater.from(this).inflate(R.layout.dialog_edittext, null);
        OEditText r1 = ((OInputView) r0.findViewById(R.id.edittext)).getVInput();
        r1.requestFocus();
        r1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        r1.addTextChangedListener(this);
        return r0;
    }

    public void onSaveInstanceState(Bundle r1) {
        this.mContents.saveStateIntoBundle(r1);
    }

    private void reportBackToCaller(int r2, Bundle r3) {
        Intent r1 = getIntent();
        if (r1.getExtras() != null) goto L5;
        return;
    L5:
        Object r4 = r1.getExtras().get("listener");
        if ((r4 instanceof Messenger) == true) goto L8;
        return;
    L8:
        Messenger r5 = (Messenger) r4;
        Message r0 = Message.obtain();
        r0.obj = r3;
        r0.what = r2;
        r5.send(r0);     // Catch: RemoteException -> L11
        return;
    }

    public void onClickCancel(View r2) {
        reportBackToCaller(1, null);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onClickConfirm(View r2) {
        Bundle r3 = new Bundle();
        reportBackToCaller(this.mContents.apply(this, r3), r3);
        finish();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (r3 != (-2)) goto L5;
        onClickCancel(null);
        return;
    L5:
        if (r3 != (-1)) goto L11;
        onClickConfirm(null);
        return;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        Button r1 = (Button) getWindow().findViewById(android.R.id.button1);
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        r1.setEnabled(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }
}
