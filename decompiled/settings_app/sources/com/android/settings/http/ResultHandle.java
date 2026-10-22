package com.android.settings.http;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ResultHandle {
    public static final int RESULT_CODE_CAPTCHA_ERROR = 1302;
    public static final int RESULT_CODE_DECRYPT_FAILED = 1100;
    public static final int RESULT_CODE_EMAIL_FORMAT_ERROR = 1101;
    public static final int RESULT_CODE_PARAMS_ERROR = 1002;
    public static final int RESULT_CODE_PWD_FORMAT_ERROR = 1102;
    public static final int RESULT_CODE_SERVER_MAINTAIN = 901;
    public static final int RESULT_CODE_SUCCESS = 0;
    private static final String TAG = "ResultHandle";

    public ResultHandle() {
    }

    public static int handleResponse(Context r4, byte[] r5) {
        String r0 = new String(r5);
        OLog.d("SendPassword", "handleResponse json string".concat(r0));
        int r6 = -1;
        int r1 = new JSONObject(r0).getInt("errno");     // Catch: JSONException -> L5
    L7:
        OLog.d(TAG, "code:" + r1);
        if (r1 != 0) goto L10;
        r6 = R.string.sendSuccess;
    L23:
        if (r1 >= 1) goto L25;
    L27:
        if (r6 <= 0) goto L29;
        Utils.showShortToast(r4, r4.getString(r6));
    L29:
        return r1;
    L25:
        if (r1 > 900) goto L27;
        OLog.d(TAG, "system error  code:" + r1);
        goto L27
    L10:
        if (r1 != 901) goto L12;
        r6 = R.string.serverGuard;
        goto L23
    L12:
        if (r1 != 1002) goto L14;
    L19:
        OLog.d("", "params error...");
        goto L23
    L14:
        if (r1 == 1302) goto L18;
        switch(r1) {
            case 1100: goto L19;
            case 1101: goto L17;
            case 1102: goto L19;
            default: goto L23;
        };
    L17:
        r6 = R.string.emailFormatError;
        goto L23
    L18:
        r6 = R.string.erroVerificationCode;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = -1;
        goto L7
    }
}
