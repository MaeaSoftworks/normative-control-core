package com.prmncr.normativecontrol.components;

import com.prmncr.normativecontrol.services.DocumentParser;
import lombok.AllArgsConstructor;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentParserBuilder {
    private CorrectDocumentParams params;
    private SectorKeywords keywords;

    public DocumentParser build(WordprocessingMLPackage docx) throws IllegalAccessException {
        return new DocumentParser(docx, params, keywords);
    }
}