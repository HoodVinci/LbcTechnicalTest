import com.hoodbrains.lbctest.domain.model.Item
import com.hoodbrains.lbctest.presentation.features.itemlist.PresentationItem

object TestBuilders {

    fun domainItem(id: Int = 0, title: String = "", imageUrl: String = ""): Item = Item(id, title, imageUrl)

    fun presentationItem(id: Int = 0, title: String = "", imageUrl: String = ""): PresentationItem = PresentationItem(id ,title, imageUrl)
}