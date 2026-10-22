package d.b.h.a.a.j;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class f extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f13791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f13792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f13794k;

    static {
    }

    public f(int r1) {
        super(r1);
        this.f13791h = new ArrayList();
        this.f13792i = new ArrayList();
        this.f13793j = false;
        this.f13794k = false;
    }

    @Override // d.b.h.a.a.j.c
    protected boolean b(d.b.r.h0.c r3, Map<String, List<String>> r4) {
        if (this.f13793j == false) goto L5;
    L44:
        return false;
    L5:
        if (h(r3) == false) goto L44;
        if (r4.isEmpty() == false) goto L11;
        return false;
    L11:
        if (this.f13791h.isEmpty() == true) goto L23;
        Map<? extends String, ? extends List<String>> r5 = new LinkedHashMap();
        if (r4.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r5.put("x-tt-encrypt-queries", r4.get("x-tt-encrypt-queries"));
    L15:
        Iterator<String> r2 = this.f13791h.iterator();
    L17:
        if (r2.hasNext() == false) goto L21;
        String r0 = r2.next();
        if (r4.containsKey(r0) == false) goto L17;
        r5.put(r0, r4.get(r0));
        goto L17
    L21:
        r4.clear();
        r4.putAll(r5);
        return true;
    L23:
        if (this.f13792i.isEmpty() == true) goto L55;
        Iterator<String> r1 = this.f13792i.iterator();
    L26:
        if (r1.hasNext() == false) goto L29;
        r4.remove(r1.next());
        goto L26
    L29:
        if (r3.G() == null) goto L31;
        String r6 = r3.G();
    L33:
        if (this.f13794k == true) goto L35;
        return true;
    L35:
        if (r6.contains("bgrm") == true) goto L57;
        Iterator<String> r7 = this.f13792i.iterator();
    L38:
        if (r7.hasNext() == false) goto L58;
        if (r6.contains(r7.next()) == false) goto L38;
        ArrayList r8 = new ArrayList();
        r8.add(LocationInfoConst.ALLOW_USE_LOCATION);
        r4.put("bgrm", r8);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r6 = "";
        goto L33
    L55:
        return true;
    }

    @Override // d.b.h.a.a.j.c
    protected void i(JSONObject r4) {
        j(r4);
        d.i(r4.optJSONArray("keep_list"), this.f13791h);
        d.i(r4.optJSONArray("remove_list"), this.f13792i);
        boolean r1 = false;
        if (r4.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.f13777c = r0;
        if (r4.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r1 = true;
    L9:
        this.f13794k = r1;
        if (this.f13791h.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.f13792i.isEmpty() == true) goto L16;
        this.f13793j = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
