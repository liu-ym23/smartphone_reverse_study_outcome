package v8;

import android.text.TextUtils;
import androidx.room.writer.DaoWriter;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import sj.k;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f22550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f22551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22552c;

    public static String a(String r10, ArrayList r11) {
        io.reactivex.exceptions.a.d("npth", "upload alog " + r10 + ": " + r11);
        String r5 = String.valueOf(n.d().u().get(WsConstants.KEY_APP_ID));     // Catch: Throwable -> L7
        String r12 = n.g().e();     // Catch: Throwable -> L7
        String r13 = "normal";
        if (TextUtils.isEmpty(r5) == false) goto L10;
        String r14 = "no_aid";
    L22:
        if (r14.equals("normal") == true) goto L24;
        return r14;
    L24:
        String r15 = b(r11);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r15) == false) goto L29;
        k.g().getClass();     // Catch: Throwable -> L7
        if (k.j(r5, r12, r10, r11) == false) goto L36;
        return "normal";
    L36:
        return "unknown";
    L29:
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L7
        r16.add(r15);     // Catch: Throwable -> L7
        k.g().getClass();     // Catch: Throwable -> L7
        if (k.j(r5, r12, r10, r16) == true) goto L33;
        r13 = "unknown";
    L33:
        new File(r15).delete();     // Catch: Throwable -> L7
        return r13;
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L13;
        r14 = "no_did";
        goto L22
    L13:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        r14 = "no_process";
        goto L22
    L15:
        if (r11 != null) goto L17;
    L20:
        r14 = "no_files";
        goto L22
    L17:
        if (r11.size() == 0) goto L20;
        r14 = "normal";
    L7:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L36
    }

    public static String b(ArrayList r10) {
        File r5 = new File((String) r10.get(0));
        String r11 = r5.getParent();
        String r12 = r5.getName();
        if (TextUtils.isEmpty(r12) == false) goto L5;
        String r13 = "";
    L9:
        File r14 = new File(r11, r13);
        if (r14.exists() == false) goto L21;
        r14.delete();
    L21:
        cl.a.w(r14.getAbsolutePath(), r10);     // Catch: Exception -> L15
        return r14.getAbsolutePath();
    L16:
        if (r14.exists() == false) goto L24;
        r14.delete();     // Catch: Exception -> L20
        return null;
    L24:
        return null;
    L25:
        return null;
    L5:
        int r15 = r12.lastIndexOf(".");
        if (r15 != (-1)) goto L8;
        r13 = r12.concat(".zip");
        goto L9
    L8:
        r13 = r12.substring(0, r15) + ".zip";
        goto L9
    }

    public static a d() {
        if (d != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public final ArrayList c(long r23, String r25) {
        File r5 = null;
        if (TextUtils.isEmpty(this.f22550a) == false) goto L6;
        return null;
    L6:
        if (new File(this.f22550a).exists() == true) goto L8;
        return null;
    L8:
        String r10 = this.f22550a;
        if ((this.f22551b instanceof b) == false) goto L11;
        b r11 = new b();
        r11.f22553a = r25;
        Object r12 = r11;
    L13:
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return null;
    L16:
        if (new File(r10).exists() == false) goto L107;
        if (r12 == null) goto L105;
        b r13 = (b) r12;
        if (r13.f22553a != null) goto L22;
        r13.f22553a = m.o(n.f4057a);
    L22:
        String r14 = r13.f22553a;
        if (r14 == null) goto L25;
        boolean r15 = !r14.contains(":");
    L26:
        ArrayList r16 = new ArrayList();
        if (TextUtils.isEmpty(r10) == true) goto L87;
        File r17 = new File(r10);     // Catch: Exception -> L95
        if (r17.exists() == true) goto L32;
    L77:
        File r18 = null;
    L78:
        if (r5 != null) goto L80;
    L82:
        if (r18 == null) goto L87;
        if (r18.length() <= 0) goto L87;
        r16.add(r18.getAbsolutePath());     // Catch: Exception -> L95
        goto L87
    L80:
        if (r5.length() <= 0) goto L82;
        r16.add(r5.getAbsolutePath());     // Catch: Exception -> L95
        goto L82
    L32:
        if (r17.listFiles() == null) goto L77;
        if (r13.f22553a.contains(":") == false) goto L37;
        String r19 = r13.f22553a.replace(":", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);     // Catch: Exception -> L95
    L38:
        File[] r20 = r17.listFiles();     // Catch: Exception -> L95
        int r21 = r20.length;     // Catch: Exception -> L95
        File r110 = null;
        int r111 = 0;
        long r112 = 0;
        long r113 = 0;
    L39:
        if (r111 >= r21) goto L76;
        File r114 = r20[r111];     // Catch: Exception -> L95
        String r22 = r114.getName();     // Catch: Exception -> L95
        if (r22.endsWith(".hot") == false) goto L75;
        if (r15 == true) goto L45;
    L46:
        if (r15 == true) goto L51;
        if (r114.getName().contains(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L75;
    L51:
        if (r22.contains(r19) == false) goto L75;
        String[] r24 = r22.split("_");     // Catch: Exception -> L95
        if (r24 != null) goto L56;
    L58:
        if (r24 != null) goto L60;
    L63:
        long r26 = -1;
    L65:
        if (r23 <= 0) goto L70;
        if (r26 > r23) goto L75;
    L70:
        if (r112 >= r26) goto L73;
        r110 = r5;
        r113 = r112;
        r5 = r114;
        r112 = r26;
        goto L75
    L73:
        if (r113 >= r26) goto L75;
        r113 = r26;
        r110 = r114;
        goto L75
    L60:
        if (r24.length <= 1) goto L63;
        r26 = Long.parseLong(r24[0]);     // Catch: Exception -> L95
        goto L65
    L56:
        if (r24.length < 4) goto L58;
        r26 = Long.parseLong(r24[3]);     // Catch: Exception -> L95
        goto L65
    L45:
        if (r114.getName().contains(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L46;
    L75:
        r111 = r111 + 1;     // Catch: Exception -> L95
        goto L39
    L76:
        r18 = r5;
        r5 = r110;
        goto L78
    L37:
        r19 = r13.f22553a;     // Catch: Exception -> L95
    L87:
        if (r16.isEmpty() == true) goto L94;
        if (r25 == null) goto L94;
        Iterator r27 = r16.iterator();
    L91:
        if (r27.hasNext() == false) goto L94;
        String r28 = (String) r27.next();
        io.reactivex.exceptions.a.d("collect alog: ", r28);
        e.l("collectAlog", r28);
    L94:
        return r16;
    L25:
        r15 = true;
        goto L26
    L105:
        return null;
    L107:
        return null;
    L11:
        r12 = this.f22551b;
        goto L13
    }
}
