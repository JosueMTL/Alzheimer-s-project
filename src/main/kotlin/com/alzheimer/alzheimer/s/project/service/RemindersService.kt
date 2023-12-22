import com.alzheimer.alzheimer.s.project.model.Reminders
import com.alzheimer.alzheimer.s.project.repository.RemindersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RemindersService {

    @Autowired
    private lateinit var remindersRepository: RemindersRepository


    fun saveReminder(reminder: Reminders) {
        remindersRepository.save(reminder)
    }

    fun getReminderById(id: Long): Reminders? {
        return remindersRepository.findById(id).orElse(null)
    }

    fun getAllReminders(): List<Reminders> {
        return remindersRepository.findAll()
    }

    fun updateReminder(reminder: Reminders) {
        // Implementa la lógica para actualizar el recordatorio
        remindersRepository.save(reminder)
    }

    fun deleteReminder(id: Long) {
        remindersRepository.deleteById(id)
    }
}
