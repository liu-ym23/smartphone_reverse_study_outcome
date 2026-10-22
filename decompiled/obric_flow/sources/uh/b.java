package uh;

import android.net.Uri;
import dh.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f22362a;

    public b(String r5) {
        this.f22362a = r5;
    }

    @Override // dh.e
    public final Uri getUrl() {
        return Uri.parse(this.f22362a);
    }
}
