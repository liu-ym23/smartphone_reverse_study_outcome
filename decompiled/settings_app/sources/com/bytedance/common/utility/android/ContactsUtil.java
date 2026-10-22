package com.bytedance.common.utility.android;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.common.utility.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ContactsUtil {
    private static final Pattern S_TRIM_PATTERN = null;
    private static final String TAG = "ContactsUtil";

    public static class PhoneContacts {
        public String contactId;
        public String contactName;
        public List<String> phoneNumbers;

        public PhoneContacts() {
            this.phoneNumbers = new ArrayList();
        }

        public PhoneContacts(String r2, String r3) {
            this.phoneNumbers = new ArrayList();
            this.contactId = r2;
            this.contactName = r3;
        }

        public JSONObject toNumberJsonWithEncrypt() {
            if (StringUtils.isEmpty(this.contactName) == false) goto L5;
            return null;
        L5:
            if (this.phoneNumbers.isEmpty() == false) goto L7;
            return null;
        L7:
            if (this.phoneNumbers.size() != 0) goto L9;
            return null;
        L9:
            if (StringUtils.isEmpty(this.contactId) == true) goto L34;
            JSONObject r0 = new JSONObject();
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L20
            Iterator<String> r4 = this.phoneNumbers.iterator();     // Catch: JSONException -> L20
        L14:
            if (r4.hasNext() == false) goto L18;
            String r2 = StringEncryptUtils.encryptBySHA256(r4.next());     // Catch: JSONException -> L20
            if (StringUtils.isEmpty(r2) == true) goto L14;
            r1.put(r2);     // Catch: JSONException -> L20
            goto L14
        L18:
            r0.put("mobiles", r1);     // Catch: JSONException -> L20
        L22:
            return r0;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        L34:
            return null;
        }

        public JSONObject toJson() {
            if (StringUtils.isEmpty(this.contactName) == false) goto L5;
            return null;
        L5:
            if (Lists.isEmpty(this.phoneNumbers) == false) goto L7;
            return null;
        L7:
            if (StringUtils.isEmpty(this.contactId) == true) goto L25;
            JSONObject r0 = new JSONObject();
            r0.put("contact_name", this.contactName);     // Catch: JSONException -> L16
            r0.put("contact_id", this.contactId);     // Catch: JSONException -> L16
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L16
            Iterator<String> r3 = this.phoneNumbers.iterator();     // Catch: JSONException -> L16
        L12:
            if (r3.hasNext() == false) goto L14;
            r1.put(r3.next());     // Catch: JSONException -> L16
            goto L12
        L14:
            r0.put("contact_number", r1);     // Catch: JSONException -> L16
        L18:
            return r0;
        L16:
            e = move-exception;
            e.printStackTrace();
            goto L18
        L25:
            return null;
        }
    }

    static {
        S_TRIM_PATTERN = Pattern.compile("[^+0-9]");
    }

    private ContactsUtil() {
    }

    public static String getHashedLocalMobile(TelephonyManager r4) {
        String r5 = r4.getLine1Number();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return "";
    L5:
        ArrayList r0 = new ArrayList();
        r0.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
        if (TextUtils.isEmpty(filterPhoneNumber(r5, r0)) == false) goto L8;
        return "";
    L8:
        return StringEncryptUtils.encryptBySHA256(r5);
    }

    public static String getLocalMobile(TelephonyManager r3) {
        String r4 = r3.getLine1Number();
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        ArrayList r0 = new ArrayList();
        r0.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
        return filterPhoneNumber(r4, r0);
    }

    private static String filterPhoneNumber(String r4, List<Pair<Pattern, String>> r5) {
        if (r5 != null) goto L5;
    L16:
        return null;
    L5:
        if (r5.size() == 0) goto L16;
        if (StringUtils.isEmpty(r4) == true) goto L16;
        String r6 = S_TRIM_PATTERN.matcher(r4).replaceAll("");
        Iterator<Pair<Pattern, String>> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        Pair<Pattern, String> r1 = r7.next();
        Matcher r2 = ((Pattern) r1.first).matcher(r6);
        if (r2.matches() == false) goto L11;
        return r2.replaceAll((String) r1.second);
    }
}
