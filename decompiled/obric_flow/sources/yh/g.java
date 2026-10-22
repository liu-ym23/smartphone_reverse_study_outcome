package yh;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidParamsError;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.snapshot.storage.ISnapshotStore$SnapshotConflictException;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f23280a = null;

    static {
        f23280a = new ah.b("pia.saveSnapshot", PiaMethod$Scope.f6953b, a.f23268c);
    }

    @Override // ah.a
    public final void a(gh.c r11, Object r12, gh.b r13, n0 r14) {
        e r15 = (e) r12;
        Intrinsics.checkNotNullParameter(r11, "bridge");
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "resolve");
        Intrinsics.checkNotNullParameter(r14, "reject");
        j.q("[SnapShot] pia.saveSnapshot called (Expires: " + r15.c() + ", Query: " + r15.e() + ", SDK: " + r15.f() + ", Version: " + r15.h() + ", URL: " + r15.g() + "), Enforce: " + r15.b(), null);
        String r5 = r15.a();
        String r10 = r15.d();
        Number r16 = r15.c();
        if (r16 == null) goto L5;
        long r17 = r16.longValue();
    L6:
        long r18 = r17 + System.currentTimeMillis();
        JsonObject r19 = r15.e();
        if (r19 == null) goto L10;
        String r110 = r19.toString();
        if (r110 == null) goto L10;
    L11:
        Integer r20 = r15.f();
        if (r20 == null) goto L14;
        int r21 = r20.intValue();
    L15:
        Number r22 = r15.h();
        if (r22 == null) goto L21;
        String r23 = r22.toString();
        if (r23 == null) goto L21;
        String r24 = r23;
    L22:
        String r25 = r15.g();
        Boolean r111 = r15.b();
        if (r111 == null) goto L25;
        boolean r112 = r111.booleanValue();
    L27:
        if (TextUtils.isEmpty(r5) == false) goto L29;
    L41:
        r14.accept(new PiaMethod$InvalidParamsError());
        return;
    L29:
        if (TextUtils.isEmpty(r25) == true) goto L41;
        JSONObject r26 = (JSONObject) i.b(r110);     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        if (r26 != null) goto L37;
        r14.accept(new PiaMethod$InvalidParamsError());     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        return;
    L37:
        AtomicBoolean r113 = xh.b.f23150a;     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        Intrinsics.checkNotNull(r5);     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        Intrinsics.checkNotNull(r25);     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        r13.accept(new f(Boolean.valueOf(xh.b.a(r5, r10, r18, r26, r21, r24, r25, r112))));     // Catch: ISnapshotStore$SnapshotConflictException -> L35
        return;
    L35:
        e = move-exception;
        nh.d r114 = r11.f17099b;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.bytedance.pia.core.PiaContext");
        r114.f20239j.b(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, "snapshot", "");
        r14.accept(new PiaMethod$Error(e.toString()));
        return;
    L25:
        r112 = true;
    L21:
        r24 = "";
        goto L22
    L14:
        r21 = 1;
    L10:
        r110 = "";
        goto L11
    L5:
        r17 = 604800000;
        goto L6
    }
}
