package android.app;

/* JADX INFO: loaded from: classes.dex */
public final class DialogExt {
    private DialogExt() {
    }

    public static boolean hasFocus(Dialog dialog) {
        return dialog.getSmtEx().hasFocus();
    L4:
        return false;
    }
}
