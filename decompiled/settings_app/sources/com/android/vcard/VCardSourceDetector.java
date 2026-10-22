package com.android.vcard;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class VCardSourceDetector implements VCardInterpreter {
    private static Set<String> APPLE_SIGNS = null;
    private static Set<String> FOMA_SIGNS = null;
    private static Set<String> JAPANESE_MOBILE_PHONE_SIGNS = null;
    private static final String LOG_TAG = "vCard";
    private static final int PARSE_TYPE_APPLE = 1;
    private static final int PARSE_TYPE_DOCOMO_FOMA = 3;
    private static final int PARSE_TYPE_MOBILE_PHONE_JP = 2;
    public static final int PARSE_TYPE_UNKNOWN = 0;
    private static final int PARSE_TYPE_WINDOWS_MOBILE_V65_JP = 4;
    private static String TYPE_FOMA_CHARSET_SIGN;
    private static Set<String> WINDOWS_MOBILE_PHONE_SIGNS;
    private int mParseType;
    private String mSpecifiedCharset;
    private int mVersion;

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryEnded() {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryStarted() {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardEnded() {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardStarted() {
    }

    public VCardSourceDetector() {
        this.mParseType = 0;
        this.mVersion = -1;
    }

    static {
        APPLE_SIGNS = new HashSet(Arrays.asList(new String[]{VCardConstants.PROPERTY_X_PHONETIC_FIRST_NAME, VCardConstants.PROPERTY_X_PHONETIC_MIDDLE_NAME, VCardConstants.PROPERTY_X_PHONETIC_LAST_NAME, "X-ABADR", "X-ABUID"}));
        JAPANESE_MOBILE_PHONE_SIGNS = new HashSet(Arrays.asList(new String[]{"X-GNO", "X-GN", VCardConstants.PROPERTY_X_REDUCTION}));
        WINDOWS_MOBILE_PHONE_SIGNS = new HashSet(Arrays.asList(new String[]{"X-MICROSOFT-ASST_TEL", "X-MICROSOFT-ASSISTANT", "X-MICROSOFT-OFFICELOC"}));
        FOMA_SIGNS = new HashSet(Arrays.asList(new String[]{"X-SD-VERN", "X-SD-FORMAT_VER", "X-SD-CATEGORIES", "X-SD-CLASS", "X-SD-DCREATED", "X-SD-DESCRIPTION"}));
        TYPE_FOMA_CHARSET_SIGN = "X-SD-CHAR_CODE";
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onPropertyCreated(VCardProperty r7) {
        String r0 = r7.getName();
        List<String> r8 = r7.getValueList();
        if (r0.equalsIgnoreCase(VCardConstants.PROPERTY_VERSION) == false) goto L17;
        if (r8.size() <= 0) goto L17;
        String r9 = r8.get(0);
        if (r9.equals(VCardConstants.VERSION_V21) == false) goto L10;
        this.mVersion = 0;
    L22:
        if (this.mParseType == 0) goto L25;
        return;
    L25:
        if (WINDOWS_MOBILE_PHONE_SIGNS.contains(r0) == false) goto L28;
        this.mParseType = 4;
        return;
    L28:
        if (FOMA_SIGNS.contains(r0) == false) goto L31;
        this.mParseType = 3;
        return;
    L31:
        if (JAPANESE_MOBILE_PHONE_SIGNS.contains(r0) == false) goto L34;
        this.mParseType = 2;
        return;
    L34:
        if (APPLE_SIGNS.contains(r0) == false) goto L40;
        this.mParseType = 1;
        return;
    L40:
        return;
    L10:
        if (r9.equals(VCardConstants.VERSION_V30) == false) goto L13;
        this.mVersion = 1;
        goto L22
    L13:
        if (r9.equals(VCardConstants.VERSION_V40) == false) goto L15;
        this.mVersion = 2;
        goto L22
    L15:
        Log.w(LOG_TAG, "Invalid version string: " + r9);
    L17:
        if (r0.equalsIgnoreCase(TYPE_FOMA_CHARSET_SIGN) == false) goto L22;
        this.mParseType = 3;
        if (r8.size() <= 0) goto L22;
        this.mSpecifiedCharset = r8.get(0);
        goto L22
    }

    public int getEstimatedType() {
        int r0 = this.mParseType;
        if (r0 != 2) goto L5;
        return VCardConfig.VCARD_TYPE_V21_JAPANESE_MOBILE;
    L5:
        if (r0 == 3) goto L19;
        int r3 = this.mVersion;
        if (r3 != 0) goto L11;
        return VCardConfig.VCARD_TYPE_V21_GENERIC;
    L11:
        if (r3 != 1) goto L14;
        return VCardConfig.VCARD_TYPE_V30_GENERIC;
    L14:
        if (r3 != 2) goto L17;
        return VCardConfig.VCARD_TYPE_V40_GENERIC;
    L17:
        return 0;
    L19:
        return VCardConfig.VCARD_TYPE_DOCOMO;
    }

    public String getEstimatedCharset() {
        if (TextUtils.isEmpty(this.mSpecifiedCharset) == true) goto L5;
        int r1 = this.mParseType;
        if (r1 != 1) goto L9;
        return "UTF-8";
    L9:
        if (r1 != 2) goto L11;
        return "SHIFT_JIS";
    L11:
        if (r1 != 3) goto L13;
        return "SHIFT_JIS";
    L13:
        if (r1 == 4) goto L21;
        return null;
    L21:
        return "SHIFT_JIS";
    L5:
        return this.mSpecifiedCharset;
    }
}
