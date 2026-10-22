package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedanceos.numberassistant.PhoneNumberAssistantProxy;
import com.bytedanceos.numberassistant.QueryCallerIdCallback;
import com.bytedanceos.numberassistant.SMSCallerIdDetail;
import com.bytedanceos.numberassistant.xysdk.XySdkCallBack;

/* JADX INFO: loaded from: classes2.dex */
public class CootekManager {
    private static final int MAX_RETRY_COUNT = 5;
    private static final String TAG = "CootekManager";
    private static boolean mIsConnected;
    private static PhoneNumberAssistantProxy.BindCallBack sBindCallBack;
    private static CootekManager sCootekManager;
    private static PhoneNumberAssistantProxy sCootekProxy;
    private static int sRetryCount;

    public CootekManager() {
    }

    static /* synthetic */ int access$000() {
        return sRetryCount;
    }

    static /* synthetic */ int access$002(int r0) {
        sRetryCount = r0;
        return r0;
    }

    static /* synthetic */ int access$008() {
        int r0 = sRetryCount;
        sRetryCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ PhoneNumberAssistantProxy access$100() {
        return sCootekProxy;
    }

    static /* synthetic */ boolean access$202(boolean r0) {
        mIsConnected = r0;
        return r0;
    }

    static {
        sCootekManager = new CootekManager();
        sRetryCount = 0;
        mIsConnected = false;
    }

    public static void init(Context context) {
        final Context r0 = context.getApplicationContext();
        sBindCallBack = new AnonymousClass1(r0);
        PhoneNumberAssistantProxy r1 = new PhoneNumberAssistantProxy();
        sCootekProxy = r1;
        r1.bind(context, sBindCallBack);
    }

    public static CootekManager getInstance() {
        return sCootekManager;
    }

    public String getNotiName(String number) {
        PhoneNumberAssistantProxy r0 = sCootekProxy;
        if (r0 == null) goto L7;
        SMSCallerIdDetail r1 = r0.querySMSCallerId(number);
        if (r1 == null) goto L7;
        String r2 = r1.getName();
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return "";
    L12:
        return r2;
    L7:
        r2 = null;
        goto L9
    }

    public int filterSMS(String message, String sourceNumber, String messageCenter) {
        PhoneNumberAssistantProxy r0 = sCootekProxy;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.filterSMS(message, sourceNumber, messageCenter);
    }

    public void queryCallerIdDetail(String number, QueryCallerIdCallback callback) {
        ensureConnected();
        PhoneNumberAssistantProxy r1 = sCootekProxy;
        if (r1 == null) goto L6;
        r1.queryCallerIdDetail(number, 3, callback);
        return;
    }

    public void parseMessageByXySdk(String msgId, String phoneNum, String smsCenterNum, String smsContent, long smsReceiveTime, XySdkCallBack xyCallBack, boolean scrollFing) {
        ensureConnected();
        if (sCootekManager == null) goto L6;
        sCootekProxy.parseMessageByXySdk(msgId, phoneNum, smsCenterNum, smsContent, smsReceiveTime, xyCallBack, scrollFing);
        return;
    }

    public String queryPublicInfoByXySdk(String phoneNum, int numType, String simIccid, XySdkCallBack xyCallBack) {
        ensureConnected();
        if (sCootekManager != null) goto L5;
        return "";
    L5:
        return sCootekProxy.queryPublicInfoByXySdk(phoneNum, numType, simIccid, xyCallBack);
    }

    public Bitmap findLogoByLogoNameByXySdk(String logoName, int width, int height, int logoType, XySdkCallBack xyCallBack) {
        ensureConnected();
        if (sCootekManager != null) goto L5;
        return null;
    L5:
        return sCootekProxy.findLogoByLogoNameByXySdk(logoName, width, height, logoType, xyCallBack);
    }

    private void ensureConnected() {
        if (mIsConnected == true) goto L15;
        int r2 = 0;
    L6:
        if (r2 >= 3) goto L22;
        if (mIsConnected == true) goto L23;
        Thread.sleep(100);     // Catch: InterruptedException -> L12
    L14:
        r2 = r2 + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L23:
        return;
    L22:
        return;
    }
}
