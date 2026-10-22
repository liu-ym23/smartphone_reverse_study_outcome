package kotlin.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum OnErrorAction extends Enum<OnErrorAction> {
    public static final /* synthetic */ OnErrorAction[] b = null;

    static {
        b = new OnErrorAction[]{new OnErrorAction("SKIP", 0), new OnErrorAction("TERMINATE", 1)};
    }

    public static OnErrorAction valueOf(String r1) {
        return (OnErrorAction) Enum.valueOf(OnErrorAction.class, r1);
    }

    public static OnErrorAction[] values() {
        return (OnErrorAction[]) b.clone();
    }
}
