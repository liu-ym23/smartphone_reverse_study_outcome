package w2;

import com.bytedance.ai.model.objects.PageType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22701a = null;

    static {
        int[] r5 = new int[PageType.values().length];
        r5[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r5[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r5[PageType.WIDGET_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r5[PageType.GEN_CARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r5[PageType.FLOATING_VIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r5[PageType.OTHER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        f22701a = r5;
    }
}
