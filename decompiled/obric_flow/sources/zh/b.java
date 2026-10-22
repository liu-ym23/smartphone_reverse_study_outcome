package zh;

import com.bytedance.keva.Keva;
import com.bytedance.pia.core.utils.j;
import com.lynx.tasm.utils.d;
import io.reactivex.internal.observers.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f23447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f23448b = null;

    static {
        f23447a = Keva.getRepo("pia-snapshot-index-repo");
        f23448b = Keva.getRepo("pia-snapshot-content-repo");
    }

    public static String a(String r5, ArrayList r10, JSONObject r11) {
        if (r11.length() != 0) goto L5;
        return r5;
    L5:
        String r12 = r5.concat("?");
        int r13 = r10.size();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        StringBuilder r15 = sk.a.a(r12);
        r15.append((String) r10.get(r14));
        r15.append('=');
        r15.append(r11.opt((String) r10.get(r14)));
        r12 = r15.toString();
        if (r14 >= (r10.size() - 1)) goto L10;
        r12 = r12 + Typography.amp;
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        return r12;
    }

    public static boolean b(String r10, JSONObject r11, ArrayList r12, String r13, String r14, long r15, String r16, int r17) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        Keva r18 = f23447a;     // Catch: Throwable -> L8
        if (r18.contains(r10) == true) goto L11;
        String[] r19 = new String[0];     // Catch: Throwable -> L8
        if (r12.isEmpty() == true) goto L10;
        r19 = (String[]) r12.toArray(r19);     // Catch: Throwable -> L8
    L10:
        r18.storeStringArray(r10, r19);     // Catch: Throwable -> L8
        r18.storeString(r10.concat("_detail_id"), UUID.randomUUID().toString());     // Catch: Throwable -> L8
    L11:
        Keva r20 = c(r10);     // Catch: Throwable -> L8
        if (r20 == null) goto L17;
        String r21 = a(r10, r12, r11);     // Catch: Throwable -> L8
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L8
        r22.put("expire_time", r15);     // Catch: Throwable -> L8
        r22.put("snapshot_version", r16);     // Catch: Throwable -> L8
        r22.put("protocol_version", r17);     // Catch: Throwable -> L8
        r22.put("content_UUID", UUID.randomUUID().toString());     // Catch: Throwable -> L8
        String r23 = r22.optString("content_UUID");     // Catch: Throwable -> L8
        JSONObject r110 = d.k("content", r13);     // Catch: Throwable -> L8
        if (r14 == null) goto L16;
        r110.put("head", r14);     // Catch: Throwable -> L8
    L16:
        f23448b.storeString(r23, r110.toString());     // Catch: Throwable -> L8
        r20.storeString(r21, r22.toString());     // Catch: Throwable -> L8
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L18:
        Object r25 = Result.m124constructorimpl(r24);     // Catch: Throwable -> L8
    L21:
        Throwable r26 = Result.m127exceptionOrNullimpl(r25);
        if (r26 != null) goto L25;
        j.q("[SnapShot] save snapshot success", null);
        return true;
    L25:
        j.C("[SnapShot] save snapshot failed. (Reason: " + r26.getMessage() + ')', null);
        return false;
    L17:
        r24 = null;
    L8:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static Keva c(String r5) {
        String r10 = h.b(r5, "_detail_id");
        Keva r11 = f23447a;
        if (r11.contains(r5) == true) goto L5;
        return null;
    L5:
        if (r11.contains(r10) == false) goto L12;
        String r12 = r11.getString(r10, "");
        if (r12.length() > 0) goto L9;
        return null;
    L9:
        return Keva.getRepo(r12);
    L12:
        return null;
    }

    public static boolean d(String r5, ArrayList r10, JSONObject r11) {
        Keva r12 = c(r5);
        if (r12 == null) goto L16;
        String r13 = a(r5, r10, r11);
        if (r12.contains(r13) == false) goto L16;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        Object r15 = Result.m124constructorimpl(new JSONObject(r12.getString(r13, "")));     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r15) != null) goto L16;
        String r16 = ((JSONObject) r15).optString("content_UUID");
        Keva r17 = f23448b;
        if (r17.contains(r16) == false) goto L16;
        r17.erase(r16);
        r12.erase(r13);
        return true;
    L8:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L16:
        return false;
    }

    public static void e(String r5) {
        j.q("[SnapShot] remove all snapshots (Path = " + r5 + ')', null);
        Keva r10 = c(r5);
        if (r10 == null) goto L9;
        Map<String, ?> r11 = r10.getAll();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Iterator<Map.Entry<String, ?>> r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        f23448b.erase(new JSONObject((String) r12.next().getValue()).getString("content_UUID"));
        goto L6
    L8:
        r10.clear();
    L9:
        Keva r13 = f23447a;
        r13.erase(r5);
        r13.erase(h.b(r5, "_detail_id"));
    }
}
