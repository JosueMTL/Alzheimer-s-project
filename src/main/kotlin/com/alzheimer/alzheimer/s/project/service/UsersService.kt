import com.alzheimer.alzheimer.s.project.model.Users
import com.alzheimer.alzheimer.s.project.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService {

    @Autowired
    private lateinit var usersRepository: UsersRepository

    fun saveUser(user: Users) {
        usersRepository.save(user)
    }

    fun getUserById(id: Long): Users? {
        return usersRepository.findById(id).orElse(null)
    }

    fun getAllUsers(): List<Users> {
        return usersRepository.findAll()
    }

    fun updateUser(user: Users) {
        // Implementa la lógica para actualizar el usuario
        usersRepository.save(user)
    }

    fun deleteUser(id: Long) {
        usersRepository.deleteById(id)
    }
}
