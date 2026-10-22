package ym;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bytedance.ai.widget.WidgetRenderType;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements z2.g, pt.p, k0.g, m2.b, s8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23310b;

    public /* synthetic */ o(Object r5, int r10) {
        this.f23309a = r10;
        this.f23310b = r5;
    }

    public static boolean g(IWsApp r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        SsWsApp r10 = (SsWsApp) r5;
        if (r10.f4000b > 0) goto L9;
        return false;
    L9:
        if (r10.d > 0) goto L12;
        return false;
    L12:
        if (com.bytedance.common.utility.b.b(r10.f4004j) == false) goto L15;
        return false;
    L15:
        if (r10.g > 0) goto L18;
        return false;
    L18:
        if (r10.f3999a.isEmpty() == false) goto L21;
        return false;
    L21:
        if (com.bytedance.common.utility.b.b(r10.e) == false) goto L24;
        return false;
    L24:
        if (r10.f4003i > 0) goto L27;
        return false;
    L27:
        if (com.bytedance.common.utility.b.b(r10.f) == false) goto L30;
        return false;
    L30:
        if (r10.f4002h == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // m2.b
    public String a(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        ConcurrentHashMap r12 = (ConcurrentHashMap) ((ConcurrentHashMap) this.f23310b).get(r5);
        if (r12 == null) goto L8;
        String r13 = (String) r12.get(r10);
        if (r13 == null) goto L8;
        return r13;
    L8:
        return r11;
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        AppletWidgetContainer r10 = (AppletWidgetContainer) this.f23310b;
        com.bytedance.ai.widget.contianer.h r11 = r10.f;
        String r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.f3047a;
    L6:
        r5.f = r13;
        if (r11 == null) goto L9;
        r12 = r11.f3048b;
    L9:
        r5.g = r12;
        g1.b r14 = r10.f2994w;
        if (r14 == null) goto L22;
        int r15 = r14.getRenderType().ordinal();
        if (r15 != 0) goto L14;
        WidgetRenderType r16 = WidgetRenderType.f2933c;
    L23:
        r5.c("renderType", r16.f2934a);
        r5.c("message_id", r10.v());
        com.bytedance.ai.widget.contianer.h r17 = r10.f;
        if (r17 == null) goto L27;
        String r18 = r17.d;
        if (r18 == null) goto L27;
    L28:
        r5.c("botId", r18);
        return;
    L27:
        r18 = "";
        goto L28
    L14:
        if (r15 != 1) goto L16;
        r16 = WidgetRenderType.d;
        goto L23
    L16:
        if (r15 != 2) goto L19;
        r16 = WidgetRenderType.e;
        goto L23
    L19:
        throw new NoWhenBranchMatchedException();
    L22:
        r16 = WidgetRenderType.f2932b;
        goto L23
    L5:
        r13 = null;
        goto L6
    }

    public int c(View r5) {
        if ((r5 instanceof com.lynx.tasm.behavior.ui.view.c) == false) goto L10;
        com.lynx.tasm.behavior.ui.view.c r10 = (com.lynx.tasm.behavior.ui.view.c) r5;
        if ((r10.getDrawChildHook() instanceof UIComponent) == false) goto L12;
        String r11 = ((UIComponent) r10.getDrawChildHook()).f10770b;
        UIListContainer r12 = (UIListContainer) this.f23310b;
        if (r12.f10569c.contains(r11) == true) goto L9;
        return -1;
    L9:
        return r12.f10569c.indexOf(r11);
    L12:
        return -1;
    L10:
        return -1;
    }

    public void d(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        int r11 = BaseLynxViewPager.f6568h;
        if (Intrinsics.areEqual(r10, "tabbarcellappear") == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        BaseLynxViewPager r13 = (BaseLynxViewPager) this.f23310b;
        r r14 = r13.getLynxContext().g;
        com.lynx.animax.i r15 = new com.lynx.animax.i(r13.getSign(), r10);
        r15.a("position", Integer.valueOf(r5));
        r14.b(r15);
        return;
    L9:
        return;
    L5:
        r12 = Intrinsics.areEqual(r10, "tabbarcelldisappear");
        goto L6
    }

    @Override // s8.f
    public void e(ConcurrentHashMap r5) {
        if (r5 == null) goto L38;
        JSONArray r10 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator r11 = r5.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r11.hasNext() == false) goto L18;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L8
    L11:
        if (g((IWsApp) r12.getValue()) == false) goto L8;
        r10.put(((SsWsApp) ((IWsApp) r12.getValue())).c());     // Catch: Throwable -> L14 Exception -> L16
    L18:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L14
        Logger.d("WsChannelSaver", "save to sp : " + r10.toString());     // Catch: Exception -> L21
        g8.g.d((Context) this.f23310b).g(r10.toString());     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // m2.b
    public void f(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        ConcurrentHashMap r12 = (ConcurrentHashMap) this.f23310b;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12.get(r5);
        if (r13 != null) goto L5;
        r13 = new ConcurrentHashMap();
    L5:
        r13.put(r10, r11);
        r12.put(r5, r13);
    }

    @Override // pt.p
    public boolean test(Object r5) {
        return !((pt.e) this.f23310b).getAsBoolean();
    }

    public String toString() {
        switch(this.f23309a) {
            case 9: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return super.toString() + "{fragment=" + ((RequestManagerFragment) this.f23310b) + "}";
    }

    public o(int r5) {
        this.f23309a = r5;
        switch(r5) {
            case 10: goto L8;
            case 11: goto L4;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        this.f23310b = new HashMap();
        return;
    L8:
        this.f23310b = new ConcurrentHashMap();
        return;
    }

    @Override // s8.f
    public Map a() {
        LinkedHashMap r5 = new LinkedHashMap();
        String r10 = g8.g.d((Context) this.f23310b).e();     // Catch: Exception -> L15
        Logger.d("WsChannelSaver", "load from sp : " + r10);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r10) == true) goto L19;
        JSONArray r11 = new JSONArray(r10);     // Catch: Exception -> L15
        int r12 = r11.length();     // Catch: Exception -> L15
        if (r12 <= 0) goto L19;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L19;
        SsWsApp r14 = h.c(r11.optJSONObject(r13));     // Catch: Exception -> L15
        if (g(r14) == false) goto L17;
        int r15 = WsChannelService.f4020c;     // Catch: Exception -> L15
        r5.put(Integer.valueOf(r14.f4000b), r14);     // Catch: Exception -> L15
    L17:
        r13 = r13 + 1;
    L19:
        return r5;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    @Override // m2.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        ConcurrentHashMap r11 = (ConcurrentHashMap) ((ConcurrentHashMap) this.f23310b).get(r5);
        if (r11 == null) goto L6;
        String r12 = (String) r11.remove(r10);
        return;
    }
}
