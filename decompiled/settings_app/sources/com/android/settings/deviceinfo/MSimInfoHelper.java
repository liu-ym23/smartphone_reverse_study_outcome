package com.android.settings.deviceinfo;

import android.content.Context;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.MultiSimAdapter;
import com.android.settings.MultiSimSettings;
import com.android.settings.R;
import com.android.settings.utils.HanziToPinyin;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class MSimInfoHelper {
    private static final String TAG = "MSimInfoHelper";
    private Context mContext;
    private Phone[] mPhone;
    private INetworkStatsService mService;
    private INetworkStatsSession mSession;

    public MSimInfoHelper(Context r4) {
        this.mContext = r4;
        int r5 = TelephonyManager.getDefault().getPhoneCount();
        this.mPhone = new Phone[r5];
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        this.mPhone[r0] = PhoneFactory.getPhone(r0);
        r0 = r0 + 1;
        goto L3
    }

    private String getOperationName(int r7) {
        ITelephony r6 = ITelephony.Stub.asInterface(ServiceManager.checkService(MultiSimAdapter.PHONE_KEY));
        if (r6 != null) goto L12;
    L6:
        String r8 = null;
    L7:
        Log.d(TAG, "getOperationName " + r8 + " for slot " + r7);
        if (r8 != null) goto L14;
        return "";
    L14:
        return r8;
    L12:
        r8 = r6.getISmtEx().getDisplayPlmnMsim(null, null, null, false, r7);     // Catch: RemoteException -> L11
        goto L7
    }

    public String getPhoneNumber(int r4) {
        Phone[] r0 = this.mPhone;
        if (r4 >= r0.length) goto L5;
        String r1 = r0[r4].getLine1Number();
    L6:
        StringBuilder r2 = new StringBuilder();
        String r5 = getOperationName(r4);
        if (TextUtils.isEmpty(r5) == true) goto L10;
        r2.append(r5).append(HanziToPinyin.Token.SEPARATOR);
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return r2.append(PhoneNumberUtils.formatNumber(r1)).toString();
    L14:
        return r2.append(this.mContext.getString(R.string.unknown_number)).toString();
    L5:
        r1 = "";
        goto L6
    }

    public static String getSimName(Context r0, int r1) {
        return MultiSimSettings.getSimName(r0, r1);
    }

    public void openSession() {
        INetworkStatsService r0 = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mService = r0;
        this.mSession = r0.openSession();     // Catch: RemoteException -> L5
        return;
    }

    public void closeSession() {
        this.mSession.close();     // Catch: RemoteException -> L4
        return;
    }

    public void forceUpdateUsage() {
        this.mService.forceUpdate();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public String getDataUsage(int r13) {
        if (this.mSession != null) goto L5;
    L16:
        return "";
    L5:
        if (r13 >= this.mPhone.length) goto L16;
        Calendar r0 = Calendar.getInstance();
        r0.set(5, 1);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        long r5 = r0.getTimeInMillis();
        long r9 = System.currentTimeMillis();
        NetworkTemplate r14 = NetworkTemplate.buildTemplateMobileAll(this.mPhone[r13].getSubscriberId());
        NetworkStatsHistory.Entry r15 = this.mSession.getHistoryForNetwork(r14, 10).getValues(r5, r9, r9, null);     // Catch: NullPointerException -> L14 RemoteException -> L17
        StringBuilder r1 = new StringBuilder().append(this.mContext.getString(R.string.multi_sim_data_used_in_month));     // Catch: NullPointerException -> L14 RemoteException -> L17
        Context r12 = this.mContext;     // Catch: NullPointerException -> L14 RemoteException -> L17
        if (r15 == null) goto L11;
        long r2 = r15.rxBytes + r15.txBytes;     // Catch: NullPointerException -> L14 RemoteException -> L17
    L12:
        return r1.append(Formatter.formatFileSize(r12, r2).replace('k', 'K')).toString();
        goto L16
    L11:
        r2 = 0;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
