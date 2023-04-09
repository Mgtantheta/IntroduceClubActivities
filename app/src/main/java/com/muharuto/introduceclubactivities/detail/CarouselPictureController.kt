package com.muharuto.introduceclubactivities.detail

import carousel
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.muharuto.introduceclubactivities.EpoxyLayoutCarouselImageBindingModel_
import com.muharuto.introduceclubactivities.data.HomeClubSummary
import withModelsFrom

class CarouselPictureController internal constructor() : TypedEpoxyController<List<HomeClubSummary>>() {
    override fun buildModels(data: List<HomeClubSummary>?) {
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
