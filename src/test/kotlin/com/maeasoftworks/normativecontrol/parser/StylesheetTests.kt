package com.maeasoftworks.normativecontrol.parser

import com.maeasoftworks.normativecontrol.dtos.enums.ErrorType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert

@SpringBootTest
internal class StylesheetTests {
    @Autowired
    lateinit var base: TestBase
    private val directory: String = "stylesheet"

    @Test
    fun `incorrect page size validated properly`() {
        val parser = base.createParser(directory, "incorrectWidth.docx")
        parser.verifyPageSize()
        Assert.notEmpty(parser.errors, "Error not found!")
        Assert.state(
            parser.errors[0].errorType == ErrorType.PAGE_WIDTH_IS_INCORRECT && parser.errors[0].paragraphId == -1 && parser.errors[0].runId == -1
                    && parser.errors[1].errorType == ErrorType.PAGE_HEIGHT_IS_INCORRECT && parser.errors[1].paragraphId == -1 && parser.errors[1].runId == -1,
            "Wrong error!"
        )
    }

    @Test
    fun `incorrect page margin validated properly`() {
        val parser = base.createParser(directory, "incorrectMargin.docx")
        parser.verifyPageMargins()
        Assert.notEmpty(parser.errors, "Error not found!")
        Assert.state(
            parser.errors[0].errorType == ErrorType.PAGE_MARGIN_TOP_IS_INCORRECT && parser.errors[0].paragraphId == -1 && parser.errors[0].runId == -1
                    && parser.errors[1].errorType == ErrorType.PAGE_MARGIN_RIGHT_IS_INCORRECT && parser.errors[1].paragraphId == -1 && parser.errors[1].runId == -1
                    && parser.errors[2].errorType == ErrorType.PAGE_MARGIN_BOTTOM_IS_INCORRECT && parser.errors[2].paragraphId == -1 && parser.errors[2].runId == -1
                    && parser.errors[3].errorType == ErrorType.PAGE_MARGIN_LEFT_IS_INCORRECT && parser.errors[3].paragraphId == -1 && parser.errors[3].runId == -1,
            "Wrong error!"
        )
    }

    @Test
    fun `correct header style validated properly`() {
        val parser = base.createParser(directory, "overwrittenDefaultStyle.docx")
        parser.findHeaderAllErrors(0)
        Assert.isTrue(parser.errors.size == 0, "There shouldn't be any error!")
    }

    @Test
    fun `incorrect header style validated properly`() {
        val parser = base.createParser(directory, "veryWrongText.docx")
        parser.findGeneralAllErrors(0)
        Assert.isTrue(parser.errors.size > 0, "There should be errors!")
    }
}