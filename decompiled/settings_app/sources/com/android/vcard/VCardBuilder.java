package com.android.vcard;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.framwork.core.sdklib.DBHelper;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class VCardBuilder {
    public static final int DEFAULT_EMAIL_TYPE = 3;
    public static final int DEFAULT_PHONE_TYPE = 1;
    public static final int DEFAULT_POSTAL_TYPE = 1;
    private static final String LOG_TAG = "vCard";
    private static final String SHIFT_JIS = "SHIFT_JIS";
    private static final String VCARD_DATA_PUBLIC = "PUBLIC";
    private static final String VCARD_DATA_SEPARATOR = ":";
    private static final String VCARD_DATA_VCARD = "VCARD";
    public static final String VCARD_END_OF_LINE = "\r\n";
    private static final String VCARD_ITEM_SEPARATOR = ";";
    private static final String VCARD_PARAM_ENCODING_BASE64_AS_B = "ENCODING=B";
    private static final String VCARD_PARAM_ENCODING_BASE64_V21 = "ENCODING=BASE64";
    private static final String VCARD_PARAM_ENCODING_QP = "ENCODING=QUOTED-PRINTABLE";
    private static final String VCARD_PARAM_EQUAL = "=";
    private static final String VCARD_PARAM_SEPARATOR = ";";
    private static final String VCARD_WS = " ";
    private static final Set<String> sAllowedAndroidPropertySet = null;
    private static final Map<Integer, Integer> sPostalTypePriorityMap = null;
    private final boolean mAppendTypeParamName;
    private StringBuilder mBuilder;
    private final String mCharset;
    private boolean mEndAppended;
    private final boolean mIsDoCoMo;
    private final boolean mIsJapaneseMobilePhone;
    private final boolean mIsV30OrV40;
    private final boolean mNeedsToConvertPhoneticString;
    private final boolean mOnlyOneNoteFieldIsAvailable;
    private final boolean mRefrainsQPToNameProperties;
    private final boolean mShouldAppendCharsetParam;
    private final boolean mShouldUseQuotedPrintable;
    private final boolean mUsesAndroidProperty;
    private final boolean mUsesDefactProperty;
    private final String mVCardCharsetParameter;
    private final int mVCardType;

    private static class PostalStruct {
        final String addressData;
        final boolean appendCharset;
        final boolean reallyUseQuotedPrintable;

        public PostalStruct(boolean r1, boolean r2, String r3) {
            this.reallyUseQuotedPrintable = r1;
            this.appendCharset = r2;
            this.addressData = r3;
        }
    }

    static {
        sAllowedAndroidPropertySet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/nickname", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation"})));
        HashMap r0 = new HashMap();
        sPostalTypePriorityMap = r0;
        r0.put(1, 0);
        r0.put(2, 1);
        r0.put(3, 2);
        r0.put(0, 3);
    }

    public VCardBuilder(int r2) {
        this(r2, null);
    }

    public VCardBuilder(int r6, String r7) {
        this.mVCardType = r6;
        if (VCardConfig.isVersion40(r6) == false) goto L5;
        Log.w(LOG_TAG, "Should not use vCard 4.0 when building vCard. It is not officially published yet.");
    L5:
        boolean r2 = false;
        if (VCardConfig.isVersion30(r6) == false) goto L8;
    L11:
        boolean r0 = true;
    L12:
        this.mIsV30OrV40 = r0;
        this.mShouldUseQuotedPrintable = VCardConfig.shouldUseQuotedPrintable(r6);
        this.mIsDoCoMo = VCardConfig.isDoCoMo(r6);
        this.mIsJapaneseMobilePhone = VCardConfig.needsToConvertPhoneticString(r6);
        this.mOnlyOneNoteFieldIsAvailable = VCardConfig.onlyOneNoteFieldIsAvailable(r6);
        this.mUsesAndroidProperty = VCardConfig.usesAndroidSpecificProperty(r6);
        this.mUsesDefactProperty = VCardConfig.usesDefactProperty(r6);
        this.mRefrainsQPToNameProperties = VCardConfig.shouldRefrainQPToNameProperties(r6);
        this.mAppendTypeParamName = VCardConfig.appendTypeParamName(r6);
        this.mNeedsToConvertPhoneticString = VCardConfig.needsToConvertPhoneticString(r6);
        if (VCardConfig.isVersion30(r6) == true) goto L15;
    L16:
        r2 = true;
    L17:
        this.mShouldAppendCharsetParam = r2;
        if (VCardConfig.isDoCoMo(r6) == false) goto L28;
        if (SHIFT_JIS.equalsIgnoreCase(r7) == false) goto L22;
        this.mCharset = r7;
    L26:
        this.mVCardCharsetParameter = "CHARSET=SHIFT_JIS";
    L31:
        clear();
        return;
    L22:
        if (TextUtils.isEmpty(r7) == false) goto L24;
        this.mCharset = SHIFT_JIS;
        goto L26
    L24:
        this.mCharset = r7;
        goto L26
    L28:
        if (TextUtils.isEmpty(r7) == false) goto L30;
        Log.i(LOG_TAG, "Use the charset \"UTF-8\" for export.");
        this.mCharset = "UTF-8";
        this.mVCardCharsetParameter = "CHARSET=UTF-8";
        goto L31
    L30:
        this.mCharset = r7;
        this.mVCardCharsetParameter = "CHARSET=" + r7;
        goto L31
    L15:
        if ("UTF-8".equalsIgnoreCase(r7) == true) goto L17;
    L8:
        if (VCardConfig.isVersion40(r6) == true) goto L11;
        r0 = false;
        goto L12
    }

    public void clear() {
        this.mBuilder = new StringBuilder();
        this.mEndAppended = false;
        appendLine(VCardConstants.PROPERTY_BEGIN, VCARD_DATA_VCARD);
        if (VCardConfig.isVersion40(this.mVCardType) == false) goto L6;
        appendLine(VCardConstants.PROPERTY_VERSION, VCardConstants.VERSION_V40);
        return;
    L6:
        if (VCardConfig.isVersion30(this.mVCardType) == false) goto L9;
        appendLine(VCardConstants.PROPERTY_VERSION, VCardConstants.VERSION_V30);
        return;
    L9:
        if (VCardConfig.isVersion21(this.mVCardType) == true) goto L11;
        Log.w(LOG_TAG, "Unknown vCard version detected.");
    L11:
        appendLine(VCardConstants.PROPERTY_VERSION, VCardConstants.VERSION_V21);
    }

    private boolean containsNonEmptyName(ContentValues r9) {
        String r8 = r9.getAsString(DBHelper.COL_DATA3);
        String r0 = r9.getAsString("data5");
        String r1 = r9.getAsString(DBHelper.COL_DATA2);
        String r2 = r9.getAsString("data4");
        String r3 = r9.getAsString("data6");
        String r4 = r9.getAsString("data9");
        String r5 = r9.getAsString("data8");
        String r6 = r9.getAsString("data7");
        String r10 = r9.getAsString("data1");
        if (TextUtils.isEmpty(r8) == true) goto L5;
    L22:
        return true;
    L5:
        if (TextUtils.isEmpty(r0) == false) goto L22;
        if (TextUtils.isEmpty(r1) == false) goto L22;
        if (TextUtils.isEmpty(r2) == false) goto L22;
        if (TextUtils.isEmpty(r3) == false) goto L22;
        if (TextUtils.isEmpty(r4) == false) goto L22;
        if (TextUtils.isEmpty(r5) == false) goto L22;
        if (TextUtils.isEmpty(r6) == false) goto L22;
        if (TextUtils.isEmpty(r10) == false) goto L22;
        return false;
    }

    private ContentValues getPrimaryContentValueWithStructuredName(List<ContentValues> r5) {
        Iterator<ContentValues> r6 = r5.iterator();
        ContentValues r0 = null;
        ContentValues r1 = null;
    L4:
        if (r6.hasNext() == false) goto L25;
        ContentValues r2 = r6.next();
        if (r2 == null) goto L4;
        Integer r3 = r2.getAsInteger("is_super_primary");
        if (r3 != null) goto L11;
    L13:
        if (r0 != null) goto L4;
        Integer r4 = r2.getAsInteger("is_primary");
        if (r4 == null) goto L21;
        if (r4.intValue() <= 0) goto L21;
        if (containsNonEmptyName(r2) == false) goto L21;
        r0 = r2;
    L21:
        if (r1 != null) goto L4;
        if (containsNonEmptyName(r2) == false) goto L4;
        r1 = r2;
        goto L4
    L11:
        if (r3.intValue() <= 0) goto L13;
        r0 = r2;
    L25:
        if (r0 != null) goto L30;
        if (r1 == null) goto L48;
        return r1;
    L48:
        return new ContentValues();
    L30:
        return r0;
    }

    private VCardBuilder appendNamePropertiesV40(List<ContentValues> r20) {
        if (this.mIsDoCoMo == false) goto L5;
    L6:
        Log.w(LOG_TAG, "Invalid flag is used in vCard 4.0 construction. Ignored.");
    L8:
        if (r20 != null) goto L10;
    L41:
        appendLine(VCardConstants.PROPERTY_FN, "");
        return this;
    L10:
        if (r20.isEmpty() == true) goto L41;
        ContentValues r4 = getPrimaryContentValueWithStructuredName(r20);
        String r5 = r4.getAsString(DBHelper.COL_DATA3);
        String r9 = r4.getAsString("data5");
        String r10 = r4.getAsString(DBHelper.COL_DATA2);
        String r11 = r4.getAsString("data4");
        String r12 = r4.getAsString("data6");
        String r6 = r4.getAsString("data1");
        if (TextUtils.isEmpty(r5) == true) goto L15;
    L27:
        String r8 = r5;
    L28:
        String r1 = r4.getAsString("data9");
        String r7 = r4.getAsString("data8");
        String r13 = r4.getAsString("data7");
        String r14 = escapeCharacters(r8);
        String r15 = escapeCharacters(r10);
        String r16 = escapeCharacters(r9);
        String r17 = escapeCharacters(r11);
        String r3 = escapeCharacters(r12);
        this.mBuilder.append("N");
        if (TextUtils.isEmpty(r1) == true) goto L31;
    L34:
        this.mBuilder.append(";");
        this.mBuilder.append("SORT-AS=").append(VCardUtils.toStringAsV40ParamValue(escapeCharacters(r1) + ';' + escapeCharacters(r13) + ';' + escapeCharacters(r7)));
    L35:
        this.mBuilder.append(":");
        this.mBuilder.append(r14);
        this.mBuilder.append(";");
        this.mBuilder.append(r15);
        this.mBuilder.append(";");
        this.mBuilder.append(r16);
        this.mBuilder.append(";");
        this.mBuilder.append(r17);
        this.mBuilder.append(";");
        this.mBuilder.append(r3);
        this.mBuilder.append("\r\n");
        if (TextUtils.isEmpty(r6) == false) goto L38;
        Log.w(LOG_TAG, "DISPLAY_NAME is empty.");
        appendLine(VCardConstants.PROPERTY_FN, escapeCharacters(VCardUtils.constructNameFromElements(VCardConfig.getNameOrderType(this.mVCardType), r8, r9, r10, r11, r12)));
    L39:
        appendPhoneticNameFields(r4);
        return this;
    L38:
        String r2 = escapeCharacters(r6);
        this.mBuilder.append(VCardConstants.PROPERTY_FN);
        this.mBuilder.append(":");
        this.mBuilder.append(r2);
        this.mBuilder.append("\r\n");
        goto L39
    L31:
        if (TextUtils.isEmpty(r7) == false) goto L34;
        if (TextUtils.isEmpty(r13) == true) goto L35;
    L15:
        if (TextUtils.isEmpty(r10) == false) goto L27;
        if (TextUtils.isEmpty(r9) == false) goto L27;
        if (TextUtils.isEmpty(r11) == false) goto L27;
        if (TextUtils.isEmpty(r12) == false) goto L27;
        if (TextUtils.isEmpty(r6) == false) goto L26;
        appendLine(VCardConstants.PROPERTY_FN, "");
        return this;
    L26:
        r8 = r6;
        goto L28
    L5:
        if (this.mNeedsToConvertPhoneticString == false) goto L8;
        goto L6
    }

    public VCardBuilder appendNameProperties(List<ContentValues> r21) {
        if (VCardConfig.isVersion40(this.mVCardType) == false) goto L7;
        return appendNamePropertiesV40(r21);
    L7:
        if (r21 == null) goto L78;
        if (r21.isEmpty() == true) goto L78;
        ContentValues r4 = getPrimaryContentValueWithStructuredName(r21);
        String r5 = r4.getAsString(DBHelper.COL_DATA3);
        String r12 = r4.getAsString("data5");
        String r13 = r4.getAsString(DBHelper.COL_DATA2);
        String r14 = r4.getAsString("data4");
        String r15 = r4.getAsString("data6");
        String r6 = r4.getAsString("data1");
        if (TextUtils.isEmpty(r5) == true) goto L14;
    L26:
        boolean r16 = false;
        boolean r2 = shouldAppendCharsetParam(new String[]{r5, r13, r12, r14, r15});
        if (this.mRefrainsQPToNameProperties == false) goto L29;
    L39:
        boolean r17 = false;
    L41:
        if (TextUtils.isEmpty(r6) == false) goto L44;
        r6 = VCardUtils.constructNameFromElements(VCardConfig.getNameOrderType(this.mVCardType), r5, r12, r13, r14, r15);
    L44:
        boolean r7 = shouldAppendCharsetParam(new String[]{r6});
        if (this.mRefrainsQPToNameProperties == false) goto L47;
    L49:
        if (r17 == false) goto L51;
        String r8 = encodeQuotedPrintable(r5);
        String r9 = encodeQuotedPrintable(r13);
        String r10 = encodeQuotedPrintable(r12);
        String r11 = encodeQuotedPrintable(r14);
        String r18 = encodeQuotedPrintable(r15);
    L52:
        if (r16 == false) goto L54;
        String r19 = encodeQuotedPrintable(r6);
    L55:
        this.mBuilder.append("N");
        if (this.mIsDoCoMo == false) goto L63;
        if (r2 == false) goto L59;
        String r3 = ";";
        this.mBuilder.append(r3);
        this.mBuilder.append(this.mVCardCharsetParameter);
    L60:
        if (r17 == false) goto L62;
        this.mBuilder.append(r3);
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L62:
        this.mBuilder.append(":");
        this.mBuilder.append(r6);
        this.mBuilder.append(r3);
        this.mBuilder.append(r3);
        this.mBuilder.append(r3);
        this.mBuilder.append(r3);
    L69:
        this.mBuilder.append("\r\n");
        this.mBuilder.append(VCardConstants.PROPERTY_FN);
        if (r7 == false) goto L72;
        this.mBuilder.append(r3);
        this.mBuilder.append(this.mVCardCharsetParameter);
    L72:
        if (r16 == false) goto L74;
        this.mBuilder.append(r3);
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L74:
        this.mBuilder.append(":");
        this.mBuilder.append(r19);
        this.mBuilder.append("\r\n");
    L75:
        appendPhoneticNameFields(r4);
        return this;
    L59:
        r3 = r10;
        goto L60
    L63:
        r3 = r10;
        if (r2 == false) goto L66;
        this.mBuilder.append(r3);
        this.mBuilder.append(this.mVCardCharsetParameter);
    L66:
        if (r17 == false) goto L68;
        this.mBuilder.append(r3);
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L68:
        this.mBuilder.append(":");
        this.mBuilder.append(r8);
        this.mBuilder.append(r3);
        this.mBuilder.append(r9);
        this.mBuilder.append(r3);
        this.mBuilder.append(r10);
        this.mBuilder.append(r3);
        this.mBuilder.append(r11);
        this.mBuilder.append(r3);
        this.mBuilder.append(r18);
        goto L69
    L54:
        r19 = escapeCharacters(r6);
        goto L55
    L51:
        r8 = escapeCharacters(r5);
        r9 = escapeCharacters(r13);
        r10 = escapeCharacters(r12);
        r11 = escapeCharacters(r14);
        r18 = escapeCharacters(r15);
        goto L52
    L47:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r6}) == true) goto L49;
        r16 = true;
        goto L49
    L29:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r5}) == true) goto L31;
    L38:
        r17 = true;
        goto L41
    L31:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r13}) == false) goto L38;
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r12}) == false) goto L38;
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r14}) == false) goto L38;
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r15}) == true) goto L39;
    L14:
        if (TextUtils.isEmpty(r13) == false) goto L26;
        if (TextUtils.isEmpty(r6) == true) goto L21;
        buildSinglePartNameField("N", r6);
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append("\r\n");
        buildSinglePartNameField(VCardConstants.PROPERTY_FN, r6);
        this.mBuilder.append("\r\n");
        goto L75
    L21:
        if (VCardConfig.isVersion30(this.mVCardType) == false) goto L24;
        appendLine("N", "");
        appendLine(VCardConstants.PROPERTY_FN, "");
        goto L75
    L24:
        if (this.mIsDoCoMo == false) goto L75;
        appendLine("N", "");
    L78:
        if (VCardConfig.isVersion30(this.mVCardType) == false) goto L81;
        appendLine("N", "");
        appendLine(VCardConstants.PROPERTY_FN, "");
    L83:
        return this;
    L81:
        if (this.mIsDoCoMo == false) goto L83;
        appendLine("N", "");
        goto L83
    }

    private void buildSinglePartNameField(String r6, String r7) {
        if (this.mRefrainsQPToNameProperties == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        String r3 = encodeQuotedPrintable(r7);
    L11:
        this.mBuilder.append(r6);
        if (shouldAppendCharsetParam(new String[]{r7}) == false) goto L14;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L14:
        if (r0 == false) goto L16;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L16:
        this.mBuilder.append(":");
        this.mBuilder.append(r3);
        return;
    L10:
        r3 = escapeCharacters(r7);
        goto L11
    L5:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r7}) == true) goto L7;
        r0 = true;
        goto L8
    }

    private void appendPhoneticNameFields(ContentValues r13) {
        String r0 = r13.getAsString("data9");
        String r1 = r13.getAsString("data8");
        String r14 = r13.getAsString("data7");
        if (this.mNeedsToConvertPhoneticString == false) goto L6;
        r0 = VCardUtils.toHalfWidthString(r0);
        r1 = VCardUtils.toHalfWidthString(r1);
        r14 = VCardUtils.toHalfWidthString(r14);
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        if (TextUtils.isEmpty(r1) == false) goto L16;
        if (TextUtils.isEmpty(r14) == false) goto L16;
        if (this.mIsDoCoMo == false) goto L114;
        this.mBuilder.append(VCardConstants.PROPERTY_SOUND);
        this.mBuilder.append(";");
        this.mBuilder.append("X-IRMC-N");
        this.mBuilder.append(":");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append("\r\n");
        return;
    L114:
        return;
    L16:
        if (VCardConfig.isVersion40(this.mVCardType) == true) goto L61;
        if (VCardConfig.isVersion30(this.mVCardType) == false) goto L27;
        String r2 = VCardUtils.constructNameFromElements(this.mVCardType, r0, r1, r14);
        this.mBuilder.append(VCardConstants.PROPERTY_SORT_STRING);
        if (VCardConfig.isVersion30(this.mVCardType) == true) goto L23;
    L25:
        this.mBuilder.append(":");
        this.mBuilder.append(escapeCharacters(r2));
        this.mBuilder.append("\r\n");
        goto L61
    L23:
        if (shouldAppendCharsetParam(new String[]{r2}) == false) goto L25;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
        goto L25
    L27:
        if (this.mIsJapaneseMobilePhone == false) goto L61;
        this.mBuilder.append(VCardConstants.PROPERTY_SOUND);
        this.mBuilder.append(";");
        this.mBuilder.append("X-IRMC-N");
        if (this.mRefrainsQPToNameProperties == false) goto L31;
    L37:
        boolean r3 = false;
    L38:
        if (r3 == false) goto L40;
        String r4 = encodeQuotedPrintable(r0);
        String r5 = encodeQuotedPrintable(r1);
        String r6 = encodeQuotedPrintable(r14);
    L42:
        if (shouldAppendCharsetParam(new String[]{r4, r5, r6}) == false) goto L44;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L44:
        this.mBuilder.append(":");
        if (TextUtils.isEmpty(r4) == true) goto L47;
        this.mBuilder.append(r4);
        boolean r7 = false;
    L49:
        if (TextUtils.isEmpty(r5) == true) goto L55;
        if (r7 == false) goto L52;
        r7 = false;
    L53:
        this.mBuilder.append(r5);
        goto L55
    L52:
        this.mBuilder.append(TokenParser.SP);
    L55:
        if (TextUtils.isEmpty(r6) == true) goto L59;
        if (r7 == true) goto L58;
        this.mBuilder.append(TokenParser.SP);
    L58:
        this.mBuilder.append(r6);
    L59:
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append(";");
        this.mBuilder.append("\r\n");
        goto L61
    L47:
        r7 = true;
        goto L49
    L40:
        r4 = escapeCharacters(r0);
        r5 = escapeCharacters(r1);
        r6 = escapeCharacters(r14);
        goto L42
    L31:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r0}) == true) goto L33;
    L36:
        r3 = true;
        goto L38
    L33:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r1}) == false) goto L36;
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r14}) == true) goto L37;
    L61:
        if (this.mUsesDefactProperty == true) goto L63;
        return;
    L63:
        if (TextUtils.isEmpty(r14) == true) goto L80;
        if (this.mShouldUseQuotedPrintable == true) goto L67;
    L69:
        boolean r8 = false;
    L70:
        if (r8 == false) goto L72;
        String r9 = encodeQuotedPrintable(r14);
    L73:
        this.mBuilder.append(VCardConstants.PROPERTY_X_PHONETIC_FIRST_NAME);
        if (shouldAppendCharsetParam(new String[]{r14}) == false) goto L76;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L76:
        if (r8 == false) goto L78;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L78:
        this.mBuilder.append(":");
        this.mBuilder.append(r9);
        this.mBuilder.append("\r\n");
        goto L80
    L72:
        r9 = escapeCharacters(r14);
        goto L73
    L67:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r14}) == true) goto L69;
        r8 = true;
    L80:
        if (TextUtils.isEmpty(r1) == true) goto L97;
        if (this.mShouldUseQuotedPrintable == true) goto L84;
    L86:
        boolean r15 = false;
    L87:
        if (r15 == false) goto L89;
        String r10 = encodeQuotedPrintable(r1);
    L90:
        this.mBuilder.append(VCardConstants.PROPERTY_X_PHONETIC_MIDDLE_NAME);
        if (shouldAppendCharsetParam(new String[]{r1}) == false) goto L93;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L93:
        if (r15 == false) goto L95;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L95:
        this.mBuilder.append(":");
        this.mBuilder.append(r10);
        this.mBuilder.append("\r\n");
        goto L97
    L89:
        r10 = escapeCharacters(r1);
        goto L90
    L84:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r1}) == true) goto L86;
        r15 = true;
    L97:
        if (TextUtils.isEmpty(r0) == false) goto L99;
        return;
    L99:
        if (this.mShouldUseQuotedPrintable == true) goto L101;
    L103:
        boolean r16 = false;
    L104:
        if (r16 == false) goto L106;
        String r11 = encodeQuotedPrintable(r0);
    L107:
        this.mBuilder.append(VCardConstants.PROPERTY_X_PHONETIC_LAST_NAME);
        if (shouldAppendCharsetParam(new String[]{r0}) == false) goto L110;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L110:
        if (r16 == false) goto L112;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L112:
        this.mBuilder.append(":");
        this.mBuilder.append(r11);
        this.mBuilder.append("\r\n");
        return;
    L106:
        r11 = escapeCharacters(r0);
        goto L107
    L101:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r0}) == true) goto L103;
        r16 = true;
        goto L104
    }

    public VCardBuilder appendNickNames(List<ContentValues> r5) {
        if (this.mIsV30OrV40 == false) goto L6;
        boolean r0 = false;
    L8:
        if (r5 == null) goto L18;
        Iterator<ContentValues> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        ContentValues r1 = r6.next();
        String r2 = r1.getAsString("data1");
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r0 == true) goto L16;
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_NICKNAME, r2);
        goto L11
    L16:
        appendAndroidSpecificProperty("vnd.android.cursor.item/nickname", r1);
    L18:
        return this;
    L6:
        if (this.mUsesAndroidProperty == false) goto L18;
        r0 = true;
        goto L8
    }

    public VCardBuilder appendPhones(List<ContentValues> r14, VCardPhoneNumberTranslationCallback r15) {
        if (r14 == null) goto L62;
        HashSet r2 = new HashSet();
        Iterator<ContentValues> r16 = r14.iterator();
        boolean r3 = false;
    L6:
        if (r16.hasNext() == false) goto L63;
        ContentValues r4 = r16.next();
        Integer r5 = r4.getAsInteger(DBHelper.COL_DATA2);
        String r6 = r4.getAsString(DBHelper.COL_DATA3);
        Integer r7 = r4.getAsInteger("is_primary");
        if (r7 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        String r9 = r4.getAsString("data1");
        if (r9 == null) goto L17;
        r9 = r9.trim();
    L17:
        if (TextUtils.isEmpty(r9) == true) goto L6;
        if (r5 == null) goto L21;
        int r10 = r5.intValue();
    L22:
        if (r15 != null) goto L23;
        if (r10 == 6) goto L59;
        if (VCardConfig.refrainPhoneNumberFormatting(this.mVCardType) == true) goto L59;
        List<String> r11 = splitPhoneNumbers(r9);
        if (r11.isEmpty() == true) goto L6;
        Iterator<String> r12 = r11.iterator();
    L36:
        if (r12.hasNext() == false) goto L61;
        String r13 = r12.next();
        if (r2.contains(r13) == true) goto L36;
        String r17 = r13.replace(',', 'p').replace(';', 'w');
        if (TextUtils.equals(r17, r13) == false) goto L51;
        StringBuilder r18 = new StringBuilder();
        int r19 = r13.length();
        int r110 = 0;
    L42:
        if (r110 >= r19) goto L49;
        char r111 = r13.charAt(r110);
        if (Character.isDigit(r111) == false) goto L46;
    L47:
        r18.append(r111);
    L48:
        r110 = r110 + 1;
        goto L42
    L46:
        if (r111 != '+') goto L48;
    L49:
        r17 = VCardUtils.PhoneNumberUtilsPort.formatNumber(r18.toString(), VCardUtils.getPhoneNumberFormat(this.mVCardType));
    L51:
        if (VCardConfig.isVersion40(this.mVCardType) == true) goto L53;
    L57:
        r2.add(r13);
        appendTelLine(Integer.valueOf(r10), r6, r17, r8);
        goto L36
    L53:
        if (TextUtils.isEmpty(r17) == true) goto L57;
        if (r17.startsWith("tel:") == true) goto L57;
        r17 = "tel:" + r17;
    L61:
        r3 = true;
    L59:
        if (r2.contains(r9) == true) goto L61;
        r2.add(r9);
        appendTelLine(Integer.valueOf(r10), r6, r9, r8);
        goto L61
    L23:
        String r20 = r15.onValueReceived(r9, r10, r6, r8);
        if (r2.contains(r20) == true) goto L6;
        r2.add(r20);
        appendTelLine(Integer.valueOf(r10), r6, r20, r8);
        goto L6
    L21:
        r10 = 1;
        goto L22
    L10:
        if (r7.intValue() <= 0) goto L12;
        r8 = true;
    L63:
        if (r3 == false) goto L65;
    L67:
        return this;
    L65:
        if (this.mIsDoCoMo == false) goto L67;
        appendTelLine(1, "", "", false);
        goto L67
    L62:
        r3 = false;
        goto L63
    }

    private List<String> splitPhoneNumbers(String r6) {
        ArrayList r5 = new ArrayList();
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        char r3 = r6.charAt(r2);
        if (r3 == '\n') goto L7;
    L9:
        r0.append(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r0.length() <= 0) goto L9;
        r5.add(r0.toString());
        r0 = new StringBuilder();
        goto L10
    L12:
        if (r0.length() <= 0) goto L14;
        r5.add(r0.toString());
    L14:
        return r5;
    }

    public VCardBuilder appendEmails(List<ContentValues> r9) {
        if (r9 == null) goto L27;
        HashSet r2 = new HashSet();
        Iterator<ContentValues> r10 = r9.iterator();
        boolean r3 = false;
    L6:
        if (r10.hasNext() == false) goto L28;
        ContentValues r4 = r10.next();
        String r5 = r4.getAsString("data1");
        if (r5 == null) goto L11;
        r5 = r5.trim();
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L6;
        Integer r6 = r4.getAsInteger(DBHelper.COL_DATA2);
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
    L17:
        String r8 = r4.getAsString(DBHelper.COL_DATA3);
        Integer r11 = r4.getAsInteger("is_primary");
        if (r11 != null) goto L20;
    L22:
        boolean r12 = false;
    L24:
        if (r2.contains(r5) == true) goto L26;
        r2.add(r5);
        appendEmailLine(r7, r8, r5, r12);
    L26:
        r3 = true;
        goto L6
    L20:
        if (r11.intValue() <= 0) goto L22;
        r12 = true;
        goto L24
    L16:
        r7 = 3;
    L28:
        if (r3 == false) goto L30;
    L32:
        return this;
    L30:
        if (this.mIsDoCoMo == false) goto L32;
        appendEmailLine(1, "", "", false);
        goto L32
    L27:
        r3 = false;
        goto L28
    }

    public VCardBuilder appendPostals(List<ContentValues> r2) {
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        if (this.mIsDoCoMo == false) goto L9;
        appendPostalsForDoCoMo(r2);
    L13:
        return this;
    L9:
        appendPostalsForGeneric(r2);
    L11:
        if (this.mIsDoCoMo == false) goto L13;
        this.mBuilder.append(VCardConstants.PROPERTY_ADR);
        this.mBuilder.append(";");
        this.mBuilder.append(VCardConstants.PARAM_TYPE_HOME);
        this.mBuilder.append(":");
        this.mBuilder.append("\r\n");
        goto L13
    }

    private void appendPostalsForDoCoMo(List<ContentValues> r11) {
        Iterator<ContentValues> r12 = r11.iterator();
        ContentValues r1 = null;
        int r2 = Integer.MAX_VALUE;
        int r3 = Integer.MAX_VALUE;
    L4:
        if (r12.hasNext() == false) goto L17;
        ContentValues r4 = r12.next();
        if (r4 == null) goto L4;
        Integer r5 = r4.getAsInteger(DBHelper.COL_DATA2);
        Integer r6 = sPostalTypePriorityMap.get(r5);
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        if (r7 >= r2) goto L4;
        r3 = r5.intValue();
        if (r7 == 0) goto L15;
        r1 = r4;
        r2 = r7;
        goto L4
    L15:
        int r8 = r3;
        ContentValues r9 = r4;
    L18:
        if (r9 != null) goto L21;
        Log.w(LOG_TAG, "Should not come here. Must have at least one postal data.");
        return;
    L21:
        appendPostalLine(r8, r9.getAsString(DBHelper.COL_DATA3), r9, false, true);
        return;
    L11:
        r7 = Integer.MAX_VALUE;
        goto L12
    L17:
        r9 = r1;
        r8 = r3;
        goto L18
    }

    private void appendPostalsForGeneric(List<ContentValues> r8) {
        Iterator<ContentValues> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L18;
        ContentValues r4 = r9.next();
        if (r4 == null) goto L4;
        Integer r0 = r4.getAsInteger(DBHelper.COL_DATA2);
        if (r0 == null) goto L11;
        int r2 = r0.intValue();
    L12:
        String r3 = r4.getAsString(DBHelper.COL_DATA3);
        Integer r1 = r4.getAsInteger("is_primary");
        boolean r5 = false;
        if (r1 != null) goto L15;
    L17:
        appendPostalLine(r2, r3, r4, r5, false);
        goto L4
    L15:
        if (r1.intValue() <= 0) goto L17;
        r5 = true;
        goto L17
    L11:
        r2 = 1;
        goto L12
    }

    private PostalStruct tryConstructPostalStruct(ContentValues r13) {
        String r0 = r13.getAsString("data5");
        String r1 = r13.getAsString("data6");
        String r2 = r13.getAsString("data4");
        String r3 = r13.getAsString("data7");
        String r4 = r13.getAsString("data8");
        String r5 = r13.getAsString("data9");
        String r6 = r13.getAsString("data10");
        boolean r8 = false;
        String[] r7 = {r0, r1, r2, r3, r4, r5, r6};
        if (VCardUtils.areAllEmpty(r7) == false) goto L5;
        String r14 = r13.getAsString("data1");
        if (TextUtils.isEmpty(r14) == false) goto L29;
        return null;
    L29:
        if (this.mShouldUseQuotedPrintable == true) goto L31;
    L33:
        boolean r9 = false;
    L34:
        boolean r10 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r14});
        if (r9 == false) goto L37;
        String r12 = encodeQuotedPrintable(r14);
    L39:
        return new PostalStruct(r9, r10, ";" + r12 + ";;;;;");
    L37:
        r12 = escapeCharacters(r14);
        goto L39
    L31:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r14}) == true) goto L33;
        r9 = true;
        goto L34
    L5:
        if (this.mShouldUseQuotedPrintable == true) goto L7;
    L9:
        boolean r15 = !VCardUtils.containsOnlyPrintableAscii(r7);
        if (TextUtils.isEmpty(r3) == false) goto L16;
        if (TextUtils.isEmpty(r1) == false) goto L14;
        r3 = "";
    L19:
        if (r8 == false) goto L21;
        String r11 = encodeQuotedPrintable(r0);
        String r16 = encodeQuotedPrintable(r2);
        String r17 = encodeQuotedPrintable(r3);
        String r18 = encodeQuotedPrintable(r4);
        String r19 = encodeQuotedPrintable(r5);
        String r110 = encodeQuotedPrintable(r6);
    L23:
        return new PostalStruct(r8, r15, r11 + ";;" + r16 + ";" + r17 + ";" + r18 + ";" + r19 + ";" + r110);
    L21:
        r11 = escapeCharacters(r0);
        String r20 = escapeCharacters(r2);
        String r21 = escapeCharacters(r3);
        String r22 = escapeCharacters(r4);
        String r23 = escapeCharacters(r5);
        String r24 = escapeCharacters(r6);
        escapeCharacters(r1);
        r16 = r20;
        r17 = r21;
        r18 = r22;
        r19 = r23;
        r110 = r24;
        goto L23
    L14:
        r3 = r1;
        goto L19
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        r3 = r3 + " " + r1;
        goto L19
    L7:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(r7) == true) goto L9;
        r8 = true;
        goto L9
    }

    public VCardBuilder appendIms(List<ContentValues> r8) {
        if (r8 == null) goto L45;
        Iterator<ContentValues> r9 = r8.iterator();
    L5:
        if (r9.hasNext() == false) goto L45;
        ContentValues r0 = r9.next();
        Integer r1 = r0.getAsInteger("data5");
        if (r1 == null) goto L5;
        String r2 = VCardUtils.getPropertyNameForIm(r1.intValue());
        if (r2 == null) goto L5;
        String r3 = r0.getAsString("data1");
        if (r3 == null) goto L16;
        r3 = r3.trim();
    L16:
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Integer r4 = r0.getAsInteger(DBHelper.COL_DATA2);
        if (r4 == null) goto L21;
        int r5 = r4.intValue();
    L22:
        String r6 = null;
        boolean r7 = true;
        if (r5 == 0) goto L30;
        if (r5 != 1) goto L26;
        r6 = VCardConstants.PARAM_TYPE_HOME;
    L33:
        ArrayList r10 = new ArrayList();
        if (TextUtils.isEmpty(r6) == true) goto L36;
        r10.add(r6);
    L36:
        Integer r11 = r0.getAsInteger("is_primary");
        if (r11 != null) goto L39;
    L41:
        r7 = false;
    L42:
        if (r7 == false) goto L44;
        r10.add(VCardConstants.PARAM_TYPE_PREF);
    L44:
        appendLineWithCharsetAndQPDetection(r2, r10, r3);
        goto L5
    L39:
        if (r11.intValue() <= 0) goto L41;
    L26:
        if (r5 != 2) goto L33;
        r6 = VCardConstants.PARAM_TYPE_WORK;
        goto L33
    L30:
        String r12 = r0.getAsString(DBHelper.COL_DATA3);
        if (r12 == null) goto L33;
        r6 = "X-" + r12;
        goto L33
    L21:
        r5 = 3;
    L45:
        return this;
    }

    public VCardBuilder appendWebsites(List<ContentValues> r3) {
        if (r3 == null) goto L12;
        Iterator<ContentValues> r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L12;
        String r0 = r4.next().getAsString("data1");
        if (r0 == null) goto L10;
        r0 = r0.trim();
    L10:
        if (TextUtils.isEmpty(r0) == true) goto L5;
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_URL, r0);
    L12:
        return this;
    }

    public VCardBuilder appendOrganizations(List<ContentValues> r8) {
        if (r8 == null) goto L39;
        Iterator<ContentValues> r9 = r8.iterator();
    L5:
        if (r9.hasNext() == false) goto L39;
        ContentValues r0 = r9.next();
        String r1 = r0.getAsString("data1");
        if (r1 == null) goto L9;
        r1 = r1.trim();
    L9:
        String r2 = r0.getAsString("data5");
        if (r2 == null) goto L12;
        r2 = r2.trim();
    L12:
        String r3 = r0.getAsString("data4");
        if (r3 == null) goto L15;
        r3 = r3.trim();
    L15:
        StringBuilder r4 = new StringBuilder();
        if (TextUtils.isEmpty(r1) == true) goto L19;
        r4.append(r1);
    L19:
        if (TextUtils.isEmpty(r2) == false) goto L21;
    L24:
        String r5 = r4.toString();
        boolean r6 = true;
        boolean r7 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r5});
        if (this.mShouldUseQuotedPrintable == true) goto L27;
    L29:
        boolean r10 = false;
    L30:
        appendLine(VCardConstants.PROPERTY_ORG, r5, r7, r10);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        boolean r11 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r3});
        if (this.mShouldUseQuotedPrintable == true) goto L35;
    L37:
        r6 = false;
    L38:
        appendLine(VCardConstants.PROPERTY_TITLE, r3, r11, r6);
        goto L5
    L35:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r3}) == true) goto L37;
    L27:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r5}) == true) goto L29;
        r10 = true;
        goto L30
    L21:
        if (r4.length() <= 0) goto L23;
        r4.append(';');
    L23:
        r4.append(r2);
    L39:
        return this;
    }

    public VCardBuilder appendPhotos(List<ContentValues> r5) {
        if (r5 == null) goto L18;
        Iterator<ContentValues> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L18;
        ContentValues r0 = r6.next();
        if (r0 == null) goto L5;
        byte[] r1 = r0.getAsByteArray("data15");
        if (r1 == null) goto L5;
        String r2 = VCardUtils.guessImageType(r1);
        if (r2 == null) goto L14;
        String r3 = new String(Base64.encode(r1, 2));
        if (TextUtils.isEmpty(r3) == true) goto L5;
        appendPhotoLine(r3, r2);
        goto L5
    L14:
        Log.d(LOG_TAG, "Unknown photo type. Ignored.");
    L18:
        return this;
    }

    public VCardBuilder appendNotes(List<ContentValues> r9) {
        if (r9 == null) goto L35;
        boolean r3 = false;
        if (this.mOnlyOneNoteFieldIsAvailable == false) goto L23;
        StringBuilder r0 = new StringBuilder();
        Iterator<ContentValues> r10 = r9.iterator();
        boolean r5 = true;
    L7:
        if (r10.hasNext() == false) goto L17;
        String r6 = r10.next().getAsString("data1");
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        if (r6.length() <= 0) goto L7;
        if (r5 == false) goto L15;
        r5 = false;
    L16:
        r0.append(r6);
        goto L7
    L15:
        r0.append('\n');
        goto L16
    L17:
        String r11 = r0.toString();
        boolean r1 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r11});
        if (this.mShouldUseQuotedPrintable == true) goto L20;
    L22:
        appendLine(VCardConstants.PROPERTY_NOTE, r11, r1, r3);
        goto L35
    L20:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r11}) == true) goto L22;
        r3 = true;
        goto L22
    L23:
        Iterator<ContentValues> r12 = r9.iterator();
    L25:
        if (r12.hasNext() == false) goto L35;
        String r2 = r12.next().getAsString("data1");
        if (TextUtils.isEmpty(r2) == true) goto L25;
        boolean r7 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r2});
        if (this.mShouldUseQuotedPrintable == true) goto L31;
    L33:
        boolean r8 = false;
    L34:
        appendLine(VCardConstants.PROPERTY_NOTE, r2, r7, r8);
        goto L25
    L31:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r2}) == true) goto L33;
        r8 = true;
    L35:
        return this;
    }

    public VCardBuilder appendEvents(List<ContentValues> r8) {
        if (r8 == null) goto L44;
        Iterator<ContentValues> r9 = r8.iterator();
        String r0 = null;
        String r1 = null;
    L5:
        if (r9.hasNext() == false) goto L40;
        ContentValues r2 = r9.next();
        if (r2 == null) goto L5;
        Integer r3 = r2.getAsInteger(DBHelper.COL_DATA2);
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L14:
        if (r4 == 3) goto L15;
        if (this.mUsesAndroidProperty == false) goto L5;
        appendAndroidSpecificProperty("vnd.android.cursor.item/contact_event", r2);
        goto L5
    L15:
        String r5 = r2.getAsString("data1");
        if (r5 == null) goto L5;
        Integer r6 = r2.getAsInteger("is_super_primary");
        boolean r7 = true;
        if (r6 != null) goto L21;
    L23:
        boolean r10 = false;
    L24:
        if (r10 == true) goto L25;
        Integer r11 = r2.getAsInteger("is_primary");
        if (r11 != null) goto L29;
    L31:
        r7 = false;
    L32:
        if (r7 == true) goto L33;
        if (r1 != null) goto L5;
        r1 = r5;
        goto L5
    L33:
        r0 = r5;
        goto L5
    L29:
        if (r11.intValue() <= 0) goto L31;
    L25:
        r0 = r5;
        goto L40
    L21:
        if (r6.intValue() <= 0) goto L23;
        r10 = true;
        goto L24
    L12:
        r4 = 2;
    L40:
        if (r0 == null) goto L42;
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_BDAY, r0.trim());
        goto L44
    L42:
        if (r1 == null) goto L44;
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_BDAY, r1.trim());
    L44:
        return this;
    }

    public VCardBuilder appendRelation(List<ContentValues> r3) {
        if (this.mUsesAndroidProperty == false) goto L12;
        if (r3 == null) goto L12;
        Iterator<ContentValues> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        ContentValues r0 = r4.next();
        if (r0 == null) goto L7;
        appendAndroidSpecificProperty("vnd.android.cursor.item/relation", r0);
    L12:
        return this;
    }

    public void appendPostalLine(int r4, String r5, ContentValues r6, boolean r7, boolean r8) {
        PostalStruct r9 = tryConstructPostalStruct(r6);
        if (r9 != null) goto L7;
        if (r8 == false) goto L6;
        String r10 = "";
        boolean r11 = false;
        boolean r1 = false;
    L8:
        ArrayList r2 = new ArrayList();
        if (r7 == false) goto L12;
        r2.add(VCardConstants.PARAM_TYPE_PREF);
    L12:
        if (r4 == 0) goto L22;
        if (r4 != 1) goto L15;
        r2.add(VCardConstants.PARAM_TYPE_HOME);
    L26:
        this.mBuilder.append(VCardConstants.PROPERTY_ADR);
        if (r2.isEmpty() == true) goto L29;
        this.mBuilder.append(";");
        appendTypeParameters(r2);
    L29:
        if (r1 == false) goto L31;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L31:
        if (r11 == false) goto L33;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L33:
        this.mBuilder.append(":");
        this.mBuilder.append(r10);
        this.mBuilder.append("\r\n");
        return;
    L15:
        if (r4 != 2) goto L17;
        r2.add(VCardConstants.PARAM_TYPE_WORK);
        goto L26
    L17:
        if (r4 == 3) goto L26;
        Log.e(LOG_TAG, "Unknown StructuredPostal type: " + r4);
        goto L26
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (VCardUtils.containsOnlyAlphaDigitHyphen(new String[]{r5}) == false) goto L26;
        r2.add("X-" + r5);
        goto L26
    L6:
        return;
    L7:
        r11 = r9.reallyUseQuotedPrintable;
        r1 = r9.appendCharset;
        r10 = r9.addressData;
        goto L8
    }

    public void appendEmailLine(int r4, String r5, String r6, boolean r7) {
        String r0 = VCardConstants.PARAM_TYPE_CELL;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L6;
        r0 = VCardConstants.PARAM_TYPE_HOME;
    L23:
        ArrayList r8 = new ArrayList();
        if (r7 == false) goto L27;
        r8.add(VCardConstants.PARAM_TYPE_PREF);
    L27:
        if (TextUtils.isEmpty(r0) == true) goto L29;
        r8.add(r0);
    L29:
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_EMAIL, r8, r6);
        return;
    L6:
        if (r4 != 2) goto L8;
        r0 = VCardConstants.PARAM_TYPE_WORK;
        goto L23
    L8:
        if (r4 != 3) goto L10;
    L12:
        r0 = null;
        goto L23
    L10:
        if (r4 == 4) goto L23;
        Log.e(LOG_TAG, "Unknown Email type: " + r4);
        goto L12
    L16:
        if (VCardUtils.isMobilePhoneLabel(r5) == true) goto L23;
        if (TextUtils.isEmpty(r5) == true) goto L12;
        if (VCardUtils.containsOnlyAlphaDigitHyphen(new String[]{r5}) == false) goto L12;
        r0 = "X-" + r5;
        goto L23
    }

    public void appendTelLine(Integer r9, String r10, String r11, boolean r12) {
        this.mBuilder.append(VCardConstants.PROPERTY_TEL);
        this.mBuilder.append(";");
        if (r9 != null) goto L5;
        int r13 = 7;
    L6:
        ArrayList r0 = new ArrayList();
        switch(r13) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L46;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L19;
            case 13: goto L16;
            case 14: goto L46;
            case 15: goto L15;
            case 16: goto L46;
            case 17: goto L14;
            case 18: goto L10;
            case 19: goto L46;
            case 20: goto L9;
            default: goto L46;
        };
    L9:
        r0.add(VCardConstants.PARAM_TYPE_MSG);
        goto L46
    L10:
        r0.add(VCardConstants.PARAM_TYPE_WORK);
        if (this.mIsDoCoMo == false) goto L13;
        r0.add(VCardConstants.PARAM_TYPE_VOICE);
        goto L46
    L13:
        r0.add(VCardConstants.PARAM_TYPE_PAGER);
        goto L46
    L14:
        r0.addAll(Arrays.asList(new String[]{VCardConstants.PARAM_TYPE_WORK, VCardConstants.PARAM_TYPE_CELL}));
        goto L46
    L15:
        r0.add(VCardConstants.PARAM_TYPE_TLX);
        goto L46
    L16:
        r0.add(VCardConstants.PARAM_TYPE_FAX);
        goto L46
    L17:
        r0.add(VCardConstants.PARAM_TYPE_ISDN);
        goto L46
    L18:
        r0.add(VCardConstants.PARAM_TYPE_WORK);
    L19:
        r12 = true;
        goto L46
    L20:
        r0.add(VCardConstants.PARAM_TYPE_CAR);
        goto L46
    L21:
        r0.add(VCardConstants.PARAM_TYPE_VOICE);
        goto L46
    L26:
        r0.addAll(Arrays.asList(new String[]{VCardConstants.PARAM_TYPE_HOME, VCardConstants.PARAM_TYPE_FAX}));
        goto L46
    L27:
        r0.addAll(Arrays.asList(new String[]{VCardConstants.PARAM_TYPE_WORK, VCardConstants.PARAM_TYPE_FAX}));
        goto L46
    L28:
        r0.addAll(Arrays.asList(new String[]{VCardConstants.PARAM_TYPE_WORK}));
        goto L46
    L29:
        r0.add(VCardConstants.PARAM_TYPE_CELL);
        goto L46
    L30:
        r0.addAll(Arrays.asList(new String[]{VCardConstants.PARAM_TYPE_HOME}));
    L46:
        if (r12 == false) goto L49;
        r0.add(VCardConstants.PARAM_TYPE_PREF);
    L49:
        if (r0.isEmpty() == false) goto L51;
        appendUncommonPhoneType(this.mBuilder, Integer.valueOf(r13));
    L52:
        this.mBuilder.append(":");
        this.mBuilder.append(r11);
        this.mBuilder.append("\r\n");
        return;
    L51:
        appendTypeParameters(r0);
        goto L52
    L23:
        if (this.mIsDoCoMo == false) goto L25;
        r0.add(VCardConstants.PARAM_TYPE_VOICE);
        goto L46
    L25:
        r0.add(VCardConstants.PARAM_TYPE_PAGER);
        goto L46
    L32:
        if (TextUtils.isEmpty(r10) == false) goto L35;
        r0.add(VCardConstants.PARAM_TYPE_VOICE);
        goto L46
    L35:
        if (VCardUtils.isMobilePhoneLabel(r10) == false) goto L38;
        r0.add(VCardConstants.PARAM_TYPE_CELL);
        goto L46
    L38:
        if (this.mIsV30OrV40 == false) goto L40;
        r0.add(r10);
        goto L46
    L40:
        String r1 = r10.toUpperCase();
        if (VCardUtils.isValidInV21ButUnknownToContactsPhoteType(r1) == false) goto L44;
        r0.add(r1);
        goto L46
    L44:
        if (VCardUtils.containsOnlyAlphaDigitHyphen(new String[]{r10}) == false) goto L46;
        r0.add("X-" + r10);
        goto L46
    L5:
        r13 = r9.intValue();
        goto L6
    }

    private void appendUncommonPhoneType(StringBuilder r2, Integer r3) {
        if (this.mIsDoCoMo == false) goto L5;
        r2.append(VCardConstants.PARAM_TYPE_VOICE);
        return;
    L5:
        String r4 = VCardUtils.getPhoneTypeString(r3);
        if (r4 == null) goto L8;
        appendTypeParameter(r4);
        return;
    L8:
        Log.e(LOG_TAG, "Unknown or unsupported (by vCard) Phone type: " + r3);
    }

    public void appendPhotoLine(String r7, String r8) {
        StringBuilder r0 = new StringBuilder();
        r0.append("PHOTO;");
        if (this.mIsV30OrV40 == false) goto L5;
        r0.append(VCARD_PARAM_ENCODING_BASE64_AS_B);
    L6:
        r0.append(";");
        appendTypeParameter(r0, r8);
        r0.append(":");
        r0.append(r7);
        String r9 = r0.toString();
        StringBuilder r10 = new StringBuilder();
        int r1 = r9.length();
        int r2 = 73;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r1) goto L12;
        r10.append(r9.charAt(r3));
        r4 = r4 + 1;
        if (r4 <= r2) goto L11;
        r10.append("\r\n ");
        r2 = 72;
        r4 = 0;
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        this.mBuilder.append(r10.toString());
        this.mBuilder.append("\r\n");
        this.mBuilder.append("\r\n");
        return;
    L5:
        r0.append(VCARD_PARAM_ENCODING_BASE64_V21);
        goto L6
    }

    public VCardBuilder appendSipAddresses(List<ContentValues> r5) {
        if (this.mIsV30OrV40 == false) goto L6;
        boolean r0 = false;
    L8:
        if (r5 == null) goto L32;
        Iterator<ContentValues> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L32;
        String r1 = r6.next().getAsString("data1");
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r0 == true) goto L18;
        if (r1.startsWith("sip:") == true) goto L28;
        r1 = "sip:" + r1;
    L28:
        if (VCardConfig.isVersion40(this.mVCardType) == false) goto L30;
        String r2 = VCardConstants.PROPERTY_TEL;
    L31:
        appendLineWithCharsetAndQPDetection(r2, r1);
        goto L11
    L30:
        r2 = VCardConstants.PROPERTY_IMPP;
        goto L31
    L18:
        if (r1.startsWith("sip:") == false) goto L23;
        if (r1.length() == 4) goto L11;
        r1 = r1.substring(4);
    L23:
        appendLineWithCharsetAndQPDetection(VCardConstants.PROPERTY_X_SIP, r1);
    L32:
        return this;
    L6:
        if (this.mUsesDefactProperty == false) goto L32;
        r0 = true;
        goto L8
    }

    public void appendAndroidSpecificProperty(String r6, ContentValues r7) {
        if (sAllowedAndroidPropertySet.contains(r6) == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        boolean r1 = true;
        int r2 = 1;
    L7:
        if (r2 > 15) goto L13;
        String r3 = r7.getAsString("data" + r2);
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r0.add(r3);
        r2 = r2 + 1;
        goto L7
    L13:
        if (this.mShouldAppendCharsetParam == true) goto L15;
    L17:
        boolean r8 = false;
    L19:
        if (this.mShouldUseQuotedPrintable == true) goto L21;
    L23:
        r1 = false;
    L24:
        this.mBuilder.append(VCardConstants.PROPERTY_X_ANDROID_CUSTOM);
        if (r8 == false) goto L27;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L27:
        if (r1 == false) goto L29;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L29:
        this.mBuilder.append(":");
        this.mBuilder.append(r6);
        Iterator r9 = r0.iterator();
    L31:
        if (r9.hasNext() == false) goto L37;
        String r10 = (String) r9.next();
        if (r1 == false) goto L35;
        String r11 = encodeQuotedPrintable(r10);
    L36:
        this.mBuilder.append(";");
        this.mBuilder.append(r11);
        goto L31
    L35:
        r11 = escapeCharacters(r10);
        goto L36
    L37:
        this.mBuilder.append("\r\n");
        return;
    L21:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(r0) == true) goto L23;
    L15:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(r0) == true) goto L17;
        r8 = true;
        goto L19
    }

    public void appendLineWithCharsetAndQPDetection(String r2, String r3) {
        appendLineWithCharsetAndQPDetection(r2, null, r3);
    }

    public void appendLineWithCharsetAndQPDetection(String r2, List<String> r3) {
        appendLineWithCharsetAndQPDetection(r2, null, r3);
    }

    public void appendLineWithCharsetAndQPDetection(String r10, List<String> r11, String r12) {
        boolean r7 = !VCardUtils.containsOnlyPrintableAscii(new String[]{r12});
        if (this.mShouldUseQuotedPrintable == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        appendLine(r10, r11, r12, r7, r8);
        return;
    L5:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[]{r12}) == true) goto L7;
        r8 = true;
        goto L8
    }

    public void appendLineWithCharsetAndQPDetection(String r10, List<String> r11, List<String> r12) {
        if (this.mShouldAppendCharsetParam == true) goto L5;
    L7:
        boolean r7 = false;
    L9:
        if (this.mShouldUseQuotedPrintable == true) goto L11;
    L13:
        boolean r8 = false;
    L14:
        appendLine(r10, r11, r12, r7, r8);
        return;
    L11:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(r12) == true) goto L13;
        r8 = true;
        goto L14
    L5:
        if (VCardUtils.containsOnlyNonCrLfPrintableAscii(r12) == true) goto L7;
        r7 = true;
        goto L9
    }

    public void appendLine(String r2, String r3) {
        appendLine(r2, r3, false, false);
    }

    public void appendLine(String r2, List<String> r3) {
        appendLine(r2, r3, false, false);
    }

    public void appendLine(String r7, String r8, boolean r9, boolean r10) {
        appendLine(r7, null, r8, r9, r10);
    }

    public void appendLine(String r7, List<String> r8, String r9) {
        appendLine(r7, r8, r9, false, false);
    }

    public void appendLine(String r2, List<String> r3, String r4, boolean r5, boolean r6) {
        this.mBuilder.append(r2);
        if (r3 != null) goto L5;
    L7:
        if (r5 == false) goto L9;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L9:
        if (r6 == false) goto L11;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
        String r7 = encodeQuotedPrintable(r4);
    L12:
        this.mBuilder.append(":");
        this.mBuilder.append(r7);
        this.mBuilder.append("\r\n");
        return;
    L11:
        r7 = escapeCharacters(r4);
        goto L12
    L5:
        if (r3.size() <= 0) goto L7;
        this.mBuilder.append(";");
        appendTypeParameters(r3);
        goto L7
    }

    public void appendLine(String r7, List<String> r8, boolean r9, boolean r10) {
        appendLine(r7, null, r8, r9, r10);
    }

    public void appendLine(String r2, List<String> r3, List<String> r4, boolean r5, boolean r6) {
        this.mBuilder.append(r2);
        if (r3 != null) goto L5;
    L7:
        if (r5 == false) goto L9;
        this.mBuilder.append(";");
        this.mBuilder.append(this.mVCardCharsetParameter);
    L9:
        if (r6 == false) goto L11;
        this.mBuilder.append(";");
        this.mBuilder.append(VCARD_PARAM_ENCODING_QP);
    L11:
        this.mBuilder.append(":");
        Iterator<String> r7 = r4.iterator();
        boolean r8 = true;
    L13:
        if (r7.hasNext() == false) goto L22;
        String r9 = r7.next();
        if (r6 == false) goto L17;
        String r10 = encodeQuotedPrintable(r9);
    L18:
        if (r8 == false) goto L20;
        r8 = false;
    L21:
        this.mBuilder.append(r10);
        goto L13
    L20:
        this.mBuilder.append(";");
        goto L21
    L17:
        r10 = escapeCharacters(r9);
        goto L18
    L22:
        this.mBuilder.append("\r\n");
        return;
    L5:
        if (r3.size() <= 0) goto L7;
        this.mBuilder.append(";");
        appendTypeParameters(r3);
        goto L7
    }

    private void appendTypeParameters(List<String> r6) {
        Iterator<String> r7 = r6.iterator();
        boolean r0 = true;
    L4:
        if (r7.hasNext() == false) goto L28;
        String r1 = r7.next();
        if (VCardConfig.isVersion30(this.mVCardType) == true) goto L18;
        if (VCardConfig.isVersion40(this.mVCardType) == true) goto L18;
        if (VCardUtils.isV21Word(r1) == false) goto L4;
        if (r0 == false) goto L15;
        r0 = false;
    L16:
        appendTypeParameter(r1);
        goto L4
    L15:
        this.mBuilder.append(";");
    L18:
        if (VCardConfig.isVersion40(this.mVCardType) == false) goto L20;
        String r2 = VCardUtils.toStringAsV40ParamValue(r1);
    L22:
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (r0 == false) goto L26;
        r0 = false;
    L27:
        appendTypeParameter(r2);
        goto L4
    L26:
        this.mBuilder.append(";");
        goto L27
    L20:
        r2 = VCardUtils.toStringAsV30ParamValue(r1);
        goto L22
    }

    private void appendTypeParameter(String r2) {
        appendTypeParameter(this.mBuilder, r2);
    }

    private void appendTypeParameter(StringBuilder r2, String r3) {
        if (VCardConfig.isVersion40(this.mVCardType) == false) goto L5;
    L10:
        r2.append(VCardConstants.PARAM_TYPE).append(VCARD_PARAM_EQUAL);
    L11:
        r2.append(r3);
        return;
    L5:
        if (VCardConfig.isVersion30(this.mVCardType) == true) goto L9;
        if (this.mAppendTypeParamName == false) goto L11;
    L9:
        if (this.mIsDoCoMo == true) goto L11;
        goto L10
    }

    private boolean shouldAppendCharsetParam(String... r6) {
        if (this.mShouldAppendCharsetParam == true) goto L5;
        return false;
    L5:
        int r5 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L11;
        if (VCardUtils.containsOnlyPrintableAscii(new String[]{r6[r1]}) == false) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    private String encodeQuotedPrintable(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder();
        byte[] r5 = r6.getBytes(this.mCharset);     // Catch: UnsupportedEncodingException -> L9
    L10:
        int r7 = 0;
        int r2 = 0;
    L12:
        if (r7 >= r5.length) goto L17;
        r0.append(String.format("=%02X", new Object[]{Byte.valueOf(r5[r7])}));
        r7 = r7 + 1;
        r2 = r2 + 3;
        if (r2 < 67) goto L12;
        r0.append("=\r\n");
        r2 = 0;
        goto L12
    L17:
        return r0.toString();
    L9:
        Log.e(LOG_TAG, "Charset " + this.mCharset + " cannot be used. Try default charset");
        r5 = r6.getBytes();
        goto L10
    }

    private String escapeCharacters(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L42;
        char r3 = r7.charAt(r2);
        if (r3 != '\n') goto L11;
    L39:
        r0.append("\\n");
    L40:
        r2 = r2 + 1;
        goto L7
    L11:
        if (r3 == '\r') goto L35;
        if (r3 == ',') goto L31;
        if (r3 == '>') goto L27;
        if (r3 == '\\') goto L24;
        if (r3 != ';') goto L20;
        r0.append("\\;");
        goto L40
    L20:
        if (r3 == '<') goto L27;
        r0.append(r3);
        goto L40
    L24:
        if (this.mIsV30OrV40 == false) goto L27;
        r0.append("\\\\");
    L27:
        if (this.mIsDoCoMo == false) goto L29;
        r0.append('\\');
        r0.append(r3);
        goto L40
    L29:
        r0.append(r3);
        goto L40
    L31:
        if (this.mIsV30OrV40 == false) goto L33;
        r0.append("\\,");
        goto L40
    L33:
        r0.append(r3);
        goto L40
    L35:
        if ((r2 + 1) >= r1) goto L39;
        if (r7.charAt(r2) != '\n') goto L39;
    L42:
        return r0.toString();
    }

    public String toString() {
        if (this.mEndAppended == true) goto L9;
        if (this.mIsDoCoMo == false) goto L7;
        appendLine(VCardConstants.PROPERTY_X_CLASS, VCARD_DATA_PUBLIC);
        appendLine(VCardConstants.PROPERTY_X_REDUCTION, "");
        appendLine(VCardConstants.PROPERTY_X_NO, "");
        appendLine(VCardConstants.PROPERTY_X_DCM_HMN_MODE, "");
    L7:
        appendLine(VCardConstants.PROPERTY_END, VCARD_DATA_VCARD);
        this.mEndAppended = true;
    L9:
        return this.mBuilder.toString();
    }
}
