package x4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends sj.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f22946b;

    public a(CopyOnWriteArrayList r5, int r10) {
        this.f22945a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "containerBaseMapList");
        this.f22946b = r5;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "containerInfoMapList");
        this.f22946b = r5;
    }

    @Override // sj.g
    public final void m(JSONObject r10) {
        switch(this.f22945a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        Iterator r5 = this.f22946b.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        Iterator r11 = ((Map) r5.next()).entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        qo.a.j(r12.getValue(), r13, r10);
        goto L9
    L11:
        return;
    L12:
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        ArrayList r14 = new ArrayList();
        Iterator r15 = this.f22946b.iterator();
    L14:
        if (r15.hasNext() == false) goto L28;
        Iterator r16 = ((Map) r15.next()).entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L14;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (Intrinsics.areEqual(r17.getKey(), "container_id") == true) goto L20;
        String r18 = (String) r17.getKey();
        qo.a.j(r17.getValue(), r18, r10);
        goto L17
    L20:
        Object r19 = r17.getValue();
        if ((r19 instanceof String) == false) goto L23;
        String r20 = (String) r19;
    L24:
        if (r20 == null) goto L17;
        r14.add(r20);
        goto L17
    L23:
        r20 = null;
        goto L24
    L28:
        if (r14.isEmpty() == true) goto L42;
        qo.a.j(new JSONArray(r14), "container_ids", r10);
        return;
    }

    public ConcurrentHashMap s() {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        Iterator r10 = this.f22946b.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Iterator r11 = ((Map) r10.next()).entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        Map.Entry r12 = (Map.Entry) r11.next();
        r5.put(r12.getKey(), r12.getValue());
        goto L7
    L9:
        return r5;
    }

    public a(int r5, Map r10) {
        this.f22945a = r5;
        switch(r5) {
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        CopyOnWriteArrayList r11 = new CopyOnWriteArrayList();
        Intrinsics.checkNotNullParameter(r11, "containerBaseMapList");
        this.f22946b = r11;
        if (r10 == null) goto L12;
        r11.add(r10);
        return;
    L12:
        return;
    L8:
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        Intrinsics.checkNotNullParameter(r12, "containerInfoMapList");
        this.f22946b = r12;
        if (r10 == null) goto L13;
        r12.add(r10);
        return;
    }
}
