package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun save(userRequest: UserRequest) : UserResponse =
        userRepository.save(userRequest.toUser()).let(UserResponse.Companion::toUserResponse)

}