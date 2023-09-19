package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.UserRepository
import gangnam.sft.corruptedargument.presentation.SignIn
import gangnam.sft.corruptedargument.presentation.UserEdit
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun signUp(userRequest: UserRequest): Unit {
        userRepository.save(userRequest.toUser())
    }

    fun signIn(signIn: SignIn): Unit {

    }

    fun editUser(userId: Long, userEdit: UserEdit): Unit {
        userRepository.findByIdOrNull(userId)
            ?.update(name = userEdit.name, birth = userEdit.birth)
            ?: throw IllegalArgumentException()
    }

}