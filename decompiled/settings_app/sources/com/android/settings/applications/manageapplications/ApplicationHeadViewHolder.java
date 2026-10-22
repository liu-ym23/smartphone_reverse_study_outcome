package com.android.settings.applications.manageapplications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationHeadViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/android/settings/applications/manageapplications/ApplicationHeadViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "setText", "", "text", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ApplicationHeadViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    private final View itemView;

    /* JADX INFO: compiled from: ApplicationHeadViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/applications/manageapplications/ApplicationHeadViewHolder$Companion;", "", "()V", "create", "Lcom/android/settings/applications/manageapplications/ApplicationHeadViewHolder;", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ApplicationHeadViewHolder create(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            View r2 = LayoutInflater.from(r3).inflate(R.layout.settings_permission_head, null, false);
            Intrinsics.checkNotNull(r2);
            return new ApplicationHeadViewHolder(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ApplicationHeadViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.itemView = r2;
    }

    public final View getItemView() {
        return this.itemView;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        ((OSectionSupportiveText) this.itemView.findViewById(R.id.tv_permission_desc)).setSectionDes(r2);
    }
}
