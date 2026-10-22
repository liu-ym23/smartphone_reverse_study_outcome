package zj;

import android.net.Uri;
import com.bytedance.lynx.webview.TTWebSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f23451a = null;

    static {
        f23451a = new AtomicBoolean(false);
    }

    public static void a(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUri");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));     // Catch: Throwable -> L5
    L8:
        if (Result.m131isSuccessimpl(r11) == false) goto L26;
        Class r12 = (Class) r11;
        Uri r13 = Uri.parse(r5.getQueryParameter("url"));     // Catch: Exception -> L13
        String r14 = r13.getScheme();     // Catch: Exception -> L13
        if (r14 == null) goto L15;
        boolean r15 = StringsKt.P(r14, "http");     // Catch: Exception -> L13
    L16:
        if (r15 == false) goto L27;
        b(r13);     // Catch: Exception -> L13
        return;
    L27:
        return;
    L15:
        r15 = false;
    L13:
        e = move-exception;
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "ttweb preconnect error " + e.getMessage(), null, 12);
        return;
    L26:
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static void b(Uri r10) {
        ArrayList r5 = new ArrayList();
        String r11 = r10.getPath();
        if (r11 == null) goto L28;
        if (r10.getScheme() != null) goto L7;
    L11:
        r11 = null;
    L12:
        if (r11 == null) goto L28;
        r5.add(r10.getScheme() + "://" + r10.getHost());
        goto L28
    L7:
        if (r10.getHost() == null) goto L11;
        if (StringsKt.P(r11, "/magic/eco/runtime/release") == false) goto L11;
    L28:
        String r12 = r10.getQueryParameter("ttweb_preconnect_hosts");     // Catch: Exception -> L21
        if (r12 == null) goto L23;
        JSONArray r13 = new JSONArray(r12);     // Catch: Exception -> L21
        int r14 = r13.length();     // Catch: Exception -> L21
        int r15 = 0;
    L18:
        if (r15 >= r14) goto L23;
        r5.add(r13.getString(r15));     // Catch: Exception -> L21
        r15 = r15 + 1;
    L23:
        Iterator r16 = r5.iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        String r17 = (String) r16.next();
        TTWebSdk.preconnectUrl(r17, 1);
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("TTWebPredictor", "ttweb preconnect " + r17, null, 12);
        goto L25
    L27:
        return;
    L21:
        e = move-exception;
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "parse query error, " + e.getMessage(), null, 12);
        goto L23
    }
}
