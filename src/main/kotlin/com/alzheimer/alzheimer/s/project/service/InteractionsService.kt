import com.alzheimer.alzheimer.s.project.model.Interactions
import com.alzheimer.alzheimer.s.project.repository.InteractionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class InteractionsService {

    @Autowired
    private lateinit var interactionsRepository: InteractionsRepository


    fun saveInteraction(interactions: Interactions) {
        interactionsRepository.save(interactions)
    }

    fun getInteractionById(id: Long): Interactions? {
        return interactionsRepository.findById(id).orElse(null)
    }

}
