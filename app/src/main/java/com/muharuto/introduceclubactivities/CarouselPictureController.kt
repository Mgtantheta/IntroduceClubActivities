package com.muharuto.introduceclubactivities

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.muharuto.introduceclubactivities.data.ClubSummary

class CarouselPictureController internal constructor() : TypedEpoxyController<List<ClubSummary>>() {
    override fun buildModels(data: List<ClubSummary>?) {
        data ?: return

        val epoxyLayoutCarouselImages: MutableList<EpoxyLayoutCarouselImageBindingModel_> =
            mutableListOf()
        data.forEach { clubSummary ->
            epoxyLayoutCarouselImages.add(
                EpoxyLayoutCarouselImageBindingModel_()
                    .id(clubSummary.id)
                    .clubSummaryModel(clubSummary)
                //Fixme: 後で消す
//                    .addTo(this@CarouselPictureController)
            )
        }

        carousel {
            id("carousel")
            numViewsToShowOnScreen(1.05f)
            padding(Carousel.Padding.dp(12, 0))
            models(epoxyLayoutCarouselImages)
        }
    }
}
