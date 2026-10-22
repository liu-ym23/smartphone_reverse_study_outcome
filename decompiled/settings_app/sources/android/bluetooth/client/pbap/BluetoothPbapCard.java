package android.bluetooth.client.pbap;

import com.android.settings.applications.PreferredSettingsUtils;
import com.android.vcard.VCardEntry;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothPbapCard {
    public final String N;
    public final String firstName;
    public final String handle;
    public final String lastName;
    public final String middleName;
    public final String prefix;
    public final String suffix;

    public BluetoothPbapCard(String r5, String r6) {
        this.handle = r5;
        this.N = r6;
        String[] r7 = r6.split(";", 5);
        String r1 = null;
        if (r7.length >= 1) goto L5;
        String r8 = null;
    L6:
        this.lastName = r8;
        if (r7.length >= 2) goto L9;
        String r9 = null;
    L10:
        this.firstName = r9;
        if (r7.length >= 3) goto L13;
        String r10 = null;
    L14:
        this.middleName = r10;
        if (r7.length >= 4) goto L17;
        String r11 = null;
    L18:
        this.prefix = r11;
        if (r7.length < 5) goto L22;
        r1 = r7[4];
    L22:
        this.suffix = r1;
        return;
    L17:
        r11 = r7[3];
        goto L18
    L13:
        r10 = r7[2];
        goto L14
    L9:
        r9 = r7[1];
        goto L10
    L5:
        r8 = r7[0];
        goto L6
    }

    public String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("handle", this.handle);     // Catch: JSONException -> L6
        r0.put("N", this.N);     // Catch: JSONException -> L6
        r0.put("lastName", this.lastName);     // Catch: JSONException -> L6
        r0.put("firstName", this.firstName);     // Catch: JSONException -> L6
        r0.put("middleName", this.middleName);     // Catch: JSONException -> L6
        r0.put("prefix", this.prefix);     // Catch: JSONException -> L6
        r0.put(PreferredSettingsUtils.OTHERS_SUFFIX_KEY, this.suffix);     // Catch: JSONException -> L6
    L5:
        return r0.toString();
    }

    public static String jsonifyVcardEntry(VCardEntry r10) {
        JSONObject r3 = new JSONObject();
        VCardEntry.NameData r4 = r10.getNameData();     // Catch: JSONException -> L20
        r3.put("formatted", r4.getFormatted());     // Catch: JSONException -> L20
        r3.put("family", r4.getFamily());     // Catch: JSONException -> L20
        r3.put("given", r4.getGiven());     // Catch: JSONException -> L20
        r3.put("middle", r4.getMiddle());     // Catch: JSONException -> L20
        r3.put("prefix", r4.getPrefix());     // Catch: JSONException -> L20
        r3.put(PreferredSettingsUtils.OTHERS_SUFFIX_KEY, r4.getSuffix());     // Catch: JSONException -> L20
    L27:
        JSONArray r5 = new JSONArray();     // Catch: JSONException -> L21
        List<VCardEntry.PhoneData> r6 = r10.getPhoneList();     // Catch: JSONException -> L21
        if (r6 == null) goto L23;
        Iterator<VCardEntry.PhoneData> r7 = r6.iterator();     // Catch: JSONException -> L21
    L8:
        if (r7.hasNext() == false) goto L10;
        VCardEntry.PhoneData r8 = r7.next();     // Catch: JSONException -> L21
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L21
        r9.put("type", r8.getType());     // Catch: JSONException -> L21
        r9.put("number", r8.getNumber());     // Catch: JSONException -> L21
        r9.put("label", r8.getLabel());     // Catch: JSONException -> L21
        r9.put("is_primary", r8.isPrimary());     // Catch: JSONException -> L21
        r5.put(r9);     // Catch: JSONException -> L21
        goto L8
    L10:
        r3.put("phones", r5);     // Catch: JSONException -> L21
    L23:
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L22
        List<VCardEntry.EmailData> r12 = r10.getEmailList();     // Catch: JSONException -> L22
        if (r12 == null) goto L19;
        Iterator<VCardEntry.EmailData> r13 = r12.iterator();     // Catch: JSONException -> L22
    L15:
        if (r13.hasNext() == false) goto L17;
        VCardEntry.EmailData r14 = r13.next();     // Catch: JSONException -> L22
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L22
        r15.put("type", r14.getType());     // Catch: JSONException -> L22
        r15.put("address", r14.getAddress());     // Catch: JSONException -> L22
        r15.put("label", r14.getLabel());     // Catch: JSONException -> L22
        r15.put("is_primary", r14.isPrimary());     // Catch: JSONException -> L22
        r11.put(r15);     // Catch: JSONException -> L22
        goto L15
    L17:
        r3.put("emails", r11);     // Catch: JSONException -> L22
    L19:
        return r3.toString();
    }
}
