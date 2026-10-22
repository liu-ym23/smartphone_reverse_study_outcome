package obric.widget.support;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbsMenuItem implements IMenuItem {
    public String getSubtitle() {
        return null;
    }

    @Override // obric.widget.support.IMenuItem
    public abstract String getTitle();

    @Override // obric.widget.support.IMenuItem
    public boolean hasMenuIcon() {
        return true;
    }

    @Override // obric.widget.support.IMenuItem
    public boolean isSelected() {
        return false;
    }

    @Override // obric.widget.support.IMenuItem
    public void setMenuIcon(ImageView targetImageView) {
    }

    public AbsMenuItem() {
    }
}
