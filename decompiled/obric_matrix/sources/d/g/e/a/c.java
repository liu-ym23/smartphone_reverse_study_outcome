package d.g.e.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.j;
import com.google.gson.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/sdk/osettings/OSettingsData;", "", WsConstants.KEY_CONNECTION_TYPE, "Lcom/obric/sdk/osettings/SettingsType;", "settings", "Lcom/google/gson/JsonObject;", "updateTime", "", "(Lcom/obric/sdk/osettings/SettingsType;Lcom/google/gson/JsonObject;J)V", "getSettings", "()Lcom/google/gson/JsonObject;", "getType", "()Lcom/obric/sdk/osettings/SettingsType;", "getUpdateTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "get", "Lcom/google/gson/JsonElement;", "keyS", "", "has", "hashCode", "", "toString", "osettings_sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f16947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f16948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16949c;

    public c() {
        this(null, null, 0, 7, null);
    }

    public c(f r2, m r3, long r4) {
        o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        o.f(r3, "settings");
        this.f16947a = r2;
        this.f16948b = r3;
        this.f16949c = r4;
    }

    public /* synthetic */ c(f r1, m r2, long r3, int r5, g r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = f.f16973l;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = new m();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r3 = System.currentTimeMillis();
    L11:
        this(r1, r2, r3);
    }

    public final j a(String r8) {
        o.f(r8, "keyS");
        m r7 = this.f16948b;
        List r9 = k.n0(r8, new String[]{"."}, false, 0, 6, null);
        Iterator r0 = r9.subList(0, r9.size() - 1).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        String r1 = (String) r0.next();
        if (r7.z(r1) == false) goto L11;
        if (r7.v(r1).o() == false) goto L18;
        r7 = r7.x(r1);
        o.e(r7, "data.getAsJsonObject(key)");
        goto L4
    L18:
        return null;
    L11:
        return null;
    L14:
        return r7.v((String) r.b0(r9));
    }

    public final m b() {
        return this.f16948b;
    }

    public final long c() {
        return this.f16949c;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof c) == true) goto L8;
        return false;
    L8:
        c r7 = (c) r6;
        if (this.f16947a == r7.f16947a) goto L12;
        return false;
    L12:
        if (o.a(this.f16948b, r7.f16948b) == true) goto L15;
        return false;
    L15:
        if (this.f16949c == r7.f16949c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f16947a.hashCode() * 31) + this.f16948b.hashCode()) * 31) + Long.hashCode(this.f16949c);
    }

    public String toString() {
        return "OSettingsData(type=" + this.f16947a + ", settings=" + this.f16948b + ", updateTime=" + this.f16949c + ')';
    }
}
