package com.obric.matrix.dataanalysis;

import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/matrix/dataanalysis/TeaEventReporter;", "", "()V", "TAG", "", "report", "", "eventName", "params", "", "json", "Lorg/json/JSONObject;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9071a = null;

    static {
        f9071a = new j();
    }

    private j() {
    }

    public final void a(String r1, Map<String, ? extends Object> r2) {
        o.f(r1, "eventName");
        o.f(r2, "params");
        h.f9059i.a().t(r1, r2);
    }

    public final void b(String r1, JSONObject r2) {
        o.f(r1, "eventName");
        o.f(r2, "json");
        h.f9059i.a().u(r1, r2);
    }
}
