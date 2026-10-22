package xh;

import android.net.Uri;
import android.os.Handler;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.pia.snapshot.storage.ISnapshotStore$SnapshotConflictException;
import com.lynx.tasm.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f23150a = null;

    static {
        f23150a = new AtomicBoolean(false);
    }

    public static boolean a(String r17, String r18, long r19, JSONObject r21, int r22, String r23, String r24, boolean r25) {
        String r5 = r17;
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r21, "query");
        Intrinsics.checkNotNullParameter(r23, "version");
        Intrinsics.checkNotNullParameter(r24, "url");
        Lazy r10 = Settings.B;
        if (p.a().t() == true) goto L5;
        return false;
    L5:
        j.y("[SnapShot] Save a snapshot (URL: " + r24 + ", Query: " + r21 + ')', null);
        ((Handler) m.f7156b.getValue()).post(a.f23148c);
        Keva r11 = zh.b.f23447a;
        Stack r12 = new Stack();
        StringBuffer r14 = new StringBuffer();
        int r15 = 0;
    L7:
        if (r15 >= r17.length()) goto L27;
        char r13 = r5.charAt(r15);
        if (r13 != '<') goto L22;
        int r16 = r15 + 34;
        if (r16 <= r17.length()) goto L13;
    L16:
        int r20 = r15 + 32;
        if (r20 > r17.length()) goto L22;
        if (Intrinsics.areEqual(r5.substring(r15, r20), "<!-- PIA_SNAPSHOT_HIDDEN_END -->") == false) goto L22;
        r12.pop();
        r5 = r17;
        r15 = r20;
        goto L7
    L13:
        if (Intrinsics.areEqual(r5.substring(r15, r16), "<!-- PIA_SNAPSHOT_HIDDEN_START -->") == false) goto L16;
        r12.push(0);
        r15 = r16;
    L22:
        if (r12.empty() == true) goto L24;
    L26:
        r15 = r15 + 1;
        r5 = r17;
        goto L7
    L24:
        if (r13 == '\n') goto L26;
        r14.append(r13);
        goto L26
    L27:
        String r26 = r14.toString();
        Intrinsics.checkNotNullParameter(r26, "content");
        Intrinsics.checkNotNullParameter(r21, "query");
        Intrinsics.checkNotNullParameter(r23, "version");
        Intrinsics.checkNotNullParameter(r24, "url");
        if (zh.b.f23447a != null) goto L31;
        return false;
    L31:
        String r27 = j.u(Uri.parse(r24));
        ArrayList r28 = new ArrayList();
        if (r21.length() <= 0) goto L37;
        Iterator<String> r29 = r21.keys();
    L35:
        if (r29.hasNext() == false) goto L37;
        r28.add(r29.next());
    L37:
        CollectionsKt.sort(r28);
        Keva r30 = zh.b.f23447a;
        if (r30.contains(r27) == true) goto L40;
    L39:
        boolean r31 = false;
    L55:
        if (r31 == false) goto L65;
        if (r25 == false) goto L63;
        zh.b.e(r27);
        if (zh.b.b(r27, r21, r28, r26, r18, r19, r23, r22) == true) goto L61;
        return false;
    L61:
        return true;
    L63:
        j.C("[SnapShot] snapshot conflict exception (URL: " + r24 + ", Query: " + r21 + "), Enforce: " + r25, null);
        throw new ISnapshotStore$SnapshotConflictException();
    L65:
        boolean r110 = zh.b.d(r27, r28, r21);
        if (zh.b.b(r27, r21, r28, r26, r18, r19, r23, r22) == true) goto L69;
        return false;
    L69:
        return r110;
    L40:
        String[] r32 = r30.getStringArray(r27, null);
        if (r32 != null) goto L44;
        zh.b.e(r27);
        goto L39
    L44:
        if (r32.length != 0) goto L49;
        if (r28.isEmpty() == true) goto L39;
    L49:
        if (r32.length == r28.size()) goto L51;
        r31 = true;
        goto L55
    L51:
        ArrayList r33 = new ArrayList();
        int r34 = r32.length;
        int r111 = 0;
    L52:
        if (r111 >= r34) goto L54;
        r33.add(r32[r111]);
        r111 = r111 + 1;
        goto L52
    L54:
        CollectionsKt.sort(r33);
        r31 = !Intrinsics.areEqual(r28, r33);
        goto L55
    }
}
