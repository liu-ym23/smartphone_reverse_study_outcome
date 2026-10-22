package uf;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.h;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f22342b;

    public /* synthetic */ c(int r5, View r10) {
        this.f22341a = r5;
        this.f22342b = r10;
    }

    private final void a(SurfaceTexture r5) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r5, int r10, int r11) {
        switch(this.f22341a) {
            case 0: goto L26;
            default: goto L4;
        };
    L4:
        e r12 = (e) this.f22342b;
        of.e r13 = r12.f22339b;
        if (r13 == null) goto L9;
        r13.d(r12.getSurface());
        of.e r14 = ((e) this.f22342b).f22339b;
        if (r14.f20558a == null) goto L9;
        r14.c(r10, r11);
    L9:
        e r15 = (e) this.f22342b;
        if (r15.f22350i == true) goto L63;
        ArrayList r16 = r15.f22349h;
        if (r16 != null) goto L15;
        return;
    L15:
        if (r16.isEmpty() == true) goto L64;
        r15.f22350i = true;
        Surface r17 = r15.getSurface();
        of.e r18 = r15.f22339b;
        if (r18 == null) goto L20;
        r18.d(r17);
    L20:
        Iterator r19 = new ArrayList(r15.f22349h).iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        ((Runnable) r19.next()).run();
        goto L22
    L24:
        r15.f22349h.clear();
        r15.f22350i = false;
        return;
    L64:
        return;
    L63:
        return;
    L26:
        LynxLog.b(2, "TextureVideoView", h.b(r10, r11, "onSurfaceTextureAvailable width = ", " height = "));
        d r20 = (d) this.f22342b;
        if (r20.f22348j == false) goto L53;
        Surface r21 = r20.f22343a;
        if (r21 == null) goto L36;
        if (r20.d == true) goto L33;
    L34:
        r20.f22343a.release();
        r20.f22343a = null;
        r20.f22344b = null;
        goto L36
    L33:
        if (r21.isValid() == false) goto L34;
    L36:
        if (r20.f22343a != null) goto L59;
        r20.f22343a = new Surface(r5);
        r20.f22344b = r5;
    L52:
        r20.d = true;
    L54:
        TextureView.SurfaceTextureListener r22 = r20.f22345c;
        if (r22 == null) goto L65;
        r22.onSurfaceTextureAvailable(r20.f22344b, r10, r11);
        return;
    L65:
        return;
    L59:
        SurfaceTexture r23 = r20.f22344b;     // Catch: Exception -> L47
        if (r23 != null) goto L41;
    L49:
        r20.f22344b = r5;     // Catch: Exception -> L47
        r20.f22343a = new Surface(r5);     // Catch: Exception -> L47
    L58:
        goto L52
    L41:
        if (r23.isReleased() == true) goto L49;
        if (r20.f22344b == r20.getSurfaceTexture()) goto L58;
        r20.setSurfaceTexture(r20.f22344b);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        LynxLog.b(4, "TextureVideoView", "onSurfaceTextureAvailable encounter exception " + e.getMessage());
        r20.f22344b = r5;
        r20.f22343a = new Surface(r5);
        goto L52
    L53:
        r20.f22343a = new Surface(r5);
        r20.f22344b = r5;
        goto L54
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r5) {
        switch(this.f22341a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        of.e r10 = ((e) this.f22342b).f22339b;
        if (r10 == null) goto L28;
        r10.d(null);
        return true;
    L28:
        return true;
    L9:
        d r11 = (d) this.f22342b;
        if (r11.f22348j == true) goto L12;
    L16:
        TextureView.SurfaceTextureListener r12 = r11.f22345c;
        if (r12 == null) goto L19;
        r12.onSurfaceTextureDestroyed(r5);
    L19:
        boolean r13 = r11.f22348j;
        if (r13 == true) goto L27;
        if (r13 == true) goto L25;
        Surface r14 = r11.f22343a;
        if (r14 == null) goto L25;
        r14.release();
        r11.f22343a = null;
    L25:
        r11.d = false;
        r11.f22343a = null;
        r11.f22344b = null;
    L27:
        return !r11.f22348j;
    L12:
        if (r11.d == true) goto L16;
        Surface r15 = r11.f22343a;
        if (r15 == null) goto L16;
        r15.release();
        r11.f22343a = null;
        r11.f22344b = null;
        goto L16
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r5, int r10, int r11) {
        switch(this.f22341a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        of.e r12 = ((e) this.f22342b).f22339b;
        if (r12.f20558a == null) goto L12;
        r12.c(r10, r11);
        return;
    L12:
        return;
    L8:
        TextureView.SurfaceTextureListener r13 = ((d) this.f22342b).f22345c;
        if (r13 == null) goto L13;
        r13.onSurfaceTextureSizeChanged(r5, r10, r11);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r5) {
        switch(this.f22341a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        TextureView.SurfaceTextureListener r10 = ((d) this.f22342b).f22345c;
        if (r10 == null) goto L9;
        r10.onSurfaceTextureUpdated(r5);
        return;
    }
}
