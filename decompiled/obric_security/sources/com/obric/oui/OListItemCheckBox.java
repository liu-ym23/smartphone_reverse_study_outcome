package com.obric.oui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.obric.oui.lisitem.OListItemCircleImg;
import com.obric.oui.oswitch.OSwitch;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListItemCheckBox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/OListItemCheckBox;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "inflateContent", "", "isChecked", "", "setChecked", "checked", "setOnCheckedChangeListener", "listener", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemCheckBox extends OListItemCircleImg {
    private HashMap _$_findViewCache;
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public /* synthetic */ OListItemCheckBox(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        AttributeSet r5 = (AttributeSet) null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener access$getMOnCheckedChangeListener$p(OListItemCheckBox r0) {
        return r0.mOnCheckedChangeListener;
    }

    public static final /* synthetic */ void access$setMOnCheckedChangeListener$p(OListItemCheckBox r0, CompoundButton.OnCheckedChangeListener r1) {
        r0.mOnCheckedChangeListener = r1;
    }

    public OListItemCheckBox(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        OSwitch r10 = new OSwitch(r8, null, 0, 6, null);
        r10.setClickable(true);
        r10.setOnCheckedChangeListener(new OListItemCheckBox$$special$$inlined$apply$lambda$1(this));
        Unit r11 = Unit.INSTANCE;
        this.mOSwitch = r10;
        setTrailingView(r10);
    }

    @Override // com.obric.oui.lisitem.OListItemCircleImg, com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_checkbox, this);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    public final void setChecked(boolean r1) {
        this.mOSwitch.setChecked(r1);
    }

    public final boolean isChecked() {
        return this.mOSwitch.isChecked();
    }
}
