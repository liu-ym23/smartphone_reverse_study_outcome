package w0;

import com.bytedance.ai.model.objects.PageType;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22675a = null;

    static {
        int[] r5 = new int[PageType.values().length];
        r5[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f22675a = r5;
    }
}
