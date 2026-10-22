package obric.widget.support;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public interface IMenuItem {
    String getTitle();

    boolean hasMenuIcon();

    boolean isSelected();

    void setMenuIcon(ImageView targetImageView);
}
