package com.obric.security.cleaner.bigfile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bytedanceos.security.BaseActivity;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BigImageActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigImageActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "targetImageView", "Landroid/widget/ImageView;", "titleBar", "Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "loadImageWithGlide", "", "imageUrl", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BigImageActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private ImageView targetImageView;
    private OCTitleBar titleBar;

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

    public BigImageActivity() {
    }

    public static final /* synthetic */ void access$loadImageWithGlide(BigImageActivity r0, String r1) {
        r0.loadImageWithGlide(r1);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_big_image);
        this.titleBar = (OCTitleBar) findViewById(R.id.title_bar);
        final String r4 = getIntent().getStringExtra("imageUrl");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Intrinsics.checkNotNullExpressionValue(r4, "intent.getStringExtra(\"imageUrl\") ?: \"\"");
        View r0 = findViewById(R.id.big_image);
        if (r0 == null) goto L13;
        ImageView r1 = (ImageView) r0;
        this.targetImageView = r1;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("targetImageView");
    L10:
        r1.post(new AnonymousClass1(this, r4));
        OCTitleBar r2 = this.titleBar;
        Intrinsics.checkNotNull(r2);
        ViewCompat.setOnApplyWindowInsetsListener(r2, AnonymousClass2.INSTANCE);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    private final void loadImageWithGlide(String r5) {
        ImageView r0 = this.targetImageView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("targetImageView");
    L5:
        int r1 = r0.getWidth();
        ImageView r2 = this.targetImageView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("targetImageView");
    L8:
        int r3 = r2.getHeight();
        RequestBuilder r6 = Glide.with(this).load(r5).override(r1, r3).fitCenter();
        ImageView r4 = this.targetImageView;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("targetImageView");
    L11:
        r6.into(r4);
    }
}
