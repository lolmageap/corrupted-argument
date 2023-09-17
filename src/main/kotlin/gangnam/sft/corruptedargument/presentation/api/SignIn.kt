package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.service.UserServiceRequest

data class SignIn(val name: String) {

    fun toUserRequest() = UserServiceRequest(name = this.name)

}