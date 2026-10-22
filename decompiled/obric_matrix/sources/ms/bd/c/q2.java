package ms.bd.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 implements SensorEventListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile q2 f22461f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f22462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f22465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<JSONArray> f22466e;

    static {
        new DecimalFormat((String) m.a(16777217, 0, 0, "5b599f", new byte[]{116, 46, 22}));
        f22461f = null;
    }

    private q2(Context r8) {
        this.f22462a = null;
        this.f22464c = 0;
        this.f22465d = new float[3];
        this.f22466e = new ArrayList();
        Context r9 = r8.getApplicationContext();
        if (r9 == null) goto L6;
        this.f22462a = (SensorManager) r9.getSystemService((String) m.a(16777217, 0, 0, "e80a66", new byte[]{103, 63, 77, 6, 6, 51}));
        return;
    }

    public static q2 a(Context r2) {
        if (f22461f != null) goto L15;
        monitor-enter(q2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22461f != null) goto L9;
        f22461f = new q2(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(q2.class);     // Catch: Throwable -> L11
    L15:
        return f22461f;
    }

    private synchronized void d() {
        monitor-enter(this);
        SensorManager r1 = this.f22462a;     // Catch: Throwable -> L10 Exception -> L12
        if (r1 == null) goto L14;
        int r2 = this.f22463b - 1;     // Catch: Throwable -> L10 Exception -> L12
        this.f22463b = r2;     // Catch: Throwable -> L10 Exception -> L12
        if (r2 != 0) goto L14;
        r1.unregisterListener(this);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        String r0 = (String) m.a(16777217, 0, 0, "2ea7be", new byte[]{48, 116, 17, 124, 72});     // Catch: Throwable -> L10
        goto L14
    }

    public synchronized void b() {
        monitor-enter(this);
        JSONArray r0 = null;
    L56:
        th = move-exception;
        throw th;
    L5:
        if (e4.i() != 1) goto L45;
        monitor-enter(this);     // Catch: Throwable -> L56
        SensorManager r1 = this.f22462a;     // Catch: Throwable -> L18 Exception -> L60
        if (r1 == null) goto L21;
        if (this.f22463b == 0) goto L14;
    L16:
        this.f22463b++;     // Catch: Throwable -> L18 Exception -> L60
        goto L21
    L14:
        if (this.f22462a.registerListener(this, r1.getDefaultSensor(1), 3) == true) goto L16;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L21:
        monitor-exit(this);     // Catch: Throwable -> L56
        monitor-enter(this);     // Catch: Throwable -> L37 Exception -> L39
        int r5 = 0;
    L61:
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37 Exception -> L39
        goto L42
    L26:
        if (this.f22464c != 0) goto L30;
        if (r5 >= 10) goto L30;
        r5 = r5 + 1;     // Catch: Throwable -> L34
        wait(1000);     // Catch: Throwable -> L34
    L30:
        monitor-exit(this);     // Catch: Throwable -> L34
        r0 = new JSONArray();     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[0]).setScale(2, 4));     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[1]).setScale(2, 4));     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[2]).setScale(2, 4));     // Catch: Throwable -> L56
        d();     // Catch: Throwable -> L56
    L32:
        this.f22464c = 0;     // Catch: Throwable -> L56
    L37:
        th = move-exception;
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L56
        r6.put(new BigDecimal(this.f22465d[0]).setScale(2, 4));     // Catch: Throwable -> L56
        r6.put(new BigDecimal(this.f22465d[1]).setScale(2, 4));     // Catch: Throwable -> L56
        r6.put(new BigDecimal(this.f22465d[2]).setScale(2, 4));     // Catch: Throwable -> L56
        d();     // Catch: Throwable -> L56
        this.f22464c = 0;     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L42:
        String r2 = (String) m.a(16777217, 0, 0, "644640", new byte[]{52, 37, 68, 125, 12});     // Catch: Throwable -> L37
        r0 = new JSONArray();     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[0]).setScale(2, 4));     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[1]).setScale(2, 4));     // Catch: Throwable -> L56
        r0.put(new BigDecimal(this.f22465d[2]).setScale(2, 4));     // Catch: Throwable -> L56
        d();     // Catch: Throwable -> L56
    L45:
        if (r0 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.f22466e.add(r0);     // Catch: Throwable -> L56
        int r3 = this.f22466e.size();     // Catch: Throwable -> L59
        if (r3 <= 100) goto L52;
        ArrayList r4 = new ArrayList(this.f22466e.subList(r3 - 50, r3));     // Catch: Throwable -> L59
        this.f22466e.clear();     // Catch: Throwable -> L59
        this.f22466e = r4;     // Catch: Throwable -> L59
    L52:
        monitor-exit(this);
    }

    public synchronized String c() {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L36
        int r1 = this.f22466e.size();     // Catch: Throwable -> L36
        if (r1 <= 0) goto L6;
        List<JSONArray> r2 = this.f22466e;     // Catch: Throwable -> L39
        int r3 = r1 - 50;     // Catch: Throwable -> L39
        if (r3 > 0) goto L12;
        r3 = 0;
    L12:
        List<JSONArray> r4 = r2.subList(r3, r1);     // Catch: Throwable -> L39
        if (r4.size() <= 0) goto L31;
        Iterator<JSONArray> r5 = r4.iterator();     // Catch: Throwable -> L39
    L16:
        if (r5.hasNext() == false) goto L31;
        JSONArray r6 = r5.next();     // Catch: Throwable -> L39
        if (r6 == null) goto L16;
        r0.append(r6.get(0).toString());     // Catch: Throwable -> L39
        r0.append((String) m.a(16777217, 0, 0, "ab89db", new byte[]{60}));     // Catch: Throwable -> L39
        r0.append(r6.get(1).toString());     // Catch: Throwable -> L39
        r0.append((String) m.a(16777217, 0, 0, "cdc72f", new byte[]{62}));     // Catch: Throwable -> L39
        r0.append(r6.get(2).toString());     // Catch: Throwable -> L39
        r0.append((String) m.a(16777217, 0, 0, "1292d9", new byte[]{60}));     // Catch: Throwable -> L39
    L31:
        if (r0.length() <= 0) goto L33;
        r0.delete(r0.length() - 1, r0.length());     // Catch: Throwable -> L39
    L33:
        String r7 = r0.toString();     // Catch: Throwable -> L36
        monitor-exit(this);
        return r7;
    L6:
        monitor-exit(this);
        return null;
    L36:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r1) {
        this.f22465d = r1.values;
        this.f22464c = 1;
    }
}
