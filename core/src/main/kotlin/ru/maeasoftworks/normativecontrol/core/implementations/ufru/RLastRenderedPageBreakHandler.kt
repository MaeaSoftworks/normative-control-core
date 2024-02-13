package ru.maeasoftworks.normativecontrol.core.implementations.ufru

import org.docx4j.wml.R
import ru.maeasoftworks.normativecontrol.core.abstractions.Config
import ru.maeasoftworks.normativecontrol.core.abstractions.Handler
import ru.maeasoftworks.normativecontrol.core.abstractions.Profile
import ru.maeasoftworks.normativecontrol.core.annotations.EagerInitialization
import ru.maeasoftworks.normativecontrol.core.model.VerificationContext

@EagerInitialization
object RLastRenderedPageBreakHandler : Handler<R.LastRenderedPageBreak, Nothing>(
    Config.create {
        setHandler { RLastRenderedPageBreakHandler }
        setTarget<R.LastRenderedPageBreak>()
        setProfile(Profile.UrFU)
    }
) {
    context(VerificationContext)
    override fun handle(element: Any) {
        if (getSharedStateAs<SharedState>().rSinceBr > 2)
            render.pageBreak(1)
    }
}