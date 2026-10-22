package com.bytedanceos.utils;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.util.Singleton;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberUtilsObric {
    static final String TAG = "PhoneNumberUtilsObric";
    static final Singleton<PhoneNumberUtilsObric> sPhoneNumberUtilsObric = null;

    /* synthetic */ PhoneNumberUtilsObric(AnonymousClass1 r1) {
        this();
    }

    static {
        sPhoneNumberUtilsObric = new AnonymousClass1();
    }

    public static PhoneNumberUtilsObric getInstance() {
        return (PhoneNumberUtilsObric) sPhoneNumberUtilsObric.get();
    }

    private PhoneNumberUtilsObric() {
    }

    public String formatNumberToLite(Context context, String phoneNumber, String defaultCountryIso) {
        return PhoneNumberUtils.formatNumber(phoneNumber, defaultCountryIso);
    }
}
