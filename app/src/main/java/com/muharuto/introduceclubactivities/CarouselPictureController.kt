package com.muharuto.introduceclubactivities

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.muharuto.introduceclubactivities.data.ClubSummary
import withModelsFrom

class CarouselPictureController internal constructor() : TypedEpoxyController<List<ClubSummary>>() {
    override fun buildModels(data: List<ClubSummary>?) {
        data ?: return

        carousel {
            id("carousel")
            numViewsToShowOnScreen(1.05f)
            padding(Carousel.Padding.dp(12, 0))
            withModelsFrom(data) {
                EpoxyLayoutCarouselImageBindingModel_().id(it.id).clubSummaryModel(it)
            }
        }
    }
}
