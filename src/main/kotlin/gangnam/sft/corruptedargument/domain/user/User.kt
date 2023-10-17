package gangnam.sft.corruptedargument.domain.user

import gangnam.sft.corruptedargument.util.BaseDeleteEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.SQLDelete
import java.time.LocalDate

@Entity
@SQLDelete(sql = "update user set deleted = true where id = ?")
@Table(name = "users")
class User(
    var name: String,
    val email: String,
    var password: String,
    var birth: LocalDate?,
) : BaseDeleteEntity() {

    var role: UserRole = UserRole.MEMBER
        get() = role

    fun update(name: String, birth: LocalDate?){
        this.name = name
        this.birth = birth
    }

}