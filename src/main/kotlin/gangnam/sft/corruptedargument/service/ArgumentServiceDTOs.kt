package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.argument.Argument

data class ArgumentRequest(
    val title: String,
    val content: String,
) {
    fun toArgument() = Argument(this.title, this.content)
}

data class ArgumentResponse(
    val title: String,
    val content: String,
) {
    companion object {
        fun from(entity: Argument) = ArgumentResponse(entity.title, entity.content)
    }
}