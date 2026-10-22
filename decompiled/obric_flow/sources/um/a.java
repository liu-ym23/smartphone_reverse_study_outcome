package um;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.apm6.cpu.exception.StateType;
import com.drakeet.multitype.MultiTypeAdapter;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements p.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f22372b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f22371a = r10;
        this.f22372b = r5;
    }

    public static Path m(float r10, float r11, float r12, float r13, float r14) {
        Path r15 = new Path();
        r15.addRoundRect(r10, r11, r12, r13, r14, r14, Path.Direction.CW);
        r15.close();
        return r15;
    }

    public void A(Class r5) {
    }

    public void B(GenericArrayType r5) {
    }

    public void C(ParameterizedType r5) {
    }

    public abstract void D(TypeVariable r5);

    public abstract void E(WildcardType r5);

    @Override // p.e
    public List e() {
        return (ArrayList) this.f22372b;
    }

    public abstract Animation f(LynxUI r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r114, int r115, Rect r116, float r117);

    public Object g(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        if ((r5 instanceof String) == false) goto L5;
        String r10 = (String) r5;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return h(r10);
    L5:
        r10 = null;
        goto L6
    }

    public abstract Object h(String r5);

    public abstract String i();

    @Override // p.e
    public boolean isStatic() {
        ArrayList r5 = (ArrayList) this.f22372b;
        if (r5.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r5.size() != 1) goto L10;
        if (((v.a) r5.get(0)).c() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void j(rd.b r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        com.bytedance.ies.bullet.service.sdk.b r13 = (com.bytedance.ies.bullet.service.sdk.b) r10;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        String r5 = (String) r13.f6143o.get(r11);
        LinkedHashMap r14 = r13.f6141m;
        if (r5 == null) goto L8;
        Object r15 = h(r5);
        this.f22372b = r15;
        if (r15 == null) goto L7;
        return;
    L7:
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r5, "value");
        r14.put(r11, r5);
    L8:
        Bundle r16 = r13.f6134b;
        if (r16 == null) goto L16;
        Object r17 = r16.get(r11);
        if (r17 == null) goto L16;
        Object r18 = g(r17);
        this.f22372b = r18;
        if (r18 == null) goto L15;
        return;
    L15:
        String r19 = r17.toString();
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r19, "value");
        r14.put(r11, r19);
    L16:
        this.f22372b = r12;
    }

    public boolean k() {
        tm.b r5 = (tm.b) this.f22372b;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.f22141b <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public abstract Path l(float r5, float r10, float r11, float r12, float r13);

    public boolean n(float r5, float r10) {
        return true;
    }

    public void o(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        s(Level.DEBUG, r5);
    }

    public abstract void p(Level r5, String r10);

    public MultiTypeAdapter q() {
        MultiTypeAdapter r5 = (MultiTypeAdapter) this.f22372b;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r5);
        return r5;
    L7:
        throw new IllegalStateException("This " + this + " has not been attached to MultiTypeAdapter yet. You should not call the method before registering the delegate.");
    }

    public boolean r(Level r5) {
        Intrinsics.checkNotNullParameter(r5, "lvl");
        if (((Level) this.f22372b).compareTo(r5) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void s(Level r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "lvl");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (r(r5) == false) goto L6;
        p(r5, r10);
        return;
    }

    public void t(com.bumptech.glide.load.engine.bitmap_recycle.h r5) {
        ArrayDeque r10 = (ArrayDeque) this.f22372b;
        if (r10.size() >= 20) goto L6;
        r10.offer(r5);
        return;
    }

    public String toString() {
        switch(this.f22371a) {
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder();
        ArrayList r10 = (ArrayList) this.f22372b;
        if (r10.isEmpty() == true) goto L10;
        r5.append("values=");
        r5.append(Arrays.toString(r10.toArray()));
    L10:
        return r5.toString();
    L5:
        return super.toString();
    }

    public abstract void u(RecyclerView.ViewHolder r5, Object r10);

    public abstract RecyclerView.ViewHolder v(LayoutInflater r5, ViewGroup r10);

    public void w() {
        if (td.b.f22124a == false) goto L8;
        String r5 = "enter : " + y();
        if (td.b.f22124a == false) goto L9;
        Log.i("APM-CPU", r5);
        return;
    L9:
        return;
    }

    public void x(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
    }

    public abstract StateType y();

    public void z(Type... r10) {
        int r5 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L31;
        Type r12 = r10[r11];
        if (r12 == null) goto L30;
        HashSet r13 = (HashSet) this.f22372b;
        if (r13.add(r12) == false) goto L30;
    L12:
        th = move-exception;
        r13.remove(r12);
        throw th;
    L10:
        if ((r12 instanceof TypeVariable) == false) goto L15;
        D((TypeVariable) r12);     // Catch: Throwable -> L12
        goto L30
    L15:
        if ((r12 instanceof WildcardType) == false) goto L18;
        E((WildcardType) r12);     // Catch: Throwable -> L12
        goto L30
    L18:
        if ((r12 instanceof ParameterizedType) == false) goto L21;
        C((ParameterizedType) r12);     // Catch: Throwable -> L12
        goto L30
    L21:
        if ((r12 instanceof Class) == false) goto L24;
        A((Class) r12);     // Catch: Throwable -> L12
        goto L30
    L24:
        if ((r12 instanceof GenericArrayType) == false) goto L26;
        B((GenericArrayType) r12);     // Catch: Throwable -> L12
        goto L30
    L26:
        String r14 = String.valueOf(r12);     // Catch: Throwable -> L12
        StringBuilder r15 = new StringBuilder(r14.length() + 14);     // Catch: Throwable -> L12
        r15.append("Unknown type: ");     // Catch: Throwable -> L12
        r15.append(r14);     // Catch: Throwable -> L12
        throw new AssertionError(r15.toString());     // Catch: Throwable -> L12
    L30:
        r11 = r11 + 1;
        goto L3
    }

    public a(int r5) {
        this.f22371a = r5;
        switch(r5) {
            case 1: goto L12;
            case 3: goto L11;
            case 4: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        this.f22372b = new tm.b();
        return;
    L6:
        this.f22372b = new RectF();
        return;
    L8:
        this.f22372b = new HashSet();
        return;
    L12:
        char[] r10 = q0.i.f21459a;
        this.f22372b = new ArrayDeque(20);
        return;
    }

    public a(ProtocolMessage r5) {
        this.f22371a = 5;
        Intrinsics.checkNotNullParameter(r5, "message");
        this.f22372b = r5;
    }

    public a(LynxView r5) {
        this.f22371a = 2;
        this.f22372b = new WeakReference(r5);
    }

    public a(Level r5) {
        this.f22371a = 9;
        Intrinsics.checkNotNullParameter(r5, "level");
        this.f22372b = r5;
    }
}
