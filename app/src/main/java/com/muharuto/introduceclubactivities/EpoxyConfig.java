package com.muharuto.introduceclubactivities;

import com.airbnb.epoxy.EpoxyDataBindingLayouts;
import com.airbnb.epoxy.EpoxyDataBindingPattern;

@EpoxyDataBindingPattern(rClass = R.class, layoutPrefix = "epoxy_layout")
@EpoxyDataBindingLayouts({
        R.layout.epoxy_layout_carousel_image
})
interface EpoxyConfig {
}
