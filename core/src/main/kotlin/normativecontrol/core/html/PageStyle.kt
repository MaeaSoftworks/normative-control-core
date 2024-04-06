package normativecontrol.core.html

import normativecontrol.core.contexts.VerificationContext
import normativecontrol.core.css.Style
import normativecontrol.core.implementations.ufru.UrFUConfiguration.globalState
import org.docx4j.wml.SectPr

context(VerificationContext)
fun createPageStyle(sectPr: SectPr?): String {
    val styleId = "page${globalState.pageStyleId++}"

    val style = Style(noInline = true)
    style += {
        width set sectPr?.pgSz?.w?.toDouble()
        minHeight set sectPr?.pgSz?.h?.toDouble()

        paddingTop set sectPr?.pgMar?.top?.toDouble()
        paddingLeft set sectPr?.pgMar?.left?.toDouble()
        paddingBottom set sectPr?.pgMar?.bottom?.toDouble()
        paddingRight set sectPr?.pgMar?.right?.toDouble()
    }
    globalState.externalGlobalStylesheet.styles[".$styleId"] = style
    return styleId
}