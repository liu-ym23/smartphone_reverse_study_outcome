package td;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidParamsError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oo.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements rd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22124a = false;

    public static int a(int r5, int r10, Bitmap.Config r11) {
        int r12 = r5 * r10;
        int r13 = f.f20802a[r11.ordinal()];
        int r14 = 4;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L7;
        r14 = 1;
        goto L15
    L7:
        if (r13 == 3) goto L12;
        if (r13 == 4) goto L12;
        throw new UnsupportedOperationException("Current Bitmap.Config is not supported");
    L12:
        r14 = 2;
    L15:
        return r12 * r14;
    }

    public static com.bytedance.ies.bullet.core.f b() {
        return (com.bytedance.ies.bullet.core.f) com.bytedance.ies.bullet.core.f.f5312b.getValue();
    }

    public static void c(String r5, fh.a r10) {
        r10.accept(new PiaMethod$InvalidParamsError(r5));
    }

    public static final void d(JSONObject r5, Function2 r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "handler");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        Iterator<String> r12 = r5.keys();     // Catch: Throwable -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        String r13 = r12.next();     // Catch: Throwable -> L7
        r10.mo2invoke(r13, r5.get(r13));     // Catch: Throwable -> L7
        goto L5
    L9:
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L19;
        boolean r16 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(androidx.room.jarjarred.org.antlr.runtime.a.x(r15, new StringBuilder("JsonUtils.forEach ")), LogLevel.d, "Monitor");
        return;
    L19:
        return;
    L7:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static void e(JSONObject r5, JSONObject r10) {
        if (r10 == null) goto L8;
        Iterator<String> r11 = r10.keys();
    L6:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();
        qo.a.j(r10.opt(r12), r12, r5);
        goto L6
    L10:
        return;
    }

    public static final void f(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        if (r10 == null) goto L13;
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L10
        if (r12 == null) goto L13;
    L8:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();     // Catch: Throwable -> L10
        r5.put(r13, r10.opt(r13));     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L14:
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L10
    L17:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L24;
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(androidx.room.jarjarred.org.antlr.runtime.a.x(r16, new StringBuilder("JsonUtils.wrap ")), LogLevel.d, "Monitor");
        return;
    L24:
        return;
    L13:
        r14 = null;
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static void g(View r5, ArrayList r10) {
        if (r5.getId() != 16908288) goto L7;
        r10.add(r5);
        return;
    L7:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = 0;
    L10:
        if (r12 >= r11.getChildCount()) goto L14;
        g(r11.getChildAt(r12), r10);
        r12 = r12 + 1;
        goto L10
    L14:
        return;
    }

    public static View h(View r5) {
        View r10 = null;
        if (r5.getVisibility() == 0) goto L6;
        return null;
    L6:
        if (r5.getVisibility() != 0) goto L16;
        if (r5.willNotDraw() == true) goto L11;
    L27:
        return r5;
    L11:
        if (r5.getForeground() != null) goto L27;
        if (r5.getBackground() != null) goto L27;
    L16:
        if ((r5 instanceof ViewGroup) == false) goto L26;
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = 0;
    L19:
        if (r12 >= r11.getChildCount()) goto L26;
        View r13 = h(r11.getChildAt(r12));
        if (r13 == null) goto L25;
        if (r10 != null) goto L23;
        r10 = r13;
        goto L25
    L23:
        return r5;
    L25:
        r12 = r12 + 1;
    L26:
        return r10;
    }
}
