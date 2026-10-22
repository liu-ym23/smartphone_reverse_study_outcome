package tmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f412a;
    private Handler b;
    private LinkedBlockingQueue c;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ pa f413a;

        a(pa r1, Looper r2) {
            this.f413a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            super.handleMessage(r3);
            if (r3.what == 0) goto L5;
            return;
        L5:
            boolean r4 = pa.m2430$$Nest$fgetc(this.f413a).isEmpty();
            pa r2 = this.f413a;
            if (r4 == false) goto L9;
            pa.m2431$$Nest$ma(r2);
            return;
        L9:
            pa.m2429$$Nest$fgetb(r2).sendEmptyMessageDelayed(0, 10);
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f414a;
        public long b;
        int c;
        int d;
        float e;
        final /* synthetic */ pa f;

        b(pa r3, String r4, int r5, int r6, float r7) {
            this.f = r3;
            this.b = System.currentTimeMillis();
            this.f414a = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        public String toString() {
            return "aveTTL=" + this.c + ",aveTime=" + this.d + ",errRate=" + ((int) this.e);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2429$$Nest$fgetb(pa r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedBlockingQueue m2430$$Nest$fgetc(pa r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2431$$Nest$ma(pa r0) {
        r0.a();
    }

    pa() {
        this.f412a = new HashMap();
        this.c = new LinkedBlockingQueue();
        HandlerThread r0 = new HandlerThread("ping_handler_thread");
        r0.start();
        this.b = new a(this, r0.getLooper());
    }

    private int a(String r2) {
        String[] r1 = r2.split("=");
        if (r1.length == 2) goto L7;
        return 0;
    L7:
        return (int) Float.parseFloat(r1[1]);
    }

    static boolean a(int r1) {
        if (r1 != 64) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 255) goto L8;
        return false;
    }

    private int b(String r2) {
        String[] r1 = r2.split("=");
        if (r1.length == 2) goto L7;
        return 0;
    L7:
        return Integer.parseInt(r1[1]);
    }

    private int[] c(String r7) {
        int[] r0 = new int[2];
        String[] r8 = r7.split(" ");
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r8[r3];
        if (r4.contains("ttl") == false) goto L8;
        r0[0] = b(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r4.contains(DBHelper.COL_TIME) == false) goto L10;
        r0[1] = a(r4);
        goto L10
    L11:
        return r0;
    }

    private void a(String r10, ArrayList r11) {
        if (r11.isEmpty() == true) goto L17;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L27;
        String r0 = (String) r12.next();
        if (r0.contains("icmp_seq") == false) goto L6;
        if (r0.contains("ttl") == false) goto L6;
        if (r0.contains(DBHelper.COL_TIME) == false) goto L6;
        int[] r1 = c(r0);
        LinkedBlockingQueue r2 = (LinkedBlockingQueue) this.f412a.get(r10);
        if (r2 != null) goto L16;
        r2 = new LinkedBlockingQueue();
    L16:
        r2.add(new b(this, r10, r1[0], r1[1], 0.0f));
        this.f412a.put(r10, r2);
        goto L6
    L27:
        return;
    }

    int a(int r6, int r7, String r8) {
        this.f412a.clear();     // Catch: Throwable -> L17
        StringBuilder r3 = new StringBuilder("ping -i 0.2");     // Catch: Throwable -> L17
        if (r6 > 0) goto L6;
        String r9 = "";
    L7:
        Process r10 = Runtime.getRuntime().exec(r3.append(r9).append(" -w ").append(r7).append("  ").append(r8).toString());     // Catch: Throwable -> L17
        r10.waitFor();     // Catch: Throwable -> L17
        BufferedReader r11 = new BufferedReader(new InputStreamReader(r10.getInputStream()));     // Catch: Throwable -> L17
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L15
    L9:
        String r2 = r11.readLine();     // Catch: Throwable -> L15
        q8.c("PingManager", "readLine =  " + r2);     // Catch: Throwable -> L15
        if (r2 == null) goto L12;
        r1.add(r2 + IOUtils.LINE_SEPARATOR_WINDOWS);     // Catch: Throwable -> L15
        goto L9
    L12:
        a(r8, r1);     // Catch: Throwable -> L15
        r10.destroy();     // Catch: Throwable -> L15
    L47:
        r11.close();     // Catch: Throwable -> L41
    L22:
        LinkedBlockingQueue r5 = (LinkedBlockingQueue) this.f412a.get(r8);
        if (r5 != null) goto L25;
    L36:
        return 64;
    L25:
        if (r5.size() <= 0) goto L36;
        Iterator r12 = r5.iterator();
    L29:
        if (r12.hasNext() == false) goto L36;
        b r13 = (b) r12.next();
        if (r13 == null) goto L29;
        if (a(r13.c) == true) goto L29;
        return r13.c;
    L15:
        th = th;
    L49:
        q8.b("PingManager", "startPing exception = " + th.toString());     // Catch: Throwable -> L37
        if (r11 == null) goto L22;
    L37:
        th = move-exception;
        if (r11 != null) goto L43;
    L40:
        throw th;
    L43:
        r11.close();     // Catch: Throwable -> L42
        goto L40
    L6:
        r9 = "-c" + r6;     // Catch: Throwable -> L17
    L17:
        th = th;
        r11 = null;
        goto L49
    }

    private void a() {
        HashMap r0 = this.f412a;
        monitor-enter(r0);
        Iterator r1 = this.f412a.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();     // Catch: Throwable -> L14
        String r3 = "address=" + r2 + ",";     // Catch: Throwable -> L14
        Iterator r4 = ((LinkedBlockingQueue) this.f412a.get(r2)).iterator();     // Catch: Throwable -> L14
    L9:
        if (r4.hasNext() == false) goto L6;
        r3 = r3 + r4.next().toString() + ",";     // Catch: Throwable -> L14
        goto L9
    L11:
        this.f412a.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
