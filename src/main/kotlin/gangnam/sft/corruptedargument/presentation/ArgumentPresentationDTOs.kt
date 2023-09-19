package gangnam.sft.corruptedargument.presentation

import gangnam.sft.corruptedargument.service.ArgumentRequest
import gangnam.sft.corruptedargument.service.ArgumentResponse

data class NewArgument(val title: String, val content: String) {
    fun toServiceRequest() = ArgumentRequest(this.title, this.content)
}

data class ArgumentInfo(val title: String, val content: String) {
    companion object {
        fun from(argumentResponse: ArgumentResponse) =
            ArgumentInfo(argumentResponse.title, argumentResponse.content)
    }
}