package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.obric.security.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static SpannableStringBuilder formatHighlight(Context context, String text, String hl) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (TextUtils.isEmpty(text) == true) goto L6;
        r0.append(text);
    L6:
        return formatHighlight(context, r0, hl);
    }

    public static SpannableStringBuilder formatHighlight(Context context, SpannableStringBuilder buf, String hl) {
        return formatHighlightColor(buf, hl, context.getResources().getColor(R.color.search_highlight_color));
    }

    public static SpannableStringBuilder formatHighlightColor(SpannableStringBuilder buf, String hl, int hightlightColor) {
        if (TextUtils.isEmpty(buf) == false) goto L5;
    L10:
        return buf;
    L5:
        if (TextUtils.isEmpty(hl) == true) goto L10;
        Matcher r5 = Pattern.compile(Pattern.quote(hl), 2).matcher(buf.toString());
    L8:
        if (r5.find() == false) goto L10;
        buf.setSpan(new ForegroundColorSpan(hightlightColor), r5.start(), r5.end(), 0);
        goto L8
    }

    public static SpannableStringBuilder formatHighlightOnlyPhoneNumber(Context context, String number, String hl) {
        String r12 = hl.replace(" ", "").replace("-", "");
        int r0 = PhoneNumberUtils.normalizeNumber(number).indexOf(r12);
        if (r0 < 0) goto L5;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L7:
        int r5 = r0 + r3;
        if (r2 > r5) goto L19;
        if (number.length() <= r2) goto L18;
        if (number.charAt(r2) != ' ') goto L14;
    L15:
        r4 = r4 + 1;
        if (r5 >= number.length()) goto L18;
        r3 = r3 + 1;
        goto L18
    L14:
        if (number.charAt(r2) == '-') goto L15;
    L18:
        r2 = r2 + 1;
        goto L7
    L19:
        int r6 = 0;
    L20:
        int r8 = r0 + r3;
        if (r5 >= (r12.length() + r8)) goto L32;
        if (number.length() <= r5) goto L31;
        if (number.charAt(r5) != ' ') goto L27;
    L28:
        r6 = r6 + 1;
        if ((r8 + r12.length()) >= number.length()) goto L31;
        r3 = r3 + 1;
        goto L31
    L27:
        if (number.charAt(r5) == '-') goto L28;
    L31:
        r5 = r5 + 1;
        goto L20
    L32:
        int r7 = ((r12.length() + r0) + r6) + r4;
        if (r7 <= number.length()) goto L36;
        r7 = number.length();
    L36:
        if (((r12.length() + r0) + r6) > number.length()) goto L40;
        SpannableStringBuilder r13 = new SpannableStringBuilder(number);
        r13.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.search_highlight_color)), r0 + r4, r7, 0);
        return r13;
    L40:
        return new SpannableStringBuilder(number);
    L5:
        return new SpannableStringBuilder(number);
    }

    public static String replaceEnterTabtoSpace(String oriString) {
        if (TextUtils.isEmpty(oriString) == false) goto L5;
        return oriString;
    L5:
        Matcher r0 = Pattern.compile("\\s").matcher(oriString);
        if (r0.find() == true) goto L8;
        return oriString;
    L8:
        return r0.replaceAll(" ");
    }
}
