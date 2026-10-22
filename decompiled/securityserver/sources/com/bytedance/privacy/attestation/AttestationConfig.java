package com.bytedance.privacy.attestation;

import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class AttestationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean[] f6a;
    public final String b;
    public final boolean c;

    /* JADX INFO: renamed from: com.bytedance.privacy.attestation.AttestationConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f7a;
        public String b;
        public boolean c;

        public Builder() {
            this.f7a = new boolean[IdType.values().length];
            this.c = false;
        }

        public final void a(String r3) {
            if (r3.isEmpty() == true) goto L11;
            SecurityFrameworkCompat.i();
            if (r3.getBytes(StandardCharsets.UTF_8).length > 1024) goto L9;
            this.b = r3;
            return;
        L9:
            throw new BdPrivacyException("customInfo too long (max 1024 bytes)");
        L11:
            throw new BdPrivacyException("customInfo must not be null or empty");
        }
    }

    public static final enum IdType extends Enum<IdType> {
        public static final /* synthetic */ IdType[] b = null;

        static {
            b = new IdType[]{new IdType("UDID", 0), new IdType("RPDID", 1), new IdType("RPUID", 2)};
        }

        public static IdType valueOf(String r1) {
            return (IdType) Enum.valueOf(IdType.class, r1);
        }

        public static IdType[] values() {
            return (IdType[]) b.clone();
        }
    }

    public AttestationConfig(Builder r2) {
        this.f6a = (boolean[]) r2.f7a.clone();
        this.b = r2.b;
        this.c = r2.c;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AttestationConfig{requestedIds=[");
        IdType[] r1 = IdType.values();
        int r2 = r1.length;
        boolean r3 = true;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L10;
        IdType r6 = r1[r5];
        if (this.f6a[r6.ordinal()] == false) goto L9;
        if (r3 == true) goto L8;
        r0.append(", ");
    L8:
        r0.append(r6.name());
        r3 = false;
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        r0.append("]");
        String r4 = this.b;
        if (r4 == null) goto L13;
        r0.append(", customInfo='");
        r0.append(r4);
        r0.append('\'');
    L13:
        r0.append(", devHealthStatusRequired=");
        r0.append(this.c);
        r0.append('}');
        return r0.toString();
    }
}
