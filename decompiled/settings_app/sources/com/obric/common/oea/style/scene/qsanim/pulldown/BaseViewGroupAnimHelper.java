package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseViewGroupAnimHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ]\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a0\u001eH\u0004R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/BaseViewGroupAnimHelper;", "", "defInitScale", "", "defInitAlpha", "(FF)V", "childViews", "", "", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "getChildViews", "()Ljava/util/Map;", "getDefInitAlpha", "()F", "getDefInitScale", "needRecollect", "", "paramViews", "", "getParamViews", "()Ljava/util/List;", "useFlattenRecyclerView", "collectChildViews", "viewGroup", "Landroid/view/ViewGroup;", "collectChildViewsIfNeeded", "", "recollectChildViews", "traverseChildViews", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "childId", "Landroid/view/View;", "child", "animConfig", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class BaseViewGroupAnimHelper {
    public static final Companion Companion = null;
    private static final String TAG = "BaseViewGroupAnimHelper";
    private final Map<String, QSAnimConfig> childViews;
    private final float defInitAlpha;
    private final float defInitScale;
    private boolean needRecollect;
    private final List<QSAnimConfig> paramViews;
    private final boolean useFlattenRecyclerView;

    /* JADX INFO: compiled from: BaseViewGroupAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/BaseViewGroupAnimHelper$Companion;", "", "()V", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BaseViewGroupAnimHelper() {
        float r2 = 0.0f;
        this(r2, r2, 3, null);
    }

    public BaseViewGroupAnimHelper(float r1, float r2) {
        this.defInitScale = r1;
        this.defInitAlpha = r2;
        this.paramViews = new ArrayList();
        this.childViews = new LinkedHashMap();
        this.needRecollect = true;
        this.useFlattenRecyclerView = true;
    }

    protected final float getDefInitScale() {
        return this.defInitScale;
    }

    public /* synthetic */ BaseViewGroupAnimHelper(float r2, float r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 1.0f;
    L8:
        this(r2, r3);
    }

    protected final float getDefInitAlpha() {
        return this.defInitAlpha;
    }

    protected final List<QSAnimConfig> getParamViews() {
        return this.paramViews;
    }

    protected final Map<String, QSAnimConfig> getChildViews() {
        return this.childViews;
    }

    public final void recollectChildViews() {
        this.needRecollect = true;
        OEALogger.INSTANCE.d(TAG, "recollectChildViews");
    }

    protected final void traverseChildViews(ViewGroup r3, Function3<? super String, ? super View, ? super QSAnimConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Intrinsics.checkNotNullParameter(r4, "action");
        collectChildViewsIfNeeded(r3);
        Iterator<Map.Entry<String, QSAnimConfig>> r2 = this.childViews.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, QSAnimConfig> r5 = r2.next();
        r4.invoke(r5.getKey(), r5.getValue().getView(), r5.getValue());
        goto L4
    }

    private final void collectChildViewsIfNeeded(ViewGroup r4) {
        if (this.needRecollect == true) goto L10;
        return;
    L10:
        this.needRecollect = collectChildViews(r4);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        OEALogger.INSTANCE.e(TAG, "collectChildViews: ", e);
        this.needRecollect = true;
    }

    protected final boolean collectChildViews(ViewGroup r22) {
        Intrinsics.checkNotNullParameter(r22, "viewGroup");
        this.childViews.clear();
        Map<String, QSAnimConfig> r2 = this.childViews;
        if (this.paramViews.isEmpty() == false) goto L25;
        OEALogger.INSTANCE.d(TAG, "collectChildViews, paramViews is empty, use childViews");
        int r3 = r22.getChildCount();
        int r7 = 0;
    L5:
        if (r7 >= r3) goto L24;
        View r9 = r22.getChildAt(r7);
        if ((r9 instanceof RecyclerView) == true) goto L9;
    L22:
        ViewUtils r4 = ViewUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r9, "child");
        r2.put(r4.idExt(r9), new QSAnimConfig(r9, this.defInitScale, this.defInitAlpha, false, 8, null));
    L23:
        r7 = r7 + 1;
        goto L5
    L9:
        if (this.useFlattenRecyclerView == false) goto L22;
        RecyclerView.LayoutManager r8 = ((RecyclerView) r9).getLayoutManager();
        if (r8 == null) goto L13;
        int r10 = r8.getChildCount();
    L14:
        int r11 = 0;
    L15:
        if (r11 >= r10) goto L23;
        if (r8 == null) goto L18;
        View r13 = r8.getChildAt(r11);
    L19:
        if (r13 == null) goto L21;
        r2.put(ViewUtils.INSTANCE.idExt(r13), new QSAnimConfig(r13, this.defInitScale, this.defInitAlpha, false, 8, null));
    L21:
        r11 = r11 + 1;
        goto L15
    L18:
        r13 = null;
        goto L19
    L13:
        r10 = 0;
        goto L14
    L24:
        boolean r6 = false;
    L66:
        OEALogger.INSTANCE.d(TAG, "collectChildViews, views size: " + r2.size());
        return r6;
    L25:
        OEALogger.INSTANCE.d(TAG, "collectChildViews, use paramViews");
        Iterator<T> r5 = this.paramViews.iterator();
        boolean r12 = false;
    L27:
        if (r5.hasNext() == false) goto L65;
        QSAnimConfig r14 = (QSAnimConfig) r5.next();
        ViewParent r15 = r14.getView().getParent();
    L30:
        if (r15 == null) goto L35;
        if ((!Intrinsics.areEqual(r15, r22)) == false) goto L35;
        r15 = r15.getParent();
    L35:
        if ((r14.getView() instanceof RecyclerView) == false) goto L53;
        if (this.useFlattenRecyclerView == false) goto L53;
        RecyclerView.LayoutManager r16 = ((RecyclerView) r14.getView()).getLayoutManager();
        if (r16 == null) goto L41;
        int r17 = r16.getChildCount();
    L42:
        int r18 = 0;
    L43:
        if (r18 >= r17) goto L50;
        if (r16 == null) goto L46;
        View r19 = r16.getChildAt(r18);
    L47:
        if (r19 == null) goto L49;
        r2.put(ViewUtils.INSTANCE.idExt(r19), new QSAnimConfig(r19, r14.getInitScale(), r14.getInitAlpha(), false, 8, null));
    L49:
        r18 = r18 + 1;
        goto L43
    L46:
        r19 = null;
        goto L47
    L50:
        if (r17 != 0) goto L27;
        r12 = true;
        goto L27
    L41:
        r17 = 0;
    L53:
        if ((r14.getView() instanceof ViewGroup) == false) goto L64;
        if (r14.getFlatChildViews() == false) goto L64;
        int r20 = ((ViewGroup) r14.getView()).getChildCount();
        int r21 = 0;
    L57:
        if (r21 >= r20) goto L62;
        View r110 = ((ViewGroup) r14.getView()).getChildAt(r21);
        if (r110 == null) goto L61;
        r2.put(ViewUtils.INSTANCE.idExt(r110), new QSAnimConfig(r110, r14.getInitScale(), r14.getInitAlpha(), false, 8, null));
    L61:
        OEALogger.INSTANCE.d(TAG, "collectChildViews, flatChildViews, " + r21);
        r21 = r21 + 1;
        goto L57
    L62:
        if (r20 != 0) goto L27;
        r12 = true;
    L64:
        r2.put(ViewUtils.INSTANCE.idExt(r14.getView()), new QSAnimConfig(r14.getView(), r14.getInitScale(), r14.getInitAlpha(), false, 8, null));
        goto L27
    L65:
        r6 = r12;
        goto L66
    }
}
