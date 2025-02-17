package normativecontrol.core.configurations

import normativecontrol.core.Runtime
import normativecontrol.core.chapters.Chapter
import normativecontrol.core.settings.RenderingSettings
import normativecontrol.core.settings.VerificationSettings
import normativecontrol.core.states.State

/**
 * Base class for document configurations. Also used for mapping handlers to groups.
 * For correct registration in [Runtime] should be annotated with [HandlerCollection].
 * @constructor creates a new configuration.
 * @param name name of configuration and handler group
 * @property startChapter First chapter of document
 * @property verificationSettings Settings for verification
 * @property renderingSettings Settings for rendering
 * @param S state type
 *
 * @sample normativecontrol.implementation.urfu.UrFUConfiguration
 */
abstract class AbstractConfiguration<out S : State>(
    name: String,
    val startChapter: Chapter,
    val verificationSettings: VerificationSettings,
    val renderingSettings: RenderingSettings
) : AbstractHandlerCollection(name) {

    abstract val state: S
}