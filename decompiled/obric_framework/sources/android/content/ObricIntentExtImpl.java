package android.content;

/* JADX INFO: loaded from: classes.dex */
public class ObricIntentExtImpl implements IObricIntentExt {
    public ObricIntentExtImpl() {
    }

    public void addObricFlags(Intent intent, int flags) {
        if (intent != null) goto L4;
        return;
    L4:
        if (intent.getObricExt() == null) goto L8;
        intent.getObricExt().addObricFlags(flags);
        return;
    }

    public void removeObricFlags(Intent intent, int flags) {
        if (intent != null) goto L4;
        return;
    L4:
        if (intent.getObricExt() == null) goto L8;
        intent.getObricExt().removeObricFlags(flags);
        return;
    }
}
