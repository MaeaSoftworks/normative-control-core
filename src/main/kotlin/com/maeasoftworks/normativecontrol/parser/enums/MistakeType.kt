package com.maeasoftworks.normativecontrol.parser.enums

//@formatter:off
enum class MistakeType {
    // page size
    PAGE_WIDTH_IS_INCORRECT,
    PAGE_HEIGHT_IS_INCORRECT,

    // page margins
    PAGE_MARGIN_TOP_IS_INCORRECT,
    PAGE_MARGIN_LEFT_IS_INCORRECT,
    PAGE_MARGIN_BOTTOM_IS_INCORRECT,
    PAGE_MARGIN_RIGHT_IS_INCORRECT,

    // chapters
    CHAPTER_NO_ONE_CHAPTER_FOUND,
    CHAPTER_UNDEFINED_CHAPTER,
    CHAPTER_EMPTY,
    CHAPTER_BODY_DISORDER,

    // word errors
    WORD_GRAMMATICAL_ERROR,
    WORD_SPELL_ERROR,

//============================================================================================================//
//                      /*|*/         not found               /*|*/                mismatch                   //
//======================/*|*/=================================/*|*/===========================================//
/*|*/ /*front page*/   /*|*/ CHAPTER_FRONT_PAGE_NOT_FOUND,   /*|*/ CHAPTER_FRONT_PAGE_POSITION_MISMATCH,   /*|*/
/*|*/ /*annotation*/   /*|*/ CHAPTER_ANNOTATION_NOT_FOUND,   /*|*/ CHAPTER_ANNOTATION_POSITION_MISMATCH,   /*|*/
/*|*/ /*contents*/     /*|*/ CHAPTER_CONTENTS_NOT_FOUND,     /*|*/ CHAPTER_CONTENTS_POSITION_MISMATCH,     /*|*/
/*|*/ /*introduction*/ /*|*/ CHAPTER_INTRODUCTION_NOT_FOUND, /*|*/ CHAPTER_INTRODUCTION_POSITION_MISMATCH, /*|*/
/*|*/ /*body*/         /*|*/ CHAPTER_BODY_NOT_FOUND,         /*|*/ CHAPTER_BODY_POSITION_MISMATCH,         /*|*/
/*|*/ /*conclusion*/   /*|*/ CHAPTER_CONCLUSION_NOT_FOUND,   /*|*/ CHAPTER_CONCLUSION_POSITION_MISMATCH,   /*|*/
/*|*/ /*references*/   /*|*/ CHAPTER_REFERENCES_NOT_FOUND,   /*|*/ CHAPTER_REFERENCES_POSITION_MISMATCH,   /*|*/
/*|*/ /*appendix*/     /*|*/ CHAPTER_APPENDIX_NOT_FOUND,     /*|*/ CHAPTER_APPENDIX_POSITION_MISMATCH,     /*|*/
//============================================================================================================//

