package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {
    private final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(@NonNull Context r2) {
        this(r2, null);
    }

    public AppCompatToggleButton(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatTextHelper r4 = new AppCompatTextHelper(this);
        this.mTextHelper = r4;
        r4.loadFromAttributes(r2, r3);
    }
}
