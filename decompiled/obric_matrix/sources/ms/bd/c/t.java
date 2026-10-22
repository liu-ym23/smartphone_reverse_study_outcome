package ms.bd.c;

import android.os.Build;
import com.bytedance.keva.KevaImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f22491a;

    public t() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r37v0, types: [ms.bd.c.s, ms.bd.c.t] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    private Object[] h(String r38, byte[] r39, String r40, String r41, String r42, boolean r43) {
        q.a r5 = new q.a();
        int r21 = -1;
        HttpURLConnection r10 = (HttpURLConnection) new URL(r38).openConnection();     // Catch: Throwable -> L108 Exception -> L112
    L142:
    L41:
        th = th;
    L110:
        DataOutputStream r2 = null;
    L111:
        ?? r9 = 0;
        ?? r3 = r2;
    L132:
        c(r9);
        d(r3);
        if (r10 != null) goto L159;
    L137:
        throw th;
    L159:
        r10.disconnect();     // Catch: Exception -> L136
    L136:
        String r1 = (String) m.a(16777217, 0, 0, "92d26d", new byte[]{59, 56, 20, 121, 1, 98, 104});
        goto L137
    L6:
        if ((r10 instanceof HttpsURLConnection) == false) goto L146;
        if (this.f22491a != null) goto L34;
        monitor-enter(t.class);     // Catch: Throwable -> L41 Exception -> L138
    L29:
        th = th;
    L31:
        monitor-exit(t.class);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L41 Exception -> L138
    L12:
        if (this.f22491a != null) goto L25;
        if (Build.VERSION.SDK_INT < 20) goto L20;
        Object r0 = m.a(16777217, 0, 0, "84b9b4", new byte[]{29, 26, 34});     // Catch: Throwable -> L29
    L21:
        SSLContext r4 = SSLContext.getInstance((String) r0);     // Catch: Throwable -> L29
        r4.init(null, null, null);     // Catch: Throwable -> L27
        this.f22491a = r4.getSocketFactory();     // Catch: Throwable -> L27
        goto L25
    L20:
        r0 = m.a(16777217, 0, 0, "03fe25", new byte[]{21, 29, 38, 7, 92, 108, 97});     // Catch: Throwable -> L29
    L25:
        monitor-exit(t.class);     // Catch: Throwable -> L27
    L27:
        th = th;
    L34:
        SSLSocketFactory r6 = this.f22491a;     // Catch: Throwable -> L41 Exception -> L138
        if (r6 == null) goto L146;
        HttpsURLConnection r14 = (HttpsURLConnection) r10;     // Catch: Throwable -> L41 Exception -> L138
        if (Build.VERSION.SDK_INT < 20) goto L39;
    L38:
        r14.setSSLSocketFactory(r6);     // Catch: Throwable -> L41 Exception -> L138
        goto L146
    L39:
        r6 = new v(this.f22491a);     // Catch: Throwable -> L41 Exception -> L138
    L146:
        r10.setConnectTimeout(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L41 Exception -> L141
        r10.setReadTimeout(5000);     // Catch: Throwable -> L41 Exception -> L141
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "3da812", new byte[]{3, 101, 17, 73, 30, 49}), (String) m.a(16777217, 0, 0, "8b6d9f", new byte[]{99, 47, 15}));     // Catch: Throwable -> L41 Exception -> L141
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "1bd42c", new byte[]{3, 111, 25, 78, 8, 119, 38, 74, 58, 106}), (String) m.a(16777217, 0, 0, "e8383a", new byte[]{95, 63, 69, 92, 65, 87, 106, 16, 116, 109}));     // Catch: Throwable -> L41 Exception -> L141
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "fab068", new byte[]{66, 112, 20, 86, 68, 14, 98, 69, 61, 116}), (String) m.a(16777217, 0, 0, "880669", new byte[]{11, 35, 87, 71, 45, 47, 53, 26, 100, 43, 4, 9, 112, 102, 34}));     // Catch: Throwable -> L41 Exception -> L141
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "09f1ed", new byte[]{2, 52, 27, 81, 95, 125, 39, 85, 3, 120, 49, 62}), (String) m.a(16777217, 0, 0, "6e6e9d", new byte[]{38, 119, 85, 29, 15, 112, 52, 80, 110, 58, 41, 40, 74, 18, 18, 118, 33, 9, 116, 33, 53, 98, 68, 28}));     // Catch: Throwable -> L41 Exception -> L141
        if (r40 != null) goto L63;
    L68:
        if (r41 != null) goto L70;
    L73:
        r5.a(r38);     // Catch: Throwable -> L41 Exception -> L141
        if (r43 == true) goto L76;
        r2 = null;
    L80:
        int r7 = r10.getResponseCode();     // Catch: Throwable -> L105 Exception -> L140
        r5.c(r10.getHeaderField((String) m.a(16777217, 0, 0, "46a75c", new byte[]{61, 121, 6, 87, 71, 120, 56, 16, 57, 99})), r7);     // Catch: Exception -> L104 Throwable -> L105
        if (r7 != 200) goto L98;
        BufferedInputStream r8 = new BufferedInputStream(r10.getInputStream());     // Catch: Exception -> L104 Throwable -> L105
    L105:
        th = th;
        goto L111
    L152:
        if (r42 == null) goto L87;
        OutputStream r11 = new FileOutputStream(r42);     // Catch: Exception -> L139 Throwable -> L130
    L88:
        byte[] r12 = new byte[256];     // Catch: Exception -> L139 Throwable -> L130
    L89:
        int r13 = r8.read(r12);     // Catch: Exception -> L139 Throwable -> L130
        if (r13 <= 0) goto L92;
        r11.write(r12, 0, r13);     // Catch: Exception -> L139 Throwable -> L130
        goto L89
    L92:
        r11.flush();     // Catch: Exception -> L139 Throwable -> L130
        if ((r11 instanceof ByteArrayOutputStream) == false) goto L95;
        byte[] r15 = ((ByteArrayOutputStream) r11).toByteArray();     // Catch: Exception -> L139 Throwable -> L130
    L96:
        r11.close();     // Catch: Exception -> L139 Throwable -> L130
        BufferedInputStream r16 = r8;
    L99:
        c(r16);
        d(r2);
        r10.disconnect();     // Catch: Exception -> L102
    L103:
        byte[] r17 = r15;
    L129:
        return new Object[]{String.valueOf(r7), r17};
    L102:
        String r18 = (String) m.a(16777217, 0, 0, "94d054", new byte[]{59, 62, 20, 123, 2, 50, 104});
        goto L103
    L95:
        r15 = null;
        goto L96
    L87:
        r11 = new ByteArrayOutputStream();     // Catch: Exception -> L139 Throwable -> L130
    L116:
        String r19 = (String) m.a(16777217, 0, 0, "fcca55", new byte[]{100, 105, 19, 42, 2, 51});     // Catch: Throwable -> L130
        if (r10 != null) goto L119;
        String r20 = null;
    L121:
        r5.b(r20, r7);     // Catch: Throwable -> L130
        c(r8);
        d(r2);
        if (r10 != null) goto L154;
    L127:
        r17 = null;
        goto L129
    L154:
        r10.disconnect();     // Catch: Exception -> L126
    L126:
        String r22 = (String) m.a(16777217, 0, 0, "a61049", new byte[]{99, 60, 65, 123, 3, 63, 48});
        goto L127
    L119:
        r20 = r10.getHeaderField((String) m.a(16777217, 0, 0, "25cab0", new byte[]{59, 122, 4, 1, 16, 43, 62, 19, 59, 53}));     // Catch: Throwable -> L130
        goto L121
    L98:
        r15 = null;
        r16 = null;
    L104:
        r21 = r7;
    L107:
        r7 = r21;
        r2 = r2;
    L114:
        r8 = null;
        goto L116
    L76:
        r10.setRequestMethod((String) m.a(16777217, 0, 0, "8761d8", new byte[]{25, 26, 118, 113}));     // Catch: Throwable -> L41 Exception -> L141
        r10.setDoOutput(true);     // Catch: Throwable -> L41 Exception -> L141
        r2 = new DataOutputStream(r10.getOutputStream());     // Catch: Throwable -> L41 Exception -> L141
        r2.write(r39);     // Catch: Throwable -> L105 Exception -> L140
        r2.flush();     // Catch: Throwable -> L105 Exception -> L140
        r2 = r2;
        goto L80
    L70:
        if (r41.trim().length() <= 0) goto L73;
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "6bcf9a", new byte[]{63, 45, 4, 6, 75, 100, 48, 82, 39, 51, 52, 116, 93, 6, 7, 113}), r41);     // Catch: Throwable -> L41 Exception -> L141
        goto L73
    L63:
        if (r40.trim().length() <= 0) goto L68;
        r10.setRequestProperty((String) m.a(16777217, 0, 0, "f4953d", new byte[]{84, 57, 69, 74, 5, 118}), String.format((String) m.a(16777217, 0, 0, "ec36d3", new byte[]{103, 100, 83, 81, 82, 43, 104, 75, 102, 59, 49, 114}), new Object[]{r40}));     // Catch: Throwable -> L41 Exception -> L141
    L113:
        r7 = -1;
        r2 = null;
    L130:
        th = th;
        r3 = r38;
        r9 = r41;
    L112:
        r10 = null;
    L108:
        th = th;
        r10 = null;
        goto L110
    }

    @Override // ms.bd.c.s
    public Object[] e(String r8, String r9, String r10) {
        return h(r8, null, null, r10, r9, false);
    }

    @Override // ms.bd.c.s
    public Object[] f(String r8, byte[] r9, String r10, String r11) {
        return h(r8, r9, r10, r11, null, true);
    }

    @Override // ms.bd.c.s
    public Object[] g(String r8, String r9, String r10) {
        return h(r8, null, r9, r10, null, false);
    }
}
