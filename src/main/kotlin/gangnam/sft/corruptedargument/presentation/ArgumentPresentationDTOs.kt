package gangnam.sft.corruptedargument.presentation

import gangnam.sft.corruptedargument.service.ArgumentRequest
import gangnam.sft.corruptedargument.service.ArgumentResponse

data class ArgumentRequest(val title: String, val content: String) {
    fun toServiceRequest() = ArgumentRequest(this.title, this.content)
}

data class ArgumentResponse(val title: String, val content: String) {
    companion object {
        fun from(serviceResponse: ArgumentResponse) =
            ArgumentResponse(serviceResponse.title, serviceResponse.content)
    }
}