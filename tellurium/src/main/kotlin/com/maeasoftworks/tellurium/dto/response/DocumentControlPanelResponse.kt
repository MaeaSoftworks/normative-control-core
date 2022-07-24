package com.maeasoftworks.tellurium.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.maeasoftworks.tellurium.dao.Mistake
import com.maeasoftworks.tellurium.dto.documentation.annotations.Documented
import com.maeasoftworks.tellurium.dto.documentation.annotations.DocumentedProperty
import java.time.LocalDateTime

@Documented("docs.entity.DocumentControlPanelResponse.info")
data class DocumentControlPanelResponse(
    @DocumentedProperty("docs.entity.common.id")
    @get:JsonProperty(value = "document-id")
    val documentId: String,
    @DocumentedProperty("docs.entity.common.key")
    @get:JsonProperty(value = "access-key")
    val accessKey: String,
    @DocumentedProperty("docs.entity.DocumentControlPanelResponse.password")
    val password: String,
    @DocumentedProperty("docs.entity.MistakesResponse.prop0")
    val mistakes: List<Mistake>,
    @DocumentedProperty("docs.entity.common.time")
    val timestamp: LocalDateTime = LocalDateTime.now()
)