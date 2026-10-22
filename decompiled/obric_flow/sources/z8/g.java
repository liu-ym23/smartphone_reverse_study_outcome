package z8;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23422c;
    public long d;
    public long e;
    public String f;

    public final JSONObject a() {
        JSONObject r5 = new JSONObject();
        r5.put("msg", this.f);     // Catch: JSONException -> L5
        r5.put("cpuDuration", this.e);     // Catch: JSONException -> L5
        r5.put("duration", this.d);     // Catch: JSONException -> L5
        r5.put("tick", this.f23422c);     // Catch: JSONException -> L5
        r5.put("type", this.f23421b);     // Catch: JSONException -> L5
        r5.put("count", this.f23420a);     // Catch: JSONException -> L5
    L7:
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final String toString() {
        int r5 = this.f23421b;
        if (r5 != 0) goto L7;
        return "[[[ IDLE  ]]] cost " + this.f23422c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
    L7:
        if (r5 != 1) goto L11;
        return "[[[ Long IDLE  ]]] cost " + this.f23422c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
    L11:
        if (r5 != 2) goto L15;
        return "[[[  1 msg  ]]] cost " + this.f23422c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e + ", msg:" + this.f;
    L15:
        if (r5 != 3) goto L19;
        return "[[[ 1 msg + IDLE  ]]] cost " + this.f23422c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
    L19:
        if (r5 != 4) goto L23;
        return "[[[ " + (this.f23420a - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.f23422c - 1) + "tick ,, mDuration：" + this.d + "cpuTime:" + this.e + " msg:" + this.f;
    L23:
        if (r5 != 5) goto L27;
        return "[[[ " + this.f23420a + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.f23422c - 1) + " ticks, , mDuration：" + this.d + "cpuTime:" + this.e;
    L27:
        if (r5 != 6) goto L31;
        return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.f23422c - 1) + ", , mDuration：" + this.d + "cpuTime:" + this.e;
    L31:
        if (r5 != 7) goto L35;
        return "[[[ " + this.f23420a + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
    L35:
        if (r5 != 8) goto L39;
        return "[[[ 1 msgs ]]] cost " + this.f23422c + " ticks , mDuration：" + this.d + " cost cpuTime:" + this.e + " msg:" + this.f;
    L39:
        if (r5 != 9) goto L43;
        return "[[[ " + this.f23420a + " msgs ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
    L43:
        return "=========   UNKNOW =========  Type:" + this.f23421b + " cost ticks " + this.f23422c + " msgs:" + this.f23420a;
    }
}
