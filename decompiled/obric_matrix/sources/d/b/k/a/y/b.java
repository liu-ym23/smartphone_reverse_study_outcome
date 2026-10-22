package d.b.k.a.y;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import d.b.k.a.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements f {
    public b() {
    }

    @Override // d.b.k.a.y.f
    public void a(Uri r2, @Nullable n r3) {
        Log.d("Lighten:", "onIntermediateImageSet: uri=" + r2 + ", imageInfo=" + r3);
    }

    @Override // d.b.k.a.y.f
    public void b(Uri r1, @Nullable View r2) {
        Log.d("Lighten:", "onStart: uri=" + r1);
    }

    @Override // d.b.k.a.y.f
    public void c(Uri r2) {
        Log.d("Lighten:", "onRelease: uri=" + r2);
    }

    @Override // d.b.k.a.y.f
    public void e(Uri r2, Throwable r3) {
        Log.d("Lighten:", "onIntermediateImageFailed: uri=" + r2 + ", throwable=" + r3);
    }
}
