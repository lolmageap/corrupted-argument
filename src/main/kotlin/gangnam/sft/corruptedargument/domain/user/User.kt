package gangnam.sft.corruptedargument.domain.user

import gangnam.sft.corruptedargument.util.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    var name: String,
) : BaseEntity() {

}