package com.android.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyPolicyDialog extends AlertDialog {
    private CheckBox mCBNextShow;
    private TextView mMessage;

    class PrivacyPolicyClickableSpan extends ClickableSpan {
        final /* synthetic */ PrivacyPolicyDialog this$0;

        @Override // android.text.style.ClickableSpan
        public void onClick(View r1) {
        }

        PrivacyPolicyClickableSpan(PrivacyPolicyDialog r1) {
            this.this$0 = r1;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r1) {
            super.updateDrawState(r1);
        }
    }

    public PrivacyPolicyDialog(Context r1, int r2) {
        super(r1, r2);
        if ((r1 instanceof Activity) == false) goto L5;
        setOwnerActivity((Activity) r1);
    L5:
        init();
    }

    private void init() {
        setTitle(R.string.dlg_title_notice);
        setCanceledOnTouchOutside(false);
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_privacy_policy, null);
        TextView r1 = (TextView) r0.findViewById(R.id.message);
        this.mMessage = r1;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        this.mCBNextShow = (CheckBox) r0.findViewById(R.id.next_show);
        setView(r0);
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence r1) {
        this.mMessage.setText(r1);
    }

    public void setMessage(int r1) {
        this.mMessage.setText(r1);
    }

    public boolean isChecked() {
        return this.mCBNextShow.isChecked();
    }
}
