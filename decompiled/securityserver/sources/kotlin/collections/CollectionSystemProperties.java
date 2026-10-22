package kotlin.collections;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CollectionSystemProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f331a = false;

    static {
        String r0 = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        if (r0 == null) goto L5;
        boolean r1 = Boolean.parseBoolean(r0);
    L6:
        f331a = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
