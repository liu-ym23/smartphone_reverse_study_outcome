package vh;

import com.google.gson.JsonObject;
import gh.c;
import kotlin.Unit;
import nh.d;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f22582b;

    public /* synthetic */ a(p r5, int r10) {
        this.f22581a = r10;
        this.f22582b = r5;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        p r10 = this.f22582b;
        switch(this.f22581a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        c r11 = ((d) r10.f23312b).f20250v;
        JsonObject r12 = new JsonObject();
        r12.addProperty("data", (String) r5);
        Unit r13 = Unit.INSTANCE;
        r11.c("pia.onWorkerMessage", r12);
        return;
    L6:
        String r14 = (String) r5;
        ((d) r10.f23312b).f20239j.b(1001, "prefetch", r14);
        c r15 = ((d) r10.f23312b).f20250v;
        JsonObject r16 = new JsonObject();
        r16.addProperty("error", r14);
        Unit r17 = Unit.INSTANCE;
        r15.c("pia.onWorkerError", r16);
    }
}
