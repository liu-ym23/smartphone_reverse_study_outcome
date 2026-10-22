package com.qualcomm.qti.internal.telephony.uicccontact;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class QtiSimPhoneBookAdnRecord {
    static final String LOG_TAG = "QtiSimPhoneBookAdnRecord";
    public int mAdNumCount;
    public String[] mAdNumbers;
    public String mAlphaTag;
    public int mEmailCount;
    public String[] mEmails;
    public String mNumber;
    public int mRecordIndex;

    public QtiSimPhoneBookAdnRecord() {
        this.mRecordIndex = 0;
        this.mAlphaTag = null;
        this.mNumber = null;
        this.mEmailCount = 0;
        this.mEmails = null;
        this.mAdNumCount = 0;
        this.mAdNumbers = null;
    }

    public int getRecordIndex() {
        return this.mRecordIndex;
    }

    public String getAlphaTag() {
        return this.mAlphaTag;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public int getNumEmails() {
        return this.mEmailCount;
    }

    public String[] getEmails() {
        return this.mEmails;
    }

    public int getNumAdNumbers() {
        return this.mAdNumCount;
    }

    public String[] getAdNumbers() {
        return this.mAdNumbers;
    }

    public static String ConvertToPhoneNumber(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.replace('e', ';').replace('T', ',').replace('?', 'N');
    }

    public static String ConvertToRecordNumber(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.replace(';', 'e').replace(',', 'T').replace('N', '?');
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.mAlphaTag) == true) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(this.mNumber) == false) goto L11;
        if (this.mEmails != null) goto L11;
        if (this.mAdNumbers != null) goto L11;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SimPhoneBookAdnRecord{index =");
        r0.append(this.mRecordIndex);
        StringBuilder r1 = r0.append(", name = ");
        String r2 = this.mAlphaTag;
        String r3 = "null";
        if (r2 != null) goto L5;
        r2 = "null";
    L5:
        r1.append(r2);
        StringBuilder r4 = r0.append(", number = ");
        String r5 = this.mNumber;
        if (r5 == null) goto L9;
        r3 = r5;
    L9:
        r4.append(r3);
        r0.append(", email count = ").append(this.mEmailCount);
        r0.append(", email = ").append(Arrays.toString(this.mEmails));
        r0.append(", ad number count = ").append(this.mAdNumCount);
        r0.append(", ad number = ").append(Arrays.toString(this.mAdNumbers));
        r0.append("}");
        return r0.toString();
    }
}
