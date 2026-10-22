package xg;

import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import com.lynx.tasm.utils.g;
import j6.c;
import java.util.LinkedList;
import jg.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f23136c;
    public long d;
    public long e;
    public long f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f23138i;

    @Override // java.lang.Runnable
    public final void run() {
        long r5 = this.e;
        LinkedList r10 = new LinkedList();     // Catch: Exception -> L12
        long[] r11 = this.f23136c;     // Catch: Exception -> L12
        int r12 = r11.length;     // Catch: Exception -> L12
        long r13 = this.f;
        if (r12 <= 0) goto L8;
        f.C(r11, r10, r13);     // Catch: Exception -> L12
        f.D(r10, new m.b(17));     // Catch: Exception -> L12
    L8:
        if (r10.size() <= 2) goto L16;
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L12
        long r15 = Math.max(r5, f.B(r10, r14));     // Catch: Exception -> L12
        String r16 = f.v(r10, r15);     // Catch: Exception -> L12
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L12
        r17.put("stack", r14.toString());     // Catch: Exception -> L12
        r17.put("stack_key", r16);     // Catch: Exception -> L12
        r17.put("scene", this.g);     // Catch: Exception -> L12
        r17.put("cost_time", r15);     // Catch: Exception -> L12
        r17.put("cpu_cost", this.d);     // Catch: Exception -> L12
        r17.put("method_time", r15);     // Catch: Exception -> L12
        long r18 = r13 - r5;     // Catch: Exception -> L12
        JSONObject r19 = k.m().l(r18, r13);     // Catch: Exception -> L12
        r19.put("evil_method", MethodCollector.getInstance().getEvilMethod(r18, r13));     // Catch: Exception -> L12
        r17.put("custom", r19);     // Catch: Exception -> L12
        r17.put("message", g.l(this.f23137h));     // Catch: Exception -> L12
        r17.put("timestamp", r13);     // Catch: Exception -> L12
        r17.put("event_type", "lag_drop_frame");     // Catch: Exception -> L12
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L12
        r20.put("crash_section", j.c(this.f23138i));     // Catch: Exception -> L12
        r20.put("block_frame", String.valueOf(this.f23135b));     // Catch: Exception -> L12
        r20.put("block_input", String.valueOf(this.f23134a));     // Catch: Exception -> L12
        r20.put("trace_type", "message");     // Catch: Exception -> L12
        r17.put("filters", r20);     // Catch: Exception -> L12
        i6.a.i().b(new c("drop_frame_stack", r17));     // Catch: Exception -> L12
        b.a("evil_method_end");     // Catch: Exception -> L12
        return;
    L16:
        return;
    L12:
        b.a("evil_method_analyse_exception");
    }
}
