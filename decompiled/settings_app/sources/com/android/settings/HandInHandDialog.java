package com.android.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public class HandInHandDialog extends AlertDialog {
    public static final int CLOSE_MOBILE_NETWORK_TYPE = 3;
    public static final int CLOSE_WIFI_TYPE = 1;
    public static final int CONNECT_VPN_TYPE = 5;
    public static final int OPEN_AIRPLANE_TYPE = 0;
    public static final int OPEN_HOTSPOT_TYPE = 4;
    public static final int SWITCH_WIFI_TYPE = 2;
    private Context mContext;

    public HandInHandDialog(Context r1, int r2, DialogInterface.OnClickListener r3, DialogInterface.OnClickListener r4) {
        super(r1);
        this.mContext = r1;
        init(r2, r3, r4);
    }

    private void init(int r2, DialogInterface.OnClickListener r3, DialogInterface.OnClickListener r4) {
        setTitle(getTitle());
        setMessage(getMessage(r2));
        setButton(-1, getRightButtonText(r2), r4);
        setButton(-2, getLeftButtonText(), r3);
    }

    private String getTitle() {
        return this.mContext.getString(R.string.hand_in_hand_dialog_title);
    }

    private String getMessage(int r2) {
        if (r2 == 0) goto L23;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L28;
        if (r2 == 3) goto L27;
        if (r2 == 4) goto L26;
        if (r2 == 5) goto L25;
        return "";
    L25:
        return this.mContext.getString(R.string.hand_in_hand_dialog_create_vpn_message);
    L26:
        return this.mContext.getString(R.string.hand_in_hand_dialog_open_hotspot_message);
    L27:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_mobile_network_message);
    L28:
        return this.mContext.getString(R.string.hand_in_hand_dialog_switch_wifi_message);
    L19:
        if (isMobileDataEnabled() == false) goto L30;
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_wifi_with_mobile_data_message);
    L30:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_wifi_message);
    L23:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_airplane_message);
    }

    private String getRightButtonText(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L22;
        return "";
    L22:
        return this.mContext.getString(R.string.hand_in_hand_dialog_create_vpn_left_text);
    L23:
        return this.mContext.getString(R.string.hand_in_hand_dialog_open_hotspot_left_text);
    L24:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_mobile_network_left_text);
    L25:
        return this.mContext.getString(R.string.hand_in_hand_dialog_switch_wifi_left_text);
    L26:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_wifi_left_text);
    L20:
        return this.mContext.getString(R.string.hand_in_hand_dialog_close_airplane_left_text);
    }

    private String getLeftButtonText() {
        return this.mContext.getString(R.string.hand_in_hand_dialog_cancel_button_text);
    }

    public boolean isMobileDataEnabled() {
        return TelephonyManager.from(this.mContext).getDataEnabled();
    }
}
