package gangnam.sft.corruptedargument

import gangnam.sft.corruptedargument.domain.user.User
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    @Transactional
    fun createUser() = userRepository.save( User(name = "김찬우") )

}