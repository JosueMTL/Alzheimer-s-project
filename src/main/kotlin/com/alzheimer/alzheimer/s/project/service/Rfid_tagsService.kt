import com.alzheimer.alzheimer.s.project.model.Rfid_tags
import com.alzheimer.alzheimer.s.project.repository.Rfid_tagsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Rfid_tagsService {

    @Autowired
    private lateinit var rfind_tagsRepository: Rfid_tagsRepository

    fun saveRfind_tags(rfind_tags: Rfid_tags) {
        rfind_tagsRepository.save(rfind_tags)
    }

    fun getRfind_tagsById(id: Long): Rfid_tags? {
        return rfind_tagsRepository.findById(id).orElse(null)
    }

    fun getAllRfind_tags(): List<Rfid_tags> {
        return rfind_tagsRepository.findAll()
    }

    fun updateRfind_tags(rfind_tags: Rfid_tags) {
        // Implementa la lógica para actualizar los rfid_tags
        rfind_tagsRepository.save(rfind_tags)
    }

    fun deleteRfind_tags(id: Long) {
        // Implementa la lógica para eliminar los rfid_tags por ID
        rfind_tagsRepository.deleteById(id)
    }
}
