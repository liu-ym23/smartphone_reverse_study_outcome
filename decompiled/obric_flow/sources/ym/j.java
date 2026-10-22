package ym;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.net.Uri;
import android.util.LruCache;
import android.webkit.WebResourceRequest;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import com.google.gson.Gson;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements z2.g, com.bytedance.ies.argus.strategy.e, dh.e, Callback, pt.o, rd.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23302a;

    public /* synthetic */ j(Object r5) {
        this.f23302a = r5;
    }

    @Override // com.bytedance.ies.argus.strategy.e
    public List a() {
        return (List) this.f23302a;
    }

    @Override // pt.o
    public Object apply(Object r5) {
        Object[] r10 = (Object[]) r5;
        if (r10.length != 2) goto L7;
        return ((pt.c) this.f23302a).apply(r10[0], r10[1]);
    L7:
        throw new IllegalArgumentException("Array of size 2 expected but got " + r10.length);
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        PageInfo r10 = (PageInfo) this.f23302a;
        String r11 = r10.getMessageId();
        if (r11 == null) goto L5;
        r5.c("message_id", r11);
    L5:
        JSONObject r12 = new JSONObject(new Gson().toJson(r10));
        Intrinsics.checkNotNullParameter("pageInfo", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r12, "value");
        if (r12.length() <= 0) goto L8;
        r5.b("pageInfo", r12);
    L8:
        Intrinsics.checkNotNullParameter("success", STGroup.DICT_KEY);
        r5.b("success", Boolean.TRUE);
    }

    public void c(Path r10) {
        ArrayList r5 = (ArrayList) this.f23302a;
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L11;
        u r12 = (u) r5.get(r11);
        PathMeasure r13 = u.f.f22191a;
        if (r12 == null) goto L10;
        if (r12.f18569a == true) goto L10;
        u.f.a(r10, r12.d.k() / 100.0f, r12.e.k() / 100.0f, r12.f.k() / 360.0f);
    L10:
        r11 = r11 - 1;
        goto L3
    }

    @Override // rd.d
    public void g(SchemaMonitorEvent r10, com.bytedance.ies.bullet.service.sdk.b r11, Map r12, Map r13, LinkedHashMap r14) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "schemaData");
        Intrinsics.checkNotNullParameter(r12, "info");
        int r15 = r10.ordinal();
        if (r15 == 0) goto L8;
        if (r15 != 1) goto L7;
        String r16 = "bdx_monitor_schema_generate";
    L9:
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r17 = (com.bytedance.ies.bullet.service.base.i) tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.i.class, (String) this.f23302a);
        if (r17 == null) goto L33;
        x r18 = new x(r16);
        r18.f6023b = r11.f6135c.toString();
        String r19 = r11.a();
        if (r19 != null) goto L14;
    L16:
        String r20 = "lynx";
    L17:
        r18.f6024c = r20;
        JSONObject r21 = new JSONObject();
        Iterator r22 = r12.entrySet().iterator();
    L19:
        if (r22.hasNext() == false) goto L21;
        Map.Entry r23 = (Map.Entry) r22.next();
        r21.put((String) r23.getKey(), r23.getValue());
        goto L19
    L21:
        if (r13 == null) goto L26;
        Iterator r24 = r13.entrySet().iterator();
    L24:
        if (r24.hasNext() == false) goto L26;
        Map.Entry r25 = (Map.Entry) r24.next();
        r21.put((String) r25.getKey(), r25.getValue());
    L26:
        r18.e = r21;
        JSONObject r26 = new JSONObject();
        if (r14 == null) goto L32;
        Iterator r27 = r14.entrySet().iterator();
    L30:
        if (r27.hasNext() == false) goto L32;
        Map.Entry r28 = (Map.Entry) r27.next();
        r26.put((String) r28.getKey(), ((Number) r28.getValue()).longValue());
    L32:
        r18.f = r26;
        ((com.bytedance.ies.bullet.service.monitor.i) r17).d(r18);
        goto L33
    L14:
        if (StringsKt.g(r19, "webview") != true) goto L16;
        r20 = "web";
    L33:
        StringBuilder r29 = new StringBuilder(r16);
        r29.append('{');
        if (r13 == null) goto L39;
        Iterator r110 = r13.entrySet().iterator();
    L37:
        if (r110.hasNext() == false) goto L39;
        Map.Entry r30 = (Map.Entry) r110.next();
        r29.append((String) r30.getKey());
        r29.append(':');
        r29.append((String) r30.getValue());
        r29.append(';');
    L39:
        if (r14 == null) goto L44;
        Iterator r111 = r14.entrySet().iterator();
    L42:
        if (r111.hasNext() == false) goto L44;
        Map.Entry r112 = (Map.Entry) r111.next();
        r29.append((String) r112.getKey());
        r29.append(':');
        r29.append(((Number) r112.getValue()).longValue());
        r29.append(';');
    L44:
        r29.append('}');
        a(r29.toString());
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r16 = "bdx_monitor_schema_convert";
        goto L9
    }

    @Override // dh.e
    public Map getRequestHeaders() {
        return ((WebResourceRequest) this.f23302a).getRequestHeaders();
    }

    @Override // dh.e
    public Uri getUrl() {
        return ((WebResourceRequest) this.f23302a).getUrl();
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... r5) {
        Callback r10 = (Callback) this.f23302a;
        if (r10 != null) goto L5;
        return;
    L5:
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putInt("code", ((Integer) r5[0]).intValue());
        if (r5.length <= 1) goto L8;
        r11.put("data", r5[1]);
    L8:
        r10.invoke(new Object[]{r11});
    }

    @Override // dh.e
    public boolean isForMainFrame() {
        return ((WebResourceRequest) this.f23302a).isForMainFrame();
    }

    public j(float r5, float r10) {
        this.f23302a = new float[]{r5, r10, 0.0f};
    }

    @Override // rd.d, com.bytedance.sdk.xbridge.cn.utils.a
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r5, LogLevel.f5954b, "XSchema");
    }

    public j(float r5, float r10, float r11) {
        this.f23302a = new float[]{r5, r10, r11};
    }

    public j(int r5) {
        switch(r5) {
            case 9: goto L7;
            case 12: goto L5;
            default: goto L3;
        };
    L3:
        this.f23302a = new d0.o(500);
        return;
    L5:
        this.f23302a = new LruCache(128);
        return;
    L7:
        this.f23302a = new ArrayList();
    }
}
