package gangnam.sft.corruptedargument.domain.argument

import gangnam.sft.corruptedargument.util.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "arguments")
class Argument(
    var title: String,
    var content: String,
): BaseEntity()