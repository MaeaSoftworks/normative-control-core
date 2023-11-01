package ru.maeasoftworks.normativecontrol.core.rendering.model.css.properties

import ru.maeasoftworks.normativecontrol.core.rendering.utils.PIXELS_IN_POINT

class Width(value: Double?) : DoubleProperty("width", value, PIXELS_IN_POINT, "px")
class MinWidth(value: Double?) : DoubleProperty("min-width", value, PIXELS_IN_POINT, "px")

class Height(value: Double?) : DoubleProperty("height", value, PIXELS_IN_POINT, "px")
class MinHeight(value: Double?) : DoubleProperty("min-height", value, PIXELS_IN_POINT, "px")