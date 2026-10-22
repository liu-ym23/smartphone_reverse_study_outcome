package com.bytedance.wirelesscast;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class LeBoControllerDialog extends AlertDialog {
    private static final String TAG = "LeBoControllerDialog";
    private View mCustomPanelView;
    private final SmtLinkInfo.OnConnectedListener mListener;
    private final String mTitle;

    static /* synthetic */ SmtLinkInfo.OnConnectedListener access$000(LeBoControllerDialog r0) {
        return r0.mListener;
    }

    public LeBoControllerDialog(Context r1, int r2, String r3, SmtLinkInfo.OnConnectedListener r4) {
        super(r1, r2);
        this.mTitle = r3;
        this.mListener = r4;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r4) {
        setTitle(this.mTitle);
        setButton(-2, getContext().getResources().getString(R.string.miniresolver_private_space_messages_information), new AnonymousClass1(this));
        super.onCreate(r4);
    }
}
