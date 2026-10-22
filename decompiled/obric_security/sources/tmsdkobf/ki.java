package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310a;
    public final int b;
    public final h2 c;

    public ki(String r1, int r2, h2 r3) {
        this.f310a = r1;
        this.b = r2;
        this.c = r3;
    }

    public static String a(String r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r3;
    L5:
        return r3.replace(r1, r2);
    }

    public String a() {
        StringBuilder r1 = new StringBuilder();
        String r2 = this.f310a;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.append(a("&", "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", r2))))));
        r1.append("_");
        r1.append(this.b);
        r1.append("_");
        h2 r3 = this.c;
        if (r3 == null) goto L8;
        r1.append(r3.f236a);
        r1.append(":");
        r1.append(this.c.b);
        r1.append(":");
        Iterator r4 = this.c.c.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        f3 r5 = (f3) r4.next();
        r1.append(r5.f195a);
        r1.append(",,,");
        Locale r7 = Locale.SIMPLIFIED_CHINESE;
        String r10 = String.format(r7, "%.5f", new Object[]{Float.valueOf(r5.d)});
        if (r10.indexOf(LibrarianImpl.Constants.DOT) <= 0) goto L15;
        r10 = r10.replaceAll("0+?$", "").replaceAll("[.]$", "");
    L15:
        r1.append(r10);
        r1.append(",");
        String r6 = String.format(r7, "%.5f", new Object[]{Float.valueOf(r5.e)});
        if (r6.indexOf(LibrarianImpl.Constants.DOT) <= 0) goto L18;
        r6 = r6.replaceAll("0+?$", "").replaceAll("[.]$", "");
    L18:
        r1.append(r6);
        if (r4.hasNext() == false) goto L11;
        r1.append(";");
        goto L11
    L21:
        r1.append(":");
        r1.append(this.c.d);
        return r1.toString();
    L8:
        return r1.toString();
    }
}
