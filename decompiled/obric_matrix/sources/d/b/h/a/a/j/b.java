package d.b.h.a.a.j;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f13772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13774j;

    static {
    }

    public b(int r1) {
        super(r1);
        this.f13772h = new ArrayList();
        this.f13773i = false;
        this.f13774j = false;
    }

    private static String o(List<Pair<String, List<String>>> r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        Pair<String, List<String>> r1 = r6.next();
        String r2 = (String) r1.first;
        List r3 = (List) r1.second;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        String r7 = (String) r4.next();
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r2);
        r0.append("=");
        r0.append(r7);
        goto L11
    L17:
        return r0.toString();
    }

    @Override // d.b.h.a.a.j.c
    protected boolean b(d.b.r.h0.c r9, Map<String, List<String>> r10) {
        boolean r1 = false;
        if (this.f13773i == false) goto L5;
    L45:
        return r1;
    L5:
        if (h(r9) == false) goto L45;
        if (this.f13774j == false) goto L11;
        r9.Q(true);
        r1 = true;
    L11:
        if (r10.isEmpty() == false) goto L14;
        return r1;
    L14:
        if (this.f13772h.isEmpty() == true) goto L45;
        if (r10.containsKey("x-tt-encrypt-queries") == true) goto L45;
        LinkedList r3 = new LinkedList();
        Iterator<String> r4 = this.f13772h.iterator();
    L20:
        if (r4.hasNext() == false) goto L25;
        String r5 = r4.next();
        if (r10.containsKey(r5) == false) goto L20;
        r3.add(new Pair(r5, r10.get(r5)));
        goto L20
    L25:
        if (r3.isEmpty() == false) goto L27;
        return r1;
    L27:
        String r6 = o(r3);
        if (TextUtils.isEmpty(r6) == false) goto L30;
        return r1;
    L30:
        byte[] r7 = null;
        r7 = r6.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L33
    L35:
        if (r7 != null) goto L37;
        return r1;
    L37:
        byte[] r8 = EncryptorUtil.a(r7, r7.length);
        if (r8 != null) goto L40;
        return r1;
    L40:
        String r2 = Base64.encodeToString(r8, 2);
        Logger.debug();
        LinkedList r11 = new LinkedList();
        r11.add(r2);
        r9.T(true);
        r10.put("x-tt-encrypt-queries", r11);
        Iterator<String> r12 = this.f13772h.iterator();
    L42:
        if (r12.hasNext() == false) goto L44;
        r10.remove(r12.next());
        goto L42
    L44:
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    @Override // d.b.h.a.a.j.c
    protected void i(JSONObject r3) {
        j(r3);
        d.i(r3.optJSONArray("encrypt_query_list"), this.f13772h);
        boolean r1 = false;
        if (r3.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r1 = true;
    L5:
        this.f13774j = r1;
        if (this.f13772h.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f13774j == true) goto L12;
        this.f13773i = true;
        return;
    }
}