    TODO_ERROR,

//=======================================================================================================================================================================================================================================================//
//                          /*|*/             common                /*|*/          header                                        /*|*/           regular text            /*|*/              whitespace                                                   //
//==========================/*|*/===================================/*|*/========================================================/*|*/===================================/*|*/===========================================================================//
/*|*/ /*empty*/             /*|*/                                   /*|*/ TEXT_HEADER_EMPTY,                                     /*|*/                                   /*|*/                                                                        /*|*/
/*|*/ /*alignment*/         /*|*/                                   /*|*/ TEXT_HEADER_ALIGNMENT, TEXT_HEADER_BODY_ALIGNMENT,     /*|*/ TEXT_REGULAR_INCORRECT_ALIGNMENT, /*|*/ TEXT_WHITESPACE_ALIGNMENT, TEXT_WHITESPACE_AFTER_HEADER_ALIGNMENT,     /*|*/
/*|*/ /*uppercase*/         /*|*/                                   /*|*/ TEXT_HEADER_NOT_UPPERCASE, TEXT_HEADER_BODY_UPPERCASE, /*|*/ TEXT_REGULAR_UPPERCASE,           /*|*/ TEXT_WHITESPACE_UPPERCASE, TEXT_WHITESPACE_AFTER_HEADER_UPPERCASE,     /*|*/
/*|*/ /*bold*/              /*|*/                                   /*|*/ TEXT_HEADER_NOT_BOLD,                                  /*|*/ TEXT_REGULAR_WAS_BOLD,            /*|*/ TEXT_WHITESPACE_BOLD, TEXT_WHITESPACE_AFTER_HEADER_BOLD,               /*|*/
/*|*/ /*font*/              /*|*/ TEXT_COMMON_FONT,                 /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_FONT,                                                  /*|*/
/*|*/ /*color*/             /*|*/ TEXT_COMMON_TEXT_COLOR,           /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_TEXT_COLOR,                                            /*|*/
/*|*/ /*underline*/         /*|*/ TEXT_COMMON_UNDERLINED,           /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_UNDERLINED,                                            /*|*/
/*|*/ /*font size*/         /*|*/ TEXT_COMMON_INCORRECT_FONT_SIZE,  /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_INCORRECT_FONT_SIZE,                                   /*|*/
/*|*/ /*italic*/            /*|*/ TEXT_COMMON_ITALIC_TEXT,          /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_ITALIC,                                                /*|*/
/*|*/ /*strikethrough*/     /*|*/ TEXT_COMMON_STRIKETHROUGH,        /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_STRIKETHROUGH,                                         /*|*/
/*|*/ /*highlight*/         /*|*/ TEXT_COMMON_HIGHLIGHT,            /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_HIGHLIGHT,                                             /*|*/
/*|*/ /*border*/            /*|*/ TEXT_COMMON_BORDER,               /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_BORDER,                                                /*|*/
/*|*/ /*background fill*/   /*|*/ TEXT_COMMON_BACKGROUND_FILL,      /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_BACKGROUND_FILL,                                       /*|*/
/*|*/ /*line spacing*/      /*|*/                                   /*|*/ TEXT_HEADER_LINE_SPACING,                              /*|*/  TEXT_REGULAR_LINE_SPACING,       /*|*/ TEXT_WHITESPACE_LINE_SPACING,                                          /*|*/
/*|*/ /*first line indent*/ /*|*/ TEXT_COMMON_INDENT_FIRST_LINES,   /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_INDENT_FIRST_LINES,                                    /*|*/
/*|*/ /*line indent left*/  /*|*/ TEXT_COMMON_INDENT_LEFT,          /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_INDENT_LEFT,                                           /*|*/
/*|*/ /*line indent right*/ /*|*/ TEXT_COMMON_INDENT_RIGHT,         /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_INDENT_RIGHT,                                          /*|*/
/*|*/ /*run spacing*/       /*|*/ TEXT_COMMON_RUN_SPACING,          /*|*/                                                        /*|*/                                   /*|*/ TEXT_WHITESPACE_RUN_SPACING,                                           /*|*/
/*|*/ /*run spacing*/       /*|*/                                   /*|*/ TEXT_HEADER_REDUNDANT_DOT,                             /*|*/                                   /*|*/                                                                        /*|*/
//=======================================================================================================================================================================================================================================================//

    DOCUMENT_UNEXPECTED_CONTENT,
    PARAGRAPH_UNEXPECTED_CONTENT,
    RUN_UNEXPECTED_CONTENT,

    // body
    TEXT_BODY_SUBHEADER_NUMBER_ORDER_MISMATCH,
    TEXT_BODY_SUBHEADER_LEVEL_WAS_MORE_THAN_3,

    // header only settings
    TEXT_HEADER_EMPTY_LINE_AFTER_HEADER_REQUIRED,
    TEXT_HYPERLINKS_NOT_ALLOWED_HERE,

    // pictures
    PICTURE_IS_NOT_INLINED,
    PICTURE_REQUIRED_BLANK_LINE_BEFORE_PICTURE,
    PICTURE_REQUIRED_BLANK_LINE_AFTER_PICTURE_TITLE,
    PICTURE_TITLE_NUMBER_DISORDER,
    PICTURE_TITLE_WRONG_FORMAT,
    PICTURE_TITLE_REQUIRED_LINE_BREAK_BETWEEN_PICTURE_AND_TITLE,
    PICTURE_TITLE_NOT_CENTERED,
    PICTURE_TITLE_ENDS_WITH_DOT,

    // lists
    LIST_LEVEL_MORE_THAN_2,
    ORDERED_LIST_INCORRECT_MARKER_FORMAT_AT_LEVEL_1,
    ORDERED_LIST_INCORRECT_MARKER_FORMAT_AT_LEVEL_2,
    ORDERED_LIST_INCORRECT_MARKER_FORMAT,
}
//@formatter:on