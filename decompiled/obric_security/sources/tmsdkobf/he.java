package tmsdkobf;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.preventdisturb.EventUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f246a;
    public Map b;
    public List c;
    public ce d;

    public he() {
    }

    public void a(List r2) {
        if (this.c != null) goto L5;
        this.c = new ArrayList();
    L5:
        this.c.addAll(r2);
    }

    public ce a(int r3) {
        if (r3 == 0) goto L4;
        List r0 = this.c;
        if (r0 != null) goto L11;
        return null;
    L11:
        if (r0.isEmpty() == true) goto L23;
        Iterator r2 = this.c.iterator();
    L14:
        if (r2.hasNext() == false) goto L24;
        ce r1 = (ce) r2.next();
        if (r1.f130a != r3) goto L14;
        return r1;
    L24:
        return null;
    L23:
        return null;
    L4:
        if (this.d != null) goto L7;
        ce r4 = new ce();
        this.d = r4;
        r4.e = this.f246a;
        r4.p = EventUtils.TO_APPMANAGER_ACTIVITY;
        r4.b = new ArrayList();
        this.d.b.add(LibrarianImpl.Constants.SEPARATOR);
        ce r5 = this.d;
        r5.r = true;
        r5.d = tb.a("deep_clean_other_rubbish");
        this.d.c = 1;
    L7:
        return this.d;
    }
}
