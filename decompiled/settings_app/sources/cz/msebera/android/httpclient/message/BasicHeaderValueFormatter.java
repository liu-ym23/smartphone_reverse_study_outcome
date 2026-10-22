package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {

    @Deprecated
    public static final BasicHeaderValueFormatter DEFAULT = null;
    public static final BasicHeaderValueFormatter INSTANCE = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    static {
        DEFAULT = new BasicHeaderValueFormatter();
        INSTANCE = new BasicHeaderValueFormatter();
    }

    public BasicHeaderValueFormatter() {
    }

    public static String formatElements(HeaderElement[] r1, boolean r2, HeaderValueFormatter r3) {
        if (r3 != null) goto L6;
        r3 = INSTANCE;
    L6:
        return r3.formatElements(null, r1, r2).toString();
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer r3, HeaderElement[] r4, boolean r5) {
        Args.notNull(r4, "Header element array");
        int r0 = estimateElementsLen(r4);
        if (r3 != null) goto L5;
        r3 = new CharArrayBuffer(r0);
    L6:
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L12;
        if (r1 <= 0) goto L11;
        r3.append(", ");
    L11:
        formatHeaderElement(r3, r4[r1], r5);
        r1 = r1 + 1;
        goto L8
    L12:
        return r3;
    L5:
        r3.ensureCapacity(r0);
        goto L6
    }

    protected int estimateElementsLen(HeaderElement[] r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r5.length < 1) goto L11;
        int r1 = (r5.length - 1) * 2;
        int r2 = r5.length;
    L8:
        if (r0 >= r2) goto L10;
        r1 = r1 + estimateHeaderElementLen(r5[r0]);
        r0 = r0 + 1;
        goto L8
    L10:
        return r1;
    }

    public static String formatHeaderElement(HeaderElement r1, boolean r2, HeaderValueFormatter r3) {
        if (r3 != null) goto L6;
        r3 = INSTANCE;
    L6:
        return r3.formatHeaderElement(null, r1, r2).toString();
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer r4, HeaderElement r5, boolean r6) {
        Args.notNull(r5, "Header element");
        int r0 = estimateHeaderElementLen(r5);
        if (r4 != null) goto L5;
        r4 = new CharArrayBuffer(r0);
    L6:
        r4.append(r5.getName());
        String r1 = r5.getValue();
        if (r1 == null) goto L9;
        r4.append('=');
        doFormatValue(r4, r1, r6);
    L9:
        int r2 = r5.getParameterCount();
        if (r2 <= 0) goto L14;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L14;
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
        formatNameValuePair(r4, r5.getParameter(r3), r6);
        r3 = r3 + 1;
    L14:
        return r4;
    L5:
        r4.ensureCapacity(r0);
        goto L6
    }

    protected int estimateHeaderElementLen(HeaderElement r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.getName().length();
        String r2 = r5.getValue();
        if (r2 == null) goto L8;
        r1 = r1 + (r2.length() + 3);
    L8:
        int r3 = r5.getParameterCount();
        if (r3 <= 0) goto L12;
    L10:
        if (r0 >= r3) goto L12;
        r1 = r1 + (estimateNameValuePairLen(r5.getParameter(r0)) + 2);
        r0 = r0 + 1;
    L12:
        return r1;
    }

    public static String formatParameters(NameValuePair[] r1, boolean r2, HeaderValueFormatter r3) {
        if (r3 != null) goto L6;
        r3 = INSTANCE;
    L6:
        return r3.formatParameters(null, r1, r2).toString();
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer r3, NameValuePair[] r4, boolean r5) {
        Args.notNull(r4, "Header parameter array");
        int r0 = estimateParametersLen(r4);
        if (r3 != null) goto L5;
        r3 = new CharArrayBuffer(r0);
    L6:
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L12;
        if (r1 <= 0) goto L11;
        r3.append(VectorFormat.DEFAULT_SEPARATOR);
    L11:
        formatNameValuePair(r3, r4[r1], r5);
        r1 = r1 + 1;
        goto L8
    L12:
        return r3;
    L5:
        r3.ensureCapacity(r0);
        goto L6
    }

    protected int estimateParametersLen(NameValuePair[] r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r5.length < 1) goto L11;
        int r1 = (r5.length - 1) * 2;
        int r2 = r5.length;
    L8:
        if (r0 >= r2) goto L10;
        r1 = r1 + estimateNameValuePairLen(r5[r0]);
        r0 = r0 + 1;
        goto L8
    L10:
        return r1;
    }

    public static String formatNameValuePair(NameValuePair r1, boolean r2, HeaderValueFormatter r3) {
        if (r3 != null) goto L6;
        r3 = INSTANCE;
    L6:
        return r3.formatNameValuePair(null, r1, r2).toString();
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer r2, NameValuePair r3, boolean r4) {
        Args.notNull(r3, "Name / value pair");
        int r0 = estimateNameValuePairLen(r3);
        if (r2 != null) goto L5;
        r2 = new CharArrayBuffer(r0);
    L6:
        r2.append(r3.getName());
        String r5 = r3.getValue();
        if (r5 == null) goto L9;
        r2.append('=');
        doFormatValue(r2, r5, r4);
    L9:
        return r2;
    L5:
        r2.ensureCapacity(r0);
        goto L6
    }

    protected int estimateNameValuePairLen(NameValuePair r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r0 = r1.getName().length();
        String r2 = r1.getValue();
        if (r2 != null) goto L8;
        return r0;
    L8:
        return r0 + (r2.length() + 3);
    }

    protected void doFormatValue(CharArrayBuffer r5, String r6, boolean r7) {
        int r0 = 0;
        if (r7 == true) goto L10;
        int r1 = 0;
    L6:
        if (r1 >= r6.length()) goto L10;
        if (r7 == true) goto L10;
        r7 = isSeparator(r6.charAt(r1));
        r1 = r1 + 1;
    L10:
        if (r7 == false) goto L13;
        r5.append('\"');
    L13:
        if (r0 >= r6.length()) goto L18;
        char r2 = r6.charAt(r0);
        if (isUnsafe(r2) == false) goto L17;
        r5.append('\\');
    L17:
        r5.append(r2);
        r0 = r0 + 1;
        goto L13
    L18:
        if (r7 == false) goto L27;
        r5.append('\"');
        return;
    }

    protected boolean isSeparator(char r1) {
        if (SEPARATORS.indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected boolean isUnsafe(char r1) {
        if (UNSAFE_CHARS.indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }
}
