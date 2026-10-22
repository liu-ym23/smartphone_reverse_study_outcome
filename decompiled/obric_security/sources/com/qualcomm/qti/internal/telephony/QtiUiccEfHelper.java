package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.Rlog;
import com.android.internal.telephony.uicc.IccFileHandler;
import com.android.internal.telephony.uicc.UiccCard;
import com.android.internal.telephony.uicc.UiccCardApplication;
import com.android.internal.telephony.uicc.UiccController;
import com.android.internal.telephony.uicc.UiccProfile;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes4.dex */
public class QtiUiccEfHelper extends Handler {
    protected static final String ACTION_READ_EF_BROADCAST = "com.qualcomm.qti.intent.action.ACTION_READ_EF_RESULT";
    protected static final String ACTION_WRITE_EF_BROADCAST = "com.qualcomm.qti.intent.action.ACTION_WRITE_EF_RESULT";
    private static final String LOG_TAG = "QtiUiccEfHelper";
    private static final int MESSAGE_GET_EF_DONE = 1;
    private static final int MESSAGE_SET_EF_DONE = 2;
    private static Context mContext;

    public QtiUiccEfHelper(Context r2) {
        super(Looper.getMainLooper());
        mContext = r2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r8) {
        Rlog.d(LOG_TAG, "handleMessage what = " + r8.what);
        AsyncResult r7 = (AsyncResult) r8.obj;
        int r1 = r8.what;
        if (r1 != 1) goto L5;
        Intent r2 = new Intent(ACTION_READ_EF_BROADCAST);
        Rlog.d(LOG_TAG, "ef content = " + r7.result + " on slot = " + r8.arg1);
        if (r7.exception == null) goto L14;
        r2.putExtra("exception", true);
    L15:
        r2.putExtra("slot", r8.arg1);
        mContext.sendBroadcast(r2);
        return;
    L14:
        r2.putExtra(WsConstants.KEY_PAYLOAD, (byte[]) r7.result);
        goto L15
    L5:
        if (r1 == 2) goto L7;
        Rlog.w(LOG_TAG, "MessageHandler: unexpected message code: " + r8.what);
        return;
    L7:
        Intent r0 = new Intent(ACTION_WRITE_EF_BROADCAST);
        if (r7.exception == null) goto L10;
        r0.putExtra("exception", true);
    L10:
        r0.putExtra("slot", r8.arg1);
        mContext.sendBroadcast(r0);
    }

    public IccFileHandler loadIccFileHandler(int r3, int r4) {
        UiccCard r2 = UiccController.getInstance().getUiccCard(r3);
        UiccProfile r5 = UiccController.getInstance().getUiccProfileForPhone(r3);
        Rlog.d(LOG_TAG, "card = " + r2);
        if (r2 == null) goto L8;
        if (r5 == null) goto L8;
        UiccCardApplication r6 = r5.getApplication(r4);
        Rlog.d(LOG_TAG, "newUiccApplication = " + r6);
        if (r6 == null) goto L8;
        IccFileHandler r7 = r6.getIccFileHandler();
        Rlog.d(LOG_TAG, "fh = " + r7);
        return r7;
    L8:
        return null;
    }

    public boolean readUiccEf(int r3, int r4, int r5) {
        IccFileHandler r6 = loadIccFileHandler(r3, r4);
        if (r6 == null) goto L6;
        r6.loadEFTransparent(r5, obtainMessage(1, r3, -1));
        return true;
    L6:
        return false;
    }

    public boolean writeUiccEf(int r3, int r4, int r5, byte[] r6) {
        IccFileHandler r7 = loadIccFileHandler(r3, r4);
        if (r7 == null) goto L6;
        r7.updateEFTransparent(r5, r6, obtainMessage(2, r3, -1));
        return true;
    L6:
        return false;
    }
}
