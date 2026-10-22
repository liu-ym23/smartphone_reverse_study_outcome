package u1;

import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.StringWriter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import okhttp3.n0;
import okhttp3.q0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f22218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StringWriter f22219c;

    public /* synthetic */ c(d r5, StringWriter r10, int r11) {
        this.f22217a = r11;
        this.f22218b = r5;
        this.f22219c = r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f22217a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        d r5 = this.f22218b;
        OkHttpClient r10 = r5.f22221a;
        n0 r11 = new n0();
        e0 r12 = r5.f22222b;
        Intrinsics.checkNotNullParameter(r12, "url");
        r11.f20713a = r12;
        r11.d("REPORT", q0.create(d.d, this.f22219c.toString()));
        r11.c("Depth", "0");
        return r10.a(r11.b()).execute();
    L6:
        d r13 = this.f22218b;
        OkHttpClient r14 = r13.f22221a;
        n0 r15 = new n0();
        e0 r16 = r13.f22222b;
        Intrinsics.checkNotNullParameter(r16, "url");
        r15.f20713a = r16;
        r15.d("REPORT", q0.create(d.d, this.f22219c.toString()));
        r15.c("Depth", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        return r14.a(r15.b()).execute();
    L8:
        d r17 = this.f22218b;
        OkHttpClient r18 = r17.f22221a;
        n0 r19 = new n0();
        e0 r20 = r17.f22222b;
        Intrinsics.checkNotNullParameter(r20, "url");
        r19.f20713a = r20;
        r19.d("REPORT", q0.create(d.d, this.f22219c.toString()));
        return r18.a(r19.b()).execute();
    }
}
