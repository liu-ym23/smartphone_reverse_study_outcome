package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final enum RequireKotlinVersionKind extends Enum<RequireKotlinVersionKind> {
    public static final RequireKotlinVersionKind b = null;
    public static final /* synthetic */ RequireKotlinVersionKind[] c = null;

    static {
        RequireKotlinVersionKind r0 = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        b = r0;
        c = new RequireKotlinVersionKind[]{r0, new RequireKotlinVersionKind("COMPILER_VERSION", 1), new RequireKotlinVersionKind("API_VERSION", 2)};
    }

    public static RequireKotlinVersionKind valueOf(String r1) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, r1);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) c.clone();
    }
}
