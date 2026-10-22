package com.obric.capabilitykit;

import android.os.Bundle;
import com.obric.capabilitykit.version.PersonalContextData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/version/PersonalContextDataManager;", "", "()V", "remoteData", "Lcom/obric/capabilitykit/version/PersonalContextData;", "getRemoteData", "()Lcom/obric/capabilitykit/version/PersonalContextData;", "setRemoteData", "(Lcom/obric/capabilitykit/version/PersonalContextData;)V", "getData", "initPersonalContextData", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class z {
    public static final z a = null;
    private static volatile PersonalContextData b;

    static {
        a = new z();
    }

    private z() {
    }

    private final PersonalContextData c() {
        Bundle r1 = EntityProvider.INSTANCE.queryPersonalContextData$capabilitykit_release();
        if (r1 == null) goto L5;
        PersonalContextData r2 = PersonalContextData.Companion.createFromBundle(r1);
        b = r2;
        return r2;
    L5:
        return null;
    }

    public final PersonalContextData a() {
        PersonalContextData r0 = b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c();
    }

    public final void a(PersonalContextData r1) {
        b = r1;
    }

    public final PersonalContextData b() {
        return b;
    }
}
