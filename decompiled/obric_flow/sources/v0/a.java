package v0;

import android.app.Application;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.launcher.widget.R$id;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f22486q;

    public a(Application r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        View.inflate(r5, r10, this);
        this.f22486q = (FrameLayout) findViewById(R$id.floating_layout);
    }
}
