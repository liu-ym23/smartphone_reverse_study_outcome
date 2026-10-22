package androidx.slice.core;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public interface SliceAction {
    PendingIntent getAction();

    CharSequence getContentDescription();

    IconCompat getIcon();

    int getImageMode();

    int getPriority();

    CharSequence getTitle();

    boolean isActivity();

    boolean isChecked();

    boolean isDefaultToggle();

    boolean isToggle();

    SliceAction setChecked(boolean r1);

    SliceAction setContentDescription(CharSequence r1);

    SliceAction setPriority(int r1);
}
