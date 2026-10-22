package tr;

import com.obric.oui.indexscrollbar.LettersBar;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LettersBar f22167b;

    public /* synthetic */ c(LettersBar r5, int r10) {
        this.f22166a = r10;
        this.f22167b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f22166a;
        LettersBar r10 = this.f22167b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LettersBar.b(r10);
        return;
    L6:
        LettersBar.a(r10);
    }
}
