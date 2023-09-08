package gangnam.sft.corruptedargument.domain.argument.application

import gangnam.sft.corruptedargument.domain.argument.Argument

data class ArgumentServiceRequest(
    val title: String,
    val content: String,
) {
    fun toEntity() = Argument(this.title, this.content)
}

data class ArgumentServiceResponse(
    val title: String,
    val content: String,
) {
    companion object {
        fun from(entity: Argument) = ArgumentServiceResponse(entity.title, entity.content)
    }
}