package gangnam.sft.corruptedargument.domain.user

import gangnam.sft.corruptedargument.util.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "users")
class User(
    var name: String,
    val email: String,
    var password: String,
    var birth: LocalDate?,
) : BaseEntity() {

    fun update(name: String, birth: LocalDate?){
        this.name = name
        this.birth = birth
    }

}