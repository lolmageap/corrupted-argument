package gangnam.sft.corruptedargument.domain.user

import gangnam.sft.corruptedargument.util.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
    var name: String,
    val email: String,
    var password: String,
    var birth: LocalDateTime?,
) : BaseEntity()