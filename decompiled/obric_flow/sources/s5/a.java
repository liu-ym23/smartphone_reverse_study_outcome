package s5;

import j6.e;
import org.json.JSONObject;
import v6.b;
import v6.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f21821c;
    public final /* synthetic */ String d;

    public a(int r5, long r10, String r11, String r12) {
        this.f21819a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f21820b = r11;
        this.f21821c = r10;
        this.d = r12;
        return;
    L6:
        c r13 = b.f22516a;
        this.f21820b = r11;
        this.f21821c = r10;
        this.d = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21819a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        c r5 = b.f22516a;
        long r10 = this.f21821c;
        String r11 = this.d;
        r5.a(r10, this.f21820b, r11);
        return;
    L9:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L8
        r12.put(this.f21820b, this.f21821c);     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        r13.put("scene", this.d);     // Catch: Exception -> L8
        e r14 = new e("page_load", "page_load", r12, r13, null);     // Catch: Exception -> L8
        i6.a.i().b(r14);     // Catch: Exception -> L8
        return;
    }
}
