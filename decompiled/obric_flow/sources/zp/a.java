package zp;

import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f23555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GLTextureView f23556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f23557c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f23558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ GLTextureView f23559i;

    public a(GLTextureView r10, int r11, int r12) {
        this.f23559i = r10;
        int[] r5 = {12324, 8, 12323, 8, 12322, 8, 12321, r11, 12325, r12, 12326, 0, 12344};
        this.f23556b = r10;
        if (r10.f11369i != 2) goto L6;
        int[] r13 = new int[15];
        System.arraycopy(r5, 0, r13, 0, 12);
        r13[12] = 12352;
        r13[13] = 4;
        r13[14] = 12344;
        r5 = r13;
    L6:
        this.f23555a = r5;
        this.f23557c = new int[1];
        this.d = 8;
        this.e = 8;
        this.f = 8;
        this.g = r11;
        this.f23558h = r12;
    }

    public final int a(EGL10 r5, EGLDisplay r10, EGLConfig r11, int r12) {
        int[] r13 = this.f23557c;
        if (r5.eglGetConfigAttrib(r10, r11, r12, r13) == true) goto L5;
        return 0;
    L5:
        return r13[0];
    }
}
