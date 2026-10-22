package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class j extends b.a {
    j() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Context r6 = a.a().c();
        ApplicationInfo r9 = r6.getPackageManager().getApplicationInfo(r6.getPackageName(), 0);
        String r12 = r9.sourceDir;
        if (r12 != null) goto L6;
        r12 = r9.publicSourceDir;
    L6:
        Map<Integer, String> r13 = c0.b(r12);
        String r14 = "";
        if (r13 != null) goto L9;
    L11:
        String r15 = "";
    L12:
        if (r15 == null) goto L17;
        if (r15.length() <= 0) goto L17;
        JSONObject r16 = new JSONObject(r15);
        r14 = c0.a(r16) + ((String) m.a(16777217, 0, 0, "b75b8b", new byte[]{40})) + c0.g(r16);
    L17:
        if (r14.length() == 0) goto L19;
        return r14;
    L19:
        return (String) m.a(16777217, 0, 0, "53ab17", new byte[]{10, 62, 28, 19});
    L9:
        if (r13.containsKey(1903654775) == false) goto L11;
        r15 = r13.get(1903654775);
        goto L12
    }
}
