package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.UserRepository
import gangnam.sft.corruptedargument.presentation.api.SignIn
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun signUp(userRequest: UserRequest): Unit {
        userRepository.save(userRequest.toUser())
    }

    fun signIn(signIn: SignIn): Unit {

    }

}