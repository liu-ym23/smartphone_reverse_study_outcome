package tr;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.obric.common.oui.R$drawable;
import com.obric.oui.indexscrollbar.AlphabetView;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f22171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22172c;
    public final int d;
    public final /* synthetic */ OIndexScrollbar e;

    public h(OIndexScrollbar r5, Context r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        this.e = r5;
        this.f22170a = r10;
        String r11 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r11, "language");
        float r12 = 9.0f;
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r11) == false) goto L6;
    L11:
        this.f22172c = r12;
        int r13 = ((int) Math.ceil(r12)) - 1;
        GridView r14 = r5.e;
        Intrinsics.checkNotNull(r14);
        this.d = r14.getVerticalSpacing() * r13;
        return;
    L6:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r11) == false) goto L9;
    L7:
        r12 = 12.5f;
        goto L11
    L9:
        if (Intrinsics.areEqual("ru", r11) == false) goto L11;
        goto L11
    }

    public final String a(int r5) {
        String[] r10 = this.f22171b;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        r10 = null;
    L6:
        return r10[r5];
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.f22171b != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
    L5:
        String[] r5 = this.f22171b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        r5 = null;
    L9:
        return r5.length;
    }

    @Override // android.widget.Adapter
    public final /* bridge */ /* synthetic */ Object getItem(int r5) {
        return a(r5);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r5) {
        return r5;
    }

    @Override // android.widget.Adapter
    public final View getView(int r10, View r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        String[] r13 = this.f22171b;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        r13 = null;
    L5:
        String r14 = r13[r10];
        float r5 = this.e.f13409m - this.d;
        float r15 = this.f22172c;
        int r16 = (int) (r5 / r15);
        int r17 = (int) (r5 - (r16 * r15));
        if (r15 == 9.0f) goto L8;
    L16:
        Context r18 = this.f22170a;
        View r19 = r11;
        if (r11 != null) goto L32;
        Intrinsics.checkNotNullParameter(r14, "alphabet");
        if (Intrinsics.areEqual(".>", r14) == false) goto L21;
        ImageView r20 = new ImageView(r18);
        r20.setImageResource(R$drawable.letter_bar_unfold_button);
        r20.setScaleType(ImageView.ScaleType.CENTER);
        r20.setMinimumHeight(r16);
        r19 = r20;
        goto L32
    L21:
        AlphabetView r21 = new AlphabetView(r18, null, 6, 0);
        r21.setHeight(r16);
        if (StringsKt.P(r14, XPath.WILDCARD) == false) goto L24;
        r21.setTextColor(Color.parseColor("#80000000"));
        r14 = r14.substring(1);
    L24:
        Intrinsics.checkNotNullParameter(r14, "alphabet");
        if (Intrinsics.areEqual(".~", r14) == true) goto L27;
        r21.setText(r14);
    L27:
        Intrinsics.checkNotNullParameter(r14, "alphabet");
        String[] r22 = (String[]) Arrays.copyOfRange(a.d, 0, 32);
        if (Arrays.asList(Arrays.copyOf(r22, r22.length)).contains(r14) == false) goto L30;
        r21.setTypeface(null, 0);
    L30:
        r19 = r21;
    L32:
        if (((r10 / 3) % 2) != 0) goto L34;
        Intrinsics.checkNotNull(r18);
        Drawable r23 = r18.getResources().getDrawable(R$drawable.quickbar_ex_alphabet_text_light_colorlist);
    L35:
        r19.setBackground(r23);
        return r19;
    L34:
        Intrinsics.checkNotNull(r18);
        r23 = r18.getResources().getDrawable(R$drawable.quickbar_ex_alphabet_text_dark_colorlist);
        goto L35
    L8:
        if (((int) (r5 % r15)) == 0) goto L16;
        if (r10 != (getCount() - 1)) goto L12;
    L15:
        r16 = r16 + r17;
        goto L16
    L12:
        if (r10 == (getCount() - 2)) goto L15;
        if (r10 != (getCount() - 3)) goto L16;
        goto L15
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int r5) {
        String[] r10 = this.f22171b;
        String[] r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        r10 = null;
    L5:
        String r12 = r10[r5];
        Intrinsics.checkNotNullParameter(r12, "alphabet");
        if (Intrinsics.areEqual(".~", r12) == true) goto L17;
        String[] r13 = this.f22171b;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
    L11:
        String r14 = r11[r5];
        if (r14 != null) goto L14;
    L16:
        return true;
    L14:
        if (StringsKt.P(r14, XPath.WILDCARD) == false) goto L16;
    L10:
        r11 = r13;
    L17:
        return false;
    }
}
