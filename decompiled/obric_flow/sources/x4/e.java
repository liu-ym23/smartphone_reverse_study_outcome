package x4;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22967c;
    public String d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22968h;

    public final String toString() {
        StringBuilder r5 = new StringBuilder("JSBInfo{bridgeName='");
        r5.append(this.f22965a);
        r5.append("', statusCode=");
        r5.append(this.f22966b);
        r5.append(", statusDescription='");
        r5.append(this.f22967c);
        r5.append("', protocolVersion='");
        r5.append(this.d);
        r5.append("', costTime=");
        r5.append(this.e);
        r5.append(", invokeTime=");
        r5.append(this.f);
        r5.append(", callbackTime=");
        return j0.o(r5, this.g, ", fireEventTime=0}");
    }
}
