package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] mStateSets;

        StateListState(StateListState r1, StateListDrawableCompat r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mStateSets = r1.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }

        int addStateSet(int[] r1, Drawable r2) {
            int r3 = addChild(r2);
            this.mStateSets[r3] = r1;
            return r3;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void growArray(int r3, int r4) {
            super.growArray(r3, r4);
            int[][] r5 = new int[r4][];
            System.arraycopy(this.mStateSets, 0, r5, 0, r3);
            this.mStateSets = r5;
        }

        int indexOfStateSet(int[] r4) {
            int[][] r0 = this.mStateSets;
            int r3 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r3) goto L8;
            if (StateSet.stateSetMatches(r0[r1], r4) == true) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return r1;
        L8:
            return -1;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            int[][] r0 = this.mStateSets;
            int[][] r1 = new int[r0.length][];
            int r2 = r0.length - 1;
        L3:
            if (r2 < 0) goto L9;
            int[][] r3 = this.mStateSets;
            if (r3[r2] == null) goto L7;
            int[] r4 = (int[]) r3[r2].clone();
        L8:
            r1[r2] = r4;
            r2 = r2 - 1;
            goto L3
        L7:
            r4 = null;
            goto L8
        L9:
            this.mStateSets = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r2) {
            return new StateListDrawableCompat(this, r2);
        }
    }

    public StateListDrawableCompat() {
        this(null, null);
    }

    StateListDrawableCompat(@Nullable StateListState r1) {
        if (r1 == null) goto L6;
        setConstantState(r1);
        return;
    }

    StateListDrawableCompat(StateListState r2, Resources r3) {
        setConstantState(new StateListState(r2, this, r3));
        onStateChange(getState());
    }

    private void inflateChildElements(Context r9, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        StateListState r0 = this.mStateListState;
        int r1 = r11.getDepth() + 1;
    L3:
        int r3 = r11.next();
        if (r3 == 1) goto L32;
        int r4 = r11.getDepth();
        if (r4 >= r1) goto L10;
        if (r3 != 3) goto L10;
        return;
    L10:
        if (r3 != 2) goto L3;
        if (r4 > r1) goto L3;
        if (r11.getName().equals("item") == false) goto L3;
        TypedArray r5 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.StateListDrawableItem);
        Drawable r6 = null;
        int r7 = r5.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (r7 <= 0) goto L19;
        r6 = ResourceManagerInternal.get().getDrawable(r9, r7);
    L19:
        r5.recycle();
        int[] r8 = extractStateSet(r12);
        if (r6 != null) goto L31;
    L21:
        int r14 = r11.next();
        if (r14 == 4) goto L21;
        if (r14 != 2) goto L30;
        if (Build.VERSION.SDK_INT < 21) goto L28;
        r6 = Compatibility.Api21Impl.createFromXmlInner(r10, r11, r12, r13);
        goto L31
    L28:
        r6 = Drawable.createFromXmlInner(r10, r11, r12);
        goto L31
    L30:
        throw new XmlPullParserException(r11.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L31:
        r0.addStateSet(r8, r6);
        goto L3
    }

    private void updateStateFromTypedArray(TypedArray r3) {
        StateListState r2 = this.mStateListState;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r2.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r3);
    L5:
        r2.mVariablePadding = r3.getBoolean(R.styleable.StateListDrawable_android_variablePadding, r2.mVariablePadding);
        r2.mConstantSize = r3.getBoolean(R.styleable.StateListDrawable_android_constantSize, r2.mConstantSize);
        r2.mEnterFadeDuration = r3.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, r2.mEnterFadeDuration);
        r2.mExitFadeDuration = r3.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, r2.mExitFadeDuration);
        r2.mDither = r3.getBoolean(R.styleable.StateListDrawable_android_dither, r2.mDither);
    }

    public void addState(int[] r2, Drawable r3) {
        if (r3 == null) goto L5;
        this.mStateListState.addStateSet(r2, r3);
        onStateChange(getState());
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme r1) {
        super.applyTheme(r1);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int[] extractStateSet(AttributeSet r8) {
        int r7 = r8.getAttributeCount();
        int[] r0 = new int[r7];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r7) goto L17;
        int r4 = r8.getAttributeNameResource(r2);
        if (r4 == 0) goto L15;
        if (r4 == 16842960) goto L15;
        if (r4 == 16843161) goto L15;
        int r5 = r3 + 1;
        if (r8.getAttributeBooleanValue(r2, false) == true) goto L14;
        r4 = -r4;
    L14:
        r0[r3] = r4;
        r3 = r5;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r0, r3);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    Drawable getStateDrawable(int r1) {
        return this.mStateListState.getChild(r1);
    }

    int getStateDrawableIndex(int[] r1) {
        return this.mStateListState.indexOfStateSet(r1);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int r1) {
        return this.mStateListState.mStateSets[r1];
    }

    public void inflate(@NonNull Context r4, @NonNull Resources r5, @NonNull XmlPullParser r6, @NonNull AttributeSet r7, @Nullable Resources.Theme r8) {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r5, r8, r7, R.styleable.StateListDrawable);
        setVisible(r0.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(r0);
        updateDensity(r5);
        r0.recycle();
        inflateChildElements(r4, r5, r6, r7, r8);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mStateListState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] r3) {
        boolean r0 = super.onStateChange(r3);
        int r4 = this.mStateListState.indexOfStateSet(r3);
        if (r4 >= 0) goto L6;
        r4 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r4) == true) goto L10;
        if (r0 == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState r2) {
        super.setConstantState(r2);
        if ((r2 instanceof StateListState) == false) goto L6;
        this.mStateListState = (StateListState) r2;
        return;
    }
}
