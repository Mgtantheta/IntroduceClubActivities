import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.muharuto.introduceclubactivities.R

@EpoxyModelClass(layout = R.layout.item_carouse_image)
abstract class CarouselImageModel : EpoxyModelWithHolder<CarouselImageModel.Holder>() {

    @EpoxyAttribute
    lateinit var imageData: ByteArray

    override fun bind(holder: Holder) {
        val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
        holder.imageView.setImageBitmap(bitmap)
    }

//    override fun getDefaultLayout(): Int = R.layout.item_carouse_image

    class Holder : EpoxyHolder() {
        lateinit var imageView: ImageView

        override fun bindView(itemView: View) {
            imageView = itemView.findViewById(R.id.image_view)
        }
    }
}
