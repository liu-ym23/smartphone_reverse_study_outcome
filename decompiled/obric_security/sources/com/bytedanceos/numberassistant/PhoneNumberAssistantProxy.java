package com.bytedanceos.numberassistant;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedanceos.numberassistant.xysdk.IXySdkCallBackAdapter;
import com.bytedanceos.numberassistant.xysdk.XySdkCallBack;
import com.bytedanceos.utils.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberAssistantProxy {
    public static final int CALLERID_QUERY_STRATEGY_BYTEDANCE = 3;
    public static final int CALLERID_QUERY_STRATEGY_DEFAULT = 0;
    public static final int CALLERID_QUERY_STRATEGY_OFFLINE_ONLY = 2;
    public static final int CALLERID_QUERY_STRATEGY_ONLINE_ONLY = 1;
    private static final String TAG = "PhoneNumberAssistant";
    private IPhoneNumberAssistant mAssis;
    private BindCallBack mBindCallBack;
    private ServiceConnection mConn;
    private Context mContext;
    private boolean mCootekFeatureDisabled;

    public interface BindCallBack {
        void onConnected();

        void onDisconnected();
    }

    public PhoneNumberAssistantProxy() {
        this.mConn = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(PhoneNumberAssistantProxy r0) {
        r0.onDisconnected();
    }

    static /* synthetic */ boolean access$100(PhoneNumberAssistantProxy r0) {
        return r0.bindInternal();
    }

    static /* synthetic */ void access$200(PhoneNumberAssistantProxy r0, ComponentName r1, IBinder r2) {
        r0.onConnected(r1, r2);
    }

    private void onConnected(ComponentName name, IBinder service) {
        this.mAssis = IPhoneNumberAssistant.Stub.asInterface(service);
        BindCallBack r0 = this.mBindCallBack;
        if (r0 == null) goto L6;
        r0.onConnected();
        return;
    }

    private void onDisconnected() {
        this.mAssis = null;
        BindCallBack r1 = this.mBindCallBack;
        if (r1 == null) goto L6;
        r1.onDisconnected();
        return;
    }

    public boolean bind(Context context, BindCallBack callback) {
        this.mContext = context;
        this.mBindCallBack = callback;
        if (context != null) goto L5;
        return false;
    L5:
        boolean r2 = !Constants.IS_FEATURE_DOMESTIC.booleanValue();
        this.mCootekFeatureDisabled = r2;
        if (r2 == false) goto L9;
        return false;
    L9:
        if (this.mAssis == null) goto L15;
        BindCallBack r1 = this.mBindCallBack;
        if (r1 == null) goto L13;
        r1.onConnected();
    L13:
        return true;
    L15:
        if (bindInternal() == false) goto L17;
        return true;
    L17:
        onDisconnected();
        return false;
    }

    private boolean bindInternal() {
        if (this.mContext != null) goto L6;
        return false;
    L6:
        Intent r0 = new Intent("com.bytedanceos.phone_number_assistant.NumberService");
        r0.setPackage("com.bytedanceos.phone_number_assistant");
        return this.mContext.bindService(r0, this.mConn, 1);
    }

    public void unbind() {
        Context r0 = this.mContext;
        if (r0 == null) goto L5;
        r0.unbindService(this.mConn);
        this.mContext = null;
    L5:
        this.mBindCallBack = null;
        this.mAssis = null;
    }

    public CallerIdDetail queryCallerIdDetail(String number) {
        return queryCallerIdDetail(number, 0);
    }

    public CallerIdDetail queryCallerIdDetail(String number, int strategy) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.queryCallerIdDetail(number, strategy);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public void queryCallerIdDetail(String number, QueryCallerIdCallback callback) {
        queryCallerIdDetail(number, 0, callback);
    }

    public void queryCallerIdDetail(String number, int strategy, QueryCallerIdCallback callback) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.queryCallerIdDetailAsync(number, strategy, callback);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void markCallerClassify(String number, String classify) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.markCallerClassify(number, classify);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void markCallerName(String number, String name) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.markCallerName(number, name);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void unMarkCaller(String number) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.unMarkCaller(number);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void launchYellowPage() {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.launchYellowPage();     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void launchRecharge() {
        launchRecharge(null);
    }

    public void launchRecharge(String number) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        r0.launchRecharge(number);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public SMSCallerIdDetail querySMSCallerId(String number) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.querySMSCallerId(number);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public int filterSMS(String message, String sourceNumber, String messageCenter) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return 1;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.filterSMS(message, sourceNumber, messageCenter);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public List<YellowPageResult> queryYellowPage(String query, int type) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.queryYellowPage(query, type);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public Intent getLaunchRechargeIntent(int from) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.getLaunchRechargeIntent(from);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String getPhoneAttriCity(String number) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.getPhoneAttriCity(number);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public long getBuildNumber() {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        return r0.getBuildNumber();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public void parseMessageByXySdk(String msgId, String phoneNum, String smsCenterNum, String smsContent, long smsReceiveTime, final XySdkCallBack xyCallBack, boolean scrollFing) {
        if (this.mAssis != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L15;
        IXySdkCallBackAdapter r9 = new AnonymousClass2(this, xyCallBack);     // Catch: RemoteException -> L9
        this.mAssis.parseMessageByXySdk(msgId, phoneNum, smsCenterNum, smsContent, smsReceiveTime, r9, scrollFing);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onNewMsgByXySdk(String phoneNum, String smsCenterNum, int simIndex, String smsContent, long smsReceiveTime, String extend) {
        IPhoneNumberAssistant r0 = this.mAssis;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == false) goto L13;
        return;
    L13:
        r0.onNewMsgByXySdk(phoneNum, smsCenterNum, simIndex, smsContent, smsReceiveTime, extend);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public String queryPublicInfoByXySdk(String phoneNum, int numType, String simIccid, final XySdkCallBack xyCallBack) {
        if (this.mAssis != null) goto L5;
    L11:
        return "";
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        IXySdkCallBackAdapter r0 = new AnonymousClass3(this, xyCallBack);     // Catch: RemoteException -> L9
        return this.mAssis.queryPublicInfoByXySdk(phoneNum, numType, simIccid, r0);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public Bitmap findLogoByLogoNameByXySdk(String logoName, int width, int height, int logoType, final XySdkCallBack xyCallBack) {
        if (this.mAssis != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        IXySdkCallBackAdapter r7 = new AnonymousClass4(this, xyCallBack);     // Catch: RemoteException -> L9
        return this.mAssis.findLogoByLogoNameByXySdk(logoName, width, height, logoType, r7);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public byte[] findScaleLogoByLogoNameByXySdk(String logoName, int scale, final XySdkCallBack xyCallBack, String backColor, String backColorEnd, int width, int height) {
        if (this.mAssis != null) goto L5;
    L11:
        return null;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L11;
        IXySdkCallBackAdapter r6 = new AnonymousClass5(this, xyCallBack);     // Catch: RemoteException -> L9
        return this.mAssis.findScaleLogoByLogoNameByXySdk(logoName, scale, r6, backColor, backColorEnd, width, height);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public boolean isTdSmsByXySdk(String msgId, String address, String serviceCenter, String body, long date) {
        if (this.mAssis != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mCootekFeatureDisabled == true) goto L13;
        if (TextUtils.isEmpty(body) == true) goto L13;
        return this.mAssis.isTdSmsByXySdk(msgId, address, serviceCenter, body, date);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public String parseTdSmsInstructByXySdk(String body) {
        if (this.mAssis != null) goto L5;
    L13:
        return "";
    L5:
        if (this.mCootekFeatureDisabled == true) goto L13;
        if (TextUtils.isEmpty(body) == true) goto L13;
        return this.mAssis.parseTdSmsInstructByXySdk(body);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public String parseSalaryIndexByXySdk(String text) {
        if (this.mAssis != null) goto L5;
    L13:
        return "";
    L5:
        if (this.mCootekFeatureDisabled == true) goto L13;
        if (TextUtils.isEmpty(text) == true) goto L13;
        return this.mAssis.parseSalaryIndexByXySdk(text);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public void parseMsgForCardByXySdk(String msgId, String phoneNumber, String smsCenterNum, String smsContent) {
        if (this.mAssis != null) goto L5;
        return;
    L5:
        if (this.mCootekFeatureDisabled == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(smsContent) == true) goto L18;
        this.mAssis.parseMsgForCardByXySdk(msgId, phoneNumber, smsCenterNum, smsContent);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public List<Account> getAccountsOfDoppelganger() {
        IPhoneNumberAssistant r1 = this.mAssis;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getAccountsOfDoppelganger();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
