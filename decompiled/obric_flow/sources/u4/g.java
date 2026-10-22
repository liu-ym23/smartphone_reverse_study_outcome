package u4;

import ko.r;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends b {
    @Override // u4.b
    public final void b(long r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        a r11 = this.f22244c;
        if (r11 == null) goto L5;
        JSONObject r12 = (JSONObject) r11.f22241b.f18728b;
    L6:
        qo.a.j(b.a(r12, "res_template_dur"), "res_template_dur", r10);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // u4.b
    public final boolean d(r r5) {
        Intrinsics.checkNotNullParameter(r5, "accessor");
        return true;
    }

    @Override // u4.b
    public final void e(r r10) {
        Intrinsics.checkNotNullParameter(r10, "accessor");
        Long r5 = 0L;
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_finish", "pathX");
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_start", "pathY");
        Object r11 = r10.f("res_load_perf.res_load_finish");
        Object r12 = r10.f("res_load_perf.res_load_start");
        if (r11 == null) goto L10;
        if (r12 == null) goto L10;
        if ((r11 instanceof Number) == false) goto L10;
        if ((r12 instanceof Number) == false) goto L10;
        r5 = Long.valueOf(((Number) r11).longValue() - ((Number) r12).longValue());
    L10:
        long r13 = r5.longValue();
        if (r13 <= 0) goto L14;
        c(new a(r13, r10));
        return;
    }
}
