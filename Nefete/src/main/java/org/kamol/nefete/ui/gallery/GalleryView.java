package org.kamol.nefete.ui.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

import org.kamol.nefete.R;

import org.kamol.nefete.NefeteApp;
import org.kamol.nefete.data.GalleryDatabase;
import org.kamol.nefete.data.api.Section;
import org.kamol.nefete.data.api.model.Image;
import org.kamol.nefete.data.rx.EndlessObserver;
import org.kamol.nefete.ui.misc.BetterViewAnimator;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

public class GalleryView extends BetterViewAnimator {
  @InjectView(R.id.gallery_grid) AbsListView galleryView;

  @Inject Picasso picasso;

  @Inject GalleryDatabase galleryDatabase;

  private Section section = Section.HOT;

  private Subscription request;

  private final GalleryAdapter adapter;

  public GalleryView(Context context, AttributeSet attrs) {
    super(context, attrs);
    NefeteApp.get(context).inject(this);

    adapter = new GalleryAdapter(context, picasso);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.inject(this);

    galleryView.setAdapter(adapter);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    request = galleryDatabase.loadGallery(section, new EndlessObserver<List<Image>>() {
      @Override public void onNext(List<Image> images) {
        adapter.replaceWith(images);
        setDisplayedChildId(R.id.gallery_grid);
      }
    });
  }

  @Override protected void onDetachedFromWindow() {
    request.unsubscribe();
    super.onDetachedFromWindow();
  }
}
