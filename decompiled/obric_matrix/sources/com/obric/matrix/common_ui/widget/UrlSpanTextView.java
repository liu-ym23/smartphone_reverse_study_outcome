package com.obric.matrix.common_ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;
import com.bytedance.common.wschannel.WsConstants;
import d.g.c.a.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/common_ui/widget/UrlSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "linkColor", "Landroid/content/res/ColorStateList;", "linkText", "", "linkUnderLine", "", "mOnClickListener", "Lcom/obric/matrix/common_ui/widget/UrlSpanTextView$OnClickListener;", "setOnClickListener", "", "listener", "setUrlSpannedText", "spannedText", "", "setUrlText", "text", "wrapText", "charSequence", "OnClickListener", "UrlClickSpan", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UrlSpanTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AttributeSet f9005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f9006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f9007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f9009j;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/common_ui/widget/UrlSpanTextView$OnClickListener;", "", "onUrlClick", "", WsConstants.KEY_CONNECTION_URL, "", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(String r1);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/common_ui/widget/UrlSpanTextView$UrlClickSpan;", "Landroid/text/style/ClickableSpan;", WsConstants.KEY_CONNECTION_URL, "", "underlineText", "", "(Lcom/obric/matrix/common_ui/widget/UrlSpanTextView;Ljava/lang/String;Z)V", "getUrl$common_ui_cnRelease", "()Ljava/lang/String;", "setUrl$common_ui_cnRelease", "(Ljava/lang/String;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class b extends ClickableSpan {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f9010f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9011g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ UrlSpanTextView f9012h;

        public b(UrlSpanTextView r2, String r3, boolean r4) {
            o.f(r3, WsConstants.KEY_CONNECTION_URL);
            this.f9012h = r2;
            this.f9010f = r3;
            this.f9011g = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r2) {
            o.f(r2, "widget");
            a r3 = UrlSpanTextView.a(this.f9012h);
            if (r3 == null) goto L6;
            r3.a(this.f9010f);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            o.f(r2, "ds");
            r2.setUnderlineText(this.f9011g);
            r2.setColor(r2.linkColor);
        }
    }

    public UrlSpanTextView(Context r8, AttributeSet r9) {
        o.f(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public UrlSpanTextView(Context r3, AttributeSet r4, int r5) {
        o.f(r3, "context");
        new LinkedHashMap();
        super(r3, r4, r5);
        this.f9005f = r4;
        this.f9008i = true;
        CharSequence r0 = "";
        this.f9009j = "";
        TypedArray r6 = r3.obtainStyledAttributes(r4, e.f16753a);
        o.e(r6, "context.obtainStyledAttr…ommon_ui_UrlSpanTextView)");
        this.f9007h = r6.getColorStateList(e.f16754b);     // Catch: Throwable -> L13
        this.f9008i = r6.getBoolean(e.f16756d, true);     // Catch: Throwable -> L13
        CharSequence r7 = r6.getText(e.f16755c);     // Catch: Throwable -> L13
        if (r7 == null) goto L7;
        r0 = r7;
    L7:
        this.f9009j = r0;     // Catch: Throwable -> L13
        ColorStateList r8 = this.f9007h;     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        super.setLinkTextColor(r8);     // Catch: Throwable -> L13
    L10:
        setUrlText(this.f9009j);     // Catch: Throwable -> L13
        r6.recycle();
        return;
    L13:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    public /* synthetic */ UrlSpanTextView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ a a(UrlSpanTextView r0) {
        return r0.f9006g;
    }

    private final CharSequence b(CharSequence r12) {
        if ((r12 instanceof SpannedString) == false) goto L9;
        SpannableString r0 = SpannableString.valueOf(r12);
        SpannedString r13 = (SpannedString) r12;
        URLSpan[] r1 = (URLSpan[]) r13.getSpans(0, r0.length() - 1, URLSpan.class);
        o.e(r1, "urlSpans");
        int r3 = r1.length;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        URLSpan r6 = r1[r5];
        int r7 = r13.getSpanStart(r6);
        int r8 = r13.getSpanEnd(r6);
        r0.removeSpan(r6);
        String r9 = r6.getURL();
        o.e(r9, "urlSpan.url");
        b r10 = new b(this, r9, this.f9008i);
        StyleSpan r11 = new StyleSpan(1);
        r0.setSpan(r10, r7, r8, 33);
        r0.setSpan(r11, r7, r8, 33);
        r5 = r5 + 1;
        goto L5
    L7:
        super.setMovementMethod(LinkMovementMethod.getInstance());
        super.setHighlightColor(0);
        super.setAutoLinkMask(1);
        o.e(r0, "spanString");
        return r0;
    L9:
        return r12;
    }

    public final AttributeSet getAttrs() {
        return this.f9005f;
    }

    public final void setOnClickListener(a r2) {
        o.f(r2, "listener");
        this.f9006g = r2;
    }

    public final void setUrlSpannedText(String r8) {
        o.f(r8, "spannedText");
        Spanned r9 = HtmlCompat.fromHtml(k.w(r8, "\n", "<br/>", false, 4, null), 0);
        if ((r9 instanceof SpannableStringBuilder) == false) goto L5;
        SpannableStringBuilder r10 = (SpannableStringBuilder) r9;
    L6:
        SpannedString r11 = SpannedString.valueOf(r10);
        o.e(r11, "spannedString");
        this.f9009j = r11;
        super.setText(b(r11));
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void setUrlText(CharSequence r2) {
        o.f(r2, "text");
        this.f9009j = r2;
        super.setText(b(r2));
    }
}
