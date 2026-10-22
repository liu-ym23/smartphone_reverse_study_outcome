package com.obric.capabilitykit.common;

import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/common/TimeTransformAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Long;", "serialize", "timeMillis", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeTransformAdapter implements r<Long>, i<Long> {
    public TimeTransformAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.i
    public Long deserialize(j r1, Type r2, h r3) {
        o.f(r1, "json");
        return Long.valueOf(r1.g() * 1000);
    }

    @Override // com.google.gson.i
    public /* bridge */ /* synthetic */ Long deserialize(j r1, Type r2, h r3) {
        return deserialize(r1, r2, r3);
    }

    public j serialize(long r1, Type r3, q r4) {
        return new p(Long.valueOf(r1 / 1000));
    }

    @Override // com.google.gson.r
    public /* bridge */ /* synthetic */ j serialize(Long r3, Type r4, q r5) {
        return serialize(r3.longValue(), r4, r5);
    }
}
