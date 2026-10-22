package yg;

import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.e;
import com.bytedance.pia.core.utils.i;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f23264c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f23265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f23266b;

    static {
        f23264c = Arrays.asList(new EventName[]{EventName.f7091a, EventName.f7092b, EventName.f7093c, EventName.d, EventName.e, EventName.f});
    }

    public d() {
        this.f23265a = new JsonObject();
        this.f23266b = new HashSet(f23264c);
    }

    public abstract void a();

    @Override // fh.a
    public final void accept(Object r10) {
        com.bytedance.pia.core.tracing.d r11 = (com.bytedance.pia.core.tracing.d) r10;
        HashSet r5 = this.f23266b;
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r5.contains(r11.f7123b) == false) goto L23;
        r5.remove(r11.f7123b);
        switch(c.f23263a[r11.f7123b.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L18;
        };
    L11:
        b(r11, "WR", "t");
        goto L18
    L12:
        b(r11, "RW", "e");
        goto L18
    L13:
        b(r11, "RW", "s");
        goto L18
    L14:
        b(r11, "WEI", "e");
        goto L18
    L15:
        b(r11, "WEI", "s");
        goto L18
    L16:
        b(r11, "NAVS", "t");
    L18:
        if (r5.isEmpty() == false) goto L21;
        a();
        return;
    L21:
        return;
    }

    public final void b(com.bytedance.pia.core.tracing.d r5, String r10, String r11) {
        JsonObject r12 = this.f23265a;
        JsonElement r13 = r12.get(r10);
        if (r13 != null) goto L5;
    L7:
        JsonObject r14 = new JsonObject();
    L8:
        r14.addProperty(r11, r5.f7124c);
        JsonElement r15 = i.a().toJsonTree(r5.d);
        if (r15.isJsonObject() == false) goto L14;
        Iterator<Map.Entry<String, JsonElement>> r16 = r15.getAsJsonObject().entrySet().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<String, JsonElement> r17 = r16.next();
        r14.add(r17.getKey(), r17.getValue());
    L14:
        r12.add(r10, r14);
        return;
    L5:
        if (r13.isJsonObject() == false) goto L7;
        r14 = r13.getAsJsonObject();
        goto L8
    }
}
