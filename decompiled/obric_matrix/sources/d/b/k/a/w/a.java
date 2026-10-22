package d.b.k.a.w;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f14080a;

    public a(List<String> r3) {
        this.f14080a = new ArrayList();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L19;
        Iterator<String> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L20;
        String r0 = r4.next();
        if (TextUtils.isEmpty(r0) == true) goto L9;
        this.f14080a.add(r0);
        goto L9
    L20:
        return;
    }

    public List<String> a() {
        return this.f14080a;
    }

    public boolean b() {
        List<String> r0 = this.f14080a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return false;
    }
}
