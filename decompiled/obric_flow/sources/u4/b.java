package u4;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import ko.r;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f22242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f22243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f22244c;
    public final List d;
    public final Object e;

    public b() {
        this.f22242a = SetsKt.hashSetOf(new String[]{"js", "css"});
        this.f22243b = CollectionsKt.listOf(new String[]{"fetch", "x.request", "__prefetch"});
        this.d = Collections.synchronizedList(new ArrayList());
        this.e = new Object();
    }

    public static JSONObject a(JSONObject r12, String r13) {
        Object r5 = "";
        Intrinsics.checkNotNullParameter(r13, "resType");
        JSONObject r10 = null;
        if (r12 == null) goto L5;
        JSONObject r11 = r12.optJSONObject("res_info");
    L6:
        if (r11 != null) goto L9;
        r11 = new JSONObject();
    L9:
        if (r12 == null) goto L11;
        JSONObject r14 = r12.optJSONObject("res_load_perf");
    L12:
        if (r14 != null) goto L15;
        r14 = new JSONObject();
    L15:
        if (r12 == null) goto L17;
        r10 = r12.optJSONObject("res_loader_info");
    L17:
        if (r10 != null) goto L19;
        r10 = new JSONObject();
    L19:
        JSONObject r15 = new JSONObject();
        r15.put("is_memory", r11.optBoolean("is_memory") ? 1 : 0);
        r15.put("is_preload", r11.optBoolean("is_preload") ? 1 : 0);
        r15.put("is_preloaded", r11.optBoolean("is_preloaded") ? 1 : 0);
        r15.put("res_from", r11.optString("res_from"));
        r15.put("res_size", r11.optLong("res_size"));
        if (Intrinsics.areEqual(r13, "res_template_dur") == false) goto L23;
        r15.put("res_src", r11.optString("res_src"));
    L48:
        r15.put("res_version", String.valueOf(r11.optLong("res_version")));
        JSONObject r16 = new JSONObject();
        r16.put("res_load_start", r14.optLong("res_load_start"));
        r16.put("res_load_finish", r14.optLong("res_load_finish"));
        JSONObject r17 = new JSONObject();
        r17.put("res_loader_name", r10.optString("res_loader_name"));
        JSONObject r18 = new JSONObject();
        r18.put("res_info", r15);
        r18.put("res_load_perf", r16);
        r18.put("res_loader_info", r17);
        return r18;
    L23:
        if (Intrinsics.areEqual(r13, "sub_res_dur") == false) goto L48;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L32
        String r110 = Uri.parse(r11.optString("res_src")).getPath();     // Catch: Throwable -> L32
        if (r110 != null) goto L27;
    L39:
        String r111 = "";
    L40:
        Object r112 = Result.m124constructorimpl(r111);     // Catch: Throwable -> L32
    L44:
        if (Result.m130isFailureimpl(r112) == true) goto L47;
        r5 = r112;
    L47:
        r15.put("res_src", (String) r5);
        goto L48
    L27:
        if (r110.length() == 0) goto L39;
        if (StringsKt.P(r110, "/") == false) goto L34;
        r110 = r110.subSequence(1, r110.length()).toString();     // Catch: Throwable -> L32
    L34:
        List r113 = StringsKt.K(r110, new String[]{"/"}, 0, 6);     // Catch: Throwable -> L32
        int r20 = r113.size();     // Catch: Throwable -> L32
        if (r20 != 1) goto L37;
        r111 = String.valueOf(r113.get(0));     // Catch: Throwable -> L32
        goto L40
    L37:
        if (r20 <= 1) goto L39;
        r111 = ((String) r113.get(r20 - 2)) + '/' + ((String) r113.get(r20 - 1));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r112 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L44
    L11:
        r14 = null;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    public abstract void b(long r5, JSONObject r10);

    public final void c(a r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if (this.f22244c != null) goto L5;
        this.f22244c = r5;
        Unit r10 = Unit.INSTANCE;
    L5:
        List r11 = this.d;
        if (r11.size() >= 10) goto L9;
        r11.add(r5);
        return;
    }

    public abstract boolean d(r r5);

    public abstract void e(r r5);
}
