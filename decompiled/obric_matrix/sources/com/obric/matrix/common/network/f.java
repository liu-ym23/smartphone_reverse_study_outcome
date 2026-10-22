package com.obric.matrix.common.network;

import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\u0002J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0086\u0002J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0006J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000eJ\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0015J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001bJ\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000J\u0010\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0000J\u001a\u0010&\u001a\u00020\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0010\u0010(\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u0005H\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/matrix/common/network/LogParams;", "Ljava/io/Serializable;", "()V", "all", "", "", "", "getAll", "()Ljava/util/Map;", "map", "", "clear", "", "contains", "", "key", "get", "k", "getBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getString", "has", "keySet", "", "put", BaseSwitches.V, "putAllIfNotExit", "params", "putAllWithReplace", "putMap", "param", "remove", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Object> f8931f;

    static {
    }

    public f() {
        this.f8931f = new HashMap();
    }

    public final f a(String r2, int r3) {
        o.f(r2, "k");
        Integer r4 = Integer.valueOf(r3);
        this.f8931f.put(r2, r4);
        return this;
    }

    public final f b(String r2, String r3) {
        o.f(r2, "k");
        o.f(r3, BaseSwitches.V);
        this.f8931f.put(r2, r3);
        return this;
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        Set<String> r1 = this.f8931f.keySet();
        if ((!r1.isEmpty()) == false) goto L10;
        Iterator<String> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type kotlin.String");
        String r4 = r3;
        r0.put(r4, this.f8931f.get(r4));     // Catch: JSONException -> L11
    L10:
        return r0;
    }

    public String toString() {
        return this.f8931f.toString();
    }
}
