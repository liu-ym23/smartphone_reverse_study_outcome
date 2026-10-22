package com.obric.matrix.opush.d.d;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.dataanalysis.j;
import com.obric.matrix.opush.g.h;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/opush/base/event/EventService;", "Lcom/obric/matrix/opush/base/event/IEventService;", "()V", "onClickPushEvent", "", "msgId", "", "pkgName", "onEvent", "eventName", "params", "Lorg/json/JSONObject;", "needNetReport", "", "needAppLog", "onReceiveMessageEvent", "sentResultCode", "", "onReceivePushEvent", WsConstants.KEY_EXTRA, "onRepeatPushEvent", "id", "onShowPushEvent", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.d.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0246a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f9278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9279g;

        C0246a(JSONObject r1, String r2) {
            this.f9278f = r1;
            this.f9279g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            JSONObject r0 = this.f9278f;
            if (r0 == null) goto L5;
            r0.put("new_push", LocationInfoConst.ALLOW_USE_LOCATION);
        L5:
            j r1 = j.f9071a;
            String r2 = "matrix_" + this.f9279g;
            JSONObject r3 = this.f9278f;
            if (r3 != null) goto L8;
            r3 = new JSONObject();
        L8:
            r1.b(r2, r3);
        }
    }

    public a() {
    }

    @Override // com.obric.matrix.opush.d.d.b
    public void a(String r3, String r4) {
        o.f(r3, "msgId");
        o.f(r4, "pkgName");
        JSONObject r0 = new JSONObject();
        r0.put("msg_id", r3);
        r0.put("pkg_name", r4);
        e(com.obric.matrix.opush.f.b.G.e(), r0, true, false);
    }

    @Override // com.obric.matrix.opush.d.d.b
    public void b(String r1) {
        o.f(r1, "id");
    }

    @Override // com.obric.matrix.opush.d.d.b
    public void c(String r1, String r2) {
        o.f(r1, "msgId");
        o.f(r2, "pkgName");
    }

    @Override // com.obric.matrix.opush.d.d.b
    public void d(String r3, String r4, int r5, String r6) {
        o.f(r3, "msgId");
        o.f(r4, "pkgName");
        JSONObject r0 = new JSONObject();
        r0.put("msg_id", r3);
        r0.put("pkg_name", r4);
        r0.put("sent_result_code", r5);
        r0.put(WsConstants.KEY_EXTRA, r6);
        e(com.obric.matrix.opush.f.b.G.f(), r0, true, false);
    }

    public void e(String r1, JSONObject r2, boolean r3, boolean r4) {
        o.f(r1, "eventName");
        h.f9431a.c(new C0246a(r2, r1));
    }
}
