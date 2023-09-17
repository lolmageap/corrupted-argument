package gangnam.sft.corruptedargument.domain.argument.presentation

import gangnam.sft.corruptedargument.service.ArgumentServiceRequest
import gangnam.sft.corruptedargument.service.ArgumentServiceResponse

data class ArgumentRequest(val title: String, val content: String) {
    fun toServiceRequest() = ArgumentServiceRequest(this.title, this.content)
}

data class ArgumentResponse(val title: String, val content: String) {
    companion object {
        fun from(serviceResponse: ArgumentServiceResponse) =
            ArgumentResponse(serviceResponse.title, serviceResponse.content)
    }
}