package org.kamol.nefete.data.api;

import org.kamol.nefete.data.api.model.Gallery;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GalleryService {
  @GET("/gallery/{section}/{sort}/{page}") //
  Observable<Gallery> listGallery( //
                                   @Path("section") Section section, //
                                   @Path("sort") Sort sort, //
                                   @Path("page") int page);
}
