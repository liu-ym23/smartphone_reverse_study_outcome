package com.qualcomm.qti.internal.telephony;

import android.util.Log;
import com.android.internal.telephony.CarrierInfoManager;
import com.android.internal.telephony.Phone;
import com.qti.extphone.QRadioResponseInfo;

/* JADX INFO: loaded from: classes4.dex */
public class QtiCarrierInfoManager extends CarrierInfoManager {
    private static final String LOG_TAG = "QtiCarrierInfoManager";
    private final Phone mPhone;

    public class QtiCarrierInfoResponse {
        final /* synthetic */ QtiCarrierInfoManager this$0;

        public QtiCarrierInfoResponse(QtiCarrierInfoManager r1) {
            this.this$0 = r1;
        }

        public void setCarrierInfoForImsiEncryptionResponse(QRadioResponseInfo r1) {
            Log.i(QtiCarrierInfoManager.LOG_TAG, "CarrierInfoForImsiEncryptionResponse");
        }
    }

    public QtiCarrierInfoManager(Phone r2) {
        this.mPhone = r2;
        QtiTelephonyComponentFactory.getInstance().getRil(r2.getPhoneId()).setImsiEncryptionResponseCallback(new QtiCarrierInfoResponse(this));
    }
}
