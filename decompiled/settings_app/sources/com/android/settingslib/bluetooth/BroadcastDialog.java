package com.android.settingslib.bluetooth;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastDialog extends AlertDialog {
    private static final String TAG = "BroadcastDialog";
    private Context mContext;
    private String mCurrentApp;
    private String mSwitchApp;

    public BroadcastDialog(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        View r11 = View.inflate(this.mContext, R.layout.broadcast_dialog, null);
        Window r0 = getWindow();
        r0.setContentView(r11);
        r0.setWindowAnimations(R.style.Theme_AlertDialog_SettingsLib);
        TextView r1 = (TextView) r11.findViewById(R.id.dialog_title);
        TextView r2 = (TextView) r11.findViewById(R.id.dialog_subtitle);
        r1.setText(this.mContext.getString(R.string.bt_le_audio_broadcast_dialog_title, new Object[]{this.mCurrentApp}));
        r2.setText(this.mContext.getString(R.string.bt_le_audio_broadcast_dialog_sub_title, new Object[]{this.mSwitchApp}));
        Button r3 = (Button) r11.findViewById(R.id.positive_btn);
        Button r4 = (Button) r11.findViewById(R.id.negative_btn);
        Button r12 = (Button) r11.findViewById(R.id.neutral_btn);
        r3.setText(this.mContext.getString(R.string.bt_le_audio_broadcast_dialog_switch_app, new Object[]{this.mSwitchApp}), null);
        r12.setOnClickListener(new BroadcastDialog$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settingslib-bluetooth-BroadcastDialog, reason: not valid java name */
    /* synthetic */ void m740x30e21355(View r2) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "BroadcastDialog dismiss.");
        dismiss();
    }
}
