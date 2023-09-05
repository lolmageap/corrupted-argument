package gangnam.sft.corruptedargument

import gangnam.sft.corruptedargument.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

}