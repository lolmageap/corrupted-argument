package gangnam.sft.corruptedargument.domain.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun save(userRequest: UserRequest) {
        userRepository.save( userRequest.toUser() )
    }

}