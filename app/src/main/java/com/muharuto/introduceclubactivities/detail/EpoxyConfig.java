package com.muharuto.introduceclubactivities.detail;

import com.airbnb.epoxy.EpoxyDataBindingLayouts;
import com.airbnb.epoxy.EpoxyDataBindingPattern;
import com.muharuto.introduceclubactivities.R;

@EpoxyDataBindingPattern(rClass = R.class, layoutPrefix = "epoxy_layout")
@EpoxyDataBindingLayouts({
        R.layout.epoxy_layout_carousel_image
})
interface EpoxyConfig {
}
