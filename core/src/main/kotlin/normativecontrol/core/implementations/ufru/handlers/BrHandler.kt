package normativecontrol.core.implementations.ufru.handlers

import normativecontrol.core.abstractions.handlers.Handler
import normativecontrol.core.contexts.VerificationContext
import normativecontrol.core.implementations.ufru.UrFUConfiguration.globalState
import org.docx4j.wml.Br
import org.docx4j.wml.STBrType

object BrHandler : Handler<Br, Nothing, Nothing>() {
    context(VerificationContext)
    override fun handle(element: Any) {
        element as Br
        if (element.type == STBrType.PAGE) {
            globalState.rSinceBr = 0
            render.pageBreak(1)
        }
    }
}