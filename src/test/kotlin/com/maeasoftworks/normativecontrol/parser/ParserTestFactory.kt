package com.maeasoftworks.normativecontrol.parser

import com.maeasoftworks.normativecontrol.entities.DocumentError
import com.maeasoftworks.normativecontrol.parser.enums.ErrorType
import org.docx4j.openpackaging.exceptions.Docx4JException
import java.io.FileInputStream
import java.io.IOException
import kotlin.reflect.KClass

open class ParserTestFactory(testClass: KClass<*>) {
    private val directory: String

    init {
        directory = testClass.simpleName!!.removeSuffix("Tests").lowercase()
    }

    protected fun errorAssert(found: MutableList<DocumentError>, vararg expected: ErrorType) {
        assert(found.size == expected.size) { "Expected: ${expected.size} errors\nFound: ${found.size}" }
        for (i in 0 until found.size) {
            assert(found[i].errorType == expected[i]) { "Expected: ${expected[i].name}\nFound: ${found[i].errorType.name}" }
        }
    }

    protected fun createParser(filename: String, useFullPath: Boolean = false): DocumentParser {
        try {
            val parser = DocumentParser(
                Document(
                    "test",
                    "test",
                    FileInputStream(if (useFullPath) "src/test/resources/$filename" else "src/test/resources/$directory/$filename").readAllBytes()
                )
            )
            parser.init()
            return parser
        } catch (e: IOException) {
            println(e.message)
            throw RuntimeException("Parser cannot be initialized!")
        } catch (e: Docx4JException) {
            println(e.message)
            throw RuntimeException("Parser cannot be initialized!")
        }
    }
}