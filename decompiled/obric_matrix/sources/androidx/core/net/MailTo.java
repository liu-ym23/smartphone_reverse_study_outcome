package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders;

    private MailTo() {
        this.mHeaders = new HashMap();
    }

    public static boolean isMailTo(@Nullable Uri r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (MAILTO.equals(r1.getScheme()) == false) goto L6;
        return true;
    }

    public static boolean isMailTo(@Nullable String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.startsWith(MAILTO_SCHEME) == false) goto L6;
        return true;
    }

    @NonNull
    public static MailTo parse(@NonNull Uri r0) {
        return parse(r0.toString());
    }

    @NonNull
    public static MailTo parse(@NonNull String r10) {
        Preconditions.checkNotNull(r10);
        if (isMailTo(r10) == false) goto L30;
        int r0 = r10.indexOf(35);
        if (r0 == (-1)) goto L7;
        r10 = r10.substring(0, r0);
    L7:
        int r1 = r10.indexOf(63);
        if (r1 != (-1)) goto L10;
        String r2 = Uri.decode(r10.substring(7));
        String r11 = null;
    L11:
        MailTo r3 = new MailTo();
        if (r11 == null) goto L24;
        String[] r12 = r11.split("&");
        int r4 = r12.length;
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L24;
        String[] r7 = r12[r6].split("=", 2);
        if (r7.length == 0) goto L23;
        String r8 = Uri.decode(r7[0]).toLowerCase(Locale.ROOT);
        if (r7.length <= 1) goto L21;
        String r9 = Uri.decode(r7[1]);
    L22:
        r3.mHeaders.put(r8, r9);
        goto L23
    L21:
        r9 = null;
    L23:
        r6 = r6 + 1;
    L24:
        String r13 = r3.getTo();
        if (r13 == null) goto L27;
        r2 = r2 + ", " + r13;
    L27:
        r3.mHeaders.put("to", r2);
        return r3;
    L10:
        r2 = Uri.decode(r10.substring(7, r1));
        r11 = r10.substring(r1 + 1);
        goto L11
    L30:
        throw new ParseException("Not a mailto scheme");
    }

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get(CC);
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get("to");
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder(MAILTO_SCHEME);
        r0.append('?');
        Iterator<Map.Entry<String, String>> r3 = this.mHeaders.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r3.next();
        r0.append(Uri.encode(r1.getKey()));
        r0.append('=');
        r0.append(Uri.encode(r1.getValue()));
        r0.append('&');
        goto L4
    L7:
        return r0.toString();
    }
}
