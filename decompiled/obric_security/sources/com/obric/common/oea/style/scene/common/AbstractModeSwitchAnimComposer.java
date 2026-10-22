package com.obric.common.oea.style.scene.common;

import android.view.View;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AbstractModeSwitchAnimComposer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J+\u0010\u001b\u001a\u00020\r2#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\r0\u001dJ+\u0010!\u001a\u00020\r2#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\r0\u001dJ\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\rH\u0017Jq\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u001d26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0(H\u0002Jq\u0010)\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u001d26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer;", "", "animTimeout", "", "(J)V", "TAG", "", "animStartTime", "enterAnims", "", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "exitAnims", "clearAllAnims", "", "enterWithoutAnim", "exitWithoutAnim", "handleSingleEnterAnimEnd", "view", "Landroid/view/View;", "finished", "", "handleSingleExitAnimEnd", "isAnimRunning", "makeEnterAnims", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "makeExitAnims", "playEnterAnim", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "finishedSuccess", "playExitAnim", "prepareEnterAnim", "prepareExitAnim", "release", "startEnterAnim", "anims", "onSingleEnd", "Lkotlin/Function2;", "startExitAnim", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractModeSwitchAnimComposer {
    private final String TAG;
    private long animStartTime;
    private final long animTimeout;
    private final List<AnimationManager> enterAnims;
    private final List<AnimationManager> exitAnims;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer$playEnterAnim$2, reason: invalid class name */
    /* JADX INFO: compiled from: AbstractModeSwitchAnimComposer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<View, Boolean, Unit> {
        AnonymousClass2(AbstractModeSwitchAnimComposer r8) {
            super(2, r8, AbstractModeSwitchAnimComposer.class, "handleSingleEnterAnimEnd", "handleSingleEnterAnimEnd(Landroid/view/View;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View r1, Boolean r2) {
            invoke(r1, r2.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((AbstractModeSwitchAnimComposer) this.receiver).handleSingleEnterAnimEnd(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer$playExitAnim$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbstractModeSwitchAnimComposer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
    static final /* synthetic */ class C02172 extends FunctionReferenceImpl implements Function2<View, Boolean, Unit> {
        C02172(AbstractModeSwitchAnimComposer r8) {
            super(2, r8, AbstractModeSwitchAnimComposer.class, "handleSingleExitAnimEnd", "handleSingleExitAnimEnd(Landroid/view/View;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View r1, Boolean r2) {
            invoke(r1, r2.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((AbstractModeSwitchAnimComposer) this.receiver).handleSingleExitAnimEnd(r2, r3);
        }
    }

    public AbstractModeSwitchAnimComposer() {
        long r2 = 0;
        this(r2, 1, null);
    }

    public abstract void handleSingleEnterAnimEnd(View r1, boolean r2);

    public abstract void handleSingleExitAnimEnd(View r1, boolean r2);

    public abstract List<PropertyAnimatable.Builder> makeEnterAnims();

    public abstract List<PropertyAnimatable.Builder> makeExitAnims();

    public AbstractModeSwitchAnimComposer(long r1) {
        this.animTimeout = r1;
        this.TAG = "AbstractModeSwitchAnimComposer";
        this.enterAnims = new ArrayList();
        this.exitAnims = new ArrayList();
    }

    public static final /* synthetic */ long access$getAnimStartTime$p(AbstractModeSwitchAnimComposer r2) {
        return r2.animStartTime;
    }

    public static final /* synthetic */ List access$getEnterAnims$p(AbstractModeSwitchAnimComposer r0) {
        return r0.enterAnims;
    }

    public static final /* synthetic */ List access$getExitAnims$p(AbstractModeSwitchAnimComposer r0) {
        return r0.exitAnims;
    }

    public static final /* synthetic */ String access$getTAG$p(AbstractModeSwitchAnimComposer r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$setAnimStartTime$p(AbstractModeSwitchAnimComposer r0, long r1) {
        r0.animStartTime = r1;
    }

    public /* synthetic */ AbstractModeSwitchAnimComposer(long r1, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 1000;
    L5:
        this(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playEnterAnim$default(AbstractModeSwitchAnimComposer r0, AnonymousClass1 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        r0.playEnterAnim(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playEnterAnim");
    }

    public final void playEnterAnim(Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        if (prepareEnterAnim() == true) goto L5;
        return;
    L5:
        startEnterAnim(makeEnterAnims(), r4, new AnonymousClass2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playExitAnim$default(AbstractModeSwitchAnimComposer r0, C02161 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = C02161.INSTANCE;
    L6:
        r0.playExitAnim(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playExitAnim");
    }

    public final void playExitAnim(Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        if (prepareExitAnim() == true) goto L5;
        return;
    L5:
        startExitAnim(makeExitAnims(), r4, new C02172(this));
    }

    public void release() {
        this.animStartTime = 0;
    }

    public final boolean isAnimRunning() {
        if ((!this.enterAnims.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!this.exitAnims.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean prepareEnterAnim() {
        if ((!this.enterAnims.isEmpty()) == false) goto L14;
        OEALogger.INSTANCE.w(this.TAG, "prepareEnterAnim, anim is running");
        if (this.animStartTime > 0) goto L7;
    L12:
        return false;
    L7:
        if ((System.currentTimeMillis() - this.animStartTime) <= this.animTimeout) goto L12;
        OEALogger.INSTANCE.w(this.TAG, "prepareEnterAnim, anim is running, but timeout, cancel all");
        Iterator r8 = CollectionsKt.toMutableList(this.enterAnims).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        AnimationManager.cancelAnimation$default((AnimationManager) r8.next(), false, 1, null);
        goto L10
    L14:
        if ((!this.exitAnims.isEmpty()) == false) goto L19;
        OEALogger.INSTANCE.w(this.TAG, "prepareEnterAnim, exit anim is running, cancel all");
        Iterator r9 = CollectionsKt.toMutableList(this.exitAnims).iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        AnimationManager.cancelAnimation$default((AnimationManager) r9.next(), false, 1, null);
    L19:
        return true;
    }

    private final boolean prepareExitAnim() {
        if ((!this.exitAnims.isEmpty()) == false) goto L14;
        OEALogger.INSTANCE.w(this.TAG, "prepareExitAnim, anim is running");
        if (this.animStartTime > 0) goto L7;
    L12:
        return false;
    L7:
        if ((System.currentTimeMillis() - this.animStartTime) <= this.animTimeout) goto L12;
        OEALogger.INSTANCE.w(this.TAG, "prepareExitAnim, anim is running, but timeout");
        Iterator r8 = CollectionsKt.toMutableList(this.exitAnims).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        AnimationManager.cancelAnimation$default((AnimationManager) r8.next(), false, 1, null);
        goto L10
    L14:
        if ((!this.enterAnims.isEmpty()) == false) goto L19;
        OEALogger.INSTANCE.w(this.TAG, "prepareExitAnim, enter anim is running, cancel all");
        Iterator r9 = CollectionsKt.toMutableList(this.enterAnims).iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        AnimationManager.cancelAnimation$default((AnimationManager) r9.next(), false, 1, null);
    L19:
        return true;
    }

    private final void startEnterAnim(List<PropertyAnimatable.Builder> r16, final Function1<? super Boolean, Unit> r17, final Function2<? super View, ? super Boolean, Unit> r18) {
        final int r9 = r16.size();
        final Ref.IntRef r10 = new Ref.IntRef();
        r10.element = 0;
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.element = true;
        Iterator<T> r12 = r16.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        final PropertyAnimatable.Builder r13 = (PropertyAnimatable.Builder) r12.next();
        AnimationManager r0 = PropertyAnimatable.start$default(r13.onEnd(new AbstractModeSwitchAnimComposer$startEnterAnim$$inlined$forEach$lambda$1(r13, this, r11, r10, r18, r9, r17)).build(), null, null, 3, null);
        this.enterAnims.add(r0);
        goto L4
    L6:
        this.animStartTime = System.currentTimeMillis();
    }

    private final void startExitAnim(List<PropertyAnimatable.Builder> r16, final Function1<? super Boolean, Unit> r17, final Function2<? super View, ? super Boolean, Unit> r18) {
        final int r9 = r16.size();
        final Ref.IntRef r10 = new Ref.IntRef();
        r10.element = 0;
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.element = true;
        Iterator<T> r12 = r16.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        final PropertyAnimatable.Builder r13 = (PropertyAnimatable.Builder) r12.next();
        AnimationManager r0 = PropertyAnimatable.start$default(r13.onEnd(new AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1(r13, this, r11, r10, r18, r9, r17)).build(), null, null, 3, null);
        this.exitAnims.add(r0);
        goto L4
    L6:
        this.animStartTime = System.currentTimeMillis();
    }

    public void enterWithoutAnim() {
        clearAllAnims();
    }

    public void exitWithoutAnim() {
        clearAllAnims();
    }

    private final void clearAllAnims() {
        Iterator<T> r0 = this.enterAnims.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AnimationManager.cancelAnimation$default((AnimationManager) r0.next(), false, 1, null);
        goto L4
    L6:
        this.enterAnims.clear();
        Iterator<T> r1 = this.exitAnims.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        AnimationManager.cancelAnimation$default((AnimationManager) r1.next(), false, 1, null);
        goto L8
    L10:
        this.exitAnims.clear();
    }
}
