package y9;

import java.util.Enumeration;
import java.util.Hashtable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f23240a;

    public a() {
        this.f23240a = new Hashtable();
    }

    public static boolean a(char r5) {
        if (r5 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r5 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r5) >= 0) goto L9;
        return true;
    }

    public static int b(int r5, String r10) {
        int r11 = r10.length();
    L3:
        if (r5 >= r11) goto L7;
        if (Character.isWhitespace(r10.charAt(r5)) == false) goto L7;
        r5 = r5 + 1;
    L7:
        return r5;
    }

    public final String toString() {
        StringBuffer r5 = new StringBuffer();
        Hashtable r10 = this.f23240a;
        r5.ensureCapacity(r10.size() * 16);
        Enumeration r11 = r10.keys();
    L4:
        if (r11.hasMoreElements() == false) goto L20;
        String r12 = (String) r11.nextElement();
        r5.append("; ");
        r5.append(r12);
        r5.append('=');
        String r13 = (String) r10.get(r12);
        int r14 = r13.length();
        int r15 = 0;
        int r16 = 0;
        boolean r17 = false;
    L6:
        if (r16 >= r14) goto L9;
        if (r17 == true) goto L9;
        r17 = !a(r13.charAt(r16));
        r16 = r16 + 1;
    L9:
        if (r17 == false) goto L18;
        StringBuffer r18 = new StringBuffer();
        r18.ensureCapacity((int) (((double) r14) * 1.5d));
        r18.append(Typography.quote);
    L11:
        if (r15 >= r14) goto L17;
        char r19 = r13.charAt(r15);
        if (r19 == '\\') goto L15;
        if (r19 == '\"') goto L15;
    L16:
        r18.append(r19);
        r15 = r15 + 1;
    L15:
        r18.append('\\');
        goto L16
    L17:
        r18.append(Typography.quote);
        r13 = r18.toString();
    L18:
        r5.append(r13);
        goto L4
    L20:
        return r5.toString();
    }
}
