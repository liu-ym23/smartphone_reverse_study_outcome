package com.tt.skin.sdk.api;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ISkinViewInterceptor {
    int getColorFromSkinResource(@ColorRes int r1);

    @Nullable
    ColorStateList getColorStateListFromSkinResource(@ColorRes int r1);

    @Nullable
    Drawable getDrawableFromSkinResource(@DrawableRes int r1);

    void ignoreActivity(@NotNull Activity r1);

    int refreshNewColor(@ColorRes int r1);

    @Nullable
    ColorStateList refreshNewColorStateList(int r1);

    void refreshView(@Nullable View r1);

    void refreshView(@Nullable View r1, boolean r2);

    void registerViewOnSkinChangeListener(@Nullable View r1, @NotNull Function1<? super Boolean, Unit> r2);

    void resetViewIgnore(@Nullable View r1);

    void setBackgroundColor(@Nullable View r1, @ColorRes int r2);

    void setColorFilter(@Nullable ImageView r1, @ColorRes int r2);

    void setHintTextColor(@Nullable TextView r1, @ColorRes int r2);

    void setHintTextColor(@Nullable TextView r1, @ColorRes int r2, boolean r3);

    void setTextColor(@Nullable TextView r1, @ColorRes int r2);

    void setTextColor(@Nullable TextView r1, @ColorRes int r2, boolean r3);

    void setViewIgnore(@Nullable View r1);
}
