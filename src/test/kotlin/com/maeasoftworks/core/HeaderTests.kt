package com.maeasoftworks.core

import com.maeasoftworks.core.enums.ChapterType
import com.maeasoftworks.core.enums.MistakeType.*
import com.maeasoftworks.core.model.Chapter
import com.maeasoftworks.core.parsers.BodyParser
import com.maeasoftworks.core.parsers.SimpleParser
import org.docx4j.wml.P
import org.junit.jupiter.api.Test

class HeaderTests : ParserTestFactory(HeaderTests::class) {
    @Test
    fun `header with correct style validated properly`() {
        val parserBase = createParser("correct header style.docx")
        parserBase.parsers += SimpleParser(Chapter(0, parserBase.doc.content), parserBase)
        parserBase.parsers[0].parse()
        errorAssert(parserBase.mistakes, WORD_SPELL_ERROR)
    }

    @Test
    fun `header with incorrect style validated properly`() {
        val parserBase = createParser("wrong header style.docx")
        parserBase.parsers += SimpleParser(Chapter(0, parserBase.doc.content), parserBase)
        parserBase.parsers[0].parse()
        errorAssert(
            parserBase.mistakes,
            TEXT_HEADER_NOT_BOLD,
            TEXT_HEADER_NOT_UPPERCASE,
            TEXT_COMMON_FONT,
            TEXT_COMMON_INCORRECT_FONT_SIZE,
            TEXT_COMMON_TEXT_COLOR,
            TEXT_HEADER_ALIGNMENT
        )
    }

    @Test
    fun `body header style validated properly`() {
        val parserBase = createParser("wrong body header style.docx")
        parserBase.parsers += BodyParser(
            Chapter(0, parserBase.doc.content.take(3).toMutableList()).also {
                it.header = parserBase.doc.content[0] as P
                it.type = ChapterType.BODY
            },
            parserBase
        )
        parserBase.parsers[0].parse()
        errorAssert(
            parserBase.mistakes
        )
    }

    @Test
    fun `body invalid header style validated properly`() {
        val parserBase = createParser("wrong body header style.docx")
        parserBase.parsers += BodyParser(
            Chapter(3, parserBase.doc.content.drop(3).toMutableList()).also {
                it.header = parserBase.doc.content[3] as P
                it.type = ChapterType.BODY
            },
            parserBase
        )
        parserBase.parsers[0].parse()
        errorAssert(
            parserBase.mistakes,
            TEXT_HEADER_BODY_ALIGNMENT,
            TEXT_HEADER_BODY_UPPERCASE
        )
    }
}