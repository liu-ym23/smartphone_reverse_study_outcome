package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListItemCircleImgSwitch.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImgSwitch;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "isChecked", "", "setChecked", "", "checked", "setOnCheckedChangeListener", "listener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImgSwitch extends OListItemCircleImg {
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public static /* synthetic */ void $r8$lambda$0kDimHIDyDNfWOiA_NTMyBx1q7g(OListItemCircleImgSwitch r0, CompoundButton r1, boolean r2) {
        m380lambda1$lambda0(r0, r1, r2);
    }

    public /* synthetic */ OListItemCircleImgSwitch(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemCircleImgSwitch(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        OSwitch r10 = new OSwitch(r8, null, 0, 6, null);
        r10.setClickable(true);
        r10.setOnCheckedChangeListener(new OListItemCircleImgSwitch$$ExternalSyntheticLambda0(this));
        this.mOSwitch = r10;
        setTrailingView(r10);
    }

    /* JADX INFO: renamed from: lambda-1$lambda-0, reason: not valid java name */
    private static final void m380lambda1$lambda0(OListItemCircleImgSwitch r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.mOnCheckedChangeListener;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
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
