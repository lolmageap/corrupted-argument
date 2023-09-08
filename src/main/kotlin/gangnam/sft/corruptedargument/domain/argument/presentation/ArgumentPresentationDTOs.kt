package gangnam.sft.corruptedargument.domain.argument.presentation

import gangnam.sft.corruptedargument.domain.argument.application.ArgumentServiceRequest
import gangnam.sft.corruptedargument.domain.argument.application.ArgumentServiceResponse

data class ArgumentRequest(val title: String, val content: String) {
    fun toServiceRequest() = ArgumentServiceRequest(this.title, this.content)
}

data class ArgumentResponse(val title: String, val content: String) {
    companion object {
        fun from(serviceResponse: ArgumentServiceResponse) =
            ArgumentResponse(serviceResponse.title, serviceResponse.content)
    }
}